package com.bytedance.lark.pb.media.v1;

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
public final class UploadAudioDataRequest extends Message<UploadAudioDataRequest, Builder> {
    public static final ProtoAdapter<UploadAudioDataRequest> ADAPTER = null;
    public static final String DEFAULT_AUDIO_TYPE = "";
    public static final Boolean DEFAULT_CANCEL = null;
    public static final ByteString DEFAULT_DATA = null;
    public static final Boolean DEFAULT_DELETE_AUDIO_RESOURCE = null;
    public static final Boolean DEFAULT_FINISH = null;
    public static final Boolean DEFAULT_NEED_RECOGNIZE = null;
    public static final Integer DEFAULT_SEQUENCE_ID = null;
    public static final String DEFAULT_UPLOAD_ID = "";
    public static final ProtoAdapter_UploadAudioDataRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String audio_type;
    public final Boolean cancel;
    public final ByteString data;
    public final Boolean delete_audio_resource;
    public final Boolean finish;
    public final Boolean need_recognize;
    public final Integer sequence_id;
    public final String upload_id;

    public static final class Builder extends Message.Builder<UploadAudioDataRequest, Builder> implements d<UploadAudioDataRequest> {
        public String audio_type;
        public Boolean cancel;
        public ByteString data;
        public Boolean delete_audio_resource;
        public Boolean finish;
        public Boolean need_recognize;
        public Integer sequence_id;
        public String upload_id;

        @Override // com.squareup.wire.Message.Builder
        public UploadAudioDataRequest build() {
            String r100 = this.upload_id;
            if (r100 == null) goto L11;
            if (this.sequence_id == null) goto L11;
            if (this.data == null) goto L11;
            return new UploadAudioDataRequest(this.upload_id, this.sequence_id, this.data, this.audio_type, this.need_recognize, this.finish, this.cancel, this.delete_audio_resource, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "upload_id", this.sequence_id, "sequence_id", this.data, "data"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder audio_type(String r100) {
            this.audio_type = r100;
            return this;
        }

        public Builder cancel(Boolean r100) {
            this.cancel = r100;
            return this;
        }

        public Builder data(ByteString r100) {
            this.data = r100;
            return this;
        }

        public Builder delete_audio_resource(Boolean r100) {
            this.delete_audio_resource = r100;
            return this;
        }

        public Builder finish(Boolean r100) {
            this.finish = r100;
            return this;
        }

        public Builder need_recognize(Boolean r100) {
            this.need_recognize = r100;
            return this;
        }

        public Builder sequence_id(Integer r100) {
            this.sequence_id = r100;
            return this;
        }

        public Builder upload_id(String r100) {
            this.upload_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UploadAudioDataRequest extends ProtoAdapter<UploadAudioDataRequest> implements c<UploadAudioDataRequest> {
        public ProtoAdapter_UploadAudioDataRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UploadAudioDataRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UploadAudioDataRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.upload_id = "";
            r101.sequence_id = 0;
            r101.data = ByteString.EMPTY;
            r101.audio_type = "";
            Boolean r102 = Boolean.FALSE;
            r101.need_recognize = r102;
            r101.finish = r102;
            r101.cancel = r102;
            r101.delete_audio_resource = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L15;
            switch(r104) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L7:
            r101.delete_audio_resource = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.cancel = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.finish = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.need_recognize = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.audio_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.data = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L13:
            r101.sequence_id = ProtoAdapter.INT32.decode(r100);
            goto L3
        L14:
            r101.upload_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UploadAudioDataRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.upload_id) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.sequence_id)) + ProtoAdapter.BYTES.encodedSizeWithTag(3, r100.data);
            String r103 = r100.audio_type;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(4, r103);
        L6:
            int r106 = r102 + r105;
            Boolean r107 = r100.need_recognize;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r107);
        L10:
            int r109 = r106 + r108;
            Boolean r110 = r100.finish;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r110);
        L14:
            int r112 = r109 + r111;
            Boolean r113 = r100.cancel;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r113);
        L18:
            int r115 = r112 + r114;
            Boolean r116 = r100.delete_audio_resource;
            if (r116 == null) goto L22;
            r104 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r116);
        L22:
            return (r115 + r104) + r100.unknownFields().size();
        L17:
            r114 = 0;
            goto L18
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UploadAudioDataRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UploadAudioDataRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UploadAudioDataRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.upload_id);
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.sequence_id);
            ProtoAdapter.BYTES.encodeWithTag(r100, 3, r101.data);
            String r103 = r101.audio_type;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 4, r103);
        L5:
            Boolean r104 = r101.need_recognize;
            if (r104 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r104);
        L8:
            Boolean r105 = r101.finish;
            if (r105 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r105);
        L11:
            Boolean r106 = r101.cancel;
            if (r106 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r106);
        L14:
            Boolean r107 = r101.delete_audio_resource;
            if (r107 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r107);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UploadAudioDataRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UploadAudioDataRequest r100 = new ProtoAdapter_UploadAudioDataRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SEQUENCE_ID = 0;
        DEFAULT_DATA = ByteString.EMPTY;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_NEED_RECOGNIZE = r101;
        DEFAULT_FINISH = r101;
        DEFAULT_CANCEL = r101;
        DEFAULT_DELETE_AUDIO_RESOURCE = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.upload_id = this.upload_id;
        r100.sequence_id = this.sequence_id;
        r100.data = this.data;
        r100.audio_type = this.audio_type;
        r100.need_recognize = this.need_recognize;
        r100.finish = this.finish;
        r100.cancel = this.cancel;
        r100.delete_audio_resource = this.delete_audio_resource;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UploadAudioDataRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UploadAudioDataRequest(String r110, Integer r111, ByteString r112, String r113, Boolean r114, Boolean r115, Boolean r116, Boolean r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public UploadAudioDataRequest(String r100, Integer r101, ByteString r102, String r103, Boolean r104, Boolean r105, Boolean r106, Boolean r107, ByteString r110) {
        super(ADAPTER, r110);
        this.upload_id = r100;
        this.sequence_id = r101;
        this.data = r102;
        this.audio_type = r103;
        this.need_recognize = r104;
        this.finish = r105;
        this.cancel = r106;
        this.delete_audio_resource = r107;
    }
}
