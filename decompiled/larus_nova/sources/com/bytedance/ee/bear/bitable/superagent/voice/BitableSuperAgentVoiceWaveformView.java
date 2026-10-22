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
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0018J\b\u0010\u001c\u001a\u00020\u0018H\u0014J\b\u0010\u001d\u001a\u00020\u0018H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/voice/BitableSuperAgentVoiceWaveformView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "barHeightsDp", "", "barDurations", "", "barBeginDelays", "bars", "", "Landroid/view/View;", "animators", "", "Landroid/animation/ObjectAnimator;", "isAnimating", "", "currentLevel", "", "setLevel", "", "newLevel", "startAnimating", "stopAnimating", "onDetachedFromWindow", "updateBarAlpha", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSuperAgentVoiceWaveformView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f215929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f215930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f215931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<View> f215932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<ObjectAnimator> f215933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f215934f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f215935g;

    public final void a() {
        if (this.f215934f == false) goto L5;
        return;
    L5:
        this.f215934f = true;
        Iterator<T> r100 = this.f215932d.iterator();
        int r101 = 0;
    L7:
        if (r100.hasNext() == false) goto L12;
        Object r102 = r100.next();
        int r103 = r101 + 1;
        if (r101 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        ObjectAnimator r104 = ObjectAnimator.ofPropertyValuesHolder((View) r102, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe(View.SCALE_Y, new Keyframe[]{Keyframe.ofFloat(0.0f, 0.45f), Keyframe.ofFloat(0.36f, 1.0f), Keyframe.ofFloat(0.72f, 0.62f), Keyframe.ofFloat(1.0f, 0.45f)})});
        r104.setDuration(this.f215930b[r101]);
        r104.setStartDelay(this.f215931c[r101]);
        r104.setRepeatCount(-1);
        r104.setInterpolator(new AccelerateDecelerateInterpolator());
        ((ArrayList) this.f215933e).add(r104);
        r104.start();
        r101 = r103;
        goto L7
    }

    public final void b() {
        if (this.f215934f == true) goto L5;
        return;
    L5:
        this.f215934f = false;
        Iterator<T> r100 = this.f215933e.iterator();
    L7:
        if (r100.hasNext() == false) goto L9;
        ((ObjectAnimator) r100.next()).cancel();
        goto L7
    L9:
        ((ArrayList) this.f215933e).clear();
        Iterator<T> r101 = this.f215932d.iterator();
    L11:
        if (r101.hasNext() == false) goto L13;
        ((View) r101.next()).setScaleY(1.0f);
        goto L11
    }

    public final void c() {
        float r100 = (this.f215935g * 0.38f) + 0.62f;
        Iterator<T> r101 = this.f215932d.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((View) r101.next()).setAlpha(r100);
        goto L4
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        b();
        super.onDetachedFromWindow();
    }

    public BitableSuperAgentVoiceWaveformView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setLevel(float r100) {
        this.f215935g = RangesKt.coerceIn(r100, 0.18f, 1.0f);
        c();
    }

    public BitableSuperAgentVoiceWaveformView(Context r100, AttributeSet r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110);
        float[] r101 = {3.11f, 14.0f, 4.67f, 7.78f, 1.56f};
        this.f215929a = r101;
        this.f215930b = new long[]{680, 760, 640, 720, 660};
        this.f215931c = new long[]{0, 80, 160, 240, 320};
        this.f215933e = new ArrayList();
        this.f215935g = 0.55f;
        setOrientation(0);
        setGravity(16);
        setClipChildren(false);
        setClipToPadding(false);
        int r102 = n.c(1.56f);
        int r103 = n.c(1.56f);
        int r104 = r101.length;
        ArrayList r105 = new ArrayList(r104);
        int r106 = 0;
    L3:
        if (r106 >= r104) goto L8;
        View r107 = new View(r100);
        r107.setBackground(ContextCompat.getDrawable(r100, R.drawable.bitable_superagent_voice_wave_bar));
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(r103, n.c(this.f215929a[r106]));
        if (r106 <= 0) goto L7;
        r108.leftMargin = r102;
    L7:
        r107.setLayoutParams(r108);
        r107.setClickable(false);
        r105.add(r107);
        r106 = r106 + 1;
        goto L3
    L8:
        Iterator r109 = r105.iterator();
    L10:
        if (r109.hasNext() == false) goto L12;
        addView((View) r109.next());
        goto L10
    L12:
        this.f215932d = r105;
        c();
    }
}
