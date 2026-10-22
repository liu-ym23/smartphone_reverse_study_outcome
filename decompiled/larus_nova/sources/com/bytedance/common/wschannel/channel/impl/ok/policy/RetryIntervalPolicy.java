package com.bytedance.common.wschannel.channel.impl.ok.policy;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import okhttp3.Response;

/* JADX INFO: loaded from: classes15.dex */
public class RetryIntervalPolicy implements RetryPolicy {
    private final Context mContext;
    private int mReconnectTimes;

    @Override // com.bytedance.common.wschannel.channel.impl.ok.policy.RetryPolicy
    public void reset() {
        this.mReconnectTimes = 0;
    }

    public long getNextRetryInterval() {
        if (isNetworkAvailable(this.mContext) == true) goto L6;
        return -1;
    L6:
        int r100 = this.mReconnectTimes + 1;
        this.mReconnectTimes = r100;
        return (long) (Math.min(((long) (1 << r100)) * 5000, 120000) + ((Math.random() * 10.0d) * 1000.0d));
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.policy.RetryPolicy
    public long getRandomInterval() {
        return (long) ((Math.random() * 4500.0d) + 500.0d);
    }

    public RetryIntervalPolicy(Context r100) {
        this.mReconnectTimes = 0;
        this.mContext = r100;
    }

    private static boolean isNetworkAvailable(Context r100) {
        NetworkInfo r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r101 == null) goto L12;
        if (r101.isAvailable() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.policy.RetryPolicy
    public long getRetryIntervalWithResponse(Response r110) {
        long r100 = getNextRetryInterval();
        if (r100 != (-1)) goto L5;
        return -1;
    L5:
        if (r110 != null) goto L30;
    L28:
        return r100;
    L30:
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L7:
        if (r110.isSuccessful() == true) goto L28;
        int r101 = r110.code();     // Catch: Exception -> L26
        if (r101 != 414) goto L11;
    L14:
        String r111 = r110.header("Handshake-Options");     // Catch: Exception -> L26
        if (r111 == null) goto L28;
        String[] r112 = r111.split(i.f25853b);     // Catch: Exception -> L26
        int r102 = r112.length;     // Catch: Exception -> L26
        int r103 = 0;
    L17:
        if (r103 >= r102) goto L28;
        String r104 = r112[r103];     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r104) == true) goto L25;
        String[] r105 = r104.split(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L26
        if ("reconnect-interval".equals(r105[0]) == false) goto L25;
        String r106 = r105[1];     // Catch: Exception -> L26
        Logger.d("WsChannelSdk_ok", "override retry interval");     // Catch: Exception -> L26
        r100 = CastLongProtector.parseLong(r106) * 1000;     // Catch: NumberFormatException -> L29 Exception -> L26
        Logger.d("WsChannelSdk_ok", "read response hand shake option : reconnect-interval:" + r100 + " ms");     // Catch: NumberFormatException -> L29 Exception -> L26
    L25:
        r103 = r103 + 1;
        goto L17
    L11:
        if (r101 == 511) goto L14;
        if (r101 != 512) goto L28;
        goto L14
    }
}
