package com.larus.im.internal.delegate;

import com.bytedance.common.wschannel.WsConstants;
import com.larus.im.FlowRuntime;
import com.larus.im.NetworkTriggerType;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class o0 implements gd9.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0 f348249a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f348250b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f348251c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f348252d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final buc.e<gd9.t> f348253e = null;

    /* JADX INFO: loaded from: classes29.dex */
    public static final class a extends com.larus.im.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f348254a;

        @Override // com.larus.im.h
        public final NetworkTriggerType triggerType() {
            if (this.f348254a == false) goto L6;
            return NetworkTriggerType.Auto;
        L6:
            return NetworkTriggerType.User;
        }

        @Override // com.larus.im.l, com.larus.im.h
        public final boolean markAsNewUser() {
            return super.markAsNewUser();
        }

        public a(boolean r100) {
            this.f348254a = r100;
        }
    }

    public o0() {
    }

    @Override // gd9.v
    public final com.larus.im.g f() {
        return null;
    }

    static {
        f348249a = new o0();
        f348250b = LazyKt.lazy(new l0());
        f348251c = LazyKt.lazy(new m0());
        f348252d = LazyKt.lazy(new n0());
        f348253e = buc.b.d(null);
    }

    public static j0 l() {
        return (j0) f348252d.getValue();
    }

    public static gd9.v m() {
        return (gd9.v) f348250b.getValue();
    }

    @Override // gd9.v
    public final gd9.n b() {
        return m().b();
    }

    @Override // gd9.v
    public final void connect() {
        m().connect();
    }

    @Override // gd9.v
    public final int d() {
        return m().d();
    }

    @Override // gd9.v
    public final void disconnect() {
        m().disconnect();
    }

    @Override // gd9.v
    public final gd9.t h() {
        return l();
    }

    @Override // gd9.v
    public final boolean isNetworkAvailable() {
        return m().isNetworkAvailable();
    }

    public static Pair n(boolean r100) {
        com.larus.im.g.f347144a.getClass();
        if (FlowRuntime.d() == false) goto L7;
        com.larus.im.g r101 = FlowRuntime.b().c().f();
        if (r101 != null) goto L9;
        r101 = com.larus.im.k.f350570b;
    L9:
        return r101.a(new a(r100));
    L7:
        r101 = com.larus.im.k.f350570b;
        goto L9
    }

    @Override // gd9.v
    public final void c(gd9.v.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        m().c(r100);
    }

    @Override // gd9.v
    public final String e(String r100) {
        return m().e(r100);
    }

    @Override // gd9.v
    public final void g(gd9.v.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        m().g(r100);
    }

    @Override // gd9.v
    public final void i(gd9.v.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        m().i(r100);
    }

    @Override // gd9.v
    public final boolean j(gd9.e r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        return m().j(r100);
    }

    @Override // gd9.v
    public final void k(gd9.v.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        m().k(r100);
    }

    @Override // gd9.v
    public final void a(byte[] r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        m().a(r100, r101);
    }
}
