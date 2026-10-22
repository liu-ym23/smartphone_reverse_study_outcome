package com.volcengine.zeus;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import mqc.q;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class FileProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f462625a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PolarisFileWrapper f462626b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f462627c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f462628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap<String, File> f462629b;

        public a(String r100) {
            this.f462629b = new HashMap();
            this.f462628a = r100;
        }

        public final File a(Uri r100) {
            String r101 = r100.getEncodedPath();
            int r102 = r101.indexOf(47, 1);
            String r103 = Uri.decode(r101.substring(1, r102));
            String r104 = Uri.decode(r101.substring(r102 + 1));
            File r105 = this.f462629b.get(r103);
            if (r105 == null) goto L14;
            PolarisFileWrapper r106 = new PolarisFileWrapper(r105, r104);
            File r107 = r106.getCanonicalFile();     // Catch: IOException -> L11
            if (r107.getPath().startsWith(r105.getPath()) == false) goto L10;
            return r107;
        L10:
            throw new SecurityException("Resolved path jumped beyond configured root");
        L12:
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r106);
        L14:
            throw new IllegalArgumentException("Unable to find configured root for " + r100);
        }
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    static {
        f462625a = new String[]{"_display_name", "_size"};
        f462626b = new PolarisFileWrapper(HTTP.URL_DEFAULT);
    }

    public FileProvider() {
    }

    public static Uri getUriForFile(File r100) {
        a r101 = f462627c;
        r101.getClass();
        String r102 = r100.getCanonicalPath();     // Catch: IOException -> L22
        Iterator<Map.Entry<String, File>> r103 = r101.f462629b.entrySet().iterator();
        Map.Entry<String, File> r104 = null;
    L6:
        if (r103.hasNext() == false) goto L13;
        Map.Entry<String, File> r105 = r103.next();
        String r106 = r105.getValue().getPath();
        if (r102.startsWith(r106) == false) goto L6;
        if (r104 == null) goto L12;
        if (r106.length() <= r104.getValue().getPath().length()) goto L6;
    L12:
        r104 = r105;
        goto L6
    L13:
        if (r104 == null) goto L21;
        String r107 = r104.getValue().getPath();
        if (r107.endsWith(HTTP.URL_DEFAULT) == false) goto L17;
        String r108 = r102.substring(r107.length());
    L19:
        return new Uri.Builder().scheme("content").authority(r101.f462628a).encodedPath(Uri.encode(r104.getKey()) + '/' + Uri.encode(r108, HTTP.URL_DEFAULT)).build();
    L17:
        r108 = r102.substring(r107.length() + 1);
        goto L19
    L21:
        throw new IllegalArgumentException("Failed to find configured root that contains " + r102);
    L23:
        throw new IllegalArgumentException("Failed to resolve canonical path for " + r100);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        File r101 = f462627c.a(r100);
        int r102 = r101.getName().lastIndexOf(46);
        if (r102 < 0) goto L7;
        String r103 = r101.getName().substring(r102 + 1);
        String r104 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r103);
        if (r104 == null) goto L9;
        return r104;
    L9:
        return "application/octet-stream";
    L7:
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context r100, ProviderInfo r101) {
        super.attachInfo(r100, r101);
        if (r101.exported == true) goto L15;
        if (r101.grantUriPermissions == false) goto L13;
        if (f462627c != null) goto L11;
        f462627c = new a(r101.authority);
        return;
    L11:
        throw new SecurityException("仅允许定义一个FileProvider");
    L13:
        throw new SecurityException("Provider must grant uri permissions");
    L15:
        throw new SecurityException("Provider must not be exported");
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri r100, String r101) throws FileNotFoundException {
        File r102 = f462627c.a(r100);
        if ("r".equals(r101) == false) goto L6;
        int r103 = 268435456;
    L23:
        return ParcelFileDescriptor.open(r102, r103);
    L6:
        if ("w".equals(r101) == false) goto L8;
    L21:
        r103 = 738197504;
        goto L23
    L8:
        if ("wt".equals(r101) == true) goto L21;
        if ("wa".equals(r101) == false) goto L14;
        r103 = 704643072;
        goto L23
    L14:
        if ("rw".equals(r101) == false) goto L17;
        r103 = 939524096;
        goto L23
    L17:
        if ("rwt".equals(r101) == false) goto L20;
        r103 = 1006632960;
        goto L23
    L20:
        throw new IllegalArgumentException("Invalid mode: " + r101);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        return f462627c.a(r100).delete() ? 1 : 0;
    }

    public static void a(String r110, Context r111, a r112, XmlResourceParser r113) throws IOException, XmlPullParserException {
    L3:
        int r100 = r113.next();
        boolean r101 = true;
        if (r100 == 1) goto L75;
        if (r100 != 2) goto L3;
        String r102 = r113.getName();
        File r103 = null;
        String r104 = r113.getAttributeValue(null, "name");
        String r105 = r113.getAttributeValue(null, "path");
        if ("root-path".equals(r102) == false) goto L12;
        File r106 = f462626b;
    L10:
        r103 = r106;
    L59:
        if (r103 == null) goto L3;
        String r107 = r110 + "_" + r104;
        if (r105 == null) goto L63;
        r103 = new PolarisFileWrapper(r103, r105);
    L63:
        r112.getClass();
        if (TextUtils.isEmpty(r107) == true) goto L71;
        r112.f462629b.put(r107, r103.getCanonicalFile());
    L67:
        e = move-exception;
        throw new IllegalArgumentException("Failed to resolve canonical path for " + r103, e);
    L71:
        throw new IllegalArgumentException("Name must not be empty");
    L12:
        if ("files-path".equals(r102) == false) goto L15;
        r106 = r111.getFilesDir();
        goto L10
    L15:
        if ("cache-path".equals(r102) == false) goto L18;
        r106 = r111.getCacheDir();
        goto L10
    L18:
        if ("external-path".equals(r102) == false) goto L22;
        r106 = Environment.getExternalStorageDirectory();
        goto L10
    L22:
        if ("external-files-path".equals(r102) == false) goto L50;
        if (TextUtils.isEmpty(r105) == false) goto L26;
    L45:
        String r108 = null;
    L46:
        File[] r109 = r111.getExternalFilesDirs(r108);
        if (r109.length <= 0) goto L59;
        r103 = r109[0];
        goto L59
    L26:
        if (r105.startsWith(HTTP.URL_DEFAULT) == false) goto L28;
        String r114 = r105.substring(1);
    L29:
        int r115 = r114.indexOf(47);
        if (r115 == (-1)) goto L32;
        r108 = r114.substring(0, r115);
    L33:
        String[] r116 = q.f514967a;
        int r117 = r116.length;
        int r118 = 0;
    L34:
        if (r118 >= r117) goto L39;
        if (Intrinsics.areEqual(r116[r118], r108) == true) goto L40;
        r118 = r118 + 1;
    L40:
        if (r101 == false) goto L45;
        if (r115 == (-1)) goto L43;
        String r119 = r114.substring(r115 + 1);
    L44:
        r105 = r119;
        goto L46
    L43:
        r119 = "";
        goto L44
    L39:
        r101 = false;
        goto L40
    L32:
        r108 = r114;
        goto L33
    L28:
        r114 = r105;
        goto L29
    L50:
        if ("external-cache-path".equals(r102) == false) goto L55;
        File[] r120 = r111.getExternalCacheDirs();
        if (r120.length <= 0) goto L59;
        r103 = r120[0];
        goto L59
    L55:
        if ("external-media-path".equals(r102) == false) goto L59;
        File[] r121 = r111.getExternalMediaDirs();
        if (r121.length <= 0) goto L59;
        r103 = r121[0];
        goto L59
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        throw new UnsupportedOperationException("No external updates");
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r110, String r111) {
        File r103 = f462627c.a(r100);
        if (r101 != null) goto L5;
        r101 = f462625a;
    L5:
        String[] r104 = new String[r101.length];
        Object[] r112 = new Object[r101.length];
        int r113 = r101.length;
        int r105 = 0;
        int r106 = 0;
    L6:
        if (r105 >= r113) goto L15;
        String r107 = r101[r105];
        if ("_display_name".equals(r107) == false) goto L12;
        r104[r106] = "_display_name";
        int r108 = r106 + 1;
        r112[r106] = r103.getName();
    L10:
        r106 = r108;
    L14:
        r105 = r105 + 1;
        goto L6
    L12:
        if ("_size".equals(r107) == false) goto L14;
        r104[r106] = "_size";
        r108 = r106 + 1;
        r112[r106] = Long.valueOf(r103.length());
        goto L10
    L15:
        String[] r109 = new String[r106];
        System.arraycopy(r104, 0, r109, 0, r106);
        Object[] r114 = new Object[r106];
        System.arraycopy(r112, 0, r114, 0, r106);
        MatrixCursor r115 = new MatrixCursor(r109, 1);
        r115.addRow(r114);
        return r115;
    }
}
