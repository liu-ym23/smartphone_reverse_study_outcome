package yx3;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.awemeopen.apps.framework.base.view.seekbar.CustomizedUISeekBar;
import com.bytedance.awemeopen.apps.framework.base.view.seekbar.SeekBarDrawerPriority;
import com.bytedance.awemeopen.apps.framework.base.view.seekbar.SeekBarState;
import com.bytedance.awemeopen.apps.framework.base.view.seekbar.d;
import com.bytedance.awemeopen.infra.util.o;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends com.bytedance.awemeopen.apps.framework.base.view.seekbar.a {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f569384w = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CustomizedUISeekBar f569385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap f569386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bitmap f569387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f569388d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f569389e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f569390f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f569391g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f569392h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f569393i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f569394j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f569395k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f569396l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f569397m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f569398n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public double f569399o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final RectF f569400p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Path f569401q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final long f569402r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f569403s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f569404t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ValueAnimator f569405u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f569406v;

    public static final class a {
    }

    static {
        Resources r100 = Resources.getSystem();
        f569384w = MathKt.roundToInt(TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics())));
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.seekbar.a
    public final boolean a() {
        if (this.f569406v == true) goto L5;
    L11:
        return false;
    L5:
        if (this.f569385a.getState() == SeekBarState.State.DRAGGING) goto L11;
        if (this.f569386b == null) goto L11;
        if (this.f569387c == null) goto L11;
        return true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.seekbar.a
    public final int c() {
        return SeekBarDrawerPriority.BUFFER_BLOCK.ordinal();
    }

    public b(CustomizedUISeekBar r110) {
        Intrinsics.checkNotNullParameter(r110, "seekBar");
        super(r110);
        this.f569385a = r110;
        Drawable r100 = AppCompatResources.getDrawable(r110.getContext(), R.drawable.aos_common_feed_bg_buffer_loading_part_seek_bar);
        Drawable r101 = AppCompatResources.getDrawable(r110.getContext(), R.drawable.aos_common_feed_bg_buffer_loading_whole_seek_bar);
        Bitmap r102 = null;
        if (r100 == null) goto L5;
        String r103 = o.f198973a;
        int r104 = o.a(r110.getContext());
        Resources r105 = Resources.getSystem();
        int r106 = r104 - MathKt.roundToInt(TypedValue.applyDimension(1, 10, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics())));
        Resources r107 = Resources.getSystem();
        Bitmap r108 = d.a(r100, r106, MathKt.roundToInt(TypedValue.applyDimension(1, 2, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()))));
    L6:
        this.f569386b = r108;
        if (r101 == null) goto L9;
        String r109 = o.f198973a;
        int r111 = o.a(r110.getContext());
        Resources r112 = Resources.getSystem();
        int r113 = r111 - MathKt.roundToInt(TypedValue.applyDimension(1, 10, WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics())));
        Resources r114 = Resources.getSystem();
        r102 = d.a(r101, r113, MathKt.roundToInt(TypedValue.applyDimension(1, 2, WindowDisplayMetricsOverride.apply(r114, r114.getDisplayMetrics()))));
    L9:
        this.f569387c = r102;
        this.f569388d = new Rect();
        this.f569395k = 1.0f;
        this.f569400p = new RectF();
        this.f569401q = new Path();
        this.f569402r = 1500;
        this.f569403s = 700;
        return;
    L5:
        r108 = null;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.seekbar.a
    public final void b(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        this.f569393i = this.f569385a.getWidth();
        this.f569394j = this.f569385a.getHeight();
        this.f569389e = this.f569385a.getPaddingLeft();
        this.f569390f = this.f569385a.getPaddingTop();
        this.f569391g = this.f569385a.getPaddingRight();
        this.f569392h = this.f569385a.getPaddingBottom();
        this.f569396l = (this.f569393i - this.f569389e) - this.f569391g;
        float r100 = (this.f569385a.getProgress() * 1.0f) / this.f569385a.getMax();
        this.f569395k = r100;
        int r101 = (int) (this.f569396l * r100);
        this.f569397m = r101;
        if (r101 <= f569384w) goto L5;
        boolean r102 = false;
    L7:
        if (r102 == false) goto L17;
        Bitmap r103 = this.f569387c;
        if (r103 != null) goto L11;
        return;
    L11:
        if (this.f569404t != 0) goto L13;
        this.f569404t = System.currentTimeMillis();
        return;
    L13:
        double r104 = (System.currentTimeMillis() - this.f569404t) / this.f569402r;
        this.f569399o = r104;
        int r105 = this.f569396l;
        this.f569398n = (int) ((((double) 2) * r104) * ((double) r105));
        if (r104 < 1.0d) goto L16;
        this.f569398n = r105 * 2;
        this.f569404t = System.currentTimeMillis();
    L16:
        int r106 = this.f569398n + this.f569389e;
        this.f569388d.set(r106 - this.f569396l, this.f569390f, r106, this.f569394j - this.f569392h);
        this.f569400p.set(this.f569389e, this.f569390f, this.f569393i - this.f569391g, this.f569394j - this.f569392h);
        this.f569401q.reset();
        Path r107 = this.f569401q;
        RectF r108 = this.f569400p;
        float r109 = ((this.f569394j - this.f569390f) - this.f569392h) / 2.0f;
        r107.addRoundRect(r108, r109, r109, Path.Direction.CW);
        r110.save();
        r110.clipPath(this.f569401q);
        r110.drawBitmap(r103, null, this.f569388d, null);
        r110.restore();
        return;
    L17:
        Bitmap r111 = this.f569386b;
        if (r111 != null) goto L20;
        return;
    L20:
        if (this.f569404t != 0) goto L22;
        this.f569404t = System.currentTimeMillis();
        return;
    L22:
        long r112 = System.currentTimeMillis();
        if (this.f569395k <= 0.5d) goto L25;
        this.f569403s = 900;
    L26:
        double r113 = (r112 - this.f569404t) / this.f569403s;
        this.f569399o = r113;
        double r114 = (((double) 1) - Math.cos(r113 * 3.141592653589793d)) / ((double) 2);
        int r115 = this.f569397m;
        this.f569398n = (int) (r114 * ((double) r115));
        if (this.f569399o < 1.0d) goto L29;
        this.f569398n = r115;
        this.f569404t = System.currentTimeMillis();
    L29:
        int r116 = this.f569398n;
        int r117 = this.f569389e;
        this.f569388d.set(r117, this.f569390f, r116 + r117, this.f569394j - this.f569392h);
        this.f569400p.set(this.f569389e, this.f569390f, this.f569393i - this.f569391g, this.f569394j - this.f569392h);
        this.f569401q.reset();
        Path r118 = this.f569401q;
        RectF r119 = this.f569400p;
        float r120 = ((this.f569394j - this.f569390f) - this.f569392h) / 2.0f;
        r118.addRoundRect(r119, r120, r120, Path.Direction.CW);
        r110.save();
        r110.clipPath(this.f569401q);
        r110.drawBitmap(r111, null, this.f569388d, null);
        r110.restore();
        return;
    L25:
        this.f569403s = 700;
        goto L26
    L5:
        r102 = true;
        goto L7
    }

    public final void d(boolean r100) {
        this.f569406v = r100;
        if (r100 == false) goto L8;
        ValueAnimator r101 = this.f569405u;
        if (r101 == null) goto L7;
        r101.cancel();
    L7:
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r102.setDuration(1000);
        r102.setInterpolator(new LinearInterpolator());
        r102.setRepeatMode(1);
        r102.setRepeatCount(-1);
        r102.addUpdateListener(new yx3.a(this));
        this.f569405u = r102;
        r102.start();
        this.f569404t = 0;
        this.f569385a.invalidate();
        return;
    L8:
        ValueAnimator r103 = this.f569405u;
        if (r103 == null) goto L11;
        r103.cancel();
    L11:
        this.f569405u = null;
        this.f569385a.invalidate();
    }
}
