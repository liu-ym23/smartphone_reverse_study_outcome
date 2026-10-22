package com.bytedance.lark.pb.ugreach.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetUGScenarioRequest extends Message<GetUGScenarioRequest, Builder> {
    public static final ProtoAdapter<GetUGScenarioRequest> ADAPTER = null;
    public static final String DEFAULT_SCENARIO_ID = "";
    public static final ProtoAdapter_GetUGScenarioRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> biz_context;
    public final String scenario_id;
    public final List<String> specified_reach_point_ids;

    public static final class Builder extends Message.Builder<GetUGScenarioRequest, Builder> implements d<GetUGScenarioRequest> {
        public Map<String, String> biz_context;
        public String scenario_id;
        public List<String> specified_reach_point_ids;

        @Override // com.squareup.wire.Message.Builder
        public GetUGScenarioRequest build() {
            return new GetUGScenarioRequest(this.scenario_id, this.specified_reach_point_ids, this.biz_context, super.buildUnknownFields());
        }

        public Builder() {
            this.specified_reach_point_ids = Internal.newMutableList();
            this.biz_context = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder biz_context(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.biz_context = r100;
            return this;
        }

        public Builder scenario_id(String r100) {
            this.scenario_id = r100;
            return this;
        }

        public Builder specified_reach_point_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.specified_reach_point_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUGScenarioRequest extends ProtoAdapter<GetUGScenarioRequest> implements c<GetUGScenarioRequest> {
        private final ProtoAdapter<Map<String, String>> biz_context;

        public ProtoAdapter_GetUGScenarioRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUGScenarioRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.biz_context = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUGScenarioRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.scenario_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.scenario_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.specified_reach_point_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.biz_context.putAll(this.biz_context.decode(r100));
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
        public int encodedSize2(GetUGScenarioRequest r100) {
            String r101 = r100.scenario_id;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L7:
            return ((r102 + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.specified_reach_point_ids)) + this.biz_context.encodedSizeWithTag(3, r100.biz_context)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUGScenarioRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUGScenarioRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUGScenarioRequest r101) throws IOException {
            String r102 = r101.scenario_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.specified_reach_point_ids);
            this.biz_context.encodeWithTag(r100, 3, r101.biz_context);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUGScenarioRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetUGScenarioRequest r100 = new ProtoAdapter_GetUGScenarioRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.scenario_id = this.scenario_id;
        r100.specified_reach_point_ids = Internal.copyOf("specified_reach_point_ids", this.specified_reach_point_ids);
        r100.biz_context = Internal.copyOf("biz_context", this.biz_context);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUGScenarioRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUGScenarioRequest(String r100, List<String> r101, Map<String, String> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetUGScenarioRequest(String r100, List<String> r101, Map<String, String> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.scenario_id = r100;
        this.specified_reach_point_ids = Internal.immutableCopyOf("specified_reach_point_ids", r101);
        this.biz_context = Internal.immutableCopyOf("biz_context", r102);
    }
}
