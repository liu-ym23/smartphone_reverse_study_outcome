package com.ss.android.lark.passport.flow.core.network;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.passport.PassportApmEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/bytedance/apm/config/EventConfig;", "Lcom/ss/android/lark/passport/PassportApmEvent;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class FlowPassportUserFetcher$fetch$result$2 extends Lambda implements Function1<PassportApmEvent, com.bytedance.apm.config.d> {
    final /* synthetic */ Ref.ObjectRef<Integer> $httpCode;
    final /* synthetic */ Ref.ObjectRef<String> $logId;
    final /* synthetic */ long $startTime;

    public FlowPassportUserFetcher$fetch$result$2(long r100, Ref.ObjectRef<Integer> r101, Ref.ObjectRef<String> r102) {
        this.$startTime = r100;
        this.$httpCode = r101;
        this.$logId = r102;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final com.bytedance.apm.config.d invoke2(PassportApmEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$monitor");
        long r101 = System.currentTimeMillis() - this.$startTime;
        Integer r102 = this.$httpCode.element;
        String r103 = this.$logId.element;
        r100.getClass();
        return PassportApmEvent.x("/accounts/web/user", false, r101, r102, r103);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ com.bytedance.apm.config.d invoke(PassportApmEvent r100) {
        return invoke2(r100);
    }
}
