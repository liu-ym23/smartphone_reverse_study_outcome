package com.bytedance.lark.pb.feed.v1;

import com.bytedance.lark.pb.basic.v1.DeniedReason;
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
public final class GetRecentVisitTargetsResponse extends Message<GetRecentVisitTargetsResponse, Builder> {
    public static final ProtoAdapter<GetRecentVisitTargetsResponse> ADAPTER = null;
    public static final ProtoAdapter_GetRecentVisitTargetsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, DeniedReason> can_not_select_chatter_map;
    public final Map<String, Long> id_to_time_stamp;
    public final List<FeedEntityPreview> previews;

    public static final class Builder extends Message.Builder<GetRecentVisitTargetsResponse, Builder> implements d<GetRecentVisitTargetsResponse> {
        public Map<String, DeniedReason> can_not_select_chatter_map;
        public Map<String, Long> id_to_time_stamp;
        public List<FeedEntityPreview> previews;

        @Override // com.squareup.wire.Message.Builder
        public GetRecentVisitTargetsResponse build() {
            return new GetRecentVisitTargetsResponse(this.previews, this.can_not_select_chatter_map, this.id_to_time_stamp, super.buildUnknownFields());
        }

        public Builder() {
            this.previews = Internal.newMutableList();
            this.can_not_select_chatter_map = Internal.newMutableMap();
            this.id_to_time_stamp = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder can_not_select_chatter_map(Map<String, DeniedReason> r100) {
            Internal.checkElementsNotNull(r100);
            this.can_not_select_chatter_map = r100;
            return this;
        }

        public Builder id_to_time_stamp(Map<String, Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.id_to_time_stamp = r100;
            return this;
        }

        public Builder previews(List<FeedEntityPreview> r100) {
            Internal.checkElementsNotNull(r100);
            this.previews = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetRecentVisitTargetsResponse extends ProtoAdapter<GetRecentVisitTargetsResponse> implements c<GetRecentVisitTargetsResponse> {
        private final ProtoAdapter<Map<String, DeniedReason>> can_not_select_chatter_map;
        private final ProtoAdapter<Map<String, Long>> id_to_time_stamp;

        public ProtoAdapter_GetRecentVisitTargetsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetRecentVisitTargetsResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.can_not_select_chatter_map = ProtoAdapter.newMapAdapter(r100, DeniedReason.ADAPTER);
            this.id_to_time_stamp = ProtoAdapter.newMapAdapter(r100, ProtoAdapter.INT64);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetRecentVisitTargetsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.previews.add(FeedEntityPreview.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.can_not_select_chatter_map.putAll(this.can_not_select_chatter_map.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.id_to_time_stamp.putAll(this.id_to_time_stamp.decode(r100));
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
        public int encodedSize2(GetRecentVisitTargetsResponse r100) {
            return ((FeedEntityPreview.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.previews) + this.can_not_select_chatter_map.encodedSizeWithTag(2, r100.can_not_select_chatter_map)) + this.id_to_time_stamp.encodedSizeWithTag(3, r100.id_to_time_stamp)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetRecentVisitTargetsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetRecentVisitTargetsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetRecentVisitTargetsResponse r101) throws IOException {
            FeedEntityPreview.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.previews);
            this.can_not_select_chatter_map.encodeWithTag(r100, 2, r101.can_not_select_chatter_map);
            this.id_to_time_stamp.encodeWithTag(r100, 3, r101.id_to_time_stamp);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetRecentVisitTargetsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetRecentVisitTargetsResponse r100 = new ProtoAdapter_GetRecentVisitTargetsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.previews = Internal.copyOf("previews", this.previews);
        r100.can_not_select_chatter_map = Internal.copyOf("can_not_select_chatter_map", this.can_not_select_chatter_map);
        r100.id_to_time_stamp = Internal.copyOf("id_to_time_stamp", this.id_to_time_stamp);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetRecentVisitTargetsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetRecentVisitTargetsResponse(List<FeedEntityPreview> r100, Map<String, DeniedReason> r101, Map<String, Long> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetRecentVisitTargetsResponse(List<FeedEntityPreview> r100, Map<String, DeniedReason> r101, Map<String, Long> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.previews = Internal.immutableCopyOf("previews", r100);
        this.can_not_select_chatter_map = Internal.immutableCopyOf("can_not_select_chatter_map", r101);
        this.id_to_time_stamp = Internal.immutableCopyOf("id_to_time_stamp", r102);
    }
}
