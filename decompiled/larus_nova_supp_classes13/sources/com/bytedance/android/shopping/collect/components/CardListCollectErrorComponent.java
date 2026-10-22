package com.bytedance.android.shopping.collect.components;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.shopping.card_list.components.CardListTrackerComponent;
import com.bytedance.android.shopping.card_list.components.b;
import com.bytedance.android.shopping.card_list.components.f;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.monitor.CardListYataMonitorManager;
import com.bytedance.android.shopping.card_list.monitor.error.CardListErrorMonitorType;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListCollectErrorComponent extends b implements f {
    public View d;
    public boolean e;
    public final Lazy f;
    public final Lazy g;
    public final String h;
    public final Lazy i;
    public final Lazy j;
    public final CardListObjectContainer k;
    public final ViewGroup l;

    @Override // com.bytedance.android.shopping.card_list.components.f
    public final void hide() {
        this.e = false;
        ConstraintLayout r1 = (ConstraintLayout) this.j.getValue();
        if (r1 == null) goto L5;
        r1.setVisibility(0);
    L5:
        this.l.setVisibility(8);
    }

    @Override // com.bytedance.android.shopping.card_list.components.f
    public final void show() {
        this.e = true;
        if (this.d != null) goto L9;
        View r0 = LayoutInflater.from(this.l.getContext()).inflate(2131560669, this.l, false);
        this.d = r0;
        this.l.addView(r0);
        View r1 = this.d;
        if (r1 == null) goto L9;
        View r2 = r1.findViewById(2131390547);
        if (r2 == null) goto L9;
        r2.setOnClickListener(new a(this));
    L9:
        ConstraintLayout r3 = (ConstraintLayout) this.j.getValue();
        if (r3 == null) goto L12;
        r3.setVisibility(8);
    L12:
        this.l.setVisibility(0);
        CardListTrackerComponent r4 = (CardListTrackerComponent) this.f.getValue();
        if (r4 == null) goto L15;
        CardListTrackerComponent.h(r4, this.k.f.getStandardShowEventName(), MapsKt.mapOf(TuplesKt.to("tab_name", "error_view")), 4);
    L15:
        CardListYataMonitorManager r5 = (CardListYataMonitorManager) this.i.getValue();
        if (r5 == null) goto L21;
        com.bytedance.android.shopping.card_list.monitor.error.a r6 = r5.e;
        if (r6 == null) goto L22;
        CardListErrorMonitorType r7 = CardListErrorMonitorType.ERROR_VIEW_SHOW;
        Map<String, com.bytedance.android.shopping.card_list.monitor.error.a> r8 = com.bytedance.android.shopping.card_list.monitor.error.a.b;
        r6.b(r7, "ErrorView-Show", null);
        return;
    L22:
        return;
    }

    @Override // com.bytedance.android.shopping.card_list.components.f
    public final boolean b() {
        return this.e;
    }

    public CardListCollectErrorComponent(CardListObjectContainer r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        Intrinsics.checkNotNullParameter(r3, "errorViewContainer");
        super(r2);
        this.k = r2;
        this.l = r3;
        this.f = LazyKt.lazy(new CardListCollectErrorComponent$trackerComponent$2(this));
        this.g = LazyKt.lazy(new CardListCollectErrorComponent$queryFetchComponent$2(this));
        CardPassThroughData r4 = r2.e.a;
        if (r4 == null) goto L5;
        String r5 = r4.getMonitorId();
    L6:
        this.h = r5;
        this.i = LazyKt.lazy(new CardListCollectErrorComponent$monitorManager$2(this));
        this.j = LazyKt.lazy(new CardListCollectErrorComponent$mainLayout$2(this));
        return;
    L5:
        r5 = null;
        goto L6
    }
}
