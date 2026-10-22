package com.ss.android.lark.pb.videochat;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class GetAdminSettingsRequest extends Message<GetAdminSettingsRequest, Builder> {
    public static final ProtoAdapter<GetAdminSettingsRequest> ADAPTER = null;
    public static final String DEFAULT_MEETING_ID = "";
    public static final Long DEFAULT_TENANT_ID = null;
    public static final String DEFAULT_TENANT_ID_STR = "";
    public static final String DEFAULT_UNIQUE_ID = "";
    public static final Long DEFAULT_USER_ID = null;
    public static final String DEFAULT_USER_ID_STR = "";
    public static final FieldOptions FIELD_OPTIONS_MTENANT_ID = null;
    private static final long serialVersionUID = 0;
    public final String mmeeting_id;
    public final Long mtenant_id;
    public final String mtenant_id_str;
    public final String munique_id;
    public final Long muser_id;
    public final String muser_id_str;

    public static final class Builder extends Message.Builder<GetAdminSettingsRequest, Builder> {
        public String mmeeting_id;
        public Long mtenant_id;
        public String mtenant_id_str;
        public String munique_id;
        public Long muser_id;
        public String muser_id_str;

        @Override // com.squareup.wire.Message.Builder
        public GetAdminSettingsRequest build() {
            return new GetAdminSettingsRequest(this.mtenant_id, this.mtenant_id_str, this.muser_id, this.muser_id_str, this.mmeeting_id, this.munique_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder meeting_id(String r100) {
            this.mmeeting_id = r100;
            return this;
        }

        public Builder tenant_id(Long r100) {
            this.mtenant_id = r100;
            return this;
        }

        public Builder tenant_id_str(String r100) {
            this.mtenant_id_str = r100;
            return this;
        }

        public Builder unique_id(String r100) {
            this.munique_id = r100;
            return this;
        }

        public Builder user_id(Long r100) {
            this.muser_id = r100;
            return this;
        }

        public Builder user_id_str(String r100) {
            this.muser_id_str = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetAdminSettingsRequest extends ProtoAdapter<GetAdminSettingsRequest> {
        public ProtoAdapter_GetAdminSettingsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetAdminSettingsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetAdminSettingsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mtenant_id = 0L;
            r101.mtenant_id_str = "";
            r101.muser_id = 0L;
            r101.muser_id_str = "";
            r101.mmeeting_id = "";
            r101.munique_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L13;
            switch(r103) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.munique_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.mmeeting_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.muser_id_str = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.muser_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            r101.mtenant_id_str = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.mtenant_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetAdminSettingsRequest r100) {
            Long r101 = r100.mtenant_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mtenant_id_str;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.muser_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.muser_id_str;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.mmeeting_id;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.munique_id;
            if (r116 == null) goto L26;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
        L21:
            r114 = 0;
            goto L22
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
        public /* bridge */ /* synthetic */ GetAdminSettingsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetAdminSettingsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetAdminSettingsRequest r101) throws IOException {
            Long r102 = r101.mtenant_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mtenant_id_str;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.muser_id;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.muser_id_str;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.mmeeting_id;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.munique_id;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetAdminSettingsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetAdminSettingsRequest();
        FIELD_OPTIONS_MTENANT_ID = new FieldOptions.Builder().FieldInfo("split,type=tenant").build();
        DEFAULT_TENANT_ID = 0L;
        DEFAULT_USER_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtenant_id = this.mtenant_id;
        r100.mtenant_id_str = this.mtenant_id_str;
        r100.muser_id = this.muser_id;
        r100.muser_id_str = this.muser_id_str;
        r100.mmeeting_id = this.mmeeting_id;
        r100.munique_id = this.munique_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetAdminSettingsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetAdminSettingsRequest(Long r100, String r110, Long r111, String r112, String r113, String r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public GetAdminSettingsRequest(Long r100, String r101, Long r102, String r103, String r104, String r105, ByteString r106) {
        super(ADAPTER, r106);
        this.mtenant_id = r100;
        this.mtenant_id_str = r101;
        this.muser_id = r102;
        this.muser_id_str = r103;
        this.mmeeting_id = r104;
        this.munique_id = r105;
    }
}
