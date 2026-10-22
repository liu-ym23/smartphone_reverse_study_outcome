package com.ss.android.lark.keyboard.ime;

import android.animation.ValueAnimator;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/animation/ValueAnimator;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ImeWrapper$preparePanelAnimator$1 extends Lambda implements Function1<ValueAnimator, Unit> {
    public static final ImeWrapper$preparePanelAnimator$1 INSTANCE = null;

    static {
        INSTANCE = new ImeWrapper$preparePanelAnimator$1();
    }

    public ImeWrapper$preparePanelAnimator$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ValueAnimator r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
