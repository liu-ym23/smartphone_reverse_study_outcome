package com.relax.relaxframework;

import com.relax.runtime.gen.CommonCallback;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final /* synthetic */ class d7 implements CommonCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f405064a;

    public /* synthetic */ d7(Function1 r100) {
        this.f405064a = r100;
    }

    @Override // com.relax.runtime.gen.CommonCallback
    public final void invoke(Object r100) {
        Function1 r101 = this.f405064a;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.relax.relaxframework.SwiperEventCommon{ com.relax.relaxframework.RelaxFrameworkKt.SwiperEvent_Change }");
        r101.invoke((SwiperEventCommon) r100);
    }
}
