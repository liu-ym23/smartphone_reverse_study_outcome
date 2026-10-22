package com.larus.utils;

import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.keva.KevaImpl;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char f375457a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f375458b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f375459c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f375460d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f375461e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f375462f;

    static {
        BigInteger r100 = BigInteger.valueOf(1024);
        r100.multiply(r100.multiply(r100.multiply(r100.multiply(r100.multiply(r100)))));
        Charset.forName("UTF-8");
        f375457a = File.separatorChar;
        f375458b = LazyKt.lazy(new m());
        f375459c = LazyKt.lazy(new n());
        f375460d = LazyKt.lazy(new o());
        f375461e = LazyKt.lazy(new p());
    }

    public static String h() {
        if (TextUtils.isEmpty(f375462f) == true) goto L7;
        return f375462f;
    L7:
        if (Build.VERSION.SDK_INT < 29) goto L19;
        Application r100 = AppHost.f326268a.getApplication();
        if (r100 != null) goto L12;
        return null;
    L12:
        File r101 = r100.getExternalFilesDir(Environment.DIRECTORY_DCIM);
        if (r101 == null) goto L18;
        if (r101.exists() == false) goto L18;
        f375462f = r101.getAbsolutePath();
    L18:
        return f375462f;
    L19:
        File r102 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102, "Camera");
        if (r103.exists() == false) goto L23;
        String r104 = r103.getAbsolutePath();
        f375462f = r104;
        return r104;
    L23:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r102, "100MEDIA");
        if (r105.exists() == false) goto L27;
        String r106 = r105.getAbsolutePath();
        f375462f = r106;
        return r106;
    L27:
        PolarisFileWrapper r107 = new PolarisFileWrapper(r102, "100ANDRO");
        if (r107.exists() == false) goto L31;
        String r108 = r107.getAbsolutePath();
        f375462f = r108;
        return r108;
    L31:
        String r109 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "nova_image";
        PolarisFileWrapper r110 = new PolarisFileWrapper(r109);
        if (r110.exists() == true) goto L34;
        r110.mkdirs();
    L34:
        f375462f = r109;
        return r109;
    }

    @JvmStatic
    public static final void a(File r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "directory");
        if (r100.exists() == false) goto L23;
        if (r100.isDirectory() == false) goto L21;
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L19;
        int r102 = r101.length;
        IOException e100 = null;
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L15;
        File r104 = r101[r103];
        Intrinsics.checkNotNull(r104);     // Catch: IOException -> L13
        g(r104);     // Catch: IOException -> L13
    L14:
        r103 = r103 + 1;
    L13:
        e100 = e;
        goto L14
    L15:
        if (e100 != null) goto L17;
        return;
    L17:
        throw e100;
    L19:
        throw new IOException("Failed to list contents of " + r100);
    L21:
        throw new FileNotFoundException(r100 + " is not a directory");
    L23:
        throw new FileNotFoundException(r100 + " does not exist");
    }

    @JvmStatic
    public static final void d(File r100) {
        if (r100.exists() == false) goto L14;
        File[] r101 = r100.listFiles();
        if (r101 != null) goto L8;
        return;
    L8:
        int r102 = r101.length;
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L18;
        File r104 = r101[r103];
        if (r104.isDirectory() == false) goto L13;
        d(r104);
    L13:
        r104.delete();
        r103 = r103 + 1;
        goto L9
    L18:
        return;
    }

    @JvmStatic
    public static final boolean f(File r100) {
        if (r100 != null) goto L12;
        return false;
    L12:
        if (r100.isDirectory() == false) goto L14;
        a(r100);     // Catch: Exception -> L10
    L14:
        return r100.delete();
    L16:
        return false;
    }

    @JvmStatic
    public static final void g(File r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "file");
        if (r100.isDirectory() == false) goto L15;
        Intrinsics.checkNotNullParameter(r100, "directory");
        if (r100.exists() == true) goto L8;
        return;
    L8:
        if (l(r100) == true) goto L11;
        a(r100);
    L11:
        if (r100.delete() == false) goto L14;
        return;
    L14:
        throw new IOException("Unable to delete directory " + r100 + '.');
    L15:
        boolean r101 = r100.exists();
        if (r100.delete() == true) goto L22;
        if (r101 == true) goto L21;
        throw new FileNotFoundException("File does not exist: " + r100);
    L21:
        throw new IOException("Unable to delete file: " + r100);
    }

    public static boolean k(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L17
        boolean r102 = true;
        if (r100 != null) goto L6;
    L9:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
    L14:
        r102 = false;
    L15:
        Object r104 = Result.m9449constructorimpl(Boolean.valueOf(r102));     // Catch: Throwable -> L17
    L20:
        if (Result.m9455isFailureimpl(r104) == false) goto L22;
        r104 = null;
    L22:
        Boolean r105 = (Boolean) r104;
        if (r105 != null) goto L25;
        return false;
    L25:
        return r105.booleanValue();
    L12:
        if (new PolarisFileWrapper(r100).exists() == false) goto L14;
    L6:
        if (r100.length() == 0) goto L9;
        r103 = false;
    L17:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    @JvmStatic
    public static final boolean l(File r100) throws IOException {
        if (r100 == null) goto L16;
        if (f375457a != '\\') goto L6;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L10;
        return false;
    L10:
        if (r100.getParent() == null) goto L14;
        File r102 = r100.getParentFile();
        Intrinsics.checkNotNull(r102);
        r100 = new PolarisFileWrapper(r102.getCanonicalFile(), r100.getName());
    L14:
        return !Intrinsics.areEqual(r100.getCanonicalFile(), r100.getAbsoluteFile());
    L6:
        r101 = false;
        goto L7
    L16:
        throw new NullPointerException("File must not be null");
    }

    @JvmStatic
    public static final boolean m(File r100) {
    L10:
        e = move-exception;
        FLogger.f375446a.e("FileUtils", "isValidDir error " + e);
        if (r100.exists() == true) goto L14;
    L16:
        return false;
    L14:
        if (r100.canWrite() == false) goto L16;
    L15:
        return true;
    L3:
        if (r100.mkdirs() == true) goto L6;
        r100.mkdir();     // Catch: Exception -> L10
    L6:
        if (r100.exists() == false) goto L16;
        if (r100.canWrite() == false) goto L16;
        goto L16
    }

    @JvmStatic
    public static final PolarisFileInputStreamWrapper n(PolarisFileWrapper r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "file");
        if (r100.exists() == false) goto L15;
        if (r100.isDirectory() == true) goto L13;
        if (r100.canRead() == false) goto L11;
        return new PolarisFileInputStreamWrapper(r100);
    L11:
        throw new IOException("File '" + r100 + "' cannot be read");
    L13:
        throw new IOException("File '" + r100 + "' exists but is a directory");
    L15:
        throw new FileNotFoundException("File '" + r100 + "' does not exist");
    }

    @JvmStatic
    public static final PolarisFileOutputStreamWrapper o(PolarisFileWrapper r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "file");
        Intrinsics.checkNotNullParameter(r100, "file");
        if (r100.exists() == true) goto L5;
        File r101 = r100.getParentFile();
        if (r101 != null) goto L16;
    L23:
        return new PolarisFileOutputStreamWrapper(r100, false);
    L16:
        if (r101.mkdirs() == true) goto L23;
        if (r101.isDirectory() == true) goto L23;
        throw new IOException("Directory '" + r101 + "' could not be created");
    L5:
        if (r100.isDirectory() == true) goto L12;
        if (r100.canWrite() == true) goto L23;
        throw new IOException("File '" + r100 + "' cannot be written to");
    L12:
        throw new IOException("File '" + r100 + "' exists but is a directory");
    }

    @JvmStatic
    public static final String p(long r100) {
        if (r100 > 0) goto L6;
        return "0";
    L6:
        double r101 = r100;
        int r102 = (int) (Math.log10(r101) / Math.log10(1024.0d));
        return new DecimalFormat("#,##0.#", new DecimalFormatSymbols(Locale.US)).format(r101 / Math.pow(1024.0d, r102)) + ' ' + new String[]{"B", "KB", "MB", "GB", "TB"}[r102];
    }

    @JvmStatic
    public static final long r(File r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        if (r100.exists() == true) goto L10;
        if (AppHost.f326268a.isDebug() == false) goto L15;
        FLogger r101 = FLogger.f375446a;
        r101.e("FileUtils", "createFileFromStream error " + (r100 + " does not exist"));
        return -1;
    L15:
        return -1;
    L10:
        if (r100.isDirectory() == false) goto L13;
        return s(r100);
    L13:
        return r100.length();
    }

    public static long s(File r100) {
        File[] r101 = r100.listFiles();
        if (r101 != null) goto L5;
        return 0;
    L5:
        int r102 = r101.length;
        int r103 = 0;
        long r104 = 0;
    L6:
        if (r103 >= r102) goto L18;
        File r105 = r101[r103];
        if (l(r105) == true) goto L17;
        Intrinsics.checkNotNull(r105);     // Catch: IOException -> L19
        if (r105.isDirectory() == false) goto L13;
        long r106 = s(r105);     // Catch: IOException -> L19
    L14:
        r104 = r104 + r106;
        if (r104 >= 0) goto L17;
    L13:
        r106 = r105.length();     // Catch: IOException -> L19
    L17:
        r103 = r103 + 1;
    L18:
        return r104;
    }

    @JvmStatic
    public static final long t(File... r100) {
        Intrinsics.checkNotNullParameter(r100, KevaImpl.PrivateConstants.FILES_DIR_NAME);
        int r101 = r100.length;
        long r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L10;
        r102 = r102 + r(r100[r103]);
    L9:
        r103 = r103 + 1;
    L7:
        e = move-exception;
        FLogger.f375446a.e("FileUtils", "sizeOfFiles error " + e);
        goto L9
    L10:
        return r102;
    }

    public static void c(File r110, PolarisFileWrapper r111) throws IOException {
        if (r110 == null) goto L72;
        if (r111 == null) goto L70;
        if (r110.exists() == false) goto L68;
        if (r110.isDirectory() == true) goto L66;
        if (Intrinsics.areEqual(r110.getCanonicalPath(), r111.getCanonicalPath()) == true) goto L64;
        File r100 = r111.getParentFile();
        if (r100 == null) goto L20;
        if (r100.mkdirs() == true) goto L20;
        if (r100.isDirectory() == true) goto L20;
        throw new IOException("Destination '" + r100 + "' directory cannot be created");
    L20:
        if (r111.exists() == false) goto L27;
        if (r111.canWrite() == true) goto L27;
        throw new IOException("Destination '" + r111 + "' exists but is read-only");
    L27:
        if (r111.exists() == true) goto L29;
    L33:
        FileChannel r101 = null;
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r110);     // Catch: Throwable -> L58
        PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r111);     // Catch: Throwable -> L56
        FileChannel r104 = r102.getChannel();     // Catch: Throwable -> L54
        r101 = r103.getChannel();     // Catch: Throwable -> L52
        long r112 = r104.size();     // Catch: Throwable -> L52
        long r113 = 0;
    L39:
        if (r113 >= r112) goto L46;
        long r105 = r112 - r113;     // Catch: Throwable -> L52
        if (r105 <= 31457280) goto L43;
        long r106 = 31457280;
    L44:
        r113 = r113 + r101.transferFrom(r104, r113, r106);
        goto L39
    L43:
        r106 = r105;
        goto L44
    L46:
        g.a(r101);
        g.a(r103);
        g.a(r104);
        g.a(r102);
        if (r110.length() != r111.length()) goto L51;
        r111.setLastModified(r110.lastModified());
        return;
    L51:
        throw new IOException("Failed to copy full contents from '" + r110 + "' to '" + r111 + '\'');
    L52:
        th = th;
    L61:
        g.a(r101);
        g.a(r103);
        g.a(r104);
        g.a(r102);
        throw th;
    L54:
        th = th;
        r104 = null;
    L56:
        th = th;
    L60:
        r103 = null;
        r104 = null;
    L58:
        th = th;
        r102 = null;
        goto L60
    L29:
        if (r111.isDirectory() == false) goto L33;
        throw new IOException("Destination '" + r111 + "' exists but is a directory");
    L64:
        throw new IOException("Source '" + r110 + "' and destination '" + r111 + "' are the same");
    L66:
        throw new IOException("Source '" + r110 + "' exists but is a directory");
    L68:
        throw new FileNotFoundException("Source '" + r110 + "' does not exist");
    L70:
        throw new NullPointerException("Destination must not be null");
    L72:
        throw new NullPointerException("Source must not be null");
    }

    @JvmStatic
    public static final void e(File r100, boolean r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_DIR);
        File[] r102 = r100.listFiles();
        if (r102 != null) goto L8;
        if (r101 == false) goto L7;
        return;
    L7:
        throw new IOException("not a readable directory: " + r100);
    L8:
        int r103 = r102.length;
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L20;
        File r105 = r102[r104];
        if (r105.isDirectory() == false) goto L14;
        Intrinsics.checkNotNull(r105);
        e(r105, r101);
    L14:
        if (r105.delete() == true) goto L19;
        if (r101 == true) goto L19;
        throw new IOException("failed to delete file: " + r105);
    L19:
        r104 = r104 + 1;
        goto L9
    }

    @JvmStatic
    public static final String j(Context r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        if (Intrinsics.areEqual("file", r101.getScheme()) == true) goto L5;
        Uri r102 = null;
        if (Intrinsics.areEqual("content", r101.getScheme()) == false) goto L23;
        Cursor r103 = b(r100.getContentResolver(), r101, new String[]{"_data"}, null, null);     // Catch: Exception -> L20
        if (r103 != null) goto L11;
        return null;
    L11:
        if (r103.moveToFirst() == true) goto L13;
        r103.close();     // Catch: Exception -> L20
        return null;
    L13:
        int r104 = r103.getColumnIndex("_data");     // Catch: Exception -> L20
        if (r104 < 0) goto L16;
        String r105 = r103.getString(r104);     // Catch: Exception -> L20
    L17:
        r103.close();     // Catch: Exception -> L20
        return r105;
    L16:
        r105 = null;
    L20:
        e = move-exception;
        FLogger.f375446a.e("FileUtils", "getFilePathByUri error " + e);
    L23:
        if (Intrinsics.areEqual("content", r101.getScheme()) == true) goto L26;
        return null;
    L26:
        if (DocumentsContract.isDocumentUri(r100, r101) == true) goto L29;
        return null;
    L29:
        if (Intrinsics.areEqual("com.android.externalstorage.documents", r101.getAuthority()) == false) goto L47;
        String r106 = DocumentsContract.getDocumentId(r101);
        Intrinsics.checkNotNull(r106);
        List<String> r107 = new Regex(":").split(r106, 0);
        if (r107.isEmpty() == true) goto L41;
        ListIterator<String> r108 = r107.listIterator(r107.size());
    L34:
        if (r108.hasPrevious() == false) goto L41;
        if (r108.previous().length() != 0) goto L38;
        boolean r109 = true;
    L39:
        if (r109 == true) goto L34;
        List r110 = CollectionsKt.take(r107, r108.nextIndex() + 1);
    L42:
        String[] r111 = (String[]) r110.toArray(new String[0]);
        if (StringsKt.equals("primary", r111[0], true) == true) goto L45;
    L85:
        return null;
    L45:
        return Environment.getExternalStorageDirectory() + '/' + r111[1];
    L38:
        r109 = false;
    L41:
        r110 = CollectionsKt.emptyList();
        goto L42
    L47:
        if (Intrinsics.areEqual("com.android.providers.downloads.documents", r101.getAuthority()) == false) goto L51;
        return i(r100, ContentUris.withAppendedId(UriProtector.parse("content://downloads/public_downloads"), CastLongProtector.valueOf(DocumentsContract.getDocumentId(r101)).longValue()), null, null);
    L51:
        if (Intrinsics.areEqual("com.android.providers.media.documents", r101.getAuthority()) == false) goto L85;
        String r112 = DocumentsContract.getDocumentId(r101);
        Intrinsics.checkNotNull(r112);
        List<String> r113 = new Regex(":").split(r112, 0);
        if (r113.isEmpty() == true) goto L63;
        ListIterator<String> r114 = r113.listIterator(r113.size());
    L56:
        if (r114.hasPrevious() == false) goto L63;
        if (r114.previous().length() != 0) goto L60;
        boolean r115 = true;
    L61:
        if (r115 == true) goto L56;
        List r116 = CollectionsKt.take(r113, r114.nextIndex() + 1);
    L64:
        String[] r117 = (String[]) r116.toArray(new String[0]);
        String r118 = r117[0];
        int r119 = r118.hashCode();
        if (r119 == 93166550) goto L80;
        if (r119 == 100313435) goto L76;
        if (r119 != 112202875) goto L84;
        if (r118.equals("video") == false) goto L84;
        r102 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    L84:
        return i(r100, r102, "_id=?", new String[]{r117[1]});
    L76:
        if (r118.equals("image") == false) goto L84;
        r102 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        goto L84
    L80:
        if (r118.equals("audio") == false) goto L84;
        r102 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        goto L84
    L60:
        r115 = false;
    L63:
        r116 = CollectionsKt.emptyList();
        goto L64
    L5:
        return r101.getPath();
    }

    @JvmStatic
    public static final boolean q(PolarisFileWrapper r100, PolarisFileWrapper r101) {
        Intrinsics.checkNotNullParameter(r100, "src");
        Intrinsics.checkNotNullParameter(r101, "dest");
        if (r100.renameTo(r101) == false) goto L16;
        return true;
    L16:
        c(r100, r101);     // Catch: Exception -> L11
        r100.delete();     // Catch: Exception -> L8
    L10:
        return true;
    L8:
        e = move-exception;
        FLogger.f375446a.e("FileUtils", "renameTo delete error " + e);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        FLogger.f375446a.e("FileUtils", "renameTo error " + e);
        return false;
    }

    public static Uri u(Context r210, String r211, boolean r212) {
        if (r210 == null) goto L99;
        if (TextUtils.isEmpty(r211) == true) goto L99;
        if (Build.VERSION.SDK_INT >= 29) goto L13;
        if (r211 == null) goto L12;
        MediaScannerConnection.scanFile(r210, new String[]{r211}, null, new q());
    L12:
        return null;
    L13:
        PolarisFileWrapper r100 = new PolarisFileWrapper(r211);
        if (r100.exists() == true) goto L16;
        return null;
    L16:
        ContentResolver r101 = r210.getContentResolver();
        ContentValues r102 = new ContentValues();
        r102.put("title", r100.getName());
        r102.put("_display_name", r100.getName());
        if (r212 == false) goto L19;
        String r103 = "image/*";
    L20:
        r102.put("mime_type", r103);
        if (r212 == false) goto L23;
        String r104 = Environment.DIRECTORY_PICTURES;
    L24:
        r102.put(LynxEventReporter.PROP_NAME_RELATIVE_PATH, r104);
        if (r212 == false) goto L27;
        Uri r105 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    L28:
        ArrayList r110 = new ArrayList();
        Object[] r111 = {r105, r102};
        f06.b r106 = new f06.b();
        g06.a r107 = ApiHookConfig.f245611b.get(240017);
        if (r107 == null) goto L31;
        f06.a[] r108 = r107.f479473i;
    L32:
        f06.a[] r112 = r108;
        int r113 = r112.length;
        int r114 = 0;
    L34:
        if (r114 >= r113) goto L41;
        f06.a r115 = r112[r114];
        int r213 = r114;
        int r214 = r113;
        f06.a[] r215 = r112;
        Object[] r216 = r111;
        f06.d r109 = r115.preInvoke(240017, "android/content/ContentResolver", "insert", r101, r111, "android.net.Uri", r106);     // Catch: Exception -> L100
        if (r109.f474982a == true) goto L43;
        r110.add(r115);     // Catch: Exception -> L100
    L43:
        if (r109.f474982a == false) goto L45;
        Uri r116 = (Uri) r109.f474983b;
    L105:
        BufferedInputStream r117 = new BufferedInputStream(new PolarisFileInputStreamWrapper(r100));     // Catch: Throwable -> L71 IOException -> L74
        if (r116 != null) goto L111;
        OutputStream r118 = null;
    L55:
        if (r118 != null) goto L108;
    L67:
        r117.close();     // Catch: IOException -> L80
        if (r118 == null) goto L86;
        r118.close();     // Catch: IOException -> L80
    L86:
        return r116;
    L108:
        byte[] r119 = new byte[4096];     // Catch: Throwable -> L63 IOException -> L65
    L58:
        int r120 = r117.read(r119);     // Catch: Throwable -> L63 IOException -> L65
        if (r120 == (-1)) goto L61;
        r118.write(r119, 0, r120);     // Catch: Throwable -> L63 IOException -> L65
        goto L58
    L61:
        r118.flush();     // Catch: Throwable -> L63 IOException -> L65
    L65:
        e = e;
        OutputStream r121 = r118;
    L103:
        e.printStackTrace();     // Catch: Throwable -> L87
        if (r117 == null) goto L82;
        r117.close();     // Catch: IOException -> L80
    L82:
        if (r121 == null) goto L86;
        r121.close();     // Catch: IOException -> L80
    L87:
        th = move-exception;
        Throwable r122 = th;
    L89:
        if (r117 != null) goto L101;
    L93:
        if (r121 == null) goto L117;
        r121.close();     // Catch: IOException -> L91
        throw r122;
    L91:
        e = move-exception;
        e.printStackTrace();
        throw r122;
    L117:
        throw r122;
    L101:
        r117.close();     // Catch: IOException -> L91
    L63:
        th = move-exception;
        r122 = th;
        r121 = r118;
        goto L89
    L111:
        r118 = ContentResolverWrapper.openOutputStream(r101, r116);     // Catch: Throwable -> L50 IOException -> L52
        goto L55
    L52:
        e = e;
    L76:
        r121 = null;
    L50:
        th = th;
    L73:
        r122 = th;
        r121 = null;
        goto L89
    L80:
        e = move-exception;
        e.printStackTrace();
    L74:
        e = e;
        r117 = null;
    L71:
        th = th;
        r117 = null;
        goto L73
    L45:
        r116 = r101.insert(r105, r102);
    L40:
        r114 = r213 + 1;
        r113 = r214;
        r112 = r215;
        r111 = r216;
        goto L34
    L41:
        r109 = new f06.d(false, null);
        goto L43
    L31:
        r108 = ApiHookConfig.f245613d;
        goto L32
    L27:
        r105 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        goto L28
    L23:
        r104 = Environment.DIRECTORY_MOVIES;
        goto L24
    L19:
        r103 = MimeType.MP4;
    L99:
        return null;
    }

    public static String i(Context r100, Uri r101, String r102, String[] r103) {
        String[] r104 = {"_data"};
        if (r101 != null) goto L21;
    L20:
        return null;
    L21:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L14
        Cursor r106 = b(r100.getContentResolver(), r101, r104, r102, r103);     // Catch: Throwable -> L14
        if (r106 != null) goto L7;
        Unit r107 = null;
    L12:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L14
    L16:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L19;
        FLogger.f375446a.e("FileUtils", "getDataColumn() get throwable with message: " + r109.getMessage() + ", and stackTrace: " + ExceptionsKt.stackTraceToString(r109));
    L19:
        Result.m9448boximpl(r108);
        goto L20
    L7:
        if (r106.moveToFirst() == false) goto L10;
        String r110 = r106.getString(r106.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L14
        r106.close();     // Catch: Throwable -> L14
        return r110;
    L10:
        r106.close();     // Catch: Throwable -> L14
        r107 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public static Cursor b(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, null};
        f06.b r115 = new f06.b();
        f06.d r116 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r115);
        if (r116.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r115, false);
        return (Cursor) r116.f474983b;
    L6:
        Cursor r117 = r110.query(r111, r112, r113, r114, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r117, r115, true);
        return r117;
    }
}
