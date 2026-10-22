package com.obric.oui.orecyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.ViewCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class r extends RecyclerView.j implements RecyclerView.n {
    public static final int[] C = null;
    public static final int[] D = null;
    public int A;
    public final a B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f401910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f401911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateListDrawable f401912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f401913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f401914e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f401915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StateListDrawable f401916g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Drawable f401917h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f401918i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f401919j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f401920k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f401921l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f401922m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f401923n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f401924o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f401925p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f401926q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f401927r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public RecyclerView f401928s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f401929t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f401930u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f401931v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f401932w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int[] f401933x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int[] f401934y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ValueAnimator f401935z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f401936a;

        public final void a() {
            r r100 = this.f401936a;
            int r101 = r100.A;
            if (r101 == 1) goto L6;
            if (r101 != 2) goto L9;
        L7:
            r100.A = 3;
            ValueAnimator r102 = r100.f401935z;
            r102.setFloatValues(new float[]{((Float) r102.getAnimatedValue()).floatValue(), 0.0f});
            r100.f401935z.setDuration(500);
            r100.f401935z.start();
            return;
        L9:
            return;
        L6:
            r100.f401935z.cancel();
            goto L7
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

        public a(r r100) {
            this.f401936a = r100;
        }
    }

    public class b extends RecyclerView.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f401937a;

        public b(r r100) {
            this.f401937a = r100;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.o
        public final void b(RecyclerView r100, int r110, int r111) {
            r r112 = this.f401937a;
            int r113 = r100.computeHorizontalScrollOffset();
            int r101 = r100.computeVerticalScrollOffset();
            int r102 = r112.f401928s.computeVerticalScrollRange();
            int r103 = r112.f401927r;
            if ((r102 - r103) > 0) goto L5;
        L7:
            boolean r104 = false;
        L8:
            r112.f401929t = r104;
            int r105 = r112.f401928s.computeHorizontalScrollRange();
            int r106 = r112.f401926q;
            if ((r105 - r106) > 0) goto L11;
        L13:
            boolean r107 = false;
        L14:
            r112.f401930u = r107;
            boolean r108 = r112.f401929t;
            if (r108 == true) goto L21;
            if (r107 == true) goto L21;
            if (r112.f401931v == 0) goto L31;
            r112.g(0);
            return;
        L31:
            return;
        L21:
            if (r108 == false) goto L24;
            float r109 = r103;
            r112.f401921l = (int) ((r109 * (r101 + (r109 / 2.0f))) / r102);
            r112.f401920k = Math.min(r103, (r103 * r103) / r102);
        L24:
            if (r112.f401930u == false) goto L26;
            float r114 = r113;
            float r115 = r106;
            r112.f401924o = (int) ((r115 * (r114 + (r115 / 2.0f))) / r105);
            r112.f401923n = Math.min(r106, (r106 * r106) / r105);
        L26:
            int r116 = r112.f401931v;
            if (r116 == 0) goto L29;
            if (r116 == 1) goto L29;
            return;
        L29:
            r112.g(1);
            return;
        L11:
            if (r106 < r112.f401910a) goto L13;
            r107 = true;
            goto L14
        L5:
            if (r103 < r112.f401910a) goto L7;
            r104 = true;
            goto L8
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f401938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ r f401939b;

        public c(r r100) {
            this.f401939b = r100;
            this.f401938a = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            this.f401938a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            if (this.f401938a == false) goto L7;
            this.f401938a = false;
            return;
        L7:
            if (((Float) this.f401939b.f401935z.getAnimatedValue()).floatValue() != 0.0f) goto L9;
            r r101 = this.f401939b;
            r101.A = 0;
            r101.g(0);
            return;
        L9:
            r r102 = this.f401939b;
            r102.A = 2;
            r102.f401928s.invalidate();
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f401940a;

        public d(r r100) {
            this.f401940a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            int r101 = (int) (((Float) r100.getAnimatedValue()).floatValue() * 255.0f);
            this.f401940a.f401912c.setAlpha(r101);
            this.f401940a.f401913d.setAlpha(r101);
            this.f401940a.f401928s.invalidate();
        }
    }

    static {
        C = new int[]{R.attr.state_pressed};
        D = new int[0];
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.n
    public final void b() {
    }

    public final void h() {
        int r100 = this.A;
        if (r100 != 0) goto L5;
    L8:
        this.A = 1;
        ValueAnimator r101 = this.f401935z;
        r101.setFloatValues(new float[]{((Float) r101.getAnimatedValue()).floatValue(), 1.0f});
        this.f401935z.setDuration(500);
        this.f401935z.setStartDelay(0);
        this.f401935z.start();
        return;
    L5:
        if (r100 != 3) goto L10;
        this.f401935z.cancel();
        goto L8
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.j
    public final void d(Canvas r100) {
        if (this.f401926q == this.f401928s.getWidth()) goto L5;
    L22:
        this.f401926q = this.f401928s.getWidth();
        this.f401927r = this.f401928s.getHeight();
        g(0);
        return;
    L5:
        if (this.f401927r != this.f401928s.getHeight()) goto L22;
        if (this.A != 0) goto L10;
        return;
    L10:
        if (this.f401929t == false) goto L19;
        int r101 = this.f401926q;
        int r102 = this.f401914e;
        int r103 = r101 - r102;
        int r104 = this.f401921l;
        int r105 = this.f401920k;
        int r106 = r104 - (r105 / 2);
        this.f401912c.setBounds(0, 0, r102, r105);
        this.f401913d.setBounds(0, 0, this.f401915f, this.f401927r);
        boolean r107 = true;
        if (ViewCompat.getLayoutDirection(this.f401928s) == 1) goto L15;
        r107 = false;
    L15:
        if (r107 == false) goto L17;
        this.f401913d.draw(r100);
        r100.translate(this.f401914e, r106);
        r100.scale(-1.0f, 1.0f);
        this.f401912c.draw(r100);
        r100.scale(-1.0f, 1.0f);
        r100.translate(-this.f401914e, -r106);
        goto L19
    L17:
        r100.translate(r103, 0.0f);
        this.f401913d.draw(r100);
        r100.translate(0.0f, r106);
        this.f401912c.draw(r100);
        r100.translate(-r103, -r106);
    L19:
        if (this.f401930u == false) goto L25;
        int r108 = this.f401927r;
        int r109 = this.f401918i;
        int r110 = r108 - r109;
        int r111 = this.f401924o;
        int r112 = this.f401923n;
        int r113 = r111 - (r112 / 2);
        this.f401916g.setBounds(0, 0, r112, r109);
        this.f401917h.setBounds(0, 0, this.f401926q, this.f401919j);
        r100.translate(0.0f, r110);
        this.f401917h.draw(r100);
        r100.translate(r113, 0.0f);
        this.f401916g.draw(r100);
        r100.translate(-r113, -r110);
        return;
    }

    public final void g(int r100) {
        if (r100 == 2) goto L5;
    L7:
        if (r100 != 0) goto L9;
        this.f401928s.invalidate();
    L11:
        if (this.f401931v != 2) goto L15;
        if (r100 == 2) goto L15;
        this.f401912c.setState(D);
        this.f401928s.removeCallbacks(this.B);
        this.f401928s.postDelayed(this.B, 1200);
    L17:
        this.f401931v = r100;
        return;
    L15:
        if (r100 != 1) goto L17;
        this.f401928s.removeCallbacks(this.B);
        this.f401928s.postDelayed(this.B, 1500);
        goto L17
    L9:
        h();
        goto L11
    L5:
        if (this.f401931v == 2) goto L7;
        this.f401912c.setState(C);
        this.f401928s.removeCallbacks(this.B);
        goto L7
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.n
    public final void onTouchEvent(MotionEvent r110) {
        if (this.f401931v != 0) goto L6;
        return;
    L6:
        if (r110.getAction() != 0) goto L16;
        boolean r100 = f(r110.getX(), r110.getY());
        boolean r101 = e(r110.getX(), r110.getY());
        if (r100 == true) goto L10;
        if (r101 == true) goto L10;
        return;
    L10:
        if (r101 == false) goto L12;
        this.f401932w = 1;
        this.f401925p = (int) r110.getX();
    L14:
        g(2);
        return;
    L12:
        if (r100 == false) goto L14;
        this.f401932w = 2;
        this.f401922m = (int) r110.getY();
        goto L14
    L16:
        if (r110.getAction() != 1) goto L21;
        if (this.f401931v != 2) goto L21;
        this.f401922m = 0.0f;
        this.f401925p = 0.0f;
        g(1);
        this.f401932w = 0;
        return;
    L21:
        if (r110.getAction() == 2) goto L23;
        return;
    L23:
        if (this.f401931v != 2) goto L57;
        h();
        if (this.f401932w != 1) goto L39;
        float r102 = r110.getX();
        int[] r103 = this.f401934y;
        int r104 = this.f401911b;
        r103[0] = r104;
        int r105 = this.f401926q - r104;
        r103[1] = r105;
        float r106 = Math.max(r104, Math.min(r105, r102));
        if (Math.abs(this.f401924o - r106) < 2.0f) goto L39;
        float r107 = this.f401925p;
        int r108 = this.f401928s.computeHorizontalScrollRange();
        int r109 = this.f401928s.computeHorizontalScrollOffset();
        int r111 = this.f401926q;
        int r112 = r103[1] - r103[0];
        if (r112 != 0) goto L32;
    L31:
        int r113 = 0;
    L35:
        if (r113 == 0) goto L37;
        this.f401928s.scrollBy(r113, 0);
    L37:
        this.f401925p = r106;
        goto L39
    L32:
        int r114 = r108 - r111;
        r113 = (int) (((r106 - r107) / r112) * r114);
        int r115 = r109 + r113;
        if (r115 >= r114) goto L31;
        if (r115 < 0) goto L31;
    L39:
        if (this.f401932w != 2) goto L58;
        float r116 = r110.getY();
        int[] r117 = this.f401933x;
        int r118 = this.f401911b;
        r117[0] = r118;
        int r119 = this.f401927r - r118;
        r117[1] = r119;
        float r120 = Math.max(r118, Math.min(r119, r116));
        if (Math.abs(this.f401921l - r120) < 2.0f) goto L59;
        float r121 = this.f401922m;
        int r122 = this.f401928s.computeVerticalScrollRange();
        int r123 = this.f401928s.computeVerticalScrollOffset();
        int r124 = this.f401927r;
        int r125 = r117[1] - r117[0];
        if (r125 != 0) goto L46;
    L45:
        int r126 = 0;
    L49:
        if (r126 == 0) goto L51;
        this.f401928s.scrollBy(0, r126);
    L51:
        this.f401922m = r120;
        return;
    L46:
        int r127 = r122 - r124;
        r126 = (int) (((r120 - r121) / r125) * r127);
        int r128 = r123 + r126;
        if (r128 >= r127) goto L45;
        if (r128 < 0) goto L45;
    L59:
        return;
    L58:
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.n
    public final boolean a(RecyclerView r100, MotionEvent r101) {
        int r102 = this.f401931v;
        if (r102 != 1) goto L13;
        boolean r103 = f(r101.getX(), r101.getY());
        boolean r104 = e(r101.getX(), r101.getY());
        if (r101.getAction() != 0) goto L15;
        if (r103 == true) goto L8;
        if (r104 == false) goto L15;
    L8:
        if (r104 == false) goto L10;
        this.f401932w = 1;
        this.f401925p = (int) r101.getX();
    L12:
        g(2);
        return true;
    L10:
        if (r103 == false) goto L12;
        this.f401932w = 2;
        this.f401922m = (int) r101.getY();
    L15:
        return false;
    L13:
        if (r102 != 2) goto L15;
        return true;
    }

    public final boolean e(float r100, float r101) {
        if (r101 < (this.f401927r - this.f401918i)) goto L9;
        int r102 = this.f401924o;
        int r103 = this.f401923n;
        if (r100 < (r102 - (r103 / 2))) goto L9;
        if (r100 > (r102 + (r103 / 2))) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean f(float r100, float r101) {
        if (ViewCompat.getLayoutDirection(this.f401928s) != 1) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L11;
        if (r100 > this.f401914e) goto L18;
    L12:
        int r103 = this.f401921l;
        int r104 = this.f401920k / 2;
        if (r101 >= (r103 - r104)) goto L15;
        return false;
    L15:
        if (r101 > (r103 + r104)) goto L21;
        return true;
    L21:
        return false;
    L18:
        return false;
    L11:
        if (r100 >= (this.f401926q - this.f401914e)) goto L12;
        return false;
    L5:
        r102 = false;
        goto L6
    }

    public r(RecyclerView r100, StateListDrawable r101, Drawable r102, StateListDrawable r110, Drawable r111, int r112, int r113, int r114) {
        boolean r103 = false;
        this.f401926q = 0;
        this.f401927r = 0;
        this.f401929t = false;
        this.f401930u = false;
        this.f401931v = 0;
        this.f401932w = 0;
        this.f401933x = new int[2];
        this.f401934y = new int[2];
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f401935z = r104;
        this.A = 0;
        a r105 = new a(this);
        this.B = r105;
        b r106 = new b(this);
        this.f401912c = r101;
        this.f401913d = r102;
        this.f401916g = r110;
        this.f401917h = r111;
        this.f401914e = Math.max(r112, r101.getIntrinsicWidth());
        this.f401915f = Math.max(r112, r102.getIntrinsicWidth());
        this.f401918i = Math.max(r112, r110.getIntrinsicWidth());
        this.f401919j = Math.max(r112, r111.getIntrinsicWidth());
        this.f401910a = r113;
        this.f401911b = r114;
        r101.setAlpha(255);
        r102.setAlpha(255);
        r104.addListener(new c(this));
        r104.addUpdateListener(new d(this));
        RecyclerView r107 = this.f401928s;
        if (r107 == r100) goto L27;
        if (r107 == null) goto L22;
        RecyclerView.k r108 = r107.f401621m;
        if (r108 == null) goto L9;
        r108.b("Cannot remove item decoration during a scroll  or layout");
    L9:
        r107.f401624p.remove(this);
        if (r107.f401624p.isEmpty() == true) goto L12;
    L15:
        r107.I();
        r107.requestLayout();
        RecyclerView r109 = this.f401928s;
        r109.f401627q.remove(this);
        if (r109.f401628r != this) goto L18;
        r109.f401628r = null;
    L18:
        List<RecyclerView.o> r115 = this.f401928s.V0;
        if (r115 == null) goto L21;
        ((ArrayList) r115).remove(r106);
    L21:
        this.f401928s.removeCallbacks(r105);
        goto L22
    L12:
        if (r107.getOverScrollMode() != 2) goto L14;
        r103 = true;
    L14:
        r107.setWillNotDraw(r103);
    L22:
        this.f401928s = r100;
        if (r100 == null) goto L26;
        r100.i(this);
        this.f401928s.f401627q.add(this);
        this.f401928s.j(r106);
        return;
    L26:
        return;
    }
}
