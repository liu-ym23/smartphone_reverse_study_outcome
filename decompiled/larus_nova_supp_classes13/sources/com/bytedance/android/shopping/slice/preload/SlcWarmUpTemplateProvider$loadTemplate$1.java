package com.bytedance.android.shopping.slice.preload;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import pq.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpq/c;", "", "invoke", "(Lpq/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class SlcWarmUpTemplateProvider$loadTemplate$1 extends Lambda implements Function1<c, Unit> {
    public static final SlcWarmUpTemplateProvider$loadTemplate$1 INSTANCE = null;

    static {
        INSTANCE = new SlcWarmUpTemplateProvider$loadTemplate$1();
    }

    public SlcWarmUpTemplateProvider$loadTemplate$1() {
        super(1);
    }

    public final void invoke(c r2) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        r2.a = "SlcWarmUpTemplateProvider";
        r2.b = "url 解析失败";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((c) r1);
        return Unit.INSTANCE;
    }
}
