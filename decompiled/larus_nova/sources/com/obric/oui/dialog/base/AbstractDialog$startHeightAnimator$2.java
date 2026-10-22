package com.obric.oui.dialog.base;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "value", "", "<anonymous parameter 2>", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class AbstractDialog$startHeightAnimator$2 extends Lambda implements Function3<String, Object, Object, Unit> {
    final /* synthetic */ View $container;
    final /* synthetic */ AbstractDialog this$0;

    public AbstractDialog$startHeightAnimator$2(AbstractDialog r100, View r101) {
        this.this$0 = r100;
        this.$container = r101;
        super(3);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100, Object r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "$noName_0");
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r102, "$noName_2");
        float r103 = ((Float) r101).floatValue();
        this.this$0.getClass();
        View r104 = this.$container;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        r105.height = (int) r103;
        r104.setLayoutParams(r105);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(String r100, Object r101, Object r102) {
        invoke2(r100, r101, r102);
        return Unit.INSTANCE;
    }
}
