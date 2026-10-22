package com.bytedance.lark.pb.url.v1;

import com.bytedance.lark.pb.basic.v1.PreviewHangPoint;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
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
public final class GetPreviewByHangPointsRequest extends Message<GetPreviewByHangPointsRequest, Builder> {
    public static final ProtoAdapter<GetPreviewByHangPointsRequest> ADAPTER = null;
    public static final Boolean DEFAULT_NEED_UPLOAD_LOCAL_PREVIEW = null;
    public static final SyncDataStrategy DEFAULT_SYNC_DATA_STRATEGY = null;
    public static final ProtoAdapter_GetPreviewByHangPointsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean need_upload_local_preview;
    public final List<PreviewHangPoint> preview_hang_points;
    public final Map<String, String> preview_id2source_ids;
    public final SyncDataStrategy sync_data_strategy;

    public static final class Builder extends Message.Builder<GetPreviewByHangPointsRequest, Builder> implements d<GetPreviewByHangPointsRequest> {
        public Boolean need_upload_local_preview;
        public List<PreviewHangPoint> preview_hang_points;
        public Map<String, String> preview_id2source_ids;
        public SyncDataStrategy sync_data_strategy;

        @Override // com.squareup.wire.Message.Builder
        public GetPreviewByHangPointsRequest build() {
            return new GetPreviewByHangPointsRequest(this.preview_hang_points, this.preview_id2source_ids, this.sync_data_strategy, this.need_upload_local_preview, super.buildUnknownFields());
        }

        public Builder() {
            this.preview_hang_points = Internal.newMutableList();
            this.preview_id2source_ids = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder need_upload_local_preview(Boolean r100) {
            this.need_upload_local_preview = r100;
            return this;
        }

        public Builder preview_hang_points(List<PreviewHangPoint> r100) {
            Internal.checkElementsNotNull(r100);
            this.preview_hang_points = r100;
            return this;
        }

        public Builder preview_id2source_ids(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.preview_id2source_ids = r100;
            return this;
        }

        public Builder sync_data_strategy(SyncDataStrategy r100) {
            this.sync_data_strategy = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetPreviewByHangPointsRequest extends ProtoAdapter<GetPreviewByHangPointsRequest> implements c<GetPreviewByHangPointsRequest> {
        private final ProtoAdapter<Map<String, String>> preview_id2source_ids;

        public ProtoAdapter_GetPreviewByHangPointsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetPreviewByHangPointsRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.preview_id2source_ids = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetPreviewByHangPointsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.sync_data_strategy = SyncDataStrategy.LOCAL;
            r101.need_upload_local_preview = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.preview_hang_points.add(PreviewHangPoint.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.preview_id2source_ids.putAll(this.preview_id2source_ids.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.sync_data_strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.need_upload_local_preview = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetPreviewByHangPointsRequest r100) {
            int r101 = PreviewHangPoint.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.preview_hang_points) + this.preview_id2source_ids.encodedSizeWithTag(2, r100.preview_id2source_ids);
            SyncDataStrategy r102 = r100.sync_data_strategy;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(3, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.need_upload_local_preview;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetPreviewByHangPointsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetPreviewByHangPointsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetPreviewByHangPointsRequest r101) throws IOException {
            PreviewHangPoint.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.preview_hang_points);
            this.preview_id2source_ids.encodeWithTag(r100, 2, r101.preview_id2source_ids);
            SyncDataStrategy r102 = r101.sync_data_strategy;
            if (r102 == null) goto L5;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 3, r102);
        L5:
            Boolean r103 = r101.need_upload_local_preview;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetPreviewByHangPointsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetPreviewByHangPointsRequest r100 = new ProtoAdapter_GetPreviewByHangPointsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SYNC_DATA_STRATEGY = SyncDataStrategy.LOCAL;
        DEFAULT_NEED_UPLOAD_LOCAL_PREVIEW = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.preview_hang_points = Internal.copyOf("preview_hang_points", this.preview_hang_points);
        r100.preview_id2source_ids = Internal.copyOf("preview_id2source_ids", this.preview_id2source_ids);
        r100.sync_data_strategy = this.sync_data_strategy;
        r100.need_upload_local_preview = this.need_upload_local_preview;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetPreviewByHangPointsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetPreviewByHangPointsRequest(List<PreviewHangPoint> r100, Map<String, String> r101, SyncDataStrategy r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetPreviewByHangPointsRequest(List<PreviewHangPoint> r100, Map<String, String> r101, SyncDataStrategy r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.preview_hang_points = Internal.immutableCopyOf("preview_hang_points", r100);
        this.preview_id2source_ids = Internal.immutableCopyOf("preview_id2source_ids", r101);
        this.sync_data_strategy = r102;
        this.need_upload_local_preview = r103;
    }
}
