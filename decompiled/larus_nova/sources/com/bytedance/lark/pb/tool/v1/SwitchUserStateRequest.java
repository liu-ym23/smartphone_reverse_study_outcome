package com.bytedance.lark.pb.tool.v1;

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
public final class SwitchUserStateRequest extends Message<SwitchUserStateRequest, Builder> {
    public static final ProtoAdapter<SwitchUserStateRequest> ADAPTER = null;
    public static final Long DEFAULT_CLIENT_SESSION_ID = null;
    public static final UserLoginState DEFAULT_DESTINATION_STATE = null;
    public static final Long DEFAULT_PREVIOUS_CONTAINER_ID = null;
    public static final Long DEFAULT_USER_ID = null;
    public static final ProtoAdapter_SwitchUserStateRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long client_session_id;
    public final UserLoginState destination_state;
    public final Long previous_container_id;
    public final Long user_id;

    public static final class Builder extends Message.Builder<SwitchUserStateRequest, Builder> implements b<SwitchUserStateRequest> {
        public Long client_session_id;
        public UserLoginState destination_state;
        public Long previous_container_id;
        public Long user_id;

        @Override // com.squareup.wire.Message.Builder
        public SwitchUserStateRequest build() {
            Long r100 = this.user_id;
            if (r100 == null) goto L11;
            if (this.destination_state == null) goto L11;
            if (this.previous_container_id == null) goto L11;
            return new SwitchUserStateRequest(this.user_id, this.destination_state, this.previous_container_id, this.client_session_id, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "user_id", this.destination_state, "destination_state", this.previous_container_id, "previous_container_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder client_session_id(Long r100) {
            this.client_session_id = r100;
            return this;
        }

        public Builder destination_state(UserLoginState r100) {
            this.destination_state = r100;
            return this;
        }

        public Builder previous_container_id(Long r100) {
            this.previous_container_id = r100;
            return this;
        }

        public Builder user_id(Long r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SwitchUserStateRequest extends ProtoAdapter<SwitchUserStateRequest> implements a<SwitchUserStateRequest> {
        public ProtoAdapter_SwitchUserStateRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SwitchUserStateRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SwitchUserStateRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.user_id = 0L;
            r101.destination_state = UserLoginState.OFFLINE;
            r101.previous_container_id = 0L;
            r101.client_session_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.user_id = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.destination_state = UserLoginState.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.previous_container_id = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.client_session_id = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SwitchUserStateRequest r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.UINT64;
            int r102 = (r101.encodedSizeWithTag(1, r100.user_id) + UserLoginState.ADAPTER.encodedSizeWithTag(2, r100.destination_state)) + r101.encodedSizeWithTag(3, r100.previous_container_id);
            Long r103 = r100.client_session_id;
            if (r103 == null) goto L5;
            int r104 = r101.encodedSizeWithTag(4, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SwitchUserStateRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SwitchUserStateRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SwitchUserStateRequest r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.UINT64;
            r102.encodeWithTag(r100, 1, r101.user_id);
            UserLoginState.ADAPTER.encodeWithTag(r100, 2, r101.destination_state);
            r102.encodeWithTag(r100, 3, r101.previous_container_id);
            Long r103 = r101.client_session_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 4, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SwitchUserStateRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SwitchUserStateRequest r100 = new ProtoAdapter_SwitchUserStateRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_USER_ID = 0L;
        DEFAULT_DESTINATION_STATE = UserLoginState.OFFLINE;
        DEFAULT_PREVIOUS_CONTAINER_ID = 0L;
        DEFAULT_CLIENT_SESSION_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_id = this.user_id;
        r100.destination_state = this.destination_state;
        r100.previous_container_id = this.previous_container_id;
        r100.client_session_id = this.client_session_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SwitchUserStateRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SwitchUserStateRequest(Long r100, UserLoginState r101, Long r102, Long r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public SwitchUserStateRequest(Long r100, UserLoginState r101, Long r102, Long r103, ByteString r104) {
        super(ADAPTER, r104);
        this.user_id = r100;
        this.destination_state = r101;
        this.previous_container_id = r102;
        this.client_session_id = r103;
    }
}
