package com.ss.ugc.live.sdk.msg.data;

import android.os.Parcelable;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes36.dex */
public final class SdkMessage extends AndroidMessage<SdkMessage, Builder> {
    public static final ProtoAdapter<SdkMessage> ADAPTER = null;
    public static final Parcelable.Creator<SdkMessage> CREATOR = null;
    public static final String DEFAULT_METHOD = "";
    public static final Long DEFAULT_MSG_ID = null;
    public static final Integer DEFAULT_MSG_TYPE = null;
    public static final Boolean DEFAULT_NEED_WRDS_STORE = null;
    public static final Long DEFAULT_OFFSET = null;
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final String DEFAULT_TENANT_ID = "";
    public static final String DEFAULT_WRDS_SUB_KEY = "";
    public static final Long DEFAULT_WRDS_VERSION = null;
    private static final long serialVersionUID = 0;
    public transient boolean fromHttp;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final Map<String, String> message_extra;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String method;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    public final Long msg_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer msg_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 6)
    public final Boolean need_wrds_store;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    public final Long offset;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 2)
    public final ByteString payload;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String tenant_id;
    public transient long timestamp;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String wrds_sub_key;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 7)
    public final Long wrds_version;

    public static final class Builder extends Message.Builder<SdkMessage, Builder> {
        public Map<String, String> message_extra;
        public String method;
        public Long msg_id;
        public Integer msg_type;
        public Boolean need_wrds_store;
        public Long offset;
        public ByteString payload;
        public String tenant_id;
        public String wrds_sub_key;
        public Long wrds_version;

        @Override // com.squareup.wire.Message.Builder
        public SdkMessage build() {
            return new SdkMessage(this.method, this.payload, this.msg_id, this.msg_type, this.offset, this.need_wrds_store, this.wrds_version, this.wrds_sub_key, this.message_extra, this.tenant_id, super.buildUnknownFields());
        }

        public Builder() {
            this.method = "";
            this.payload = ByteString.EMPTY;
            this.msg_id = 0L;
            this.msg_type = 0;
            this.offset = 0L;
            this.need_wrds_store = Boolean.FALSE;
            this.wrds_version = 0L;
            this.wrds_sub_key = "";
            this.tenant_id = "";
            this.message_extra = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder message_extra(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_extra = r100;
            return this;
        }

        public Builder method(String r100) {
            this.method = r100;
            return this;
        }

        public Builder msg_id(Long r100) {
            this.msg_id = r100;
            return this;
        }

        public Builder msg_type(Integer r100) {
            this.msg_type = r100;
            return this;
        }

        public Builder need_wrds_store(Boolean r100) {
            this.need_wrds_store = r100;
            return this;
        }

        public Builder offset(Long r100) {
            this.offset = r100;
            return this;
        }

        public Builder payload(ByteString r100) {
            this.payload = r100;
            return this;
        }

        public Builder tenant_id(String r100) {
            this.tenant_id = r100;
            return this;
        }

        public Builder wrds_sub_key(String r100) {
            this.wrds_sub_key = r100;
            return this;
        }

        public Builder wrds_version(Long r100) {
            this.wrds_version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SdkMessage extends ProtoAdapter<SdkMessage> {
        private final ProtoAdapter<Map<String, String>> message_extra;

        public ProtoAdapter_SdkMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkMessage.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.message_extra = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SdkMessage decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            switch(r103) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r101.tenant_id(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            r101.message_extra.putAll(this.message_extra.decode(r100));
            goto L3
        L9:
            r101.wrds_sub_key(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            r101.wrds_version(ProtoAdapter.INT64.decode(r100));
            goto L3
        L11:
            r101.need_wrds_store(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L12:
            r101.offset(ProtoAdapter.INT64.decode(r100));
            goto L3
        L13:
            r101.msg_type(ProtoAdapter.INT32.decode(r100));
            goto L3
        L14:
            r101.msg_id(ProtoAdapter.INT64.decode(r100));
            goto L3
        L15:
            r101.payload(ProtoAdapter.BYTES.decode(r100));
            goto L3
        L16:
            r101.method(ProtoAdapter.STRING.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SdkMessage r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.method) + ProtoAdapter.BYTES.encodedSizeWithTag(2, r100.payload);
            ProtoAdapter<Long> r103 = ProtoAdapter.INT64;
            return ((((((((r102 + r103.encodedSizeWithTag(3, r100.msg_id)) + ProtoAdapter.INT32.encodedSizeWithTag(4, r100.msg_type)) + r103.encodedSizeWithTag(5, r100.offset)) + ProtoAdapter.BOOL.encodedSizeWithTag(6, r100.need_wrds_store)) + r103.encodedSizeWithTag(7, r100.wrds_version)) + r101.encodedSizeWithTag(8, r100.wrds_sub_key)) + this.message_extra.encodedSizeWithTag(9, r100.message_extra)) + r101.encodedSizeWithTag(10, r100.tenant_id)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SdkMessage redact2(SdkMessage r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkMessage decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SdkMessage r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkMessage redact(SdkMessage r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SdkMessage r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.method);
            ProtoAdapter.BYTES.encodeWithTag(r100, 2, r101.payload);
            ProtoAdapter<Long> r103 = ProtoAdapter.INT64;
            r103.encodeWithTag(r100, 3, r101.msg_id);
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r101.msg_type);
            r103.encodeWithTag(r100, 5, r101.offset);
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r101.need_wrds_store);
            r103.encodeWithTag(r100, 7, r101.wrds_version);
            r102.encodeWithTag(r100, 8, r101.wrds_sub_key);
            this.message_extra.encodeWithTag(r100, 9, r101.message_extra);
            r102.encodeWithTag(r100, 10, r101.tenant_id);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SdkMessage r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SdkMessage r100 = new ProtoAdapter_SdkMessage();
        ADAPTER = r100;
        CREATOR = AndroidMessage.newCreator(r100);
        DEFAULT_PAYLOAD = ByteString.EMPTY;
        DEFAULT_MSG_ID = 0L;
        DEFAULT_MSG_TYPE = 0;
        DEFAULT_OFFSET = 0L;
        DEFAULT_NEED_WRDS_STORE = Boolean.FALSE;
        DEFAULT_WRDS_VERSION = 0L;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L41;
        int r101 = unknownFields().hashCode() * 37;
        String r102 = this.method;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        ByteString r106 = this.payload;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        Long r109 = this.msg_id;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        Integer r112 = this.msg_type;
        if (r112 == null) goto L19;
        int r113 = r112.hashCode();
    L20:
        int r114 = (r111 + r113) * 37;
        Long r115 = this.offset;
        if (r115 == null) goto L23;
        int r116 = r115.hashCode();
    L24:
        int r117 = (r114 + r116) * 37;
        Boolean r118 = this.need_wrds_store;
        if (r118 == null) goto L27;
        int r119 = r118.hashCode();
    L28:
        int r120 = (r117 + r119) * 37;
        Long r121 = this.wrds_version;
        if (r121 == null) goto L31;
        int r122 = r121.hashCode();
    L32:
        int r123 = (r120 + r122) * 37;
        String r124 = this.wrds_sub_key;
        if (r124 == null) goto L35;
        int r125 = r124.hashCode();
    L36:
        int r126 = (((r123 + r125) * 37) + this.message_extra.hashCode()) * 37;
        String r127 = this.tenant_id;
        if (r127 == null) goto L39;
        r103 = r127.hashCode();
    L39:
        int r128 = r126 + r103;
        this.hashCode = r128;
        return r128;
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
        r116 = 0;
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
    L41:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.method = this.method;
        r100.payload = this.payload;
        r100.msg_id = this.msg_id;
        r100.msg_type = this.msg_type;
        r100.offset = this.offset;
        r100.need_wrds_store = this.need_wrds_store;
        r100.wrds_version = this.wrds_version;
        r100.wrds_sub_key = this.wrds_sub_key;
        r100.message_extra = Internal.copyOf(AppConstants.KEY_MESSAGE_EXTRA, this.message_extra);
        r100.tenant_id = this.tenant_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.method == null) goto L6;
        r100.append(", method=");
        r100.append(this.method);
    L6:
        if (this.msg_id == null) goto L9;
        r100.append(", msg_id=");
        r100.append(this.msg_id);
    L9:
        if (this.msg_type == null) goto L12;
        r100.append(", msg_type=");
        r100.append(this.msg_type);
    L12:
        if (this.offset == null) goto L15;
        r100.append(", offset=");
        r100.append(this.offset);
    L15:
        if (this.need_wrds_store == null) goto L18;
        r100.append(", need_wrds_store=");
        r100.append(this.need_wrds_store);
    L18:
        if (this.wrds_version == null) goto L21;
        r100.append(", wrds_version=");
        r100.append(this.wrds_version);
    L21:
        if (this.wrds_sub_key == null) goto L23;
        r100.append(", wrds_sub_key=");
        r100.append(this.wrds_sub_key);
    L23:
        Map<String, String> r101 = this.message_extra;
        if (r101 == null) goto L29;
        if (r101.isEmpty() == true) goto L29;
        r100.append(", message_extra=");
        r100.append(this.message_extra);
    L29:
        if (this.tenant_id == null) goto L31;
        r100.append(", tenant_id=");
        r100.append(this.tenant_id);
    L31:
        StringBuilder r102 = r100.replace(0, 2, "SdkMessage{");
        r102.append('}');
        return r102.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SdkMessage) == true) goto L8;
        return false;
    L8:
        SdkMessage r101 = (SdkMessage) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L31:
        return false;
    L11:
        if (Internal.equals(this.method, r101.method) == false) goto L31;
        if (Internal.equals(this.payload, r101.payload) == false) goto L31;
        if (Internal.equals(this.msg_id, r101.msg_id) == false) goto L31;
        if (Internal.equals(this.msg_type, r101.msg_type) == false) goto L31;
        if (Internal.equals(this.offset, r101.offset) == false) goto L31;
        if (Internal.equals(this.need_wrds_store, r101.need_wrds_store) == false) goto L31;
        if (Internal.equals(this.wrds_version, r101.wrds_version) == false) goto L31;
        if (Internal.equals(this.wrds_sub_key, r101.wrds_sub_key) == false) goto L31;
        if (this.message_extra.equals(r101.message_extra) == false) goto L31;
        if (Internal.equals(this.tenant_id, r101.tenant_id) == false) goto L31;
        return true;
    }

    public SdkMessage(String r110, ByteString r111, Long r112, Integer r113, Long r114, Boolean r115, Long r116, String r210, Map<String, String> r211, String r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public SdkMessage(String r100, ByteString r101, Long r102, Integer r103, Long r104, Boolean r105, Long r106, String r107, Map<String, String> r110, String r111, ByteString r112) {
        super(ADAPTER, r112);
        this.method = r100;
        this.payload = r101;
        this.msg_id = r102;
        this.msg_type = r103;
        this.offset = r104;
        this.need_wrds_store = r105;
        this.wrds_version = r106;
        this.wrds_sub_key = r107;
        this.message_extra = Internal.immutableCopyOf(AppConstants.KEY_MESSAGE_EXTRA, r110);
        this.tenant_id = r111;
    }
}
