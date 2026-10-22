package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetChatQRCodeTokenRequest extends Message<GetChatQRCodeTokenRequest, Builder> {
    public static final ProtoAdapter<GetChatQRCodeTokenRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Integer DEFAULT_EXPIRED_DAY = null;
    public static final Boolean DEFAULT_IS_UNLIMITED = null;
    public static final ProtoAdapter_GetChatQRCodeTokenRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final Integer expired_day;
    public final Boolean is_unlimited;

    public static final class Builder extends Message.Builder<GetChatQRCodeTokenRequest, Builder> implements d<GetChatQRCodeTokenRequest> {
        public String chat_id;
        public Integer expired_day;
        public Boolean is_unlimited;

        @Override // com.squareup.wire.Message.Builder
        public GetChatQRCodeTokenRequest build() {
            String r100 = this.chat_id;
            if (r100 == null) goto L7;
            return new GetChatQRCodeTokenRequest(this.chat_id, this.expired_day, this.is_unlimited, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "chat_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder expired_day(Integer r100) {
            this.expired_day = r100;
            return this;
        }

        public Builder is_unlimited(Boolean r100) {
            this.is_unlimited = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetChatQRCodeTokenRequest extends ProtoAdapter<GetChatQRCodeTokenRequest> implements c<GetChatQRCodeTokenRequest> {
        public ProtoAdapter_GetChatQRCodeTokenRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChatQRCodeTokenRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChatQRCodeTokenRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            r101.expired_day = 7;
            r101.is_unlimited = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.expired_day = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.is_unlimited = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(GetChatQRCodeTokenRequest r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.chat_id);
            Integer r102 = r100.expired_day;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.INT32.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.is_unlimited;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetChatQRCodeTokenRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChatQRCodeTokenRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChatQRCodeTokenRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.chat_id);
            Integer r102 = r101.expired_day;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r102);
        L5:
            Boolean r103 = r101.is_unlimited;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChatQRCodeTokenRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetChatQRCodeTokenRequest r100 = new ProtoAdapter_GetChatQRCodeTokenRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_EXPIRED_DAY = 7;
        DEFAULT_IS_UNLIMITED = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.expired_day = this.expired_day;
        r100.is_unlimited = this.is_unlimited;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChatQRCodeTokenRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChatQRCodeTokenRequest(String r100, Integer r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetChatQRCodeTokenRequest(String r100, Integer r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.chat_id = r100;
        this.expired_day = r101;
        this.is_unlimited = r102;
    }
}
