package com.ss.android.lark.pb.usearch;

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

/* JADX INFO: loaded from: classes37.dex */
public final class SearchPlaceholder extends Message<SearchPlaceholder, Builder> {
    public static final ProtoAdapter<SearchPlaceholder> ADAPTER = null;
    public static final String DEFAULT_ANSWER = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_MARQUEE_TEXT = "";
    public static final String DEFAULT_QUERY = "";
    public static final String DEFAULT_TEXT = "";
    private static final long serialVersionUID = 0;
    public final String manswer;
    public final List<MarqueeFilter> mfilters;
    public final Map<String, String> mi18n_text;
    public final String mid;
    public final String mmarquee_text;
    public final String mquery;
    public final com.ss.android.lark.pb.searches.SearchTabName msearch_tab_name;
    public final String mtext;
    public final SearchResult muser_search_info;

    public static final class Builder extends Message.Builder<SearchPlaceholder, Builder> {
        public String manswer;
        public List<MarqueeFilter> mfilters;
        public Map<String, String> mi18n_text;
        public String mid;
        public String mmarquee_text;
        public String mquery;
        public com.ss.android.lark.pb.searches.SearchTabName msearch_tab_name;
        public String mtext;
        public SearchResult muser_search_info;

        @Override // com.squareup.wire.Message.Builder
        public SearchPlaceholder build() {
            String r100 = this.mtext;
            if (r100 == null) goto L7;
            return new SearchPlaceholder(this.mtext, this.mi18n_text, this.mquery, this.msearch_tab_name, this.mfilters, this.muser_search_info, this.mmarquee_text, this.mid, this.manswer, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mtext"});
        }

        public Builder() {
            this.mi18n_text = Internal.newMutableMap();
            this.mfilters = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder answer(String r100) {
            this.manswer = r100;
            return this;
        }

        public Builder filters(List<MarqueeFilter> r100) {
            Internal.checkElementsNotNull(r100);
            this.mfilters = r100;
            return this;
        }

        public Builder i18n_text(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mi18n_text = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder marquee_text(String r100) {
            this.mmarquee_text = r100;
            return this;
        }

        public Builder query(String r100) {
            this.mquery = r100;
            return this;
        }

        public Builder search_tab_name(com.ss.android.lark.pb.searches.SearchTabName r100) {
            this.msearch_tab_name = r100;
            return this;
        }

        public Builder text(String r100) {
            this.mtext = r100;
            return this;
        }

        public Builder user_search_info(SearchResult r100) {
            this.muser_search_info = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchPlaceholder extends ProtoAdapter<SearchPlaceholder> {
        private final ProtoAdapter<Map<String, String>> mi18n_text;

        public ProtoAdapter_SearchPlaceholder() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchPlaceholder.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mi18n_text = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SearchPlaceholder decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mtext = "";
            r101.mquery = "";
            r101.mmarquee_text = "";
            r101.mid = "";
            r101.manswer = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L21;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L21:
            r101.msearch_tab_name = com.ss.android.lark.pb.searches.SearchTabName.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.manswer = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.mmarquee_text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.muser_search_info = SearchResult.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.mfilters.add(MarqueeFilter.ADAPTER.decode(r100));
            goto L3
        L16:
            r101.mquery = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.mi18n_text.putAll(this.mi18n_text.decode(r100));
            goto L3
        L18:
            r101.mtext = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SearchPlaceholder r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.mtext) + this.mi18n_text.encodedSizeWithTag(2, r100.mi18n_text);
            String r103 = r100.mquery;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            com.ss.android.lark.pb.searches.SearchTabName r107 = r100.msearch_tab_name;
            if (r107 == null) goto L9;
            int r108 = com.ss.android.lark.pb.searches.SearchTabName.ADAPTER.encodedSizeWithTag(4, r107);
        L10:
            int r109 = (r106 + r108) + MarqueeFilter.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.mfilters);
            SearchResult r110 = r100.muser_search_info;
            if (r110 == null) goto L13;
            int r111 = SearchResult.ADAPTER.encodedSizeWithTag(6, r110);
        L14:
            int r112 = r109 + r111;
            String r113 = r100.mmarquee_text;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(7, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.mid;
            if (r116 == null) goto L21;
            int r117 = r101.encodedSizeWithTag(8, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.manswer;
            if (r119 == null) goto L26;
            r104 = r101.encodedSizeWithTag(9, r119);
        L26:
            return (r118 + r104) + r100.unknownFields().size();
        L21:
            r117 = 0;
            goto L22
        L17:
            r114 = 0;
            goto L18
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SearchPlaceholder decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SearchPlaceholder r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SearchPlaceholder r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mtext);
            this.mi18n_text.encodeWithTag(r100, 2, r101.mi18n_text);
            String r103 = r101.mquery;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            com.ss.android.lark.pb.searches.SearchTabName r104 = r101.msearch_tab_name;
            if (r104 == null) goto L8;
            com.ss.android.lark.pb.searches.SearchTabName.ADAPTER.encodeWithTag(r100, 4, r104);
        L8:
            MarqueeFilter.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.mfilters);
            SearchResult r105 = r101.muser_search_info;
            if (r105 == null) goto L11;
            SearchResult.ADAPTER.encodeWithTag(r100, 6, r105);
        L11:
            String r106 = r101.mmarquee_text;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 7, r106);
        L14:
            String r107 = r101.mid;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 8, r107);
        L17:
            String r108 = r101.manswer;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 9, r108);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchPlaceholder r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchPlaceholder();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtext = this.mtext;
        r100.mi18n_text = Internal.copyOf("mi18n_text", this.mi18n_text);
        r100.mquery = this.mquery;
        r100.msearch_tab_name = this.msearch_tab_name;
        r100.mfilters = Internal.copyOf("mfilters", this.mfilters);
        r100.muser_search_info = this.muser_search_info;
        r100.mmarquee_text = this.mmarquee_text;
        r100.mid = this.mid;
        r100.manswer = this.manswer;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SearchPlaceholder.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SearchPlaceholder(String r110, Map<String, String> r111, String r112, com.ss.android.lark.pb.searches.SearchTabName r113, List<MarqueeFilter> r114, SearchResult r115, String r116, String r117, String r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public SearchPlaceholder(String r100, Map<String, String> r101, String r102, com.ss.android.lark.pb.searches.SearchTabName r103, List<MarqueeFilter> r104, SearchResult r105, String r106, String r107, String r110, ByteString r111) {
        super(ADAPTER, r111);
        this.mtext = r100;
        this.mi18n_text = Internal.immutableCopyOf("mi18n_text", r101);
        this.mquery = r102;
        this.msearch_tab_name = r103;
        this.mfilters = Internal.immutableCopyOf("mfilters", r104);
        this.muser_search_info = r105;
        this.mmarquee_text = r106;
        this.mid = r107;
        this.manswer = r110;
    }
}
