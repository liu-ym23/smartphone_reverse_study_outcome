package com.ivy.ivykit.plugin.impl.render;

import com.bytedance.android.lola.LolaCanvas;
import com.bytedance.ies.xelement.LynxBounceView;
import com.bytedance.ies.xelement.LynxImpressionView;
import com.bytedance.ies.xelement.LynxNestedScrollView;
import com.bytedance.ies.xelement.LynxScrollView;
import com.bytedance.ies.xelement.banner.LynxSwiperItemView;
import com.bytedance.ies.xelement.banner.LynxSwiperView;
import com.bytedance.ies.xelement.input.AutoHeightInputShadowNode;
import com.bytedance.ies.xelement.input.LynxInputView;
import com.bytedance.ies.xelement.input.LynxTextAreaView;
import com.bytedance.ies.xelement.overlay.LynxOverlayViewProxy;
import com.bytedance.ies.xelement.text.inlineimage.LynxInlineImageShadowNode;
import com.bytedance.ies.xelement.text.inlinetext.LynxInlineTextShadowNode;
import com.bytedance.ies.xelement.text.inlinetruncation.LynxInlineTruncationShadowNode;
import com.bytedance.ies.xelement.text.text.LynxTextShadowNode;
import com.bytedance.ies.xelement.text.text.LynxTextUI;
import com.bytedance.ies.xelement.viewpager.LynxTabBarView;
import com.bytedance.ies.xelement.viewpager.LynxViewPager;
import com.bytedance.ies.xelement.viewpager.childitem.LynxTabbarItem;
import com.bytedance.ies.xelement.viewpager.childitem.LynxViewpagerItem;
import com.bytedance.ies.xelement.viewpager.viewpager.LynxViewPagerNG;
import com.bytedance.lynx.map.ng.LynxMapView;
import com.lynx.animax.util.LynxAnimaX;
import com.lynx.canvas.UICanvas;
import com.lynx.component.svg.UISvg;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.canvas.LynxHeliumCanvas;
import com.lynx.tasm.behavior.ui.swiper.XSwiperUI;
import com.lynx.tasm.behavior.ui.view.UIView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes23.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, com.lynx.tasm.behavior.a> f278426a = null;

    /* JADX INFO: renamed from: com.ivy.ivykit.plugin.impl.render.a$a, reason: collision with other inner class name */
    public static final class C3880a extends com.lynx.tasm.behavior.a {
        public C3880a() {
            super("x-scroll-view");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNull(r100);
            return new LynxScrollView(r100);
        }
    }

    public static final class a0 extends com.lynx.tasm.behavior.a {
        public a0() {
            super("x-viewpager-ng");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNull(r100);
            return new LynxViewPagerNG(r100, null);
        }
    }

    public static final class b extends com.lynx.tasm.behavior.a {
        public b() {
            super("x-nested-scroll-view");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNull(r100);
            return new LynxNestedScrollView(r100);
        }
    }

    public static final class b0 extends com.lynx.tasm.behavior.a {
        public b0() {
            super("x-viewpager-item-ng");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNull(r100);
            return new LynxViewpagerItem(r100);
        }
    }

    public static final class c extends com.lynx.tasm.behavior.a {
        public c() {
            super("x-viewpager");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNull(r100);
            return new LynxViewPager(r100);
        }
    }

    public static final class c0 extends com.lynx.tasm.behavior.a {
        public c0() {
            super("input");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxInputView(r100);
        }
    }

    public static final class d extends com.lynx.tasm.behavior.a {
        public d() {
            super("x-viewpager-item");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNull(r100);
            return new LynxViewpagerItem(r100);
        }
    }

    public static final class d0 extends com.lynx.tasm.behavior.a {
        public d0() {
            super("canvas");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            return new LynxHeliumCanvas(r100);
        }
    }

    public static final class e extends com.lynx.tasm.behavior.a {
        public e() {
            super("lola-canvas");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNull(r100);
            return new LolaCanvas(r100);
        }
    }

    public static final class e0 extends com.lynx.tasm.behavior.a {
        public e0() {
            super("canvas-ng");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            return new UICanvas(r100);
        }
    }

    public static final class f extends com.lynx.tasm.behavior.a {
        public f() {
            super("x-bounce-view");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNull(r100);
            return new LynxBounceView(r100);
        }
    }

    public static final class f0 extends com.lynx.tasm.behavior.a {
        public f0() {
            super("x-overlay");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNull(r100);
            return new LynxOverlayViewProxy(r100);
        }
    }

    public static final class g extends com.lynx.tasm.behavior.a {
        public g() {
            super("x-impression-view");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNull(r100);
            return new LynxImpressionView(r100);
        }
    }

    public static final class h extends com.lynx.tasm.behavior.a {
        public h() {
            super("x-inline-truncation");
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return new LynxInlineTruncationShadowNode();
        }
    }

    public static final class i extends com.lynx.tasm.behavior.a {
        public i() {
            super("x-inline-text");
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return new LynxInlineTextShadowNode();
        }
    }

    public static final class j extends com.lynx.tasm.behavior.a {
        public j() {
            super("x-inline-image");
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return new LynxInlineImageShadowNode();
        }
    }

    public static final class k extends com.lynx.tasm.behavior.a {
        public k() {
            super("x-text");
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return new LynxTextShadowNode();
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxTextUI(r100);
        }
    }

    public static final class l extends com.lynx.tasm.behavior.a {
        public l() {
            super("x-swiper");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxSwiperView(r100);
        }
    }

    public static final class m extends com.lynx.tasm.behavior.a {
        public m() {
            super("x-swiper-item");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxSwiperItemView(r100);
        }
    }

    public static final class n extends com.lynx.tasm.behavior.a {
        public n() {
            super("swiper");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new XSwiperUI(r100, null);
        }
    }

    public static final class o extends com.lynx.tasm.behavior.a {
        public o() {
            super("swiper-item");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new UIView(r100);
        }
    }

    public static final class p extends com.lynx.tasm.behavior.a {
        public p() {
            super("svg");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNull(r100);
            return new UISvg(r100, null);
        }
    }

    public static final class q extends com.lynx.tasm.behavior.a {
        public q() {
            super("x-tabbar-pro");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNull(r100);
            return new LynxTabBarView(r100, null);
        }
    }

    public static final class r extends com.lynx.tasm.behavior.a {
        public r() {
            super("x-tabbar-item-pro");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNull(r100);
            return new LynxTabbarItem(r100);
        }
    }

    public static final class s extends com.lynx.tasm.behavior.a {
        public s() {
            super("x-tabbar");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNull(r100);
            return new LynxTabBarView(r100, null);
        }
    }

    public static final class t extends com.lynx.tasm.behavior.a {
        public t() {
            super("x-tabbar-item");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNull(r100);
            return new LynxTabbarItem(r100);
        }
    }

    public static final class u extends com.lynx.tasm.behavior.a {
        public u() {
            super("textarea");
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return new AutoHeightInputShadowNode();
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxTextAreaView(r100);
        }
    }

    public static final class v extends com.lynx.tasm.behavior.a {
        public v() {
            super("x-textarea");
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return new AutoHeightInputShadowNode();
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxTextAreaView(r100);
        }
    }

    public static final class w extends com.lynx.tasm.behavior.a {
        public w() {
            super("x-map");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNull(r100);
            return new LynxMapView(r100);
        }
    }

    public static final class x extends com.lynx.tasm.behavior.a {
        public x() {
            super("x-map-ng");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNull(r100);
            return new LynxMapView(r100);
        }
    }

    public static final class y extends com.lynx.tasm.behavior.a {
        public y() {
            super("animax-view");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return LynxAnimaX.inst().createUI(r100);
        }
    }

    public static final class z extends com.lynx.tasm.behavior.a {
        public z() {
            super("x-input");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxInputView(r100);
        }
    }

    static {
        List r100 = CollectionsKt.listOf(new com.lynx.tasm.behavior.a[]{new k(), new v(), new z(), new a0(), new b0(), new c0(), new d0(), new e0(), new f0(), new C3880a(), new b(), new c(), new d(), new e(), new f(), new g(), new h(), new i(), new j(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new w(), new x(), new y()});
        LinkedHashMap r101 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r100, 10)), 16));
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Object r103 = r102.next();
        r101.put(((com.lynx.tasm.behavior.a) r103).getName(), r103);
        goto L4
    L6:
        f278426a = MapsKt.toMutableMap(r101);
    }

    public static void a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "behavior");
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        com.lynx.tasm.behavior.a r102 = (com.lynx.tasm.behavior.a) r101.next();
        f278426a.put(r102.getName(), r102);
        goto L4
    }
}
