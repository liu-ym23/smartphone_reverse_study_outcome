package com.larus.avlink.record.page;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/avlink/record/page/UploadProgressView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_trackPaint", "Landroid/graphics/Paint;", "_progressPaint", "_arcRect", "Landroid/graphics/RectF;", "_progress", "", "setProgress", "", "progress", "onDraw", "canvas", "Landroid/graphics/Canvas;", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UploadProgressView extends View {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f294200e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f294201f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f294202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f294203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f294204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f294205d;

    public static final class a {
    }

    public UploadProgressView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public UploadProgressView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    static {
        f294200e = ColorProtector.parseColor("#CCCCCC");
        f294201f = ColorProtector.parseColor("#0066FF");
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        float r101 = getWidth() * 0.12f;
        this.f294202a.setStrokeWidth(r101);
        this.f294203b.setStrokeWidth(r101);
        float r102 = r101 / 2.0f;
        this.f294204c.set(r102, r102, getWidth() - r102, getHeight() - r102);
        r100.drawArc(this.f294204c, 0.0f, 360.0f, false, this.f294202a);
        r100.drawArc(this.f294204c, -90.0f, this.f294205d * 360.0f, false, this.f294203b);
    }

    public final void setProgress(float r100) {
        float r101 = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        if (r101 != this.f294205d) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        this.f294205d = r101;
        invalidate();
        return;
    L9:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public UploadProgressView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.STROKE);
        r103.setColor(f294200e);
        this.f294202a = r103;
        Paint r104 = new Paint(1);
        r104.setStyle(Paint.Style.STROKE);
        r104.setColor(f294201f);
        r104.setStrokeCap(Paint.Cap.ROUND);
        this.f294203b = r104;
        this.f294204c = new RectF();
    }

    public /* synthetic */ UploadProgressView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
