package com.bytedance.android.shopping.new_cart.components;

import android.view.ViewGroup;
import com.bytedance.android.shopping.card_list.components.CardListTrackerComponent;
import com.bytedance.android.shopping.card_list.components.r;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.monitor.CardListYataMonitorManager;
import com.bytedance.android.shopping.card_list.monitor.error.CardListErrorMonitorType;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.new_cart.widgets.CardListCartErrorView;
import com.bytedance.android.shopping.new_cart.widgets.ErrorViewAction;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListCartErrorComponent extends com.bytedance.android.shopping.card_list.components.b implements com.bytedance.android.shopping.card_list.components.f {
    public CardListCartErrorView d;
    public boolean e;
    public final Lazy f;
    public final Lazy g;
    public final String h;
    public final Lazy i;
    public final Lazy j;
    public final com.bytedance.android.shopping.new_cart.widgets.i k;
    public final r l;
    public final CardListObjectContainer m;
    public final ViewGroup n;

    @Override // com.bytedance.android.shopping.card_list.components.f
    public final void hide() {
        this.e = false;
        this.n.setVisibility(8);
        this.k.c.setValue(Boolean.FALSE);
        com.bytedance.android.shopping.card_list.utils.a.HandlerC0036a r0 = com.bytedance.android.shopping.card_list.utils.a.a;
        com.bytedance.android.shopping.card_list.utils.a.b(new AnonymousClass1(this));
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [VIEW_TYPE extends android.view.View, com.bytedance.android.shopping.new_cart.widgets.CardListCartErrorView] */
    @Override // com.bytedance.android.shopping.card_list.components.f
    public final void show() {
        this.e = true;
        if (this.d != null) goto L8;
        ?? r0 = new CardListCartErrorView(this.n.getContext(), null, 6, 0);
        this.d = r0;
        r r3 = this.l;
        r0.setViewState(this.k);
        ACTION r4 = this.l.c;
        if (r4 != 0) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L7:
        r0.setViewAction((ErrorViewAction) r4);
        r0.initView();
        r0.setObjectContainer(this.m);
        Unit r5 = Unit.INSTANCE;
        r3.a = r0;
        this.n.addView(this.d);
    L8:
        this.n.setVisibility(0);
        CardListTrackerComponent r1 = (CardListTrackerComponent) this.f.getValue();
        if (r1 == null) goto L11;
        CardListTrackerComponent.h(r1, this.m.f.getStandardShowEventName(), MapsKt.mapOf(TuplesKt.to("tab_name", "error_view")), 4);
    L11:
        CardListYataMonitorManager r2 = (CardListYataMonitorManager) this.i.getValue();
        if (r2 == null) goto L16;
        com.bytedance.android.shopping.card_list.monitor.error.a r6 = r2.e;
        if (r6 == null) goto L16;
        CardListErrorMonitorType r7 = CardListErrorMonitorType.ERROR_VIEW_SHOW;
        Map<String, com.bytedance.android.shopping.card_list.monitor.error.a> r8 = com.bytedance.android.shopping.card_list.monitor.error.a.b;
        r6.b(r7, "ErrorView-Show", null);
    L16:
        this.k.c.setValue(Boolean.TRUE);
        com.bytedance.android.shopping.card_list.utils.a.HandlerC0036a r9 = com.bytedance.android.shopping.card_list.utils.a.a;
        com.bytedance.android.shopping.card_list.utils.a.a(this.m, 1000, new C02741(this));
    }

    @Override // com.bytedance.android.shopping.card_list.components.b, com.bytedance.android.shopping.card_list.components.a
    public final void onCreate() {
        super.onCreate();
        r r0 = this.l;
        Intrinsics.checkNotNullParameter(r0, "scene");
        this.a = r0;
    }

    @Override // com.bytedance.android.shopping.card_list.components.f
    public final boolean b() {
        return this.e;
    }

    public CardListCartErrorComponent(CardListObjectContainer r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        Intrinsics.checkNotNullParameter(r3, "errorViewContainer");
        super(r2);
        this.m = r2;
        this.n = r3;
        this.f = LazyKt.lazy(new CardListCartErrorComponent$trackerComponent$2(this));
        this.g = LazyKt.lazy(new CardListCartErrorComponent$queryFetchComponent$2(this));
        CardPassThroughData r4 = r2.e.a;
        if (r4 == null) goto L5;
        String r5 = r4.getMonitorId();
    L6:
        this.h = r5;
        this.i = LazyKt.lazy(new CardListCartErrorComponent$monitorManager$2(this));
        this.j = LazyKt.lazy(new CardListCartErrorComponent$bodyComponent$2(this));
        this.k = new com.bytedance.android.shopping.new_cart.widgets.i(this.b);
        this.l = com.bytedance.android.shopping.card_list.components.d.a(new CardListCartErrorComponent$scene$1(this));
        return;
    L5:
        r5 = null;
        goto L6
    }
}
