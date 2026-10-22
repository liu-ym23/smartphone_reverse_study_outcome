package zq3;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import com.bytedance.android.window.shop.widget.WindowProductCardApertureView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f573305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WindowProductCardApertureView f573306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View.OnLayoutChangeListener f573307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u1 f573308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t1 f573309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f573310f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f573311g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f573312h;

    public static final class a {
    }

    public static final class b implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s1 f573313a;

        public b(s1 r100) {
            this.f573313a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            s1 r109 = this.f573313a;
            View.OnLayoutChangeListener r110 = r109.f573307c;
            if (r110 == null) goto L5;
            r109.f573310f.removeOnLayoutChangeListener(r110);
        L5:
            s1 r111 = this.f573313a;
            r111.f573307c = null;
            r111.c();
        }
    }

    public static final class c implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s1 f573314a;

        public c(s1 r100) {
            this.f573314a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            s1 r109 = this.f573314a;
            WindowProductCardApertureView r110 = r109.f573306b;
            if (r110 == null) goto L6;
            r109.b(r110);
            return;
        }
    }

    static {
    }

    public final void a() {
        this.f573310f.removeCallbacks(this.f573308d);
        View.OnLayoutChangeListener r100 = this.f573307c;
        if (r100 == null) goto L5;
        this.f573310f.removeOnLayoutChangeListener(r100);
    L5:
        this.f573307c = null;
        this.f573310f.removeOnAttachStateChangeListener(this.f573309e);
        WindowProductCardApertureView r101 = this.f573306b;
        if (r101 == null) goto L12;
        ViewGroup r102 = this.f573305a;
        if (r102 == null) goto L12;
        ViewGroupOverlay r103 = r102.getOverlay();
        if (r103 == null) goto L12;
        r103.remove(r101);
    L12:
        this.f573306b = null;
    }

    public final void c() {
        a();
        ViewGroup r100 = this.f573305a;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f573310f.getWidth() > 0) goto L8;
    L12:
        b r101 = new b(this);
        this.f573307c = r101;
        this.f573310f.addOnLayoutChangeListener(r101);
        return;
    L8:
        if (this.f573310f.getHeight() <= 0) goto L12;
        WindowProductCardApertureView r102 = new WindowProductCardApertureView(this.f573310f.getContext(), null, this.f573311g, 2);
        r100.getOverlay().add(r102);
        b(r102);
        Unit r103 = Unit.INSTANCE;
        this.f573306b = r102;
        c r104 = new c(this);
        this.f573307c = r104;
        this.f573310f.addOnLayoutChangeListener(r104);
        this.f573310f.addOnAttachStateChangeListener(this.f573309e);
        this.f573310f.removeCallbacks(this.f573308d);
        this.f573310f.postDelayed(this.f573308d, this.f573312h);
    }

    public final void b(WindowProductCardApertureView r100) {
        int r101 = this.f573310f.getWidth();
        int r102 = this.f573310f.getHeight();
        if (r101 <= 0) goto L8;
        if (r102 <= 0) goto L9;
        r100.measure(View.MeasureSpec.makeMeasureSpec(r101, 1073741824), View.MeasureSpec.makeMeasureSpec(r102, 1073741824));
        r100.layout(0, 0, r101, r102);
        return;
    L9:
        return;
    }

    public s1(View r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "targetView");
        this.f573310f = r100;
        this.f573311g = r101;
        this.f573312h = 3000;
        if ((r100 instanceof ViewGroup) == true) goto L5;
        r100 = null;
    L5:
        this.f573305a = (ViewGroup) r100;
        this.f573308d = new u1(this);
        this.f573309e = new t1(this);
    }
}
