package com.bytedance.lark.pb.im.v2;

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
public final class GetContactTokenResponse extends Message<GetContactTokenResponse, Builder> {
    public static final ProtoAdapter<GetContactTokenResponse> ADAPTER = null;
    public static final ProtoAdapter_GetContactTokenResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ContactTokenResponse link;
    public final ContactTokenResponse qr_code;

    public static final class Builder extends Message.Builder<GetContactTokenResponse, Builder> implements d<GetContactTokenResponse> {
        public ContactTokenResponse link;
        public ContactTokenResponse qr_code;

        @Override // com.squareup.wire.Message.Builder
        public GetContactTokenResponse build() {
            return new GetContactTokenResponse(this.qr_code, this.link, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder link(ContactTokenResponse r100) {
            this.link = r100;
            return this;
        }

        public Builder qr_code(ContactTokenResponse r100) {
            this.qr_code = r100;
            return this;
        }
    }

    public static final class ContactTokenResponse extends Message<ContactTokenResponse, Builder> {
        public static final ProtoAdapter<ContactTokenResponse> ADAPTER = null;
        public static final Boolean DEFAULT_CAN_SEARCH_WITH_TOKEN = null;
        public static final String DEFAULT_COUNTRY_CODE = "";
        public static final String DEFAULT_INVITE_MSG = "";
        public static final String DEFAULT_INVITE_URL = "";
        public static final String DEFAULT_TOKEN = "";
        public static final String DEFAULT_UNIQUE_ID = "";
        private static final long serialVersionUID = 0;
        public final Boolean can_search_with_token;
        public final String country_code;
        public final String invite_msg;
        public final String invite_url;
        public final String token;
        public final String unique_id;

        public static final class Builder extends Message.Builder<ContactTokenResponse, Builder> {
            public Boolean can_search_with_token;
            public String country_code;
            public String invite_msg;
            public String invite_url;
            public String token;
            public String unique_id;

            @Override // com.squareup.wire.Message.Builder
            public ContactTokenResponse build() {
                return new ContactTokenResponse(this.token, this.invite_url, this.invite_msg, this.country_code, this.can_search_with_token, this.unique_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder can_search_with_token(Boolean r100) {
                this.can_search_with_token = r100;
                return this;
            }

            public Builder country_code(String r100) {
                this.country_code = r100;
                return this;
            }

            public Builder invite_msg(String r100) {
                this.invite_msg = r100;
                return this;
            }

            public Builder invite_url(String r100) {
                this.invite_url = r100;
                return this;
            }

            public Builder token(String r100) {
                this.token = r100;
                return this;
            }

            public Builder unique_id(String r100) {
                this.unique_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ContactTokenResponse extends ProtoAdapter<ContactTokenResponse> {
            public ProtoAdapter_ContactTokenResponse() {
                super(FieldEncoding.LENGTH_DELIMITED, ContactTokenResponse.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ContactTokenResponse decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.token = "";
                r101.invite_url = "";
                r101.invite_msg = "";
                r101.country_code = "";
                r101.can_search_with_token = Boolean.FALSE;
                r101.unique_id = "";
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
                r101.unique_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                r101.can_search_with_token = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                r101.country_code = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.invite_msg = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.invite_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                r101.token = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(ContactTokenResponse r100) {
                String r101 = r100.token;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.invite_url;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.invite_msg;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.country_code;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Boolean r113 = r100.can_search_with_token;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                String r116 = r100.unique_id;
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
            public /* bridge */ /* synthetic */ ContactTokenResponse decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ContactTokenResponse r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ContactTokenResponse r101) throws IOException {
                String r102 = r101.token;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.invite_url;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.invite_msg;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.country_code;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                Boolean r106 = r101.can_search_with_token;
                if (r106 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
            L17:
                String r107 = r101.unique_id;
                if (r107 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
            L20:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ContactTokenResponse r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ContactTokenResponse();
            DEFAULT_CAN_SEARCH_WITH_TOKEN = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.token = this.token;
            r100.invite_url = this.invite_url;
            r100.invite_msg = this.invite_msg;
            r100.country_code = this.country_code;
            r100.can_search_with_token = this.can_search_with_token;
            r100.unique_id = this.unique_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ContactTokenResponse.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ContactTokenResponse(String r100, String r110, String r111, String r112, Boolean r113, String r114) {
            this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
        }

        public ContactTokenResponse(String r100, String r101, String r102, String r103, Boolean r104, String r105, ByteString r106) {
            super(ADAPTER, r106);
            this.token = r100;
            this.invite_url = r101;
            this.invite_msg = r102;
            this.country_code = r103;
            this.can_search_with_token = r104;
            this.unique_id = r105;
        }
    }

    public static final class ProtoAdapter_GetContactTokenResponse extends ProtoAdapter<GetContactTokenResponse> implements c<GetContactTokenResponse> {
        public ProtoAdapter_GetContactTokenResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetContactTokenResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetContactTokenResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.qr_code = ContactTokenResponse.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.link = ContactTokenResponse.ADAPTER.decode(r100);
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
        public int encodedSize2(GetContactTokenResponse r100) {
            ContactTokenResponse r101 = r100.qr_code;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ContactTokenResponse.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            ContactTokenResponse r104 = r100.link;
            if (r104 == null) goto L10;
            r102 = ContactTokenResponse.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetContactTokenResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetContactTokenResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetContactTokenResponse r101) throws IOException {
            ContactTokenResponse r102 = r101.qr_code;
            if (r102 == null) goto L5;
            ContactTokenResponse.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            ContactTokenResponse r103 = r101.link;
            if (r103 == null) goto L8;
            ContactTokenResponse.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetContactTokenResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetContactTokenResponse r100 = new ProtoAdapter_GetContactTokenResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.qr_code = this.qr_code;
        r100.link = this.link;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetContactTokenResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetContactTokenResponse(ContactTokenResponse r100, ContactTokenResponse r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetContactTokenResponse(ContactTokenResponse r100, ContactTokenResponse r101, ByteString r102) {
        super(ADAPTER, r102);
        this.qr_code = r100;
        this.link = r101;
    }
}
