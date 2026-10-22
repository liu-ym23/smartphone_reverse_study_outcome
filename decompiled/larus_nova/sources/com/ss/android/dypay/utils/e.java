package com.ss.android.dypay.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.android.ttcjpaysdk.integrated.counter.outerpay.IntegratedOuterPayRooter;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.dypay.activity.DyPayEntranceActivity;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f408484a;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f408485a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f408486b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f408487c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f408488d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ a[] f408489e = null;

        static {
            a r100 = new a("AWEME_AVAILABLE", 0);
            f408485a = r100;
            a r101 = new a("AWEME_LITE_AVAILABLE", 1);
            f408486b = r101;
            a r102 = new a("AWEME_HOTSOON_AVAILABLE", 2);
            f408487c = r102;
            a r103 = new a("UNAVAILABLE", 3);
            f408488d = r103;
            f408489e = new a[]{r100, r101, r102, r103};
        }

        public a(String r100, int r101) {
            super(r100, r101);
        }

        public static a valueOf(String r100) {
            return (a) r27.a.a(a.class, r100);
        }

        public static a[] values() {
            return (a[]) f408489e.clone();
        }
    }

    static {
    }

    public static Boolean c(DyPayEntranceActivity r100, String r101) {
        Uri r102 = Uri.parse(r101);     // Catch: Throwable -> L24
        if (r100 == null) goto L8;
        ContentResolver r103 = r100.getContentResolver();     // Catch: Throwable -> L24
        if (r103 == null) goto L8;
        Cursor r104 = d(r103, r102);     // Catch: Throwable -> L24
    L9:
        if (r104 == null) goto L11;
        r104.moveToFirst();     // Catch: Throwable -> L24
    L11:
        if (r104 == null) goto L13;
        String r105 = r104.getString(0);     // Catch: Throwable -> L24
    L14:
        if (r104 == null) goto L17;
        r104.close();     // Catch: Throwable -> L24
    L17:
        if (Intrinsics.areEqual(r105, "1") == false) goto L21;
        return Boolean.TRUE;
    L21:
        if (Intrinsics.areEqual(r105, "0") == true) goto L23;
    L26:
        return null;
    L23:
        return Boolean.FALSE;
    L13:
        r105 = null;
    L8:
        r104 = null;
    L24:
        th = move-exception;
        th.getStackTrace();
        goto L26
    }

    public static boolean b(Context r100, String r101) {
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        boolean r103 = true ^ r102;
        Long r104 = null;
        if (r103 == true) goto L14;
        r101 = null;
    L14:
        if (r101 != null) goto L31;
        String r105 = f408484a;
        if (r105 == null) goto L29;
        int r106 = r105.hashCode();
        if (r106 == (-557969986)) goto L27;
        if (r106 != 0) goto L29;
        if (r105.equals("") == false) goto L29;
        r101 = "ttcjpay://dypay/cashier";
        goto L31
    L27:
        if (r105.equals(IntegratedOuterPayRooter.INTEGRATED_SIGN_AND_PAY) == false) goto L29;
        r101 = "ttcjpay://dypay/sign";
    L29:
        r101 = "dypay://aweme";
    L31:
        if (Intrinsics.areEqual(r101, "dypay://aweme") == false) goto L36;
        if (vta.d.f557262c == false) goto L36;
        r104 = 230900L;
    L36:
        return a(r100, "com.ss.android.ugc.aweme", r101, r104);
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static Cursor d(ContentResolver r110, Uri r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, null, null, null, null};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r112, false);
        return (Cursor) r113.f474983b;
    L6:
        Cursor r114 = r110.query(r111, null, null, null, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r114, r112, true);
        return r114;
    }

    public static a e(Context r100, String r101) {
        int r102 = 0;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
    L13:
        r101 = "123";
    L14:
        int r104 = r101.length();
    L15:
        if (r102 >= r104) goto L33;
        switch(r101.charAt(r102)) {
            case 49: goto L28;
            case 50: goto L24;
            case 51: goto L20;
            default: goto L31;
        };
    L20:
        if (a(r100, "com.ss.android.ugc.live", "dypay8663://dypay/cashier", null) == false) goto L31;
        return a.f408487c;
    L24:
        if (a(r100, "com.ss.android.ugc.aweme.lite", "ttcjpay://dypay/awemelite", null) == false) goto L31;
        return a.f408486b;
    L28:
        if (b(r100, null) == false) goto L31;
        return a.f408485a;
    L31:
        r102 = r102 + 1;
        goto L15
    L33:
        return a.f408488d;
    L12:
        if (CollectionsKt.listOf(new String[]{"123", BDLocationException.ERROR_CODE_EXCEPTION, "213", "231", "312", "321"}).contains(r101) == true) goto L14;
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public static JSONObject f(Context r100, String r101) {
        String r102 = "";
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r101.length() != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L41;
        JSONObject r104 = new JSONObject();
        PackageInfo r105 = r100.getPackageManager().getPackageInfo(r101, 0);     // Catch: Exception -> L34
        if (Build.VERSION.SDK_INT < 28) goto L16;
        Object r106 = Long.valueOf(r105.getLongVersionCode());     // Catch: Exception -> L34
    L17:
        r104.put("version_code", r106);     // Catch: Exception -> L34
        r104.put("version_name", r105.versionName);     // Catch: Exception -> L34
        long r107 = r105.firstInstallTime;     // Catch: Exception -> L34
        String r108 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(r107));     // Catch: Exception -> L24
    L25:
        r104.put("first_install_time", r108);     // Catch: Exception -> L34
        long r109 = r105.lastUpdateTime;     // Catch: Exception -> L34
        r102 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(r109));     // Catch: Exception -> L33
    L29:
        r104.put("last_update_time", r102);     // Catch: Exception -> L34
    L24:
        r108 = "";
        goto L25
    L16:
        r106 = Integer.valueOf(r105.versionCode);     // Catch: Exception -> L34
    L30:
        return r104;
    L41:
        return null;
    L7:
        r103 = false;
        goto L8
    }

    public static boolean a(Context r110, String r111, String r112, Long r113) {
        Long r100 = null;
        if (r110 != null) goto L75;
    L39:
        boolean r101 = false;
    L40:
        if (r110 == null) goto L45;
        Intent r102 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        r102.setData(UriProtector.parse(r112));
        if (r102.resolveActivity(r110.getPackageManager()) == null) goto L45;
        boolean r114 = true;
    L46:
        if (r113 == null) goto L68;
        long r103 = r113.longValue();
        if (r110 != null) goto L50;
    L62:
        if (r100 == null) goto L68;
        long r115 = r100.longValue();
        if (String.valueOf(r115).length() != String.valueOf(r103).length()) goto L68;
        if (r115 >= r103) goto L68;
        boolean r116 = false;
    L69:
        if (r101 == false) goto L73;
        if (r114 == false) goto L73;
        if (r116 == false) goto L73;
        return true;
    L73:
        return false;
    L50:
        if (r111.length() != 0) goto L52;
        boolean r117 = true;
    L53:
        if (r117 == true) goto L62;
        PackageInfo r118 = r110.getPackageManager().getPackageInfo(r111, 0);     // Catch: Exception -> L61
        if (Build.VERSION.SDK_INT < 28) goto L58;
        long r119 = r118.getLongVersionCode();     // Catch: Exception -> L61
    L59:
        r100 = Long.valueOf(r119);     // Catch: Exception -> L61
        goto L62
    L58:
        r119 = r118.versionCode;     // Catch: Exception -> L61
        goto L59
    L52:
        r117 = false;
    L68:
        r116 = true;
    L45:
        r114 = false;
        goto L46
    L75:
        if (r110.getPackageManager().getApplicationInfo(r111, 0) == null) goto L39;
        Map<String, vta.b> r104 = vta.d.f557261b;     // Catch: Exception -> L36
        if (r104.isEmpty() == true) goto L19;
        Map.Entry r105 = (Map.Entry) CollectionsKt.firstOrNull(((LinkedHashMap) r104).entrySet());     // Catch: Exception -> L36
        if (r105 == null) goto L13;
        vta.b r106 = (vta.b) r105.getValue();     // Catch: Exception -> L36
    L14:
        if (r106 == null) goto L19;
        if (r106.f557248a.f557286n != true) goto L19;
        boolean r107 = true;
    L20:
        List<PackageInstaller.SessionInfo> r108 = r110.getPackageManager().getPackageInstaller().getAllSessions();     // Catch: Exception -> L36
        if ((r108 instanceof Collection) == true) goto L23;
    L25:
        Iterator<T> r109 = r108.iterator();     // Catch: Exception -> L36
    L27:
        if (r109.hasNext() == false) goto L31;
        if (TextUtils.equals(((PackageInstaller.SessionInfo) r109.next()).getAppPackageName(), r111) == false) goto L27;
        r101 = false;
    L32:
        if (r101 == true) goto L34;
        sta.a.e("api", "app_is_installing", null, null, null, 60);     // Catch: Exception -> L36
    L34:
        if (r107 == true) goto L40;
    L31:
        r101 = true;
        goto L32
    L23:
        if (r108.isEmpty() == false) goto L25;
    L13:
        r106 = null;
    L19:
        r107 = false;
    L37:
        r101 = true;
        goto L40
    }
}
