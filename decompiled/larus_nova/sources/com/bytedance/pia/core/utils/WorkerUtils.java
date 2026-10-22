package com.bytedance.pia.core.utils;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator;
import com.bytedance.vmsdk.jsbridge.utils.ReadableType;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class WorkerUtils {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f266383a = null;

        static {
            int[] r100 = new int[ReadableType.values().length];
            r100[ReadableType.Null.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[ReadableType.Boolean.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[ReadableType.Int.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[ReadableType.Long.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[ReadableType.Number.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[ReadableType.String.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[ReadableType.Map.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[ReadableType.Array.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f266383a = r100;
        }
    }

    static {
    }

    @JvmStatic
    public static final JavaOnlyArray a(JsonArray r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        JavaOnlyArray r101 = new JavaOnlyArray();
        Iterator<JsonElement> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L28;
        JsonElement r103 = r102.next();
        if ((r103 instanceof JsonNull) == true) goto L7;
        if ((r103 instanceof JsonObject) == true) goto L10;
        if ((r103 instanceof JsonArray) == true) goto L13;
        if ((r103 instanceof JsonPrimitive) == false) goto L4;
        JsonPrimitive r104 = (JsonPrimitive) r103;
        if (r104.isBoolean() == true) goto L18;
        if (r104.isString() == true) goto L21;
        if (r104.isNumber() == false) goto L4;
        String r105 = r104.getAsNumber().toString();
        if (StringsKt.contains$default(r105, '.', false, 2, null) == true) goto L26;
        r101.add(Long.valueOf(r104.getAsNumber().longValue()));
        goto L4
    L26:
        r101.add(Double.valueOf(CastDoubleProtector.parseDouble(r105)));
        goto L4
    L21:
        r101.add(r104.getAsString());
        goto L4
    L18:
        r101.add(Boolean.valueOf(r104.getAsBoolean()));
        goto L4
    L13:
        r101.add(a((JsonArray) r103));
        goto L4
    L10:
        r101.add(b((JsonObject) r103));
        goto L4
    L7:
        r101.add(null);
        goto L4
    L28:
        return r101;
    }

    @JvmStatic
    public static final JavaOnlyMap b(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        JavaOnlyMap r101 = new JavaOnlyMap();
        Iterator<T> r102 = r100.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L28;
        String r103 = (String) r102.next();
        JsonElement r104 = r100.get(r103);
        if ((r104 instanceof JsonNull) == true) goto L7;
        if ((r104 instanceof JsonObject) == true) goto L10;
        if ((r104 instanceof JsonArray) == true) goto L13;
        if ((r104 instanceof JsonPrimitive) == false) goto L4;
        JsonPrimitive r105 = (JsonPrimitive) r104;
        if (r105.isBoolean() == true) goto L18;
        if (r105.isString() == true) goto L21;
        if (r105.isNumber() == false) goto L4;
        String r106 = r105.getAsNumber().toString();
        if (StringsKt.contains$default(r106, '.', false, 2, null) == true) goto L26;
        r101.put(r103, Long.valueOf(r105.getAsNumber().longValue()));
        goto L4
    L26:
        r101.put(r103, Double.valueOf(CastDoubleProtector.parseDouble(r106)));
        goto L4
    L21:
        r101.put(r103, r105.getAsString());
        goto L4
    L18:
        r101.put(r103, Boolean.valueOf(r105.getAsBoolean()));
        goto L4
    L13:
        r101.put(r103, a((JsonArray) r104));
        goto L4
    L10:
        r101.put(r103, b((JsonObject) r104));
        goto L4
    L7:
        r101.put(r103, null);
        goto L4
    L28:
        return r101;
    }

    @JvmStatic
    public static final JsonArray c(ReadableArray r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        JsonArray r101 = new JsonArray();
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L19;
        ReadableType r104 = r100.getType(r103);
        if (r104 != null) goto L7;
        int r105 = -1;
    L8:
        switch(r105) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            default: goto L18;
        };
    L10:
        r101.add(c(r100.getArray(r103)));
        goto L18
    L11:
        r101.add(d(r100.getMap(r103)));
        goto L18
    L12:
        r101.add(r100.getString(r103));
        goto L18
    L13:
        r101.add(Double.valueOf(r100.getDouble(r103)));
        goto L18
    L14:
        r101.add(Long.valueOf(r100.getLong(r103)));
        goto L18
    L15:
        r101.add(Integer.valueOf(r100.getInt(r103)));
        goto L18
    L16:
        r101.add(Boolean.valueOf(r100.getBoolean(r103)));
        goto L18
    L17:
        r101.add(JsonNull.INSTANCE);
    L18:
        r103 = r103 + 1;
        goto L3
    L7:
        r105 = a.f266383a[r104.ordinal()];
        goto L8
    L19:
        return r101;
    }

    @JvmStatic
    public static final JsonObject d(final ReadableMap r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        final JsonObject r101 = new JsonObject();
        Function1<String, Unit> r102 = new WorkerUtils$toJson$1$1(r100, r101);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "block");
        ReadableMapKeySetIterator r103 = r100.keySetIterator();
    L4:
        if (r103.hasNextKey() == false) goto L14;
        String r104 = r103.nextKey();
        if (r104 != null) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r105 == true) goto L4;
        r102.invoke(r104);
        goto L4
    L8:
        if (StringsKt.isBlank(r104) == true) goto L11;
        r105 = false;
        goto L12
    L14:
        return r101;
    }
}
