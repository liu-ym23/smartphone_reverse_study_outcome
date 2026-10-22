package com.bytedance.lark.pb.basic.v1;

import com.alipay.sdk.m.p.e;
import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class SendHttpRequest extends com.squareup.wire.Message<SendHttpRequest, Builder> {
    public static final ProtoAdapter<SendHttpRequest> ADAPTER = null;
    public static final ByteString DEFAULT_BODY = null;
    public static final String DEFAULT_DOWNLOAD_FILE_PATH = "";
    public static final Boolean DEFAULT_ENABLE_COMPLEX_CONNECT = null;
    public static final Boolean DEFAULT_ENABLE_START_UP_CONTROL = null;
    public static final HostAlias DEFAULT_HOST_ALIAS = null;
    public static final String DEFAULT_JSON_BODY = "";
    public static final Method DEFAULT_METHOD = null;
    public static final Boolean DEFAULT_NO_FOLLOW_REDIRECTION = null;
    public static final Priority DEFAULT_PRIORITY = null;
    public static final String DEFAULT_REQUEST_ID = "";
    public static final Integer DEFAULT_RETRY_NUM = null;
    public static final Integer DEFAULT_TIMEOUT = null;
    public static final String DEFAULT_UPLOAD_FILE_PATH = "";
    public static final String DEFAULT_URL = "";
    public static final ProtoAdapter_SendHttpRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ByteString body;
    public final String download_file_path;
    public final Boolean enable_complex_connect;
    public final Boolean enable_start_up_control;
    public final Map<String, String> headers;
    public final HostAlias host_alias;
    public final String json_body;
    public final Method method;
    public final Boolean no_follow_redirection;
    public final Priority priority;
    public final String request_id;
    public final Integer retry_num;
    public final Integer timeout;
    public final String upload_file_path;
    public final String url;

    public static final class Builder extends com.squareup.wire.Message.Builder<SendHttpRequest, Builder> implements b<SendHttpRequest> {
        public ByteString body;
        public String download_file_path;
        public Boolean enable_complex_connect;
        public Boolean enable_start_up_control;
        public Map<String, String> headers;
        public HostAlias host_alias;
        public String json_body;
        public Method method;
        public Boolean no_follow_redirection;
        public Priority priority;
        public String request_id;
        public Integer retry_num;
        public Integer timeout;
        public String upload_file_path;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public SendHttpRequest build() {
            String r100 = this.url;
            if (r100 == null) goto L9;
            if (this.method == null) goto L9;
            return new SendHttpRequest(this.url, this.method, this.headers, this.body, this.timeout, this.request_id, this.enable_complex_connect, this.retry_num, this.priority, this.download_file_path, this.upload_file_path, this.host_alias, this.enable_start_up_control, this.no_follow_redirection, this.json_body, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "url", this.method, e.f25671s});
        }

        public Builder() {
            this.headers = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder body(ByteString r100) {
            this.body = r100;
            return this;
        }

        public Builder download_file_path(String r100) {
            this.download_file_path = r100;
            return this;
        }

        public Builder enable_complex_connect(Boolean r100) {
            this.enable_complex_connect = r100;
            return this;
        }

        public Builder enable_start_up_control(Boolean r100) {
            this.enable_start_up_control = r100;
            return this;
        }

        public Builder headers(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.headers = r100;
            return this;
        }

        public Builder host_alias(HostAlias r100) {
            this.host_alias = r100;
            return this;
        }

        public Builder json_body(String r100) {
            this.json_body = r100;
            return this;
        }

        public Builder method(Method r100) {
            this.method = r100;
            return this;
        }

        public Builder no_follow_redirection(Boolean r100) {
            this.no_follow_redirection = r100;
            return this;
        }

        public Builder priority(Priority r100) {
            this.priority = r100;
            return this;
        }

        public Builder request_id(String r100) {
            this.request_id = r100;
            return this;
        }

        public Builder retry_num(Integer r100) {
            this.retry_num = r100;
            return this;
        }

        public Builder timeout(Integer r100) {
            this.timeout = r100;
            return this;
        }

        public Builder upload_file_path(String r100) {
            this.upload_file_path = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static final enum HostAlias extends Enum<HostAlias> implements WireEnum {
        private static final /* synthetic */ HostAlias[] $VALUES = null;
        public static final ProtoAdapter<HostAlias> ADAPTER = null;
        public static final HostAlias API = null;
        public static final HostAlias DOCS = null;
        public static final HostAlias DRIVE = null;
        public static final HostAlias FILE = null;
        public static final HostAlias MINA = null;
        public static final HostAlias OAPI = null;
        public static final HostAlias OPEN = null;
        public static final HostAlias UNKNOWN = null;
        private final int value;

        static {
            HostAlias r100 = new HostAlias("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            HostAlias r101 = new HostAlias("API", 1, 1);
            API = r101;
            HostAlias r102 = new HostAlias("FILE", 2, 2);
            FILE = r102;
            HostAlias r103 = new HostAlias(DocTabPayload.VALUE_OPAI, 3, 3);
            OAPI = r103;
            HostAlias r104 = new HostAlias("DRIVE", 4, 4);
            DRIVE = r104;
            HostAlias r105 = new HostAlias("DOCS", 5, 5);
            DOCS = r105;
            HostAlias r110 = new HostAlias("MINA", 6, 6);
            MINA = r110;
            HostAlias r111 = new HostAlias("OPEN", 7, 7);
            OPEN = r111;
            $VALUES = new HostAlias[]{r100, r101, r102, r103, r104, r105, r110, r111};
            ADAPTER = ProtoAdapter.newEnumAdapter(HostAlias.class);
        }

        public static HostAlias[] values() {
            return (HostAlias[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static HostAlias fromValue(int r100) {
            switch(r100) {
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return OPEN;
        L8:
            return MINA;
        L10:
            return DOCS;
        L12:
            return DRIVE;
        L14:
            return OAPI;
        L16:
            return FILE;
        L18:
            return API;
        L20:
            return UNKNOWN;
        }

        public static HostAlias valueOf(String r100) {
            return (HostAlias) a.a(HostAlias.class, r100);
        }

        private HostAlias(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Method extends Enum<Method> implements WireEnum {
        private static final /* synthetic */ Method[] $VALUES = null;
        public static final ProtoAdapter<Method> ADAPTER = null;
        public static final Method CONNECT = null;
        public static final Method DELETE = null;
        public static final Method GET = null;
        public static final Method HEAD = null;
        public static final Method OPTIONS = null;
        public static final Method PATCH = null;
        public static final Method POST = null;
        public static final Method PUT = null;
        public static final Method TRACE = null;
        private final int value;

        static {
            Method r100 = new Method("GET", 0, 1);
            GET = r100;
            Method r101 = new Method("POST", 1, 2);
            POST = r101;
            Method r102 = new Method("DELETE", 2, 3);
            DELETE = r102;
            Method r103 = new Method("PUT", 3, 4);
            PUT = r103;
            Method r104 = new Method("PATCH", 4, 5);
            PATCH = r104;
            Method r110 = new Method("HEAD", 5, 6);
            HEAD = r110;
            Method r111 = new Method(OpenNetMethod.CONNECT, 6, 7);
            CONNECT = r111;
            Method r112 = new Method("OPTIONS", 7, 8);
            OPTIONS = r112;
            Method r113 = new Method("TRACE", 8, 9);
            TRACE = r113;
            $VALUES = new Method[]{r100, r101, r102, r103, r104, r110, r111, r112, r113};
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
            switch(r100) {
                case 1: goto L22;
                case 2: goto L20;
                case 3: goto L18;
                case 4: goto L16;
                case 5: goto L14;
                case 6: goto L12;
                case 7: goto L10;
                case 8: goto L8;
                case 9: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return TRACE;
        L8:
            return OPTIONS;
        L10:
            return CONNECT;
        L12:
            return HEAD;
        L14:
            return PATCH;
        L16:
            return PUT;
        L18:
            return DELETE;
        L20:
            return POST;
        L22:
            return GET;
        }

        public static Method valueOf(String r100) {
            return (Method) a.a(Method.class, r100);
        }

        private Method(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Priority extends Enum<Priority> implements WireEnum {
        private static final /* synthetic */ Priority[] $VALUES = null;
        public static final ProtoAdapter<Priority> ADAPTER = null;
        public static final Priority HIGH = null;
        public static final Priority LOW = null;
        public static final Priority MEDIUM = null;
        private final int value;

        static {
            Priority r100 = new Priority("HIGH", 0, 1);
            HIGH = r100;
            Priority r101 = new Priority("MEDIUM", 1, 2);
            MEDIUM = r101;
            Priority r102 = new Priority("LOW", 2, 3);
            LOW = r102;
            $VALUES = new Priority[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Priority.class);
        }

        public static Priority[] values() {
            return (Priority[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Priority fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return LOW;
        L13:
            return MEDIUM;
        L15:
            return HIGH;
        }

        public static Priority valueOf(String r100) {
            return (Priority) a.a(Priority.class, r100);
        }

        private Priority(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_SendHttpRequest extends ProtoAdapter<SendHttpRequest> implements we6.a<SendHttpRequest> {
        private final ProtoAdapter<Map<String, String>> headers;

        public ProtoAdapter_SendHttpRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SendHttpRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.headers = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SendHttpRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.url = "";
            r101.method = Method.GET;
            r101.body = ByteString.EMPTY;
            r101.timeout = 0;
            r101.request_id = "";
            Boolean r102 = Boolean.FALSE;
            r101.enable_complex_connect = r102;
            r101.retry_num = 3;
            r101.priority = Priority.MEDIUM;
            r101.download_file_path = "";
            r101.upload_file_path = "";
            r101.host_alias = HostAlias.UNKNOWN;
            r101.enable_start_up_control = r102;
            r101.no_follow_redirection = r102;
            r101.json_body = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L33;
            if (r104 != 1000) goto L7;
            r101.json_body = ProtoAdapter.STRING.decode(r100);
            goto L3
        L7:
            switch(r104) {
                case 1: goto L31;
                case 2: goto L35;
                case 3: goto L26;
                case 4: goto L25;
                case 5: goto L24;
                case 6: goto L23;
                case 7: goto L22;
                case 8: goto L21;
                case 9: goto L39;
                case 10: goto L16;
                case 11: goto L15;
                case 12: goto L37;
                case 13: goto L10;
                case 14: goto L9;
                default: goto L8;
            };
        L35:
            r101.method = Method.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L29
        L29:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L37:
            r101.host_alias = HostAlias.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L39:
            r101.priority = Priority.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            r101.no_follow_redirection = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.enable_start_up_control = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            r101.upload_file_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.download_file_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.retry_num = ProtoAdapter.INT32.decode(r100);
            goto L3
        L22:
            r101.enable_complex_connect = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L23:
            r101.request_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L24:
            r101.timeout = ProtoAdapter.INT32.decode(r100);
            goto L3
        L25:
            r101.body = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L26:
            r101.headers.putAll(this.headers.decode(r100));
            goto L3
        L31:
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L33:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SendHttpRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.url) + Method.ADAPTER.encodedSizeWithTag(2, r100.method)) + this.headers.encodedSizeWithTag(3, r100.headers);
            ByteString r103 = r100.body;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.BYTES.encodedSizeWithTag(4, r103);
        L6:
            int r106 = r102 + r105;
            Integer r107 = r100.timeout;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(5, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.request_id;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(6, r110);
        L14:
            int r112 = r109 + r111;
            Boolean r113 = r100.enable_complex_connect;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r113);
        L18:
            int r115 = r112 + r114;
            Integer r116 = r100.retry_num;
            if (r116 == null) goto L21;
            int r117 = ProtoAdapter.INT32.encodedSizeWithTag(8, r116);
        L22:
            int r118 = r115 + r117;
            Priority r119 = r100.priority;
            if (r119 == null) goto L25;
            int r120 = Priority.ADAPTER.encodedSizeWithTag(9, r119);
        L26:
            int r121 = r118 + r120;
            String r122 = r100.download_file_path;
            if (r122 == null) goto L29;
            int r123 = r101.encodedSizeWithTag(10, r122);
        L30:
            int r124 = r121 + r123;
            String r125 = r100.upload_file_path;
            if (r125 == null) goto L33;
            int r126 = r101.encodedSizeWithTag(11, r125);
        L34:
            int r127 = r124 + r126;
            HostAlias r128 = r100.host_alias;
            if (r128 == null) goto L37;
            int r129 = HostAlias.ADAPTER.encodedSizeWithTag(12, r128);
        L38:
            int r130 = r127 + r129;
            Boolean r131 = r100.enable_start_up_control;
            if (r131 == null) goto L41;
            int r132 = ProtoAdapter.BOOL.encodedSizeWithTag(13, r131);
        L42:
            int r133 = r130 + r132;
            Boolean r134 = r100.no_follow_redirection;
            if (r134 == null) goto L45;
            int r135 = ProtoAdapter.BOOL.encodedSizeWithTag(14, r134);
        L46:
            int r136 = r133 + r135;
            String r137 = r100.json_body;
            if (r137 == null) goto L50;
            r104 = r101.encodedSizeWithTag(1000, r137);
        L50:
            return (r136 + r104) + r100.unknownFields().size();
        L45:
            r135 = 0;
            goto L46
        L41:
            r132 = 0;
            goto L42
        L37:
            r129 = 0;
            goto L38
        L33:
            r126 = 0;
            goto L34
        L29:
            r123 = 0;
            goto L30
        L25:
            r120 = 0;
            goto L26
        L21:
            r117 = 0;
            goto L22
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
        public /* bridge */ /* synthetic */ SendHttpRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SendHttpRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SendHttpRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.url);
            Method.ADAPTER.encodeWithTag(r100, 2, r101.method);
            this.headers.encodeWithTag(r100, 3, r101.headers);
            ByteString r103 = r101.body;
            if (r103 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 4, r103);
        L5:
            Integer r104 = r101.timeout;
            if (r104 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r104);
        L8:
            String r105 = r101.request_id;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 6, r105);
        L11:
            Boolean r106 = r101.enable_complex_connect;
            if (r106 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r106);
        L14:
            Integer r107 = r101.retry_num;
            if (r107 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 8, r107);
        L17:
            Priority r108 = r101.priority;
            if (r108 == null) goto L20;
            Priority.ADAPTER.encodeWithTag(r100, 9, r108);
        L20:
            String r109 = r101.download_file_path;
            if (r109 == null) goto L23;
            r102.encodeWithTag(r100, 10, r109);
        L23:
            String r110 = r101.upload_file_path;
            if (r110 == null) goto L26;
            r102.encodeWithTag(r100, 11, r110);
        L26:
            HostAlias r111 = r101.host_alias;
            if (r111 == null) goto L29;
            HostAlias.ADAPTER.encodeWithTag(r100, 12, r111);
        L29:
            Boolean r112 = r101.enable_start_up_control;
            if (r112 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r100, 13, r112);
        L32:
            Boolean r113 = r101.no_follow_redirection;
            if (r113 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r100, 14, r113);
        L35:
            String r114 = r101.json_body;
            if (r114 == null) goto L38;
            r102.encodeWithTag(r100, 1000, r114);
        L38:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SendHttpRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SendHttpRequest r100 = new ProtoAdapter_SendHttpRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_METHOD = Method.GET;
        DEFAULT_BODY = ByteString.EMPTY;
        DEFAULT_TIMEOUT = 0;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_ENABLE_COMPLEX_CONNECT = r101;
        DEFAULT_RETRY_NUM = 3;
        DEFAULT_PRIORITY = Priority.MEDIUM;
        DEFAULT_HOST_ALIAS = HostAlias.UNKNOWN;
        DEFAULT_ENABLE_START_UP_CONTROL = r101;
        DEFAULT_NO_FOLLOW_REDIRECTION = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.url = this.url;
        r100.method = this.method;
        r100.headers = Internal.copyOf("headers", this.headers);
        r100.body = this.body;
        r100.timeout = this.timeout;
        r100.request_id = this.request_id;
        r100.enable_complex_connect = this.enable_complex_connect;
        r100.retry_num = this.retry_num;
        r100.priority = this.priority;
        r100.download_file_path = this.download_file_path;
        r100.upload_file_path = this.upload_file_path;
        r100.host_alias = this.host_alias;
        r100.enable_start_up_control = this.enable_start_up_control;
        r100.no_follow_redirection = this.no_follow_redirection;
        r100.json_body = this.json_body;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SendHttpRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public SendHttpRequest(String r110, Method r111, Map<String, String> r210, ByteString r211, Integer r212, String r213, Boolean r214, Integer r215, Priority r216, String r217, String r218, HostAlias r219, Boolean r310, Boolean r311, String r312) {
        this(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, ByteString.EMPTY);
    }

    public SendHttpRequest(String r100, Method r101, Map<String, String> r102, ByteString r103, Integer r104, String r105, Boolean r110, Integer r111, Priority r112, String r113, String r114, HostAlias r115, Boolean r116, Boolean r117, String r118, ByteString r119) {
        super(ADAPTER, r119);
        this.url = r100;
        this.method = r101;
        this.headers = Internal.immutableCopyOf("headers", r102);
        this.body = r103;
        this.timeout = r104;
        this.request_id = r105;
        this.enable_complex_connect = r110;
        this.retry_num = r111;
        this.priority = r112;
        this.download_file_path = r113;
        this.upload_file_path = r114;
        this.host_alias = r115;
        this.enable_start_up_control = r116;
        this.no_follow_redirection = r117;
        this.json_body = r118;
    }
}
