package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class ReportUGEventRequest extends Message<ReportUGEventRequest, Builder> {
    public static final ProtoAdapter<ReportUGEventRequest> ADAPTER = null;
    public static final String DEFAULT_EVENT_NAME = "";
    public static final Long DEFAULT_LOCAL_RULE_ID = null;
    public static final String DEFAULT_MATERIAL_KEY = "";
    public static final String DEFAULT_REACH_POINT_ID = "";
    public static final String DEFAULT_SCENARIO_ID = "";
    private static final long serialVersionUID = 0;
    public final ConsumeType mconsume_type;
    public final String mevent_name;
    public final Long mlocal_rule_id;
    public final String mmaterial_key;
    public final String mreach_point_id;
    public final String mscenario_id;
    public final Map<String, String> mupload_context;

    public static final class Builder extends Message.Builder<ReportUGEventRequest, Builder> {
        public ConsumeType mconsume_type;
        public String mevent_name;
        public Long mlocal_rule_id;
        public String mmaterial_key;
        public String mreach_point_id;
        public String mscenario_id;
        public Map<String, String> mupload_context;

        @Override // com.squareup.wire.Message.Builder
        public ReportUGEventRequest build() {
            return new ReportUGEventRequest(this.mscenario_id, this.mreach_point_id, this.mmaterial_key, this.mlocal_rule_id, this.mevent_name, this.mupload_context, this.mconsume_type, super.buildUnknownFields());
        }

        public Builder() {
            this.mupload_context = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder consume_type(ConsumeType r100) {
            this.mconsume_type = r100;
            return this;
        }

        public Builder event_name(String r100) {
            this.mevent_name = r100;
            return this;
        }

        public Builder local_rule_id(Long r100) {
            this.mlocal_rule_id = r100;
            return this;
        }

        public Builder material_key(String r100) {
            this.mmaterial_key = r100;
            return this;
        }

        public Builder reach_point_id(String r100) {
            this.mreach_point_id = r100;
            return this;
        }

        public Builder scenario_id(String r100) {
            this.mscenario_id = r100;
            return this;
        }

        public Builder upload_context(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mupload_context = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ReportUGEventRequest extends ProtoAdapter<ReportUGEventRequest> {
        private final ProtoAdapter<Map<String, String>> mupload_context;

        public ProtoAdapter_ReportUGEventRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, ReportUGEventRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mupload_context = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ReportUGEventRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mscenario_id = "";
            r101.mreach_point_id = "";
            r101.mmaterial_key = "";
            r101.mlocal_rule_id = 0L;
            r101.mevent_name = "";
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
                case 7: goto L19;
                default: goto L6;
            };
        L19:
            r101.mconsume_type = ConsumeType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.mupload_context.putAll(this.mupload_context.decode(r100));
            goto L3
        L12:
            r101.mevent_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.mlocal_rule_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            r101.mmaterial_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.mreach_point_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.mscenario_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(ReportUGEventRequest r100) {
            String r101 = r100.mscenario_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mreach_point_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mmaterial_key;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.mlocal_rule_id;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.mevent_name;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = (r112 + r114) + this.mupload_context.encodedSizeWithTag(6, r100.mupload_context);
            ConsumeType r116 = r100.mconsume_type;
            if (r116 == null) goto L26;
            r102 = ConsumeType.ADAPTER.encodedSizeWithTag(7, r116);
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
        public /* bridge */ /* synthetic */ ReportUGEventRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ReportUGEventRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ReportUGEventRequest r101) throws IOException {
            String r102 = r101.mscenario_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mreach_point_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mmaterial_key;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.mlocal_rule_id;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.mevent_name;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            this.mupload_context.encodeWithTag(r100, 6, r101.mupload_context);
            ConsumeType r107 = r101.mconsume_type;
            if (r107 == null) goto L20;
            ConsumeType.ADAPTER.encodeWithTag(r100, 7, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ReportUGEventRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ReportUGEventRequest();
        DEFAULT_LOCAL_RULE_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mscenario_id = this.mscenario_id;
        r100.mreach_point_id = this.mreach_point_id;
        r100.mmaterial_key = this.mmaterial_key;
        r100.mlocal_rule_id = this.mlocal_rule_id;
        r100.mevent_name = this.mevent_name;
        r100.mupload_context = Internal.copyOf("mupload_context", this.mupload_context);
        r100.mconsume_type = this.mconsume_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ReportUGEventRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ReportUGEventRequest(String r110, String r111, String r112, Long r113, String r114, Map<String, String> r115, ConsumeType r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public ReportUGEventRequest(String r100, String r101, String r102, Long r103, String r104, Map<String, String> r105, ConsumeType r106, ByteString r107) {
        super(ADAPTER, r107);
        this.mscenario_id = r100;
        this.mreach_point_id = r101;
        this.mmaterial_key = r102;
        this.mlocal_rule_id = r103;
        this.mevent_name = r104;
        this.mupload_context = Internal.immutableCopyOf("mupload_context", r105);
        this.mconsume_type = r106;
    }
}
