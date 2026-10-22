package com.ss.ugc.live.sdk.msg.network;

import com.bytedance.common.wschannel.WsConstants;
import com.ss.ugc.live.sdk.message.data.PayloadItemType;
import com.ss.ugc.live.sdk.msg.utils.StateMachine;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class WSState implements m, lmc.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f458282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f458283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f458284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StateMachine<c, a, b> f458285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l f458286e;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.network.WSState$a$a, reason: collision with other inner class name */
        public static final class C5479a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C5479a f458287a = null;

            static {
                f458287a = new C5479a();
            }

            public C5479a() {
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f458288a = null;

            static {
                f458288a = new b();
            }

            public b() {
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f458289a;

            public c(String r100) {
                Intrinsics.checkNotNullParameter(r100, "reason");
                this.f458289a = r100;
            }
        }

        public a() {
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f458290a = null;

            static {
                f458290a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.network.WSState$b$b, reason: collision with other inner class name */
        public static final class C5480b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C5480b f458291a = null;

            static {
                f458291a = new C5480b();
            }

            public C5480b() {
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f458292a;

            public c(String r100) {
                Intrinsics.checkNotNullParameter(r100, "reason");
                this.f458292a = r100;
            }
        }

        public b() {
        }
    }

    public static abstract class c {

        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f458293a = null;

            static {
                f458293a = new a();
            }

            public a() {
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f458294a = null;

            static {
                f458294a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.network.WSState$c$c, reason: collision with other inner class name */
        public static final class C5481c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C5481c f458295a = null;

            static {
                f458295a = new C5481c();
            }

            public C5481c() {
            }
        }

        public c() {
        }
    }

    @Override // lmc.h
    public final void f() {
        this.f458284c = null;
    }

    @Override // lmc.h
    public final boolean g() {
        return false;
    }

    @Override // com.ss.ugc.live.sdk.msg.network.m
    public final void a() {
        this.f458285d.d(a.b.f458288a);
    }

    @Override // lmc.h
    public final boolean c() {
        if (Intrinsics.areEqual(this.f458285d.b(), c.a.f458293a) == false) goto L9;
        k r100 = this.f458282a;
        if (r100 == null) goto L9;
        if (r100.a() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public WSState(l r100) {
        Intrinsics.checkNotNullParameter(r100, "wsClient");
        this.f458286e = r100;
        StateMachine.a r101 = StateMachine.f458449c;
        Function1<StateMachine.GraphBuilder<c, a, b>, Unit> r102 = new WSState$stateMachine$1(this);
        r101.getClass();
        this.f458285d = StateMachine.a.a(r102);
    }

    @Override // com.ss.ugc.live.sdk.msg.network.m
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f458285d.d(new a.c(r100));
    }

    @Override // com.ss.ugc.live.sdk.msg.network.m
    public final void d(tlc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "payloadItem");
        m r101 = this.f458283b;
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    @Override // lmc.h
    public final void e(tlc.f r100) {
        k r101 = this.f458282a;
        if (r101 == null) goto L6;
        r101.e(r100);
        return;
    }

    @Override // lmc.h
    public final void h(m r100) {
        this.f458284c = r100;
    }

    @Override // com.ss.ugc.live.sdk.msg.network.m
    public final void i(tlc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "payloadItem");
        if (Intrinsics.areEqual(r100.f546762c, PayloadItemType.PAYLOAD_TYPE_UPLINK.getType()) == false) goto L8;
        m r101 = this.f458284c;
        if (r101 == null) goto L9;
        r101.i(r100);
        return;
    L9:
        return;
    }

    public final void j(String r100, Map r101, cmc.a.b r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "onWSListener");
        this.f458283b = r102;
        this.f458282a = this.f458286e.a(r100, r101, this, r103);
        this.f458285d.d(a.C5479a.f458287a);
    }

    public final void k(String r110, byte[] r111, List r112, long r113, long r114) {
        Intrinsics.checkNotNullParameter("none", "encodeType");
        Intrinsics.checkNotNullParameter(r110, "payloadType");
        Intrinsics.checkNotNullParameter(r111, WsConstants.KEY_PAYLOAD);
        Intrinsics.checkNotNullParameter(r112, "headers");
        if (c() == true) goto L5;
        return;
    L5:
        k r115 = this.f458282a;
        if (r115 == null) goto L9;
        r115.f(new tlc.f(r110, "none", r111, r112, r113, r114));
        return;
    }
}
