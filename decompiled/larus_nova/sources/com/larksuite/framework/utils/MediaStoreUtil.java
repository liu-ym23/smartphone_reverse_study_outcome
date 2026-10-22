package com.larksuite.framework.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class MediaStoreUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f285910a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larksuite/framework/utils/MediaStoreUtil$DirType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PICTURES", "DCIM", "DOWNLOADS", "DOCUMENTS", "MUSIC", "MOVIES", "common-utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DirType extends Enum<DirType> {
        public static final DirType DCIM = null;
        public static final DirType DOCUMENTS = null;
        public static final DirType DOWNLOADS = null;
        public static final DirType MOVIES = null;
        public static final DirType MUSIC = null;
        public static final DirType PICTURES = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DirType[] f285911a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f285912b = null;
        private final String value;

        public static EnumEntries<DirType> getEntries() {
            return f285912b;
        }

        static {
            DirType r100 = new DirType("PICTURES", 0, Environment.DIRECTORY_PICTURES);
            PICTURES = r100;
            DirType r101 = new DirType("DCIM", 1, Environment.DIRECTORY_DCIM);
            DCIM = r101;
            DirType r102 = new DirType("DOWNLOADS", 2, Environment.DIRECTORY_DOWNLOADS);
            DOWNLOADS = r102;
            DirType r103 = new DirType("DOCUMENTS", 3, Environment.DIRECTORY_DOCUMENTS);
            DOCUMENTS = r103;
            DirType r104 = new DirType("MUSIC", 4, Environment.DIRECTORY_MUSIC);
            MUSIC = r104;
            DirType r105 = new DirType("MOVIES", 5, Environment.DIRECTORY_MOVIES);
            MOVIES = r105;
            DirType[] r110 = {r100, r101, r102, r103, r104, r105};
            f285911a = r110;
            f285912b = EnumEntriesKt.enumEntries(r110);
        }

        public static DirType[] values() {
            return (DirType[]) f285911a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static DirType valueOf(String r100) {
            return (DirType) r27.a.a(DirType.class, r100);
        }

        public DirType(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f285913a = null;

        static {
            int[] r100 = new int[DirType.values().length];
            r100[DirType.DOCUMENTS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[DirType.DOWNLOADS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[DirType.MUSIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[DirType.MOVIES.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[DirType.DCIM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[DirType.PICTURES.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f285913a = r100;
        }
    }

    public MediaStoreUtil() {
    }

    @JvmStatic
    public static final Uri e(Context r100, String r101, String r102, DirType r110, Token r111) {
        Intrinsics.checkNotNullParameter(r102, DBDefinition.MIME_TYPE);
        Intrinsics.checkNotNullParameter(r110, "dirType");
        Intrinsics.checkNotNullParameter(r111, "token");
        return f(r100, r101, r102, r110, r111, 16);
    }

    static {
        f285910a = SetsKt.setOf(new String[]{"doc", DocumentType.DOCX_NAME, "xls", "xlsx", ExportFileExtension.PDF, "pps", "ppt", ExportFileExtension.PPTX, "txt"});
    }

    public static DirType h(String r100) {
        Log.i("MediaStoreUtil", "getDirName ... filename: " + r100);
        if (TextUtils.isEmpty(r100) == true) goto L5;
        String r101 = FileUtils.k(r100);
        Intrinsics.checkNotNull(r101);
        Intrinsics.checkNotNullParameter(r101, "extension");
        if (f285910a.contains(r101) == true) goto L9;
        String r102 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r101);
        if (r102 != null) goto L13;
        r102 = "*/*";
    L13:
        Log.i("MediaStoreUtil", "getDirName ... mimeType from extension(" + r101 + "): " + r102);
        Intrinsics.checkNotNull(r102);
        if (StringsKt.startsWith$default(r102, "image", false, 2, null) == false) goto L17;
        return DirType.PICTURES;
    L17:
        if (StringsKt.startsWith$default(r102, "video", false, 2, null) == false) goto L20;
        return DirType.MOVIES;
    L20:
        if (StringsKt.startsWith$default(r102, "audio", false, 2, null) == false) goto L23;
        return DirType.MUSIC;
    L23:
        return DirType.DOWNLOADS;
    L9:
        return DirType.DOCUMENTS;
    L5:
        return DirType.DOWNLOADS;
    }

    @JvmStatic
    public static final String i(DirType r100) {
        Intrinsics.checkNotNullParameter(r100, "dirType");
        Intrinsics.checkNotNullParameter(r100, "dirType");
        PolarisFileWrapper r101 = new PolarisFileWrapper(Environment.getExternalStoragePublicDirectory(r100.getValue()), "Lark");
        if (r101.exists() == true) goto L7;
        r101.mkdirs();     // Catch: Exception -> L8
    L7:
        return r100.getValue() + File.separator + "Lark";
    }

    public static Uri b(ContentResolver r110, Uri r111, ContentValues r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240017);
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
        f06.d r107 = r106.preInvoke(240017, "android/content/ContentResolver", "insert", r110, r101, "android.net.Uri", r112);     // Catch: Exception -> L22
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
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @JvmStatic
    public static final void c(File r100, Uri r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "srcFile");
        Intrinsics.checkNotNullParameter(r101, "destUri");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r100);     // Catch: IOException -> L24
        OutputStream r104 = ContentResolverWrapper.openOutputStream(r102.getContentResolver(), r101);     // Catch: Throwable -> L19
        if (r104 != null) goto L31;
        Log.e("MediaStoreUtil", "open uri failed:" + r101);     // Catch: Throwable -> L19
    L16:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r103, null);     // Catch: IOException -> L24
        return;
    L31:
        FileUtils.d(r103, r104);     // Catch: Throwable -> L10
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r104, null);     // Catch: Throwable -> L19
        goto L16
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);     // Catch: IOException -> L24
        throw th;     // Catch: IOException -> L24
    L24:
        e = move-exception;
        Log.d("MediaStoreUtil", e.getMessage());
    }

    @JvmStatic
    public static final void j(Context r100, String r101, Token r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "token");
        if (TextUtils.isEmpty(r101) == false) goto L10;
        return;
    L10:
        uf7.a.a(r102);     // Catch: SensitiveAPIException -> L7
        Intent r103 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");     // Catch: SensitiveAPIException -> L7
        r103.setData(Uri.fromFile(new PolarisFileWrapper(r101)));     // Catch: SensitiveAPIException -> L7
        r100.sendBroadcast(r103);     // Catch: SensitiveAPIException -> L7
        MediaScannerConnection.scanFile(r100, new String[]{r101}, null, null);     // Catch: SensitiveAPIException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("MediaStoreUtil", "notifySystemScanFile failed", e);
    }

    public static void a(ContentValues r100, String r101, String r102, String r103) {
        long r104 = System.currentTimeMillis();
        r100.put("_display_name", r101);
        r100.put("mime_type", r102);
        r100.put(LynxEventReporter.PROP_NAME_RELATIVE_PATH, r103);
        r100.put("date_added", Long.valueOf(r104));
    }

    @Deprecated(message = "use psda token", replaceWith = @ReplaceWith(expression = "createMediaStoreUri function with token parameter.", imports = {}))
    @JvmStatic
    public static final Uri d(Context r100, String r101, String r110, DirType r111) {
        Intrinsics.checkNotNullParameter(r110, DBDefinition.MIME_TYPE);
        Intrinsics.checkNotNullParameter(r111, "dirType");
        ContentValues r102 = new ContentValues();
        Intrinsics.checkNotNullParameter(r110, DBDefinition.MIME_TYPE);
        Intrinsics.checkNotNullParameter(r111, "dirType");
        return g(r100, r101, r110, r111, r102, null);
    }

    public static Uri f(Context r100, String r101, String r102, DirType r103, Token r110, int r111) {
        if ((r111 & 4) == 0) goto L5;
        r102 = FileUtils.p(r101);
    L5:
        String r104 = r102;
        if ((r111 & 8) == 0) goto L8;
        r103 = h(r101);
    L8:
        DirType r105 = r103;
        if ((r111 & 16) == 0) goto L11;
        ContentValues r106 = new ContentValues();
    L12:
        Intrinsics.checkNotNullParameter(r104, DBDefinition.MIME_TYPE);
        Intrinsics.checkNotNullParameter(r105, "dirType");
        Intrinsics.checkNotNullParameter(r110, "token");
        return g(r100, r101, r104, r105, r106, r110);
    L11:
        r106 = null;
        goto L12
    }

    @JvmStatic
    public static final Uri g(Context r110, String r111, String r112, DirType r210, ContentValues r211, Token r212) {
        Intrinsics.checkNotNullParameter(r112, DBDefinition.MIME_TYPE);
        Intrinsics.checkNotNullParameter(r210, "dirType");
        if (r110 != null) goto L6;
        Log.e("MediaStoreUtil", "context is null");
        return null;
    L6:
        if (r111 != null) goto L8;
    L96:
        Log.e("MediaStoreUtil", "filename is not valid");
        return null;
    L8:
        if (TextUtils.isEmpty(r111) == true) goto L96;
        if (r211 != null) goto L12;
        ContentValues r100 = new ContentValues();
    L13:
        String r101 = i(r210);
        switch(a.f285913a[r210.ordinal()]) {
            case 1: goto L85;
            case 2: goto L73;
            case 3: goto L54;
            case 4: goto L36;
            case 5: goto L18;
            case 6: goto L18;
            default: goto L16;
        };
    L16:
        throw new NoWhenBranchMatchedException();
    L18:
        if (TextUtils.isEmpty(r111) == false) goto L20;
    L71:
        return null;
    L20:
        if (TextUtils.isEmpty(r101) == true) goto L71;
        if (r101.endsWith(HTTP.URL_DEFAULT) == true) goto L25;
        r101 = r101.concat(HTTP.URL_DEFAULT);
    L25:
        r100.put("_display_name", r111);
        r100.put("mime_type", r112);
        if (Build.VERSION.SDK_INT < 29) goto L28;
        r100.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        Uri r102 = MediaStore.Images.Media.getContentUri("external_primary");
        r100.put(LynxEventReporter.PROP_NAME_RELATIVE_PATH, r101);
    L29:
        if (r212 != null) goto L102;
        Uri r103 = c.a(r110.getContentResolver(), r102, r100);
    L95:
        return r103;
    L102:
        r103 = sf7.a.f541727a.insert(r110.getContentResolver(), r102, r100, r212);     // Catch: SensitiveAPIException -> L32
    L32:
        e = move-exception;
        Log.e("BdMediaFileSystemWithPSDA", "createImageUri failed:" + e.getMessage());
        goto L71
    L28:
        Uri r104 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        r100.put("_data", bytedance.util.a.e(Environment.getExternalStorageDirectory().getPath() + HTTP.URL_DEFAULT + r101 + HTTP.URL_DEFAULT + r111));
        r102 = r104;
        goto L29
    L36:
        if (TextUtils.isEmpty(r111) == true) goto L71;
        if (TextUtils.isEmpty(r101) == true) goto L71;
        if (r101.endsWith(HTTP.URL_DEFAULT) == true) goto L43;
        r101 = r101.concat(HTTP.URL_DEFAULT);
    L43:
        r100.put("_display_name", r111);
        r100.put("mime_type", r112);
        if (Build.VERSION.SDK_INT < 29) goto L46;
        r100.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        Uri r105 = MediaStore.Video.Media.getContentUri("external_primary");
        r100.put(LynxEventReporter.PROP_NAME_RELATIVE_PATH, r101);
    L47:
        if (r212 != null) goto L100;
        r103 = c.a(r110.getContentResolver(), r105, r100);
        goto L95
    L100:
        r103 = sf7.a.f541727a.insert(r110.getContentResolver(), r105, r100, r212);     // Catch: SensitiveAPIException -> L50
    L50:
        e = move-exception;
        Log.e("BdMediaFileSystemWithPSDA", "createVideoUri failed:" + e.getMessage());
        goto L71
    L46:
        Uri r106 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        r100.put("_data", bytedance.util.a.e(Environment.getExternalStorageDirectory().getPath() + HTTP.URL_DEFAULT + r101 + HTTP.URL_DEFAULT + r111));
        r105 = r106;
        goto L47
    L54:
        if (TextUtils.isEmpty(r111) == true) goto L71;
        if (TextUtils.isEmpty(r101) == true) goto L71;
        if (r101.endsWith(HTTP.URL_DEFAULT) == true) goto L61;
        r101 = r101.concat(HTTP.URL_DEFAULT);
    L61:
        r100.put("_display_name", r111);
        r100.put("mime_type", r112);
        if (Build.VERSION.SDK_INT < 29) goto L64;
        r100.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        Uri r107 = MediaStore.Audio.Media.getContentUri("external_primary");
        r100.put(LynxEventReporter.PROP_NAME_RELATIVE_PATH, r101);
    L65:
        if (r212 != null) goto L98;
        r103 = c.a(r110.getContentResolver(), r107, r100);
        goto L95
    L98:
        r103 = sf7.a.f541727a.insert(r110.getContentResolver(), r107, r100, r212);     // Catch: SensitiveAPIException -> L68
    L68:
        e = move-exception;
        Log.e("BdMediaFileSystemWithPSDA", "createMusicUri failed:" + e.getMessage());
        goto L71
    L64:
        Uri r108 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        r100.put("_data", bytedance.util.a.e(Environment.getExternalStorageDirectory().getPath() + HTTP.URL_DEFAULT + r101 + HTTP.URL_DEFAULT + r111));
        r107 = r108;
        goto L65
    L73:
        if (Build.VERSION.SDK_INT <= 29) goto L75;
        boolean r109 = true;
    L76:
        if (r109 == false) goto L83;
        a(r100, r111, r112, i(r210));
        Uri r113 = MediaStore.Downloads.getContentUri("external_primary");
        if (r212 == null) goto L80;
        r103 = sf7.a.f541727a.insert(r110.getContentResolver(), r113, r100, r212);
    L81:
        if (r103 != null) goto L95;
        Log.e("MediaStoreUtil", "create download uri for R failed");
        goto L95
    L80:
        r103 = b(r110.getContentResolver(), r113, r100);
        goto L81
    L83:
        PolarisFileWrapper r114 = new PolarisFileWrapper(i(r210));
        r114.mkdirs();
        r103 = Uri.fromFile(new PolarisFileWrapper(r114, r111));
        goto L95
    L75:
        r109 = false;
        goto L76
    L85:
        if (Build.VERSION.SDK_INT <= 29) goto L87;
        boolean r115 = true;
    L88:
        if (r115 == false) goto L93;
        a(r100, r111, r112, i(r210));
        Uri r116 = MediaStore.Files.getContentUri("external_primary");
        if (r212 == null) goto L92;
        sf7.a r117 = sf7.a.f541727a;
        ContentResolver r118 = r110.getContentResolver();
        Intrinsics.checkNotNull(r116);
        r103 = r117.insert(r118, r116, r100, r212);
        goto L95
    L92:
        r103 = b(r110.getContentResolver(), r116, r100);
        goto L95
    L93:
        PolarisFileWrapper r119 = new PolarisFileWrapper(i(r210));
        r119.mkdirs();
        r103 = Uri.fromFile(new PolarisFileWrapper(r119, r111));
        goto L95
    L87:
        r115 = false;
        goto L88
    L12:
        r100 = r211;
        goto L13
    }
}
