package com.bytedance.lark.pb.basic.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class LarkError extends com.squareup.wire.Message<LarkError, Builder> {
    public static final ProtoAdapter<LarkError> ADAPTER = null;
    public static final Integer DEFAULT_CODE = null;
    public static final String DEFAULT_DISPLAY_MESSAGE = "";
    public static final String DEFAULT_DISPLAY_TITLE = "";
    public static final ByteString DEFAULT_EXTRA = null;
    public static final String DEFAULT_SERVER_MESSAGE = "";
    public static final Integer DEFAULT_STATUS = null;
    public static final FieldOptions FIELD_OPTIONS_CODE = null;
    public static final FieldOptions FIELD_OPTIONS_DETAILS = null;
    public static final FieldOptions FIELD_OPTIONS_STATUS = null;
    public static final ProtoAdapter_LarkError RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Integer code;
    public final ErrorDetails details;
    public final String display_message;
    public final String display_title;
    public final ByteString extra;
    public final String server_message;
    public final Integer status;

    public static final class Builder extends com.squareup.wire.Message.Builder<LarkError, Builder> implements d<LarkError> {
        public Integer code;
        public ErrorDetails details;
        public String display_message;
        public String display_title;
        public ByteString extra;
        public String server_message;
        public Integer status;

        @Override // com.squareup.wire.Message.Builder
        public LarkError build() {
            return new LarkError(this.status, this.code, this.details, this.display_message, this.display_title, this.server_message, this.extra, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder code(Integer r100) {
            this.code = r100;
            return this;
        }

        public Builder details(ErrorDetails r100) {
            this.details = r100;
            return this;
        }

        public Builder display_message(String r100) {
            this.display_message = r100;
            return this;
        }

        public Builder display_title(String r100) {
            this.display_title = r100;
            return this;
        }

        public Builder extra(ByteString r100) {
            this.extra = r100;
            return this;
        }

        public Builder server_message(String r100) {
            this.server_message = r100;
            return this;
        }

        public Builder status(Integer r100) {
            this.status = r100;
            return this;
        }
    }

    public static final class ErrorDetails extends com.squareup.wire.Message<ErrorDetails, Builder> {
        public static final ProtoAdapter<ErrorDetails> ADAPTER = null;
        public static final String DEFAULT_DEBUG_MESSAGE = "";
        public static final String DEFAULT_SERVER_REQUEST_ID = "";
        public static final String DEFAULT_X_TT_LOGID = "";
        public static final FieldOptions FIELD_OPTIONS_DEBUG_MESSAGE = null;
        public static final FieldOptions FIELD_OPTIONS_SERVER_REQUEST_ID = null;
        public static final FieldOptions FIELD_OPTIONS_X_TT_LOGID = null;
        private static final long serialVersionUID = 0;
        public final String debug_message;
        public final List<HttpHeader> headers;
        public final String server_request_id;
        public final String x_tt_logid;

        public static final class Builder extends com.squareup.wire.Message.Builder<ErrorDetails, Builder> {
            public String debug_message;
            public List<HttpHeader> headers;
            public String server_request_id;
            public String x_tt_logid;

            @Override // com.squareup.wire.Message.Builder
            public ErrorDetails build() {
                return new ErrorDetails(this.debug_message, this.server_request_id, this.x_tt_logid, this.headers, super.buildUnknownFields());
            }

            public Builder() {
                this.headers = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder debug_message(String r100) {
                this.debug_message = r100;
                return this;
            }

            public Builder headers(List<HttpHeader> r100) {
                Internal.checkElementsNotNull(r100);
                this.headers = r100;
                return this;
            }

            public Builder server_request_id(String r100) {
                this.server_request_id = r100;
                return this;
            }

            public Builder x_tt_logid(String r100) {
                this.x_tt_logid = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ErrorDetails extends ProtoAdapter<ErrorDetails> {
            public ProtoAdapter_ErrorDetails() {
                super(FieldEncoding.LENGTH_DELIMITED, ErrorDetails.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ErrorDetails decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.debug_message = "";
                r101.server_request_id = "";
                r101.x_tt_logid = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.debug_message = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.server_request_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.x_tt_logid = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.headers.add(HttpHeader.ADAPTER.decode(r100));
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
            public int encodedSize2(ErrorDetails r100) {
                String r101 = r100.debug_message;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.server_request_id;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.x_tt_logid;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                return ((r106 + r102) + HttpHeader.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.headers)) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ErrorDetails decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ErrorDetails r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ErrorDetails r101) throws IOException {
                String r102 = r101.debug_message;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.server_request_id;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.x_tt_logid;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                HttpHeader.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.headers);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ErrorDetails r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ErrorDetails();
            FIELD_OPTIONS_DEBUG_MESSAGE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_SERVER_REQUEST_ID = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_X_TT_LOGID = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.debug_message = this.debug_message;
            r100.server_request_id = this.server_request_id;
            r100.x_tt_logid = this.x_tt_logid;
            r100.headers = Internal.copyOf("headers", this.headers);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ErrorDetails.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ErrorDetails(String r100, String r101, String r102, List<HttpHeader> r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public ErrorDetails(String r100, String r101, String r102, List<HttpHeader> r103, ByteString r104) {
            super(ADAPTER, r104);
            this.debug_message = r100;
            this.server_request_id = r101;
            this.x_tt_logid = r102;
            this.headers = Internal.immutableCopyOf("headers", r103);
        }
    }

    public static final class ProtoAdapter_LarkError extends ProtoAdapter<LarkError> implements c<LarkError> {
        public ProtoAdapter_LarkError() {
            super(FieldEncoding.LENGTH_DELIMITED, LarkError.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public LarkError decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.status = 0;
            r101.code = 0;
            r101.display_message = "";
            r101.display_title = "";
            r101.server_message = "";
            r101.extra = ByteString.EMPTY;
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
            r101.extra = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L8:
            r101.server_message = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.display_title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.display_message = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.details = ErrorDetails.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.code = ProtoAdapter.INT32.decode(r100);
            goto L3
        L13:
            r101.status = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(LarkError r100) {
            Integer r101 = r100.status;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.code;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ErrorDetails r107 = r100.details;
            if (r107 == null) goto L13;
            int r108 = ErrorDetails.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.display_message;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.display_title;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.server_message;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            ByteString r119 = r100.extra;
            if (r119 == null) goto L30;
            r102 = ProtoAdapter.BYTES.encodedSizeWithTag(7, r119);
        L30:
            return (r118 + r102) + r100.unknownFields().size();
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
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
        public /* bridge */ /* synthetic */ LarkError decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LarkError r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LarkError r101) throws IOException {
            Integer r102 = r101.status;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.code;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            ErrorDetails r104 = r101.details;
            if (r104 == null) goto L11;
            ErrorDetails.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.display_message;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.display_title;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.server_message;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            ByteString r108 = r101.extra;
            if (r108 == null) goto L23;
            ProtoAdapter.BYTES.encodeWithTag(r100, 7, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LarkError r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_LarkError r100 = new ProtoAdapter_LarkError();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        FIELD_OPTIONS_STATUS = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_CODE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_DETAILS = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_STATUS = 0;
        DEFAULT_CODE = 0;
        DEFAULT_EXTRA = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.status = this.status;
        r100.code = this.code;
        r100.details = this.details;
        r100.display_message = this.display_message;
        r100.display_title = this.display_title;
        r100.server_message = this.server_message;
        r100.extra = this.extra;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LarkError.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public LarkError(Integer r110, Integer r111, ErrorDetails r112, String r113, String r114, String r115, ByteString r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public LarkError(Integer r100, Integer r101, ErrorDetails r102, String r103, String r104, String r105, ByteString r106, ByteString r107) {
        super(ADAPTER, r107);
        this.status = r100;
        this.code = r101;
        this.details = r102;
        this.display_message = r103;
        this.display_title = r104;
        this.server_message = r105;
        this.extra = r106;
    }
}
