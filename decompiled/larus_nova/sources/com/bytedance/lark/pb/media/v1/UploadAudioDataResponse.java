package com.bytedance.lark.pb.media.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
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
public final class UploadAudioDataResponse extends Message<UploadAudioDataResponse, Builder> {
    public static final ProtoAdapter<UploadAudioDataResponse> ADAPTER = null;
    public static final String DEFAULT_AUDIO2TEXT = "";
    public static final Integer DEFAULT_CODE = null;
    public static final Integer DEFAULT_SEQUENCE_ID = null;
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_UPLOAD_ID = "";
    public static final FieldOptions FIELD_OPTIONS_AUDIO2TEXT = null;
    public static final FieldOptions FIELD_OPTIONS_CODE = null;
    public static final FieldOptions FIELD_OPTIONS_SEQUENCE_ID = null;
    public static final FieldOptions FIELD_OPTIONS_TOKEN = null;
    public static final FieldOptions FIELD_OPTIONS_UPLOAD_ID = null;
    public static final ProtoAdapter_UploadAudioDataResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String audio2text;
    public final Integer code;
    public final Integer sequence_id;
    public final String token;
    public final String upload_id;

    public static final class Builder extends Message.Builder<UploadAudioDataResponse, Builder> implements d<UploadAudioDataResponse> {
        public String audio2text;
        public Integer code;
        public Integer sequence_id;
        public String token;
        public String upload_id;

        @Override // com.squareup.wire.Message.Builder
        public UploadAudioDataResponse build() {
            String r100 = this.upload_id;
            if (r100 == null) goto L11;
            if (this.sequence_id == null) goto L11;
            if (this.code == null) goto L11;
            return new UploadAudioDataResponse(this.upload_id, this.sequence_id, this.code, this.audio2text, this.token, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "upload_id", this.sequence_id, "sequence_id", this.code, "code"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder audio2text(String r100) {
            this.audio2text = r100;
            return this;
        }

        public Builder code(Integer r100) {
            this.code = r100;
            return this;
        }

        public Builder sequence_id(Integer r100) {
            this.sequence_id = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }

        public Builder upload_id(String r100) {
            this.upload_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UploadAudioDataResponse extends ProtoAdapter<UploadAudioDataResponse> implements c<UploadAudioDataResponse> {
        public ProtoAdapter_UploadAudioDataResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, UploadAudioDataResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UploadAudioDataResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.upload_id = "";
            r101.sequence_id = 0;
            r101.code = 0;
            r101.audio2text = "";
            r101.token = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.upload_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.sequence_id = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.code = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.audio2text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.token = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(UploadAudioDataResponse r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.upload_id);
            ProtoAdapter<Integer> r103 = ProtoAdapter.INT32;
            int r104 = (r102 + r103.encodedSizeWithTag(2, r100.sequence_id)) + r103.encodedSizeWithTag(3, r100.code);
            String r105 = r100.audio2text;
            int r106 = 0;
            if (r105 == null) goto L5;
            int r107 = r101.encodedSizeWithTag(4, r105);
        L6:
            int r108 = r104 + r107;
            String r109 = r100.token;
            if (r109 == null) goto L10;
            r106 = r101.encodedSizeWithTag(5, r109);
        L10:
            return (r108 + r106) + r100.unknownFields().size();
        L5:
            r107 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UploadAudioDataResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UploadAudioDataResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UploadAudioDataResponse r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.upload_id);
            ProtoAdapter<Integer> r103 = ProtoAdapter.INT32;
            r103.encodeWithTag(r100, 2, r101.sequence_id);
            r103.encodeWithTag(r100, 3, r101.code);
            String r104 = r101.audio2text;
            if (r104 == null) goto L5;
            r102.encodeWithTag(r100, 4, r104);
        L5:
            String r105 = r101.token;
            if (r105 == null) goto L8;
            r102.encodeWithTag(r100, 5, r105);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UploadAudioDataResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UploadAudioDataResponse r100 = new ProtoAdapter_UploadAudioDataResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        FIELD_OPTIONS_UPLOAD_ID = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_SEQUENCE_ID = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_CODE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_AUDIO2TEXT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_TOKEN = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_SEQUENCE_ID = 0;
        DEFAULT_CODE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.upload_id = this.upload_id;
        r100.sequence_id = this.sequence_id;
        r100.code = this.code;
        r100.audio2text = this.audio2text;
        r100.token = this.token;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UploadAudioDataResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UploadAudioDataResponse(String r100, Integer r101, Integer r110, String r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public UploadAudioDataResponse(String r100, Integer r101, Integer r102, String r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.upload_id = r100;
        this.sequence_id = r101;
        this.code = r102;
        this.audio2text = r103;
        this.token = r104;
    }
}
