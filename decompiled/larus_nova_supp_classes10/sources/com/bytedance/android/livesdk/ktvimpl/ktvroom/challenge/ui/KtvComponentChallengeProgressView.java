package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000fB'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/ui/KtvComponentChallengeProgressView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "max", "", "setProgressBarRange", "challengeType", "setChallengeTypeText", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentChallengeProgressView extends ConstraintLayout {
    public ProgressBar a;
    public KtvComponentChallengeResultView b;

    public static final class a {
    }

    static {
    }

    public KtvComponentChallengeProgressView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvComponentChallengeProgressView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(int r7) {
        ProgressBar r0 = this.a;
        if (r0 == null) goto L5;
        r0.setProgress(r7);
    L5:
        KtvComponentChallengeResultView r1 = this.b;
        if (r1 == null) goto L40;
        ProgressBar r2 = this.a;
        if (r2 == null) goto L10;
        int r3 = r2.getMax();
    L11:
        int r4 = getWidth();
        TextView r5 = r1.b;
        if (r5 == null) goto L14;
        r5.setText(String.valueOf(r7));
    L14:
        if (r7 <= 0) goto L41;
        View r6 = r1.e;
        ViewGroup.LayoutParams r8 = null;
        if (r6 == null) goto L18;
        ViewGroup.LayoutParams r9 = r6.getLayoutParams();
    L20:
        if ((r9 instanceof ConstraintLayout.LayoutParams) == false) goto L23;
        r8 = r9;
    L23:
        ViewGroup.LayoutParams r10 = (ConstraintLayout.LayoutParams) r8;
        if (r10 == null) goto L26;
        ((ConstraintLayout.LayoutParams) r10).rightToRight = 2131376891;
        ((ConstraintLayout.LayoutParams) r10).leftToLeft = 2131376891;
    L26:
        View r11 = r1.e;
        if (r11 == null) goto L29;
        r11.setLayoutParams(r10);
    L29:
        View r12 = r1.e;
        if (r12 == null) goto L32;
        r12.setBackgroundResource(2131252035);
    L32:
        TextView r13 = r1.d;
        if (r13 == null) goto L35;
        r13.setBackgroundResource(2131249302);
    L35:
        View r14 = r1.f;
        if (r14 == null) goto L38;
        r14.setBackgroundResource(2131249302);
    L38:
        r1.R5(r7, r3, r4);
        return;
    L18:
        r9 = null;
        goto L20
    L41:
        return;
    L10:
        r3 = 0;
        goto L11
    }

    public final void setChallengeTypeText(int r2) {
        KtvComponentChallengeResultView r0 = this.b;
        if (r0 == null) goto L6;
        r0.setChallengeTypeText(r2);
        return;
    }

    public final void setProgressBarRange(int r3) {
        ProgressBar r0 = this.a;
        if (r0 == null) goto L5;
        r0.setProgress(0);
    L5:
        ProgressBar r1 = this.a;
        if (r1 == null) goto L8;
        r1.setMax(r3);
    L8:
        KtvComponentChallengeResultView r2 = this.b;
        if (r2 == null) goto L12;
        r2.setProgressBarRange(r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KtvComponentChallengeProgressView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131566477, this);
        this.a = (ProgressBar) findViewById(2131376899);
        this.b = (KtvComponentChallengeResultView) findViewById(2131376901);
    }

    public /* synthetic */ KtvComponentChallengeProgressView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
