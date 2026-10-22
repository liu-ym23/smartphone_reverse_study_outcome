package com.bytedance.lark.pb.search.v2;

import com.bytedance.lark.pb.basic.v1.GroupSortRuleType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class GroupChatFilter extends Message<GroupChatFilter, Builder> {
    public static final ProtoAdapter<GroupChatFilter> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<GroupChatFilter, Builder> {
        @Override // com.squareup.wire.Message.Builder
        public GroupChatFilter build() {
            return new GroupChatFilter(super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }
    }

    public static final class IncludeUserFilter extends Message<IncludeUserFilter, Builder> {
        public static final ProtoAdapter<IncludeUserFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> user_ids;

        public static final class Builder extends Message.Builder<IncludeUserFilter, Builder> {
            public List<String> user_ids;

            @Override // com.squareup.wire.Message.Builder
            public IncludeUserFilter build() {
                return new IncludeUserFilter(this.user_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.user_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder user_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.user_ids = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_IncludeUserFilter extends ProtoAdapter<IncludeUserFilter> {
            public ProtoAdapter_IncludeUserFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, IncludeUserFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public IncludeUserFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.user_ids.add(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(IncludeUserFilter r100) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.user_ids) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ IncludeUserFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(IncludeUserFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, IncludeUserFilter r101) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.user_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, IncludeUserFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_IncludeUserFilter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.user_ids = Internal.copyOf("user_ids", this.user_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return IncludeUserFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public IncludeUserFilter(List<String> r100) {
            this(r100, ByteString.EMPTY);
        }

        public IncludeUserFilter(List<String> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.user_ids = Internal.immutableCopyOf("user_ids", r100);
        }
    }

    public static final class ProtoAdapter_GroupChatFilter extends ProtoAdapter<GroupChatFilter> {
        public ProtoAdapter_GroupChatFilter() {
            super(FieldEncoding.LENGTH_DELIMITED, GroupChatFilter.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GroupChatFilter decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L6;
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L6:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GroupChatFilter r100) {
            return r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GroupChatFilter decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GroupChatFilter r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GroupChatFilter r101) throws IOException {
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GroupChatFilter r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class SearchTypeFilter extends Message<SearchTypeFilter, Builder> {
        public static final ProtoAdapter<SearchTypeFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<SearchType> search_type;

        public static final class Builder extends Message.Builder<SearchTypeFilter, Builder> {
            public List<SearchType> search_type;

            @Override // com.squareup.wire.Message.Builder
            public SearchTypeFilter build() {
                return new SearchTypeFilter(this.search_type, super.buildUnknownFields());
            }

            public Builder() {
                this.search_type = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder search_type(List<SearchType> r100) {
                Internal.checkElementsNotNull(r100);
                this.search_type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SearchTypeFilter extends ProtoAdapter<SearchTypeFilter> {
            public ProtoAdapter_SearchTypeFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, SearchTypeFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SearchTypeFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L7;
                r101.search_type.add(SearchType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(SearchTypeFilter r100) {
                return SearchType.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.search_type) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SearchTypeFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SearchTypeFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SearchTypeFilter r101) throws IOException {
                SearchType.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.search_type);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchTypeFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum SearchType extends Enum<SearchType> implements WireEnum {
            private static final /* synthetic */ SearchType[] $VALUES = null;
            public static final ProtoAdapter<SearchType> ADAPTER = null;
            public static final SearchType CROSS_TENANT = null;
            public static final SearchType DEFAULT = null;
            public static final SearchType PRIVATE = null;
            public static final SearchType PUBLIC_JOINED = null;
            public static final SearchType PUBLIC_NOT_JOINED = null;
            private final int value;

            static {
                SearchType r100 = new SearchType("DEFAULT", 0, 0);
                DEFAULT = r100;
                SearchType r101 = new SearchType("PRIVATE", 1, 1);
                PRIVATE = r101;
                SearchType r102 = new SearchType("CROSS_TENANT", 2, 2);
                CROSS_TENANT = r102;
                SearchType r103 = new SearchType("PUBLIC_JOINED", 3, 3);
                PUBLIC_JOINED = r103;
                SearchType r104 = new SearchType("PUBLIC_NOT_JOINED", 4, 4);
                PUBLIC_NOT_JOINED = r104;
                $VALUES = new SearchType[]{r100, r101, r102, r103, r104};
                ADAPTER = ProtoAdapter.newEnumAdapter(SearchType.class);
            }

            public static SearchType[] values() {
                return (SearchType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static SearchType fromValue(int r100) {
                if (r100 == 0) goto L22;
                if (r100 == 1) goto L20;
                if (r100 == 2) goto L18;
                if (r100 == 3) goto L16;
                if (r100 == 4) goto L14;
                return null;
            L14:
                return PUBLIC_NOT_JOINED;
            L16:
                return PUBLIC_JOINED;
            L18:
                return CROSS_TENANT;
            L20:
                return PRIVATE;
            L22:
                return DEFAULT;
            }

            public static SearchType valueOf(String r100) {
                return (SearchType) a.a(SearchType.class, r100);
            }

            private SearchType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SearchTypeFilter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.search_type = Internal.copyOf("search_type", this.search_type);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SearchTypeFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SearchTypeFilter(List<SearchType> r100) {
            this(r100, ByteString.EMPTY);
        }

        public SearchTypeFilter(List<SearchType> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.search_type = Internal.immutableCopyOf("search_type", r100);
        }
    }

    public static final class SortRuleFilter extends Message<SortRuleFilter, Builder> {
        public static final ProtoAdapter<SortRuleFilter> ADAPTER = null;
        public static final GroupSortRuleType DEFAULT_SORT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final GroupSortRuleType sort_type;

        public static final class Builder extends Message.Builder<SortRuleFilter, Builder> {
            public GroupSortRuleType sort_type;

            @Override // com.squareup.wire.Message.Builder
            public SortRuleFilter build() {
                return new SortRuleFilter(this.sort_type, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder sort_type(GroupSortRuleType r100) {
                this.sort_type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SortRuleFilter extends ProtoAdapter<SortRuleFilter> {
            public ProtoAdapter_SortRuleFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, SortRuleFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SortRuleFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.sort_type = GroupSortRuleType.GROUP_DEFAULT_SORT;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L7;
                r101.sort_type = GroupSortRuleType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(SortRuleFilter r100) {
                GroupSortRuleType r101 = r100.sort_type;
                if (r101 == null) goto L5;
                int r102 = GroupSortRuleType.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SortRuleFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SortRuleFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SortRuleFilter r101) throws IOException {
                GroupSortRuleType r102 = r101.sort_type;
                if (r102 == null) goto L5;
                GroupSortRuleType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SortRuleFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SortRuleFilter();
            DEFAULT_SORT_TYPE = GroupSortRuleType.GROUP_DEFAULT_SORT;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.sort_type = this.sort_type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SortRuleFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SortRuleFilter(GroupSortRuleType r100) {
            this(r100, ByteString.EMPTY);
        }

        public SortRuleFilter(GroupSortRuleType r100, ByteString r101) {
            super(ADAPTER, r101);
            this.sort_type = r100;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GroupChatFilter();
    }

    public GroupChatFilter() {
        this(ByteString.EMPTY);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GroupChatFilter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GroupChatFilter(ByteString r100) {
        super(ADAPTER, r100);
    }
}
