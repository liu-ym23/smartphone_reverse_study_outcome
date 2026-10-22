package com.bytedance.badger.collect.impl.model;

import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.bytedance.badger.collect.impl.interfaces.ISimCardCompliance;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import f06.b;
import f06.c;
import f06.d;
import g06.a;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultSimCardComplianceImpl implements ISimCardCompliance {
    public DefaultSimCardComplianceImpl() {
    }

    @Override // com.bytedance.badger.collect.impl.interfaces.ISimCardCompliance
    public Enumeration<NetworkInterface> getNetworkInterfaces() {
        return NetworkInterface.getNetworkInterfaces();
    L4:
        return null;
    }

    private static String com_bytedance_badger_collect_impl_model_DefaultSimCardComplianceImpl_android_telephony_SubscriptionInfo_getIccId(SubscriptionInfo r110) {
        c r100 = new c();
        Object[] r101 = new Object[0];
        b r111 = new b();
        d r112 = r100.b(101500, "android/telephony/SubscriptionInfo", "getIccId", r110, r101, "java.lang.String", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(101500, "android/telephony/SubscriptionInfo", "getIccId", r110, r101, null, r111, false);
        return (String) r112.f474983b;
    L6:
        String r113 = r110.getIccId();
        r100.a(101500, "android/telephony/SubscriptionInfo", "getIccId", r110, r101, r113, r111, true);
        return r113;
    }

    private static List com_bytedance_badger_collect_impl_model_DefaultSimCardComplianceImpl_android_telephony_SubscriptionManager_getActiveSubscriptionInfoList(SubscriptionManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        b r112 = new b();
        a r101 = ApiHookConfig.f245611b.get(102008);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        d r106 = r105.preInvoke(102008, "android/telephony/SubscriptionManager", "getActiveSubscriptionInfoList", r110, r111, "java.util.List", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (List) r106.f474983b;
    L21:
        return r110.getActiveSubscriptionInfoList();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    private static String com_bytedance_badger_collect_impl_model_DefaultSimCardComplianceImpl_android_telephony_TelephonyManager_getSimOperator(TelephonyManager r110) {
        c r100 = new c();
        Object[] r101 = new Object[0];
        b r111 = new b();
        d r112 = r100.b(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, r110, r101, "java.lang.String", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, r110, r101, null, r111, false);
        return (String) r112.f474983b;
    L6:
        String r113 = r110.getSimOperator();
        r100.a(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, r110, r101, r113, r111, true);
        return r113;
    }

    private static String com_bytedance_badger_collect_impl_model_DefaultSimCardComplianceImpl_android_telephony_TelephonyManager_getSimSerialNumber(TelephonyManager r110) {
        c r100 = new c();
        Object[] r101 = new Object[0];
        b r111 = new b();
        d r112 = r100.b(101400, "android/telephony/TelephonyManager", "getSimSerialNumber", r110, r101, "java.lang.String", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(101400, "android/telephony/TelephonyManager", "getSimSerialNumber", r110, r101, null, r111, false);
        return (String) r112.f474983b;
    L6:
        String r113 = r110.getSimSerialNumber();
        r100.a(101400, "android/telephony/TelephonyManager", "getSimSerialNumber", r110, r101, r113, r111, true);
        return r113;
    }

    @Override // com.bytedance.badger.collect.impl.interfaces.ISimCardCompliance
    public List<SubscriptionInfo> getActiveSubscriptionInfoList(SubscriptionManager r100) {
        if (Build.VERSION.SDK_INT >= 22) goto L5;
        return null;
    L5:
        return com_bytedance_badger_collect_impl_model_DefaultSimCardComplianceImpl_android_telephony_SubscriptionManager_getActiveSubscriptionInfoList(r100);
    }

    @Override // com.bytedance.badger.collect.impl.interfaces.ISimCardCompliance
    public String getIccId(SubscriptionInfo r100) {
        if (Build.VERSION.SDK_INT >= 22) goto L5;
        return "";
    L5:
        return com_bytedance_badger_collect_impl_model_DefaultSimCardComplianceImpl_android_telephony_SubscriptionInfo_getIccId(r100);
    }

    @Override // com.bytedance.badger.collect.impl.interfaces.ISimCardCompliance
    public int getNetworkType(TelephonyManager r100) {
        return r100.getNetworkType();
    }

    @Override // com.bytedance.badger.collect.impl.interfaces.ISimCardCompliance
    public String getSimOperator(TelephonyManager r100) {
        return com_bytedance_badger_collect_impl_model_DefaultSimCardComplianceImpl_android_telephony_TelephonyManager_getSimOperator(r100);
    }

    @Override // com.bytedance.badger.collect.impl.interfaces.ISimCardCompliance
    public String getSimSerialNumber(TelephonyManager r100) {
        return com_bytedance_badger_collect_impl_model_DefaultSimCardComplianceImpl_android_telephony_TelephonyManager_getSimSerialNumber(r100);
    }
}
