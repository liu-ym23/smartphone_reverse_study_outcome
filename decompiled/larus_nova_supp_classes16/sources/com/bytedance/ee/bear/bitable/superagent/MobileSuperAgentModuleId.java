package com.bytedance.ee.bear.bitable.superagent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/MobileSuperAgentModuleId;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CONVERSATION", "SUB_CONVERSATION", "CONVERSATION_MANAGER", "TASK_INFO", "VOICE_INPUT", "DEBUG", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MobileSuperAgentModuleId extends Enum<MobileSuperAgentModuleId> {
    public static final MobileSuperAgentModuleId CONVERSATION = null;
    public static final MobileSuperAgentModuleId CONVERSATION_MANAGER = null;
    public static final a Companion = null;
    public static final MobileSuperAgentModuleId DEBUG = null;
    public static final MobileSuperAgentModuleId SUB_CONVERSATION = null;
    public static final MobileSuperAgentModuleId TASK_INFO = null;
    public static final MobileSuperAgentModuleId VOICE_INPUT = null;
    public static final /* synthetic */ MobileSuperAgentModuleId[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<MobileSuperAgentModuleId> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.bitable.superagent.MobileSuperAgentModuleId$a] */
    static {
        MobileSuperAgentModuleId r0 = new MobileSuperAgentModuleId("CONVERSATION", 0, "conversation");
        CONVERSATION = r0;
        MobileSuperAgentModuleId r1 = new MobileSuperAgentModuleId("SUB_CONVERSATION", 1, "subConversation");
        SUB_CONVERSATION = r1;
        MobileSuperAgentModuleId r3 = new MobileSuperAgentModuleId("CONVERSATION_MANAGER", 2, "conversationManager");
        CONVERSATION_MANAGER = r3;
        MobileSuperAgentModuleId r5 = new MobileSuperAgentModuleId("TASK_INFO", 3, "taskInfo");
        TASK_INFO = r5;
        MobileSuperAgentModuleId r7 = new MobileSuperAgentModuleId("VOICE_INPUT", 4, "voiceInput");
        VOICE_INPUT = r7;
        MobileSuperAgentModuleId r9 = new MobileSuperAgentModuleId("DEBUG", 5, "debug");
        DEBUG = r9;
        MobileSuperAgentModuleId[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
        Companion = new a();
    }

    public static MobileSuperAgentModuleId[] values() {
        return (MobileSuperAgentModuleId[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static MobileSuperAgentModuleId valueOf(String r1) {
        return (MobileSuperAgentModuleId) r27.a.a(MobileSuperAgentModuleId.class, r1);
    }

    public MobileSuperAgentModuleId(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
