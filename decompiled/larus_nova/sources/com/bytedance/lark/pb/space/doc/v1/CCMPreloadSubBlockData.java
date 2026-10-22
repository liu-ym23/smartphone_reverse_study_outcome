package com.bytedance.lark.pb.space.doc.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
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
public final class CCMPreloadSubBlockData extends Message<CCMPreloadSubBlockData, Builder> {
    public static final ProtoAdapter<CCMPreloadSubBlockData> ADAPTER = null;
    public static final String DEFAULT_DOCX_TOKEN = "";
    public static final ProtoAdapter_CCMPreloadSubBlockData RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String docx_token;
    public final List<CCMEmbedDocItem> embed_doc_list;
    public final List<CCMResourceItem> res_list;

    public static final class Builder extends Message.Builder<CCMPreloadSubBlockData, Builder> implements d<CCMPreloadSubBlockData> {
        public String docx_token;
        public List<CCMEmbedDocItem> embed_doc_list;
        public List<CCMResourceItem> res_list;

        @Override // com.squareup.wire.Message.Builder
        public CCMPreloadSubBlockData build() {
            String r100 = this.docx_token;
            if (r100 == null) goto L7;
            return new CCMPreloadSubBlockData(this.docx_token, this.res_list, this.embed_doc_list, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "docx_token"});
        }

        public Builder() {
            this.res_list = Internal.newMutableList();
            this.embed_doc_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder docx_token(String r100) {
            this.docx_token = r100;
            return this;
        }

        public Builder embed_doc_list(List<CCMEmbedDocItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.embed_doc_list = r100;
            return this;
        }

        public Builder res_list(List<CCMResourceItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.res_list = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CCMPreloadSubBlockData extends ProtoAdapter<CCMPreloadSubBlockData> implements c<CCMPreloadSubBlockData> {
        public ProtoAdapter_CCMPreloadSubBlockData() {
            super(FieldEncoding.LENGTH_DELIMITED, CCMPreloadSubBlockData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CCMPreloadSubBlockData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.docx_token = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.docx_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.res_list.add(CCMResourceItem.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.embed_doc_list.add(CCMEmbedDocItem.ADAPTER.decode(r100));
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
        public int encodedSize2(CCMPreloadSubBlockData r100) {
            return ((ProtoAdapter.STRING.encodedSizeWithTag(1, r100.docx_token) + CCMResourceItem.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.res_list)) + CCMEmbedDocItem.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.embed_doc_list)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CCMPreloadSubBlockData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CCMPreloadSubBlockData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CCMPreloadSubBlockData r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.docx_token);
            CCMResourceItem.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.res_list);
            CCMEmbedDocItem.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.embed_doc_list);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CCMPreloadSubBlockData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CCMPreloadSubBlockData r100 = new ProtoAdapter_CCMPreloadSubBlockData();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.docx_token = this.docx_token;
        r100.res_list = Internal.copyOf("res_list", this.res_list);
        r100.embed_doc_list = Internal.copyOf("embed_doc_list", this.embed_doc_list);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CCMPreloadSubBlockData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CCMPreloadSubBlockData(String r100, List<CCMResourceItem> r101, List<CCMEmbedDocItem> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public CCMPreloadSubBlockData(String r100, List<CCMResourceItem> r101, List<CCMEmbedDocItem> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.docx_token = r100;
        this.res_list = Internal.immutableCopyOf("res_list", r101);
        this.embed_doc_list = Internal.immutableCopyOf("embed_doc_list", r102);
    }
}
