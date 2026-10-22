package com.bytedance.lark.pb.media.v1;

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
public final class GetFileStateByUrlResponse extends Message<GetFileStateByUrlResponse, Builder> {
    public static final ProtoAdapter<GetFileStateByUrlResponse> ADAPTER = null;
    public static final GetFileStateResponse.State DEFAULT_STATE = null;
    public static final ProtoAdapter_GetFileStateByUrlResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final GetFileStateResponse.State state;

    public static final class Builder extends Message.Builder<GetFileStateByUrlResponse, Builder> implements d<GetFileStateByUrlResponse> {
        public GetFileStateResponse.State state;

        @Override // com.squareup.wire.Message.Builder
        public GetFileStateByUrlResponse build() {
            GetFileStateResponse.State r100 = this.state;
            if (r100 == null) goto L7;
            return new GetFileStateByUrlResponse(this.state, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "state"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder state(GetFileStateResponse.State r100) {
            this.state = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetFileStateByUrlResponse extends ProtoAdapter<GetFileStateByUrlResponse> implements c<GetFileStateByUrlResponse> {
        public ProtoAdapter_GetFileStateByUrlResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetFileStateByUrlResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetFileStateByUrlResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.state = GetFileStateResponse.State.NORMAL;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.state = GetFileStateResponse.State.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetFileStateByUrlResponse r100) {
            return GetFileStateResponse.State.ADAPTER.encodedSizeWithTag(1, r100.state) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetFileStateByUrlResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetFileStateByUrlResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetFileStateByUrlResponse r101) throws IOException {
            GetFileStateResponse.State.ADAPTER.encodeWithTag(r100, 1, r101.state);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetFileStateByUrlResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetFileStateByUrlResponse r100 = new ProtoAdapter_GetFileStateByUrlResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STATE = GetFileStateResponse.State.NORMAL;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.state = this.state;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetFileStateByUrlResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetFileStateByUrlResponse(GetFileStateResponse.State r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetFileStateByUrlResponse(GetFileStateResponse.State r100, ByteString r101) {
        super(ADAPTER, r101);
        this.state = r100;
    }
}
