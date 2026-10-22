package com.ss.android.lark.pb.recognition;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class SpeechRecognitionReportEditResponse extends Message<SpeechRecognitionReportEditResponse, Builder> {
    public static final ProtoAdapter<SpeechRecognitionReportEditResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<SpeechRecognitionReportEditResponse, Builder> {
        @Override // com.squareup.wire.Message.Builder
        public SpeechRecognitionReportEditResponse build() {
            return new SpeechRecognitionReportEditResponse(super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }
    }

    public static final class ProtoAdapter_SpeechRecognitionReportEditResponse extends ProtoAdapter<SpeechRecognitionReportEditResponse> {
        public ProtoAdapter_SpeechRecognitionReportEditResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SpeechRecognitionReportEditResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SpeechRecognitionReportEditResponse decode(ProtoReader r100) throws IOException {
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
        public int encodedSize2(SpeechRecognitionReportEditResponse r100) {
            return r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SpeechRecognitionReportEditResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SpeechRecognitionReportEditResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SpeechRecognitionReportEditResponse r101) throws IOException {
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SpeechRecognitionReportEditResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SpeechRecognitionReportEditResponse();
    }

    public SpeechRecognitionReportEditResponse() {
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
        return SpeechRecognitionReportEditResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SpeechRecognitionReportEditResponse(ByteString r100) {
        super(ADAPTER, r100);
    }
}
