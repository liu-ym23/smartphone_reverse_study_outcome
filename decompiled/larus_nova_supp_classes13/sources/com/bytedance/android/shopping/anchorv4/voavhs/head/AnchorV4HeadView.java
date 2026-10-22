package com.bytedance.android.shopping.anchorv4.voavhs.head;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.anchorv3.detail.widget.ECAnchorHeaderFrameLayout;
import com.bytedance.android.shopping.anchorv3.detail.widget.ECHorizontalScrollView;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.HeadViewHolderBuilder;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.HeadViewType;
import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4DownTabIndicator;
import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4HeadIndicator;
import com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.AnchorV4SmallTransition;
import com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.TransSmallComponent;
import com.bytedance.android.shopping.anchorv4.voavhs.head.view.AnchorV4FindSameView;
import com.bytedance.android.shopping.anchorv4.voavhs.headbottom.AnchorV4HeadBottomView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeadScrollStateManager;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.google.gson.internal.LinkedTreeMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class AnchorV4HeadView extends FrameLayout {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public AnchorV4HeadVO g;
    public AnchorV4VM h;
    public LinkedTreeMap<String, Object> i;
    public List<com.bytedance.android.shopping.anchorv4.voavhs.head.b> j;
    public SlcRenderContext k;
    public final Lazy l;

    public static final class a {
    }

    public static final class b implements l {
        public final /* synthetic */ AnchorV4HeadView a;
        public final /* synthetic */ AnchorV4VM b;
        public final /* synthetic */ List c;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.l
        public final void b() {
            AnchorV4HeadView.c(this.a).setVisibility(0);
            AnchorV4HeadView.c(this.a).setAlpha(1.0f);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.l
        public final void c(float r3) {
            AnchorV4VM r0 = this.b;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.isEnablePlayBackEntryAlphaTrans() != true) goto L12;
            AnchorV4HeadView.c(this.a).setAlpha(1 - r3);
            if (AnchorV4HeadView.c(this.a).getAlpha() >= 0.01f) goto L9;
            AnchorV4HeadView.c(this.a).setVisibility(8);
            return;
        L9:
            AnchorV4HeadView.c(this.a).setVisibility(0);
            return;
        }

        public b(AnchorV4HeadView r1, AnchorV4VM r2, List r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    private final FrameLayout getDownTabIndicatorContainer() {
        return (FrameLayout) this.c.getValue();
    }

    private final View getFlBack() {
        return (View) this.e.getValue();
    }

    private final AnchorV4HeadBottomView getHeadBottomView() {
        return (AnchorV4HeadBottomView) this.f.getValue();
    }

    private final FrameLayout getIndicatorsContainer() {
        return (FrameLayout) this.b.getValue();
    }

    private final LinearLayout getLlFloatButtonElements() {
        return (LinearLayout) this.d.getValue();
    }

    private final SlidesAndIndicatorV4Component getSlidesAndIndicatorComponent() {
        return (SlidesAndIndicatorV4Component) this.l.getValue();
    }

    private final FrameLayout getSlidesContainer() {
        return (FrameLayout) this.a.getValue();
    }

    public final boolean update(AnchorV4HeadVO r1, List<com.bytedance.android.shopping.anchorv4.voavhs.head.b> r2, AnchorV4VM r3, LinkedTreeMap<String, Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "headNodeGroupList");
        return false;
    }

    public final d83.b getHeaderAbility() {
        return getSlidesAndIndicatorComponent();
    }

    public final void h() {
        SlidesAndIndicatorV4Component r0 = getSlidesAndIndicatorComponent();
        AnchorV4HeadViewPager r1 = r0.e;
        if (r1 == null) goto L7;
        HeadViewHolderBuilder r2 = r1.g;
        if (r2 == null) goto L7;
        r2.d();
    L7:
        TransSmallComponent r3 = r0.q;
        if (r3 == null) goto L13;
        HeadViewHolderBuilder r4 = r3.e;
        if (r4 == null) goto L14;
        r4.d();
        return;
    L14:
        return;
    }

    public final void i() {
        SlidesAndIndicatorV4Component r0 = getSlidesAndIndicatorComponent();
        AnchorV4HeadViewPager r1 = r0.e;
        if (r1 == null) goto L7;
        HeadViewHolderBuilder r2 = r1.g;
        if (r2 == null) goto L7;
        r2.e();
    L7:
        TransSmallComponent r3 = r0.q;
        if (r3 == null) goto L13;
        HeadViewHolderBuilder r4 = r3.e;
        if (r4 == null) goto L14;
        r4.e();
        return;
    L14:
        return;
    }

    public final void j() {
        SlidesAndIndicatorV4Component r0 = getSlidesAndIndicatorComponent();
        AnchorV4HeadViewPager r1 = r0.e;
        if (r1 == null) goto L7;
        HeadViewHolderBuilder r2 = r1.g;
        if (r2 == null) goto L7;
        r2.f();
    L7:
        TransSmallComponent r3 = r0.q;
        if (r3 == null) goto L13;
        HeadViewHolderBuilder r4 = r3.e;
        if (r4 == null) goto L14;
        r4.f();
        return;
    L14:
        return;
    }

    public final void k() {
        if (getSlidesAndIndicatorComponent().p == false) goto L6;
        System.currentTimeMillis();
        return;
    }

    public final void l() {
        getSlidesAndIndicatorComponent().getClass();
    }

    public final SlcRenderContext getSlcRenderContext() {
        return this.k;
    }

    public AnchorV4HeadView(final Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.a = LazyKt.lazy(new AnchorV4HeadView$slidesContainer$2(this));
        this.b = LazyKt.lazy(new AnchorV4HeadView$indicatorsContainer$2(this));
        this.c = LazyKt.lazy(new AnchorV4HeadView$downTabIndicatorContainer$2(this));
        this.d = LazyKt.lazy(new AnchorV4HeadView$llFloatButtonElements$2(this));
        this.e = LazyKt.lazy(new AnchorV4HeadView$flBack$2(this));
        this.f = LazyKt.lazy(new AnchorV4HeadView$headBottomView$2(this));
        this.j = CollectionsKt.emptyList();
        this.l = LazyKt.lazy(new AnchorV4HeadView$slidesAndIndicatorComponent$2(this, r3));
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r3).aU(2131560610, this, true);
        getFlBack().setOnClickListener(new e(this));
    }

    public static final /* synthetic */ FrameLayout a(AnchorV4HeadView r0) {
        return r0.getDownTabIndicatorContainer();
    }

    public static final /* synthetic */ FrameLayout b(AnchorV4HeadView r0) {
        return r0.getIndicatorsContainer();
    }

    public static final /* synthetic */ LinearLayout c(AnchorV4HeadView r0) {
        return r0.getLlFloatButtonElements();
    }

    public static final /* synthetic */ SlidesAndIndicatorV4Component d(AnchorV4HeadView r0) {
        return r0.getSlidesAndIndicatorComponent();
    }

    public static final /* synthetic */ FrameLayout e(AnchorV4HeadView r0) {
        return r0.getSlidesContainer();
    }

    public final void f(boolean r9) {
        TransSmallComponent r0 = getSlidesAndIndicatorComponent().q;
        if (r0 == null) goto L21;
        r0.d.c(r9);
        if (r0.a == true) goto L22;
        AnchorV4SmallTransition r10 = r0.d;
        int r1 = r10.k.h().getScrollX();
        Iterator<T> r11 = r10.a().iterator();
        int r3 = 0;
        int r4 = 0;
    L8:
        if (r11.hasNext() == false) goto L16;
        View r5 = (View) r11.next();
        if (r5.getX() > 0) goto L13;
        r3 = r3 + 1;
    L13:
        if (r1 <= r5.getX()) goto L17;
        r4 = r4 + 1;
    L17:
        r0.p.setCurrentItem(r4 - r3, false);
        return;
    L16:
        r4 = 0;
        goto L17
    L22:
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void m(float r14) {
        getFlBack().setAlpha(1 - r14);
        SlidesAndIndicatorV4Component r0 = getSlidesAndIndicatorComponent();
        AnchorV4HeadViewPager r2 = r0.e;
        if (r2 == null) goto L7;
        r2.m = r14;
        HeadViewHolderBuilder r3 = r2.g;
        if (r3 == null) goto L7;
        r3.g(r14);
    L7:
        TransSmallComponent r1 = r0.q;
        if (r1 != null) goto L10;
        return;
    L10:
        if (r14 >= 0) goto L13;
        return;
    L13:
        if (r14 != 1.0f) goto L15;
        boolean r4 = true;
    L16:
        boolean r5 = r1.a;
        if (r5 == r4) goto L42;
        com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.c r6 = r1.g;
        if (r6 == null) goto L33;
        if (r5 == false) goto L27;
        HeadViewHolderBuilder r7 = r6.d;
        if (r7 == null) goto L33;
        Iterator r8 = ((ArrayList) r7.a.j).iterator();
    L25:
        if (r8.hasNext() == false) goto L33;
        ((com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.b) r8.next()).b();
        goto L25
    L27:
        HeadViewHolderBuilder r9 = r6.c;
        if (r9 == null) goto L33;
        Iterator r10 = ((ArrayList) r9.a.j).iterator();
    L31:
        if (r10.hasNext() == false) goto L33;
        ((com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.b) r10.next()).b();
    L33:
        com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.c r11 = r1.g;
        if (r11 == null) goto L42;
        if (r4 == false) goto L39;
        HeadViewHolderBuilder r12 = r11.d;
        if (r12 == null) goto L42;
        r12.h(r11.a);
        goto L42
    L39:
        HeadViewHolderBuilder r13 = r11.c;
        if (r13 == null) goto L42;
        r13.h(r11.a);
    L42:
        r1.a = r4;
        ViewPager r15 = r1.p;
        if (r4 == false) goto L45;
        int r16 = 0;
    L46:
        r15.setVisibility(r16);
        ECHorizontalScrollView r17 = r1.b;
        if (r4 == false) goto L49;
        int r18 = 8;
    L50:
        r17.setVisibility(r18);
        if (r1.a == true) goto L146;
        AnchorV4SmallTransition r19 = r1.d;
        if (r19.j == r14) goto L146;
        r19.j = r14;
        List<com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a> r20 = r19.a;
        if (r20 != null) goto L58;
    L61:
        boolean r21 = true;
    L62:
        if (r21 == true) goto L146;
        if (r19.a().size() != ((ArrayList) r19.a).size()) goto L146;
        ViewGroup.LayoutParams r22 = r19.k.h().getLayoutParams();
        int r23 = r19.f;
        r22.height = (int) (r23 + ((r19.g - r23) * r14));
        Iterator<T> r24 = r19.a().iterator();
        int r25 = 0;
    L68:
        if (r24.hasNext() == false) goto L134;
        View r26 = (View) r24.next();
        r26.setX(((com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a) ListProtector.get(r19.a, r25)).a + ((((com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a) ListProtector.get(r19.b, r25)).a - ((com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a) ListProtector.get(r19.a, r25)).a) * r14));
        r26.setY(((com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a) ListProtector.get(r19.a, r25)).b + ((((com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a) ListProtector.get(r19.b, r25)).b - ((com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a) ListProtector.get(r19.a, r25)).b) * r14));
        ViewGroup.LayoutParams r27 = r26.getLayoutParams();
        if (r27 == null) goto L72;
        r27.width = (int) (((com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a) ListProtector.get(r19.a, r25)).c + ((((com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a) ListProtector.get(r19.b, r25)).c - ((com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a) ListProtector.get(r19.a, r25)).c) * r14));
        r27.height = (int) (((com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a) ListProtector.get(r19.a, r25)).d + ((((com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a) ListProtector.get(r19.b, r25)).d - ((com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a) ListProtector.get(r19.a, r25)).d) * r14));
        r26.setLayoutParams(r27);
    L72:
        ECHorizontalScrollView r28 = r19.k.h();
        int r29 = r19.c;
        r28.setScrollX((int) (r29 + ((r19.d - r29) * r14)));
        if (j.a() == false) goto L98;
        View r30 = (View) CollectionsKt.firstOrNull(com.bytedance.commerce.base.view.b.a(r26));
        if (r30 == null) goto L118;
        List r31 = com.bytedance.commerce.base.view.b.a(r30);
        if (r31 == null) goto L118;
        Iterator r32 = r31.iterator();
    L80:
        if (r32.hasNext() == false) goto L84;
        Object r33 = r32.next();
        if ((((View) r33) instanceof AnchorV4FindSameView) == false) goto L80;
    L85:
        View r34 = (View) r33;
        if (r34 == null) goto L118;
        List r35 = com.bytedance.commerce.base.view.b.a(r34);
        if (r35 == null) goto L118;
        if (r35.size() <= 3) goto L92;
        boolean r36 = true;
    L93:
        if (r36 == true) goto L96;
        r35 = null;
    L96:
        if (r35 == null) goto L118;
        List r37 = r35.subList(0, 4);
    L119:
        if (r37 == null) goto L132;
        Iterator r38 = r37.iterator();
    L122:
        if (r38.hasNext() == false) goto L132;
        View r39 = (View) r38.next();
        int r110 = (r19.k.c() - com.bytedance.android.shopping.extensions.b.b(8)) / 2;
        Integer r111 = Integer.valueOf((int) (((com.bytedance.android.shopping.extensions.b.b(128) - r110) * r14) + r110));
        if (r111.intValue() <= r110) goto L126;
        boolean r112 = true;
    L127:
        if (r112 == true) goto L130;
        r111 = null;
    L130:
        if (r111 == null) goto L122;
        int r113 = r111.intValue();
        r39.getLayoutParams().width = r113;
        r39.getLayoutParams().height = r113;
        goto L122
    L126:
        r112 = false;
    L132:
        r25 = r25 + 1;
        goto L68
    L92:
        r36 = false;
        goto L93
    L84:
        r33 = null;
    L118:
        r37 = null;
        goto L119
    L98:
        Iterator r40 = com.bytedance.commerce.base.view.b.a(r26).iterator();
    L100:
        if (r40.hasNext() == false) goto L104;
        Object r41 = r40.next();
        if ((((View) r41) instanceof AnchorV4FindSameView) == false) goto L100;
    L105:
        View r42 = (View) r41;
        if (r42 == null) goto L118;
        List r43 = com.bytedance.commerce.base.view.b.a(r42);
        if (r43 == null) goto L118;
        if (r43.size() <= 3) goto L112;
        boolean r44 = true;
    L113:
        if (r44 == true) goto L116;
        r43 = null;
    L116:
        if (r43 == null) goto L118;
        r37 = r43.subList(0, 4);
        goto L119
    L112:
        r44 = false;
        goto L113
    L104:
        r41 = null;
        goto L105
    L134:
        if (r14 != 0.0f) goto L140;
        ECAnchorHeaderFrameLayout r45 = r19.k.f();
        if (r45 == null) goto L139;
        r45.setFixedWidth(Integer.valueOf(r19.e));
    L143:
        r19.k.g();
        goto L146
    L139:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv3.detail.widget.ECAnchorHeaderFrameLayout");
    L140:
        ECAnchorHeaderFrameLayout r46 = r19.k.f();
        if (r46 == null) goto L145;
        r46.setFixedWidth(Integer.valueOf(r19.h));
        goto L143
    L145:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv3.detail.widget.ECAnchorHeaderFrameLayout");
    L58:
        if (((ArrayList) r20).isEmpty() == true) goto L61;
        r21 = false;
    L146:
        HeadViewHolderBuilder r47 = r1.e;
        if (r47 == null) goto L149;
        r47.g(r14);
    L149:
        f83.p r114 = r1.p.getTabLogicInterceptor();
        if (r114 == null) goto L173;
        Function0<f83.l> r115 = r114.d;
        if (r115 == null) goto L174;
        f83.l r116 = (f83.l) r115.invoke();
        if (r116 == null) goto L175;
        r116.h(r1.a);
        return;
    L175:
        return;
    L174:
        return;
    L173:
        return;
    L49:
        r18 = 0;
        goto L50
    L45:
        r16 = 8;
        goto L46
    L15:
        r4 = false;
        goto L16
    }

    public final void n(boolean r2) {
        AnchorV4HeadViewPager r0 = getSlidesAndIndicatorComponent().e;
        if (r0 == null) goto L6;
        r0.l(r2);
        return;
    }

    public final void setSlcRenderContext(SlcRenderContext r1) {
        this.k = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v17, types: [android.view.View, com.bytedance.android.shopping.anchorv4.voavhs.head.AnchorV4HeadViewPager] */
    /* JADX WARN: Type inference failed for: r3v22, types: [android.view.ViewGroup, com.bytedance.android.shopping.anchorv4.voavhs.head.AnchorV4HeadViewPager] */
    public final void g(AnchorV4HeadVO r28, final List<com.bytedance.android.shopping.anchorv4.voavhs.head.b> r29, TagsScrollBoxComponent r30, final AnchorV4VM r31, com.bytedance.android.shopping.anchorv4.vm.i r32, l53.b r33, LinkedTreeMap<String, Object> r34, final HeadBusinessMeta r35) {
        Intrinsics.checkNotNullParameter(r29, "headNodeGroupList");
        Intrinsics.checkNotNullParameter(r32, "pathParams");
        Intrinsics.checkNotNullParameter(r33, "collisionNegotiator");
        AnchorV4HeadVO r1 = this.g;
        if (r1 == null) goto L29;
        ComponentDTO r2 = r1.getComponent();
        if (r2 == null) goto L9;
        VO r3 = r2.getVo();
        if (r3 == null) goto L9;
        String r4 = r3.getDisplayMd5();
    L10:
        if (r4 == null) goto L29;
        ComponentDTO r5 = r1.getComponent();
        if (r5 == null) goto L16;
        VO r6 = r5.getVo();
        if (r6 == null) goto L16;
        String r7 = r6.getDisplayMd5();
    L17:
        if (r28 == null) goto L23;
        ComponentDTO r8 = r28.getComponent();
        if (r8 == null) goto L23;
        VO r9 = r8.getVo();
        if (r9 == null) goto L23;
        String r10 = r9.getDisplayMd5();
    L25:
        if (Intrinsics.areEqual(r7, r10) == false) goto L29;
        if (update(r28, r29, r31, r34) == false) goto L29;
        return;
    L23:
        r10 = null;
    L16:
        r7 = null;
    L9:
        r4 = null;
    L29:
        if (r28 == null) goto L31;
        this.g = r28;
    L31:
        this.h = r31;
        this.i = r34;
        SlidesAndIndicatorV4Component r0 = getSlidesAndIndicatorComponent();
        if (r28 == null) goto L34;
        CommonFindSameElement r11 = r28.getFindSameEntryElement();
    L35:
        r0.i = r11;
        final SlidesAndIndicatorV4Component r14 = getSlidesAndIndicatorComponent();
        if (r31 == null) goto L38;
        com.bytedance.android.shopping.anchorv4.containers.e r12 = r31.commentAbility();
    L39:
        r14.a = r12;
        if (r31 == null) goto L42;
        com.bytedance.android.shopping.anchorv4.containers.i r13 = r31.showAbility();
    L43:
        r14.b = r13;
        r14.c = new AnchorV4HeadView$bind$$inlined$apply$lambda$1(r14, this, r31, r35, r29);
        r14.d = new b(this, r31, r29);
        List<com.bytedance.android.shopping.anchorv4.voavhs.head.b> r15 = this.j;
        this.j = r29;
        if (r15.size() != r29.size()) goto L50;
        int r16 = r15.size();
        int r17 = 0;
    L47:
        if (r17 >= r16) goto L52;
        if ((!Intrinsics.areEqual(((com.bytedance.android.shopping.anchorv4.voavhs.head.b) ListProtector.get(r15, r17)).a(), ((com.bytedance.android.shopping.anchorv4.voavhs.head.b) ListProtector.get(r29, r17)).a())) == true) goto L50;
        r17 = r17 + 1;
        goto L47
    L52:
        boolean r18 = false;
    L53:
        if (r18 == false) goto L214;
        AnchorV4VM r19 = this.h;
        if (r19 == null) goto L61;
        AnchorV4Param r20 = r19.getAnchorV4Param();
        if (r20 == null) goto L61;
        V4NativeParams r21 = r20.getNativeParams();
        if (r21 == null) goto L61;
        String r22 = r21.getCovImageUri();
    L62:
        if (r22 != null) goto L64;
    L67:
        boolean r23 = true;
    L69:
        if (r23 == true) goto L103;
        ArrayList r24 = new ArrayList();
        Iterator<com.bytedance.android.shopping.anchorv4.voavhs.head.b> r110 = r29.iterator();
    L72:
        if (r110.hasNext() == false) goto L74;
        r24.addAll(r110.next().c);
        goto L72
    L74:
        Iterator r25 = r24.iterator();
        int r111 = 0;
    L76:
        if (r25.hasNext() == false) goto L91;
        c r112 = (c) r25.next();
        if (r112.getType() != HeadViewType.PICTURE.getType()) goto L87;
        ECUrlModel r26 = r112.b;
        if (r26 == null) goto L83;
        String r27 = r26.getUri();
        if (r27 == null) goto L83;
    L85:
        if (TextUtils.equals(r27, r22) == false) goto L87;
        boolean r36 = true;
    L88:
        if (r36 == true) goto L92;
        r111 = r111 + 1;
    L92:
        if (r111 >= 0) goto L102;
        int r37 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r38 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.h);
        if (r38 == null) goto L102;
        Pair[] r39 = new Pair[1];
        AnchorV4VM r40 = this.h;
        if (r40 == null) goto L100;
        CommonMeta r41 = r40.commonMeta();
        if (r41 == null) goto L100;
        String r42 = r41.getProductId();
    L101:
        r39[0] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r42);
        r38.c = MapsKt.hashMapOf(r39);
        AnchorV4TrackerImpl.b(r38, "product_preview_dismatch", false, null, false, null, 30);
    L100:
        r42 = null;
    L102:
        Integer r43 = Integer.valueOf(r111);
    L104:
        final SlidesAndIndicatorV4Component r44 = getSlidesAndIndicatorComponent();
        Context r45 = getContext();
        if (r28 == null) goto L107;
        String r46 = r28.getHeadTabBgColor();
    L108:
        if (r28 == null) goto L110;
        boolean r210 = r28.getHeadTabExpand();
    L111:
        r44.getClass();
        Intrinsics.checkNotNullParameter(r45, "context");
        r44.t = r33;
        r44.r = r43;
        AnchorV4HeadIndicator r113 = new AnchorV4HeadIndicator(r44.w.getContext(), null, 0, (f83.p) r44.o.getValue(), r44.y, r44.i, r210, 6);
        r44.w.removeAllViews();
        r44.w.addView(r113, new FrameLayout.LayoutParams(-1, -2));
        Unit r47 = Unit.INSTANCE;
        r44.k = r113;
        r44.m = r113;
        AnchorV4DownTabIndicator r48 = new AnchorV4DownTabIndicator(r44.w.getContext(), null, 0, (f83.p) r44.o.getValue(), r44.y, r44.i, r46, r44.x, 6);
        r44.x.removeAllViews();
        FrameLayout r49 = r44.x;
        FrameLayout.LayoutParams r114 = new FrameLayout.LayoutParams(-1, -2);
        r114.gravity = 17;
        r49.addView(r48, r114);
        if (r46 == null) goto L114;
        r44.x.setBackgroundColor(ColorProtector.parseColor(r46));
    L114:
        r44.l = r48;
        AnchorV4HeadIndicator r50 = r44.k;
        if (r50 != null) goto L117;
        Intrinsics.throwUninitializedPropertyAccessException("headTabIndicator");
    L117:
        r44.f = new f83.k(r50);
        ?? r51 = new AnchorV4HeadViewPager(r45, null, (f83.p) r44.o.getValue(), r44.s, r44.f, 2);
        r44.e = r51;
        r44.v.addView(r51, new FrameLayout.LayoutParams(-1, -1));
        final AnchorV4HeadViewPager r52 = r44.e;
        if (r52 == null) goto L120;
        final Function1<Integer, Unit> r53 = new SlidesAndIndicatorV4Component$injectAndConfigPossibleViewPager$3(r44);
        final Function2<Integer, Integer, Unit> r54 = new SlidesAndIndicatorV4Component$injectAndConfigPossibleViewPager$4(r44);
        Intrinsics.checkNotNullParameter(r53, "listener");
        Intrinsics.checkNotNullParameter(r54, "pageScrollListener");
        r52.addOnPageChangeListener(new AnchorV4HeadViewPager$setOnScrollBeginListener$1(r52, r54, r53));
    L120:
        AnchorV4HeadViewPager r55 = r44.e;
        if (r55 == null) goto L123;
        r55.setOnHolderIndicatorChangedListener(r44.n);
    L123:
        AnchorV4HeadViewPager r56 = r44.e;
        if (r56 == null) goto L129;
        if (r33 == null) goto L128;
        r56.setCollisionNegotiator(r33);
        goto L129
    L128:
        throw new IllegalStateException("Required value was null.".toString());
    L129:
        AnchorV4VM r57 = (AnchorV4VM) r44.E.invoke();
        if (r57 == null) goto L135;
        HeadScrollStateManager r58 = r57.getHeadScrollStateManager();
        if (r58 == null) goto L135;
        r58.g = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.o) r44.u.getValue();
    L135:
        if (com.bytedance.android.shopping.anchorv4.video.float.e.b() == false) goto L142;
        FrameLayout r59 = getIndicatorsContainer();
        ViewGroup.LayoutParams r60 = r59.getLayoutParams();
        if ((r60 instanceof ViewGroup.MarginLayoutParams) == true) goto L139;
        r60 = null;
    L139:
        ViewGroup.MarginLayoutParams r61 = (ViewGroup.MarginLayoutParams) r60;
        if (r61 == null) goto L156;
        r61.bottomMargin = com.bytedance.android.shopping.extensions.b.b(28) - com.bytedance.android.shopping.extensions.b.b(12);
        r59.setLayoutParams(r61);
    L156:
        SlidesAndIndicatorV4Component r62 = getSlidesAndIndicatorComponent();
        boolean r63 = r32.a;
        ?? r64 = r62.e;
        if (com.bytedance.android.shopping.anchorv3.detail.utils.a.a() == false) goto L161;
        if (r64 == 0) goto L161;
        if (r63 == true) goto L161;
        TransSmallComponent r65 = new TransSmallComponent(r62.w.getContext(), r64, r62.s);
        r62.q = r65;
        r62.v.addView(r65.b, new FrameLayout.LayoutParams(-1, -1));
        r64.setVisibility(8);
    L161:
        SlidesAndIndicatorV4Component r66 = getSlidesAndIndicatorComponent();
        boolean r67 = r32.a;
        r66.getClass();
        Intrinsics.checkNotNullParameter(r29, "headNodeGroupList");
        r66.g = r29;
        r66.j = r67;
        r66.x.post(new v(r66));
        if (j.a() == true) goto L164;
    L166:
        AnchorV4HeadViewPager r68 = r66.e;
        if (r68 == null) goto L169;
        r68.m(r29);
    L169:
        TransSmallComponent r69 = r66.q;
        if (r69 == null) goto L173;
        r69.m(r29, r66.t);
    L173:
        if (com.bytedance.android.ec.core.opt.ab.w.a() != 1) goto L175;
        boolean r70 = true;
    L176:
        if (r70 == false) goto L198;
        AnchorV4HeadViewPager r71 = r66.e;
        if (r71 == null) goto L180;
        PagerAdapter r72 = r71.getAdapter();
    L182:
        if ((r72 instanceof AnchorV4HeadViewAdapter) == true) goto L184;
        r72 = null;
    L184:
        AnchorV4HeadViewAdapter r73 = (AnchorV4HeadViewAdapter) r72;
        if (r73 == null) goto L198;
        if (r73.b == (-1)) goto L189;
        boolean r74 = true;
    L190:
        if (r74 == true) goto L198;
        Integer r75 = r66.r;
        if (r75 == null) goto L194;
        int r76 = r75.intValue();
    L195:
        if (r76 >= 0) goto L197;
        r76 = 0;
    L197:
        ((f83.p) r66.o.getValue()).b(r76, true);
        goto L198
    L194:
        r76 = 0;
        goto L195
    L189:
        r74 = false;
        goto L190
    L180:
        r72 = null;
    L198:
        AnchorV4HeadViewPager r77 = getSlidesAndIndicatorComponent().e;
        if (r77 == null) goto L201;
        int r78 = r77.getTotalBuilderCount();
    L202:
        if (r43 == null) goto L214;
        int r79 = r43.intValue();
        if (r79 < 0) goto L208;
        if (r78 <= r79) goto L208;
        boolean r80 = true;
    L209:
        if (r80 == false) goto L211;
        Integer r81 = r43;
    L212:
        if (r81 == null) goto L214;
        r81.intValue();
        getSlidesAndIndicatorComponent().m(r43.intValue());
        goto L214
    L211:
        r81 = null;
    L208:
        r80 = false;
        goto L209
    L201:
        r78 = 0;
        goto L202
    L175:
        r70 = false;
        goto L176
    L164:
        if (r66.q == null) goto L166;
        r66.v.post(new w(r66, r29));
        goto L169
    L142:
        Integer r82 = r73.b.b;
        if (r82 == null) goto L145;
        int r84 = r82.intValue();
    L146:
        if (r84 <= 0) goto L148;
        boolean r85 = true;
    L149:
        if (r85 == false) goto L156;
        FrameLayout r86 = getIndicatorsContainer();
        ViewGroup.LayoutParams r87 = r86.getLayoutParams();
        if ((r87 instanceof ViewGroup.MarginLayoutParams) == true) goto L153;
        r87 = null;
    L153:
        ViewGroup.MarginLayoutParams r88 = (ViewGroup.MarginLayoutParams) r87;
        if (r88 == null) goto L156;
        r88.bottomMargin = com.bytedance.android.shopping.extensions.b.b(24) - com.bytedance.android.shopping.extensions.b.b(12);
        r86.setLayoutParams(r88);
        goto L156
    L148:
        r85 = false;
        goto L149
    L145:
        r84 = r73.b.a;
        goto L146
    L110:
        r210 = false;
        goto L111
    L107:
        r46 = null;
    L83:
        r27 = "";
    L87:
        r36 = false;
        goto L88
    L91:
        r111 = -1;
        goto L92
    L103:
        r43 = null;
        goto L104
    L64:
        if (r22.length() == 0) goto L67;
        r23 = false;
    L61:
        r22 = null;
    L214:
        LinearLayout r89 = getLlFloatButtonElements();
        ViewGroup.LayoutParams r90 = r89.getLayoutParams();
        if ((r90 instanceof ViewGroup.MarginLayoutParams) == true) goto L217;
        r90 = null;
    L217:
        ViewGroup.MarginLayoutParams r91 = (ViewGroup.MarginLayoutParams) r90;
        if (r91 == null) goto L239;
        if (r28 == null) goto L221;
        ScrollMoreText r92 = r28.getScrollMoreText();
    L222:
        if (r92 == null) goto L224;
        int r94 = 80;
    L225:
        r91.topMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r94));
        if (r31 != null) goto L228;
    L238:
        r89.setLayoutParams(r91);
        goto L239
    L228:
        if (r31.isEnablePlayBackEntryAlphaTrans() != true) goto L238;
        if (r28 == null) goto L231;
        ScrollMoreText r95 = r28.getScrollMoreText();
    L232:
        if (r95 == null) goto L238;
        int r96 = com.bytedance.android.shopping.extensions.b.b(124);
        if (com.bytedance.android.shopping.anchorv4.experiment.e.a() == true) goto L236;
        int r97 = com.bytedance.android.shopping.extensions.j.a(2131165695);
    L237:
        r91.topMargin = r96 + r97;
        goto L238
    L236:
        r97 = 0;
        goto L237
    L231:
        r95 = null;
        goto L232
    L224:
        r94 = 158;
        goto L225
    L221:
        r92 = null;
    L239:
        if (r30 == null) goto L247;
        List r98 = r30.getButtonList();
        if (r98 == null) goto L247;
        TextWithOneIconElement r99 = (TextWithOneIconElement) CollectionsKt.firstOrNull(r98);
        if (r99 == null) goto L247;
        TextElement r100 = r99.getContent();
        if (r100 == null) goto L247;
        String r101 = r100.getText();
    L249:
        if (Intrinsics.areEqual(r101, "直播中") == false) goto L255;
        AnchorV4VM r102 = this.h;
        if (r102 == null) goto L255;
        boolean r103 = true;
        if (r102.existLiveWindow() == true) goto L269;
    L256:
        if (r30 == null) goto L269;
        List r104 = r30.getButtonList();
        if (r104 == null) goto L269;
        if ((r104.isEmpty() ^ r103) == true) goto L263;
        r104 = null;
    L263:
        if (r104 == null) goto L269;
        getLlFloatButtonElements().removeAllViews();
        Iterator r105 = CollectionsKt.reversed(r104).iterator();
    L267:
        if (r105.hasNext() == false) goto L269;
        TextWithOneIconElement r106 = (TextWithOneIconElement) r105.next();
        LinearLayout r107 = getLlFloatButtonElements();
        TextWithOneIconElementView r108 = new TextWithOneIconElementView(getContext(), null, 0, null, 30);
        r108.setMinimumWidth(com.bytedance.android.shopping.extensions.b.b(50));
        TextWithOneIconElementView.b(r108, r106, null, false, null, 14);
        Unit r109 = Unit.INSTANCE;
        ViewGroup.MarginLayoutParams r115 = new ViewGroup.MarginLayoutParams(-2, -2);
        r115.bottomMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r106.getSpace()));
        r107.addView(r108, r115);
    L269:
        View r116 = getFlBack();
        if (r32.a == false) goto L272;
        int r117 = 8;
    L273:
        r116.setVisibility(r117);
        this.j = r29;
        AnchorV4VM r118 = this.h;
        if (r118 == null) goto L276;
        r118.registerHeadVHUpdateListener(new AnchorV4HeadView$listenHeadVHChange$1(this));
    L276:
        AnchorV4VM r119 = this.h;
        if (r119 == null) goto L279;
        r119.registerHeadIndicatorListener(new AnchorV4HeadView$listenIndicatorChange$1(this));
    L279:
        getFlBack().setContentDescription(com.bytedance.android.shopping.extensions.j.c(2131913935));
        if (r31 == null) goto L284;
        CommonMeta r120 = r31.commonMeta();
        if (r120 == null) goto L284;
        Boolean r121 = Boolean.valueOf(r120.getEnablePDPOptimize());
    L286:
        if (com.bytedance.android.shopping.extensions.k.i(r121) == false) goto L288;
        getHeadBottomView().setVisibility(0);
    L289:
        getHeadBottomView().setHeadViewAbility(getSlidesAndIndicatorComponent());
        if (r31 == null) goto L294;
        List r122 = r31.getHeadViewStatusListenerList();
        if (r122 == null) goto L294;
        r122.add(getHeadBottomView().getHeadViewStatusListener());
    L294:
        if (r31 == null) goto L311;
        List r123 = r31.getHeadViewStatusListenerList();
        if (r123 == null) goto L311;
        Iterator r124 = r123.iterator();
    L299:
        if (r124.hasNext() == false) goto L311;
        com.bytedance.android.shopping.anchorv4.vm.c r125 = (com.bytedance.android.shopping.anchorv4.vm.c) r124.next();
        if (r28 == null) goto L303;
        Integer r126 = r28.getContainerSizeType();
    L304:
        if (r126 != null) goto L307;
    L309:
        boolean r127 = false;
    L310:
        r125.a9(r127);
        goto L299
    L307:
        if (r126.intValue() != 1) goto L309;
        r127 = true;
        goto L310
    L303:
        r126 = null;
    L311:
        if (r31 == null) goto L318;
        List r128 = r31.getHeadViewStatusListenerList();
        if (r128 == null) goto L329;
        Iterator r129 = r128.iterator();
    L316:
        if (r129.hasNext() == false) goto L330;
        ((com.bytedance.android.shopping.anchorv4.vm.c) r129.next()).X8();
        goto L316
    L330:
        return;
    L329:
        return;
    L318:
        return;
    L288:
        getHeadBottomView().setVisibility(8);
    L284:
        r121 = null;
        goto L286
    L272:
        r117 = 0;
    L255:
        r103 = true;
    L247:
        r101 = null;
    L50:
        r18 = true;
        goto L53
    L42:
        r13 = null;
        goto L43
    L38:
        r12 = null;
        goto L39
    L34:
        r11 = null;
        goto L35
    }
}
