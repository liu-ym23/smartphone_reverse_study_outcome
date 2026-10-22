package com.larus.bmhome.chat.thinkmode;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/thinkmode/BehaviorSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ACTIONBAR", "CHAT", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BehaviorSource extends Enum<BehaviorSource> {
    public static final BehaviorSource ACTIONBAR = null;
    public static final BehaviorSource CHAT = null;
    public static final BehaviorSource UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BehaviorSource[] f309969a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f309970b = null;
    private final int value;

    public static EnumEntries<BehaviorSource> getEntries() {
        return f309970b;
    }

    static {
        BehaviorSource r100 = new BehaviorSource("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        BehaviorSource r101 = new BehaviorSource("ACTIONBAR", 1, 1);
        ACTIONBAR = r101;
        BehaviorSource r102 = new BehaviorSource("CHAT", 2, 2);
        CHAT = r102;
        BehaviorSource[] r103 = {r100, r101, r102};
        f309969a = r103;
        f309970b = EnumEntriesKt.enumEntries(r103);
    }

    public static BehaviorSource[] values() {
        return (BehaviorSource[]) f309969a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static BehaviorSource valueOf(String r100) {
        return (BehaviorSource) r27.a.a(BehaviorSource.class, r100);
    }

    public BehaviorSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
