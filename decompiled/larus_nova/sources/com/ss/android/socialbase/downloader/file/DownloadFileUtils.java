package com.ss.android.socialbase.downloader.file;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import f06.b;
import f06.c;
import f06.d;
import g06.a;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class DownloadFileUtils {
    private static SparseArray<MediaItem> MEDIA_STORE_DATA = null;
    public static final String MODE_READ = "r";
    public static final String MODE_WRITE = "w";
    private static final String TAG = "DownloadFileUtils";
    private static volatile Boolean mEnableExternalDownload;

    public static class MediaItem {
        public String columnId;
        public Uri contentUri;
        public String contentUriString;

        public MediaItem() {
        }

        public static MediaItem build(Uri r100, String r101) {
            MediaItem r102 = new MediaItem();
            r102.contentUri = r100;
            r102.contentUriString = r100.toString();
            r102.columnId = r101;
            return r102;
        }
    }

    public DownloadFileUtils() {
    }

    static {
        MEDIA_STORE_DATA = new SparseArray();     // Catch: Throwable -> L9
        if (isAtLeastAndroidQ() == false) goto L7;
        MEDIA_STORE_DATA.put(2, MediaItem.build(MediaStore.Images.Media.getContentUri("external_primary"), DBDefinition.ID));     // Catch: Throwable -> L9
        MEDIA_STORE_DATA.put(3, MediaItem.build(MediaStore.Video.Media.getContentUri("external_primary"), DBDefinition.ID));     // Catch: Throwable -> L9
        MEDIA_STORE_DATA.put(4, MediaItem.build(MediaStore.Audio.Media.getContentUri("external_primary"), DBDefinition.ID));     // Catch: Throwable -> L9
        MEDIA_STORE_DATA.put(5, MediaItem.build(MediaStore.Downloads.EXTERNAL_CONTENT_URI, DBDefinition.ID));     // Catch: Throwable -> L9
    L13:
    L11:
        mEnableExternalDownload = null;
        return;
    L7:
        MEDIA_STORE_DATA.put(2, MediaItem.build(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, DBDefinition.ID));     // Catch: Throwable -> L9
        MEDIA_STORE_DATA.put(3, MediaItem.build(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, DBDefinition.ID));     // Catch: Throwable -> L9
        MEDIA_STORE_DATA.put(4, MediaItem.build(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, DBDefinition.ID));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Logger.globalError(TAG, "init", "Error:" + th);
        goto L11
    }

    public static boolean isAtLeastAndroidQ() {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isExternalDownloadEnabled() {
        if (mEnableExternalDownload != null) goto L12;
        if (Build.VERSION.SDK_INT > 29) goto L7;
    L9:
        boolean r100 = false;
    L10:
        mEnableExternalDownload = Boolean.valueOf(r100);
        goto L12
    L7:
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.ENABLE_EXTERNAL_DOWNLOAD) <= 0) goto L9;
        r100 = true;
    L12:
        return mEnableExternalDownload.booleanValue();
    }

    public static boolean isScopedStorage() {
        Context r100 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (r100 == null) goto L5;
        int r101 = r100.getApplicationInfo().targetSdkVersion;
        if (Logger.debug() == false) goto L12;
        Logger.globalDebug(TAG, "isScopedStorage", "SDK_INT:" + Build.VERSION.SDK_INT + " targetSdkVersion:" + r101);
    L12:
        if (Build.VERSION.SDK_INT >= 29) goto L18;
        if (Logger.debug() == false) goto L16;
        Logger.globalDebug(TAG, "isScopedStorage", "SDK_INT < Android Q");
    L16:
        return false;
    L18:
        if (r101 == 29) goto L20;
    L25:
        if (r101 <= 29) goto L31;
        if (Logger.debug() == false) goto L29;
        Logger.globalDebug(TAG, "isScopedStorage", "SDK_INT > Android Q");
    L29:
        return true;
    L31:
        if (Logger.debug() == false) goto L33;
        Logger.globalDebug(TAG, "isScopedStorage", "ScopedStorage = False");
    L33:
        return false;
    L20:
        if (DownloadDirUtils.isExternalStorageLegacy(false) == true) goto L25;
        if (Logger.debug() == false) goto L24;
        Logger.globalDebug(TAG, "isScopedStorage", "SDK_INT = Android Q and isExternalStorageLegacy");
    L24:
        return true;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.globalDebug(TAG, "isScopedStorage", "Context is null");
    L7:
        return false;
    }

    public static boolean checkUriInsert(String r100) {
        checkUri(UriProtector.parse(r100), getTypeByUri(r100));     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }

    public static void deleteUri(Uri r100) throws Throwable {
        com_ss_android_socialbase_downloader_file_DownloadFileUtils_android_content_ContentResolver_delete(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext().getContentResolver(), r100, null, null);
    }

    public static boolean emptyFile(FileOutputStream r100) {
        r100.write(new byte[0]);     // Catch: Throwable -> L6
        r100.close();     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        Logger.globalError(TAG, "emptyFile", "Error:" + th);
        return false;
    }

    public static boolean exists(Uri r100) {
        if (getLength(r100) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean existsAndNotEmpty(DownloadFile r100) {
        if (r100.exists() == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.length() <= 0) goto L7;
        return true;
    }

    public static String getContentUriString(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        if (r100.startsWith("content") == false) goto L18;
        int r101 = 0;
    L8:
        if (r101 >= MEDIA_STORE_DATA.size()) goto L19;
        int r102 = MEDIA_STORE_DATA.keyAt(r101);
        MediaItem r103 = MEDIA_STORE_DATA.get(r102);
        if (r100.startsWith(r103.contentUriString) == true) goto L12;
        r101 = r101 + 1;
        goto L8
    L12:
        return r103.contentUriString;
    L19:
        return null;
    L18:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String getFilePathFromUri(Uri r110) {
        String[] r100 = {"_data"};
        String r101 = null;
        Context r102 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();     // Catch: Throwable -> L17
        if (r102 != null) goto L7;
        DownloadUtils.safeClose(new Cursor[]{null});
        return null;
    L7:
        Cursor r111 = com_ss_android_socialbase_downloader_file_DownloadFileUtils_android_content_ContentResolver_query(r102.getContentResolver(), r110, r100, null, null, null);     // Catch: Throwable -> L17
        if (r111 != null) goto L22;
    L15:
        DownloadUtils.safeClose(new Cursor[]{r111});
        return r101;
    L22:
    L13:
        th = th;
        r101 = r111;
    L18:
        DownloadUtils.safeClose(new Cursor[]{r101});
        throw th;
    L10:
        if (r111.moveToFirst() == false) goto L15;
        r101 = r111.getString(r111.getColumnIndex(r100[0]));     // Catch: Throwable -> L13
    L17:
        th = th;
        goto L18
    }

    public static long getLength(Uri r100) {
        ParcelFileDescriptor r101 = null;
        r101 = getParcelFileDescriptor(r100, "r");     // Catch: Throwable -> L6
        long r102 = r101.getStatSize();     // Catch: Throwable -> L6
        DownloadUtils.safeClose(new Closeable[]{r101});
        return r102;
    L6:
        DownloadUtils.safeClose(new Closeable[]{r101});
        return -1;
    }

    public static Pair<String, String> getParentAndNameFromRelativePath(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        return new Pair(r101.getParent(), r101.getName());
    L6:
        return null;
    }

    public static Pair<String, String> getParentAndNameFromUri(Uri r100) {
        return getParentAndNameFromRelativePath(getFilePathFromUri(r100));
    }

    public static int getTypeByUri(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return -1;
    L6:
        if (r100.startsWith("content") == false) goto L15;
        int r101 = 0;
    L9:
        if (r101 >= MEDIA_STORE_DATA.size()) goto L14;
        int r102 = MEDIA_STORE_DATA.keyAt(r101);
        if (r100.startsWith(MEDIA_STORE_DATA.get(r102).contentUriString) == true) goto L12;
        r101 = r101 + 1;
        goto L9
    L12:
        return r102;
    L14:
        return -1;
    L15:
        return 1;
    }

    public static Uri getUriFromFilePath(String r110) {
        Uri r100 = DownloadDirUtils.getRootContentUri();
        Cursor r101 = null;
    L19:
        th = th;
    L20:
        DownloadUtils.safeClose(new Cursor[]{r101});
        throw th;
    L5:
        if (Build.VERSION.SDK_INT < 29) goto L8;
        Cursor r111 = com_ss_android_socialbase_downloader_file_DownloadFileUtils_android_content_ContentResolver_query(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext().getContentResolver(), MediaStore.setIncludePending(r100), new String[]{DBDefinition.ID}, "_data=? ", new String[]{r110}, null);     // Catch: Throwable -> L19
    L9:
        if (r111 != null) goto L22;
    L17:
        DownloadUtils.safeClose(new Cursor[]{r111});
        return null;
    L22:
    L15:
        th = move-exception;
        r101 = r111;
        th = th;
        goto L20
    L11:
        if (r111.moveToFirst() == false) goto L17;
        Uri r102 = ContentUris.withAppendedId(r100, r111.getInt(r111.getColumnIndex(DBDefinition.ID)));     // Catch: Throwable -> L15
        DownloadUtils.safeClose(new Cursor[]{r111});
        return r102;
    L8:
        r111 = null;
        goto L9
    }

    public static boolean isFilePathInExternalPublicDir(String r100) {
        if (isMediaUri(r100) == false) goto L5;
        return true;
    L5:
        File r101 = DownloadDirUtils.getExternalStorageDirectory(false);
        if (r101 != null) goto L8;
    L31:
        return false;
    L8:
        if (r100.startsWith(r101.getPath()) == false) goto L31;
        Context r102 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (r102 != null) goto L13;
        Logger.globalError(TAG, "isFilePathInExternalPublicDir", "Context is null");
        return false;
    L13:
        File r103 = DownloadDirUtils.getExternalCacheDir(r102, false);
        if (r103 != null) goto L17;
        Logger.globalError(TAG, "isFilePathInExternalPublicDir", "ExternalCacheDir is null");
        return false;
    L17:
        String r104 = r103.getParent();
        if (r104 != null) goto L20;
    L22:
        File r105 = DownloadDirUtils.getObbDirStr(r102, false);
        if (r105 == null) goto L28;
        if (r100.startsWith(r105.getAbsolutePath()) == false) goto L28;
        return false;
    L28:
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.UNCHECK_EXTERNAL_PUBLIC_DIR, 0) <= 0) goto L30;
        return false;
    L30:
        return true;
    L20:
        if (r100.startsWith(r104) == false) goto L22;
        return false;
    }

    public static boolean isMediaUri(String r100) {
        if (getTypeByUri(r100) > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void setEnableExternalDownload(boolean r100) {
        mEnableExternalDownload = Boolean.valueOf(r100);
    }

    public static void checkUri(Uri r100, int r101) throws Throwable {
        MediaItem r102 = MEDIA_STORE_DATA.get(r101);
        if (r102 == null) goto L20;
        String r103 = r102.columnId + " = ?";
        String[] r104 = {r100.getLastPathSegment()};
        Cursor r105 = null;
        Uri r106 = r102.contentUri;     // Catch: Throwable -> L16
        if (Build.VERSION.SDK_INT < 29) goto L8;
        r106 = MediaStore.setIncludePending(r106);     // Catch: Throwable -> L16
    L8:
        r105 = com_ss_android_socialbase_downloader_file_DownloadFileUtils_android_content_ContentResolver_query(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext().getContentResolver(), r106, null, r103, r104, null);     // Catch: Throwable -> L16
        if (r105 == null) goto L15;
        if (r105.moveToFirst() == false) goto L15;
        DownloadUtils.safeClose(new Cursor[]{r105});
        return;
    L15:
        throw new Throwable("Fail to check Uri with cursor.");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r105});
        throw th;
    L20:
        throw new Throwable("Fail to check Uri, type error :" + r101);
    }

    public static FileDescriptor getFileDescriptor(Uri r100, String r101) throws IOException {
        ParcelFileDescriptor r102 = getParcelFileDescriptor(r100, r101);
        if (r102 == null) goto L7;
        return r102.getFileDescriptor();
    L7:
        throw new IOException("Fail to get FileDescriptor, ParcelFileDescriptor is null");
    }

    public static ParcelFileDescriptor getParcelFileDescriptor(Uri r100, String r101) throws IOException {
        if (r100 == null) goto L12;
        ParcelFileDescriptor r102 = com_ss_android_socialbase_downloader_file_DownloadFileUtils_android_content_ContentResolver_openFileDescriptor(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext().getContentResolver(), r100, r101);     // Catch: Exception -> L8
        if (r102 == null) goto L7;
        return r102;
    L7:
        throw new IOException("Fail to get ParcelFileDescriptor, fileDescriptor is null");     // Catch: Exception -> L8
    L8:
        e = move-exception;
        throw new IOException("Fail to get ParcelFileDescriptor", e);
    L12:
        throw new IOException("Fail to get ParcelFileDescriptor, uri is null");
    }

    private static Uri com_ss_android_socialbase_downloader_file_DownloadFileUtils_android_content_ContentResolver_insert(ContentResolver r110, Uri r111, ContentValues r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        b r112 = new b();
        a r102 = ApiHookConfig.f245611b.get(240017);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(240017, "android/content/ContentResolver", "insert", r110, r101, "android.net.Uri", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (Uri) r107.f474983b;
    L21:
        return r110.insert(r111, r210);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    private static ParcelFileDescriptor com_ss_android_socialbase_downloader_file_DownloadFileUtils_android_content_ContentResolver_openFileDescriptor(ContentResolver r110, Uri r111, String r210) throws IOException {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        b r112 = new b();
        a r102 = ApiHookConfig.f245611b.get(240020);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r110, r101, "android.os.ParcelFileDescriptor", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r110, r111, r210);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static ContentValues createContentValues(String r100, String r101, String r102) {
        ContentValues r103 = new ContentValues();
        r103.put(LynxEventReporter.PROP_NAME_RELATIVE_PATH, r100);
        r103.put("_display_name", r101);
        r103.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        if (TextUtils.isEmpty(r102) == true) goto L5;
        r103.put("mime_type", r102);
    L5:
        return r103;
    }

    public static String getExternalUriPath(String r100, String r101, String r102) {
        if (isExternalDownloadEnabled() == true) goto L5;
        return null;
    L5:
        Context r103 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (r103 != null) goto L8;
        return null;
    L8:
        List r104 = Downloader.getInstance(r103).getDownloadInfoList(r100);
        if (r104 != null) goto L11;
    L37:
        Uri r105 = createUriAtLeastQ(MediaStore.Downloads.EXTERNAL_CONTENT_URI, DownloadDirUtils.getExternalRelativePath(), r101, r102);     // Catch: Throwable -> L31
    L33:
        if (r105 != null) goto L36;
        return null;
    L36:
        return r105.toString();
    L31:
        th = move-exception;
        Logger.globalError(TAG, "getExternalSavePath", "Error:" + th);
        r105 = null;
        goto L33
    L11:
        if (r104.isEmpty() == true) goto L37;
        Iterator r106 = r104.iterator();
        String r107 = null;
    L14:
        if (r106.hasNext() == false) goto L27;
        DownloadInfo r108 = (DownloadInfo) r106.next();
        String r109 = r108.getSavePath();
        if (TextUtils.isEmpty(r107) == false) goto L25;
        if (TextUtils.isEmpty(r107) == false) goto L24;
        if (isMediaUri(r109) == false) goto L24;
        if (checkUriInsert(r109) == false) goto L25;
    L24:
        r107 = r109;
    L25:
        Downloader.getInstance(r103).clearDownloadData(r108.getId());
        goto L14
    L27:
        if (TextUtils.isEmpty(r107) == true) goto L37;
        return r107;
    }

    private static int com_ss_android_socialbase_downloader_file_DownloadFileUtils_android_content_ContentResolver_delete(ContentResolver r110, Uri r111, String r210, String[] r211) throws Throwable {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210, r211};
        b r112 = new b();
        a r102 = ApiHookConfig.f245611b.get(240019);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(240019, "android/content/ContentResolver", "delete", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.delete(r111, r210, r211);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Uri createUriAtLeastQ(Uri r100, String r101, String r102, String r103) {
        Context r104 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (r104 != null) goto L7;
        return null;
    L7:
        return com_ss_android_socialbase_downloader_file_DownloadFileUtils_android_content_ContentResolver_insert(r104.getContentResolver(), r100, createContentValues(r101, r102, r103));
    }

    public static Uri getUriAtLeastQ(Uri r100, String r101, String r102, String r103) {
        Uri r104 = queryUriAtLeastQ(r100, r101, r102, r103);
        if (r104 == null) goto L5;
        return r104;
    L5:
        return createUriAtLeastQ(r100, r101, r102, r103);
    }

    public static Uri queryUriAtLeastQ(Uri r100, String r101, String r102, String r110) {
        Cursor r103 = null;
        if (r100 != null) goto L5;
    L41:
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L41;
        if (TextUtils.isEmpty(r102) == true) goto L41;
        if (r101.startsWith(HTTP.URL_DEFAULT) == false) goto L13;
        r101 = r101.substring(1);
    L13:
        if (r101.endsWith(HTTP.URL_DEFAULT) == true) goto L44;
        r101 = r101.concat(HTTP.URL_DEFAULT);
    L44:
    L38:
        th = th;
    L39:
        DownloadUtils.safeClose(new Cursor[]{r103});
        throw th;
    L17:
        if (TextUtils.isEmpty(r110) == false) goto L19;
        String r104 = "";
    L20:
        String r105 = "relative_path = ? AND _display_name = ?".concat(r104);     // Catch: Throwable -> L38
        if (TextUtils.isEmpty(r110) == false) goto L23;
        String[] r111 = {r101, r102};     // Catch: Throwable -> L38
    L24:
        Bundle r106 = new Bundle();     // Catch: Throwable -> L38
        r106.putString("android:query-arg-sql-selection", r105);     // Catch: Throwable -> L38
        r106.putStringArray("android:query-arg-sql-selection-args", r111);     // Catch: Throwable -> L38
        r106.putString("android:query-arg-sql-sort-order", "_id DESC");     // Catch: Throwable -> L38
        if (Build.VERSION.SDK_INT <= 30) goto L27;
        r106.putInt("android:query-arg-match-pending", 1);     // Catch: Throwable -> L38
    L27:
        Cursor r107 = com_ss_android_socialbase_downloader_file_DownloadFileUtils_android_content_ContentResolver_query(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext().getContentResolver(), MediaStore.setIncludePending(r100), new String[]{DBDefinition.ID}, r106, null);     // Catch: Throwable -> L38
        if (r107 != null) goto L42;
    L36:
        DownloadUtils.safeClose(new Cursor[]{r107});
        return null;
    L42:
    L34:
        th = th;
        r103 = r107;
        goto L39
    L30:
        if (r107.moveToFirst() == false) goto L36;
        Uri r108 = ContentUris.withAppendedId(r100, r107.getLong(r107.getColumnIndexOrThrow(DBDefinition.ID)));     // Catch: Throwable -> L34
        DownloadUtils.safeClose(new Cursor[]{r107});
        return r108;
    L23:
        r111 = new String[]{r101, r102, r110};     // Catch: Throwable -> L38
        goto L24
    L19:
        r104 = " AND mime_type = ?";
        goto L20
    }

    private static Cursor com_ss_android_socialbase_downloader_file_DownloadFileUtils_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, Bundle r113, CancellationSignal r114) {
        c r100 = new c();
        Object[] r101 = {r111, r112, r113, r114};
        b r115 = new b();
        d r116 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r115);
        if (r116.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r115, false);
        return (Cursor) r116.f474983b;
    L6:
        Cursor r117 = r110.query(r111, r112, r113, r114);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r117, r115, true);
        return r117;
    }

    private static Cursor com_ss_android_socialbase_downloader_file_DownloadFileUtils_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) throws Throwable {
        c r100 = new c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        b r116 = new b();
        d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
