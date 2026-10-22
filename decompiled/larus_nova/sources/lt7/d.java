package lt7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import io.supercharge.shimmerlayout.ShimmerLayout;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f510699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f510700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f510701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f510702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f510703e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f510704f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f510705g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f510706a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f510707b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f510708c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f510709d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f510710e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f510711f;

        public final d b() {
            d r100 = new d(this);
            r100.b();
            return r100;
        }

        public a(View r100) {
            this.f510708c = true;
            this.f510710e = 1000;
            this.f510711f = 20;
            this.f510706a = r100;
            this.f510709d = ContextCompat.getColor(r100.getContext(), R.color.shimmer_color);
        }

        public final void a(int r100) {
            this.f510709d = ContextCompat.getColor(this.f510706a.getContext(), r100);
        }
    }

    public final void a() {
        View r100 = this.f510699a.f510692b;
        if ((r100 instanceof ShimmerLayout) == false) goto L5;
        ((ShimmerLayout) r100).d();
    L5:
        b r101 = this.f510699a;
        ViewGroup r102 = r101.f510694d;
        if (r102 == null) goto L9;
        r102.removeView(r101.f510693c);
        r101.f510694d.addView(r101.f510691a, r101.f510696f, r101.f510695e);
        r101.f510693c = r101.f510691a;
        r101.f510692b = null;
        return;
    }

    public final void b() {
        ViewParent r100 = this.f510700b.getParent();
        int r101 = 0;
        if (r100 != null) goto L5;
        View r102 = null;
    L12:
        if (r102 == null) goto L36;
        b r103 = this.f510699a;
        if (r103.f510693c != r102) goto L17;
        return;
    L17:
        if (r102.getParent() == null) goto L20;
        ((ViewGroup) r102.getParent()).removeView(r102);
    L20:
        if (r103.f510694d != null) goto L30;
        ViewGroup r104 = (ViewGroup) r103.f510691a.getParent();
        r103.f510694d = r104;
        if (r104 == null) goto L31;
        int r105 = r104.getChildCount();
    L25:
        if (r101 >= r105) goto L30;
        if (r103.f510691a == r103.f510694d.getChildAt(r101)) goto L28;
        r101 = r101 + 1;
        goto L25
    L28:
        r103.f510696f = r101;
    L31:
        if (r101 == 0) goto L37;
        r103.f510692b = r102;
        r103.f510694d.removeView(r103.f510693c);
        r103.f510692b.setId(r103.f510697g);
        r103.f510694d.addView(r103.f510692b, r103.f510696f, r103.f510695e);
        r103.f510693c = r103.f510692b;
        return;
    L37:
        return;
    L30:
        r101 = 1;
        goto L31
    L36:
        return;
    L5:
        ViewGroup r106 = (ViewGroup) r100;
        if (this.f510703e == false) goto L11;
        ShimmerLayout r107 = (ShimmerLayout) LayoutInflater.from(this.f510700b.getContext()).inflate(R.layout.layout_shimmer, r106, false);
        r107.setShimmerColor(this.f510702d);
        r107.setShimmerAngle(this.f510705g);
        r107.setShimmerAnimationDuration(this.f510704f);
        View r108 = LayoutInflater.from(this.f510700b.getContext()).inflate(this.f510701c, r107, false);
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        if (r109 == null) goto L10;
        r107.setLayoutParams(r109);
    L10:
        r107.addView(r108);
        r107.addOnAttachStateChangeListener(new c(r107));
        r107.c();
        r102 = r107;
        goto L12
    L11:
        r102 = LayoutInflater.from(this.f510700b.getContext()).inflate(this.f510701c, r106, false);
        goto L12
    }

    static {
    }

    public d(a r100) {
        this.f510700b = r100.f510706a;
        this.f510701c = r100.f510707b;
        this.f510703e = r100.f510708c;
        this.f510704f = r100.f510710e;
        this.f510705g = r100.f510711f;
        this.f510702d = r100.f510709d;
        this.f510699a = new b(r100.f510706a);
    }
}
