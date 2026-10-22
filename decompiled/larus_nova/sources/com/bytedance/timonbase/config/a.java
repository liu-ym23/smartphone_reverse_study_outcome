package com.bytedance.timonbase.config;

import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JsonObject f270807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static C3793a f270808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, b> f270809c = null;

    /* JADX INFO: renamed from: com.bytedance.timonbase.config.a$a, reason: collision with other inner class name */
    public static final class C3793a implements Function1<String, JsonObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentHashMap<String, JsonObject> f270810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<String, JsonObject> f270811b;

        /* JADX WARN: Multi-variable type inference failed */
        public C3793a(Function1<? super String, JsonObject> r100) {
            this.f270811b = r100;
            this.f270810a = new ConcurrentHashMap();
        }

        public final JsonObject a(String r100) {
            JsonObject r101 = this.f270810a.get(r100);
            if (r101 != null) goto L13;
            Function1<String, JsonObject> r102 = this.f270811b;
            if (r102 == null) goto L10;
            JsonObject r103 = r102.invoke(r100);
            if (r103 == null) goto L10;
            this.f270810a.put(r100, r103);
            return r103;
        L10:
            return null;
        L13:
            return r101;
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ JsonObject invoke(String r100) {
            return a(r100);
        }
    }

    public static final class b implements Function0<JsonObject> {
        @Override // kotlin.jvm.functions.Function0
        public final JsonObject invoke() {
            throw null;
        }
    }

    static {
        new ConcurrentHashMap();
        f270809c = new LinkedHashMap();
    }

    public static JsonObject a(String r100) {
        if (Intrinsics.areEqual(r100, "rule_engine_strategy_sets_v2") == false) goto L6;
        return b("rule_engine_strategy_sets_v2");
    L6:
        if (Intrinsics.areEqual(r100, "timon_config") == false) goto L13;
        JsonObject r101 = b("timon_config");
        Iterator r102 = ((LinkedHashMap) f270809c).entrySet().iterator();
        if (r102.hasNext() == true) goto L10;
        return r101;
    L10:
        ((b) ((Map.Entry) r102.next()).getValue()).getClass();
        throw null;
    L13:
        if (Intrinsics.areEqual(r100, "sensitive_path_config") == false) goto L19;
        if (((b) ((LinkedHashMap) f270809c).get("sensitive_path_config")) == null) goto L33;
        throw null;
    L33:
        return b("sensitive_path_config");
    L19:
        if (Intrinsics.areEqual(r100, "timon_encryption_list") == false) goto L25;
        if (((b) ((LinkedHashMap) f270809c).get("timon_encryption_list")) == null) goto L34;
        throw null;
    L34:
        return b("timon_encryption_list");
    L25:
        if (((b) ((LinkedHashMap) f270809c).get(r100)) != null) goto L31;
        JsonObject r103 = b("timon_config");
        if (r103 == null) goto L30;
        return r103.getAsJsonObject(r100);
    L30:
        return null;
    L31:
        throw null;
    }

    public static JsonObject b(String r100) {
        C3793a r101 = f270808b;
        JsonObject r102 = null;
        if (r101 == null) goto L5;
        JsonObject r103 = r101.a(r100);
    L6:
        if (r103 != null) goto L12;
        JsonObject r104 = f270807a;
        if (r104 == null) goto L11;
        r102 = r104.getAsJsonObject(r100);
    L11:
        return r102;
    L12:
        return r103;
    L5:
        r103 = null;
        goto L6
    }
}
