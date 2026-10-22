package open_app.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class IdRequestChatInfo extends Message<IdRequestChatInfo, Builder> {
    public static final ProtoAdapter<IdRequestChatInfo> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Integer DEFAULT_CHAT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final Integer chat_type;

    public static final class Builder extends Message.Builder<IdRequestChatInfo, Builder> {
        public String chat_id;
        public Integer chat_type;

        @Override // com.squareup.wire.Message.Builder
        public IdRequestChatInfo build() {
            String r100 = this.chat_id;
            if (r100 == null) goto L9;
            if (this.chat_type == null) goto L9;
            return new IdRequestChatInfo(this.chat_id, this.chat_type, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "chat_id", this.chat_type, "chat_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder chat_type(Integer r100) {
            this.chat_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_IdRequestChatInfo extends ProtoAdapter<IdRequestChatInfo> {
        public ProtoAdapter_IdRequestChatInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, IdRequestChatInfo.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public IdRequestChatInfo decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.chat_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(IdRequestChatInfo r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.chat_id) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.chat_type)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ IdRequestChatInfo decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(IdRequestChatInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, IdRequestChatInfo r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.chat_id);
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.chat_type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, IdRequestChatInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_IdRequestChatInfo();
        DEFAULT_CHAT_TYPE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.chat_type = this.chat_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return IdRequestChatInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public IdRequestChatInfo(String r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public IdRequestChatInfo(String r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.chat_id = r100;
        this.chat_type = r101;
    }
}
