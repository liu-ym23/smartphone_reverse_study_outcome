package com.bytedance.ug.sdk.luckydog.task;

import java.util.List;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f271930a = null;

    static {
        f271930a = CollectionsKt.listOf(new String[]{"transfer_target", "luckydog_target_page"});
    }

    public static void a(String r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ThirdPartyExchangeManager", "reportHandleThirdPartyExchange onCall, transferTarget: ".concat(r100));
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L5
        r101.put("transfer_target", r100);     // Catch: Throwable -> L5
        com.bytedance.ug.sdk.luckydog.api.log.b.a("luckydog_handle_exchange_schema", r101);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.c("ThirdPartyExchangeManager", th.getLocalizedMessage(), th);
    }
}
