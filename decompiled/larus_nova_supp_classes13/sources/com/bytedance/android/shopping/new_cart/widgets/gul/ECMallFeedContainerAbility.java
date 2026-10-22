package com.bytedance.android.shopping.new_cart.widgets.gul;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.shopping.api.mall.feed.e;
import com.bytedance.android.shopping.new_cart.components.CartBodyComponent;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.CartSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.new_cart.params.CartParams;
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
    public final CartObjectContainer e;

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
        CartSliceCustomWidgetAdapterComponent r1 = (CartSliceCustomWidgetAdapterComponent) this.a.getValue();
        if (r1 == null) goto L5;
        String r2 = r1.c;
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

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final boolean isDarkMode() {
        return false;
    }

    public final Map<String, Object> a() {
        if (this.b != null) goto L44;
        LinkedHashMap r0 = new LinkedHashMap();
        CartObjectContainer r1 = this.e;
        if (r1 == null) goto L43;
        com.bytedance.android.shopping.new_cart.container.b r2 = r1.e;
        if (r2 == null) goto L43;
        CartParams r3 = r2.c;
        if (r3 == null) goto L43;
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
        r0.put(PdpOpenThirdParam.KEY_PAGE_NAME, "product_cart_page");
        HashMap<String, String> r9 = r3.getSchemaParams();
        if (r9 == null) goto L25;
        String r10 = r9.get("ecom_scene_id");
    L26:
        String r11 = r10;
        if (r11 != null) goto L29;
    L32:
        String r12 = "1042";
        if (r5 == true) goto L39;
        List r13 = CollectionsKt.toMutableList(StringsKt.split$default(r11, new String[]{","}, false, 0, 6, null));
        if (r13.isEmpty() == true) goto L39;
        r13.add("1042");
        r12 = CollectionsKt.joinToString$default(r13, ",", null, null, 0, null, null, 62, null);
    L39:
        r0.put("ecom_scene_id", r12);
        String r14 = r3.getHistoryPath();
        if (r14 == null) goto L42;
        r0.put(SimilarProductParam.ENTER_FROM, r14);
    L42:
        r0.put("technology", "YATA_Android");
        goto L43
    L29:
        if (r11.length() == 0) goto L32;
        r5 = false;
        goto L32
    L25:
        r10 = null;
    L43:
        Unit r15 = Unit.INSTANCE;
        this.b = r0;
    L44:
        Map<String, Object> r16 = this.b;
        if (r16 == null) goto L47;
        return r16;
    L47:
        return new LinkedHashMap();
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

    public ECMallFeedContainerAbility(Context r2, CartObjectContainer r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.d = r2;
        this.e = r3;
        this.a = LazyKt.lazy(new ECMallFeedContainerAbility$sliceCustomWidgetAdapterComponent$2(this));
        if (r3 == null) goto L5;
        CartBodyComponent r4 = (CartBodyComponent) r3.a(Reflection.getOrCreateKotlinClass(CartBodyComponent.class));
    L6:
        if (r4 == null) goto L9;
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) r4.c).add(this);
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
