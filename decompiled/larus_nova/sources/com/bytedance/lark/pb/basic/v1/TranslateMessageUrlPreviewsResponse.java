package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class TranslateMessageUrlPreviewsResponse extends com.squareup.wire.Message<TranslateMessageUrlPreviewsResponse, Builder> {
    public static final ProtoAdapter<TranslateMessageUrlPreviewsResponse> ADAPTER = null;
    public static final ProtoAdapter_TranslateMessageUrlPreviewsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TranslatedUrlPreviewEntity> translated_entities;

    public static final class Builder extends com.squareup.wire.Message.Builder<TranslateMessageUrlPreviewsResponse, Builder> implements d<TranslateMessageUrlPreviewsResponse> {
        public List<TranslatedUrlPreviewEntity> translated_entities;

        @Override // com.squareup.wire.Message.Builder
        public TranslateMessageUrlPreviewsResponse build() {
            return new TranslateMessageUrlPreviewsResponse(this.translated_entities, super.buildUnknownFields());
        }

        public Builder() {
            this.translated_entities = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder translated_entities(List<TranslatedUrlPreviewEntity> r100) {
            Internal.checkElementsNotNull(r100);
            this.translated_entities = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TranslateMessageUrlPreviewsResponse extends ProtoAdapter<TranslateMessageUrlPreviewsResponse> implements c<TranslateMessageUrlPreviewsResponse> {
        public ProtoAdapter_TranslateMessageUrlPreviewsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, TranslateMessageUrlPreviewsResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TranslateMessageUrlPreviewsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.translated_entities.add(TranslatedUrlPreviewEntity.ADAPTER.decode(r100));
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
        public int encodedSize2(TranslateMessageUrlPreviewsResponse r100) {
            return TranslatedUrlPreviewEntity.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.translated_entities) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TranslateMessageUrlPreviewsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TranslateMessageUrlPreviewsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TranslateMessageUrlPreviewsResponse r101) throws IOException {
            TranslatedUrlPreviewEntity.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.translated_entities);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TranslateMessageUrlPreviewsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_TranslateMessageUrlPreviewsResponse r100 = new ProtoAdapter_TranslateMessageUrlPreviewsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.translated_entities = Internal.copyOf("translated_entities", this.translated_entities);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TranslateMessageUrlPreviewsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TranslateMessageUrlPreviewsResponse(List<TranslatedUrlPreviewEntity> r100) {
        this(r100, ByteString.EMPTY);
    }

    public TranslateMessageUrlPreviewsResponse(List<TranslatedUrlPreviewEntity> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.translated_entities = Internal.immutableCopyOf("translated_entities", r100);
    }
}
