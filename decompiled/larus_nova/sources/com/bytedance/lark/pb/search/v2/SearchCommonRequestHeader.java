package com.bytedance.lark.pb.search.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SearchCommonRequestHeader extends Message<SearchCommonRequestHeader, Builder> {
    public static final ProtoAdapter<SearchCommonRequestHeader> ADAPTER = null;
    public static final ClusteringType DEFAULT_CLUSTERING_TYPE = null;
    public static final Boolean DEFAULT_ISTENANTNOTPAYED = null;
    public static final Boolean DEFAULT_IS_FORCE = null;
    public static final Boolean DEFAULT_IS_QUERY_TEMPLATE = null;
    public static final Integer DEFAULT_PAGE_SIZE = null;
    public static final String DEFAULT_PAGINATION_TOKEN = "";
    public static final String DEFAULT_QUERY = "";
    public static final Integer DEFAULT_QUERY_LEN = null;
    public static final SearchScene DEFAULT_SEARCH_SCENE = null;
    public static final String DEFAULT_SEARCH_SESSION = "";
    public static final Integer DEFAULT_SESSION_SEQ_ID = null;
    public static final ByteString DEFAULT_TEMPLATE_INFO = null;
    public static final String DEFAULT_TIMEZONE = "";
    private static final long serialVersionUID = 0;
    public final ClusteringType clustering_type;
    public final BaseEntity.SearchExtras extra_params;
    public final Boolean isTenantNotPayed;
    public final Boolean is_force;
    public final Boolean is_query_template;

    /* JADX INFO: renamed from: op, reason: collision with root package name */
    public final OpAfterError f253731op;
    public final Integer page_size;
    public final String pagination_token;
    public final List<PagingInfo> paging_infos;
    public final String query;
    public final Integer query_len;
    public final BaseEntity.SearchContext search_context;
    public final SearchScene search_scene;
    public final String search_session;
    public final Layout section_summary_layout;
    public final Integer session_seq_id;
    public final ColdAndHotStorageInfo storage_info;
    public final Layout summary_layout;
    public final ByteString template_info;
    public final String timezone;
    public final Layout title_layout;

    public static final class Builder extends Message.Builder<SearchCommonRequestHeader, Builder> {
        public ClusteringType clustering_type;
        public BaseEntity.SearchExtras extra_params;
        public Boolean isTenantNotPayed;
        public Boolean is_force;
        public Boolean is_query_template;

        /* JADX INFO: renamed from: op, reason: collision with root package name */
        public OpAfterError f253732op;
        public Integer page_size;
        public String pagination_token;
        public List<PagingInfo> paging_infos;
        public String query;
        public Integer query_len;
        public BaseEntity.SearchContext search_context;
        public SearchScene search_scene;
        public String search_session;
        public Layout section_summary_layout;
        public Integer session_seq_id;
        public ColdAndHotStorageInfo storage_info;
        public Layout summary_layout;
        public ByteString template_info;
        public String timezone;
        public Layout title_layout;

        @Override // com.squareup.wire.Message.Builder
        public SearchCommonRequestHeader build() {
            String r100 = this.search_session;
            if (r100 == null) goto L11;
            if (this.session_seq_id == null) goto L11;
            if (this.query == null) goto L11;
            return new SearchCommonRequestHeader(this.search_session, this.session_seq_id, this.query, this.pagination_token, this.search_context, this.extra_params, this.is_force, this.title_layout, this.summary_layout, this.section_summary_layout, this.storage_info, this.paging_infos, this.clustering_type, this.timezone, this.f253732op, this.template_info, this.is_query_template, this.page_size, this.search_scene, this.isTenantNotPayed, this.query_len, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "search_session", this.session_seq_id, "session_seq_id", this.query, "query"});
        }

        public Builder() {
            this.paging_infos = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder clustering_type(ClusteringType r100) {
            this.clustering_type = r100;
            return this;
        }

        public Builder extra_params(BaseEntity.SearchExtras r100) {
            this.extra_params = r100;
            return this;
        }

        public Builder isTenantNotPayed(Boolean r100) {
            this.isTenantNotPayed = r100;
            return this;
        }

        public Builder is_force(Boolean r100) {
            this.is_force = r100;
            return this;
        }

        public Builder is_query_template(Boolean r100) {
            this.is_query_template = r100;
            return this;
        }

        public Builder op(OpAfterError r100) {
            this.f253732op = r100;
            return this;
        }

        public Builder page_size(Integer r100) {
            this.page_size = r100;
            return this;
        }

        public Builder pagination_token(String r100) {
            this.pagination_token = r100;
            return this;
        }

        public Builder paging_infos(List<PagingInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.paging_infos = r100;
            return this;
        }

        public Builder query(String r100) {
            this.query = r100;
            return this;
        }

        public Builder query_len(Integer r100) {
            this.query_len = r100;
            return this;
        }

        public Builder search_context(BaseEntity.SearchContext r100) {
            this.search_context = r100;
            return this;
        }

        public Builder search_scene(SearchScene r100) {
            this.search_scene = r100;
            return this;
        }

        public Builder search_session(String r100) {
            this.search_session = r100;
            return this;
        }

        public Builder section_summary_layout(Layout r100) {
            this.section_summary_layout = r100;
            return this;
        }

        public Builder session_seq_id(Integer r100) {
            this.session_seq_id = r100;
            return this;
        }

        public Builder storage_info(ColdAndHotStorageInfo r100) {
            this.storage_info = r100;
            return this;
        }

        public Builder summary_layout(Layout r100) {
            this.summary_layout = r100;
            return this;
        }

        public Builder template_info(ByteString r100) {
            this.template_info = r100;
            return this;
        }

        public Builder timezone(String r100) {
            this.timezone = r100;
            return this;
        }

        public Builder title_layout(Layout r100) {
            this.title_layout = r100;
            return this;
        }
    }

    public static final class Layout extends Message<Layout, Builder> {
        public static final ProtoAdapter<Layout> ADAPTER = null;
        public static final Integer DEFAULT_LINE = null;
        public static final Integer DEFAULT_WIDTH = null;
        private static final long serialVersionUID = 0;
        public final Integer line;
        public final Integer width;

        public static final class Builder extends Message.Builder<Layout, Builder> {
            public Integer line;
            public Integer width;

            @Override // com.squareup.wire.Message.Builder
            public Layout build() {
                return new Layout(this.line, this.width, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder line(Integer r100) {
                this.line = r100;
                return this;
            }

            public Builder width(Integer r100) {
                this.width = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Layout extends ProtoAdapter<Layout> {
            public ProtoAdapter_Layout() {
                super(FieldEncoding.LENGTH_DELIMITED, Layout.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Layout decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.line = 0;
                r101.width = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.line = ProtoAdapter.INT32.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.width = ProtoAdapter.INT32.decode(r100);
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
            public int encodedSize2(Layout r100) {
                Integer r101 = r100.line;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.width;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Layout decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Layout r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Layout r101) throws IOException {
                Integer r102 = r101.line;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.width;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Layout r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Layout();
            DEFAULT_LINE = 0;
            DEFAULT_WIDTH = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.line = this.line;
            r100.width = this.width;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Layout.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Layout(Integer r100, Integer r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public Layout(Integer r100, Integer r101, ByteString r102) {
            super(ADAPTER, r102);
            this.line = r100;
            this.width = r101;
        }
    }

    public static final class PagingInfo extends Message<PagingInfo, Builder> {
        public static final ProtoAdapter<PagingInfo> ADAPTER = null;
        public static final ClusteringType DEFAULT_CLUSTERING_TYPE = null;
        public static final Integer DEFAULT_PAGE_SIZE = null;
        private static final long serialVersionUID = 0;
        public final ClusteringType clustering_type;
        public final Integer page_size;

        public static final class Builder extends Message.Builder<PagingInfo, Builder> {
            public ClusteringType clustering_type;
            public Integer page_size;

            @Override // com.squareup.wire.Message.Builder
            public PagingInfo build() {
                return new PagingInfo(this.clustering_type, this.page_size, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder clustering_type(ClusteringType r100) {
                this.clustering_type = r100;
                return this;
            }

            public Builder page_size(Integer r100) {
                this.page_size = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_PagingInfo extends ProtoAdapter<PagingInfo> {
            public ProtoAdapter_PagingInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, PagingInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PagingInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.clustering_type = ClusteringType.COMMON_ITEMS;
                r101.page_size = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.clustering_type = ClusteringType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.page_size = ProtoAdapter.INT32.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(PagingInfo r100) {
                ClusteringType r101 = r100.clustering_type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ClusteringType.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.page_size;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ PagingInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(PagingInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, PagingInfo r101) throws IOException {
                ClusteringType r102 = r101.clustering_type;
                if (r102 == null) goto L5;
                ClusteringType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.page_size;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PagingInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_PagingInfo();
            DEFAULT_CLUSTERING_TYPE = ClusteringType.COMMON_ITEMS;
            DEFAULT_PAGE_SIZE = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.clustering_type = this.clustering_type;
            r100.page_size = this.page_size;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return PagingInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public PagingInfo(ClusteringType r100, Integer r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public PagingInfo(ClusteringType r100, Integer r101, ByteString r102) {
            super(ADAPTER, r102);
            this.clustering_type = r100;
            this.page_size = r101;
        }
    }

    public static final class ProtoAdapter_SearchCommonRequestHeader extends ProtoAdapter<SearchCommonRequestHeader> {
        public ProtoAdapter_SearchCommonRequestHeader() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchCommonRequestHeader.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SearchCommonRequestHeader decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.search_session = "";
            r101.session_seq_id = 0;
            r101.query = "";
            r101.pagination_token = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_force = r102;
            r101.clustering_type = ClusteringType.COMMON_ITEMS;
            r101.timezone = "";
            r101.template_info = ByteString.EMPTY;
            r101.is_query_template = r102;
            r101.page_size = 0;
            r101.search_scene = SearchScene.DEFAULT_SEARCH_SCENE;
            r101.isTenantNotPayed = r102;
            r101.query_len = 0;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L34;
            switch(r104) {
                case 1: goto L33;
                case 2: goto L32;
                case 3: goto L31;
                case 4: goto L30;
                case 5: goto L29;
                case 6: goto L28;
                case 7: goto L27;
                case 8: goto L26;
                case 9: goto L25;
                case 10: goto L24;
                case 11: goto L23;
                case 12: goto L22;
                case 13: goto L36;
                case 14: goto L17;
                case 15: goto L16;
                case 16: goto L15;
                case 17: goto L14;
                case 18: goto L13;
                case 19: goto L38;
                case 20: goto L8;
                case 21: goto L7;
                default: goto L6;
            };
        L36:
            r101.clustering_type = ClusteringType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L38:
            r101.search_scene = SearchScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.query_len = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            r101.isTenantNotPayed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.page_size = ProtoAdapter.INT32.decode(r100);
            goto L3
        L14:
            r101.is_query_template = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            r101.template_info = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L16:
            r101.f253732op = OpAfterError.ADAPTER.decode(r100);
            goto L3
        L17:
            r101.timezone = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.paging_infos.add(PagingInfo.ADAPTER.decode(r100));
            goto L3
        L23:
            r101.section_summary_layout = Layout.ADAPTER.decode(r100);
            goto L3
        L24:
            r101.storage_info = ColdAndHotStorageInfo.ADAPTER.decode(r100);
            goto L3
        L25:
            r101.summary_layout = Layout.ADAPTER.decode(r100);
            goto L3
        L26:
            r101.title_layout = Layout.ADAPTER.decode(r100);
            goto L3
        L27:
            r101.is_force = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L28:
            r101.extra_params = BaseEntity.SearchExtras.ADAPTER.decode(r100);
            goto L3
        L29:
            r101.search_context = BaseEntity.SearchContext.ADAPTER.decode(r100);
            goto L3
        L30:
            r101.pagination_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L31:
            r101.query = ProtoAdapter.STRING.decode(r100);
            goto L3
        L32:
            r101.session_seq_id = ProtoAdapter.INT32.decode(r100);
            goto L3
        L33:
            r101.search_session = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L34:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SearchCommonRequestHeader r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.search_session);
            ProtoAdapter<Integer> r103 = ProtoAdapter.INT32;
            int r104 = (r102 + r103.encodedSizeWithTag(2, r100.session_seq_id)) + r101.encodedSizeWithTag(3, r100.query);
            String r105 = r100.pagination_token;
            int r106 = 0;
            if (r105 == null) goto L5;
            int r107 = r101.encodedSizeWithTag(4, r105);
        L6:
            int r108 = r104 + r107;
            BaseEntity.SearchContext r109 = r100.search_context;
            if (r109 == null) goto L9;
            int r110 = BaseEntity.SearchContext.ADAPTER.encodedSizeWithTag(5, r109);
        L10:
            int r111 = r108 + r110;
            BaseEntity.SearchExtras r112 = r100.extra_params;
            if (r112 == null) goto L13;
            int r113 = BaseEntity.SearchExtras.ADAPTER.encodedSizeWithTag(6, r112);
        L14:
            int r114 = r111 + r113;
            Boolean r115 = r100.is_force;
            if (r115 == null) goto L17;
            int r116 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r115);
        L18:
            int r117 = r114 + r116;
            Layout r118 = r100.title_layout;
            if (r118 == null) goto L21;
            int r119 = Layout.ADAPTER.encodedSizeWithTag(8, r118);
        L22:
            int r120 = r117 + r119;
            Layout r121 = r100.summary_layout;
            if (r121 == null) goto L25;
            int r122 = Layout.ADAPTER.encodedSizeWithTag(9, r121);
        L26:
            int r123 = r120 + r122;
            Layout r124 = r100.section_summary_layout;
            if (r124 == null) goto L29;
            int r125 = Layout.ADAPTER.encodedSizeWithTag(11, r124);
        L30:
            int r126 = r123 + r125;
            ColdAndHotStorageInfo r127 = r100.storage_info;
            if (r127 == null) goto L33;
            int r128 = ColdAndHotStorageInfo.ADAPTER.encodedSizeWithTag(10, r127);
        L34:
            int r129 = (r126 + r128) + PagingInfo.ADAPTER.asRepeated().encodedSizeWithTag(12, r100.paging_infos);
            ClusteringType r130 = r100.clustering_type;
            if (r130 == null) goto L37;
            int r131 = ClusteringType.ADAPTER.encodedSizeWithTag(13, r130);
        L38:
            int r132 = r129 + r131;
            String r133 = r100.timezone;
            if (r133 == null) goto L41;
            int r134 = r101.encodedSizeWithTag(14, r133);
        L42:
            int r135 = r132 + r134;
            OpAfterError r136 = r100.f253731op;
            if (r136 == null) goto L45;
            int r137 = OpAfterError.ADAPTER.encodedSizeWithTag(15, r136);
        L46:
            int r138 = r135 + r137;
            ByteString r139 = r100.template_info;
            if (r139 == null) goto L49;
            int r140 = ProtoAdapter.BYTES.encodedSizeWithTag(16, r139);
        L50:
            int r141 = r138 + r140;
            Boolean r142 = r100.is_query_template;
            if (r142 == null) goto L53;
            int r143 = ProtoAdapter.BOOL.encodedSizeWithTag(17, r142);
        L54:
            int r144 = r141 + r143;
            Integer r145 = r100.page_size;
            if (r145 == null) goto L57;
            int r146 = r103.encodedSizeWithTag(18, r145);
        L58:
            int r147 = r144 + r146;
            SearchScene r148 = r100.search_scene;
            if (r148 == null) goto L61;
            int r149 = SearchScene.ADAPTER.encodedSizeWithTag(19, r148);
        L62:
            int r150 = r147 + r149;
            Boolean r151 = r100.isTenantNotPayed;
            if (r151 == null) goto L65;
            int r152 = ProtoAdapter.BOOL.encodedSizeWithTag(20, r151);
        L66:
            int r153 = r150 + r152;
            Integer r154 = r100.query_len;
            if (r154 == null) goto L70;
            r106 = r103.encodedSizeWithTag(21, r154);
        L70:
            return (r153 + r106) + r100.unknownFields().size();
        L65:
            r152 = 0;
            goto L66
        L61:
            r149 = 0;
            goto L62
        L57:
            r146 = 0;
            goto L58
        L53:
            r143 = 0;
            goto L54
        L49:
            r140 = 0;
            goto L50
        L45:
            r137 = 0;
            goto L46
        L41:
            r134 = 0;
            goto L42
        L37:
            r131 = 0;
            goto L38
        L33:
            r128 = 0;
            goto L34
        L29:
            r125 = 0;
            goto L30
        L25:
            r122 = 0;
            goto L26
        L21:
            r119 = 0;
            goto L22
        L17:
            r116 = 0;
            goto L18
        L13:
            r113 = 0;
            goto L14
        L9:
            r110 = 0;
            goto L10
        L5:
            r107 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SearchCommonRequestHeader decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SearchCommonRequestHeader r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SearchCommonRequestHeader r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.search_session);
            ProtoAdapter<Integer> r103 = ProtoAdapter.INT32;
            r103.encodeWithTag(r100, 2, r101.session_seq_id);
            r102.encodeWithTag(r100, 3, r101.query);
            String r104 = r101.pagination_token;
            if (r104 == null) goto L5;
            r102.encodeWithTag(r100, 4, r104);
        L5:
            BaseEntity.SearchContext r105 = r101.search_context;
            if (r105 == null) goto L8;
            BaseEntity.SearchContext.ADAPTER.encodeWithTag(r100, 5, r105);
        L8:
            BaseEntity.SearchExtras r106 = r101.extra_params;
            if (r106 == null) goto L11;
            BaseEntity.SearchExtras.ADAPTER.encodeWithTag(r100, 6, r106);
        L11:
            Boolean r107 = r101.is_force;
            if (r107 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r107);
        L14:
            Layout r108 = r101.title_layout;
            if (r108 == null) goto L17;
            Layout.ADAPTER.encodeWithTag(r100, 8, r108);
        L17:
            Layout r109 = r101.summary_layout;
            if (r109 == null) goto L20;
            Layout.ADAPTER.encodeWithTag(r100, 9, r109);
        L20:
            Layout r110 = r101.section_summary_layout;
            if (r110 == null) goto L23;
            Layout.ADAPTER.encodeWithTag(r100, 11, r110);
        L23:
            ColdAndHotStorageInfo r111 = r101.storage_info;
            if (r111 == null) goto L26;
            ColdAndHotStorageInfo.ADAPTER.encodeWithTag(r100, 10, r111);
        L26:
            PagingInfo.ADAPTER.asRepeated().encodeWithTag(r100, 12, r101.paging_infos);
            ClusteringType r112 = r101.clustering_type;
            if (r112 == null) goto L29;
            ClusteringType.ADAPTER.encodeWithTag(r100, 13, r112);
        L29:
            String r113 = r101.timezone;
            if (r113 == null) goto L32;
            r102.encodeWithTag(r100, 14, r113);
        L32:
            OpAfterError r114 = r101.f253731op;
            if (r114 == null) goto L35;
            OpAfterError.ADAPTER.encodeWithTag(r100, 15, r114);
        L35:
            ByteString r115 = r101.template_info;
            if (r115 == null) goto L38;
            ProtoAdapter.BYTES.encodeWithTag(r100, 16, r115);
        L38:
            Boolean r116 = r101.is_query_template;
            if (r116 == null) goto L41;
            ProtoAdapter.BOOL.encodeWithTag(r100, 17, r116);
        L41:
            Integer r117 = r101.page_size;
            if (r117 == null) goto L44;
            r103.encodeWithTag(r100, 18, r117);
        L44:
            SearchScene r118 = r101.search_scene;
            if (r118 == null) goto L47;
            SearchScene.ADAPTER.encodeWithTag(r100, 19, r118);
        L47:
            Boolean r119 = r101.isTenantNotPayed;
            if (r119 == null) goto L50;
            ProtoAdapter.BOOL.encodeWithTag(r100, 20, r119);
        L50:
            Integer r120 = r101.query_len;
            if (r120 == null) goto L53;
            r103.encodeWithTag(r100, 21, r120);
        L53:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchCommonRequestHeader r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchCommonRequestHeader();
        DEFAULT_SESSION_SEQ_ID = 0;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_FORCE = r100;
        DEFAULT_CLUSTERING_TYPE = ClusteringType.COMMON_ITEMS;
        DEFAULT_TEMPLATE_INFO = ByteString.EMPTY;
        DEFAULT_IS_QUERY_TEMPLATE = r100;
        DEFAULT_PAGE_SIZE = 0;
        DEFAULT_SEARCH_SCENE = SearchScene.DEFAULT_SEARCH_SCENE;
        DEFAULT_ISTENANTNOTPAYED = r100;
        DEFAULT_QUERY_LEN = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.search_session = this.search_session;
        r100.session_seq_id = this.session_seq_id;
        r100.query = this.query;
        r100.pagination_token = this.pagination_token;
        r100.search_context = this.search_context;
        r100.extra_params = this.extra_params;
        r100.is_force = this.is_force;
        r100.title_layout = this.title_layout;
        r100.summary_layout = this.summary_layout;
        r100.section_summary_layout = this.section_summary_layout;
        r100.storage_info = this.storage_info;
        r100.paging_infos = Internal.copyOf("paging_infos", this.paging_infos);
        r100.clustering_type = this.clustering_type;
        r100.timezone = this.timezone;
        r100.f253732op = this.f253731op;
        r100.template_info = this.template_info;
        r100.is_query_template = this.is_query_template;
        r100.page_size = this.page_size;
        r100.search_scene = this.search_scene;
        r100.isTenantNotPayed = this.isTenantNotPayed;
        r100.query_len = this.query_len;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SearchCommonRequestHeader.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SearchCommonRequestHeader(String r210, Integer r211, String r212, String r213, BaseEntity.SearchContext r214, BaseEntity.SearchExtras r215, Boolean r310, Layout r311, Layout r312, Layout r313, ColdAndHotStorageInfo r314, List<PagingInfo> r315, ClusteringType r316, String r317, OpAfterError r318, ByteString r319, Boolean r410, Integer r411, SearchScene r412, Boolean r413, Integer r414) {
        this(r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, ByteString.EMPTY);
    }

    public SearchCommonRequestHeader(String r100, Integer r101, String r102, String r103, BaseEntity.SearchContext r104, BaseEntity.SearchExtras r105, Boolean r110, Layout r111, Layout r112, Layout r113, ColdAndHotStorageInfo r114, List<PagingInfo> r115, ClusteringType r116, String r117, OpAfterError r118, ByteString r119, Boolean r210, Integer r211, SearchScene r212, Boolean r213, Integer r214, ByteString r215) {
        super(ADAPTER, r215);
        this.search_session = r100;
        this.session_seq_id = r101;
        this.query = r102;
        this.pagination_token = r103;
        this.search_context = r104;
        this.extra_params = r105;
        this.is_force = r110;
        this.title_layout = r111;
        this.summary_layout = r112;
        this.section_summary_layout = r113;
        this.storage_info = r114;
        this.paging_infos = Internal.immutableCopyOf("paging_infos", r115);
        this.clustering_type = r116;
        this.timezone = r117;
        this.f253731op = r118;
        this.template_info = r119;
        this.is_query_template = r210;
        this.page_size = r211;
        this.search_scene = r212;
        this.isTenantNotPayed = r213;
        this.query_len = r214;
    }
}
