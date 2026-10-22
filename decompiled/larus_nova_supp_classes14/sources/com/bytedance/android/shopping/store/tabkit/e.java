package com.bytedance.android.shopping.store.tabkit;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.hybrid.IECBridgeMethod;
import com.bytedance.android.shopping.store.tabkit.bridge.TabKitBridge;
import com.bytedance.android.shopping.store.tabkit.model.a0;
import com.bytedance.android.shopping.store.tabkit.model.b0;
import com.bytedance.android.shopping.store.tabkit.model.n;
import com.bytedance.android.shopping.store.tabkit.model.p;
import com.bytedance.android.shopping.store.tabkit.model.q;
import com.bytedance.android.shopping.store.tabkit.model.s;
import com.bytedance.android.shopping.store.tabkit.model.x;
import com.bytedance.android.shopping.store.tabkit.view.BaseTabItemView;
import com.bytedance.android.shopping.store.tabkit.view.MixTabLayout;
import com.bytedance.android.shopping.store.tabkit.view.RightItemView;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ ti.l b;
        public final /* synthetic */ com.bytedance.android.shopping.store.tabkit.model.k c;
        public final /* synthetic */ TabKitBridge d;

        public a(Function1 r1, ti.l r2, com.bytedance.android.shopping.store.tabkit.model.k r3, TabKitBridge r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            pd.f r0 = this.d.c;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.d((IECBridgeMethod) this.a.invoke(this.c));
        }
    }

    public static final class b implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ ti.l b;
        public final /* synthetic */ com.bytedance.android.shopping.store.tabkit.model.k c;
        public final /* synthetic */ TabKitBridge d;

        public b(Function1 r1, ti.l r2, com.bytedance.android.shopping.store.tabkit.model.k r3, TabKitBridge r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            pd.f r0 = this.d.c;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.d((IECBridgeMethod) this.a.invoke(this.c));
        }
    }

    public static final boolean a(View r3) {
        if (r3.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L19;
        Object r4 = r3.getParent();
        if ((r4 instanceof View) == true) goto L10;
        r4 = null;
    L10:
        View r5 = (View) r4;
        if (r5 != null) goto L13;
        return false;
    L13:
        if (r5.getVisibility() != 0) goto L15;
        boolean r6 = true;
    L16:
        if (r6 != true) goto L21;
        return true;
    L21:
        return false;
    L15:
        r6 = false;
        goto L16
    L19:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    public static final List<BaseTabItemView> i(ECTabLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$baseTabItemViews");
        List<ECTabLayout.Tab> r3 = k(r2);
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r4 = ((ArrayList) r3).iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        View r1 = ((ECTabLayout.Tab) r4.next()).getCustomView();
        if (r1 == null) goto L9;
        r0.add((BaseTabItemView) r1);
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.tabkit.view.BaseTabItemView");
    L10:
        return r0;
    }

    public static final String j(com.bytedance.android.shopping.store.tabkit.model.k r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$localRedDotKey");
        StringBuilder r0 = new StringBuilder("ec_hybrid_tab_red_dot_show_");
        r0.append(String.valueOf(r2.n()));
        r0.append("_");
        x r3 = r2.o();
        if (r3 == null) goto L7;
        com.bytedance.android.shopping.store.tabkit.model.l r4 = r3.a();
        if (r4 == null) goto L7;
        String r5 = r4.getIdentifier();
    L8:
        r0.append(String.valueOf(r5));
        return r0.toString();
    L7:
        r5 = null;
        goto L8
    }

    public static final List<ECTabLayout.Tab> k(ECTabLayout r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$tabs");
        ArrayList r0 = new ArrayList();
        int r1 = r4.getTabCount();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        ECTabLayout.Tab r3 = r4.getTabAt(r2);
        if (r3 == null) goto L7;
        r0.add(r3);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        return r0;
    }

    public static final boolean l(com.bytedance.android.shopping.store.tabkit.model.k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isLynxTab");
        s r2 = r1.f();
        if (r2 == null) goto L5;
        Integer r3 = r2.c();
    L6:
        if (r3 != null) goto L9;
    L11:
        return false;
    L9:
        if (r3.intValue() != 2) goto L11;
        return true;
    L5:
        r3 = null;
        goto L6
    }

    public static final boolean m(com.bytedance.android.shopping.store.tabkit.model.k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isWebTab");
        s r2 = r1.f();
        if (r2 == null) goto L5;
        Integer r3 = r2.c();
    L6:
        if (r3 != null) goto L9;
    L11:
        return false;
    L9:
        if (r3.intValue() != 3) goto L11;
        return true;
    L5:
        r3 = null;
        goto L6
    }

    public static final void d(com.bytedance.android.shopping.store.tabkit.model.g r2, ECDraweeView r3) {
        Intrinsics.checkNotNullParameter(r3, "iconView");
        int r0 = 0;
        if (r2 == null) goto L7;
        Integer r1 = r2.e();
        if (r1 == null) goto L7;
        int r4 = com.bytedance.android.shopping.extensions.b.b(r1);
    L8:
        if (r2 == null) goto L12;
        Integer r5 = r2.d();
        if (r5 == null) goto L12;
        r0 = com.bytedance.android.shopping.extensions.b.b(r5);
    L12:
        c(r0, r4, r3);
        return;
    L7:
        r4 = 0;
        goto L8
    }

    public static final b0 e(b0 r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$appendParam");
        Intrinsics.checkNotNullParameter(r3, "map");
        b0 r0 = new b0();
        r0.c(r2.a());
        LinkedHashMap r1 = new LinkedHashMap();
        r1.putAll(r3);
        Map<String, String> r4 = r2.b();
        if (r4 == null) goto L5;
        r1.putAll(r4);
    L5:
        Unit r5 = Unit.INSTANCE;
        r0.d(MapsKt.toMap(r1));
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void f(ECDraweeView r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "draweeView");
        PipelineDraweeControllerBuilder r4 = Fresco.newDraweeControllerBuilder().setUri("res://" + r2.getContext().getPackageName() + "/" + r3).setOldController(r2.getController());
        if (r4 == null) goto L5;
        AbstractDraweeController r5 = r4.build();
    L6:
        r2.setController(r5);
        return;
    L5:
        r5 = null;
        goto L6
    }

    public static final void g(GenericDraweeView r9, ECUrlModel r10) {
        Intrinsics.checkNotNullParameter(h0.a, "$this$bindImage");
        Intrinsics.checkNotNullParameter(r9, "draweeView");
        h0.d(r9, r10, new r("redundancy", "redundancy", "redundancy"), null, null, null, null, 120);
    }

    public static final void h(GenericDraweeView r2, ECUrlModel r3) {
        Intrinsics.checkNotNullParameter(r2, "draweeView");
        AbstractDraweeController r0 = null;
        if (r3 == null) goto L5;
        String r1 = r3.getUri();
    L6:
        String r4 = a2.d(r1);
        if (r4 != null) goto L14;
        if (r3 == null) goto L12;
        List r5 = r3.getUrlList();
        if (r5 == null) goto L12;
        String r6 = (String) CollectionsKt.first(r5);
    L13:
        r4 = a2.d(r6);
    L12:
        r6 = null;
    L14:
        if (r4 != null) goto L16;
        return;
    L16:
        PipelineDraweeControllerBuilder r7 = Fresco.newDraweeControllerBuilder().setUri(r4).setOldController(r2.getController());
        if (r7 == null) goto L19;
        r0 = r7.build();
    L19:
        r2.setController(r0);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final p o(q r1, TabKitViewModel r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$selectTabBarStyle");
        if (r2 == null) goto L7;
        MutableLiveData<Integer> r3 = r2.getScreenState();
        if (r3 == null) goto L7;
        Integer r4 = (Integer) r3.getValue();
    L8:
        if (r4 == null) goto L14;
        if (r4.intValue() != 0) goto L14;
        return r1.d();
    L14:
        return r1.i();
    L7:
        r4 = null;
        goto L8
    }

    public static final void p(MixTabLayout r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$setVisibilityByDisplayMode");
        if (r3 != null) goto L6;
    L8:
        if (r3 != null) goto L11;
    L13:
        ExtensionsKt.visible(r2);
        return;
    L11:
        if (r3.intValue() != 1) goto L13;
        ExtensionsKt.visible(r2);
        return;
    L6:
        if (r3.intValue() != 2) goto L8;
        ExtensionsKt.gone(r2);
    }

    public static final ExtensionsKt$toBaseMetricEvent2$3 r(b0 r2, com.bytedance.android.shopping.store.tabkit.model.k r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$toBaseMetricEvent2");
        final String r0 = r2.a();
        if (r0 != null) goto L6;
        return null;
    L6:
        com.bytedance.android.ec.core.event.a r1 = new ExtensionsKt$toBaseMetricEvent2$3(r0, r0);
        Map<String, String> r4 = r2.b();
        if (r4 == null) goto L9;
        r1.appendParam(r4);
    L9:
        com.bytedance.android.shopping.store.tabkit.model.c r5 = r3.a();
        if (r5 == null) goto L16;
        a0 r6 = r5.a();
        if (r6 == null) goto L16;
        Map<String, String> r7 = r6.b();
        if (r7 == null) goto L16;
        r1.appendParam(r7);
    L16:
        Map<String, String> r8 = r3.h();
        if (r8 == null) goto L19;
        r1.appendParam(r8);
    L19:
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void s(com.bytedance.android.shopping.store.tabkit.model.g r2, ECDraweeView r3) {
        if (r2 == null) goto L13;
        String r4 = r2.c();
        if (r4 != null) goto L6;
        return;
    L6:
        if (com.bytedance.android.shopping.extensions.k.c(r4) == true) goto L9;
        r4 = null;
    L9:
        if (r4 == null) goto L15;
        if (r3 == 0) goto L16;
        r3.setColorFilter(com.bytedance.android.ec.core.utils.s.a(r4, (int) 4294967295L));
        return;
    L16:
        return;
    L15:
        return;
    }

    public static final void t(ECTabLayout r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$updateTabBarItems");
        Iterator r3 = ((ArrayList) i(r1)).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((BaseTabItemView) r3.next()).setFullScreenState(r2);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void c(int r2, int r3, ECDraweeView r4) {
        Intrinsics.checkNotNullParameter(r4, "iconView");
        if (r3 != 0) goto L6;
        if (r2 != 0) goto L6;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        r5.height = com.bytedance.android.shopping.extensions.b.b(24);
        r5.width = com.bytedance.android.shopping.extensions.b.b(24);
        r4.setAdjustMode(0);
        return;
    L6:
        if (r3 <= 0) goto L10;
        if (r2 <= 0) goto L10;
        ViewGroup.LayoutParams r1 = r4.getLayoutParams();
        r1.height = r2;
        r1.width = r3;
        r4.setAdjustMode(0);
        return;
    L10:
        if (r2 != 0) goto L13;
        if (r3 <= 0) goto L13;
        r4.getLayoutParams().width = r3;
        r4.getLayoutParams().height = -2;
        r4.setAdjustMode(2);
        return;
    L13:
        if (r3 != 0) goto L20;
        if (r2 <= 0) goto L21;
        r4.getLayoutParams().height = r2;
        r4.getLayoutParams().width = -2;
        r4.setAdjustMode(1);
        return;
    L21:
        return;
    }

    public static final ExtensionsKt$toBaseMetricEvent2$1 q(b0 r2, com.bytedance.android.shopping.store.tabkit.model.k r3, a0 r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$toBaseMetricEvent2");
        final String r0 = r2.a();
        if (r0 != null) goto L6;
        return null;
    L6:
        com.bytedance.android.ec.core.event.a r1 = new ExtensionsKt$toBaseMetricEvent2$1(r0, r0);
        Map<String, String> r5 = r2.b();
        if (r5 == null) goto L9;
        r1.appendParam(r5);
    L9:
        if (r4 == null) goto L13;
        Map<String, String> r6 = r4.b();
        if (r6 == null) goto L13;
        r1.appendParam(r6);
    L13:
        if (r3 == null) goto L17;
        Map<String, String> r7 = r3.h();
        if (r7 == null) goto L17;
        r1.appendParam(r7);
    L17:
        return r1;
    }

    public static final void b(View r7, Integer r8, View r9, RightItemView r10) {
        ViewGroup.LayoutParams r0 = null;
        if (r7 == null) goto L5;
        ViewGroup.LayoutParams r1 = r7.getLayoutParams();
    L7:
        if ((r1 instanceof FrameLayout.LayoutParams) == false) goto L10;
        r0 = r1;
    L10:
        FrameLayout.LayoutParams r4 = (FrameLayout.LayoutParams) r0;
        if (r4 != null) goto L13;
        return;
    L13:
        Ref.IntRef r2 = new Ref.IntRef();
        r2.element = 0;
        Ref.IntRef r5 = new Ref.IntRef();
        r5.element = 0;
        if (r8 != null) goto L17;
    L19:
        if (r8 != null) goto L22;
    L24:
        if (r8 != null) goto L27;
    L29:
        if (r8 != null) goto L32;
        return;
    L32:
        if (r8.intValue() != 2) goto L37;
        r7.post(new c(r9, r2, r4, r5, r7));
        return;
    L37:
        return;
    L27:
        if (r8.intValue() != 3) goto L29;
        r7.post(new com.bytedance.android.shopping.store.tabkit.b(r4, r10, r5, r2, r7));
        return;
    L22:
        if (r8.intValue() != 0) goto L24;
    L23:
        r4.gravity = 1;
        r4.setMargins(r2.element, r4.topMargin, r5.element, r4.bottomMargin);
        r7.requestLayout();
        return;
    L17:
        if (r8.intValue() != 1) goto L19;
    L5:
        r1 = null;
        goto L7
    }

    public static final void n(ti.l r3, TabKitBridge r4, com.bytedance.android.shopping.store.tabkit.model.k r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "$this$registerTabKitBridge");
        Intrinsics.checkNotNullParameter(r4, "bridge");
        Intrinsics.checkNotNullParameter(r5, "tab");
        if (r6 == false) goto L9;
        Iterator r7 = ((ArrayList) r4.b.getValue()).iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        Function1 r0 = (Function1) r7.next();
        r3.registerMethod(((TabKitBridge.TabKitBaseBridgeMethod) r0.invoke(r5)).getName(), new a(r0, r3, r5, r4));
        goto L6
    L8:
        return;
    L9:
        Iterator<Function1<com.bytedance.android.shopping.store.tabkit.model.k, TabKitBridge.TabKitBaseBridgeMethod>> r8 = r4.a.iterator();
    L11:
        if (r8.hasNext() == false) goto L13;
        Function1<com.bytedance.android.shopping.store.tabkit.model.k, TabKitBridge.TabKitBaseBridgeMethod> r1 = r8.next();
        r3.registerMethod(((TabKitBridge.TabKitBaseBridgeMethod) r1.invoke(r5)).getName(), new b(r1, r3, r5, r4));
        goto L11
    }

    public static final void u(ECTabLayout r8, p r9, boolean r10, MixTabLayout r11, View r12, RightItemView r13) {
        Intrinsics.checkNotNullParameter(r8, "$this$updateTabBarLayoutStyle");
        ViewGroup.LayoutParams r0 = r8.getLayoutParams();
        Integer r2 = null;
        if ((r0 instanceof FrameLayout.LayoutParams) == true) goto L5;
        r0 = null;
    L5:
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        if (r9 == null) goto L12;
        Integer r3 = r9.d();
        if (r3 == null) goto L12;
        int r4 = r3.intValue();
        if (r1 == null) goto L12;
        r1.height = r4;
    L12:
        if (r9 == null) goto L14;
        String r5 = r9.b();
    L15:
        if (r5 != null) goto L138;
        if (r10 == true) goto L27;
        if (r11 == null) goto L27;
        r11.setBackgroundColor(-1);
    L27:
        Drawable r14 = r8.getTabSelectedIndicator();
        if ((r14 instanceof LayerDrawable) == true) goto L30;
        r14 = null;
    L30:
        LayerDrawable r15 = (LayerDrawable) r14;
        if (r15 == null) goto L33;
        Drawable r6 = r15.getDrawable(0);
    L35:
        if ((r6 instanceof GradientDrawable) == true) goto L37;
        r6 = null;
    L37:
        GradientDrawable r7 = (GradientDrawable) r6;
        if (r10 == false) goto L67;
        if (r9 == null) goto L67;
        n r16 = r9.e();
        if (r16 == null) goto L67;
        List<String> r17 = r16.a();
        if (r17 == null) goto L67;
        if (r17.size() <= 1) goto L142;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L56
        if (r7 == null) goto L53;
        List<String> r19 = r17;     // Catch: Throwable -> L56
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));     // Catch: Throwable -> L56
        Iterator<T> r21 = r19.iterator();     // Catch: Throwable -> L56
    L50:
        if (r21.hasNext() == false) goto L52;
        r20.add(Integer.valueOf(Color.parseColor((String) r21.next())));     // Catch: Throwable -> L56
        goto L50
    L52:
        qc3.a.f(r7, CollectionsKt.toIntArray(r20));     // Catch: Throwable -> L56
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L56
    L54:
        Object r23 = Result.constructor-impl(r22);     // Catch: Throwable -> L56
    L66:
        Result.box-impl(r23);
        goto L67
    L53:
        r22 = null;
    L56:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L66
    L142:
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L64
        if (r7 == null) goto L61;
        qc3.a.f(r7, new int[]{Color.parseColor((String) ListProtector.get(r17, 0)), Color.parseColor((String) ListProtector.get(r17, 0))});     // Catch: Throwable -> L64
        Unit r26 = Unit.INSTANCE;     // Catch: Throwable -> L64
    L62:
        r23 = Result.constructor-impl(r26);     // Catch: Throwable -> L64
        goto L66
    L61:
        r26 = null;
    L64:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
    L67:
        if (r9 == null) goto L73;
        n r28 = r9.e();
        if (r28 == null) goto L73;
        Integer r29 = r28.d();
        if (r29 == null) goto L73;
        int r30 = com.bytedance.android.shopping.extensions.b.b(r29);
    L75:
        Integer r31 = Integer.valueOf(r30);
    L77:
        if (r31 == null) goto L79;
        int r32 = r31.intValue();
    L80:
        if (r9 == null) goto L86;
        n r33 = r9.e();
        if (r33 == null) goto L86;
        Integer r34 = r33.c();
        if (r34 == null) goto L86;
        int r35 = com.bytedance.android.shopping.extensions.b.b(r34);
    L88:
        Integer r36 = Integer.valueOf(r35);
    L90:
        if (r36 == null) goto L92;
        int r37 = r36.intValue();
    L94:
        if (Build.VERSION.SDK_INT < 23) goto L97;
        if (r15 == null) goto L97;
        r15.setLayerSize(0, r32, r37);
    L97:
        if (r9 == null) goto L99;
        Integer r110 = r9.a();
    L100:
        b(r8, r110, r12, r13);
        if (r9 == null) goto L105;
        n r111 = r9.e();
        if (r111 == null) goto L105;
        r2 = r111.b();
    L105:
        if (r2 != null) goto L108;
    L112:
        if (r2 != null) goto L115;
    L119:
        Iterator r38 = ((ArrayList) i(r8)).iterator();
    L121:
        if (r38.hasNext() == false) goto L137;
        BaseTabItemView r112 = (BaseTabItemView) r38.next();
        r112.setTabBarStyleConfig(r9);
        if (r10 == false) goto L121;
        if (r9 == null) goto L129;
        int r113 = r9.f();
        if (r113 == null) goto L129;
    L130:
        int r114 = com.bytedance.android.shopping.extensions.b.b(r113);
        if (r9 == null) goto L135;
        Integer r39 = r9.h();
        if (r39 == null) goto L135;
        int r115 = com.bytedance.android.shopping.extensions.b.b(r39);
    L136:
        r112.setPadding(r114, 0, r115, 0);
    L135:
        r115 = com.bytedance.android.shopping.extensions.b.b(14);
    L129:
        r113 = 14;
        goto L130
    L137:
        return;
    L115:
        if (r2.intValue() != 1) goto L119;
        Drawable r116 = r8.getTabSelectedIndicator();
        if (r116 == null) goto L119;
        r116.setAlpha(255);
        goto L119
    L108:
        if (r2.intValue() != 2) goto L112;
        Drawable r117 = r8.getTabSelectedIndicator();
        if (r117 == null) goto L119;
        r117.setAlpha(0);
        goto L119
    L99:
        r110 = null;
        goto L100
    L92:
        r37 = com.bytedance.android.shopping.extensions.b.b(3);
    L86:
        if (r7 == null) goto L89;
        r35 = r7.getIntrinsicHeight();
        goto L88
    L89:
        r36 = null;
        goto L90
    L79:
        r32 = com.bytedance.android.shopping.extensions.b.b(30);
    L73:
        if (r7 == null) goto L76;
        r30 = r7.getIntrinsicWidth();
        goto L75
    L76:
        r31 = null;
        goto L77
    L33:
        r6 = null;
        goto L35
    L138:
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L22
        if (r11 == null) goto L19;
        r11.setBackgroundColor(Color.parseColor(r9.b()));     // Catch: Throwable -> L22
        Unit r118 = Unit.INSTANCE;     // Catch: Throwable -> L22
    L20:
        Result.constructor-impl(r118);     // Catch: Throwable -> L22
        goto L27
    L19:
        r118 = null;
    L22:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L14:
        r5 = null;
        goto L15
    }
}
