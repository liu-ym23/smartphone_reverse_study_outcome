package com.bytedance.awemeopen.infra.support;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class AoCodeResult<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f198929d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f198930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f198931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f198932c;

    public static final class a {
        public static AoCodeResult a(int r100) {
            return new AoCodeResult(new b(r100));
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f198933a;

        public final String toString() {
            return "Failure(" + this.f198933a + ')';
        }

        public final int hashCode() {
            return this.f198933a;
        }

        public b(int r100) {
            this.f198933a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof b) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.f198933a != ((b) r100).f198933a) goto L7;
            return true;
        }
    }

    static {
    }

    public AoCodeResult(Object r100) {
        this.f198930a = r100;
        LazyThreadSafetyMode r101 = LazyThreadSafetyMode.NONE;
        this.f198931b = LazyKt.lazy(r101, new AoCodeResult$isSuccess$2(this));
        this.f198932c = LazyKt.lazy(r101, new AoCodeResult$isFail$2(this));
    }

    public final void a(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Object r101 = this.f198930a;
        if ((r101 instanceof b) == false) goto L6;
        r100.invoke(Integer.valueOf(((b) r101).f198933a));
        return;
    }

    public final void b(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (((Boolean) this.f198931b.getValue()).booleanValue() == false) goto L6;
        r100.invoke(this.f198930a);
        return;
    }
}
