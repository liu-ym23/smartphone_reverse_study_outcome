package com.bytedance.android.ui.ec.widget.guide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ui.ec.widget.tools.UnitExtensionKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ECGuideBubbleView extends FrameLayout implements ECFunctionGuideView.FunctionLayer {
    private int mArrowHeight;
    private Paint mArrowPaint;
    private final Path mArrowPath;
    private int mArrowToRightEdgeDistance;
    private int mArrowWidth;
    private FrameLayout.LayoutParams mLayerParams;
    private int mNoticeTextHeight;
    private TextView mNoticeTextView;
    private int mQuadLength;
    private int mTopDistanceToTarget;

    @Override // com.bytedance.android.ui.ec.widget.guide.ECFunctionGuideView.FunctionLayer
    public View getView() {
        return this;
    }

    @Override // com.bytedance.android.ui.ec.widget.guide.ECFunctionGuideView.FunctionLayer
    public FrameLayout.LayoutParams getLayerParams() {
        return this.mLayerParams;
    }

    public ECGuideBubbleView(Context r3) {
        super(r3);
        this.mArrowPath = new Path();
        this.mArrowPaint = new Paint();
        this.mLayerParams = new FrameLayout.LayoutParams(-2, -2);
        init(r3, false);
    }

    @Override // android.view.View
    public void onDraw(Canvas r7) {
        float r0 = getMeasuredWidth() - this.mArrowToRightEdgeDistance;
        this.mArrowPath.moveTo(r0, this.mArrowHeight);
        this.mArrowPath.lineTo(r0 - this.mArrowWidth, this.mArrowHeight);
        Path r1 = this.mArrowPath;
        float r2 = r0 - (this.mArrowWidth / 2.0f);
        int r4 = this.mQuadLength;
        r1.lineTo(r2 - r4, r4);
        Path r3 = this.mArrowPath;
        int r5 = this.mArrowWidth;
        float r6 = r0 - (r5 / 2.0f);
        float r8 = r0 - (r5 / 2.0f);
        int r9 = this.mQuadLength;
        r3.quadTo(r6, 0.0f, r8 + r9, r9);
        this.mArrowPath.close();
        r7.drawPath(this.mArrowPath, this.mArrowPaint);
    }

    public ECGuideBubbleView(Context r3, boolean r4) {
        super(r3);
        this.mArrowPath = new Path();
        this.mArrowPaint = new Paint();
        this.mLayerParams = new FrameLayout.LayoutParams(-2, -2);
        init(r3, r4);
    }

    private void init(Context r5, boolean r6) {
        setWillNotDraw(false);
        this.mQuadLength = UnitExtensionKt.dp2px(1);
        this.mArrowHeight = UnitExtensionKt.dp2px(5);
        this.mArrowWidth = UnitExtensionKt.dp2px(10);
        this.mArrowToRightEdgeDistance = UnitExtensionKt.dp2px(11);
        this.mNoticeTextHeight = UnitExtensionKt.dp2px(44);
        this.mArrowPaint.setStyle(Paint.Style.FILL);
        this.mArrowPaint.setAntiAlias(true);
        this.mNoticeTextView = new TextView(r5);
        if (r6 == false) goto L5;
        this.mArrowPaint.setColor(-1);
        this.mNoticeTextView.setBackgroundResource(2131234306);
        this.mNoticeTextView.setTextColor(-1090519040);
        this.mTopDistanceToTarget = UnitExtensionKt.dp2px(10);
    L6:
        this.mNoticeTextView.setGravity(17);
        this.mNoticeTextView.setTextSize(1, 14.0f);
        int r7 = UnitExtensionKt.dp2px(12);
        this.mNoticeTextView.setPadding(r7, r7, r7, r7);
        return;
    L5:
        this.mArrowPaint.setColor(-654311424);
        this.mNoticeTextView.setBackgroundResource(2131234248);
        this.mNoticeTextView.setTextColor(-1);
        this.mTopDistanceToTarget = UnitExtensionKt.dp2px(6);
        goto L6
    }

    public void setSingleData(int r3, int r4, String r5, String r6) {
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(-2, this.mNoticeTextHeight);
        r7.topMargin = this.mArrowHeight;
        addView(this.mNoticeTextView, r7);
        this.mNoticeTextView.setText(r5);
        this.mNoticeTextView.setIncludeFontPadding(false);
        this.mNoticeTextView.measure(0, 0);
        int r8 = (this.mNoticeTextView.getMeasuredWidth() - (this.mArrowWidth / 2)) - this.mArrowToRightEdgeDistance;
        FrameLayout.LayoutParams r9 = this.mLayerParams;
        r9.leftMargin = r3 - r8;
        r9.topMargin = r4 + this.mTopDistanceToTarget;
    }

    public void setMulData(Context r3, int r4, int r5, int r6, Function1<TextView, Unit> r7) {
        if (r3 == null) goto L4;
        int r8 = UnitExtensionKt.dp2px(16);
        int r0 = UnitExtensionKt.dp2px(12);
        this.mNoticeTextView.setPadding(r8, r0, r8, r0);
        this.mNoticeTextView.setGravity(3);
        this.mNoticeTextView.setLineSpacing(UnitExtensionKt.dp2px(5), 1.0f);
    L4:
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(r6, -2);
        r9.topMargin = this.mArrowHeight;
        addView(this.mNoticeTextView, r9);
        if (r7 == null) goto L7;
        r7.invoke(this.mNoticeTextView);
    L7:
        int r10 = (r6 - (this.mArrowWidth / 2)) - this.mArrowToRightEdgeDistance;
        FrameLayout.LayoutParams r11 = this.mLayerParams;
        r11.leftMargin = r4 - r10;
        r11.topMargin = r5 + this.mTopDistanceToTarget;
    }
}
