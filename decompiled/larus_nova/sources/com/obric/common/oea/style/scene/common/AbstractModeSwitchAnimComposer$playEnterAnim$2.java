package com.obric.common.oea.style.scene.common;

import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", "p2", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class AbstractModeSwitchAnimComposer$playEnterAnim$2 extends FunctionReferenceImpl implements Function2<View, Boolean, Unit> {
    public AbstractModeSwitchAnimComposer$playEnterAnim$2(a r100) {
        super(2, r100, a.class, "handleSingleEnterAnimEnd", "handleSingleEnterAnimEnd(Landroid/view/View;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(View r100, Boolean r101) {
        invoke(r100, r101.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((a) this.receiver).a();
    }
}
