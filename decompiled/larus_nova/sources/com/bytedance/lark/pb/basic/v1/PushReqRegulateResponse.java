package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class PushReqRegulateResponse extends com.squareup.wire.Message<PushReqRegulateResponse, Builder> {
    public static final ProtoAdapter<PushReqRegulateResponse> ADAPTER = null;
    public static final String DEFAULT_CONTEXT_ID = "";
    public static final String DEFAULT_REQ_COMMAND = "";
    public static final String DEFAULT_X_LSC_BIZID = "";
    public static final Integer DEFAULT_X_LSC_CODE = null;
    public static final ByteString DEFAULT_X_LSC_DECISION = null;
    public static final String DEFAULT_X_TT_LOGID = "";
    public static final Long DEFAULT_X_USER_ID = null;
    public static final ProtoAdapter_PushReqRegulateResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String context_id;
    public final String req_command;
    public final String x_lsc_bizid;
    public final Integer x_lsc_code;
    public final ByteString x_lsc_decision;
    public final String x_tt_logid;
    public final Long x_user_id;

    public static final class Builder extends com.squareup.wire.Message.Builder<PushReqRegulateResponse, Builder> implements b<PushReqRegulateResponse> {
        public String context_id;
        public String req_command;
        public String x_lsc_bizid;
        public Integer x_lsc_code;
        public ByteString x_lsc_decision;
        public String x_tt_logid;
        public Long x_user_id;

        @Override // com.squareup.wire.Message.Builder
        public PushReqRegulateResponse build() {
            Integer r100 = this.x_lsc_code;
            if (r100 == null) goto L9;
            if (this.x_lsc_decision == null) goto L9;
            return new PushReqRegulateResponse(this.x_lsc_code, this.x_lsc_decision, this.x_lsc_bizid, this.x_tt_logid, this.x_user_id, this.req_command, this.context_id, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "x_lsc_code", this.x_lsc_decision, "x_lsc_decision"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder context_id(String r100) {
            this.context_id = r100;
            return this;
        }

        public Builder req_command(String r100) {
            this.req_command = r100;
            return this;
        }

        public Builder x_lsc_bizid(String r100) {
            this.x_lsc_bizid = r100;
            return this;
        }

        public Builder x_lsc_code(Integer r100) {
            this.x_lsc_code = r100;
            return this;
        }

        public Builder x_lsc_decision(ByteString r100) {
            this.x_lsc_decision = r100;
            return this;
        }

        public Builder x_tt_logid(String r100) {
            this.x_tt_logid = r100;
            return this;
        }

        public Builder x_user_id(Long r100) {
            this.x_user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushReqRegulateResponse extends ProtoAdapter<PushReqRegulateResponse> implements a<PushReqRegulateResponse> {
        public ProtoAdapter_PushReqRegulateResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PushReqRegulateResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushReqRegulateResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.x_lsc_code = 0;
            r101.x_lsc_decision = ByteString.EMPTY;
            r101.x_lsc_bizid = "";
            r101.x_tt_logid = "";
            r101.x_user_id = 0L;
            r101.req_command = "";
            r101.context_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L14;
            switch(r103) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.context_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.req_command = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.x_user_id = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L10:
            r101.x_tt_logid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.x_lsc_bizid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.x_lsc_decision = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L13:
            r101.x_lsc_code = ProtoAdapter.INT32.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushReqRegulateResponse r100) {
            int r101 = ProtoAdapter.INT32.encodedSizeWithTag(1, r100.x_lsc_code) + ProtoAdapter.BYTES.encodedSizeWithTag(2, r100.x_lsc_decision);
            String r102 = r100.x_lsc_bizid;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(3, r102);
        L6:
            int r105 = r101 + r104;
            String r106 = r100.x_tt_logid;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.STRING.encodedSizeWithTag(4, r106);
        L10:
            int r108 = r105 + r107;
            Long r109 = r100.x_user_id;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.UINT64.encodedSizeWithTag(5, r109);
        L14:
            int r111 = r108 + r110;
            String r112 = r100.req_command;
            if (r112 == null) goto L17;
            int r113 = ProtoAdapter.STRING.encodedSizeWithTag(6, r112);
        L18:
            int r114 = r111 + r113;
            String r115 = r100.context_id;
            if (r115 == null) goto L22;
            r103 = ProtoAdapter.STRING.encodedSizeWithTag(7, r115);
        L22:
            return (r114 + r103) + r100.unknownFields().size();
        L17:
            r113 = 0;
            goto L18
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushReqRegulateResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushReqRegulateResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushReqRegulateResponse r101) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r101.x_lsc_code);
            ProtoAdapter.BYTES.encodeWithTag(r100, 2, r101.x_lsc_decision);
            String r102 = r101.x_lsc_bizid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r102);
        L5:
            String r103 = r101.x_tt_logid;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r103);
        L8:
            Long r104 = r101.x_user_id;
            if (r104 == null) goto L11;
            ProtoAdapter.UINT64.encodeWithTag(r100, 5, r104);
        L11:
            String r105 = r101.req_command;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r105);
        L14:
            String r106 = r101.context_id;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushReqRegulateResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushReqRegulateResponse r100 = new ProtoAdapter_PushReqRegulateResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_X_LSC_CODE = 0;
        DEFAULT_X_LSC_DECISION = ByteString.EMPTY;
        DEFAULT_X_USER_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.x_lsc_code = this.x_lsc_code;
        r100.x_lsc_decision = this.x_lsc_decision;
        r100.x_lsc_bizid = this.x_lsc_bizid;
        r100.x_tt_logid = this.x_tt_logid;
        r100.x_user_id = this.x_user_id;
        r100.req_command = this.req_command;
        r100.context_id = this.context_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushReqRegulateResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushReqRegulateResponse(Integer r110, ByteString r111, String r112, String r113, Long r114, String r115, String r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public PushReqRegulateResponse(Integer r100, ByteString r101, String r102, String r103, Long r104, String r105, String r106, ByteString r107) {
        super(ADAPTER, r107);
        this.x_lsc_code = r100;
        this.x_lsc_decision = r101;
        this.x_lsc_bizid = r102;
        this.x_tt_logid = r103;
        this.x_user_id = r104;
        this.req_command = r105;
        this.context_id = r106;
    }
}
