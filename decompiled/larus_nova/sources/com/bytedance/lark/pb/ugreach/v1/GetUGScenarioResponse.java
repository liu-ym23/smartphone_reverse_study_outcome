package com.bytedance.lark.pb.ugreach.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetUGScenarioResponse extends Message<GetUGScenarioResponse, Builder> {
    public static final ProtoAdapter<GetUGScenarioResponse> ADAPTER = null;
    public static final String DEFAULT_SCENARIO_ID = "";
    public static final ProtoAdapter_GetUGScenarioResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ScenarioContext scenario_context;
    public final String scenario_id;

    public static final class Builder extends Message.Builder<GetUGScenarioResponse, Builder> implements d<GetUGScenarioResponse> {
        public ScenarioContext scenario_context;
        public String scenario_id;

        @Override // com.squareup.wire.Message.Builder
        public GetUGScenarioResponse build() {
            return new GetUGScenarioResponse(this.scenario_id, this.scenario_context, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder scenario_context(ScenarioContext r100) {
            this.scenario_context = r100;
            return this;
        }

        public Builder scenario_id(String r100) {
            this.scenario_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUGScenarioResponse extends ProtoAdapter<GetUGScenarioResponse> implements c<GetUGScenarioResponse> {
        public ProtoAdapter_GetUGScenarioResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUGScenarioResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUGScenarioResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.scenario_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.scenario_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.scenario_context = ScenarioContext.ADAPTER.decode(r100);
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
        public int encodedSize2(GetUGScenarioResponse r100) {
            String r101 = r100.scenario_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            ScenarioContext r104 = r100.scenario_context;
            if (r104 == null) goto L10;
            r102 = ScenarioContext.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUGScenarioResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUGScenarioResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUGScenarioResponse r101) throws IOException {
            String r102 = r101.scenario_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ScenarioContext r103 = r101.scenario_context;
            if (r103 == null) goto L8;
            ScenarioContext.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUGScenarioResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetUGScenarioResponse r100 = new ProtoAdapter_GetUGScenarioResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.scenario_id = this.scenario_id;
        r100.scenario_context = this.scenario_context;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUGScenarioResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUGScenarioResponse(String r100, ScenarioContext r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetUGScenarioResponse(String r100, ScenarioContext r101, ByteString r102) {
        super(ADAPTER, r102);
        this.scenario_id = r100;
        this.scenario_context = r101;
    }
}
