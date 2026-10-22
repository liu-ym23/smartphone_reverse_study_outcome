package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.stage.KtvMicHighScoreLabelAnim;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000fB'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/midi/KtvMvMidiMicLabelAnim;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/stage/KtvMicHighScoreLabelAnim;", "Lpy/k;", "imageModel", "", "setUserAvatar", "", "getLayout", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMvMidiMicLabelAnim extends KtvMicHighScoreLabelAnim {
    public static final /* synthetic */ int p = 0;
    public LinearLayout i;
    public HSImageView j;
    public View k;
    public final AnimatorSet l;
    public int m;
    public ObjectAnimator n;
    public final ObjectAnimator o;

    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ KtvMvMidiMicLabelAnim a;

        public a(KtvMvMidiMicLabelAnim r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            KtvMvMidiMicLabelAnim r3 = this.a;
            int r0 = KtvMvMidiMicLabelAnim.p;
            r3.getClass();
        }
    }

    public static final class b {
        public final View a;

        public b(View r1) {
            this.a = r1;
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ KtvMvMidiMicLabelAnim a;
        public final /* synthetic */ b b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            TextView r4 = this.a.getMicLabelContent();
            if (r4 == null) goto L5;
            r4.setAlpha(1.0f);
        L5:
            LinearLayout r5 = this.a.i;
            if (r5 == null) goto L8;
            r5.setVisibility(8);
        L8:
            b r6 = this.b;
            int r0 = this.a.m;
            View r1 = r6.a;
            if (r1 == null) goto L13;
            ViewGroup.LayoutParams r2 = r1.getLayoutParams();
            if (r2 == null) goto L13;
            r2.width = r0;
        L13:
            View r7 = r6.a;
            if (r7 == null) goto L16;
            r7.requestLayout();
        L16:
            this.a.setAnimShowing(false);
            te2.a r8 = this.a.getLabelAnimCallback();
            if (r8 == null) goto L20;
            r8.a();
            return;
        }

        public c(KtvMvMidiMicLabelAnim r1, b r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ KtvMvMidiMicLabelAnim a;

        public d(KtvMvMidiMicLabelAnim r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            this.a.l.start();
        }
    }

    public KtvMvMidiMicLabelAnim(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvMvMidiMicLabelAnim(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.stage.KtvMicHighScoreLabelAnim
    public int getLayout() {
        return 2131565149;
    }

    public final void b() {
        FrameLayout.inflate(getContext(), getLayout(), this);
        this.i = (LinearLayout) findViewById(2131376978);
        this.k = findViewById(2131376981);
        String[] r0 = getConfig().ktvMidiLabelBackground;
        if (r0 == null) goto L9;
        ArrayList r2 = new ArrayList(r0.length);
        int r3 = r0.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L7;
        r2.add(Integer.valueOf(ColorProtector.parseColor(r0[r4])));
        r4 = r4 + 1;
        goto L5
    L7:
        int[] r1 = CollectionsKt.toIntArray(r2);
        if (r1 == null) goto L9;
    L11:
        if (r1.length <= 1) goto L15;
        GradientDrawable r5 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, r1);
        r5.setShape(0);
        r5.setCornerRadius(s1.G(180));
        View r6 = this.k;
        if (r6 == null) goto L15;
        r6.setBackground(r5);
    L15:
        LinearLayout r7 = this.i;
        if (r7 == null) goto L18;
        r7.setVisibility(8);
    L18:
        View r8 = this.k;
        if (r8 == null) goto L21;
        r8.setAlpha(0.0f);
    L21:
        setMicLabelContent((TextView) findViewById(2131376982));
        this.j = findViewById(2131376983);
        return;
    L9:
        r1 = new int[0];
        goto L11
    }

    public final void setUserAvatar(k r4) {
        ImageUtil.loadRoundImageAntiFlink(this.j, r4, 0);
    }

    public KtvMvMidiMicLabelAnim(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.l = new AnimatorSet();
        ObjectAnimator r5 = ObjectAnimator.ofFloat(getMicLabelContent(), "alpha", new float[]{1.0f, 0.0f});
        r5.setDuration(250);
        r5.addListener(new a(this));
        Unit r6 = Unit.INSTANCE;
        this.o = r5;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.stage.KtvMicHighScoreLabelAnim
    public final void a(String r6, String r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "labelTag");
        super.a(r6, r7, r8);
        LinearLayout r9 = this.i;
        if (r9 == null) goto L5;
        r9.measure(0, 0);
    L5:
        LinearLayout r10 = this.i;
        if (r10 == null) goto L8;
        r10.setVisibility(0);
    L8:
        View r11 = this.k;
        if (r11 == null) goto L11;
        r11.setAlpha(1.0f);
    L11:
        LinearLayout r12 = this.i;
        if (r12 == null) goto L14;
        r8 = r12.getMeasuredWidth();
    L14:
        this.m = r8;
        View r0 = this.k;
        b r13 = new b(r0);
        if (r0 == null) goto L19;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L19;
        r1.width = r8;
    L19:
        if (r0 == null) goto L21;
        r0.requestLayout();
    L21:
        ObjectAnimator r2 = ObjectAnimator.ofInt(r13, "width", new int[]{this.m, (int) s1.e(30.0f)});
        r2.setDuration(500);
        r2.addListener(new c(this, r13));
        Unit r14 = Unit.INSTANCE;
        this.n = r2;
        getVisibility();
        this.l.playTogether(new Animator[]{this.n, this.o});
        setTimerDisposable(Observable.timer(3, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this)));
    }

    public /* synthetic */ KtvMvMidiMicLabelAnim(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
