package com.bytedance.push.sync;

import android.content.Context;
import android.util.Log;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.third.IPushAdapter;
import com.bytedance.push.third.PushChannelHelper;
import com.bytedance.sync.SyncSDK;
import com.bytedance.sync.a;
import com.ss.android.message.AppProvider;
import h87.b;

/* JADX INFO: loaded from: classes3.dex */
public class SyncPushAdapter implements IPushAdapter {
    private static int SYNC_PUSH = -1;

    public SyncPushAdapter() {
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public boolean checkThirdPushConfig(String r100, Context r101) throws Exception {
        return true;
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public boolean requestRemoveVoipNotification(Context r100, int r101) {
        return false;
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public void setAlias(Context r100, String r101, int r102) {
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public void trackPush(Context r100, int r101, Object r102) {
    }

    public static int getSyncPush() {
        if (SYNC_PUSH != (-1)) goto L6;
        SYNC_PUSH = PushChannelHelper.inst(AppProvider.getApp()).getChannelId(SyncPushAdapter.class.getName());
    L6:
        return SYNC_PUSH;
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public boolean isPushAvailable(Context r100, int r101) {
        b.b(r100).getClass();
        if (b.a() == null) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public void registerPush(Context r100, int r101) {
        b r102 = b.b(r100);
        r102.getClass();
    L9:
        th = move-exception;
        PushSupporter.monitor().monitorRegisterSenderFailed(getSyncPush(), -1, "-1", Log.getStackTraceString(th));
        return;
    L4:
        if (PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIsBoe == false) goto L6;
        long r103 = 878;
    L7:
        a.C3779a r104 = new a.C3779a(r103);     // Catch: Throwable -> L9
        r104.a(new h87.a(r102));     // Catch: Throwable -> L9
        r102.f484228a = SyncSDK.registerBusiness(r104.b());     // Catch: Throwable -> L9
        PushSupporter.monitor().monitorRegisterSenderSuccess(getSyncPush());     // Catch: Throwable -> L9
        return;
    L6:
        r103 = 21;
        goto L7
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public void unregisterPush(Context r100, int r101) {
        b r102 = b.b(r100);
        r102.getClass();
        r102.f484228a.remove();     // Catch: Throwable -> L5
        return;
    }
}
