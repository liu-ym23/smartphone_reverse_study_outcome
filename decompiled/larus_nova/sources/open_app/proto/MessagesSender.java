package open_app.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class MessagesSender extends Message<MessagesSender, Builder> {
    public static final ProtoAdapter<MessagesSender> ADAPTER = null;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_OPEN_ID = "";
    public static final String DEFAULT_STATUS = "";
    private static final long serialVersionUID = 0;
    public final String name;
    public final String open_id;
    public final String status;

    public static final class Builder extends Message.Builder<MessagesSender, Builder> {
        public String name;
        public String open_id;
        public String status;

        @Override // com.squareup.wire.Message.Builder
        public MessagesSender build() {
            String r100 = this.name;
            if (r100 == null) goto L9;
            if (this.open_id == null) goto L9;
            return new MessagesSender(this.name, this.open_id, this.status, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "name", this.open_id, Constants.JumpUrlConstants.URL_KEY_OPENID});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder open_id(String r100) {
            this.open_id = r100;
            return this;
        }

        public Builder status(String r100) {
            this.status = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MessagesSender extends ProtoAdapter<MessagesSender> {
        public ProtoAdapter_MessagesSender() {
            super(FieldEncoding.LENGTH_DELIMITED, MessagesSender.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public MessagesSender decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.open_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.status = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(MessagesSender r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.name) + r101.encodedSizeWithTag(2, r100.open_id);
            String r103 = r100.status;
            if (r103 == null) goto L5;
            int r104 = r101.encodedSizeWithTag(3, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MessagesSender decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MessagesSender r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MessagesSender r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.name);
            r102.encodeWithTag(r100, 2, r101.open_id);
            String r103 = r101.status;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessagesSender r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessagesSender();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.name = this.name;
        r100.open_id = this.open_id;
        r100.status = this.status;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MessagesSender.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MessagesSender(String r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public MessagesSender(String r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.name = r100;
        this.open_id = r101;
        this.status = r102;
    }
}
