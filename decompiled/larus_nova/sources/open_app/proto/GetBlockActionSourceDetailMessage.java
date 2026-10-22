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
public final class GetBlockActionSourceDetailMessage extends Message<GetBlockActionSourceDetailMessage, Builder> {
    public static final ProtoAdapter<GetBlockActionSourceDetailMessage> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_CREATE_TIME = "";
    public static final String DEFAULT_MESSAGE_TYPE = "";
    public static final String DEFAULT_OPEN_CHAT_ID = "";
    public static final String DEFAULT_OPEN_MESSAGE_ID = "";
    public static final Boolean DEFAULT_STATUS = null;
    public static final Boolean DEFAULT_SUPPORT = null;
    private static final long serialVersionUID = 0;
    public final String content;
    public final String create_time;
    public final String message_type;
    public final String open_chat_id;
    public final String open_message_id;
    public final MessagesSender sender;
    public final Boolean status;
    public final Boolean support;

    public static final class Builder extends Message.Builder<GetBlockActionSourceDetailMessage, Builder> {
        public String content;
        public String create_time;
        public String message_type;
        public String open_chat_id;
        public String open_message_id;
        public MessagesSender sender;
        public Boolean status;
        public Boolean support;

        @Override // com.squareup.wire.Message.Builder
        public GetBlockActionSourceDetailMessage build() {
            String r100 = this.message_type;
            if (r100 == null) goto L21;
            if (this.sender == null) goto L21;
            if (this.create_time == null) goto L21;
            if (this.support == null) goto L21;
            if (this.open_chat_id == null) goto L21;
            if (this.open_message_id == null) goto L21;
            if (this.content == null) goto L21;
            if (this.status == null) goto L21;
            return new GetBlockActionSourceDetailMessage(this.message_type, this.sender, this.create_time, this.support, this.open_chat_id, this.open_message_id, this.content, this.status, super.buildUnknownFields());
        L21:
            throw Internal.missingRequiredFields(new Object[]{r100, "message_type", this.sender, "sender", this.create_time, "create_time", this.support, "support", this.open_chat_id, "open_chat_id", this.open_message_id, "open_message_id", this.content, "content", this.status, "status"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder content(String r100) {
            this.content = r100;
            return this;
        }

        public Builder create_time(String r100) {
            this.create_time = r100;
            return this;
        }

        public Builder message_type(String r100) {
            this.message_type = r100;
            return this;
        }

        public Builder open_chat_id(String r100) {
            this.open_chat_id = r100;
            return this;
        }

        public Builder open_message_id(String r100) {
            this.open_message_id = r100;
            return this;
        }

        public Builder sender(MessagesSender r100) {
            this.sender = r100;
            return this;
        }

        public Builder status(Boolean r100) {
            this.status = r100;
            return this;
        }

        public Builder support(Boolean r100) {
            this.support = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetBlockActionSourceDetailMessage extends ProtoAdapter<GetBlockActionSourceDetailMessage> {
        public ProtoAdapter_GetBlockActionSourceDetailMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, GetBlockActionSourceDetailMessage.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public GetBlockActionSourceDetailMessage decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            switch(r103) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L7:
            r101.status = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.content = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.open_message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.open_chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.support = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.create_time = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.sender = MessagesSender.ADAPTER.decode(r100);
            goto L3
        L14:
            r101.message_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetBlockActionSourceDetailMessage r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.message_type) + MessagesSender.ADAPTER.encodedSizeWithTag(2, r100.sender)) + r101.encodedSizeWithTag(3, r100.create_time);
            ProtoAdapter<Boolean> r103 = ProtoAdapter.BOOL;
            return (((((r102 + r103.encodedSizeWithTag(4, r100.support)) + r101.encodedSizeWithTag(5, r100.open_chat_id)) + r101.encodedSizeWithTag(6, r100.open_message_id)) + r101.encodedSizeWithTag(7, r100.content)) + r103.encodedSizeWithTag(8, r100.status)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetBlockActionSourceDetailMessage decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetBlockActionSourceDetailMessage r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetBlockActionSourceDetailMessage r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.message_type);
            MessagesSender.ADAPTER.encodeWithTag(r100, 2, r101.sender);
            r102.encodeWithTag(r100, 3, r101.create_time);
            ProtoAdapter<Boolean> r103 = ProtoAdapter.BOOL;
            r103.encodeWithTag(r100, 4, r101.support);
            r102.encodeWithTag(r100, 5, r101.open_chat_id);
            r102.encodeWithTag(r100, 6, r101.open_message_id);
            r102.encodeWithTag(r100, 7, r101.content);
            r103.encodeWithTag(r100, 8, r101.status);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetBlockActionSourceDetailMessage r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetBlockActionSourceDetailMessage();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_SUPPORT = r100;
        DEFAULT_STATUS = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_type = this.message_type;
        r100.sender = this.sender;
        r100.create_time = this.create_time;
        r100.support = this.support;
        r100.open_chat_id = this.open_chat_id;
        r100.open_message_id = this.open_message_id;
        r100.content = this.content;
        r100.status = this.status;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetBlockActionSourceDetailMessage.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetBlockActionSourceDetailMessage(String r110, MessagesSender r111, String r112, Boolean r113, String r114, String r115, String r116, Boolean r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public GetBlockActionSourceDetailMessage(String r100, MessagesSender r101, String r102, Boolean r103, String r104, String r105, String r106, Boolean r107, ByteString r110) {
        super(ADAPTER, r110);
        this.message_type = r100;
        this.sender = r101;
        this.create_time = r102;
        this.support = r103;
        this.open_chat_id = r104;
        this.open_message_id = r105;
        this.content = r106;
        this.status = r107;
    }
}
