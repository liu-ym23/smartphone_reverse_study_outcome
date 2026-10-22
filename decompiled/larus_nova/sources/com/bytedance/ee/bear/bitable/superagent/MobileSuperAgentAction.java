package com.bytedance.ee.bear.bitable.superagent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\u0081\u0002\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/MobileSuperAgentAction;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ENTER_CONVERSATION", "EXIT_CONVERSATION", "START_NEW_CONVERSATION", "SEND_MESSAGE", "STOP_ANSWER", "REGENERATE_ANSWER", "FEEDBACK_ANSWER", "LOAD_MORE_MESSAGES", "COPY_ANSWER", "COPY_TABLE_CARD", "SET_ACTIVE_TOOLS", "ENTER_SUB_CONVERSATION", "EXIT_SUB_CONVERSATION", "ENTER_CONVERSATION_MANAGER", "EXIT_CONVERSATION_MANAGER", "RENAME_CONVERSATION", "DELETE_CONVERSATION", "SELECT_HISTORY_CONVERSATION", "START_VOICE_INPUT", "STOP_VOICE_INPUT", "MODULE_DID_ENTER", "MODULE_DID_EXIT", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MobileSuperAgentAction extends Enum<MobileSuperAgentAction> {
    public static final MobileSuperAgentAction COPY_ANSWER = null;
    public static final MobileSuperAgentAction COPY_TABLE_CARD = null;
    public static final a Companion = null;
    public static final MobileSuperAgentAction DELETE_CONVERSATION = null;
    public static final MobileSuperAgentAction ENTER_CONVERSATION = null;
    public static final MobileSuperAgentAction ENTER_CONVERSATION_MANAGER = null;
    public static final MobileSuperAgentAction ENTER_SUB_CONVERSATION = null;
    public static final MobileSuperAgentAction EXIT_CONVERSATION = null;
    public static final MobileSuperAgentAction EXIT_CONVERSATION_MANAGER = null;
    public static final MobileSuperAgentAction EXIT_SUB_CONVERSATION = null;
    public static final MobileSuperAgentAction FEEDBACK_ANSWER = null;
    public static final MobileSuperAgentAction LOAD_MORE_MESSAGES = null;
    public static final MobileSuperAgentAction MODULE_DID_ENTER = null;
    public static final MobileSuperAgentAction MODULE_DID_EXIT = null;
    public static final MobileSuperAgentAction REGENERATE_ANSWER = null;
    public static final MobileSuperAgentAction RENAME_CONVERSATION = null;
    public static final MobileSuperAgentAction SELECT_HISTORY_CONVERSATION = null;
    public static final MobileSuperAgentAction SEND_MESSAGE = null;
    public static final MobileSuperAgentAction SET_ACTIVE_TOOLS = null;
    public static final MobileSuperAgentAction START_NEW_CONVERSATION = null;
    public static final MobileSuperAgentAction START_VOICE_INPUT = null;
    public static final MobileSuperAgentAction STOP_ANSWER = null;
    public static final MobileSuperAgentAction STOP_VOICE_INPUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MobileSuperAgentAction[] f215773a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f215774b = null;
    private final String value;

    public static EnumEntries<MobileSuperAgentAction> getEntries() {
        return f215774b;
    }

    /* JADX WARN: Type inference failed for: r0v22, types: [com.bytedance.ee.bear.bitable.superagent.MobileSuperAgentAction$a] */
    static {
        MobileSuperAgentAction r100 = new MobileSuperAgentAction("ENTER_CONVERSATION", 0, "enterConversation");
        ENTER_CONVERSATION = r100;
        MobileSuperAgentAction r101 = new MobileSuperAgentAction("EXIT_CONVERSATION", 1, "exitConversation");
        EXIT_CONVERSATION = r101;
        MobileSuperAgentAction r102 = new MobileSuperAgentAction("START_NEW_CONVERSATION", 2, "startNewConversation");
        START_NEW_CONVERSATION = r102;
        MobileSuperAgentAction r103 = new MobileSuperAgentAction("SEND_MESSAGE", 3, "sendMessage");
        SEND_MESSAGE = r103;
        MobileSuperAgentAction r104 = new MobileSuperAgentAction("STOP_ANSWER", 4, "stopAnswer");
        STOP_ANSWER = r104;
        MobileSuperAgentAction r105 = new MobileSuperAgentAction("REGENERATE_ANSWER", 5, "regenerateAnswer");
        REGENERATE_ANSWER = r105;
        MobileSuperAgentAction r110 = new MobileSuperAgentAction("FEEDBACK_ANSWER", 6, "feedbackAnswer");
        FEEDBACK_ANSWER = r110;
        MobileSuperAgentAction r111 = new MobileSuperAgentAction("LOAD_MORE_MESSAGES", 7, "loadMoreMessages");
        LOAD_MORE_MESSAGES = r111;
        MobileSuperAgentAction r112 = new MobileSuperAgentAction("COPY_ANSWER", 8, "copyAnswer");
        COPY_ANSWER = r112;
        MobileSuperAgentAction r113 = new MobileSuperAgentAction("COPY_TABLE_CARD", 9, "copyTableCard");
        COPY_TABLE_CARD = r113;
        MobileSuperAgentAction r106 = new MobileSuperAgentAction("SET_ACTIVE_TOOLS", 10, "setActiveTools");
        SET_ACTIVE_TOOLS = r106;
        MobileSuperAgentAction r107 = new MobileSuperAgentAction("ENTER_SUB_CONVERSATION", 11, "enterSubConversation");
        ENTER_SUB_CONVERSATION = r107;
        MobileSuperAgentAction r108 = new MobileSuperAgentAction("EXIT_SUB_CONVERSATION", 12, "exitSubConversation");
        EXIT_SUB_CONVERSATION = r108;
        MobileSuperAgentAction r109 = new MobileSuperAgentAction("ENTER_CONVERSATION_MANAGER", 13, "enterConversationManager");
        ENTER_CONVERSATION_MANAGER = r109;
        MobileSuperAgentAction r114 = new MobileSuperAgentAction("EXIT_CONVERSATION_MANAGER", 14, "exitConversationManager");
        EXIT_CONVERSATION_MANAGER = r114;
        MobileSuperAgentAction r115 = new MobileSuperAgentAction("RENAME_CONVERSATION", 15, "renameConversation");
        RENAME_CONVERSATION = r115;
        MobileSuperAgentAction r116 = new MobileSuperAgentAction("DELETE_CONVERSATION", 16, "deleteConversation");
        DELETE_CONVERSATION = r116;
        MobileSuperAgentAction r117 = new MobileSuperAgentAction("SELECT_HISTORY_CONVERSATION", 17, "selectHistoryConversation");
        SELECT_HISTORY_CONVERSATION = r117;
        MobileSuperAgentAction r118 = new MobileSuperAgentAction("START_VOICE_INPUT", 18, "startVoiceInput");
        START_VOICE_INPUT = r118;
        MobileSuperAgentAction r119 = new MobileSuperAgentAction("STOP_VOICE_INPUT", 19, "stopVoiceInput");
        STOP_VOICE_INPUT = r119;
        MobileSuperAgentAction r120 = new MobileSuperAgentAction("MODULE_DID_ENTER", 20, "moduleDidEnter");
        MODULE_DID_ENTER = r120;
        MobileSuperAgentAction r121 = new MobileSuperAgentAction("MODULE_DID_EXIT", 21, "moduleDidExit");
        MODULE_DID_EXIT = r121;
        MobileSuperAgentAction[] r122 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107, r108, r109, r114, r115, r116, r117, r118, r119, r120, r121};
        f215773a = r122;
        f215774b = EnumEntriesKt.enumEntries(r122);
        Companion = new a();
    }

    public static MobileSuperAgentAction[] values() {
        return (MobileSuperAgentAction[]) f215773a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static MobileSuperAgentAction valueOf(String r100) {
        return (MobileSuperAgentAction) r27.a.a(MobileSuperAgentAction.class, r100);
    }

    public MobileSuperAgentAction(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
