package com.bytedance.ee.bear.bitable.superagent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/MobileSuperAgentModuleId;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CONVERSATION", "SUB_CONVERSATION", "CONVERSATION_MANAGER", "TASK_INFO", "VOICE_INPUT", "DEBUG", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MobileSuperAgentModuleId extends Enum<MobileSuperAgentModuleId> {
    public static final MobileSuperAgentModuleId CONVERSATION = null;
    public static final MobileSuperAgentModuleId CONVERSATION_MANAGER = null;
    public static final a Companion = null;
    public static final MobileSuperAgentModuleId DEBUG = null;
    public static final MobileSuperAgentModuleId SUB_CONVERSATION = null;
    public static final MobileSuperAgentModuleId TASK_INFO = null;
    public static final MobileSuperAgentModuleId VOICE_INPUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MobileSuperAgentModuleId[] f215775a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f215776b = null;
    private final String value;

    public static EnumEntries<MobileSuperAgentModuleId> getEntries() {
        return f215776b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.bitable.superagent.MobileSuperAgentModuleId$a] */
    static {
        MobileSuperAgentModuleId r100 = new MobileSuperAgentModuleId("CONVERSATION", 0, "conversation");
        CONVERSATION = r100;
        MobileSuperAgentModuleId r101 = new MobileSuperAgentModuleId("SUB_CONVERSATION", 1, "subConversation");
        SUB_CONVERSATION = r101;
        MobileSuperAgentModuleId r102 = new MobileSuperAgentModuleId("CONVERSATION_MANAGER", 2, "conversationManager");
        CONVERSATION_MANAGER = r102;
        MobileSuperAgentModuleId r103 = new MobileSuperAgentModuleId("TASK_INFO", 3, "taskInfo");
        TASK_INFO = r103;
        MobileSuperAgentModuleId r104 = new MobileSuperAgentModuleId("VOICE_INPUT", 4, "voiceInput");
        VOICE_INPUT = r104;
        MobileSuperAgentModuleId r105 = new MobileSuperAgentModuleId("DEBUG", 5, "debug");
        DEBUG = r105;
        MobileSuperAgentModuleId[] r110 = {r100, r101, r102, r103, r104, r105};
        f215775a = r110;
        f215776b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static MobileSuperAgentModuleId[] values() {
        return (MobileSuperAgentModuleId[]) f215775a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static MobileSuperAgentModuleId valueOf(String r100) {
        return (MobileSuperAgentModuleId) r27.a.a(MobileSuperAgentModuleId.class, r100);
    }

    public MobileSuperAgentModuleId(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
