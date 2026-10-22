package com.bytedance.lark.pb.openplatform.v1;

import com.bytedance.lark.pb.basic.v1.UniversalCardEntity;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class PutUniversalCardActionRequestInner extends Message<PutUniversalCardActionRequestInner, Builder> {
    public static final ProtoAdapter<PutUniversalCardActionRequestInner> ADAPTER = null;
    public static final String DEFAULT_ACTION_ID = "";
    public static final String DEFAULT_APP_CARD_VERSION = "";
    public static final String DEFAULT_CARD_ID = "";
    public static final String DEFAULT_SOURCE_ID = "";
    public static final Integer DEFAULT_SOURCE_TYPE = null;
    public static final String DEFAULT_TRACE_ID = "";
    public static final String DEFAULT_VERSION = "";
    private static final long serialVersionUID = 0;
    public final String action_id;
    public final String app_card_version;
    public final String card_id;
    public final Map<String, String> params;
    public final String source_id;
    public final Integer source_type;
    public final String trace_id;
    public final UniversalCardBizParam universal_card_biz_param;
    public final UniversalCardEntity universal_card_entity;
    public final String version;

    public static final class Builder extends Message.Builder<PutUniversalCardActionRequestInner, Builder> {
        public String action_id;
        public String app_card_version;
        public String card_id;
        public Map<String, String> params;
        public String source_id;
        public Integer source_type;
        public String trace_id;
        public UniversalCardBizParam universal_card_biz_param;
        public UniversalCardEntity universal_card_entity;
        public String version;

        @Override // com.squareup.wire.Message.Builder
        public PutUniversalCardActionRequestInner build() {
            String r100 = this.card_id;
            if (r100 == null) goto L11;
            if (this.version == null) goto L11;
            if (this.action_id == null) goto L11;
            return new PutUniversalCardActionRequestInner(this.card_id, this.version, this.action_id, this.params, this.source_id, this.source_type, this.trace_id, this.app_card_version, this.universal_card_biz_param, this.universal_card_entity, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "card_id", this.version, "version", this.action_id, "action_id"});
        }

        public Builder() {
            this.params = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action_id(String r100) {
            this.action_id = r100;
            return this;
        }

        public Builder app_card_version(String r100) {
            this.app_card_version = r100;
            return this;
        }

        public Builder card_id(String r100) {
            this.card_id = r100;
            return this;
        }

        public Builder params(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.params = r100;
            return this;
        }

        public Builder source_id(String r100) {
            this.source_id = r100;
            return this;
        }

        public Builder source_type(Integer r100) {
            this.source_type = r100;
            return this;
        }

        public Builder trace_id(String r100) {
            this.trace_id = r100;
            return this;
        }

        public Builder universal_card_biz_param(UniversalCardBizParam r100) {
            this.universal_card_biz_param = r100;
            return this;
        }

        public Builder universal_card_entity(UniversalCardEntity r100) {
            this.universal_card_entity = r100;
            return this;
        }

        public Builder version(String r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PutUniversalCardActionRequestInner extends ProtoAdapter<PutUniversalCardActionRequestInner> {
        private final ProtoAdapter<Map<String, String>> params;

        public ProtoAdapter_PutUniversalCardActionRequestInner() {
            super(FieldEncoding.LENGTH_DELIMITED, PutUniversalCardActionRequestInner.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.params = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutUniversalCardActionRequestInner decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.card_id = "";
            r101.version = "";
            r101.action_id = "";
            r101.source_id = "";
            r101.source_type = 0;
            r101.trace_id = "";
            r101.app_card_version = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            switch(r103) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L6;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L7:
            r101.universal_card_entity = UniversalCardEntity.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.universal_card_biz_param = UniversalCardBizParam.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.app_card_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.trace_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.source_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            r101.source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.params.putAll(this.params.decode(r100));
            goto L3
        L14:
            r101.action_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.card_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(PutUniversalCardActionRequestInner r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = ((r101.encodedSizeWithTag(1, r100.card_id) + r101.encodedSizeWithTag(2, r100.version)) + r101.encodedSizeWithTag(3, r100.action_id)) + this.params.encodedSizeWithTag(4, r100.params);
            String r103 = r100.source_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(6, r103);
        L6:
            int r106 = r102 + r105;
            Integer r107 = r100.source_type;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(7, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.trace_id;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(8, r110);
        L14:
            int r112 = r109 + r111;
            String r113 = r100.app_card_version;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(9, r113);
        L18:
            int r115 = r112 + r114;
            UniversalCardBizParam r116 = r100.universal_card_biz_param;
            if (r116 == null) goto L21;
            int r117 = UniversalCardBizParam.ADAPTER.encodedSizeWithTag(10, r116);
        L22:
            int r118 = r115 + r117;
            UniversalCardEntity r119 = r100.universal_card_entity;
            if (r119 == null) goto L26;
            r104 = UniversalCardEntity.ADAPTER.encodedSizeWithTag(11, r119);
        L26:
            return (r118 + r104) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ PutUniversalCardActionRequestInner decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutUniversalCardActionRequestInner r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutUniversalCardActionRequestInner r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.card_id);
            r102.encodeWithTag(r100, 2, r101.version);
            r102.encodeWithTag(r100, 3, r101.action_id);
            this.params.encodeWithTag(r100, 4, r101.params);
            String r103 = r101.source_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 6, r103);
        L5:
            Integer r104 = r101.source_type;
            if (r104 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 7, r104);
        L8:
            String r105 = r101.trace_id;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 8, r105);
        L11:
            String r106 = r101.app_card_version;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 9, r106);
        L14:
            UniversalCardBizParam r107 = r101.universal_card_biz_param;
            if (r107 == null) goto L17;
            UniversalCardBizParam.ADAPTER.encodeWithTag(r100, 10, r107);
        L17:
            UniversalCardEntity r108 = r101.universal_card_entity;
            if (r108 == null) goto L20;
            UniversalCardEntity.ADAPTER.encodeWithTag(r100, 11, r108);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutUniversalCardActionRequestInner r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PutUniversalCardActionRequestInner();
        DEFAULT_SOURCE_TYPE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.card_id = this.card_id;
        r100.version = this.version;
        r100.action_id = this.action_id;
        r100.params = Internal.copyOf("params", this.params);
        r100.source_id = this.source_id;
        r100.source_type = this.source_type;
        r100.trace_id = this.trace_id;
        r100.app_card_version = this.app_card_version;
        r100.universal_card_biz_param = this.universal_card_biz_param;
        r100.universal_card_entity = this.universal_card_entity;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PutUniversalCardActionRequestInner.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutUniversalCardActionRequestInner(String r110, String r111, String r112, Map<String, String> r113, String r114, Integer r115, String r116, String r210, UniversalCardBizParam r211, UniversalCardEntity r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public PutUniversalCardActionRequestInner(String r100, String r101, String r102, Map<String, String> r103, String r104, Integer r105, String r106, String r107, UniversalCardBizParam r110, UniversalCardEntity r111, ByteString r112) {
        super(ADAPTER, r112);
        this.card_id = r100;
        this.version = r101;
        this.action_id = r102;
        this.params = Internal.immutableCopyOf("params", r103);
        this.source_id = r104;
        this.source_type = r105;
        this.trace_id = r106;
        this.app_card_version = r107;
        this.universal_card_biz_param = r110;
        this.universal_card_entity = r111;
    }
}
