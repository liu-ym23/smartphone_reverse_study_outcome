package vn;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.vlayout.VirtualLayoutManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a extends i {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f556361h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f556362i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f556363j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f556364k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f556365l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public InterfaceC8022a f556366m;

    /* JADX INFO: renamed from: vn.a$a, reason: collision with other inner class name */
    public interface InterfaceC8022a {
        void a(View r100);
    }

    @Override // com.bytedance.android.ec.vlayout.a
    public boolean i() {
        return false;
    }

    public abstract void w(RecyclerView.Recycler r100, RecyclerView.State r101, VirtualLayoutManager.e r102, g r103, com.bytedance.android.ec.vlayout.b r104);

    public void x(com.bytedance.android.ec.vlayout.b r100) {
    }

    public boolean y() {
        if (this.f556363j == 0) goto L5;
    L8:
        return true;
    L5:
        if (this.f556366m != null) goto L8;
        return false;
    }

    public a() {
        this.f556361h = new Rect();
        this.f556364k = Float.NaN;
        this.f556365l = 0;
    }

    @Override // com.bytedance.android.ec.vlayout.a
    public final int h() {
        return this.f556365l;
    }

    public void A(com.bytedance.android.ec.hybrid.list.ability.l r100) {
        this.f556366m = r100;
    }

    @Override // com.bytedance.android.ec.vlayout.a
    public final void d(com.bytedance.android.ec.vlayout.b r100) {
        View r101 = this.f556362i;
        if (r101 == null) goto L5;
        ((VirtualLayoutManager) r100).removeView(r101);
        this.f556362i = null;
    L5:
        x(r100);
    }

    @Override // com.bytedance.android.ec.vlayout.a
    public void r(int r100) {
        this.f556365l = r100;
    }

    public void z(int r100) {
        this.f556363j = r100;
    }

    public static void u(g r100, View r101) {
        RecyclerView.LayoutParams r102 = (RecyclerView.LayoutParams) r101.getLayoutParams();
        boolean r103 = true;
        if (r102.isItemRemoved() == false) goto L5;
    L6:
        r100.f556371c = true;
    L8:
        if (r100.f556372d == false) goto L10;
    L13:
        r100.f556372d = r103;
        return;
    L10:
        if (r101.isFocusable() == true) goto L13;
        r103 = false;
        goto L13
    L5:
        if (r102.isItemChanged() == false) goto L8;
        goto L6
    }

    @Override // com.bytedance.android.ec.vlayout.a
    public void b(RecyclerView.Recycler r100, RecyclerView.State r101, com.bytedance.android.ec.vlayout.b r102) {
        if (y() == true) goto L10;
        View r103 = this.f556362i;
        if (r103 == null) goto L9;
        ((VirtualLayoutManager) r102).removeView(r103);
        this.f556362i = null;
        return;
    L9:
        return;
    }

    public final int t(com.bytedance.android.ec.vlayout.b r100, boolean r101, boolean r102) {
        if ((r100 instanceof VirtualLayoutManager) == false) goto L17;
        LinkedList r103 = (LinkedList) ((un.g) ((VirtualLayoutManager) r100).f49085w).f550760b;
        int r104 = r103.indexOf(this);
        if (r104 == (-1)) goto L17;
        if (r102 == false) goto L9;
        int r105 = r104 - 1;
    L10:
        if (r105 < 0) goto L17;
        if (r105 >= r103.size()) goto L17;
        com.bytedance.android.ec.vlayout.a r106 = (com.bytedance.android.ec.vlayout.a) ListProtector.get(r103, r105);
        if (r106 == null) goto L17;
        if (r106.i() == true) goto L17;
    L18:
        if (r106 == null) goto L23;
        if ((r106 instanceof i) == false) goto L23;
        i r107 = (i) r106;
    L23:
        if (r106 != this) goto L25;
        return 0;
    L25:
        if (r101 == false) goto L29;
        if (r102 == false) goto L28;
        int r108 = this.f556377f;
    L33:
        return r108 + 0;
    L28:
        r108 = this.f556378g;
        goto L33
    L29:
        if (r102 == false) goto L31;
        r108 = this.f556375d;
        goto L33
    L31:
        r108 = this.f556376e;
        goto L33
    L9:
        r105 = r104 + 1;
    L17:
        r106 = null;
        goto L18
    }

    @Override // com.bytedance.android.ec.vlayout.a
    public final void f(RecyclerView.Recycler r100, RecyclerView.State r101, VirtualLayoutManager.e r102, g r103, com.bytedance.android.ec.vlayout.b r104) {
        w(r100, r101, r102, r103, r104);
    }

    @Override // com.bytedance.android.ec.vlayout.a
    public void a(RecyclerView.Recycler r100, RecyclerView.State r101, int r102, int r103, int r110, com.bytedance.android.ec.vlayout.b r111) {
        if (y() == true) goto L5;
    L46:
        View r104 = this.f556362i;
        if (r104 == null) goto L50;
        ((VirtualLayoutManager) r111).removeView(r104);
        this.f556362i = null;
        return;
    L50:
        return;
    L5:
        if (r110 == Integer.MAX_VALUE) goto L8;
        if (r110 == Integer.MIN_VALUE) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L14;
        View r106 = this.f556362i;
        if (r106 == null) goto L14;
        this.f556361h.union(r106.getLeft(), this.f556362i.getTop(), this.f556362i.getRight(), this.f556362i.getBottom());
    L14:
        if (this.f556361h.isEmpty() == true) goto L46;
        if (r110 == Integer.MAX_VALUE) goto L18;
        if (r110 == Integer.MIN_VALUE) goto L18;
        boolean r107 = true;
    L19:
        if (r107 == true) goto L21;
    L24:
        VirtualLayoutManager r108 = (VirtualLayoutManager) r111;
        int r109 = r108.P();
        int r112 = r108.O();
        if (r108.getOrientation() != 1) goto L30;
        if (this.f556361h.intersects(0, (-r112) / 4, r109, r112 + (r112 / 4)) == true) goto L32;
    L43:
        this.f556361h.set(0, 0, 0, 0);
        View r113 = this.f556362i;
        if (r113 == null) goto L46;
        r113.layout(0, 0, 0, 0);
    L32:
        if (this.f556362i != null) goto L35;
        View r114 = r108.N();
        this.f556362i = r114;
        r108.L(r114, true);
    L35:
        if (r108.getOrientation() != 1) goto L37;
        Rect r115 = this.f556361h;
        r115.left = r108.getPaddingLeft() + 0;
        Rect r116 = this.f556361h;
        r116.right = (r108.P() - r108.getPaddingRight()) - 0;
    L38:
        View r117 = this.f556362i;
        r117.measure(View.MeasureSpec.makeMeasureSpec(this.f556361h.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f556361h.height(), 1073741824));
        Rect r118 = this.f556361h;
        r117.layout(r118.left, r118.top, r118.right, r118.bottom);
        r117.setBackgroundColor(this.f556363j);
        InterfaceC8022a r119 = this.f556366m;
        if (r119 == null) goto L41;
        r119.a(r117);
    L41:
        this.f556361h.set(0, 0, 0, 0);
        return;
    L37:
        Rect r120 = this.f556361h;
        r120.top = r108.getPaddingTop() + 0;
        Rect r121 = this.f556361h;
        r121.bottom = (r108.O() - r108.getPaddingBottom()) - 0;
        goto L38
    L30:
        if (this.f556361h.intersects((-r109) / 4, 0, r109 + (r109 / 4), r112) == false) goto L43;
    L21:
        if (r111.getOrientation() != 1) goto L23;
        this.f556361h.offset(0, -r110);
        goto L24
    L23:
        this.f556361h.offset(-r110, 0);
    L18:
        r107 = false;
    L8:
        r105 = false;
        goto L9
    }

    public final void v(View r100, int r101, int r102, int r110, int r111, com.bytedance.android.ec.vlayout.b r112) {
        VirtualLayoutManager r103 = (VirtualLayoutManager) r112;
        r103.getClass();
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r100.getLayoutParams();
        r103.layoutDecorated(r100, r101 + r113.leftMargin, r102 + r113.topMargin, r110 - r113.rightMargin, r111 - r113.bottomMargin);
        if (y() == false) goto L6;
        this.f556361h.union(r101 - this.f556375d, r102 - this.f556377f, r110 + this.f556376e, r111 + this.f556378g);
        return;
    }
}
