package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.MessageLink;
import com.bytedance.lark.pb.basic.v1.PreviewEntityPair;
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
public final class PushMessagePreviewsRequest extends Message<PushMessagePreviewsRequest, Builder> {
    public static final ProtoAdapter<PushMessagePreviewsRequest> ADAPTER = null;
    public static final ProtoAdapter_PushMessagePreviewsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, MessageLink> message_links;
    public final Map<String, PreviewPair> need_load_ids;
    public final Map<String, PreviewEntityPair> preview_entities;

    public static final class Builder extends Message.Builder<PushMessagePreviewsRequest, Builder> implements d<PushMessagePreviewsRequest> {
        public Map<String, MessageLink> message_links;
        public Map<String, PreviewPair> need_load_ids;
        public Map<String, PreviewEntityPair> preview_entities;

        @Override // com.squareup.wire.Message.Builder
        public PushMessagePreviewsRequest build() {
            return new PushMessagePreviewsRequest(this.preview_entities, this.need_load_ids, this.message_links, super.buildUnknownFields());
        }

        public Builder() {
            this.preview_entities = Internal.newMutableMap();
            this.need_load_ids = Internal.newMutableMap();
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

        public Builder need_load_ids(Map<String, PreviewPair> r100) {
            Internal.checkElementsNotNull(r100);
            this.need_load_ids = r100;
            return this;
        }

        public Builder preview_entities(Map<String, PreviewEntityPair> r100) {
            Internal.checkElementsNotNull(r100);
            this.preview_entities = r100;
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

    public static final class ProtoAdapter_PushMessagePreviewsRequest extends ProtoAdapter<PushMessagePreviewsRequest> implements c<PushMessagePreviewsRequest> {
        private final ProtoAdapter<Map<String, MessageLink>> message_links;
        private final ProtoAdapter<Map<String, PreviewPair>> need_load_ids;
        private final ProtoAdapter<Map<String, PreviewEntityPair>> preview_entities;

        public ProtoAdapter_PushMessagePreviewsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PushMessagePreviewsRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.preview_entities = ProtoAdapter.newMapAdapter(r100, PreviewEntityPair.ADAPTER);
            this.need_load_ids = ProtoAdapter.newMapAdapter(r100, PreviewPair.ADAPTER);
            this.message_links = ProtoAdapter.newMapAdapter(r100, MessageLink.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushMessagePreviewsRequest decode(ProtoReader r100) throws IOException {
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
            r101.need_load_ids.putAll(this.need_load_ids.decode(r100));
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
        public int encodedSize2(PushMessagePreviewsRequest r100) {
            return ((this.preview_entities.encodedSizeWithTag(1, r100.preview_entities) + this.need_load_ids.encodedSizeWithTag(2, r100.need_load_ids)) + this.message_links.encodedSizeWithTag(3, r100.message_links)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushMessagePreviewsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushMessagePreviewsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushMessagePreviewsRequest r101) throws IOException {
            this.preview_entities.encodeWithTag(r100, 1, r101.preview_entities);
            this.need_load_ids.encodeWithTag(r100, 2, r101.need_load_ids);
            this.message_links.encodeWithTag(r100, 3, r101.message_links);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushMessagePreviewsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushMessagePreviewsRequest r100 = new ProtoAdapter_PushMessagePreviewsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.preview_entities = Internal.copyOf("preview_entities", this.preview_entities);
        r100.need_load_ids = Internal.copyOf("need_load_ids", this.need_load_ids);
        r100.message_links = Internal.copyOf("message_links", this.message_links);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushMessagePreviewsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushMessagePreviewsRequest(Map<String, PreviewEntityPair> r100, Map<String, PreviewPair> r101, Map<String, MessageLink> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PushMessagePreviewsRequest(Map<String, PreviewEntityPair> r100, Map<String, PreviewPair> r101, Map<String, MessageLink> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.preview_entities = Internal.immutableCopyOf("preview_entities", r100);
        this.need_load_ids = Internal.immutableCopyOf("need_load_ids", r101);
        this.message_links = Internal.immutableCopyOf("message_links", r102);
    }
}
