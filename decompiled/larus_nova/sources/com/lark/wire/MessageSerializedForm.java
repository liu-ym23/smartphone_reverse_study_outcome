package com.lark.wire;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.lark.wire.Message;
import com.lark.wire.Message.a;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000e*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0002*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00042\u00020\u0005:\u0001\u000eB\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/lark/wire/MessageSerializedForm;", "M", "Lcom/lark/wire/Message;", "B", "Lcom/lark/wire/Message$Builder;", "Ljava/io/Serializable;", HTTP.CONTENT_RANGE_BYTES, "", "messageClass", "Ljava/lang/Class;", "<init>", "([BLjava/lang/Class;)V", "readResolve", "", "Companion", "wire-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MessageSerializedForm<M extends Message<M, B>, B extends Message.a<M, B>> implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 0;
    private final byte[] bytes;
    private final Class<M> messageClass;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final Object readResolve() throws ObjectStreamException {
        l r100 = ProtoAdapter.f282718g;
        Class<M> r101 = this.messageClass;
        Intrinsics.checkNotNullParameter(r101, "type");
        Object r102 = r101.getField("ADAPTER").get(null);     // Catch: NoSuchFieldException -> L9 IllegalAccessException -> L12
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.lark.wire.ProtoAdapter<M of com.lark.wire.ProtoAdapter.Companion.get>");     // Catch: NoSuchFieldException -> L9 IllegalAccessException -> L12
        return ((ProtoAdapter) r102).e(this.bytes);
    L6:
        e = move-exception;
        throw new StreamCorruptedException(e.getMessage());
    L12:
        e = move-exception;
        throw new IllegalArgumentException("failed to access " + r101.getName() + "#ADAPTER", e);
    L9:
        e = move-exception;
        throw new IllegalArgumentException("failed to access " + r101.getName() + "#ADAPTER", e);
    }

    public MessageSerializedForm(byte[] r100, Class<M> r101) {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        Intrinsics.checkNotNullParameter(r101, "messageClass");
        this.bytes = r100;
        this.messageClass = r101;
    }
}
