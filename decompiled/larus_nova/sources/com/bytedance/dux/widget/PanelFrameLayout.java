package com.bytedance.dux.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.dux.common.DuxConfig;
import com.bytedance.dux.common.PadAdaptScene;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import im4.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/dux/widget/PanelFrameLayout;", "Landroid/widget/FrameLayout;", "", "getMaxHeight", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getAdaptFoldBlackEnable", "()Z", "setAdaptFoldBlackEnable", "(Z)V", "adaptFoldBlackEnable", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class PanelFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f205923a;

    public PanelFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PanelFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final int getMaxHeight() {
        Map<PadAdaptScene, Boolean> r100 = DuxConfig.f204897a;
        if (DuxConfig.a(PadAdaptScene.PANEL) == true) goto L6;
        return Integer.MAX_VALUE;
    L6:
        int r101 = a.f490534a;
        Context r102 = getContext();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r103 = MathKt.roundToInt(TypedValue.applyDimension(1, gm4.a.d(r102).f485915b, a.a(Resources.getSystem())));
        if (r103 >= MathKt.roundToInt(TypedValue.applyDimension(1, 704, a.a(Resources.getSystem())))) goto L10;
        return Math.min((int) (((double) r103) * 0.73d), MathKt.roundToInt(TypedValue.applyDimension(1, 560, a.a(Resources.getSystem()))));
    L10:
        return MathKt.roundToInt(TypedValue.applyDimension(1, 560, a.a(Resources.getSystem())));
    }

    public final boolean getAdaptFoldBlackEnable() {
        return this.f205923a;
    }

    public final void setAdaptFoldBlackEnable(boolean r100) {
        this.f205923a = r100;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f205923a == false) goto L6;
        super.onMeasure(r100, r101);
        return;
    L6:
        int r102 = getMaxHeight();
        int r103 = View.MeasureSpec.getSize(r101);
        int r104 = View.MeasureSpec.getMode(r101);
        if (r104 == Integer.MIN_VALUE) goto L11;
        if (r104 == 0) goto L10;
        int r105 = View.MeasureSpec.makeMeasureSpec(Math.min(r103, r102), 1073741824);
    L12:
        super.onMeasure(r100, r105);
        return;
    L10:
        r105 = View.MeasureSpec.makeMeasureSpec(r102, Integer.MIN_VALUE);
        goto L12
    L11:
        r105 = View.MeasureSpec.makeMeasureSpec(Math.min(r103, r102), Integer.MIN_VALUE);
        goto L12
    }

    public PanelFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ PanelFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
