package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;

/* JADX INFO: loaded from: classes34.dex */
final class MessageSerializedForm<M extends Message<M, B>, B extends Message.Builder<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;
    private final byte[] bytes;
    private final Class<M> messageClass;

    public Object readResolve() throws ObjectStreamException {
        ProtoAdapter r100 = ProtoAdapter.get(this.messageClass);
        return r100.decode(this.bytes);
    L5:
        e = move-exception;
        throw new StreamCorruptedException(e.getMessage());
    }

    public MessageSerializedForm(byte[] r100, Class<M> r101) {
        this.bytes = r100;
        this.messageClass = r101;
    }
}
