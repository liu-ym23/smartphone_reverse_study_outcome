package com.larus.bmhome.actionbar.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/actionbar/model/AgentMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "MOA", "CHAT", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AgentMode extends Enum<AgentMode> {
    public static final AgentMode CHAT = null;
    public static final AgentMode MOA = null;
    public static final AgentMode UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AgentMode[] f294934a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f294935b = null;
    private final int value;

    public static EnumEntries<AgentMode> getEntries() {
        return f294935b;
    }

    static {
        AgentMode r100 = new AgentMode("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        AgentMode r101 = new AgentMode("MOA", 1, 1);
        MOA = r101;
        AgentMode r102 = new AgentMode("CHAT", 2, 2);
        CHAT = r102;
        AgentMode[] r103 = {r100, r101, r102};
        f294934a = r103;
        f294935b = EnumEntriesKt.enumEntries(r103);
    }

    public static AgentMode[] values() {
        return (AgentMode[]) f294934a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AgentMode valueOf(String r100) {
        return (AgentMode) r27.a.a(AgentMode.class, r100);
    }

    public AgentMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
