package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes15.dex */
class WsChannelEnableObserver implements IEnableObserver {
    private final Context mContext;
    private final Handler mHandler;
    private IEnableObserver.OnWsChannelEnableChangedObserver mObserver;
    private boolean mPushSdkEnabled;
    private ContentObserver mPushSdkEnabledObserver;

    private void handlePushSdkEnabled() {
        boolean r100 = this.mPushSdkEnabled;     // Catch: Exception -> L8
        loadPushSdkEnabled();     // Catch: Exception -> L8
        boolean r101 = this.mPushSdkEnabled;     // Catch: Exception -> L8
        if (r100 == r101) goto L11;
        IEnableObserver.OnWsChannelEnableChangedObserver r102 = this.mObserver;     // Catch: Exception -> L8
        if (r102 == null) goto L12;
        r102.onWsChannelEnableChange(r101);     // Catch: Exception -> L8
        return;
    L12:
        return;
    L11:
        return;
    }

    private void loadPushSdkEnabled() {
        boolean r100 = WsChannelSettings.inst(this.mContext).isEnable();     // Catch: Throwable -> L10
        if (Logger.debug() == false) goto L7;
        Logger.d("WsChannelService", "pushSdkEnabled = " + r100);     // Catch: Throwable -> L10
    L7:
        if (r100 == this.mPushSdkEnabled) goto L13;
        this.mPushSdkEnabled = r100;     // Catch: Throwable -> L10
        return;
    L13:
        return;
    }

    private void registerContentObservers() {
        this.mContext.getContentResolver().registerContentObserver(WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, WsConstants.KEY_FRONTIER_ENABLED, "boolean"), true, this.mPushSdkEnabledObserver);     // Catch: Throwable -> L4
        return;
    }

    @Override // com.bytedance.common.wschannel.server.IEnableObserver
    public void startLoad() {
        loadPushSdkEnabled();
        final Handler r100 = this.mHandler;
        this.mPushSdkEnabledObserver = new AnonymousClass1(this, r100);
        registerContentObservers();
    }

    @Override // com.bytedance.common.wschannel.server.IEnableObserver
    public boolean isEnable() {
        return this.mPushSdkEnabled;
    }

    public static /* synthetic */ void access$000(WsChannelEnableObserver r100) {
        r100.handlePushSdkEnabled();
    }

    @Override // com.bytedance.common.wschannel.server.IEnableObserver
    public void setEnableListener(IEnableObserver.OnWsChannelEnableChangedObserver r100) {
        this.mObserver = r100;
    }

    public WsChannelEnableObserver(Context r100, Handler r101) {
        this.mHandler = r101;
        this.mContext = r100;
    }
}
