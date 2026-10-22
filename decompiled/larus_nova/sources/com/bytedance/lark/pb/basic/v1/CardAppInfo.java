package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class CardAppInfo extends com.squareup.wire.Message<CardAppInfo, Builder> {
    public static final ProtoAdapter<CardAppInfo> ADAPTER = null;
    public static final String DEFAULT_APP_ID = "";
    public static final String DEFAULT_BOT_ID = "";
    private static final long serialVersionUID = 0;
    public final String app_id;
    public final String bot_id;

    public static final class Builder extends com.squareup.wire.Message.Builder<CardAppInfo, Builder> {
        public String app_id;
        public String bot_id;

        @Override // com.squareup.wire.Message.Builder
        public CardAppInfo build() {
            return new CardAppInfo(this.app_id, this.bot_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder app_id(String r100) {
            this.app_id = r100;
            return this;
        }

        public Builder bot_id(String r100) {
            this.bot_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CardAppInfo extends ProtoAdapter<CardAppInfo> {
        public ProtoAdapter_CardAppInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, CardAppInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CardAppInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.app_id = "";
            r101.bot_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.app_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.bot_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(CardAppInfo r100) {
            String r101 = r100.app_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.bot_id;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CardAppInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CardAppInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CardAppInfo r101) throws IOException {
            String r102 = r101.app_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.bot_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CardAppInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CardAppInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.app_id = this.app_id;
        r100.bot_id = this.bot_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CardAppInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public CardAppInfo(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CardAppInfo(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.app_id = r100;
        this.bot_id = r101;
    }
}
