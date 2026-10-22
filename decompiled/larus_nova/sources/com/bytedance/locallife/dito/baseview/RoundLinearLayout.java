package com.bytedance.locallife.dito.baseview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/dito/baseview/RoundLinearLayout;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/locallife/dito/baseview/c;", "", "radiusDp", "", "setRadius", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public class RoundLinearLayout extends LinearLayout implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoundHelper f257315a;

    public RoundLinearLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RoundLinearLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.locallife.dito.baseview.c
    public final void e() {
        this.f257315a.f257314m = false;
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f257315a.f(r100);
        super.draw(r100);
        this.f257315a.a(r100);
    }

    public void setRadius(int r100) {
        this.f257315a.g(r100);
    }

    @Override // com.bytedance.locallife.dito.baseview.c
    public void setRadius(List<Float> r100) {
        c.a.a(this, r100);
    }

    @Override // com.bytedance.locallife.dito.baseview.c
    public final void w(Integer r100, Float r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L7;
        RoundHelper r102 = this.f257315a;
        int r103 = r100.intValue();
        float r104 = r101.floatValue();
        r102.f257310i.setColor(r103);
        r102.f257310i.setStrokeWidth(r104);
        r102.f257313l = r104;
        r102.f257314m = true;
        return;
    L7:
        return;
    }

    public RoundLinearLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        RoundHelper r103 = new RoundHelper();
        this.f257315a = r103;
        r103.d(this);
        TypedArray r104 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.left_rounded_radius, R.attr.rounded_radius}, r102, 0);
        if (r104.hasValue(1) == false) goto L5;
        r103.g(r104.getDimensionPixelOffset(1, 0));
    L5:
        r104.recycle();
    }

    public /* synthetic */ RoundLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // com.bytedance.locallife.dito.baseview.c
    public final void b(int r100, int r101, int r102, int r103) {
        this.f257315a.h(r100, r101, r102, r103);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f257315a.e(r100, r101);
    }
}
