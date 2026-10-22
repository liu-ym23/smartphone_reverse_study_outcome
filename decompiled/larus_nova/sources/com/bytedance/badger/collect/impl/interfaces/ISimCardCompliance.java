package com.bytedance.badger.collect.impl.interfaces;

import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface ISimCardCompliance {
    List<SubscriptionInfo> getActiveSubscriptionInfoList(SubscriptionManager r100);

    String getIccId(SubscriptionInfo r100);

    Enumeration<NetworkInterface> getNetworkInterfaces();

    int getNetworkType(TelephonyManager r100);

    String getSimOperator(TelephonyManager r100);

    String getSimSerialNumber(TelephonyManager r100);
}
