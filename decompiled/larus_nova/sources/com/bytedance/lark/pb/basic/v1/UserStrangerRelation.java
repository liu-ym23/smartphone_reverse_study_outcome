package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class UserStrangerRelation extends com.squareup.wire.Message<UserStrangerRelation, Builder> {
    public static final ProtoAdapter<UserStrangerRelation> ADAPTER = null;
    public static final Boolean DEFAULT_IS_STRANGER = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final Long DEFAULT_USER_ID = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_stranger;
    public final Long update_time;
    public final Long user_id;

    public static final class Builder extends com.squareup.wire.Message.Builder<UserStrangerRelation, Builder> {
        public Boolean is_stranger;
        public Long update_time;
        public Long user_id;

        @Override // com.squareup.wire.Message.Builder
        public UserStrangerRelation build() {
            return new UserStrangerRelation(this.user_id, this.is_stranger, this.update_time, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder is_stranger(Boolean r100) {
            this.is_stranger = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }

        public Builder user_id(Long r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UserStrangerRelation extends ProtoAdapter<UserStrangerRelation> {
        public ProtoAdapter_UserStrangerRelation() {
            super(FieldEncoding.LENGTH_DELIMITED, UserStrangerRelation.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UserStrangerRelation decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.user_id = 0L;
            r101.is_stranger = Boolean.FALSE;
            r101.update_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.user_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.is_stranger = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.update_time = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(UserStrangerRelation r100) {
            Long r101 = r100.user_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.is_stranger;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.update_time;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ UserStrangerRelation decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UserStrangerRelation r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UserStrangerRelation r101) throws IOException {
            Long r102 = r101.user_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.is_stranger;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.update_time;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserStrangerRelation r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserStrangerRelation();
        DEFAULT_USER_ID = 0L;
        DEFAULT_IS_STRANGER = Boolean.FALSE;
        DEFAULT_UPDATE_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_id = this.user_id;
        r100.is_stranger = this.is_stranger;
        r100.update_time = this.update_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UserStrangerRelation.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public UserStrangerRelation(Long r100, Boolean r101, Long r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public UserStrangerRelation(Long r100, Boolean r101, Long r102, ByteString r103) {
        super(ADAPTER, r103);
        this.user_id = r100;
        this.is_stranger = r101;
        this.update_time = r102;
    }
}
