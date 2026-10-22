package com.bytedance.geckox.gson;

import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import sy5.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/geckox/gson/BooleanTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "", "<init>", "()V", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class BooleanTypeAdapter extends TypeAdapter<Boolean> {
    public BooleanTypeAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public final Boolean read(JsonReader r100) {
        JsonToken r101 = r100.peek();
        if (r101 == null) goto L19;
        int r102 = a.f543887a[r101.ordinal()];
        boolean r103 = true;
        if (r102 == 1) goto L17;
        if (r102 != 2) goto L9;
        r100.nextNull();
        return null;
    L9:
        if (r102 != 3) goto L19;
        if (r100.nextInt() != 0) goto L20;
        r103 = false;
    L20:
        return Boolean.valueOf(r103);
    L17:
        return Boolean.valueOf(r100.nextBoolean());
    L19:
        throw new JsonParseException("Expected BOOLEAN or NUMBER but was " + r101);
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, Boolean r101) {
        Boolean r102 = r101;
        if (r102 != null) goto L5;
        r100.nullValue();
        return;
    L5:
        r100.value(r102.booleanValue());
    }
}
