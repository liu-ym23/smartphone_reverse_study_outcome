package com.ss.ugc.live.sdk.msg.unify;

import com.ss.ugc.live.sdk.msg.utils.StateMachine;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateMachine<c, a, b> f458413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.msg.unify.a f458414b;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.i$a$a, reason: collision with other inner class name */
        public static final class C5496a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C5496a f458415a = null;

            static {
                f458415a = new C5496a();
            }

            public C5496a() {
            }
        }

        public static final class b extends a {
            static {
                new b();
            }

            public b() {
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f458416a = null;

            static {
                f458416a = new c();
            }

            public c() {
            }
        }

        public a() {
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f458417a = null;

            static {
                f458417a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.i$b$b, reason: collision with other inner class name */
        public static final class C5497b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C5497b f458418a = null;

            static {
                f458418a = new C5497b();
            }

            public C5497b() {
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f458419a = null;

            static {
                f458419a = new c();
            }

            public c() {
            }
        }

        public b() {
        }
    }

    public static abstract class c {

        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f458420a = null;

            static {
                f458420a = new a();
            }

            public a() {
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f458421a = null;

            static {
                f458421a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.i$c$c, reason: collision with other inner class name */
        public static final class C5498c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C5498c f458422a = null;

            static {
                f458422a = new C5498c();
            }

            public C5498c() {
            }
        }

        public static final class d extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f458423a = null;

            static {
                f458423a = new d();
            }

            public d() {
            }
        }

        public c() {
        }
    }

    public i(com.ss.ugc.live.sdk.msg.unify.a r100, final kmc.d r101) {
        Intrinsics.checkNotNullParameter(r100, "stateListener");
        Intrinsics.checkNotNullParameter(r101, "logger");
        this.f458414b = r100;
        StateMachine.a r102 = StateMachine.f458449c;
        Function1<StateMachine.GraphBuilder<c, a, b>, Unit> r103 = new UnifyMessageState$stateMachine$1(this, r101);
        r102.getClass();
        this.f458413a = StateMachine.a.a(r103);
    }
}
