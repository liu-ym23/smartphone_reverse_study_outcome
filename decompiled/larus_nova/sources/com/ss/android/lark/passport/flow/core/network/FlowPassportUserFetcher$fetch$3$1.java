package com.ss.android.lark.passport.flow.core.network;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.passport.PassportApmEvent;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/bytedance/apm/config/EventConfig;", "Lcom/ss/android/lark/passport/PassportApmEvent;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class FlowPassportUserFetcher$fetch$3$1 extends Lambda implements Function1<PassportApmEvent, com.bytedance.apm.config.d> {
    final /* synthetic */ Ref.ObjectRef<Integer> $httpCode;
    final /* synthetic */ Object $it;
    final /* synthetic */ Ref.ObjectRef<String> $logId;
    final /* synthetic */ long $startTime;

    public FlowPassportUserFetcher$fetch$3$1(Object r100, long r101, Ref.ObjectRef<Integer> r102, Ref.ObjectRef<String> r103) {
        this.$it = r100;
        this.$startTime = r101;
        this.$httpCode = r102;
        this.$logId = r103;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final com.bytedance.apm.config.d invoke2(PassportApmEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$monitor");
        boolean r101 = Result.m9456isSuccessimpl(this.$it);
        long r102 = System.currentTimeMillis() - this.$startTime;
        Integer r103 = this.$httpCode.element;
        String r104 = this.$logId.element;
        r100.getClass();
        return PassportApmEvent.x("/accounts/web/user", r101, r102, r103, r104);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ com.bytedance.apm.config.d invoke(PassportApmEvent r100) {
        return invoke2(r100);
    }
}
