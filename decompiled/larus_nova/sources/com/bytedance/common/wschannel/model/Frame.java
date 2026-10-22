package com.bytedance.common.wschannel.model;

import com.alipay.sdk.m.p.e;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class Frame extends Message<Frame, Builder> {
    public static final ProtoAdapter<Frame> ADAPTER = null;
    public static final Long DEFAULT_LOGID = null;
    public static final String DEFAULT_LOGIDNEW = "";
    public static final Integer DEFAULT_METHOD = null;
    public static final String DEFAULT_MSGID = "";
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final String DEFAULT_PAYLOAD_ENCODING = "";
    public static final String DEFAULT_PAYLOAD_TYPE = "";
    public static final Long DEFAULT_SEQID = null;
    public static final String DEFAULT_SERVERTIMING = "";
    public static final Integer DEFAULT_SERVICE = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.bytedance.article.wschannel.model.Frame$ExtendedEntry#ADAPTER", label = WireField.Label.REPEATED, tag = 5)
    public final List<ExtendedEntry> headers;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", label = WireField.Label.REQUIRED, tag = 2)
    public final Long logid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String logidnew;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 4)
    public final Integer method;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String msgId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 8)
    public final ByteString payload;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String payload_encoding;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String payload_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", label = WireField.Label.REQUIRED, tag = 1)
    public final Long seqid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String serverTiming;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 3)
    public final Integer service;

    public static final class Builder extends Message.Builder<Frame, Builder> {
        public List<ExtendedEntry> headers;
        public Long logid;
        public String logidnew;
        public Integer method;
        public String msgId;
        public ByteString payload;
        public String payload_encoding;
        public String payload_type;
        public Long seqid;
        public String serverTiming;
        public Integer service;

        @Override // com.squareup.wire.Message.Builder
        public Frame build() {
            Long r100 = this.seqid;
            if (r100 == null) goto L13;
            if (this.logid == null) goto L13;
            if (this.service == null) goto L13;
            if (this.method == null) goto L13;
            return new Frame(this.seqid, this.logid, this.service, this.method, this.headers, this.payload_encoding, this.payload_type, this.payload, this.logidnew, this.serverTiming, this.msgId, buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "seqid", this.logid, CronetDataStorageAccess.LOGID, this.service, "service", this.method, e.f25671s});
        }

        public Builder() {
            this.headers = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder headers(List<ExtendedEntry> r100) {
            Internal.checkElementsNotNull(r100);
            this.headers = r100;
            return this;
        }

        public Builder logid(Long r100) {
            this.logid = r100;
            return this;
        }

        public Builder logidnew(String r100) {
            this.logidnew = r100;
            return this;
        }

        public Builder method(Integer r100) {
            this.method = r100;
            return this;
        }

        public Builder msgId(String r100) {
            this.msgId = r100;
            return this;
        }

        public Builder payload(ByteString r100) {
            this.payload = r100;
            return this;
        }

        public Builder payload_encoding(String r100) {
            this.payload_encoding = r100;
            return this;
        }

        public Builder payload_type(String r100) {
            this.payload_type = r100;
            return this;
        }

        public Builder seqid(Long r100) {
            this.seqid = r100;
            return this;
        }

        public Builder serverTiming(String r100) {
            this.serverTiming = r100;
            return this;
        }

        public Builder service(Integer r100) {
            this.service = r100;
            return this;
        }
    }

    public static final class ExtendedEntry extends Message<ExtendedEntry, Builder> {
        public static final ProtoAdapter<ExtendedEntry> ADAPTER = null;
        public static final String DEFAULT_KEY = "";
        public static final String DEFAULT_VALUE = "";
        private static final long serialVersionUID = 0;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
        public final String key;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 2)
        public final String value;

        public static final class Builder extends Message.Builder<ExtendedEntry, Builder> {
            public String key;
            public String value;

            @Override // com.squareup.wire.Message.Builder
            public ExtendedEntry build() {
                String r100 = this.key;
                if (r100 == null) goto L9;
                if (this.value == null) goto L9;
                return new ExtendedEntry(this.key, this.value, buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "key", this.value, "value"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder key(String r100) {
                this.key = r100;
                return this;
            }

            public Builder value(String r100) {
                this.value = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ExtendedEntry extends ProtoAdapter<ExtendedEntry> {
            public ProtoAdapter_ExtendedEntry() {
                super(FieldEncoding.LENGTH_DELIMITED, ExtendedEntry.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ExtendedEntry decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.key(ProtoAdapter.STRING.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.value(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(ExtendedEntry r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                return (r101.encodedSizeWithTag(1, r100.key) + r101.encodedSizeWithTag(2, r100.value)) + r100.unknownFields().size();
            }

            /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
            public ExtendedEntry redact2(ExtendedEntry r100) {
                Builder r101 = r100.newBuilder();
                r101.clearUnknownFields();
                return r101.build();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ExtendedEntry decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ExtendedEntry r100) {
                return encodedSize2(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ExtendedEntry redact(ExtendedEntry r100) {
                return redact2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ExtendedEntry r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.key);
                r102.encodeWithTag(r100, 2, r101.value);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ExtendedEntry r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ExtendedEntry();
        }

        public int hashCode() {
            int r100 = this.hashCode;
            if (r100 != 0) goto L13;
            int r101 = unknownFields().hashCode() * 37;
            String r102 = this.key;
            int r103 = 0;
            if (r102 == null) goto L7;
            int r104 = r102.hashCode();
        L8:
            int r105 = (r101 + r104) * 37;
            String r106 = this.value;
            if (r106 == null) goto L11;
            r103 = r106.hashCode();
        L11:
            int r107 = r105 + r103;
            this.hashCode = r107;
            return r107;
        L7:
            r104 = 0;
            goto L8
        L13:
            return r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.key = this.key;
            r100.value = this.value;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            StringBuilder r100 = new StringBuilder();
            if (this.key == null) goto L6;
            r100.append(", key=");
            r100.append(this.key);
        L6:
            if (this.value == null) goto L8;
            r100.append(", value=");
            r100.append(this.value);
        L8:
            StringBuilder r101 = r100.replace(0, 2, "ExtendedEntry{");
            r101.append('}');
            return r101.toString();
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public boolean equals(Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if ((r100 instanceof ExtendedEntry) == true) goto L8;
            return false;
        L8:
            ExtendedEntry r101 = (ExtendedEntry) r100;
            if (Internal.equals(unknownFields(), r101.unknownFields()) == true) goto L11;
        L15:
            return false;
        L11:
            if (Internal.equals(this.key, r101.key) == false) goto L15;
            if (Internal.equals(this.value, r101.value) == false) goto L15;
            return true;
        }

        public ExtendedEntry(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public ExtendedEntry(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.key = r100;
            this.value = r101;
        }
    }

    public static final class ProtoAdapter_Frame extends ProtoAdapter<Frame> {
        public ProtoAdapter_Frame() {
            super(FieldEncoding.LENGTH_DELIMITED, Frame.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Frame decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            switch(r103) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L7:
            r101.msgId(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            r101.serverTiming(ProtoAdapter.STRING.decode(r100));
            goto L3
        L9:
            r101.logidnew(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            r101.payload(ProtoAdapter.BYTES.decode(r100));
            goto L3
        L11:
            r101.payload_type(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            r101.payload_encoding(ProtoAdapter.STRING.decode(r100));
            goto L3
        L13:
            r101.headers.add(ExtendedEntry.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.method(ProtoAdapter.INT32.decode(r100));
            goto L3
        L15:
            r101.service(ProtoAdapter.INT32.decode(r100));
            goto L3
        L16:
            r101.logid(ProtoAdapter.UINT64.decode(r100));
            goto L3
        L17:
            r101.seqid(ProtoAdapter.UINT64.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Frame r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.UINT64;
            int r102 = r101.encodedSizeWithTag(1, r100.seqid) + r101.encodedSizeWithTag(2, r100.logid);
            ProtoAdapter<Integer> r103 = ProtoAdapter.INT32;
            int r104 = ((r102 + r103.encodedSizeWithTag(3, r100.service)) + r103.encodedSizeWithTag(4, r100.method)) + ExtendedEntry.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.headers);
            String r105 = r100.payload_encoding;
            int r106 = 0;
            if (r105 == null) goto L5;
            int r107 = ProtoAdapter.STRING.encodedSizeWithTag(6, r105);
        L6:
            int r108 = r104 + r107;
            String r109 = r100.payload_type;
            if (r109 == null) goto L9;
            int r110 = ProtoAdapter.STRING.encodedSizeWithTag(7, r109);
        L10:
            int r111 = r108 + r110;
            ByteString r112 = r100.payload;
            if (r112 == null) goto L13;
            int r113 = ProtoAdapter.BYTES.encodedSizeWithTag(8, r112);
        L14:
            int r114 = r111 + r113;
            String r115 = r100.logidnew;
            if (r115 == null) goto L17;
            int r116 = ProtoAdapter.STRING.encodedSizeWithTag(9, r115);
        L18:
            int r117 = r114 + r116;
            String r118 = r100.serverTiming;
            if (r118 == null) goto L21;
            int r119 = ProtoAdapter.STRING.encodedSizeWithTag(10, r118);
        L22:
            int r120 = r117 + r119;
            String r121 = r100.msgId;
            if (r121 == null) goto L26;
            r106 = ProtoAdapter.STRING.encodedSizeWithTag(11, r121);
        L26:
            return (r120 + r106) + r100.unknownFields().size();
        L21:
            r119 = 0;
            goto L22
        L17:
            r116 = 0;
            goto L18
        L13:
            r113 = 0;
            goto L14
        L9:
            r110 = 0;
            goto L10
        L5:
            r107 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public Frame redact2(Frame r100) {
            Builder r101 = r100.newBuilder();
            Internal.redactElements(r101.headers, ExtendedEntry.ADAPTER);
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Frame decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Frame r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Frame redact(Frame r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Frame r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.UINT64;
            r102.encodeWithTag(r100, 1, r101.seqid);
            r102.encodeWithTag(r100, 2, r101.logid);
            ProtoAdapter<Integer> r103 = ProtoAdapter.INT32;
            r103.encodeWithTag(r100, 3, r101.service);
            r103.encodeWithTag(r100, 4, r101.method);
            if (r101.headers == null) goto L5;
            ExtendedEntry.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.headers);
        L5:
            String r104 = r101.payload_encoding;
            if (r104 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r104);
        L8:
            String r105 = r101.payload_type;
            if (r105 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r105);
        L11:
            ByteString r106 = r101.payload;
            if (r106 == null) goto L14;
            ProtoAdapter.BYTES.encodeWithTag(r100, 8, r106);
        L14:
            String r107 = r101.logidnew;
            if (r107 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r107);
        L17:
            String r108 = r101.serverTiming;
            if (r108 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 10, r108);
        L20:
            String r109 = r101.msgId;
            if (r109 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 11, r109);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Frame r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Frame();
        DEFAULT_SEQID = 0L;
        DEFAULT_LOGID = 0L;
        DEFAULT_SERVICE = 0;
        DEFAULT_METHOD = 0;
        DEFAULT_PAYLOAD = ByteString.EMPTY;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L49;
        int r101 = unknownFields().hashCode() * 37;
        Long r102 = this.seqid;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        Long r106 = this.logid;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        Integer r109 = this.service;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        Integer r112 = this.method;
        if (r112 == null) goto L19;
        int r113 = r112.hashCode();
    L20:
        int r114 = (r111 + r113) * 37;
        List<ExtendedEntry> r115 = this.headers;
        if (r115 == null) goto L23;
        int r116 = r115.hashCode();
    L24:
        int r117 = (r114 + r116) * 37;
        String r118 = this.payload_encoding;
        if (r118 == null) goto L27;
        int r119 = r118.hashCode();
    L28:
        int r120 = (r117 + r119) * 37;
        String r121 = this.payload_type;
        if (r121 == null) goto L31;
        int r122 = r121.hashCode();
    L32:
        int r123 = (r120 + r122) * 37;
        ByteString r124 = this.payload;
        if (r124 == null) goto L35;
        int r125 = r124.hashCode();
    L36:
        int r126 = (r123 + r125) * 37;
        String r127 = this.logidnew;
        if (r127 == null) goto L39;
        int r128 = r127.hashCode();
    L40:
        int r129 = (r126 + r128) * 37;
        String r130 = this.serverTiming;
        if (r130 == null) goto L43;
        int r131 = r130.hashCode();
    L44:
        int r132 = (r129 + r131) * 37;
        String r133 = this.msgId;
        if (r133 == null) goto L47;
        r103 = r133.hashCode();
    L47:
        int r134 = r132 + r103;
        this.hashCode = r134;
        return r134;
    L43:
        r131 = 0;
        goto L44
    L39:
        r128 = 0;
        goto L40
    L35:
        r125 = 0;
        goto L36
    L31:
        r122 = 0;
        goto L32
    L27:
        r119 = 0;
        goto L28
    L23:
        r116 = 1;
        goto L24
    L19:
        r113 = 0;
        goto L20
    L15:
        r110 = 0;
        goto L16
    L11:
        r107 = 0;
        goto L12
    L7:
        r104 = 0;
        goto L8
    L49:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.seqid = this.seqid;
        r100.logid = this.logid;
        r100.service = this.service;
        r100.method = this.method;
        r100.headers = Internal.copyOf("headers", this.headers);
        r100.payload_encoding = this.payload_encoding;
        r100.payload_type = this.payload_type;
        r100.payload = this.payload;
        r100.logidnew = this.logidnew;
        r100.serverTiming = this.serverTiming;
        r100.msgId = this.msgId;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.seqid == null) goto L6;
        r100.append(", seqid=");
        r100.append(this.seqid);
    L6:
        if (this.logid == null) goto L9;
        r100.append(", logid=");
        r100.append(this.logid);
    L9:
        if (this.service == null) goto L12;
        r100.append(", service=");
        r100.append(this.service);
    L12:
        if (this.method == null) goto L15;
        r100.append(", method=");
        r100.append(this.method);
    L15:
        if (this.headers == null) goto L18;
        r100.append(", headers=");
        r100.append(this.headers);
    L18:
        if (this.payload_encoding == null) goto L21;
        r100.append(", payload_encoding=");
        r100.append(this.payload_encoding);
    L21:
        if (this.payload_type == null) goto L24;
        r100.append(", payload_type=");
        r100.append(this.payload_type);
    L24:
        if (this.payload == null) goto L27;
        r100.append(", payload=");
        r100.append(this.payload);
    L27:
        if (this.logidnew == null) goto L30;
        r100.append(", logidnew=");
        r100.append(this.logidnew);
    L30:
        if (this.serverTiming == null) goto L33;
        r100.append(", serverTiming=");
        r100.append(this.serverTiming);
    L33:
        if (this.msgId == null) goto L35;
        r100.append(", msgId=");
        r100.append(this.msgId);
    L35:
        StringBuilder r101 = r100.replace(0, 2, "Frame{");
        r101.append('}');
        return r101.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof Frame) == true) goto L8;
        return false;
    L8:
        Frame r101 = (Frame) r100;
        if (Internal.equals(unknownFields(), r101.unknownFields()) == true) goto L11;
    L33:
        return false;
    L11:
        if (Internal.equals(this.seqid, r101.seqid) == false) goto L33;
        if (Internal.equals(this.logid, r101.logid) == false) goto L33;
        if (Internal.equals(this.service, r101.service) == false) goto L33;
        if (Internal.equals(this.method, r101.method) == false) goto L33;
        if (Internal.equals(this.headers, r101.headers) == false) goto L33;
        if (Internal.equals(this.payload_encoding, r101.payload_encoding) == false) goto L33;
        if (Internal.equals(this.payload_type, r101.payload_type) == false) goto L33;
        if (Internal.equals(this.payload, r101.payload) == false) goto L33;
        if (Internal.equals(this.logidnew, r101.logidnew) == false) goto L33;
        if (Internal.equals(this.serverTiming, r101.serverTiming) == false) goto L33;
        if (Internal.equals(this.msgId, r101.msgId) == false) goto L33;
        return true;
    }

    public Frame(Long r110, Long r111, Integer r112, Integer r113, List<ExtendedEntry> r114, String r115, String r210, ByteString r211, String r212, String r213, String r214) {
        this(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, ByteString.EMPTY);
    }

    public Frame(Long r100, Long r101, Integer r102, Integer r103, List<ExtendedEntry> r104, String r105, String r106, ByteString r107, String r110, String r111, String r112, ByteString r113) {
        super(ADAPTER, r113);
        this.seqid = r100;
        this.logid = r101;
        this.service = r102;
        this.method = r103;
        this.headers = Internal.immutableCopyOf("headers", r104);
        this.payload_encoding = r105;
        this.payload_type = r106;
        this.payload = r107;
        this.logidnew = r110;
        this.serverTiming = r111;
        this.msgId = r112;
    }
}
