package com.bytedance.awemeopen.apps.framework.feed.ui.information.desc;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.SpannableStringBuilder;
import android.view.ViewGroup;
import com.bytedance.awemeopen.apps.framework.feed.desc.ScrollMentionTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r extends AnimatorListenerAdapter {
    public final /* synthetic */ q a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ SpannableStringBuilder c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.widget.TextView] */
    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        if (this.b == true) goto L5;
        this.a.h(this.c);
    L5:
        ViewGroup r0 = this.a.h;
        ?? r1 = 0;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mDescToggleContainer");
        r0 = null;
    L8:
        r0.setClickable(true);
        ScrollMentionTextView r2 = this.a.g;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mDescView");
    L12:
        r1.setClickable(true);
        r4.removeListener(this);
        return;
    L11:
        r1 = r2;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.widget.TextView] */
    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        ViewGroup r4 = this.a.h;
        ?? r0 = 0;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDescToggleContainer");
        r4 = null;
    L5:
        r4.setClickable(false);
        ScrollMentionTextView r5 = this.a.g;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mDescView");
    L9:
        r0.setClickable(false);
        return;
    L8:
        r0 = r5;
        goto L9
    }

    public r(q r1, boolean r2, SpannableStringBuilder r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
