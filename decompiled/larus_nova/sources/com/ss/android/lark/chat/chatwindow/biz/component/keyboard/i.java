package com.ss.android.lark.chat.chatwindow.biz.component.keyboard;

import android.animation.Animator;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.MessageListAnimationContainer;

/* JADX INFO: loaded from: classes35.dex */
public final class i implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MessageListAnimationContainer f412090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f412091b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f412090a.setTranslationY(0.0f);
        this.f412091b.setTranslationY(0.0f);
        this.f412090a.setAnimType(MessageListAnimationContainer.AnimType.None);
    }

    public i(MessageListAnimationContainer r100, RecyclerView r101) {
        this.f412090a = r100;
        this.f412091b = r101;
    }
}
