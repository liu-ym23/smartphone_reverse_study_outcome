package com.ss.android.lark.pb.recognition;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class SpeechRecognitionFeedbackItem extends Message<SpeechRecognitionFeedbackItem, Builder> {
    public static final ProtoAdapter<SpeechRecognitionFeedbackItem> ADAPTER = null;
    public static final String DEFAULT_CLIENT_RECEIVED_RESULT = "";
    public static final ByteString DEFAULT_ORIGIN_AUDIO_DATA = null;
    public static final String DEFAULT_ORIGIN_AUDIO_TYPE = "";
    public static final String DEFAULT_RECORDING_DEVICE = "";
    public static final String DEFAULT_SOURCE_ID = "";
    private static final long serialVersionUID = 0;
    public final String mclient_received_result;
    public final ByteString morigin_audio_data;
    public final String morigin_audio_type;
    public final String mrecording_device;
    public final String msource_id;

    public static final class Builder extends Message.Builder<SpeechRecognitionFeedbackItem, Builder> {
        public String mclient_received_result;
        public ByteString morigin_audio_data;
        public String morigin_audio_type;
        public String mrecording_device;
        public String msource_id;

        @Override // com.squareup.wire.Message.Builder
        public SpeechRecognitionFeedbackItem build() {
            return new SpeechRecognitionFeedbackItem(this.msource_id, this.morigin_audio_type, this.morigin_audio_data, this.mclient_received_result, this.mrecording_device, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder client_received_result(String r100) {
            this.mclient_received_result = r100;
            return this;
        }

        public Builder origin_audio_data(ByteString r100) {
            this.morigin_audio_data = r100;
            return this;
        }

        public Builder origin_audio_type(String r100) {
            this.morigin_audio_type = r100;
            return this;
        }

        public Builder recording_device(String r100) {
            this.mrecording_device = r100;
            return this;
        }

        public Builder source_id(String r100) {
            this.msource_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SpeechRecognitionFeedbackItem extends ProtoAdapter<SpeechRecognitionFeedbackItem> {
        public ProtoAdapter_SpeechRecognitionFeedbackItem() {
            super(FieldEncoding.LENGTH_DELIMITED, SpeechRecognitionFeedbackItem.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SpeechRecognitionFeedbackItem decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.msource_id = "";
            r101.morigin_audio_type = "";
            r101.morigin_audio_data = ByteString.EMPTY;
            r101.mclient_received_result = "";
            r101.mrecording_device = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.msource_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.morigin_audio_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.morigin_audio_data = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.mclient_received_result = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.mrecording_device = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SpeechRecognitionFeedbackItem r100) {
            String r101 = r100.msource_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.morigin_audio_type;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ByteString r107 = r100.morigin_audio_data;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BYTES.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mclient_received_result;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.mrecording_device;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SpeechRecognitionFeedbackItem decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SpeechRecognitionFeedbackItem r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SpeechRecognitionFeedbackItem r101) throws IOException {
            String r102 = r101.msource_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.morigin_audio_type;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            ByteString r104 = r101.morigin_audio_data;
            if (r104 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mclient_received_result;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.mrecording_device;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SpeechRecognitionFeedbackItem r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SpeechRecognitionFeedbackItem();
        DEFAULT_ORIGIN_AUDIO_DATA = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.msource_id = this.msource_id;
        r100.morigin_audio_type = this.morigin_audio_type;
        r100.morigin_audio_data = this.morigin_audio_data;
        r100.mclient_received_result = this.mclient_received_result;
        r100.mrecording_device = this.mrecording_device;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SpeechRecognitionFeedbackItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SpeechRecognitionFeedbackItem(String r100, String r101, ByteString r110, String r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public SpeechRecognitionFeedbackItem(String r100, String r101, ByteString r102, String r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.msource_id = r100;
        this.morigin_audio_type = r101;
        this.morigin_audio_data = r102;
        this.mclient_received_result = r103;
        this.mrecording_device = r104;
    }
}
