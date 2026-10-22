package com.bytedance.lark.pb.contact.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class UserRelation extends Message<UserRelation, Builder> {
    public static final ProtoAdapter<UserRelation> ADAPTER = null;
    public static final Boolean DEFAULT_IS_FRIEND = null;
    public static final Boolean DEFAULT_REQUEST_USER_APPLY = null;
    public static final Long DEFAULT_REQUEST_USER_APPLY_ID = null;
    public static final String DEFAULT_REQUEST_USER_APPLY_REASON = "";
    public static final Boolean DEFAULT_TARGET_USER_APPLY = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_friend;
    public final Boolean request_user_apply;
    public final Long request_user_apply_id;
    public final String request_user_apply_reason;
    public final Boolean target_user_apply;

    public static final class Builder extends Message.Builder<UserRelation, Builder> {
        public Boolean is_friend;
        public Boolean request_user_apply;
        public Long request_user_apply_id;
        public String request_user_apply_reason;
        public Boolean target_user_apply;

        @Override // com.squareup.wire.Message.Builder
        public UserRelation build() {
            return new UserRelation(this.is_friend, this.request_user_apply, this.request_user_apply_id, this.request_user_apply_reason, this.target_user_apply, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_friend(Boolean r100) {
            this.is_friend = r100;
            return this;
        }

        public Builder request_user_apply(Boolean r100) {
            this.request_user_apply = r100;
            return this;
        }

        public Builder request_user_apply_id(Long r100) {
            this.request_user_apply_id = r100;
            return this;
        }

        public Builder request_user_apply_reason(String r100) {
            this.request_user_apply_reason = r100;
            return this;
        }

        public Builder target_user_apply(Boolean r100) {
            this.target_user_apply = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UserRelation extends ProtoAdapter<UserRelation> {
        public ProtoAdapter_UserRelation() {
            super(FieldEncoding.LENGTH_DELIMITED, UserRelation.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UserRelation decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.is_friend = r102;
            r101.request_user_apply = r102;
            r101.request_user_apply_id = 0L;
            r101.request_user_apply_reason = "";
            r101.target_user_apply = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L21;
            if (r104 != 1) goto L8;
            r101.is_friend = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.request_user_apply = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.request_user_apply_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L14;
            r101.request_user_apply_reason = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r104 != 5) goto L15;
            r101.target_user_apply = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UserRelation r100) {
            Boolean r101 = r100.is_friend;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.request_user_apply;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.request_user_apply_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.request_user_apply_reason;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.target_user_apply;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ UserRelation decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UserRelation r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UserRelation r101) throws IOException {
            Boolean r102 = r101.is_friend;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.request_user_apply;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.request_user_apply_id;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.request_user_apply_reason;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.target_user_apply;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserRelation r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserRelation();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_FRIEND = r100;
        DEFAULT_REQUEST_USER_APPLY = r100;
        DEFAULT_REQUEST_USER_APPLY_ID = 0L;
        DEFAULT_TARGET_USER_APPLY = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.is_friend = this.is_friend;
        r100.request_user_apply = this.request_user_apply;
        r100.request_user_apply_id = this.request_user_apply_id;
        r100.request_user_apply_reason = this.request_user_apply_reason;
        r100.target_user_apply = this.target_user_apply;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UserRelation.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UserRelation(Boolean r100, Boolean r101, Long r110, String r111, Boolean r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public UserRelation(Boolean r100, Boolean r101, Long r102, String r103, Boolean r104, ByteString r105) {
        super(ADAPTER, r105);
        this.is_friend = r100;
        this.request_user_apply = r101;
        this.request_user_apply_id = r102;
        this.request_user_apply_reason = r103;
        this.target_user_apply = r104;
    }
}
