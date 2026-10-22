package com.ss.ugc.live.sdk.msg.utils.task;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ugc.live.sdk.msg.utils.MainTaskScheduler;
import com.ss.ugc.live.sdk.msg.utils.StateMachine;
import com.ss.ugc.live.sdk.msg.utils.g;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mmc.a;

/* JADX INFO: loaded from: classes36.dex */
public final class TaskState<INPUT, OUTPUT, T extends mmc.a<INPUT, OUTPUT>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f458485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f458486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f458487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StateMachine<d, a, c> f458488d;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.utils.task.TaskState$a$a, reason: collision with other inner class name */
        public static final class C5505a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final g<?, Throwable> f458489a;

            /* JADX WARN: Multi-variable type inference failed */
            public C5505a(g<?, ? extends Throwable> r100) {
                Intrinsics.checkNotNullParameter(r100, "result");
                this.f458489a = r100;
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Object f458490a;

            public b(Object r100) {
                this.f458490a = r100;
            }
        }

        public a() {
        }
    }

    public static final class b<INPUT, OUTPUT, T extends mmc.a<INPUT, OUTPUT>> implements mmc.b<OUTPUT, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final mmc.b<OUTPUT, T> f458491a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f458492a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ mmc.a f458493b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ g f458494c;

            public a(b r100, mmc.a r101, g r102) {
                this.f458492a = r100;
                this.f458493b = r101;
                this.f458494c = r102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f458492a.f458491a.b(this.f458493b, this.f458494c);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.utils.task.TaskState$b$b, reason: collision with other inner class name */
        public static final class RunnableC5506b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f458495a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ mmc.a f458496b;

            public RunnableC5506b(b r100, mmc.a r101) {
                this.f458495a = r100;
                this.f458496b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f458495a.f458491a.c(this.f458496b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f458497a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ mmc.a f458498b;

            public c(b r100, mmc.a r101) {
                this.f458497a = r100;
                this.f458498b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f458497a.f458491a.a(this.f458498b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(com.ss.ugc.live.sdk.msg.utils.task.d.a r100) {
            Intrinsics.checkNotNullParameter(r100, "delegate");
            this.f458491a = r100;
        }

        @Override // mmc.b
        public final void a(T r100) {
            Intrinsics.checkNotNullParameter(r100, "task");
            MainTaskScheduler.a(new c(this, r100));
        }

        @Override // mmc.b
        public final void c(T r100) {
            Intrinsics.checkNotNullParameter(r100, "task");
            MainTaskScheduler.a(new RunnableC5506b(this, r100));
        }

        @Override // mmc.b
        public final void b(T r100, g<? extends OUTPUT, ? extends Throwable> r101) {
            Intrinsics.checkNotNullParameter(r100, "task");
            Intrinsics.checkNotNullParameter(r101, "result");
            MainTaskScheduler.a(new a(this, r100, r101));
        }
    }

    public static abstract class c {

        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f458499a = null;

            static {
                f458499a = new a();
            }

            public a() {
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f458500a = null;

            static {
                f458500a = new b();
            }

            public b() {
            }
        }

        public c() {
        }
    }

    public static abstract class d {

        public static final class a extends d {
            static {
                new a();
            }

            public a() {
            }
        }

        public static final class b extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f458501a = null;

            static {
                f458501a = new b();
            }

            public b() {
            }
        }

        public static final class c extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f458502a = null;

            static {
                f458502a = new c();
            }

            public c() {
            }
        }

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.utils.task.TaskState$d$d, reason: collision with other inner class name */
        public static final class C5507d extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C5507d f458503a = null;

            static {
                f458503a = new C5507d();
            }

            public C5507d() {
            }
        }

        public d() {
        }
    }

    public TaskState() {
        StateMachine.a r100 = StateMachine.f458449c;
        Function1<StateMachine.GraphBuilder<d, a, c>, Unit> r101 = new TaskState$stateMachine$1(this);
        r100.getClass();
        this.f458488d = StateMachine.a.a(r101);
    }
}
