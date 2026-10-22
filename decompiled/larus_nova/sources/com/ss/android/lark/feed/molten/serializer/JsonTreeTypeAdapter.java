package com.ss.android.lark.feed.molten.serializer;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0010H&¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/gson/TypeAdapter;", "<init>", "()V", "write", "", Argument.OUT, "Lcom/google/gson/stream/JsonWriter;", "value", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;", "writeJsonObject", "Lcom/google/gson/JsonObject;", "(Ljava/lang/Object;)Lcom/google/gson/JsonObject;", "readJsonObject", "json", "(Lcom/google/gson/JsonObject;)Ljava/lang/Object;", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class JsonTreeTypeAdapter<T> extends TypeAdapter<T> {
    public abstract T a(JsonObject r100);

    public abstract JsonObject b(T r100);

    public JsonTreeTypeAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public final T read(JsonReader r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        if (r100.peek() != JsonToken.NULL) goto L6;
        r100.nextNull();
        return null;
    L6:
        JsonElement r101 = Streams.parse(r100);
        if (r101.isJsonNull() == false) goto L10;
        return null;
    L10:
        return a(r101.getAsJsonObject());
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        if (r101 != null) goto L6;
        r100.nullValue();
        return;
    L6:
        Streams.write(b(r101), r100);
    }
}
