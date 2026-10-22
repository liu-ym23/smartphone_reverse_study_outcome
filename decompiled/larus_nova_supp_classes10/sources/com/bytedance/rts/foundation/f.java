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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static Map b(String r1) {
            Intrinsics.checkNotNullParameter(r1, "jsonStr");
            Intrinsics.checkNotNullParameter(r1, "jsonStr");
            JsonObject r2 = GsonProtectorUtils.parse(new JsonParser(), r1);
            if ((r2 instanceof JsonObject) == false) goto L7;
            return MapsKt.toMutableMap(g.n(r2));
        L7:
            throw new IllegalArgumentException("input is not json object");
        }

        public static Object a(Map r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "json");
            Intrinsics.checkNotNullParameter(r3, "key");
            Intrinsics.checkNotNullParameter(r2, "json");
            Intrinsics.checkNotNullParameter(r3, "key");
            Object r4 = r2.get(r3);
            if ((r4 instanceof JsonElement) == true) goto L5;
            return r4;
        L5:
            return g.a((JsonElement) r4);
        }

        public static Map c(String r2, Function1 r3) {
            Intrinsics.checkNotNullParameter(r2, "jsonStr");
            Intrinsics.checkNotNullParameter(r3, "err_hanlder");
            Intrinsics.checkNotNullParameter(r2, "jsonStr");
            Intrinsics.checkNotNullParameter(r3, "err_hanlder");
            return b(r2);
        L5:
            e = move-exception;
            r3.invoke(e);
            return new LinkedHashMap();
        }

        public final Map<String, Object> update(Map<String, Object> r3, Map<String, Object> r4) {
            Intrinsics.checkNotNullParameter(r3, "json");
            Intrinsics.checkNotNullParameter(r4, "data");
            Intrinsics.checkNotNullParameter(r3, "json");
            Intrinsics.checkNotNullParameter(r4, "data");
            r3.putAll(r4);
            return r3;
        }
    }

    static {
    }
}
