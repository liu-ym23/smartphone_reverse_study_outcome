package p40;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.a0;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.k;
import com.bytedance.android.live.componentsmarket.api.draggable.DraggableComponentState;
import com.bytedance.android.live.componentsmarket.impl.components.draggablecomponent.dragger.DraggableContainerView;
import com.bytedance.android.live.componentsmarket.impl.components.draggablecomponent.dragger.RegionId;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import k40.e;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends k40.d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ConstraintLayout f527622h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FrameLayout f527623i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DraggableContainerView f527624j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FrameLayout f527625k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FrameLayout f527626l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Space f527627m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Space f527628n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final View f527629o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Pair<Integer, Integer> f527630p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CompositeDisposable f527631q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Context f527632r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final View f527633s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f527634t;

    /* JADX INFO: renamed from: p40.a$a, reason: collision with other inner class name */
    public static final class C7148a {
    }

    static {
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void g() {
        ALogger.d("DraggableComponentView", "onAttach");
        t((int) (r() * 0.31466666f));
        DraggableContainerView r100 = this.f527624j;
        this.f527625k = r100;
        if (r100 == null) goto L6;
        r100.addView(this.f527633s);
        return;
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void i() {
        ALogger.e("DraggableComponentView", "DraggableComponentView onDetach");
        this.f527631q.clear();
        this.f527624j.setDragCallback(null);
        this.f527630p = TuplesKt.to(0, 0);
        this.f527625k = null;
    }

    public final int r() {
        return RangesKt.coerceAtMost(s1.y(), s1.w());
    }

    public final Context getContext() {
        return this.f527632r;
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final boolean d(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        if ((r100 instanceof e) == false) goto L6;
        e r101 = (e) r100;
        r101.getClass();
        r101.getClass();
        r101.getClass();
        p(null, null, 0, "RefreshLayout");
        return true;
    L6:
        return false;
    }

    public final void t(int r100) {
        ALogger.d("DraggableComponentView", "updateRegionBWidth, width:" + r100);
        if (r100 != 0) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r101 = this.f527628n.getLayoutParams();
        int r102 = Math.min((int) (r() * 0.31466666f), r100);
        if (r101.width == r102) goto L9;
        r101.width = r102;
        this.f527628n.setLayoutParams(r101);
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.anya.BaseMVIView
    public final void b(k r110, MVIState r111) {
        DraggableComponentState r112 = (DraggableComponentState) r111;
        Intrinsics.checkNotNullParameter(r110, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r112, "state");
        r r100 = r112.f64497c;
        KProperty[] r101 = DraggableComponentState.f64494h;
        KProperty r102 = r101[2];
        r100.getClass();
        Object r103 = r110.f41740c.a(r100);
        if (r103 == null) goto L22;
        r110.f41739b.f41563a.invoke(r100);
        DraggableComponentState.Mode r104 = (DraggableComponentState.Mode) r103;
        this.f527626l = this.f527625k;
        if (r104 != DraggableComponentState.Mode.EXPAND) goto L14;
        DraggableContainerView r105 = this.f527624j;
        if (r105 == null) goto L9;
        r105.setVisibility(0);
    L9:
        FrameLayout r106 = this.f527623i;
        if (r106 == null) goto L12;
        r106.setVisibility(8);
    L12:
        this.f527625k = this.f527624j;
    L14:
        if (r104 != DraggableComponentState.Mode.CLOSE) goto L22;
        DraggableContainerView r107 = this.f527624j;
        if (r107 == null) goto L18;
        r107.setVisibility(8);
    L18:
        FrameLayout r108 = this.f527623i;
        if (r108 == null) goto L21;
        r108.setVisibility(0);
    L21:
        this.f527625k = this.f527623i;
    L22:
        r r109 = r112.f64498d;
        KProperty r113 = r101[3];
        r109.getClass();
        r r114 = r112.f64496b;
        KProperty r115 = r101[1];
        r114.getClass();
        r r116 = r112.f64500f;
        KProperty r117 = r101[5];
        r116.getClass();
        Object r118 = r110.f41740c.a(r109);
        if (r118 == null) goto L25;
        r110.f41739b.f41563a.invoke(r109);
    L26:
        Object r119 = r110.f41740c.a(r114);
        if (r119 == null) goto L29;
        r110.f41739b.f41563a.invoke(r114);
    L30:
        Object r120 = r110.f41740c.a(r116);
        if (r120 == null) goto L33;
        r110.f41739b.f41563a.invoke(r116);
    L34:
        if (r118 != null) goto L37;
        if (r119 != null) goto L37;
        if (r120 != null) goto L37;
    L51:
        r r121 = r112.f64499e;
        KProperty r122 = r101[4];
        r121.getClass();
        Object r123 = r110.f41740c.a(r121);
        if (r123 == null) goto L54;
        r110.f41739b.f41563a.invoke(r121);
        new LinkedHashMap().put("container_payload", (String) r123);
    L54:
        r r124 = r112.f64495a;
        KProperty r125 = r101[0];
        r124.getClass();
        r r126 = r112.f64496b;
        KProperty r127 = r101[1];
        r126.getClass();
        r r128 = r112.f64500f;
        KProperty r129 = r101[5];
        r128.getClass();
        Object r130 = r110.f41740c.a(r124);
        if (r130 == null) goto L57;
        r110.f41739b.f41563a.invoke(r124);
    L58:
        Object r131 = r110.f41740c.a(r126);
        if (r131 == null) goto L61;
        r110.f41739b.f41563a.invoke(r126);
    L62:
        Object r132 = r110.f41740c.a(r128);
        if (r132 == null) goto L65;
        r110.f41739b.f41563a.invoke(r128);
    L66:
        if (r130 != null) goto L69;
        if (r131 != null) goto L69;
        if (r132 != null) goto L69;
    L82:
        r r133 = r112.f64501g;
        KProperty r134 = r101[6];
        r133.getClass();
        Object r135 = r110.f41740c.a(r133);
        if (r135 == null) goto L86;
        r110.f41739b.f41563a.invoke(r133);
        UtilityKotlinExtentionsKt.v(this.f527622h, ((Boolean) r135).booleanValue());
        return;
    L86:
        return;
    L69:
        if (r130 != null) goto L71;
        r130 = r124.c();
    L71:
        if (r131 != null) goto L73;
        r131 = r126.c();
    L73:
        if (r132 != null) goto L75;
        r132 = r128.c();
    L75:
        int r136 = ((Number) r132).intValue();
        DraggableComponentState.Style r137 = (DraggableComponentState.Style) r131;
        if (((Boolean) r130).booleanValue() == true) goto L78;
    L80:
        this.f527624j.setDragCallback(null);
    L81:
        RxUtilKt.c(RxUtilKt.g(this.f527624j, true).subscribe(new d(this)), this.f527631q);
        goto L82
    L78:
        if (r137 == DraggableComponentState.Style.DEFAULT) goto L80;
        q40.c r138 = new q40.c();
        q40.b r139 = new q40.b(RegionId.A, this.f527627m);
        Intrinsics.checkNotNullParameter(r139, "reg");
        r138.f531618a.add(r139);
        q40.b r140 = new q40.b(RegionId.B, this.f527628n);
        Intrinsics.checkNotNullParameter(r140, "reg");
        r138.f531618a.add(r140);
        this.f527624j.setDragCallback(new q40.a(this.f527624j, r138, new c(this, r137, r136)));
        goto L81
    L65:
        r132 = null;
        goto L66
    L61:
        r131 = null;
        goto L62
    L57:
        r130 = null;
    L37:
        if (r118 != null) goto L39;
        r118 = r109.c();
    L39:
        if (r119 != null) goto L41;
        r119 = r114.c();
    L41:
        if (r120 != null) goto L43;
        r120 = r116.c();
    L43:
        int r141 = ((Number) r120).intValue();
        DraggableComponentState.Style r142 = (DraggableComponentState.Style) r119;
        l40.a r143 = (l40.a) r118;
        if (this.f527622h.getWidth() != 0) goto L46;
    L49:
        this.f527622h.post(new b(r143, r142, r141, this));
    L50:
        ViewGroup.LayoutParams r144 = this.f527629o.getLayoutParams();
        r144.height = r141;
        this.f527629o.setLayoutParams(r144);
        goto L51
    L46:
        if (this.f527622h.getHeight() == 0) goto L49;
        p(r143, r142, r141, "else");
        goto L50
    L33:
        r120 = null;
        goto L34
    L29:
        r119 = null;
        goto L30
    L25:
        r118 = null;
        goto L26
    }

    public final l40.a q(DraggableComponentState.Style r100, int r101) {
        FrameLayout r102 = this.f527625k;
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r102.getWidth() != 0) goto L8;
    L18:
        return null;
    L8:
        if (r102.getHeight() == 0) goto L18;
        if (r102.getVisibility() != 0) goto L18;
        float r103 = r102.getWidth();
        float r104 = r102.getHeight() / r103;
        float r105 = r103 / r();
        float r106 = (r104 * r105) * 0.46182266f;
        if (r100 != DraggableComponentState.Style.HORIZONTAL) goto L15;
        float r107 = r102.getY();
        int r108 = this.f527622h.getHeight() - r101;
    L16:
        float r109 = r107 / r108;
        float r110 = r102.getX() / this.f527622h.getWidth();
        float r111 = (r102.getY() + r102.getHeight()) / this.f527622h.getHeight();
        float r112 = (r102.getX() + r102.getWidth()) / this.f527622h.getWidth();
        l40.a r113 = new l40.a(0);
        r113.j(j80.a.a(r109, 4));
        r113.h(j80.a.a(r110, 4));
        r113.i(j80.a.a(r112, 4));
        r113.f(j80.a.a(r111, 4));
        r113.k(j80.a.a(r105, 4));
        r113.g(j80.a.a(r106, 4));
        return r113;
    L15:
        r107 = r102.getY();
        r108 = this.f527622h.getHeight();
        goto L16
    }

    public final void s(RegionId r100, int r101) {
        FrameLayout r102 = this.f527625k;
        if (r102 == null) goto L5;
        r102.getVisibility();
    L5:
        RegionId r103 = RegionId.A;
        o(new k40.a());
    }

    public a(Context r100, View r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "cardView");
        this.f527632r = r100;
        this.f527633s = r101;
        this.f527634t = r102;
        View r103 = LayoutInflater.from(r100).inflate(R.layout.ttlive_draggable_component_view, null);
        if (r103 == null) goto L7;
        ConstraintLayout r104 = (ConstraintLayout) r103;
        this.f527622h = r104;
        this.f527623i = (FrameLayout) r104.findViewById(R.id.close_view);
        this.f527624j = (DraggableContainerView) r104.findViewById(R.id.expand_view);
        this.f527627m = (Space) r104.findViewById(R.id.region_a);
        this.f527628n = (Space) r104.findViewById(R.id.regin_b);
        this.f527629o = r104.findViewById(R.id.entry_anim_placeholder);
        this.f527630p = TuplesKt.to(0, 0);
        this.f527631q = new CompositeDisposable();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    }

    public final void p(l40.a r210, DraggableComponentState.Style r211, int r212, String r213) {
        ALogger.d("DraggableComponentView", "calculate layout: " + r210 + "  style:" + r211 + "  source" + r213);
        ConstraintSet r100 = new ConstraintSet();
        r100.clone(this.f527622h);
        r100.setTranslation(R.id.expand_view, 0.0f, 0.0f);
        if (r211 != DraggableComponentState.Style.DEFAULT) goto L18;
        FrameLayout r101 = this.f527625k;
        if (r101 == null) goto L7;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
    L9:
        if (r102 == null) goto L11;
        r102.width = -2;
    L11:
        if (r102 == null) goto L13;
        r102.height = -2;
    L13:
        r100.clear(R.id.expand_view, 3);
        r100.clear(R.id.expand_view, 6);
        r100.clear(R.id.expand_view, 4);
        r100.clear(R.id.expand_view, 7);
        r100.connect(R.id.expand_view, 3, R.id.group_parent_content, 3);
        r100.connect(R.id.expand_view, 6, R.id.group_parent_content, 6);
        r100.applyTo(this.f527622h);
        l40.a r103 = q(r211, r212);
        if (r103 != null) goto L16;
        return;
    L16:
        o(new k40.b(r103));
        return;
    L7:
        r102 = null;
        goto L9
    L18:
        float r104 = r210.e() * r();
        float r105 = ((r210.b() / r210.e()) * 2.1653333f) * r104;
        if (this.f527630p.getFirst().intValue() != 0) goto L21;
    L23:
        float r110 = r104;
        float r111 = r105;
        Rect r112 = new Rect();
        r112.left = this.f527627m.getLeft();
        r112.top = this.f527627m.getTop();
        r112.bottom = this.f527622h.getHeight() - r212;
        r112.right = this.f527627m.getRight();
        if (r211 != DraggableComponentState.Style.HORIZONTAL) goto L50;
        float r106 = (this.f527622h.getHeight() - r212) * r210.d();
        float r107 = this.f527622h.getWidth() * r210.c();
        RectF r108 = new RectF(r107, r106, r107 + r110, r106 + r111);
        if (r108.left >= this.f527627m.getLeft()) goto L29;
        float r109 = this.f527627m.getLeft();
        r108.left = r109;
        r108.right = r109 + r110;
    L29:
        if (r108.right <= this.f527627m.getRight()) goto L32;
        float r113 = this.f527627m.getRight();
        r108.right = r113;
        r108.left = r113 - r110;
    L32:
        if (r108.left >= this.f527627m.getLeft()) goto L35;
        r108.left = this.f527627m.getLeft();
    L35:
        if (r108.right <= this.f527627m.getRight()) goto L37;
        r108.right = this.f527627m.getRight();
    L37:
        float r114 = r108.right - r108.left;
        float r115 = r108.top;
        float r116 = r112.top;
        if (r115 >= r116) goto L40;
        r108.top = r116;
        r108.bottom = r116 + r111;
    L40:
        float r117 = r108.bottom;
        float r118 = r112.bottom;
        if (r117 <= r118) goto L44;
        r108.bottom = r118;
        r108.top = r118 - r111;
    L44:
        if (r108.top >= r116) goto L47;
        r108.top = r116;
    L47:
        if (r108.bottom <= r118) goto L49;
        r108.bottom = r118;
    L49:
        r100.clear(R.id.expand_view, 3);
        r100.clear(R.id.expand_view, 6);
        r100.clear(R.id.expand_view, 4);
        r100.clear(R.id.expand_view, 7);
        int r119 = 3;
        r100.connect(R.id.expand_view, 6, R.id.group_parent_content, 6, (int) r108.left);
        r100.connect(R.id.expand_view, 3, R.id.group_parent_content, 3, (int) r108.top);
        s(RegionId.A, (int) r114);
        r100.applyTo(this.f527622h);
    L52:
        if (r211 != DraggableComponentState.Style.VERTICAL) goto L107;
        float r120 = this.f527622h.getHeight() * r210.d();
        float r121 = this.f527622h.getWidth() * r210.c();
        RectF r122 = new RectF(r121, r120, r121 + r110, r120 + r111);
        ALogger.d("DraggableComponentView", "rect: " + r122 + ", reginA:" + TuplesKt.to(Integer.valueOf(this.f527627m.getWidth()), Integer.valueOf(this.f527627m.getHeight())) + ", reginB:" + TuplesKt.to(Integer.valueOf(this.f527628n.getWidth()), Integer.valueOf(this.f527628n.getHeight())));
        if (r122.left >= this.f527627m.getLeft()) goto L57;
        r122.left = this.f527627m.getLeft();
        r122.right = this.f527627m.getLeft() + r110;
    L57:
        if (r122.right <= this.f527628n.getRight()) goto L60;
        r122.right = this.f527628n.getRight();
        r122.left = this.f527628n.getRight() - r110;
    L60:
        if (r122.left >= this.f527628n.getLeft()) goto L67;
        if (r122.right <= this.f527628n.getLeft()) goto L67;
        if (r122.bottom <= r112.bottom) goto L67;
        r122.right = this.f527628n.getRight();
        r122.left = this.f527628n.getRight() - r110;
    L67:
        if (r122.left >= this.f527627m.getLeft()) goto L70;
        r122.left = this.f527627m.getLeft();
    L70:
        if (r122.right <= this.f527628n.getRight()) goto L72;
        r122.right = this.f527628n.getRight();
    L72:
        float r123 = r122.right;
        float r124 = r123 - r122.left;
        if (r123 > this.f527628n.getLeft()) goto L75;
    L93:
        float r125 = r122.top;
        float r126 = r112.top;
        if (r125 >= r126) goto L96;
        r122.top = r126;
        r122.bottom = r126 + r111;
    L96:
        float r127 = r122.bottom;
        float r128 = r112.bottom;
        if (r127 <= r128) goto L100;
        r122.bottom = r128;
        r122.top = r128 - r111;
    L100:
        if (r122.top >= r126) goto L103;
        r122.top = r126;
    L103:
        if (r122.bottom <= r128) goto L105;
        r122.bottom = r128;
    L105:
        r100.clear(R.id.expand_view, r119);
        r100.clear(R.id.expand_view, 6);
        r100.clear(R.id.expand_view, 4);
        r100.clear(R.id.expand_view, 7);
        r100.connect(R.id.expand_view, 6, R.id.group_parent_content, 6, (int) r122.left);
        r100.connect(R.id.expand_view, 3, R.id.group_parent_content, 3, (int) r122.top);
        r100.applyTo(this.f527622h);
        s(RegionId.A, (int) r124);
        return;
    L75:
        if (r122.left < this.f527628n.getLeft()) goto L93;
        if (r122.top >= this.f527628n.getTop()) goto L81;
        r122.top = this.f527628n.getTop();
        r122.bottom = this.f527628n.getTop() + r111;
    L81:
        if (r122.bottom <= this.f527628n.getBottom()) goto L84;
        r122.bottom = this.f527628n.getBottom();
        r122.top = this.f527628n.getBottom() - r111;
    L84:
        if (r122.top >= this.f527628n.getTop()) goto L87;
        r122.top = this.f527628n.getTop();
    L87:
        if (r122.bottom <= this.f527628n.getBottom()) goto L90;
        r122.bottom = this.f527628n.getBottom();
    L90:
        if (r122.bottom <= r112.bottom) goto L92;
        s(RegionId.B, (int) r124);
        r100.clear(R.id.expand_view, r119);
        r100.clear(R.id.expand_view, 6);
        r100.clear(R.id.expand_view, 4);
        r100.clear(R.id.expand_view, 7);
        r100.connect(R.id.expand_view, 6, R.id.group_parent_content, 6, (int) r122.left);
        r100.connect(R.id.expand_view, 3, R.id.group_parent_content, 3, (int) r122.top);
        r100.applyTo(this.f527622h);
        return;
    L92:
        s(RegionId.A, (int) r124);
        r100.clear(R.id.expand_view, r119);
        r100.clear(R.id.expand_view, 6);
        r100.clear(R.id.expand_view, 4);
        r100.clear(R.id.expand_view, 7);
        r100.connect(R.id.expand_view, 6, R.id.group_parent_content, 6, (int) r122.left);
        r100.connect(R.id.expand_view, 3, R.id.group_parent_content, 3, (int) r122.top);
        r100.applyTo(this.f527622h);
        return;
    L107:
        return;
    L50:
        r119 = 3;
        goto L52
    L21:
        if (this.f527630p.getSecond().intValue() == 0) goto L23;
        ALogger.d("DraggableComponentView", "expand size: " + this.f527630p);
        r104 = (float) this.f527630p.getFirst().intValue();
        r105 = (float) this.f527630p.getSecond().intValue();
        goto L23
    }
}
