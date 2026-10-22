package com.bytedance.lark.pb.contact.v1;

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
public final class SendUserInvitationResponse extends Message<SendUserInvitationResponse, Builder> {
    public static final ProtoAdapter<SendUserInvitationResponse> ADAPTER = null;
    public static final Boolean DEFAULT_SUCCESS = null;
    public static final ProtoAdapter_SendUserInvitationResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final GetUserProfileResponse profile;
    public final Boolean success;
    public final UserBriefInfo user;

    public static final class Builder extends Message.Builder<SendUserInvitationResponse, Builder> implements d<SendUserInvitationResponse> {
        public GetUserProfileResponse profile;
        public Boolean success;
        public UserBriefInfo user;

        @Override // com.squareup.wire.Message.Builder
        public SendUserInvitationResponse build() {
            return new SendUserInvitationResponse(this.success, this.user, this.profile, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder profile(GetUserProfileResponse r100) {
            this.profile = r100;
            return this;
        }

        public Builder success(Boolean r100) {
            this.success = r100;
            return this;
        }

        public Builder user(UserBriefInfo r100) {
            this.user = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SendUserInvitationResponse extends ProtoAdapter<SendUserInvitationResponse> implements c<SendUserInvitationResponse> {
        public ProtoAdapter_SendUserInvitationResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SendUserInvitationResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SendUserInvitationResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.success = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.success = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.user = UserBriefInfo.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.profile = GetUserProfileResponse.ADAPTER.decode(r100);
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
        public int encodedSize2(SendUserInvitationResponse r100) {
            Boolean r101 = r100.success;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            UserBriefInfo r104 = r100.user;
            if (r104 == null) goto L9;
            int r105 = UserBriefInfo.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            GetUserProfileResponse r107 = r100.profile;
            if (r107 == null) goto L14;
            r102 = GetUserProfileResponse.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ SendUserInvitationResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SendUserInvitationResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SendUserInvitationResponse r101) throws IOException {
            Boolean r102 = r101.success;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            UserBriefInfo r103 = r101.user;
            if (r103 == null) goto L8;
            UserBriefInfo.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            GetUserProfileResponse r104 = r101.profile;
            if (r104 == null) goto L11;
            GetUserProfileResponse.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SendUserInvitationResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SendUserInvitationResponse r100 = new ProtoAdapter_SendUserInvitationResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SUCCESS = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.success = this.success;
        r100.user = this.user;
        r100.profile = this.profile;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SendUserInvitationResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SendUserInvitationResponse(Boolean r100, UserBriefInfo r101, GetUserProfileResponse r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public SendUserInvitationResponse(Boolean r100, UserBriefInfo r101, GetUserProfileResponse r102, ByteString r103) {
        super(ADAPTER, r103);
        this.success = r100;
        this.user = r101;
        this.profile = r102;
    }
}
