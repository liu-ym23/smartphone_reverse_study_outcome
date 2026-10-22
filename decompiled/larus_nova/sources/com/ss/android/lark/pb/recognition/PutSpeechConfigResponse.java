package com.ss.android.lark.pb.recognition;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PutSpeechConfigResponse extends Message<PutSpeechConfigResponse, Builder> {
    public static final ProtoAdapter<PutSpeechConfigResponse> ADAPTER = null;
    public static final Integer DEFAULT_CODE = null;
    public static final String DEFAULT_REQUEST_NO = "";
    private static final long serialVersionUID = 0;
    public final Integer mcode;
    public final String mrequest_no;

    public static final class Builder extends Message.Builder<PutSpeechConfigResponse, Builder> {
        public Integer mcode;
        public String mrequest_no;

        @Override // com.squareup.wire.Message.Builder
        public PutSpeechConfigResponse build() {
            return new PutSpeechConfigResponse(this.mcode, this.mrequest_no, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder code(Integer r100) {
            this.mcode = r100;
            return this;
        }

        public Builder request_no(String r100) {
            this.mrequest_no = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PutSpeechConfigResponse extends ProtoAdapter<PutSpeechConfigResponse> {
        public ProtoAdapter_PutSpeechConfigResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PutSpeechConfigResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutSpeechConfigResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mcode = 0;
            r101.mrequest_no = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mcode = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mrequest_no = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(PutSpeechConfigResponse r100) {
            Integer r101 = r100.mcode;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mrequest_no;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PutSpeechConfigResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutSpeechConfigResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutSpeechConfigResponse r101) throws IOException {
            Integer r102 = r101.mcode;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mrequest_no;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutSpeechConfigResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PutSpeechConfigResponse();
        DEFAULT_CODE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mcode = this.mcode;
        r100.mrequest_no = this.mrequest_no;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PutSpeechConfigResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutSpeechConfigResponse(Integer r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PutSpeechConfigResponse(Integer r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mcode = r100;
        this.mrequest_no = r101;
    }
}
