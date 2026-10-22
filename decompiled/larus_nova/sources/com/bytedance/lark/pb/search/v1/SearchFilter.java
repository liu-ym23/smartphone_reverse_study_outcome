package com.bytedance.lark.pb.search.v1;

import com.bytedance.sdk.account.platform.api.IGoogleService;
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
public final class SearchFilter extends Message<SearchFilter, Builder> {
    public static final ProtoAdapter<SearchFilter> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<SearchFilter, Builder> {
        @Override // com.squareup.wire.Message.Builder
        public SearchFilter build() {
            return new SearchFilter(super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }
    }

    public static final class CustomFilterInfo extends Message<CustomFilterInfo, Builder> {
        public static final ProtoAdapter<CustomFilterInfo> ADAPTER = null;
        public static final String DEFAULT_DISPLAY_NAME = "";
        public static final String DEFAULT_ID = "";
        public static final FilterInTab DEFAULT_SMART_TAB_FILTER_TYPE = null;
        public static final FilterType DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final String display_name;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public final String f253693id;
        public final List<String> options;
        public final FilterInTab smart_tab_filter_type;
        public final FilterType type;

        public static final class Builder extends Message.Builder<CustomFilterInfo, Builder> {
            public String display_name;

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            public String f253694id;
            public List<String> options;
            public FilterInTab smart_tab_filter_type;
            public FilterType type;

            @Override // com.squareup.wire.Message.Builder
            public CustomFilterInfo build() {
                String r100 = this.f253694id;
                if (r100 == null) goto L11;
                if (this.display_name == null) goto L11;
                if (this.type == null) goto L11;
                return new CustomFilterInfo(this.f253694id, this.display_name, this.type, this.options, this.smart_tab_filter_type, super.buildUnknownFields());
            L11:
                throw Internal.missingRequiredFields(new Object[]{r100, "id", this.display_name, IGoogleService.ResponseKey.DISPLAY_NAME, this.type, "type"});
            }

            public Builder() {
                this.options = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder display_name(String r100) {
                this.display_name = r100;
                return this;
            }

            public Builder id(String r100) {
                this.f253694id = r100;
                return this;
            }

            public Builder options(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.options = r100;
                return this;
            }

            public Builder smart_tab_filter_type(FilterInTab r100) {
                this.smart_tab_filter_type = r100;
                return this;
            }

            public Builder type(FilterType r100) {
                this.type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CustomFilterInfo extends ProtoAdapter<CustomFilterInfo> {
            public ProtoAdapter_CustomFilterInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, CustomFilterInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CustomFilterInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.f253694id = "";
                r101.display_name = "";
                r101.type = FilterType.USER_FILTER;
                r101.smart_tab_filter_type = FilterInTab.SMART_USER;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L27;
                if (r103 != 1) goto L8;
                r101.f253694id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.display_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.type = FilterType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
            L23:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.options.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.smart_tab_filter_type = FilterInTab.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            L18:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L15:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L27:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(CustomFilterInfo r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = ((r101.encodedSizeWithTag(1, r100.f253693id) + r101.encodedSizeWithTag(2, r100.display_name)) + FilterType.ADAPTER.encodedSizeWithTag(3, r100.type)) + r101.asRepeated().encodedSizeWithTag(4, r100.options);
                FilterInTab r103 = r100.smart_tab_filter_type;
                if (r103 == null) goto L5;
                int r104 = FilterInTab.ADAPTER.encodedSizeWithTag(5, r103);
            L7:
                return (r102 + r104) + r100.unknownFields().size();
            L5:
                r104 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CustomFilterInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CustomFilterInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CustomFilterInfo r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.f253693id);
                r102.encodeWithTag(r100, 2, r101.display_name);
                FilterType.ADAPTER.encodeWithTag(r100, 3, r101.type);
                r102.asRepeated().encodeWithTag(r100, 4, r101.options);
                FilterInTab r103 = r101.smart_tab_filter_type;
                if (r103 == null) goto L5;
                FilterInTab.ADAPTER.encodeWithTag(r100, 5, r103);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomFilterInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CustomFilterInfo();
            DEFAULT_TYPE = FilterType.USER_FILTER;
            DEFAULT_SMART_TAB_FILTER_TYPE = FilterInTab.SMART_USER;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.f253694id = this.f253693id;
            r100.display_name = this.display_name;
            r100.type = this.type;
            r100.options = Internal.copyOf("options", this.options);
            r100.smart_tab_filter_type = this.smart_tab_filter_type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CustomFilterInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public CustomFilterInfo(String r100, String r101, FilterType r110, List<String> r111, FilterInTab r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public CustomFilterInfo(String r100, String r101, FilterType r102, List<String> r103, FilterInTab r104, ByteString r105) {
            super(ADAPTER, r105);
            this.f253693id = r100;
            this.display_name = r101;
            this.type = r102;
            this.options = Internal.immutableCopyOf("options", r103);
            this.smart_tab_filter_type = r104;
        }
    }

    public static final enum FilterType extends Enum<FilterType> implements WireEnum {
        private static final /* synthetic */ FilterType[] $VALUES = null;
        public static final ProtoAdapter<FilterType> ADAPTER = null;
        public static final FilterType CHAT_FILTER = null;
        public static final FilterType DURATION_FILTER = null;
        public static final FilterType MULTIPLE_CHOICE_FILTER = null;
        public static final FilterType SINGLE_CHOICE_FILTER = null;
        public static final FilterType USER_FILTER = null;
        private final int value;

        static {
            FilterType r100 = new FilterType("USER_FILTER", 0, 1);
            USER_FILTER = r100;
            FilterType r101 = new FilterType("DURATION_FILTER", 1, 2);
            DURATION_FILTER = r101;
            FilterType r102 = new FilterType("SINGLE_CHOICE_FILTER", 2, 3);
            SINGLE_CHOICE_FILTER = r102;
            FilterType r103 = new FilterType("MULTIPLE_CHOICE_FILTER", 3, 4);
            MULTIPLE_CHOICE_FILTER = r103;
            FilterType r104 = new FilterType("CHAT_FILTER", 4, 5);
            CHAT_FILTER = r104;
            $VALUES = new FilterType[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(FilterType.class);
        }

        public static FilterType[] values() {
            return (FilterType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static FilterType fromValue(int r100) {
            if (r100 == 1) goto L23;
            if (r100 == 2) goto L21;
            if (r100 == 3) goto L19;
            if (r100 == 4) goto L17;
            if (r100 == 5) goto L15;
            return null;
        L15:
            return CHAT_FILTER;
        L17:
            return MULTIPLE_CHOICE_FILTER;
        L19:
            return SINGLE_CHOICE_FILTER;
        L21:
            return DURATION_FILTER;
        L23:
            return USER_FILTER;
        }

        public static FilterType valueOf(String r100) {
            return (FilterType) a.a(FilterType.class, r100);
        }

        private FilterType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_SearchFilter extends ProtoAdapter<SearchFilter> {
        public ProtoAdapter_SearchFilter() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchFilter.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SearchFilter decode(ProtoReader r100) throws IOException {
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
        public int encodedSize2(SearchFilter r100) {
            return r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SearchFilter decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SearchFilter r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SearchFilter r101) throws IOException {
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchFilter r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchFilter();
    }

    public SearchFilter() {
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
        return SearchFilter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SearchFilter(ByteString r100) {
        super(ADAPTER, r100);
    }
}
