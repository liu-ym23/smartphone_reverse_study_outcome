package com.bytedance.android.shopping.store.tabkit;

import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class TabKitAbilityConfig {
    public static final HashMap<String, Map<String, Object>> d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public final ArrayList<String> a;
    public final Lazy b;
    public final TabKitRouterParams c;

    public static final class a {
    }

    static {
        d = new HashMap();
        e = LazyKt.lazy(TabKitAbilityConfig$Companion$tabKitAbilityConfigJSON$2.INSTANCE);
        f = LazyKt.lazy(TabKitAbilityConfig$Companion$globalAbilityConfigJSON$2.INSTANCE);
    }

    public TabKitAbilityConfig(TabKitRouterParams r18) {
        Intrinsics.checkNotNullParameter(r18, "tabKitRouterParams");
        this.c = r18;
        this.a = CollectionsKt.arrayListOf(new String[]{"na_prefetch_opt", "web_landing_opt", "web_nested_scroll", "btm_custom_page_v2", "enable_anniex_async_create", "disable_anniex_container", "disable_new_top_bar", "na_prefetch_sync_update", "na_prefetch_thread_opt", "tabkit_lite_page", "tabkit_anniex_force", "preload_anchor_url", "tabkit_fold_adapter", "tabkit_show_now"});
        this.b = LazyKt.lazy(new TabKitAbilityConfig$expValueMap$2(this));
    }

    public final int a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        String r0 = this.c.getParamsMap().get(r5);
        Integer r1 = null;
        if (r0 == null) goto L6;
        Integer r2 = StringsKt.toIntOrNull(r0);
        if (r2 == null) goto L6;
    L14:
        if (r2 != null) goto L25;
        JSONObject r3 = (JSONObject) e.getValue();
        if (r3 == null) goto L24;
        JSONObject r4 = r3.optJSONObject(this.c.getBizTag());
        if (r4 == null) goto L24;
        Object r6 = r4.opt(r5);
        if (r6 == null) goto L24;
        String r7 = r6.toString();
        if (r7 == null) goto L24;
        r2 = StringsKt.toIntOrNull(r7);
    L24:
        r2 = null;
    L25:
        if (r2 != null) goto L33;
        JSONObject r8 = (JSONObject) f.getValue();
        if (r8 == null) goto L34;
        Object r9 = r8.opt(r5);
        if (r9 == null) goto L34;
        String r10 = r9.toString();
        if (r10 == null) goto L34;
        r1 = StringsKt.toIntOrNull(r10);
    L34:
        if (r1 != null) goto L38;
        return 0;
    L38:
        return r1.intValue();
    L33:
        r1 = r2;
    L6:
        Map r11 = (Map) this.b.getValue();
        if (r11 == null) goto L13;
        Object r12 = r11.get(this.c.getBizTag() + '_' + r5);
        if (r12 == null) goto L13;
        String r13 = r12.toString();
        if (r13 == null) goto L13;
        r2 = StringsKt.toIntOrNull(r13);
    L13:
        r2 = null;
        goto L14
    }

    public final boolean b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        if (Intrinsics.areEqual("tabkit_anniex_force", r2) == false) goto L8;
        cl.d.a.getClass();
        cl.d r0 = cl.d.a.b();
        if (r0 == null) goto L8;
        r0.n();
    L8:
        if (a(r2) <= 0) goto L10;
        return true;
    L10:
        return false;
    }
}
