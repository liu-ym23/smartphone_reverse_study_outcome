package com.obric.oui.progress;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewKt;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes34.dex */
public class ODownloadProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f402505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f402506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f402507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f402508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f402509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f402510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f402511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f402512h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ValueAnimator f402513i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f402514j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f402515k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f402516l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Drawable f402517m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Drawable f402518n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f402519o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Drawable f402520p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Drawable f402521q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Drawable f402522r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Drawable f402523s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Path f402524t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ValueAnimator f402525u;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f402526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f402527b;

        public class a implements Parcelable.Creator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r100) {
                return new SavedState(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r100) {
                return new SavedState[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r100) {
            super(r100);
            this.f402526a = r100.readInt();
            this.f402527b = r100.readInt();
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f402526a);
            r100.writeInt(this.f402527b);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Size {
        public static final int LARGE = 0;
        public static final int MEDIUM = 1;
        public static final int SMALL = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
        public static final int EMPTY = 10;
        public static final int FAILED = 5;
        public static final int PAUSED = 1;
        public static final int PROCESSING = 0;
        public static final int RESUMED = 2;
        public static final int RETRY = 3;
        public static final int SUCCEED = 4;
    }

    public class a implements Function1<View, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ODownloadProgressView f402528a;

        public a(ODownloadProgressView r100) {
            this.f402528a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(View r100) {
            ODownloadProgressView r101 = this.f402528a;
            if (r101.f402505a == 0) goto L5;
        L11:
            this.f402528a.a();
            return Unit.INSTANCE;
        L5:
            if (r101.isShown() == false) goto L11;
            if (this.f402528a.f402525u.isRunning() == true) goto L13;
            this.f402528a.a();
            this.f402528a.f402525u.setInterpolator(new LinearInterpolator());
            ODownloadProgressView r102 = this.f402528a;
            r102.f402525u.setDuration(r102.f402516l);
            this.f402528a.f402525u.setFloatValues(new float[]{0.0f, 360.0f});
            this.f402528a.f402525u.addUpdateListener(new com.obric.oui.progress.a(this));
            this.f402528a.f402525u.setRepeatCount(-1);
            this.f402528a.f402525u.start();
            return Unit.INSTANCE;
        L13:
            return Unit.INSTANCE;
        }
    }

    public void setAlphaAnimationDuration(long r100) {
    }

    public void setProgressDuration(int r100) {
    }

    private Drawable getCurrentStateDrawable() {
        return c(this.f402505a);
    }

    private Drawable getLastStateDrawable() {
        return c(this.f402506b);
    }

    public final void a() {
        this.f402525u.removeAllUpdateListeners();
        this.f402525u.cancel();
    }

    public final void d() {
        if (this.f402505a == 0) goto L6;
        a();
        return;
    L6:
        ViewKt.doOnPreDraw(this, new a(this));
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        this.f402508d = 255;
        this.f402513i.removeAllUpdateListeners();
        this.f402513i.cancel();
        a();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        r100.f402526a = this.f402512h;
        r100.f402527b = this.f402505a;
        return r100;
    }

    public int getCurrentState() {
        return this.f402505a;
    }

    public Drawable getDownloadDrawable() {
        return this.f402519o;
    }

    public Drawable getFailedDrawable() {
        return this.f402523s;
    }

    public int getLastState() {
        return this.f402506b;
    }

    public Drawable getPauseDrawable() {
        return this.f402520p;
    }

    public Drawable getProcessingDrawable() {
        return this.f402517m;
    }

    public int getProgress() {
        return this.f402512h;
    }

    public Drawable getProgressBgDrawable() {
        return this.f402518n;
    }

    public Drawable getRetryDrawable() {
        return this.f402521q;
    }

    public Drawable getSucceedDrawable() {
        return this.f402522r;
    }

    public ODownloadProgressView(Context r100) {
        this(r100, null);
    }

    public static int b(float r100) {
        Resources r101 = Resources.getSystem();
        return (int) (r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density);
    }

    public final Drawable c(int r100) {
        if (r100 == 0) goto L20;
        if (r100 == 1) goto L26;
        if (r100 == 2) goto L25;
        if (r100 == 3) goto L24;
        if (r100 == 4) goto L23;
        if (r100 == 5) goto L22;
        return null;
    L22:
        return this.f402523s;
    L23:
        return this.f402522r;
    L24:
        return this.f402521q;
    L25:
        return this.f402520p;
    L26:
        return this.f402519o;
    L20:
        return this.f402517m;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (this.f402507c != null) goto L5;
        this.f402507c = new Paint();
    L5:
        this.f402507c.reset();
        boolean r100 = true;
        this.f402507c.setAntiAlias(true);
        int r101 = this.f402509e / 2;
        r110.save();
        Drawable r102 = getLastStateDrawable();
        if (r102 != null) goto L8;
    L20:
        Drawable r103 = getCurrentStateDrawable();
        if (r103 == null) goto L48;
        int r104 = this.f402505a;
        if (r104 == 0) goto L28;
        if (r104 == 4) goto L28;
        if (r104 == 5) goto L28;
        boolean r105 = false;
    L29:
        if (r105 == false) goto L31;
        int r106 = this.f402509e;
        r103.setBounds(0, 0, r106, r106);
    L33:
        if (this.f402505a == 0) goto L35;
    L39:
        r103.setAlpha(this.f402508d);
        r103.draw(r110);
        int r107 = this.f402505a;
        if (r107 == 0) goto L45;
        if (r107 == 4) goto L45;
        if (r107 == 5) goto L45;
        r100 = false;
    L45:
        if (r100 == false) goto L48;
        invalidate();
        return;
    L35:
        if (this.f402525u.isRunning() == false) goto L39;
        if (this.f402525u.getAnimatedValue() == null) goto L39;
        r110.save();
        Drawable r108 = this.f402518n;
        r108.setBounds(r103.getBounds());
        r108.setColorFilter(this.f402515k, PorterDuff.Mode.SRC_IN);
        r108.draw(r110);
        r110.restore();
        float r109 = r101;
        r110.rotate(((Float) this.f402525u.getAnimatedValue()).floatValue(), r109, r109);
        goto L39
    L31:
        int r111 = this.f402509e;
        int r112 = this.f402511g;
        int r113 = (r111 - r112) / 2;
        int r114 = (r111 + r112) / 2;
        r103.setBounds(r113, r113, r114, r114);
    L28:
        r105 = true;
    L48:
        r110.restore();
        if (this.f402513i.isRunning() == true) goto L51;
    L53:
        float r115 = this.f402512h;
    L54:
        float r116 = (r115 * 360.0f) / 100.0f;
        r110.save();
        if (r116 < 360.0f) goto L57;
        this.f402518n.setColorFilter(this.f402514j, PorterDuff.Mode.SRC_IN);
        this.f402518n.draw(r110);
    L58:
        r110.restore();
        return;
    L57:
        this.f402518n.setColorFilter(this.f402515k, PorterDuff.Mode.SRC_IN);
        this.f402518n.draw(r110);
        this.f402524t.reset();
        this.f402524t.moveTo(getWidth() / 2.0f, getHeight() / 2.0f);
        this.f402524t.arcTo(0.0f, 0.0f, getWidth(), getHeight(), -90.0f, r116, false);
        r110.save();
        r110.clipPath(this.f402524t);
        this.f402518n.setColorFilter(this.f402514j, PorterDuff.Mode.SRC_IN);
        this.f402518n.draw(r110);
        r110.restore();
        goto L58
    L51:
        if (this.f402513i.getAnimatedValue() == null) goto L53;
        r115 = ((Float) this.f402513i.getAnimatedValue()).floatValue();
        goto L54
    L8:
        if (this.f402508d == 255) goto L20;
        int r117 = this.f402506b;
        if (r117 == 0) goto L15;
        if (r117 == 4) goto L15;
        if (r117 == 5) goto L15;
        boolean r118 = false;
    L16:
        if (r118 == false) goto L18;
        int r119 = this.f402509e;
        r102.setBounds(0, 0, r119, r119);
    L19:
        r102.setAlpha(255 - this.f402508d);
        r102.draw(r110);
        goto L20
    L18:
        int r120 = Math.min(r102.getIntrinsicWidth(), this.f402511g);
        int r121 = Math.min(r102.getIntrinsicHeight(), this.f402511g);
        int r122 = this.f402509e;
        r102.setBounds((r122 - r120) / 2, (r122 - r121) / 2, (r120 + r122) / 2, (r122 + r121) / 2);
    L15:
        r118 = true;
        goto L16
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        setCurrentState(r101.f402527b);
        setProgress(r101.f402526a);
    }

    public void setActionColor(int r100) {
        this.f402519o = this.f402519o.mutate();
        this.f402520p = this.f402520p.mutate();
        this.f402521q = this.f402521q.mutate();
        DrawableCompat.setTint(this.f402519o, r100);
        DrawableCompat.setTint(this.f402520p, r100);
        DrawableCompat.setTint(this.f402521q, r100);
    }

    public void setCurrentState(int r100) {
        int r101 = this.f402505a;
        if (r101 != r100) goto L5;
        return;
    L5:
        this.f402506b = r101;
        this.f402505a = r100;
        invalidate();
        d();
    }

    public void setDownloadDrawable(Drawable r100) {
        this.f402519o = r100;
    }

    public void setFailedDrawable(Drawable r100) {
        this.f402523s = r100;
    }

    public void setPauseDrawable(Drawable r100) {
        this.f402520p = r100;
    }

    @Override // android.view.View
    public void setPressed(boolean r100) {
        super.setPressed(r100);
        invalidate();
    }

    public void setProcessingColor(int r100) {
        Drawable r101 = this.f402517m.mutate();
        this.f402517m = r101;
        DrawableCompat.setTint(r101, r100);
    }

    public void setProcessingDrawable(Drawable r100) {
        this.f402517m = r100;
    }

    public void setProcessingDuration(int r100) {
        this.f402516l = r100;
    }

    public void setProgress(int r100) {
        if (this.f402512h == r100) goto L7;
        this.f402513i.cancel();
        int r101 = this.f402512h;
        this.f402512h = Math.max(Math.min(r100, 100), 0);
        invalidate();
        return;
    }

    public void setProgressBackgroundColor(int r100) {
        this.f402515k = r100;
    }

    public void setProgressBgDrawable(Drawable r100) {
        this.f402518n = r100;
    }

    public void setProgressColor(int r100) {
        this.f402514j = r100;
    }

    public void setRetryDrawable(Drawable r100) {
        this.f402521q = r100;
    }

    public void setSize(int r100) {
        if (r100 != 0) goto L5;
        this.f402510f = b(48.0f);
        this.f402511g = b(24.0f);
    L9:
        Drawable r101 = this.f402518n;
        int r102 = this.f402510f;
        r101.setBounds(0, 0, r102, r102);
        invalidate();
        return;
    L5:
        if (r100 == 2) goto L7;
        this.f402510f = b(36.0f);
        this.f402511g = b(16.0f);
        goto L9
    L7:
        this.f402510f = b(24.0f);
        this.f402511g = b(12.0f);
        goto L9
    }

    public void setSucceedDrawable(Drawable r100) {
        this.f402522r = r100;
    }

    public ODownloadProgressView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getSize(r100);
        if (r102 == Integer.MIN_VALUE) goto L7;
        if (r103 <= 0) goto L7;
        this.f402509e = r103;
    L8:
        int r104 = this.f402509e;
        setMeasuredDimension(r104, r104);
        return;
    L7:
        this.f402509e = this.f402510f;
        goto L8
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        super.onVisibilityChanged(r100, r101);
        if (r101 != 0) goto L5;
        d();
        return;
    L5:
        a();
    }

    public ODownloadProgressView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102, 0);
        this.f402505a = 0;
        this.f402506b = 0;
        this.f402508d = 255;
        this.f402513i = new ValueAnimator();
        this.f402516l = 1200;
        this.f402524t = new Path();
        new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.f402525u = new ValueAnimator();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.oui_download_action_color, R.attr.oui_progress, R.attr.oui_progress_background_color, R.attr.oui_progress_color, R.attr.oui_progress_view_size, R.attr.oui_progressing_action_color}, r102, 0);
        int r104 = r103.getInt(4, 1);
        this.f402512h = r103.getInt(1, 0);
        this.f402514j = r103.getColor(3, ContextCompat.getColor(r100, R.color.oui_accent_6_bg));
        this.f402515k = r103.getColor(2, ContextCompat.getColor(r100, R.color.oui_basic_line_2));
        int r105 = r103.getColor(5, ContextCompat.getColor(r100, R.color.oui_accent_6_bg));
        int r106 = r103.getColor(0, ContextCompat.getColor(r100, R.color.oui_accent_6_bg));
        r103.recycle();
        this.f402517m = ResourcesCompat.getDrawable(getResources(), R.drawable.o_ic_progress_processing, null);
        this.f402518n = ResourcesCompat.getDrawable(getResources(), R.drawable.o_ic_download_progress_bg, null);
        this.f402519o = ResourcesCompat.getDrawable(getResources(), R.drawable.o_ic_arrow_down_download, null);
        this.f402520p = ResourcesCompat.getDrawable(getResources(), R.drawable.o_ic_pause_download, null);
        this.f402521q = ResourcesCompat.getDrawable(getResources(), R.drawable.o_ic_download_retry, null);
        if (r105 == 0) goto L5;
        setProcessingColor(r105);
    L5:
        if (r106 == 0) goto L7;
        setActionColor(r106);
    L7:
        this.f402522r = ResourcesCompat.getDrawable(getResources(), R.drawable.o_ic_download_succeed, null);
        this.f402523s = ResourcesCompat.getDrawable(getResources(), R.drawable.o_ic_download_failed, null);
        setSize(r104);
        d();
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
