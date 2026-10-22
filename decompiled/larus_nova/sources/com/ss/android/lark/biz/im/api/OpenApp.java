package com.ss.android.lark.biz.im.api;

import java.io.Serializable;

/* JADX INFO: loaded from: classes34.dex */
public class OpenApp implements Serializable {
    private String appId;
    private String avatarKey;
    private String botId;
    private BotMenuDisplayStrategy botMenuDisplayStrategy;
    private BotTipsContent botTips;
    private Boolean canEdit;
    private Chatable chatable;
    private String desc;
    private ExtraConfig extraConfig;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f409884id;
    private String lastHappen;
    private String name;
    private State state;
    private String tips;
    private String version;

    public static final enum BotMenuDisplayStrategy extends Enum<BotMenuDisplayStrategy> {
        public static final BotMenuDisplayStrategy CHAT_INPUT = null;
        public static final BotMenuDisplayStrategy CHAT_MENU = null;
        public static final BotMenuDisplayStrategy FLOATING = null;
        public static final BotMenuDisplayStrategy MENU_UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BotMenuDisplayStrategy[] f409885a = null;
        private int value;

        static {
            BotMenuDisplayStrategy r100 = new BotMenuDisplayStrategy("MENU_UNKNOWN", 0, 0);
            MENU_UNKNOWN = r100;
            BotMenuDisplayStrategy r101 = new BotMenuDisplayStrategy("CHAT_MENU", 1, 1);
            CHAT_MENU = r101;
            BotMenuDisplayStrategy r102 = new BotMenuDisplayStrategy("CHAT_INPUT", 2, 2);
            CHAT_INPUT = r102;
            BotMenuDisplayStrategy r103 = new BotMenuDisplayStrategy("FLOATING", 3, 3);
            FLOATING = r103;
            f409885a = new BotMenuDisplayStrategy[]{r100, r101, r102, r103};
        }

        public static BotMenuDisplayStrategy[] values() {
            return (BotMenuDisplayStrategy[]) f409885a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static BotMenuDisplayStrategy fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return MENU_UNKNOWN;
        L11:
            return FLOATING;
        L13:
            return CHAT_INPUT;
        L15:
            return CHAT_MENU;
        }

        public static BotMenuDisplayStrategy valueOf(String r100) {
            return (BotMenuDisplayStrategy) r27.a.a(BotMenuDisplayStrategy.class, r100);
        }

        public BotMenuDisplayStrategy(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Chatable extends Enum<Chatable> {
        public static final Chatable CHATABLE = null;
        public static final Chatable CHATABLE_UNKNOWN = null;
        public static final Chatable UNCHATABLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Chatable[] f409886a = null;
        private int value;

        static {
            Chatable r100 = new Chatable("CHATABLE_UNKNOWN", 0, 0);
            CHATABLE_UNKNOWN = r100;
            Chatable r101 = new Chatable("CHATABLE", 1, 1);
            CHATABLE = r101;
            Chatable r102 = new Chatable("UNCHATABLE", 2, 2);
            UNCHATABLE = r102;
            f409886a = new Chatable[]{r100, r101, r102};
        }

        public static Chatable[] values() {
            return (Chatable[]) f409886a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static Chatable fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return UNCHATABLE;
        L10:
            return UNCHATABLE;
        L12:
            return CHATABLE;
        L14:
            return CHATABLE_UNKNOWN;
        }

        public static Chatable valueOf(String r100) {
            return (Chatable) r27.a.a(Chatable.class, r100);
        }

        public Chatable(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum State extends Enum<State> {
        public static final State DELETED = null;
        public static final State DEVELOPER_FORBIDDEN = null;
        public static final State OFFLINE = null;
        public static final State PLATFORM_FORBIDDEN = null;
        public static final State TENANT_FORBIDDEN = null;
        public static final State UNKNOW = null;
        public static final State USABLE = null;
        public static final State USER_INVISIBLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f409887a = null;
        private int value;

        static {
            State r100 = new State("UNKNOW", 0, 100);
            UNKNOW = r100;
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
            State r111 = new State("DELETED", 7, 8);
            DELETED = r111;
            f409887a = new State[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static State[] values() {
            return (State[]) f409887a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static State fromValue(int r100) {
            if (r100 == 0) goto L34;
            if (r100 == 8) goto L32;
            if (r100 == 100) goto L30;
            if (r100 == 2) goto L28;
            if (r100 == 3) goto L26;
            if (r100 == 4) goto L24;
            if (r100 == 5) goto L22;
            if (r100 == 6) goto L20;
            return USABLE;
        L20:
            return USER_INVISIBLE;
        L22:
            return OFFLINE;
        L24:
            return DEVELOPER_FORBIDDEN;
        L26:
            return PLATFORM_FORBIDDEN;
        L28:
            return TENANT_FORBIDDEN;
        L30:
            return UNKNOW;
        L32:
            return DELETED;
        L34:
            return USABLE;
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public OpenApp() {
    }

    public boolean canApplyVisibility() {
        ExtraConfig r100 = this.extraConfig;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.isCanApplyVisibility() == true) goto L8;
        return false;
    }

    public boolean isValid() {
        if (this.f409884id == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAvatarKey() {
        return this.avatarKey;
    }

    public String getBotId() {
        return this.botId;
    }

    public BotMenuDisplayStrategy getBotMenuDisplayStrategy() {
        return this.botMenuDisplayStrategy;
    }

    public BotTipsContent getBotTips() {
        return this.botTips;
    }

    public Boolean getCanEdit() {
        return this.canEdit;
    }

    public Chatable getChatable() {
        return this.chatable;
    }

    public String getDesc() {
        return this.desc;
    }

    public ExtraConfig getExtraConfig() {
        return this.extraConfig;
    }

    public String getId() {
        return this.f409884id;
    }

    public String getLastHappen() {
        return this.lastHappen;
    }

    public String getName() {
        return this.name;
    }

    public State getState() {
        return this.state;
    }

    public String getTips() {
        return this.tips;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAppId(String r100) {
        this.appId = r100;
    }

    public void setAvatarKey(String r100) {
        this.avatarKey = r100;
    }

    public void setBotId(String r100) {
        this.botId = r100;
    }

    public void setBotMenuDisplayStrategy(BotMenuDisplayStrategy r100) {
        this.botMenuDisplayStrategy = r100;
    }

    public void setBotTips(BotTipsContent r100) {
        this.botTips = r100;
    }

    public void setCanEdit(Boolean r100) {
        this.canEdit = r100;
    }

    public void setChatable(Chatable r100) {
        this.chatable = r100;
    }

    public void setDesc(String r100) {
        this.desc = r100;
    }

    public void setExtraConfig(ExtraConfig r100) {
        this.extraConfig = r100;
    }

    public void setId(String r100) {
        this.f409884id = r100;
    }

    public void setLastHappen(String r100) {
        this.lastHappen = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setState(State r100) {
        this.state = r100;
    }

    public void setTips(String r100) {
        this.tips = r100;
    }

    public void setVersion(String r100) {
        this.version = r100;
    }
}
