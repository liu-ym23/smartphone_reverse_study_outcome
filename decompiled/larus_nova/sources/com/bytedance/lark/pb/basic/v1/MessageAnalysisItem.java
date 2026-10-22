package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class MessageAnalysisItem extends com.squareup.wire.Message<MessageAnalysisItem, Builder> {
    public static final ProtoAdapter<MessageAnalysisItem> ADAPTER = null;
    public static final String DEFAULT_ICON_URL = "";
    public static final String DEFAULT_JUMP_URL = "";
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final String icon_url;
    public final String jump_url;
    public final String name;

    public static final class Builder extends com.squareup.wire.Message.Builder<MessageAnalysisItem, Builder> {
        public String icon_url;
        public String jump_url;
        public String name;

        @Override // com.squareup.wire.Message.Builder
        public MessageAnalysisItem build() {
            return new MessageAnalysisItem(this.name, this.icon_url, this.jump_url, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder icon_url(String r100) {
            this.icon_url = r100;
            return this;
        }

        public Builder jump_url(String r100) {
            this.jump_url = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MessageAnalysisItem extends ProtoAdapter<MessageAnalysisItem> {
        public ProtoAdapter_MessageAnalysisItem() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageAnalysisItem.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MessageAnalysisItem decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.name = "";
            r101.icon_url = "";
            r101.jump_url = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.icon_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.jump_url = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(MessageAnalysisItem r100) {
            String r101 = r100.name;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.icon_url;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.jump_url;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ MessageAnalysisItem decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MessageAnalysisItem r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MessageAnalysisItem r101) throws IOException {
            String r102 = r101.name;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.icon_url;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.jump_url;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageAnalysisItem r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageAnalysisItem();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.name = this.name;
        r100.icon_url = this.icon_url;
        r100.jump_url = this.jump_url;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MessageAnalysisItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public MessageAnalysisItem(String r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public MessageAnalysisItem(String r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.name = r100;
        this.icon_url = r101;
        this.jump_url = r102;
    }
}
