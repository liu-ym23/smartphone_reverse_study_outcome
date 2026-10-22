package com.ss.android.lark.feed.molten.serializer;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016J\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/ListTypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/gson/TypeAdapter;", "", "elementAdapter", "<init>", "(Lcom/google/gson/TypeAdapter;)V", "write", "", Argument.OUT, "Lcom/google/gson/stream/JsonWriter;", "value", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ListTypeAdapter<T> extends TypeAdapter<List<? extends T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeAdapter<T> f421083a;

    public ListTypeAdapter(TypeAdapter<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "elementAdapter");
        this.f421083a = r100;
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        if (r100.peek() != JsonToken.NULL) goto L5;
        r100.nextNull();
        return null;
    L5:
        ArrayList r101 = new ArrayList();
        r100.beginArray();
    L7:
        if (r100.hasNext() == false) goto L11;
        T r102 = this.f421083a.read(r100);
        if (r102 == null) goto L7;
        r101.add(r102);
        goto L7
    L11:
        r100.endArray();
        return r101;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, Object r101) {
        List r102 = (List) r101;
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        if (r102 != null) goto L5;
        r100.nullValue();
        return;
    L5:
        r100.beginArray();
        Iterator<T> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        T r104 = r103.next();
        this.f421083a.write(r100, r104);
        goto L7
    L9:
        r100.endArray();
    }
}
