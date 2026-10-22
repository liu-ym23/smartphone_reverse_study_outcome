package com.bytedance.lark.pb.security.v1;

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
public final class FileSecurityQueryStatusV2Response extends Message<FileSecurityQueryStatusV2Response, Builder> {
    public static final ProtoAdapter<FileSecurityQueryStatusV2Response> ADAPTER = null;
    public static final ByteString DEFAULT_DEVICE_KEY = null;
    public static final Integer DEFAULT_ERR_CODE = null;
    public static final String DEFAULT_ERR_MSG = "";
    public static final Integer DEFAULT_MODE = null;
    public static final ProtoAdapter_FileSecurityQueryStatusV2Response RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ByteString device_key;
    public final Integer err_code;
    public final String err_msg;
    public final Integer mode;

    public static final class Builder extends Message.Builder<FileSecurityQueryStatusV2Response, Builder> implements d<FileSecurityQueryStatusV2Response> {
        public ByteString device_key;
        public Integer err_code;
        public String err_msg;
        public Integer mode;

        @Override // com.squareup.wire.Message.Builder
        public FileSecurityQueryStatusV2Response build() {
            Integer r100 = this.mode;
            if (r100 == null) goto L7;
            return new FileSecurityQueryStatusV2Response(this.mode, this.err_code, this.err_msg, this.device_key, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mode"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder device_key(ByteString r100) {
            this.device_key = r100;
            return this;
        }

        public Builder err_code(Integer r100) {
            this.err_code = r100;
            return this;
        }

        public Builder err_msg(String r100) {
            this.err_msg = r100;
            return this;
        }

        public Builder mode(Integer r100) {
            this.mode = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FileSecurityQueryStatusV2Response extends ProtoAdapter<FileSecurityQueryStatusV2Response> implements c<FileSecurityQueryStatusV2Response> {
        public ProtoAdapter_FileSecurityQueryStatusV2Response() {
            super(FieldEncoding.LENGTH_DELIMITED, FileSecurityQueryStatusV2Response.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FileSecurityQueryStatusV2Response decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mode = 0;
            r101.err_code = 0;
            r101.err_msg = "";
            r101.device_key = ByteString.EMPTY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mode = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.err_code = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.err_msg = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.device_key = ProtoAdapter.BYTES.decode(r100);
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
        public int encodedSize2(FileSecurityQueryStatusV2Response r100) {
            ProtoAdapter<Integer> r101 = ProtoAdapter.INT32;
            int r102 = r101.encodedSizeWithTag(1, r100.mode);
            Integer r103 = r100.err_code;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.err_msg;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            ByteString r110 = r100.device_key;
            if (r110 == null) goto L14;
            r104 = ProtoAdapter.BYTES.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ FileSecurityQueryStatusV2Response decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FileSecurityQueryStatusV2Response r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FileSecurityQueryStatusV2Response r101) throws IOException {
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            r102.encodeWithTag(r100, 1, r101.mode);
            Integer r103 = r101.err_code;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.err_msg;
            if (r104 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L8:
            ByteString r105 = r101.device_key;
            if (r105 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r100, 4, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FileSecurityQueryStatusV2Response r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_FileSecurityQueryStatusV2Response r100 = new ProtoAdapter_FileSecurityQueryStatusV2Response();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_MODE = 0;
        DEFAULT_ERR_CODE = 0;
        DEFAULT_DEVICE_KEY = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mode = this.mode;
        r100.err_code = this.err_code;
        r100.err_msg = this.err_msg;
        r100.device_key = this.device_key;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FileSecurityQueryStatusV2Response.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FileSecurityQueryStatusV2Response(Integer r100, Integer r101, String r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FileSecurityQueryStatusV2Response(Integer r100, Integer r101, String r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mode = r100;
        this.err_code = r101;
        this.err_msg = r102;
        this.device_key = r103;
    }
}
