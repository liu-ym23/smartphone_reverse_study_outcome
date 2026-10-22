package com.bytedance.ee.bear.bitable.superagent.voice;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.util.ui.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0018J\b\u0010\u001c\u001a\u00020\u0018H\u0014J\b\u0010\u001d\u001a\u00020\u0018H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/voice/BitableSuperAgentVoiceWaveformView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "barHeightsDp", "", "barDurations", "", "barBeginDelays", "bars", "", "Landroid/view/View;", "animators", "", "Landroid/animation/ObjectAnimator;", "isAnimating", "", "currentLevel", "", "setLevel", "", "newLevel", "startAnimating", "stopAnimating", "onDetachedFromWindow", "updateBarAlpha", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSuperAgentVoiceWaveformView extends LinearLayout {
    public final float[] a;
    public final long[] b;
    public final long[] c;
    public final List<View> d;
    public final List<ObjectAnimator> e;
    public boolean f;
    public float g;

    public final void a() {
        if (this.f == false) goto L5;
        return;
    L5:
        this.f = true;
        Iterator<T> r1 = this.d.iterator();
        int r3 = 0;
    L7:
        if (r1.hasNext() == false) goto L12;
        Object r4 = r1.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        ObjectAnimator r6 = ObjectAnimator.ofPropertyValuesHolder((View) r4, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe(View.SCALE_Y, new Keyframe[]{Keyframe.ofFloat(0.0f, 0.45f), Keyframe.ofFloat(0.36f, 1.0f), Keyframe.ofFloat(0.72f, 0.62f), Keyframe.ofFloat(1.0f, 0.45f)})});
        r6.setDuration(this.b[r3]);
        r6.setStartDelay(this.c[r3]);
        r6.setRepeatCount(-1);
        r6.setInterpolator(new AccelerateDecelerateInterpolator());
        ((ArrayList) this.e).add(r6);
        r6.start();
        r3 = r5;
        goto L7
    }

    public final void b() {
        if (this.f == true) goto L5;
        return;
    L5:
        this.f = false;
        Iterator<T> r0 = this.e.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((ObjectAnimator) r0.next()).cancel();
        goto L7
    L9:
        ((ArrayList) this.e).clear();
        Iterator<T> r1 = this.d.iterator();
    L11:
        if (r1.hasNext() == false) goto L13;
        ((View) r1.next()).setScaleY(1.0f);
        goto L11
    }

    public final void c() {
        float r0 = (this.g * 0.38f) + 0.62f;
        Iterator<T> r1 = this.d.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((View) r1.next()).setAlpha(r0);
        goto L4
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        b();
        super.onDetachedFromWindow();
    }

    public BitableSuperAgentVoiceWaveformView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setLevel(float r3) {
        this.g = RangesKt.coerceIn(r3, 0.18f, 1.0f);
        c();
    }

    public BitableSuperAgentVoiceWaveformView(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10);
        float[] r0 = {3.11f, 14.0f, 4.67f, 7.78f, 1.56f};
        this.a = r0;
        this.b = new long[]{680, 760, 640, 720, 660};
        this.c = new long[]{0, 80, 160, 240, 320};
        this.e = new ArrayList();
        this.g = 0.55f;
        setOrientation(0);
        setGravity(16);
        setClipChildren(false);
        setClipToPadding(false);
        int r2 = n.c(1.56f);
        int r1 = n.c(1.56f);
        int r3 = r0.length;
        ArrayList r4 = new ArrayList(r3);
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L8;
        View r6 = new View(r9);
        r6.setBackground(ContextCompat.getDrawable(r9, 2131232384));
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(r1, n.c(this.a[r5]));
        if (r5 <= 0) goto L7;
        r7.leftMargin = r2;
    L7:
        r6.setLayoutParams(r7);
        r6.setClickable(false);
        r4.add(r6);
        r5 = r5 + 1;
        goto L3
    L8:
        Iterator r11 = r4.iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        addView((View) r11.next());
        goto L10
    L12:
        this.d = r4;
        c();
    }
}
