package com.bytedance.android.shopping.slice.preload;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import pq.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpq/c;", "", "invoke", "(Lpq/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class SlcWarmUpTemplateProvider$getGeckoModel$2 extends Lambda implements Function1<c, Unit> {
    final /* synthetic */ String $url;

    public SlcWarmUpTemplateProvider$getGeckoModel$2(String r1) {
        this.$url = r1;
        super(1);
    }

    public final void invoke(c r3) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        r3.a = "SlcWarmUpTemplateProvider";
        r3.b = "获取GeckoModel失败：" + this.$url;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((c) r1);
        return Unit.INSTANCE;
    }
}
