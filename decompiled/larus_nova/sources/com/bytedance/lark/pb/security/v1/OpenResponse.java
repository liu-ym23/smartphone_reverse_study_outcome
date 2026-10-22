package com.bytedance.lark.pb.security.v1;

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
public final class OpenResponse extends Message<OpenResponse, Builder> {
    public static final ProtoAdapter<OpenResponse> ADAPTER = null;
    public static final Integer DEFAULT_ERR_CODE = null;
    public static final String DEFAULT_ERR_MSG = "";
    public static final Long DEFAULT_SEC_FD = null;
    public static final ProtoAdapter_OpenResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Integer err_code;
    public final String err_msg;
    public final Long sec_fd;
    public final SelfHelpContext selfhelp_context;

    public static final class Builder extends Message.Builder<OpenResponse, Builder> implements d<OpenResponse> {
        public Integer err_code;
        public String err_msg;
        public Long sec_fd;
        public SelfHelpContext selfhelp_context;

        @Override // com.squareup.wire.Message.Builder
        public OpenResponse build() {
            return new OpenResponse(this.err_code, this.err_msg, this.sec_fd, this.selfhelp_context, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder err_code(Integer r100) {
            this.err_code = r100;
            return this;
        }

        public Builder err_msg(String r100) {
            this.err_msg = r100;
            return this;
        }

        public Builder sec_fd(Long r100) {
            this.sec_fd = r100;
            return this;
        }

        public Builder selfhelp_context(SelfHelpContext r100) {
            this.selfhelp_context = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_OpenResponse extends ProtoAdapter<OpenResponse> implements c<OpenResponse> {
        public ProtoAdapter_OpenResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, OpenResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OpenResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.err_code = 0;
            r101.err_msg = "";
            r101.sec_fd = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.err_code = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.err_msg = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.sec_fd = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.selfhelp_context = SelfHelpContext.ADAPTER.decode(r100);
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
        public int encodedSize2(OpenResponse r100) {
            Integer r101 = r100.err_code;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.err_msg;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.sec_fd;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.UINT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            SelfHelpContext r110 = r100.selfhelp_context;
            if (r110 == null) goto L18;
            r102 = SelfHelpContext.ADAPTER.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ OpenResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OpenResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OpenResponse r101) throws IOException {
            Integer r102 = r101.err_code;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.err_msg;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.sec_fd;
            if (r104 == null) goto L11;
            ProtoAdapter.UINT64.encodeWithTag(r100, 3, r104);
        L11:
            SelfHelpContext r105 = r101.selfhelp_context;
            if (r105 == null) goto L14;
            SelfHelpContext.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OpenResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_OpenResponse r100 = new ProtoAdapter_OpenResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_ERR_CODE = 0;
        DEFAULT_SEC_FD = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.err_code = this.err_code;
        r100.err_msg = this.err_msg;
        r100.sec_fd = this.sec_fd;
        r100.selfhelp_context = this.selfhelp_context;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OpenResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OpenResponse(Integer r100, String r101, Long r102, SelfHelpContext r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public OpenResponse(Integer r100, String r101, Long r102, SelfHelpContext r103, ByteString r104) {
        super(ADAPTER, r104);
        this.err_code = r100;
        this.err_msg = r101;
        this.sec_fd = r102;
        this.selfhelp_context = r103;
    }
}
