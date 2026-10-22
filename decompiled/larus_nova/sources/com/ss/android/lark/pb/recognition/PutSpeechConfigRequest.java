package com.ss.android.lark.pb.recognition;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PutSpeechConfigRequest extends Message<PutSpeechConfigRequest, Builder> {
    public static final ProtoAdapter<PutSpeechConfigRequest> ADAPTER = null;
    public static final Boolean DEFAULT_ENABLE_FORMAT = null;
    public static final String DEFAULT_MANUAL_CONF_LANG = "";
    public static final String DEFAULT_REQUEST_NO = "";
    public static final Integer DEFAULT_SPEECH_VERSION = null;
    private static final long serialVersionUID = 0;
    public final Boolean menable_format;
    public final String mmanual_conf_lang;
    public final String mrequest_no;
    public final Integer mspeech_version;

    public static final class Builder extends Message.Builder<PutSpeechConfigRequest, Builder> {
        public Boolean menable_format;
        public String mmanual_conf_lang;
        public String mrequest_no;
        public Integer mspeech_version;

        @Override // com.squareup.wire.Message.Builder
        public PutSpeechConfigRequest build() {
            return new PutSpeechConfigRequest(this.mrequest_no, this.mmanual_conf_lang, this.mspeech_version, this.menable_format, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder enable_format(Boolean r100) {
            this.menable_format = r100;
            return this;
        }

        public Builder manual_conf_lang(String r100) {
            this.mmanual_conf_lang = r100;
            return this;
        }

        public Builder request_no(String r100) {
            this.mrequest_no = r100;
            return this;
        }

        public Builder speech_version(Integer r100) {
            this.mspeech_version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PutSpeechConfigRequest extends ProtoAdapter<PutSpeechConfigRequest> {
        public ProtoAdapter_PutSpeechConfigRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PutSpeechConfigRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutSpeechConfigRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mrequest_no = "";
            r101.mmanual_conf_lang = "";
            r101.mspeech_version = 0;
            r101.menable_format = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mrequest_no = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mmanual_conf_lang = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mspeech_version = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.menable_format = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PutSpeechConfigRequest r100) {
            String r101 = r100.mrequest_no;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mmanual_conf_lang;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.mspeech_version;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.menable_format;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ PutSpeechConfigRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutSpeechConfigRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutSpeechConfigRequest r101) throws IOException {
            String r102 = r101.mrequest_no;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mmanual_conf_lang;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.mspeech_version;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.menable_format;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutSpeechConfigRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PutSpeechConfigRequest();
        DEFAULT_SPEECH_VERSION = 0;
        DEFAULT_ENABLE_FORMAT = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mrequest_no = this.mrequest_no;
        r100.mmanual_conf_lang = this.mmanual_conf_lang;
        r100.mspeech_version = this.mspeech_version;
        r100.menable_format = this.menable_format;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PutSpeechConfigRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutSpeechConfigRequest(String r100, String r101, Integer r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PutSpeechConfigRequest(String r100, String r101, Integer r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mrequest_no = r100;
        this.mmanual_conf_lang = r101;
        this.mspeech_version = r102;
        this.menable_format = r103;
    }
}
