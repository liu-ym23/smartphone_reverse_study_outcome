package com.bytedance.android.shopping.sku.inner.yata.abilities;

import android.content.Context;
import com.bytedance.android.shopping.sku.common.monitor.business.SkuBusinessMonitor;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonToast;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import v96.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements g {
    public final Context a;
    public final com.bytedance.android.shopping.sku.inner.container.b b;

    public final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "content");
        int r0 = SkuCommonToast.a;
        SkuCommonToast.b(this.a, r4);
        if (StringsKt.isBlank(r4) == true) goto L10;
        mh3.a r1 = this.b.qn().getMonitorManager();
        if (r1 == null) goto L11;
        SkuBusinessMonitor r2 = r1.b;
        if (r2 == null) goto L12;
        Intrinsics.checkNotNullParameter(r4, "str");
        JSONObject r3 = new JSONObject();
        r3.put("toast_message", r4);
        Unit r5 = Unit.INSTANCE;
        r2.b("toast", r3);
        return;
    L12:
        return;
    L11:
        return;
    }

    public d(Context r2, com.bytedance.android.shopping.sku.inner.container.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        this.a = r2;
        this.b = r3;
    }
}
