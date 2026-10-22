package com.ss.android.ugc.tools.type_adapter;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uhc.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/tools/type_adapter/BooleanAsIntTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "", "<init>", "()V", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class BooleanAsIntTypeAdapter extends TypeAdapter<Integer> {
    public BooleanAsIntTypeAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public final Integer read(JsonReader r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        JsonToken r101 = r100.peek();
        if (r101 == null) goto L28;
        int r102 = a.f550117a[r101.ordinal()];
        if (r102 == 1) goto L23;
        if (r102 != 2) goto L9;
        r100.nextNull();
        return null;
    L9:
        if (r102 != 3) goto L11;
        return Integer.valueOf(r100.nextInt());
    L18:
        e = move-exception;
        throw new JsonSyntaxException(e);
    L11:
        if (r102 != 4) goto L28;
        if (Boolean.parseBoolean(r100.nextString()) == false) goto L32;
        return 1;
    L32:
        return 0;
    L23:
        if (r100.nextBoolean() == false) goto L26;
        return 1;
    L26:
        return 0;
    L28:
        throw new IllegalStateException("Expected BOOLEAN or NUMBER but was " + r101);
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, Integer r101) {
        Integer r102 = r101;
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        if (r102 != null) goto L5;
        r100.nullValue();
        return;
    L5:
        r100.value(r102);
    }
}
