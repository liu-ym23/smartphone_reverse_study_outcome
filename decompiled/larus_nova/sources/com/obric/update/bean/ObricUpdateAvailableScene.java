package com.obric.update.bean;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b'\b\u0086\u0081\u0002\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002()B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'¨\u0006*"}, d2 = {"Lcom/obric/update/bean/ObricUpdateAvailableScene;", "", "bitmask", "", "<init>", "(Ljava/lang/String;II)V", "getBitmask", "()I", UserProfileEvent.POSITION_NONE, "ASSISTANT", "AI_AGENT", "AI_KERNEL", "MEMORY_DATA", "OAUTO", "ASSISTANT_AI_AGENT", "ASSISTANT_AI_KERNEL", "ASSISTANT_MEMORY_DATA", "ASSISTANT_OAUTO", "AI_AGENT_AI_KERNEL", "AI_AGENT_MEMORY_DATA", "AI_AGENT_OAUTO", "AI_KERNEL_MEMORY_DATA", "AI_KERNEL_OAUTO", "MEMORY_DATA_OAUTO", "ASSISTANT_AI_AGENT_AI_KERNEL", "ASSISTANT_AI_AGENT_MEMORY_DATA", "ASSISTANT_AI_AGENT_OAUTO", "ASSISTANT_AI_KERNEL_MEMORY_DATA", "ASSISTANT_AI_KERNEL_OAUTO", "ASSISTANT_MEMORY_DATA_OAUTO", "AI_AGENT_AI_KERNEL_MEMORY_DATA", "AI_AGENT_AI_KERNEL_OAUTO", "AI_AGENT_MEMORY_DATA_OAUTO", "AI_KERNEL_MEMORY_DATA_OAUTO", "ASSISTANT_AI_AGENT_AI_KERNEL_MEMORY_DATA", "ASSISTANT_AI_AGENT_AI_KERNEL_OAUTO", "ASSISTANT_AI_AGENT_MEMORY_DATA_OAUTO", "ASSISTANT_AI_KERNEL_MEMORY_DATA_OAUTO", "AI_AGENT_AI_KERNEL_MEMORY_DATA_OAUTO", AccountType.ALL, "Companion", "AppType", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricUpdateAvailableScene extends Enum<ObricUpdateAvailableScene> {
    public static final ObricUpdateAvailableScene AI_AGENT = null;
    public static final ObricUpdateAvailableScene AI_AGENT_AI_KERNEL = null;
    public static final ObricUpdateAvailableScene AI_AGENT_AI_KERNEL_MEMORY_DATA = null;
    public static final ObricUpdateAvailableScene AI_AGENT_AI_KERNEL_MEMORY_DATA_OAUTO = null;
    public static final ObricUpdateAvailableScene AI_AGENT_AI_KERNEL_OAUTO = null;
    public static final ObricUpdateAvailableScene AI_AGENT_MEMORY_DATA = null;
    public static final ObricUpdateAvailableScene AI_AGENT_MEMORY_DATA_OAUTO = null;
    public static final ObricUpdateAvailableScene AI_AGENT_OAUTO = null;
    public static final ObricUpdateAvailableScene AI_KERNEL = null;
    public static final ObricUpdateAvailableScene AI_KERNEL_MEMORY_DATA = null;
    public static final ObricUpdateAvailableScene AI_KERNEL_MEMORY_DATA_OAUTO = null;
    public static final ObricUpdateAvailableScene AI_KERNEL_OAUTO = null;
    public static final ObricUpdateAvailableScene ALL = null;
    public static final ObricUpdateAvailableScene ASSISTANT = null;
    public static final ObricUpdateAvailableScene ASSISTANT_AI_AGENT = null;
    public static final ObricUpdateAvailableScene ASSISTANT_AI_AGENT_AI_KERNEL = null;
    public static final ObricUpdateAvailableScene ASSISTANT_AI_AGENT_AI_KERNEL_MEMORY_DATA = null;
    public static final ObricUpdateAvailableScene ASSISTANT_AI_AGENT_AI_KERNEL_OAUTO = null;
    public static final ObricUpdateAvailableScene ASSISTANT_AI_AGENT_MEMORY_DATA = null;
    public static final ObricUpdateAvailableScene ASSISTANT_AI_AGENT_MEMORY_DATA_OAUTO = null;
    public static final ObricUpdateAvailableScene ASSISTANT_AI_AGENT_OAUTO = null;
    public static final ObricUpdateAvailableScene ASSISTANT_AI_KERNEL = null;
    public static final ObricUpdateAvailableScene ASSISTANT_AI_KERNEL_MEMORY_DATA = null;
    public static final ObricUpdateAvailableScene ASSISTANT_AI_KERNEL_MEMORY_DATA_OAUTO = null;
    public static final ObricUpdateAvailableScene ASSISTANT_AI_KERNEL_OAUTO = null;
    public static final ObricUpdateAvailableScene ASSISTANT_MEMORY_DATA = null;
    public static final ObricUpdateAvailableScene ASSISTANT_MEMORY_DATA_OAUTO = null;
    public static final ObricUpdateAvailableScene ASSISTANT_OAUTO = null;
    public static final a Companion = null;
    public static final ObricUpdateAvailableScene MEMORY_DATA = null;
    public static final ObricUpdateAvailableScene MEMORY_DATA_OAUTO = null;
    public static final ObricUpdateAvailableScene NONE = null;
    public static final ObricUpdateAvailableScene OAUTO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricUpdateAvailableScene[] f404040a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f404041b = null;
    private final int bitmask;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/update/bean/ObricUpdateAvailableScene$AppType;", "", "bitmask", "", "packageName", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getBitmask", "()I", "getPackageName", "()Ljava/lang/String;", "ASSISTANT", "AI_AGENT", "AI_KERNEL", "MEMORY_DATA", "OAUTO", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AppType extends Enum<AppType> {
        public static final AppType AI_AGENT = null;
        public static final AppType AI_KERNEL = null;
        public static final AppType ASSISTANT = null;
        public static final AppType MEMORY_DATA = null;
        public static final AppType OAUTO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AppType[] f404042a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f404043b = null;
        private final int bitmask;
        private final String packageName;

        public static EnumEntries<AppType> getEntries() {
            return f404043b;
        }

        static {
            AppType r100 = new AppType("ASSISTANT", 0, 1, "com.larus.nova");
            ASSISTANT = r100;
            AppType r101 = new AppType("AI_AGENT", 1, 2, "com.obric.assistantaiagent");
            AI_AGENT = r101;
            AppType r102 = new AppType("AI_KERNEL", 2, 4, "com.obric.aikernel");
            AI_KERNEL = r102;
            AppType r103 = new AppType("MEMORY_DATA", 3, 8, "com.obric.memorydata");
            MEMORY_DATA = r103;
            AppType r104 = new AppType("OAUTO", 4, 16, "com.obric.autoaction");
            OAUTO = r104;
            AppType[] r105 = {r100, r101, r102, r103, r104};
            f404042a = r105;
            f404043b = EnumEntriesKt.enumEntries(r105);
        }

        public static AppType[] values() {
            return (AppType[]) f404042a.clone();
        }

        public final int getBitmask() {
            return this.bitmask;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public static AppType valueOf(String r100) {
            return (AppType) r27.a.a(AppType.class, r100);
        }

        public AppType(String r100, int r101, int r102, String r103) {
            super(r100, r101);
            this.bitmask = r102;
            this.packageName = r103;
        }
    }

    public static EnumEntries<ObricUpdateAvailableScene> getEntries() {
        return f404041b;
    }

    /* JADX WARN: Type inference failed for: r0v33, types: [com.obric.update.bean.ObricUpdateAvailableScene$a] */
    static {
        ObricUpdateAvailableScene r100 = new ObricUpdateAvailableScene(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        ObricUpdateAvailableScene r101 = new ObricUpdateAvailableScene("ASSISTANT", 1, 1);
        ASSISTANT = r101;
        ObricUpdateAvailableScene r102 = new ObricUpdateAvailableScene("AI_AGENT", 2, 2);
        AI_AGENT = r102;
        ObricUpdateAvailableScene r103 = new ObricUpdateAvailableScene("AI_KERNEL", 3, 4);
        AI_KERNEL = r103;
        ObricUpdateAvailableScene r104 = new ObricUpdateAvailableScene("MEMORY_DATA", 4, 8);
        MEMORY_DATA = r104;
        ObricUpdateAvailableScene r110 = new ObricUpdateAvailableScene("OAUTO", 5, 16);
        OAUTO = r110;
        int r111 = r101.bitmask;
        int r112 = r102.bitmask;
        int r105 = r111 | r112;
        ObricUpdateAvailableScene r113 = new ObricUpdateAvailableScene("ASSISTANT_AI_AGENT", 6, r105);
        ASSISTANT_AI_AGENT = r113;
        int r106 = r103.bitmask;
        int r107 = r111 | r106;
        ObricUpdateAvailableScene r108 = new ObricUpdateAvailableScene("ASSISTANT_AI_KERNEL", 7, r107);
        ASSISTANT_AI_KERNEL = r108;
        int r114 = r104.bitmask;
        int r109 = r111 | r114;
        ObricUpdateAvailableScene r115 = new ObricUpdateAvailableScene("ASSISTANT_MEMORY_DATA", 8, r109);
        ASSISTANT_MEMORY_DATA = r115;
        int r116 = r110.bitmask;
        ObricUpdateAvailableScene r117 = new ObricUpdateAvailableScene("ASSISTANT_OAUTO", 9, r111 | r116);
        ASSISTANT_OAUTO = r117;
        int r118 = r112 | r106;
        ObricUpdateAvailableScene r119 = new ObricUpdateAvailableScene("AI_AGENT_AI_KERNEL", 10, r118);
        AI_AGENT_AI_KERNEL = r119;
        int r120 = r112 | r114;
        ObricUpdateAvailableScene r121 = new ObricUpdateAvailableScene("AI_AGENT_MEMORY_DATA", 11, r120);
        AI_AGENT_MEMORY_DATA = r121;
        ObricUpdateAvailableScene r122 = new ObricUpdateAvailableScene("AI_AGENT_OAUTO", 12, r112 | r116);
        AI_AGENT_OAUTO = r122;
        int r123 = r106 | r114;
        ObricUpdateAvailableScene r124 = new ObricUpdateAvailableScene("AI_KERNEL_MEMORY_DATA", 13, r123);
        AI_KERNEL_MEMORY_DATA = r124;
        ObricUpdateAvailableScene r125 = new ObricUpdateAvailableScene("AI_KERNEL_OAUTO", 14, r106 | r116);
        AI_KERNEL_OAUTO = r125;
        ObricUpdateAvailableScene r126 = new ObricUpdateAvailableScene("MEMORY_DATA_OAUTO", 15, r114 | r116);
        MEMORY_DATA_OAUTO = r126;
        int r127 = r106 | r105;
        ObricUpdateAvailableScene r128 = new ObricUpdateAvailableScene("ASSISTANT_AI_AGENT_AI_KERNEL", 16, r127);
        ASSISTANT_AI_AGENT_AI_KERNEL = r128;
        int r129 = r105 | r114;
        ObricUpdateAvailableScene r130 = new ObricUpdateAvailableScene("ASSISTANT_AI_AGENT_MEMORY_DATA", 17, r129);
        ASSISTANT_AI_AGENT_MEMORY_DATA = r130;
        ObricUpdateAvailableScene r131 = new ObricUpdateAvailableScene("ASSISTANT_AI_AGENT_OAUTO", 18, r105 | r116);
        ASSISTANT_AI_AGENT_OAUTO = r131;
        int r132 = r107 | r114;
        ObricUpdateAvailableScene r133 = new ObricUpdateAvailableScene("ASSISTANT_AI_KERNEL_MEMORY_DATA", 19, r132);
        ASSISTANT_AI_KERNEL_MEMORY_DATA = r133;
        ObricUpdateAvailableScene r134 = new ObricUpdateAvailableScene("ASSISTANT_AI_KERNEL_OAUTO", 20, r107 | r116);
        ASSISTANT_AI_KERNEL_OAUTO = r134;
        ObricUpdateAvailableScene r135 = new ObricUpdateAvailableScene("ASSISTANT_MEMORY_DATA_OAUTO", 21, r109 | r116);
        ASSISTANT_MEMORY_DATA_OAUTO = r135;
        int r136 = r118 | r114;
        ObricUpdateAvailableScene r137 = new ObricUpdateAvailableScene("AI_AGENT_AI_KERNEL_MEMORY_DATA", 22, r136);
        AI_AGENT_AI_KERNEL_MEMORY_DATA = r137;
        ObricUpdateAvailableScene r138 = new ObricUpdateAvailableScene("AI_AGENT_AI_KERNEL_OAUTO", 23, r118 | r116);
        AI_AGENT_AI_KERNEL_OAUTO = r138;
        ObricUpdateAvailableScene r139 = new ObricUpdateAvailableScene("AI_AGENT_MEMORY_DATA_OAUTO", 24, r120 | r116);
        AI_AGENT_MEMORY_DATA_OAUTO = r139;
        ObricUpdateAvailableScene r140 = new ObricUpdateAvailableScene("AI_KERNEL_MEMORY_DATA_OAUTO", 25, r123 | r116);
        AI_KERNEL_MEMORY_DATA_OAUTO = r140;
        int r141 = r127 | r114;
        ObricUpdateAvailableScene r142 = new ObricUpdateAvailableScene("ASSISTANT_AI_AGENT_AI_KERNEL_MEMORY_DATA", 26, r141);
        ASSISTANT_AI_AGENT_AI_KERNEL_MEMORY_DATA = r142;
        ObricUpdateAvailableScene r143 = new ObricUpdateAvailableScene("ASSISTANT_AI_AGENT_AI_KERNEL_OAUTO", 27, r127 | r116);
        ASSISTANT_AI_AGENT_AI_KERNEL_OAUTO = r143;
        ObricUpdateAvailableScene r144 = new ObricUpdateAvailableScene("ASSISTANT_AI_AGENT_MEMORY_DATA_OAUTO", 28, r129 | r116);
        ASSISTANT_AI_AGENT_MEMORY_DATA_OAUTO = r144;
        ObricUpdateAvailableScene r145 = new ObricUpdateAvailableScene("ASSISTANT_AI_KERNEL_MEMORY_DATA_OAUTO", 29, r132 | r116);
        ASSISTANT_AI_KERNEL_MEMORY_DATA_OAUTO = r145;
        ObricUpdateAvailableScene r146 = new ObricUpdateAvailableScene("AI_AGENT_AI_KERNEL_MEMORY_DATA_OAUTO", 30, r136 | r116);
        AI_AGENT_AI_KERNEL_MEMORY_DATA_OAUTO = r146;
        ObricUpdateAvailableScene r147 = new ObricUpdateAvailableScene(AccountType.ALL, 31, r116 | r141);
        ALL = r147;
        ObricUpdateAvailableScene[] r148 = {r100, r101, r102, r103, r104, r110, r113, r108, r115, r117, r119, r121, r122, r124, r125, r126, r128, r130, r131, r133, r134, r135, r137, r138, r139, r140, r142, r143, r144, r145, r146, r147};
        f404040a = r148;
        f404041b = EnumEntriesKt.enumEntries(r148);
        Companion = new a();
    }

    public static ObricUpdateAvailableScene[] values() {
        return (ObricUpdateAvailableScene[]) f404040a.clone();
    }

    public final int getBitmask() {
        return this.bitmask;
    }

    public static ObricUpdateAvailableScene valueOf(String r100) {
        return (ObricUpdateAvailableScene) r27.a.a(ObricUpdateAvailableScene.class, r100);
    }

    public ObricUpdateAvailableScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.bitmask = r102;
    }
}
