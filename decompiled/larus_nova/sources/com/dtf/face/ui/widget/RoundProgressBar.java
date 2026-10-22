package com.dtf.face.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.shopping.store.hybrid.jsbcheck.ECStoreJsbErrorCode;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.dtf.face.log.RecordService;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import ws7.j;

/* JADX INFO: loaded from: classes22.dex */
public class RoundProgressBar extends View {
    public static final int FILL = 1;
    public static final int STROKE = 0;
    public float backColorWidth;
    public int backgroundColor;
    private Context ctx;
    public int endAngle;
    private boolean isPausing;
    private Handler mMainHandle;
    public int mProgressAngle;
    private SweepGradient mRoundShader;
    private int mWidth;
    private int max;
    private int maxMiliSeconds;
    public Paint paint;
    private Runnable processRunnable;
    public int progress;
    public int radius;
    public int roundColor;
    private RoundProgressCallback roundProgressCallback;
    public int roundProgressColor;
    public boolean roundShader;
    public int roundShaderEndColor;
    public int roundShaderStartColor;
    public float roundWidth;
    public int secondProgressColor;
    public int startAngle;
    public int style;
    public int textColor;
    public boolean textIsDisplayable;
    public float textSize;

    public synchronized int getMax() {
        monitor-enter(this);
        int r100 = this.max;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int getProgress() {
        monitor-enter(this);
        int r100 = this.progress;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public void stopProcess() {
        this.mMainHandle.removeCallbacks(this.processRunnable);
    }

    public int getCricleColor() {
        return this.roundColor;
    }

    public int getCricleProgressColor() {
        return this.roundProgressColor;
    }

    public int getRadius() {
        return this.radius;
    }

    public float getRoundWidth() {
        return this.roundWidth;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public float getTextSize() {
        return this.textSize;
    }

    public RoundProgressBar(Context r100) {
        this(r100, null);
        this.ctx = r100;
    }

    public static /* synthetic */ boolean access$000(RoundProgressBar r100) {
        return r100.isPausing;
    }

    public static /* synthetic */ int access$100(RoundProgressBar r100) {
        return r100.maxMiliSeconds;
    }

    public static /* synthetic */ Handler access$200(RoundProgressBar r100) {
        return r100.mMainHandle;
    }

    public static /* synthetic */ RoundProgressCallback access$300(RoundProgressBar r100) {
        return r100.roundProgressCallback;
    }

    @Override // android.view.View
    public void onDraw(Canvas r110) {
        super.onDraw(r110);
        int r100 = getWidth() / 2;
        float r101 = r100;
        this.radius = (int) (r101 - (this.roundWidth / 2.0f));
        this.paint.setColor(this.roundColor);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.roundWidth);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.paint.setColor(this.backgroundColor);
        this.paint.setStrokeWidth(0.0f);
        this.paint.setColor(this.textColor);
        this.paint.setTextSize(this.textSize);
        this.paint.setTypeface(Typeface.DEFAULT_BOLD);
        int r102 = (int) ((this.progress / this.max) * 100.0f);
        float r103 = this.paint.measureText(r102 + GXTemplateKey.GAIAX_PE);
        this.paint.setShader(null);
        if (this.textIsDisplayable == false) goto L8;
        if (r102 == 0) goto L8;
        if (this.style != 0) goto L8;
        r110.drawText(r102 + GXTemplateKey.GAIAX_PE, r101 - (r103 / 2.0f), r101 + (this.textSize / 2.0f), this.paint);
    L8:
        this.paint.setStrokeWidth(this.roundWidth);
        int r104 = this.radius;
        float r105 = r100 - r104;
        float r106 = r100 + r104;
        RectF r107 = new RectF(r105, r105, r106, r106);
        this.paint.setColor(this.roundColor);
        int r108 = this.style;
        if (r108 == 0) goto L15;
        if (r108 != 1) goto L19;
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        int r109 = this.progress;
        if (r109 == 0) goto L17;
        int r111 = this.startAngle;
        r110.drawArc(r107, r111 + 90, ((this.endAngle - r111) * r109) / this.max, true, this.paint);
        return;
    L17:
        return;
    L19:
        return;
    L15:
        paintStroke(r110, r107);
    }

    public void pauseProcess(boolean r100) {
        this.isPausing = r100;
    }

    @Override // android.view.View
    public void setBackgroundColor(int r100) {
        this.backgroundColor = r100;
        postInvalidate();
    }

    public void setCricleColor(int r100) {
        this.roundColor = r100;
    }

    public void setCricleProgressColor(int r100) {
        this.roundProgressColor = r100;
    }

    public void setGradientColor(int r100) {
        this.roundShaderEndColor = r100;
    }

    public synchronized void setMax(int r100) {
        monitor-enter(this);
        if (r100 < 0) goto L8;
        this.max = r100;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L8:
        throw new IllegalArgumentException("max not less than 0");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized void setProgress(int r100) {
        monitor-enter(this);
        if (r100 < 0) goto L12;
        int r101 = this.max;     // Catch: Throwable -> L13
        if (r100 <= r101) goto L7;
        r100 = r101;
    L7:
        if (r100 > r101) goto L9;
        this.progress = r100;     // Catch: Throwable -> L13
        postInvalidate();     // Catch: Throwable -> L13
    L9:
        monitor-exit(this);
        return;
    L12:
        throw new IllegalArgumentException("progress not less than 0");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public synchronized void setProgressAngle(int r100) {
        monitor-enter(this);
        this.mProgressAngle = r100;     // Catch: Throwable -> L6
        postInvalidate();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void setRoundColor(int r100) {
        this.roundColor = r100;
        postInvalidate();
    }

    public void setRoundProgressColor(int r100) {
        this.roundProgressColor = r100;
    }

    public void setRoundWidth(float r100) {
        this.roundWidth = r100;
    }

    public void setStartColor(int r100) {
        this.roundShaderStartColor = r100;
    }

    public void setTextColor(int r100) {
        this.textColor = r100;
    }

    public void setTextSize(float r100) {
        this.textSize = r100;
    }

    public RoundProgressBar(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
        this.ctx = r100;
    }

    private void paintStroke(Canvas r110, RectF r111) {
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setColor(this.roundColor);
        int r100 = this.startAngle;
        r110.drawArc(r111, r100, this.endAngle - r100, false, this.paint);
        if (this.roundShader == true) goto L5;
    L11:
        SweepGradient r101 = this.mRoundShader;
        if (r101 == null) goto L14;
        this.paint.setShader(r101);
    L14:
        this.paint.setColor(this.roundProgressColor);
        r110.drawArc(r111, this.startAngle, (this.progress * (this.endAngle - this.startAngle)) / getMax(), false, this.paint);
        this.paint.setShader(null);
        return;
    L5:
        if (this.roundShaderStartColor == 0) goto L11;
        if (this.roundShaderEndColor == 0) goto L11;
        if (this.mRoundShader != null) goto L11;
        float r102 = r111.centerX();
        float r103 = r111.centerY();
        this.mRoundShader = new SweepGradient(r102, r103, new int[]{this.roundShaderStartColor, this.roundShaderEndColor}, null);
        Matrix r104 = new Matrix();
        r104.setRotate(90.0f, r102, r103);
        this.mRoundShader.setLocalMatrix(r104);
        goto L11
    }

    public void initRoundProgressBarAttrs(Context r110, AttributeSet r111) {
        TypedArray r100 = r110.obtainStyledAttributes(r111, new int[]{R.attr.dtf_face_background_color, R.attr.dtf_face_color_bg_width, R.attr.dtf_face_end_angle, R.attr.dtf_face_gradient_color_end, R.attr.dtf_face_gradient_color_start, R.attr.dtf_face_max, R.attr.dtf_face_progress_shader, R.attr.dtf_face_round_color, R.attr.dtf_face_round_progress_color, R.attr.dtf_face_round_width, R.attr.dtf_face_start_angle, R.attr.dtf_face_style, R.attr.dtf_face_text_color, R.attr.dtf_face_text_is_displayable, R.attr.dtf_face_text_size, R.attr.dtf_face_use_xml});     // Catch: Throwable -> L7
        if (r100 == null) goto L9;
        this.roundColor = r100.getColor(7, -65536);     // Catch: Throwable -> L7
        this.roundProgressColor = r100.getColor(8, FakePickerAvatarCreator.GREEN);     // Catch: Throwable -> L7
        this.secondProgressColor = r100.getColor(8, FakePickerAvatarCreator.GREEN);     // Catch: Throwable -> L7
        this.textColor = r100.getColor(12, FakePickerAvatarCreator.GREEN);     // Catch: Throwable -> L7
        this.textSize = r100.getDimension(14, 15.0f);     // Catch: Throwable -> L7
        this.roundWidth = r100.getDimension(9, 5.0f);     // Catch: Throwable -> L7
        this.max = r100.getInteger(5, 100);     // Catch: Throwable -> L7
        this.textIsDisplayable = r100.getBoolean(13, true);     // Catch: Throwable -> L7
        this.style = r100.getInt(11, 0);     // Catch: Throwable -> L7
        this.roundShader = r100.getBoolean(6, false);     // Catch: Throwable -> L7
        this.backColorWidth = r100.getDimension(1, 0.0f);     // Catch: Throwable -> L7
        this.roundShaderStartColor = r100.getColor(4, 0);     // Catch: Throwable -> L7
        this.roundShaderEndColor = r100.getColor(3, 0);     // Catch: Throwable -> L7
        this.startAngle = r100.getInt(10, 0);     // Catch: Throwable -> L7
        this.endAngle = r100.getInt(2, 360);     // Catch: Throwable -> L7
        this.backgroundColor = r100.getColor(0, -1);     // Catch: Throwable -> L7
        r100.recycle();     // Catch: Throwable -> L7
    L9:
        int r101 = this.roundColor;
        if (r101 == (-65536)) goto L12;
        if (r101 == 0) goto L12;
        return;
    L12:
        this.roundColor = ColorProtector.parseColor("#dfe6eb");
        this.roundProgressColor = ColorProtector.parseColor("#FF6A00");
        this.secondProgressColor = ColorProtector.parseColor("#FF6A00");
        this.textColor = -16777216;
        this.roundWidth = j.a(getContext(), 5.0f);
        this.max = 100;
        this.textIsDisplayable = false;
        this.style = 0;
        this.roundShader = true;
        this.backColorWidth = 0.0f;
        this.roundShaderStartColor = ColorProtector.parseColor("#dfe6eb");
        this.roundShaderEndColor = ColorProtector.parseColor("#FF6A00");
        this.startAngle = ECStoreJsbErrorCode.EMPTY_NO_POLICY;
        this.endAngle = 60;
        this.backgroundColor = -1;
        return;
    L7:
        th = move-exception;
        RecordService.getInstance().recordEvent(4, "FaceUiException", new String[]{"msg", RecordService.getStackTraceString(th)});
        goto L9
    }

    public void startProcess(int r100, RoundProgressCallback r101) {
        this.roundProgressCallback = r101;
        setProgress(0);
        this.maxMiliSeconds = r100;
        this.mMainHandle.post(this.processRunnable);
    }

    public RoundProgressBar(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.isPausing = false;
        this.style = 0;
        this.radius = 0;
        this.maxMiliSeconds = -1;
        this.processRunnable = new AnonymousClass1(this);
        this.mProgressAngle = 0;
        this.paint = new Paint();
        this.mMainHandle = new Handler(Looper.getMainLooper());
        initRoundProgressBarAttrs(r100, r101);
    }
}
