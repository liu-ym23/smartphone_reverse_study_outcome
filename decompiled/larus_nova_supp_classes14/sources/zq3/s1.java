package zq3;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import com.bytedance.android.window.shop.widget.WindowProductCardApertureView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s1 {
    public final ViewGroup a;
    public WindowProductCardApertureView b;
    public View.OnLayoutChangeListener c;
    public final u1 d;
    public final t1 e;
    public final View f;
    public final float g;
    public final long h;

    public static final class a {
    }

    public static final class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ s1 a;

        public b(s1 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            s1 r10 = this.a;
            View.OnLayoutChangeListener r11 = r10.c;
            if (r11 == null) goto L5;
            r10.f.removeOnLayoutChangeListener(r11);
        L5:
            s1 r12 = this.a;
            r12.c = null;
            r12.c();
        }
    }

    public static final class c implements View.OnLayoutChangeListener {
        public final /* synthetic */ s1 a;

        public c(s1 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            s1 r10 = this.a;
            WindowProductCardApertureView r11 = r10.b;
            if (r11 == null) goto L6;
            r10.b(r11);
            return;
        }
    }

    static {
    }

    public final void a() {
        this.f.removeCallbacks(this.d);
        View.OnLayoutChangeListener r0 = this.c;
        if (r0 == null) goto L5;
        this.f.removeOnLayoutChangeListener(r0);
    L5:
        this.c = null;
        this.f.removeOnAttachStateChangeListener(this.e);
        WindowProductCardApertureView r1 = this.b;
        if (r1 == null) goto L12;
        ViewGroup r2 = this.a;
        if (r2 == null) goto L12;
        ViewGroupOverlay r3 = r2.getOverlay();
        if (r3 == null) goto L12;
        r3.remove(r1);
    L12:
        this.b = null;
    }

    public final void c() {
        a();
        ViewGroup r0 = this.a;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.f.getWidth() > 0) goto L8;
    L12:
        b r1 = new b(this);
        this.c = r1;
        this.f.addOnLayoutChangeListener(r1);
        return;
    L8:
        if (this.f.getHeight() <= 0) goto L12;
        WindowProductCardApertureView r2 = new WindowProductCardApertureView(this.f.getContext(), null, this.g, 2);
        r0.getOverlay().add(r2);
        b(r2);
        Unit r3 = Unit.INSTANCE;
        this.b = r2;
        c r4 = new c(this);
        this.c = r4;
        this.f.addOnLayoutChangeListener(r4);
        this.f.addOnAttachStateChangeListener(this.e);
        this.f.removeCallbacks(this.d);
        this.f.postDelayed(this.d, this.h);
    }

    public final void b(WindowProductCardApertureView r5) {
        int r0 = this.f.getWidth();
        int r1 = this.f.getHeight();
        if (r0 <= 0) goto L8;
        if (r1 <= 0) goto L9;
        r5.measure(View.MeasureSpec.makeMeasureSpec(r0, 1073741824), View.MeasureSpec.makeMeasureSpec(r1, 1073741824));
        r5.layout(0, 0, r0, r1);
        return;
    L9:
        return;
    }

    public s1(View r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "targetView");
        this.f = r3;
        this.g = r4;
        this.h = 3000;
        if ((r3 instanceof ViewGroup) == true) goto L5;
        r3 = null;
    L5:
        this.a = (ViewGroup) r3;
        this.d = new u1(this);
        this.e = new t1(this);
    }
}
