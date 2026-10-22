package com.bytedance.lark.pb.space.drive.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class UploadFailedInfo extends Message<UploadFailedInfo, Builder> {
    public static final ProtoAdapter<UploadFailedInfo> ADAPTER = null;
    public static final Integer DEFAULT_ERROR_CODE = null;
    public static final String DEFAULT_ERROR_MESSAGE = "";
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_REQUEST_ID = "";
    private static final long serialVersionUID = 0;
    public final Integer error_code;
    public final String error_message;
    public final String key;
    public final String request_id;

    public static final class Builder extends Message.Builder<UploadFailedInfo, Builder> {
        public Integer error_code;
        public String error_message;
        public String key;
        public String request_id;

        @Override // com.squareup.wire.Message.Builder
        public UploadFailedInfo build() {
            String r100 = this.key;
            if (r100 == null) goto L7;
            return new UploadFailedInfo(this.key, this.error_code, this.request_id, this.error_message, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "key"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder error_code(Integer r100) {
            this.error_code = r100;
            return this;
        }

        public Builder error_message(String r100) {
            this.error_message = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder request_id(String r100) {
            this.request_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UploadFailedInfo extends ProtoAdapter<UploadFailedInfo> {
        public ProtoAdapter_UploadFailedInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, UploadFailedInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UploadFailedInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.key = "";
            r101.error_code = 0;
            r101.request_id = "";
            r101.error_message = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.error_code = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.request_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.error_message = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(UploadFailedInfo r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.key);
            Integer r103 = r100.error_code;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.request_id;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.error_message;
            if (r110 == null) goto L14;
            r104 = r101.encodedSizeWithTag(4, r110);
        L14:
            return (r109 + r104) + r100.unknownFields().size();
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UploadFailedInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UploadFailedInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UploadFailedInfo r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.key);
            Integer r103 = r101.error_code;
            if (r103 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.request_id;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            String r105 = r101.error_message;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 4, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UploadFailedInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UploadFailedInfo();
        DEFAULT_ERROR_CODE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.error_code = this.error_code;
        r100.request_id = this.request_id;
        r100.error_message = this.error_message;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UploadFailedInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UploadFailedInfo(String r100, Integer r101, String r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public UploadFailedInfo(String r100, Integer r101, String r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.key = r100;
        this.error_code = r101;
        this.request_id = r102;
        this.error_message = r103;
    }
}
