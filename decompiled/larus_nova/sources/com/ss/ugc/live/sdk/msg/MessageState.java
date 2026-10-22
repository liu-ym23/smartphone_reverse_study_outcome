package com.ss.ugc.live.sdk.msg;

import com.ss.ugc.live.sdk.msg.utils.StateMachine;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class MessageState implements com.ss.ugc.live.sdk.msg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateMachine<c, a, b> f458187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.msg.b f458188b;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.MessageState$a$a, reason: collision with other inner class name */
        public static final class C5474a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C5474a f458189a = null;

            static {
                f458189a = new C5474a();
            }

            public C5474a() {
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final boolean f458190a;

            public b(boolean r100) {
                this.f458190a = r100;
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f458191a = null;

            static {
                f458191a = new c();
            }

            public c() {
            }
        }

        public static final class d extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f458192a = null;

            static {
                f458192a = new d();
            }

            public d() {
            }
        }

        public static final class e extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f458193a = null;

            static {
                f458193a = new e();
            }

            public e() {
            }
        }

        public a() {
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f458194a = null;

            static {
                f458194a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.MessageState$b$b, reason: collision with other inner class name */
        public static final class C5475b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final boolean f458195a;

            public C5475b(boolean r100) {
                this.f458195a = r100;
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f458196a = null;

            static {
                f458196a = new c();
            }

            public c() {
            }
        }

        public static final class d extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f458197a = null;

            static {
                f458197a = new d();
            }

            public d() {
            }
        }

        public static final class e extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f458198a = null;

            static {
                f458198a = new e();
            }

            public e() {
            }
        }

        public b() {
        }
    }

    public static abstract class c {

        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f458199a = null;

            static {
                f458199a = new a();
            }

            public a() {
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f458200a = null;

            static {
                f458200a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.MessageState$c$c, reason: collision with other inner class name */
        public static final class C5476c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C5476c f458201a = null;

            static {
                f458201a = new C5476c();
            }

            public C5476c() {
            }
        }

        public static final class d extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f458202a = null;

            static {
                f458202a = new d();
            }

            public d() {
            }
        }

        public static final class e extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f458203a = null;

            static {
                f458203a = new e();
            }

            public e() {
            }
        }

        public c() {
        }
    }

    @Override // com.ss.ugc.live.sdk.msg.a
    public final boolean isRunning() {
        return Intrinsics.areEqual(this.f458187a.b(), c.e.f458203a);
    }

    public MessageState(com.ss.ugc.live.sdk.msg.b r100, final vlc.c r101) {
        Intrinsics.checkNotNullParameter(r100, "stateListener");
        Intrinsics.checkNotNullParameter(r101, "logger");
        this.f458188b = r100;
        StateMachine.a r102 = StateMachine.f458449c;
        Function1<StateMachine.GraphBuilder<c, a, b>, Unit> r103 = new MessageState$stateMachine$1(this, r101);
        r102.getClass();
        this.f458187a = StateMachine.a.a(r103);
    }
}
