package com.ss.android.lark.feed.molten.serializer;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0010\b\u0000\u0010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/WireMessageTypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/squareup/wire/Message;", "Lcom/google/gson/TypeAdapter;", "messageClass", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "write", "", Argument.OUT, "Lcom/google/gson/stream/JsonWriter;", "value", "(Lcom/google/gson/stream/JsonWriter;Lcom/squareup/wire/Message;)V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Lcom/squareup/wire/Message;", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WireMessageTypeAdapter<T extends Message<?, ?>> extends TypeAdapter<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<T> f421096a;

    public WireMessageTypeAdapter(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "messageClass");
        this.f421096a = r100;
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        if (r100.peek() != JsonToken.NULL) goto L5;
        r100.nextNull();
        return null;
    L5:
        String r101 = r100.nextString();
        ByteString.a r102 = ByteString.Companion;
        Intrinsics.checkNotNull(r101);
        r102.getClass();
        ByteString r103 = ByteString.a.a(r101);
        if (r103 == null) goto L13;
        byte[] r104 = r103.toByteArray();
        if (r104 == null) goto L14;
        int r105 = g.f421123a;
        Class<T> r106 = this.f421096a;
        Intrinsics.checkNotNullParameter(r106, "messageClass");
        Object r107 = r106.getField("ADAPTER").get(null);
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<T of com.ss.android.lark.feed.molten.serializer.WireReflection.adapterOf>");
        return (Message) ((ProtoAdapter) r107).decode(r104);
    L14:
        return null;
    L13:
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, Object r101) {
        Message r102 = (Message) r101;
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        if (r102 != null) goto L5;
        r100.nullValue();
        return;
    L5:
        int r103 = g.f421123a;
        Class<T> r104 = this.f421096a;
        Intrinsics.checkNotNullParameter(r104, "messageClass");
        Object r105 = r104.getField("ADAPTER").get(null);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<T of com.ss.android.lark.feed.molten.serializer.WireReflection.adapterOf>");
        byte[] r106 = ((ProtoAdapter) r105).encode(r102);
        ByteString.a r107 = ByteString.Companion;
        Intrinsics.checkNotNull(r106);
        r100.value(ByteString.a.e(r107, r106).base64());
    }
}
