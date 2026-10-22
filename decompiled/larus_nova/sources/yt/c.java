package yt;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PolarisFileWrapper f568999a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, a> f569000b = null;

    public interface a {
        Uri a(PolarisFileWrapper r100);

        File getFileForUri(Uri r100);
    }

    public static class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f569001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap<String, File> f569002b;

        public b(String r100) {
            this.f569002b = new HashMap();
            this.f569001a = r100;
        }

        @Override // yt.c.a
        public final Uri a(PolarisFileWrapper r100) {
            String r101 = r100.getCanonicalPath();     // Catch: IOException -> L21
            Iterator<Map.Entry<String, File>> r102 = this.f569002b.entrySet().iterator();
            Map.Entry<String, File> r103 = null;
        L5:
            if (r102.hasNext() == false) goto L12;
            Map.Entry<String, File> r104 = r102.next();
            String r105 = r104.getValue().getPath();
            if (r101.startsWith(r105) == false) goto L5;
            if (r103 == null) goto L11;
            if (r105.length() <= r103.getValue().getPath().length()) goto L5;
        L11:
            r103 = r104;
            goto L5
        L12:
            if (r103 == null) goto L20;
            String r106 = r103.getValue().getPath();
            if (r106.endsWith(HTTP.URL_DEFAULT) == false) goto L16;
            String r107 = r101.substring(r106.length());
        L18:
            return new Uri.Builder().scheme("content").authority(this.f569001a).encodedPath(Uri.encode(r103.getKey()) + '/' + Uri.encode(r107, HTTP.URL_DEFAULT)).build();
        L16:
            r107 = r101.substring(r106.length() + 1);
            goto L18
        L20:
            throw new IllegalArgumentException("Failed to find configured root that contains " + r101);
        L22:
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r100);
        }

        @Override // yt.c.a
        public final File getFileForUri(Uri r100) {
            String r101 = r100.getEncodedPath();
            int r102 = r101.indexOf(47, 1);
            String r103 = Uri.decode(r101.substring(1, r102));
            String r104 = Uri.decode(r101.substring(r102 + 1));
            File r105 = this.f569002b.get(r103);
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

    static {
        f568999a = new PolarisFileWrapper(HTTP.URL_DEFAULT);
        f569000b = new HashMap();
    }

    public static a a(Context r100, String r101) {
        HashMap<String, a> r102 = f569000b;
        monitor-enter(r102);
        a r103 = r102.get(r101);     // Catch: Throwable -> L16
        if (r103 == null) goto L20;
    L14:
        monitor-exit(r102);     // Catch: Throwable -> L16
        return r103;
    L20:
        r103 = b(r100, r101);     // Catch: XmlPullParserException -> L8 IOException -> L11 Throwable -> L16
        r102.put(r101, r103);     // Catch: Throwable -> L16
        goto L14
    L8:
        e = move-exception;
        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);     // Catch: Throwable -> L16
    L11:
        e = move-exception;
        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public static b b(Context r100, String r101) throws IOException, XmlPullParserException {
        b r102 = new b(r101);
        ProviderInfo r103 = r100.getPackageManager().resolveContentProvider(r101, 128);
        if (r103 == null) goto L53;
        XmlResourceParser r104 = r103.loadXmlMetaData(r100.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (r104 == null) goto L51;
    L6:
        int r105 = r104.next();
        if (r105 == 1) goto L49;
        if (r105 != 2) goto L6;
        String r106 = r104.getName();
        File r107 = null;
        String r108 = r104.getAttributeValue(null, "name");
        String r109 = r104.getAttributeValue(null, "path");
        if ("root-path".equals(r106) == false) goto L14;
        r107 = f568999a;
    L37:
        if (r107 == null) goto L6;
        if (r109 == null) goto L41;
        r107 = new PolarisFileWrapper(r107, r109);
    L41:
        if (TextUtils.isEmpty(r108) == true) goto L48;
        r102.f569002b.put(r108, r107.getCanonicalFile());
    L44:
        e = move-exception;
        throw new IllegalArgumentException("Failed to resolve canonical path for " + r107, e);
    L48:
        throw new IllegalArgumentException("Name must not be empty");
    L14:
        if ("files-path".equals(r106) == false) goto L17;
        r107 = r100.getFilesDir();
        goto L37
    L17:
        if ("cache-path".equals(r106) == false) goto L20;
        r107 = r100.getCacheDir();
        goto L37
    L20:
        if ("external-path".equals(r106) == false) goto L23;
        r107 = Environment.getExternalStorageDirectory();
        goto L37
    L23:
        if ("external-files-path".equals(r106) == false) goto L28;
        File[] r110 = ContextCompat.getExternalFilesDirs(r100, null);
        if (r110.length <= 0) goto L37;
        r107 = r110[0];
        goto L37
    L28:
        if ("external-cache-path".equals(r106) == false) goto L33;
        File[] r111 = ContextCompat.getExternalCacheDirs(r100);
        if (r111.length <= 0) goto L37;
        r107 = r111[0];
        goto L37
    L33:
        if ("external-media-path".equals(r106) == false) goto L37;
        File[] r112 = r100.getExternalMediaDirs();
        if (r112.length <= 0) goto L37;
        r107 = r112[0];
        goto L37
    L49:
        return r102;
    L51:
        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    L53:
        throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + r101);
    }
}
