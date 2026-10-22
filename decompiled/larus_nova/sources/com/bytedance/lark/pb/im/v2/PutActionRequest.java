package com.bytedance.lark.pb.im.v2;

import com.bytedance.lark.pb.basic.v1.UniversalCardEntity;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PutActionRequest extends Message<PutActionRequest, Builder> {
    public static final ProtoAdapter<PutActionRequest> ADAPTER = null;
    public static final UniversalCardEntity.ActionDataSource DEFAULT_ACTION_DATA_SOURCE = null;
    public static final String DEFAULT_ACTION_ID = "";
    public static final Integer DEFAULT_APP_CARD_VERSION = null;
    public static final Integer DEFAULT_CONTENT_VERSION = null;
    public static final UniversalCardEntity.DataSource DEFAULT_DATA_SOURCE = null;
    public static final Boolean DEFAULT_IS_EPHEMERAL = null;
    public static final Boolean DEFAULT_IS_FROM_TRANSLATION = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final String DEFAULT_TRACE_ID = "";
    public static final ProtoAdapter_PutActionRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final UniversalCardEntity.ActionDataSource action_data_source;
    public final String action_id;
    public final Integer app_card_version;
    public final Integer content_version;
    public final UniversalCardEntity.DataSource data_source;
    public final Boolean is_ephemeral;
    public final Boolean is_from_translation;
    public final String message_id;
    public final Map<String, String> params;
    public final String trace_id;

    public static final class Builder extends Message.Builder<PutActionRequest, Builder> implements d<PutActionRequest> {
        public UniversalCardEntity.ActionDataSource action_data_source;
        public String action_id;
        public Integer app_card_version;
        public Integer content_version;
        public UniversalCardEntity.DataSource data_source;
        public Boolean is_ephemeral;
        public Boolean is_from_translation;
        public String message_id;
        public Map<String, String> params;
        public String trace_id;

        @Override // com.squareup.wire.Message.Builder
        public PutActionRequest build() {
            String r100 = this.action_id;
            if (r100 == null) goto L9;
            if (this.message_id == null) goto L9;
            return new PutActionRequest(this.action_id, this.params, this.message_id, this.content_version, this.is_ephemeral, this.trace_id, this.is_from_translation, this.app_card_version, this.data_source, this.action_data_source, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "action_id", this.message_id, MusicAppletPage.KEY_MESSAGE_ID});
        }

        public Builder() {
            this.params = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action_data_source(UniversalCardEntity.ActionDataSource r100) {
            this.action_data_source = r100;
            return this;
        }

        public Builder action_id(String r100) {
            this.action_id = r100;
            return this;
        }

        public Builder app_card_version(Integer r100) {
            this.app_card_version = r100;
            return this;
        }

        public Builder content_version(Integer r100) {
            this.content_version = r100;
            return this;
        }

        public Builder data_source(UniversalCardEntity.DataSource r100) {
            this.data_source = r100;
            return this;
        }

        public Builder is_ephemeral(Boolean r100) {
            this.is_ephemeral = r100;
            return this;
        }

        public Builder is_from_translation(Boolean r100) {
            this.is_from_translation = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder params(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.params = r100;
            return this;
        }

        public Builder trace_id(String r100) {
            this.trace_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PutActionRequest extends ProtoAdapter<PutActionRequest> implements c<PutActionRequest> {
        private final ProtoAdapter<Map<String, String>> params;

        public ProtoAdapter_PutActionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PutActionRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.params = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutActionRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.action_id = "";
            r101.message_id = "";
            r101.content_version = 0;
            Boolean r102 = Boolean.FALSE;
            r101.is_ephemeral = r102;
            r101.trace_id = "";
            r101.is_from_translation = r102;
            r101.app_card_version = 0;
            r101.data_source = UniversalCardEntity.DataSource.IM;
            r101.action_data_source = UniversalCardEntity.ActionDataSource.IM_CONTENT;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L23;
            switch(r104) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L27;
                case 10: goto L25;
                default: goto L6;
            };
        L25:
            r101.action_data_source = UniversalCardEntity.ActionDataSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L27:
            r101.data_source = UniversalCardEntity.DataSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            r101.app_card_version = ProtoAdapter.INT32.decode(r100);
            goto L3
        L16:
            r101.is_from_translation = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L17:
            r101.trace_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.is_ephemeral = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L19:
            r101.content_version = ProtoAdapter.INT32.decode(r100);
            goto L3
        L20:
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.params.putAll(this.params.decode(r100));
            goto L3
        L22:
            r101.action_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L23:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PutActionRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.action_id) + this.params.encodedSizeWithTag(2, r100.params)) + r101.encodedSizeWithTag(3, r100.message_id);
            Integer r103 = r100.content_version;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(4, r103);
        L6:
            int r106 = r102 + r105;
            Boolean r107 = r100.is_ephemeral;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.trace_id;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(6, r110);
        L14:
            int r112 = r109 + r111;
            Boolean r113 = r100.is_from_translation;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r113);
        L18:
            int r115 = r112 + r114;
            Integer r116 = r100.app_card_version;
            if (r116 == null) goto L21;
            int r117 = ProtoAdapter.INT32.encodedSizeWithTag(8, r116);
        L22:
            int r118 = r115 + r117;
            UniversalCardEntity.DataSource r119 = r100.data_source;
            if (r119 == null) goto L25;
            int r120 = UniversalCardEntity.DataSource.ADAPTER.encodedSizeWithTag(9, r119);
        L26:
            int r121 = r118 + r120;
            UniversalCardEntity.ActionDataSource r122 = r100.action_data_source;
            if (r122 == null) goto L30;
            r104 = UniversalCardEntity.ActionDataSource.ADAPTER.encodedSizeWithTag(10, r122);
        L30:
            return (r121 + r104) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ PutActionRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutActionRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutActionRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.action_id);
            this.params.encodeWithTag(r100, 2, r101.params);
            r102.encodeWithTag(r100, 3, r101.message_id);
            Integer r103 = r101.content_version;
            if (r103 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r103);
        L5:
            Boolean r104 = r101.is_ephemeral;
            if (r104 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r104);
        L8:
            String r105 = r101.trace_id;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 6, r105);
        L11:
            Boolean r106 = r101.is_from_translation;
            if (r106 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r106);
        L14:
            Integer r107 = r101.app_card_version;
            if (r107 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 8, r107);
        L17:
            UniversalCardEntity.DataSource r108 = r101.data_source;
            if (r108 == null) goto L20;
            UniversalCardEntity.DataSource.ADAPTER.encodeWithTag(r100, 9, r108);
        L20:
            UniversalCardEntity.ActionDataSource r109 = r101.action_data_source;
            if (r109 == null) goto L23;
            UniversalCardEntity.ActionDataSource.ADAPTER.encodeWithTag(r100, 10, r109);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutActionRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PutActionRequest r100 = new ProtoAdapter_PutActionRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_CONTENT_VERSION = 0;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_IS_EPHEMERAL = r101;
        DEFAULT_IS_FROM_TRANSLATION = r101;
        DEFAULT_APP_CARD_VERSION = 0;
        DEFAULT_DATA_SOURCE = UniversalCardEntity.DataSource.IM;
        DEFAULT_ACTION_DATA_SOURCE = UniversalCardEntity.ActionDataSource.IM_CONTENT;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.action_id = this.action_id;
        r100.params = Internal.copyOf("params", this.params);
        r100.message_id = this.message_id;
        r100.content_version = this.content_version;
        r100.is_ephemeral = this.is_ephemeral;
        r100.trace_id = this.trace_id;
        r100.is_from_translation = this.is_from_translation;
        r100.app_card_version = this.app_card_version;
        r100.data_source = this.data_source;
        r100.action_data_source = this.action_data_source;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PutActionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutActionRequest(String r110, Map<String, String> r111, String r112, Integer r113, Boolean r114, String r115, Boolean r116, Integer r210, UniversalCardEntity.DataSource r211, UniversalCardEntity.ActionDataSource r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public PutActionRequest(String r100, Map<String, String> r101, String r102, Integer r103, Boolean r104, String r105, Boolean r106, Integer r107, UniversalCardEntity.DataSource r110, UniversalCardEntity.ActionDataSource r111, ByteString r112) {
        super(ADAPTER, r112);
        this.action_id = r100;
        this.params = Internal.immutableCopyOf("params", r101);
        this.message_id = r102;
        this.content_version = r103;
        this.is_ephemeral = r104;
        this.trace_id = r105;
        this.is_from_translation = r106;
        this.app_card_version = r107;
        this.data_source = r110;
        this.action_data_source = r111;
    }
}
