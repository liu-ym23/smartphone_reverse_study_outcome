package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Serializable;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Message<M extends Message<M, B>, B extends Builder<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;
    private final transient ProtoAdapter<M> adapter;
    transient int cachedSerializedSize;
    protected transient int hashCode;
    private final transient ByteString unknownFields;

    public static abstract class Builder<M extends Message<M, B>, B extends Builder<M, B>> {
        transient Buffer unknownFieldsBuffer;
        transient ByteString unknownFieldsByteString;
        transient ProtoWriter unknownFieldsWriter;

        public abstract M build();

        private void prepareForNewUnknownFields() {
            if (this.unknownFieldsBuffer != null) goto L9;
            Buffer r100 = new Buffer();
            this.unknownFieldsBuffer = r100;
            ProtoWriter r101 = new ProtoWriter(r100);
            this.unknownFieldsWriter = r101;
            r101.writeBytes(this.unknownFieldsByteString);     // Catch: IOException -> L7
            this.unknownFieldsByteString = ByteString.EMPTY;
            return;
        L8:
            throw new AssertionError();
        }

        public final ByteString buildUnknownFields() {
            Buffer r100 = this.unknownFieldsBuffer;
            if (r100 == null) goto L6;
            this.unknownFieldsByteString = r100.readByteString();
            this.unknownFieldsBuffer = null;
            this.unknownFieldsWriter = null;
        L6:
            return this.unknownFieldsByteString;
        }

        public final Builder<M, B> clearUnknownFields() {
            this.unknownFieldsByteString = ByteString.EMPTY;
            Buffer r100 = this.unknownFieldsBuffer;
            if (r100 == null) goto L5;
            r100.clear();
            this.unknownFieldsBuffer = null;
        L5:
            this.unknownFieldsWriter = null;
            return this;
        }

        public Builder() {
            this.unknownFieldsByteString = ByteString.EMPTY;
        }

        public final Builder<M, B> addUnknownFields(ByteString r100) {
            if (r100.size() <= 0) goto L9;
            prepareForNewUnknownFields();
            this.unknownFieldsWriter.writeBytes(r100);     // Catch: IOException -> L7
        L8:
            throw new AssertionError();
        L9:
            return this;
        }

        public final Builder<M, B> addUnknownField(int r100, FieldEncoding r101, Object r102) {
            prepareForNewUnknownFields();
            r101.rawProtoAdapter().encodeWithTag(this.unknownFieldsWriter, r100, r102);     // Catch: IOException -> L5
            return this;
        L6:
            throw new AssertionError();
        }
    }

    public abstract Builder<M, B> newBuilder();

    public final byte[] encode() {
        return this.adapter.encode(this);
    }

    public String toString() {
        return this.adapter.toString(this);
    }

    public final ByteString unknownFields() {
        ByteString r100 = this.unknownFields;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return ByteString.EMPTY;
    }

    public final Object writeReplace() throws ObjectStreamException {
        return new MessageSerializedForm(encode(), getClass());
    }

    public final M withoutUnknownFields() {
        return (M) newBuilder().clearUnknownFields().build();
    }

    public final ProtoAdapter<M> adapter() {
        return this.adapter;
    }

    public final void encode(OutputStream r100) throws IOException {
        this.adapter.encode(r100, this);
    }

    public final void encode(BufferedSink r100) throws IOException {
        this.adapter.encode(r100, this);
    }

    public Message(ProtoAdapter<M> r100, ByteString r101) {
        this.cachedSerializedSize = 0;
        this.hashCode = 0;
        if (r100 == null) goto L10;
        if (r101 == null) goto L8;
        this.adapter = r100;
        this.unknownFields = r101;
        return;
    L8:
        throw new NullPointerException("unknownFields == null");
    L10:
        throw new NullPointerException("adapter == null");
    }
}
