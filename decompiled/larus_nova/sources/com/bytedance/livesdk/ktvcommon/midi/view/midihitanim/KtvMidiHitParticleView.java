package com.bytedance.livesdk.ktvcommon.midi.view.midihitanim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.livesdk.ktvcommon.midi.model.HitType;
import com.bytedance.livesdk.ktvcommon.midi.view.LiveDegradeFpsAnimator;
import com.bytedance.livesdk.ktvcommon.midi.view.j;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import vm2.h;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/livesdk/ktvcommon/midi/view/midihitanim/KtvMidiHitParticleView;", "Landroid/widget/RelativeLayout;", "", "", "gap", "", "setAnimGap", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMidiHitParticleView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f256093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f256094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f256095c;

    public KtvMidiHitParticleView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KtvMidiHitParticleView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a(j r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        b r101 = this.f256093a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        r101.f256113k = r100.F();
        r101.f256114l = r100.D();
        a r102 = this.f256094b;
        b r103 = this.f256093a;
        int r104 = r103.f256113k;
        int r105 = r103.f256114l;
        r102.a(r102.f256096a, r104);
        r102.a(r102.f256097b, r105);
    }

    public void setAnimGap(int r100) {
        this.f256093a.f256115m = r100;
    }

    public KtvMidiHitParticleView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        int r113 = b.f256102n;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        b r114 = new b(s1.f(92.0f), s1.f(2.0f), s1.f(70.0f), s1.f(30.0f), s1.f(80.0f), s1.f(40.0f), s1.f(14.0f), h.w(), s1.f(0.0f));
        this.f256093a = r114;
        KtvHitResourceManager r100 = new KtvHitResourceManager();
        a r101 = new a(this, r114);
        this.f256094b = r101;
        this.f256095c = new d(r110, this, r114, r100, r101);
    }

    public /* synthetic */ KtvMidiHitParticleView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void b(float r110, float r111, HitType r210, int r211, boolean r212) {
        float r100 = r111;
        if (r212 == false) goto L5;
        boolean r101 = this.f256094b.f256097b.a();
    L6:
        if (r101 == true) goto L8;
        return;
    L8:
        d r102 = this.f256095c;
        r102.f256126j.f256104b = r100;
        KtvHitResourceManager r103 = r102.f256127k;
        int r104 = 3;
        int r105 = 2;
        boolean r106 = true;
        if (r210 == null) goto L15;
        r103.getClass();
        int r107 = c.f256116a[r210.ordinal()];
        if (r107 == 1) goto L19;
        if (r107 == 2) goto L19;
        if (r107 != 3) goto L15;
        if (r212 == false) goto L18;
        List r108 = (List) r103.f256092c.getValue();
    L20:
        List r109 = CollectionsKt.filterNotNull(r108);
        if (r109.isEmpty() == true) goto L77;
        int r112 = 0;
        int r113 = Math.min(r211, RangesKt.coerceAtLeast(r102.f256124h - ((ArrayList) r102.f256118b).size(), 0));
        if (r113 <= 0) goto L81;
        int r114 = 0;
    L27:
        if (r114 >= r113) goto L82;
        Drawable r115 = (Drawable) ListProtector.get(r109, r102.f256117a.nextInt(r109.size()));
        if (r212 == false) goto L31;
        final ImageView r116 = r102.f256128l.f256097b.b();
    L33:
        if (r116 == null) goto L35;
        r116.setLayerType(r105, null);
    L36:
        if (r116 == null) goto L76;
        r116.setImageDrawable(r115);
        r116.setX(r110);
        r116.setY(r100);
        r116.setAlpha(1.0f);
        r116.setScaleX(1.0f);
        r116.setScaleY(1.0f);
        r116.setRotation(0.0f);
        r116.setVisibility(r112);
        r116.clearAnimation();
        if ((Intrinsics.areEqual(r116.getParent(), r102.f256125i) ^ r106) == false) goto L41;
        r102.f256125i.addView(r116);
    L41:
        if (r212 == false) goto L43;
        boolean r117 = r102.f256117a.nextBoolean();
    L44:
        b r118 = r102.f256126j;
        float r119 = r118.f256103a;
        float r120 = r118.f256105c;
        final PointF r121 = new PointF(r119 - r120, (r118.f256104b + r118.f256115m) - r120);
        b r122 = r102.f256126j;
        if (r212 == false) goto L47;
        int r123 = r122.f256108f;
    L48:
        if (r212 == false) goto L50;
        int r124 = r122.f256109g;
    L51:
        int r125 = r102.f256117a.nextInt((r123 * 2) / r104);
        int r126 = r102.f256117a.nextInt(r124);
        if (r117 == false) goto L54;
        b r127 = r102.f256126j;
        float r128 = (((r127.f256104b + r127.f256115m) - r124) + r126) - r127.f256105c;
    L55:
        float r129 = RangesKt.coerceIn(r128, 0.0f, r102.f256125i.getHeight());
        b r130 = r102.f256126j;
        final PointF r131 = new PointF(((r130.f256103a - r123) + r125) - r130.f256105c, r129);
        int r132 = Math.abs((int) (r121.y - r131.y));
        float r133 = r131.x;
        float r134 = (r133 + ((r121.x - r133) / 2)) - r102.f256126j.f256105c;
        float r135 = r131.y;
        SecureRandom r136 = r102.f256117a;
        if (r132 > 0) goto L59;
        r132 = 1;
    L59:
        final PointF r137 = new PointF(r134, (r135 + r136.nextInt(r132)) - r102.f256126j.f256105c);
        LiveDegradeFpsAnimator r138 = r102.f256119c.a(new MidiParticleManager$createMoveAnimation$bezierAnim$1(r137, r121, r131));
        r138.a(d.a(r212));
        r138.setObjectValues(new Object[]{r121, r131});
        r138.setEvaluator(new com.bytedance.android.live.ktv.common.midi.a(r137));
        r138.removeAllUpdateListeners();
        r138.addUpdateListener(new e(r116));
        LiveDegradeFpsAnimator r139 = r102.f256120d.a(new MidiParticleManager$createMoveAnimation$rotationAnim$1(r116));
        r139.a(d.a(r212));
        r139.setFloatValues(new float[]{0.0f, 360.0f});
        r139.removeAllUpdateListeners();
        AnimatorSet r140 = new AnimatorSet();
        r140.playTogether(new Animator[]{r138, r139});
        LiveDegradeFpsAnimator r141 = r102.f256121e.a(new MidiParticleManager$createEnterAnimation$alphaAnim$1(r116));
        r141.a(d.a(r212));
        r141.setFloatValues(new float[]{0.0f, 1.0f});
        r141.removeAllUpdateListeners();
        LiveDegradeFpsAnimator r142 = r102.f256122f.a(new MidiParticleManager$createEnterAnimation$scaleXAnim$1(r116));
        r142.a(d.a(r212));
        r142.setFloatValues(new float[]{0.0f, 1.0f});
        r142.removeAllUpdateListeners();
        LiveDegradeFpsAnimator r143 = r102.f256123g.a(new MidiParticleManager$createEnterAnimation$scaleYAnim$1(r116));
        r143.a(d.a(r212));
        r143.setFloatValues(new float[]{0.0f, 1.0f});
        r143.removeAllUpdateListeners();
        AnimatorSet r144 = new AnimatorSet();
        r144.playTogether(new Animator[]{r141, r142, r143});
        b r145 = r102.f256126j;
        if (r212 == false) goto L62;
        long r146 = r145.f256112j;
    L63:
        r144.setDuration(r146 / ((long) 3));
        LiveDegradeFpsAnimator r147 = r102.f256121e.a(new MidiParticleManager$createEndAnimation$alphaAnim$1(r116));
        r147.a(d.a(r212));
        r147.setFloatValues(new float[]{1.0f, 0.0f});
        r147.removeAllUpdateListeners();
        LiveDegradeFpsAnimator r148 = r102.f256122f.a(new MidiParticleManager$createEndAnimation$scaleXAnim$1(r116));
        r148.a(d.a(r212));
        r148.setFloatValues(new float[]{1.0f, 0.0f});
        r148.removeAllUpdateListeners();
        LiveDegradeFpsAnimator r149 = r102.f256123g.a(new MidiParticleManager$createEndAnimation$scaleYAnim$1(r116));
        r149.a(d.a(r212));
        r149.setFloatValues(new float[]{1.0f, 0.0f});
        r149.removeAllUpdateListeners();
        b r150 = r102.f256126j;
        if (r212 == false) goto L66;
        long r151 = r150.f256112j;
    L67:
        long r152 = r151 / ((long) 5);
        AnimatorSet r153 = new AnimatorSet();
        r153.playTogether(new Animator[]{r147, r148, r149});
        b r154 = r102.f256126j;
        if (r212 == false) goto L70;
        long r155 = r154.f256112j;
    L71:
        r153.setStartDelay(r155 - r152);
        r153.setDuration(r152);
        AnimatorSet r156 = new AnimatorSet();
        r104 = 3;
        r106 = true;
        r156.playTogether(new Animator[]{r140, r144, r153});
        r156.setInterpolator(new LinearInterpolator());
        b r157 = r102.f256126j;
        if (r212 == false) goto L74;
        long r158 = r157.f256112j;
    L75:
        r156.setDuration(r158);
        r156.addListener(new f(r102, new WeakReference(r116), r212));
        ((ArrayList) r102.f256118b).add(r156);
        r156.start();
        goto L76
    L74:
        r158 = r157.f256111i;
        goto L75
    L70:
        r155 = r154.f256111i;
        goto L71
    L66:
        r151 = r150.f256111i;
        goto L67
    L62:
        r146 = r145.f256111i;
        goto L63
    L54:
        b r159 = r102.f256126j;
        r128 = (((r159.f256104b + r159.f256115m) + r124) - r126) + r159.f256105c;
        goto L55
    L50:
        r124 = r122.f256107e;
        goto L51
    L47:
        r123 = r122.f256106d;
        goto L48
    L43:
        r117 = true;
    L76:
        r114 = r114 + 1;
        r100 = r111;
        r113 = r113;
        r105 = 2;
        r112 = 0;
        goto L27
    L35:
        r116 = null;
        goto L36
    L31:
        r116 = r102.f256128l.f256096a.b();
        goto L33
    L82:
        return;
    L81:
        return;
    L77:
        return;
    L18:
        r108 = (List) r103.f256091b.getValue();
    L19:
        r108 = (List) r103.f256090a.getValue();
    L15:
        r108 = (List) r103.f256090a.getValue();
        goto L20
    L5:
        r101 = this.f256094b.f256096a.a();
        goto L6
    }
}
