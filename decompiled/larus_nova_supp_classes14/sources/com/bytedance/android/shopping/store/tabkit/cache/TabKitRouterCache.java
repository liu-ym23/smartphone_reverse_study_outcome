package com.bytedance.android.shopping.store.tabkit.cache;

import com.bytedance.android.ec.core.opt.ab.p;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class TabKitRouterCache {
    public static final List<String> a = null;
    public static final Lazy b = null;

    public static ConcurrentHashMap b() {
        return (ConcurrentHashMap) b.getValue();
    }

    static {
        int r0 = hk3.a.a;
        int r1 = p.a;
        Object r2 = CollectionsKt.listOf(new String[]{"lifecycle_listener_id", "native_mall_launch_time", "native_mall_launch_type", "mall_open_page_time", "mall_homepage_open_time", "mall_click_enter_time", "source_btm_token", "fe_flag"});
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r4 = jj4.b.b;     // Catch: Throwable -> L7
        Object r5 = jj4.a.a("tabkit_deeplink_ignore_parameter", List.class, r2, false);     // Catch: Throwable -> L7
        if (r5 != null) goto L13;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L13:
        a = (List) r5;
        b = LazyKt.lazy(TabKitRouterCache$cache$2.INSTANCE);
        return;
    L7:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Object r7 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r7) == true) goto L12;
        r2 = r7;
    L12:
        r5 = r2;
        goto L13
    }

    public static a a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter("ec_request_id_placeholder", "key");
        int r0 = PrefetchRequestState.NO_STORE.getValue();
        if (b().isEmpty() == true) goto L12;
        String r4 = c.a(r3);
        if (r4 == null) goto L12;
        b r5 = (b) b().get(r4);
        if (r5 == null) goto L12;
        r5.getClass();
    L12:
        return new a(null, r0);
    }

    public static JSONObject c(String r4) {
        if (r4 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        return null;
    L12:
        if (com.bytedance.android.shopping.store.tabkit.drainageprefetch.b.c(r4) == true) goto L14;
    L40:
        return null;
    L14:
        if (b().isEmpty() == true) goto L22;
        String r1 = c.a(r4);
        if (r1 == null) goto L22;
        b r2 = (b) b().get(r1);
        if (r2 == null) goto L22;
        Map<String, String> r3 = r2.a;
    L23:
        if (r3 == null) goto L40;
        if (Intrinsics.areEqual(r3.get("prefetch_request_state"), String.valueOf(PrefetchRequestState.MATCH_SUCCESS_NORMAL.getValue())) == false) goto L27;
    L30:
        d(r4);
        JSONObject r5 = new JSONObject();
    L41:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L37
        Iterator<Map.Entry<String, String>> r7 = r3.entrySet().iterator();     // Catch: Throwable -> L37
    L33:
        if (r7.hasNext() == false) goto L35;
        Map.Entry<String, String> r8 = r7.next();     // Catch: Throwable -> L37
        r5.put(r8.getKey(), r8.getValue());     // Catch: Throwable -> L37
        goto L33
    L35:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L37
    L39:
        return r5;
    L37:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    L27:
        if (Intrinsics.areEqual(r3.get("prefetch_request_state"), String.valueOf(PrefetchRequestState.MATCH_SUCCESS_EXPIRED.getValue())) == true) goto L30;
        r5 = new JSONObject();
    L22:
        r3 = null;
        goto L23
    L4:
        if (StringsKt.isBlank(r4) == true) goto L7;
        r0 = false;
        goto L9
    }

    public static JSONObject d(String r2) {
        if (b().isEmpty() == false) goto L5;
        return null;
    L5:
        if (r2 == null) goto L10;
        String r3 = c.a(r2);
        if (r3 == null) goto L10;
        b r4 = (b) b().get(r3);
    L10:
        return null;
    }
}
