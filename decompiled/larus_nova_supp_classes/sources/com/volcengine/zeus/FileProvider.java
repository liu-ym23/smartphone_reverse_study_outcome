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
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import mqc.q;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class FileProvider extends ContentProvider {
    public static final String[] a = null;
    public static final PolarisFileWrapper b = null;
    public static a c;

    public static class a {
        public final String a;
        public final HashMap<String, File> b;

        public a(String r2) {
            this.b = new HashMap();
            this.a = r2;
        }

        public final File a(Uri r5) {
            String r0 = r5.getEncodedPath();
            int r1 = r0.indexOf(47, 1);
            String r3 = Uri.decode(r0.substring(1, r1));
            String r2 = Uri.decode(r0.substring(r1 + 1));
            File r4 = this.b.get(r3);
            if (r4 == null) goto L14;
            PolarisFileWrapper r6 = new PolarisFileWrapper(r4, r2);
            File r7 = r6.getCanonicalFile();     // Catch: IOException -> L11
            if (r7.getPath().startsWith(r4.getPath()) == false) goto L10;
            return r7;
        L10:
            throw new SecurityException("Resolved path jumped beyond configured root");
        L12:
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r6);
        L14:
            throw new IllegalArgumentException("Unable to find configured root for " + r5);
        }
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    static {
        a = new String[]{"_display_name", "_size"};
        b = new PolarisFileWrapper("/");
    }

    public FileProvider() {
    }

    public static Uri getUriForFile(File r6) {
        a r0 = c;
        r0.getClass();
        String r7 = r6.getCanonicalPath();     // Catch: IOException -> L22
        Iterator<Map.Entry<String, File>> r1 = r0.b.entrySet().iterator();
        Map.Entry<String, File> r2 = null;
    L6:
        if (r1.hasNext() == false) goto L13;
        Map.Entry<String, File> r3 = r1.next();
        String r4 = r3.getValue().getPath();
        if (r7.startsWith(r4) == false) goto L6;
        if (r2 == null) goto L12;
        if (r4.length() <= r2.getValue().getPath().length()) goto L6;
    L12:
        r2 = r3;
        goto L6
    L13:
        if (r2 == null) goto L21;
        String r5 = r2.getValue().getPath();
        if (r5.endsWith("/") == false) goto L17;
        String r8 = r7.substring(r5.length());
    L19:
        return new Uri.Builder().scheme("content").authority(r0.a).encodedPath(Uri.encode(r2.getKey()) + '/' + Uri.encode(r8, "/")).build();
    L17:
        r8 = r7.substring(r5.length() + 1);
        goto L19
    L21:
        throw new IllegalArgumentException("Failed to find configured root that contains " + r7);
    L23:
        throw new IllegalArgumentException("Failed to resolve canonical path for " + r6);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r3) {
        File r4 = c.a(r3);
        int r0 = r4.getName().lastIndexOf(46);
        if (r0 < 0) goto L7;
        String r5 = r4.getName().substring(r0 + 1);
        String r6 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r5);
        if (r6 == null) goto L9;
        return r6;
    L9:
        return "application/octet-stream";
    L7:
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context r1, ProviderInfo r2) {
        super.attachInfo(r1, r2);
        if (r2.exported == true) goto L15;
        if (r2.grantUriPermissions == false) goto L13;
        if (c != null) goto L11;
        c = new a(r2.authority);
        return;
    L11:
        throw new SecurityException("仅允许定义一个FileProvider");
    L13:
        throw new SecurityException("Provider must grant uri permissions");
    L15:
        throw new SecurityException("Provider must not be exported");
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri r3, String r4) throws FileNotFoundException {
        File r5 = c.a(r3);
        if ("r".equals(r4) == false) goto L6;
        int r6 = 268435456;
    L23:
        return ParcelFileDescriptor.open(r5, r6);
    L6:
        if ("w".equals(r4) == false) goto L8;
    L21:
        r6 = 738197504;
        goto L23
    L8:
        if ("wt".equals(r4) == true) goto L21;
        if ("wa".equals(r4) == false) goto L14;
        r6 = 704643072;
        goto L23
    L14:
        if ("rw".equals(r4) == false) goto L17;
        r6 = 939524096;
        goto L23
    L17:
        if ("rwt".equals(r4) == false) goto L20;
        r6 = 1006632960;
        goto L23
    L20:
        throw new IllegalArgumentException("Invalid mode: " + r4);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        return c.a(r1).delete() ? 1 : 0;
    }

    public static void a(String r14, Context r15, a r16, XmlResourceParser r17) throws IOException, XmlPullParserException {
    L3:
        int r1 = r17.next();
        boolean r2 = true;
        if (r1 == 1) goto L75;
        if (r1 != 2) goto L3;
        String r3 = r17.getName();
        File r4 = null;
        String r5 = r17.getAttributeValue(null, "name");
        String r6 = r17.getAttributeValue(null, "path");
        if ("root-path".equals(r3) == false) goto L12;
        File r7 = b;
    L10:
        r4 = r7;
    L59:
        if (r4 == null) goto L3;
        String r8 = r14 + "_" + r5;
        if (r6 == null) goto L63;
        r4 = new PolarisFileWrapper(r4, r6);
    L63:
        r16.getClass();
        if (TextUtils.isEmpty(r8) == true) goto L71;
        r16.b.put(r8, r4.getCanonicalFile());
    L67:
        e = move-exception;
        throw new IllegalArgumentException("Failed to resolve canonical path for " + r4, e);
    L71:
        throw new IllegalArgumentException("Name must not be empty");
    L12:
        if ("files-path".equals(r3) == false) goto L15;
        r7 = r15.getFilesDir();
        goto L10
    L15:
        if ("cache-path".equals(r3) == false) goto L18;
        r7 = r15.getCacheDir();
        goto L10
    L18:
        if ("external-path".equals(r3) == false) goto L22;
        r7 = Environment.getExternalStorageDirectory();
        goto L10
    L22:
        if ("external-files-path".equals(r3) == false) goto L50;
        if (TextUtils.isEmpty(r6) == false) goto L26;
    L45:
        String r9 = null;
    L46:
        File[] r10 = r15.getExternalFilesDirs(r9);
        if (r10.length <= 0) goto L59;
        r4 = r10[0];
        goto L59
    L26:
        if (r6.startsWith("/") == false) goto L28;
        String r11 = r6.substring(1);
    L29:
        int r12 = r11.indexOf(47);
        if (r12 == (-1)) goto L32;
        r9 = r11.substring(0, r12);
    L33:
        String[] r13 = q.a;
        int r18 = r13.length;
        int r19 = 0;
    L34:
        if (r19 >= r18) goto L39;
        if (Intrinsics.areEqual(r13[r19], r9) == true) goto L40;
        r19 = r19 + 1;
    L40:
        if (r2 == false) goto L45;
        if (r12 == (-1)) goto L43;
        String r20 = r11.substring(r12 + 1);
    L44:
        r6 = r20;
        goto L46
    L43:
        r20 = XmlPullParser.NO_NAMESPACE;
        goto L44
    L39:
        r2 = false;
        goto L40
    L32:
        r9 = r11;
        goto L33
    L28:
        r11 = r6;
        goto L29
    L50:
        if ("external-cache-path".equals(r3) == false) goto L55;
        File[] r21 = r15.getExternalCacheDirs();
        if (r21.length <= 0) goto L59;
        r4 = r21[0];
        goto L59
    L55:
        if ("external-media-path".equals(r3) == false) goto L59;
        File[] r22 = r15.getExternalMediaDirs();
        if (r22.length <= 0) goto L59;
        r4 = r22[0];
        goto L59
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        throw new UnsupportedOperationException("No external updates");
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r7, String[] r8, String r9, String[] r10, String r11) {
        File r12 = c.a(r7);
        if (r8 != null) goto L5;
        r8 = a;
    L5:
        String[] r13 = new String[r8.length];
        Object[] r14 = new Object[r8.length];
        int r15 = r8.length;
        int r1 = 0;
        int r2 = 0;
    L6:
        if (r1 >= r15) goto L15;
        String r3 = r8[r1];
        if ("_display_name".equals(r3) == false) goto L12;
        r13[r2] = "_display_name";
        int r4 = r2 + 1;
        r14[r2] = r12.getName();
    L10:
        r2 = r4;
    L14:
        r1 = r1 + 1;
        goto L6
    L12:
        if ("_size".equals(r3) == false) goto L14;
        r13[r2] = "_size";
        r4 = r2 + 1;
        r14[r2] = Long.valueOf(r12.length());
        goto L10
    L15:
        String[] r16 = new String[r2];
        System.arraycopy(r13, 0, r16, 0, r2);
        Object[] r17 = new Object[r2];
        System.arraycopy(r14, 0, r17, 0, r2);
        MatrixCursor r18 = new MatrixCursor(r16, 1);
        r18.addRow(r17);
        return r18;
    }
}
