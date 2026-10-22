package com.ss.android.lark.pb.searches;

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

/* JADX INFO: loaded from: classes37.dex */
public final class PlatformSearchFilter extends Message<PlatformSearchFilter, Builder> {
    public static final ProtoAdapter<PlatformSearchFilter> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<PlatformSearchFilter, Builder> {
        @Override // com.squareup.wire.Message.Builder
        public PlatformSearchFilter build() {
            return new PlatformSearchFilter(super.buildUnknownFields());
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
        public static final String DEFAULT_DEFAULT_CHECKED_ID = "";
        public static final Boolean DEFAULT_DISABLE_EMPTY_SEARCH_ONLY_CHECKED = null;
        public static final String DEFAULT_DISPLAY_NAME = "";
        public static final String DEFAULT_ID = "";
        public static final String DEFAULT_REFERENCE_APP_ID = "";
        public static final Boolean DEFAULT_SHOULD_REPORT = null;
        private static final long serialVersionUID = 0;
        public final FilterInTab massociated_smart_filter;
        public final String mdefault_checked_id;
        public final Boolean mdisable_empty_search_only_checked;
        public final String mdisplay_name;
        public final FilterType mfilter_type;
        public final String mid;
        public final OptionMode moption_mode;
        public final List<EnumValue> mpredefine_enum_values;
        public final String mreference_app_id;
        public final Boolean mshould_report;

        public static final class Builder extends Message.Builder<CustomFilterInfo, Builder> {
            public FilterInTab massociated_smart_filter;
            public String mdefault_checked_id;
            public Boolean mdisable_empty_search_only_checked;
            public String mdisplay_name;
            public FilterType mfilter_type;
            public String mid;
            public OptionMode moption_mode;
            public List<EnumValue> mpredefine_enum_values;
            public String mreference_app_id;
            public Boolean mshould_report;

            @Override // com.squareup.wire.Message.Builder
            public CustomFilterInfo build() {
                String r100 = this.mid;
                if (r100 == null) goto L11;
                if (this.mdisplay_name == null) goto L11;
                if (this.mfilter_type == null) goto L11;
                return new CustomFilterInfo(this.mid, this.mdisplay_name, this.mfilter_type, this.mpredefine_enum_values, this.moption_mode, this.mreference_app_id, this.massociated_smart_filter, this.mdefault_checked_id, this.mshould_report, this.mdisable_empty_search_only_checked, super.buildUnknownFields());
            L11:
                throw Internal.missingRequiredFields(new Object[]{r100, "mid", this.mdisplay_name, "mdisplay_name", this.mfilter_type, "mfilter_type"});
            }

            public Builder() {
                this.mpredefine_enum_values = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder associated_smart_filter(FilterInTab r100) {
                this.massociated_smart_filter = r100;
                return this;
            }

            public Builder default_checked_id(String r100) {
                this.mdefault_checked_id = r100;
                return this;
            }

            public Builder disable_empty_search_only_checked(Boolean r100) {
                this.mdisable_empty_search_only_checked = r100;
                return this;
            }

            public Builder display_name(String r100) {
                this.mdisplay_name = r100;
                return this;
            }

            public Builder filter_type(FilterType r100) {
                this.mfilter_type = r100;
                return this;
            }

            public Builder id(String r100) {
                this.mid = r100;
                return this;
            }

            public Builder option_mode(OptionMode r100) {
                this.moption_mode = r100;
                return this;
            }

            public Builder predefine_enum_values(List<EnumValue> r100) {
                Internal.checkElementsNotNull(r100);
                this.mpredefine_enum_values = r100;
                return this;
            }

            public Builder reference_app_id(String r100) {
                this.mreference_app_id = r100;
                return this;
            }

            public Builder should_report(Boolean r100) {
                this.mshould_report = r100;
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
                r101.mid = "";
                r101.mdisplay_name = "";
                r101.mreference_app_id = "";
                r101.mdefault_checked_id = "";
                Boolean r102 = Boolean.FALSE;
                r101.mshould_report = r102;
                r101.mdisable_empty_search_only_checked = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L26;
                switch(r104) {
                    case 1: goto L25;
                    case 2: goto L24;
                    case 3: goto L30;
                    case 4: goto L19;
                    case 5: goto L32;
                    case 6: goto L14;
                    case 7: goto L28;
                    case 8: goto L9;
                    case 9: goto L8;
                    case 10: goto L7;
                    default: goto L6;
                };
            L28:
                r101.massociated_smart_filter = FilterInTab.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L30:
                r101.mfilter_type = FilterType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L32:
                r101.moption_mode = OptionMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.mdisable_empty_search_only_checked = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                r101.mshould_report = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                r101.mdefault_checked_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                r101.mreference_app_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L19:
                r101.mpredefine_enum_values.add(EnumValue.ADAPTER.decode(r100));
                goto L3
            L24:
                r101.mdisplay_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L25:
                r101.mid = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L26:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(CustomFilterInfo r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = ((r101.encodedSizeWithTag(1, r100.mid) + r101.encodedSizeWithTag(2, r100.mdisplay_name)) + FilterType.ADAPTER.encodedSizeWithTag(3, r100.mfilter_type)) + EnumValue.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.mpredefine_enum_values);
                OptionMode r103 = r100.moption_mode;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = OptionMode.ADAPTER.encodedSizeWithTag(5, r103);
            L6:
                int r106 = r102 + r105;
                String r107 = r100.mreference_app_id;
                if (r107 == null) goto L9;
                int r108 = r101.encodedSizeWithTag(6, r107);
            L10:
                int r109 = r106 + r108;
                FilterInTab r110 = r100.massociated_smart_filter;
                if (r110 == null) goto L13;
                int r111 = FilterInTab.ADAPTER.encodedSizeWithTag(7, r110);
            L14:
                int r112 = r109 + r111;
                String r113 = r100.mdefault_checked_id;
                if (r113 == null) goto L17;
                int r114 = r101.encodedSizeWithTag(8, r113);
            L18:
                int r115 = r112 + r114;
                Boolean r116 = r100.mshould_report;
                if (r116 == null) goto L21;
                int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r116);
            L22:
                int r118 = r115 + r117;
                Boolean r119 = r100.mdisable_empty_search_only_checked;
                if (r119 == null) goto L26;
                r104 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r119);
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
                r102.encodeWithTag(r100, 1, r101.mid);
                r102.encodeWithTag(r100, 2, r101.mdisplay_name);
                FilterType.ADAPTER.encodeWithTag(r100, 3, r101.mfilter_type);
                EnumValue.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.mpredefine_enum_values);
                OptionMode r103 = r101.moption_mode;
                if (r103 == null) goto L5;
                OptionMode.ADAPTER.encodeWithTag(r100, 5, r103);
            L5:
                String r104 = r101.mreference_app_id;
                if (r104 == null) goto L8;
                r102.encodeWithTag(r100, 6, r104);
            L8:
                FilterInTab r105 = r101.massociated_smart_filter;
                if (r105 == null) goto L11;
                FilterInTab.ADAPTER.encodeWithTag(r100, 7, r105);
            L11:
                String r106 = r101.mdefault_checked_id;
                if (r106 == null) goto L14;
                r102.encodeWithTag(r100, 8, r106);
            L14:
                Boolean r107 = r101.mshould_report;
                if (r107 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r100, 9, r107);
            L17:
                Boolean r108 = r101.mdisable_empty_search_only_checked;
                if (r108 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r100, 10, r108);
            L20:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomFilterInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CustomFilterInfo();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_SHOULD_REPORT = r100;
            DEFAULT_DISABLE_EMPTY_SEARCH_ONLY_CHECKED = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mid = this.mid;
            r100.mdisplay_name = this.mdisplay_name;
            r100.mfilter_type = this.mfilter_type;
            r100.mpredefine_enum_values = Internal.copyOf("mpredefine_enum_values", this.mpredefine_enum_values);
            r100.moption_mode = this.moption_mode;
            r100.mreference_app_id = this.mreference_app_id;
            r100.massociated_smart_filter = this.massociated_smart_filter;
            r100.mdefault_checked_id = this.mdefault_checked_id;
            r100.mshould_report = this.mshould_report;
            r100.mdisable_empty_search_only_checked = this.mdisable_empty_search_only_checked;
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

        public CustomFilterInfo(String r110, String r111, FilterType r112, List<EnumValue> r113, OptionMode r114, String r115, FilterInTab r116, String r210, Boolean r211, Boolean r212) {
            this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
        }

        public CustomFilterInfo(String r100, String r101, FilterType r102, List<EnumValue> r103, OptionMode r104, String r105, FilterInTab r106, String r107, Boolean r110, Boolean r111, ByteString r112) {
            super(ADAPTER, r112);
            this.mid = r100;
            this.mdisplay_name = r101;
            this.mfilter_type = r102;
            this.mpredefine_enum_values = Internal.immutableCopyOf("mpredefine_enum_values", r103);
            this.moption_mode = r104;
            this.mreference_app_id = r105;
            this.massociated_smart_filter = r106;
            this.mdefault_checked_id = r107;
            this.mshould_report = r110;
            this.mdisable_empty_search_only_checked = r111;
        }
    }

    public static final class EnumValue extends Message<EnumValue, Builder> {
        public static final ProtoAdapter<EnumValue> ADAPTER = null;
        public static final String DEFAULT_DISPLAY_TEXT = "";
        public static final String DEFAULT_ID = "";
        private static final long serialVersionUID = 0;
        public final String mdisplay_text;
        public final String mid;

        public static final class Builder extends Message.Builder<EnumValue, Builder> {
            public String mdisplay_text;
            public String mid;

            @Override // com.squareup.wire.Message.Builder
            public EnumValue build() {
                return new EnumValue(this.mid, this.mdisplay_text, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder display_text(String r100) {
                this.mdisplay_text = r100;
                return this;
            }

            public Builder id(String r100) {
                this.mid = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_EnumValue extends ProtoAdapter<EnumValue> {
            public ProtoAdapter_EnumValue() {
                super(FieldEncoding.LENGTH_DELIMITED, EnumValue.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public EnumValue decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mid = "";
                r101.mdisplay_text = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mid = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mdisplay_text = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(EnumValue r100) {
                String r101 = r100.mid;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.mdisplay_text;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ EnumValue decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(EnumValue r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, EnumValue r101) throws IOException {
                String r102 = r101.mid;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.mdisplay_text;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EnumValue r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_EnumValue();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mid = this.mid;
            r100.mdisplay_text = this.mdisplay_text;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return EnumValue.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public EnumValue(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public EnumValue(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mid = r100;
            this.mdisplay_text = r101;
        }
    }

    public static final enum FilterType extends Enum<FilterType> implements WireEnum {
        private static final /* synthetic */ FilterType[] $VALUES = null;
        public static final ProtoAdapter<FilterType> ADAPTER = null;
        public static final FilterType CALENDAR_FILTER = null;
        public static final FilterType INPUT_TEXT_FILTER = null;
        public static final FilterType MAIL_USER = null;
        public static final FilterType PREDEFINE_ENUM_FILTER = null;
        public static final FilterType SEARCHABLE_FILTER = null;
        public static final FilterType TIME_FILTER = null;
        public static final FilterType USER_CHAT_FILTER = null;
        public static final FilterType USER_FILTER = null;
        private final int value;

        static {
            FilterType r100 = new FilterType("USER_FILTER", 0, 1);
            USER_FILTER = r100;
            FilterType r101 = new FilterType("TIME_FILTER", 1, 2);
            TIME_FILTER = r101;
            FilterType r102 = new FilterType("SEARCHABLE_FILTER", 2, 4);
            SEARCHABLE_FILTER = r102;
            FilterType r103 = new FilterType("PREDEFINE_ENUM_FILTER", 3, 5);
            PREDEFINE_ENUM_FILTER = r103;
            FilterType r104 = new FilterType("MAIL_USER", 4, 6);
            MAIL_USER = r104;
            FilterType r110 = new FilterType("INPUT_TEXT_FILTER", 5, 7);
            INPUT_TEXT_FILTER = r110;
            FilterType r111 = new FilterType("USER_CHAT_FILTER", 6, 8);
            USER_CHAT_FILTER = r111;
            FilterType r112 = new FilterType("CALENDAR_FILTER", 7, 9);
            CALENDAR_FILTER = r112;
            $VALUES = new FilterType[]{r100, r101, r102, r103, r104, r110, r111, r112};
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
            switch(r100) {
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L3;
                case 4: goto L16;
                case 5: goto L14;
                case 6: goto L12;
                case 7: goto L10;
                case 8: goto L8;
                case 9: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return CALENDAR_FILTER;
        L8:
            return USER_CHAT_FILTER;
        L10:
            return INPUT_TEXT_FILTER;
        L12:
            return MAIL_USER;
        L14:
            return PREDEFINE_ENUM_FILTER;
        L16:
            return SEARCHABLE_FILTER;
        L18:
            return TIME_FILTER;
        L20:
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

    public static final enum OptionMode extends Enum<OptionMode> implements WireEnum {
        private static final /* synthetic */ OptionMode[] $VALUES = null;
        public static final ProtoAdapter<OptionMode> ADAPTER = null;
        public static final OptionMode MULTIPLE = null;
        public static final OptionMode SINGLE = null;
        private final int value;

        static {
            OptionMode r100 = new OptionMode("SINGLE", 0, 1);
            SINGLE = r100;
            OptionMode r101 = new OptionMode("MULTIPLE", 1, 2);
            MULTIPLE = r101;
            $VALUES = new OptionMode[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(OptionMode.class);
        }

        public static OptionMode[] values() {
            return (OptionMode[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static OptionMode fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return MULTIPLE;
        L11:
            return SINGLE;
        }

        public static OptionMode valueOf(String r100) {
            return (OptionMode) a.a(OptionMode.class, r100);
        }

        private OptionMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_PlatformSearchFilter extends ProtoAdapter<PlatformSearchFilter> {
        public ProtoAdapter_PlatformSearchFilter() {
            super(FieldEncoding.LENGTH_DELIMITED, PlatformSearchFilter.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PlatformSearchFilter decode(ProtoReader r100) throws IOException {
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
        public int encodedSize2(PlatformSearchFilter r100) {
            return r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PlatformSearchFilter decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PlatformSearchFilter r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PlatformSearchFilter r101) throws IOException {
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PlatformSearchFilter r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PlatformSearchFilter();
    }

    public PlatformSearchFilter() {
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
        return PlatformSearchFilter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PlatformSearchFilter(ByteString r100) {
        super(ADAPTER, r100);
    }
}
