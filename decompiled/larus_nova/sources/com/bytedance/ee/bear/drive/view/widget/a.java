package com.bytedance.ee.bear.drive.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f225969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f225970b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.view.widget.a$a, reason: collision with other inner class name */
    public static final class C3244a {
    }

    static {
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        float r101 = ((getWidth() - getPaddingStart()) - getPaddingEnd()) / 2.0f;
        float r102 = ((getHeight() - getPaddingTop()) - getPaddingBottom()) / 2.0f;
        float r103 = Math.min(r102, r102);
        r100.translate(getPaddingStart() + r101, getPaddingTop() + r102);
        r100.drawCircle(0.0f, 0.0f, r103, this.f225970b);
        if (this.f225969a == false) goto L5;
        r100.drawRect(0.0f, -r103, r103, 0.0f, this.f225970b);
        return;
    L5:
        float r104 = -r103;
        r100.drawRect(r104, r104, 0.0f, 0.0f, this.f225970b);
    }

    public a(Context r100, boolean r101) {
        int r102 = ContextCompat.getColor(r100, R.color.ud_B500);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f225969a = r101;
        Paint r103 = new Paint(1);
        this.f225970b = r103;
        r103.setColor(r102);
        invalidate();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getMode(r101);
        if (r102 != 1073741824) goto L5;
        int r104 = View.MeasureSpec.getSize(r100);
    L6:
        if (r103 != 1073741824) goto L8;
        int r105 = View.MeasureSpec.getSize(r101);
    L9:
        setMeasuredDimension(r104, r105);
        return;
    L8:
        r105 = (UIHelper.dp2px(20.0f) + getPaddingTop()) + getPaddingBottom();
        goto L9
    L5:
        r104 = (UIHelper.dp2px(20.0f) + getPaddingStart()) + getPaddingEnd();
        goto L6
    }
}
