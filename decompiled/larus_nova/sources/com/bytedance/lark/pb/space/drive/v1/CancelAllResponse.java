package com.bytedance.lark.pb.space.drive.v1;

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
public final class CancelAllResponse extends Message<CancelAllResponse, Builder> {
    public static final ProtoAdapter<CancelAllResponse> ADAPTER = null;
    public static final Integer DEFAULT_RESULT = null;
    public static final ProtoAdapter_CancelAllResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Integer result;

    public static final class Builder extends Message.Builder<CancelAllResponse, Builder> implements d<CancelAllResponse> {
        public Integer result;

        @Override // com.squareup.wire.Message.Builder
        public CancelAllResponse build() {
            Integer r100 = this.result;
            if (r100 == null) goto L7;
            return new CancelAllResponse(this.result, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "result"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder result(Integer r100) {
            this.result = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CancelAllResponse extends ProtoAdapter<CancelAllResponse> implements c<CancelAllResponse> {
        public ProtoAdapter_CancelAllResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, CancelAllResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CancelAllResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.result = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.result = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(CancelAllResponse r100) {
            return ProtoAdapter.INT32.encodedSizeWithTag(1, r100.result) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CancelAllResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CancelAllResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CancelAllResponse r101) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r101.result);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CancelAllResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CancelAllResponse r100 = new ProtoAdapter_CancelAllResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_RESULT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.result = this.result;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CancelAllResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CancelAllResponse(Integer r100) {
        this(r100, ByteString.EMPTY);
    }

    public CancelAllResponse(Integer r100, ByteString r101) {
        super(ADAPTER, r101);
        this.result = r100;
    }
}
