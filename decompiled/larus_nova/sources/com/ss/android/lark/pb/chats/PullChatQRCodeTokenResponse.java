package com.ss.android.lark.pb.chats;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullChatQRCodeTokenResponse extends Message<PullChatQRCodeTokenResponse, Builder> {
    public static final ProtoAdapter<PullChatQRCodeTokenResponse> ADAPTER = null;
    public static final Long DEFAULT_EXPIRE_TIME = null;
    public static final Boolean DEFAULT_IS_UNLIMITED = null;
    public static final String DEFAULT_SHARED_URL = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    public final Long mexpire_time;
    public final Boolean mis_unlimited;
    public final String mshared_url;
    public final String mtoken;

    public static final class Builder extends Message.Builder<PullChatQRCodeTokenResponse, Builder> {
        public Long mexpire_time;
        public Boolean mis_unlimited;
        public String mshared_url;
        public String mtoken;

        @Override // com.squareup.wire.Message.Builder
        public PullChatQRCodeTokenResponse build() {
            return new PullChatQRCodeTokenResponse(this.mtoken, this.mexpire_time, this.mshared_url, this.mis_unlimited, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder expire_time(Long r100) {
            this.mexpire_time = r100;
            return this;
        }

        public Builder is_unlimited(Boolean r100) {
            this.mis_unlimited = r100;
            return this;
        }

        public Builder shared_url(String r100) {
            this.mshared_url = r100;
            return this;
        }

        public Builder token(String r100) {
            this.mtoken = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullChatQRCodeTokenResponse extends ProtoAdapter<PullChatQRCodeTokenResponse> {
        public ProtoAdapter_PullChatQRCodeTokenResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullChatQRCodeTokenResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullChatQRCodeTokenResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mtoken = "";
            r101.mexpire_time = 0L;
            r101.mshared_url = "";
            r101.mis_unlimited = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mtoken = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mexpire_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mshared_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mis_unlimited = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(PullChatQRCodeTokenResponse r100) {
            String r101 = r100.mtoken;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.mexpire_time;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mshared_url;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.mis_unlimited;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ PullChatQRCodeTokenResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullChatQRCodeTokenResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullChatQRCodeTokenResponse r101) throws IOException {
            String r102 = r101.mtoken;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.mexpire_time;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mshared_url;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.mis_unlimited;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullChatQRCodeTokenResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullChatQRCodeTokenResponse();
        DEFAULT_EXPIRE_TIME = 0L;
        DEFAULT_IS_UNLIMITED = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtoken = this.mtoken;
        r100.mexpire_time = this.mexpire_time;
        r100.mshared_url = this.mshared_url;
        r100.mis_unlimited = this.mis_unlimited;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullChatQRCodeTokenResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullChatQRCodeTokenResponse(String r100, Long r101, String r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PullChatQRCodeTokenResponse(String r100, Long r101, String r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mtoken = r100;
        this.mexpire_time = r101;
        this.mshared_url = r102;
        this.mis_unlimited = r103;
    }
}
