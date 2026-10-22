package com.ss.android.lark.pb.improto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PutSameDeviceJudgeInfoResponse extends Message<PutSameDeviceJudgeInfoResponse, Builder> {
    public static final ProtoAdapter<PutSameDeviceJudgeInfoResponse> ADAPTER = null;
    public static final Integer DEFAULT_STATUS_CODE = null;
    public static final String DEFAULT_STATUS_MESSAGE = "";
    private static final long serialVersionUID = 0;
    public final Integer mstatus_code;
    public final String mstatus_message;

    public static final class Builder extends Message.Builder<PutSameDeviceJudgeInfoResponse, Builder> {
        public Integer mstatus_code;
        public String mstatus_message;

        @Override // com.squareup.wire.Message.Builder
        public PutSameDeviceJudgeInfoResponse build() {
            return new PutSameDeviceJudgeInfoResponse(this.mstatus_code, this.mstatus_message, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder status_code(Integer r100) {
            this.mstatus_code = r100;
            return this;
        }

        public Builder status_message(String r100) {
            this.mstatus_message = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PutSameDeviceJudgeInfoResponse extends ProtoAdapter<PutSameDeviceJudgeInfoResponse> {
        public ProtoAdapter_PutSameDeviceJudgeInfoResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PutSameDeviceJudgeInfoResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutSameDeviceJudgeInfoResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mstatus_code = 0;
            r101.mstatus_message = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mstatus_code = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mstatus_message = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(PutSameDeviceJudgeInfoResponse r100) {
            Integer r101 = r100.mstatus_code;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mstatus_message;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PutSameDeviceJudgeInfoResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutSameDeviceJudgeInfoResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutSameDeviceJudgeInfoResponse r101) throws IOException {
            Integer r102 = r101.mstatus_code;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mstatus_message;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutSameDeviceJudgeInfoResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PutSameDeviceJudgeInfoResponse();
        DEFAULT_STATUS_CODE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mstatus_code = this.mstatus_code;
        r100.mstatus_message = this.mstatus_message;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PutSameDeviceJudgeInfoResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutSameDeviceJudgeInfoResponse(Integer r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PutSameDeviceJudgeInfoResponse(Integer r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mstatus_code = r100;
        this.mstatus_message = r101;
    }
}
