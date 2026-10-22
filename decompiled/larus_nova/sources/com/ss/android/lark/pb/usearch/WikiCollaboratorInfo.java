package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class WikiCollaboratorInfo extends Message<WikiCollaboratorInfo, Builder> {
    public static final ProtoAdapter<WikiCollaboratorInfo> ADAPTER = null;
    public static final String DEFAULT_AVATAR_URL = "";
    public static final Long DEFAULT_MEMBER_ID = null;
    public static final Long DEFAULT_TENANT_ID = null;
    private static final long serialVersionUID = 0;
    public final String mavatar_url;
    public final I18NNameText mmember_display_name;
    public final Long mmember_id;
    public final I18NNameText mmember_name;
    public final Long mtenant_id;

    public static final class Builder extends Message.Builder<WikiCollaboratorInfo, Builder> {
        public String mavatar_url;
        public I18NNameText mmember_display_name;
        public Long mmember_id;
        public I18NNameText mmember_name;
        public Long mtenant_id;

        @Override // com.squareup.wire.Message.Builder
        public WikiCollaboratorInfo build() {
            return new WikiCollaboratorInfo(this.mmember_id, this.mmember_name, this.mmember_display_name, this.mavatar_url, this.mtenant_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder avatar_url(String r100) {
            this.mavatar_url = r100;
            return this;
        }

        public Builder member_display_name(I18NNameText r100) {
            this.mmember_display_name = r100;
            return this;
        }

        public Builder member_id(Long r100) {
            this.mmember_id = r100;
            return this;
        }

        public Builder member_name(I18NNameText r100) {
            this.mmember_name = r100;
            return this;
        }

        public Builder tenant_id(Long r100) {
            this.mtenant_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_WikiCollaboratorInfo extends ProtoAdapter<WikiCollaboratorInfo> {
        public ProtoAdapter_WikiCollaboratorInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, WikiCollaboratorInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public WikiCollaboratorInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mmember_id = 0L;
            r101.mavatar_url = "";
            r101.mtenant_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mmember_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mmember_name = I18NNameText.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mmember_display_name = I18NNameText.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.mavatar_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.mtenant_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(WikiCollaboratorInfo r100) {
            Long r101 = r100.mmember_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            I18NNameText r104 = r100.mmember_name;
            if (r104 == null) goto L9;
            int r105 = I18NNameText.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            I18NNameText r107 = r100.mmember_display_name;
            if (r107 == null) goto L13;
            int r108 = I18NNameText.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mavatar_url;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.mtenant_id;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ WikiCollaboratorInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(WikiCollaboratorInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, WikiCollaboratorInfo r101) throws IOException {
            Long r102 = r101.mmember_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            I18NNameText r103 = r101.mmember_name;
            if (r103 == null) goto L8;
            I18NNameText.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            I18NNameText r104 = r101.mmember_display_name;
            if (r104 == null) goto L11;
            I18NNameText.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mavatar_url;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Long r106 = r101.mtenant_id;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WikiCollaboratorInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_WikiCollaboratorInfo();
        DEFAULT_MEMBER_ID = 0L;
        DEFAULT_TENANT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mmember_id = this.mmember_id;
        r100.mmember_name = this.mmember_name;
        r100.mmember_display_name = this.mmember_display_name;
        r100.mavatar_url = this.mavatar_url;
        r100.mtenant_id = this.mtenant_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return WikiCollaboratorInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public WikiCollaboratorInfo(Long r100, I18NNameText r101, I18NNameText r110, String r111, Long r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public WikiCollaboratorInfo(Long r100, I18NNameText r101, I18NNameText r102, String r103, Long r104, ByteString r105) {
        super(ADAPTER, r105);
        this.mmember_id = r100;
        this.mmember_name = r101;
        this.mmember_display_name = r102;
        this.mavatar_url = r103;
        this.mtenant_id = r104;
    }
}
