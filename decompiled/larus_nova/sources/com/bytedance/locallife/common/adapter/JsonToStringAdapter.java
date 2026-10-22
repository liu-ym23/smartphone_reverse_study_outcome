package com.bytedance.locallife.common.adapter;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes21.dex */
public class JsonToStringAdapter extends TypeAdapter<String> {
    public JsonToStringAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public final String read(JsonReader r100) throws IOException {
        JsonElement r101 = Streams.parse(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.toString();
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, String r101) throws IOException {
        JsonParser r102 = new JsonParser();
        JsonElement r103 = GsonProtectorUtils.parse(r102, r101);
        TypeAdapters.JSON_ELEMENT.write(r100, r103);
    }
}
