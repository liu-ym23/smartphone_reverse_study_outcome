package com.bytedance.lark.pb.url.v1;

import com.bytedance.lark.pb.basic.v1.MessageLink;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
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
public final class PushPreviewsRequest extends Message<PushPreviewsRequest, Builder> {
    public static final ProtoAdapter<PushPreviewsRequest> ADAPTER = null;
    public static final ProtoAdapter_PushPreviewsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, MessageLink> message_links;
    public final List<PushNeedLazyLoadPreview> need_lazy_load_previews;
    public final Map<String, UrlPreviewEntity> preview_entities;

    public static final class Builder extends Message.Builder<PushPreviewsRequest, Builder> implements d<PushPreviewsRequest> {
        public Map<String, MessageLink> message_links;
        public List<PushNeedLazyLoadPreview> need_lazy_load_previews;
        public Map<String, UrlPreviewEntity> preview_entities;

        @Override // com.squareup.wire.Message.Builder
        public PushPreviewsRequest build() {
            return new PushPreviewsRequest(this.preview_entities, this.need_lazy_load_previews, this.message_links, super.buildUnknownFields());
        }

        public Builder() {
            this.preview_entities = Internal.newMutableMap();
            this.need_lazy_load_previews = Internal.newMutableList();
            this.message_links = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder message_links(Map<String, MessageLink> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_links = r100;
            return this;
        }

        public Builder need_lazy_load_previews(List<PushNeedLazyLoadPreview> r100) {
            Internal.checkElementsNotNull(r100);
            this.need_lazy_load_previews = r100;
            return this;
        }

        public Builder preview_entities(Map<String, UrlPreviewEntity> r100) {
            Internal.checkElementsNotNull(r100);
            this.preview_entities = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushPreviewsRequest extends ProtoAdapter<PushPreviewsRequest> implements c<PushPreviewsRequest> {
        private final ProtoAdapter<Map<String, MessageLink>> message_links;
        private final ProtoAdapter<Map<String, UrlPreviewEntity>> preview_entities;

        public ProtoAdapter_PushPreviewsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PushPreviewsRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.preview_entities = ProtoAdapter.newMapAdapter(r100, UrlPreviewEntity.ADAPTER);
            this.message_links = ProtoAdapter.newMapAdapter(r100, MessageLink.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushPreviewsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.preview_entities.putAll(this.preview_entities.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.need_lazy_load_previews.add(PushNeedLazyLoadPreview.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.message_links.putAll(this.message_links.decode(r100));
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
        public int encodedSize2(PushPreviewsRequest r100) {
            return ((this.preview_entities.encodedSizeWithTag(1, r100.preview_entities) + PushNeedLazyLoadPreview.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.need_lazy_load_previews)) + this.message_links.encodedSizeWithTag(3, r100.message_links)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushPreviewsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushPreviewsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushPreviewsRequest r101) throws IOException {
            this.preview_entities.encodeWithTag(r100, 1, r101.preview_entities);
            PushNeedLazyLoadPreview.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.need_lazy_load_previews);
            this.message_links.encodeWithTag(r100, 3, r101.message_links);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushPreviewsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushPreviewsRequest r100 = new ProtoAdapter_PushPreviewsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.preview_entities = Internal.copyOf("preview_entities", this.preview_entities);
        r100.need_lazy_load_previews = Internal.copyOf("need_lazy_load_previews", this.need_lazy_load_previews);
        r100.message_links = Internal.copyOf("message_links", this.message_links);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushPreviewsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushPreviewsRequest(Map<String, UrlPreviewEntity> r100, List<PushNeedLazyLoadPreview> r101, Map<String, MessageLink> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PushPreviewsRequest(Map<String, UrlPreviewEntity> r100, List<PushNeedLazyLoadPreview> r101, Map<String, MessageLink> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.preview_entities = Internal.immutableCopyOf("preview_entities", r100);
        this.need_lazy_load_previews = Internal.immutableCopyOf("need_lazy_load_previews", r101);
        this.message_links = Internal.immutableCopyOf("message_links", r102);
    }
}
