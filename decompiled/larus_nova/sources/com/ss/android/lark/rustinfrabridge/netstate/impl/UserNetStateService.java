package com.ss.android.lark.rustinfrabridge.netstate.impl;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.GetWebSocketStatusResponse;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.rustinfrabridge.netstate.api.WSConnState$ConnState;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class UserNetStateService implements g3c.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f439697e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f439698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<h3c.a> f439699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile WSConnState$ConnState f439700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Executor f439701d;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f439702a = null;

        static {
            int[] r100 = new int[GetWebSocketStatusResponse.Status.values().length];
            r100[GetWebSocketStatusResponse.Status.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[GetWebSocketStatusResponse.Status.CLOSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[GetWebSocketStatusResponse.Status.OPENING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f439702a = r100;
        }
    }

    static {
    }

    @Override // g3c.a
    public final void Je(h3c.a r100) {
        if (r100 == null) goto L5;
        r100.a(this.f439700c);
        ((CopyOnWriteArrayList) this.f439699b).add(r100);
        return;
    }

    @Override // g3c.a
    public final void i5(h3c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((CopyOnWriteArrayList) this.f439699b).remove(r100);
    }

    @Override // g3c.a
    public final void v0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        t.g(this.f439698a.i(Command.PUSH_WEB_SOCKET_STATUS, GetWebSocketStatusResponse.RAW_TYPE_ADAPTER), new UserNetStateService$registerPush$1(this), UserNetStateService$registerPush$2.INSTANCE);
        Object r101 = LarkNetworkLevelManager.f439693d;
        LarkNetworkLevelManager.a.a().v0(r100);
    }

    @Inject
    public UserNetStateService(l r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        Intrinsics.checkNotNullParameter(r101, "userId");
        this.f439698a = r100;
        this.f439699b = new CopyOnWriteArrayList();
        this.f439700c = WSConnState$ConnState.ConnectUnknown;
        this.f439701d = CoreThreadPool.getDefault().newSerialCpuDensityThreadPool("thread-pool-wschannel");
    }
}
