package com.larus.im.constant;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/im/constant/PullSingleChainScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "MSG_MISSING", "FRONTIER_TIMEOUT", "MSG_REGEN", "MSG_NOTIFY_PULL", "REQUEST_NEW_MSG", "CONVERSATION_CHECK", "CONVERSATION_INFO", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PullSingleChainScene extends Enum<PullSingleChainScene> {
    public static final PullSingleChainScene CONVERSATION_CHECK = null;
    public static final PullSingleChainScene CONVERSATION_INFO = null;
    public static final PullSingleChainScene FRONTIER_TIMEOUT = null;
    public static final PullSingleChainScene MSG_MISSING = null;
    public static final PullSingleChainScene MSG_NOTIFY_PULL = null;
    public static final PullSingleChainScene MSG_REGEN = null;
    public static final PullSingleChainScene REQUEST_NEW_MSG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PullSingleChainScene[] f347132a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f347133b = null;
    private final int value;

    public static EnumEntries<PullSingleChainScene> getEntries() {
        return f347133b;
    }

    static {
        PullSingleChainScene r100 = new PullSingleChainScene("MSG_MISSING", 0, 0);
        MSG_MISSING = r100;
        PullSingleChainScene r101 = new PullSingleChainScene("FRONTIER_TIMEOUT", 1, 1);
        FRONTIER_TIMEOUT = r101;
        PullSingleChainScene r102 = new PullSingleChainScene("MSG_REGEN", 2, 2);
        MSG_REGEN = r102;
        PullSingleChainScene r103 = new PullSingleChainScene("MSG_NOTIFY_PULL", 3, 3);
        MSG_NOTIFY_PULL = r103;
        PullSingleChainScene r104 = new PullSingleChainScene("REQUEST_NEW_MSG", 4, 4);
        REQUEST_NEW_MSG = r104;
        PullSingleChainScene r105 = new PullSingleChainScene("CONVERSATION_CHECK", 5, 5);
        CONVERSATION_CHECK = r105;
        PullSingleChainScene r110 = new PullSingleChainScene("CONVERSATION_INFO", 6, 6);
        CONVERSATION_INFO = r110;
        PullSingleChainScene[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f347132a = r111;
        f347133b = EnumEntriesKt.enumEntries(r111);
    }

    public static PullSingleChainScene[] values() {
        return (PullSingleChainScene[]) f347132a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static PullSingleChainScene valueOf(String r100) {
        return (PullSingleChainScene) a.a(PullSingleChainScene.class, r100);
    }

    public PullSingleChainScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
