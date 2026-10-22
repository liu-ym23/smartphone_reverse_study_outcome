package com.bytedance.lark.pb.search.v1;

import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
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
        public static final FilterInTab DEFAULT_ASSOCIATED_SMART_FILTER = null;
        public static final String DEFAULT_DISPLAY_NAME = "";
        public static final FilterType DEFAULT_FILTER_TYPE = null;
        public static final String DEFAULT_ID = "";
        public static final OptionMode DEFAULT_OPTION_MODE = null;
        public static final String DEFAULT_REFERENCE_APP_ID = "";
        private static final long serialVersionUID = 0;
        public final FilterInTab associated_smart_filter;
        public final String display_name;
        public final FilterType filter_type;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public final String f253685id;
        public final OptionMode option_mode;
        public final List<EnumValue> predefine_enum_values;
        public final String reference_app_id;

        public static final class Builder extends Message.Builder<CustomFilterInfo, Builder> {
            public FilterInTab associated_smart_filter;
            public String display_name;
            public FilterType filter_type;

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            public String f253686id;
            public OptionMode option_mode;
            public List<EnumValue> predefine_enum_values;
            public String reference_app_id;

            @Override // com.squareup.wire.Message.Builder
            public CustomFilterInfo build() {
                String r100 = this.f253686id;
                if (r100 == null) goto L11;
                if (this.display_name == null) goto L11;
                if (this.filter_type == null) goto L11;
                return new CustomFilterInfo(this.f253686id, this.display_name, this.filter_type, this.predefine_enum_values, this.option_mode, this.reference_app_id, this.associated_smart_filter, super.buildUnknownFields());
            L11:
                throw Internal.missingRequiredFields(new Object[]{r100, "id", this.display_name, IGoogleService.ResponseKey.DISPLAY_NAME, this.filter_type, EffectConfiguration.KEY_FILTER_TYPE});
            }

            public Builder() {
                this.predefine_enum_values = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder associated_smart_filter(FilterInTab r100) {
                this.associated_smart_filter = r100;
                return this;
            }

            public Builder display_name(String r100) {
                this.display_name = r100;
                return this;
            }

            public Builder filter_type(FilterType r100) {
                this.filter_type = r100;
                return this;
            }

            public Builder id(String r100) {
                this.f253686id = r100;
                return this;
            }

            public Builder option_mode(OptionMode r100) {
                this.option_mode = r100;
                return this;
            }

            public Builder predefine_enum_values(List<EnumValue> r100) {
                Internal.checkElementsNotNull(r100);
                this.predefine_enum_values = r100;
                return this;
            }

            public Builder reference_app_id(String r100) {
                this.reference_app_id = r100;
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
                r101.f253686id = "";
                r101.display_name = "";
                r101.filter_type = FilterType.USER_FILTER;
                r101.option_mode = OptionMode.SINGLE;
                r101.reference_app_id = "";
                r101.associated_smart_filter = FilterInTab.SMART_USER;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L23;
                switch(r103) {
                    case 1: goto L22;
                    case 2: goto L21;
                    case 3: goto L25;
                    case 4: goto L16;
                    case 5: goto L29;
                    case 6: goto L11;
                    case 7: goto L27;
                    default: goto L6;
                };
            L25:
                r101.filter_type = FilterType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L27:
                r101.associated_smart_filter = FilterInTab.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L29:
                r101.option_mode = OptionMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                r101.reference_app_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L16:
                r101.predefine_enum_values.add(EnumValue.ADAPTER.decode(r100));
                goto L3
            L21:
                r101.display_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L22:
                r101.f253686id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L23:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(CustomFilterInfo r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = ((r101.encodedSizeWithTag(1, r100.f253685id) + r101.encodedSizeWithTag(2, r100.display_name)) + FilterType.ADAPTER.encodedSizeWithTag(3, r100.filter_type)) + EnumValue.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.predefine_enum_values);
                OptionMode r103 = r100.option_mode;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = OptionMode.ADAPTER.encodedSizeWithTag(5, r103);
            L6:
                int r106 = r102 + r105;
                String r107 = r100.reference_app_id;
                if (r107 == null) goto L9;
                int r108 = r101.encodedSizeWithTag(6, r107);
            L10:
                int r109 = r106 + r108;
                FilterInTab r110 = r100.associated_smart_filter;
                if (r110 == null) goto L14;
                r104 = FilterInTab.ADAPTER.encodedSizeWithTag(7, r110);
            L14:
                return (r109 + r104) + r100.unknownFields().size();
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
                r102.encodeWithTag(r100, 1, r101.f253685id);
                r102.encodeWithTag(r100, 2, r101.display_name);
                FilterType.ADAPTER.encodeWithTag(r100, 3, r101.filter_type);
                EnumValue.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.predefine_enum_values);
                OptionMode r103 = r101.option_mode;
                if (r103 == null) goto L5;
                OptionMode.ADAPTER.encodeWithTag(r100, 5, r103);
            L5:
                String r104 = r101.reference_app_id;
                if (r104 == null) goto L8;
                r102.encodeWithTag(r100, 6, r104);
            L8:
                FilterInTab r105 = r101.associated_smart_filter;
                if (r105 == null) goto L11;
                FilterInTab.ADAPTER.encodeWithTag(r100, 7, r105);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomFilterInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CustomFilterInfo();
            DEFAULT_FILTER_TYPE = FilterType.USER_FILTER;
            DEFAULT_OPTION_MODE = OptionMode.SINGLE;
            DEFAULT_ASSOCIATED_SMART_FILTER = FilterInTab.SMART_USER;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.f253686id = this.f253685id;
            r100.display_name = this.display_name;
            r100.filter_type = this.filter_type;
            r100.predefine_enum_values = Internal.copyOf("predefine_enum_values", this.predefine_enum_values);
            r100.option_mode = this.option_mode;
            r100.reference_app_id = this.reference_app_id;
            r100.associated_smart_filter = this.associated_smart_filter;
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

        public CustomFilterInfo(String r110, String r111, FilterType r112, List<EnumValue> r113, OptionMode r114, String r115, FilterInTab r116) {
            this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
        }

        public CustomFilterInfo(String r100, String r101, FilterType r102, List<EnumValue> r103, OptionMode r104, String r105, FilterInTab r106, ByteString r107) {
            super(ADAPTER, r107);
            this.f253685id = r100;
            this.display_name = r101;
            this.filter_type = r102;
            this.predefine_enum_values = Internal.immutableCopyOf("predefine_enum_values", r103);
            this.option_mode = r104;
            this.reference_app_id = r105;
            this.associated_smart_filter = r106;
        }
    }

    public static final class EnumValue extends Message<EnumValue, Builder> {
        public static final ProtoAdapter<EnumValue> ADAPTER = null;
        public static final String DEFAULT_DISPLAY_TEXT = "";
        public static final String DEFAULT_ID = "";
        private static final long serialVersionUID = 0;
        public final String display_text;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public final String f253687id;

        public static final class Builder extends Message.Builder<EnumValue, Builder> {
            public String display_text;

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            public String f253688id;

            @Override // com.squareup.wire.Message.Builder
            public EnumValue build() {
                return new EnumValue(this.f253688id, this.display_text, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder display_text(String r100) {
                this.display_text = r100;
                return this;
            }

            public Builder id(String r100) {
                this.f253688id = r100;
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
                r101.f253688id = "";
                r101.display_text = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.f253688id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.display_text = ProtoAdapter.STRING.decode(r100);
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
                String r101 = r100.f253687id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.display_text;
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
                String r102 = r101.f253687id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.display_text;
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
            r100.f253688id = this.f253687id;
            r100.display_text = this.display_text;
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
            this.f253687id = r100;
            this.display_text = r101;
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
