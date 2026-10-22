package com.bytedance.android.shopping.collect.components;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.anchorv3.compat.UserInteractFrameLayout;
import com.bytedance.android.shopping.card_list.components.CardListTrackerComponent;
import com.bytedance.android.shopping.card_list.components.d;
import com.bytedance.android.shopping.card_list.components.k;
import com.bytedance.android.shopping.card_list.components.r;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.widgets.CardListRootFrameLayoutContainer;
import com.bytedance.android.shopping.collect.custom_view.CardListCollectLoadingView;
import com.bytedance.android.shopping.new_cart.widgets.l;
import com.bytedance.kmp.ec.yata.store.node.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
public final class KitCollectLoadingComponent extends com.bytedance.android.shopping.card_list.components.b implements k {
    public View d;
    public View e;
    public final Lazy f;
    public final Lazy g;
    public boolean h;
    public final AtomicLong i;
    public List<String> j;
    public final Lazy k;
    public final String l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final CardListObjectContainer p;
    public final ViewGroup q;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.collect.components.KitCollectLoadingComponent$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004*\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/shopping/card_list/components/r;", "Lcom/bytedance/android/shopping/collect/custom_view/CardListCollectLoadingView;", "Lcom/bytedance/android/shopping/new_cart/widgets/l;", "Lcom/bytedance/android/shopping/new_cart/widgets/k;", "", "invoke", "(Lcom/bytedance/android/shopping/card_list/components/r;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function1<r<CardListCollectLoadingView, l, com.bytedance.android.shopping.new_cart.widgets.k>, Unit> {
        final /* synthetic */ KitCollectLoadingComponent this$0;

        public AnonymousClass1(KitCollectLoadingComponent r1) {
            this.this$0 = r1;
            super(1);
        }

        public final void invoke(r<CardListCollectLoadingView, l, com.bytedance.android.shopping.new_cart.widgets.k> r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            r2.c(new C00411(this));
            r2.a(new AnonymousClass2(this));
            r2.d(new AnonymousClass3(this));
            r2.b(AnonymousClass4.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((r) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class a implements View.OnClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public static final class b implements View.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    @Override // com.bytedance.android.shopping.card_list.components.b, com.bytedance.android.shopping.card_list.components.a
    public final void onCreate() {
        super.onCreate();
        View r0 = new View(e());
        r0.setId(2131371242);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-1, com.bytedance.android.shopping.extensions.b.b(70));
        r1.gravity = 8388611;
        r1.topMargin = com.bytedance.android.shopping.extensions.b.b(80);
        Unit r4 = Unit.INSTANCE;
        r0.setLayoutParams(r1);
        r0.setVisibility(8);
        r0.setOnClickListener(a.a);
        this.e = r0;
        View r2 = new View(e());
        r2.setId(2131371241);
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(-1, com.bytedance.android.shopping.extensions.b.b(64));
        r5.gravity = 80;
        r2.setLayoutParams(r5);
        r2.setVisibility(8);
        r2.setOnClickListener(b.a);
        this.d = r2;
        UserInteractFrameLayout r3 = (CardListRootFrameLayoutContainer) this.p.d(2131365188);
        if (r3 == null) goto L6;
        r3.addView(this.e);
        r3.addView(this.d);
        return;
    }

    @Override // com.bytedance.android.shopping.card_list.components.k
    public final boolean isLoading() {
        return this.h;
    }

    public KitCollectLoadingComponent(CardListObjectContainer r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "objectContainer");
        Intrinsics.checkNotNullParameter(r5, "loadingViewContainer");
        super(r4);
        this.p = r4;
        this.q = r5;
        this.f = LazyKt.lazy(new KitCollectLoadingComponent$placeHolderGroup$2(this));
        this.g = LazyKt.lazy(new KitCollectLoadingComponent$bottomHolderGroup$2(this));
        this.i = new AtomicLong(-1);
        this.j = new ArrayList();
        this.k = LazyKt.lazy(new KitCollectLoadingComponent$pageCallBackComponent$2(this));
        CardPassThroughData r6 = r4.e.a;
        if (r6 == null) goto L5;
        String r7 = r6.getMonitorId();
    L6:
        this.l = r7;
        this.m = LazyKt.lazy(new KitCollectLoadingComponent$monitorManager$2(this));
        this.n = LazyKt.lazy(new KitCollectLoadingComponent$trackerComponent$2(this));
        this.o = LazyKt.lazy(new KitCollectLoadingComponent$loadingView$2(this));
        r5.setVisibility(0);
        r r8 = d.a(new AnonymousClass1(this));
        Intrinsics.checkNotNullParameter(r8, "scene");
        this.a = r8;
        return;
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.card_list.components.k
    public final void a(String r10, com.bytedance.kmp.ec.yata.common.biz.callback.a r11) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        boolean r1 = false;
        this.h = false;
        ((CardListCollectLoadingView) this.o.getValue()).V5();
        Iterator r2 = ((List) this.f.getValue()).iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        View r3 = (View) r2.next();
        if (r3 == null) goto L4;
        r3.setVisibility(8);
        goto L4
    L8:
        Iterator r4 = ((List) this.g.getValue()).iterator();
    L10:
        if (r4.hasNext() == false) goto L15;
        View r5 = (View) r4.next();
        if (r5 == null) goto L10;
        r5.setVisibility(8);
        goto L10
    L15:
        if (this.i.get() == (-1)) goto L53;
        Pair[] r6 = new Pair[7];
        r6[0] = TuplesKt.to("state", "stop");
        r6[1] = TuplesKt.to("scene", r10);
        Long r12 = null;
        if (r11 == null) goto L20;
        String r7 = r11.b;
    L21:
        r6[2] = TuplesKt.to("trigger", r7);
        if (r11 == null) goto L26;
        c r8 = r11.a;
        if (r8 == null) goto L26;
        String r9 = r8.getNodeName();
    L27:
        r6[3] = TuplesKt.to("node_name", r9);
        if (r11 == null) goto L30;
        String r13 = r11.c;
    L31:
        r6[4] = TuplesKt.to("operator_type", r13);
        r6[5] = TuplesKt.to("actions", this.j);
        r6[6] = TuplesKt.to("action_size", Integer.valueOf(((ArrayList) this.j).size()));
        Map r14 = MapsKt.mutableMapOf(r6);
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
        CardListTrackerComponent r16 = (CardListTrackerComponent) this.n.getValue();
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
    public final void c(String r3, boolean r4, com.bytedance.kmp.ec.yata.common.biz.callback.a r5, boolean r6, boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        if (r6 == false) goto L6;
        this.h = true;
        ((CardListCollectLoadingView) this.o.getValue()).U5(Intrinsics.areEqual(r3, "first_enter"));
    L6:
        if (r7 == false) goto L13;
        Iterator r9 = ((List) this.f.getValue()).iterator();
    L9:
        if (r9.hasNext() == false) goto L13;
        View r1 = (View) r9.next();
        if (r1 == null) goto L9;
        r1.setVisibility(0);
    L13:
        if (r8 == false) goto L20;
        Iterator r10 = ((List) this.g.getValue()).iterator();
    L16:
        if (r10.hasNext() == false) goto L20;
        View r11 = (View) r10.next();
        if (r11 == null) goto L16;
        r11.setVisibility(0);
    L20:
        Pair[] r12 = new Pair[5];
        r12[0] = TuplesKt.to("state", "start");
        r12[1] = TuplesKt.to("scene", r3);
        String r13 = null;
        if (r5 == null) goto L23;
        String r14 = r5.b;
    L24:
        r12[2] = TuplesKt.to("trigger", r14);
        if (r5 == null) goto L29;
        c r15 = r5.a;
        if (r15 == null) goto L29;
        String r16 = r15.getNodeName();
    L30:
        r12[3] = TuplesKt.to("node_name", r16);
        if (r5 == null) goto L33;
        String r17 = r5.c;
    L34:
        r12[4] = TuplesKt.to("operator_type", r17);
        Map r18 = MapsKt.mutableMapOf(r12);
        CardListTrackerComponent r19 = (CardListTrackerComponent) this.n.getValue();
        if (r19 == null) goto L37;
        CardListTrackerComponent.h(r19, "yata_card_list_loading_state", r18, 4);
    L37:
        this.i.compareAndSet(-1, System.currentTimeMillis());
        List<String> r20 = this.j;
        StringBuilder r21 = new StringBuilder();
        r21.append(r3);
        r21.append('_');
        if (r5 == null) goto L42;
        c r22 = r5.a;
        if (r22 == null) goto L42;
        String r23 = r22.getNodeName();
    L43:
        r21.append(r23);
        r21.append('_');
        if (r5 == null) goto L46;
        String r24 = r5.b;
    L47:
        r21.append(r24);
        r21.append('_');
        if (r5 == null) goto L50;
        r13 = r5.c;
    L50:
        r21.append(r13);
        ((ArrayList) r20).add(r21.toString());
        return;
    L46:
        r24 = null;
    L42:
        r23 = null;
        goto L43
    L33:
        r17 = null;
    L29:
        r16 = null;
        goto L30
    L23:
        r14 = null;
        goto L24
    }
}
