package com.bytedance.kmp.ec.yata.view.render.controller.manager.exposure;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 0}, xi = 48)
final class AbsExposureHelper$onSubmitDataEnd$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $action;
    final /* synthetic */ AbsExposureHelper this$0;

    public AbsExposureHelper$onSubmitDataEnd$1(AbsExposureHelper r100, Function0<Unit> r101) {
        this.this$0 = r100;
        this.$action = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        int r100 = ha6.h.f484393a;
        AbsExposureHelper r101 = this.this$0;
        ha6.h.b(r101.f251849c, r101.f251848b, 1, 3, this.$action);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
