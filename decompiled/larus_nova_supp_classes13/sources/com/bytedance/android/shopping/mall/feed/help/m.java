package com.bytedance.android.shopping.mall.feed.help;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m implements Runnable {
    public final /* synthetic */ Map a;
    public final /* synthetic */ String b;

    public m(Map r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JSONObject r0 = com.bytedance.android.ec.hybrid.list.util.k.b(this.a);     // Catch: Throwable -> L4
        r0.putOpt("business_type", this.b);     // Catch: Throwable -> L4
        AppLogNewUtils.onEventV3("mall_card_tag_repeat", r0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
