package com.bytedance.android.shopping.new_cart.components;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.NewCartActivity;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.android.shopping.new_cart.widgets.ECCartLoadingView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CartLoadingComponent extends com.bytedance.android.shopping.new_cart.components.a {
    public View b;
    public View c;
    public View d;
    public final Lazy e;
    public final Lazy f;
    public final AtomicBoolean g;
    public final CartViewModel h;
    public boolean i;
    public final AtomicLong j;
    public List<String> k;
    public String l;
    public final Lazy m;
    public final CartObjectContainer n;
    public final ECCartLoadingView o;

    public static final class a {
    }

    public final class b implements View.OnClickListener {
        public final String a;
        public final /* synthetic */ CartLoadingComponent b;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            Pair[] r10 = new Pair[2];
            r10[0] = TuplesKt.to("type", this.a);
            CartPageCallBackComponent r0 = (CartPageCallBackComponent) this.b.m.getValue();
            if (r0 == null) goto L5;
            String r1 = r0.h;
        L6:
            r10[1] = TuplesKt.to("scene", r1);
            Map r4 = MapsKt.mutableMapOf(r10);
            CartPageCallBackComponent r11 = (CartPageCallBackComponent) this.b.m.getValue();
            if (r11 == null) goto L10;
            AtomicLong r12 = r11.e;
            if (r12 == null) goto L10;
        L12:
            if (r12.get() == (-1)) goto L14;
            r4.put("duration", String.valueOf(System.currentTimeMillis() - r12.get()));
        L14:
            CartViewModel.doEventAction$default(this.b.h, "yata_cart_click_placeholder", r4, null, 4, null);
            return;
        L10:
            r12 = new AtomicLong(-1);
            goto L12
        L5:
            r1 = null;
            goto L6
        }

        public b(CartLoadingComponent r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "type");
            this.b = r2;
            this.a = r3;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ CartLoadingComponent a;

        public c(CartLoadingComponent r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            CartLoadingComponent r8 = this.a;
            CartViewModel.doEventAction$default(r8.h, "yata_cart_click_loading", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("scene", r8.l)}), null, 4, null);
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void i() {
        dm.a.a("ECCartLoadingView").i("cartLoadingComponent destroy");
        p("destroy", null);
    }

    public final void n() {
        if (this.g.compareAndSet(false, true) == false) goto L56;
        ECCartLoadingView r0 = this.o;
        if (r0 == null) goto L7;
        r0.setCartObjectContainer(this.n);
    L7:
        ECCartLoadingView r1 = this.o;
        if (r1 == null) goto L10;
        r1.Y5();
    L10:
        ECCartLoadingView r2 = this.o;
        if (r2 == null) goto L13;
        r2.setNeedHint(true);
    L13:
        ConstraintLayout r3 = this.o;
        if (r3 == null) goto L16;
        r3.setOnClickListener(new c(this));
    L16:
        NewCartActivity r4 = c();
        View r5 = null;
        if (r4 == null) goto L20;
        View r6 = r4.findViewById(2131371243);
        if (r6 == null) goto L20;
    L26:
        if (r6 == null) goto L28;
        r6.setOnClickListener(new b(this, "left"));
        Unit r7 = Unit.INSTANCE;
    L29:
        this.b = r6;
        NewCartActivity r8 = c();
        if (r8 == null) goto L33;
        View r9 = r8.findViewById(2131371241);
        if (r9 == null) goto L33;
    L39:
        if (r9 == null) goto L41;
        r9.setOnClickListener(new b(this, "bottom"));
        Unit r10 = Unit.INSTANCE;
    L42:
        this.c = r9;
        NewCartActivity r11 = c();
        if (r11 == null) goto L46;
        View r12 = r11.findViewById(2131371242);
        if (r12 == null) goto L46;
    L52:
        if (r12 == null) goto L54;
        r12.setOnClickListener(new b(this, "top"));
        Unit r13 = Unit.INSTANCE;
        r5 = r12;
    L54:
        this.d = r5;
        return;
    L46:
        Fragment r14 = this.a.f;
        if (r14 == null) goto L51;
        View r15 = r14.getView();
        if (r15 == null) goto L51;
        r12 = r15.findViewById(2131371242);
    L51:
        r12 = null;
        goto L52
    L41:
        r9 = null;
    L33:
        Fragment r16 = this.a.f;
        if (r16 == null) goto L38;
        View r17 = r16.getView();
        if (r17 == null) goto L38;
        r9 = r17.findViewById(2131371241);
    L38:
        r9 = null;
        goto L39
    L28:
        r6 = null;
    L20:
        Fragment r18 = this.a.f;
        if (r18 == null) goto L25;
        View r19 = r18.getView();
        if (r19 == null) goto L25;
        r6 = r19.findViewById(2131371243);
    L25:
        r6 = null;
        goto L26
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void h() {
        n();
    }

    public CartLoadingComponent(CartObjectContainer r3, ECCartLoadingView r4) {
        Intrinsics.checkNotNullParameter(r3, "objectContainer");
        super(r3);
        this.n = r3;
        this.o = r4;
        this.e = LazyKt.lazy(new CartLoadingComponent$placeHolderGroup$2(this));
        this.f = LazyKt.lazy(new CartLoadingComponent$bottomHolderGroup$2(this));
        this.g = new AtomicBoolean(false);
        this.h = this.a.d;
        this.j = new AtomicLong(-1);
        this.k = new ArrayList();
        this.m = LazyKt.lazy(new CartLoadingComponent$cartPageCallBackComponent$2(this));
    }

    public final void p(String r13, com.bytedance.kmp.ec.yata.common.biz.callback.a r14) {
        Intrinsics.checkNotNullParameter(r13, "scene");
        boolean r1 = false;
        this.i = false;
        ECCartLoadingView r2 = this.o;
        if (r2 == null) goto L5;
        Intrinsics.checkNotNullParameter(r13, "scene");
        bg3.a r3 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.f(new com.bytedance.android.shopping.new_cart.widgets.h(r2, r13));
    L5:
        Iterator r4 = ((List) this.e.getValue()).iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        View r5 = (View) r4.next();
        if (r5 == null) goto L7;
        r5.setVisibility(8);
        goto L7
    L11:
        Iterator r6 = ((List) this.f.getValue()).iterator();
    L13:
        if (r6.hasNext() == false) goto L18;
        View r7 = (View) r6.next();
        if (r7 == null) goto L13;
        r7.setVisibility(8);
        goto L13
    L18:
        if (this.j.get() == (-1)) goto L53;
        Pair[] r8 = new Pair[7];
        r8[0] = TuplesKt.to("state", "stop");
        r8[1] = TuplesKt.to("scene", r13);
        Long r15 = null;
        if (r14 == null) goto L23;
        String r9 = r14.b;
    L24:
        r8[2] = TuplesKt.to("trigger", r9);
        if (r14 == null) goto L29;
        com.bytedance.kmp.ec.yata.store.node.c r10 = r14.a;
        if (r10 == null) goto L29;
        String r11 = r10.getNodeName();
    L30:
        r8[3] = TuplesKt.to("node_name", r11);
        if (r14 == null) goto L33;
        String r16 = r14.c;
    L34:
        r8[4] = TuplesKt.to("operator_type", r16);
        r8[5] = TuplesKt.to("actions", this.k);
        r8[6] = TuplesKt.to("action_size", Integer.valueOf(((ArrayList) this.k).size()));
        Map r12 = MapsKt.mutableMapOf(r8);
        Long r17 = Long.valueOf(this.j.get());
        if (r17.longValue() == (-1)) goto L37;
        r1 = true;
    L37:
        if (r1 == false) goto L39;
        r15 = r17;
    L39:
        if (r15 == null) goto L41;
        r12.put("duration", Long.valueOf(System.currentTimeMillis() - r15.longValue()));
    L41:
        CartViewModel.doEventAction$default(this.h, "yata_cart_loading_state", r12, null, 4, null);
        this.j.set(-1);
        this.k = new ArrayList();
        return;
    L33:
        r16 = null;
    L29:
        r11 = null;
        goto L30
    L23:
        r9 = null;
        goto L24
    }

    public static void o(CartLoadingComponent r6, String r7, boolean r8, com.bytedance.kmp.ec.yata.common.biz.callback.a r9, boolean r10, boolean r11, boolean r12, int r13) {
        if ((r13 & 8) == 0) goto L6;
        r10 = false;
    L6:
        if ((r13 & 16) == 0) goto L9;
        r11 = false;
    L9:
        if ((r13 & 32) == 0) goto L11;
        r12 = false;
    L11:
        Intrinsics.checkNotNullParameter(r7, "scene");
        r6.n();
        if (r10 == false) goto L19;
        Intrinsics.checkNotNullParameter(r7, "scene");
        r6.i = true;
        ECCartLoadingView r14 = r6.o;
        if (r14 == null) goto L16;
        r14.setNeedHint(r8);
    L16:
        ECCartLoadingView r15 = r6.o;
        if (r15 == null) goto L19;
        bg3.a r16 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.f(new com.bytedance.android.shopping.new_cart.widgets.g(r15));
    L19:
        if (r11 == false) goto L26;
        Intrinsics.checkNotNullParameter(r7, "scene");
        Iterator r17 = ((List) r6.e.getValue()).iterator();
    L22:
        if (r17.hasNext() == false) goto L26;
        View r18 = (View) r17.next();
        if (r18 == null) goto L22;
        r18.setVisibility(0);
    L26:
        if (r12 == false) goto L33;
        Intrinsics.checkNotNullParameter(r7, "scene");
        Iterator r19 = ((List) r6.f.getValue()).iterator();
    L29:
        if (r19.hasNext() == false) goto L33;
        View r110 = (View) r19.next();
        if (r110 == null) goto L29;
        r110.setVisibility(0);
    L33:
        r6.l = r7;
        Pair[] r20 = new Pair[5];
        r20[0] = TuplesKt.to("state", "start");
        r20[1] = TuplesKt.to("scene", r7);
        String r111 = null;
        if (r9 == null) goto L36;
        String r112 = r9.b;
    L37:
        r20[2] = TuplesKt.to("trigger", r112);
        if (r9 == null) goto L42;
        com.bytedance.kmp.ec.yata.store.node.c r113 = r9.a;
        if (r113 == null) goto L42;
        String r114 = r113.getNodeName();
    L43:
        r20[3] = TuplesKt.to("node_name", r114);
        if (r9 == null) goto L46;
        String r115 = r9.c;
    L47:
        r20[4] = TuplesKt.to("operator_type", r115);
        CartViewModel.doEventAction$default(r6.h, "yata_cart_loading_state", MapsKt.mutableMapOf(r20), null, 4, null);
        r6.j.compareAndSet(-1, System.currentTimeMillis());
        List<String> r21 = r6.k;
        StringBuilder r22 = new StringBuilder();
        r22.append(r7);
        r22.append('_');
        if (r9 == null) goto L52;
        com.bytedance.kmp.ec.yata.store.node.c r116 = r9.a;
        if (r116 == null) goto L52;
        String r117 = r116.getNodeName();
    L53:
        r22.append(r117);
        r22.append('_');
        if (r9 == null) goto L56;
        String r118 = r9.b;
    L57:
        r22.append(r118);
        r22.append('_');
        if (r9 == null) goto L60;
        r111 = r9.c;
    L60:
        r22.append(r111);
        ((ArrayList) r21).add(r22.toString());
        return;
    L56:
        r118 = null;
    L52:
        r117 = null;
        goto L53
    L46:
        r115 = null;
    L42:
        r114 = null;
        goto L43
    L36:
        r112 = null;
        goto L37
    }
}
