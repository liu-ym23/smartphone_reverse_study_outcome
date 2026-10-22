package com.bytedance.awemeopen.appserviceimpl.dislike;

import android.content.Context;
import com.bytedance.awemeopen.bizmodels.user.f;
import com.bytedance.awemeopen.domain.dislike.DislikeDomain;
import com.bytedance.awemeopen.domain.dislike.a;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import r24.b;
import r24.c;
import r24.d;

/* JADX INFO: loaded from: classes44.dex */
public final class DislikeService implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f198090a;

    @Override // k24.a
    public final void x0() {
    }

    public DislikeService() {
        this.f198090a = LazyKt.lazy(DislikeService$domain$2.INSTANCE);
    }

    @Override // r24.c
    public final void Y0(Context r100, final b r101, final f r102, final d r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dislikeModel");
        Intrinsics.checkNotNullParameter(r103, "callback");
        DislikeDomain r104 = (DislikeDomain) this.f198090a.getValue();
        com.bytedance.awemeopen.domain.dislike.b r105 = new com.bytedance.awemeopen.domain.dislike.b(r101.f535756a, r101.f535757b);
        a r106 = new a();
        Function1<Function1<? super String, ? extends Unit>, Unit> r107 = new DislikeService$dislike$1$1(r101, r102, r103);
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r106.f198316c = r107;
        r106.f198317d = new j14.a(r102, new DislikeService$dislike$1$2(r101, r102, r103));
        r106.f198315b = new DislikeService$dislike$1$3(r103);
        r106.f198314a = new DislikeService$dislike$1$4(r103);
        r106.f198318e = new DislikeService$dislike$1$5(r103);
        Unit r108 = Unit.INSTANCE;
        r104.a(r100, r105, r106);
    }
}
