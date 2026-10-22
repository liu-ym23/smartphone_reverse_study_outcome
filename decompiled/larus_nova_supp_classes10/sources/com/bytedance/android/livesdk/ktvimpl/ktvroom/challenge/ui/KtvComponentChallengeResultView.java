package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.message.model.KtvChallengeType;
import com.bytedance.bdlocation.exception.BDLocationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000fB'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/ui/KtvComponentChallengeResultView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "max", "", "setProgressBarRange", "challengeType", "setChallengeTypeText", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentChallengeResultView extends ConstraintLayout {
    public static final /* synthetic */ int g = 0;
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public View e;
    public View f;

    public static final class a {
    }

    static {
    }

    public KtvComponentChallengeResultView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvComponentChallengeResultView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5() {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        ViewGroup.LayoutParams r2 = null;
        if ((r0 instanceof ConstraintLayout.LayoutParams) == true) goto L5;
        r0 = null;
    L5:
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;
        if (r1 == null) goto L8;
        r1.rightToRight = 0;
        r1.leftToLeft = -1;
    L8:
        setLayoutParams(r1);
        setTranslationX(0.0f);
        View r3 = this.e;
        if (r3 == null) goto L11;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
    L13:
        if ((r4 instanceof ConstraintLayout.LayoutParams) == false) goto L16;
        r2 = r4;
    L16:
        ViewGroup.LayoutParams r5 = (ConstraintLayout.LayoutParams) r2;
        if (r5 == null) goto L19;
        ((ConstraintLayout.LayoutParams) r5).rightToRight = 0;
        ((ConstraintLayout.LayoutParams) r5).leftToLeft = -1;
    L19:
        View r6 = this.e;
        if (r6 == null) goto L22;
        r6.setLayoutParams(r5);
    L22:
        View r7 = this.e;
        if (r7 == null) goto L25;
        r7.setBackgroundResource(2131252036);
    L25:
        TextView r8 = this.d;
        if (r8 == null) goto L28;
        r8.setBackgroundResource(2131249304);
    L28:
        View r9 = this.f;
        if (r9 == null) goto L32;
        r9.setBackgroundResource(2131249304);
        return;
    L32:
        return;
    L11:
        r4 = null;
        goto L13
    }

    public final void setChallengeTypeText(int r5) {
        if (r5 != KtvChallengeType.KTV_CHALLENGE_TYPE_GIFT.getValue()) goto L11;
        TextView r6 = this.c;
        if (r6 == null) goto L7;
        r6.setText("");
    L7:
        Drawable r7 = s1.m(2131252024);
        r7.setBounds(0, 0, UtilityKotlinExtentionsKt.i(11), UtilityKotlinExtentionsKt.i(11));
        TextView r0 = this.c;
        if (r0 == null) goto L27;
        r0.setCompoundDrawables(r7, null, null, null);
        return;
    L27:
        return;
    L11:
        if (r5 != KtvChallengeType.KTV_CHALLENGE_TYPE_MIDI.getValue()) goto L19;
        TextView r8 = this.c;
        if (r8 == null) goto L15;
        r8.setCompoundDrawables(null, null, null, null);
    L15:
        TextView r9 = this.c;
        if (r9 == null) goto L29;
        r9.setText(s1.B(2131918253));
        return;
    L29:
        return;
    L19:
        if (r5 != KtvChallengeType.KTV_CHALLENGE_TYPE_LIKE.getValue()) goto L31;
        TextView r10 = this.c;
        if (r10 == null) goto L23;
        r10.setCompoundDrawables(null, null, null, null);
    L23:
        TextView r11 = this.c;
        if (r11 == null) goto L32;
        r11.setText(s1.B(2131918252));
        return;
    L32:
        return;
    }

    public final void setProgressBarRange(int r4) {
        TextView r0 = this.b;
        if (r0 == null) goto L5;
        r0.setText(BDLocationException.ERROR_TIMEOUT);
    L5:
        TextView r1 = this.a;
        if (r1 == null) goto L9;
        r1.setText("/" + r4);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KtvComponentChallengeResultView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131566478, this);
        this.a = (TextView) findViewById(2131365450);
        this.b = (TextView) findViewById(2131365447);
        this.c = (TextView) findViewById(2131365446);
        this.d = (TextView) findViewById(2131365449);
        this.f = findViewById(2131376891);
        this.e = findViewById(2131365448);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(int r5, int r6, int r7) {
        if (r5 < r6) goto L4;
        int r0 = r6;
    L5:
        int r1 = r7 - (getWidth() / 2);
        int r2 = getWidth() / 2;
        float r3 = (r0 / r6) * r7;
        float r8 = r1;
        if (r3 >= r8) goto L8;
        r8 = r3;
    L8:
        float r4 = r2;
        if (r3 >= r4) goto L11;
        setTranslationX(0.0f);
        return;
    L11:
        if (r5 < r6) goto L13;
        setTranslationX(0.0f);
        S5();
        return;
    L13:
        setTranslationX(r8 - r4);
        return;
    L4:
        r0 = r5;
        goto L5
    }

    public /* synthetic */ KtvComponentChallengeResultView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
