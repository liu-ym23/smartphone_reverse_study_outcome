package com.larus.setting.impl.iconchanger;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/setting/impl/iconchanger/CircleRingView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "customPaint", "Landroid/graphics/Paint;", "strokeWidth", "", "setStrokeWidth", "", "width", "setColor", "colorInt", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CircleRingView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f368344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f368345b;

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        int r101 = getWidth();
        int r102 = getHeight();
        r100.drawCircle(r101 / 2, r102 / 2, (Math.min(r101, r102) / 2) - (this.f368345b / 2), this.f368344a);
    }

    public final void setColor(int r100) {
        this.f368344a.setColor(ve8.d.a(r100, getContext()));
        invalidate();
    }

    public final void setStrokeWidth(float r100) {
        this.f368345b = r100;
        this.f368344a.setStrokeWidth(r100);
        invalidate();
    }

    public CircleRingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        Paint r102 = new Paint();
        this.f368344a = r102;
        this.f368345b = 10.0f;
        r102.setColor(-256);
        r102.setStrokeWidth(10.0f);
        r102.setStyle(Paint.Style.STROKE);
        r102.setAntiAlias(true);
    }
}
