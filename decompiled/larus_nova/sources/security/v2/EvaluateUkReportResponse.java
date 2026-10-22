package security.v2;

import annotation.OptionsExt;
import com.google.protobuf.MessageOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes41.dex */
public final class EvaluateUkReportResponse extends Message<EvaluateUkReportResponse, Builder> {
    public static final ProtoAdapter<EvaluateUkReportResponse> ADAPTER = null;
    public static final MessageOptions MESSAGE_OPTIONS = null;
    public static final ProtoAdapter_EvaluateUkReportResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<EvaluateUkReportResponse, Builder> implements d<EvaluateUkReportResponse> {
        @Override // com.squareup.wire.Message.Builder
        public EvaluateUkReportResponse build() {
            return new EvaluateUkReportResponse(super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }
    }

    public static final class ProtoAdapter_EvaluateUkReportResponse extends ProtoAdapter<EvaluateUkReportResponse> implements c<EvaluateUkReportResponse> {
        public ProtoAdapter_EvaluateUkReportResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, EvaluateUkReportResponse.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public EvaluateUkReportResponse decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L6;
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L6:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(EvaluateUkReportResponse r100) {
            return r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ EvaluateUkReportResponse decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EvaluateUkReportResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EvaluateUkReportResponse r101) throws IOException {
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EvaluateUkReportResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_EvaluateUkReportResponse r100 = new ProtoAdapter_EvaluateUkReportResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    public EvaluateUkReportResponse() {
        this(ByteString.EMPTY);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EvaluateUkReportResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public EvaluateUkReportResponse(ByteString r100) {
        super(ADAPTER, r100);
    }
}
