package com.bytedance.android.shopping.store.tabkit.bridge;

import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.android.shopping.store.tabkit.model.k;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public final TabKitViewModel a;

    public c(TabKitViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.a = r2;
    }

    public final void b(k r4) {
        Intrinsics.checkNotNullParameter(r4, "tab");
        JSONObject r0 = new JSONObject();
        r0.put("tab_id", r4.n());
        r0.put("tab_item", r4.d);
        Unit r5 = Unit.INSTANCE;
        a("ecTabKit.tabItemDidShow", r0);
    }

    public final void a(String r3, JSONObject r4) {
        Iterator<T> r0 = this.a.getHybridComponents().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((l) r0.next()).sendJsEvent(r3, r4);
        goto L4
    L6:
        Iterator<T> r1 = this.a.getLynxCards().iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((ECLynxCard) r1.next()).o(r3, r4);
        goto L8
    }
}
