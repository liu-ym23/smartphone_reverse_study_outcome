package com.bytedance.lark.pb.tool.v1;

import com.alipay.sdk.m.p.e;
import com.bytedance.lark.pb.basic.v1.DomainSettings;
import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
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
public final class FetchRequest extends Message<FetchRequest, Builder> {
    public static final ProtoAdapter<FetchRequest> ADAPTER = null;
    public static final Boolean DEFAULT_DISABLE_COOKIE = null;
    public static final DomainSettings.Alias DEFAULT_DOMAIN_ALIAS = null;
    public static final Boolean DEFAULT_ENABLE_COMPLEX_CONNECT = null;
    public static final Long DEFAULT_ISOLATE_USER_ID = null;
    public static final Boolean DEFAULT_IS_FOLLOW_REDIRECT = null;
    public static final Method DEFAULT_METHOD = null;
    public static final Priority DEFAULT_PRIORITY = null;
    public static final Long DEFAULT_REQUEST_ID = null;
    public static final Integer DEFAULT_RETRY_NUM = null;
    public static final Integer DEFAULT_TIMEOUT = null;
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final Boolean disable_cookie;
    public final DomainSettings.Alias domain_alias;
    public final Boolean enable_complex_connect;
    public final List<HttpHeader> headers;
    public final Boolean is_follow_redirect;
    public final Long isolate_user_id;
    public final Method method;
    public final Priority priority;
    public final Long request_id;
    public final Integer retry_num;
    public final Integer timeout;
    public final String url;

    public static final class Builder extends Message.Builder<FetchRequest, Builder> {
        public Boolean disable_cookie;
        public DomainSettings.Alias domain_alias;
        public Boolean enable_complex_connect;
        public List<HttpHeader> headers;
        public Boolean is_follow_redirect;
        public Long isolate_user_id;
        public Method method;
        public Priority priority;
        public Long request_id;
        public Integer retry_num;
        public Integer timeout;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public FetchRequest build() {
            String r100 = this.url;
            if (r100 == null) goto L11;
            if (this.method == null) goto L11;
            if (this.request_id == null) goto L11;
            return new FetchRequest(this.url, this.method, this.headers, this.timeout, this.is_follow_redirect, this.request_id, this.priority, this.enable_complex_connect, this.retry_num, this.domain_alias, this.isolate_user_id, this.disable_cookie, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "url", this.method, e.f25671s, this.request_id, "request_id"});
        }

        public Builder() {
            this.headers = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder disable_cookie(Boolean r100) {
            this.disable_cookie = r100;
            return this;
        }

        public Builder domain_alias(DomainSettings.Alias r100) {
            this.domain_alias = r100;
            return this;
        }

        public Builder enable_complex_connect(Boolean r100) {
            this.enable_complex_connect = r100;
            return this;
        }

        public Builder headers(List<HttpHeader> r100) {
            Internal.checkElementsNotNull(r100);
            this.headers = r100;
            return this;
        }

        public Builder is_follow_redirect(Boolean r100) {
            this.is_follow_redirect = r100;
            return this;
        }

        public Builder isolate_user_id(Long r100) {
            this.isolate_user_id = r100;
            return this;
        }

        public Builder method(Method r100) {
            this.method = r100;
            return this;
        }

        public Builder priority(Priority r100) {
            this.priority = r100;
            return this;
        }

        public Builder request_id(Long r100) {
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

        public Builder url(String r100) {
            this.url = r100;
            return this;
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

    public static final class ProtoAdapter_FetchRequest extends ProtoAdapter<FetchRequest> {
        public ProtoAdapter_FetchRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, FetchRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FetchRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.url = "";
            r101.method = Method.GET;
            r101.timeout = 0;
            Boolean r102 = Boolean.FALSE;
            r101.is_follow_redirect = r102;
            r101.request_id = 0L;
            r101.priority = Priority.MEDIUM;
            r101.enable_complex_connect = r102;
            r101.retry_num = 3;
            r101.domain_alias = DomainSettings.Alias.UNKNOWN;
            r101.isolate_user_id = 0L;
            r101.disable_cookie = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L28;
            switch(r104) {
                case 1: goto L27;
                case 2: goto L32;
                case 3: goto L22;
                case 4: goto L21;
                case 5: goto L6;
                case 6: goto L20;
                case 7: goto L19;
                case 8: goto L30;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L34;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L30:
            r101.priority = Priority.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L32:
            r101.method = Method.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L34:
            r101.domain_alias = DomainSettings.Alias.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.disable_cookie = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.isolate_user_id = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L13:
            r101.retry_num = ProtoAdapter.INT32.decode(r100);
            goto L3
        L14:
            r101.enable_complex_connect = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L19:
            r101.request_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L20:
            r101.is_follow_redirect = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L21:
            r101.timeout = ProtoAdapter.INT32.decode(r100);
            goto L3
        L22:
            r101.headers.add(HttpHeader.ADAPTER.decode(r100));
            goto L3
        L27:
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L28:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FetchRequest r100) {
            int r101 = (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.url) + Method.ADAPTER.encodedSizeWithTag(2, r100.method)) + HttpHeader.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.headers);
            Integer r102 = r100.timeout;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.INT32.encodedSizeWithTag(4, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.is_follow_redirect;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r106);
        L10:
            int r108 = (r105 + r107) + ProtoAdapter.INT64.encodedSizeWithTag(7, r100.request_id);
            Priority r109 = r100.priority;
            if (r109 == null) goto L13;
            int r110 = Priority.ADAPTER.encodedSizeWithTag(8, r109);
        L14:
            int r111 = r108 + r110;
            Boolean r112 = r100.enable_complex_connect;
            if (r112 == null) goto L17;
            int r113 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r112);
        L18:
            int r114 = r111 + r113;
            Integer r115 = r100.retry_num;
            if (r115 == null) goto L21;
            int r116 = ProtoAdapter.INT32.encodedSizeWithTag(10, r115);
        L22:
            int r117 = r114 + r116;
            DomainSettings.Alias r118 = r100.domain_alias;
            if (r118 == null) goto L25;
            int r119 = DomainSettings.Alias.ADAPTER.encodedSizeWithTag(11, r118);
        L26:
            int r120 = r117 + r119;
            Long r121 = r100.isolate_user_id;
            if (r121 == null) goto L29;
            int r122 = ProtoAdapter.UINT64.encodedSizeWithTag(12, r121);
        L30:
            int r123 = r120 + r122;
            Boolean r124 = r100.disable_cookie;
            if (r124 == null) goto L34;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(13, r124);
        L34:
            return (r123 + r103) + r100.unknownFields().size();
        L29:
            r122 = 0;
            goto L30
        L25:
            r119 = 0;
            goto L26
        L21:
            r116 = 0;
            goto L22
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
        public /* bridge */ /* synthetic */ FetchRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FetchRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FetchRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.url);
            Method.ADAPTER.encodeWithTag(r100, 2, r101.method);
            HttpHeader.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.headers);
            Integer r102 = r101.timeout;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r102);
        L5:
            Boolean r103 = r101.is_follow_redirect;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r103);
        L8:
            ProtoAdapter.INT64.encodeWithTag(r100, 7, r101.request_id);
            Priority r104 = r101.priority;
            if (r104 == null) goto L11;
            Priority.ADAPTER.encodeWithTag(r100, 8, r104);
        L11:
            Boolean r105 = r101.enable_complex_connect;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r105);
        L14:
            Integer r106 = r101.retry_num;
            if (r106 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 10, r106);
        L17:
            DomainSettings.Alias r107 = r101.domain_alias;
            if (r107 == null) goto L20;
            DomainSettings.Alias.ADAPTER.encodeWithTag(r100, 11, r107);
        L20:
            Long r108 = r101.isolate_user_id;
            if (r108 == null) goto L23;
            ProtoAdapter.UINT64.encodeWithTag(r100, 12, r108);
        L23:
            Boolean r109 = r101.disable_cookie;
            if (r109 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 13, r109);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FetchRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FetchRequest();
        DEFAULT_METHOD = Method.GET;
        DEFAULT_TIMEOUT = 0;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_FOLLOW_REDIRECT = r100;
        DEFAULT_REQUEST_ID = 0L;
        DEFAULT_PRIORITY = Priority.MEDIUM;
        DEFAULT_ENABLE_COMPLEX_CONNECT = r100;
        DEFAULT_RETRY_NUM = 3;
        DEFAULT_DOMAIN_ALIAS = DomainSettings.Alias.UNKNOWN;
        DEFAULT_ISOLATE_USER_ID = 0L;
        DEFAULT_DISABLE_COOKIE = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.url = this.url;
        r100.method = this.method;
        r100.headers = Internal.copyOf("headers", this.headers);
        r100.timeout = this.timeout;
        r100.is_follow_redirect = this.is_follow_redirect;
        r100.request_id = this.request_id;
        r100.priority = this.priority;
        r100.enable_complex_connect = this.enable_complex_connect;
        r100.retry_num = this.retry_num;
        r100.domain_alias = this.domain_alias;
        r100.isolate_user_id = this.isolate_user_id;
        r100.disable_cookie = this.disable_cookie;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FetchRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FetchRequest(String r110, Method r111, List<HttpHeader> r112, Integer r113, Boolean r114, Long r210, Priority r211, Boolean r212, Integer r213, DomainSettings.Alias r214, Long r215, Boolean r216) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, ByteString.EMPTY);
    }

    public FetchRequest(String r100, Method r101, List<HttpHeader> r102, Integer r103, Boolean r104, Long r105, Priority r106, Boolean r107, Integer r110, DomainSettings.Alias r111, Long r112, Boolean r113, ByteString r114) {
        super(ADAPTER, r114);
        this.url = r100;
        this.method = r101;
        this.headers = Internal.immutableCopyOf("headers", r102);
        this.timeout = r103;
        this.is_follow_redirect = r104;
        this.request_id = r105;
        this.priority = r106;
        this.enable_complex_connect = r107;
        this.retry_num = r110;
        this.domain_alias = r111;
        this.isolate_user_id = r112;
        this.disable_cookie = r113;
    }
}
