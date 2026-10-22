package com.bytedance.lark.pb.search.feedback.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SearchResult extends Message<SearchResult, Builder> {
    public static final ProtoAdapter<SearchResult> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253675id;
    public final String name;
    public final Integer type;

    public static final class Builder extends Message.Builder<SearchResult, Builder> {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253676id;
        public String name;
        public Integer type;

        @Override // com.squareup.wire.Message.Builder
        public SearchResult build() {
            String r100 = this.f253676id;
            if (r100 == null) goto L11;
            if (this.type == null) goto L11;
            if (this.name == null) goto L11;
            return new SearchResult(this.f253676id, this.type, this.name, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.type, "type", this.name, "name"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder id(String r100) {
            this.f253676id = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder type(Integer r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchResult extends ProtoAdapter<SearchResult> {
        public ProtoAdapter_SearchResult() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchResult.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SearchResult decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253676id = "";
            r101.type = 0;
            r101.name = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.f253676id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.name = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SearchResult r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((r101.encodedSizeWithTag(1, r100.f253675id) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.type)) + r101.encodedSizeWithTag(3, r100.name)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SearchResult decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SearchResult r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SearchResult r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253675id);
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.type);
            r102.encodeWithTag(r100, 3, r101.name);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchResult r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchResult();
        DEFAULT_TYPE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253676id = this.f253675id;
        r100.type = this.type;
        r100.name = this.name;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SearchResult.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SearchResult(String r100, Integer r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public SearchResult(String r100, Integer r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.f253675id = r100;
        this.type = r101;
        this.name = r102;
    }
}
