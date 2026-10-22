package k56;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f501847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f501848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f501849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f501850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f501851e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f501852f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AnimatorSet f501853g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AnimatorSet f501854h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f501855i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f501856j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f501857k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f501858l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f501859m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f501860n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public WindowManager f501861o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public WindowManager.LayoutParams f501862p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f501863q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f501864r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f501865s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f501866t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f501867u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f501868v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f501869w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f501870x;

    public b() {
        throw null;
    }

    public final void b() {
        if (this.f501858l == true) goto L5;
        return;
    L5:
        ViewGroup r100 = this.f501848b;
        if (r100 != null) goto L8;
    L10:
        this.f501858l = false;
        return;
    L8:
        if (r100.getParent() == null) goto L10;
        this.f501861o.removeView(this.f501848b);
        this.f501848b.removeView(this.f501851e);
        goto L10
    }

    public final View c() {
        LayoutInflater r100 = LayoutInflater.from(this.f501847a);
        if ((-1) == this.f501867u) goto L5;
        int r101 = this.f501868v;
        if (r101 > 0) goto L21;
        if (this.f501864r == false) goto L12;
        r101 = R.layout.custom_default_toast_light;
        goto L21
    L12:
        r101 = R.layout.custom_default_toast_deep;
    L21:
        View r102 = r100.inflate(r101, this.f501848b, false);     // Catch: InflateException -> L16
        this.f501863q = r102;     // Catch: InflateException -> L16
        this.f501867u = r101;     // Catch: InflateException -> L16
        return r102;
    L17:
        if (this.f501863q != null) goto L19;
        this.f501863q = r100.inflate(R.layout.custom_default_toast_deep, this.f501848b, false);
    L19:
        this.f501867u = R.layout.custom_default_toast_deep;
        return this.f501863q;
    L5:
        return this.f501863q;
    }

    public final boolean f() {
        if (this.f501847a != null) goto L5;
    L8:
        return true;
    L5:
        if (this.f501857k == true) goto L8;
        return false;
    }

    public Context getContext() {
        return this.f501847a;
    }

    public b(Context r100) {
        this.f501849c = 49;
        this.f501855i = 2500;
        this.f501860n = false;
        this.f501864r = false;
        this.f501868v = R.layout.custom_system_toast_new;
        d(r100);
    }

    public final void d(Context r100) {
        this.f501847a = r100;
        this.f501850d = new int[4];
        if (f() == false) goto L5;
        return;
    L5:
        this.f501848b = new FrameLayout(this.f501847a);
        this.f501870x = (int) r100.getResources().getDimension(R.dimen.toast_start_anim_height);
        this.f501848b.setOnTouchListener(new a(this));
    }

    public final void e(String r100, int r101) {
        if (f() == false) goto L5;
        return;
    L5:
        this.f501859m = r100;
        View r102 = this.f501851e;
        if (r102 == null) goto L8;
        this.f501852f = (TextView) r102.findViewById(R.id.text);
        this.f501856j = (ImageView) this.f501851e.findViewById(R.id.icon);
    L8:
        ImageView r103 = this.f501856j;
        if (r103 != null) goto L11;
    L13:
        int r104 = View.MeasureSpec.makeMeasureSpec(1073741823, Integer.MIN_VALUE);
        int r105 = View.MeasureSpec.makeMeasureSpec(1073741823, Integer.MIN_VALUE);
        this.f501851e.measure(r104, r105);
        return;
    L11:
        if (r101 != (-1)) goto L13;
        r103.setVisibility(8);
        goto L13
    }

    public static void a(b r100, float r101, float r102) {
        if (r100.f501869w == true) goto L6;
        return;
    L6:
        if (r100.f501851e == null) goto L8;
        AnimatorSet r103 = new AnimatorSet();
        r103.play(ObjectAnimator.ofFloat(r100.f501848b, LiveDegradeFpsAnimator.SCALE_X, new float[]{r101, r102})).with(ObjectAnimator.ofFloat(r100.f501848b, LiveDegradeFpsAnimator.SCALE_Y, new float[]{r101, r102}));
        r103.setDuration(80);
    L9:
        if (r103 == null) goto L12;
        r103.start();
        return;
    L12:
        return;
    L8:
        r103 = null;
        goto L9
    }
}
