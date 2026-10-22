package com.bytedance.commerce.base.drawable;

import android.graphics.drawable.Drawable;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/commerce/base/drawable/d;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/commerce/base/drawable/d;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class RippleDrawableProxy$target$1 extends Lambda implements Function1<d, Unit> {
    final /* synthetic */ int $color;
    final /* synthetic */ Drawable $content;

    public RippleDrawableProxy$target$1(Drawable r100, int r101) {
        this.$content = r100;
        this.$color = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(d r100) {
        r100.a();
        new AnonymousClass1(this);
        r100.c();
        new AnonymousClass2(this);
        r100.b();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(d r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
