package com.bytedance.lark.pb.im.v2;

import com.alipay.sdk.m.p.e;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PutActionResponse extends Message<PutActionResponse, Builder> {
    public static final ProtoAdapter<PutActionResponse> ADAPTER = null;
    public static final String DEFAULT_APP_CLI_ID = "";
    public static final Method DEFAULT_METHOD = null;
    public static final ProtoAdapter_PutActionResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String app_cli_id;
    public final Method method;
    public final Map<String, Long> time_cost;
    public final Map<String, Long> timestamp_detail;
    public final Toast toast;

    public static final class Builder extends Message.Builder<PutActionResponse, Builder> implements d<PutActionResponse> {
        public String app_cli_id;
        public Method method;
        public Map<String, Long> time_cost;
        public Map<String, Long> timestamp_detail;
        public Toast toast;

        @Override // com.squareup.wire.Message.Builder
        public PutActionResponse build() {
            Method r100 = this.method;
            if (r100 == null) goto L7;
            return new PutActionResponse(this.method, this.toast, this.timestamp_detail, this.time_cost, this.app_cli_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, e.f25671s});
        }

        public Builder() {
            this.timestamp_detail = Internal.newMutableMap();
            this.time_cost = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_cli_id(String r100) {
            this.app_cli_id = r100;
            return this;
        }

        public Builder method(Method r100) {
            this.method = r100;
            return this;
        }

        public Builder time_cost(Map<String, Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.time_cost = r100;
            return this;
        }

        public Builder timestamp_detail(Map<String, Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.timestamp_detail = r100;
            return this;
        }

        public Builder toast(Toast r100) {
            this.toast = r100;
            return this;
        }
    }

    public static final enum Method extends Enum<Method> implements WireEnum {
        private static final /* synthetic */ Method[] $VALUES = null;
        public static final ProtoAdapter<Method> ADAPTER = null;
        public static final Method NONE = null;
        public static final Method TOAST = null;
        private final int value;

        static {
            Method r100 = new Method(UserProfileEvent.POSITION_NONE, 0, 1);
            NONE = r100;
            Method r101 = new Method("TOAST", 1, 2);
            TOAST = r101;
            $VALUES = new Method[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(Method.class);
        }

        public static Method[] values() {
            return (Method[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Method fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return TOAST;
        L11:
            return NONE;
        }

        public static Method valueOf(String r100) {
            return (Method) a.a(Method.class, r100);
        }

        private Method(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_PutActionResponse extends ProtoAdapter<PutActionResponse> implements c<PutActionResponse> {
        private final ProtoAdapter<Map<String, Long>> time_cost;
        private final ProtoAdapter<Map<String, Long>> timestamp_detail;

        public ProtoAdapter_PutActionResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PutActionResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
            this.timestamp_detail = ProtoAdapter.newMapAdapter(r100, r101);
            this.time_cost = ProtoAdapter.newMapAdapter(r100, r101);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutActionResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.method = Method.NONE;
            r101.app_cli_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.method = Method.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.toast = Toast.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.timestamp_detail.putAll(this.timestamp_detail.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.time_cost.putAll(this.time_cost.decode(r100));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.app_cli_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(PutActionResponse r100) {
            int r101 = Method.ADAPTER.encodedSizeWithTag(1, r100.method);
            Toast r102 = r100.toast;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = Toast.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = ((r101 + r104) + this.timestamp_detail.encodedSizeWithTag(3, r100.timestamp_detail)) + this.time_cost.encodedSizeWithTag(4, r100.time_cost);
            String r106 = r100.app_cli_id;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.STRING.encodedSizeWithTag(5, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PutActionResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutActionResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutActionResponse r101) throws IOException {
            Method.ADAPTER.encodeWithTag(r100, 1, r101.method);
            Toast r102 = r101.toast;
            if (r102 == null) goto L5;
            Toast.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            this.timestamp_detail.encodeWithTag(r100, 3, r101.timestamp_detail);
            this.time_cost.encodeWithTag(r100, 4, r101.time_cost);
            String r103 = r101.app_cli_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutActionResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class Toast extends Message<Toast, Builder> {
        public static final ProtoAdapter<Toast> ADAPTER = null;
        public static final Integer DEFAULT_CODE = null;
        public static final String DEFAULT_CONTENT = "";
        public static final Integer DEFAULT_ERROR_CODE = null;
        private static final long serialVersionUID = 0;
        public final Integer code;
        public final String content;
        public final Integer error_code;

        public static final class Builder extends Message.Builder<Toast, Builder> {
            public Integer code;
            public String content;
            public Integer error_code;

            @Override // com.squareup.wire.Message.Builder
            public Toast build() {
                return new Toast(this.code, this.content, this.error_code, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder code(Integer r100) {
                this.code = r100;
                return this;
            }

            public Builder content(String r100) {
                this.content = r100;
                return this;
            }

            public Builder error_code(Integer r100) {
                this.error_code = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Toast extends ProtoAdapter<Toast> {
            public ProtoAdapter_Toast() {
                super(FieldEncoding.LENGTH_DELIMITED, Toast.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Toast decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.code = 0;
                r101.content = "";
                r101.error_code = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.code = ProtoAdapter.INT32.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.content = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.error_code = ProtoAdapter.INT32.decode(r100);
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
            public int encodedSize2(Toast r100) {
                Integer r101 = r100.code;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.content;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Integer r107 = r100.error_code;
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
            public /* bridge */ /* synthetic */ Toast decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Toast r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Toast r101) throws IOException {
                Integer r102 = r101.code;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.content;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                Integer r104 = r101.error_code;
                if (r104 == null) goto L11;
                ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Toast r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Toast();
            DEFAULT_CODE = 0;
            DEFAULT_ERROR_CODE = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.code = this.code;
            r100.content = this.content;
            r100.error_code = this.error_code;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Toast.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Toast(Integer r100, String r101, Integer r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public Toast(Integer r100, String r101, Integer r102, ByteString r103) {
            super(ADAPTER, r103);
            this.code = r100;
            this.content = r101;
            this.error_code = r102;
        }
    }

    static {
        ProtoAdapter_PutActionResponse r100 = new ProtoAdapter_PutActionResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_METHOD = Method.NONE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.method = this.method;
        r100.toast = this.toast;
        r100.timestamp_detail = Internal.copyOf("timestamp_detail", this.timestamp_detail);
        r100.time_cost = Internal.copyOf("time_cost", this.time_cost);
        r100.app_cli_id = this.app_cli_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PutActionResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutActionResponse(Method r100, Toast r101, Map<String, Long> r110, Map<String, Long> r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public PutActionResponse(Method r100, Toast r101, Map<String, Long> r102, Map<String, Long> r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.method = r100;
        this.toast = r101;
        this.timestamp_detail = Internal.immutableCopyOf("timestamp_detail", r102);
        this.time_cost = Internal.immutableCopyOf("time_cost", r103);
        this.app_cli_id = r104;
    }
}
