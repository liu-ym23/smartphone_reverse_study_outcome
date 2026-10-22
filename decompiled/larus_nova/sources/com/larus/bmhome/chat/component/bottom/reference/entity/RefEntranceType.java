package com.larus.bmhome.chat.component.bottom.reference.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/reference/entity/RefEntranceType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "ChooseTextAutoCite", "LongPressAnswerMore", "LongPressAndChooseText", "ClickMarkDownLink", "TaskCardQuestion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RefEntranceType extends Enum<RefEntranceType> {
    public static final RefEntranceType ChooseTextAutoCite = null;
    public static final RefEntranceType ClickMarkDownLink = null;
    public static final RefEntranceType LongPressAndChooseText = null;
    public static final RefEntranceType LongPressAnswerMore = null;
    public static final RefEntranceType TaskCardQuestion = null;
    public static final RefEntranceType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RefEntranceType[] f300330a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f300331b = null;
    private final int value;

    public static EnumEntries<RefEntranceType> getEntries() {
        return f300331b;
    }

    static {
        RefEntranceType r100 = new RefEntranceType("Unknown", 0, 0);
        Unknown = r100;
        RefEntranceType r101 = new RefEntranceType("ChooseTextAutoCite", 1, 1);
        ChooseTextAutoCite = r101;
        RefEntranceType r102 = new RefEntranceType("LongPressAnswerMore", 2, 2);
        LongPressAnswerMore = r102;
        RefEntranceType r103 = new RefEntranceType("LongPressAndChooseText", 3, 3);
        LongPressAndChooseText = r103;
        RefEntranceType r104 = new RefEntranceType("ClickMarkDownLink", 4, 4);
        ClickMarkDownLink = r104;
        RefEntranceType r105 = new RefEntranceType("TaskCardQuestion", 5, 5);
        TaskCardQuestion = r105;
        RefEntranceType[] r110 = {r100, r101, r102, r103, r104, r105};
        f300330a = r110;
        f300331b = EnumEntriesKt.enumEntries(r110);
    }

    public static RefEntranceType[] values() {
        return (RefEntranceType[]) f300330a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static RefEntranceType valueOf(String r100) {
        return (RefEntranceType) a.a(RefEntranceType.class, r100);
    }

    public RefEntranceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
