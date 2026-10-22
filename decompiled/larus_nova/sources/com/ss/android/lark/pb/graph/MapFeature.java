package com.ss.android.lark.pb.graph;

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
public final class MapFeature extends Message<MapFeature, Builder> {
    public static final ProtoAdapter<MapFeature> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, Double> mfeature_map;

    public static final class Builder extends Message.Builder<MapFeature, Builder> {
        public Map<String, Double> mfeature_map;

        @Override // com.squareup.wire.Message.Builder
        public MapFeature build() {
            return new MapFeature(this.mfeature_map, super.buildUnknownFields());
        }

        public Builder() {
            this.mfeature_map = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder feature_map(Map<String, Double> r100) {
            Internal.checkElementsNotNull(r100);
            this.mfeature_map = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MapFeature extends ProtoAdapter<MapFeature> {
        private final ProtoAdapter<Map<String, Double>> mfeature_map;

        public ProtoAdapter_MapFeature() {
            super(FieldEncoding.LENGTH_DELIMITED, MapFeature.class);
            this.mfeature_map = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.DOUBLE);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MapFeature decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mfeature_map.putAll(this.mfeature_map.decode(r100));
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
        public int encodedSize2(MapFeature r100) {
            return this.mfeature_map.encodedSizeWithTag(1, r100.mfeature_map) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MapFeature decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MapFeature r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MapFeature r101) throws IOException {
            this.mfeature_map.encodeWithTag(r100, 1, r101.mfeature_map);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MapFeature r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MapFeature();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mfeature_map = Internal.copyOf("mfeature_map", this.mfeature_map);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MapFeature.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MapFeature(Map<String, Double> r100) {
        this(r100, ByteString.EMPTY);
    }

    public MapFeature(Map<String, Double> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mfeature_map = Internal.immutableCopyOf("mfeature_map", r100);
    }
}
