package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 H2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0006GHIJKLB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010E\u001a\u00020\u0002H\u0016J\b\u0010F\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\"\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000bR\u0013\u0010$\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u000bR\u0013\u0010&\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u000bR\u0013\u0010(\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u000bR\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010/\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u000bR\u0013\u00101\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u000bR\u0013\u00103\u001a\u0004\u0018\u000104¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u00107\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u000bR\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020:0+¢\u0006\b\n\u0000\u001a\u0004\b;\u0010.R\u0013\u0010<\u001a\u0004\u0018\u00010=¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0015\u0010@\u001a\u0004\u0018\u00010A¢\u0006\n\n\u0002\u0010D\u001a\u0004\bB\u0010C¨\u0006M"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/OpenApp;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/OpenApp$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/OpenApp$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "app_id", "getApp_id", "bot_id", "getBot_id", "state", "Lcom/lark/kmp/pb/basic/v1/OpenApp$State;", "getState", "()Lcom/lark/kmp/pb/basic/v1/OpenApp$State;", "tips", "getTips", "last_happen", "getLast_happen", "version", "getVersion", "app_tips", "Lcom/lark/kmp/pb/basic/v1/AppTipsContent;", "getApp_tips", "()Lcom/lark/kmp/pb/basic/v1/AppTipsContent;", "bot_tips", "Lcom/lark/kmp/pb/basic/v1/BotTipsContent;", "getBot_tips", "()Lcom/lark/kmp/pb/basic/v1/BotTipsContent;", "i18n_name", "getI18n_name", "i18n_desc", "getI18n_desc", "avatar_key", "getAvatar_key", "app_id_i64", "getApp_id_i64", "abilities", "", "Lcom/lark/kmp/pb/basic/v1/OpenApp$Ability;", "getAbilities", "()Ljava/util/List;", "app_url", "getApp_url", "avatar_path", "getAvatar_path", "chatable", "Lcom/lark/kmp/pb/basic/v1/OpenApp$Chatable;", "getChatable", "()Lcom/lark/kmp/pb/basic/v1/OpenApp$Chatable;", "extra_config", "getExtra_config", "tags", "Lcom/lark/kmp/pb/basic/v1/Tag;", "getTags", "bot_menu_display_strategy", "Lcom/lark/kmp/pb/basic/v1/OpenApp$BotMenuDisplayStrategy;", "getBot_menu_display_strategy", "()Lcom/lark/kmp/pb/basic/v1/OpenApp$BotMenuDisplayStrategy;", "can_edit", "", "getCan_edit", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "Builder", "Companion", "State", "Ability", "Chatable", "BotMenuDisplayStrategy", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class OpenApp extends com.lark.wire.Message<OpenApp, a> {
    public static final ProtoAdapter<OpenApp> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final List<Ability> abilities;
    private final String app_id;
    private final String app_id_i64;
    private final AppTipsContent app_tips;
    private final String app_url;
    private final String avatar_key;
    private final String avatar_path;
    private final String bot_id;
    private final BotMenuDisplayStrategy bot_menu_display_strategy;
    private final BotTipsContent bot_tips;
    private final Boolean can_edit;
    private final Chatable chatable;
    private final String extra_config;
    private final String i18n_desc;
    private final String i18n_name;
    private final String id;
    private final String last_happen;
    private final State state;
    private final List<Tag> tags;
    private final String tips;
    private final String version;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/OpenApp$Ability;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "MICRO_APP", "H5", "BOT", "LOCAL_COMPONENT", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Ability extends Enum<Ability> implements o0 {
        public static final ProtoAdapter<Ability> ADAPTER = null;
        public static final Ability BOT = null;
        public static final b Companion = null;
        public static final Ability H5 = null;
        public static final Ability LOCAL_COMPONENT = null;
        public static final Ability MICRO_APP = null;
        public static final Ability UNKNOWN = null;
        public static final /* synthetic */ Ability[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Ability> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Ability.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Ability> r1, Syntax r2, Ability r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Ability a(int r1) {
                if (r1 == 0) goto L17;
                if (r1 == 1) goto L22;
                if (r1 == 2) goto L21;
                if (r1 == 3) goto L20;
                if (r1 == 4) goto L19;
                return null;
            L19:
                return Ability.LOCAL_COMPONENT;
            L20:
                return Ability.BOT;
            L21:
                return Ability.H5;
            L22:
                return Ability.MICRO_APP;
            L17:
                return Ability.UNKNOWN;
            }
        }

        @JvmStatic
        public static final Ability fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Ability> getEntries() {
            return b;
        }

        static {
            Ability r0 = new Ability("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Ability r1 = new Ability("MICRO_APP", 1, 1);
            MICRO_APP = r1;
            Ability r3 = new Ability("H5", 2, 2);
            H5 = r3;
            Ability r5 = new Ability("BOT", 3, 3);
            BOT = r5;
            Ability r7 = new Ability("LOCAL_COMPONENT", 4, 4);
            LOCAL_COMPONENT = r7;
            Ability[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Ability.class), Syntax.PROTO_2, r0);
        }

        public static Ability[] values() {
            return (Ability[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static Ability valueOf(String r1) {
            return (Ability) r27.a.a(Ability.class, r1);
        }

        public Ability(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/OpenApp$BotMenuDisplayStrategy;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "MENU_UNKNOWN", "CHAT_MENU", "CHAT_INPUT", "FLOATING", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum BotMenuDisplayStrategy extends Enum<BotMenuDisplayStrategy> implements o0 {
        public static final ProtoAdapter<BotMenuDisplayStrategy> ADAPTER = null;
        public static final BotMenuDisplayStrategy CHAT_INPUT = null;
        public static final BotMenuDisplayStrategy CHAT_MENU = null;
        public static final b Companion = null;
        public static final BotMenuDisplayStrategy FLOATING = null;
        public static final BotMenuDisplayStrategy MENU_UNKNOWN = null;
        public static final /* synthetic */ BotMenuDisplayStrategy[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<BotMenuDisplayStrategy> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                BotMenuDisplayStrategy.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
                return null;
            L17:
                return BotMenuDisplayStrategy.FLOATING;
            L18:
                return BotMenuDisplayStrategy.CHAT_INPUT;
            L19:
                return BotMenuDisplayStrategy.CHAT_MENU;
            L15:
                return BotMenuDisplayStrategy.MENU_UNKNOWN;
            }

            public a(KClass<BotMenuDisplayStrategy> r1, Syntax r2, BotMenuDisplayStrategy r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<BotMenuDisplayStrategy> getEntries() {
            return b;
        }

        static {
            BotMenuDisplayStrategy r0 = new BotMenuDisplayStrategy("MENU_UNKNOWN", 0, 0);
            MENU_UNKNOWN = r0;
            BotMenuDisplayStrategy r1 = new BotMenuDisplayStrategy("CHAT_MENU", 1, 1);
            CHAT_MENU = r1;
            BotMenuDisplayStrategy r3 = new BotMenuDisplayStrategy("CHAT_INPUT", 2, 2);
            CHAT_INPUT = r3;
            BotMenuDisplayStrategy r5 = new BotMenuDisplayStrategy("FLOATING", 3, 3);
            FLOATING = r5;
            BotMenuDisplayStrategy[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(BotMenuDisplayStrategy.class), Syntax.PROTO_2, r0);
        }

        public static BotMenuDisplayStrategy[] values() {
            return (BotMenuDisplayStrategy[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final BotMenuDisplayStrategy fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
            return null;
        L17:
            return FLOATING;
        L18:
            return CHAT_INPUT;
        L19:
            return CHAT_MENU;
        L15:
            return MENU_UNKNOWN;
        }

        public static BotMenuDisplayStrategy valueOf(String r1) {
            return (BotMenuDisplayStrategy) r27.a.a(BotMenuDisplayStrategy.class, r1);
        }

        public BotMenuDisplayStrategy(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/OpenApp$Chatable;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CHATABLE_UNKNOWN", "CHATABLE", "UNCHATABLE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Chatable extends Enum<Chatable> implements o0 {
        public static final ProtoAdapter<Chatable> ADAPTER = null;
        public static final Chatable CHATABLE = null;
        public static final Chatable CHATABLE_UNKNOWN = null;
        public static final b Companion = null;
        public static final Chatable UNCHATABLE = null;
        public static final /* synthetic */ Chatable[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Chatable> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Chatable.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return Chatable.UNCHATABLE;
            L15:
                return Chatable.CHATABLE;
            L12:
                return Chatable.CHATABLE_UNKNOWN;
            }

            public a(KClass<Chatable> r1, Syntax r2, Chatable r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Chatable> getEntries() {
            return b;
        }

        static {
            Chatable r0 = new Chatable("CHATABLE_UNKNOWN", 0, 0);
            CHATABLE_UNKNOWN = r0;
            Chatable r1 = new Chatable("CHATABLE", 1, 1);
            CHATABLE = r1;
            Chatable r3 = new Chatable("UNCHATABLE", 2, 2);
            UNCHATABLE = r3;
            Chatable[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Chatable.class), Syntax.PROTO_2, r0);
        }

        public static Chatable[] values() {
            return (Chatable[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Chatable fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return UNCHATABLE;
        L15:
            return CHATABLE;
        L12:
            return CHATABLE_UNKNOWN;
        }

        public static Chatable valueOf(String r1) {
            return (Chatable) r27.a.a(Chatable.class, r1);
        }

        public Chatable(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00122\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/OpenApp$State;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_STATE", "USABLE", "TENANT_FORBIDDEN", "PLATFORM_FORBIDDEN", "DEVELOPER_FORBIDDEN", "OFFLINE", "USER_INVISIBLE", "APP_NEED_PAY_USE", "APP_DELETED", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum State extends Enum<State> implements o0 {
        public static final ProtoAdapter<State> ADAPTER = null;
        public static final State APP_DELETED = null;
        public static final State APP_NEED_PAY_USE = null;
        public static final b Companion = null;
        public static final State DEVELOPER_FORBIDDEN = null;
        public static final State OFFLINE = null;
        public static final State PLATFORM_FORBIDDEN = null;
        public static final State TENANT_FORBIDDEN = null;
        public static final State UNKNOWN_STATE = null;
        public static final State USABLE = null;
        public static final State USER_INVISIBLE = null;
        public static final /* synthetic */ State[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<State> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                State.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<State> r1, Syntax r2, State r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static State a(int r1) {
                if (r1 == 0) goto L16;
                if (r1 == 100) goto L25;
                switch(r1) {
                    case 2: goto L24;
                    case 3: goto L23;
                    case 4: goto L22;
                    case 5: goto L21;
                    case 6: goto L20;
                    case 7: goto L19;
                    case 8: goto L18;
                    default: goto L6;
                };
            L6:
                return null;
            L18:
                return State.APP_DELETED;
            L19:
                return State.APP_NEED_PAY_USE;
            L20:
                return State.USER_INVISIBLE;
            L21:
                return State.OFFLINE;
            L22:
                return State.DEVELOPER_FORBIDDEN;
            L23:
                return State.PLATFORM_FORBIDDEN;
            L24:
                return State.TENANT_FORBIDDEN;
            L25:
                return State.UNKNOWN_STATE;
            L16:
                return State.USABLE;
            }
        }

        @JvmStatic
        public static final State fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<State> getEntries() {
            return b;
        }

        static {
            State r0 = new State("UNKNOWN_STATE", 0, 100);
            UNKNOWN_STATE = r0;
            State r1 = new State("USABLE", 1, 0);
            USABLE = r1;
            State r3 = new State("TENANT_FORBIDDEN", 2, 2);
            TENANT_FORBIDDEN = r3;
            State r5 = new State("PLATFORM_FORBIDDEN", 3, 3);
            PLATFORM_FORBIDDEN = r5;
            State r7 = new State("DEVELOPER_FORBIDDEN", 4, 4);
            DEVELOPER_FORBIDDEN = r7;
            State r9 = new State("OFFLINE", 5, 5);
            OFFLINE = r9;
            State r11 = new State("USER_INVISIBLE", 6, 6);
            USER_INVISIBLE = r11;
            State r13 = new State("APP_NEED_PAY_USE", 7, 7);
            APP_NEED_PAY_USE = r13;
            State r15 = new State("APP_DELETED", 8, 8);
            APP_DELETED = r15;
            State[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r15};
            a = r14;
            b = EnumEntriesKt.enumEntries(r14);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(State.class), Syntax.PROTO_2, r1);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public State(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<OpenApp, a> {
        public String d;
        public String e;
        public String f;
        public State g;
        public String h;
        public String i;
        public String j;
        public AppTipsContent k;
        public BotTipsContent l;
        public String m;
        public String n;
        public String o;
        public String p;
        public List<? extends Ability> q;
        public String r;
        public String s;
        public Chatable t;
        public String u;
        public List<? extends Tag> v;
        public BotMenuDisplayStrategy w;
        public Boolean x;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new OpenApp(this, c(), null);
        }

        public a() {
            this.q = CollectionsKt.emptyList();
            this.v = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<OpenApp> {
        @Override // com.lark.wire.ProtoAdapter
        public final OpenApp c(g0 r12) {
            Intrinsics.checkNotNullParameter(r12, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            ArrayList r3 = new ArrayList();
            long r4 = r12.c();
        L3:
            int r6 = r12.e();
            if (r6 == (-1)) goto L45;
            switch(r6) {
                case 1: goto L44;
                case 2: goto L43;
                case 3: goto L42;
                case 4: goto L51;
                case 5: goto L37;
                case 6: goto L36;
                case 7: goto L35;
                case 8: goto L34;
                case 9: goto L33;
                case 10: goto L32;
                case 11: goto L31;
                case 12: goto L30;
                case 13: goto L29;
                case 14: goto L47;
                case 15: goto L23;
                case 16: goto L22;
                case 17: goto L53;
                case 18: goto L17;
                case 19: goto L49;
                case 20: goto L55;
                case 21: goto L7;
                default: goto L6;
            };
        L47:
            Ability.ADAPTER.m(r12, r2);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L26
        L28:
            Unit r7 = Unit.INSTANCE;
        L26:
            e = move-exception;
            r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L28
        L49:
            Tag.ADAPTER.m(r12, r3);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L16:
            Unit r8 = Unit.INSTANCE;
        L14:
            e = move-exception;
            r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L16
        L51:
            r1.g = State.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L40
        L40:
            e = move-exception;
            r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r9 = Unit.INSTANCE;
            goto L3
        L53:
            r1.t = Chatable.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r10 = Unit.INSTANCE;
            goto L3
        L55:
            r1.w = BotMenuDisplayStrategy.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r11 = Unit.INSTANCE;
            goto L3
        L7:
            r1.x = (Boolean) ProtoAdapter.g.c(r12);
            goto L3
        L17:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.u = r12.i();
            goto L3
        L22:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.s = r12.i();
            goto L3
        L23:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.r = r12.i();
            goto L3
        L29:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.p = r12.i();
            goto L3
        L30:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.o = r12.i();
            goto L3
        L31:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.n = r12.i();
            goto L3
        L32:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.m = r12.i();
            goto L3
        L33:
            r1.l = BotTipsContent.ADAPTER.c(r12);
            goto L3
        L34:
            r1.k = AppTipsContent.ADAPTER.c(r12);
            goto L3
        L35:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.j = r12.i();
            goto L3
        L36:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.i = r12.i();
            goto L3
        L37:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.h = r12.i();
            goto L3
        L42:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.f = r12.i();
            goto L3
        L43:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.e = r12.i();
            goto L3
        L44:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.d = r12.i();
            goto L3
        L6:
            r12.j(r6);
            Unit r13 = Unit.INSTANCE;
            goto L3
        L45:
            ByteString r14 = r12.d(r4);
            Intrinsics.checkNotNullParameter(r2, "abilities");
            com.lark.wire.internal.a.a(r2);
            r1.q = r2;
            Intrinsics.checkNotNullParameter(r3, "tags");
            com.lark.wire.internal.a.a(r3);
            r1.v = r3;
            return new OpenApp(r1, r14, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(OpenApp r6) {
            OpenApp r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return ((((((((((((((((((((r0 + r1.l(1, r7.getId())) + r1.l(2, r7.getApp_id())) + r1.l(3, r7.getBot_id())) + State.ADAPTER.l(4, r7.getState())) + r1.l(5, r7.getTips())) + r1.l(6, r7.getLast_happen())) + r1.l(7, r7.getVersion())) + AppTipsContent.ADAPTER.l(8, r7.getApp_tips())) + BotTipsContent.ADAPTER.l(9, r7.getBot_tips())) + r1.l(10, r7.getI18n_name())) + r1.l(11, r7.getI18n_desc())) + r1.l(12, r7.getAvatar_key())) + r1.l(13, r7.getApp_id_i64())) + Ability.ADAPTER.a().l(14, r7.getAbilities())) + r1.l(15, r7.getApp_url())) + r1.l(16, r7.getAvatar_path())) + Chatable.ADAPTER.l(17, r7.getChatable())) + r1.l(18, r7.getExtra_config())) + Tag.ADAPTER.a().l(19, r7.getTags())) + BotMenuDisplayStrategy.ADAPTER.l(20, r7.getBot_menu_display_strategy())) + ProtoAdapter.g.l(21, r7.getCan_edit());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, OpenApp r6) {
            OpenApp r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getId());
            r0.i(r5, 2, r7.getApp_id());
            r0.i(r5, 3, r7.getBot_id());
            State.ADAPTER.i(r5, 4, r7.getState());
            r0.i(r5, 5, r7.getTips());
            r0.i(r5, 6, r7.getLast_happen());
            r0.i(r5, 7, r7.getVersion());
            AppTipsContent.ADAPTER.i(r5, 8, r7.getApp_tips());
            BotTipsContent.ADAPTER.i(r5, 9, r7.getBot_tips());
            r0.i(r5, 10, r7.getI18n_name());
            r0.i(r5, 11, r7.getI18n_desc());
            r0.i(r5, 12, r7.getAvatar_key());
            r0.i(r5, 13, r7.getApp_id_i64());
            Ability.ADAPTER.a().i(r5, 14, r7.getAbilities());
            r0.i(r5, 15, r7.getApp_url());
            r0.i(r5, 16, r7.getAvatar_path());
            Chatable.ADAPTER.i(r5, 17, r7.getChatable());
            r0.i(r5, 18, r7.getExtra_config());
            Tag.ADAPTER.a().i(r5, 19, r7.getTags());
            BotMenuDisplayStrategy.ADAPTER.i(r5, 20, r7.getBot_menu_display_strategy());
            ProtoAdapter.g.i(r5, 21, r7.getCan_edit());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, OpenApp r6) {
            OpenApp r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            ProtoAdapter.g.j(r5, 21, r7.getCan_edit());
            BotMenuDisplayStrategy.ADAPTER.j(r5, 20, r7.getBot_menu_display_strategy());
            Tag.ADAPTER.a().j(r5, 19, r7.getTags());
            w r0 = ProtoAdapter.q;
            r0.j(r5, 18, r7.getExtra_config());
            Chatable.ADAPTER.j(r5, 17, r7.getChatable());
            r0.j(r5, 16, r7.getAvatar_path());
            r0.j(r5, 15, r7.getApp_url());
            Ability.ADAPTER.a().j(r5, 14, r7.getAbilities());
            r0.j(r5, 13, r7.getApp_id_i64());
            r0.j(r5, 12, r7.getAvatar_key());
            r0.j(r5, 11, r7.getI18n_desc());
            r0.j(r5, 10, r7.getI18n_name());
            BotTipsContent.ADAPTER.j(r5, 9, r7.getBot_tips());
            AppTipsContent.ADAPTER.j(r5, 8, r7.getApp_tips());
            r0.j(r5, 7, r7.getVersion());
            r0.j(r5, 6, r7.getLast_happen());
            r0.j(r5, 5, r7.getTips());
            State.ADAPTER.j(r5, 4, r7.getState());
            r0.j(r5, 3, r7.getBot_id());
            r0.j(r5, 2, r7.getApp_id());
            r0.j(r5, 1, r7.getId());
        }

        public b(FieldEncoding r7, KClass<OpenApp> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.OpenApp", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ OpenApp(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(OpenApp.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.app_id;
        r0.f = this.bot_id;
        r0.g = this.state;
        r0.h = this.tips;
        r0.i = this.last_happen;
        r0.j = this.version;
        r0.k = this.app_tips;
        r0.l = this.bot_tips;
        r0.m = this.i18n_name;
        r0.n = this.i18n_desc;
        r0.o = this.avatar_key;
        r0.p = this.app_id_i64;
        r0.q = this.abilities;
        r0.r = this.app_url;
        r0.s = this.avatar_path;
        r0.t = this.chatable;
        r0.u = this.extra_config;
        r0.v = this.tags;
        r0.w = this.bot_menu_display_strategy;
        r0.x = this.can_edit;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(OpenApp.class).getSimpleName() + '@' + hashCode();
    }

    public final List<Ability> getAbilities() {
        return this.abilities;
    }

    public final String getApp_id() {
        return this.app_id;
    }

    public final String getApp_id_i64() {
        return this.app_id_i64;
    }

    public final AppTipsContent getApp_tips() {
        return this.app_tips;
    }

    public final String getApp_url() {
        return this.app_url;
    }

    public final String getAvatar_key() {
        return this.avatar_key;
    }

    public final String getAvatar_path() {
        return this.avatar_path;
    }

    public final String getBot_id() {
        return this.bot_id;
    }

    public final BotMenuDisplayStrategy getBot_menu_display_strategy() {
        return this.bot_menu_display_strategy;
    }

    public final BotTipsContent getBot_tips() {
        return this.bot_tips;
    }

    public final Boolean getCan_edit() {
        return this.can_edit;
    }

    public final Chatable getChatable() {
        return this.chatable;
    }

    public final String getExtra_config() {
        return this.extra_config;
    }

    public final String getI18n_desc() {
        return this.i18n_desc;
    }

    public final String getI18n_name() {
        return this.i18n_name;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLast_happen() {
        return this.last_happen;
    }

    public final State getState() {
        return this.state;
    }

    public final List<Tag> getTags() {
        return this.tags;
    }

    public final String getTips() {
        return this.tips;
    }

    public final String getVersion() {
        return this.version;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public OpenApp(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.id = r2.d;
        this.app_id = r2.e;
        this.bot_id = r2.f;
        this.state = r2.g;
        this.tips = r2.h;
        this.last_happen = r2.i;
        this.version = r2.j;
        this.app_tips = r2.k;
        this.bot_tips = r2.l;
        this.i18n_name = r2.m;
        this.i18n_desc = r2.n;
        this.avatar_key = r2.o;
        this.app_id_i64 = r2.p;
        this.abilities = com.lark.wire.internal.a.c("abilities", r2.q);
        this.app_url = r2.r;
        this.avatar_path = r2.s;
        this.chatable = r2.t;
        this.extra_config = r2.u;
        this.tags = com.lark.wire.internal.a.c("tags", r2.v);
        this.bot_menu_display_strategy = r2.w;
        this.can_edit = r2.x;
    }

    public /* synthetic */ OpenApp(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
