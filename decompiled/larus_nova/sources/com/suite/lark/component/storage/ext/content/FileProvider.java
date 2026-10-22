package com.suite.lark.component.storage.ext.content;

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
import androidx.core.content.ContextCompat;
import com.alipay.sdk.m.u.i;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes5.dex */
public class FileProvider extends ContentProvider {
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String[] COLUMNS = null;
    private static final File DEVICE_ROOT = null;
    private static final String DISPLAYNAME_FIELD = "displayName";
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG = "FileProvider";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final String TAG_EXTERNAL_FILES = "external-files-path";
    private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private static final HashMap<String, a> sCache = null;
    private static final String specialMatchPath = "/uz_";
    private a mStrategy;

    public interface a {
        File getFileForUri(Uri r100);

        Uri getUriForFile(File r100);
    }

    public static class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f460420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap<String, File> f460421b;

        public b(String r100) {
            this.f460421b = new HashMap();
            this.f460420a = r100;
        }

        @Override // com.suite.lark.component.storage.ext.content.FileProvider.a
        public final File getFileForUri(Uri r100) {
            String r101 = r100.getEncodedPath();
            int r102 = r101.indexOf(47, 1);
            String r103 = Uri.decode(r101.substring(1, r102));
            String r104 = Uri.decode(r101.substring(r102 + 1));
            File r105 = this.f460421b.get(r103);
            if (r105 == null) goto L18;
            PolarisFileWrapper r106 = new PolarisFileWrapper(r105, r104);
            if (r106.exists() == false) goto L7;
        L19:
            File r107 = r106.getCanonicalFile();     // Catch: IOException -> L15
            if (r107.getPath().startsWith(r105.getPath()) == false) goto L14;
            return r107;
        L14:
            throw new SecurityException("Resolved path jumped beyond configured root");
        L16:
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r106);
        L7:
            if (r105.getPath().endsWith(FileProvider.specialMatchPath) == false) goto L19;
            r106 = new PolarisFileWrapper(r105 + r104);
            goto L19
        L18:
            throw new IllegalArgumentException("Unable to find configured root for " + r100);
        }

        @Override // com.suite.lark.component.storage.ext.content.FileProvider.a
        public final Uri getUriForFile(File r100) {
            String r101 = r100.getCanonicalPath();     // Catch: IOException -> L24
            Iterator<Map.Entry<String, File>> r102 = this.f460421b.entrySet().iterator();
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
            if (r103 == null) goto L23;
            String r106 = r103.getValue().getPath();
            if (r106.endsWith(HTTP.URL_DEFAULT) == false) goto L16;
        L19:
            String r107 = r101.substring(r106.length());
        L21:
            return new Uri.Builder().scheme("content").authority(this.f460420a).encodedPath(Uri.encode(r103.getKey()) + '/' + Uri.encode(r107, HTTP.URL_DEFAULT)).build();
        L16:
            if (r101.startsWith(r106.concat(HTTP.URL_DEFAULT)) == false) goto L19;
            r107 = r101.substring(r106.length() + 1);
            goto L21
        L23:
            throw new IllegalArgumentException("Failed to find configured root that contains " + r101);
        L25:
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r100);
        }

        public final void a(String r100, File r101) {
            if (TextUtils.isEmpty(r100) == true) goto L11;
            this.f460421b.put(r100, r101.getCanonicalFile());
            return;
        L7:
            e = move-exception;
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r101, e);
        L11:
            throw new IllegalArgumentException("Name must not be empty");
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    static {
        COLUMNS = new String[]{"_display_name", "_size"};
        DEVICE_ROOT = new PolarisFileWrapper(HTTP.URL_DEFAULT);
        sCache = new HashMap();
    }

    public FileProvider() {
    }

    private static boolean isExternalPathTag(String r100) {
        if (TAG_EXTERNAL.equals(r100) == false) goto L5;
    L12:
        return true;
    L5:
        if (TAG_EXTERNAL_FILES.equals(r100) == true) goto L12;
        if (TAG_EXTERNAL_CACHE.equals(r100) == true) goto L12;
        if (TAG_EXTERNAL_MEDIA.equals(r100) == true) goto L12;
        return false;
    }

    private static int modeToMode(String r100) {
        if ("r".equals(r100) == false) goto L6;
        return 268435456;
    L6:
        if ("w".equals(r100) == false) goto L8;
    L21:
        return 738197504;
    L8:
        if ("wt".equals(r100) == true) goto L21;
        if ("wa".equals(r100) == false) goto L14;
        return 704643072;
    L14:
        if ("rw".equals(r100) == false) goto L17;
        return 939524096;
    L17:
        if ("rwt".equals(r100) == false) goto L20;
        return 1006632960;
    L20:
        throw new IllegalArgumentException("Invalid mode: " + r100);
    }

    public String getDefaultAuthority(Context r100) {
        return r100.getPackageName() + ".suite.provider";
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        File r101 = this.mStrategy.getFileForUri(r100);
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

    private static File buildPath(File r100, String... r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        String r104 = r101[r103];
        if (r104 == null) goto L7;
        r100 = new PolarisFileWrapper(r100, r104);
    L7:
        r103 = r103 + 1;
        goto L3
    L8:
        return r100;
    }

    private static Object[] copyOf(Object[] r100, int r101) {
        Object[] r102 = new Object[r101];
        System.arraycopy(r100, 0, r102, 0, r101);
        return r102;
    }

    private static a getPathStrategy(Context r100, String r101) {
        HashMap<String, a> r102 = sCache;
        monitor-enter(r102);
        a r103 = r102.get(r101);     // Catch: Throwable -> L16
        if (r103 == null) goto L20;
    L14:
        monitor-exit(r102);     // Catch: Throwable -> L16
        return r103;
    L20:
        r103 = parsePathStrategy(r100, r101);     // Catch: XmlPullParserException -> L8 IOException -> L11 Throwable -> L16
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

    private static a parsePathStrategy(Context r100, String r110) throws IOException, XmlPullParserException {
        b r101 = new b(r110);
        ProviderInfo r102 = r100.getPackageManager().resolveContentProvider(r110, 128);
        if (r102 == null) goto L51;
        XmlResourceParser r111 = r102.loadXmlMetaData(r100.getPackageManager(), META_DATA_FILE_PROVIDER_PATHS);
        if (r111 == null) goto L49;
    L6:
        int r103 = r111.next();
        if (r103 == 1) goto L47;
        if (r103 != 2) goto L6;
        String r104 = r111.getName();
        File r105 = null;
        String r106 = r111.getAttributeValue(null, "name");
        String r107 = r111.getAttributeValue(null, "path");
        if (TAG_ROOT_PATH.equals(r104) == false) goto L14;
        r105 = DEVICE_ROOT;
    L37:
        if (r105 == null) goto L6;
        r101.a(r106, buildPath(r105, new String[]{r107}));     // Catch: IllegalArgumentException -> L40
    L40:
        e = move-exception;
        if (isExternalPathTag(r104) == false) goto L46;
        if ((e.getCause() instanceof IOException) == true) goto L6;
    L46:
        throw e;
    L14:
        if (TAG_FILES_PATH.equals(r104) == false) goto L17;
        r105 = r100.getFilesDir();
        goto L37
    L17:
        if (TAG_CACHE_PATH.equals(r104) == false) goto L20;
        r105 = r100.getCacheDir();
        goto L37
    L20:
        if (TAG_EXTERNAL.equals(r104) == false) goto L23;
        r105 = Environment.getExternalStorageDirectory();
        goto L37
    L23:
        if (TAG_EXTERNAL_FILES.equals(r104) == false) goto L28;
        File[] r108 = ContextCompat.getExternalFilesDirs(r100, null);
        if (r108.length <= 0) goto L37;
        r105 = r108[0];
        goto L37
    L28:
        if (TAG_EXTERNAL_CACHE.equals(r104) == false) goto L33;
        File[] r109 = ContextCompat.getExternalCacheDirs(r100);
        if (r109.length <= 0) goto L37;
        r105 = r109[0];
        goto L37
    L33:
        if (TAG_EXTERNAL_MEDIA.equals(r104) == false) goto L37;
        File[] r112 = r100.getExternalMediaDirs();
        if (r112.length <= 0) goto L37;
        r105 = r112[0];
        goto L37
    L47:
        return r101;
    L49:
        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    L51:
        throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + r110);
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context r100, ProviderInfo r101) {
        super.attachInfo(r100, r101);
        if (r101.exported == true) goto L14;
        if (r101.grantUriPermissions == false) goto L12;
        if (r101.authority != null) goto L9;
        r101.authority = getDefaultAuthority(r100);
    L9:
        this.mStrategy = getPathStrategy(r100, r101.authority.split(i.f25853b)[0]);
        return;
    L12:
        throw new SecurityException("Provider must grant uri permissions");
    L14:
        throw new SecurityException("Provider must not be exported");
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri r100, String r101) throws FileNotFoundException {
        return ParcelFileDescriptor.open(this.mStrategy.getFileForUri(r100), modeToMode(r101));
    }

    private static String[] copyOf(String[] r100, int r101) {
        String[] r102 = new String[r101];
        System.arraycopy(r100, 0, r102, 0, r101);
        return r102;
    }

    public static Uri getUriForFile(Context r100, String r101, File r102) {
        return getPathStrategy(r100, r101).getUriForFile(r102);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        return this.mStrategy.getFileForUri(r100).delete() ? 1 : 0;
    }

    public static Uri getUriForFile(Context r100, String r101, File r102, String r103) {
        return getUriForFile(r100, r101, r102).buildUpon().appendQueryParameter("displayName", r103).build();
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        throw new UnsupportedOperationException("No external updates");
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r110, String r111) {
        File r103 = this.mStrategy.getFileForUri(r100);
        String r104 = UriProtector.getQueryParameter(r100, "displayName");
        if (r101 != null) goto L5;
        r101 = COLUMNS;
    L5:
        String[] r112 = new String[r101.length];
        Object[] r113 = new Object[r101.length];
        int r105 = r101.length;
        int r106 = 0;
        int r107 = 0;
    L6:
        if (r106 >= r105) goto L19;
        String r108 = r101[r106];
        if ("_display_name".equals(r108) == false) goto L15;
        r112[r107] = "_display_name";
        int r109 = r107 + 1;
        if (r104 != null) goto L12;
        String r114 = r103.getName();
    L13:
        r113[r107] = r114;
    L17:
        r107 = r109;
    L18:
        r106 = r106 + 1;
        goto L6
    L12:
        r114 = r104;
        goto L13
    L15:
        if ("_size".equals(r108) == false) goto L18;
        r112[r107] = "_size";
        r109 = r107 + 1;
        r113[r107] = Long.valueOf(r103.length());
        goto L17
    L19:
        String[] r115 = copyOf(r112, r107);
        Object[] r116 = copyOf(r113, r107);
        MatrixCursor r117 = new MatrixCursor(r115, 1);
        r117.addRow(r116);
        return r117;
    }
}
