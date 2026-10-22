package com.ss.android.lark.pb.chats;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullChangeGroupMemberAuthorizationResponse extends Message<PullChangeGroupMemberAuthorizationResponse, Builder> {
    public static final ProtoAdapter<PullChangeGroupMemberAuthorizationResponse> ADAPTER = null;
    public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
    public static final String DEFAULT_MSG_DESCRIPTION = "";
    public static final Boolean DEFAULT_NEED_APPLY_FOR_INCR = null;
    public static final Boolean DEFAULT_PASS = null;
    private static final long serialVersionUID = 0;
    public final Boolean mis_cross_tenant;
    public final String mmsg_description;
    public final Boolean mneed_apply_for_incr;
    public final Boolean mpass;

    public static final class Builder extends Message.Builder<PullChangeGroupMemberAuthorizationResponse, Builder> {
        public Boolean mis_cross_tenant;
        public String mmsg_description;
        public Boolean mneed_apply_for_incr;
        public Boolean mpass;

        @Override // com.squareup.wire.Message.Builder
        public PullChangeGroupMemberAuthorizationResponse build() {
            return new PullChangeGroupMemberAuthorizationResponse(this.mpass, this.mmsg_description, this.mneed_apply_for_incr, this.mis_cross_tenant, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_cross_tenant(Boolean r100) {
            this.mis_cross_tenant = r100;
            return this;
        }

        public Builder msg_description(String r100) {
            this.mmsg_description = r100;
            return this;
        }

        public Builder need_apply_for_incr(Boolean r100) {
            this.mneed_apply_for_incr = r100;
            return this;
        }

        public Builder pass(Boolean r100) {
            this.mpass = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullChangeGroupMemberAuthorizationResponse extends ProtoAdapter<PullChangeGroupMemberAuthorizationResponse> {
        public ProtoAdapter_PullChangeGroupMemberAuthorizationResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullChangeGroupMemberAuthorizationResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullChangeGroupMemberAuthorizationResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.mpass = r102;
            r101.mmsg_description = "";
            r101.mneed_apply_for_incr = r102;
            r101.mis_cross_tenant = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L18;
            if (r104 != 1) goto L8;
            r101.mpass = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.mmsg_description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.mneed_apply_for_incr = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L13;
            r101.mis_cross_tenant = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PullChangeGroupMemberAuthorizationResponse r100) {
            Boolean r101 = r100.mpass;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mmsg_description;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.mneed_apply_for_incr;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.mis_cross_tenant;
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
        public /* bridge */ /* synthetic */ PullChangeGroupMemberAuthorizationResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullChangeGroupMemberAuthorizationResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullChangeGroupMemberAuthorizationResponse r101) throws IOException {
            Boolean r102 = r101.mpass;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mmsg_description;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.mneed_apply_for_incr;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.mis_cross_tenant;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullChangeGroupMemberAuthorizationResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullChangeGroupMemberAuthorizationResponse();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_PASS = r100;
        DEFAULT_NEED_APPLY_FOR_INCR = r100;
        DEFAULT_IS_CROSS_TENANT = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mpass = this.mpass;
        r100.mmsg_description = this.mmsg_description;
        r100.mneed_apply_for_incr = this.mneed_apply_for_incr;
        r100.mis_cross_tenant = this.mis_cross_tenant;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullChangeGroupMemberAuthorizationResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullChangeGroupMemberAuthorizationResponse(Boolean r100, String r101, Boolean r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PullChangeGroupMemberAuthorizationResponse(Boolean r100, String r101, Boolean r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mpass = r100;
        this.mmsg_description = r101;
        this.mneed_apply_for_incr = r102;
        this.mis_cross_tenant = r103;
    }
}
