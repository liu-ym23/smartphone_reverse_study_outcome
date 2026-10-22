package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TodoExtra extends Message<TodoExtra, Builder> {
    public static final ProtoAdapter<TodoExtra> ADAPTER = null;
    public static final ByteString DEFAULT_EXTRA = null;
    private static final long serialVersionUID = 0;
    public final ByteString extra;

    public static final class Builder extends Message.Builder<TodoExtra, Builder> {
        public ByteString extra;

        @Override // com.squareup.wire.Message.Builder
        public TodoExtra build() {
            return new TodoExtra(this.extra, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder extra(ByteString r100) {
            this.extra = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TodoExtra extends ProtoAdapter<TodoExtra> {
        public ProtoAdapter_TodoExtra() {
            super(FieldEncoding.LENGTH_DELIMITED, TodoExtra.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TodoExtra decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.extra = ByteString.EMPTY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.extra = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TodoExtra r100) {
            ByteString r101 = r100.extra;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.BYTES.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TodoExtra decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TodoExtra r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TodoExtra r101) throws IOException {
            ByteString r102 = r101.extra;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TodoExtra r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TodoExtra();
        DEFAULT_EXTRA = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.extra = this.extra;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TodoExtra.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TodoExtra(ByteString r100) {
        this(r100, ByteString.EMPTY);
    }

    public TodoExtra(ByteString r100, ByteString r101) {
        super(ADAPTER, r101);
        this.extra = r100;
    }
}
