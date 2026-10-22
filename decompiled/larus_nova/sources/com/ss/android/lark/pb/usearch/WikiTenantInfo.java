package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class WikiTenantInfo extends Message<WikiTenantInfo, Builder> {
    public static final ProtoAdapter<WikiTenantInfo> ADAPTER = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final Long DEFAULT_TENANT_ID = null;
    private static final long serialVersionUID = 0;
    public final String mavatar_key;
    public final Long mtenant_id;
    public final I18NNameText mtenant_name;

    public static final class Builder extends Message.Builder<WikiTenantInfo, Builder> {
        public String mavatar_key;
        public Long mtenant_id;
        public I18NNameText mtenant_name;

        @Override // com.squareup.wire.Message.Builder
        public WikiTenantInfo build() {
            return new WikiTenantInfo(this.mtenant_id, this.mtenant_name, this.mavatar_key, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder avatar_key(String r100) {
            this.mavatar_key = r100;
            return this;
        }

        public Builder tenant_id(Long r100) {
            this.mtenant_id = r100;
            return this;
        }

        public Builder tenant_name(I18NNameText r100) {
            this.mtenant_name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_WikiTenantInfo extends ProtoAdapter<WikiTenantInfo> {
        public ProtoAdapter_WikiTenantInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, WikiTenantInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public WikiTenantInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mtenant_id = 0L;
            r101.mavatar_key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mtenant_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mtenant_name = I18NNameText.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mavatar_key = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(WikiTenantInfo r100) {
            Long r101 = r100.mtenant_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            I18NNameText r104 = r100.mtenant_name;
            if (r104 == null) goto L9;
            int r105 = I18NNameText.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mavatar_key;
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
        public /* bridge */ /* synthetic */ WikiTenantInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(WikiTenantInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, WikiTenantInfo r101) throws IOException {
            Long r102 = r101.mtenant_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            I18NNameText r103 = r101.mtenant_name;
            if (r103 == null) goto L8;
            I18NNameText.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mavatar_key;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WikiTenantInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_WikiTenantInfo();
        DEFAULT_TENANT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtenant_id = this.mtenant_id;
        r100.mtenant_name = this.mtenant_name;
        r100.mavatar_key = this.mavatar_key;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return WikiTenantInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public WikiTenantInfo(Long r100, I18NNameText r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public WikiTenantInfo(Long r100, I18NNameText r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mtenant_id = r100;
        this.mtenant_name = r101;
        this.mavatar_key = r102;
    }
}
