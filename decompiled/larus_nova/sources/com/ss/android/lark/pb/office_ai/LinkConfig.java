package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class LinkConfig extends Message<LinkConfig, Builder> {
    public static final ProtoAdapter<LinkConfig> ADAPTER = null;
    public static final String DEFAULT_LINK_ADDR = "";
    private static final long serialVersionUID = 0;
    public final String mlink_addr;
    public final LinkProtocolType mprotocol_type;

    public static final class Builder extends Message.Builder<LinkConfig, Builder> {
        public String mlink_addr;
        public LinkProtocolType mprotocol_type;

        @Override // com.squareup.wire.Message.Builder
        public LinkConfig build() {
            return new LinkConfig(this.mprotocol_type, this.mlink_addr, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder link_addr(String r100) {
            this.mlink_addr = r100;
            return this;
        }

        public Builder protocol_type(LinkProtocolType r100) {
            this.mprotocol_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LinkConfig extends ProtoAdapter<LinkConfig> {
        public ProtoAdapter_LinkConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, LinkConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public LinkConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mlink_addr = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mprotocol_type = LinkProtocolType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mlink_addr = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(LinkConfig r100) {
            LinkProtocolType r101 = r100.mprotocol_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = LinkProtocolType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mlink_addr;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LinkConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LinkConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LinkConfig r101) throws IOException {
            LinkProtocolType r102 = r101.mprotocol_type;
            if (r102 == null) goto L5;
            LinkProtocolType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mlink_addr;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LinkConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LinkConfig();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mprotocol_type = this.mprotocol_type;
        r100.mlink_addr = this.mlink_addr;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LinkConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LinkConfig(LinkProtocolType r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public LinkConfig(LinkProtocolType r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mprotocol_type = r100;
        this.mlink_addr = r101;
    }
}
