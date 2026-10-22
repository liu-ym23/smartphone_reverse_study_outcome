package com.bytedance.android.shopping.collect.custom_view;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.shopping.api.mall.feed.h;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements com.bytedance.android.shopping.api.mall.feed.e {
    public Map<String, Object> a;
    public final h b;

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final boolean oi() {
        return false;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final yj.e Pn() {
        return this.b.i;
    }

    public final Map<String, Object> a() {
        if (this.a != null) goto L14;
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put(PdpOpenThirdParam.KEY_PAGE_NAME, this.b.a);
        String r1 = this.b.c;
        if (r1 == null) goto L7;
        r0.put("ecom_scene_id", r1);
    L7:
        String r2 = this.b.b;
        if (r2 == null) goto L10;
        r0.put(SimilarProductParam.ENTER_FROM, r2);
    L10:
        Map<String, Object> r3 = this.b.e;
        if (r3 == null) goto L13;
        r0.putAll(r3);
    L13:
        Unit r4 = Unit.INSTANCE;
        this.a = r0;
    L14:
        Map<String, Object> r5 = this.a;
        if (r5 == null) goto L17;
        return r5;
    L17:
        return new LinkedHashMap();
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final Map<String, Object> getGlobalProps() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(a());
        return r0;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final boolean isDarkMode() {
        return this.b.d;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final LifecycleOwner s4() {
        return this.b.g;
    }

    public e(h r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.b = r2;
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
        this.a = r0;
    }
}
