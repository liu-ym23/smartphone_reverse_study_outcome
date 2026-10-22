package com.larus.home.impl.main.side_bar.view.group.policy;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/group/policy/ConversationGroupPolicy;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "None", "Project", "Device", "Time", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ConversationGroupPolicy extends Enum<ConversationGroupPolicy> {
    public static final ConversationGroupPolicy Device = null;
    public static final ConversationGroupPolicy None = null;
    public static final ConversationGroupPolicy Project = null;
    public static final ConversationGroupPolicy Time = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConversationGroupPolicy[] f345569a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f345570b = null;
    private final int value;

    public static EnumEntries<ConversationGroupPolicy> getEntries() {
        return f345570b;
    }

    static {
        ConversationGroupPolicy r100 = new ConversationGroupPolicy("None", 0, 0);
        None = r100;
        ConversationGroupPolicy r101 = new ConversationGroupPolicy("Project", 1, 1);
        Project = r101;
        ConversationGroupPolicy r102 = new ConversationGroupPolicy("Device", 2, 2);
        Device = r102;
        ConversationGroupPolicy r103 = new ConversationGroupPolicy("Time", 3, 3);
        Time = r103;
        ConversationGroupPolicy[] r104 = {r100, r101, r102, r103};
        f345569a = r104;
        f345570b = EnumEntriesKt.enumEntries(r104);
    }

    public static ConversationGroupPolicy[] values() {
        return (ConversationGroupPolicy[]) f345569a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ConversationGroupPolicy valueOf(String r100) {
        return (ConversationGroupPolicy) r27.a.a(ConversationGroupPolicy.class, r100);
    }

    public ConversationGroupPolicy(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
