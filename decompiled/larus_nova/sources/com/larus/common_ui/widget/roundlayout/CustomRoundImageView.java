package com.larus.common_ui.widget.roundlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\rR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/common_ui/widget/roundlayout/CustomRoundImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "path", "Landroid/graphics/Path;", "cornerRadius", "", "usedWidth", "usedHeight", "rectF", "Landroid/graphics/RectF;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setCornerRadius", "radius", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomRoundImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f328722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f328723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f328724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f328725d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RectF f328726e;

    public static final class a {
    }

    static {
    }

    public CustomRoundImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CustomRoundImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L13
        if (this.f328724c == getWidth()) goto L6;
    L7:
        this.f328724c = getWidth();     // Catch: Throwable -> L13
        this.f328725d = getHeight();     // Catch: Throwable -> L13
        this.f328726e = new RectF(0.0f, 0.0f, getWidth(), getHeight());     // Catch: Throwable -> L13
    L8:
        RectF r102 = this.f328726e;     // Catch: Throwable -> L13
        if (r102 == null) goto L11;
        Path r103 = this.f328722a;     // Catch: Throwable -> L13
        float r104 = this.f328723b;     // Catch: Throwable -> L13
        r103.addRoundRect(r102, r104, r104, Path.Direction.CW);     // Catch: Throwable -> L13
        r100.clipPath(this.f328722a);     // Catch: Throwable -> L13
    L11:
        super.onDraw(r100);     // Catch: Throwable -> L13
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L22;
        FLogger.f375446a.e("CustomRoundImageView", "on err = " + r106);
        return;
    L22:
        return;
    L6:
        if (this.f328725d == getHeight()) goto L8;
    L13:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public final void setCornerRadius(float r100) {
        this.f328723b = r100;
        invalidate();
    }

    public CustomRoundImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f328722a = new Path();
        if (r101 == null) goto L6;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.cus_corner_radius});
        this.f328723b = r103.getDimensionPixelSize(0, 0);
        r103.recycle();
        return;
    }

    public /* synthetic */ CustomRoundImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
