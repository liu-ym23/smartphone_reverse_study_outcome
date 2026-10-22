package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class AppStatusInfo extends com.squareup.wire.Message<AppStatusInfo, Builder> {
    public static final ProtoAdapter<AppStatusInfo> ADAPTER = null;
    public static final Long DEFAULT_APP_ID = null;
    public static final String DEFAULT_APP_STORE_URL = "";
    public static final String DEFAULT_APP_URL = "";
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final Boolean DEFAULT_CHATABLE = null;
    public static final String DEFAULT_CLI_ID = "";
    public static final String DEFAULT_EXTRA_CONFIG = "";
    public static final Boolean DEFAULT_IS_AVAILABLE = null;
    public static final Boolean DEFAULT_IS_ISV = null;
    private static final long serialVersionUID = 0;
    public final List<FeatureAbility> mapp_ability;
    public final Long mapp_id;
    public final String mapp_store_url;
    public final String mapp_url;
    public final Image mavatar;
    public final String mavatar_key;
    public final List<BotCheckStatus> mbot_list;
    public final BotMenuDisplayStrategy mbot_menu_display_strategy;
    public final Boolean mchatable;
    public final String mcli_id;
    public final List<ExtraHitField> mextraHitFields;
    public final String mextra_config;
    public final Map<String, String> mi18n_descriptions;
    public final Map<String, String> mi18n_names;
    public final Boolean mis_available;
    public final Boolean mis_isv;
    public final AppUsageStatus mstatus;
    public final TipsContent mtips;

    public static final enum AppUsageStatus extends Enum<AppUsageStatus> implements WireEnum {
        private static final /* synthetic */ AppUsageStatus[] $VALUES = null;
        public static final ProtoAdapter<AppUsageStatus> ADAPTER = null;
        public static final AppUsageStatus APP_DELETED = null;
        public static final AppUsageStatus APP_DEVELOPER_FORBIDDEN = null;
        public static final AppUsageStatus APP_NEED_PAY_USE = null;
        public static final AppUsageStatus APP_OFFLINE = null;
        public static final AppUsageStatus APP_PLATFORM_FORBIDDEN = null;
        public static final AppUsageStatus APP_TENANT_FORBIDDEN = null;
        public static final AppUsageStatus APP_USABLE = null;
        public static final AppUsageStatus APP_USER_UNVISIBLE = null;
        private final int value;

        static {
            AppUsageStatus r100 = new AppUsageStatus("APP_USABLE", 0, 1);
            APP_USABLE = r100;
            AppUsageStatus r101 = new AppUsageStatus("APP_TENANT_FORBIDDEN", 1, 2);
            APP_TENANT_FORBIDDEN = r101;
            AppUsageStatus r102 = new AppUsageStatus("APP_PLATFORM_FORBIDDEN", 2, 3);
            APP_PLATFORM_FORBIDDEN = r102;
            AppUsageStatus r103 = new AppUsageStatus("APP_DEVELOPER_FORBIDDEN", 3, 4);
            APP_DEVELOPER_FORBIDDEN = r103;
            AppUsageStatus r104 = new AppUsageStatus("APP_OFFLINE", 4, 5);
            APP_OFFLINE = r104;
            AppUsageStatus r110 = new AppUsageStatus("APP_USER_UNVISIBLE", 5, 6);
            APP_USER_UNVISIBLE = r110;
            AppUsageStatus r111 = new AppUsageStatus("APP_NEED_PAY_USE", 6, 7);
            APP_NEED_PAY_USE = r111;
            AppUsageStatus r112 = new AppUsageStatus("APP_DELETED", 7, 8);
            APP_DELETED = r112;
            $VALUES = new AppUsageStatus[]{r100, r101, r102, r103, r104, r110, r111, r112};
            ADAPTER = ProtoAdapter.newEnumAdapter(AppUsageStatus.class);
        }

        public static AppUsageStatus[] values() {
            return (AppUsageStatus[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static AppUsageStatus fromValue(int r100) {
            switch(r100) {
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L16;
                case 4: goto L14;
                case 5: goto L12;
                case 6: goto L10;
                case 7: goto L8;
                case 8: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return APP_DELETED;
        L8:
            return APP_NEED_PAY_USE;
        L10:
            return APP_USER_UNVISIBLE;
        L12:
            return APP_OFFLINE;
        L14:
            return APP_DEVELOPER_FORBIDDEN;
        L16:
            return APP_PLATFORM_FORBIDDEN;
        L18:
            return APP_TENANT_FORBIDDEN;
        L20:
            return APP_USABLE;
        }

        public static AppUsageStatus valueOf(String r100) {
            return (AppUsageStatus) a.a(AppUsageStatus.class, r100);
        }

        private AppUsageStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum BotMenuDisplayStrategy extends Enum<BotMenuDisplayStrategy> implements WireEnum {
        private static final /* synthetic */ BotMenuDisplayStrategy[] $VALUES = null;
        public static final ProtoAdapter<BotMenuDisplayStrategy> ADAPTER = null;
        public static final BotMenuDisplayStrategy CHAT_INPUT = null;
        public static final BotMenuDisplayStrategy CHAT_MENU = null;
        public static final BotMenuDisplayStrategy FLOATING = null;
        public static final BotMenuDisplayStrategy UNKNOWN = null;
        private final int value;

        static {
            BotMenuDisplayStrategy r100 = new BotMenuDisplayStrategy("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            BotMenuDisplayStrategy r101 = new BotMenuDisplayStrategy("CHAT_MENU", 1, 1);
            CHAT_MENU = r101;
            BotMenuDisplayStrategy r102 = new BotMenuDisplayStrategy("CHAT_INPUT", 2, 2);
            CHAT_INPUT = r102;
            BotMenuDisplayStrategy r103 = new BotMenuDisplayStrategy("FLOATING", 3, 3);
            FLOATING = r103;
            $VALUES = new BotMenuDisplayStrategy[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(BotMenuDisplayStrategy.class);
        }

        public static BotMenuDisplayStrategy[] values() {
            return (BotMenuDisplayStrategy[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static BotMenuDisplayStrategy fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return FLOATING;
        L14:
            return CHAT_INPUT;
        L16:
            return CHAT_MENU;
        L18:
            return UNKNOWN;
        }

        public static BotMenuDisplayStrategy valueOf(String r100) {
            return (BotMenuDisplayStrategy) a.a(BotMenuDisplayStrategy.class, r100);
        }

        private BotMenuDisplayStrategy(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<AppStatusInfo, Builder> {
        public List<FeatureAbility> mapp_ability;
        public Long mapp_id;
        public String mapp_store_url;
        public String mapp_url;
        public Image mavatar;
        public String mavatar_key;
        public List<BotCheckStatus> mbot_list;
        public BotMenuDisplayStrategy mbot_menu_display_strategy;
        public Boolean mchatable;
        public String mcli_id;
        public List<ExtraHitField> mextraHitFields;
        public String mextra_config;
        public Map<String, String> mi18n_descriptions;
        public Map<String, String> mi18n_names;
        public Boolean mis_available;
        public Boolean mis_isv;
        public AppUsageStatus mstatus;
        public TipsContent mtips;

        @Override // com.squareup.wire.Message.Builder
        public AppStatusInfo build() {
            return new AppStatusInfo(this.mcli_id, this.mstatus, this.mtips, this.mbot_list, this.mapp_ability, this.mapp_url, this.mi18n_names, this.mi18n_descriptions, this.mavatar_key, this.mapp_id, this.mchatable, this.mextra_config, this.mavatar, this.mapp_store_url, this.mis_isv, this.mis_available, this.mextraHitFields, this.mbot_menu_display_strategy, super.buildUnknownFields());
        }

        public Builder() {
            this.mbot_list = Internal.newMutableList();
            this.mapp_ability = Internal.newMutableList();
            this.mi18n_names = Internal.newMutableMap();
            this.mi18n_descriptions = Internal.newMutableMap();
            this.mextraHitFields = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder app_ability(List<FeatureAbility> r100) {
            Internal.checkElementsNotNull(r100);
            this.mapp_ability = r100;
            return this;
        }

        public Builder app_id(Long r100) {
            this.mapp_id = r100;
            return this;
        }

        public Builder app_store_url(String r100) {
            this.mapp_store_url = r100;
            return this;
        }

        public Builder app_url(String r100) {
            this.mapp_url = r100;
            return this;
        }

        public Builder avatar(Image r100) {
            this.mavatar = r100;
            return this;
        }

        public Builder avatar_key(String r100) {
            this.mavatar_key = r100;
            return this;
        }

        public Builder bot_list(List<BotCheckStatus> r100) {
            Internal.checkElementsNotNull(r100);
            this.mbot_list = r100;
            return this;
        }

        public Builder bot_menu_display_strategy(BotMenuDisplayStrategy r100) {
            this.mbot_menu_display_strategy = r100;
            return this;
        }

        public Builder chatable(Boolean r100) {
            this.mchatable = r100;
            return this;
        }

        public Builder cli_id(String r100) {
            this.mcli_id = r100;
            return this;
        }

        public Builder extraHitFields(List<ExtraHitField> r100) {
            Internal.checkElementsNotNull(r100);
            this.mextraHitFields = r100;
            return this;
        }

        public Builder extra_config(String r100) {
            this.mextra_config = r100;
            return this;
        }

        public Builder i18n_descriptions(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mi18n_descriptions = r100;
            return this;
        }

        public Builder i18n_names(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mi18n_names = r100;
            return this;
        }

        public Builder is_available(Boolean r100) {
            this.mis_available = r100;
            return this;
        }

        public Builder is_isv(Boolean r100) {
            this.mis_isv = r100;
            return this;
        }

        public Builder status(AppUsageStatus r100) {
            this.mstatus = r100;
            return this;
        }

        public Builder tips(TipsContent r100) {
            this.mtips = r100;
            return this;
        }
    }

    public static final enum FeatureAbility extends Enum<FeatureAbility> implements WireEnum {
        private static final /* synthetic */ FeatureAbility[] $VALUES = null;
        public static final ProtoAdapter<FeatureAbility> ADAPTER = null;
        public static final FeatureAbility BOT = null;
        public static final FeatureAbility H5 = null;
        public static final FeatureAbility LOCAL_COMPONENT = null;
        public static final FeatureAbility SMALL = null;
        private final int value;

        static {
            FeatureAbility r100 = new FeatureAbility("SMALL", 0, 1);
            SMALL = r100;
            FeatureAbility r101 = new FeatureAbility("H5", 1, 2);
            H5 = r101;
            FeatureAbility r102 = new FeatureAbility("BOT", 2, 3);
            BOT = r102;
            FeatureAbility r103 = new FeatureAbility("LOCAL_COMPONENT", 3, 4);
            LOCAL_COMPONENT = r103;
            $VALUES = new FeatureAbility[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(FeatureAbility.class);
        }

        public static FeatureAbility[] values() {
            return (FeatureAbility[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static FeatureAbility fromValue(int r100) {
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L15;
            if (r100 == 4) goto L13;
            return null;
        L13:
            return LOCAL_COMPONENT;
        L15:
            return BOT;
        L17:
            return H5;
        L19:
            return SMALL;
        }

        public static FeatureAbility valueOf(String r100) {
            return (FeatureAbility) a.a(FeatureAbility.class, r100);
        }

        private FeatureAbility(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_AppStatusInfo extends ProtoAdapter<AppStatusInfo> {
        private final ProtoAdapter<Map<String, String>> mi18n_descriptions;
        private final ProtoAdapter<Map<String, String>> mi18n_names;

        public ProtoAdapter_AppStatusInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, AppStatusInfo.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mi18n_names = ProtoAdapter.newMapAdapter(r100, r100);
            this.mi18n_descriptions = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AppStatusInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mcli_id = "";
            r101.mapp_url = "";
            r101.mavatar_key = "";
            r101.mapp_id = 0L;
            Boolean r102 = Boolean.FALSE;
            r101.mchatable = r102;
            r101.mextra_config = "";
            r101.mapp_store_url = "";
            r101.mis_isv = r102;
            r101.mis_available = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L34;
            switch(r104) {
                case 1: goto L33;
                case 2: goto L36;
                case 3: goto L28;
                case 4: goto L27;
                case 5: goto L38;
                case 6: goto L22;
                case 7: goto L21;
                case 8: goto L20;
                case 9: goto L19;
                case 10: goto L18;
                case 11: goto L17;
                case 12: goto L16;
                case 13: goto L15;
                case 14: goto L14;
                case 15: goto L13;
                case 16: goto L12;
                case 17: goto L11;
                case 18: goto L40;
                default: goto L6;
            };
        L36:
            r101.mstatus = AppUsageStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L31
        L31:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L38:
            r101.mapp_ability.add(FeatureAbility.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L40:
            r101.mbot_menu_display_strategy = BotMenuDisplayStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.mextraHitFields.add(ExtraHitField.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.mis_available = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.mis_isv = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            r101.mapp_store_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.mavatar = Image.ADAPTER.decode(r100);
            goto L3
        L16:
            r101.mextra_config = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.mchatable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L18:
            r101.mapp_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L19:
            r101.mavatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.mi18n_descriptions.putAll(this.mi18n_descriptions.decode(r100));
            goto L3
        L21:
            r101.mi18n_names.putAll(this.mi18n_names.decode(r100));
            goto L3
        L22:
            r101.mapp_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L27:
            r101.mbot_list.add(BotCheckStatus.ADAPTER.decode(r100));
            goto L3
        L28:
            r101.mtips = TipsContent.ADAPTER.decode(r100);
            goto L3
        L33:
            r101.mcli_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(AppStatusInfo r100) {
            String r101 = r100.mcli_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            AppUsageStatus r104 = r100.mstatus;
            if (r104 == null) goto L9;
            int r105 = AppUsageStatus.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            TipsContent r107 = r100.mtips;
            if (r107 == null) goto L13;
            int r108 = TipsContent.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = ((r106 + r108) + BotCheckStatus.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.mbot_list)) + FeatureAbility.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.mapp_ability);
            String r110 = r100.mapp_url;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(6, r110);
        L18:
            int r112 = ((r109 + r111) + this.mi18n_names.encodedSizeWithTag(7, r100.mi18n_names)) + this.mi18n_descriptions.encodedSizeWithTag(8, r100.mi18n_descriptions);
            String r113 = r100.mavatar_key;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(9, r113);
        L22:
            int r115 = r112 + r114;
            Long r116 = r100.mapp_id;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT64.encodedSizeWithTag(10, r116);
        L26:
            int r118 = r115 + r117;
            Boolean r119 = r100.mchatable;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.mextra_config;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(12, r122);
        L34:
            int r124 = r121 + r123;
            Image r125 = r100.mavatar;
            if (r125 == null) goto L37;
            int r126 = Image.ADAPTER.encodedSizeWithTag(13, r125);
        L38:
            int r127 = r124 + r126;
            String r128 = r100.mapp_store_url;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.STRING.encodedSizeWithTag(14, r128);
        L42:
            int r130 = r127 + r129;
            Boolean r131 = r100.mis_isv;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.BOOL.encodedSizeWithTag(15, r131);
        L46:
            int r133 = r130 + r132;
            Boolean r134 = r100.mis_available;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.BOOL.encodedSizeWithTag(16, r134);
        L50:
            int r136 = (r133 + r135) + ExtraHitField.ADAPTER.asRepeated().encodedSizeWithTag(17, r100.mextraHitFields);
            BotMenuDisplayStrategy r137 = r100.mbot_menu_display_strategy;
            if (r137 == null) goto L54;
            r102 = BotMenuDisplayStrategy.ADAPTER.encodedSizeWithTag(18, r137);
        L54:
            return (r136 + r102) + r100.unknownFields().size();
        L49:
            r135 = 0;
            goto L50
        L45:
            r132 = 0;
            goto L46
        L41:
            r129 = 0;
            goto L42
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
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
        public /* bridge */ /* synthetic */ AppStatusInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AppStatusInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AppStatusInfo r101) throws IOException {
            String r102 = r101.mcli_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            AppUsageStatus r103 = r101.mstatus;
            if (r103 == null) goto L8;
            AppUsageStatus.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            TipsContent r104 = r101.mtips;
            if (r104 == null) goto L11;
            TipsContent.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            BotCheckStatus.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.mbot_list);
            FeatureAbility.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.mapp_ability);
            String r105 = r101.mapp_url;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r105);
        L14:
            this.mi18n_names.encodeWithTag(r100, 7, r101.mi18n_names);
            this.mi18n_descriptions.encodeWithTag(r100, 8, r101.mi18n_descriptions);
            String r106 = r101.mavatar_key;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r106);
        L17:
            Long r107 = r101.mapp_id;
            if (r107 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 10, r107);
        L20:
            Boolean r108 = r101.mchatable;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 11, r108);
        L23:
            String r109 = r101.mextra_config;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 12, r109);
        L26:
            Image r110 = r101.mavatar;
            if (r110 == null) goto L29;
            Image.ADAPTER.encodeWithTag(r100, 13, r110);
        L29:
            String r111 = r101.mapp_store_url;
            if (r111 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r100, 14, r111);
        L32:
            Boolean r112 = r101.mis_isv;
            if (r112 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r100, 15, r112);
        L35:
            Boolean r113 = r101.mis_available;
            if (r113 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r100, 16, r113);
        L38:
            ExtraHitField.ADAPTER.asRepeated().encodeWithTag(r100, 17, r101.mextraHitFields);
            BotMenuDisplayStrategy r114 = r101.mbot_menu_display_strategy;
            if (r114 == null) goto L41;
            BotMenuDisplayStrategy.ADAPTER.encodeWithTag(r100, 18, r114);
        L41:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AppStatusInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AppStatusInfo();
        DEFAULT_APP_ID = 0L;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_CHATABLE = r100;
        DEFAULT_IS_ISV = r100;
        DEFAULT_IS_AVAILABLE = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mcli_id = this.mcli_id;
        r100.mstatus = this.mstatus;
        r100.mtips = this.mtips;
        r100.mbot_list = Internal.copyOf("mbot_list", this.mbot_list);
        r100.mapp_ability = Internal.copyOf("mapp_ability", this.mapp_ability);
        r100.mapp_url = this.mapp_url;
        r100.mi18n_names = Internal.copyOf("mi18n_names", this.mi18n_names);
        r100.mi18n_descriptions = Internal.copyOf("mi18n_descriptions", this.mi18n_descriptions);
        r100.mavatar_key = this.mavatar_key;
        r100.mapp_id = this.mapp_id;
        r100.mchatable = this.mchatable;
        r100.mextra_config = this.mextra_config;
        r100.mavatar = this.mavatar;
        r100.mapp_store_url = this.mapp_store_url;
        r100.mis_isv = this.mis_isv;
        r100.mis_available = this.mis_available;
        r100.mextraHitFields = Internal.copyOf("mextraHitFields", this.mextraHitFields);
        r100.mbot_menu_display_strategy = this.mbot_menu_display_strategy;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AppStatusInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public AppStatusInfo(String r210, AppUsageStatus r211, TipsContent r212, List<BotCheckStatus> r213, List<FeatureAbility> r214, String r215, Map<String, String> r216, Map<String, String> r217, String r218, Long r310, Boolean r311, String r312, Image r313, String r314, Boolean r315, Boolean r316, List<ExtraHitField> r317, BotMenuDisplayStrategy r318) {
        this(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r318, ByteString.EMPTY);
    }

    public AppStatusInfo(String r100, AppUsageStatus r101, TipsContent r102, List<BotCheckStatus> r103, List<FeatureAbility> r104, String r105, Map<String, String> r110, Map<String, String> r111, String r112, Long r113, Boolean r114, String r115, Image r116, String r117, Boolean r118, Boolean r119, List<ExtraHitField> r210, BotMenuDisplayStrategy r211, ByteString r212) {
        super(ADAPTER, r212);
        this.mcli_id = r100;
        this.mstatus = r101;
        this.mtips = r102;
        this.mbot_list = Internal.immutableCopyOf("mbot_list", r103);
        this.mapp_ability = Internal.immutableCopyOf("mapp_ability", r104);
        this.mapp_url = r105;
        this.mi18n_names = Internal.immutableCopyOf("mi18n_names", r110);
        this.mi18n_descriptions = Internal.immutableCopyOf("mi18n_descriptions", r111);
        this.mavatar_key = r112;
        this.mapp_id = r113;
        this.mchatable = r114;
        this.mextra_config = r115;
        this.mavatar = r116;
        this.mapp_store_url = r117;
        this.mis_isv = r118;
        this.mis_available = r119;
        this.mextraHitFields = Internal.immutableCopyOf("mextraHitFields", r210);
        this.mbot_menu_display_strategy = r211;
    }
}
