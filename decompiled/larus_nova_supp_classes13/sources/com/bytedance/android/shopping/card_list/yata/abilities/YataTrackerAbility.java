package com.bytedance.android.shopping.card_list.yata.abilities;

import com.bytedance.android.bcm.api.b;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v96.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class YataTrackerAbility implements h {
    public final Lazy a;
    public final Map<String, Object> b;
    public final CardListObjectContainer c;
    public final Function2<String, Map<String, Object>, Unit> d;

    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "btm");
        BtmSDK.INSTANCE.createBtmChain(new BtmItemBuilder(r4, Boolean.TRUE).withPageFinder((PageFinder) this.a.getValue()).build());
    }

    public final void c(Map<String, ? extends Object> r2) {
        PageFinder r0 = (PageFinder) this.a.getValue();
        if (r0 == null) goto L6;
        b.f(r0, r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public YataTrackerAbility(CardListObjectContainer r3, Function2<? super String, ? super Map<String, Object>, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "objectContainer");
        Intrinsics.checkNotNullParameter(r4, "trackCallback");
        this.c = r3;
        this.d = r4;
        this.a = LazyKt.lazy(new YataTrackerAbility$btmPageFinder$2(this));
        this.b = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android"), TuplesKt.to("area_type", "104"), TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, r3.f.getPageName())});
    }

    public final void a(String r3, Map<String, Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "params");
        if (ECAppInfoService.e.isDebug() == false) goto L5;
        r4.put("card_list_android_track_debug", "true");
    L5:
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(this.b);
        r0.putAll(r4);
        this.d.invoke(r3, r0);
    }
}
