package com.bytedance.lark.pb.todo.v1;

import com.google.protobuf.MessageOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TodoOwner extends Message<TodoOwner, Builder> {
    public static final ProtoAdapter<TodoOwner> ADAPTER = null;
    public static final String DEFAULT_ASSIGNER_ID = "";
    public static final Long DEFAULT_READ_MILLI_TIME = null;
    public static final MessageOptions MESSAGE_OPTIONS = null;
    private static final long serialVersionUID = 0;
    public final String assigner_id;
    public final Long read_milli_time;
    public final TodoUser user;

    public static final class Builder extends Message.Builder<TodoOwner, Builder> {
        public String assigner_id;
        public Long read_milli_time;
        public TodoUser user;

        @Override // com.squareup.wire.Message.Builder
        public TodoOwner build() {
            return new TodoOwner(this.user, this.assigner_id, this.read_milli_time, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder assigner_id(String r100) {
            this.assigner_id = r100;
            return this;
        }

        public Builder read_milli_time(Long r100) {
            this.read_milli_time = r100;
            return this;
        }

        public Builder user(TodoUser r100) {
            this.user = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TodoOwner extends ProtoAdapter<TodoOwner> {
        public ProtoAdapter_TodoOwner() {
            super(FieldEncoding.LENGTH_DELIMITED, TodoOwner.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TodoOwner decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.assigner_id = "";
            r101.read_milli_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.user = TodoUser.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.assigner_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.read_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TodoOwner r100) {
            TodoUser r101 = r100.user;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = TodoUser.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.assigner_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.read_milli_time;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TodoOwner decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TodoOwner r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TodoOwner r101) throws IOException {
            TodoUser r102 = r101.user;
            if (r102 == null) goto L5;
            TodoUser.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.assigner_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.read_milli_time;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TodoOwner r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TodoOwner();
        MESSAGE_OPTIONS = new MessageOptions.Builder().deprecated(Boolean.TRUE).build();
        DEFAULT_READ_MILLI_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user = this.user;
        r100.assigner_id = this.assigner_id;
        r100.read_milli_time = this.read_milli_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TodoOwner.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TodoOwner(TodoUser r100, String r101, Long r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public TodoOwner(TodoUser r100, String r101, Long r102, ByteString r103) {
        super(ADAPTER, r103);
        this.user = r100;
        this.assigner_id = r101;
        this.read_milli_time = r102;
    }
}
