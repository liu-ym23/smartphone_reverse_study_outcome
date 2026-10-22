package im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class MessageIdentity extends Message<MessageIdentity, Builder> {
    public static final ProtoAdapter<MessageIdentity> ADAPTER = null;
    public static final Long DEFAULT_ID = null;
    public static final Long DEFAULT_MESSAGE_CHAT_ID = null;
    public static final Long DEFAULT_MESSAGE_CREATE_TIME_MS = null;
    public static final Long DEFAULT_TENANT_ID = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final Long f490425id;
    public final Long message_chat_id;
    public final Long message_create_time_ms;
    public final Long tenant_id;

    public static final class Builder extends Message.Builder<MessageIdentity, Builder> {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public Long f490426id;
        public Long message_chat_id;
        public Long message_create_time_ms;
        public Long tenant_id;

        @Override // com.squareup.wire.Message.Builder
        public MessageIdentity build() {
            return new MessageIdentity(this.f490426id, this.message_chat_id, this.tenant_id, this.message_create_time_ms, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder id(Long r100) {
            this.f490426id = r100;
            return this;
        }

        public Builder message_chat_id(Long r100) {
            this.message_chat_id = r100;
            return this;
        }

        public Builder message_create_time_ms(Long r100) {
            this.message_create_time_ms = r100;
            return this;
        }

        public Builder tenant_id(Long r100) {
            this.tenant_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MessageIdentity extends ProtoAdapter<MessageIdentity> {
        public ProtoAdapter_MessageIdentity() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageIdentity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MessageIdentity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f490426id = 0L;
            r101.message_chat_id = 0L;
            r101.tenant_id = 0L;
            r101.message_create_time_ms = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.f490426id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.message_chat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.tenant_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.message_create_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MessageIdentity r100) {
            Long r101 = r100.f490425id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.message_chat_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.tenant_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.message_create_time_ms;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MessageIdentity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MessageIdentity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MessageIdentity r101) throws IOException {
            Long r102 = r101.f490425id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.message_chat_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.tenant_id;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.message_create_time_ms;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageIdentity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageIdentity();
        DEFAULT_ID = 0L;
        DEFAULT_MESSAGE_CHAT_ID = 0L;
        DEFAULT_TENANT_ID = 0L;
        DEFAULT_MESSAGE_CREATE_TIME_MS = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f490426id = this.f490425id;
        r100.message_chat_id = this.message_chat_id;
        r100.tenant_id = this.tenant_id;
        r100.message_create_time_ms = this.message_create_time_ms;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MessageIdentity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MessageIdentity(Long r100, Long r101, Long r102, Long r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public MessageIdentity(Long r100, Long r101, Long r102, Long r103, ByteString r104) {
        super(ADAPTER, r104);
        this.f490425id = r100;
        this.message_chat_id = r101;
        this.tenant_id = r102;
        this.message_create_time_ms = r103;
    }
}
