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
public final class GetChatLinkTokenRequest extends Message<GetChatLinkTokenRequest, Builder> {
    public static final ProtoAdapter<GetChatLinkTokenRequest> ADAPTER = null;
    public static final String DEFAULT_APP_NAME = "";
    public static final String DEFAULT_CHAT_ID = "";
    public static final Integer DEFAULT_EXPIRED_DAY = null;
    public static final ProtoAdapter_GetChatLinkTokenRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String app_name;
    public final String chat_id;
    public final Integer expired_day;

    public static final class Builder extends Message.Builder<GetChatLinkTokenRequest, Builder> implements d<GetChatLinkTokenRequest> {
        public String app_name;
        public String chat_id;
        public Integer expired_day;

        @Override // com.squareup.wire.Message.Builder
        public GetChatLinkTokenRequest build() {
            String r100 = this.chat_id;
            if (r100 == null) goto L7;
            return new GetChatLinkTokenRequest(this.chat_id, this.expired_day, this.app_name, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "chat_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_name(String r100) {
            this.app_name = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder expired_day(Integer r100) {
            this.expired_day = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetChatLinkTokenRequest extends ProtoAdapter<GetChatLinkTokenRequest> implements c<GetChatLinkTokenRequest> {
        public ProtoAdapter_GetChatLinkTokenRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChatLinkTokenRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChatLinkTokenRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            r101.expired_day = 7;
            r101.app_name = "";
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
            r101.app_name = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(GetChatLinkTokenRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.chat_id);
            Integer r103 = r100.expired_day;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.app_name;
            if (r107 == null) goto L10;
            r104 = r101.encodedSizeWithTag(3, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetChatLinkTokenRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChatLinkTokenRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChatLinkTokenRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.chat_id);
            Integer r103 = r101.expired_day;
            if (r103 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.app_name;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChatLinkTokenRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetChatLinkTokenRequest r100 = new ProtoAdapter_GetChatLinkTokenRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_EXPIRED_DAY = 7;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.expired_day = this.expired_day;
        r100.app_name = this.app_name;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChatLinkTokenRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChatLinkTokenRequest(String r100, Integer r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetChatLinkTokenRequest(String r100, Integer r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.chat_id = r100;
        this.expired_day = r101;
        this.app_name = r102;
    }
}
