package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class PreviewHangPointPair extends com.squareup.wire.Message<PreviewHangPointPair, Builder> {
    public static final ProtoAdapter<PreviewHangPointPair> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, PreviewHangPoint> url_preview_hang_point_map;

    public static final class Builder extends com.squareup.wire.Message.Builder<PreviewHangPointPair, Builder> {
        public Map<String, PreviewHangPoint> url_preview_hang_point_map;

        @Override // com.squareup.wire.Message.Builder
        public PreviewHangPointPair build() {
            return new PreviewHangPointPair(this.url_preview_hang_point_map, super.buildUnknownFields());
        }

        public Builder() {
            this.url_preview_hang_point_map = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder url_preview_hang_point_map(Map<String, PreviewHangPoint> r100) {
            Internal.checkElementsNotNull(r100);
            this.url_preview_hang_point_map = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PreviewHangPointPair extends ProtoAdapter<PreviewHangPointPair> {
        private final ProtoAdapter<Map<String, PreviewHangPoint>> url_preview_hang_point_map;

        public ProtoAdapter_PreviewHangPointPair() {
            super(FieldEncoding.LENGTH_DELIMITED, PreviewHangPointPair.class);
            this.url_preview_hang_point_map = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, PreviewHangPoint.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PreviewHangPointPair decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.url_preview_hang_point_map.putAll(this.url_preview_hang_point_map.decode(r100));
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
        public int encodedSize2(PreviewHangPointPair r100) {
            return this.url_preview_hang_point_map.encodedSizeWithTag(1, r100.url_preview_hang_point_map) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PreviewHangPointPair decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PreviewHangPointPair r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PreviewHangPointPair r101) throws IOException {
            this.url_preview_hang_point_map.encodeWithTag(r100, 1, r101.url_preview_hang_point_map);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PreviewHangPointPair r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PreviewHangPointPair();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.url_preview_hang_point_map = Internal.copyOf("url_preview_hang_point_map", this.url_preview_hang_point_map);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PreviewHangPointPair.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public PreviewHangPointPair(Map<String, PreviewHangPoint> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PreviewHangPointPair(Map<String, PreviewHangPoint> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.url_preview_hang_point_map = Internal.immutableCopyOf("url_preview_hang_point_map", r100);
    }
}
