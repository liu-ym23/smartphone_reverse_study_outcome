package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GrabHongbaoResponse extends Message<GrabHongbaoResponse, Builder> {
    public static final ProtoAdapter<GrabHongbaoResponse> ADAPTER = null;
    public static final Long DEFAULT_AMOUNT = null;
    public static final String DEFAULT_AUTH_URL = "";
    public static final Boolean DEFAULT_IS_REAL_NAME_AUTHED = null;
    public static final ProtoAdapter_GrabHongbaoResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long amount;
    public final String auth_url;
    public final ClientDisplayActionInfo client_display_action_info;
    public final Boolean is_real_name_authed;

    public static final class Builder extends Message.Builder<GrabHongbaoResponse, Builder> implements d<GrabHongbaoResponse> {
        public Long amount;
        public String auth_url;
        public ClientDisplayActionInfo client_display_action_info;
        public Boolean is_real_name_authed;

        @Override // com.squareup.wire.Message.Builder
        public GrabHongbaoResponse build() {
            return new GrabHongbaoResponse(this.amount, this.is_real_name_authed, this.auth_url, this.client_display_action_info, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder amount(Long r100) {
            this.amount = r100;
            return this;
        }

        public Builder auth_url(String r100) {
            this.auth_url = r100;
            return this;
        }

        public Builder client_display_action_info(ClientDisplayActionInfo r100) {
            this.client_display_action_info = r100;
            return this;
        }

        public Builder is_real_name_authed(Boolean r100) {
            this.is_real_name_authed = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GrabHongbaoResponse extends ProtoAdapter<GrabHongbaoResponse> implements c<GrabHongbaoResponse> {
        public ProtoAdapter_GrabHongbaoResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GrabHongbaoResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GrabHongbaoResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.amount = 0L;
            r101.is_real_name_authed = Boolean.TRUE;
            r101.auth_url = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.amount = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.is_real_name_authed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.auth_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 10) goto L13;
            r101.client_display_action_info = ClientDisplayActionInfo.ADAPTER.decode(r100);
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
        public int encodedSize2(GrabHongbaoResponse r100) {
            Long r101 = r100.amount;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.is_real_name_authed;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.auth_url;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ClientDisplayActionInfo r110 = r100.client_display_action_info;
            if (r110 == null) goto L18;
            r102 = ClientDisplayActionInfo.ADAPTER.encodedSizeWithTag(10, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ GrabHongbaoResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GrabHongbaoResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GrabHongbaoResponse r101) throws IOException {
            Long r102 = r101.amount;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.is_real_name_authed;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.auth_url;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            ClientDisplayActionInfo r105 = r101.client_display_action_info;
            if (r105 == null) goto L14;
            ClientDisplayActionInfo.ADAPTER.encodeWithTag(r100, 10, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GrabHongbaoResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GrabHongbaoResponse r100 = new ProtoAdapter_GrabHongbaoResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_AMOUNT = 0L;
        DEFAULT_IS_REAL_NAME_AUTHED = Boolean.TRUE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.amount = this.amount;
        r100.is_real_name_authed = this.is_real_name_authed;
        r100.auth_url = this.auth_url;
        r100.client_display_action_info = this.client_display_action_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GrabHongbaoResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GrabHongbaoResponse(Long r100, Boolean r101, String r102, ClientDisplayActionInfo r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GrabHongbaoResponse(Long r100, Boolean r101, String r102, ClientDisplayActionInfo r103, ByteString r104) {
        super(ADAPTER, r104);
        this.amount = r100;
        this.is_real_name_authed = r101;
        this.auth_url = r102;
        this.client_display_action_info = r103;
    }
}
