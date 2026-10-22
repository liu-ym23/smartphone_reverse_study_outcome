package com.bytedance.android.shopping.extensions;

import android.graphics.Color;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.core.utils.z1;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k {

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/bytedance/android/shopping/extensions/k$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<Map<String, Object>> {
        public a() {
        }
    }

    public static final boolean m(int r1) {
        if (r1 == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static final HashMap<String, String> A(JSONObject r4) throws JSONException {
        Intrinsics.checkNotNullParameter(r4, "$this$toStringMap");
        HashMap<String, String> r0 = new HashMap();
        Iterator<String> r1 = r4.keys();
    L4:
        if (r1.hasNext() == false) goto L6;
        String r2 = r1.next();
        r0.put(r2, r4.get(r2).toString());
        goto L4
    L6:
        return r0;
    }

    public static final <K, V> Map<K, V> b(Map<K, ? extends V> r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$filterNotNullValues");
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<K, ? extends V>> r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L12;
        Map.Entry<K, ? extends V> r1 = r4.next();
        K r2 = r1.getKey();
        V r5 = r1.getValue();
        if (r5 == null) goto L8;
        Pair r6 = TuplesKt.to(r2, r5);
    L9:
        if (r6 == null) goto L4;
        r0.add(r6);
        goto L4
    L8:
        r6 = null;
        goto L9
    L12:
        return MapsKt.toMap(r0);
    }

    public static final boolean c(String r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.length() <= 0) goto L6;
        return true;
    }

    public static final float d(Float r0) {
        if (r0 != null) goto L6;
        return 0.0f;
    L6:
        return r0.floatValue();
    }

    public static final int f(Integer r0) {
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.intValue();
    }

    public static final long h(Long r2) {
        if (r2 != null) goto L6;
        return 0;
    L6:
        return r2.longValue();
    }

    public static final boolean i(Boolean r0) {
        if (r0 != null) goto L6;
        return false;
    L6:
        return r0.booleanValue();
    }

    public static String j(String r2) {
        Intrinsics.checkNotNullParameter("", "default");
        if (r2 == null) goto L5;
        return r2;
    L5:
        return "";
    }

    public static final int o(String r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$toColorInt");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r1)));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r2) == false) goto L10;
        r2 = null;
    L10:
        Integer r3 = (Integer) r2;
        if (r3 != null) goto L17;
        return 0;
    L17:
        return r3.intValue();
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static final int q(Boolean r1) {
        return Intrinsics.areEqual(r1, Boolean.TRUE) ? 1 : 0;
    }

    public static final JSONArray s(List<String> r2) {
        JSONArray r0 = new JSONArray();
        if (r2 == null) goto L8;
        Iterator<T> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        r0.put((String) r3.next());
    L8:
        return r0;
    }

    public static final JSONArray t(String r1) {
    L6:
        e = move-exception;
        ECExceptionMonitor.f(e, "json_format_error");
        return null;
    L3:
        if (c(r1) == false) goto L12;
        return new JSONArray(r1);
    L12:
        return null;
    }

    public static final JSONObject u(String r1) {
    L6:
        e = move-exception;
        ECExceptionMonitor.f(e, "json_format_error");
    L9:
        return new JSONObject();
    L3:
        if (c(r1) == false) goto L9;
        return new JSONObject(r1);
    }

    public static JSONObject v(Object r1) {
        if (r1 == null) goto L8;
        return tv5.a.b(r1);
    L5:
        e = move-exception;
        ECExceptionMonitor.f(e, "json_format_error");
    L8:
        return new JSONObject();
    }

    public static final JSONObject w(String r1) {
    L6:
        e = move-exception;
        ECExceptionMonitor.f(e, "json_format_error");
        return null;
    L3:
        if (c(r1) == false) goto L12;
        return new JSONObject(r1);
    L12:
        return null;
    }

    public static final String x(Object r0) {
        if (r0 != null) goto L6;
        return (String) r0;
    L6:
        return u0.d(r0);
    }

    public static final Map<String, Object> z(String r2) {
        int r0 = t0.a;     // Catch: Exception -> L4
        return (Map) t0.a.a.fromJson(r2, new a().getType());
    L4:
        return null;
    }

    public static final String a(String r1, Function1<? super JSONObject, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        JSONObject r3 = z1.g(r1);
        if (r3 == null) goto L5;
        r2.invoke(r3);
        return r3.toString();
    L5:
        return null;
    }

    public static final float e(Float r0, float r1) {
        if (r0 != null) goto L4;
        return r1;
    L4:
        return r0.floatValue();
    }

    public static final int g(Integer r0, int r1) {
        if (r0 != null) goto L4;
        return r1;
    L4:
        return r0.intValue();
    }

    public static final String k(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "default");
        if (c(r1) == true) goto L6;
        r1 = null;
    L6:
        if (r1 != null) goto L8;
        return r2;
    L8:
        return r1;
    }

    public static final boolean n(String r0, boolean r1) {
        if (r0 != null) goto L5;
        return r1;
    L5:
        if (Intrinsics.areEqual(r0, "1") == false) goto L7;
        return true;
    L7:
        if (Intrinsics.areEqual(r0, "true") == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static final float p(String r0, float r1) {
        if (r0 == null) goto L7;
        Float r2 = StringsKt.toFloatOrNull(r0);
        if (r2 != null) goto L6;
        return r1;
    L6:
        return r2.floatValue();
    L7:
        return r1;
    }

    public static final int r(String r0, int r1) {
        if (r0 == null) goto L7;
        Integer r2 = StringsKt.toIntOrNull(r0);
        if (r2 != null) goto L6;
        return r1;
    L6:
        return r2.intValue();
    L7:
        return r1;
    }

    public static final long y(String r0, long r1) {
        if (r0 == null) goto L7;
        Long r2 = StringsKt.toLongOrNull(r0);
        if (r2 != null) goto L6;
        return r1;
    L6:
        return r2.longValue();
    L7:
        return r1;
    }

    public static final void l(JSONObject r1, String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$safePut");
        Intrinsics.checkNotNullParameter(r2, "key");
        r1.put(r2, r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.f(e, "json put error");
    }
}
