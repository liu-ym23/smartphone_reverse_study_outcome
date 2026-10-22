package com.bytedance.lark.pb.search.v2;

import com.bytedance.lark.pb.basic.v1.NavigationAppInfo;
import com.bytedance.lark.pb.basic.v1.NavigationAppType;
import com.obric.capabilitykit.EntityProvider;
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
public final class UniversalSearchResponse extends Message<UniversalSearchResponse, Builder> {
    public static final ProtoAdapter<UniversalSearchResponse> ADAPTER = null;
    public static final ByteString DEFAULT_TEMPLATE_INFO_RESPONSE = null;
    public static final ProtoAdapter_UniversalSearchResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final CopyWritingInfo copy_writing_info;
    public final ExtraMeta extra_meta;
    public final List<FailedEntityInfo> failed_entity_infos;
    public final SearchCommonResponseHeader header;
    public final List<HistoryNavigationAppInfo> navigation_app_info;
    public final List<PartialFailureEntityInfo> partial_failure_entities;
    public final RecordExtra record_extra;
    public final List<SearchResult> results;
    public final SuggestionInfo suggestion_info;
    public final ByteString template_info_response;

    public static final class Builder extends Message.Builder<UniversalSearchResponse, Builder> implements d<UniversalSearchResponse> {
        public CopyWritingInfo copy_writing_info;
        public ExtraMeta extra_meta;
        public List<FailedEntityInfo> failed_entity_infos;
        public SearchCommonResponseHeader header;
        public List<HistoryNavigationAppInfo> navigation_app_info;
        public List<PartialFailureEntityInfo> partial_failure_entities;
        public RecordExtra record_extra;
        public List<SearchResult> results;
        public SuggestionInfo suggestion_info;
        public ByteString template_info_response;

        @Override // com.squareup.wire.Message.Builder
        public UniversalSearchResponse build() {
            SearchCommonResponseHeader r100 = this.header;
            if (r100 == null) goto L7;
            return new UniversalSearchResponse(this.header, this.results, this.extra_meta, this.suggestion_info, this.failed_entity_infos, this.partial_failure_entities, this.record_extra, this.template_info_response, this.navigation_app_info, this.copy_writing_info, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "header"});
        }

        public Builder() {
            this.results = Internal.newMutableList();
            this.failed_entity_infos = Internal.newMutableList();
            this.partial_failure_entities = Internal.newMutableList();
            this.navigation_app_info = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder copy_writing_info(CopyWritingInfo r100) {
            this.copy_writing_info = r100;
            return this;
        }

        public Builder extra_meta(ExtraMeta r100) {
            this.extra_meta = r100;
            return this;
        }

        public Builder failed_entity_infos(List<FailedEntityInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.failed_entity_infos = r100;
            return this;
        }

        public Builder header(SearchCommonResponseHeader r100) {
            this.header = r100;
            return this;
        }

        public Builder navigation_app_info(List<HistoryNavigationAppInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.navigation_app_info = r100;
            return this;
        }

        public Builder partial_failure_entities(List<PartialFailureEntityInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.partial_failure_entities = r100;
            return this;
        }

        public Builder record_extra(RecordExtra r100) {
            this.record_extra = r100;
            return this;
        }

        public Builder results(List<SearchResult> r100) {
            Internal.checkElementsNotNull(r100);
            this.results = r100;
            return this;
        }

        public Builder suggestion_info(SuggestionInfo r100) {
            this.suggestion_info = r100;
            return this;
        }

        public Builder template_info_response(ByteString r100) {
            this.template_info_response = r100;
            return this;
        }
    }

    public static final class CopyWritingInfo extends Message<CopyWritingInfo, Builder> {
        public static final ProtoAdapter<CopyWritingInfo> ADAPTER = null;
        public static final String DEFAULT_MESSAGE_HAS_RESULT = "";
        public static final String DEFAULT_MESSAGE_NO_RESULT = "";
        public static final String DEFAULT_MESSAGE_NO_RESULT_FOR_QA_IN_CHAT = "";
        public static final String DEFAULT_MESSAGE_NO_RESULT_FOR_QA_IN_MESSAGE_SEARCH = "";
        private static final long serialVersionUID = 0;
        public final String message_has_result;
        public final String message_no_result;
        public final String message_no_result_for_qa_in_chat;
        public final String message_no_result_for_qa_in_message_search;

        public static final class Builder extends Message.Builder<CopyWritingInfo, Builder> {
            public String message_has_result;
            public String message_no_result;
            public String message_no_result_for_qa_in_chat;
            public String message_no_result_for_qa_in_message_search;

            @Override // com.squareup.wire.Message.Builder
            public CopyWritingInfo build() {
                return new CopyWritingInfo(this.message_has_result, this.message_no_result, this.message_no_result_for_qa_in_chat, this.message_no_result_for_qa_in_message_search, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder message_has_result(String r100) {
                this.message_has_result = r100;
                return this;
            }

            public Builder message_no_result(String r100) {
                this.message_no_result = r100;
                return this;
            }

            public Builder message_no_result_for_qa_in_chat(String r100) {
                this.message_no_result_for_qa_in_chat = r100;
                return this;
            }

            public Builder message_no_result_for_qa_in_message_search(String r100) {
                this.message_no_result_for_qa_in_message_search = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CopyWritingInfo extends ProtoAdapter<CopyWritingInfo> {
            public ProtoAdapter_CopyWritingInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, CopyWritingInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CopyWritingInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.message_has_result = "";
                r101.message_no_result = "";
                r101.message_no_result_for_qa_in_chat = "";
                r101.message_no_result_for_qa_in_message_search = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.message_has_result = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.message_no_result = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.message_no_result_for_qa_in_chat = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.message_no_result_for_qa_in_message_search = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(CopyWritingInfo r100) {
                String r101 = r100.message_has_result;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.message_no_result;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.message_no_result_for_qa_in_chat;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.message_no_result_for_qa_in_message_search;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                return (r109 + r102) + r100.unknownFields().size();
            L13:
                r108 = 0;
                goto L14
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CopyWritingInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CopyWritingInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CopyWritingInfo r101) throws IOException {
                String r102 = r101.message_has_result;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.message_no_result;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.message_no_result_for_qa_in_chat;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.message_no_result_for_qa_in_message_search;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CopyWritingInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CopyWritingInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.message_has_result = this.message_has_result;
            r100.message_no_result = this.message_no_result;
            r100.message_no_result_for_qa_in_chat = this.message_no_result_for_qa_in_chat;
            r100.message_no_result_for_qa_in_message_search = this.message_no_result_for_qa_in_message_search;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CopyWritingInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public CopyWritingInfo(String r100, String r101, String r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public CopyWritingInfo(String r100, String r101, String r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.message_has_result = r100;
            this.message_no_result = r101;
            this.message_no_result_for_qa_in_chat = r102;
            this.message_no_result_for_qa_in_message_search = r103;
        }
    }

    public static final class FailedEntityInfo extends Message<FailedEntityInfo, Builder> {
        public static final ProtoAdapter<FailedEntityInfo> ADAPTER = null;
        public static final SearchEntityType DEFAULT_ENTITY_TYPE = null;
        public static final Boolean DEFAULT_IS_NEED_LOCAL_FALLBACK = null;
        public static final String DEFAULT_LOCAL_PAGINATION_TOKEN = "";
        private static final long serialVersionUID = 0;
        public final SearchEntityType entity_type;
        public final Boolean is_need_local_fallback;
        public final String local_pagination_token;

        public static final class Builder extends Message.Builder<FailedEntityInfo, Builder> {
            public SearchEntityType entity_type;
            public Boolean is_need_local_fallback;
            public String local_pagination_token;

            @Override // com.squareup.wire.Message.Builder
            public FailedEntityInfo build() {
                SearchEntityType r100 = this.entity_type;
                if (r100 == null) goto L9;
                if (this.is_need_local_fallback == null) goto L9;
                return new FailedEntityInfo(this.entity_type, this.is_need_local_fallback, this.local_pagination_token, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, EntityProvider.KEY_ENTITY_TYPE, this.is_need_local_fallback, "is_need_local_fallback"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder entity_type(SearchEntityType r100) {
                this.entity_type = r100;
                return this;
            }

            public Builder is_need_local_fallback(Boolean r100) {
                this.is_need_local_fallback = r100;
                return this;
            }

            public Builder local_pagination_token(String r100) {
                this.local_pagination_token = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_FailedEntityInfo extends ProtoAdapter<FailedEntityInfo> {
            public ProtoAdapter_FailedEntityInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, FailedEntityInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public FailedEntityInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.entity_type = SearchEntityType.UNKNOWN;
                r101.is_need_local_fallback = Boolean.FALSE;
                r101.local_pagination_token = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.entity_type = SearchEntityType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.is_need_local_fallback = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.local_pagination_token = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(FailedEntityInfo r100) {
                int r101 = SearchEntityType.ADAPTER.encodedSizeWithTag(1, r100.entity_type) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.is_need_local_fallback);
                String r102 = r100.local_pagination_token;
                if (r102 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(3, r102);
            L7:
                return (r101 + r103) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ FailedEntityInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(FailedEntityInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, FailedEntityInfo r101) throws IOException {
                SearchEntityType.ADAPTER.encodeWithTag(r100, 1, r101.entity_type);
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.is_need_local_fallback);
                String r102 = r101.local_pagination_token;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FailedEntityInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_FailedEntityInfo();
            DEFAULT_ENTITY_TYPE = SearchEntityType.UNKNOWN;
            DEFAULT_IS_NEED_LOCAL_FALLBACK = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.entity_type = this.entity_type;
            r100.is_need_local_fallback = this.is_need_local_fallback;
            r100.local_pagination_token = this.local_pagination_token;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return FailedEntityInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public FailedEntityInfo(SearchEntityType r100, Boolean r101, String r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public FailedEntityInfo(SearchEntityType r100, Boolean r101, String r102, ByteString r103) {
            super(ADAPTER, r103);
            this.entity_type = r100;
            this.is_need_local_fallback = r101;
            this.local_pagination_token = r102;
        }
    }

    public static final class HistoryNavigationAppInfo extends Message<HistoryNavigationAppInfo, Builder> {
        public static final ProtoAdapter<HistoryNavigationAppInfo> ADAPTER = null;
        public static final NavigationAppType DEFAULT_APPTYPE = null;
        public static final String DEFAULT_APP_ID = "";
        public static final String DEFAULT_KEY = "";
        public static final String DEFAULT_SUBTITLE = "";
        public static final String DEFAULT_UNIQUE_ID = "";
        private static final long serialVersionUID = 0;
        public final NavigationAppType appType;
        public final String app_id;
        public final Map<String, String> extra;
        public final String key;
        public final NavigationAppInfo.Logo logo;
        public final Map<String, String> name;
        public final String subtitle;
        public final String unique_id;

        public static final class Builder extends Message.Builder<HistoryNavigationAppInfo, Builder> {
            public NavigationAppType appType;
            public String app_id;
            public Map<String, String> extra;
            public String key;
            public NavigationAppInfo.Logo logo;
            public Map<String, String> name;
            public String subtitle;
            public String unique_id;

            @Override // com.squareup.wire.Message.Builder
            public HistoryNavigationAppInfo build() {
                return new HistoryNavigationAppInfo(this.unique_id, this.key, this.appType, this.name, this.logo, this.extra, this.subtitle, this.app_id, super.buildUnknownFields());
            }

            public Builder() {
                this.name = Internal.newMutableMap();
                this.extra = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder appType(NavigationAppType r100) {
                this.appType = r100;
                return this;
            }

            public Builder app_id(String r100) {
                this.app_id = r100;
                return this;
            }

            public Builder extra(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.extra = r100;
                return this;
            }

            public Builder key(String r100) {
                this.key = r100;
                return this;
            }

            public Builder logo(NavigationAppInfo.Logo r100) {
                this.logo = r100;
                return this;
            }

            public Builder name(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.name = r100;
                return this;
            }

            public Builder subtitle(String r100) {
                this.subtitle = r100;
                return this;
            }

            public Builder unique_id(String r100) {
                this.unique_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_HistoryNavigationAppInfo extends ProtoAdapter<HistoryNavigationAppInfo> {
            private final ProtoAdapter<Map<String, String>> extra;
            private final ProtoAdapter<Map<String, String>> name;

            public ProtoAdapter_HistoryNavigationAppInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, HistoryNavigationAppInfo.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.name = ProtoAdapter.newMapAdapter(r100, r100);
                this.extra = ProtoAdapter.newMapAdapter(r100, r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public HistoryNavigationAppInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.unique_id = "";
                r101.key = "";
                r101.appType = NavigationAppType.APP_TYPE_LARK_NATIVE;
                r101.subtitle = "";
                r101.app_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                switch(r103) {
                    case 1: goto L17;
                    case 2: goto L16;
                    case 3: goto L20;
                    case 4: goto L11;
                    case 5: goto L10;
                    case 6: goto L9;
                    case 7: goto L8;
                    case 8: goto L7;
                    default: goto L6;
                };
            L20:
                r101.appType = NavigationAppType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.app_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                r101.subtitle = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                r101.extra.putAll(this.extra.decode(r100));
                goto L3
            L10:
                r101.logo = NavigationAppInfo.Logo.ADAPTER.decode(r100);
                goto L3
            L11:
                r101.name.putAll(this.name.decode(r100));
                goto L3
            L16:
                r101.key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L17:
                r101.unique_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(HistoryNavigationAppInfo r100) {
                String r101 = r100.unique_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.key;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                NavigationAppType r107 = r100.appType;
                if (r107 == null) goto L13;
                int r108 = NavigationAppType.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = (r106 + r108) + this.name.encodedSizeWithTag(4, r100.name);
                NavigationAppInfo.Logo r110 = r100.logo;
                if (r110 == null) goto L17;
                int r111 = NavigationAppInfo.Logo.ADAPTER.encodedSizeWithTag(5, r110);
            L18:
                int r112 = (r109 + r111) + this.extra.encodedSizeWithTag(6, r100.extra);
                String r113 = r100.subtitle;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.STRING.encodedSizeWithTag(7, r113);
            L22:
                int r115 = r112 + r114;
                String r116 = r100.app_id;
                if (r116 == null) goto L26;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(8, r116);
            L26:
                return (r115 + r102) + r100.unknownFields().size();
            L21:
                r114 = 0;
                goto L22
            L17:
                r111 = 0;
                goto L18
            L13:
                r108 = 0;
                goto L14
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ HistoryNavigationAppInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(HistoryNavigationAppInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, HistoryNavigationAppInfo r101) throws IOException {
                String r102 = r101.unique_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.key;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                NavigationAppType r104 = r101.appType;
                if (r104 == null) goto L11;
                NavigationAppType.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                this.name.encodeWithTag(r100, 4, r101.name);
                NavigationAppInfo.Logo r105 = r101.logo;
                if (r105 == null) goto L14;
                NavigationAppInfo.Logo.ADAPTER.encodeWithTag(r100, 5, r105);
            L14:
                this.extra.encodeWithTag(r100, 6, r101.extra);
                String r106 = r101.subtitle;
                if (r106 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 7, r106);
            L17:
                String r107 = r101.app_id;
                if (r107 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r100, 8, r107);
            L20:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HistoryNavigationAppInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_HistoryNavigationAppInfo();
            DEFAULT_APPTYPE = NavigationAppType.APP_TYPE_LARK_NATIVE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.unique_id = this.unique_id;
            r100.key = this.key;
            r100.appType = this.appType;
            r100.name = Internal.copyOf("name", this.name);
            r100.logo = this.logo;
            r100.extra = Internal.copyOf("extra", this.extra);
            r100.subtitle = this.subtitle;
            r100.app_id = this.app_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return HistoryNavigationAppInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public HistoryNavigationAppInfo(String r110, String r111, NavigationAppType r112, Map<String, String> r113, NavigationAppInfo.Logo r114, Map<String, String> r115, String r116, String r117) {
            this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
        }

        public HistoryNavigationAppInfo(String r100, String r101, NavigationAppType r102, Map<String, String> r103, NavigationAppInfo.Logo r104, Map<String, String> r105, String r106, String r107, ByteString r110) {
            super(ADAPTER, r110);
            this.unique_id = r100;
            this.key = r101;
            this.appType = r102;
            this.name = Internal.immutableCopyOf("name", r103);
            this.logo = r104;
            this.extra = Internal.immutableCopyOf("extra", r105);
            this.subtitle = r106;
            this.app_id = r107;
        }
    }

    public static final class PartialFailureEntityInfo extends Message<PartialFailureEntityInfo, Builder> {
        public static final ProtoAdapter<PartialFailureEntityInfo> ADAPTER = null;
        public static final SearchEntityType DEFAULT_ENTITY_TYPE = null;
        public static final Boolean DEFAULT_IS_NEED_LOCAL_FALLBACK = null;
        private static final long serialVersionUID = 0;
        public final SearchEntityType entity_type;
        public final Boolean is_need_local_fallback;

        public static final class Builder extends Message.Builder<PartialFailureEntityInfo, Builder> {
            public SearchEntityType entity_type;
            public Boolean is_need_local_fallback;

            @Override // com.squareup.wire.Message.Builder
            public PartialFailureEntityInfo build() {
                return new PartialFailureEntityInfo(this.entity_type, this.is_need_local_fallback, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder entity_type(SearchEntityType r100) {
                this.entity_type = r100;
                return this;
            }

            public Builder is_need_local_fallback(Boolean r100) {
                this.is_need_local_fallback = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_PartialFailureEntityInfo extends ProtoAdapter<PartialFailureEntityInfo> {
            public ProtoAdapter_PartialFailureEntityInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, PartialFailureEntityInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PartialFailureEntityInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.entity_type = SearchEntityType.UNKNOWN;
                r101.is_need_local_fallback = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.entity_type = SearchEntityType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.is_need_local_fallback = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(PartialFailureEntityInfo r100) {
                SearchEntityType r101 = r100.entity_type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = SearchEntityType.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.is_need_local_fallback;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ PartialFailureEntityInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(PartialFailureEntityInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, PartialFailureEntityInfo r101) throws IOException {
                SearchEntityType r102 = r101.entity_type;
                if (r102 == null) goto L5;
                SearchEntityType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.is_need_local_fallback;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PartialFailureEntityInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_PartialFailureEntityInfo();
            DEFAULT_ENTITY_TYPE = SearchEntityType.UNKNOWN;
            DEFAULT_IS_NEED_LOCAL_FALLBACK = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.entity_type = this.entity_type;
            r100.is_need_local_fallback = this.is_need_local_fallback;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return PartialFailureEntityInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public PartialFailureEntityInfo(SearchEntityType r100, Boolean r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public PartialFailureEntityInfo(SearchEntityType r100, Boolean r101, ByteString r102) {
            super(ADAPTER, r102);
            this.entity_type = r100;
            this.is_need_local_fallback = r101;
        }
    }

    public static final class ProtoAdapter_UniversalSearchResponse extends ProtoAdapter<UniversalSearchResponse> implements c<UniversalSearchResponse> {
        public ProtoAdapter_UniversalSearchResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, UniversalSearchResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UniversalSearchResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.template_info_response = ByteString.EMPTY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            switch(r103) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r101.copy_writing_info = CopyWritingInfo.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.navigation_app_info.add(HistoryNavigationAppInfo.ADAPTER.decode(r100));
            goto L3
        L9:
            r101.template_info_response = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L10:
            r101.record_extra = RecordExtra.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.partial_failure_entities.add(PartialFailureEntityInfo.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.failed_entity_infos.add(FailedEntityInfo.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.suggestion_info = SuggestionInfo.ADAPTER.decode(r100);
            goto L3
        L14:
            r101.extra_meta = ExtraMeta.ADAPTER.decode(r100);
            goto L3
        L15:
            r101.results.add(SearchResult.ADAPTER.decode(r100));
            goto L3
        L16:
            r101.header = SearchCommonResponseHeader.ADAPTER.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UniversalSearchResponse r100) {
            int r101 = SearchCommonResponseHeader.ADAPTER.encodedSizeWithTag(1, r100.header) + SearchResult.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.results);
            ExtraMeta r102 = r100.extra_meta;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ExtraMeta.ADAPTER.encodedSizeWithTag(3, r102);
        L6:
            int r105 = r101 + r104;
            SuggestionInfo r106 = r100.suggestion_info;
            if (r106 == null) goto L9;
            int r107 = SuggestionInfo.ADAPTER.encodedSizeWithTag(4, r106);
        L10:
            int r108 = ((r105 + r107) + FailedEntityInfo.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.failed_entity_infos)) + PartialFailureEntityInfo.ADAPTER.asRepeated().encodedSizeWithTag(6, r100.partial_failure_entities);
            RecordExtra r109 = r100.record_extra;
            if (r109 == null) goto L13;
            int r110 = RecordExtra.ADAPTER.encodedSizeWithTag(7, r109);
        L14:
            int r111 = r108 + r110;
            ByteString r112 = r100.template_info_response;
            if (r112 == null) goto L17;
            int r113 = ProtoAdapter.BYTES.encodedSizeWithTag(8, r112);
        L18:
            int r114 = (r111 + r113) + HistoryNavigationAppInfo.ADAPTER.asRepeated().encodedSizeWithTag(9, r100.navigation_app_info);
            CopyWritingInfo r115 = r100.copy_writing_info;
            if (r115 == null) goto L22;
            r103 = CopyWritingInfo.ADAPTER.encodedSizeWithTag(10, r115);
        L22:
            return (r114 + r103) + r100.unknownFields().size();
        L17:
            r113 = 0;
            goto L18
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UniversalSearchResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UniversalSearchResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UniversalSearchResponse r101) throws IOException {
            SearchCommonResponseHeader.ADAPTER.encodeWithTag(r100, 1, r101.header);
            SearchResult.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.results);
            ExtraMeta r102 = r101.extra_meta;
            if (r102 == null) goto L5;
            ExtraMeta.ADAPTER.encodeWithTag(r100, 3, r102);
        L5:
            SuggestionInfo r103 = r101.suggestion_info;
            if (r103 == null) goto L8;
            SuggestionInfo.ADAPTER.encodeWithTag(r100, 4, r103);
        L8:
            FailedEntityInfo.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.failed_entity_infos);
            PartialFailureEntityInfo.ADAPTER.asRepeated().encodeWithTag(r100, 6, r101.partial_failure_entities);
            RecordExtra r104 = r101.record_extra;
            if (r104 == null) goto L11;
            RecordExtra.ADAPTER.encodeWithTag(r100, 7, r104);
        L11:
            ByteString r105 = r101.template_info_response;
            if (r105 == null) goto L14;
            ProtoAdapter.BYTES.encodeWithTag(r100, 8, r105);
        L14:
            HistoryNavigationAppInfo.ADAPTER.asRepeated().encodeWithTag(r100, 9, r101.navigation_app_info);
            CopyWritingInfo r106 = r101.copy_writing_info;
            if (r106 == null) goto L17;
            CopyWritingInfo.ADAPTER.encodeWithTag(r100, 10, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UniversalSearchResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UniversalSearchResponse r100 = new ProtoAdapter_UniversalSearchResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_TEMPLATE_INFO_RESPONSE = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.header = this.header;
        r100.results = Internal.copyOf("results", this.results);
        r100.extra_meta = this.extra_meta;
        r100.suggestion_info = this.suggestion_info;
        r100.failed_entity_infos = Internal.copyOf("failed_entity_infos", this.failed_entity_infos);
        r100.partial_failure_entities = Internal.copyOf("partial_failure_entities", this.partial_failure_entities);
        r100.record_extra = this.record_extra;
        r100.template_info_response = this.template_info_response;
        r100.navigation_app_info = Internal.copyOf("navigation_app_info", this.navigation_app_info);
        r100.copy_writing_info = this.copy_writing_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UniversalSearchResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UniversalSearchResponse(SearchCommonResponseHeader r110, List<SearchResult> r111, ExtraMeta r112, SuggestionInfo r113, List<FailedEntityInfo> r114, List<PartialFailureEntityInfo> r115, RecordExtra r116, ByteString r210, List<HistoryNavigationAppInfo> r211, CopyWritingInfo r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public UniversalSearchResponse(SearchCommonResponseHeader r100, List<SearchResult> r101, ExtraMeta r102, SuggestionInfo r103, List<FailedEntityInfo> r104, List<PartialFailureEntityInfo> r105, RecordExtra r106, ByteString r107, List<HistoryNavigationAppInfo> r110, CopyWritingInfo r111, ByteString r112) {
        super(ADAPTER, r112);
        this.header = r100;
        this.results = Internal.immutableCopyOf("results", r101);
        this.extra_meta = r102;
        this.suggestion_info = r103;
        this.failed_entity_infos = Internal.immutableCopyOf("failed_entity_infos", r104);
        this.partial_failure_entities = Internal.immutableCopyOf("partial_failure_entities", r105);
        this.record_extra = r106;
        this.template_info_response = r107;
        this.navigation_app_info = Internal.immutableCopyOf("navigation_app_info", r110);
        this.copy_writing_info = r111;
    }
}
