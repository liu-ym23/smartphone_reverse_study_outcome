package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class HongbaoSystemContent extends com.squareup.wire.Message<HongbaoSystemContent, Builder> {
    public static final ProtoAdapter<HongbaoSystemContent> ADAPTER = null;
    public static final String DEFAULT_HONGBAO_ID = "";
    public static final String DEFAULT_MESSAGE_ID = "";
    private static final long serialVersionUID = 0;
    public final String hongbao_id;
    public final String message_id;
    public final Map<String, String> wallet;

    public static final class Builder extends com.squareup.wire.Message.Builder<HongbaoSystemContent, Builder> {
        public String hongbao_id;
        public String message_id;
        public Map<String, String> wallet;

        @Override // com.squareup.wire.Message.Builder
        public HongbaoSystemContent build() {
            return new HongbaoSystemContent(this.wallet, this.hongbao_id, this.message_id, super.buildUnknownFields());
        }

        public Builder() {
            this.wallet = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder hongbao_id(String r100) {
            this.hongbao_id = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder wallet(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.wallet = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_HongbaoSystemContent extends ProtoAdapter<HongbaoSystemContent> {
        private final ProtoAdapter<Map<String, String>> wallet;

        public ProtoAdapter_HongbaoSystemContent() {
            super(FieldEncoding.LENGTH_DELIMITED, HongbaoSystemContent.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.wallet = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public HongbaoSystemContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.hongbao_id = "";
            r101.message_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.wallet.putAll(this.wallet.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.hongbao_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.message_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(HongbaoSystemContent r100) {
            int r101 = this.wallet.encodedSizeWithTag(1, r100.wallet);
            String r102 = r100.hongbao_id;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            String r106 = r100.message_id;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.STRING.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ HongbaoSystemContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(HongbaoSystemContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, HongbaoSystemContent r101) throws IOException {
            this.wallet.encodeWithTag(r100, 1, r101.wallet);
            String r102 = r101.hongbao_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            String r103 = r101.message_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HongbaoSystemContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_HongbaoSystemContent();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.wallet = Internal.copyOf("wallet", this.wallet);
        r100.hongbao_id = this.hongbao_id;
        r100.message_id = this.message_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return HongbaoSystemContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public HongbaoSystemContent(Map<String, String> r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public HongbaoSystemContent(Map<String, String> r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.wallet = Internal.immutableCopyOf("wallet", r100);
        this.hongbao_id = r101;
        this.message_id = r102;
    }
}
