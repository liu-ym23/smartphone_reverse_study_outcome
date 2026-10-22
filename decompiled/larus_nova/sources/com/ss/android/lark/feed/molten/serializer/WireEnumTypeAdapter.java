package com.ss.android.lark.feed.molten.serializer;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.squareup.wire.WireEnum;
import java.lang.Enum;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0012\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u000eJ\u0017\u0010\u000f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/WireEnumTypeAdapter;", ExifInterface.LONGITUDE_EAST, "", "Lcom/squareup/wire/WireEnum;", "Lcom/google/gson/TypeAdapter;", "enumClass", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "write", "", Argument.OUT, "Lcom/google/gson/stream/JsonWriter;", "value", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Enum;)V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Enum;", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WireEnumTypeAdapter<E extends Enum<E> & WireEnum> extends TypeAdapter<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<E> f421094a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f421095a = null;

        static {
            int[] r100 = new int[JsonToken.values().length];
            r100[JsonToken.STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f421095a = r100;
        }
    }

    public WireEnumTypeAdapter(Class<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "enumClass");
        this.f421094a = r100;
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        if (r100.peek() != JsonToken.NULL) goto L5;
        r100.nextNull();
    L15:
        return null;
    L5:
        JsonToken r101 = r100.peek();
        if (r101 != null) goto L8;
        int r102 = -1;
    L10:
        if (r102 != 1) goto L12;
        Integer r103 = StringsKt.toIntOrNull(r100.nextString());
    L13:
        if (r103 == null) goto L15;
        int r104 = r103.intValue();
        int r105 = g.f421123a;
        return (Enum) g.a(this.f421094a, r104);
    L12:
        r103 = Integer.valueOf(r100.nextInt());
        goto L13
    L8:
        r102 = a.f421095a[r101.ordinal()];
        goto L10
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, Object r101) {
        Object r102 = (Enum) r101;
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        if (r102 != null) goto L5;
        r100.nullValue();
        return;
    L5:
        r100.value(Integer.valueOf(((WireEnum) r102).getValue()));
    }
}
