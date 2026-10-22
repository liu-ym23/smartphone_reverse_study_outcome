package vn;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx;
import com.bytedance.android.ec.vlayout.VirtualLayoutManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes44.dex */
public final class l extends vn.a {
    public final a A;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f556380n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public c[] f556381o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f556382p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f556383q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f556384r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f556385s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f556386t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public BitSet f556387u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b f556388v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List<View> f556389w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f556390x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f556391y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public WeakReference<VirtualLayoutManager> f556392z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f556393a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f556393a.B();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(l r100) {
            this.f556393a = r100;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f556394a;

        public b() {
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<View> f556395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f556396b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f556397c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f556398d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f556399e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f556400f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f556401g;

        public c(int r100) {
            this.f556395a = new ArrayList();
            this.f556396b = Integer.MIN_VALUE;
            this.f556397c = Integer.MIN_VALUE;
            this.f556398d = 0;
            this.f556400f = Integer.MIN_VALUE;
            this.f556401g = Integer.MIN_VALUE;
            this.f556399e = r100;
        }

        public final void c(int r100) {
            int r101 = this.f556400f;
            if (r101 == Integer.MIN_VALUE) goto L5;
            this.f556400f = r101 + r100;
        L5:
            int r102 = this.f556396b;
            if (r102 == Integer.MIN_VALUE) goto L8;
            this.f556396b = r102 + r100;
        L8:
            int r103 = this.f556401g;
            if (r103 == Integer.MIN_VALUE) goto L11;
            this.f556401g = r103 + r100;
        L11:
            int r104 = this.f556397c;
            if (r104 == Integer.MIN_VALUE) goto L15;
            this.f556397c = r104 + r100;
            return;
        }

        public final void d(un.e r100) {
            int r101 = this.f556395a.size();
            View r102 = (View) ListProtector.remove(this.f556395a, r101 - 1);
            RecyclerView.LayoutParams r103 = (RecyclerView.LayoutParams) r102.getLayoutParams();
            if (r103.isItemRemoved() == false) goto L5;
        L6:
            this.f556398d -= r100.c(r102);
        L8:
            if (r101 != 1) goto L10;
            this.f556396b = Integer.MIN_VALUE;
        L10:
            this.f556397c = Integer.MIN_VALUE;
            return;
        L5:
            if (r103.isItemChanged() == false) goto L8;
            goto L6
        }

        public final void e(un.e r100) {
            View r101 = (View) ListProtector.remove(this.f556395a, 0);
            RecyclerView.LayoutParams r102 = (RecyclerView.LayoutParams) r101.getLayoutParams();
            if (this.f556395a.size() != 0) goto L6;
            this.f556397c = Integer.MIN_VALUE;
        L6:
            if (r102.isItemRemoved() == false) goto L8;
        L9:
            this.f556398d -= r100.c(r101);
        L10:
            this.f556396b = Integer.MIN_VALUE;
            return;
        L8:
            if (r102.isItemChanged() == false) goto L10;
            goto L9
        }

        public final int a(int r100, un.e r101) {
            int r102 = this.f556397c;
            if (r102 != Integer.MIN_VALUE) goto L5;
            if (r100 == Integer.MIN_VALUE) goto L15;
            if (this.f556395a.size() != 0) goto L15;
            int r103 = this.f556400f;
            if (r103 == Integer.MIN_VALUE) goto L13;
            return r103;
        L13:
            return r100;
        L15:
            if (this.f556395a.size() != 0) goto L17;
            this.f556397c = Integer.MIN_VALUE;
        L19:
            return this.f556397c;
        L17:
            ArrayList<View> r104 = this.f556395a;
            this.f556397c = r101.b((View) ListProtector.get(r104, r104.size() - 1));
            goto L19
        L5:
            return r102;
        }

        public final int b(int r100, un.e r101) {
            int r102 = this.f556396b;
            if (r102 == Integer.MIN_VALUE) goto L5;
            return r102;
        L5:
            if (r100 == Integer.MIN_VALUE) goto L13;
            if (this.f556395a.size() != 0) goto L13;
            int r103 = this.f556401g;
            if (r103 == Integer.MIN_VALUE) goto L11;
            return r103;
        L11:
            return r100;
        L13:
            if (this.f556395a.size() != 0) goto L15;
            this.f556396b = Integer.MIN_VALUE;
        L17:
            return this.f556396b;
        L15:
            this.f556396b = r101.e((View) ListProtector.get(this.f556395a, 0));
            goto L17
        }
    }

    public l() {
        this(1, 0);
    }

    @Override // com.bytedance.android.ec.vlayout.a
    public final void l() {
    }

    public final void B() {
        WeakReference<VirtualLayoutManager> r100 = this.f556392z;
        if (r100 != null) goto L5;
        return;
    L5:
        VirtualLayoutManager r101 = r100.get();
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.getChildCount() == 0) goto L125;
        un.f<Integer> r102 = this.f49095a;
        if (r101.getReverseLayout() == false) goto L13;
        int r103 = ((Integer) r102.f550758b).intValue() - 1;
    L14:
        un.e r104 = r101.f49079q;
        int r105 = r101.getChildCount();
        if (r101.getReverseLayout() == false) goto L34;
        int r106 = r105 - 1;
        int r107 = r106;
    L17:
        if (r107 < 0) goto L62;
        View r108 = r101.getChildAt(r107);
        if (r108 == null) goto L33;
        int r109 = r101.getPosition(r108);
        if (r109 != r103) goto L33;
        if (r107 != r106) goto L25;
        int r110 = r104.b(r108);
    L64:
        if (r109 != Integer.MIN_VALUE) goto L67;
        return;
    L67:
        if (r101.findViewByPosition(r109) == null) goto L102;
        new BitSet(this.f556380n).set(0, this.f556380n, true);
        c[] r111 = this.f556381o;
        if (r111 == null) goto L102;
        int r112 = r111.length;
        int r113 = 0;
    L72:
        if (r113 >= r112) goto L102;
        c r114 = this.f556381o[r113];
        if (r114.f556395a.size() == 0) goto L101;
        un.e r115 = r101.f49079q;
        if (r101.getReverseLayout() == false) goto L88;
        if (r101.getOrientation() != 1) goto L80;
        boolean r116 = true;
    L81:
        if (r116 == false) goto L83;
        int r117 = this.f556378g;
    L85:
        if ((r114.a(Integer.MIN_VALUE, r115) + (r117 + 0)) < r110) goto L93;
    L94:
        boolean r118 = false;
    L95:
        if (r118 == false) goto L101;
        if (r101.getReverseLayout() == false) goto L99;
        ArrayList<View> r119 = r114.f556395a;
        Object r120 = ListProtector.get(r119, r119.size() - 1);
    L100:
        View r121 = (View) r120;
    L103:
        if (r121 == null) goto L124;
        c[] r122 = this.f556381o;
        if (r122 == null) goto L109;
        int r123 = r122.length;
        int r124 = 0;
    L107:
        if (r124 >= r123) goto L109;
        c r125 = this.f556381o[r124];
        r125.f556395a.clear();
        r125.f556396b = Integer.MIN_VALUE;
        r125.f556397c = Integer.MIN_VALUE;
        r125.f556401g = Integer.MIN_VALUE;
        r125.f556400f = Integer.MIN_VALUE;
        r125.f556398d = 0;
        r124 = r124 + 1;
    L109:
        r101.requestSimpleAnimationsInNextLayout();
        r101.requestLayout();
        return;
    L124:
        return;
    L99:
        r120 = ListProtector.get(r114.f556395a, 0);
    L93:
        r118 = true;
        goto L95
    L83:
        r117 = this.f556375d;
        goto L85
    L80:
        r116 = false;
        goto L81
    L88:
        if (r101.getOrientation() != 1) goto L90;
        boolean r126 = true;
    L92:
        if ((r114.b(Integer.MIN_VALUE, r115) - t(r101, r126, true)) <= r110) goto L94;
    L90:
        r126 = false;
    L101:
        r113 = r113 + 1;
    L102:
        r121 = null;
        goto L103
    L25:
        View r127 = r101.getChildAt(r107 + 1);
        if (r101.getPosition(r127) != (r109 - 1)) goto L32;
        int r128 = r104.e(r127);
        if (r127 == null) goto L30;
        int r129 = r101.p(r127, false, true);
    L31:
        r110 = r101.p(r108, true, true) + (r128 - r129);
        goto L64
    L30:
        r129 = 0;
        goto L31
    L32:
        r110 = r104.b(r108);
    L33:
        r107 = r107 - 1;
    L62:
        r110 = Integer.MIN_VALUE;
    L63:
        r109 = Integer.MIN_VALUE;
        goto L64
    L34:
        int r130 = 0;
    L35:
        if (r130 >= r105) goto L62;
        View r131 = r101.getChildAt(r130);
        if (r131 == null) goto L62;
        r109 = r101.getPosition(r131);
        if (r109 == r103) goto L41;
        r130 = r130 + 1;
        goto L35
    L41:
        if (r130 != 0) goto L43;
        r110 = H(r104.i(), r104);
        goto L64
    L43:
        View r132 = r101.getChildAt(r130 - 1);
        int r133 = r104.b(r132);
        if (r132 == null) goto L46;
        int r134 = r101.p(r132, true, false);
    L47:
        int r135 = (r133 + r134) - r101.p(r131, false, false);
        if (r135 != r104.e(r131)) goto L50;
        r110 = r135;
        goto L63
    L50:
        int r136 = r101.getPosition(r132);
        int r137 = r103 - 1;
        if (r136 == r137) goto L59;
        com.bytedance.android.ec.vlayout.a r138 = r101.M(r137);
        if (r138 != null) goto L55;
    L60:
        r110 = r135;
        goto L64
    L55:
        if ((r138 instanceof m) == false) goto L60;
        if (r138.g() == null) goto L60;
        r135 = r135 + r138.g().getMeasuredHeight();
        goto L60
    L59:
        r101.M(r136).getClass();
        goto L60
    L46:
        r134 = 0;
        goto L47
    L13:
        r103 = ((Integer) r102.f550757a).intValue();
        goto L14
    }

    public final void C() {
        c[] r100 = this.f556381o;
        if (r100 != null) goto L5;
    L8:
        this.f556387u = new BitSet(this.f556380n);
        this.f556381o = new c[this.f556380n];
        int r101 = 0;
    L10:
        if (r101 >= this.f556380n) goto L14;
        this.f556381o[r101] = new c(r101);
        r101 = r101 + 1;
        goto L10
    L14:
        return;
    L5:
        if (r100.length != this.f556380n) goto L8;
        if (this.f556387u == null) goto L8;
    }

    @Override // com.bytedance.android.ec.vlayout.a
    public final void p(VirtualLayoutManager.c r100) {
        C();
        if (j(r100.f49090a) == false) goto L9;
        c[] r101 = this.f556381o;
        if (r101 == null) goto L11;
        int r102 = r101.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L12;
        c r104 = this.f556381o[r103];
        r104.f556395a.clear();
        r104.f556396b = Integer.MIN_VALUE;
        r104.f556397c = Integer.MIN_VALUE;
        r104.f556401g = Integer.MIN_VALUE;
        r104.f556400f = Integer.MIN_VALUE;
        r104.f556398d = 0;
        r103 = r103 + 1;
        goto L7
    L12:
        return;
    L11:
        return;
    }

    @Override // vn.a
    public final void x(com.bytedance.android.ec.vlayout.b r100) {
        int[] r101 = this.f556388v.f556394a;
        if (r101 == null) goto L5;
        Arrays.fill(r101, Integer.MIN_VALUE);
    L5:
        this.f556381o = null;
        this.f556392z = null;
    }

    public l(int r100, int r101) {
        this.f556380n = 0;
        this.f556382p = 0;
        this.f556383q = 0;
        this.f556384r = 0;
        this.f556385s = 0;
        this.f556386t = 0;
        this.f556387u = null;
        this.f556388v = new b();
        this.f556389w = new ArrayList();
        this.f556392z = null;
        this.A = new a(this);
        this.f556380n = r100;
        C();
        this.f556382p = 0;
        this.f556383q = 0;
    }

    public final int E(int r100, un.e r101) {
        c[] r102 = this.f556381o;
        if (r102 != null) goto L5;
    L15:
        return r100;
    L5:
        if (r102.length == 0) goto L15;
        int r103 = r102[0].a(r100, r101);
        int r104 = 1;
    L9:
        if (r104 >= this.f556380n) goto L14;
        int r105 = this.f556381o[r104].a(r100, r101);
        if (r105 <= r103) goto L13;
        r103 = r105;
    L13:
        r104 = r104 + 1;
        goto L9
    L14:
        return r103;
    }

    public final int F(int r100, un.e r101) {
        c[] r102 = this.f556381o;
        if (r102 != null) goto L5;
    L15:
        return r100;
    L5:
        if (r102.length == 0) goto L15;
        int r103 = r102[0].b(r100, r101);
        int r104 = 1;
    L9:
        if (r104 >= this.f556380n) goto L14;
        int r105 = this.f556381o[r104].b(r100, r101);
        if (r105 <= r103) goto L13;
        r103 = r105;
    L13:
        r104 = r104 + 1;
        goto L9
    L14:
        return r103;
    }

    public final int G(int r100, un.e r101) {
        c[] r102 = this.f556381o;
        if (r102 != null) goto L5;
    L15:
        return r100;
    L5:
        if (r102.length == 0) goto L15;
        int r103 = r102[0].a(r100, r101);
        int r104 = 1;
    L9:
        if (r104 >= this.f556380n) goto L14;
        int r105 = this.f556381o[r104].a(r100, r101);
        if (r105 >= r103) goto L13;
        r103 = r105;
    L13:
        r104 = r104 + 1;
        goto L9
    L14:
        return r103;
    }

    public final int H(int r100, un.e r101) {
        c[] r102 = this.f556381o;
        if (r102 != null) goto L5;
    L15:
        return r100;
    L5:
        if (r102.length == 0) goto L15;
        int r103 = r102[0].b(r100, r101);
        int r104 = 1;
    L9:
        if (r104 >= this.f556380n) goto L14;
        int r105 = this.f556381o[r104].b(r100, r101);
        if (r105 >= r103) goto L13;
        r103 = r105;
    L13:
        r104 = r104 + 1;
        goto L9
    L14:
        return r103;
    }

    @Override // com.bytedance.android.ec.vlayout.a
    public final void m(int r100, com.bytedance.android.ec.vlayout.b r101) {
        if (r101.getOrientation() != 0) goto L9;
        c[] r102 = this.f556381o;
        if (r102 == null) goto L11;
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L12;
        this.f556381o[r104].c(r100);
        r104 = r104 + 1;
        goto L7
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.ec.vlayout.a
    public final void n(int r100, com.bytedance.android.ec.vlayout.b r101) {
        if (r101.getOrientation() != 1) goto L9;
        c[] r102 = this.f556381o;
        if (r102 == null) goto L11;
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L12;
        this.f556381o[r104].c(r100);
        r104 = r104 + 1;
        goto L7
    L12:
        return;
    L11:
        return;
    }

    public final c D(int r100, View r101, boolean r110) {
        int[] r102 = this.f556388v.f556394a;
        if (r102 != null) goto L5;
    L9:
        int r103 = Integer.MIN_VALUE;
    L10:
        c[] r104 = this.f556381o;
        if (r104 != null) goto L14;
        return null;
    L14:
        if (r103 >= 0) goto L16;
    L36:
        int r105 = 0;
    L37:
        c[] r106 = this.f556381o;
        if (r105 >= r106.length) goto L61;
        if (r105 == r103) goto L60;
        c r107 = r106[r105];
        if (r110 == true) goto L44;
    L51:
        if (r110 == true) goto L60;
        int r108 = r107.f556395a.size();
        if (r108 > 0) goto L55;
    L57:
        boolean r109 = false;
    L58:
        if (r109 == false) goto L60;
        return r107;
    L55:
        if (ListProtector.get(r107.f556395a, r108 - 1) != r101) goto L57;
        r109 = true;
        goto L58
    L44:
        if (r107.f556395a.size() > 0) goto L46;
    L48:
        boolean r111 = false;
    L49:
        if (r111 == false) goto L51;
        return r107;
    L46:
        if (ListProtector.get(r107.f556395a, 0) != r101) goto L48;
        r111 = true;
    L60:
        r105 = r105 + 1;
        goto L37
    L61:
        return null;
    L16:
        if (r103 >= r104.length) goto L36;
        c r112 = r104[r103];
        if (r110 == true) goto L20;
    L27:
        if (r110 == true) goto L36;
        int r113 = r112.f556395a.size();
        if (r113 > 0) goto L31;
    L33:
        boolean r114 = false;
    L34:
        if (r114 == false) goto L36;
        return r112;
    L31:
        if (ListProtector.get(r112.f556395a, r113 - 1) != r101) goto L33;
        r114 = true;
        goto L34
    L20:
        if (r112.f556395a.size() > 0) goto L22;
    L24:
        boolean r115 = false;
    L25:
        if (r115 == false) goto L27;
        return r112;
    L22:
        if (ListProtector.get(r112.f556395a, 0) != r101) goto L24;
        r115 = true;
        goto L25
    L5:
        if (r100 >= r102.length) goto L9;
        if (r100 < 0) goto L9;
        r103 = r102[r100];
        goto L10
    }

    @Override // vn.a, com.bytedance.android.ec.vlayout.a
    public final void b(RecyclerView.Recycler r100, RecyclerView.State r101, com.bytedance.android.ec.vlayout.b r110) {
        super.b(r100, r101, r110);
        if (r110.getOrientation() != 1) goto L5;
        int r102 = ((((VirtualLayoutManager) r110).P() - r110.getPaddingLeft()) - r110.getPaddingRight()) - 0;
        int r103 = this.f556375d;
        int r104 = this.f556376e;
    L6:
        int r105 = r102 - (r103 + r104);
        int r106 = this.f556382p;
        int r107 = this.f556380n;
        int r108 = (int) (((double) ((r105 - (r106 * (r107 - 1))) / r107)) + 0.5d);
        this.f556384r = r108;
        int r109 = r105 - (r108 * r107);
        if (r107 > 1) goto L10;
        this.f556386t = 0;
        this.f556385s = 0;
    L17:
        WeakReference<VirtualLayoutManager> r111 = this.f556392z;
        if (r111 == null) goto L24;
        if (r111.get() == null) goto L24;
        if (this.f556392z.get() != r110) goto L24;
        return;
    L24:
        if ((r110 instanceof VirtualLayoutManager) == false) goto L28;
        this.f556392z = new WeakReference((VirtualLayoutManager) r110);
        return;
    L28:
        return;
    L10:
        if (r107 != 2) goto L13;
        this.f556385s = r109;
        this.f556386t = r109;
        goto L17
    L13:
        if (r110.getOrientation() != 1) goto L15;
        int r112 = this.f556382p;
    L16:
        this.f556386t = r112;
        this.f556385s = r112;
        goto L17
    L15:
        r112 = this.f556383q;
        goto L16
    L5:
        r102 = ((((VirtualLayoutManager) r110).O() - r110.getPaddingTop()) - r110.getPaddingBottom()) - 0;
        r103 = this.f556377f;
        r104 = this.f556378g;
        goto L6
    }

    @Override // com.bytedance.android.ec.vlayout.a
    public final void c(RecyclerView.State r110, VirtualLayoutManager.c r111, com.bytedance.android.ec.vlayout.b r112) {
        C();
        un.f<Integer> r113 = this.f49095a;
        View r100 = r112.findViewByPosition(r111.f49090a);
        boolean r101 = true;
        if (r112.getOrientation() != 1) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        int r103 = this.f556383q;
    L9:
        un.e r104 = ((VirtualLayoutManager) r112).f49079q;
        if (r100 != null) goto L17;
        c[] r114 = this.f556381o;
        if (r114 == null) goto L82;
        int r115 = r114.length;
        int r116 = 0;
    L14:
        if (r116 >= r115) goto L92;
        c r117 = this.f556381o[r116];
        r117.f556395a.clear();
        r117.f556396b = Integer.MIN_VALUE;
        r117.f556397c = Integer.MIN_VALUE;
        r117.f556401g = Integer.MIN_VALUE;
        r117.f556400f = Integer.MIN_VALUE;
        r117.f556398d = 0;
        r116 = r116 + 1;
        goto L14
    L92:
        return;
    L82:
        return;
    L17:
        if (r111.f49092c == false) goto L19;
        int r105 = Integer.MIN_VALUE;
    L20:
        c[] r106 = this.f556381o;
        if (r106 == null) goto L32;
        int r107 = r106.length;
        int r108 = 0;
    L23:
        if (r108 >= r107) goto L32;
        c r109 = this.f556381o[r108];
        if (r109.f556395a.isEmpty() == true) goto L30;
        if (r111.f49092c == false) goto L29;
        ArrayList<View> r118 = r109.f556395a;
        r105 = Math.max(r105, r112.getPosition((View) ListProtector.get(r118, r118.size() - 1)));
        goto L30
    L29:
        r105 = Math.min(r105, r112.getPosition((View) ListProtector.get(r109.f556395a, 0)));
    L30:
        r108 = r108 + 1;
    L32:
        if (j(r105) == false) goto L34;
        this.f556391y = r111.f49090a;
        this.f556390x = true;
    L61:
        int r119 = Integer.MIN_VALUE;
    L62:
        c[] r120 = this.f556381o;
        if (r120 == null) goto L91;
        int r121 = r120.length;
        int r122 = 0;
    L65:
        if (r122 >= r121) goto L93;
        c r123 = this.f556381o[r122];
        boolean r124 = r112.getReverseLayout() ^ r111.f49092c;
        if (r124 == false) goto L69;
        int r125 = r123.a(Integer.MIN_VALUE, r104);
    L70:
        r123.f556395a.clear();
        r123.f556396b = Integer.MIN_VALUE;
        r123.f556397c = Integer.MIN_VALUE;
        r123.f556401g = Integer.MIN_VALUE;
        r123.f556400f = Integer.MIN_VALUE;
        r123.f556398d = 0;
        if (r125 == Integer.MIN_VALUE) goto L81;
        if (r124 == true) goto L75;
    L76:
        if (r124 == true) goto L78;
        r104.i();
    L78:
        if (r119 == Integer.MIN_VALUE) goto L80;
        r125 = r125 + r119;
    L80:
        r123.f556397c = r125;
        r123.f556396b = r125;
        r123.f556401g = Integer.MIN_VALUE;
        r123.f556400f = Integer.MIN_VALUE;
        goto L81
    L75:
        if (r125 < r104.g()) goto L78;
    L81:
        r122 = r122 + 1;
        goto L65
    L69:
        r125 = r123.b(Integer.MIN_VALUE, r104);
        goto L70
    L93:
        return;
    L91:
        return;
    L34:
        if (r105 == ((Integer) r113.f550757a).intValue()) goto L37;
        r101 = false;
    L37:
        View r126 = r112.findViewByPosition(r105);
        if (r126 == null) goto L61;
        if (r111.f49092c == false) goto L50;
        r111.f49090a = r105;
        int r127 = r104.b(r100);
        int r128 = r111.f49091b;
        if (r127 >= r128) goto L47;
        int r129 = r128 - r127;
        if (r101 == false) goto L46;
        r103 = 0;
    L46:
        r119 = r129 + r103;
        r111.f49091b = r104.b(r126) + r119;
        goto L62
    L47:
        if (r101 == false) goto L49;
        r103 = 0;
    L49:
        r111.f49091b = r104.b(r126) + r103;
        r119 = r103;
        goto L62
    L50:
        r111.f49090a = r105;
        int r130 = r104.e(r100);
        VirtualLayoutManager r131 = this.f556392z.get();
        int r132 = r111.f49091b;
        if (r130 <= r132) goto L56;
        int r133 = r132 - r130;
        if (r101 == false) goto L55;
        r103 = 0;
    L55:
        r119 = r133 - r103;
        r111.f49091b = r104.e(r126) + r119;
        goto L62
    L56:
        if (r101 == false) goto L58;
        r103 = 0;
    L58:
        int r134 = -r103;
        r111.f49091b = r104.e(r126) + r134;
        r119 = r134;
        goto L62
    L19:
        r105 = Integer.MAX_VALUE;
        goto L20
    L8:
        r103 = this.f556382p;
        goto L9
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.android.ec.vlayout.a
    public final void k(int r100, com.bytedance.android.ec.vlayout.b r101, boolean r102) {
        View r103 = r101.findViewByPosition(r100);
        if (r103 == null) goto L21;
        un.e r104 = ((VirtualLayoutManager) r101).f49079q;
        int r105 = ((RecyclerView.LayoutParams) r103.getLayoutParams()).getViewPosition();
        if (r101.getReverseLayout() == false) goto L13;
        if (r102 == false) goto L10;
        c r106 = D(r105, r103, true);
        if (r106 == null) goto L22;
        r106.d(r104);
        return;
    L22:
        return;
    L10:
        c r107 = D(r105, r103, false);
        if (r107 == null) goto L24;
        r107.e(r104);
        return;
    L24:
        return;
    L13:
        if (r102 == false) goto L17;
        c r108 = D(r105, r103, true);
        if (r108 == null) goto L26;
        r108.e(r104);
        return;
    L26:
        return;
    L17:
        c r109 = D(r105, r103, false);
        if (r109 == null) goto L28;
        r109.d(r104);
        return;
    L28:
        return;
    }

    @Override // com.bytedance.android.ec.vlayout.a
    public final void q(int r100, int r101, int r102) {
        if (r101 <= ((Integer) this.f49095a.f550758b).intValue()) goto L5;
        return;
    L5:
        if (r102 < ((Integer) this.f49095a.f550757a).intValue()) goto L12;
        if (r100 != 0) goto L11;
        B();
        return;
    L11:
        return;
    }

    public final void I(c r100, int r101, int r102, un.e r103) {
        int r104 = r100.f556398d;
        if (r101 != (-1)) goto L8;
        if ((r100.b(Integer.MIN_VALUE, r103) + r104) >= r102) goto L11;
        this.f556387u.set(r100.f556399e, false);
        return;
    L11:
        return;
    L8:
        if ((r100.a(Integer.MIN_VALUE, r103) - r104) <= r102) goto L13;
        this.f556387u.set(r100.f556399e, false);
        return;
    }

    @Override // vn.i, com.bytedance.android.ec.vlayout.a
    public final int e(int r100, boolean r101, boolean r102, com.bytedance.android.ec.vlayout.b r103) {
        if (r103.getOrientation() != 1) goto L5;
        boolean r104 = true;
    L6:
        un.e r105 = ((VirtualLayoutManager) r103).f49079q;
        View r106 = r103.findViewByPosition(((Integer) this.f49095a.f550757a).intValue() + r100);
        if (r106 != null) goto L9;
        return 0;
    L9:
        C();
        if (r104 == false) goto L25;
        if (r101 == true) goto L13;
        if (r100 == 0) goto L22;
        if (r102 == true) goto L25;
        int r107 = F(r105.b(r106), r105);
        int r108 = r105.e(r106);
    L19:
        return r107 - r108;
    L22:
        return (0 - this.f556377f) - (r105.e(r106) - H(r105.e(r106), r105));
    L13:
        if (r100 == (this.f556365l - 1)) goto L15;
        if (r102 == true) goto L25;
        r107 = G(r105.e(r106), r105);
        r108 = r105.b(r106);
        goto L19
    L15:
        return (0 + this.f556378g) + (E(r105.b(r106), r105) - r105.b(r106));
    L25:
        return 0;
    L5:
        r104 = false;
        goto L6
    }

    @Override // vn.a
    public final void w(RecyclerView.Recycler r210, RecyclerView.State r211, VirtualLayoutManager.e r212, g r213, com.bytedance.android.ec.vlayout.b r214) {
        RecyclerView.Recycler r100 = r210;
        RecyclerView.State r101 = r211;
        g r110 = r213;
        if (j(r212.f49093a.f49067f) == false) goto L5;
        return;
    L5:
        C();
        if (r214.getOrientation() != 1) goto L8;
        boolean r111 = true;
    L9:
        VirtualLayoutManager r102 = (VirtualLayoutManager) r214;
        un.e r103 = r102.f49079q;
        un.e r104 = r102.f49080r;
        this.f556387u.set(0, this.f556380n, true);
        ExposeLinearLayoutManagerEx.d r105 = r212.f49093a;
        if (r105.f49069h != 1) goto L12;
        int r106 = r105.f49065d + r105.f49066e;
        int r107 = (r105.f49071j + r106) + r103.h();
    L13:
        int r108 = r107;
        int r109 = r106;
        int r112 = r212.f49093a.f49069h;
        int r113 = 0;
    L15:
        if (r113 >= this.f556380n) goto L21;
        if (this.f556381o[r113].f556395a.isEmpty() == true) goto L20;
        I(this.f556381o[r113], r112, r108, r103);
    L20:
        r113 = r113 + 1;
        goto L15
    L21:
        int r114 = r212.f49093a.f49065d;
        ((ArrayList) this.f556389w).clear();
        j(r212.f49093a.f49067f);
    L23:
        if (r212.a(r101) == false) goto L211;
        if (this.f556387u.isEmpty() == true) goto L211;
        if (j(r212.f49093a.f49067f) == true) goto L211;
        j(r212.f49093a.f49067f);
        ExposeLinearLayoutManagerEx.d r115 = r212.f49093a;
        int r116 = r115.f49065d;
        int r117 = r115.f49067f;
        View r118 = r115.a(r100);
        if (r118 == null) goto L30;
        VirtualLayoutManager.LayoutParams r119 = (VirtualLayoutManager.LayoutParams) r118.getLayoutParams();
        int r120 = r109;
        int r121 = r119.getViewPosition();
        int r122 = r108;
        int[] r123 = this.f556388v.f556394a;
        if (r123 != null) goto L34;
    L38:
        int r124 = Integer.MIN_VALUE;
    L40:
        if (r124 != Integer.MIN_VALUE) goto L42;
        boolean r125 = true;
    L43:
        if (r125 == false) goto L93;
        un.e r126 = r102.f49079q;
        if (r214.getOrientation() != 0) goto L54;
        if (r212.f49093a.f49069h != (-1)) goto L49;
        boolean r127 = true;
    L51:
        if (r127 != r214.getReverseLayout()) goto L63;
    L64:
        boolean r128 = false;
    L65:
        if (r128 == false) goto L67;
        int r129 = this.f556380n - 1;
        int r130 = -1;
        int r131 = -1;
    L68:
        c r215 = null;
        if (r212.f49093a.f49069h != 1) goto L77;
        int r132 = Integer.MAX_VALUE;
        int r133 = r129;
    L71:
        if (r133 == r130) goto L76;
        int r216 = r117;
        c r134 = this.f556381o[r133];
        int r135 = r134.a(r114, r126);
        if (r135 >= r132) goto L75;
        r132 = r135;
        r215 = r134;
    L75:
        r133 = r133 + r131;
        r117 = r216;
        goto L71
    L76:
        int r217 = r117;
    L83:
        c r136 = r215;
        b r137 = this.f556388v;
        int[] r138 = r137.f556394a;
        if (r138 != null) goto L87;
        int[] r139 = new int[Math.max(r121, 10) + 1];
        r137.f556394a = r139;
        Arrays.fill(r139, Integer.MIN_VALUE);
    L92:
        r137.f556394a[r121] = r136.f556399e;
    L94:
        c r140 = r136;
        int r141 = r140.f556399e;
        if ((r121 - ((Integer) this.f49095a.f550757a).intValue()) >= this.f556380n) goto L97;
        boolean r142 = true;
    L99:
        if ((((Integer) this.f49095a.f550758b).intValue() - r121) >= this.f556380n) goto L101;
        boolean r143 = true;
    L103:
        if (r212.f49093a.f49072k == false) goto L106;
        ((ArrayList) this.f556389w).add(r118);
    L106:
        if (r212.f49093a.f49068g != 1) goto L108;
        int r144 = -1;
    L109:
        r102.V(r118);
        if (r212.f49093a.f49073l == null) goto L112;
        boolean r145 = true;
    L113:
        if (r145 == true) goto L115;
        r102.addView(r118, r144);
    L117:
        if (r111 == false) goto L123;
        int r146 = RecyclerView.LayoutManager.getChildMeasureSpec(this.f556384r, 0, ((ViewGroup.MarginLayoutParams) r119).width, false);
        int r147 = r103.j();
        if (Float.isNaN(r119.f49089a) == false) goto L121;
        int r148 = ((ViewGroup.MarginLayoutParams) r119).height;
    L122:
        int r149 = RecyclerView.LayoutManager.getChildMeasureSpec(r147, 0, r148, true);
        com.bytedance.android.ec.vlayout.b r150 = r214;
        r150.measureChildWithMargins(r118, r146, r149);
        boolean r151 = true;
    L129:
        if (r212.f49093a.f49069h != r151) goto L146;
        int r152 = r140.a(r114, r103);
        if (r142 == false) goto L135;
        int r153 = t(r150, r111, r151);
    L133:
        r152 = r152 + r153;
    L145:
        r103.c(r118);
        int r154 = r152;
        int r155 = r103.c(r118) + r152;
    L154:
        if (r212.f49093a.f49069h != 1) goto L164;
        RecyclerView.LayoutParams r156 = (RecyclerView.LayoutParams) r118.getLayoutParams();
        r140.f556395a.add(r118);
        r140.f556397c = Integer.MIN_VALUE;
        if (r140.f556395a.size() != 1) goto L159;
        r140.f556396b = Integer.MIN_VALUE;
    L159:
        if (r156.isItemRemoved() == false) goto L161;
    L162:
        r140.f556398d += r103.c(r118);
    L172:
        int r157 = r140.f556399e;
        if (r157 != (this.f556380n - 1)) goto L175;
        int r158 = this.f556384r;
        int r159 = this.f556385s;
        int r160 = ((r157 * (r158 + r159)) - r159) + this.f556386t;
    L176:
        int r161 = r160 + r104.i();
        if (r111 == false) goto L179;
        int r162 = this.f556375d;
    L180:
        int r163 = (r162 + 0) + r161;
        int r164 = r163 + r103.d(r118);
        if (r111 == false) goto L183;
        View r165 = r118;
        int r166 = r122;
        un.e r167 = r103;
        v(r165, r163, r154, r164, r155, r214);
        VirtualLayoutManager r168 = r102;
        un.e r169 = r167;
    L184:
        r169.b(r165);
        I(r140, r212.f49093a.f49069h, r166, r169);
        un.e r170 = r168.f49079q;
        if (r212.f49093a.f49069h != (-1)) goto L198;
        int r171 = Math.max(r120, F(r140.b(Integer.MIN_VALUE, r170), r170)) + (r170.f() - r170.i());
        un.e r172 = r168.f49079q;
        int r173 = r214.getChildCount() - 1;
    L187:
        if (r173 < 0) goto L197;
        View r174 = r150.getChildAt(r173);
        if (r174 == null) goto L197;
        if (r172.e(r174) <= r171) goto L197;
        c r175 = D(((RecyclerView.LayoutParams) r174.getLayoutParams()).getViewPosition(), r174, false);
        if (r175 == null) goto L196;
        r175.d(r172);
        r168.removeView(r174);
        r210.recycleView(r174);
    L196:
        r173 = r173 - 1;
    L197:
        RecyclerView.Recycler r176 = r210;
    L210:
        vn.a.u(r213, r165);
        r211.getItemCount();
        r212.a(r211);
        this.f556387u.isEmpty();
        j(r212.f49093a.f49067f);
        r100 = r176;
        r103 = r169;
        r102 = r168;
        r109 = r120;
        r108 = r166;
        r111 = r111;
        r114 = r114;
        r104 = r104;
        r101 = r211;
        r110 = r213;
        goto L23
    L198:
        r176 = r210;
        int r177 = Math.min(r120, G(r140.a(Integer.MIN_VALUE, r170), r170)) - (r170.f() - r170.i());
        un.e r178 = r168.f49079q;
        boolean r179 = true;
    L200:
        if (r214.getChildCount() <= 0) goto L210;
        if (r179 == false) goto L210;
        View r180 = r150.getChildAt(0);
        if (r180 == null) goto L210;
        if (r178.b(r180) >= r177) goto L210;
        c r181 = D(((RecyclerView.LayoutParams) r180.getLayoutParams()).getViewPosition(), r180, true);
        if (r181 != null) goto L208;
        r179 = false;
        goto L200
    L208:
        r181.e(r178);
        r168.removeView(r180);
        r176.recycleView(r180);
        goto L200
    L183:
        r165 = r118;
        r166 = r122;
        int r182 = r155;
        r169 = r103;
        r168 = r102;
        v(r165, r154, r163, r182, r164, r214);
        goto L184
    L179:
        r162 = this.f556377f;
        goto L180
    L175:
        r160 = r157 * (this.f556384r + this.f556385s);
        goto L176
    L161:
        if (r156.isItemChanged() == false) goto L172;
    L164:
        RecyclerView.LayoutParams r183 = (RecyclerView.LayoutParams) r118.getLayoutParams();
        ListProtector.add(r140.f556395a, 0, r118);
        r140.f556396b = Integer.MIN_VALUE;
        if (r140.f556395a.size() != 1) goto L168;
        r140.f556397c = Integer.MIN_VALUE;
    L168:
        if (r183.isItemRemoved() == false) goto L170;
    L171:
        r140.f556398d += r103.c(r118);
        goto L172
    L170:
        if (r183.isItemChanged() == false) goto L172;
    L135:
        if (this.f556390x == true) goto L137;
        if (r111 == false) goto L144;
        r153 = this.f556383q;
        goto L133
    L144:
        r153 = this.f556382p;
        goto L133
    L137:
        if (Math.abs(r217 - this.f556391y) < this.f556380n) goto L145;
        if (r111 == false) goto L141;
        r153 = this.f556383q;
        goto L133
    L141:
        r153 = this.f556382p;
        goto L133
    L146:
        if (r143 == false) goto L148;
        int r184 = r140.b(r114, r103);
        int r185 = this.f556376e + 0;
    L152:
        int r186 = r184 - r185;
        r155 = r186;
        r154 = r186 - r103.c(r118);
        goto L154
    L148:
        r184 = r140.b(r114, r103);
        if (r111 == false) goto L151;
        r185 = this.f556383q;
        goto L152
    L151:
        r185 = this.f556382p;
        goto L152
    L121:
        r148 = (int) ((View.MeasureSpec.getSize(r146) / r119.f49089a) + 0.5f);
        goto L122
    L123:
        r150 = r214;
        int r187 = RecyclerView.LayoutManager.getChildMeasureSpec(this.f556384r, 0, ((ViewGroup.MarginLayoutParams) r119).height, false);
        int r188 = r103.j();
        if (Float.isNaN(r119.f49089a) == false) goto L126;
        int r189 = ((ViewGroup.MarginLayoutParams) r119).width;
    L127:
        r151 = true;
        r150.measureChildWithMargins(r118, RecyclerView.LayoutManager.getChildMeasureSpec(r188, 0, r189, true), r187);
        goto L129
    L126:
        r189 = (int) ((View.MeasureSpec.getSize(r187) * r119.f49089a) + 0.5f);
        goto L127
    L115:
        r102.addDisappearingView(r118, r144);
        goto L117
    L112:
        r145 = false;
        goto L113
    L108:
        r144 = 0;
        goto L109
    L101:
        r143 = false;
        goto L103
    L97:
        r142 = false;
        goto L99
    L87:
        if (r121 < r138.length) goto L92;
        int r190 = r138.length;
    L89:
        if (r190 > r121) goto L91;
        r190 = r190 * 2;
        goto L89
    L91:
        int[] r191 = new int[r190];
        r137.f556394a = r191;
        System.arraycopy(r138, 0, r191, 0, r138.length);
        int[] r192 = r137.f556394a;
        Arrays.fill(r192, r138.length, r192.length, Integer.MIN_VALUE);
        goto L92
    L77:
        r217 = r117;
        int r193 = r129;
        int r194 = Integer.MIN_VALUE;
    L78:
        if (r193 == r130) goto L83;
        c r195 = this.f556381o[r193];
        int r196 = r195.b(r114, r126);
        if (r196 <= r194) goto L82;
        r215 = r195;
        r194 = r196;
    L82:
        r193 = r193 + r131;
        goto L78
    L67:
        r130 = this.f556380n;
        r131 = 1;
        r129 = 0;
    L63:
        r128 = true;
        goto L65
    L49:
        r127 = false;
        goto L51
    L54:
        if (r212.f49093a.f49069h != (-1)) goto L56;
        boolean r197 = true;
    L58:
        if (r197 != r214.getReverseLayout()) goto L60;
        boolean r198 = true;
    L62:
        if (r198 != r102.isLayoutRTL()) goto L64;
    L60:
        r198 = false;
        goto L62
    L56:
        r197 = false;
        goto L58
    L93:
        r217 = r117;
        r136 = this.f556381o[r124];
        goto L94
    L42:
        r125 = false;
        goto L43
    L34:
        if (r121 >= r123.length) goto L38;
        if (r121 < 0) goto L38;
        r124 = r123[r121];
        goto L40
    L30:
        new Throwable("view == null");
    L211:
        VirtualLayoutManager r199 = r102;
        RecyclerView.Recycler r200 = r100;
        RecyclerView.State r201 = r101;
        g r202 = r110;
        boolean r1100 = r111;
        un.e r203 = r103;
        if (j(r212.f49093a.f49067f) == false) goto L229;
        c[] r204 = this.f556381o;
        if (r204 == null) goto L229;
        if (r212.f49093a.f49069h != (-1)) goto L223;
        int r205 = r204.length;
        int r206 = 0;
    L218:
        if (r206 >= r205) goto L229;
        c r207 = this.f556381o[r206];
        int r208 = r207.f556396b;
        if (r208 == Integer.MIN_VALUE) goto L222;
        r207.f556400f = r208;
    L222:
        r206 = r206 + 1;
        goto L218
    L223:
        int r209 = r204.length;
        int r218 = 0;
    L224:
        if (r218 >= r209) goto L229;
        c r219 = this.f556381o[r218];
        int r220 = r219.f556397c;
        if (r220 == Integer.MIN_VALUE) goto L228;
        r219.f556401g = r220;
    L228:
        r218 = r218 + 1;
    L229:
        ExposeLinearLayoutManagerEx.d r221 = r212.f49093a;
        if (r221.f49069h != (-1)) goto L241;
        j(r221.f49067f);
        r212.a(r201);
        Objects.toString(this.f49095a);
        if (j(r212.f49093a.f49067f) == false) goto L234;
    L236:
        int r222 = r212.f49093a.f49065d - H(r203.g(), r203);
        if (r1100 == false) goto L239;
        int r223 = this.f556377f;
    L240:
        r202.f556369a = r222 + (0 + r223);
    L251:
        un.e r224 = r199.f49079q;
        int r225 = ((ArrayList) this.f556389w).size() - 1;
    L252:
        if (r225 < 0) goto L306;
        View r226 = (View) ListProtector.get(this.f556389w, r225);
        if (r226 == null) goto L261;
        if (r224.e(r226) <= r224.g()) goto L261;
        c r227 = D(((RecyclerView.LayoutParams) r226.getLayoutParams()).getViewPosition(), r226, false);
        if (r227 == null) goto L260;
        r227.d(r224);
    L260:
        r199.removeView(r226);
        r200.recycleView(r226);
        r225 = r225 - 1;
    L261:
        c r228 = D(((RecyclerView.LayoutParams) r226.getLayoutParams()).getViewPosition(), r226, false);
        if (r228 == null) goto L264;
        r228.d(r224);
    L264:
        r199.removeView(r226);
        r200.recycleView(r226);
        return;
    L306:
        return;
    L239:
        r223 = this.f556375d;
        goto L240
    L234:
        if (r212.a(r201) == false) goto L236;
        r202.f556369a = r212.f49093a.f49065d - F(r203.i(), r203);
        goto L251
    L241:
        j(r221.f49067f);
        r212.a(r201);
        Objects.toString(this.f49095a);
        System.identityHashCode(this.f49095a);
        G(r203.g(), r203);
        E(r203.g(), r203);
        if (j(r212.f49093a.f49067f) == false) goto L244;
    L246:
        int r229 = E(r203.i(), r203);
        this.f556381o[0].f556395a.size();
        this.f556381o[1].f556395a.size();
        int r230 = r229 - r212.f49093a.f49065d;
        if (r1100 == false) goto L249;
        int r231 = this.f556378g;
    L250:
        r202.f556369a = r230 + (0 + r231);
        goto L251
    L249:
        r231 = this.f556376e;
        goto L250
    L244:
        if (r212.a(r201) == false) goto L246;
        r202.f556369a = G(r203.g(), r203) - r212.f49093a.f49065d;
        goto L251
    L12:
        r106 = r105.f49065d - r105.f49066e;
        r107 = (r106 - r105.f49071j) - r103.i();
        goto L13
    L8:
        r111 = false;
        goto L9
    }

    @Override // vn.a, com.bytedance.android.ec.vlayout.a
    public final void a(RecyclerView.Recycler r100, RecyclerView.State r101, int r102, int r103, int r104, com.bytedance.android.ec.vlayout.b r105) {
        super.a(r100, r101, r102, r103, r104, r105);
        this.f556390x = false;
        if (r102 <= ((Integer) this.f49095a.f550758b).intValue()) goto L5;
        return;
    L5:
        if (r103 >= ((Integer) this.f49095a.f550757a).intValue()) goto L8;
        return;
    L8:
        if (r101.isPreLayout() == false) goto L10;
        return;
    L10:
        if (r105.getChildCount() <= 0) goto L15;
        ViewCompat.postOnAnimation(r105.getChildAt(0), this.A);
        return;
    }
}
