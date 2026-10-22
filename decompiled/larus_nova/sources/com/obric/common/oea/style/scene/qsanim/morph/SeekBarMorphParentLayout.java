package com.obric.common.oea.style.scene.qsanim.morph;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\t\u001a\u00020\u00028\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/morph/SeekBarMorphParentLayout;", "Landroid/widget/FrameLayout;", "Landroid/widget/SeekBar;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/SeekBar;", "getSeekBarChild", "()Landroid/widget/SeekBar;", "setSeekBarChild", "(Landroid/widget/SeekBar;)V", "seekBarChild", "Landroid/graphics/PointF;", "c", "Landroid/graphics/PointF;", "getLastTouchPoint", "()Landroid/graphics/PointF;", "setLastTouchPoint", "(Landroid/graphics/PointF;)V", "lastTouchPoint", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public abstract class SeekBarMorphParentLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SeekBar f396660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f396661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PointF f396662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f396663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f396664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f396665f;

    public static final class a {
    }

    static {
    }

    public SeekBarMorphParentLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SeekBarMorphParentLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public abstract void a();

    public abstract void b();

    public abstract float c(MotionEvent r100);

    public abstract void d();

    public final SeekBar getSeekBarChild() {
        SeekBar r100 = this.f396660a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("seekBarChild");
    L5:
        return r100;
    }

    public final PointF getLastTouchPoint() {
        return this.f396662c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r110) {
        SeekBar r100 = this.f396660a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("seekBarChild");
    L5:
        float r101 = r100.getProgress();
        if (r110 == null) goto L8;
        Integer r102 = Integer.valueOf(r110.getAction());
    L10:
        if (r102 != null) goto L13;
    L15:
        if (r102 != null) goto L18;
    L39:
        if (r102 != null) goto L42;
    L44:
        if (r102 != null) goto L47;
    L49:
        boolean r103 = false;
    L50:
        if (r103 == false) goto L52;
        return true;
    L52:
        if (super.dispatchTouchEvent(r110) == true) goto L57;
        return false;
    L57:
        return true;
    L47:
        if (r102.intValue() != 3) goto L49;
    L48:
        b();
        goto L49
    L42:
        if (r102.intValue() != 1) goto L44;
    L18:
        if (r102.intValue() != 2) goto L39;
        float r104 = c(r110);
        float r105 = (r101 - this.f396663d) / r104;
        float r106 = 0.0f;
        if (r105 == 0.0f) goto L22;
        this.f396661b = RangesKt.coerceIn(r105, 0.1f, 0.3f);
    L22:
        this.f396662c = new PointF(r110.getX(), r110.getY());
        this.f396663d = r101;
        float r107 = this.f396665f;
        if (r101 < r107) goto L25;
    L28:
        r106 = this.f396664e + (this.f396661b * r104);
        if (r106 <= r107) goto L31;
    L35:
        this.f396664e = r106;
        r103 = true;
    L36:
        if (r103 == false) goto L38;
        a();
    L38:
        mja.a.C6822a r108 = mja.a.f514263a;
        mja.a.a("MorphSeekBarParentLayout", "needMorph: " + r103 + ", force: " + r106 + ", process: " + r101 + ", deltaMove: " + r104 + ", forceFactor: " + this.f396661b + ", f: " + r105);
        goto L50
    L31:
        if (r106 < 0) goto L35;
        this.f396664e = r101;
    L34:
        r103 = false;
        goto L36
    L25:
        if (r101 <= 0) goto L28;
        this.f396664e = r101;
        goto L34
    L13:
        if (r102.intValue() != 0) goto L15;
        d();
        this.f396662c = new PointF(r110.getX(), r110.getY());
        this.f396663d = r101;
        this.f396664e = r101;
        this.f396661b = 0.2f;
        goto L49
    L8:
        r102 = null;
        goto L10
    }

    public final void setLastTouchPoint(PointF r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f396662c = r100;
    }

    public final void setSeekBarChild(SeekBar r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f396660a = r100;
    }

    public SeekBarMorphParentLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f396662c = new PointF(0.0f, 0.0f);
        this.f396665f = 100;
    }

    public /* synthetic */ SeekBarMorphParentLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
