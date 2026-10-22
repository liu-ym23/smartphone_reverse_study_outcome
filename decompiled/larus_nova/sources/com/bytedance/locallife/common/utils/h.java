package com.bytedance.locallife.common.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f257147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f257148b;

    public static final class a implements c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f257149a;

        @Override // com.bytedance.locallife.common.utils.c.a
        public final void onStart() {
        }

        @Override // com.bytedance.locallife.common.utils.c.a
        public final void onTick() {
        }

        @Override // com.bytedance.locallife.common.utils.c.a
        public final void onFinish() {
            this.f257149a.invoke();
        }

        public a(Function0<Unit> r100) {
            this.f257149a = r100;
        }
    }

    public final void a() {
        c r100 = this.f257148b;
        monitor-enter(r100);
        r100.f257139e = true;     // Catch: Throwable -> L8
        r100.f257141g = false;     // Catch: Throwable -> L8
        r100.f257142h = false;     // Catch: Throwable -> L8
        r100.f257143i.removeMessages(1);     // Catch: Throwable -> L8
        monitor-exit(r100);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final boolean b() {
        c r100 = this.f257148b;
        monitor-enter(r100);
        boolean r101 = r100.f257141g;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final void c() {
        this.f257148b.e();
    }

    public h(long r100, Function0<Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "onFinish");
        this.f257147a = r100;
        this.f257148b = new c(this.f257147a, this.f257147a, new a(r110));
    }
}
