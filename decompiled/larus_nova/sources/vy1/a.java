package vy1;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.android.anya.BaseMVIView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.a0;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.k;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.gift.grouplive.component.GroupComponentState;
import com.bytedance.android.livesdk.gift.grouplive.component.dragger.DraggableContainerView;
import com.bytedance.android.livesdk.gift.grouplive.component.dragger.RegionId;
import com.bytedance.android.livesdk.gift.grouplive.component.l;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.caijing_pay.impl.config.CJHostRouterServiceImpl;
import com.larus.nova.R;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends BaseMVIView<GroupComponentState, com.bytedance.android.livesdk.gift.grouplive.component.c> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ConstraintLayout f557538h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FrameLayout f557539i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DraggableContainerView f557540j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FrameLayout f557541k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FrameLayout f557542l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Space f557543m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Space f557544n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final View f557545o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public zy0.b f557546p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ty1.c f557547q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f557548r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Pair<Integer, Integer> f557549s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f557550t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final CompositeDisposable f557551u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Context f557552v;

    /* JADX INFO: renamed from: vy1.a$a, reason: collision with other inner class name */
    public static final class C8051a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f557553a;

        public b(a r100) {
            this.f557553a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Configuration r101 = (Configuration) r100;
            if (FoldScreenUtils.f() == false) goto L10;
            zy0.b r102 = this.f557553a.f557546p;
            if (r102 == null) goto L11;
            xy0.a<?> r103 = r102.g();
            if (r103 == null) goto L12;
            int r104 = this.f557553a.q();
            this.f557553a.getClass();
            r103.updateScreenMetrics(r104, RangesKt.coerceAtLeast(s1.y(), s1.w()));
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void i() {
        zy0.b r100 = this.f557546p;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f557551u.clear();
        this.f557540j.setDragCallback(null);
        this.f557547q = null;
        this.f557549s = TuplesKt.to(0, 0);
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void g() {
        s((int) (q() * 0.31466666f));
        RxUtilKt.c(((rr2.a) vh6.c.b(rr2.a.class)).fg().subscribe(new b(this)), this.f557551u);
    }

    public final int q() {
        return RangesKt.coerceAtMost(s1.y(), s1.w());
    }

    public final Context getContext() {
        return this.f557552v;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f557552v = r100;
        View r101 = LayoutInflater.from(r100).inflate(R.layout.ttlive_group_live_component_view, null);
        if (r101 == null) goto L7;
        ConstraintLayout r102 = (ConstraintLayout) r101;
        this.f557538h = r102;
        this.f557539i = (FrameLayout) r102.findViewById(R.id.close_view);
        this.f557540j = (DraggableContainerView) r102.findViewById(R.id.expand_view);
        this.f557543m = (Space) r102.findViewById(R.id.region_a);
        this.f557544n = (Space) r102.findViewById(R.id.regin_b);
        this.f557545o = r102.findViewById(R.id.entry_anim_placeholder);
        this.f557549s = TuplesKt.to(0, 0);
        this.f557550t = "";
        this.f557551u = new CompositeDisposable();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final boolean d(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        if ((r100 instanceof l) == false) goto L18;
        zy0.b r101 = this.f557546p;
        if (r101 == null) goto L9;
        xy0.a<?> r102 = r101.g();
        if (r102 == null) goto L9;
        r102.updateScreenMetrics(q(), RangesKt.coerceAtLeast(s1.y(), s1.w()));
    L9:
        zy0.b r103 = this.f557546p;
        if (r103 == null) goto L16;
        xy0.a<?> r104 = r103.g();
        if (r104 == null) goto L16;
        View r105 = r104.getHybridView();
        if (r105 == null) goto L16;
        r105.requestLayout();
    L16:
        l r106 = (l) r100;
        p(r106.f126309a, r106.f126310b, r106.f126311c);
        return true;
    L18:
        return false;
    }

    public final void s(int r100) {
        jy0.b.a("GroupComponentView", "updateRegionBWidth, width:" + r100);
        if (r100 != 0) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r101 = this.f557544n.getLayoutParams();
        int r102 = Math.min((int) (q() * 0.31466666f), r100);
        if (r101.width == r102) goto L9;
        r101.width = r102;
        this.f557544n.setLayoutParams(r101);
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.anya.BaseMVIView
    public final void b(k r110, MVIState r210) {
        GroupComponentState r100 = (GroupComponentState) r210;
        Intrinsics.checkNotNullParameter(r110, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r100, "state");
        r r101 = r100.f126275c;
        KProperty[] r102 = GroupComponentState.f126272j;
        KProperty r103 = r102[2];
        r101.getClass();
        Object r104 = r110.f41740c.a(r101);
        if (r104 == null) goto L22;
        r110.f41739b.f41563a.invoke(r101);
        GroupComponentState.Mode r105 = (GroupComponentState.Mode) r104;
        this.f557542l = this.f557541k;
        if (r105 != GroupComponentState.Mode.EXPAND) goto L14;
        DraggableContainerView r106 = this.f557540j;
        if (r106 == null) goto L9;
        r106.setVisibility(0);
    L9:
        FrameLayout r107 = this.f557539i;
        if (r107 == null) goto L12;
        r107.setVisibility(8);
    L12:
        this.f557541k = this.f557540j;
    L14:
        if (r105 != GroupComponentState.Mode.CLOSE) goto L22;
        DraggableContainerView r108 = this.f557540j;
        if (r108 == null) goto L18;
        r108.setVisibility(8);
    L18:
        FrameLayout r109 = this.f557539i;
        if (r109 == null) goto L21;
        r109.setVisibility(0);
    L21:
        this.f557541k = this.f557539i;
    L22:
        r r111 = r100.f126276d;
        KProperty r112 = r102[3];
        r111.getClass();
        r r113 = r100.f126274b;
        KProperty r114 = r102[1];
        r113.getClass();
        r r115 = r100.f126279g;
        KProperty r116 = r102[6];
        r115.getClass();
        Object r117 = r110.f41740c.a(r111);
        if (r117 == null) goto L25;
        r110.f41739b.f41563a.invoke(r111);
    L26:
        Object r118 = r110.f41740c.a(r113);
        if (r118 == null) goto L29;
        r110.f41739b.f41563a.invoke(r113);
    L30:
        Object r119 = r110.f41740c.a(r115);
        if (r119 == null) goto L33;
        r110.f41739b.f41563a.invoke(r115);
    L34:
        if (r117 != null) goto L37;
        if (r118 != null) goto L37;
        if (r119 != null) goto L37;
    L51:
        r r120 = r100.f126277e;
        KProperty r121 = r102[4];
        r120.getClass();
        r r122 = r100.f126278f;
        KProperty r123 = r102[5];
        r122.getClass();
        r r124 = r100.f126281i;
        KProperty r125 = r102[8];
        r124.getClass();
        Object r126 = r110.f41740c.a(r120);
        if (r126 == null) goto L54;
        r110.f41739b.f41563a.invoke(r120);
    L55:
        Object r127 = r110.f41740c.a(r122);
        if (r127 == null) goto L58;
        r110.f41739b.f41563a.invoke(r122);
    L59:
        Object r128 = r110.f41740c.a(r124);
        if (r128 == null) goto L62;
        r110.f41739b.f41563a.invoke(r124);
    L63:
        if (r126 != null) goto L66;
        if (r127 != null) goto L66;
        if (r128 != null) goto L66;
    L129:
        r r129 = r100.f126273a;
        KProperty r130 = r102[0];
        r129.getClass();
        r r131 = r100.f126274b;
        KProperty r132 = r102[1];
        r131.getClass();
        r r133 = r100.f126279g;
        KProperty r134 = r102[6];
        r133.getClass();
        Object r135 = r110.f41740c.a(r129);
        if (r135 == null) goto L132;
        r110.f41739b.f41563a.invoke(r129);
    L133:
        Object r136 = r110.f41740c.a(r131);
        if (r136 == null) goto L136;
        r110.f41739b.f41563a.invoke(r131);
    L137:
        Object r137 = r110.f41740c.a(r133);
        if (r137 == null) goto L140;
        r110.f41739b.f41563a.invoke(r133);
    L141:
        if (r135 != null) goto L144;
        if (r136 != null) goto L144;
        if (r137 != null) goto L144;
    L159:
        r r138 = r100.f126280h;
        KProperty r139 = r102[7];
        r138.getClass();
        Object r140 = r110.f41740c.a(r138);
        if (r140 == null) goto L163;
        r110.f41739b.f41563a.invoke(r138);
        UtilityKotlinExtentionsKt.v(this.f557538h, ((Boolean) r140).booleanValue());
        return;
    L163:
        return;
    L144:
        if (r135 != null) goto L146;
        r135 = r129.c();
    L146:
        if (r136 != null) goto L148;
        r136 = r131.c();
    L148:
        if (r137 != null) goto L150;
        r137 = r133.c();
    L150:
        int r141 = ((Number) r137).intValue();
        GroupComponentState.Style r142 = (GroupComponentState.Style) r136;
        if (((Boolean) r135).booleanValue() == true) goto L153;
    L155:
        this.f557540j.setDragCallback(null);
    L156:
        RxUtilKt.c(RxUtilKt.g(this.f557540j, true).subscribe(new d(this)), this.f557551u);
        if (((Boolean) qy1.a.f535179d.getValue(null, qy1.a.f535176a[2])).booleanValue() == false) goto L159;
        RxUtilKt.c(RxUtilKt.g(this.f557538h, true).subscribe(new e(this)), this.f557551u);
        goto L159
    L153:
        if (r142 == GroupComponentState.Style.DEFAULT) goto L155;
        ry1.c r143 = new ry1.c();
        ry1.b r144 = new ry1.b(RegionId.A, this.f557543m);
        Intrinsics.checkNotNullParameter(r144, "reg");
        r143.f539895a.add(r144);
        ry1.b r145 = new ry1.b(RegionId.B, this.f557544n);
        Intrinsics.checkNotNullParameter(r145, "reg");
        r143.f539895a.add(r145);
        this.f557540j.setDragCallback(new ry1.a(this.f557540j, r143, new c(this, r142, r141)));
        goto L156
    L140:
        r137 = null;
        goto L141
    L136:
        r136 = null;
        goto L137
    L132:
        r135 = null;
    L66:
        if (r126 != null) goto L68;
        r126 = r120.c();
    L68:
        if (r127 != null) goto L70;
        r127 = r122.c();
    L70:
        if (r128 != null) goto L72;
        r128 = r124.c();
    L72:
        boolean r146 = ((Boolean) r128).booleanValue();
        String r147 = (String) r126;
        LinkedHashMap r148 = new LinkedHashMap();
        String r149 = String.valueOf(System.currentTimeMillis());
        r148.put("container_payload", (String) r127);
        r148.put(EventConstants.ExtraJson.EXTRA_CURRENT_TIMESTAMP, r149);
        r148.put(IPerformanceManager.Params.is_anchor, Boolean.valueOf(r146));
        jy0.b.c("GroupComponentView", "GroupComponentView update Data:" + r149, null, 4);
        if ((!Intrinsics.areEqual(r147, this.f557550t)) == false) goto L124;
        FrameLayout r150 = this.f557542l;
        if (r150 == null) goto L77;
        r150.removeAllViews();
    L77:
        FrameLayout r151 = this.f557541k;
        if (r151 == null) goto L81;
        r151.removeAllViews();
    L81:
        if (r147.length() <= 0) goto L83;
        boolean r152 = true;
    L84:
        if (r152 == true) goto L86;
        zy0.b r153 = this.f557546p;
        if (r153 == null) goto L117;
        r153.dispose();
    L117:
        DraggableContainerView r154 = this.f557540j;
        if (r154 == null) goto L120;
        r154.removeAllViews();
    L120:
        FrameLayout r155 = this.f557539i;
        if (r155 == null) goto L123;
        r155.removeAllViews();
    L123:
        this.f557550t = r147;
        goto L124
    L86:
        if (StringsKt.startsWith$default(r147, "https://", false, 2, null) == false) goto L88;
    L91:
        Uri r156 = x6.a.d(r147);
    L92:
        ReadOnlyProperty r157 = qy1.a.f535180e;
        KProperty<?>[] r158 = qy1.a.f535176a;
        if (((Boolean) r157.getValue(null, r158[3])).booleanValue() == false) goto L95;
        Uri r159 = r156.buildUpon().appendQueryParameter(CJHostRouterServiceImpl.URI_KEY_MIX_CONTAINER_TYPE, ILiveHybridMonitor.ContainerType.ANNIE).build();
    L97:
        if (((Boolean) qy1.a.f535181f.getValue(null, r158[4])).booleanValue() == false) goto L99;
        r159 = r156.buildUpon().appendQueryParameter("fold_service_update", "1").build();
    L99:
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r160 = ((vy0.c) f.a(vy0.c.class)).J8(this.f557552v, r159, null);
        zy0.b r161 = this.f557546p;
        if (r161 == null) goto L102;
        r161.dispose();
    L102:
        this.f557546p = r160;
        if (r160 == null) goto L109;
        FrameLayout r162 = this.f557541k;
        if (r162 == null) goto L107;
        r162.addView((View) r160.f91463d);
        Unit r163 = Unit.INSTANCE;
    L108:
        if (r163 == null) goto L109;
    L110:
        if (r160 == null) goto L123;
        xy0.a<?> r164 = r160.g();
        if (r164 == null) goto L123;
        r164.load(null, r148);
        goto L123
    L107:
        r163 = null;
    L109:
        jy0.b.c("GroupComponentView", "hybrid card create failed!!", null, 4);
        Unit r165 = Unit.INSTANCE;
        goto L110
    L95:
        r159 = r156;
        goto L97
    L88:
        if (StringsKt.startsWith$default(r147, "http://", false, 2, null) == true) goto L91;
        r156 = UriProtector.parse(r147);
        goto L92
    L83:
        r152 = false;
    L124:
        zy0.b r166 = this.f557546p;
        if (r166 == null) goto L129;
        xy0.a<?> r167 = r166.g();
        if (r167 == null) goto L129;
        r167.updateData(r148);
        goto L129
    L62:
        r128 = null;
        goto L63
    L58:
        r127 = null;
        goto L59
    L54:
        r126 = null;
    L37:
        if (r117 != null) goto L39;
        r117 = r111.c();
    L39:
        if (r118 != null) goto L41;
        r118 = r113.c();
    L41:
        if (r119 != null) goto L43;
        r119 = r115.c();
    L43:
        int r168 = ((Number) r119).intValue();
        GroupComponentState.Style r169 = (GroupComponentState.Style) r118;
        ty1.c r170 = (ty1.c) r117;
        this.f557547q = r170;
        if (this.f557538h.getWidth() != 0) goto L46;
    L49:
        this.f557538h.post(new vy1.b(r170, r169, r168, this));
    L50:
        ViewGroup.LayoutParams r171 = this.f557545o.getLayoutParams();
        r171.height = r168;
        this.f557545o.setLayoutParams(r171);
        goto L51
    L46:
        if (this.f557538h.getHeight() == 0) goto L49;
        p(r170, r169, r168);
        goto L50
    L33:
        r119 = null;
        goto L34
    L29:
        r118 = null;
        goto L30
    L25:
        r117 = null;
        goto L26
    }

    public final void r(RegionId r100, int r101) {
        FrameLayout r102 = this.f557541k;
        boolean r103 = true;
        if (r102 != null) goto L5;
    L7:
        boolean r104 = false;
    L9:
        if (r100 == RegionId.B) goto L12;
        r103 = false;
    L12:
        o(new com.bytedance.android.livesdk.gift.grouplive.component.a(r104, r103, r101));
        return;
    L5:
        if (r102.getVisibility() != 0) goto L7;
        r104 = true;
        goto L9
    }

    public final void p(ty1.c r210, GroupComponentState.Style r211, int r212) {
        jy0.b.a("GroupComponentView", "calculate layout: " + r210);
        ConstraintSet r100 = new ConstraintSet();
        r100.clone(this.f557538h);
        r100.setTranslation(R.id.expand_view, 0.0f, 0.0f);
        if (r211 != GroupComponentState.Style.DEFAULT) goto L5;
    L98:
        FrameLayout r101 = this.f557541k;
        if (r101 == null) goto L101;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
    L103:
        if (r102 == null) goto L105;
        r102.width = -2;
    L105:
        if (r102 == null) goto L107;
        r102.height = -2;
    L107:
        r100.clear(R.id.expand_view, 3);
        r100.clear(R.id.expand_view, 6);
        r100.clear(R.id.expand_view, 4);
        r100.clear(R.id.expand_view, 7);
        r100.connect(R.id.expand_view, 3, R.id.group_parent_content, 3);
        r100.connect(R.id.expand_view, 7, R.id.group_parent_content, 7);
        r100.applyTo(this.f557538h);
        return;
    L101:
        r102 = null;
        goto L103
    L5:
        if (r210.c() == 1.0f) goto L7;
    L9:
        float r103 = r210.e() * q();
        float r104 = ((r210.b() / r210.e()) * 2.1653333f) * r103;
        if (this.f557549s.getFirst().intValue() != 0) goto L12;
    L14:
        float r110 = r103;
        float r111 = r104;
        Rect r112 = new Rect();
        r112.left = this.f557543m.getLeft();
        r112.top = this.f557543m.getTop();
        r112.bottom = this.f557538h.getHeight() - r212;
        r112.right = this.f557543m.getRight();
        if (r211 != GroupComponentState.Style.HORIZONTAL) goto L43;
        float r105 = (this.f557538h.getHeight() - r212) * r210.d();
        float r106 = this.f557538h.getWidth() * r210.c();
        RectF r107 = new RectF(r106, r105, r106 + r110, r105 + r111);
        if (r107.left >= this.f557543m.getLeft()) goto L20;
        float r108 = this.f557543m.getLeft();
        r107.left = r108;
        r107.right = r108 + r110;
    L20:
        if (r107.right <= this.f557543m.getRight()) goto L23;
        float r109 = this.f557543m.getRight();
        r107.right = r109;
        r107.left = r109 - r110;
    L23:
        if (r107.left >= this.f557543m.getLeft()) goto L26;
        r107.left = this.f557543m.getLeft();
    L26:
        if (r107.right <= this.f557543m.getRight()) goto L28;
        r107.right = this.f557543m.getRight();
    L28:
        float r113 = r107.right - r107.left;
        float r114 = r107.top;
        int r115 = r112.top;
        if (r114 >= r115) goto L31;
        float r116 = r115;
        r107.top = r116;
        r107.bottom = r116 + r111;
    L31:
        float r117 = r107.bottom;
        int r118 = r112.bottom;
        if (r117 <= r118) goto L35;
        r107.bottom = r118;
        r107.top = r118 - r111;
    L35:
        if (r107.top >= r115) goto L38;
        r107.top = r115;
    L38:
        if (r107.bottom <= r118) goto L40;
        r107.bottom = r118;
    L40:
        r100.clear(R.id.expand_view, 3);
        r100.clear(R.id.expand_view, 6);
        r100.clear(R.id.expand_view, 4);
        r100.clear(R.id.expand_view, 7);
        r100.connect(R.id.expand_view, 6, R.id.group_parent_content, 6, (int) r107.left);
        r100.connect(R.id.expand_view, 3, R.id.group_parent_content, 3, (int) r107.top);
        r(RegionId.A, (int) r113);
        r100.applyTo(this.f557538h);
    L43:
        if (r211 != GroupComponentState.Style.VERTICAL) goto L109;
        float r119 = this.f557538h.getHeight() * r210.d();
        float r120 = this.f557538h.getWidth() * r210.c();
        RectF r121 = new RectF(r120, r119, r120 + r110, r119 + r111);
        jy0.b.a("GroupComponentView", "rect: " + r121 + ", reginA:" + TuplesKt.to(Integer.valueOf(this.f557543m.getWidth()), Integer.valueOf(this.f557543m.getHeight())) + ", reginB:" + TuplesKt.to(Integer.valueOf(this.f557544n.getWidth()), Integer.valueOf(this.f557544n.getHeight())));
        if (r121.left >= this.f557543m.getLeft()) goto L48;
        r121.left = this.f557543m.getLeft();
        r121.right = this.f557543m.getLeft() + r110;
    L48:
        if (r121.right <= this.f557544n.getRight()) goto L51;
        r121.right = this.f557544n.getRight();
        r121.left = this.f557544n.getRight() - r110;
    L51:
        if (r121.left >= this.f557544n.getLeft()) goto L58;
        if (r121.right <= this.f557544n.getLeft()) goto L58;
        if (r121.bottom <= r112.bottom) goto L58;
        r121.right = this.f557544n.getRight();
        r121.left = this.f557544n.getRight() - r110;
    L58:
        if (r121.left >= this.f557543m.getLeft()) goto L61;
        r121.left = this.f557543m.getLeft();
    L61:
        if (r121.right <= this.f557544n.getRight()) goto L63;
        r121.right = this.f557544n.getRight();
    L63:
        float r122 = r121.right;
        float r123 = r122 - r121.left;
        if (r122 > this.f557544n.getLeft()) goto L66;
    L84:
        float r124 = r121.top;
        int r125 = r112.top;
        if (r124 >= r125) goto L87;
        float r126 = r125;
        r121.top = r126;
        r121.bottom = r126 + r111;
    L87:
        float r127 = r121.bottom;
        int r128 = r112.bottom;
        if (r127 <= r128) goto L91;
        r121.bottom = r128;
        r121.top = r128 - r111;
    L91:
        if (r121.top >= r125) goto L94;
        r121.top = r125;
    L94:
        if (r121.bottom <= r128) goto L96;
        r121.bottom = r128;
    L96:
        r100.clear(R.id.expand_view, 3);
        r100.clear(R.id.expand_view, 6);
        r100.clear(R.id.expand_view, 4);
        r100.clear(R.id.expand_view, 7);
        r100.connect(R.id.expand_view, 6, R.id.group_parent_content, 6, (int) r121.left);
        r100.connect(R.id.expand_view, 3, R.id.group_parent_content, 3, (int) r121.top);
        r100.applyTo(this.f557538h);
        r(RegionId.A, (int) r123);
        return;
    L66:
        if (r121.left < this.f557544n.getLeft()) goto L84;
        if (r121.top >= this.f557544n.getTop()) goto L72;
        r121.top = this.f557544n.getTop();
        r121.bottom = this.f557544n.getTop() + r111;
    L72:
        if (r121.bottom <= this.f557544n.getBottom()) goto L75;
        r121.bottom = this.f557544n.getBottom();
        r121.top = this.f557544n.getBottom() - r111;
    L75:
        if (r121.top >= this.f557544n.getTop()) goto L78;
        r121.top = this.f557544n.getTop();
    L78:
        if (r121.bottom <= this.f557544n.getBottom()) goto L81;
        r121.bottom = this.f557544n.getBottom();
    L81:
        if (r121.bottom <= r112.bottom) goto L83;
        r(RegionId.B, (int) r123);
        r100.clear(R.id.expand_view, 3);
        r100.clear(R.id.expand_view, 6);
        r100.clear(R.id.expand_view, 4);
        r100.clear(R.id.expand_view, 7);
        r100.connect(R.id.expand_view, 6, R.id.group_parent_content, 6, (int) r121.left);
        r100.connect(R.id.expand_view, 3, R.id.group_parent_content, 3, (int) r121.top);
        r100.applyTo(this.f557538h);
        return;
    L83:
        r(RegionId.A, (int) r123);
        r100.clear(R.id.expand_view, 3);
        r100.clear(R.id.expand_view, 6);
        r100.clear(R.id.expand_view, 4);
        r100.clear(R.id.expand_view, 7);
        r100.connect(R.id.expand_view, 6, R.id.group_parent_content, 6, (int) r121.left);
        r100.connect(R.id.expand_view, 3, R.id.group_parent_content, 3, (int) r121.top);
        r100.applyTo(this.f557538h);
        return;
    L109:
        return;
    L12:
        if (this.f557549s.getSecond().intValue() == 0) goto L14;
        jy0.b.a("GroupComponentView", "expand size: " + this.f557549s);
        r103 = (float) this.f557549s.getFirst().intValue();
        r104 = (float) this.f557549s.getSecond().intValue();
        goto L14
    L7:
        if (r210.d() != 0.0f) goto L9;
        goto L9
    }
}
