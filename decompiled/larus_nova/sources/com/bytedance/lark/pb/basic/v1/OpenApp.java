package com.bytedance.lark.pb.basic.v1;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.squareup.wire.FieldEncoding;
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
public final class OpenApp extends com.squareup.wire.Message<OpenApp, Builder> {
    public static final ProtoAdapter<OpenApp> ADAPTER = null;
    public static final String DEFAULT_APP_ID = "";
    public static final String DEFAULT_APP_ID_I64 = "";
    public static final String DEFAULT_APP_URL = "";
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_AVATAR_PATH = "";
    public static final String DEFAULT_BOT_ID = "";
    public static final BotMenuDisplayStrategy DEFAULT_BOT_MENU_DISPLAY_STRATEGY = null;
    public static final Boolean DEFAULT_CAN_EDIT = null;
    public static final Chatable DEFAULT_CHATABLE = null;
    public static final String DEFAULT_EXTRA_CONFIG = "";
    public static final String DEFAULT_I18N_DESC = "";
    public static final String DEFAULT_I18N_NAME = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_LAST_HAPPEN = "";
    public static final State DEFAULT_STATE = null;
    public static final String DEFAULT_TIPS = "";
    public static final String DEFAULT_VERSION = "";
    private static final long serialVersionUID = 0;
    public final List<Ability> abilities;
    public final String app_id;
    public final String app_id_i64;
    public final AppTipsContent app_tips;
    public final String app_url;
    public final String avatar_key;
    public final String avatar_path;
    public final String bot_id;
    public final BotMenuDisplayStrategy bot_menu_display_strategy;
    public final BotTipsContent bot_tips;
    public final Boolean can_edit;
    public final Chatable chatable;
    public final String extra_config;
    public final String i18n_desc;
    public final String i18n_name;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253527id;
    public final String last_happen;
    public final State state;
    public final List<Tag> tags;
    public final String tips;
    public final String version;

    public static final enum Ability extends Enum<Ability> implements WireEnum {
        private static final /* synthetic */ Ability[] $VALUES = null;
        public static final ProtoAdapter<Ability> ADAPTER = null;
        public static final Ability BOT = null;
        public static final Ability H5 = null;
        public static final Ability LOCAL_COMPONENT = null;
        public static final Ability MICRO_APP = null;
        public static final Ability UNKNOWN = null;
        private final int value;

        static {
            Ability r100 = new Ability("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Ability r101 = new Ability("MICRO_APP", 1, 1);
            MICRO_APP = r101;
            Ability r102 = new Ability("H5", 2, 2);
            H5 = r102;
            Ability r103 = new Ability("BOT", 3, 3);
            BOT = r103;
            Ability r104 = new Ability("LOCAL_COMPONENT", 4, 4);
            LOCAL_COMPONENT = r104;
            $VALUES = new Ability[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(Ability.class);
        }

        public static Ability[] values() {
            return (Ability[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Ability fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return LOCAL_COMPONENT;
        L16:
            return BOT;
        L18:
            return H5;
        L20:
            return MICRO_APP;
        L22:
            return UNKNOWN;
        }

        public static Ability valueOf(String r100) {
            return (Ability) a.a(Ability.class, r100);
        }

        private Ability(String r100, int r101, int r102) {
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
        public static final BotMenuDisplayStrategy MENU_UNKNOWN = null;
        private final int value;

        static {
            BotMenuDisplayStrategy r100 = new BotMenuDisplayStrategy("MENU_UNKNOWN", 0, 0);
            MENU_UNKNOWN = r100;
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
            return MENU_UNKNOWN;
        }

        public static BotMenuDisplayStrategy valueOf(String r100) {
            return (BotMenuDisplayStrategy) a.a(BotMenuDisplayStrategy.class, r100);
        }

        private BotMenuDisplayStrategy(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<OpenApp, Builder> {
        public List<Ability> abilities;
        public String app_id;
        public String app_id_i64;
        public AppTipsContent app_tips;
        public String app_url;
        public String avatar_key;
        public String avatar_path;
        public String bot_id;
        public BotMenuDisplayStrategy bot_menu_display_strategy;
        public BotTipsContent bot_tips;
        public Boolean can_edit;
        public Chatable chatable;
        public String extra_config;
        public String i18n_desc;
        public String i18n_name;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253528id;
        public String last_happen;
        public State state;
        public List<Tag> tags;
        public String tips;
        public String version;

        @Override // com.squareup.wire.Message.Builder
        public OpenApp build() {
            return new OpenApp(this.f253528id, this.app_id, this.bot_id, this.state, this.tips, this.last_happen, this.version, this.app_tips, this.bot_tips, this.i18n_name, this.i18n_desc, this.avatar_key, this.app_id_i64, this.abilities, this.app_url, this.avatar_path, this.chatable, this.extra_config, this.tags, this.bot_menu_display_strategy, this.can_edit, super.buildUnknownFields());
        }

        public Builder() {
            this.abilities = Internal.newMutableList();
            this.tags = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder abilities(List<Ability> r100) {
            Internal.checkElementsNotNull(r100);
            this.abilities = r100;
            return this;
        }

        public Builder app_id(String r100) {
            this.app_id = r100;
            return this;
        }

        public Builder app_id_i64(String r100) {
            this.app_id_i64 = r100;
            return this;
        }

        public Builder app_tips(AppTipsContent r100) {
            this.app_tips = r100;
            return this;
        }

        public Builder app_url(String r100) {
            this.app_url = r100;
            return this;
        }

        public Builder avatar_key(String r100) {
            this.avatar_key = r100;
            return this;
        }

        public Builder avatar_path(String r100) {
            this.avatar_path = r100;
            return this;
        }

        public Builder bot_id(String r100) {
            this.bot_id = r100;
            return this;
        }

        public Builder bot_menu_display_strategy(BotMenuDisplayStrategy r100) {
            this.bot_menu_display_strategy = r100;
            return this;
        }

        public Builder bot_tips(BotTipsContent r100) {
            this.bot_tips = r100;
            return this;
        }

        public Builder can_edit(Boolean r100) {
            this.can_edit = r100;
            return this;
        }

        public Builder chatable(Chatable r100) {
            this.chatable = r100;
            return this;
        }

        public Builder extra_config(String r100) {
            this.extra_config = r100;
            return this;
        }

        public Builder i18n_desc(String r100) {
            this.i18n_desc = r100;
            return this;
        }

        public Builder i18n_name(String r100) {
            this.i18n_name = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253528id = r100;
            return this;
        }

        public Builder last_happen(String r100) {
            this.last_happen = r100;
            return this;
        }

        public Builder state(State r100) {
            this.state = r100;
            return this;
        }

        public Builder tags(List<Tag> r100) {
            Internal.checkElementsNotNull(r100);
            this.tags = r100;
            return this;
        }

        public Builder tips(String r100) {
            this.tips = r100;
            return this;
        }

        public Builder version(String r100) {
            this.version = r100;
            return this;
        }
    }

    public static final enum Chatable extends Enum<Chatable> implements WireEnum {
        private static final /* synthetic */ Chatable[] $VALUES = null;
        public static final ProtoAdapter<Chatable> ADAPTER = null;
        public static final Chatable CHATABLE = null;
        public static final Chatable CHATABLE_UNKNOWN = null;
        public static final Chatable UNCHATABLE = null;
        private final int value;

        static {
            Chatable r100 = new Chatable("CHATABLE_UNKNOWN", 0, 0);
            CHATABLE_UNKNOWN = r100;
            Chatable r101 = new Chatable("CHATABLE", 1, 1);
            CHATABLE = r101;
            Chatable r102 = new Chatable("UNCHATABLE", 2, 2);
            UNCHATABLE = r102;
            $VALUES = new Chatable[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Chatable.class);
        }

        public static Chatable[] values() {
            return (Chatable[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Chatable fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return UNCHATABLE;
        L12:
            return CHATABLE;
        L14:
            return CHATABLE_UNKNOWN;
        }

        public static Chatable valueOf(String r100) {
            return (Chatable) a.a(Chatable.class, r100);
        }

        private Chatable(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_OpenApp extends ProtoAdapter<OpenApp> {
        public ProtoAdapter_OpenApp() {
            super(FieldEncoding.LENGTH_DELIMITED, OpenApp.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OpenApp decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253528id = "";
            r101.app_id = "";
            r101.bot_id = "";
            r101.state = State.UNKNOWN_STATE;
            r101.tips = "";
            r101.last_happen = "";
            r101.version = "";
            r101.i18n_name = "";
            r101.i18n_desc = "";
            r101.avatar_key = "";
            r101.app_id_i64 = "";
            r101.app_url = "";
            r101.avatar_path = "";
            r101.chatable = Chatable.CHATABLE_UNKNOWN;
            r101.extra_config = "";
            r101.bot_menu_display_strategy = BotMenuDisplayStrategy.MENU_UNKNOWN;
            r101.can_edit = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L43;
            switch(r103) {
                case 1: goto L42;
                case 2: goto L41;
                case 3: goto L40;
                case 4: goto L45;
                case 5: goto L35;
                case 6: goto L34;
                case 7: goto L33;
                case 8: goto L32;
                case 9: goto L31;
                case 10: goto L30;
                case 11: goto L29;
                case 12: goto L28;
                case 13: goto L27;
                case 14: goto L53;
                case 15: goto L22;
                case 16: goto L21;
                case 17: goto L49;
                case 18: goto L16;
                case 19: goto L47;
                case 20: goto L51;
                case 21: goto L7;
                default: goto L6;
            };
        L45:
            r101.state = State.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L38
        L38:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L47:
            r101.tags.add(Tag.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L49:
            r101.chatable = Chatable.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L51:
            r101.bot_menu_display_strategy = BotMenuDisplayStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L53:
            r101.abilities.add(Ability.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.can_edit = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L16:
            r101.extra_config = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.avatar_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.app_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L27:
            r101.app_id_i64 = ProtoAdapter.STRING.decode(r100);
            goto L3
        L28:
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L29:
            r101.i18n_desc = ProtoAdapter.STRING.decode(r100);
            goto L3
        L30:
            r101.i18n_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L31:
            r101.bot_tips = BotTipsContent.ADAPTER.decode(r100);
            goto L3
        L32:
            r101.app_tips = AppTipsContent.ADAPTER.decode(r100);
            goto L3
        L33:
            r101.version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L34:
            r101.last_happen = ProtoAdapter.STRING.decode(r100);
            goto L3
        L35:
            r101.tips = ProtoAdapter.STRING.decode(r100);
            goto L3
        L40:
            r101.bot_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L41:
            r101.app_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L42:
            r101.f253528id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L43:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(OpenApp r100) {
            String r101 = r100.f253527id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.app_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.bot_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            State r110 = r100.state;
            if (r110 == null) goto L17;
            int r111 = State.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.tips;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.last_happen;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.version;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            AppTipsContent r122 = r100.app_tips;
            if (r122 == null) goto L33;
            int r123 = AppTipsContent.ADAPTER.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            BotTipsContent r125 = r100.bot_tips;
            if (r125 == null) goto L37;
            int r126 = BotTipsContent.ADAPTER.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            String r128 = r100.i18n_name;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.STRING.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            String r131 = r100.i18n_desc;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.STRING.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            String r134 = r100.avatar_key;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.STRING.encodedSizeWithTag(12, r134);
        L50:
            int r136 = r133 + r135;
            String r137 = r100.app_id_i64;
            if (r137 == null) goto L53;
            int r138 = ProtoAdapter.STRING.encodedSizeWithTag(13, r137);
        L54:
            int r139 = (r136 + r138) + Ability.ADAPTER.asRepeated().encodedSizeWithTag(14, r100.abilities);
            String r140 = r100.app_url;
            if (r140 == null) goto L57;
            int r141 = ProtoAdapter.STRING.encodedSizeWithTag(15, r140);
        L58:
            int r142 = r139 + r141;
            String r143 = r100.avatar_path;
            if (r143 == null) goto L61;
            int r144 = ProtoAdapter.STRING.encodedSizeWithTag(16, r143);
        L62:
            int r145 = r142 + r144;
            Chatable r146 = r100.chatable;
            if (r146 == null) goto L65;
            int r147 = Chatable.ADAPTER.encodedSizeWithTag(17, r146);
        L66:
            int r148 = r145 + r147;
            String r149 = r100.extra_config;
            if (r149 == null) goto L69;
            int r150 = ProtoAdapter.STRING.encodedSizeWithTag(18, r149);
        L70:
            int r151 = (r148 + r150) + Tag.ADAPTER.asRepeated().encodedSizeWithTag(19, r100.tags);
            BotMenuDisplayStrategy r152 = r100.bot_menu_display_strategy;
            if (r152 == null) goto L73;
            int r153 = BotMenuDisplayStrategy.ADAPTER.encodedSizeWithTag(20, r152);
        L74:
            int r154 = r151 + r153;
            Boolean r155 = r100.can_edit;
            if (r155 == null) goto L78;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(21, r155);
        L78:
            return (r154 + r102) + r100.unknownFields().size();
        L73:
            r153 = 0;
            goto L74
        L69:
            r150 = 0;
            goto L70
        L65:
            r147 = 0;
            goto L66
        L61:
            r144 = 0;
            goto L62
        L57:
            r141 = 0;
            goto L58
        L53:
            r138 = 0;
            goto L54
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
        public /* bridge */ /* synthetic */ OpenApp decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OpenApp r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OpenApp r101) throws IOException {
            String r102 = r101.f253527id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.app_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.bot_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            State r105 = r101.state;
            if (r105 == null) goto L14;
            State.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.tips;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.last_happen;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.version;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            AppTipsContent r109 = r101.app_tips;
            if (r109 == null) goto L26;
            AppTipsContent.ADAPTER.encodeWithTag(r100, 8, r109);
        L26:
            BotTipsContent r110 = r101.bot_tips;
            if (r110 == null) goto L29;
            BotTipsContent.ADAPTER.encodeWithTag(r100, 9, r110);
        L29:
            String r111 = r101.i18n_name;
            if (r111 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r100, 10, r111);
        L32:
            String r112 = r101.i18n_desc;
            if (r112 == null) goto L35;
            ProtoAdapter.STRING.encodeWithTag(r100, 11, r112);
        L35:
            String r113 = r101.avatar_key;
            if (r113 == null) goto L38;
            ProtoAdapter.STRING.encodeWithTag(r100, 12, r113);
        L38:
            String r114 = r101.app_id_i64;
            if (r114 == null) goto L41;
            ProtoAdapter.STRING.encodeWithTag(r100, 13, r114);
        L41:
            Ability.ADAPTER.asRepeated().encodeWithTag(r100, 14, r101.abilities);
            String r115 = r101.app_url;
            if (r115 == null) goto L44;
            ProtoAdapter.STRING.encodeWithTag(r100, 15, r115);
        L44:
            String r116 = r101.avatar_path;
            if (r116 == null) goto L47;
            ProtoAdapter.STRING.encodeWithTag(r100, 16, r116);
        L47:
            Chatable r117 = r101.chatable;
            if (r117 == null) goto L50;
            Chatable.ADAPTER.encodeWithTag(r100, 17, r117);
        L50:
            String r118 = r101.extra_config;
            if (r118 == null) goto L53;
            ProtoAdapter.STRING.encodeWithTag(r100, 18, r118);
        L53:
            Tag.ADAPTER.asRepeated().encodeWithTag(r100, 19, r101.tags);
            BotMenuDisplayStrategy r119 = r101.bot_menu_display_strategy;
            if (r119 == null) goto L56;
            BotMenuDisplayStrategy.ADAPTER.encodeWithTag(r100, 20, r119);
        L56:
            Boolean r120 = r101.can_edit;
            if (r120 == null) goto L59;
            ProtoAdapter.BOOL.encodeWithTag(r100, 21, r120);
        L59:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OpenApp r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum State extends Enum<State> implements WireEnum {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final ProtoAdapter<State> ADAPTER = null;
        public static final State APP_DELETED = null;
        public static final State APP_NEED_PAY_USE = null;
        public static final State DEVELOPER_FORBIDDEN = null;
        public static final State OFFLINE = null;
        public static final State PLATFORM_FORBIDDEN = null;
        public static final State TENANT_FORBIDDEN = null;
        public static final State UNKNOWN_STATE = null;
        public static final State USABLE = null;
        public static final State USER_INVISIBLE = null;
        private final int value;

        static {
            State r100 = new State("UNKNOWN_STATE", 0, 100);
            UNKNOWN_STATE = r100;
            State r101 = new State("USABLE", 1, 0);
            USABLE = r101;
            State r102 = new State("TENANT_FORBIDDEN", 2, 2);
            TENANT_FORBIDDEN = r102;
            State r103 = new State("PLATFORM_FORBIDDEN", 3, 3);
            PLATFORM_FORBIDDEN = r103;
            State r104 = new State("DEVELOPER_FORBIDDEN", 4, 4);
            DEVELOPER_FORBIDDEN = r104;
            State r105 = new State("OFFLINE", 5, 5);
            OFFLINE = r105;
            State r110 = new State("USER_INVISIBLE", 6, 6);
            USER_INVISIBLE = r110;
            State r111 = new State("APP_NEED_PAY_USE", 7, 7);
            APP_NEED_PAY_USE = r111;
            State r112 = new State("APP_DELETED", 8, 8);
            APP_DELETED = r112;
            $VALUES = new State[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
            ADAPTER = ProtoAdapter.newEnumAdapter(State.class);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static State fromValue(int r100) {
            if (r100 == 0) goto L25;
            if (r100 == 100) goto L23;
            switch(r100) {
                case 2: goto L21;
                case 3: goto L19;
                case 4: goto L17;
                case 5: goto L15;
                case 6: goto L13;
                case 7: goto L11;
                case 8: goto L9;
                default: goto L6;
            };
        L6:
            return null;
        L9:
            return APP_DELETED;
        L11:
            return APP_NEED_PAY_USE;
        L13:
            return USER_INVISIBLE;
        L15:
            return OFFLINE;
        L17:
            return DEVELOPER_FORBIDDEN;
        L19:
            return PLATFORM_FORBIDDEN;
        L21:
            return TENANT_FORBIDDEN;
        L23:
            return UNKNOWN_STATE;
        L25:
            return USABLE;
        }

        public static State valueOf(String r100) {
            return (State) a.a(State.class, r100);
        }

        private State(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OpenApp();
        DEFAULT_STATE = State.UNKNOWN_STATE;
        DEFAULT_CHATABLE = Chatable.CHATABLE_UNKNOWN;
        DEFAULT_BOT_MENU_DISPLAY_STRATEGY = BotMenuDisplayStrategy.MENU_UNKNOWN;
        DEFAULT_CAN_EDIT = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253528id = this.f253527id;
        r100.app_id = this.app_id;
        r100.bot_id = this.bot_id;
        r100.state = this.state;
        r100.tips = this.tips;
        r100.last_happen = this.last_happen;
        r100.version = this.version;
        r100.app_tips = this.app_tips;
        r100.bot_tips = this.bot_tips;
        r100.i18n_name = this.i18n_name;
        r100.i18n_desc = this.i18n_desc;
        r100.avatar_key = this.avatar_key;
        r100.app_id_i64 = this.app_id_i64;
        r100.abilities = Internal.copyOf("abilities", this.abilities);
        r100.app_url = this.app_url;
        r100.avatar_path = this.avatar_path;
        r100.chatable = this.chatable;
        r100.extra_config = this.extra_config;
        r100.tags = Internal.copyOf(PromotionProductPrivilegesStruct.TAGS, this.tags);
        r100.bot_menu_display_strategy = this.bot_menu_display_strategy;
        r100.can_edit = this.can_edit;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OpenApp.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public OpenApp(String r210, String r211, String r212, State r213, String r214, String r215, String r310, AppTipsContent r311, BotTipsContent r312, String r313, String r314, String r315, String r316, List<Ability> r317, String r318, String r319, Chatable r410, String r411, List<Tag> r412, BotMenuDisplayStrategy r413, Boolean r414) {
        this(r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, ByteString.EMPTY);
    }

    public OpenApp(String r100, String r101, String r102, State r103, String r104, String r105, String r110, AppTipsContent r111, BotTipsContent r112, String r113, String r114, String r115, String r116, List<Ability> r117, String r118, String r119, Chatable r210, String r211, List<Tag> r212, BotMenuDisplayStrategy r213, Boolean r214, ByteString r215) {
        super(ADAPTER, r215);
        this.f253527id = r100;
        this.app_id = r101;
        this.bot_id = r102;
        this.state = r103;
        this.tips = r104;
        this.last_happen = r105;
        this.version = r110;
        this.app_tips = r111;
        this.bot_tips = r112;
        this.i18n_name = r113;
        this.i18n_desc = r114;
        this.avatar_key = r115;
        this.app_id_i64 = r116;
        this.abilities = Internal.immutableCopyOf("abilities", r117);
        this.app_url = r118;
        this.avatar_path = r119;
        this.chatable = r210;
        this.extra_config = r211;
        this.tags = Internal.immutableCopyOf(PromotionProductPrivilegesStruct.TAGS, r212);
        this.bot_menu_display_strategy = r213;
        this.can_edit = r214;
    }
}
