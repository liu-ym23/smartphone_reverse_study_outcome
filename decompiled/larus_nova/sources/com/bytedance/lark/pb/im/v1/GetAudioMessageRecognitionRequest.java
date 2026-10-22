package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetAudioMessageRecognitionRequest extends Message<GetAudioMessageRecognitionRequest, Builder> {
    public static final ProtoAdapter<GetAudioMessageRecognitionRequest> ADAPTER = null;
    public static final String DEFAULT_AUDIO_FORMAT = "";
    public static final Integer DEFAULT_AUDIO_RATE = null;
    public static final String DEFAULT_DEVICE_LOCALE = "";
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final Integer DEFAULT_START_TIME = null;
    public static final ProtoAdapter_GetAudioMessageRecognitionRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String audio_format;
    public final Integer audio_rate;
    public final String device_locale;
    public final String message_id;
    public final Integer start_time;

    public static final class Builder extends Message.Builder<GetAudioMessageRecognitionRequest, Builder> implements d<GetAudioMessageRecognitionRequest> {
        public String audio_format;
        public Integer audio_rate;
        public String device_locale;
        public String message_id;
        public Integer start_time;

        @Override // com.squareup.wire.Message.Builder
        public GetAudioMessageRecognitionRequest build() {
            return new GetAudioMessageRecognitionRequest(this.message_id, this.audio_rate, this.audio_format, this.device_locale, this.start_time, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder audio_format(String r100) {
            this.audio_format = r100;
            return this;
        }

        public Builder audio_rate(Integer r100) {
            this.audio_rate = r100;
            return this;
        }

        public Builder device_locale(String r100) {
            this.device_locale = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder start_time(Integer r100) {
            this.start_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetAudioMessageRecognitionRequest extends ProtoAdapter<GetAudioMessageRecognitionRequest> implements c<GetAudioMessageRecognitionRequest> {
        public ProtoAdapter_GetAudioMessageRecognitionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetAudioMessageRecognitionRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetAudioMessageRecognitionRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_id = "";
            r101.audio_rate = 0;
            r101.audio_format = "";
            r101.device_locale = "";
            r101.start_time = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.audio_rate = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.audio_format = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.device_locale = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.start_time = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(GetAudioMessageRecognitionRequest r100) {
            String r101 = r100.message_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.audio_rate;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.audio_format;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.device_locale;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Integer r113 = r100.start_time;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(5, r113);
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
        public /* bridge */ /* synthetic */ GetAudioMessageRecognitionRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetAudioMessageRecognitionRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetAudioMessageRecognitionRequest r101) throws IOException {
            String r102 = r101.message_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.audio_rate;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.audio_format;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.device_locale;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Integer r106 = r101.start_time;
            if (r106 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetAudioMessageRecognitionRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetAudioMessageRecognitionRequest r100 = new ProtoAdapter_GetAudioMessageRecognitionRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_AUDIO_RATE = 0;
        DEFAULT_START_TIME = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_id = this.message_id;
        r100.audio_rate = this.audio_rate;
        r100.audio_format = this.audio_format;
        r100.device_locale = this.device_locale;
        r100.start_time = this.start_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetAudioMessageRecognitionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetAudioMessageRecognitionRequest(String r100, Integer r101, String r110, String r111, Integer r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public GetAudioMessageRecognitionRequest(String r100, Integer r101, String r102, String r103, Integer r104, ByteString r105) {
        super(ADAPTER, r105);
        this.message_id = r100;
        this.audio_rate = r101;
        this.audio_format = r102;
        this.device_locale = r103;
        this.start_time = r104;
    }
}
