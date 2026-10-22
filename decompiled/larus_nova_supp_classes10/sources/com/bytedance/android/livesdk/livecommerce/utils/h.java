package com.bytedance.android.livesdk.livecommerce.utils;

import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements com.bytedance.android.ec.opt.asynctask.w {
    public h() {
    }

    public final com.bytedance.android.ec.opt.asynctask.k r() {
        com.bytedance.android.ec.opt.asynctask.r r0 = new com.bytedance.android.ec.opt.asynctask.r();
        r0.b = true;
        return r0.f;
    }

    public final void run() {
        ((LinkedHashMap) ECCartMonitor.c).clear();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L24
        Integer r2 = (Integer) EComABUtils.getLiveSettingValue(EComABUtils.SETTING_EC_LIVE_CART_LOG_REPORT, 0);     // Catch: Throwable -> L24
        if (r2 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L22;
        List r4 = com.bytedance.android.ec.core.utils.u0.e((String) EComABUtils.getLiveSettingValue(EComABUtils.SETTING_EC_LIVE_CART_LOG_RULE, ""), JsonObject[].class);     // Catch: Throwable -> L24
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));     // Catch: Throwable -> L24
        Iterator r6 = r4.iterator();     // Catch: Throwable -> L24
    L13:
        if (r6.hasNext() == false) goto L22;
        JsonObject r7 = (JsonObject) r6.next();     // Catch: Throwable -> L24
        LogRule.Companion.getClass();     // Catch: Throwable -> L24
        LogRule r8 = LogRule.a.a(r7);     // Catch: Throwable -> L24
        if (r8 == null) goto L20;
        Map<String, List<LogRule>> r9 = ECCartMonitor.c;     // Catch: Throwable -> L24
        List r10 = (List) ((LinkedHashMap) r9).get(r8.getIntrinsicOn());     // Catch: Throwable -> L24
        if (r10 == null) goto L19;
        Boolean r11 = Boolean.valueOf(r10.add(r8));     // Catch: Throwable -> L24
    L21:
        r5.add(r11);     // Catch: Throwable -> L24
        goto L13
    L19:
        r9.put(r8.getIntrinsicOn(), CollectionsKt.mutableListOf(new LogRule[]{r8}));     // Catch: Throwable -> L24
        r11 = Unit.INSTANCE;     // Catch: Throwable -> L24
        goto L21
    L20:
        r11 = null;
    L22:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        ECCartMonitor.a = true ^ ECCartMonitor.c.isEmpty();
        return;
    L7:
        if (r2.intValue() != 1) goto L9;
        r3 = true;
    L24:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }
}
