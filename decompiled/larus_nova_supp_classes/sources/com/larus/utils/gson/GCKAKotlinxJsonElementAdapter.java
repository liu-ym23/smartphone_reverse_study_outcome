package com.larus.utils.gson;

import android.util.EventsUtils;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import ouc.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/utils/gson/GCKAKotlinxJsonElementAdapter;", "T", "Lkotlinx/serialization/json/JsonElement;", "Lcom/google/gson/TypeAdapter;", "cast", "Lkotlin/Function1;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "write", XmlPullParser.NO_NAMESPACE, "out", "Lcom/google/gson/stream/JsonWriter;", "value", "(Lcom/google/gson/stream/JsonWriter;Lkotlinx/serialization/json/JsonElement;)V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Lkotlinx/serialization/json/JsonElement;", "utils_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
class GCKAKotlinxJsonElementAdapter<T extends ouc.i> extends TypeAdapter<T> {
    public final Function1<ouc.i, T> a;

    /* JADX WARN: Multi-variable type inference failed */
    public GCKAKotlinxJsonElementAdapter(Function1<? super ouc.i, ? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "cast");
        this.a = r2;
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader r2) {
        Intrinsics.checkNotNullParameter(r2, "reader");
        JsonElement r3 = TypeAdapters.JSON_ELEMENT.read(r2);
        if (r3 != null) goto L5;
    L8:
        return null;
    L5:
        if (r3.isJsonNull() == true) goto L8;
        return this.a.invoke(f.a(r3));
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r2, Object r3) {
        ouc.i r4 = (ouc.i) r3;
        Intrinsics.checkNotNullParameter(r2, "out");
        if (r4 != null) goto L5;
        r2.nullValue();
        return;
    L5:
        TypeAdapters.JSON_ELEMENT.write(r2, f.b(r4));
    }
}
