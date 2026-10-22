package xh3;

import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.model.sku.SkuSchemaCategory;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements ea3.a {
    public final UrlBuilderV2 a;
    public final Map<String, Map<String, Object>> b;
    public JSONArray c;

    public final JSONArray i() {
        if (this.c != null) goto L16;
        String r0 = this.a.getQuery(SkuSchemaCategory.KEY_PASS_THROUGH.getValue());
        if (r0 != null) goto L7;
    L13:
        JSONArray r1 = new JSONArray();
    L14:
        this.c = r1;
        goto L16
    L7:
        if ((!Intrinsics.areEqual(r0, "null")) == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L13;
        r1 = k.t(r0);
        if (r1 != null) goto L14;
    L16:
        return this.c;
    }

    public final void k() {
        Iterator r0 = ((LinkedHashMap) this.b).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry r1 = (Map.Entry) r0.next();
        String r2 = k.x(r1.getValue());
        if (r2 == null) goto L4;
        this.a.addOrReplaceParam((String) r1.getKey(), r2);
        goto L4
    L8:
        JSONArray r3 = i();
        if (r3 == null) goto L19;
        String r4 = r3.toString();
        if (r4 == null) goto L20;
        this.a.addOrReplaceParam(SkuSchemaCategory.KEY_PASS_THROUGH.getValue(), r4);
        return;
    L20:
        return;
    }

    public final String f() {
        k();
        return this.a.build();
    }

    public final Map<String, String> g() {
        k();
        return this.a.queryMap();
    }

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        this.a = new UrlBuilderV2(r2);
        this.b = new LinkedHashMap();
    }

    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "token");
        this.a.addOrReplaceParam("source_btm_token", r3);
    }

    public final Map<String, Object> h(String r3) {
        Map<String, Object> r0 = (Map) ((LinkedHashMap) this.b).get(r3);
        if (r0 == null) goto L5;
        return r0;
    L5:
        Map<String, Object> r1 = k.z(this.a.getQuery(r3));
        if (r1 != null) goto L8;
        r1 = new LinkedHashMap();
    L8:
        this.b.put(r3, r1);
        return r1;
    }

    public final Object j(String r8) {
        Intrinsics.checkNotNullParameter(r8, "path");
        List r9 = StringsKt.split$default(r8, new String[]{"."}, false, 0, 6, null);
        if (r9.isEmpty() == false) goto L6;
        return null;
    L6:
        if (r9.size() != 1) goto L12;
        String r10 = (String) CollectionsKt.getOrNull(r9, 0);
        if (r10 != null) goto L10;
        return null;
    L10:
        return this.a.getQuery(r10);
    L12:
        String r0 = (String) CollectionsKt.getOrNull(r9, 0);
        String r1 = "";
        if (r0 != null) goto L15;
        r0 = "";
    L15:
        String r11 = (String) CollectionsKt.getOrNull(r9, 1);
        if (r11 == null) goto L20;
        r1 = r11;
    L20:
        return h(r0).get(r1);
    }

    public final void b(String r8, Object r9) {
        Intrinsics.checkNotNullParameter(r8, "path");
        List r10 = StringsKt.split$default(r8, new String[]{"."}, false, 0, 6, null);
        if (r10.size() >= 2) goto L5;
        return;
    L5:
        boolean r0 = false;
        String r1 = (String) CollectionsKt.getOrNull(r10, 0);
        String r2 = "";
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        String r11 = (String) CollectionsKt.getOrNull(r10, 1);
        if (r11 == null) goto L12;
        r2 = r11;
    L12:
        SkuSchemaCategory.Companion.getClass();
        Intrinsics.checkNotNullParameter(r1, "key");
        if (SkuSchemaCategory.access$getKeysSet$cp().contains(r1) == true) goto L15;
        return;
    L15:
        if (r1.length() != 0) goto L17;
        boolean r12 = true;
    L18:
        if (r12 == false) goto L20;
        return;
    L20:
        if (r2.length() != 0) goto L22;
        r0 = true;
    L22:
        if (r0 == true) goto L28;
        h(r1).put(r2, r9);
        return;
    L28:
        return;
    L17:
        r12 = false;
        goto L18
    }

    public final void d(List<String> r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "to");
        Intrinsics.checkNotNullParameter(r6, "data");
        JSONArray r2 = i();
        if (r2 == null) goto L6;
        JSONObject r3 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r3, "to", k.s(r5));
        KtSafeMethodExtensionKt.safePut(r3, "data", r6);
        Unit r7 = Unit.INSTANCE;
        r2.put(r3);
        return;
    }

    public final void e(JSONObject r17, int r18) {
        Intrinsics.checkNotNullParameter("track.client", "to");
        Intrinsics.checkNotNullParameter(r17, "data");
        if (r18 != 1) goto L25;
        JSONArray r7 = i();
        if (r7 == null) goto L25;
        int r8 = r7.length();
        int r9 = 0;
        boolean r10 = false;
    L7:
        if (r9 >= r8) goto L24;
        JSONObject r11 = JSONArrayProtectorUtils.getJSONObject(r7, r9);
        JSONArray r0 = r11.optJSONArray("to");
        if (r0 == null) goto L23;
        ArrayList r12 = new ArrayList();     // Catch: Exception -> L16
        int r13 = r0.length();     // Catch: Exception -> L16
        int r14 = 0;
    L11:
        if (r14 >= r13) goto L18;
        Object r15 = r0.opt(r14);     // Catch: Exception -> L16
        if ((r15 instanceof String) == false) goto L15;
        r12.add(r15);     // Catch: Exception -> L16
    L15:
        r14 = r14 + 1;
    L18:
        if (r12 == null) goto L23;
        if (r12.contains("track.client") != true) goto L23;
        JSONObject r1 = z1.f(r11.optString("data"));
        x0.b(r1, r17, false);
        KtSafeMethodExtensionKt.safePut(r11, "data", r1.toString());
        r10 = true;
    L16:
        e = move-exception;
        e.printStackTrace();
        r12 = null;
    L23:
        r9 = r9 + 1;
        goto L7
    L24:
        boolean r5 = r10;
    L26:
        if (r5 == false) goto L28;
        return;
    L28:
        JSONArray r2 = i();
        if (r2 == null) goto L40;
        JSONObject r6 = new JSONObject();
        JSONArray r16 = new JSONArray();
        r16.put("track.client");
        Unit r3 = Unit.INSTANCE;
        KtSafeMethodExtensionKt.safePut(r6, "to", r16);
        KtSafeMethodExtensionKt.safePut(r6, "data", r17);
        r2.put(r6);
        return;
    L40:
        return;
    L25:
        r5 = false;
        goto L26
    }

    public final void c(String r17, String r18, int r19) {
        Intrinsics.checkNotNullParameter(r17, "to");
        Intrinsics.checkNotNullParameter(r18, "data");
        if (r19 != 1) goto L25;
        JSONArray r7 = i();
        if (r7 == null) goto L25;
        int r8 = r7.length();
        int r9 = 0;
        boolean r10 = false;
    L7:
        if (r9 >= r8) goto L24;
        JSONObject r11 = JSONArrayProtectorUtils.getJSONObject(r7, r9);
        JSONArray r0 = r11.optJSONArray("to");
        if (r0 == null) goto L23;
        ArrayList r12 = new ArrayList();     // Catch: Exception -> L16
        int r13 = r0.length();     // Catch: Exception -> L16
        int r14 = 0;
    L11:
        if (r14 >= r13) goto L18;
        Object r15 = r0.opt(r14);     // Catch: Exception -> L16
        if ((r15 instanceof String) == false) goto L15;
        r12.add(r15);     // Catch: Exception -> L16
    L15:
        r14 = r14 + 1;
    L18:
        if (r12 == null) goto L23;
        if (r12.contains(r17) != true) goto L23;
        JSONObject r1 = z1.f(r11.optString("data"));
        x0.b(r1, z1.f(r18), false);
        KtSafeMethodExtensionKt.safePut(r11, "data", r1.toString());
        r10 = true;
    L16:
        e = move-exception;
        e.printStackTrace();
        r12 = null;
    L23:
        r9 = r9 + 1;
        goto L7
    L24:
        boolean r5 = r10;
    L26:
        if (r5 == false) goto L28;
        return;
    L28:
        JSONArray r2 = i();
        if (r2 == null) goto L40;
        JSONObject r6 = new JSONObject();
        JSONArray r16 = new JSONArray();
        r16.put(r17);
        Unit r3 = Unit.INSTANCE;
        KtSafeMethodExtensionKt.safePut(r6, "to", r16);
        KtSafeMethodExtensionKt.safePut(r6, "data", r18);
        r2.put(r6);
        return;
    L40:
        return;
    L25:
        r5 = false;
        goto L26
    }
}
