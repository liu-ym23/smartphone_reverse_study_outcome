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
public final class TranslateMessageUrlPreviewsRequest extends com.squareup.wire.Message<TranslateMessageUrlPreviewsRequest, Builder> {
    public static final ProtoAdapter<TranslateMessageUrlPreviewsRequest> ADAPTER = null;
    public static final Boolean DEFAULT_IS_AUTO_TRANSLATE = null;
    public static final ProtoAdapter_TranslateMessageUrlPreviewsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_auto_translate;
    public final List<TranslateUrlPreviewContext> translate_contexts;

    public static final class Builder extends com.squareup.wire.Message.Builder<TranslateMessageUrlPreviewsRequest, Builder> implements d<TranslateMessageUrlPreviewsRequest> {
        public Boolean is_auto_translate;
        public List<TranslateUrlPreviewContext> translate_contexts;

        @Override // com.squareup.wire.Message.Builder
        public TranslateMessageUrlPreviewsRequest build() {
            return new TranslateMessageUrlPreviewsRequest(this.translate_contexts, this.is_auto_translate, super.buildUnknownFields());
        }

        public Builder() {
            this.translate_contexts = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder is_auto_translate(Boolean r100) {
            this.is_auto_translate = r100;
            return this;
        }

        public Builder translate_contexts(List<TranslateUrlPreviewContext> r100) {
            Internal.checkElementsNotNull(r100);
            this.translate_contexts = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TranslateMessageUrlPreviewsRequest extends ProtoAdapter<TranslateMessageUrlPreviewsRequest> implements c<TranslateMessageUrlPreviewsRequest> {
        public ProtoAdapter_TranslateMessageUrlPreviewsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, TranslateMessageUrlPreviewsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TranslateMessageUrlPreviewsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.is_auto_translate = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.translate_contexts.add(TranslateUrlPreviewContext.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.is_auto_translate = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(TranslateMessageUrlPreviewsRequest r100) {
            int r101 = TranslateUrlPreviewContext.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.translate_contexts);
            Boolean r102 = r100.is_auto_translate;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TranslateMessageUrlPreviewsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TranslateMessageUrlPreviewsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TranslateMessageUrlPreviewsRequest r101) throws IOException {
            TranslateUrlPreviewContext.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.translate_contexts);
            Boolean r102 = r101.is_auto_translate;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TranslateMessageUrlPreviewsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_TranslateMessageUrlPreviewsRequest r100 = new ProtoAdapter_TranslateMessageUrlPreviewsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_IS_AUTO_TRANSLATE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.translate_contexts = Internal.copyOf("translate_contexts", this.translate_contexts);
        r100.is_auto_translate = this.is_auto_translate;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TranslateMessageUrlPreviewsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TranslateMessageUrlPreviewsRequest(List<TranslateUrlPreviewContext> r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TranslateMessageUrlPreviewsRequest(List<TranslateUrlPreviewContext> r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.translate_contexts = Internal.immutableCopyOf("translate_contexts", r100);
        this.is_auto_translate = r101;
    }
}
