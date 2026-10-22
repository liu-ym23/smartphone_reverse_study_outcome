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
public final class SwitchUserStateResponse extends Message<SwitchUserStateResponse, Builder> {
    public static final ProtoAdapter<SwitchUserStateResponse> ADAPTER = null;
    public static final Long DEFAULT_DESTINATION_CONTAINER_ID = null;
    public static final Long DEFAULT_USER_CONTAINER_ID = null;
    public static final ProtoAdapter_SwitchUserStateResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long destination_container_id;
    public final Long user_container_id;

    public static final class Builder extends Message.Builder<SwitchUserStateResponse, Builder> implements b<SwitchUserStateResponse> {
        public Long destination_container_id;
        public Long user_container_id;

        @Override // com.squareup.wire.Message.Builder
        public SwitchUserStateResponse build() {
            Long r100 = this.destination_container_id;
            if (r100 == null) goto L9;
            if (this.user_container_id == null) goto L9;
            return new SwitchUserStateResponse(this.destination_container_id, this.user_container_id, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "destination_container_id", this.user_container_id, "user_container_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder destination_container_id(Long r100) {
            this.destination_container_id = r100;
            return this;
        }

        public Builder user_container_id(Long r100) {
            this.user_container_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SwitchUserStateResponse extends ProtoAdapter<SwitchUserStateResponse> implements a<SwitchUserStateResponse> {
        public ProtoAdapter_SwitchUserStateResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SwitchUserStateResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SwitchUserStateResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.destination_container_id = 0L;
            r101.user_container_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.destination_container_id = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.user_container_id = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SwitchUserStateResponse r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.UINT64;
            return (r101.encodedSizeWithTag(1, r100.destination_container_id) + r101.encodedSizeWithTag(2, r100.user_container_id)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SwitchUserStateResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SwitchUserStateResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SwitchUserStateResponse r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.UINT64;
            r102.encodeWithTag(r100, 1, r101.destination_container_id);
            r102.encodeWithTag(r100, 2, r101.user_container_id);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SwitchUserStateResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SwitchUserStateResponse r100 = new ProtoAdapter_SwitchUserStateResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_DESTINATION_CONTAINER_ID = 0L;
        DEFAULT_USER_CONTAINER_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.destination_container_id = this.destination_container_id;
        r100.user_container_id = this.user_container_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SwitchUserStateResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SwitchUserStateResponse(Long r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SwitchUserStateResponse(Long r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.destination_container_id = r100;
        this.user_container_id = r101;
    }
}
