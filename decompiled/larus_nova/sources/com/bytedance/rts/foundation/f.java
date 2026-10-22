package com.bytedance.rts.foundation;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f267579a = 0;

    public static final class a {
        public static Map b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "jsonStr");
            Intrinsics.checkNotNullParameter(r100, "jsonStr");
            JsonElement r101 = GsonProtectorUtils.parse(new JsonParser(), r100);
            if ((r101 instanceof JsonObject) == false) goto L7;
            return MapsKt.toMutableMap(g.n((JsonObject) r101));
        L7:
            throw new IllegalArgumentException("input is not json object");
        }

        public static Object a(Map r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "json");
            Intrinsics.checkNotNullParameter(r101, "key");
            Intrinsics.checkNotNullParameter(r100, "json");
            Intrinsics.checkNotNullParameter(r101, "key");
            Object r102 = r100.get(r101);
            if ((r102 instanceof JsonElement) == true) goto L5;
            return r102;
        L5:
            return g.a((JsonElement) r102);
        }

        public static Map c(String r100, Function1 r101) {
            Intrinsics.checkNotNullParameter(r100, "jsonStr");
            Intrinsics.checkNotNullParameter(r101, "err_hanlder");
            Intrinsics.checkNotNullParameter(r100, "jsonStr");
            Intrinsics.checkNotNullParameter(r101, "err_hanlder");
            return b(r100);
        L5:
            e = move-exception;
            r101.invoke(e);
            return new LinkedHashMap();
        }

        public final Map<String, Object> update(Map<String, Object> r100, Map<String, Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "json");
            Intrinsics.checkNotNullParameter(r101, "data");
            Intrinsics.checkNotNullParameter(r100, "json");
            Intrinsics.checkNotNullParameter(r101, "data");
            r100.putAll(r101);
            return r100;
        }
    }

    static {
    }
}
