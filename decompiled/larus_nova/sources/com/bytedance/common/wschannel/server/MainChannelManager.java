package com.bytedance.common.wschannel.server;

import android.content.Context;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes3.dex */
public class MainChannelManager {
    private static volatile ChannelManager sInstance;

    private static ChannelManager createChannelManager(Context r110) {
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("wschannel");
        ThreadMethodProxy.start(r100);
        ChannelKeeper r101 = new ChannelKeeper();
        MainMsgHandler r102 = new MainMsgHandler(r110, r101);
        IEnableObserver r103 = new AnonymousClass1();
        ChannelManager r104 = new ChannelManager(r110, r100.getLooper(), new AnonymousClass2(), r101, r102, r103);
        r102.setChannelManager(r104);
        return r104;
    }

    public static ChannelManager inst(Context r100) {
        if (sInstance != null) goto L15;
        monitor-enter(ChannelManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = createChannelManager(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(ChannelManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }
}
