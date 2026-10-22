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
public final class OpenPlatformChatModel extends Message<OpenPlatformChatModel, Builder> {
    public static final ProtoAdapter<OpenPlatformChatModel> ADAPTER = null;
    public static final String DEFAULT_BIZ_TYPE = "";
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_CHAT_NAME = "";
    private static final long serialVersionUID = 0;
    public final String biz_type;
    public final String chat_id;
    public final String chat_name;

    public static final class Builder extends Message.Builder<OpenPlatformChatModel, Builder> {
        public String biz_type;
        public String chat_id;
        public String chat_name;

        @Override // com.squareup.wire.Message.Builder
        public OpenPlatformChatModel build() {
            String r100 = this.chat_id;
            if (r100 == null) goto L11;
            if (this.chat_name == null) goto L11;
            if (this.biz_type == null) goto L11;
            return new OpenPlatformChatModel(this.chat_id, this.chat_name, this.biz_type, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "chat_id", this.chat_name, "chat_name", this.biz_type, "biz_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder biz_type(String r100) {
            this.biz_type = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder chat_name(String r100) {
            this.chat_name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_OpenPlatformChatModel extends ProtoAdapter<OpenPlatformChatModel> {
        public ProtoAdapter_OpenPlatformChatModel() {
            super(FieldEncoding.LENGTH_DELIMITED, OpenPlatformChatModel.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public OpenPlatformChatModel decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.chat_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.biz_type = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(OpenPlatformChatModel r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((r101.encodedSizeWithTag(1, r100.chat_id) + r101.encodedSizeWithTag(2, r100.chat_name)) + r101.encodedSizeWithTag(3, r100.biz_type)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OpenPlatformChatModel decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OpenPlatformChatModel r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OpenPlatformChatModel r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.chat_id);
            r102.encodeWithTag(r100, 2, r101.chat_name);
            r102.encodeWithTag(r100, 3, r101.biz_type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OpenPlatformChatModel r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OpenPlatformChatModel();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.chat_name = this.chat_name;
        r100.biz_type = this.biz_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OpenPlatformChatModel.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OpenPlatformChatModel(String r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public OpenPlatformChatModel(String r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.chat_id = r100;
        this.chat_name = r101;
        this.biz_type = r102;
    }
}
