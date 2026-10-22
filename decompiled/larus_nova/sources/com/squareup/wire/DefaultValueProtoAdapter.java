package com.squareup.wire;

import java.io.IOException;

/* JADX INFO: loaded from: classes34.dex */
public abstract class DefaultValueProtoAdapter<E> extends ProtoAdapter<E> {
    public abstract E decode(ProtoReader r100, E r101) throws IOException;

    public DefaultValueProtoAdapter(FieldEncoding r100, Class<?> r101) {
        super(r100, r101);
    }
}
