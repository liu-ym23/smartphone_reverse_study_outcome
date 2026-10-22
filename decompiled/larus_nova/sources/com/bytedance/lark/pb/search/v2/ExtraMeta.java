package com.bytedance.lark.pb.search.v2;

import com.bytedance.lark.pb.search.v1.SearchBoxMeta;
import com.bytedance.lark.pb.search.v1.SearchDocFeedMeta;
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
public final class ExtraMeta extends Message<ExtraMeta, Builder> {
    public static final ProtoAdapter<ExtraMeta> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, SearchBoxMeta> chat_box_meta;
    public final Map<String, SearchDocFeedMeta> doc_feed_meta;

    public static final class Builder extends Message.Builder<ExtraMeta, Builder> {
        public Map<String, SearchBoxMeta> chat_box_meta;
        public Map<String, SearchDocFeedMeta> doc_feed_meta;

        @Override // com.squareup.wire.Message.Builder
        public ExtraMeta build() {
            return new ExtraMeta(this.chat_box_meta, this.doc_feed_meta, super.buildUnknownFields());
        }

        public Builder() {
            this.chat_box_meta = Internal.newMutableMap();
            this.doc_feed_meta = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_box_meta(Map<String, SearchBoxMeta> r100) {
            Internal.checkElementsNotNull(r100);
            this.chat_box_meta = r100;
            return this;
        }

        public Builder doc_feed_meta(Map<String, SearchDocFeedMeta> r100) {
            Internal.checkElementsNotNull(r100);
            this.doc_feed_meta = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ExtraMeta extends ProtoAdapter<ExtraMeta> {
        private final ProtoAdapter<Map<String, SearchBoxMeta>> chat_box_meta;
        private final ProtoAdapter<Map<String, SearchDocFeedMeta>> doc_feed_meta;

        public ProtoAdapter_ExtraMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, ExtraMeta.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.chat_box_meta = ProtoAdapter.newMapAdapter(r100, SearchBoxMeta.ADAPTER);
            this.doc_feed_meta = ProtoAdapter.newMapAdapter(r100, SearchDocFeedMeta.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ExtraMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.chat_box_meta.putAll(this.chat_box_meta.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.doc_feed_meta.putAll(this.doc_feed_meta.decode(r100));
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
        public int encodedSize2(ExtraMeta r100) {
            return (this.chat_box_meta.encodedSizeWithTag(1, r100.chat_box_meta) + this.doc_feed_meta.encodedSizeWithTag(2, r100.doc_feed_meta)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ExtraMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ExtraMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ExtraMeta r101) throws IOException {
            this.chat_box_meta.encodeWithTag(r100, 1, r101.chat_box_meta);
            this.doc_feed_meta.encodeWithTag(r100, 2, r101.doc_feed_meta);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ExtraMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ExtraMeta();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_box_meta = Internal.copyOf("chat_box_meta", this.chat_box_meta);
        r100.doc_feed_meta = Internal.copyOf("doc_feed_meta", this.doc_feed_meta);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ExtraMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ExtraMeta(Map<String, SearchBoxMeta> r100, Map<String, SearchDocFeedMeta> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ExtraMeta(Map<String, SearchBoxMeta> r100, Map<String, SearchDocFeedMeta> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.chat_box_meta = Internal.immutableCopyOf("chat_box_meta", r100);
        this.doc_feed_meta = Internal.immutableCopyOf("doc_feed_meta", r101);
    }
}
