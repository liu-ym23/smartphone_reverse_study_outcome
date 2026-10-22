package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
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
public final class QuasiMessageExtraData extends Message<QuasiMessageExtraData, Builder> {
    public static final ProtoAdapter<QuasiMessageExtraData> ADAPTER = null;
    public static final Boolean DEFAULT_IS_LAST_IN_BATCH = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_last_in_batch;
    public final Map<String, UrlPreviewEntity> url_preview_entities;

    public static final class Builder extends Message.Builder<QuasiMessageExtraData, Builder> {
        public Boolean is_last_in_batch;
        public Map<String, UrlPreviewEntity> url_preview_entities;

        @Override // com.squareup.wire.Message.Builder
        public QuasiMessageExtraData build() {
            return new QuasiMessageExtraData(this.url_preview_entities, this.is_last_in_batch, super.buildUnknownFields());
        }

        public Builder() {
            this.url_preview_entities = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_last_in_batch(Boolean r100) {
            this.is_last_in_batch = r100;
            return this;
        }

        public Builder url_preview_entities(Map<String, UrlPreviewEntity> r100) {
            Internal.checkElementsNotNull(r100);
            this.url_preview_entities = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_QuasiMessageExtraData extends ProtoAdapter<QuasiMessageExtraData> {
        private final ProtoAdapter<Map<String, UrlPreviewEntity>> url_preview_entities;

        public ProtoAdapter_QuasiMessageExtraData() {
            super(FieldEncoding.LENGTH_DELIMITED, QuasiMessageExtraData.class);
            this.url_preview_entities = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, UrlPreviewEntity.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public QuasiMessageExtraData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.is_last_in_batch = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.url_preview_entities.putAll(this.url_preview_entities.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.is_last_in_batch = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(QuasiMessageExtraData r100) {
            int r101 = this.url_preview_entities.encodedSizeWithTag(1, r100.url_preview_entities);
            Boolean r102 = r100.is_last_in_batch;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ QuasiMessageExtraData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(QuasiMessageExtraData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, QuasiMessageExtraData r101) throws IOException {
            this.url_preview_entities.encodeWithTag(r100, 1, r101.url_preview_entities);
            Boolean r102 = r101.is_last_in_batch;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, QuasiMessageExtraData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_QuasiMessageExtraData();
        DEFAULT_IS_LAST_IN_BATCH = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.url_preview_entities = Internal.copyOf("url_preview_entities", this.url_preview_entities);
        r100.is_last_in_batch = this.is_last_in_batch;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return QuasiMessageExtraData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public QuasiMessageExtraData(Map<String, UrlPreviewEntity> r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public QuasiMessageExtraData(Map<String, UrlPreviewEntity> r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.url_preview_entities = Internal.immutableCopyOf("url_preview_entities", r100);
        this.is_last_in_batch = r101;
    }
}
