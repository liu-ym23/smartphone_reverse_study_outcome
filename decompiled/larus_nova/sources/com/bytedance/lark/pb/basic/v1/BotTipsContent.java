package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class BotTipsContent extends com.squareup.wire.Message<BotTipsContent, Builder> {
    public static final ProtoAdapter<BotTipsContent> ADAPTER = null;
    public static final String DEFAULT_ADMIN_ID = "";
    public static final String DEFAULT_I18N_ADMIN_NAME = "";
    public static final String DEFAULT_I18N_MSG = "";
    private static final long serialVersionUID = 0;
    public final String admin_id;
    public final String i18n_admin_name;
    public final String i18n_msg;

    public static final class Builder extends com.squareup.wire.Message.Builder<BotTipsContent, Builder> {
        public String admin_id;
        public String i18n_admin_name;
        public String i18n_msg;

        @Override // com.squareup.wire.Message.Builder
        public BotTipsContent build() {
            return new BotTipsContent(this.i18n_msg, this.admin_id, this.i18n_admin_name, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder admin_id(String r100) {
            this.admin_id = r100;
            return this;
        }

        public Builder i18n_admin_name(String r100) {
            this.i18n_admin_name = r100;
            return this;
        }

        public Builder i18n_msg(String r100) {
            this.i18n_msg = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BotTipsContent extends ProtoAdapter<BotTipsContent> {
        public ProtoAdapter_BotTipsContent() {
            super(FieldEncoding.LENGTH_DELIMITED, BotTipsContent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BotTipsContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.i18n_msg = "";
            r101.admin_id = "";
            r101.i18n_admin_name = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.i18n_msg = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.admin_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.i18n_admin_name = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(BotTipsContent r100) {
            String r101 = r100.i18n_msg;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.admin_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.i18n_admin_name;
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
        public /* bridge */ /* synthetic */ BotTipsContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BotTipsContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BotTipsContent r101) throws IOException {
            String r102 = r101.i18n_msg;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.admin_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.i18n_admin_name;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BotTipsContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BotTipsContent();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.i18n_msg = this.i18n_msg;
        r100.admin_id = this.admin_id;
        r100.i18n_admin_name = this.i18n_admin_name;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BotTipsContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public BotTipsContent(String r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public BotTipsContent(String r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.i18n_msg = r100;
        this.admin_id = r101;
        this.i18n_admin_name = r102;
    }
}
