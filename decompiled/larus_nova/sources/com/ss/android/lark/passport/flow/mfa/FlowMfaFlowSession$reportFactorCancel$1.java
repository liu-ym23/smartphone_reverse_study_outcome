package com.ss.android.lark.passport.flow.mfa;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.passport.PassportApmEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/bytedance/apm/config/EventConfig;", "Lcom/ss/android/lark/passport/PassportApmEvent;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class FlowMfaFlowSession$reportFactorCancel$1 extends Lambda implements Function1<PassportApmEvent, com.bytedance.apm.config.d> {
    final /* synthetic */ a0 $reportInfo;

    public FlowMfaFlowSession$reportFactorCancel$1(a0 r100) {
        this.$reportInfo = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final com.bytedance.apm.config.d invoke2(PassportApmEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$monitor");
        a0 r101 = this.$reportInfo;
        String r102 = r101.f437885a;
        String r103 = r101.f437886b;
        String r104 = r101.f437887c;
        String r105 = r101.f437888d;
        String r106 = r101.f437889e;
        r100.getClass();
        return PassportApmEvent.t(r102, r103, r104, r105, r106);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ com.bytedance.apm.config.d invoke(PassportApmEvent r100) {
        return invoke2(r100);
    }
}
