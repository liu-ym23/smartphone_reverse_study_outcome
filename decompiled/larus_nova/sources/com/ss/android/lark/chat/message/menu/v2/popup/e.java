package com.ss.android.lark.chat.message.menu.v2.popup;

import android.animation.ValueAnimator;
import com.ss.android.lark.chat.message.menu.v2.DragPanelLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PopupMenuEmojiPanelContent f415888a;

    public e(PopupMenuEmojiPanelContent r100) {
        this.f415888a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        DragPanelLayout r101 = this.f415888a.f415810e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragPanelLayout");
        r101 = null;
    L5:
        Object r102 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Float");
        r101.setTranslationY(((Float) r102).floatValue());
    }
}
