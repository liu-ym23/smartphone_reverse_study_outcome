package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetCanSetStrangerResponse extends Message<GetCanSetStrangerResponse, Builder> {
    public static final ProtoAdapter<GetCanSetStrangerResponse> ADAPTER = null;
    public static final ProtoAdapter_GetCanSetStrangerResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Long, Boolean> can_set_stranger;

    public static final class Builder extends Message.Builder<GetCanSetStrangerResponse, Builder> implements d<GetCanSetStrangerResponse> {
        public Map<Long, Boolean> can_set_stranger;

        @Override // com.squareup.wire.Message.Builder
        public GetCanSetStrangerResponse build() {
            return new GetCanSetStrangerResponse(this.can_set_stranger, super.buildUnknownFields());
        }

        public Builder() {
            this.can_set_stranger = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder can_set_stranger(Map<Long, Boolean> r100) {
            Internal.checkElementsNotNull(r100);
            this.can_set_stranger = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetCanSetStrangerResponse extends ProtoAdapter<GetCanSetStrangerResponse> implements c<GetCanSetStrangerResponse> {
        private final ProtoAdapter<Map<Long, Boolean>> can_set_stranger;

        public ProtoAdapter_GetCanSetStrangerResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetCanSetStrangerResponse.class);
            this.can_set_stranger = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, ProtoAdapter.BOOL);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetCanSetStrangerResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.can_set_stranger.putAll(this.can_set_stranger.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetCanSetStrangerResponse r100) {
            return this.can_set_stranger.encodedSizeWithTag(1, r100.can_set_stranger) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetCanSetStrangerResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetCanSetStrangerResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetCanSetStrangerResponse r101) throws IOException {
            this.can_set_stranger.encodeWithTag(r100, 1, r101.can_set_stranger);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetCanSetStrangerResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetCanSetStrangerResponse r100 = new ProtoAdapter_GetCanSetStrangerResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.can_set_stranger = Internal.copyOf("can_set_stranger", this.can_set_stranger);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetCanSetStrangerResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetCanSetStrangerResponse(Map<Long, Boolean> r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetCanSetStrangerResponse(Map<Long, Boolean> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.can_set_stranger = Internal.immutableCopyOf("can_set_stranger", r100);
    }
}
