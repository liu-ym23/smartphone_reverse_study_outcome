package com.larus.bmhome.chat.standarduikit.taskcard.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/taskcard/view/GeneralTaskSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "MAIN_CONVERSATION", "THREAD_CONVERSATION", "THREAD_CONVERSATION_V2", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GeneralTaskSource extends Enum<GeneralTaskSource> {
    public static final GeneralTaskSource MAIN_CONVERSATION = null;
    public static final GeneralTaskSource THREAD_CONVERSATION = null;
    public static final GeneralTaskSource THREAD_CONVERSATION_V2 = null;
    public static final GeneralTaskSource UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GeneralTaskSource[] f309813a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f309814b = null;
    private final int value;

    public static EnumEntries<GeneralTaskSource> getEntries() {
        return f309814b;
    }

    static {
        GeneralTaskSource r100 = new GeneralTaskSource("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        GeneralTaskSource r101 = new GeneralTaskSource("MAIN_CONVERSATION", 1, 1);
        MAIN_CONVERSATION = r101;
        GeneralTaskSource r102 = new GeneralTaskSource("THREAD_CONVERSATION", 2, 2);
        THREAD_CONVERSATION = r102;
        GeneralTaskSource r103 = new GeneralTaskSource("THREAD_CONVERSATION_V2", 3, 3);
        THREAD_CONVERSATION_V2 = r103;
        GeneralTaskSource[] r104 = {r100, r101, r102, r103};
        f309813a = r104;
        f309814b = EnumEntriesKt.enumEntries(r104);
    }

    public static GeneralTaskSource[] values() {
        return (GeneralTaskSource[]) f309813a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static GeneralTaskSource valueOf(String r100) {
        return (GeneralTaskSource) a.a(GeneralTaskSource.class, r100);
    }

    public GeneralTaskSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
