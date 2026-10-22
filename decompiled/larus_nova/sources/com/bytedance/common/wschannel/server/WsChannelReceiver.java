package com.bytedance.common.wschannel.server;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.common.wschannel.WsChannelSettings;

/* JADX INFO: loaded from: classes3.dex */
public class WsChannelReceiver extends BroadcastReceiver {
    private static boolean sFrontierEnabled;
    private boolean mIsFirstTimeReceiveNetChangedAction;
    private ChannelManager mManager;
    private NetworkUtils.NetworkType mOnCreateNetworkType;

    public WsChannelReceiver() {
        this.mIsFirstTimeReceiveNetChangedAction = true;
    }

    public static /* synthetic */ boolean access$100() {
        return sFrontierEnabled;
    }

    public static /* synthetic */ ChannelManager access$200(WsChannelReceiver r100) {
        return r100.mManager;
    }

    private void loadFrontierEnabled(Context r100) {
        boolean r101 = WsChannelSettings.inst(r100).isEnable();     // Catch: Throwable -> L6
        if (r101 == sFrontierEnabled) goto L9;
        sFrontierEnabled = r101;     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public WsChannelReceiver(Context r100, ChannelManager r101) {
        this.mIsFirstTimeReceiveNetChangedAction = true;
        this.mOnCreateNetworkType = NetworkUtils.getNetworkType(r100);
        this.mManager = r101;
    }

    public static /* synthetic */ void access$000(WsChannelReceiver r100, Context r101) {
        r100.loadFrontierEnabled(r101);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context r100, Intent r101) {
        if (r100 == null) goto L20;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.mManager != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r101.getAction()) == false) goto L11;
        return;
    L11:
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r101.getAction()) == true) goto L14;
        return;
    L14:
        if (this.mIsFirstTimeReceiveNetChangedAction == false) goto L18;
        this.mIsFirstTimeReceiveNetChangedAction = false;
        if (NetworkUtils.getNetworkType(r100) != this.mOnCreateNetworkType) goto L18;
        return;
    L18:
        ThreadPlus.submitRunnable(new AnonymousClass1(this, r100));
        return;
    }
}
