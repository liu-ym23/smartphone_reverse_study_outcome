package com.ss.android.ttve.nativePort;

import android.app.Application;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.vesdk.VEConfigCenter;
import com.ss.android.vesdk.VELogUtil;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public class TEContentProviderUtils {
    private static final String TAG = "TEContentProviderUtils";
    private static Application _initApplication;
    private static String sMediaStoreVersion;
    private static HashMap<String, String> sPathMap;

    public TEContentProviderUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        sPathMap = new HashMap();
        sMediaStoreVersion = null;
    }

    public static Application getApplicationContext() {
        if (_initApplication != null) goto L9;
        Class r100 = INVOKESTATIC_com_ss_android_ttve_nativePort_TEContentProviderUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread");     // Catch: Throwable -> L6
        Field r101 = r100.getDeclaredField("mInitialApplication");     // Catch: Throwable -> L6
        Object r102 = r100.getMethod("currentActivityThread", new Class[0]).invoke(null, null);     // Catch: Throwable -> L6
        r101.setAccessible(true);     // Catch: Throwable -> L6
        _initApplication = (Application) r101.get(r102);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        VELogUtil.e(TEContentProviderUtils.class, "[getApplicationContext] err: " + th.getMessage());
    L9:
        return _initApplication;
    }

    public static String getAndroidExternalDir() {
        Application r100 = getApplicationContext();
        if (r100 == null) goto L8;
        File r101 = r100.getExternalFilesDir(null);
        if (r101 == null) goto L8;
        return r101.getAbsolutePath();
    L8:
        return null;
    }

    public static ContentResolver getContentResolver() {
        Application r100 = getApplicationContext();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getContentResolver();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_ttve_nativePort_TEContentProviderUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private static boolean checkDownloadsDoc(Uri r100) {
        return "com.android.providers.downloads.documents".equals(r100.getAuthority());
    }

    private static boolean checkExternalStorageDoc(Uri r100) {
        return "com.android.externalstorage.documents".equals(r100.getAuthority());
    }

    private static boolean checkGooglePhotosUri(Uri r100) {
        return "com.google.android.apps.photos.content".equals(r100.getAuthority());
    }

    private static boolean checkMediaDoc(Uri r100) {
        return "com.android.providers.media.documents".equals(r100.getAuthority());
    }

    public static String convertUriPathFromNative(String r100) {
        Application r101 = getApplicationContext();
        if (r101 != null) goto L5;
        return null;
    L5:
        if (VEConfigCenter.getInstance().getValue("ve_enable_uri_convert_android_q_cache", false).booleanValue() == true) goto L7;
    L30:
        ContentResolver r102 = r101.getContentResolver();     // Catch: Throwable -> L26
        Uri r103 = UriProtector.parse(r100);     // Catch: Throwable -> L26
        if (r103 == null) goto L33;
        if (r102 == null) goto L34;
        String r104 = convertUriPath(r101, r103);     // Catch: Throwable -> L26
        VELogUtil.i("TEContentProviderUtils-Q", "[convertUriPathFromNative] from db. uriPath = " + VELogUtil.getSafeString(r100) + ", convertPath = " + VELogUtil.getSafeString(r104));     // Catch: Throwable -> L26
        sPathMap.put(r100, r104);     // Catch: Throwable -> L26
        return r104;
    L34:
        return null;
    L33:
        return null;
    L26:
        th = move-exception;
        VELogUtil.e(TEContentProviderUtils.class, "[getFd] err", th);
        return null;
    L7:
        if (sMediaStoreVersion != null) goto L10;
        sMediaStoreVersion = getVersion(r101);
    L10:
        if (sMediaStoreVersion != null) goto L12;
    L20:
        sMediaStoreVersion = getVersion(r101);
        sPathMap.clear();
        goto L30
    L12:
        if (getVersion(r101) == null) goto L20;
        if (sMediaStoreVersion.equals(getVersion(r101)) == false) goto L20;
        if (sPathMap.containsKey(r100) == false) goto L30;
        String r105 = sPathMap.get(r100);
        VELogUtil.i("TEContentProviderUtils-Q", "[convertUriPathFromNative] from cache. uriPath = " + VELogUtil.getSafeString(r100) + ", cachePath = " + VELogUtil.getSafeString(r105));
        return r105;
    }

    public static String getExtensionFromUri(String r100) {
        String r101 = getFileTypeFromUri(r100);
        return MimeTypeMap.getSingleton().getExtensionFromMimeType(r101);
    }

    public static String getFileTypeFromUri(String r100) {
        long r101 = System.currentTimeMillis();
        if (VEConfigCenter.getInstance().getValue("ve_enable_cache_file_info_opt", false).booleanValue() == false) goto L8;
        a r102 = a.C5448a.f449971a;
        if (r102.f449970c.containsKey(r100) == false) goto L8;
        VELogUtil.d(TAG, "getFileTypeFromUri cache cost = " + (System.currentTimeMillis() - r101) + ", filePath = " + r100);
        return r102.f449970c.get(r100);
    L8:
        Application r103 = getApplicationContext();
        String r104 = null;
        if (r103 != null) goto L19;
    L17:
        a.C5448a.f449971a.f449970c.put(r100, r104);
        VELogUtil.d(TAG, "getFileTypeFromUri cost = " + (System.currentTimeMillis() - r101) + ", filePath = " + r100);
        return r104;
    L19:
        Uri r105 = UriProtector.parse(r100);     // Catch: Throwable -> L15
        ContentResolver r106 = r103.getContentResolver();     // Catch: Throwable -> L15
        if (r105 == null) goto L17;
        if (r106 == null) goto L17;
        r104 = r106.getType(r105);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        VELogUtil.e(TEContentProviderUtils.class, "[getFileTypeFromUri] err", th);
        goto L17
    }

    private static String getVersion(Context r100) {
        ContentProviderClient r101 = com_ss_android_ttve_nativePort_TEContentProviderUtils_android_content_ContentResolver_acquireContentProviderClient(r100.getContentResolver(), "media");
        if (r101 == null) goto L6;
        r101.release();
        return MediaStore.getVersion(r100);
    L6:
        return null;
    }

    private static ContentProviderClient com_ss_android_ttve_nativePort_TEContentProviderUtils_android_content_ContentResolver_acquireContentProviderClient(ContentResolver r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(240016, "android/content/ContentResolver", "acquireContentProviderClient", r110, r101, "android.content.ContentProviderClient", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(240016, "android/content/ContentResolver", "acquireContentProviderClient", r110, r101, null, r112, false);
        return (ContentProviderClient) r113.f474983b;
    L6:
        ContentProviderClient r114 = r110.acquireContentProviderClient(r111);
        r100.a(240016, "android/content/ContentResolver", "acquireContentProviderClient", r110, r101, r114, r112, true);
        return r114;
    }

    private static String convertUriPath(Context r100, Uri r101) {
        Uri r102 = null;
        if (DocumentsContract.isDocumentUri(r100, r101) == false) goto L28;
        if (checkExternalStorageDoc(r101) == false) goto L11;
        String[] r103 = DocumentsContract.getDocumentId(r101).split(":");
        if ("primary".equalsIgnoreCase(r103[0]) == true) goto L9;
    L39:
        return null;
    L9:
        return Environment.getExternalStorageDirectory() + HTTP.URL_DEFAULT + r103[1];
    L11:
        if (checkDownloadsDoc(r101) == false) goto L15;
        return getColumnByUri(r100, ContentUris.withAppendedId(UriProtector.parse("content://downloads/public_downloads"), CastLongProtector.parseLong(DocumentsContract.getDocumentId(r101))), null, null);
    L15:
        if (checkMediaDoc(r101) == false) goto L39;
        String[] r104 = DocumentsContract.getDocumentId(r101).split(":");
        String r105 = r104[0];
        if ("image".equals(r105) == false) goto L20;
        r102 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    L26:
        return getColumnByUri(r100, r102, "_id=?", new String[]{r104[1]});
    L20:
        if ("video".equals(r105) == false) goto L23;
        r102 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        goto L26
    L23:
        if ("audio".equals(r105) == false) goto L26;
        r102 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        goto L26
    L28:
        if ("content".equalsIgnoreCase(r101.getScheme()) == false) goto L36;
        if (checkGooglePhotosUri(r101) == false) goto L34;
        return r101.getLastPathSegment();
    L34:
        return getColumnByUri(r100, r101, null, null);
    L36:
        if ("file".equalsIgnoreCase(r101.getScheme()) == false) goto L39;
        return r101.getPath();
    }

    public static int getFd(String r100, String r101) {
        long r102 = System.currentTimeMillis();
        Application r103 = getApplicationContext();
        int r104 = -1;
        if (r103 != null) goto L13;
    L11:
        VELogUtil.d(TAG, "getFd cost = " + (System.currentTimeMillis() - r102) + ", filePath = " + r100);
        return r104;
    L13:
        ContentResolver r105 = r103.getContentResolver();     // Catch: Throwable -> L9
        Uri r106 = UriProtector.parse(r100);     // Catch: Throwable -> L9
        if (r106 == null) goto L11;
        if (r105 == null) goto L11;
        r104 = com_ss_android_ttve_nativePort_TEContentProviderUtils_android_content_ContentResolver_openFileDescriptor(r105, r106, r101).detachFd();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        VELogUtil.e(TEContentProviderUtils.class, "[getFd] err", th);
        goto L11
    }

    private static ParcelFileDescriptor com_ss_android_ttve_nativePort_TEContentProviderUtils_android_content_ContentResolver_openFileDescriptor(ContentResolver r110, Uri r111, String r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240020);
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
        f06.d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r110, r101, "android.os.ParcelFileDescriptor", r112);     // Catch: Exception -> L22
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
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    private static String getColumnByUri(Context r100, Uri r101, String r110, String[] r111) {
        String[] r102 = {"_data"};
        Cursor r103 = null;
        Cursor r104 = com_ss_android_ttve_nativePort_TEContentProviderUtils_android_content_ContentResolver_query(r100.getContentResolver(), r101, r102, r110, r111, null);     // Catch: Throwable -> L15
        if (r104 != null) goto L21;
    L12:
        if (r104 == null) goto L14;
        r104.close();
    L14:
        return null;
    L21:
    L10:
        th = th;
        r103 = r104;
    L16:
        if (r103 == null) goto L18;
        r103.close();
    L18:
        throw th;
    L6:
        if (r104.moveToFirst() == false) goto L12;
        String r105 = r104.getString(r104.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L10
        r104.close();
        return r105;
    L15:
        th = th;
        goto L16
    }

    private static Cursor com_ss_android_ttve_nativePort_TEContentProviderUtils_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        f06.b r116 = new f06.b();
        f06.d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
