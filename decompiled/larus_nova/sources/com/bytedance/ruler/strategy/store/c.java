package com.bytedance.ruler.strategy.store;

import com.bytedance.ruler.strategy.utils.RuleParseUtil;
import com.bytedance.ruler.strategy.utils.e;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JsonObject f267731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JsonObject f267732b;

    public c() {
    }

    public final String toString() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        JsonObject r101 = new JsonObject();     // Catch: Throwable -> L4
        r101.add("strategies", this.f267731a);     // Catch: Throwable -> L4
        r101.add("policies", this.f267732b);     // Catch: Throwable -> L4
        return r101.toString();
    L4:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Throwable r103 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r103 == null) goto L12;
        r103.printStackTrace();
        return "";
    L12:
        return "";
    }

    @Override // com.bytedance.ruler.strategy.store.b
    public final fa7.c a(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L32
        JsonObject r102 = this.f267731a;     // Catch: Throwable -> L32
        if (r102 == null) goto L31;
        JsonObject r103 = r102.getAsJsonObject(r100);     // Catch: Throwable -> L32
        if (r103 == null) goto L31;
        JsonArray r104 = r103.getAsJsonArray("rules");     // Catch: Throwable -> L32
        if (r104 == null) goto L31;
        JsonObject r105 = this.f267731a;     // Catch: Throwable -> L32
        if (r105 == null) goto L16;
        JsonObject r106 = r105.getAsJsonObject(r100);     // Catch: Throwable -> L32
        if (r106 == null) goto L16;
        JsonPrimitive r107 = r106.getAsJsonPrimitive("exec_all_rules");     // Catch: Throwable -> L32
        if (r107 == null) goto L16;
        boolean r108 = r107.getAsBoolean();     // Catch: Throwable -> L32
    L17:
        ArrayList r109 = new ArrayList();     // Catch: Throwable -> L32
        Iterator<JsonElement> r110 = r104.iterator();     // Catch: Throwable -> L32
    L19:
        if (r110.hasNext() == false) goto L29;
        String r111 = r110.next().getAsString();     // Catch: Throwable -> L32
        JsonObject r112 = this.f267732b;     // Catch: Throwable -> L32
        if (r112 == null) goto L23;
        JsonElement r113 = r112.get(r111);     // Catch: Throwable -> L32
    L24:
        if (r113 != null) goto L25;
        int r114 = e.f267751a;     // Catch: Throwable -> L32
        e.a(this, 303, "rule[" + r111 + "] not found in policies", null);     // Catch: Throwable -> L32
        goto L19
    L25:
        fa7.a r115 = RuleParseUtil.b(r113);     // Catch: Throwable -> L32
        if (r115 == null) goto L19;
        r115.g(r111);     // Catch: Throwable -> L32
        r109.add(r115);     // Catch: Throwable -> L32
        goto L19
    L23:
        r113 = null;
        goto L24
    L29:
        return new fa7.c(r100, r108, r109);
    L16:
        r108 = false;
    L31:
        return null;
    L32:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        Throwable r117 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r117 == null) goto L36;
        int r118 = e.f267751a;
        e.a(this, 301, r117.getLocalizedMessage(), r117);
    L36:
        return null;
    }

    @Override // com.bytedance.ruler.strategy.store.b
    public void update(String r100, JsonObject r101) {
        JsonObject r102 = r101.getAsJsonObject("policies");
        if (r102 != null) goto L5;
    L13:
        JsonObject r103 = r101.getAsJsonObject("strategies");
        if (r103 != null) goto L16;
        return;
    L16:
        if (this.f267731a == null) goto L23;
        Iterator<T> r104 = r103.entrySet().iterator();
    L19:
        if (r104.hasNext() == false) goto L36;
        Map.Entry r105 = (Map.Entry) r104.next();
        JsonObject r106 = this.f267731a;
        if (r106 == null) goto L19;
        r106.add((String) r105.getKey(), (JsonElement) r105.getValue());
        goto L19
    L36:
        return;
    L23:
        this.f267731a = r103;
        return;
    L5:
        if (this.f267732b == null) goto L12;
        Iterator<T> r107 = r102.entrySet().iterator();
    L8:
        if (r107.hasNext() == false) goto L13;
        Map.Entry r108 = (Map.Entry) r107.next();
        JsonObject r109 = this.f267732b;
        if (r109 == null) goto L8;
        r109.add((String) r108.getKey(), (JsonElement) r108.getValue());
        goto L8
    L12:
        this.f267732b = r102;
        goto L13
    }
}
