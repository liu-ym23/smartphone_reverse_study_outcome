package vn;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx;
import com.bytedance.android.ec.vlayout.VirtualLayoutManager;

/* JADX INFO: loaded from: classes44.dex */
public class h extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f556373n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f556374o;

    public h(int r100, int r101) {
        this.f556373n = 0;
        this.f556374o = false;
        this.f556365l = r101;
        if (r100 >= 0) goto L5;
        r100 = 0;
    L5:
        this.f556373n = r100;
    }

    @Override // com.bytedance.android.ec.vlayout.a
    public final void c(RecyclerView.State r100, VirtualLayoutManager.c r101, com.bytedance.android.ec.vlayout.b r102) {
        this.f556374o = true;
    }

    @Override // vn.i, com.bytedance.android.ec.vlayout.a
    public final int e(int r100, boolean r101, boolean r102, com.bytedance.android.ec.vlayout.b r103) {
        if (r103.getOrientation() != 1) goto L5;
        boolean r104 = true;
    L6:
        if (r101 == true) goto L8;
        if (r100 != 0) goto L21;
        if (r104 == false) goto L17;
        int r105 = this.f556377f;
    L19:
        return 0 - r105;
    L17:
        r105 = this.f556375d;
        goto L19
    L21:
        return 0;
    L8:
        if (r100 != (this.f556365l - 1)) goto L20;
        if (r104 == false) goto L11;
        int r106 = this.f556378g;
    L13:
        return 0 + r106;
    L11:
        r106 = this.f556376e;
        goto L13
    L20:
        return 0;
    L5:
        r104 = false;
        goto L6
    }

    @Override // vn.a
    public final void w(RecyclerView.Recycler r210, RecyclerView.State r211, VirtualLayoutManager.e r212, g r213, com.bytedance.android.ec.vlayout.b r214) {
        if (j(r212.f49093a.f49067f) == false) goto L5;
        return;
    L5:
        ExposeLinearLayoutManagerEx.d r100 = r212.f49093a;
        int r101 = r100.f49067f;
        View r102 = r100.a(r210);
        if (r102 != null) goto L8;
        r213.f556370b = true;
        r102 = null;
    L19:
        View r110 = r102;
        if (r110 != null) goto L22;
        return;
    L22:
        r214.getClass();
        VirtualLayoutManager.LayoutParams r103 = (VirtualLayoutManager.LayoutParams) r110.getLayoutParams();
        if (r214.getOrientation() != 1) goto L25;
        boolean r104 = true;
    L27:
        if (r212.f49093a.f49069h != 1) goto L29;
        boolean r111 = true;
    L30:
        if (r111 == false) goto L35;
        if (r101 == ((Integer) this.f49095a.f550757a).intValue()) goto L36;
    L37:
        boolean r112 = false;
    L38:
        if (r111 == false) goto L43;
        if (r101 == ((Integer) this.f49095a.f550758b).intValue()) goto L44;
    L45:
        boolean r105 = false;
    L46:
        if (r112 == false) goto L48;
        int r113 = t(r214, r104, r111);
    L49:
        if (r105 == false) goto L54;
        if (r104 == false) goto L52;
        int r106 = this.f556378g;
    L53:
        int r107 = r106 + 0;
    L55:
        if (r112 == false) goto L57;
    L60:
        int r114 = 0;
    L61:
        VirtualLayoutManager r115 = (VirtualLayoutManager) r214;
        int r116 = (((r115.P() - r214.getPaddingLeft()) - r214.getPaddingRight()) - 0) - (this.f556375d + this.f556376e);
        int r108 = RecyclerView.LayoutManager.getChildMeasureSpec(r116, 0, ((ViewGroup.MarginLayoutParams) r103).width, !r104);
        float r109 = r103.f49089a;
        if (Float.isNaN(r109) == true) goto L67;
        if (r109 <= 0.0f) goto L67;
        int r117 = View.MeasureSpec.makeMeasureSpec((int) ((r116 / r109) + 0.5f), 1073741824);
    L72:
        r214.measureChildWithMargins(r110, r108, r117);
        un.e r118 = r115.f49079q;
        r213.f556369a = ((r118.c(r110) + r113) + r107) + r114;
        if (r214.getOrientation() == 1) goto L75;
        int r119 = (r214.getPaddingTop() + 0) + this.f556377f;
        int r120 = r118.d(r110) + r119;
        ExposeLinearLayoutManagerEx.d r121 = r212.f49093a;
        if (r121.f49069h != (-1)) goto L95;
        int r122 = r121.f49065d - r113;
        if (r112 == false) goto L94;
        r114 = 0;
    L94:
        int r123 = r122 - r114;
        int r124 = r123;
        int r125 = r120;
        int r126 = r119;
        int r127 = r123 - r118.c(r110);
    L99:
        v(r110, r127, r126, r124, r125, r214);
        a.u(r213, r110);
        this.f556374o = false;
        return;
    L95:
        int r128 = r121.f49065d + r113;
        if (r112 == false) goto L98;
        r114 = 0;
    L98:
        int r129 = r128 + r114;
        r124 = r118.c(r110) + r129;
        r125 = r120;
        r126 = r119;
        r127 = r129;
        goto L99
    L75:
        if (r115.isLayoutRTL() == false) goto L77;
        int r130 = ((r115.P() - r214.getPaddingRight()) - 0) - this.f556376e;
        int r131 = r130 - r118.d(r110);
    L78:
        ExposeLinearLayoutManagerEx.d r132 = r212.f49093a;
        if (r132.f49069h != (-1)) goto L84;
        int r133 = r132.f49065d - r113;
        if (r112 == false) goto L83;
        r114 = 0;
    L83:
        int r134 = r133 - r114;
        int r135 = r134 - r118.c(r110);
    L88:
        r125 = r134;
        r126 = r135;
        int r136 = r131;
        r124 = r130;
        r127 = r136;
        goto L99
    L84:
        int r137 = r132.f49065d + r113;
        if (r112 == false) goto L87;
        r114 = 0;
    L87:
        int r138 = r137 + r114;
        int r139 = r118.c(r110) + r138;
        r135 = r138;
        r134 = r139;
        goto L88
    L77:
        r131 = (r214.getPaddingLeft() + 0) + this.f556375d;
        r130 = r118.d(r110) + r131;
    L67:
        if (Float.isNaN(this.f556364k) == true) goto L71;
        float r140 = this.f556364k;
        if (r140 <= 0.0f) goto L71;
        r117 = View.MeasureSpec.makeMeasureSpec((int) (((double) (r116 / r140)) + 0.5d), 1073741824);
    L71:
        r117 = RecyclerView.LayoutManager.getChildMeasureSpec((((r115.O() - r214.getPaddingTop()) - r214.getPaddingBottom()) - 0) - (this.f556377f + this.f556378g), 0, ((ViewGroup.MarginLayoutParams) r103).height, r104);
        goto L72
    L57:
        if (this.f556374o == true) goto L60;
        r114 = this.f556373n;
        goto L61
    L52:
        r106 = this.f556375d;
        goto L53
    L54:
        r107 = 0;
        goto L55
    L48:
        r113 = 0;
    L44:
        r105 = true;
        goto L46
    L43:
        if (r101 != ((Integer) this.f49095a.f550757a).intValue()) goto L45;
    L36:
        r112 = true;
        goto L38
    L35:
        if (r101 != ((Integer) this.f49095a.f550758b).intValue()) goto L37;
    L29:
        r111 = false;
        goto L30
    L25:
        r104 = false;
        goto L27
    L8:
        VirtualLayoutManager r141 = (VirtualLayoutManager) r214;
        r141.getClass();
        if (r212.f49093a.f49068g != 1) goto L11;
        int r142 = -1;
    L12:
        r141.V(r102);
        if (r212.f49093a.f49073l == null) goto L15;
        boolean r143 = true;
    L16:
        if (r143 == true) goto L18;
        r141.addView(r102, r142);
        goto L19
    L18:
        r141.addDisappearingView(r102, r142);
        goto L19
    L15:
        r143 = false;
        goto L16
    L11:
        r142 = 0;
        goto L12
    }
}
