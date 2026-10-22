package com.larus.common_ui.popupwindow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.byted.cast.common.CastMonitor;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ0\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0014J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H\u0014R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/larus/common_ui/popupwindow/ShadowConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "anchorView", "Landroid/view/View;", "getAnchorView", "()Landroid/view/View;", "setAnchorView", "(Landroid/view/View;)V", "shadowRadius", "", "getShadowRadius", "()F", "setShadowRadius", "(F)V", "cornerRadius", "shadowColor", "shadowPaint", "Landroid/graphics/Paint;", "shadowRect", "Landroid/graphics/RectF;", "onLayout", "", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "left", "top", "right", "bottom", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShadowConstraintLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f327764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f327765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f327766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f327767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f327768e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f327769f;

    public final View getAnchorView() {
        return this.f327764a;
    }

    public final float getShadowRadius() {
        return this.f327765b;
    }

    public ShadowConstraintLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f327766c = c7.b(12);
        this.f327767d = Color.argb(30, Color.red(-16777216), Color.green(-16777216), Color.blue(-16777216));
        Paint r101 = new Paint();
        r101.setAntiAlias(true);
        this.f327768e = r101;
        this.f327769f = new RectF();
        setBackgroundColor(0);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        View r101 = this.f327764a;
        if (r101 != null) goto L5;
        return;
    L5:
        float r102 = r101.getLeft();
        float r103 = r101.getTop();
        this.f327769f.set(r102, r103, r101.getWidth() + r102, r101.getHeight() + r103);
        Paint r104 = this.f327768e;
        r104.setColor(this.f327767d);
        r104.setShadowLayer(this.f327765b, 0.0f, 0.0f, this.f327767d);
        RectF r105 = this.f327769f;
        float r106 = this.f327766c;
        r100.drawRoundRect(r105, r106, r106, this.f327768e);
        super.dispatchDraw(r100);
    }

    public final void setAnchorView(View r100) {
        this.f327764a = r100;
    }

    public final void setShadowRadius(float r100) {
        this.f327765b = r100;
    }

    public ShadowConstraintLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f327766c = c7.b(12);
        this.f327767d = Color.argb(30, Color.red(-16777216), Color.green(-16777216), Color.blue(-16777216));
        Paint r102 = new Paint();
        r102.setAntiAlias(true);
        this.f327768e = r102;
        this.f327769f = new RectF();
        setBackgroundColor(0);
    }

    public ShadowConstraintLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f327766c = c7.b(12);
        this.f327767d = Color.argb(30, Color.red(-16777216), Color.green(-16777216), Color.blue(-16777216));
        Paint r103 = new Paint();
        r103.setAntiAlias(true);
        this.f327768e = r103;
        this.f327769f = new RectF();
        setBackgroundColor(0);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
