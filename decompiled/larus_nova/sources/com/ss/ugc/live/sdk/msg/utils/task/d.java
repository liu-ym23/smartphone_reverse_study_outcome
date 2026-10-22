package com.ss.ugc.live.sdk.msg.utils.task;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ugc.live.sdk.msg.utils.g;
import com.ss.ugc.live.sdk.msg.utils.j;
import com.ss.ugc.live.sdk.msg.utils.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f458513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.ugc.live.sdk.msg.utils.task.b f458514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j f458515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f458516d;

    public static final class a implements mmc.b<Object, com.ss.ugc.live.sdk.msg.utils.task.b<Object, Object>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f458517a;

        public a(d r100) {
            this.f458517a = r100;
        }

        @Override // mmc.b
        public final void a(mmc.a r100) {
            Intrinsics.checkNotNullParameter((com.ss.ugc.live.sdk.msg.utils.task.b) r100, "task");
        }

        @Override // mmc.b
        public final void c(mmc.a r100) {
            Intrinsics.checkNotNullParameter((com.ss.ugc.live.sdk.msg.utils.task.b) r100, "task");
        }

        @Override // mmc.b
        public final void b(mmc.a r100, g<? extends Object, ? extends Throwable> r101) {
            com.ss.ugc.live.sdk.msg.utils.task.b r102 = (com.ss.ugc.live.sdk.msg.utils.task.b) r100;
            Intrinsics.checkNotNullParameter(r102, "task");
            Intrinsics.checkNotNullParameter(r101, "result");
            this.f458517a.f458515c.b(new k(r102.f458505b, r101));
            this.f458517a.f458513a.f458507b.getAndSet(null);
            c.a(this.f458517a.f458513a, null);
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f458518a;

        public b(d r100) {
            this.f458518a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d r100 = this.f458518a;     // Catch: Throwable -> L4
            com.ss.ugc.live.sdk.msg.utils.task.b r101 = r100.f458514b;     // Catch: Throwable -> L4
            Object r102 = r100.f458516d;     // Catch: Throwable -> L4
            r101.f458504a.f458488d.d(new TaskState.a.b(r102));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public d(c r100, com.ss.ugc.live.sdk.msg.utils.task.a r101, j r102, Object r103) {
        this.f458513a = r100;
        this.f458514b = r101;
        this.f458515c = r102;
        this.f458516d = r103;
    }

    public final void a() {
        com.ss.ugc.live.sdk.msg.utils.task.b r100 = this.f458514b;
        a r101 = new a(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "taskStateListener");
        TaskState<INPUT, OUTPUT, com.ss.ugc.live.sdk.msg.utils.task.b<INPUT, OUTPUT>> r102 = r100.f458504a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "taskStateListener");
        r102.f458485a = r100;
        TaskState.b r103 = new TaskState.b(r101);
        r102.f458486b = r103;
        r103.c(r100);
        c.a r104 = new c.a(this.f458514b, new b(this));
        c.a(this.f458513a, r104);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
