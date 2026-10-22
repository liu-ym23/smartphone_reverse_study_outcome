package com.ss.ugc.live.sdk.msg.unify.network;

import com.ss.ugc.live.sdk.msg.utils.StateMachine;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tlc.f;

/* JADX INFO: loaded from: classes36.dex */
public final class UnifyWSState implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f458431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.ugc.live.sdk.msg.unify.network.b f458432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f458433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StateMachine<c, a, b> f458434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.msg.unify.network.c f458435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final kmc.d f458436f;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.network.UnifyWSState$a$a, reason: collision with other inner class name */
        public static final class C5499a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C5499a f458437a = null;

            static {
                f458437a = new C5499a();
            }

            public C5499a() {
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f458438a = null;

            static {
                f458438a = new b();
            }

            public b() {
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f458439a;

            public c(String r100) {
                Intrinsics.checkNotNullParameter(r100, "reason");
                this.f458439a = r100;
            }
        }

        public a() {
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f458440a = null;

            static {
                f458440a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.network.UnifyWSState$b$b, reason: collision with other inner class name */
        public static final class C5500b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C5500b f458441a = null;

            static {
                f458441a = new C5500b();
            }

            public C5500b() {
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f458442a;

            public c(String r100) {
                Intrinsics.checkNotNullParameter(r100, "reason");
                this.f458442a = r100;
            }
        }

        public b() {
        }
    }

    public static abstract class c {

        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f458443a = null;

            static {
                f458443a = new a();
            }

            public a() {
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f458444a = null;

            static {
                f458444a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.network.UnifyWSState$c$c, reason: collision with other inner class name */
        public static final class C5501c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C5501c f458445a = null;

            static {
                f458445a = new C5501c();
            }

            public C5501c() {
            }
        }

        public c() {
        }
    }

    @Override // com.ss.ugc.live.sdk.msg.unify.network.d
    public final void a() {
        this.f458434d.d(a.b.f458438a);
    }

    public final boolean e() {
        if (Intrinsics.areEqual(this.f458434d.b(), c.a.f458443a) == false) goto L9;
        com.ss.ugc.live.sdk.msg.unify.network.b r100 = this.f458432b;
        if (r100 == null) goto L9;
        if (r100.a() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.ss.ugc.live.sdk.msg.unify.network.d
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f458434d.d(new a.c(r100));
    }

    @Override // com.ss.ugc.live.sdk.msg.unify.network.d
    public final void d(f r100) {
        Intrinsics.checkNotNullParameter(r100, "payloadItem");
        d r101 = this.f458433c;
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    public final void f(f r100) {
        Intrinsics.checkNotNullParameter(r100, "payloadItem");
        com.ss.ugc.live.sdk.msg.unify.network.b r101 = this.f458432b;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    public UnifyWSState(com.ss.ugc.live.sdk.msg.unify.network.c r100, kmc.d r101) {
        Intrinsics.checkNotNullParameter(r100, "wsClient");
        Intrinsics.checkNotNullParameter(r101, "unifyTracer");
        this.f458435e = r100;
        this.f458436f = r101;
        StateMachine.a r102 = StateMachine.f458449c;
        Function1<StateMachine.GraphBuilder<c, a, b>, Unit> r103 = new UnifyWSState$stateMachine$1(this);
        r102.getClass();
        this.f458434d = StateMachine.a.a(r103);
    }

    public final void c(String r100, Map r101, com.ss.ugc.live.sdk.msg.unify.f.b r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "OnUnifyWSListener");
        this.f458433c = r102;
        this.f458432b = this.f458435e.a(r100, r101, this, r103);
        this.f458434d.d(a.C5499a.f458437a);
    }
}
