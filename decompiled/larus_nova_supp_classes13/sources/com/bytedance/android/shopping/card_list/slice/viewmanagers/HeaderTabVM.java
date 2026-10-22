package com.bytedance.android.shopping.card_list.slice.viewmanagers;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.shopping.card_list.monitor.CardListYataMonitorManager;
import com.bytedance.android.shopping.card_list.monitor.error.CardListErrorMonitorType;
import com.bytedance.android.shopping.card_list.slice.widgets.CardListHeaderTab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class HeaderTabVM extends BaseSlcViewManager<CardListHeaderTab> {
    public static final /* synthetic */ int M3 = 0;
    public final Lazy H3;
    public final Lazy I3;
    public final Lazy J3;
    public final Lazy K3;
    public final SlcTemplateContext L3;

    public HeaderTabVM(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "slcTemplateContext");
        super(r2);
        this.L3 = r2;
        this.H3 = LazyKt.lazy(new HeaderTabVM$provider$2(this));
        this.I3 = LazyKt.lazy(new HeaderTabVM$objectContainer$2(this));
        this.J3 = LazyKt.lazy(new HeaderTabVM$monitorId$2(this));
        this.K3 = LazyKt.lazy(new HeaderTabVM$monitorManager$2(this));
    }

    public final View A0(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new CardListHeaderTab(r3, this.L3);
    }

    public final void H0(Map<String, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r8, "props");
        ArrayList r0 = new ArrayList();
        Object r1 = r8.get("tab_list");
        Object r2 = null;
        if (r1 == null) goto L30;
        boolean r3 = r1 instanceof List;
        if (r3 == false) goto L30;
        if (r3 == true) goto L8;
        r1 = null;
    L8:
        List r4 = (List) r1;
        if (r4 == null) goto L30;
        Iterator r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L30;
        Map r6 = (Map) r5.next();
        int r7 = com.bytedance.android.shopping.card_list.utils.f.a;
        String r9 = (String) this.J3.getValue();
        Intrinsics.checkNotNullParameter(i.class, "objectClass");
        if (r6 != null) goto L16;
    L26:
        Object r10 = null;
    L27:
        i r11 = (i) r10;
        if (r11 == null) goto L12;
        r0.add(r11);
        goto L12
    L16:
        if (r6.isEmpty() == true) goto L26;
        r10 = u0.b(k.d(r6), i.class);     // Catch: Throwable -> L20
    L20:
        Map<String, CardListYataMonitorManager> r12 = CardListYataMonitorManager.k;
        CardListYataMonitorManager r13 = CardListYataMonitorManager.a.a(r9);
        if (r13 == null) goto L23;
        com.bytedance.android.shopping.card_list.monitor.error.a r14 = r13.e;
    L24:
        if (r14 == null) goto L26;
        CardListErrorMonitorType r15 = CardListErrorMonitorType.GET_OBJECT_FROM_MAP;
        Map<String, com.bytedance.android.shopping.card_list.monitor.error.a> r16 = com.bytedance.android.shopping.card_list.monitor.error.a.b;
        r14.b(r15, "CardListCommonUtils-getObjectFromMap", null);
        goto L26
    L23:
        r14 = null;
    L30:
        Object r17 = r8.get("tab_color");
        if ((r17 instanceof String) == true) goto L33;
        r17 = null;
    L33:
        String r18 = (String) r17;
        if (r18 != null) goto L36;
        r18 = "#FF3344";
    L36:
        CardListHeaderTab r19 = (CardListHeaderTab) getView();
        Object r20 = r8.get("selected_tab_type");
        if ((r20 instanceof String) == false) goto L40;
        r2 = r20;
    L40:
        r19.g(r0, (String) r2, r18);
    }
}
