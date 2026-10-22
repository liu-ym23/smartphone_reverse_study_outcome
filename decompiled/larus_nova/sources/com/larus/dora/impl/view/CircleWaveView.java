package com.larus.dora.impl.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.lark.utils.statistics.PerfLog;
import g49.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q69.b;
import q69.c;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u0001:\u0001*B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0014J\u0016\u0010&\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007J\u0006\u0010'\u001a\u00020#J\u0006\u0010(\u001a\u00020\u001cJ\u0006\u0010)\u001a\u00020#R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/dora/impl/view/CircleWaveView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint1", "Landroid/graphics/Paint;", "alpha1", "circleRadius1", "", "valueAnimator1", "Landroid/animation/ValueAnimator;", "paint2", "alpha2", "circleRadius2", "valueAnimator2", "paint3", "alpha3", "circleRadius3", "valueAnimator3", "paint", "circleColor", "isPlaying", "", "maxRadius", "minRadius", "icon", "Landroid/graphics/drawable/Drawable;", "iconSize", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setRadius", "start", "getState", "stop", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CircleWaveView extends View {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f338163p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f338164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f338165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f338166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f338167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f338168e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f338169f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f338170g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f338171h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f338172i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f338173j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f338174k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f338175l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f338176m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Drawable f338177n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f338178o;

    public static final class a {
    }

    static {
    }

    public CircleWaveView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CircleWaveView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final boolean getState() {
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        this.f338164a.setAlpha(this.f338165b);
        this.f338167d.setAlpha(this.f338168e);
        this.f338170g.setAlpha(this.f338171h);
        float r101 = getWidth() / 2.0f;
        float r102 = getHeight() / 2.0f;
        r100.drawCircle(r101, r102, this.f338166c, this.f338164a);
        r100.drawCircle(r101, r102, this.f338169f, this.f338167d);
        r100.drawCircle(r101, r102, this.f338172i, this.f338170g);
        r100.drawCircle(r101, r102, this.f338176m, this.f338173j);
        Drawable r103 = this.f338177n;
        if (r103 == null) goto L6;
        int r104 = this.f338178o;
        r103.setBounds(0, 0, r104, r104);
        int r105 = this.f338178o;
        r100.translate(r101 - (r105 / 2.0f), r102 - (r105 / 2.0f));
        r103.draw(r100);
        return;
    }

    public CircleWaveView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f338164a = new Paint();
        this.f338165b = 255;
        this.f338167d = new Paint();
        this.f338168e = 255;
        this.f338170g = new Paint();
        this.f338171h = 255;
        this.f338173j = new Paint();
        this.f338174k = FakePickerAvatarCreator.BLUE;
        this.f338175l = 40;
        this.f338176m = 20;
        TypedArray r100 = null;
        if (r111 != null) goto L19;
    L15:
        if (r100 != null) goto L10;
    L17:
        this.f338173j.setColor(this.f338174k);
        this.f338164a.setColor(this.f338174k);
        this.f338167d.setColor(this.f338174k);
        this.f338170g.setColor(this.f338174k);
        ValueAnimator r113 = ValueAnimator.ofInt(new int[]{this.f338176m, this.f338175l});
        r113.setDuration(3000);
        r113.setRepeatCount(-1);
        r113.setRepeatMode(1);
        r113.addUpdateListener(new q69.a(this));
        ValueAnimator r114 = ValueAnimator.ofInt(new int[]{this.f338176m, this.f338175l});
        r114.setDuration(3000);
        r114.setRepeatCount(-1);
        r114.setRepeatMode(1);
        r114.addUpdateListener(new b(this));
        ValueAnimator r115 = ValueAnimator.ofInt(new int[]{this.f338176m, this.f338175l});
        r115.setDuration(3000);
        r115.setRepeatCount(-1);
        r115.setRepeatMode(1);
        r115.addUpdateListener(new c(this));
        return;
    L10:
        r100.recycle();
        goto L17
    L19:
        r100 = r110.obtainStyledAttributes(r111, new int[]{R.attr.larus_CircleWaveViewColor, R.attr.larus_CircleWaveViewIcon, R.attr.larus_CircleWaveViewIconSize, R.attr.larus_CircleWaveViewMaxRadius, R.attr.larus_CircleWaveViewMinRadius});     // Catch: Throwable -> L7
        this.f338174k = r100.getColor(0, FakePickerAvatarCreator.BLUE);     // Catch: Throwable -> L7
        this.f338175l = r100.getDimensionPixelSize(3, 40);     // Catch: Throwable -> L7
        this.f338176m = r100.getDimensionPixelSize(4, 20);     // Catch: Throwable -> L7
        this.f338177n = r100.getDrawable(1);     // Catch: Throwable -> L7
        this.f338178o = r100.getDimensionPixelSize(2, 0);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        d.c("CircleWaveView", "init: exception", th);     // Catch: Throwable -> L11
        if (r100 == null) goto L17;
    L11:
        th = move-exception;
        if (r100 == null) goto L14;
        r100.recycle();
    L14:
        throw th;
    }

    public /* synthetic */ CircleWaveView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
