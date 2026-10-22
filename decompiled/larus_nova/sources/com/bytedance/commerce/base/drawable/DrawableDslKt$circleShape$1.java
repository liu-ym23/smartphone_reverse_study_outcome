package com.bytedance.commerce.base.drawable;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/commerce/base/drawable/c;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/commerce/base/drawable/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class DrawableDslKt$circleShape$1 extends Lambda implements Function1<c, Unit> {
    final /* synthetic */ int $color;
    final /* synthetic */ int $diameter;

    public DrawableDslKt$circleShape$1(int r100, int r101) {
        this.$color = r100;
        this.$diameter = r101;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(c r100) {
        r100.g(wf4.b.a.f559470b);
        r100.a(this.$color);
        r100.f(new AnonymousClass1(this));
    }
}
