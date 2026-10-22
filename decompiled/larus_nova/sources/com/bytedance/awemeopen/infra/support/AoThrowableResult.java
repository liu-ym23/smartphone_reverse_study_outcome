package com.bytedance.awemeopen.infra.support;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class AoThrowableResult<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f198934d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f198935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f198936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f198937c;

    public static final class a {
        public static AoThrowableResult a(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
            return new AoThrowableResult(new b(r100));
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f198938a;

        public final int hashCode() {
            return this.f198938a.hashCode();
        }

        public final String toString() {
            return "Failure(" + this.f198938a + ')';
        }

        public b(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
            this.f198938a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof b) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(this.f198938a, ((b) r100).f198938a) == false) goto L7;
            return true;
        }
    }

    static {
    }

    public AoThrowableResult(Object r100) {
        this.f198935a = r100;
        LazyThreadSafetyMode r101 = LazyThreadSafetyMode.NONE;
        this.f198936b = LazyKt.lazy(r101, new AoThrowableResult$isSuccess$2(this));
        this.f198937c = LazyKt.lazy(r101, new AoThrowableResult$isFail$2(this));
    }

    public final <R> AoThrowableResult<R> a(Function1<? super T, ? extends R> r100) {
        Intrinsics.checkNotNullParameter(r100, "transform");
        if (((Boolean) this.f198936b.getValue()).booleanValue() == false) goto L7;
        return new AoThrowableResult(r100.invoke((Object) this.f198935a));
    L7:
        return new AoThrowableResult(this.f198935a);
    }
}
