package com.bytedance.android.shopping.card_list.widgets.gul;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.api.mall.feed.e;
import com.bytedance.android.shopping.card_list.components.CardListBodyComponent;
import com.bytedance.android.shopping.card_list.components.CardListSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.params.CartPassThroughData;
import com.bytedance.android.shopping.card_list.params.CollectPassThroughData;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.utils.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFeedContainerAbility implements e, t {
    public final Lazy a;
    public Map<String, Object> b;
    public boolean c;
    public final Context d;
    public final CardListObjectContainer e;

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final /* bridge */ /* synthetic */ yj.e Pn() {
        return null;
    }

    public final void g() {
        this.c = true;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final Map<String, Object> getGlobalProps() {
        Pair[] r0 = new Pair[1];
        CardListSliceCustomWidgetAdapterComponent r1 = (CardListSliceCustomWidgetAdapterComponent) this.a.getValue();
        if (r1 == null) goto L5;
        String r2 = r1.f;
    L6:
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r0[0] = TuplesKt.to("current_tab", r2);
        Map<String, Object> r3 = MapsKt.mutableMapOf(r0);
        r3.putAll(a());
        return r3;
    L5:
        r2 = null;
        goto L6
    }

    public final Map<String, Object> a() {
        if (this.b != null) goto L54;
        LinkedHashMap r0 = new LinkedHashMap();
        CardListObjectContainer r1 = this.e;
        if (r1 == null) goto L53;
        com.bytedance.android.shopping.card_list.common_params.a r2 = r1.e;
        if (r2 == null) goto L53;
        CardPassThroughData r3 = r2.a;
        if (r3 == null) goto L53;
        HashMap<String, String> r4 = r3.getSchemaParams();
        boolean r5 = true;
        if (r4 == null) goto L22;
        Set<Map.Entry<String, String>> r6 = r4.entrySet();
        if (r6 == null) goto L22;
        Iterator<T> r7 = r6.iterator();
    L16:
        if (r7.hasNext() == false) goto L22;
        Map.Entry r8 = (Map.Entry) r7.next();
        if ((!StringsKt.isBlank((CharSequence) r8.getKey())) == false) goto L16;
        if ((!StringsKt.isBlank((CharSequence) r8.getValue())) == false) goto L16;
        r0.put(r8.getKey(), r8.getValue());
    L22:
        String r9 = this.e.f.getPageName();
        if (r9 != null) goto L25;
        r9 = "";
    L25:
        r0.put(PdpOpenThirdParam.KEY_PAGE_NAME, r9);
        HashMap<String, String> r10 = r3.getSchemaParams();
        if (r10 == null) goto L28;
        String r11 = r10.get("ecom_scene_id");
    L29:
        String r12 = r11;
        if (r12 != null) goto L32;
    L35:
        String r13 = "1042";
        if (r5 == true) goto L42;
        List r14 = CollectionsKt.toMutableList(StringsKt.split$default(r12, new String[]{","}, false, 0, 6, null));
        if (r14.isEmpty() == true) goto L42;
        r14.add("1042");
        r13 = CollectionsKt.joinToString$default(r14, ",", null, null, 0, null, null, 62, null);
    L42:
        r0.put("ecom_scene_id", r13);
        CartPassThroughData r15 = r3.getCartSchemaData();
        if (r15 == null) goto L47;
        String r16 = r15.getHistoryPath();
        if (r16 == null) goto L47;
        r0.put(SimilarProductParam.ENTER_FROM, r16);
    L47:
        CollectPassThroughData r17 = r3.getCollectSchemaData();
        if (r17 == null) goto L52;
        String r18 = r17.getPreviousPage();
        if (r18 == null) goto L52;
        r0.put(SimilarProductParam.ENTER_FROM, r18);
    L52:
        r0.put("technology", "YATA_Android");
        goto L53
    L32:
        if (r12.length() == 0) goto L35;
        r5 = false;
        goto L35
    L28:
        r11 = null;
    L53:
        Unit r19 = Unit.INSTANCE;
        this.b = r0;
    L54:
        Map<String, Object> r20 = this.b;
        if (r20 == null) goto L57;
        return r20;
    L57:
        return new LinkedHashMap();
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final boolean isDarkMode() {
        if (ECAppInfoService.e.isNightMode() == false) goto L15;
        CardListObjectContainer r0 = this.e;
        if (r0 == null) goto L15;
        com.bytedance.android.shopping.card_list.common_params.a r1 = r0.e;
        if (r1 == null) goto L15;
        CardPassThroughData r2 = r1.a;
        if (r2 == null) goto L15;
        CollectPassThroughData r3 = r2.getCollectSchemaData();
        if (r3 == null) goto L15;
        if (r3.isFromPersonal() != true) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final boolean oi() {
        boolean r0 = this.c;
        this.c = false;
        return r0;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final LifecycleOwner s4() {
        LifecycleOwner r0 = ECHybridExtensionsKt.a(this.d);
        if (r0 == null) goto L7;
        return r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    }

    public ECMallFeedContainerAbility(Context r2, CardListObjectContainer r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.d = r2;
        this.e = r3;
        this.a = LazyKt.lazy(new ECMallFeedContainerAbility$sliceCustomWidgetAdapterComponent$2(this));
        if (r3 == null) goto L5;
        CardListBodyComponent r4 = (CardListBodyComponent) r3.b(Reflection.getOrCreateKotlinClass(CardListBodyComponent.class));
    L6:
        if (r4 == null) goto L9;
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) r4.e).add(this);
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final Map<String, Object> PN(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "apiKey");
        Intrinsics.checkNotNullParameter(r1, "apiKey");
        return null;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final Map<String, String> Xj(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "apiKey");
        Intrinsics.checkNotNullParameter(r1, "apiKey");
        return null;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final void jq(Map<String, ? extends Object> r3, Set<String> r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(a());
        if (r4 == null) goto L8;
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        r0.remove((String) r5.next());
    L8:
        if (r3 == null) goto L10;
        r0.putAll(r3);
    L10:
        this.b = r0;
    }
}
