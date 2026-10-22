package lark_bitable.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class AttachmentCellItem extends Message<AttachmentCellItem, Builder> {
    public static final ProtoAdapter<AttachmentCellItem> ADAPTER = null;
    public static final String DEFAULT_EXTRA = "";
    public static final String DEFAULT_MIME_TYPE = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    public final String extra;
    public final String mime_type;
    public final String name;
    public final String token;

    public static final class Builder extends Message.Builder<AttachmentCellItem, Builder> {
        public String extra;
        public String mime_type;
        public String name;
        public String token;

        @Override // com.squareup.wire.Message.Builder
        public AttachmentCellItem build() {
            String r100 = this.name;
            if (r100 == null) goto L13;
            if (this.mime_type == null) goto L13;
            if (this.token == null) goto L13;
            if (this.extra == null) goto L13;
            return new AttachmentCellItem(this.name, this.mime_type, this.token, this.extra, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "name", this.mime_type, "mime_type", this.token, "token", this.extra, "extra"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder extra(String r100) {
            this.extra = r100;
            return this;
        }

        public Builder mime_type(String r100) {
            this.mime_type = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AttachmentCellItem extends ProtoAdapter<AttachmentCellItem> {
        public ProtoAdapter_AttachmentCellItem() {
            super(FieldEncoding.LENGTH_DELIMITED, AttachmentCellItem.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public AttachmentCellItem decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mime_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.extra = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(AttachmentCellItem r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (((r101.encodedSizeWithTag(1, r100.name) + r101.encodedSizeWithTag(2, r100.mime_type)) + r101.encodedSizeWithTag(3, r100.token)) + r101.encodedSizeWithTag(4, r100.extra)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AttachmentCellItem decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AttachmentCellItem r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AttachmentCellItem r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.name);
            r102.encodeWithTag(r100, 2, r101.mime_type);
            r102.encodeWithTag(r100, 3, r101.token);
            r102.encodeWithTag(r100, 4, r101.extra);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AttachmentCellItem r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AttachmentCellItem();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.name = this.name;
        r100.mime_type = this.mime_type;
        r100.token = this.token;
        r100.extra = this.extra;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AttachmentCellItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AttachmentCellItem(String r100, String r101, String r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public AttachmentCellItem(String r100, String r101, String r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.name = r100;
        this.mime_type = r101;
        this.token = r102;
        this.extra = r103;
    }
}
