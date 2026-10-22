package vn;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx;
import com.bytedance.android.ec.vlayout.VirtualLayoutManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

/* JADX INFO: loaded from: classes44.dex */
public final class m extends d {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f556402o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f556403p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f556404q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f556405r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f556406s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public b f556407t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public a f556408u;

    public interface a {
        void enable();
    }

    public interface b {
        void a(int r100);

        void b(int r100);
    }

    public m() {
        this(0);
    }

    @Override // vn.a
    public final boolean y() {
        return false;
    }

    @Override // com.bytedance.android.ec.vlayout.a
    public final View g() {
        return this.f556404q;
    }

    public m(int r100) {
        this.f556402o = -1;
        this.f556403p = true;
        this.f556404q = null;
        this.f556405r = false;
        this.f556406s = false;
        this.f556403p = true;
        r(1);
    }

    public final int C(com.bytedance.android.ec.vlayout.b r100) {
        a r101 = this.f556408u;
        int r102 = 0;
        if (r101 == null) goto L16;
        r101.enable();
        if ((r100 instanceof VirtualLayoutManager) == false) goto L16;
        Iterator<com.bytedance.android.ec.vlayout.a> r103 = ((VirtualLayoutManager) r100).R().iterator();
    L8:
        if (r103.hasNext() == false) goto L16;
        com.bytedance.android.ec.vlayout.a r104 = r103.next();
        if (r104.i() == false) goto L8;
        if (((Integer) r104.f49095a.f550758b).intValue() >= ((Integer) this.f49095a.f550757a).intValue()) goto L8;
        View r105 = r104.g();
        if (r105 == null) goto L8;
        r102 = r102 + r105.getHeight();
    L16:
        return r102;
    }

    @Override // com.bytedance.android.ec.vlayout.a
    public final void o(int r100) {
        this.f556402o = r100;
    }

    @Override // vn.a, com.bytedance.android.ec.vlayout.a
    public final void r(int r100) {
        if (r100 <= 0) goto L4;
        this.f556365l = 1;
        return;
    L4:
        this.f556365l = 0;
    }

    @Override // vn.a
    public final void x(com.bytedance.android.ec.vlayout.b r100) {
        View r101 = this.f556404q;
        if (r101 == null) goto L13;
        VirtualLayoutManager r102 = (VirtualLayoutManager) r100;
        if (r102.f49081s == null) goto L11;
        ViewParent r103 = r101.getParent();
        if (r103 == null) goto L11;
        RecyclerView r104 = r102.f49081s;
        if (r103 != r104) goto L11;
        RecyclerView.ViewHolder r105 = r104.getChildViewHolder(r101);
        r102.f49081s.getRecycledViewPool().putRecycledView(r105);
    L11:
        r102.removeView(this.f556404q);
        this.f556404q = null;
        return;
    }

    public final void B(View r110, com.bytedance.android.ec.vlayout.b r111) {
        VirtualLayoutManager.LayoutParams r100 = (VirtualLayoutManager.LayoutParams) r110.getLayoutParams();
        if (r111.getOrientation() != 1) goto L5;
        boolean r101 = true;
    L6:
        VirtualLayoutManager r102 = (VirtualLayoutManager) r111;
        int r103 = ((r102.P() - r111.getPaddingLeft()) - r111.getPaddingRight()) - 0;
        int r104 = ((r102.O() - r111.getPaddingTop()) - r111.getPaddingBottom()) - 0;
        float r105 = r100.f49089a;
        if (r101 == false) goto L20;
        int r106 = RecyclerView.LayoutManager.getChildMeasureSpec(r103, 0, ((ViewGroup.MarginLayoutParams) r100).width, false);
        if (Float.isNaN(r105) == true) goto L14;
        if (r105 <= 0.0f) goto L14;
        int r107 = View.MeasureSpec.makeMeasureSpec((int) ((r103 / r105) + 0.5f), 1073741824);
    L19:
        r111.measureChildWithMargins(r110, r106, r107);
        return;
    L14:
        if (Float.isNaN(this.f556364k) == true) goto L18;
        float r108 = this.f556364k;
        if (r108 <= 0.0f) goto L18;
        r107 = View.MeasureSpec.makeMeasureSpec((int) (((double) (r103 / r108)) + 0.5d), 1073741824);
    L18:
        r107 = RecyclerView.LayoutManager.getChildMeasureSpec(r104, 0, ((ViewGroup.MarginLayoutParams) r100).height, true);
        goto L19
    L20:
        int r109 = RecyclerView.LayoutManager.getChildMeasureSpec(r104, 0, ((ViewGroup.MarginLayoutParams) r100).height, false);
        if (Float.isNaN(r105) == true) goto L26;
        if (r105 <= 0.0f) goto L26;
        int r112 = View.MeasureSpec.makeMeasureSpec((int) (((double) (r104 * r105)) + 0.5d), 1073741824);
    L31:
        r111.measureChildWithMargins(r110, r112, r109);
        return;
    L26:
        if (Float.isNaN(this.f556364k) == true) goto L30;
        float r113 = this.f556364k;
        if (r113 <= 0.0f) goto L30;
        r112 = View.MeasureSpec.makeMeasureSpec((int) (((double) (r104 * r113)) + 0.5d), 1073741824);
    L30:
        r112 = RecyclerView.LayoutManager.getChildMeasureSpec(r103, 0, ((ViewGroup.MarginLayoutParams) r100).width, true);
        goto L31
    L5:
        r101 = false;
        goto L6
    }

    @Override // vn.a, com.bytedance.android.ec.vlayout.a
    public final void b(RecyclerView.Recycler r100, RecyclerView.State r101, com.bytedance.android.ec.vlayout.b r102) {
        super.b(r100, r101, r102);
        View r103 = this.f556404q;
        if (r103 == null) goto L54;
        RecyclerView r104 = ((VirtualLayoutManager) r102).f49081s;
        if (r104 == null) goto L7;
        RecyclerView.ViewHolder r105 = r104.getChildViewHolder(r103);
    L8:
        boolean r106 = true;
        if (r105 == null) goto L49;
        ExposeLinearLayoutManagerEx.e r107 = new ExposeLinearLayoutManagerEx.e(r105);
        Method r108 = ExposeLinearLayoutManagerEx.e.f49074b;
        if (r108 != null) goto L60;
    L19:
        boolean r109 = true;
    L20:
        if (r109 == true) goto L45;
        Method r110 = ExposeLinearLayoutManagerEx.e.f49075c;
        if (r110 != null) goto L58;
    L30:
        boolean r111 = true;
    L31:
        if (r111 == true) goto L45;
        Method r112 = ExposeLinearLayoutManagerEx.e.f49076d;
        if (r112 != null) goto L56;
    L41:
        boolean r113 = true;
    L42:
        if (r113 == true) goto L45;
        boolean r114 = false;
    L46:
        if (r114 == true) goto L49;
        r106 = false;
        goto L49
    L56:
        r113 = ((Boolean) r112.invoke(r107.f49078a, new Object[0])).booleanValue();     // Catch: InvocationTargetException -> L37 IllegalAccessException -> L39
    L39:
        e = move-exception;
        e.printStackTrace();
    L37:
        e = move-exception;
        e.printStackTrace();
        goto L41
    L58:
        r111 = ((Boolean) r110.invoke(r107.f49078a, new Object[0])).booleanValue();     // Catch: InvocationTargetException -> L26 IllegalAccessException -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    L26:
        e = move-exception;
        e.printStackTrace();
    L45:
        r114 = true;
        goto L46
    L60:
        r109 = ((Boolean) r108.invoke(r105, new Object[0])).booleanValue();     // Catch: InvocationTargetException -> L15 IllegalAccessException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
    L15:
        e = move-exception;
        e.printStackTrace();
    L49:
        if (r106 == false) goto L54;
        if (r102.getPosition(this.f556404q) != 0) goto L53;
        return;
    L53:
        ((VirtualLayoutManager) r102).removeView(this.f556404q);
        r100.recycleView(this.f556404q);
        this.f556404q = null;
        goto L54
    L7:
        r105 = null;
    L54:
        this.f556405r = false;
    }

    @Override // vn.a
    public final void w(RecyclerView.Recycler r110, RecyclerView.State r111, VirtualLayoutManager.e r210, g r211, com.bytedance.android.ec.vlayout.b r212) {
        if (j(r210.f49093a.f49067f) == false) goto L5;
        return;
    L5:
        View r100 = this.f556404q;
        if (r100 != null) goto L8;
        r100 = r210.f49093a.a(r110);
    L9:
        View r112 = r100;
        boolean r113 = true;
        if (r112 != null) goto L13;
        r211.f556370b = true;
        return;
    L13:
        B(r112, r212);
        r212.getOrientation();
        VirtualLayoutManager r114 = (VirtualLayoutManager) r212;
        un.e r101 = r114.f49079q;
        r211.f556369a = r101.c(r112);
        RecyclerView.LayoutParams r102 = (RecyclerView.LayoutParams) r112.getLayoutParams();
        this.f556405r = true;
        ExposeLinearLayoutManagerEx.d r103 = r210.f49093a;
        int r104 = (r103.f49066e - r211.f556369a) + r103.f49071j;
        int r115 = -1;
        if (r212.getOrientation() == 1) goto L16;
        int r105 = r212.getPaddingTop();
        int r106 = (r101.d(r112) + r105) + 0;
        ExposeLinearLayoutManagerEx.d r107 = r210.f49093a;
        if (r107.f49069h != (-1)) goto L50;
        int r108 = r107.f49065d;
        int r109 = r108 + 0;
        int r116 = r108 - r211.f556369a;
    L52:
        if (r212.getReverseLayout() == false) goto L54;
    L59:
        this.f556368n.getClass();
        if (r104 >= 0) goto L62;
        this.f556405r = false;
        this.f556404q = r112;
        int r117 = r101.g() - 0;
        this.f556368n.getClass();
        int r118 = r117 - 0;
        int r119 = r118 - r211.f556369a;
        int r120 = r118;
    L64:
        int r121 = r105;
    L65:
        v(r112, r119, r121, r120, r106, r212);
        r211.f556369a += 0;
        if (r111.isPreLayout() == false) goto L69;
        this.f556405r = true;
    L69:
        if (this.f556405r == true) goto L71;
        return;
    L71:
        if (r210.f49093a.f49068g == 1) goto L74;
        r115 = 0;
    L74:
        r114.V(r112);
        if (r210.f49093a.f49073l != null) goto L78;
        r113 = false;
    L78:
        if (r113 == true) goto L80;
        r114.addView(r112, r115);
    L81:
        vn.a.u(r211, r112);
        return;
    L80:
        r114.addDisappearingView(r112, r115);
    L62:
        r119 = r116;
        r120 = r109;
        goto L64
    L54:
        if (this.f556403p == false) goto L59;
        this.f556368n.getClass();
        if (r104 >= 0) goto L62;
        this.f556405r = false;
        this.f556404q = r112;
        int r122 = r101.i() + 0;
        this.f556368n.getClass();
        r120 = r211.f556369a;
        r119 = r122 + 0;
        goto L64
    L50:
        int r123 = r107.f49065d;
        r109 = r123 + r211.f556369a;
        r116 = r123 + 0;
        goto L52
    L16:
        if (r114.isLayoutRTL() == false) goto L18;
        int r124 = (r114.P() - r212.getPaddingRight()) - 0;
        int r125 = r124 - r101.d(r112);
    L19:
        ExposeLinearLayoutManagerEx.d r126 = r210.f49093a;
        if (r126.f49069h != (-1)) goto L23;
        int r127 = r126.f49065d;
        r106 = r127 + 0;
        int r128 = r127 - r211.f556369a;
    L27:
        if (r212.getReverseLayout() == false) goto L29;
    L39:
        this.f556368n.getClass();
        if (r104 < 0) goto L42;
    L43:
        this.f556368n.getClass();
        if (r106 <= 0) goto L46;
    L45:
        this.f556405r = false;
        this.f556404q = r112;
        int r129 = (r101.g() - 0) - 0;
        this.f556368n.getClass();
        int r130 = r129 - 0;
        r106 = r130;
        r128 = r130 - r211.f556369a;
    L46:
        r119 = r125;
        r121 = r128;
        r120 = r124;
        goto L65
    L42:
        if (r210.f49093a.f49068g == 1) goto L45;
    L29:
        if (this.f556403p == false) goto L39;
        this.f556368n.getClass();
        if (r104 < 0) goto L34;
    L35:
        this.f556368n.getClass();
        if (r128 >= 0) goto L38;
    L37:
        this.f556405r = false;
        this.f556404q = r112;
        int r131 = (r101.i() + 0) + 0;
        this.f556368n.getClass();
        int r132 = r131 + 0;
        r128 = r132;
        r106 = r211.f556369a + r132;
        goto L46
    L38:
        vn.b r133 = VirtualLayoutManager.H;
        goto L46
    L34:
        if (r210.f49093a.f49068g == (-1)) goto L37;
    L23:
        if (this.f556403p == false) goto L25;
        int r134 = r126.f49065d;
        r106 = r134 + r211.f556369a;
        r128 = r134 + 0;
        goto L27
    L25:
        int r135 = (r101.g() - 0) - 0;
        this.f556368n.getClass();
        r106 = r135 + 0;
        r128 = r106 - r211.f556369a;
        goto L27
    L18:
        r125 = r212.getPaddingLeft() + 0;
        r124 = r101.d(r112) + r125;
        goto L19
    L8:
        ExposeLinearLayoutManagerEx.d r136 = r210.f49093a;
        r136.f49067f += r136.f49068g;
        goto L9
    }

    @Override // vn.a, com.bytedance.android.ec.vlayout.a
    public final void a(RecyclerView.Recycler r110, RecyclerView.State r111, int r210, int r211, int r212, com.bytedance.android.ec.vlayout.b r213) {
        super.a(r110, r111, r210, r211, r212, r213);
        int r100 = this.f556402o;
        if (r100 >= 0) goto L5;
        return;
    L5:
        VirtualLayoutManager r101 = (VirtualLayoutManager) r213;
        un.e r102 = r101.f49079q;
        boolean r112 = false;
        if (this.f556405r == true) goto L45;
        if (r100 < r210) goto L45;
        if (r100 > r211) goto L45;
        vn.b r103 = VirtualLayoutManager.H;
        if (this.f556404q == null) goto L45;
        if (this.f556403p == false) goto L28;
        int r104 = r213.getChildCount() - 1;
    L14:
        if (r104 < 0) goto L45;
        View r105 = r213.getChildAt(r104);
        int r106 = r213.getPosition(r105);
        if (r106 < this.f556402o) goto L17;
        r104 = r104 - 1;
        goto L14
    L17:
        int r107 = r102.b(r105);
        com.bytedance.android.ec.vlayout.a r108 = ((VirtualLayoutManager) r213).M(r106);
        if ((r108 instanceof j) == false) goto L20;
        ((Integer) ((j) r108).f49095a.f550758b).intValue();
        throw null;
    L20:
        if ((r108 instanceof i) == false) goto L22;
        i r109 = (i) r108;
        r109.getClass();
        r107 = (r107 + 0) + r109.f556378g;
    L22:
        this.f556368n.getClass();
        if (r107 < 0) goto L45;
        this.f556405r = true;
        goto L45
    L28:
        int r113 = 0;
    L30:
        if (r113 >= r213.getChildCount()) goto L45;
        View r114 = r213.getChildAt(r113);
        int r115 = r213.getPosition(r114);
        if (r115 > this.f556402o) goto L33;
        r113 = r113 + 1;
        goto L30
    L33:
        int r116 = r102.e(r114);
        com.bytedance.android.ec.vlayout.a r117 = ((VirtualLayoutManager) r213).M(r115);
        if ((r117 instanceof j) == false) goto L36;
        ((Integer) ((j) r117).f49095a.f550757a).intValue();
        throw null;
    L36:
        if ((r117 instanceof i) == false) goto L38;
        i r118 = (i) r117;
        r118.getClass();
        r116 = (r116 + 0) - r118.f556377f;
    L38:
        this.f556368n.getClass();
        if (r116 < 0) goto L45;
        this.f556405r = true;
    L45:
        if (this.f556405r == false) goto L47;
    L48:
        r111.isPreLayout();
        View r119 = this.f556404q;
        if (r119 == null) goto L365;
        r101.removeView(r119);
    L51:
        View r120 = this.f556404q;
        if (this.f556405r == true) goto L182;
        if (r120 == null) goto L182;
        if (r120.getParent() != null) goto L57;
        r101.L(this.f556404q, false);
    L324:
        b r121 = this.f556407t;
        if (r121 == null) goto L366;
        boolean r122 = this.f556406s;
        if (r122 == true) goto L329;
    L336:
        if (r122 == false) goto L338;
        return;
    L338:
        if (this.f556405r == false) goto L340;
    L342:
        if (r112 == false) goto L369;
        r121.b(this.f556402o);
        this.f556406s = true;
        return;
    L369:
        return;
    L340:
        if (this.f556404q == null) goto L342;
        r112 = true;
        goto L342
    L329:
        if (this.f556405r == false) goto L331;
    L333:
        boolean r123 = false;
    L334:
        if (r123 == true) goto L336;
        r121.a(this.f556402o);
        this.f556406s = false;
        return;
    L331:
        if (this.f556404q == null) goto L333;
        r123 = true;
        goto L334
    L366:
        return;
    L57:
        View r124 = this.f556404q;
        if (r124 != null) goto L60;
    L62:
        boolean r125 = this.f556403p;
        if (r125 == true) goto L65;
    L66:
        if (r125 == false) goto L68;
    L174:
        r101.removeView(this.f556404q);
        View r126 = this.f556404q;
        if (r101.f49081s == null) goto L181;
        ViewParent r127 = r126.getParent();
        if (r127 == null) goto L181;
        RecyclerView r128 = r101.f49081s;
        if (r127 != r128) goto L181;
        r101.f49081s.getRecycledViewPool().putRecycledView(r128.getChildViewHolder(r126));
    L181:
        this.f556404q = null;
        goto L324
    L68:
        if (r210 > this.f556402o) goto L174;
    L69:
        int r129 = r102.c(this.f556404q);
        if (r213.getOrientation() != 1) goto L72;
        boolean r130 = true;
    L73:
        int r131 = C(r213);
        if (r130 == false) goto L76;
        this.f556368n.getClass();
        int r132 = r131 + 0;
    L77:
        this.f556368n.getClass();
        if (r130 == false) goto L138;
        VirtualLayoutManager r133 = (VirtualLayoutManager) r213;
        if (r133.isLayoutRTL() == false) goto L82;
        int r134 = (r133.P() - r213.getPaddingRight()) - 0;
        int r135 = r134 - r102.d(this.f556404q);
    L84:
        if (this.f556403p == false) goto L98;
        int r136 = r213.getChildCount() - 1;
        View r137 = null;
    L86:
        if (r136 < 0) goto L113;
        r137 = r213.getChildAt(r136);
        int r138 = r213.getPosition(r137);
        if (r138 < this.f556402o) goto L89;
        r136 = r136 - 1;
        goto L86
    L89:
        int r139 = r102.b(r137);
        com.bytedance.android.ec.vlayout.a r140 = r133.M(r138);
        if ((r140 instanceof j) == false) goto L92;
        ((Integer) ((j) r140).f49095a.f550758b).intValue();
        throw null;
    L92:
        if ((r140 instanceof i) == false) goto L94;
        i r141 = (i) r140;
        r141.getClass();
        r139 = (r139 + 0) + r141.f556378g;
    L94:
        int r142 = r139 + r129;
        this.f556405r = true;
    L109:
        int r143 = r136;
        int r144 = r139;
        int r145 = r143;
    L114:
        if (r137 == null) goto L116;
        if (r145 < 0) goto L116;
    L118:
        if (r213.getReverseLayout() == true) goto L126;
        if (this.f556403p == false) goto L126;
        if (r144 >= ((r102.i() + 0) + r132)) goto L129;
        this.f556405r = false;
    L129:
        if (this.f556405r == false) goto L131;
    L137:
        int r146 = r134;
        int r147 = r135;
        int r148 = r144;
        int r149 = r142;
        int r150 = r145;
    L166:
        v(this.f556404q, r147, r148, r146, r149, r213);
        if (this.f556405r == false) goto L173;
        if (r150 < 0) goto L324;
        if (this.f556404q.getParent() != null) goto L172;
        ((VirtualLayoutManager) r213).K(this.f556404q, r150);
    L172:
        this.f556404q = null;
        goto L324
    L173:
        VirtualLayoutManager r151 = (VirtualLayoutManager) r213;
        r151.V(this.f556404q);
        r151.L(this.f556404q, false);
        goto L324
    L131:
        if (r213.getReverseLayout() == false) goto L133;
    L136:
        r142 = (r102.g() - 0) + 0;
        r144 = r142 - r129;
        goto L137
    L133:
        if (this.f556403p == false) goto L136;
        r144 = (r102.i() + 0) + r132;
        r142 = r144 + r129;
    L126:
        if (r142 <= ((r102.g() - 0) - 0)) goto L129;
        this.f556405r = false;
    L116:
        this.f556405r = false;
    L113:
        r142 = 0;
        r145 = -1;
        r144 = 0;
        goto L114
    L98:
        r137 = null;
        int r152 = 0;
    L100:
        if (r152 >= r213.getChildCount()) goto L113;
        r137 = r213.getChildAt(r152);
        int r153 = r213.getPosition(r137);
        if (r153 > this.f556402o) goto L103;
        r152 = r152 + 1;
        goto L100
    L103:
        int r154 = r102.e(r137);
        com.bytedance.android.ec.vlayout.a r155 = r133.M(r153);
        if ((r155 instanceof j) == false) goto L106;
        ((Integer) ((j) r155).f49095a.f550757a).intValue();
        throw null;
    L106:
        if ((r155 instanceof i) == false) goto L108;
        i r156 = (i) r155;
        r156.getClass();
        r154 = (r154 + 0) - r156.f556377f;
    L108:
        r142 = r154;
        r139 = r142 - r129;
        r136 = r152 + 1;
        this.f556405r = true;
        goto L109
    L82:
        r135 = r213.getPaddingLeft() + 0;
        r134 = r102.d(this.f556404q) + r135;
        goto L84
    L138:
        int r157 = r213.getPaddingTop();
        int r158 = r102.d(this.f556404q) + r157;
        if (this.f556405r == false) goto L157;
        if (this.f556403p == false) goto L148;
        int r159 = r213.getChildCount() - 1;
    L143:
        if (r159 < 0) goto L155;
        View r160 = r213.getChildAt(r159);
        if (r213.getPosition(r160) < this.f556402o) goto L146;
        r159 = r159 - 1;
        goto L143
    L146:
        r147 = r102.b(r160);
    L162:
        int r161 = r129 + r147;
    L165:
        r146 = r161;
        r149 = r158;
        r150 = -1;
        r148 = r157;
    L155:
        r161 = 0;
        r147 = 0;
        goto L165
    L148:
        int r162 = 0;
    L150:
        if (r162 >= r213.getChildCount()) goto L155;
        View r163 = r213.getChildAt(r162);
        if (r213.getPosition(r163) > this.f556402o) goto L153;
        r162 = r162 + 1;
        goto L150
    L153:
        int r164 = r102.e(r163);
    L164:
        int r165 = r164;
        r147 = r164 - r129;
        r161 = r165;
        goto L165
    L157:
        if (r213.getReverseLayout() == false) goto L159;
    L163:
        r164 = (r102.g() - 0) - 0;
        goto L164
    L159:
        if (this.f556403p == false) goto L163;
        r147 = r132 + (r102.i() + 0);
        goto L162
    L76:
        this.f556368n.getClass();
        r132 = 0;
        goto L77
    L72:
        r130 = false;
        goto L73
    L65:
        if (r211 >= this.f556402o) goto L69;
    L60:
        if (r124.isLayoutRequested() == false) goto L62;
        B(this.f556404q, r213);
    L182:
        if (r120 != null) goto L185;
        r120 = r213.findViewByPosition(this.f556402o);
    L185:
        if (r213.getOrientation() != 1) goto L187;
        boolean r166 = true;
    L188:
        int r167 = C(r213);
        if (r166 == false) goto L191;
        this.f556368n.getClass();
        int r168 = r167 + 0;
    L192:
        this.f556368n.getClass();
        boolean r169 = this.f556403p;
        if (r169 == true) goto L195;
    L196:
        if (r169 == false) goto L198;
    L219:
        boolean r170 = false;
    L220:
        View r171 = this.f556404q;
        if (r171 != null) goto L223;
    L323:
        this.f556405r = r170;
        goto L324
    L223:
        if (((RecyclerView.LayoutParams) r171.getLayoutParams()).isItemRemoved() == true) goto L324;
        int r172 = r102.c(this.f556404q);
        if (r166 == false) goto L286;
        VirtualLayoutManager r173 = (VirtualLayoutManager) r213;
        if (r173.isLayoutRTL() == false) goto L230;
        int r174 = (r173.P() - r213.getPaddingRight()) - 0;
        int r175 = r174 - r102.d(this.f556404q);
    L231:
        if (r170 == true) goto L233;
        int r176 = 0;
        int r177 = -1;
        int r178 = 0;
    L277:
        if (r170 == false) goto L279;
    L285:
        int r179 = r176;
        int r180 = r174;
        int r181 = r175;
        int r182 = r178;
        boolean r183 = r170;
        int r184 = r177;
    L314:
        v(this.f556404q, r181, r182, r180, r179, r213);
        if (r183 == false) goto L321;
        if (r184 >= 0) goto L318;
    L322:
        r170 = r183;
        goto L323
    L318:
        if (this.f556404q.getParent() != null) goto L320;
        ((VirtualLayoutManager) r213).K(this.f556404q, r184);
    L320:
        this.f556404q = null;
        goto L322
    L321:
        ((VirtualLayoutManager) r213).L(this.f556404q, false);
        goto L322
    L279:
        if (r213.getReverseLayout() == false) goto L281;
    L284:
        r176 = (r102.g() - 0) + 0;
        r178 = r176 - r172;
        goto L285
    L281:
        if (this.f556403p == false) goto L284;
        r178 = (r102.i() + 0) + r168;
        r176 = r172 + r178;
        goto L285
    L233:
        if (this.f556403p == false) goto L247;
        int r185 = r213.getChildCount() - 1;
        View r186 = null;
    L235:
        if (r185 < 0) goto L261;
        r186 = r213.getChildAt(r185);
        int r187 = r213.getPosition(r186);
        if (r187 < this.f556402o) goto L238;
        r185 = r185 - 1;
        goto L235
    L238:
        int r188 = r102.b(r186);
        com.bytedance.android.ec.vlayout.a r189 = r173.M(r187);
        if ((r189 instanceof j) == false) goto L241;
        ((Integer) ((j) r189).f49095a.f550758b).intValue();
        throw null;
    L241:
        if ((r189 instanceof i) == false) goto L243;
        i r190 = (i) r189;
        r190.getClass();
        r188 = (r188 + 0) + r190.f556378g;
    L243:
        r176 = r188 + r172;
        int r191 = r185 + 1;
        r178 = r188;
        r177 = r191;
    L262:
        if (r186 == null) goto L264;
        if (r177 < 0) goto L264;
    L266:
        if (r213.getReverseLayout() == true) goto L274;
        if (this.f556403p == false) goto L274;
        if (r178 >= ((r102.i() + 0) + r168)) goto L277;
    L275:
        r170 = false;
    L274:
        if (r176 <= ((r102.g() - 0) - 0)) goto L277;
    L264:
        r170 = false;
    L261:
        r176 = 0;
        r177 = -1;
        r178 = 0;
        goto L262
    L247:
        r186 = null;
        r177 = 0;
    L249:
        if (r177 >= r213.getChildCount()) goto L261;
        r186 = r213.getChildAt(r177);
        int r192 = r213.getPosition(r186);
        if (r192 > this.f556402o) goto L252;
        r177 = r177 + 1;
        goto L249
    L252:
        int r193 = r102.e(r186);
        com.bytedance.android.ec.vlayout.a r194 = r173.M(r192);
        if ((r194 instanceof j) == false) goto L255;
        ((Integer) ((j) r194).f49095a.f550757a).intValue();
        throw null;
    L255:
        if ((r194 instanceof i) == false) goto L257;
        i r195 = (i) r194;
        r195.getClass();
        r193 = (r193 + 0) - r195.f556377f;
    L257:
        r176 = r193;
        r178 = r176 - r172;
        goto L262
    L230:
        r175 = r213.getPaddingLeft() + 0;
        r174 = r102.d(this.f556404q) + r175;
        goto L231
    L286:
        int r196 = r213.getPaddingTop();
        int r197 = r102.d(this.f556404q) + r196;
        if (r170 == false) goto L305;
        if (this.f556403p == false) goto L296;
        int r198 = r213.getChildCount() - 1;
    L291:
        if (r198 < 0) goto L303;
        View r199 = r213.getChildAt(r198);
        if (r213.getPosition(r199) < this.f556402o) goto L294;
        r198 = r198 - 1;
        goto L291
    L294:
        int r200 = r102.b(r199);
    L310:
        int r1100 = r200;
        r180 = r172 + r200;
        int r201 = r1100;
    L313:
        r183 = r170;
        r179 = r197;
        r184 = -1;
        r182 = r196;
        r181 = r201;
    L303:
        r201 = 0;
        r180 = 0;
        goto L313
    L296:
        int r202 = 0;
    L298:
        if (r202 >= r213.getChildCount()) goto L303;
        View r203 = r213.getChildAt(r202);
        if (r213.getPosition(r203) > this.f556402o) goto L301;
        r202 = r202 + 1;
        goto L298
    L301:
        r180 = r102.e(r203);
    L312:
        r201 = r180 - r172;
        goto L313
    L305:
        if (r213.getReverseLayout() == false) goto L307;
    L311:
        r180 = (r102.g() - 0) - 0;
        goto L312
    L307:
        if (this.f556403p == false) goto L311;
        r200 = (r102.i() + 0) + r168;
        goto L310
    L198:
        if (r210 > this.f556402o) goto L219;
    L199:
        if (r120 != null) goto L208;
        if (r169 == false) goto L202;
        int r204 = r168;
    L204:
        if ((r204 + 0) < 0) goto L206;
        r170 = true;
    L207:
        View r205 = r110.getViewForPosition(this.f556402o);
        this.f556404q = r205;
        B(r205, r213);
        goto L220
    L206:
        r170 = false;
        goto L207
    L202:
        r204 = 0;
        goto L204
    L208:
        if (r169 == false) goto L213;
        if (r102.e(r120) < ((r102.i() + 0) + r168)) goto L213;
        this.f556404q = r120;
    L217:
        r170 = true;
    L213:
        if (this.f556403p == false) goto L215;
    L218:
        this.f556404q = r120;
        goto L219
    L215:
        if (r102.b(r120) > ((r102.g() - 0) - 0)) goto L218;
        this.f556404q = r120;
        goto L217
    L195:
        if (r211 >= this.f556402o) goto L199;
    L191:
        this.f556368n.getClass();
        r168 = 0;
        goto L192
    L187:
        r166 = false;
        goto L188
    L365:
        return;
    L47:
        if (r111.isPreLayout() == false) goto L51;
        goto L48
    }
}
