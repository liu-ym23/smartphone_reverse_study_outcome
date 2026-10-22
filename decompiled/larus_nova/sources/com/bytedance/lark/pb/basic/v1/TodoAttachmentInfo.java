package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class TodoAttachmentInfo extends com.squareup.wire.Message<TodoAttachmentInfo, Builder> {
    public static final ProtoAdapter<TodoAttachmentInfo> ADAPTER = null;
    public static final TodoAttachmentType DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final TodoAttachmentType type;

    public static final class Builder extends com.squareup.wire.Message.Builder<TodoAttachmentInfo, Builder> {
        public TodoAttachmentType type;

        @Override // com.squareup.wire.Message.Builder
        public TodoAttachmentInfo build() {
            return new TodoAttachmentInfo(this.type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder type(TodoAttachmentType r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TodoAttachmentInfo extends ProtoAdapter<TodoAttachmentInfo> {
        public ProtoAdapter_TodoAttachmentInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, TodoAttachmentInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TodoAttachmentInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = TodoAttachmentType.UNKNOWN_ATTACHMENT_TYPE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.type = TodoAttachmentType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TodoAttachmentInfo r100) {
            TodoAttachmentType r101 = r100.type;
            if (r101 == null) goto L5;
            int r102 = TodoAttachmentType.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TodoAttachmentInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TodoAttachmentInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TodoAttachmentInfo r101) throws IOException {
            TodoAttachmentType r102 = r101.type;
            if (r102 == null) goto L5;
            TodoAttachmentType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TodoAttachmentInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum TodoAttachmentType extends Enum<TodoAttachmentType> implements WireEnum {
        private static final /* synthetic */ TodoAttachmentType[] $VALUES = null;
        public static final ProtoAdapter<TodoAttachmentType> ADAPTER = null;
        public static final TodoAttachmentType IMAGE = null;
        public static final TodoAttachmentType UNKNOWN_ATTACHMENT_TYPE = null;
        private final int value;

        static {
            TodoAttachmentType r100 = new TodoAttachmentType("UNKNOWN_ATTACHMENT_TYPE", 0, 0);
            UNKNOWN_ATTACHMENT_TYPE = r100;
            TodoAttachmentType r101 = new TodoAttachmentType("IMAGE", 1, 1);
            IMAGE = r101;
            $VALUES = new TodoAttachmentType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(TodoAttachmentType.class);
        }

        public static TodoAttachmentType[] values() {
            return (TodoAttachmentType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static TodoAttachmentType fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return IMAGE;
        L10:
            return UNKNOWN_ATTACHMENT_TYPE;
        }

        public static TodoAttachmentType valueOf(String r100) {
            return (TodoAttachmentType) a.a(TodoAttachmentType.class, r100);
        }

        private TodoAttachmentType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TodoAttachmentInfo();
        DEFAULT_TYPE = TodoAttachmentType.UNKNOWN_ATTACHMENT_TYPE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TodoAttachmentInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TodoAttachmentInfo(TodoAttachmentType r100) {
        this(r100, ByteString.EMPTY);
    }

    public TodoAttachmentInfo(TodoAttachmentType r100, ByteString r101) {
        super(ADAPTER, r101);
        this.type = r100;
    }
}
