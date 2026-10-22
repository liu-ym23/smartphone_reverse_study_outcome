package com.bytedance.ee.bear.more.protocol3.extension;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class BaseMoreProvider$bindMoreInfo$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<oj5.c> $moreInfo;
    final /* synthetic */ BaseMoreProvider this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseMoreProvider$bindMoreInfo$4(BaseMoreProvider r1, Function0<? extends oj5.c> r2) {
        this.this$0 = r1;
        this.$moreInfo = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m312invoke() {
        BaseMoreProvider r0 = this.this$0;
        oj5.c r1 = (oj5.c) this.$moreInfo.invoke();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "moreInfo");
        r0.d = r1;
        r0.g();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m312invoke();
        return Unit.INSTANCE;
    }
}
