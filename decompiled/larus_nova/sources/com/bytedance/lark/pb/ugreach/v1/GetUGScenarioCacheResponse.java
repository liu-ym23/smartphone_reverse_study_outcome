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
public final class GetUGScenarioCacheResponse extends Message<GetUGScenarioCacheResponse, Builder> {
    public static final ProtoAdapter<GetUGScenarioCacheResponse> ADAPTER = null;
    public static final ProtoAdapter_GetUGScenarioCacheResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ScenarioContextCache scenario_cache;

    public static final class Builder extends Message.Builder<GetUGScenarioCacheResponse, Builder> implements d<GetUGScenarioCacheResponse> {
        public ScenarioContextCache scenario_cache;

        @Override // com.squareup.wire.Message.Builder
        public GetUGScenarioCacheResponse build() {
            return new GetUGScenarioCacheResponse(this.scenario_cache, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder scenario_cache(ScenarioContextCache r100) {
            this.scenario_cache = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUGScenarioCacheResponse extends ProtoAdapter<GetUGScenarioCacheResponse> implements c<GetUGScenarioCacheResponse> {
        public ProtoAdapter_GetUGScenarioCacheResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUGScenarioCacheResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUGScenarioCacheResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.scenario_cache = ScenarioContextCache.ADAPTER.decode(r100);
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetUGScenarioCacheResponse r100) {
            ScenarioContextCache r101 = r100.scenario_cache;
            if (r101 == null) goto L5;
            int r102 = ScenarioContextCache.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUGScenarioCacheResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUGScenarioCacheResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUGScenarioCacheResponse r101) throws IOException {
            ScenarioContextCache r102 = r101.scenario_cache;
            if (r102 == null) goto L5;
            ScenarioContextCache.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUGScenarioCacheResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetUGScenarioCacheResponse r100 = new ProtoAdapter_GetUGScenarioCacheResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.scenario_cache = this.scenario_cache;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUGScenarioCacheResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUGScenarioCacheResponse(ScenarioContextCache r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetUGScenarioCacheResponse(ScenarioContextCache r100, ByteString r101) {
        super(ADAPTER, r101);
        this.scenario_cache = r100;
    }
}
