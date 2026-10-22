package com.ss.android.lark.rustinfrabridge.netstate.impl;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.DynamicNetStatusResponse;
import com.bytedance.lark.rustclient.api.h;
import com.bytedance.lark.rustclient.api.t;
import com.ss.android.lark.rustinfrabridge.netstate.api.NetworkLevelListener;
import com.ss.android.lark.utils.statistics.PerfLog;
import e0c.k;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Singleton
public final class LarkNetworkLevelManager implements com.ss.android.lark.rustinfrabridge.netstate.api.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f439693d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f439694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NetworkLevelListener.NetworkLevel f439695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<NetworkLevelListener, Object> f439696c;

    public static final class a {
        @JvmStatic
        public static com.ss.android.lark.rustinfrabridge.netstate.api.a a() {
            if (com.bytedance.lark.sdk.d.l() == false) goto L6;
            Object r100 = com.ss.android.lark.rustinfrabridge.netstate.impl.a.f439706c;
            com.ss.android.lark.rustinfrabridge.netstate.impl.a r101 = com.ss.android.lark.rustinfrabridge.netstate.impl.a.C5277a.f439709a;
            Intrinsics.checkNotNull(r101);
            return r101;
        L6:
            return (com.ss.android.lark.rustinfrabridge.netstate.api.a) k.a(com.larksuite.framework.utils.b.f285948a, com.ss.android.lark.rustinfrabridge.netstate.api.a.class);
        }
    }

    static {
        f439693d = new Object();
    }

    @Override // com.ss.android.lark.rustinfrabridge.netstate.api.a
    public final NetworkLevelListener.NetworkLevel getCurNetWorkLevel() {
        return this.f439695b;
    }

    @Inject
    public LarkNetworkLevelManager(h r100) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        this.f439694a = r100;
        this.f439696c = new ConcurrentHashMap();
        this.f439695b = NetworkLevelListener.NetworkLevel.EXCELLENT;
    }

    @Override // com.ss.android.lark.rustinfrabridge.netstate.api.a
    public final void v0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        t.g(this.f439694a.e(Command.PUSH_DYNAMIC_NET_STATUS, DynamicNetStatusResponse.RAW_TYPE_ADAPTER), new LarkNetworkLevelManager$registerPush$1(this), LarkNetworkLevelManager$registerPush$2.INSTANCE);
    }

    @Override // com.ss.android.lark.rustinfrabridge.netstate.api.a
    public final void w0(NetworkLevelListener r100) {
        if (r100 == null) goto L5;
        Map<NetworkLevelListener, Object> r101 = this.f439696c;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        r102.put(r100, f439693d);
        return;
    }

    @Override // com.ss.android.lark.rustinfrabridge.netstate.api.a
    public final void x0(NetworkLevelListener r100) {
        if (r100 == null) goto L5;
        ((ConcurrentHashMap) this.f439696c).remove(r100);
        return;
    }
}
