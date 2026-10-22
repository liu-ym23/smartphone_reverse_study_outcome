package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.basic.v1.UrlPreviewHangPoint;
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
public final class GetMessagePreviewsRequest extends Message<GetMessagePreviewsRequest, Builder> {
    public static final ProtoAdapter<GetMessagePreviewsRequest> ADAPTER = null;
    public static final SyncDataStrategy DEFAULT_SYNC_DATA_STRATEGY = null;
    public static final ProtoAdapter_GetMessagePreviewsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, UrlPreviewHangPointPair> hang_point_pair_map;
    public final Map<String, PreviewPair> message_preview_map;
    public final SyncDataStrategy sync_data_strategy;

    public static final class Builder extends Message.Builder<GetMessagePreviewsRequest, Builder> implements d<GetMessagePreviewsRequest> {
        public Map<String, UrlPreviewHangPointPair> hang_point_pair_map;
        public Map<String, PreviewPair> message_preview_map;
        public SyncDataStrategy sync_data_strategy;

        @Override // com.squareup.wire.Message.Builder
        public GetMessagePreviewsRequest build() {
            return new GetMessagePreviewsRequest(this.message_preview_map, this.hang_point_pair_map, this.sync_data_strategy, super.buildUnknownFields());
        }

        public Builder() {
            this.message_preview_map = Internal.newMutableMap();
            this.hang_point_pair_map = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder hang_point_pair_map(Map<String, UrlPreviewHangPointPair> r100) {
            Internal.checkElementsNotNull(r100);
            this.hang_point_pair_map = r100;
            return this;
        }

        public Builder message_preview_map(Map<String, PreviewPair> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_preview_map = r100;
            return this;
        }

        public Builder sync_data_strategy(SyncDataStrategy r100) {
            this.sync_data_strategy = r100;
            return this;
        }
    }

    public static final class PreviewPair extends Message<PreviewPair, Builder> {
        public static final ProtoAdapter<PreviewPair> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> preview_ids;

        public static final class Builder extends Message.Builder<PreviewPair, Builder> {
            public List<String> preview_ids;

            @Override // com.squareup.wire.Message.Builder
            public PreviewPair build() {
                return new PreviewPair(this.preview_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.preview_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder preview_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.preview_ids = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_PreviewPair extends ProtoAdapter<PreviewPair> {
            public ProtoAdapter_PreviewPair() {
                super(FieldEncoding.LENGTH_DELIMITED, PreviewPair.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PreviewPair decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.preview_ids.add(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(PreviewPair r100) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.preview_ids) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ PreviewPair decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(PreviewPair r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, PreviewPair r101) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.preview_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PreviewPair r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_PreviewPair();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.preview_ids = Internal.copyOf("preview_ids", this.preview_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return PreviewPair.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public PreviewPair(List<String> r100) {
            this(r100, ByteString.EMPTY);
        }

        public PreviewPair(List<String> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.preview_ids = Internal.immutableCopyOf("preview_ids", r100);
        }
    }

    public static final class ProtoAdapter_GetMessagePreviewsRequest extends ProtoAdapter<GetMessagePreviewsRequest> implements c<GetMessagePreviewsRequest> {
        private final ProtoAdapter<Map<String, UrlPreviewHangPointPair>> hang_point_pair_map;
        private final ProtoAdapter<Map<String, PreviewPair>> message_preview_map;

        public ProtoAdapter_GetMessagePreviewsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetMessagePreviewsRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.message_preview_map = ProtoAdapter.newMapAdapter(r100, PreviewPair.ADAPTER);
            this.hang_point_pair_map = ProtoAdapter.newMapAdapter(r100, UrlPreviewHangPointPair.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetMessagePreviewsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.sync_data_strategy = SyncDataStrategy.TRY_LOCAL;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.message_preview_map.putAll(this.message_preview_map.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.hang_point_pair_map.putAll(this.hang_point_pair_map.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.sync_data_strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetMessagePreviewsRequest r100) {
            int r101 = this.message_preview_map.encodedSizeWithTag(1, r100.message_preview_map) + this.hang_point_pair_map.encodedSizeWithTag(2, r100.hang_point_pair_map);
            SyncDataStrategy r102 = r100.sync_data_strategy;
            if (r102 == null) goto L5;
            int r103 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(3, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetMessagePreviewsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetMessagePreviewsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetMessagePreviewsRequest r101) throws IOException {
            this.message_preview_map.encodeWithTag(r100, 1, r101.message_preview_map);
            this.hang_point_pair_map.encodeWithTag(r100, 2, r101.hang_point_pair_map);
            SyncDataStrategy r102 = r101.sync_data_strategy;
            if (r102 == null) goto L5;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 3, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetMessagePreviewsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class UrlPreviewHangPointPair extends Message<UrlPreviewHangPointPair, Builder> {
        public static final ProtoAdapter<UrlPreviewHangPointPair> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<UrlPreviewHangPoint> hang_points;

        public static final class Builder extends Message.Builder<UrlPreviewHangPointPair, Builder> {
            public List<UrlPreviewHangPoint> hang_points;

            @Override // com.squareup.wire.Message.Builder
            public UrlPreviewHangPointPair build() {
                return new UrlPreviewHangPointPair(this.hang_points, super.buildUnknownFields());
            }

            public Builder() {
                this.hang_points = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder hang_points(List<UrlPreviewHangPoint> r100) {
                Internal.checkElementsNotNull(r100);
                this.hang_points = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_UrlPreviewHangPointPair extends ProtoAdapter<UrlPreviewHangPointPair> {
            public ProtoAdapter_UrlPreviewHangPointPair() {
                super(FieldEncoding.LENGTH_DELIMITED, UrlPreviewHangPointPair.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UrlPreviewHangPointPair decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.hang_points.add(UrlPreviewHangPoint.ADAPTER.decode(r100));
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
            public int encodedSize2(UrlPreviewHangPointPair r100) {
                return UrlPreviewHangPoint.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.hang_points) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ UrlPreviewHangPointPair decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(UrlPreviewHangPointPair r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, UrlPreviewHangPointPair r101) throws IOException {
                UrlPreviewHangPoint.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.hang_points);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UrlPreviewHangPointPair r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UrlPreviewHangPointPair();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.hang_points = Internal.copyOf("hang_points", this.hang_points);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return UrlPreviewHangPointPair.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public UrlPreviewHangPointPair(List<UrlPreviewHangPoint> r100) {
            this(r100, ByteString.EMPTY);
        }

        public UrlPreviewHangPointPair(List<UrlPreviewHangPoint> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.hang_points = Internal.immutableCopyOf("hang_points", r100);
        }
    }

    static {
        ProtoAdapter_GetMessagePreviewsRequest r100 = new ProtoAdapter_GetMessagePreviewsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SYNC_DATA_STRATEGY = SyncDataStrategy.TRY_LOCAL;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_preview_map = Internal.copyOf("message_preview_map", this.message_preview_map);
        r100.hang_point_pair_map = Internal.copyOf("hang_point_pair_map", this.hang_point_pair_map);
        r100.sync_data_strategy = this.sync_data_strategy;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetMessagePreviewsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetMessagePreviewsRequest(Map<String, PreviewPair> r100, Map<String, UrlPreviewHangPointPair> r101, SyncDataStrategy r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetMessagePreviewsRequest(Map<String, PreviewPair> r100, Map<String, UrlPreviewHangPointPair> r101, SyncDataStrategy r102, ByteString r103) {
        super(ADAPTER, r103);
        this.message_preview_map = Internal.immutableCopyOf("message_preview_map", r100);
        this.hang_point_pair_map = Internal.immutableCopyOf("hang_point_pair_map", r101);
        this.sync_data_strategy = r102;
    }
}
