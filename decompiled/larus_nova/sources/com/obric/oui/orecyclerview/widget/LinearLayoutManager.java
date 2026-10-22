package com.obric.oui.orecyclerview.widget;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public class LinearLayoutManager extends RecyclerView.k implements RecyclerView.u.b {
    public final int A;
    public final int[] B;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f401559n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public c f401560o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public c0 f401561p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f401562q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f401563r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f401564s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f401565t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f401566u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f401567v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f401568w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public SavedState f401569x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final a f401570y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final b f401571z;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f401572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f401573b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f401574c;

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

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        static {
            CREATOR = new a();
        }

        public SavedState() {
        }

        public SavedState(Parcel r100) {
            this.f401572a = r100.readInt();
            this.f401573b = r100.readInt();
            boolean r101 = true;
            if (r100.readInt() == 1) goto L6;
            r101 = false;
        L6:
            this.f401574c = r101;
        }

        public SavedState(SavedState r100) {
            this.f401572a = r100.f401572a;
            this.f401573b = r100.f401573b;
            this.f401574c = r100.f401574c;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(this.f401572a);
            r100.writeInt(this.f401573b);
            r100.writeInt(this.f401574c ? 1 : 0);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c0 f401575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f401576b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f401577c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f401578d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f401579e;

        public final void d() {
            this.f401576b = -1;
            this.f401577c = Integer.MIN_VALUE;
            this.f401578d = false;
            this.f401579e = false;
        }

        public final void a() {
            if (this.f401578d == false) goto L5;
            int r100 = this.f401575a.f();
        L6:
            this.f401577c = r100;
            return;
        L5:
            r100 = this.f401575a.j();
            goto L6
        }

        public final String toString() {
            return "AnchorInfo{mPosition=" + this.f401576b + ", mCoordinate=" + this.f401577c + ", mLayoutFromEnd=" + this.f401578d + ", mValid=" + this.f401579e + '}';
        }

        public a() {
            d();
        }

        public final void b(View r100, int r101) {
            if (this.f401578d == false) goto L9;
            int r102 = this.f401575a.a(r100);
            c0 r103 = this.f401575a;
            if (Integer.MIN_VALUE != r103.f401789b) goto L7;
            int r104 = 0;
        L8:
            this.f401577c = r102 + r104;
        L10:
            this.f401576b = r101;
            return;
        L7:
            r104 = r103.k() - r103.f401789b;
            goto L8
        L9:
            this.f401577c = this.f401575a.d(r100);
            goto L10
        }

        public final void c(View r100, int r101) {
            c0 r102 = this.f401575a;
            if (Integer.MIN_VALUE != r102.f401789b) goto L5;
            int r103 = 0;
        L6:
            if (r103 < 0) goto L9;
            b(r100, r101);
            return;
        L9:
            this.f401576b = r101;
            if (this.f401578d == false) goto L16;
            int r104 = (this.f401575a.f() - r103) - this.f401575a.a(r100);
            this.f401577c = this.f401575a.f() - r104;
            if (r104 <= 0) goto L22;
            int r105 = this.f401577c - this.f401575a.b(r100);
            int r106 = this.f401575a.j();
            int r107 = r105 - (r106 + Math.min(this.f401575a.d(r100) - r106, 0));
            if (r107 >= 0) goto L23;
            this.f401577c += Math.min(r104, -r107);
            return;
        L23:
            return;
        L22:
            return;
        L16:
            int r108 = this.f401575a.d(r100);
            int r109 = r108 - this.f401575a.j();
            this.f401577c = r108;
            if (r109 <= 0) goto L25;
            int r110 = (this.f401575a.f() - Math.min(0, (this.f401575a.f() - r103) - this.f401575a.a(r100))) - (r108 + this.f401575a.b(r100));
            if (r110 >= 0) goto L26;
            this.f401577c -= Math.min(r109, -r110);
            return;
        L26:
            return;
        L25:
            return;
        L5:
            r103 = r102.k() - r102.f401789b;
            goto L6
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f401580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f401581b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f401582c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f401583d;

        public b() {
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f401584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f401585b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f401586c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f401587d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f401588e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f401589f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f401590g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f401591h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f401592i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f401593j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public List<RecyclerView.y> f401594k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f401595l;

        public c() {
            this.f401584a = true;
            this.f401591h = 0;
            this.f401592i = 0;
            this.f401594k = null;
        }

        public final void a(View r100) {
            int r101 = this.f401594k.size();
            View r102 = null;
            int r103 = Integer.MAX_VALUE;
            int r104 = 0;
        L3:
            if (r104 >= r101) goto L18;
            View r105 = ((RecyclerView.y) ListProtector.get(this.f401594k, r104)).f401728a;
            RecyclerView.LayoutParams r106 = (RecyclerView.LayoutParams) r105.getLayoutParams();
            if (r105 == r100) goto L17;
            if (r106.b() == true) goto L17;
            int r107 = (r106.a() - this.f401587d) * this.f401588e;
            if (r107 < 0) goto L17;
            if (r107 >= r103) goto L17;
            r102 = r105;
            if (r107 == 0) goto L18;
            r103 = r107;
        L17:
            r104 = r104 + 1;
        L18:
            if (r102 != null) goto L20;
            this.f401587d = -1;
            return;
        L20:
            this.f401587d = ((RecyclerView.LayoutParams) r102.getLayoutParams()).a();
        }

        public final View b(RecyclerView.q r100) {
            List<RecyclerView.y> r101 = this.f401594k;
            if (r101 == null) goto L15;
            int r102 = r101.size();
            int r103 = 0;
        L5:
            if (r103 >= r102) goto L13;
            View r104 = ((RecyclerView.y) ListProtector.get(this.f401594k, r103)).f401728a;
            RecyclerView.LayoutParams r105 = (RecyclerView.LayoutParams) r104.getLayoutParams();
            if (r105.b() == true) goto L12;
            if (this.f401587d != r105.a()) goto L12;
            a(r104);
            return r104;
        L12:
            r103 = r103 + 1;
            goto L5
        L13:
            return null;
        L15:
            View r106 = r100.k(this.f401587d, Long.MAX_VALUE).f401728a;
            this.f401587d += this.f401588e;
            return r106;
        }
    }

    public LinearLayoutManager() {
        this(1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final boolean I() {
        return true;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final void M() {
    }

    public void N0(RecyclerView.q r100, RecyclerView.v r101, a r102, int r103) {
    }

    public final void A0() {
        if (this.f401560o != null) goto L6;
        this.f401560o = new c();
        return;
    }

    public final View J0() {
        if (this.f401564s == false) goto L5;
        int r100 = 0;
    L7:
        return t(r100);
    L5:
        r100 = u() - 1;
        goto L7
    }

    public final View K0() {
        if (this.f401564s == false) goto L5;
        int r100 = u() - 1;
    L7:
        return t(r100);
    L5:
        r100 = 0;
        goto L7
    }

    public final boolean L0() {
        if (ViewCompat.getLayoutDirection(this.f401662b) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void Q0() {
        if (this.f401559n != 1) goto L5;
    L8:
        this.f401564s = this.f401563r;
        return;
    L5:
        if (L0() == false) goto L8;
        this.f401564s = !this.f401563r;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final Parcelable a0() {
        if (this.f401569x != null) goto L5;
        SavedState r100 = new SavedState();
        if (u() <= 0) goto L12;
        A0();
        boolean r101 = this.f401562q ^ this.f401564s;
        r100.f401574c = r101;
        if (r101 == false) goto L11;
        View r102 = J0();
        r100.f401573b = this.f401561p.f() - this.f401561p.a(r102);
        r100.f401572a = RecyclerView.k.F(r102);
    L13:
        return r100;
    L11:
        View r103 = K0();
        r100.f401572a = RecyclerView.k.F(r103);
        r100.f401573b = this.f401561p.d(r103) - this.f401561p.j();
        goto L13
    L12:
        r100.f401572a = -1;
        goto L13
    L5:
        return new SavedState(this.f401569x);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final boolean c() {
        if (this.f401559n != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final boolean d() {
        if (this.f401559n == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public RecyclerView.LayoutParams q() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final boolean q0() {
        if (this.f401671k != 1073741824) goto L5;
        return false;
    L5:
        if (this.f401670j == 1073741824) goto L24;
        int r100 = u();
        int r101 = 0;
    L8:
        if (r101 >= r100) goto L15;
        ViewGroup.LayoutParams r102 = t(r101).getLayoutParams();
        if (r102.width >= 0) goto L14;
        if (r102.height >= 0) goto L14;
        boolean r103 = true;
    L16:
        if (r103 == false) goto L25;
        return true;
    L25:
        return false;
    L14:
        r101 = r101 + 1;
        goto L8
    L15:
        r103 = false;
        goto L16
    L24:
        return false;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public boolean t0() {
        if (this.f401569x == null) goto L5;
    L7:
        return false;
    L5:
        if (this.f401562q != this.f401565t) goto L7;
        return true;
    }

    public LinearLayoutManager(int r100) {
        this.f401559n = 1;
        this.f401563r = false;
        this.f401564s = false;
        this.f401565t = false;
        this.f401566u = true;
        this.f401567v = -1;
        this.f401568w = Integer.MIN_VALUE;
        this.f401569x = null;
        a r101 = new a();
        this.f401570y = r101;
        this.f401571z = new b();
        this.A = 2;
        this.B = new int[2];
        if (r100 == 0) goto L8;
        if (r100 == 1) goto L8;
        throw new IllegalArgumentException("invalid orientation:" + r100);
    L8:
        b(null);
        if (r100 == this.f401559n) goto L11;
    L12:
        if (r100 == 0) goto L17;
        if (r100 != 1) goto L16;
        c0 r102 = new b0(this);
    L18:
        this.f401561p = r102;
        r101.f401575a = r102;
        this.f401559n = r100;
        f0();
    L19:
        b(null);
        if (this.f401563r == false) goto L24;
        this.f401563r = false;
        f0();
        return;
    L24:
        return;
    L16:
        throw new IllegalArgumentException("invalid orientation");
    L17:
        r102 = new a0(this);
        goto L18
    L11:
        if (this.f401561p != null) goto L19;
        goto L12
    }

    public final View C0(boolean r100) {
        if (this.f401564s == false) goto L7;
        return F0(0, u(), r100);
    L7:
        return F0(u() - 1, -1, r100);
    }

    public final View D0(boolean r100) {
        if (this.f401564s == false) goto L7;
        return F0(u() - 1, -1, r100);
    L7:
        return F0(0, u(), r100);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final void O(AccessibilityEvent r100) {
        super.O(r100);
        if (u() <= 0) goto L14;
        View r101 = F0(0, u(), false);
        int r102 = -1;
        if (r101 != null) goto L7;
        int r103 = -1;
    L8:
        r100.setFromIndex(r103);
        View r104 = F0(u() - 1, -1, false);
        if (r104 == null) goto L12;
        r102 = RecyclerView.k.F(r104);
    L12:
        r100.setToIndex(r102);
        return;
    L7:
        r103 = RecyclerView.k.F(r101);
        goto L8
    }

    public void S0(boolean r100) {
        b(null);
        if (this.f401565t != r100) goto L5;
        return;
    L5:
        this.f401565t = r100;
        f0();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public void Y(RecyclerView.v r100) {
        this.f401569x = null;
        this.f401567v = -1;
        this.f401568w = Integer.MIN_VALUE;
        this.f401570y.d();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final void Z(Parcelable r100) {
        if ((r100 instanceof SavedState) == false) goto L9;
        SavedState r101 = (SavedState) r100;
        this.f401569x = r101;
        if (this.f401567v == (-1)) goto L7;
        r101.f401572a = -1;
    L7:
        f0();
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final void b(String r100) {
        if (this.f401569x != null) goto L6;
        super.b(r100);
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.u.b
    public final PointF computeScrollVectorForPosition(int r100) {
        if (u() != 0) goto L6;
        return null;
    L6:
        boolean r101 = false;
        int r102 = 1;
        if (r100 >= RecyclerView.k.F(t(0))) goto L10;
        r101 = true;
    L10:
        if (r101 == this.f401564s) goto L13;
        r102 = -1;
    L13:
        if (this.f401559n != 0) goto L17;
        return new PointF(r102, 0.0f);
    L17:
        return new PointF(0.0f, r102);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final int i(RecyclerView.v r100) {
        return w0(r100);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final void i0(int r100) {
        this.f401567v = r100;
        this.f401568w = Integer.MIN_VALUE;
        SavedState r101 = this.f401569x;
        if (r101 == null) goto L5;
        r101.f401572a = -1;
    L5:
        f0();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public int j(RecyclerView.v r100) {
        return x0(r100);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public int k(RecyclerView.v r100) {
        return y0(r100);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final int l(RecyclerView.v r100) {
        return w0(r100);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public int m(RecyclerView.v r100) {
        return x0(r100);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public int n(RecyclerView.v r100) {
        return y0(r100);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final View p(int r100) {
        int r101 = u();
        if (r101 != 0) goto L6;
        return null;
    L6:
        int r102 = r100 - RecyclerView.k.F(t(0));
        if (r102 < 0) goto L13;
        if (r102 >= r101) goto L13;
        View r103 = t(r102);
        if (RecyclerView.k.F(r103) != r100) goto L13;
        return r103;
    L13:
        return super.p(r100);
    }

    public final int w0(RecyclerView.v r100) {
        if (u() != 0) goto L5;
        return 0;
    L5:
        A0();
        c0 r101 = this.f401561p;
        View r102 = D0(!this.f401566u);
        View r103 = C0(!this.f401566u);
        boolean r104 = this.f401566u;
        if (u() != 0) goto L8;
        return 0;
    L8:
        if (r100.b() == 0) goto L17;
        if (r102 == null) goto L18;
        if (r103 == null) goto L20;
        if (r104 == true) goto L15;
        return Math.abs(RecyclerView.k.F(r102) - RecyclerView.k.F(r103)) + 1;
    L15:
        return Math.min(r101.k(), r101.a(r103) - r101.d(r102));
    L20:
        return 0;
    L18:
        return 0;
    L17:
        return 0;
    }

    public final int x0(RecyclerView.v r110) {
        if (u() != 0) goto L5;
        return 0;
    L5:
        A0();
        c0 r100 = this.f401561p;
        View r101 = D0(!this.f401566u);
        View r102 = C0(!this.f401566u);
        boolean r103 = this.f401566u;
        boolean r104 = this.f401564s;
        if (u() != 0) goto L8;
        return 0;
    L8:
        if (r110.b() == 0) goto L22;
        if (r101 == null) goto L23;
        if (r102 == null) goto L24;
        int r105 = Math.min(RecyclerView.k.F(r101), RecyclerView.k.F(r102));
        int r106 = Math.max(RecyclerView.k.F(r101), RecyclerView.k.F(r102));
        if (r104 == false) goto L15;
        int r111 = Math.max(0, (r110.b() - r106) - 1);
    L16:
        int r107 = r111;
        if (r103 == true) goto L20;
        return r107;
    L20:
        return Math.round((r107 * (Math.abs(r100.a(r102) - r100.d(r101)) / (Math.abs(RecyclerView.k.F(r101) - RecyclerView.k.F(r102)) + 1))) + (r100.j() - r100.d(r101)));
    L15:
        r111 = Math.max(0, r105);
        goto L16
    L24:
        return 0;
    L23:
        return 0;
    L22:
        return 0;
    }

    public final int y0(RecyclerView.v r100) {
        if (u() != 0) goto L5;
        return 0;
    L5:
        A0();
        c0 r101 = this.f401561p;
        View r102 = D0(!this.f401566u);
        View r103 = C0(!this.f401566u);
        boolean r104 = this.f401566u;
        if (u() != 0) goto L8;
        return 0;
    L8:
        if (r100.b() == 0) goto L17;
        if (r102 == null) goto L18;
        if (r103 == null) goto L20;
        if (r104 == true) goto L15;
        return r100.b();
    L15:
        return (int) (((r101.a(r103) - r101.d(r102)) / (Math.abs(RecyclerView.k.F(r102) - RecyclerView.k.F(r103)) + 1)) * r100.b());
    L20:
        return 0;
    L18:
        return 0;
    L17:
        return 0;
    }

    public final int z0(int r100) {
        if (r100 == 1) goto L43;
        if (r100 == 2) goto L36;
        if (r100 == 17) goto L31;
        if (r100 == 33) goto L26;
        if (r100 == 66) goto L21;
        if (r100 == 130) goto L16;
        return Integer.MIN_VALUE;
    L16:
        if (this.f401559n == 1) goto L49;
        return Integer.MIN_VALUE;
    L49:
        return 1;
    L21:
        if (this.f401559n == 0) goto L50;
        return Integer.MIN_VALUE;
    L50:
        return 1;
    L26:
        if (this.f401559n == 1) goto L51;
        return Integer.MIN_VALUE;
    L51:
        return -1;
    L31:
        if (this.f401559n == 0) goto L52;
        return Integer.MIN_VALUE;
    L52:
        return -1;
    L36:
        if (this.f401559n != 1) goto L39;
        return 1;
    L39:
        if (L0() == false) goto L41;
        return -1;
    L41:
        return 1;
    L43:
        if (this.f401559n != 1) goto L46;
        return -1;
    L46:
        if (L0() == false) goto L48;
        return 1;
    L48:
        return -1;
    }

    public final View E0(int r100, int r101) {
        A0();
        if (r101 <= r100) goto L5;
        byte r102 = 1;
    L8:
        if (r102 != 0) goto L12;
        return t(r100);
    L12:
        if (this.f401561p.d(t(r100)) >= this.f401561p.j()) goto L14;
        int r103 = 16644;
        int r104 = 16388;
    L16:
        if (this.f401559n != 0) goto L19;
        return this.f401663c.a(r100, r101, r103, r104);
    L19:
        return this.f401664d.a(r100, r101, r103, r104);
    L14:
        r103 = 4161;
        r104 = 4097;
        goto L16
    L5:
        if (r101 >= r100) goto L7;
        r102 = -1;
        goto L8
    L7:
        r102 = 0;
        goto L8
    }

    public final void O0(RecyclerView.q r100, c r101) {
        if (r101.f401584a == true) goto L5;
        return;
    L5:
        if (r101.f401595l == true) goto L71;
        int r102 = r101.f401590g;
        int r103 = r101.f401592i;
        if (r101.f401589f != (-1)) goto L32;
        int r104 = u();
        if (r102 < 0) goto L72;
        int r105 = (this.f401561p.e() - r102) + r103;
        if (this.f401564s == false) goto L23;
        int r106 = 0;
    L15:
        if (r106 >= r104) goto L74;
        View r107 = t(r106);
        if (this.f401561p.d(r107) < r105) goto L22;
        if (this.f401561p.m(r107) < r105) goto L22;
        r106 = r106 + 1;
    L22:
        P0(r100, 0, r106);
        return;
    L74:
        return;
    L23:
        int r108 = r104 - 1;
        int r109 = r108;
    L24:
        if (r109 < 0) goto L75;
        View r110 = t(r109);
        if (this.f401561p.d(r110) < r105) goto L31;
        if (this.f401561p.m(r110) < r105) goto L31;
        r109 = r109 - 1;
    L31:
        P0(r100, r108, r109);
        return;
    L75:
        return;
    L72:
        return;
    L32:
        if (r102 < 0) goto L73;
        int r111 = r102 - r103;
        int r112 = u();
        if (this.f401564s == false) goto L45;
        int r113 = r112 - 1;
        int r114 = r113;
    L37:
        if (r114 < 0) goto L76;
        View r115 = t(r114);
        if (this.f401561p.a(r115) > r111) goto L44;
        if (this.f401561p.l(r115) > r111) goto L44;
        r114 = r114 - 1;
    L44:
        P0(r100, r113, r114);
        return;
    L76:
        return;
    L45:
        int r116 = 0;
    L46:
        if (r116 >= r112) goto L77;
        View r117 = t(r116);
        if (this.f401561p.a(r117) > r111) goto L53;
        if (this.f401561p.l(r117) > r111) goto L53;
        r116 = r116 + 1;
    L53:
        P0(r100, 0, r116);
        return;
    L77:
        return;
    L73:
        return;
    }

    public final void U0(int r100, int r101) {
        c r102 = this.f401560o;
        r102.f401586c = this.f401561p.f() - r101;
        c r103 = this.f401560o;
        if (this.f401564s == false) goto L5;
        int r104 = -1;
    L6:
        r103.f401588e = r104;
        r103.f401587d = r100;
        r103.f401589f = 1;
        r103.f401585b = r101;
        r103.f401590g = Integer.MIN_VALUE;
        return;
    L5:
        r104 = 1;
        goto L6
    }

    public final void V0(int r100, int r101) {
        c r102 = this.f401560o;
        r102.f401586c = r101 - this.f401561p.j();
        c r103 = this.f401560o;
        r103.f401587d = r100;
        if (this.f401564s == false) goto L5;
        int r104 = 1;
    L6:
        r103.f401588e = r104;
        r103.f401589f = -1;
        r103.f401585b = r101;
        r103.f401590g = Integer.MIN_VALUE;
        return;
    L5:
        r104 = -1;
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public void X(RecyclerView.q r110, RecyclerView.v r210) {
        if (this.f401569x != null) goto L7;
        if (this.f401567v != (-1)) goto L7;
    L10:
        SavedState r100 = this.f401569x;
        if (r100 == null) goto L18;
        int r101 = r100.f401572a;
        if (r101 < 0) goto L15;
        boolean r102 = true;
    L16:
        if (r102 == false) goto L18;
        this.f401567v = r101;
        goto L18
    L15:
        r102 = false;
    L18:
        A0();
        this.f401560o.f401584a = false;
        Q0();
        RecyclerView r103 = this.f401662b;
        if (r103 != null) goto L21;
    L20:
        View r104 = null;
    L26:
        a r105 = this.f401570y;
        if (r105.f401579e == true) goto L29;
    L39:
        r105.d();
        a r106 = this.f401570y;
        r106.f401578d = this.f401564s ^ this.f401565t;
        if (r210.f401712g == true) goto L99;
        int r107 = this.f401567v;
        if (r107 == (-1)) goto L99;
        if (r107 >= 0) goto L46;
    L98:
        this.f401567v = -1;
        this.f401568w = Integer.MIN_VALUE;
        goto L99
    L46:
        if (r107 >= r210.b()) goto L98;
        int r108 = this.f401567v;
        r106.f401576b = r108;
        SavedState r109 = this.f401569x;
        if (r109 == null) goto L60;
        if (r109.f401572a < 0) goto L53;
        boolean r111 = true;
    L54:
        if (r111 == false) goto L60;
        boolean r112 = r109.f401574c;
        r106.f401578d = r112;
        if (r112 == false) goto L58;
        r106.f401577c = this.f401561p.f() - this.f401569x.f401573b;
    L97:
        boolean r113 = true;
    L100:
        if (r113 == false) goto L103;
    L157:
        this.f401570y.f401579e = true;
    L158:
        c r114 = this.f401560o;
        if (r114.f401593j < 0) goto L161;
        int r115 = 1;
    L162:
        r114.f401589f = r115;
        int[] r116 = this.B;
        r116[0] = 0;
        r116[1] = 0;
        u0(r210, r116);
        int r117 = Math.max(0, this.B[0]) + this.f401561p.j();
        int r118 = Math.max(0, this.B[1]) + this.f401561p.g();
        if (r210.f401712g == false) goto L178;
        int r119 = this.f401567v;
        if (r119 == (-1)) goto L178;
        if (this.f401568w == Integer.MIN_VALUE) goto L178;
        View r120 = p(r119);
        if (r120 == null) goto L178;
        if (this.f401564s == false) goto L173;
        int r121 = this.f401561p.f() - this.f401561p.a(r120);
        int r122 = this.f401568w;
    L174:
        int r123 = r121 - r122;
        if (r123 <= 0) goto L177;
        r117 = r117 + r123;
        goto L178
    L177:
        r118 = r118 - r123;
        goto L178
    L173:
        r122 = this.f401561p.d(r120) - this.f401561p.j();
        r121 = this.f401568w;
    L178:
        a r124 = this.f401570y;
        if (r124.f401578d == false) goto L184;
        if (this.f401564s == true) goto L186;
    L185:
        int r125 = -1;
    L187:
        N0(r110, r210, r124, r125);
        o(r110);
        c r126 = this.f401560o;
        if (this.f401561p.h() == 0) goto L190;
    L192:
        boolean r127 = false;
    L193:
        r126.f401595l = r127;
        this.f401560o.getClass();
        this.f401560o.f401592i = 0;
        a r128 = this.f401570y;
        if (r128.f401578d == false) goto L201;
        V0(r128.f401576b, r128.f401577c);
        c r129 = this.f401560o;
        r129.f401591h = r117;
        B0(r110, r129, r210, false);
        c r130 = this.f401560o;
        int r131 = r130.f401585b;
        int r132 = r130.f401587d;
        int r133 = r130.f401586c;
        if (r133 <= 0) goto L198;
        r118 = r118 + r133;
    L198:
        a r134 = this.f401570y;
        U0(r134.f401576b, r134.f401577c);
        c r135 = this.f401560o;
        r135.f401591h = r118;
        r135.f401587d += r135.f401588e;
        B0(r110, r135, r210, false);
        c r136 = this.f401560o;
        int r137 = r136.f401585b;
        int r138 = r136.f401586c;
        if (r138 <= 0) goto L209;
        V0(r132, r131);
        c r139 = this.f401560o;
        r139.f401591h = r138;
        B0(r110, r139, r210, false);
        r131 = this.f401560o.f401585b;
    L209:
        if (u() <= 0) goto L216;
        if ((this.f401564s ^ this.f401565t) == false) goto L213;
        int r140 = H0(r137, r110, r210, true);
        int r141 = r131 + r140;
        int r142 = r137 + r140;
        int r143 = I0(r141, r110, r210, false);
    L214:
        r131 = r141 + r143;
        r137 = r142 + r143;
        goto L216
    L213:
        int r144 = I0(r131, r110, r210, true);
        r141 = r131 + r144;
        r142 = r137 + r144;
        r143 = H0(r142, r110, r210, false);
    L216:
        if (r210.f401716k == false) goto L249;
        if (u() == 0) goto L249;
        if (r210.f401712g == true) goto L249;
        if (t0() == false) goto L249;
        List<RecyclerView.y> r145 = r110.f401686d;
        int r146 = r145.size();
        int r147 = RecyclerView.k.F(t(0));
        int r148 = 0;
        int r149 = 0;
        int r150 = 0;
    L225:
        if (r148 >= r146) goto L241;
        RecyclerView.y r151 = (RecyclerView.y) ListProtector.get(r145, r148);
        if (r151.i() == true) goto L240;
        if (r151.d() >= r147) goto L232;
        boolean r152 = true;
    L234:
        if (r152 == this.f401564s) goto L236;
        byte r153 = -1;
    L237:
        if (r153 != (-1)) goto L239;
        r149 = r149 + this.f401561p.b(r151.f401728a);
        goto L240
    L239:
        r150 = r150 + this.f401561p.b(r151.f401728a);
        goto L240
    L236:
        r153 = 1;
        goto L237
    L232:
        r152 = false;
    L240:
        r148 = r148 + 1;
        goto L225
    L241:
        this.f401560o.f401594k = r145;
        if (r149 <= 0) goto L244;
        V0(RecyclerView.k.F(K0()), r131);
        c r154 = this.f401560o;
        r154.f401591h = r149;
        r154.f401586c = 0;
        r154.a(null);
        B0(r110, this.f401560o, r210, false);
    L244:
        if (r150 <= 0) goto L246;
        U0(RecyclerView.k.F(J0()), r137);
        c r155 = this.f401560o;
        r155.f401591h = r150;
        r155.f401586c = 0;
        List<RecyclerView.y> r156 = null;
        r155.a(null);
        B0(r110, this.f401560o, r210, false);
    L247:
        this.f401560o.f401594k = r156;
        goto L249
    L246:
        r156 = null;
    L249:
        if (r210.f401712g == true) goto L251;
        c0 r157 = this.f401561p;
        r157.f401789b = r157.k();
    L252:
        this.f401562q = this.f401565t;
        return;
    L251:
        this.f401570y.d();
        goto L252
    L201:
        U0(r128.f401576b, r128.f401577c);
        c r158 = this.f401560o;
        r158.f401591h = r118;
        B0(r110, r158, r210, false);
        c r159 = this.f401560o;
        int r160 = r159.f401585b;
        int r161 = r159.f401587d;
        int r162 = r159.f401586c;
        if (r162 <= 0) goto L204;
        r117 = r117 + r162;
    L204:
        a r163 = this.f401570y;
        V0(r163.f401576b, r163.f401577c);
        c r164 = this.f401560o;
        r164.f401591h = r117;
        r164.f401587d += r164.f401588e;
        B0(r110, r164, r210, false);
        c r165 = this.f401560o;
        int r166 = r165.f401585b;
        int r167 = r165.f401586c;
        if (r167 <= 0) goto L207;
        U0(r161, r160);
        c r168 = this.f401560o;
        r168.f401591h = r167;
        B0(r110, r168, r210, false);
        r131 = r166;
        r137 = this.f401560o.f401585b;
        goto L209
    L207:
        r131 = r166;
        r137 = r160;
        goto L209
    L190:
        if (this.f401561p.e() != 0) goto L192;
        r127 = true;
    L186:
        r125 = 1;
        goto L187
    L184:
        if (this.f401564s == false) goto L186;
    L161:
        r115 = -1;
        goto L162
    L103:
        if (u() == 0) goto L149;
        RecyclerView r169 = this.f401662b;
        if (r169 != null) goto L108;
    L107:
        View r170 = null;
    L113:
        if (r170 == null) goto L124;
        RecyclerView.LayoutParams r171 = (RecyclerView.LayoutParams) r170.getLayoutParams();
        if (r171.b() == false) goto L117;
    L121:
        boolean r172 = false;
    L122:
        if (r172 == false) goto L124;
        r106.c(r170, RecyclerView.k.F(r170));
    L148:
        boolean r173 = true;
    L150:
        if (r173 == true) goto L157;
        r106.a();
        if (this.f401565t == false) goto L155;
        int r174 = r210.b() - 1;
    L156:
        r106.f401576b = r174;
        goto L157
    L155:
        r174 = 0;
        goto L156
    L117:
        if (r171.a() < 0) goto L121;
        if (r171.a() >= r210.b()) goto L121;
        r172 = true;
    L124:
        boolean r175 = this.f401562q;
        boolean r176 = this.f401565t;
        if (r175 != r176) goto L149;
        View r177 = G0(r110, r210, r106.f401578d, r176);
        if (r177 == null) goto L149;
        r106.b(r177, RecyclerView.k.F(r177));
        if (r210.f401712g == true) goto L148;
        if (t0() == false) goto L148;
        int r178 = this.f401561p.d(r177);
        int r179 = this.f401561p.a(r177);
        int r180 = this.f401561p.j();
        int r181 = this.f401561p.f();
        if (r179 > r180) goto L137;
        if (r178 >= r180) goto L137;
        boolean r182 = true;
    L138:
        if (r178 < r181) goto L141;
        if (r179 <= r181) goto L141;
        boolean r183 = true;
    L142:
        if (r182 == true) goto L145;
        if (r183 == false) goto L148;
    L145:
        if (r106.f401578d == false) goto L147;
        r180 = r181;
    L147:
        r106.f401577c = r180;
    L141:
        r183 = false;
    L137:
        r182 = false;
        goto L138
    L108:
        r170 = r169.getFocusedChild();
        if (r170 == null) goto L107;
        if (this.f401661a.k(r170) == false) goto L113;
    L149:
        r173 = false;
        goto L150
    L58:
        r106.f401577c = this.f401561p.j() + this.f401569x.f401573b;
        goto L97
    L53:
        r111 = false;
    L60:
        if (this.f401568w != Integer.MIN_VALUE) goto L93;
        View r184 = p(r108);
        if (r184 == null) goto L82;
        if (this.f401561p.b(r184) <= this.f401561p.k()) goto L67;
        r106.a();
        goto L97
    L67:
        if ((this.f401561p.d(r184) - this.f401561p.j()) >= 0) goto L70;
        r106.f401577c = this.f401561p.j();
        r106.f401578d = false;
        goto L97
    L70:
        if ((this.f401561p.f() - this.f401561p.a(r184)) >= 0) goto L73;
        r106.f401577c = this.f401561p.f();
        r106.f401578d = true;
        goto L97
    L73:
        if (r106.f401578d == false) goto L79;
        int r185 = this.f401561p.a(r184);
        c0 r186 = this.f401561p;
        if (Integer.MIN_VALUE != r186.f401789b) goto L77;
        int r187 = 0;
    L78:
        int r188 = r185 + r187;
    L80:
        r106.f401577c = r188;
        goto L97
    L77:
        r187 = r186.k() - r186.f401789b;
        goto L78
    L79:
        r188 = this.f401561p.d(r184);
        goto L80
    L82:
        if (u() > 0) goto L84;
    L92:
        r106.a();
        goto L97
    L84:
        if (this.f401567v >= RecyclerView.k.F(t(0))) goto L86;
        boolean r189 = true;
    L88:
        if (r189 != this.f401564s) goto L90;
        boolean r190 = true;
    L91:
        r106.f401578d = r190;
        goto L92
    L90:
        r190 = false;
        goto L91
    L86:
        r189 = false;
        goto L88
    L93:
        boolean r191 = this.f401564s;
        r106.f401578d = r191;
        if (r191 == false) goto L96;
        r106.f401577c = this.f401561p.f() - this.f401568w;
        goto L97
    L96:
        r106.f401577c = this.f401561p.j() + this.f401568w;
    L99:
        r113 = false;
        goto L100
    L29:
        if (this.f401567v != (-1)) goto L39;
        if (this.f401569x != null) goto L39;
        if (r104 == null) goto L158;
        if (this.f401561p.d(r104) < this.f401561p.f()) goto L37;
    L38:
        this.f401570y.c(r104, RecyclerView.k.F(r104));
        goto L158
    L37:
        if (this.f401561p.a(r104) > this.f401561p.j()) goto L158;
    L21:
        r104 = r103.getFocusedChild();
        if (r104 == null) goto L20;
        if (this.f401661a.k(r104) == false) goto L26;
    L7:
        if (r210.b() != 0) goto L10;
        b0(r110);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final void h(int r100, RecyclerView.k.c r101) {
        SavedState r102 = this.f401569x;
        int r103 = 1;
        if (r102 == null) goto L10;
        int r104 = r102.f401572a;
        if (r104 < 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L10;
        boolean r106 = r102.f401574c;
    L15:
        if (r106 == false) goto L17;
        r103 = -1;
    L17:
        int r107 = 0;
    L19:
        if (r107 >= this.A) goto L23;
        if (r104 < 0) goto L27;
        if (r104 >= r100) goto L28;
        ((s.b) r101).a(r104, 0);
        r104 = r104 + r103;
        r107 = r107 + 1;
        goto L19
    L28:
        return;
    L27:
        return;
    L23:
        return;
    L7:
        r105 = false;
    L10:
        Q0();
        r106 = this.f401564s;
        r104 = this.f401567v;
        if (r104 != (-1)) goto L15;
        if (r106 == false) goto L14;
        r104 = r100 - 1;
        goto L15
    L14:
        r104 = 0;
        goto L15
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final void r0(RecyclerView r100, int r101) {
        u r102 = new u(r100.getContext());
        r102.f401692a = r101;
        s0(r102);
    }

    public final void u0(RecyclerView.v r100, int[] r101) {
        if (r100.f401706a == (-1)) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        int r103 = this.f401561p.k();
    L10:
        if (this.f401560o.f401589f != (-1)) goto L12;
        int r104 = 0;
    L13:
        r101[0] = r103;
        r101[1] = r104;
        return;
    L12:
        r104 = r103;
        r103 = 0;
        goto L13
    L8:
        r103 = 0;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public final View F0(int r100, int r101, boolean r102) {
        A0();
        if (r102 == false) goto L5;
        int r103 = 24579;
    L7:
        if (this.f401559n != 0) goto L10;
        return this.f401663c.a(r100, r101, r103, 320);
    L10:
        return this.f401664d.a(r100, r101, r103, 320);
    L5:
        r103 = 320;
        goto L7
    }

    public final void P0(RecyclerView.q r100, int r101, int r102) {
        if (r101 != r102) goto L4;
        return;
    L4:
        if (r102 <= r101) goto L8;
    L5:
        r102 = r102 - 1;
        if (r102 < r101) goto L10;
        View r103 = t(r102);
        d0(r102);
        r100.h(r103);
        goto L5
    L10:
        return;
    L8:
        if (r101 <= r102) goto L13;
        View r104 = t(r101);
        d0(r101);
        r100.h(r104);
        r101 = r101 - 1;
        goto L8
    }

    public final int R0(int r100, RecyclerView.q r101, RecyclerView.v r102) {
        if (u() == 0) goto L17;
        if (r100 == 0) goto L17;
        A0();
        this.f401560o.f401584a = true;
        if (r100 <= 0) goto L9;
        int r103 = 1;
    L10:
        int r104 = Math.abs(r100);
        T0(r103, r104, true, r102);
        c r105 = this.f401560o;
        int r106 = r105.f401590g + B0(r101, r105, r102, false);
        if (r106 >= 0) goto L13;
        return 0;
    L13:
        if (r104 <= r106) goto L15;
        r100 = r103 * r106;
    L15:
        this.f401561p.n(-r100);
        this.f401560o.f401593j = r100;
        return r100;
    L9:
        r103 = -1;
    L17:
        return 0;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public int h0(int r100, RecyclerView.q r101, RecyclerView.v r102) {
        if (this.f401559n != 1) goto L7;
        return 0;
    L7:
        return R0(r100, r101, r102);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public int j0(int r100, RecyclerView.q r101, RecyclerView.v r102) {
        if (this.f401559n != 0) goto L7;
        return 0;
    L7:
        return R0(r100, r101, r102);
    }

    public void v0(RecyclerView.v r100, c r101, RecyclerView.k.c r102) {
        int r103 = r101.f401587d;
        if (r103 >= 0) goto L5;
        return;
    L5:
        if (r103 >= r100.b()) goto L9;
        s.b r104 = (s.b) r102;
        r104.a(r103, Math.max(0, r101.f401590g));
        return;
    }

    public final int B0(RecyclerView.q r100, c r101, RecyclerView.v r110, boolean r111) {
        int r102 = r101.f401586c;
        int r103 = r101.f401590g;
        if (r103 == Integer.MIN_VALUE) goto L7;
        if (r102 >= 0) goto L6;
        r101.f401590g = r103 + r102;
    L6:
        O0(r100, r101);
    L7:
        int r104 = r101.f401586c + r101.f401591h;
        b r105 = this.f401571z;
    L9:
        if (r101.f401595l == true) goto L11;
        if (r104 > 0) goto L11;
    L38:
        return r102 - r101.f401586c;
    L11:
        int r106 = r101.f401587d;
        if (r106 >= 0) goto L14;
    L16:
        boolean r107 = false;
    L17:
        if (r107 == false) goto L38;
        r105.f401580a = 0;
        r105.f401581b = false;
        r105.f401582c = false;
        r105.f401583d = false;
        M0(r100, r110, r101, r105);
        if (r105.f401581b == true) goto L38;
        int r108 = r101.f401585b;
        int r109 = r105.f401580a;
        r101.f401585b = r108 + (r101.f401589f * r109);
        if (r105.f401582c == true) goto L24;
    L27:
        r101.f401586c -= r109;
        r104 = r104 - r109;
    L28:
        int r112 = r101.f401590g;
        if (r112 == Integer.MIN_VALUE) goto L34;
        int r113 = r112 + r109;
        r101.f401590g = r113;
        int r114 = r101.f401586c;
        if (r114 >= 0) goto L33;
        r101.f401590g = r113 + r114;
    L33:
        O0(r100, r101);
    L34:
        if (r111 == false) goto L9;
        if (r105.f401583d == false) goto L9;
    L24:
        if (r101.f401594k != null) goto L27;
        if (r110.f401712g == true) goto L28;
    L14:
        if (r106 >= r110.b()) goto L16;
        r107 = true;
        goto L17
    }

    public View G0(RecyclerView.q r110, RecyclerView.v r111, boolean r112, boolean r210) {
        A0();
        int r100 = u();
        if (r210 == false) goto L5;
        int r101 = u() - 1;
        int r102 = -1;
        int r103 = -1;
    L6:
        int r104 = r111.b();
        int r105 = this.f401561p.j();
        int r106 = this.f401561p.f();
        View r107 = null;
        View r113 = null;
        View r114 = null;
    L7:
        if (r101 == r102) goto L37;
        View r115 = t(r101);
        int r116 = RecyclerView.k.F(r115);
        int r117 = this.f401561p.d(r115);
        int r118 = this.f401561p.a(r115);
        if (r116 < 0) goto L36;
        if (r116 >= r104) goto L36;
        if (((RecyclerView.LayoutParams) r115.getLayoutParams()).b() == false) goto L15;
        if (r114 != null) goto L36;
        r114 = r115;
        goto L36
    L15:
        if (r118 > r105) goto L18;
        if (r117 >= r105) goto L18;
        boolean r119 = true;
    L19:
        if (r117 < r106) goto L22;
        if (r118 <= r106) goto L22;
        boolean r120 = true;
    L23:
        if (r119 == true) goto L27;
        if (r120 == true) goto L27;
        return r115;
    L27:
        if (r112 == false) goto L32;
        if (r120 == true) goto L33;
        if (r107 != null) goto L36;
    L35:
        r107 = r115;
    L33:
        r113 = r115;
        goto L36
    L32:
        if (r119 == true) goto L33;
        if (r107 != null) goto L36;
    L22:
        r120 = false;
    L18:
        r119 = false;
    L36:
        r101 = r101 + r103;
        goto L7
    L37:
        if (r107 != null) goto L54;
        if (r113 == null) goto L42;
        return r113;
    L42:
        return r114;
    L54:
        return r107;
    L5:
        r102 = r100;
        r101 = 0;
        r103 = 1;
        goto L6
    }

    public final int H0(int r100, RecyclerView.q r101, RecyclerView.v r102, boolean r103) {
        int r104 = this.f401561p.f() - r100;
        if (r104 <= 0) goto L11;
        int r105 = -R0(-r104, r101, r102);
        int r106 = r100 + r105;
        if (r103 == false) goto L10;
        int r107 = this.f401561p.f() - r106;
        if (r107 <= 0) goto L10;
        this.f401561p.n(r107);
        return r107 + r105;
    L10:
        return r105;
    L11:
        return 0;
    }

    public final int I0(int r100, RecyclerView.q r101, RecyclerView.v r102, boolean r103) {
        int r104 = r100 - this.f401561p.j();
        if (r104 <= 0) goto L10;
        int r105 = -R0(r104, r101, r102);
        int r106 = r100 + r105;
        if (r103 == false) goto L12;
        int r107 = r106 - this.f401561p.j();
        if (r107 <= 0) goto L13;
        this.f401561p.n(-r107);
        return r105 - r107;
    L13:
        return r105;
    L12:
        return r105;
    L10:
        return 0;
    }

    public void M0(RecyclerView.q r100, RecyclerView.v r110, c r111, b r112) {
        View r101 = r111.b(r100);
        if (r101 != null) goto L6;
        r112.f401581b = true;
        return;
    L6:
        RecyclerView.LayoutParams r102 = (RecyclerView.LayoutParams) r101.getLayoutParams();
        boolean r103 = false;
        if (r111.f401594k != null) goto L15;
        boolean r104 = this.f401564s;
        if (r111.f401589f != (-1)) goto L11;
        boolean r105 = true;
    L12:
        if (r104 != r105) goto L14;
        a(r101, -1, false);
    L22:
        L(r101);
        r112.f401580a = this.f401561p.b(r101);
        if (this.f401559n == 1) goto L25;
        int r106 = E();
        int r107 = this.f401561p.c(r101) + r106;
        if (r111.f401589f != (-1)) goto L35;
        int r113 = r111.f401585b;
        int r108 = r113 - r112.f401580a;
        int r109 = r113;
        int r114 = r107;
        int r115 = r108;
        int r116 = r106;
    L36:
        RecyclerView.k.K(r101, r115, r116, r109, r114);
        if (r102.b() == false) goto L39;
    L42:
        r112.f401582c = true;
    L43:
        r112.f401583d = r101.hasFocusable();
        return;
    L39:
        if ((r102.f401651a.f401737j & 2) == 0) goto L41;
        r103 = true;
    L41:
        if (r103 == false) goto L43;
    L35:
        int r117 = r111.f401585b;
        int r118 = r112.f401580a + r117;
        r115 = r117;
        r114 = r107;
        r116 = r106;
        r109 = r118;
        goto L36
    L25:
        if (L0() == false) goto L27;
        r109 = this.f401672l - D();
        r115 = r109 - this.f401561p.c(r101);
    L29:
        if (r111.f401589f != (-1)) goto L31;
        r114 = r111.f401585b;
        r116 = r114 - r112.f401580a;
        goto L36
    L31:
        r116 = r111.f401585b;
        r114 = r112.f401580a + r116;
        goto L36
    L27:
        r115 = C();
        r109 = this.f401561p.c(r101) + r115;
        goto L29
    L14:
        a(r101, 0, false);
        goto L22
    L11:
        r105 = false;
        goto L12
    L15:
        boolean r119 = this.f401564s;
        if (r111.f401589f != (-1)) goto L18;
        boolean r120 = true;
    L19:
        if (r119 != r120) goto L21;
        a(r101, -1, true);
        goto L22
    L21:
        a(r101, 0, true);
        goto L22
    L18:
        r120 = false;
        goto L19
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public View N(View r100, int r101, RecyclerView.q r102, RecyclerView.v r103) {
        Q0();
        if (u() != 0) goto L5;
        return null;
    L5:
        int r104 = z0(r101);
        if (r104 != Integer.MIN_VALUE) goto L8;
        return null;
    L8:
        A0();
        T0(r104, (int) (this.f401561p.k() * 0.33333334f), false, r103);
        c r105 = this.f401560o;
        r105.f401590g = Integer.MIN_VALUE;
        r105.f401584a = false;
        B0(r102, r105, r103, true);
        if (r104 != (-1)) goto L15;
        if (this.f401564s == false) goto L13;
        View r106 = E0(u() - 1, -1);
    L18:
        if (r104 != (-1)) goto L20;
        View r107 = K0();
    L22:
        if (r107.hasFocusable() == false) goto L26;
        if (r106 != null) goto L25;
        return null;
    L25:
        return r107;
    L26:
        return r106;
    L20:
        r107 = J0();
        goto L22
    L13:
        r106 = E0(0, u());
        goto L18
    L15:
        if (this.f401564s == false) goto L17;
        r106 = E0(0, u());
        goto L18
    L17:
        r106 = E0(u() - 1, -1);
        goto L18
    }

    public final void T0(int r100, int r101, boolean r102, RecyclerView.v r103) {
        c r104 = this.f401560o;
        boolean r105 = false;
        int r106 = 1;
        if (this.f401561p.h() == 0) goto L5;
    L7:
        boolean r107 = false;
    L8:
        r104.f401595l = r107;
        this.f401560o.f401589f = r100;
        int[] r108 = this.B;
        r108[0] = 0;
        r108[1] = 0;
        u0(r103, r108);
        int r109 = Math.max(0, this.B[0]);
        int r110 = Math.max(0, this.B[1]);
        if (r100 != 1) goto L11;
        r105 = true;
    L11:
        c r111 = this.f401560o;
        if (r105 == false) goto L14;
        int r112 = r110;
    L15:
        r111.f401591h = r112;
        if (r105 == true) goto L19;
        r109 = r110;
    L19:
        r111.f401592i = r109;
        if (r105 == false) goto L25;
        r111.f401591h = r112 + this.f401561p.g();
        View r113 = J0();
        c r114 = this.f401560o;
        if (this.f401564s == false) goto L24;
        r106 = -1;
    L24:
        r114.f401588e = r106;
        int r115 = RecyclerView.k.F(r113);
        c r116 = this.f401560o;
        r114.f401587d = r115 + r116.f401588e;
        r116.f401585b = this.f401561p.a(r113);
        int r117 = this.f401561p.a(r113) - this.f401561p.f();
    L30:
        c r118 = this.f401560o;
        r118.f401586c = r101;
        if (r102 == false) goto L33;
        r118.f401586c = r101 - r117;
    L33:
        r118.f401590g = r117;
        return;
    L25:
        View r119 = K0();
        this.f401560o.f401591h += this.f401561p.j();
        c r120 = this.f401560o;
        if (this.f401564s == true) goto L29;
        r106 = -1;
    L29:
        r120.f401588e = r106;
        int r121 = RecyclerView.k.F(r119);
        c r122 = this.f401560o;
        r120.f401587d = r121 + r122.f401588e;
        r122.f401585b = this.f401561p.d(r119);
        r117 = (-this.f401561p.d(r119)) + this.f401561p.j();
        goto L30
    L14:
        r112 = r109;
        goto L15
    L5:
        if (this.f401561p.e() != 0) goto L7;
        r107 = true;
        goto L8
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public final void g(int r100, int r101, RecyclerView.v r102, RecyclerView.k.c r103) {
        if (this.f401559n == 0) goto L7;
        r100 = r101;
    L7:
        if (u() == 0) goto L16;
        if (r100 == 0) goto L17;
        A0();
        if (r100 <= 0) goto L13;
        int r104 = 1;
    L14:
        T0(r104, Math.abs(r100), true, r102);
        v0(r102, this.f401560o, r103);
        return;
    L13:
        r104 = -1;
        goto L14
    L17:
        return;
    }
}
