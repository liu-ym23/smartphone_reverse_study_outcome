package com.bytedance.ee.bear.more.protocol3.extension;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class BaseMoreProvider$bindMoreInfo$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<oj5.c> $moreInfo;
    final /* synthetic */ BaseMoreProvider this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseMoreProvider$bindMoreInfo$4(BaseMoreProvider r100, Function0<? extends oj5.c> r101) {
        this.this$0 = r100;
        this.$moreInfo = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        BaseMoreProvider r100 = this.this$0;
        oj5.c r101 = this.$moreInfo.invoke();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "moreInfo");
        r100.f234889d = r101;
        r100.g();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
