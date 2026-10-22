package com.bytedance.upc.cache;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements f06.a {
    public a() {
    }

    @Override // f06.a
    public final f06.d preInvoke(int r100, String r101, String r102, Object r103, Object[] r104, String r105, f06.b r106) {
        AtomicBoolean r107 = c.f272454a;
    L45:
        th = move-exception;
        th.toString();
        boolean r108 = ip7.b.f495310a;
    L47:
        Pair<Boolean, String> r109 = new Pair(Boolean.FALSE, null);
    L49:
        return new f06.d(((Boolean) r109.first).booleanValue(), r109.second);
    L4:
        if (r101.contains("android/telephony/TelephonyManager") == false) goto L9;
        if (r102.contains("getImei") == false) goto L9;
        r109 = c.c();     // Catch: Throwable -> L45
    L9:
        if (r101.contains("android/telephony/TelephonyManager") == false) goto L14;
        if (r102.contains("getDeviceId") == false) goto L14;
        r109 = c.b();     // Catch: Throwable -> L45
    L14:
        if (r101.contains("android/telephony/TelephonyManager") == false) goto L19;
        if (r102.contains(BpeaManager.getSimOperator) == false) goto L19;
        r109 = new Pair(Boolean.FALSE, null);     // Catch: Throwable -> L45
    L19:
        if (r101.equals("android/net/wifi/WifiInfo") == false) goto L24;
        if (r102.equals("getMacAddress") == false) goto L24;
        r109 = new Pair(Boolean.FALSE, null);     // Catch: Throwable -> L45
    L24:
        if (r101.equals("java/net/NetworkInterface") == false) goto L29;
        if (r102.equals("getHardwareAddress") == false) goto L29;
        r109 = new Pair(Boolean.FALSE, null);     // Catch: Throwable -> L45
    L29:
        if (r101.equals("com/bytedance/bdinstall/oaid") == true) goto L33;
        if (r101.equals("com/ss/android/deviceregister/base/Oaid") == true) goto L33;
    L36:
        if (r101.equals("android/provider/Settings$System") == true) goto L40;
        if (r101.equals("android/provider/Settings$Secure") == false) goto L47;
    L40:
        if (r102.equals("getString") == false) goto L47;
        if (TextUtils.equals("android_id", (String) r104[1]) == false) goto L47;
        new Pair(Boolean.FALSE, null);     // Catch: Throwable -> L45
    L33:
        if (r102.equals("getOaidId") == false) goto L36;
        r109 = new Pair(Boolean.FALSE, null);     // Catch: Throwable -> L45
        goto L49
    }

    @Override // f06.a
    public final void postInvoke(int r100, String r101, String r102, Object r103, Object[] r104, Object r105, f06.b r106, boolean r107) {
        AtomicBoolean r108 = c.f272454a;
        if (r105 == null) goto L62;
    L58:
        th = move-exception;
        th.toString();
        boolean r109 = ip7.b.f495310a;
        return;
    L5:
        if (r101.contains("android/telephony/TelephonyManager") == false) goto L12;
        if (r102.contains("getImei") == false) goto L12;
        String r110 = (String) r105;     // Catch: Throwable -> L58
        if (TextUtils.isEmpty(r110) == true) goto L63;
        b.f272453c.c("upc_cache_imei", r110);     // Catch: Throwable -> L58
        Set<String> r111 = ApiHookRecord.f272434a;     // Catch: Throwable -> L58
        ApiHookRecord.e("IMEI", r110);     // Catch: Throwable -> L58
        return;
    L63:
        return;
    L12:
        if (r101.contains("android/telephony/TelephonyManager") == false) goto L19;
        if (r102.contains("getDeviceId") == false) goto L19;
        String r112 = (String) r105;     // Catch: Throwable -> L58
        if (TextUtils.isEmpty(r112) == true) goto L65;
        b.f272453c.c("upc_cache_deviceid", r112);     // Catch: Throwable -> L58
        Set<String> r113 = ApiHookRecord.f272434a;     // Catch: Throwable -> L58
        ApiHookRecord.e("DEVICE_ID", r112);     // Catch: Throwable -> L58
        return;
    L65:
        return;
    L19:
        if (r101.contains("android/telephony/TelephonyManager") == false) goto L26;
        if (r102.contains(BpeaManager.getSimOperator) == false) goto L26;
        String r114 = (String) r105;     // Catch: Throwable -> L58
        if (TextUtils.isEmpty(r114) == true) goto L67;
        Set<String> r115 = ApiHookRecord.f272434a;     // Catch: Throwable -> L58
        ApiHookRecord.e("IMSI", r114);     // Catch: Throwable -> L58
        return;
    L67:
        return;
    L26:
        if (r101.equals("android/net/wifi/WifiInfo") == false) goto L31;
        if (r102.equals("getMacAddress") == false) goto L31;
        c.a(r105);     // Catch: Throwable -> L58
        return;
    L31:
        if (r101.equals("java/net/NetworkInterface") == false) goto L36;
        if (r102.equals("getHardwareAddress") == false) goto L36;
        c.a(r105);     // Catch: Throwable -> L58
        return;
    L36:
        if (r101.equals("com/bytedance/bdinstall/oaid/Oaid") == true) goto L40;
        if (r101.equals("com/ss/android/deviceregister/base/Oaid") == true) goto L40;
    L47:
        if (r101.equals("android/provider/Settings$System") == true) goto L51;
        if (r101.equals("android/provider/Settings$Secure") == true) goto L51;
        return;
    L51:
        if (r102.equals("getString") == true) goto L53;
        return;
    L53:
        if (TextUtils.equals("android_id", (String) r104[1]) == false) goto L76;
        String r116 = (String) r105;     // Catch: Throwable -> L58
        if (TextUtils.isEmpty(r116) == true) goto L77;
        Set<String> r117 = ApiHookRecord.f272434a;     // Catch: Throwable -> L58
        ApiHookRecord.e("ANDROID_ID", r116);     // Catch: Throwable -> L58
        return;
    L77:
        return;
    L76:
        return;
    L40:
        if (r102.equals("getOaidId") == false) goto L47;
        String r118 = (String) r105;     // Catch: Throwable -> L58
        if (c.f272454a.compareAndSet(false, true) == true) goto L44;
        return;
    L44:
        if (TextUtils.isEmpty(r118) == true) goto L72;
        Set<String> r119 = ApiHookRecord.f272434a;     // Catch: Throwable -> L58
        ApiHookRecord.e("OAID", r118);     // Catch: Throwable -> L58
        return;
    L72:
        return;
    }
}
