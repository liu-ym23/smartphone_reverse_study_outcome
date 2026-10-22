package com.bytedance.live.livelink.kmp.impl.extend;

import com.bytedance.live.livelink.kmp.api.base.interceptor.InterceptModule;
import com.bytedance.revenue.platform.api.core.rx.h;
import hi6.e;
import hi6.f;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class InterceptorCallExtendKt {

    public static final class a implements hi6.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f255535a;

        public a(Function1 r100) {
            this.f255535a = r100;
        }

        @Override // hi6.c
        public final f a(e r100) {
            Intrinsics.checkNotNullParameter(r100, "intcCall");
            return (f) this.f255535a.invoke(new d(r100));
        }
    }

    public static final Disposable a(final b r100, final InterceptModule r101, final hi6.d r102, Function1<? super d, f> r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$intercept");
        Intrinsics.checkNotNullParameter(r101, "intcModule");
        Intrinsics.checkNotNullParameter(r102, "intcStep");
        Intrinsics.checkNotNullParameter(r103, "scope");
        final a r104 = new a(r103);
        hi6.b r105 = r100.c().f255520i;
        if (r105 == null) goto L5;
        r105.b(r101, r102, r104);
    L5:
        int r106 = h.f267513a;
        return h.a(new InterceptorCallExtendKt$intercept$1(r100, r101, r102, r104));
    }
}
