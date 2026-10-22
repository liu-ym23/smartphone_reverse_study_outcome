package androidx.core.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import androidx.core.util.ObjectsCompat;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class FileProvider extends ContentProvider {
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String[] COLUMNS = null;
    private static final File DEVICE_ROOT = null;
    private static final String DISPLAYNAME_FIELD = "displayName";
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final String TAG_EXTERNAL_FILES = "external-files-path";
    private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private static final HashMap<String, PathStrategy> sCache = null;
    private String mAuthority;
    private PathStrategy mLocalPathStrategy;
    private final Object mLock;
    private final int mResourceId;

    public FileProvider() {
        this(0);
    }

    @Override // android.content.ContentProvider
    public String getTypeAnonymous(Uri r1) {
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    static {
        COLUMNS = new String[]{"_display_name", "_size"};
        DEVICE_ROOT = new File("/");
        sCache = new HashMap();
    }

    private PathStrategy getLocalPathStrategy() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ObjectsCompat.requireNonNull(this.mAuthority, "mAuthority is null. Did you override attachInfo and did not call super.attachInfo()?");     // Catch: Throwable -> L10
        if (this.mLocalPathStrategy != null) goto L7;
        this.mLocalPathStrategy = getPathStrategy(getContext(), this.mAuthority, this.mResourceId);     // Catch: Throwable -> L10
    L7:
        PathStrategy r1 = this.mLocalPathStrategy;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    public FileProvider(int r2) {
        this.mLock = new Object();
        this.mResourceId = r2;
    }

    public static /* synthetic */ String access$000(String r0) {
        return removeTrailingSlash(r0);
    }

    private static int modeToMode(String r3) {
        if ("r".equals(r3) == false) goto L6;
        return 268435456;
    L6:
        if ("w".equals(r3) == false) goto L8;
    L21:
        return 738197504;
    L8:
        if ("wt".equals(r3) == true) goto L21;
        if ("wa".equals(r3) == false) goto L14;
        return 704643072;
    L14:
        if ("rw".equals(r3) == false) goto L17;
        return 939524096;
    L17:
        if ("rwt".equals(r3) == false) goto L20;
        return 1006632960;
    L20:
        throw new IllegalArgumentException("Invalid mode: " + r3);
    }

    private static String removeTrailingSlash(String r2) {
        if (r2.length() > 0) goto L5;
        return r2;
    L5:
        if (r2.charAt(r2.length() - 1) == '/') goto L7;
        return r2;
    L7:
        return r2.substring(0, r2.length() - 1);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r3) {
        File r4 = getLocalPathStrategy().getFileForUri(r3);
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

    private static File buildPath(File r4, String... r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        String r2 = r5[r1];
        if (r2 == null) goto L7;
        r4 = new File(r4, r2);
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r4;
    }

    private static Object[] copyOf(Object[] r2, int r3) {
        Object[] r0 = new Object[r3];
        System.arraycopy(r2, 0, r0, 0, r3);
        return r0;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context r2, ProviderInfo r3) {
        super.attachInfo(r2, r3);
        if (r3.exported == true) goto L24;
        if (r3.grantUriPermissions == false) goto L22;
        String r4 = r3.authority.split(";")[0];
        Object r5 = this.mLock;
        monitor-enter(r5);
        this.mAuthority = r4;     // Catch: Throwable -> L18
        monitor-exit(r5);     // Catch: Throwable -> L18
        HashMap<String, PathStrategy> r0 = sCache;
        monitor-enter(r0);
        r0.remove(r4);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L18:
        th = move-exception;
        throw th;
    L22:
        throw new SecurityException("Provider must grant uri permissions");
    L24:
        throw new SecurityException("Provider must not be exported");
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri r2, String r3) throws FileNotFoundException {
        return ParcelFileDescriptor.open(getLocalPathStrategy().getFileForUri(r2), modeToMode(r3));
    }

    private static String[] copyOf(String[] r2, int r3) {
        String[] r0 = new String[r3];
        System.arraycopy(r2, 0, r0, 0, r3);
        return r0;
    }

    private static PathStrategy getPathStrategy(Context r2, String r3, int r4) {
        HashMap<String, PathStrategy> r0 = sCache;
        monitor-enter(r0);
        PathStrategy r1 = r0.get(r3);     // Catch: Throwable -> L16
        if (r1 == null) goto L20;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return r1;
    L20:
        r1 = parsePathStrategy(r2, r3, r4);     // Catch: XmlPullParserException -> L8 IOException -> L11 Throwable -> L16
        r0.put(r3, r1);     // Catch: Throwable -> L16
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

    public static Uri getUriForFile(Context r1, String r2, File r3) {
        return getPathStrategy(r1, r2, 0).getUriForFile(r3);
    }

    private static PathStrategy parsePathStrategy(Context r7, String r8, int r9) throws IOException, XmlPullParserException {
        SimplePathStrategy r0 = new SimplePathStrategy(r8);
        XmlResourceParser r10 = getFileProviderPathsMetaData(r7, r8, r7.getPackageManager().resolveContentProvider(r8, 128), r9);
    L3:
        int r11 = r10.next();
        if (r11 == 1) goto L36;
        if (r11 != 2) goto L3;
        String r12 = r10.getName();
        File r3 = null;
        String r2 = r10.getAttributeValue(null, ATTR_NAME);
        String r4 = r10.getAttributeValue(null, ATTR_PATH);
        if (TAG_ROOT_PATH.equals(r12) == false) goto L11;
        r3 = DEVICE_ROOT;
    L34:
        if (r3 == null) goto L3;
        r0.addRoot(r2, buildPath(r3, new String[]{r4}));
        goto L3
    L11:
        if (TAG_FILES_PATH.equals(r12) == false) goto L14;
        r3 = r7.getFilesDir();
        goto L34
    L14:
        if (TAG_CACHE_PATH.equals(r12) == false) goto L17;
        r3 = r7.getCacheDir();
        goto L34
    L17:
        if (TAG_EXTERNAL.equals(r12) == false) goto L20;
        r3 = Environment.getExternalStorageDirectory();
        goto L34
    L20:
        if (TAG_EXTERNAL_FILES.equals(r12) == false) goto L25;
        File[] r13 = ContextCompat.getExternalFilesDirs(r7, null);
        if (r13.length <= 0) goto L34;
        r3 = r13[0];
        goto L34
    L25:
        if (TAG_EXTERNAL_CACHE.equals(r12) == false) goto L30;
        File[] r14 = ContextCompat.getExternalCacheDirs(r7);
        if (r14.length <= 0) goto L34;
        r3 = r14[0];
        goto L34
    L30:
        if (TAG_EXTERNAL_MEDIA.equals(r12) == false) goto L34;
        File[] r15 = Api21Impl.getExternalMediaDirs(r7);
        if (r15.length <= 0) goto L34;
        r3 = r15[0];
        goto L34
    L36:
        return r0;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        return getLocalPathStrategy().getFileForUri(r1).delete() ? 1 : 0;
    }

    public static XmlResourceParser getFileProviderPathsMetaData(Context r2, String r3, ProviderInfo r4, int r5) {
        if (r4 == null) goto L13;
        if (r4.metaData != null) goto L7;
        if (r5 == 0) goto L7;
        Bundle r6 = new Bundle(1);
        r4.metaData = r6;
        r6.putInt(META_DATA_FILE_PROVIDER_PATHS, r5);
    L7:
        XmlResourceParser r7 = r4.loadXmlMetaData(r2.getPackageManager(), META_DATA_FILE_PROVIDER_PATHS);
        if (r7 == null) goto L11;
        return r7;
    L11:
        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    L13:
        throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + r3);
    }

    public static Uri getUriForFile(Context r0, String r1, File r2, String r3) {
        return getUriForFile(r0, r1, r2).buildUpon().appendQueryParameter(DISPLAYNAME_FIELD, r3).build();
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        throw new UnsupportedOperationException("No external updates");
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r7, String[] r8, String r9, String[] r10, String r11) {
        File r12 = getLocalPathStrategy().getFileForUri(r7);
        String r13 = UriProtector.getQueryParameter(r7, DISPLAYNAME_FIELD);
        if (r8 != null) goto L5;
        r8 = COLUMNS;
    L5:
        String[] r14 = new String[r8.length];
        Object[] r15 = new Object[r8.length];
        int r0 = r8.length;
        int r1 = 0;
        int r2 = 0;
    L6:
        if (r1 >= r0) goto L19;
        String r3 = r8[r1];
        if ("_display_name".equals(r3) == false) goto L15;
        r14[r2] = "_display_name";
        int r4 = r2 + 1;
        if (r13 != null) goto L12;
        String r5 = r12.getName();
    L13:
        r15[r2] = r5;
    L17:
        r2 = r4;
    L18:
        r1 = r1 + 1;
        goto L6
    L12:
        r5 = r13;
        goto L13
    L15:
        if ("_size".equals(r3) == false) goto L18;
        r14[r2] = "_size";
        r4 = r2 + 1;
        r15[r2] = Long.valueOf(r12.length());
        goto L17
    L19:
        String[] r16 = copyOf(r14, r2);
        Object[] r17 = copyOf(r15, r2);
        MatrixCursor r18 = new MatrixCursor(r16, 1);
        r18.addRow(r17);
        return r18;
    }
}
