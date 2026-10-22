package com.larus.bmhome.view.actionbar.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/view/actionbar/api/ChatUIBlockConfig;", "", "configKey", "", "description", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getConfigKey", "()Ljava/lang/String;", "getDescription", "HIDE_INPUT_BAR", "HIDE_TITLE_BAR_BUTTONS", "DISABLE_MSG_LONG_PRESS", "HIDE_MESSAGE_BOTTOM_ACTIONS", "DISABLE_MESSAGE_INTERACTION", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatUIBlockConfig extends Enum<ChatUIBlockConfig> {
    public static final a Companion = null;
    public static final ChatUIBlockConfig DISABLE_MESSAGE_INTERACTION = null;
    public static final ChatUIBlockConfig DISABLE_MSG_LONG_PRESS = null;
    public static final ChatUIBlockConfig HIDE_INPUT_BAR = null;
    public static final ChatUIBlockConfig HIDE_MESSAGE_BOTTOM_ACTIONS = null;
    public static final ChatUIBlockConfig HIDE_TITLE_BAR_BUTTONS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatUIBlockConfig[] f315657a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f315658b = null;
    private final String configKey;
    private final String description;

    public static EnumEntries<ChatUIBlockConfig> getEntries() {
        return f315658b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.view.actionbar.api.ChatUIBlockConfig$a] */
    static {
        ChatUIBlockConfig r100 = new ChatUIBlockConfig("HIDE_INPUT_BAR", 0, "hide_input_bar", "隐藏输入框");
        HIDE_INPUT_BAR = r100;
        ChatUIBlockConfig r101 = new ChatUIBlockConfig("HIDE_TITLE_BAR_BUTTONS", 1, "hide_title_bar_buttons", "隐藏标题栏按钮");
        HIDE_TITLE_BAR_BUTTONS = r101;
        ChatUIBlockConfig r102 = new ChatUIBlockConfig("DISABLE_MSG_LONG_PRESS", 2, "disable_msg_long_press", "禁用消息长按菜单");
        DISABLE_MSG_LONG_PRESS = r102;
        ChatUIBlockConfig r103 = new ChatUIBlockConfig("HIDE_MESSAGE_BOTTOM_ACTIONS", 3, "hide_message_bottom_actions", "隐藏消息底部操作区");
        HIDE_MESSAGE_BOTTOM_ACTIONS = r103;
        ChatUIBlockConfig r104 = new ChatUIBlockConfig("DISABLE_MESSAGE_INTERACTION", 4, "disable_message_interaction", "禁用部分消息交互");
        DISABLE_MESSAGE_INTERACTION = r104;
        ChatUIBlockConfig[] r105 = {r100, r101, r102, r103, r104};
        f315657a = r105;
        f315658b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static ChatUIBlockConfig[] values() {
        return (ChatUIBlockConfig[]) f315657a.clone();
    }

    public final String getConfigKey() {
        return this.configKey;
    }

    public final String getDescription() {
        return this.description;
    }

    public static ChatUIBlockConfig valueOf(String r100) {
        return (ChatUIBlockConfig) r27.a.a(ChatUIBlockConfig.class, r100);
    }

    public ChatUIBlockConfig(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.configKey = r102;
        this.description = r103;
    }
}
