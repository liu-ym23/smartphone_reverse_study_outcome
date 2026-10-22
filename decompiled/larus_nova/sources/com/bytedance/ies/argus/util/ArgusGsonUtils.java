package com.bytedance.ies.argus.util;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class ArgusGsonUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f246245a = null;

    public static final class a implements ExclusionStrategy {
        public a() {
        }

        @Override // com.google.gson.ExclusionStrategy
        public final boolean shouldSkipClass(Class<?> r100) {
            return false;
        }

        @Override // com.google.gson.ExclusionStrategy
        public final boolean shouldSkipField(FieldAttributes r100) {
            Intrinsics.checkNotNullParameter(r100, "fieldAttributes");
            if (r100.getAnnotation(SerializedName.class) != null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        f246245a = LazyKt.lazy(ArgusGsonUtils$gsonObjExcludeProperty$2.INSTANCE);
    }

    public static JSONObject a(Object r100) {
        Gson r101 = (Gson) f246245a.getValue();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        if (r100 != null) goto L6;
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L7
    L9:
        return r102;
    L6:
        r102 = new JSONObject(r101.toJson(r100));     // Catch: Throwable -> L7
    L12:
        return new JSONObject();
    }

    public static String b(Object r100) {
        if ((r100 instanceof String) == false) goto L7;
        return (String) r100;
    L7:
        if ((r100 instanceof JSONObject) == true) goto L9;
        Gson r101 = (Gson) f246245a.getValue();
        Intrinsics.checkNotNullParameter(r101, "<this>");
    L16:
        return "";
    L12:
        if ((r100 instanceof String) == false) goto L14;
        String r102 = (String) r100;     // Catch: Throwable -> L16
    L18:
        return r102;
    L14:
        r102 = r101.toJson(r100);     // Catch: Throwable -> L16
        goto L18
    L9:
        return r100.toString();
    }

    public static Object c(JSONObject r100, Class r101) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r100 == null) goto L11;
        return ((Gson) f246245a.getValue()).fromJson(r100.toString(), r101);
    L6:
        th = move-exception;
        int r102 = com.bytedance.ies.argus.base.d.f245942a;
        com.bytedance.ies.argus.base.d.b("GsonUtils", "safelyFromJSONObjectToClass error " + th + ": " + r100, null, 12);
        return null;
    L11:
        return null;
    }
}
