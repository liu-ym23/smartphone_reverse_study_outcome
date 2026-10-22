package com.bytedance.ee.bear.bitable.superagent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/ChatStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "PENDING", "RUNNING", "FINISHED", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatStatus extends Enum<ChatStatus> {
    public static final a Companion = null;
    public static final ChatStatus FINISHED = null;
    public static final ChatStatus PENDING = null;
    public static final ChatStatus RUNNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatStatus[] f215771a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f215772b = null;
    private final int value;

    public static EnumEntries<ChatStatus> getEntries() {
        return f215772b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.bitable.superagent.ChatStatus$a] */
    static {
        ChatStatus r100 = new ChatStatus("PENDING", 0, 1);
        PENDING = r100;
        ChatStatus r101 = new ChatStatus("RUNNING", 1, 2);
        RUNNING = r101;
        ChatStatus r102 = new ChatStatus("FINISHED", 2, 3);
        FINISHED = r102;
        ChatStatus[] r103 = {r100, r101, r102};
        f215771a = r103;
        f215772b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static ChatStatus[] values() {
        return (ChatStatus[]) f215771a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ChatStatus valueOf(String r100) {
        return (ChatStatus) r27.a.a(ChatStatus.class, r100);
    }

    public ChatStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
