package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0011J\u0016\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioPopupBackground;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mRippleRadiusDiff", "", "mRippleRadius", "mRipplePaint", "Landroid/graphics/Paint;", "valueAnimator", "Landroid/animation/ValueAnimator;", "lastVolume", "mMainBtnRadius", "", "mMainBtnBottomMargin", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setVolume", ITTVideoEngineEventSource.KEY_VOLUME, "setMainBtnRadiusAndBottomMargin", "radius", "bottomMargin", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioPopupBackground extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f430015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f430016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f430017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f430018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f430019e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f430020f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f430021g;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioPopupBackground f430022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f430023b;

        /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget.AudioPopupBackground$a$a, reason: collision with other inner class name */
        public static final class C5110a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AudioPopupBackground f430024a;

            public C5110a(AudioPopupBackground r100) {
                this.f430024a = r100;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                AudioPopupBackground r101 = this.f430024a;
                Object r102 = r100.getAnimatedValue();
                Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Float");
                r101.f430019e = ((Float) r102).floatValue();
                AudioPopupBackground r103 = this.f430024a;
                int r104 = c.f430003a;
                float r105 = c.o(Float.valueOf(r103.f430019e), 1, 0);
                AudioPopupBackground r106 = this.f430024a;
                r103.f430016b = (r105 * r106.f430015a) + (r106.f430020f * 0.9f);
                r106.invalidate();
            }
        }

        public a(AudioPopupBackground r100, int r101) {
            this.f430022a = r100;
            this.f430023b = r101;
        }

        public final void a() {
            AudioPopupBackground r100 = this.f430022a;
            ValueAnimator r101 = r100.f430018d;
            if (r101 == null) goto L5;
            int r102 = this.f430023b;
            r101.cancel();
            r101.setFloatValues(new float[]{r100.f430019e, r102});
            r101.start();
            return;
        L5:
            ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{r100.f430019e, this.f430023b});
            r103.setInterpolator(new AccelerateInterpolator());
            r103.setDuration(100).addUpdateListener(new C5110a(r100));
            r103.start();
            r100.f430018d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.drawCircle(getMeasuredWidth() / 2, (getMeasuredHeight() - this.f430020f) - this.f430021g, this.f430016b, this.f430017c);
    }

    public final void setVolume(int r100) {
        post(new a(this, r100));
    }

    public AudioPopupBackground(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        int r102 = c.f430003a;
        this.f430015a = c.n(this, 30);
        Paint r103 = new Paint(1);
        r103.setColor(c.c(this, R.color.function_info_content_pressed));
        r103.setAlpha(25);
        this.f430017c = r103;
    }
}
