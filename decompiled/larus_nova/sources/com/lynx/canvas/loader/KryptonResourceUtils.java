package com.lynx.canvas.loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.canvas.Krypton;
import com.lynx.canvas.KryptonLLog;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Executor;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public class KryptonResourceUtils {
    private static final String ASSET_SCHEME_PREFIX = "asset:///";
    private static final String BASE64_PREFIX = "base64,";
    private static final int BUFFER_MAX_SIZE = 65536;
    private static final int BUFFER_MIN_SIZE = 1024;
    private static final String CONTENT_SCHEMA_PREFIX = "content://";
    private static final String DATA_SCHEMA_PREFIX = "data:";
    private static final String FILE_SCHEME_PREFIX = "file://";
    private static final String HTTPS_SCHEME_PREFIX = "https://";
    private static final String HTTP_SCHEME_PREFIX = "http://";
    private static final String RESOURCE_SCHEME_PREFIX = "res:///";
    private static final String TAG = "KryptonResourceUtils";
    private static volatile Executor sBriefIOExecutor;

    public static final enum KryptonSchemaType extends Enum<KryptonSchemaType> {
        private static final /* synthetic */ KryptonSchemaType[] $VALUES = null;
        public static final KryptonSchemaType CONTENT = null;
        public static final KryptonSchemaType DATAURI = null;
        public static final KryptonSchemaType EMPTY = null;
        public static final KryptonSchemaType INVALID = null;
        public static final KryptonSchemaType LOCAL = null;
        public static final KryptonSchemaType REMOTE = null;

        static {
            KryptonSchemaType r100 = new KryptonSchemaType("EMPTY", 0);
            EMPTY = r100;
            KryptonSchemaType r101 = new KryptonSchemaType("INVALID", 1);
            INVALID = r101;
            KryptonSchemaType r102 = new KryptonSchemaType("REMOTE", 2);
            REMOTE = r102;
            KryptonSchemaType r103 = new KryptonSchemaType(AccountType.LOCAL, 3);
            LOCAL = r103;
            KryptonSchemaType r104 = new KryptonSchemaType("CONTENT", 4);
            CONTENT = r104;
            KryptonSchemaType r105 = new KryptonSchemaType("DATAURI", 5);
            DATAURI = r105;
            $VALUES = new KryptonSchemaType[]{r100, r101, r102, r103, r104, r105};
        }

        public static KryptonSchemaType[] values() {
            return (KryptonSchemaType[]) $VALUES.clone();
        }

        public static KryptonSchemaType valueOf(String r100) {
            return (KryptonSchemaType) a.a(KryptonSchemaType.class, r100);
        }

        private KryptonSchemaType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public KryptonResourceUtils() {
    }

    private static int clamp(int r100, int r101, int r102) {
        if (r100 >= r101) goto L4;
        return r101;
    L4:
        if (r100 <= r102) goto L6;
        return r102;
    L6:
        return r100;
    }

    public static Executor getKryptonIOExecutor() {
        if (sBriefIOExecutor != null) goto L15;
        monitor-enter(KryptonResourceUtils.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sBriefIOExecutor != null) goto L9;
        sBriefIOExecutor = getExecutor("krypton-brief-resource-thread", 5, 3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(KryptonResourceUtils.class);     // Catch: Throwable -> L11
    L15:
        return sBriefIOExecutor;
    }

    private static void closeQuietly(Closeable r100) {
        if (r100 == null) goto L10;
        r100.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        KryptonLLog.e(TAG, "Failed to close resource: " + e.getMessage());
        return;
    }

    public static Bitmap decodeBase64Image(String r100) throws IllegalArgumentException {
        if (schemaType(r100) != KryptonSchemaType.DATAURI) goto L7;
        byte[] r101 = Base64.decode(getDataUrlBase64Content(r100), 0);
        return BitmapFactory.decodeByteArray(r101, 0, r101.length);
    L7:
        throw new IllegalArgumentException("Call decodeBase64Image with invalid path" + r100);
    }

    public static byte[] decodeDataURI(String r100) throws IllegalArgumentException {
        KryptonSchemaType r101 = schemaType(r100);
        if (r101 != KryptonSchemaType.DATAURI) goto L7;
        return Base64.decode(getDataUrlBase64Content(r100), 0);
    L7:
        if (r101 != KryptonSchemaType.EMPTY) goto L11;
        throw new IllegalArgumentException("Call decodeBase64DataUrl with empty path!");
    L11:
        throw new IllegalArgumentException("Call decodeBase64DataUrl with invalid path: " + getTruncatePath(r100));
    }

    private static String getDataUrlBase64Content(String r100) {
        return r100.substring(r100.indexOf(BASE64_PREFIX) + 7);
    }

    public static int getPreferredBufferSize(int r100) {
        return clamp(r100, 1024, 65536);
    }

    public static String getTruncatePath(String r100) {
        int r101 = r100.length();
        if (r101 <= 500) goto L6;
        r101 = 500;
    L6:
        return r100.substring(0, r101);
    }

    public static boolean isContentURI(String r100) {
        if (schemaType(r100) != KryptonSchemaType.CONTENT) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isDataURI(String r100) {
        if (schemaType(r100) != KryptonSchemaType.DATAURI) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isHeif(byte[] r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.length >= 12) goto L8;
        return false;
    L8:
        if (r100[4] == 102) goto L10;
        return false;
    L10:
        if (r100[5] == 116) goto L12;
        return false;
    L12:
        if (r100[6] == 121) goto L14;
        return false;
    L14:
        if (r100[7] != 112) goto L36;
        String r101 = new String(r100, 8, 4);
        if (r101.equals("heic") == false) goto L19;
    L28:
        return true;
    L19:
        if (r101.equals("heix") == true) goto L28;
        if (r101.equals("heim") == true) goto L28;
        if (r101.equals("heis") == true) goto L28;
        if (r101.equals("mif1") == true) goto L28;
        if (r101.equals("msf1") == true) goto L28;
        return false;
    L36:
        return false;
    }

    public static boolean isLocalPath(String r100) {
        if (schemaType(r100) != KryptonSchemaType.LOCAL) goto L5;
        return true;
    L5:
        return false;
    }

    public static InputStream loadResourceFromLocalPath(String r110) {
        KryptonSchemaType r100 = schemaType(r110);
        if (r100 != KryptonSchemaType.LOCAL) goto L5;
    L45:
        Context r101 = Krypton.inst().getContext();     // Catch: Exception -> L42
        if (r101 != null) goto L13;
        KryptonLLog.e(TAG, "Load stream from resource failed with null context: " + r110);     // Catch: Exception -> L42
        return null;
    L13:
        if (r110.startsWith(ASSET_SCHEME_PREFIX) == false) goto L19;
        if (r110.length() <= 9) goto L19;
        KryptonLLog.i(TAG, "Load resource from asset: ".concat(r110));     // Catch: Exception -> L42
        return r101.getAssets().open(r110.substring(9));
    L19:
        if (r110.startsWith(RESOURCE_SCHEME_PREFIX) == false) goto L25;
        if (r110.length() <= 7) goto L25;
        KryptonLLog.i(TAG, "Load resource from res: ".concat(r110));     // Catch: Exception -> L42
        return r101.getResources().openRawResource(r101.getResources().getIdentifier(r110.substring(7), "drawable", r101.getPackageCodePath()));
    L25:
        if (r110.startsWith("file://") == false) goto L35;
        if (r110.length() <= 7) goto L35;
        KryptonLLog.i(TAG, "Load resource from file: ".concat(r110));     // Catch: Exception -> L42
        String r102 = r110.substring(7);     // Catch: Exception -> L42
        if (r102.startsWith(HTTP.URL_DEFAULT) == true) goto L33;
        r102 = HTTP.URL_DEFAULT.concat(r102);     // Catch: Exception -> L42
    L33:
        return new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r102));
    L35:
        if (r110.startsWith(CONTENT_SCHEMA_PREFIX) == true) goto L37;
    L40:
        KryptonLLog.e(TAG, "the url is not available local or content path: ".concat(r110));     // Catch: Exception -> L42
        return null;
    L37:
        if (r110.length() <= 10) goto L40;
        KryptonLLog.i(TAG, "Load resource from content uri: ".concat(r110));     // Catch: Exception -> L42
        return ContentResolverWrapper.openInputStream(r101.getContentResolver(), UriProtector.parse(r110));
    L42:
        e = move-exception;
        KryptonLLog.e(TAG, "Load stream from resource failed, the resource path is: " + r110 + " with error: " + e.getMessage());
        return null;
    L5:
        if (r100 == KryptonSchemaType.CONTENT) goto L45;
        KryptonLLog.e(TAG, "The url is not a local or content path: " + r110);
        return null;
    }

    public static byte[] mergeArray(byte[]... r100) {
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r101 >= r100.length) goto L6;
        r102 = r102 + r100[r101].length;
        r101 = r101 + 1;
        goto L4
    L6:
        byte[] r103 = new byte[r102];
        int r104 = 0;
        int r105 = 0;
    L8:
        if (r104 >= r100.length) goto L14;
        byte[] r106 = r100[r104];
        int r107 = r106.length;
        if (r107 == 0) goto L13;
        System.arraycopy(r106, 0, r103, r105, r107);
        r105 = r105 + r107;
    L13:
        r104 = r104 + 1;
        goto L8
    L14:
        return r103;
    }

    public static KryptonSchemaType schemaType(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return KryptonSchemaType.EMPTY;
    L7:
        if (r100.startsWith(HTTP_SCHEME_PREFIX) == true) goto L33;
        if (r100.startsWith(HTTPS_SCHEME_PREFIX) == true) goto L33;
        if (r100.startsWith(ASSET_SCHEME_PREFIX) == true) goto L31;
        if (r100.startsWith(RESOURCE_SCHEME_PREFIX) == true) goto L31;
        if (r100.startsWith("file://") == true) goto L31;
        if (r100.startsWith(CONTENT_SCHEMA_PREFIX) == false) goto L23;
        return KryptonSchemaType.CONTENT;
    L23:
        if (r100.startsWith("data:") == false) goto L29;
        if (r100.contains(BASE64_PREFIX) == false) goto L29;
        return KryptonSchemaType.DATAURI;
    L29:
        return KryptonSchemaType.INVALID;
    L31:
        return KryptonSchemaType.LOCAL;
    L33:
        return KryptonSchemaType.REMOTE;
    }

    public static byte[] getByteArrayFromInputStream(InputStream r100, int r101) {
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();
        if (copyStream(r100, r102, r101) == true) goto L5;
        return null;
    L5:
        return r102.toByteArray();
    }

    private static boolean copyStream(InputStream r100, OutputStream r101, int r102) {
        if (r100 == null) goto L22;
        if (r101 == null) goto L22;
        int r103 = clamp(r102, 1024, 65536);     // Catch: Throwable -> L14 IOException -> L16
        byte[] r104 = new byte[r103];     // Catch: Throwable -> L14 IOException -> L16
        KryptonLLog.i(TAG, "Start read from stream...");     // Catch: Throwable -> L14 IOException -> L16
    L8:
        int r105 = r100.read(r104, 0, r103);     // Catch: Throwable -> L14 IOException -> L16
        if (r105 == (-1)) goto L11;
        r101.write(r104, 0, r105);     // Catch: Throwable -> L14 IOException -> L16
        goto L8
    L11:
        KryptonLLog.i(TAG, "End read from stream, the total stream content is: " + r102);     // Catch: Throwable -> L14 IOException -> L16
        closeQuietly(r100);
        closeQuietly(r101);
        return true;
    L16:
        e = move-exception;
        KryptonLLog.e(TAG, "Failed to convert to byte array from LynxResResponse: " + e.getMessage());     // Catch: Throwable -> L14
        closeQuietly(r100);
        closeQuietly(r101);
        return false;
    L14:
        th = move-exception;
        closeQuietly(r100);
        closeQuietly(r101);
        throw th;
    L22:
        KryptonLLog.e(TAG, "Invalid input stream or output stream");
        return false;
    }

    private static Executor getExecutor(final String r100, final int r101, int r102) {
        return PThreadExecutorsUtils.newFixedThreadPool(r102, new AnonymousClass1(r100, r101));
    L4:
        th = move-exception;
        KryptonLLog.e(TAG, th.toString());
        return new AnonymousClass2();
    }
}
