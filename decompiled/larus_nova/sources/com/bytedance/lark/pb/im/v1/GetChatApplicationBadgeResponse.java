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
public final class GetChatApplicationBadgeResponse extends Message<GetChatApplicationBadgeResponse, Builder> {
    public static final ProtoAdapter<GetChatApplicationBadgeResponse> ADAPTER = null;
    public static final Integer DEFAULT_CHAT_BADGE = null;
    public static final Integer DEFAULT_FRIEND_BADGE = null;
    public static final String DEFAULT_LATEST_APPLY_USERNAME = "";
    public static final ProtoAdapter_GetChatApplicationBadgeResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Integer chat_badge;
    public final Integer friend_badge;
    public final String latest_apply_username;

    public static final class Builder extends Message.Builder<GetChatApplicationBadgeResponse, Builder> implements d<GetChatApplicationBadgeResponse> {
        public Integer chat_badge;
        public Integer friend_badge;
        public String latest_apply_username;

        @Override // com.squareup.wire.Message.Builder
        public GetChatApplicationBadgeResponse build() {
            return new GetChatApplicationBadgeResponse(this.chat_badge, this.friend_badge, this.latest_apply_username, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_badge(Integer r100) {
            this.chat_badge = r100;
            return this;
        }

        public Builder friend_badge(Integer r100) {
            this.friend_badge = r100;
            return this;
        }

        public Builder latest_apply_username(String r100) {
            this.latest_apply_username = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetChatApplicationBadgeResponse extends ProtoAdapter<GetChatApplicationBadgeResponse> implements c<GetChatApplicationBadgeResponse> {
        public ProtoAdapter_GetChatApplicationBadgeResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChatApplicationBadgeResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChatApplicationBadgeResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_badge = 0;
            r101.friend_badge = 0;
            r101.latest_apply_username = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.chat_badge = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.friend_badge = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.latest_apply_username = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(GetChatApplicationBadgeResponse r100) {
            Integer r101 = r100.chat_badge;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.friend_badge;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.latest_apply_username;
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
        public /* bridge */ /* synthetic */ GetChatApplicationBadgeResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChatApplicationBadgeResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChatApplicationBadgeResponse r101) throws IOException {
            Integer r102 = r101.chat_badge;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.friend_badge;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.latest_apply_username;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChatApplicationBadgeResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetChatApplicationBadgeResponse r100 = new ProtoAdapter_GetChatApplicationBadgeResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_CHAT_BADGE = 0;
        DEFAULT_FRIEND_BADGE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_badge = this.chat_badge;
        r100.friend_badge = this.friend_badge;
        r100.latest_apply_username = this.latest_apply_username;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChatApplicationBadgeResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChatApplicationBadgeResponse(Integer r100, Integer r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetChatApplicationBadgeResponse(Integer r100, Integer r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.chat_badge = r100;
        this.friend_badge = r101;
        this.latest_apply_username = r102;
    }
}
