package com.bytedance.lark.pb.tool.v1;

import com.obric.miniapp.alarm.AccountType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class OnFetchResponse extends Message<OnFetchResponse, Builder> {
    public static final ProtoAdapter<OnFetchResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final OnBodyResponse body_response;
    public final OnCancelResponse cancel_response;
    public final OnErrorResponse error_response;
    public final OnHeaderResponse header_response;
    public final OnProgressResponse progress_response;
    public final OnSuccessResponse success_response;

    public static final class Builder extends Message.Builder<OnFetchResponse, Builder> {
        public OnBodyResponse body_response;
        public OnCancelResponse cancel_response;
        public OnErrorResponse error_response;
        public OnHeaderResponse header_response;
        public OnProgressResponse progress_response;
        public OnSuccessResponse success_response;

        @Override // com.squareup.wire.Message.Builder
        public OnFetchResponse build() {
            return new OnFetchResponse(this.header_response, this.body_response, this.error_response, this.success_response, this.cancel_response, this.progress_response, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder body_response(OnBodyResponse r100) {
            this.body_response = r100;
            this.header_response = null;
            this.error_response = null;
            this.success_response = null;
            this.cancel_response = null;
            this.progress_response = null;
            return this;
        }

        public Builder cancel_response(OnCancelResponse r100) {
            this.cancel_response = r100;
            this.header_response = null;
            this.body_response = null;
            this.error_response = null;
            this.success_response = null;
            this.progress_response = null;
            return this;
        }

        public Builder error_response(OnErrorResponse r100) {
            this.error_response = r100;
            this.header_response = null;
            this.body_response = null;
            this.success_response = null;
            this.cancel_response = null;
            this.progress_response = null;
            return this;
        }

        public Builder header_response(OnHeaderResponse r100) {
            this.header_response = r100;
            this.body_response = null;
            this.error_response = null;
            this.success_response = null;
            this.cancel_response = null;
            this.progress_response = null;
            return this;
        }

        public Builder progress_response(OnProgressResponse r100) {
            this.progress_response = r100;
            this.header_response = null;
            this.body_response = null;
            this.error_response = null;
            this.success_response = null;
            this.cancel_response = null;
            return this;
        }

        public Builder success_response(OnSuccessResponse r100) {
            this.success_response = r100;
            this.header_response = null;
            this.body_response = null;
            this.error_response = null;
            this.cancel_response = null;
            this.progress_response = null;
            return this;
        }
    }

    public static final class OnBodyResponse extends Message<OnBodyResponse, Builder> {
        public static final ProtoAdapter<OnBodyResponse> ADAPTER = null;
        public static final ByteString DEFAULT_BODY = null;
        private static final long serialVersionUID = 0;
        public final ByteString body;

        public static final class Builder extends Message.Builder<OnBodyResponse, Builder> {
            public ByteString body;

            @Override // com.squareup.wire.Message.Builder
            public OnBodyResponse build() {
                return new OnBodyResponse(this.body, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder body(ByteString r100) {
                this.body = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_OnBodyResponse extends ProtoAdapter<OnBodyResponse> {
            public ProtoAdapter_OnBodyResponse() {
                super(FieldEncoding.LENGTH_DELIMITED, OnBodyResponse.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public OnBodyResponse decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.body = ByteString.EMPTY;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.body = ProtoAdapter.BYTES.decode(r100);
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(OnBodyResponse r100) {
                ByteString r101 = r100.body;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.BYTES.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ OnBodyResponse decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(OnBodyResponse r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, OnBodyResponse r101) throws IOException {
                ByteString r102 = r101.body;
                if (r102 == null) goto L5;
                ProtoAdapter.BYTES.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OnBodyResponse r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OnBodyResponse();
            DEFAULT_BODY = ByteString.EMPTY;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.body = this.body;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return OnBodyResponse.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public OnBodyResponse(ByteString r100) {
            this(r100, ByteString.EMPTY);
        }

        public OnBodyResponse(ByteString r100, ByteString r101) {
            super(ADAPTER, r101);
            this.body = r100;
        }
    }

    public static final class OnCancelResponse extends Message<OnCancelResponse, Builder> {
        public static final ProtoAdapter<OnCancelResponse> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends Message.Builder<OnCancelResponse, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public OnCancelResponse build() {
                return new OnCancelResponse(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_OnCancelResponse extends ProtoAdapter<OnCancelResponse> {
            public ProtoAdapter_OnCancelResponse() {
                super(FieldEncoding.LENGTH_DELIMITED, OnCancelResponse.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public OnCancelResponse decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(OnCancelResponse r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ OnCancelResponse decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(OnCancelResponse r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, OnCancelResponse r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OnCancelResponse r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OnCancelResponse();
        }

        public OnCancelResponse() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return OnCancelResponse.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public OnCancelResponse(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class OnErrorResponse extends Message<OnErrorResponse, Builder> {
        public static final ProtoAdapter<OnErrorResponse> ADAPTER = null;
        public static final Code DEFAULT_CODE = null;
        public static final Integer DEFAULT_LARK_ERROR_CODE = null;
        public static final Integer DEFAULT_LARK_ERROR_STATUS = null;
        public static final String DEFAULT_MESSAGE = "";
        private static final long serialVersionUID = 0;
        public final Code code;
        public final Integer lark_error_code;
        public final Integer lark_error_status;
        public final String message;
        public final StageCost stage_cost;

        public static final class Builder extends Message.Builder<OnErrorResponse, Builder> {
            public Code code;
            public Integer lark_error_code;
            public Integer lark_error_status;
            public String message;
            public StageCost stage_cost;

            @Override // com.squareup.wire.Message.Builder
            public OnErrorResponse build() {
                return new OnErrorResponse(this.code, this.message, this.stage_cost, this.lark_error_code, this.lark_error_status, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder code(Code r100) {
                this.code = r100;
                return this;
            }

            public Builder lark_error_code(Integer r100) {
                this.lark_error_code = r100;
                return this;
            }

            public Builder lark_error_status(Integer r100) {
                this.lark_error_status = r100;
                return this;
            }

            public Builder message(String r100) {
                this.message = r100;
                return this;
            }

            public Builder stage_cost(StageCost r100) {
                this.stage_cost = r100;
                return this;
            }
        }

        public static final enum Code extends Enum<Code> implements WireEnum {
            private static final /* synthetic */ Code[] $VALUES = null;
            public static final ProtoAdapter<Code> ADAPTER = null;
            public static final Code IO = null;
            public static final Code OFFLINE = null;
            public static final Code OTHERS = null;
            public static final Code SDK = null;
            public static final Code TIMEOUT = null;
            private final int value;

            static {
                Code r100 = new Code("TIMEOUT", 0, 1);
                TIMEOUT = r100;
                Code r101 = new Code(AccountType.OTHERS, 1, 2);
                OTHERS = r101;
                Code r102 = new Code("SDK", 2, 3);
                SDK = r102;
                Code r103 = new Code("OFFLINE", 3, 4);
                OFFLINE = r103;
                Code r104 = new Code("IO", 4, 5);
                IO = r104;
                $VALUES = new Code[]{r100, r101, r102, r103, r104};
                ADAPTER = ProtoAdapter.newEnumAdapter(Code.class);
            }

            public static Code[] values() {
                return (Code[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Code fromValue(int r100) {
                if (r100 == 1) goto L23;
                if (r100 == 2) goto L21;
                if (r100 == 3) goto L19;
                if (r100 == 4) goto L17;
                if (r100 == 5) goto L15;
                return null;
            L15:
                return IO;
            L17:
                return OFFLINE;
            L19:
                return SDK;
            L21:
                return OTHERS;
            L23:
                return TIMEOUT;
            }

            public static Code valueOf(String r100) {
                return (Code) a.a(Code.class, r100);
            }

            private Code(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_OnErrorResponse extends ProtoAdapter<OnErrorResponse> {
            public ProtoAdapter_OnErrorResponse() {
                super(FieldEncoding.LENGTH_DELIMITED, OnErrorResponse.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public OnErrorResponse decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.code = Code.TIMEOUT;
                r101.message = "";
                r101.lark_error_code = 0;
                r101.lark_error_status = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L24;
                if (r103 != 1) goto L8;
                r101.code = Code.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.message = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.stage_cost = StageCost.ADAPTER.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.lark_error_code = ProtoAdapter.INT32.decode(r100);
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.lark_error_status = ProtoAdapter.INT32.decode(r100);
                goto L3
            L15:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L24:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(OnErrorResponse r100) {
                Code r101 = r100.code;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Code.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.message;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                StageCost r107 = r100.stage_cost;
                if (r107 == null) goto L13;
                int r108 = StageCost.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Integer r110 = r100.lark_error_code;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.INT32.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Integer r113 = r100.lark_error_status;
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
            public /* bridge */ /* synthetic */ OnErrorResponse decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(OnErrorResponse r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, OnErrorResponse r101) throws IOException {
                Code r102 = r101.code;
                if (r102 == null) goto L5;
                Code.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.message;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                StageCost r104 = r101.stage_cost;
                if (r104 == null) goto L11;
                StageCost.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                Integer r105 = r101.lark_error_code;
                if (r105 == null) goto L14;
                ProtoAdapter.INT32.encodeWithTag(r100, 4, r105);
            L14:
                Integer r106 = r101.lark_error_status;
                if (r106 == null) goto L17;
                ProtoAdapter.INT32.encodeWithTag(r100, 5, r106);
            L17:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OnErrorResponse r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OnErrorResponse();
            DEFAULT_CODE = Code.TIMEOUT;
            DEFAULT_LARK_ERROR_CODE = 0;
            DEFAULT_LARK_ERROR_STATUS = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.code = this.code;
            r100.message = this.message;
            r100.stage_cost = this.stage_cost;
            r100.lark_error_code = this.lark_error_code;
            r100.lark_error_status = this.lark_error_status;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return OnErrorResponse.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public OnErrorResponse(Code r100, String r101, StageCost r110, Integer r111, Integer r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public OnErrorResponse(Code r100, String r101, StageCost r102, Integer r103, Integer r104, ByteString r105) {
            super(ADAPTER, r105);
            this.code = r100;
            this.message = r101;
            this.stage_cost = r102;
            this.lark_error_code = r103;
            this.lark_error_status = r104;
        }
    }

    public static final class OnHeaderResponse extends Message<OnHeaderResponse, Builder> {
        public static final ProtoAdapter<OnHeaderResponse> ADAPTER = null;
        public static final Protocol DEFAULT_PROTOCOL = null;
        public static final Integer DEFAULT_STATUS_CODE = null;
        private static final long serialVersionUID = 0;
        public final List<HttpHeader> headers;
        public final Protocol protocol;
        public final Integer status_code;

        public static final class Builder extends Message.Builder<OnHeaderResponse, Builder> {
            public List<HttpHeader> headers;
            public Protocol protocol;
            public Integer status_code;

            @Override // com.squareup.wire.Message.Builder
            public OnHeaderResponse build() {
                return new OnHeaderResponse(this.headers, this.status_code, this.protocol, super.buildUnknownFields());
            }

            public Builder() {
                this.headers = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder headers(List<HttpHeader> r100) {
                Internal.checkElementsNotNull(r100);
                this.headers = r100;
                return this;
            }

            public Builder protocol(Protocol r100) {
                this.protocol = r100;
                return this;
            }

            public Builder status_code(Integer r100) {
                this.status_code = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_OnHeaderResponse extends ProtoAdapter<OnHeaderResponse> {
            public ProtoAdapter_OnHeaderResponse() {
                super(FieldEncoding.LENGTH_DELIMITED, OnHeaderResponse.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public OnHeaderResponse decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.status_code = 0;
                r101.protocol = Protocol.UNKNOWN;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.headers.add(HttpHeader.ADAPTER.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.status_code = ProtoAdapter.INT32.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.protocol = Protocol.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(OnHeaderResponse r100) {
                int r101 = HttpHeader.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.headers);
                Integer r102 = r100.status_code;
                int r103 = 0;
                if (r102 == null) goto L5;
                int r104 = ProtoAdapter.INT32.encodedSizeWithTag(2, r102);
            L6:
                int r105 = r101 + r104;
                Protocol r106 = r100.protocol;
                if (r106 == null) goto L10;
                r103 = Protocol.ADAPTER.encodedSizeWithTag(3, r106);
            L10:
                return (r105 + r103) + r100.unknownFields().size();
            L5:
                r104 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ OnHeaderResponse decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(OnHeaderResponse r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, OnHeaderResponse r101) throws IOException {
                HttpHeader.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.headers);
                Integer r102 = r101.status_code;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r102);
            L5:
                Protocol r103 = r101.protocol;
                if (r103 == null) goto L8;
                Protocol.ADAPTER.encodeWithTag(r100, 3, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OnHeaderResponse r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Protocol extends Enum<Protocol> implements WireEnum {
            private static final /* synthetic */ Protocol[] $VALUES = null;
            public static final ProtoAdapter<Protocol> ADAPTER = null;
            public static final Protocol HTTP_1_1 = null;
            public static final Protocol HTTP_2 = null;
            public static final Protocol QUIC = null;
            public static final Protocol UNKNOWN = null;
            private final int value;

            static {
                Protocol r100 = new Protocol("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Protocol r101 = new Protocol("HTTP_1_1", 1, 1);
                HTTP_1_1 = r101;
                Protocol r102 = new Protocol("HTTP_2", 2, 2);
                HTTP_2 = r102;
                Protocol r103 = new Protocol("QUIC", 3, 3);
                QUIC = r103;
                $VALUES = new Protocol[]{r100, r101, r102, r103};
                ADAPTER = ProtoAdapter.newEnumAdapter(Protocol.class);
            }

            public static Protocol[] values() {
                return (Protocol[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Protocol fromValue(int r100) {
                if (r100 == 0) goto L18;
                if (r100 == 1) goto L16;
                if (r100 == 2) goto L14;
                if (r100 == 3) goto L12;
                return null;
            L12:
                return QUIC;
            L14:
                return HTTP_2;
            L16:
                return HTTP_1_1;
            L18:
                return UNKNOWN;
            }

            public static Protocol valueOf(String r100) {
                return (Protocol) a.a(Protocol.class, r100);
            }

            private Protocol(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OnHeaderResponse();
            DEFAULT_STATUS_CODE = 0;
            DEFAULT_PROTOCOL = Protocol.UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.headers = Internal.copyOf("headers", this.headers);
            r100.status_code = this.status_code;
            r100.protocol = this.protocol;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return OnHeaderResponse.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public OnHeaderResponse(List<HttpHeader> r100, Integer r101, Protocol r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public OnHeaderResponse(List<HttpHeader> r100, Integer r101, Protocol r102, ByteString r103) {
            super(ADAPTER, r103);
            this.headers = Internal.immutableCopyOf("headers", r100);
            this.status_code = r101;
            this.protocol = r102;
        }
    }

    public static final class OnProgressResponse extends Message<OnProgressResponse, Builder> {
        public static final ProtoAdapter<OnProgressResponse> ADAPTER = null;
        public static final Integer DEFAULT_CONTENT_LENGTH = null;
        public static final Integer DEFAULT_RECV_LENGTH = null;
        private static final long serialVersionUID = 0;
        public final Integer content_length;
        public final Integer recv_length;

        public static final class Builder extends Message.Builder<OnProgressResponse, Builder> {
            public Integer content_length;
            public Integer recv_length;

            @Override // com.squareup.wire.Message.Builder
            public OnProgressResponse build() {
                return new OnProgressResponse(this.recv_length, this.content_length, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder content_length(Integer r100) {
                this.content_length = r100;
                return this;
            }

            public Builder recv_length(Integer r100) {
                this.recv_length = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_OnProgressResponse extends ProtoAdapter<OnProgressResponse> {
            public ProtoAdapter_OnProgressResponse() {
                super(FieldEncoding.LENGTH_DELIMITED, OnProgressResponse.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public OnProgressResponse decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.recv_length = 0;
                r101.content_length = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.recv_length = ProtoAdapter.INT32.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.content_length = ProtoAdapter.INT32.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(OnProgressResponse r100) {
                Integer r101 = r100.recv_length;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.content_length;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ OnProgressResponse decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(OnProgressResponse r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, OnProgressResponse r101) throws IOException {
                Integer r102 = r101.recv_length;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.content_length;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OnProgressResponse r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OnProgressResponse();
            DEFAULT_RECV_LENGTH = 0;
            DEFAULT_CONTENT_LENGTH = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.recv_length = this.recv_length;
            r100.content_length = this.content_length;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return OnProgressResponse.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public OnProgressResponse(Integer r100, Integer r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public OnProgressResponse(Integer r100, Integer r101, ByteString r102) {
            super(ADAPTER, r102);
            this.recv_length = r100;
            this.content_length = r101;
        }
    }

    public static final class OnSuccessResponse extends Message<OnSuccessResponse, Builder> {
        public static final ProtoAdapter<OnSuccessResponse> ADAPTER = null;
        public static final String DEFAULT_PEER_ADDR = "";
        private static final long serialVersionUID = 0;
        public final String peer_addr;
        public final StageCost stage_cost;

        public static final class Builder extends Message.Builder<OnSuccessResponse, Builder> {
            public String peer_addr;
            public StageCost stage_cost;

            @Override // com.squareup.wire.Message.Builder
            public OnSuccessResponse build() {
                return new OnSuccessResponse(this.stage_cost, this.peer_addr, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder peer_addr(String r100) {
                this.peer_addr = r100;
                return this;
            }

            public Builder stage_cost(StageCost r100) {
                this.stage_cost = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_OnSuccessResponse extends ProtoAdapter<OnSuccessResponse> {
            public ProtoAdapter_OnSuccessResponse() {
                super(FieldEncoding.LENGTH_DELIMITED, OnSuccessResponse.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public OnSuccessResponse decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.peer_addr = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.stage_cost = StageCost.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.peer_addr = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(OnSuccessResponse r100) {
                StageCost r101 = r100.stage_cost;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = StageCost.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.peer_addr;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ OnSuccessResponse decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(OnSuccessResponse r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, OnSuccessResponse r101) throws IOException {
                StageCost r102 = r101.stage_cost;
                if (r102 == null) goto L5;
                StageCost.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.peer_addr;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OnSuccessResponse r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OnSuccessResponse();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.stage_cost = this.stage_cost;
            r100.peer_addr = this.peer_addr;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return OnSuccessResponse.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public OnSuccessResponse(StageCost r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public OnSuccessResponse(StageCost r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.stage_cost = r100;
            this.peer_addr = r101;
        }
    }

    public static final class ProtoAdapter_OnFetchResponse extends ProtoAdapter<OnFetchResponse> {
        public ProtoAdapter_OnFetchResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, OnFetchResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OnFetchResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L13;
            switch(r103) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.progress_response(OnProgressResponse.ADAPTER.decode(r100));
            goto L3
        L8:
            r101.cancel_response(OnCancelResponse.ADAPTER.decode(r100));
            goto L3
        L9:
            r101.success_response(OnSuccessResponse.ADAPTER.decode(r100));
            goto L3
        L10:
            r101.error_response(OnErrorResponse.ADAPTER.decode(r100));
            goto L3
        L11:
            r101.body_response(OnBodyResponse.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.header_response(OnHeaderResponse.ADAPTER.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(OnFetchResponse r100) {
            OnHeaderResponse r101 = r100.header_response;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = OnHeaderResponse.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            OnBodyResponse r104 = r100.body_response;
            if (r104 == null) goto L9;
            int r105 = OnBodyResponse.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            OnErrorResponse r107 = r100.error_response;
            if (r107 == null) goto L13;
            int r108 = OnErrorResponse.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            OnSuccessResponse r110 = r100.success_response;
            if (r110 == null) goto L17;
            int r111 = OnSuccessResponse.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            OnCancelResponse r113 = r100.cancel_response;
            if (r113 == null) goto L21;
            int r114 = OnCancelResponse.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            OnProgressResponse r116 = r100.progress_response;
            if (r116 == null) goto L26;
            r102 = OnProgressResponse.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ OnFetchResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OnFetchResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OnFetchResponse r101) throws IOException {
            OnHeaderResponse r102 = r101.header_response;
            if (r102 == null) goto L5;
            OnHeaderResponse.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            OnBodyResponse r103 = r101.body_response;
            if (r103 == null) goto L8;
            OnBodyResponse.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            OnErrorResponse r104 = r101.error_response;
            if (r104 == null) goto L11;
            OnErrorResponse.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            OnSuccessResponse r105 = r101.success_response;
            if (r105 == null) goto L14;
            OnSuccessResponse.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            OnCancelResponse r106 = r101.cancel_response;
            if (r106 == null) goto L17;
            OnCancelResponse.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            OnProgressResponse r107 = r101.progress_response;
            if (r107 == null) goto L20;
            OnProgressResponse.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OnFetchResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class StageCost extends Message<StageCost, Builder> {
        public static final ProtoAdapter<StageCost> ADAPTER = null;
        public static final Integer DEFAULT_DNS_COST = null;
        public static final Integer DEFAULT_TCP_CONNECT_COST = null;
        public static final Integer DEFAULT_TLS_COST = null;
        private static final long serialVersionUID = 0;
        public final Integer dns_cost;
        public final Integer tcp_connect_cost;
        public final Integer tls_cost;

        public static final class Builder extends Message.Builder<StageCost, Builder> {
            public Integer dns_cost;
            public Integer tcp_connect_cost;
            public Integer tls_cost;

            @Override // com.squareup.wire.Message.Builder
            public StageCost build() {
                return new StageCost(this.dns_cost, this.tcp_connect_cost, this.tls_cost, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder dns_cost(Integer r100) {
                this.dns_cost = r100;
                return this;
            }

            public Builder tcp_connect_cost(Integer r100) {
                this.tcp_connect_cost = r100;
                return this;
            }

            public Builder tls_cost(Integer r100) {
                this.tls_cost = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_StageCost extends ProtoAdapter<StageCost> {
            public ProtoAdapter_StageCost() {
                super(FieldEncoding.LENGTH_DELIMITED, StageCost.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public StageCost decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.dns_cost = 0;
                r101.tcp_connect_cost = 0;
                r101.tls_cost = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.dns_cost = ProtoAdapter.INT32.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.tcp_connect_cost = ProtoAdapter.INT32.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.tls_cost = ProtoAdapter.INT32.decode(r100);
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(StageCost r100) {
                Integer r101 = r100.dns_cost;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.tcp_connect_cost;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Integer r107 = r100.tls_cost;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
            L14:
                return (r106 + r102) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ StageCost decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(StageCost r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, StageCost r101) throws IOException {
                Integer r102 = r101.dns_cost;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.tcp_connect_cost;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                Integer r104 = r101.tls_cost;
                if (r104 == null) goto L11;
                ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, StageCost r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_StageCost();
            DEFAULT_DNS_COST = 0;
            DEFAULT_TCP_CONNECT_COST = 0;
            DEFAULT_TLS_COST = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.dns_cost = this.dns_cost;
            r100.tcp_connect_cost = this.tcp_connect_cost;
            r100.tls_cost = this.tls_cost;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return StageCost.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public StageCost(Integer r100, Integer r101, Integer r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public StageCost(Integer r100, Integer r101, Integer r102, ByteString r103) {
            super(ADAPTER, r103);
            this.dns_cost = r100;
            this.tcp_connect_cost = r101;
            this.tls_cost = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OnFetchResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.header_response = this.header_response;
        r100.body_response = this.body_response;
        r100.error_response = this.error_response;
        r100.success_response = this.success_response;
        r100.cancel_response = this.cancel_response;
        r100.progress_response = this.progress_response;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OnFetchResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OnFetchResponse(OnHeaderResponse r100, OnBodyResponse r110, OnErrorResponse r111, OnSuccessResponse r112, OnCancelResponse r113, OnProgressResponse r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public OnFetchResponse(OnHeaderResponse r100, OnBodyResponse r101, OnErrorResponse r102, OnSuccessResponse r103, OnCancelResponse r104, OnProgressResponse r105, ByteString r106) {
        super(ADAPTER, r106);
        if (Internal.countNonNull(r100, r101, r102, r103, new Object[]{r104, r105}) > 1) goto L7;
        this.header_response = r100;
        this.body_response = r101;
        this.error_response = r102;
        this.success_response = r103;
        this.cancel_response = r104;
        this.progress_response = r105;
        return;
    L7:
        throw new IllegalArgumentException("at most one of header_response, body_response, error_response, success_response, cancel_response, progress_response may be non-null");
    }
}
