package com.squareup.wire;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import javax.annotation.Nullable;
import okio.ByteString;

/* JADX INFO: loaded from: classes34.dex */
class ByteStringTypeAdapter extends TypeAdapter<ByteString> {
    public ByteStringTypeAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    @Nullable
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public ByteString read2(JsonReader r100) throws IOException {
        if (r100.peek() != JsonToken.NULL) goto L7;
        r100.nextNull();
        return null;
    L7:
        return ByteString.decodeBase64(r100.nextString());
    }

    @Override // com.google.gson.TypeAdapter
    @Nullable
    public /* bridge */ /* synthetic */ ByteString read(JsonReader r100) throws IOException {
        return read2(r100);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(JsonWriter r100, @Nullable ByteString r101) throws IOException {
        if (r101 != null) goto L4;
        r100.nullValue();
        return;
    L4:
        r100.value(r101.base64());
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r100, @Nullable ByteString r101) throws IOException {
        write2(r100, r101);
    }
}
