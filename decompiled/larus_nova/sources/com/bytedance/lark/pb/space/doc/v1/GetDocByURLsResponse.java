package com.bytedance.lark.pb.space.doc.v1;

import com.bytedance.lark.pb.basic.v1.Doc;
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
public final class GetDocByURLsResponse extends Message<GetDocByURLsResponse, Builder> {
    public static final ProtoAdapter<GetDocByURLsResponse> ADAPTER = null;
    public static final ProtoAdapter_GetDocByURLsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, Doc> docs;
    public final List<String> invalid_urls;
    public final List<String> no_perm_urls;

    public static final class Builder extends Message.Builder<GetDocByURLsResponse, Builder> implements d<GetDocByURLsResponse> {
        public Map<String, Doc> docs;
        public List<String> invalid_urls;
        public List<String> no_perm_urls;

        @Override // com.squareup.wire.Message.Builder
        public GetDocByURLsResponse build() {
            return new GetDocByURLsResponse(this.docs, this.invalid_urls, this.no_perm_urls, super.buildUnknownFields());
        }

        public Builder() {
            this.docs = Internal.newMutableMap();
            this.invalid_urls = Internal.newMutableList();
            this.no_perm_urls = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder docs(Map<String, Doc> r100) {
            Internal.checkElementsNotNull(r100);
            this.docs = r100;
            return this;
        }

        public Builder invalid_urls(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.invalid_urls = r100;
            return this;
        }

        public Builder no_perm_urls(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.no_perm_urls = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetDocByURLsResponse extends ProtoAdapter<GetDocByURLsResponse> implements c<GetDocByURLsResponse> {
        private final ProtoAdapter<Map<String, Doc>> docs;

        public ProtoAdapter_GetDocByURLsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetDocByURLsResponse.class);
            this.docs = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, Doc.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetDocByURLsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.docs.putAll(this.docs.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.invalid_urls.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.no_perm_urls.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(GetDocByURLsResponse r100) {
            int r101 = this.docs.encodedSizeWithTag(1, r100.docs);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            return ((r101 + r102.asRepeated().encodedSizeWithTag(2, r100.invalid_urls)) + r102.asRepeated().encodedSizeWithTag(3, r100.no_perm_urls)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetDocByURLsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetDocByURLsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetDocByURLsResponse r101) throws IOException {
            this.docs.encodeWithTag(r100, 1, r101.docs);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 2, r101.invalid_urls);
            r102.asRepeated().encodeWithTag(r100, 3, r101.no_perm_urls);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetDocByURLsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetDocByURLsResponse r100 = new ProtoAdapter_GetDocByURLsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.docs = Internal.copyOf("docs", this.docs);
        r100.invalid_urls = Internal.copyOf("invalid_urls", this.invalid_urls);
        r100.no_perm_urls = Internal.copyOf("no_perm_urls", this.no_perm_urls);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetDocByURLsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetDocByURLsResponse(Map<String, Doc> r100, List<String> r101, List<String> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetDocByURLsResponse(Map<String, Doc> r100, List<String> r101, List<String> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.docs = Internal.immutableCopyOf("docs", r100);
        this.invalid_urls = Internal.immutableCopyOf("invalid_urls", r101);
        this.no_perm_urls = Internal.immutableCopyOf("no_perm_urls", r102);
    }
}
