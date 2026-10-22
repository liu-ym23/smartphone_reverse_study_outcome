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
public final class GetChatLimitInfoResponse extends Message<GetChatLimitInfoResponse, Builder> {
    public static final ProtoAdapter<GetChatLimitInfoResponse> ADAPTER = null;
    public static final Boolean DEFAULT_IS_LARGE_GROUP = null;
    public static final Boolean DEFAULT_IS_SUPER_GROUP = null;
    public static final Boolean DEFAULT_IS_URGENT_ALL_SUPPORT = null;
    public static final Boolean DEFAULT_IS_USER_COUNT_VISIBLE = null;
    public static final Boolean DEFAULT_OPEN_SECURITY = null;
    public static final Integer DEFAULT_SHOW_MEMBER_LIMIT = null;
    public static final ProtoAdapter_GetChatLimitInfoResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_large_group;
    public final Boolean is_super_group;
    public final Boolean is_urgent_all_support;
    public final Boolean is_user_count_visible;
    public final Boolean open_security;
    public final Integer show_member_limit;

    public static final class Builder extends Message.Builder<GetChatLimitInfoResponse, Builder> implements d<GetChatLimitInfoResponse> {
        public Boolean is_large_group;
        public Boolean is_super_group;
        public Boolean is_urgent_all_support;
        public Boolean is_user_count_visible;
        public Boolean open_security;
        public Integer show_member_limit;

        @Override // com.squareup.wire.Message.Builder
        public GetChatLimitInfoResponse build() {
            Boolean r100 = this.is_large_group;
            if (r100 == null) goto L9;
            if (this.open_security == null) goto L9;
            return new GetChatLimitInfoResponse(this.is_large_group, this.open_security, this.is_super_group, this.is_urgent_all_support, this.show_member_limit, this.is_user_count_visible, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "is_large_group", this.open_security, "open_security"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_large_group(Boolean r100) {
            this.is_large_group = r100;
            return this;
        }

        public Builder is_super_group(Boolean r100) {
            this.is_super_group = r100;
            return this;
        }

        public Builder is_urgent_all_support(Boolean r100) {
            this.is_urgent_all_support = r100;
            return this;
        }

        public Builder is_user_count_visible(Boolean r100) {
            this.is_user_count_visible = r100;
            return this;
        }

        public Builder open_security(Boolean r100) {
            this.open_security = r100;
            return this;
        }

        public Builder show_member_limit(Integer r100) {
            this.show_member_limit = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetChatLimitInfoResponse extends ProtoAdapter<GetChatLimitInfoResponse> implements c<GetChatLimitInfoResponse> {
        public ProtoAdapter_GetChatLimitInfoResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChatLimitInfoResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChatLimitInfoResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.is_large_group = r102;
            r101.open_security = r102;
            r101.is_super_group = r102;
            r101.is_urgent_all_support = r102;
            r101.show_member_limit = 0;
            r101.is_user_count_visible = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L13;
            switch(r104) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.is_user_count_visible = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.show_member_limit = ProtoAdapter.INT32.decode(r100);
            goto L3
        L9:
            r101.is_urgent_all_support = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.is_super_group = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.open_security = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.is_large_group = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetChatLimitInfoResponse r100) {
            ProtoAdapter<Boolean> r101 = ProtoAdapter.BOOL;
            int r102 = r101.encodedSizeWithTag(1, r100.is_large_group) + r101.encodedSizeWithTag(2, r100.open_security);
            Boolean r103 = r100.is_super_group;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            Boolean r107 = r100.is_urgent_all_support;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(4, r107);
        L10:
            int r109 = r106 + r108;
            Integer r110 = r100.show_member_limit;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.INT32.encodedSizeWithTag(5, r110);
        L14:
            int r112 = r109 + r111;
            Boolean r113 = r100.is_user_count_visible;
            if (r113 == null) goto L18;
            r104 = r101.encodedSizeWithTag(6, r113);
        L18:
            return (r112 + r104) + r100.unknownFields().size();
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetChatLimitInfoResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChatLimitInfoResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChatLimitInfoResponse r101) throws IOException {
            ProtoAdapter<Boolean> r102 = ProtoAdapter.BOOL;
            r102.encodeWithTag(r100, 1, r101.is_large_group);
            r102.encodeWithTag(r100, 2, r101.open_security);
            Boolean r103 = r101.is_super_group;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            Boolean r104 = r101.is_urgent_all_support;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 4, r104);
        L8:
            Integer r105 = r101.show_member_limit;
            if (r105 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r105);
        L11:
            Boolean r106 = r101.is_user_count_visible;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 6, r106);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChatLimitInfoResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetChatLimitInfoResponse r100 = new ProtoAdapter_GetChatLimitInfoResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_IS_LARGE_GROUP = r101;
        DEFAULT_OPEN_SECURITY = r101;
        DEFAULT_IS_SUPER_GROUP = r101;
        DEFAULT_IS_URGENT_ALL_SUPPORT = r101;
        DEFAULT_SHOW_MEMBER_LIMIT = 0;
        DEFAULT_IS_USER_COUNT_VISIBLE = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.is_large_group = this.is_large_group;
        r100.open_security = this.open_security;
        r100.is_super_group = this.is_super_group;
        r100.is_urgent_all_support = this.is_urgent_all_support;
        r100.show_member_limit = this.show_member_limit;
        r100.is_user_count_visible = this.is_user_count_visible;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChatLimitInfoResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChatLimitInfoResponse(Boolean r100, Boolean r110, Boolean r111, Boolean r112, Integer r113, Boolean r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public GetChatLimitInfoResponse(Boolean r100, Boolean r101, Boolean r102, Boolean r103, Integer r104, Boolean r105, ByteString r106) {
        super(ADAPTER, r106);
        this.is_large_group = r100;
        this.open_security = r101;
        this.is_super_group = r102;
        this.is_urgent_all_support = r103;
        this.show_member_limit = r104;
        this.is_user_count_visible = r105;
    }
}
