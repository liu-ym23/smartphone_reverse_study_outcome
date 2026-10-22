package com.bytedance.lark.pb.ugreach.v1;

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
public final class ScenarioContextCache extends Message<ScenarioContextCache, Builder> {
    public static final ProtoAdapter<ScenarioContextCache> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ScenarioContext meta;
    public final Map<String, Long> rpid2update_time;

    public static final class Builder extends Message.Builder<ScenarioContextCache, Builder> {
        public ScenarioContext meta;
        public Map<String, Long> rpid2update_time;

        @Override // com.squareup.wire.Message.Builder
        public ScenarioContextCache build() {
            return new ScenarioContextCache(this.meta, this.rpid2update_time, super.buildUnknownFields());
        }

        public Builder() {
            this.rpid2update_time = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder meta(ScenarioContext r100) {
            this.meta = r100;
            return this;
        }

        public Builder rpid2update_time(Map<String, Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.rpid2update_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ScenarioContextCache extends ProtoAdapter<ScenarioContextCache> {
        private final ProtoAdapter<Map<String, Long>> rpid2update_time;

        public ProtoAdapter_ScenarioContextCache() {
            super(FieldEncoding.LENGTH_DELIMITED, ScenarioContextCache.class);
            this.rpid2update_time = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.INT64);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ScenarioContextCache decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.meta = ScenarioContext.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.rpid2update_time.putAll(this.rpid2update_time.decode(r100));
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
        public int encodedSize2(ScenarioContextCache r100) {
            ScenarioContext r101 = r100.meta;
            if (r101 == null) goto L5;
            int r102 = ScenarioContext.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + this.rpid2update_time.encodedSizeWithTag(2, r100.rpid2update_time)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ScenarioContextCache decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ScenarioContextCache r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ScenarioContextCache r101) throws IOException {
            ScenarioContext r102 = r101.meta;
            if (r102 == null) goto L5;
            ScenarioContext.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            this.rpid2update_time.encodeWithTag(r100, 2, r101.rpid2update_time);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ScenarioContextCache r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ScenarioContextCache();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.meta = this.meta;
        r100.rpid2update_time = Internal.copyOf("rpid2update_time", this.rpid2update_time);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ScenarioContextCache.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ScenarioContextCache(ScenarioContext r100, Map<String, Long> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ScenarioContextCache(ScenarioContext r100, Map<String, Long> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.meta = r100;
        this.rpid2update_time = Internal.immutableCopyOf("rpid2update_time", r101);
    }
}
