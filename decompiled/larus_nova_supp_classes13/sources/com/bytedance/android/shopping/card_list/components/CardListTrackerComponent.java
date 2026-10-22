package com.bytedance.android.shopping.card_list.components;

import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.params.CartPassThroughData;
import com.bytedance.android.shopping.card_list.params.CollectPassThroughData;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListTrackerComponent extends b {
    public final gb3.a d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final AtomicBoolean h;
    public final CardListObjectContainer i;

    public static final class a {
    }

    static {
    }

    public CardListTrackerComponent(CardListObjectContainer r3) {
        Intrinsics.checkNotNullParameter(r3, "objectContainer");
        super(r3);
        this.i = r3;
        this.d = new gb3.a(r3.f.getPageName(), r3.f.getPageType());
        this.e = LazyKt.lazy(new CardListTrackerComponent$cardListSliceCustomWidgetAdapterComponent$2(this));
        this.f = LazyKt.lazy(new CardListTrackerComponent$yataInstance$2(this));
        this.g = LazyKt.lazy(new CardListTrackerComponent$monitorId$2(this));
        this.h = new AtomicBoolean(false);
    }

    public final void g(String r7, Map<String, ? extends Object> r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "name");
        Intrinsics.checkNotNullParameter(r8, "params");
        LinkedHashMap r0 = new LinkedHashMap();
        CardPassThroughData r1 = this.i.e.a;
        Pair[] r2 = new Pair[4];
        r2[0] = TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
        String r3 = this.i.f.getPageName();
        if (r3 != null) goto L5;
        r3 = "product_card_list_page";
    L5:
        r2[1] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, r3);
        r2[2] = TuplesKt.to("session_id", this.i.e.i);
        String r4 = this.i.f.getPageType();
        if (r4 != null) goto L8;
        r4 = "none";
    L8:
        r2[3] = TuplesKt.to("page_type", r4);
        Map r5 = MapsKt.mutableMapOf(r2);
        if (r1 == null) goto L15;
        CollectPassThroughData r6 = r1.getCollectSchemaData();
        if (r6 == null) goto L15;
        String r10 = r6.getPreviousPage();
        if (r10 == null) goto L15;
        r5.put("previous_page", r10);
    L15:
        if (r1 == null) goto L31;
        CartPassThroughData r11 = r1.getCartSchemaData();
        if (r11 == null) goto L31;
        r5.put("is_split_screen", Integer.valueOf(com.bytedance.android.shopping.extensions.k.q(Boolean.valueOf(this.i.e.m))));
        CardListSliceCustomWidgetAdapterComponent r12 = (CardListSliceCustomWidgetAdapterComponent) this.e.getValue();
        if (r12 == null) goto L22;
        String r13 = r12.f;
        if (r13 == null) goto L22;
    L23:
        r5.put("top_tab_name", r13);
        String r14 = r11.getHistoryPath();
        String r15 = "";
        if (r14 != null) goto L26;
        r14 = "";
    L26:
        r5.put("previous_page", r14);
        String r16 = r11.getNewSourceType();
        if (r16 == null) goto L30;
        r15 = r16;
    L30:
        r5.put("new_source_type", r15);
        r5.put("area_type", "104");
    L22:
        r13 = "MAIN";
    L31:
        r0.putAll(r5);
        r0.putAll(r8);
        this.d.a(r7, r0, this.i.e.g, r9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void h(CardListTrackerComponent r0, String r1, Map r2, int r3) {
        if ((r3 & 2) == 0) goto L5;
        r2 = MapsKt.emptyMap();
    L5:
        r0.g(r1, r2, null);
    }
}
