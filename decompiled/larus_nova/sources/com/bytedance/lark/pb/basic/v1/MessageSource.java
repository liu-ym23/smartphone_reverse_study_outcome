package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class MessageSource extends com.squareup.wire.Message<MessageSource, Builder> {
    public static final ProtoAdapter<MessageSource> ADAPTER = null;
    public static final String DEFAULT_SOURCE_ID = "";
    public static final MessageSourceType DEFAULT_SOURCE_TYPE = null;
    private static final long serialVersionUID = 0;
    public final List<String> message_id_path;
    public final String source_id;
    public final MessageSourceType source_type;

    public static final class Builder extends com.squareup.wire.Message.Builder<MessageSource, Builder> {
        public List<String> message_id_path;
        public String source_id;
        public MessageSourceType source_type;

        @Override // com.squareup.wire.Message.Builder
        public MessageSource build() {
            MessageSourceType r100 = this.source_type;
            if (r100 == null) goto L7;
            return new MessageSource(this.source_type, this.source_id, this.message_id_path, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "source_type"});
        }

        public Builder() {
            this.message_id_path = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder message_id_path(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_id_path = r100;
            return this;
        }

        public Builder source_id(String r100) {
            this.source_id = r100;
            return this;
        }

        public Builder source_type(MessageSourceType r100) {
            this.source_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MessageSource extends ProtoAdapter<MessageSource> {
        public ProtoAdapter_MessageSource() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageSource.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MessageSource decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.source_type = MessageSourceType.COMMON_MESSAGE;
            r101.source_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.source_type = MessageSourceType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.message_id_path.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MessageSource r100) {
            int r101 = MessageSourceType.ADAPTER.encodedSizeWithTag(1, r100.source_type);
            String r102 = r100.source_id;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L7:
            return ((r101 + r103) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(3, r100.message_id_path)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MessageSource decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MessageSource r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MessageSource r101) throws IOException {
            MessageSourceType.ADAPTER.encodeWithTag(r100, 1, r101.source_type);
            String r102 = r101.source_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 3, r101.message_id_path);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageSource r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageSource();
        DEFAULT_SOURCE_TYPE = MessageSourceType.COMMON_MESSAGE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.source_type = this.source_type;
        r100.source_id = this.source_id;
        r100.message_id_path = Internal.copyOf("message_id_path", this.message_id_path);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MessageSource.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public MessageSource(MessageSourceType r100, String r101, List<String> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public MessageSource(MessageSourceType r100, String r101, List<String> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.source_type = r100;
        this.source_id = r101;
        this.message_id_path = Internal.immutableCopyOf("message_id_path", r102);
    }
}
