package com.bytedance.lark.pb.tool.v1;

import com.bytedance.lark.pb.basic.v1.LogoutReason;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class MakeUserOfflineV2Request extends Message<MakeUserOfflineV2Request, Builder> {
    public static final ProtoAdapter<MakeUserOfflineV2Request> ADAPTER = null;
    public static final Long DEFAULT_CONTAINER_ID = null;
    public static final LogoutReason DEFAULT_LOGOUT_REASON = null;
    public static final UserLoginState DEFAULT_PRIOR_STATE = null;
    public static final Long DEFAULT_USER_ID = null;
    public static final ProtoAdapter_MakeUserOfflineV2Request RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long container_id;
    public final LogoutReason logout_reason;
    public final UserLoginState prior_state;
    public final Long user_id;

    public static final class Builder extends Message.Builder<MakeUserOfflineV2Request, Builder> implements b<MakeUserOfflineV2Request> {
        public Long container_id;
        public LogoutReason logout_reason;
        public UserLoginState prior_state;
        public Long user_id;

        @Override // com.squareup.wire.Message.Builder
        public MakeUserOfflineV2Request build() {
            Long r100 = this.user_id;
            if (r100 == null) goto L7;
            return new MakeUserOfflineV2Request(this.user_id, this.logout_reason, this.container_id, this.prior_state, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "user_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder container_id(Long r100) {
            this.container_id = r100;
            return this;
        }

        public Builder logout_reason(LogoutReason r100) {
            this.logout_reason = r100;
            return this;
        }

        public Builder prior_state(UserLoginState r100) {
            this.prior_state = r100;
            return this;
        }

        public Builder user_id(Long r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MakeUserOfflineV2Request extends ProtoAdapter<MakeUserOfflineV2Request> implements a<MakeUserOfflineV2Request> {
        public ProtoAdapter_MakeUserOfflineV2Request() {
            super(FieldEncoding.LENGTH_DELIMITED, MakeUserOfflineV2Request.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MakeUserOfflineV2Request decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.user_id = 0L;
            r101.logout_reason = LogoutReason.UnKnownReason;
            r101.container_id = 0L;
            r101.prior_state = UserLoginState.OFFLINE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.user_id = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.logout_reason = LogoutReason.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.container_id = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L12:
            if (r103 != 11) goto L13;
            r101.prior_state = UserLoginState.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MakeUserOfflineV2Request r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.UINT64;
            int r102 = r101.encodedSizeWithTag(1, r100.user_id);
            LogoutReason r103 = r100.logout_reason;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = LogoutReason.ADAPTER.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Long r107 = r100.container_id;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            UserLoginState r110 = r100.prior_state;
            if (r110 == null) goto L14;
            r104 = UserLoginState.ADAPTER.encodedSizeWithTag(11, r110);
        L14:
            return (r109 + r104) + r100.unknownFields().size();
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MakeUserOfflineV2Request decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MakeUserOfflineV2Request r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MakeUserOfflineV2Request r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.UINT64;
            r102.encodeWithTag(r100, 1, r101.user_id);
            LogoutReason r103 = r101.logout_reason;
            if (r103 == null) goto L5;
            LogoutReason.ADAPTER.encodeWithTag(r100, 2, r103);
        L5:
            Long r104 = r101.container_id;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            UserLoginState r105 = r101.prior_state;
            if (r105 == null) goto L11;
            UserLoginState.ADAPTER.encodeWithTag(r100, 11, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MakeUserOfflineV2Request r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MakeUserOfflineV2Request r100 = new ProtoAdapter_MakeUserOfflineV2Request();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_USER_ID = 0L;
        DEFAULT_LOGOUT_REASON = LogoutReason.UnKnownReason;
        DEFAULT_CONTAINER_ID = 0L;
        DEFAULT_PRIOR_STATE = UserLoginState.OFFLINE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_id = this.user_id;
        r100.logout_reason = this.logout_reason;
        r100.container_id = this.container_id;
        r100.prior_state = this.prior_state;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MakeUserOfflineV2Request.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MakeUserOfflineV2Request(Long r100, LogoutReason r101, Long r102, UserLoginState r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public MakeUserOfflineV2Request(Long r100, LogoutReason r101, Long r102, UserLoginState r103, ByteString r104) {
        super(ADAPTER, r104);
        this.user_id = r100;
        this.logout_reason = r101;
        this.container_id = r102;
        this.prior_state = r103;
    }
}
