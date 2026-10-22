package com.ss.android.lark.chameleon.util;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleon/util/IntTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "", "()V", "read", "input", "Lcom/google/gson/stream/JsonReader;", "write", "", Argument.OUT, "Lcom/google/gson/stream/JsonWriter;", "value", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IntTypeAdapter extends TypeAdapter<Number> {
    public IntTypeAdapter() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public Number read(JsonReader r100) {
        if (r100 == null) goto L5;
        JsonToken r101 = r100.peek();
    L7:
        if (r101 != JsonToken.NULL) goto L10;
        r100.nextNull();
        return null;
    L10:
        if (r100 != null) goto L22;
        String r102 = null;
    L14:
        if (r102 == null) goto L24;
        return Integer.valueOf(CastIntegerProtector.parseInt(r102));
    L17:
        if (r100 == null) goto L25;
        String r103 = r100.nextString();
        if (r103 != null) goto L21;
        return null;
    L21:
        return Long.valueOf(CastLongProtector.parseLong(r103));
    L25:
        return null;
    L24:
        return null;
    L22:
        r102 = r100.nextString();     // Catch: NumberFormatException -> L12
        goto L14
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Number read(JsonReader r100) {
        return read(r100);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(JsonWriter r100, Number r101) {
        if (r100 == null) goto L5;
        r100.value(r101);
        return;
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r100, Number r101) {
        write2(r100, r101);
    }
}
