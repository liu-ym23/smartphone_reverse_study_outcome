package com.bytedance.lark.pb.security.v2;

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

/* JADX INFO: loaded from: classes20.dex */
public final class AuditEventsResponse extends Message<AuditEventsResponse, Builder> {
    public static final ProtoAdapter<AuditEventsResponse> ADAPTER = null;
    public static final String DEFAULT_ERR_MESSAGE = "";
    public static final Long DEFAULT_FAIL_NUM = null;
    public static final Long DEFAULT_SUCCESS_NUM = null;
    public static final Long DEFAULT_TOTAL_NUM = null;
    public static final MessageOptions MESSAGE_OPTIONS = null;
    public static final ProtoAdapter_AuditEventsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String err_message;
    public final Long fail_num;
    public final Long success_num;
    public final Long total_num;

    public static final class Builder extends Message.Builder<AuditEventsResponse, Builder> implements d<AuditEventsResponse> {
        public String err_message;
        public Long fail_num;
        public Long success_num;
        public Long total_num;

        @Override // com.squareup.wire.Message.Builder
        public AuditEventsResponse build() {
            return new AuditEventsResponse(this.err_message, this.fail_num, this.success_num, this.total_num, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder err_message(String r100) {
            this.err_message = r100;
            return this;
        }

        public Builder fail_num(Long r100) {
            this.fail_num = r100;
            return this;
        }

        public Builder success_num(Long r100) {
            this.success_num = r100;
            return this;
        }

        public Builder total_num(Long r100) {
            this.total_num = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AuditEventsResponse extends ProtoAdapter<AuditEventsResponse> implements c<AuditEventsResponse> {
        public ProtoAdapter_AuditEventsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, AuditEventsResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AuditEventsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.err_message = "";
            r101.fail_num = 0L;
            r101.success_num = 0L;
            r101.total_num = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.err_message = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.fail_num = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.success_num = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.total_num = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(AuditEventsResponse r100) {
            String r101 = r100.err_message;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.fail_num;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.success_num;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.total_num;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ AuditEventsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AuditEventsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AuditEventsResponse r101) throws IOException {
            String r102 = r101.err_message;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.fail_num;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.success_num;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.total_num;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AuditEventsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_AuditEventsResponse r100 = new ProtoAdapter_AuditEventsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
        DEFAULT_FAIL_NUM = 0L;
        DEFAULT_SUCCESS_NUM = 0L;
        DEFAULT_TOTAL_NUM = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.err_message = this.err_message;
        r100.fail_num = this.fail_num;
        r100.success_num = this.success_num;
        r100.total_num = this.total_num;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AuditEventsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AuditEventsResponse(String r100, Long r101, Long r102, Long r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public AuditEventsResponse(String r100, Long r101, Long r102, Long r103, ByteString r104) {
        super(ADAPTER, r104);
        this.err_message = r100;
        this.fail_num = r101;
        this.success_num = r102;
        this.total_num = r103;
    }
}
