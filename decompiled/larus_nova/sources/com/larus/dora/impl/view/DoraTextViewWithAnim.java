package com.larus.dora.impl.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0014J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/larus/dora/impl/view/DoraTextViewWithAnim;", "Lcom/larus/dora/impl/view/DoraTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "objectAnimator", "Landroid/animation/ObjectAnimator;", "getObjectAnimator", "()Landroid/animation/ObjectAnimator;", "setObjectAnimator", "(Landroid/animation/ObjectAnimator;)V", "onDetachedFromWindow", "", "alphaAnimRepeat", "stopAlphaAnim", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraTextViewWithAnim extends DoraTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObjectAnimator f338228a;

    public DoraTextViewWithAnim(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DoraTextViewWithAnim(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void x() {
        ObjectAnimator r100 = this.f338228a;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L9;
        return;
    L9:
        setAlpha(0.3f);
        e1.x(this);
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this, View.ALPHA, new float[]{0.3f, 1.0f});
        r102.setDuration(1000);
        r102.setInterpolator(new DecelerateInterpolator());
        r102.setRepeatMode(2);
        r102.setRepeatCount(-1);
        r102.start();
        this.f338228a = r102;
        return;
    L5:
        if (r100.isRunning() != true) goto L7;
        r101 = true;
        goto L7
    }

    public final void y() {
        setAlpha(1.0f);
        ObjectAnimator r100 = this.f338228a;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator r100 = this.f338228a;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f338228a = null;
    }

    public final ObjectAnimator getObjectAnimator() {
        return this.f338228a;
    }

    public final void setObjectAnimator(ObjectAnimator r100) {
        this.f338228a = r100;
    }

    public DoraTextViewWithAnim(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ DoraTextViewWithAnim(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
