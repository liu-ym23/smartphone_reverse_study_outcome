package com.ss.android.lark.chat.chatwindow.chat.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0001$B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u000bJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ(\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\rH\u0014J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u0000J\u0006\u0010#\u001a\u00020\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/view/IMCircleLoadingView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "paint", "Landroid/graphics/Paint;", "strokeWidth", "", "color", "", "rectF", "Landroid/graphics/RectF;", "paintShader", "Landroid/graphics/SweepGradient;", "loadingAnimator", "Landroid/animation/ObjectAnimator;", "setCircleStrokeWidth", "width", "setCircleColor", "onSizeChanged", "", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "isRunning", "", "startLoading", "stopLoading", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IMCircleLoadingView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f414691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f414692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f414693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f414694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObjectAnimator f414695e;

    public static final class a {
    }

    static {
    }

    public final void a() {
        if (getVisibility() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L9;
        setVisibility(0);
    L9:
        if (this.f414695e == null) goto L27;
        return;
    L27:
        ObjectAnimator r101 = ObjectAnimator.ofFloat(this, "rotation", new float[]{0.0f, 360.0f});     // Catch: Throwable -> L24
        this.f414695e = r101;     // Catch: Throwable -> L24
        if (r101 == null) goto L14;
        r101.setDuration(1000);     // Catch: Throwable -> L24
    L14:
        ObjectAnimator r102 = this.f414695e;     // Catch: Throwable -> L24
        if (r102 == null) goto L17;
        r102.setInterpolator(new LinearInterpolator());     // Catch: Throwable -> L24
    L17:
        ObjectAnimator r103 = this.f414695e;     // Catch: Throwable -> L24
        if (r103 == null) goto L20;
        r103.setRepeatCount(-1);     // Catch: Throwable -> L24
    L20:
        ObjectAnimator r104 = this.f414695e;     // Catch: Throwable -> L24
        if (r104 == null) goto L29;
        r104.start();     // Catch: Throwable -> L24
        return;
    L29:
        return;
    L24:
        th = move-exception;
        Log.e("IMCircleLoadingView", "startLoading error: " + th.getMessage());
        this.f414695e = null;
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final void b() {
        if (getVisibility() != 0) goto L5;
        boolean r100 = true;
    L7:
        if (r100 == false) goto L10;
        setVisibility(8);
    L10:
        if (this.f414695e != null) goto L12;
        return;
    L12:
        setVisibility(8);
        ObjectAnimator r101 = this.f414695e;
        if (r101 == null) goto L22;
        r101.cancel();     // Catch: Throwable -> L16
    L18:
        this.f414695e = null;
        return;
    L16:
        th = move-exception;
        Log.e("IMCircleLoadingView", "stopLoading error: " + th.getMessage());
        goto L18
    L22:
        return;
    L5:
        r100 = false;
        goto L7
    }

    public IMCircleLoadingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        r100.drawArc(this.f414694d, 0.0f, 360.0f, false, this.f414691a);
    }

    public IMCircleLoadingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        Paint r102 = new Paint(1);
        this.f414691a = r102;
        this.f414692b = 10.0f;
        this.f414693c = ColorProtector.parseColor("#4A90E2");
        this.f414694d = new RectF();
        float r103 = UIUtils.dp2px(r100, 3.0f);
        this.f414692b = r103;
        this.f414693c = UIUtils.getColor(r100, R.color.im_circle_loading_color);
        r102.setStyle(Paint.Style.STROKE);
        r102.setStrokeWidth(r103);
        r102.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        float r104 = r100;
        float r105 = r101;
        int r106 = this.f414693c;
        this.f414691a.setShader(new SweepGradient(r104 / 2.0f, r105 / 2.0f, new int[]{0, 0, r106, r106}, new float[]{0.0f, 0.25f, 0.9f, 1.0f}));
        RectF r107 = this.f414694d;
        float r108 = this.f414692b;
        r107.set(r108, r108, r104 - r108, r105 - r108);
    }
}
