package com.larus.utils.gson;

import android.util.EventsUtils;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ouc.a0;
import ouc.b;
import ouc.d0;
import ouc.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\r\u001a\n\u0012\u0004\u0012\u0002H\u000f\u0018\u00010\u000e\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0013H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/utils/gson/GCKAKotlinxJsonTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "<init>", "()V", "jsonElementAdapter", "Lcom/larus/utils/gson/GCKAKotlinxJsonElementAdapter;", "Lkotlinx/serialization/json/JsonElement;", "jsonObjectAdapter", "Lkotlinx/serialization/json/JsonObject;", "jsonArrayAdapter", "Lkotlinx/serialization/json/JsonArray;", "jsonPrimitiveAdapter", "Lkotlinx/serialization/json/JsonPrimitive;", "create", "Lcom/google/gson/TypeAdapter;", "T", "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "utils_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class GCKAKotlinxJsonTypeAdapterFactory implements TypeAdapterFactory {
    public static final GCKAKotlinxJsonTypeAdapterFactory a = null;
    public static final GCKAKotlinxJsonElementAdapter<ouc.i> b = null;
    public static final GCKAKotlinxJsonElementAdapter<d0> c = null;
    public static final GCKAKotlinxJsonElementAdapter<b> d = null;
    public static final GCKAKotlinxJsonElementAdapter<g0> e = null;

    private GCKAKotlinxJsonTypeAdapterFactory() {
    }

    static {
        a = new GCKAKotlinxJsonTypeAdapterFactory();
        b = new GCKAKotlinxJsonElementAdapter(new g());
        c = new GCKAKotlinxJsonElementAdapter(new h());
        d = new GCKAKotlinxJsonElementAdapter(new i());
        e = new GCKAKotlinxJsonElementAdapter(new j());
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final <T> TypeAdapter<T> create(Gson r2, TypeToken<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "gson");
        Intrinsics.checkNotNullParameter(r3, "type");
        Class<? super T> r4 = r3.getRawType();
        if (Intrinsics.areEqual(r4, ouc.i.class) == false) goto L6;
        GCKAKotlinxJsonElementAdapter<ouc.i> r5 = b;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.google.gson.TypeAdapter<T of com.larus.utils.gson.GCKAKotlinxJsonTypeAdapterFactory.create>");
        return r5;
    L6:
        if (Intrinsics.areEqual(r4, d0.class) == false) goto L9;
        GCKAKotlinxJsonElementAdapter<d0> r6 = c;
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.google.gson.TypeAdapter<T of com.larus.utils.gson.GCKAKotlinxJsonTypeAdapterFactory.create>");
        return r6;
    L9:
        if (Intrinsics.areEqual(r4, b.class) == false) goto L12;
        GCKAKotlinxJsonElementAdapter<b> r7 = d;
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.google.gson.TypeAdapter<T of com.larus.utils.gson.GCKAKotlinxJsonTypeAdapterFactory.create>");
        return r7;
    L12:
        if (Intrinsics.areEqual(r4, g0.class) == false) goto L15;
        GCKAKotlinxJsonElementAdapter<g0> r8 = e;
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.google.gson.TypeAdapter<T of com.larus.utils.gson.GCKAKotlinxJsonTypeAdapterFactory.create>");
        return r8;
    L15:
        if (Intrinsics.areEqual(r4, a0.class) == false) goto L17;
        GCKAKotlinxJsonElementAdapter<ouc.i> r9 = b;
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.google.gson.TypeAdapter<T of com.larus.utils.gson.GCKAKotlinxJsonTypeAdapterFactory.create>");
        return r9;
    L17:
        return null;
    }
}
