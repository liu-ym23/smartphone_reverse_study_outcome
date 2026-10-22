package com.ttnetuploader.uploader.utils;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import androidx.documentfile.provider.DocumentFile;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import f06.b;
import f06.c;
import f06.d;
import java.io.Closeable;
import java.io.InputStream;

/* JADX INFO: loaded from: classes41.dex */
public class UploadFileUtils {
    private static SparseArray<MediaItem> MEDIA_STORE_DATA = null;
    private static final String TAG = "UploadFileUtils";
    public static final int TYPE_AUDIO = 4;
    public static final int TYPE_DOWNLOADS = 5;
    public static final int TYPE_ERROR = -1;
    public static final int TYPE_FILE = 1;
    public static final int TYPE_IMAGE = 2;
    public static final int TYPE_VIDEO = 3;

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

    public UploadFileUtils() {
    }

    static {
        MEDIA_STORE_DATA = new SparseArray();     // Catch: Throwable -> L9
        if (isAtLeastAndroidQ() == false) goto L7;
        MEDIA_STORE_DATA.put(2, MediaItem.build(MediaStore.Images.Media.getContentUri("external_primary"), DBDefinition.ID));     // Catch: Throwable -> L9
        MEDIA_STORE_DATA.put(3, MediaItem.build(MediaStore.Video.Media.getContentUri("external_primary"), DBDefinition.ID));     // Catch: Throwable -> L9
        MEDIA_STORE_DATA.put(4, MediaItem.build(MediaStore.Audio.Media.getContentUri("external_primary"), DBDefinition.ID));     // Catch: Throwable -> L9
        MEDIA_STORE_DATA.put(5, MediaItem.build(MediaStore.Downloads.EXTERNAL_CONTENT_URI, DBDefinition.ID));     // Catch: Throwable -> L9
    L12:
        return;
    L7:
        MEDIA_STORE_DATA.put(2, MediaItem.build(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, DBDefinition.ID));     // Catch: Throwable -> L9
        MEDIA_STORE_DATA.put(3, MediaItem.build(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, DBDefinition.ID));     // Catch: Throwable -> L9
        MEDIA_STORE_DATA.put(4, MediaItem.build(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, DBDefinition.ID));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.printStackTrace();
    }

    public static Uri getRootContentUri() {
        return MediaStore.Files.getContentUri("external");
    }

    public static boolean isAtLeastAndroidQ() {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        return true;
    L5:
        return false;
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

    public static Pair<String, String> getParentAndNameFromRelativePath(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        return new Pair(r101.getParent(), r101.getName());
    L6:
        return null;
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

    public static boolean isMediaUri(String r100) {
        if (getTypeByUri(r100) > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void safeClose(Closeable... r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = r100.length;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L14;
        Closeable r103 = r100[r102];
        if (r103 == null) goto L13;
        r103.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
    L13:
        r102 = r102 + 1;
        goto L5
    }

    public static InputStream getFileInputStream(String r100, Context r101) throws Exception {
    L11:
        e = move-exception;
        throw e;
    L3:
        if (getTypeByUri(r100) == 1) goto L5;
        Uri r102 = UriProtector.parse(r100);     // Catch: Exception -> L11
    L6:
        if (r102 == null) goto L10;
        return ContentResolverWrapper.openInputStream(r101.getContentResolver(), r102);
    L10:
        return new PolarisFileInputStreamWrapper(r100);
    L5:
        r102 = null;
        goto L6
    }

    public static long getFileLength(String r100, Context r101) {
        if (r100 != null) goto L20;
        return -1;
    L20:
    L17:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L6:
        if (getTypeByUri(r100) == 1) goto L8;
        Uri r102 = UriProtector.parse(r100);     // Catch: Exception -> L17
    L9:
        if (r102 == null) goto L16;
        DocumentFile r103 = DocumentFile.fromSingleUri(r101, r102);     // Catch: Exception -> L17
        if (r103 != null) goto L13;
        return -1;
    L13:
        return r103.length();
    L16:
        return new PolarisFileWrapper(r100).length();
    L8:
        r102 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String getFilePathFromUri(Uri r110, Context r111) {
        String[] r100 = {"_data"};
        String r101 = null;
        if (r111 != null) goto L21;
        safeClose(new Closeable[]{null});
        return null;
    L21:
        Cursor r112 = com_ttnetuploader_uploader_utils_UploadFileUtils_android_content_ContentResolver_query(r111.getContentResolver(), r110, r100, null, null, null);     // Catch: Throwable -> L16
        if (r112 != null) goto L19;
    L14:
        safeClose(new Closeable[]{r112});
        return r101;
    L19:
    L12:
        th = th;
        r101 = r112;
    L17:
        safeClose(new Closeable[]{r101});
        throw th;
    L9:
        if (r112.moveToFirst() == false) goto L14;
        r101 = r112.getString(r112.getColumnIndex(r100[0]));     // Catch: Throwable -> L12
    L16:
        th = th;
        goto L17
    }

    public static Pair<String, String> getParentAndNameFromUri(Uri r100, Context r101) {
        return getParentAndNameFromRelativePath(getFilePathFromUri(r100, r101));
    }

    public static Uri getUriFromFilePath(String r110, Context r111) {
        Uri r100 = getRootContentUri();
        Cursor r101 = null;
    L23:
        th = th;
    L24:
        safeClose(new Closeable[]{r101});
        throw th;
    L5:
        if (Build.VERSION.SDK_INT < 29) goto L8;
        Cursor r112 = com_ttnetuploader_uploader_utils_UploadFileUtils_android_content_ContentResolver_query(r111.getContentResolver(), MediaStore.setIncludePending(r100), new String[]{DBDefinition.ID}, "_data=? ", new String[]{r110}, null);     // Catch: Throwable -> L23
    L9:
        if (r112 != null) goto L28;
    L21:
        safeClose(new Closeable[]{r112});
        return null;
    L28:
    L19:
        th = move-exception;
        r101 = r112;
        th = th;
        goto L24
    L11:
        if (r112.moveToFirst() == false) goto L21;
        int r113 = r112.getColumnIndex(DBDefinition.ID);     // Catch: Throwable -> L19
        if (r113 < 0) goto L17;
        Uri r114 = ContentUris.withAppendedId(r100, r112.getInt(r113));     // Catch: Throwable -> L19
        safeClose(new Closeable[]{r112});
        return r114;
    L17:
        safeClose(new Closeable[]{r112});
        return null;
    L8:
        r112 = null;
        goto L9
    }

    public static String getFileName(String r100, String r101, Context r102) {
        if (r101 != null) goto L4;
    L6:
        if (r100 != null) goto L18;
        return r100;
    L18:
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    L9:
        if (getTypeByUri(r100) == 1) goto L13;
        String r103 = getFilePathFromUri(UriProtector.parse(r100), r102);     // Catch: Exception -> L15
        if (r103 == null) goto L13;
        r100 = r103;
    L13:
        return new PolarisFileWrapper(r100).getName();
    L4:
        if (r101.isEmpty() == true) goto L6;
        return r101;
    }

    private static Cursor com_ttnetuploader_uploader_utils_UploadFileUtils_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
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
