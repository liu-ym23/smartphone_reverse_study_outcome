package ww7;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.hihonor.push.framework.aidl.entity.RequestHeader;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.hihonor.push.sdk.ipc.HonorApiAvailability$PackageStates;
import java.io.Closeable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public static String e(byte[] r100) {
        if (r100.length == 0) goto L12;
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L11;
        String r104 = Integer.toHexString(r100[r103] & UByte.MAX_VALUE);
        if (r104.length() != 1) goto L9;
        r101.append('0');
    L9:
        r101.append(r104);
        r103 = r103 + 1;
        goto L5
    L11:
        return r101.toString();
    L12:
        return "";
    }

    public static byte[] i(String r110) {
        if (TextUtils.isEmpty(r110) == true) goto L5;
        String r111 = r110.toUpperCase(Locale.ENGLISH);
        int r100 = r111.length() / 2;
        byte[] r101 = new byte[r100];
        byte[] r112 = r111.getBytes(StandardCharsets.UTF_8);     // Catch: NumberFormatException -> L11
        int r102 = 0;
    L8:
        if (r102 >= r100) goto L13;
        StringBuilder r103 = new StringBuilder();     // Catch: NumberFormatException -> L11
        r103.append("0x");     // Catch: NumberFormatException -> L11
        int r104 = r102 * 2;     // Catch: NumberFormatException -> L11
        r103.append(new String(new byte[]{r112[r104]}, StandardCharsets.UTF_8));     // Catch: NumberFormatException -> L11
        r101[r102] = (byte) (((byte) (Byte.decode(r103.toString()).byteValue() << 4)) ^ Byte.decode("0x" + new String(new byte[]{r112[r104 + 1]}, StandardCharsets.UTF_8)).byteValue());     // Catch: NumberFormatException -> L11
        r102 = r102 + 1;
    L13:
        return r101;
    L11:
        e = move-exception;
        e.getMessage();
        goto L13
    L5:
        return new byte[0];
    }

    public static RequestHeader a() throws ApiException {
        Context r100 = c0.f561643e.a();
        Object r101 = r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 128).metaData.get("com.hihonor.push.app_id");     // Catch: PackageManager.NameNotFoundException -> L7
        if (r101 == null) goto L8;
        String r102 = String.valueOf(r101);     // Catch: PackageManager.NameNotFoundException -> L7
    L10:
        if (TextUtils.isEmpty(r102) == true) goto L36;
        String r103 = d(r100, r100.getPackageName());
        if (TextUtils.isEmpty(r103) == true) goto L34;
        RequestHeader r104 = new RequestHeader();
        r104.setPackageName(r100.getPackageName());
        r104.setAppId(r102);
        r104.setCertificateFingerprint(r103);
        n r105 = n.f561683b;
        r104.setPushToken(r105.b(r100));
        monitor-enter(r105);
    L31:
        th = move-exception;
        throw th;
    L16:
        if (n.f561682a != null) goto L20;
        n.f561682a = new w(r100);     // Catch: Throwable -> L31
    L20:
        SharedPreferences r106 = n.f561682a.f561721a;     // Catch: Throwable -> L31
        if (r106 == null) goto L24;
        String r107 = r106.getString("key_aaid", "");     // Catch: Throwable -> L31
    L26:
        if (TextUtils.isEmpty(r107) == false) goto L28;
        r107 = UUID.randomUUID().toString().replace("-", "");     // Catch: Throwable -> L31
        n.f561682a.b("key_aaid", r107);     // Catch: Throwable -> L31
    L28:
        monitor-exit(r105);
        r104.setAAID(r107);
        r104.setSdkVersion(70061303);
        return r104;
    L24:
        r107 = "";
        goto L26
    L34:
        k.a("checkPushConfig Parameter is missing.");
        throw HonorPushErrorEnum.ERROR_CERT_FINGERPRINT_EMPTY.toApiException();
    L36:
        k.a("checkPushConfig Parameter is missing");
        throw HonorPushErrorEnum.ERROR_NO_APPID.toApiException();
    L8:
        r102 = null;
    L7:
        k.b("getPushAppId");
        goto L8
    }

    public static ApiException b(Exception r100) {
        if ((r100.getCause() instanceof ApiException) == false) goto L6;
        return (ApiException) r100.getCause();
    L6:
        if ((r100 instanceof ApiException) == false) goto L9;
        return (ApiException) r100;
    L9:
        return new ApiException(-1, r100.getMessage());
    }

    public static Object c(e r100) throws ExecutionException, InterruptedException {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L20;
        Object r101 = r100.f561648a;
        monitor-enter(r101);
        boolean r102 = r100.f561649b;     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
        if (r102 == true) goto L11;
        w0 r103 = new w0();
        h0 r104 = h0.f561662c;
        r100.b(new u0(r104.f561663a, r103));
        r100.b(new q0(r104.f561663a, r103));
        r100.b(new j0(r104.f561663a));
        r103.f561722a.await();
    L11:
        if (r100.f() == false) goto L15;
        return r100.d();
    L15:
        throw new ExecutionException(r100.c());
    L16:
        th = move-exception;
        throw th;
    L20:
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    public static xw7.a f(Context r100) {
        xw7.a r101 = new xw7.a();
        Intent r102 = new Intent();
        r102.setComponent(new ComponentName("android", "com.hihonor.android.pushagentproxy.HiPushService"));
        List<ResolveInfo> r103 = r100.getPackageManager().queryIntentServices(r102, 128);
        if (r103.size() <= 0) goto L7;
        Iterator<ResolveInfo> r104 = r103.iterator();
        if (r104.hasNext() == false) goto L7;
        ResolveInfo r105 = r104.next();
        String r106 = r105.serviceInfo.applicationInfo.packageName;
        String r107 = d(r100, r106);
        r101.f565258a = r106;
        r101.f565260c = r105.serviceInfo.name;
        r101.f565259b = r107;
    L7:
        return r101;
    }

    public static void g(Handler r100) {
        if (Looper.myLooper() != r100.getLooper()) goto L6;
        return;
    L6:
        throw new IllegalStateException("Must be called on the handler thread");
    }

    public static void h(Closeable r100) {
        r100.close();     // Catch: Exception -> L4
        return;
    L4:
        k.b("close");
    }

    public static int j(Context r100) {
        if (r100 == null) goto L29;
        xw7.a r101 = f(r100);
        String r102 = r101.f565258a;
        if (TextUtils.isEmpty(r102) == false) goto L31;
        HonorApiAvailability$PackageStates r103 = HonorApiAvailability$PackageStates.NOT_INSTALLED;
    L13:
        if (HonorApiAvailability$PackageStates.NOT_INSTALLED.equals(r103) == false) goto L17;
        return 8002008;
    L17:
        if (HonorApiAvailability$PackageStates.DISABLED.equals(r103) == false) goto L21;
        return 8002007;
    L21:
        if (TextUtils.equals(r102, "android") == true) goto L23;
        return 8002006;
    L23:
        if (TextUtils.isEmpty(r101.f565259b) == false) goto L25;
        return 8002006;
    L25:
        return HonorPushErrorEnum.SUCCESS.statusCode;
    L31:
    L11:
        r103 = HonorApiAvailability$PackageStates.NOT_INSTALLED;
        goto L13
    L7:
        if (r100.getPackageManager().getApplicationInfo(r102, 0).enabled == false) goto L9;
        r103 = HonorApiAvailability$PackageStates.ENABLED;     // Catch: PackageManager.NameNotFoundException -> L11
    L30:
        goto L13
    L9:
        r103 = HonorApiAvailability$PackageStates.DISABLED;     // Catch: PackageManager.NameNotFoundException -> L11
        goto L30
    L29:
        throw new NullPointerException("context must not be null.");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x003a -> B:19:0x003b). Please report as a decompilation issue!!! */
    public static String d(Context r110, String r111) {
        ArrayList r100 = new ArrayList();
        PackageManager r112 = r110.getPackageManager();
        if (Build.VERSION.SDK_INT < 30) goto L13;
        PackageInfo r113 = r112.getPackageInfo(r111, AMapEngineUtils.HALF_MAX_P20_WIDTH);     // Catch: PackageManager.NameNotFoundException -> L17
        if (r113 == null) goto L18;
        SigningInfo r114 = r113.signingInfo;     // Catch: PackageManager.NameNotFoundException -> L17
        if (r114 == null) goto L18;
        if (r114.hasMultipleSigners() == false) goto L12;
        Signature[] r115 = r114.getApkContentsSigners();     // Catch: PackageManager.NameNotFoundException -> L17
    L19:
        if (r115 == null) goto L39;
        if (r115.length <= 0) goto L39;
        int r101 = r115.length;
        int r102 = 0;
    L24:
        if (r102 >= r101) goto L39;
        byte[] r103 = MessageDigest.getInstance("SHA256").digest(r115[r102].toByteArray());     // Catch: NoSuchAlgorithmException -> L34
        StringBuilder r104 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L34
        int r105 = r103.length;     // Catch: NoSuchAlgorithmException -> L34
        int r106 = 0;
    L27:
        if (r106 >= r105) goto L32;
        String r107 = Integer.toHexString(r103[r106] & UByte.MAX_VALUE).toUpperCase(Locale.ENGLISH);     // Catch: NoSuchAlgorithmException -> L34
        if (r107.length() != 1) goto L31;
        r104.append("0");     // Catch: NoSuchAlgorithmException -> L34
    L31:
        r104.append(r107);     // Catch: NoSuchAlgorithmException -> L34
        r106 = r106 + 1;     // Catch: NoSuchAlgorithmException -> L34
        goto L27
    L32:
        String r108 = r104.toString();     // Catch: NoSuchAlgorithmException -> L34
    L35:
        if (r108 != null) goto L36;
        r102 = r102 + 1;
        goto L24
    L36:
        r100.add(r108);
    L34:
        r108 = null;
    L39:
        if (r100.isEmpty() == false) goto L42;
        return null;
    L42:
        return (String) ListProtector.get(r100, 0);
    L12:
        r115 = r114.getSigningCertificateHistory();     // Catch: PackageManager.NameNotFoundException -> L17
        goto L19
    L13:
        PackageInfo r116 = r112.getPackageInfo(r111, 64);     // Catch: PackageManager.NameNotFoundException -> L17
        if (r116 == null) goto L18;
        r115 = r116.signatures;     // Catch: PackageManager.NameNotFoundException -> L17
    L18:
        r115 = null;
        goto L19
    }
}
