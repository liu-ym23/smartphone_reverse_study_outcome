package com.bytedance.lark.pb.contact.v2;

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
public final class GetUserBlockStatusResponse extends Message<GetUserBlockStatusResponse, Builder> {
    public static final ProtoAdapter<GetUserBlockStatusResponse> ADAPTER = null;
    public static final Boolean DEFAULT_BE_BLOCK_STATUS = null;
    public static final Boolean DEFAULT_BLOCK_STATUS = null;
    public static final ProtoAdapter_GetUserBlockStatusResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean be_block_status;
    public final Boolean block_status;

    public static final class Builder extends Message.Builder<GetUserBlockStatusResponse, Builder> implements d<GetUserBlockStatusResponse> {
        public Boolean be_block_status;
        public Boolean block_status;

        @Override // com.squareup.wire.Message.Builder
        public GetUserBlockStatusResponse build() {
            Boolean r100 = this.block_status;
            if (r100 == null) goto L9;
            if (this.be_block_status == null) goto L9;
            return new GetUserBlockStatusResponse(this.block_status, this.be_block_status, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "block_status", this.be_block_status, "be_block_status"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder be_block_status(Boolean r100) {
            this.be_block_status = r100;
            return this;
        }

        public Builder block_status(Boolean r100) {
            this.block_status = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUserBlockStatusResponse extends ProtoAdapter<GetUserBlockStatusResponse> implements c<GetUserBlockStatusResponse> {
        public ProtoAdapter_GetUserBlockStatusResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUserBlockStatusResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUserBlockStatusResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.block_status = r102;
            r101.be_block_status = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L12;
            if (r104 != 1) goto L8;
            r101.block_status = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L9;
            r101.be_block_status = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetUserBlockStatusResponse r100) {
            ProtoAdapter<Boolean> r101 = ProtoAdapter.BOOL;
            return (r101.encodedSizeWithTag(1, r100.block_status) + r101.encodedSizeWithTag(2, r100.be_block_status)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUserBlockStatusResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUserBlockStatusResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUserBlockStatusResponse r101) throws IOException {
            ProtoAdapter<Boolean> r102 = ProtoAdapter.BOOL;
            r102.encodeWithTag(r100, 1, r101.block_status);
            r102.encodeWithTag(r100, 2, r101.be_block_status);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUserBlockStatusResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetUserBlockStatusResponse r100 = new ProtoAdapter_GetUserBlockStatusResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_BLOCK_STATUS = r101;
        DEFAULT_BE_BLOCK_STATUS = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.block_status = this.block_status;
        r100.be_block_status = this.be_block_status;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUserBlockStatusResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUserBlockStatusResponse(Boolean r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetUserBlockStatusResponse(Boolean r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.block_status = r100;
        this.be_block_status = r101;
    }
}
