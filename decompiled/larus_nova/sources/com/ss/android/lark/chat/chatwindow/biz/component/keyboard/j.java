package com.ss.android.lark.chat.chatwindow.biz.component.keyboard;

import android.animation.Animator;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.MessageListAnimationContainer;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.AnchorItemLayoutManager;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class j implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f412092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f412093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MessageListAnimationContainer f412094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f412095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f412096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Function1 f412097f;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        if (this.f412092a <= this.f412093b) goto L5;
        MessageListAnimationContainer.AnimType r101 = MessageListAnimationContainer.AnimType.Enter;
    L6:
        this.f412094c.setAnimType(r101);
        d r102 = this.f412095d;
        Intrinsics.checkNotNull(this.f412096e);
        RecyclerView r103 = this.f412096e;
        r102.getClass();
        RecyclerView.LayoutManager r104 = r103.getLayoutManager();
        if ((r104 instanceof AnchorItemLayoutManager) == false) goto L9;
        AnchorItemLayoutManager r105 = (AnchorItemLayoutManager) r104;
    L9:
        r102.f412082e = Math.max(0, Math.max((r103.getHeight() - r103.getPaddingBottom()) - r103.computeVerticalScrollRange(), 0));
        this.f412097f.invoke(Float.valueOf(this.f412092a));
        return;
    L5:
        r101 = MessageListAnimationContainer.AnimType.Exit;
        goto L6
    }

    public j(int r100, int r101, MessageListAnimationContainer r102, d r103, RecyclerView r104, Function1 r105) {
        this.f412092a = r100;
        this.f412093b = r101;
        this.f412094c = r102;
        this.f412095d = r103;
        this.f412096e = r104;
        this.f412097f = r105;
    }
}
