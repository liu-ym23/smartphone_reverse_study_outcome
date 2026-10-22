package com.bytedance.dux.slider;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zl4.a;
import zl4.b;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/dux/slider/TickMarkSeekBar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "", "getOffset", "Landroid/graphics/drawable/Drawable;", "getBgDrawable", "", "progress", "", "setDefaultProgress", "getDefaultProgress", "", "isAlwaysLight", "setIsAlwaysLight", "isAlwaysNight", "setIsAlwaysNight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dux_release"}, k = 1, mv = {1, 7, 1})
public class TickMarkSeekBar extends AppCompatSeekBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f205654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f205655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f205656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f205657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f205658e;

    public TickMarkSeekBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TickMarkSeekBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final Drawable getBgDrawable() {
        if (this.f205657d == false) goto L6;
        return ContextCompat.getDrawable(getContext(), R.drawable.dux_background_seekbar_always_light);
    L6:
        if (this.f205658e == false) goto L9;
        return ContextCompat.getDrawable(getContext(), R.drawable.dux_background_seekbar_always_night);
    L9:
        return ContextCompat.getDrawable(getContext(), R.drawable.dux_background_seekbar);
    }

    private final float getOffset() {
        return getResources().getDimension(R.dimen.dux_slider_thumb_width) / 2;
    }

    public int getDefaultProgress() {
        return this.f205656c;
    }

    public final void a(Canvas r100) {
        if (this.f205654a == null) goto L13;
        int r101 = r100.save();
        r100.translate(getOffset(), getPaddingTop());
        int r102 = getMeasuredHeight() / 2;
        Drawable r103 = this.f205654a;
        Intrinsics.checkNotNull(r103);
        int r104 = r102 - (r103.getIntrinsicHeight() / 2);
        int r105 = getMeasuredWidth() - ((int) (getOffset() * 2));
        int r106 = getMeasuredHeight() / 2;
        Drawable r107 = this.f205654a;
        Intrinsics.checkNotNull(r107);
        Rect r108 = new Rect(0, r104, r105, r106 + (r107.getIntrinsicHeight() / 2));
        Drawable r109 = this.f205654a;
        if (r109 == null) goto L8;
        r109.setBounds(r108);
    L8:
        Drawable r110 = this.f205654a;
        if (r110 == null) goto L11;
        r110.draw(r100);
    L11:
        r100.restoreToCount(r101);
        return;
    }

    public final void b(Canvas r100) {
        Drawable r101 = getProgressDrawable();
        if (r101 == null) goto L6;
        int r102 = r100.save();
        r100.translate(getOffset(), getPaddingTop());
        r101.setBounds(new Rect(0, (getMeasuredHeight() / 2) - (r101.getIntrinsicHeight() / 2), getMeasuredWidth() - ((int) (getOffset() * 2)), (getMeasuredHeight() / 2) + (r101.getIntrinsicHeight() / 2)));
        r101.draw(r100);
        r100.restoreToCount(r102);
        return;
    }

    public final void c(Canvas r100) {
        b r101 = this.f205655b;
        if (r101 == null) goto L22;
        float r102 = this.f205656c / getMax();
        if (Build.VERSION.SDK_INT < 26) goto L7;
        r102 = this.f205656c / (getMax() - getMin());
    L7:
        double r103 = r102;
        int r104 = 1;
        if (AudioStats.AUDIO_AMPLITUDE_NONE <= r103) goto L10;
    L12:
        boolean r105 = false;
    L13:
        if (r105 == false) goto L23;
        int r106 = r101.getIntrinsicWidth();
        int r107 = r101.getIntrinsicHeight();
        if (r106 < 0) goto L17;
        int r108 = r106 / 2;
    L18:
        if (r107 < 0) goto L20;
        r104 = r107 / 2;
    L20:
        r101.setBounds(-r108, -r104, r108, r104);
        int r109 = r100.save();
        r100.translate(((getWidth() - (getOffset() * 2)) * r102) + getOffset(), getHeight() / 2);
        r101.draw(r100);
        r100.restoreToCount(r109);
        return;
    L17:
        r108 = 1;
        goto L18
    L23:
        return;
    L10:
        if (r103 > 1.0d) goto L12;
        r105 = true;
        goto L13
    }

    @Override // android.widget.ProgressBar, android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "dr");
        Objects.toString(r100);
        super.invalidateDrawable(r100);
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "canvas");     // Catch: Throwable -> L8
        a(r100);     // Catch: Throwable -> L8
        b(r100);     // Catch: Throwable -> L8
        c(r100);     // Catch: Throwable -> L8
        Drawable r101 = getThumb();     // Catch: Throwable -> L8
        if (r101 == null) goto L6;
        int r102 = r100.save();     // Catch: Throwable -> L8
        r100.translate(0.0f, getPaddingTop());     // Catch: Throwable -> L8
        r101.draw(r100);     // Catch: Throwable -> L8
        r100.restoreToCount(r102);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void setDefaultProgress(int r100) {
        this.f205656c = r100;
        invalidate();
    }

    public final void setIsAlwaysLight(boolean r100) {
        this.f205657d = r100;
        this.f205654a = getBgDrawable();
        invalidate();
    }

    public final void setIsAlwaysNight(boolean r100) {
        this.f205658e = r100;
        this.f205654a = getBgDrawable();
        invalidate();
    }

    public TickMarkSeekBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f205656c = -1;
        this.f205654a = getBgDrawable();
        this.f205655b = new b(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.dux_ic_slider_tick));
        setThumb(new a(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.dux_slider_thumb_icon)));
        setThumbOffset(0);
    }

    public /* synthetic */ TickMarkSeekBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        int r104 = (r101 - getPaddingTop()) - getPaddingBottom();
        if (getThumb() == null) goto L5;
        int r105 = getThumb().getIntrinsicHeight();
    L6:
        if (r105 > r104) goto L8;
        return;
    L8:
        if (getThumb() == null) goto L12;
        int r106 = (r104 - r105) / 2;
        Rect r107 = getThumb().getBounds();
        int r108 = r107.left;
        int r109 = r107.right;
        Rect r110 = new Rect(r108, r106, r109, r105 + r106);
        getThumb().setBounds(r110);
        return;
    L12:
        return;
    L5:
        r105 = 0;
        goto L6
    }
}
