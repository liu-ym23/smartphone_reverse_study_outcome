package com.bytedance.android.shopping.new_cart.components;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.anchorv3.compat.UserInteractFrameLayout;
import com.bytedance.android.shopping.card_list.components.CardListTrackerComponent;
import com.bytedance.android.shopping.card_list.components.r;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.widgets.CardListRootFrameLayoutContainer;
import com.bytedance.android.shopping.new_cart.widgets.CardListCartLoadingView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class KitCartLoadingComponent extends com.bytedance.android.shopping.card_list.components.b implements com.bytedance.android.shopping.card_list.components.k {
    public static final /* synthetic */ int s = 0;
    public View d;
    public View e;
    public final Lazy f;
    public final Lazy g;
    public boolean h;
    public final AtomicLong i;
    public List<String> j;
    public String k;
    public final String l;
    public final Lazy m;
    public final AtomicBoolean n;
    public final Lazy o;
    public final Lazy p;
    public final CardListObjectContainer q;
    public final ViewGroup r;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.components.KitCartLoadingComponent$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004*\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/shopping/card_list/components/r;", "Lcom/bytedance/android/shopping/new_cart/widgets/CardListCartLoadingView;", "Lcom/bytedance/android/shopping/new_cart/widgets/l;", "Lcom/bytedance/android/shopping/new_cart/widgets/k;", "", "invoke", "(Lcom/bytedance/android/shopping/card_list/components/r;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function1<r<CardListCartLoadingView, com.bytedance.android.shopping.new_cart.widgets.l, com.bytedance.android.shopping.new_cart.widgets.k>, Unit> {
        final /* synthetic */ KitCartLoadingComponent this$0;

        public AnonymousClass1(KitCartLoadingComponent r1) {
            this.this$0 = r1;
            super(1);
        }

        public final void invoke(r<CardListCartLoadingView, com.bytedance.android.shopping.new_cart.widgets.l, com.bytedance.android.shopping.new_cart.widgets.k> r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            r2.c(new C01171(this));
            r2.a(new AnonymousClass2(this));
            r2.d(new AnonymousClass3(this));
            r2.b(new AnonymousClass4(this));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((r) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ KitCartLoadingComponent a;

        public b(KitCartLoadingComponent r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            CardListTrackerComponent r6 = (CardListTrackerComponent) this.a.o.getValue();
            if (r6 == null) goto L6;
            CardListTrackerComponent.h(r6, this.a.q.f.getStandardClickEventName(), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("scene", this.a.k), TuplesKt.to("tab_name", "loading_view")}), 4);
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public static final class d implements View.OnClickListener {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    static {
    }

    public final CardListCartLoadingView g() {
        return (CardListCartLoadingView) this.p.getValue();
    }

    public final void h() {
        if (this.n.compareAndSet(false, true) == false) goto L6;
        g().Y5();
        g().setNeedHint(true);
        g().setOnClickListener(new b(this));
        return;
    }

    @Override // com.bytedance.android.shopping.card_list.components.b, com.bytedance.android.shopping.card_list.components.a
    public final void onCreate() {
        super.onCreate();
        View r0 = new View(e());
        r0.setId(2131371242);
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-1, com.bytedance.android.shopping.extensions.b.b(70));
        r1.gravity = 8388611;
        r1.topMargin = com.bytedance.android.shopping.extensions.b.b(80);
        Unit r4 = Unit.INSTANCE;
        r0.setLayoutParams(r1);
        r0.setVisibility(8);
        r0.setOnClickListener(c.a);
        this.e = r0;
        View r2 = new View(e());
        r2.setId(2131371241);
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-1, com.bytedance.android.shopping.extensions.b.b(64));
        r5.gravity = 80;
        r2.setLayoutParams(r5);
        r2.setVisibility(8);
        r2.setOnClickListener(d.a);
        this.d = r2;
        UserInteractFrameLayout r3 = (CardListRootFrameLayoutContainer) this.q.d(2131365188);
        if (r3 == null) goto L6;
        r3.addView(this.e);
        r3.addView(this.d);
        return;
    }

    @Override // com.bytedance.android.shopping.card_list.components.b, com.bytedance.android.shopping.card_list.components.a
    public final void onDestroy() {
        super.onDestroy();
        a("destroy", null);
    }

    @Override // com.bytedance.android.shopping.card_list.components.k
    public final boolean isLoading() {
        return this.h;
    }

    public KitCartLoadingComponent(CardListObjectContainer r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "objectContainer");
        Intrinsics.checkNotNullParameter(r4, "loadingViewContainer");
        super(r3);
        this.q = r3;
        this.r = r4;
        this.f = LazyKt.lazy(new KitCartLoadingComponent$placeHolderGroup$2(this));
        this.g = LazyKt.lazy(new KitCartLoadingComponent$bottomHolderGroup$2(this));
        this.i = new AtomicLong(-1);
        this.j = new ArrayList();
        CardPassThroughData r5 = r3.e.a;
        if (r5 == null) goto L5;
        String r6 = r5.getMonitorId();
    L6:
        this.l = r6;
        this.m = LazyKt.lazy(new KitCartLoadingComponent$monitorManager$2(this));
        this.n = new AtomicBoolean(false);
        this.o = LazyKt.lazy(new KitCartLoadingComponent$trackerComponent$2(this));
        this.p = LazyKt.lazy(new KitCartLoadingComponent$loadingView$2(this));
        r r7 = com.bytedance.android.shopping.card_list.components.d.a(new AnonymousClass1(this));
        Intrinsics.checkNotNullParameter(r7, "scene");
        this.a = r7;
        return;
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.card_list.components.k
    public final void a(String r10, com.bytedance.kmp.ec.yata.common.biz.callback.a r11) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        this.r.setVisibility(8);
        boolean r1 = false;
        this.h = false;
        g().b6();
        Iterator r3 = ((List) this.f.getValue()).iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        View r4 = (View) r3.next();
        if (r4 == null) goto L4;
        r4.setVisibility(8);
        goto L4
    L8:
        Iterator r5 = ((List) this.g.getValue()).iterator();
    L10:
        if (r5.hasNext() == false) goto L15;
        View r6 = (View) r5.next();
        if (r6 == null) goto L10;
        r6.setVisibility(8);
        goto L10
    L15:
        if (this.i.get() == (-1)) goto L53;
        Pair[] r2 = new Pair[7];
        r2[0] = TuplesKt.to("state", "stop");
        r2[1] = TuplesKt.to("scene", r10);
        Long r12 = null;
        if (r11 == null) goto L20;
        String r7 = r11.b;
    L21:
        r2[2] = TuplesKt.to("trigger", r7);
        if (r11 == null) goto L26;
        com.bytedance.kmp.ec.yata.store.node.c r8 = r11.a;
        if (r8 == null) goto L26;
        String r9 = r8.getNodeName();
    L27:
        r2[3] = TuplesKt.to("node_name", r9);
        if (r11 == null) goto L30;
        String r13 = r11.c;
    L31:
        r2[4] = TuplesKt.to("operator_type", r13);
        r2[5] = TuplesKt.to("actions", this.j);
        r2[6] = TuplesKt.to("action_size", Integer.valueOf(((ArrayList) this.j).size()));
        Map r14 = MapsKt.mutableMapOf(r2);
        Long r15 = Long.valueOf(this.i.get());
        if (r15.longValue() == (-1)) goto L34;
        r1 = true;
    L34:
        if (r1 == false) goto L36;
        r12 = r15;
    L36:
        if (r12 == null) goto L38;
        r14.put("duration", Long.valueOf(System.currentTimeMillis() - r12.longValue()));
    L38:
        CardListTrackerComponent r16 = (CardListTrackerComponent) this.o.getValue();
        if (r16 == null) goto L41;
        CardListTrackerComponent.h(r16, "yata_card_list_loading_state", r14, 4);
    L41:
        this.i.set(-1);
        this.j = new ArrayList();
        return;
    L30:
        r13 = null;
    L26:
        r9 = null;
        goto L27
    L20:
        r7 = null;
        goto L21
    }

    @Override // com.bytedance.android.shopping.card_list.components.k
    public final void c(String r4, boolean r5, com.bytedance.kmp.ec.yata.common.biz.callback.a r6, boolean r7, boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        this.r.setVisibility(0);
        h();
        if (r7 == false) goto L5;
        this.h = true;
        g().setNeedHint(r5);
        g().Z5();
    L5:
        if (r8 == false) goto L12;
        Iterator r10 = ((List) this.f.getValue()).iterator();
    L8:
        if (r10.hasNext() == false) goto L12;
        View r11 = (View) r10.next();
        if (r11 == null) goto L8;
        r11.setVisibility(0);
    L12:
        if (r9 == false) goto L19;
        Iterator r12 = ((List) this.g.getValue()).iterator();
    L15:
        if (r12.hasNext() == false) goto L19;
        View r13 = (View) r12.next();
        if (r13 == null) goto L15;
        r13.setVisibility(0);
    L19:
        this.k = r4;
        Pair[] r14 = new Pair[5];
        r14[0] = TuplesKt.to("state", "start");
        r14[1] = TuplesKt.to("scene", r4);
        String r15 = null;
        if (r6 == null) goto L22;
        String r16 = r6.b;
    L23:
        r14[2] = TuplesKt.to("trigger", r16);
        if (r6 == null) goto L28;
        com.bytedance.kmp.ec.yata.store.node.c r17 = r6.a;
        if (r17 == null) goto L28;
        String r18 = r17.getNodeName();
    L29:
        r14[3] = TuplesKt.to("node_name", r18);
        if (r6 == null) goto L32;
        String r19 = r6.c;
    L33:
        r14[4] = TuplesKt.to("operator_type", r19);
        Map r20 = MapsKt.mutableMapOf(r14);
        CardListTrackerComponent r21 = (CardListTrackerComponent) this.o.getValue();
        if (r21 == null) goto L36;
        CardListTrackerComponent.h(r21, "yata_card_list_loading_state", r20, 4);
    L36:
        this.i.compareAndSet(-1, System.currentTimeMillis());
        List<String> r22 = this.j;
        StringBuilder r23 = new StringBuilder();
        r23.append(r4);
        r23.append('_');
        if (r6 == null) goto L41;
        com.bytedance.kmp.ec.yata.store.node.c r24 = r6.a;
        if (r24 == null) goto L41;
        String r25 = r24.getNodeName();
    L42:
        r23.append(r25);
        r23.append('_');
        if (r6 == null) goto L45;
        String r26 = r6.b;
    L46:
        r23.append(r26);
        r23.append('_');
        if (r6 == null) goto L49;
        r15 = r6.c;
    L49:
        r23.append(r15);
        ((ArrayList) r22).add(r23.toString());
        return;
    L45:
        r26 = null;
    L41:
        r25 = null;
        goto L42
    L32:
        r19 = null;
    L28:
        r18 = null;
        goto L29
    L22:
        r16 = null;
        goto L23
    }
}
