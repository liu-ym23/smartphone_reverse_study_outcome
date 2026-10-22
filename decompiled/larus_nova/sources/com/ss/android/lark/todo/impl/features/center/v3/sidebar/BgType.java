package com.ss.android.lark.todo.impl.features.center.v3.sidebar;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/sidebar/BgType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NO_BG", "BG_FIRST_IN_SECTION", "BG_MIDDLE_IN_SECTION", "BG_END_IN_SECTION", "BG_ONLY_ONE_IN_SECTION", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BgType extends Enum<BgType> {
    public static final BgType BG_END_IN_SECTION = null;
    public static final BgType BG_FIRST_IN_SECTION = null;
    public static final BgType BG_MIDDLE_IN_SECTION = null;
    public static final BgType BG_ONLY_ONE_IN_SECTION = null;
    public static final BgType NO_BG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BgType[] f441639a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f441640b = null;
    private final int value;

    public static EnumEntries<BgType> getEntries() {
        return f441640b;
    }

    static {
        BgType r100 = new BgType("NO_BG", 0, 0);
        NO_BG = r100;
        BgType r101 = new BgType("BG_FIRST_IN_SECTION", 1, 1);
        BG_FIRST_IN_SECTION = r101;
        BgType r102 = new BgType("BG_MIDDLE_IN_SECTION", 2, 2);
        BG_MIDDLE_IN_SECTION = r102;
        BgType r103 = new BgType("BG_END_IN_SECTION", 3, 3);
        BG_END_IN_SECTION = r103;
        BgType r104 = new BgType("BG_ONLY_ONE_IN_SECTION", 4, 4);
        BG_ONLY_ONE_IN_SECTION = r104;
        BgType[] r105 = {r100, r101, r102, r103, r104};
        f441639a = r105;
        f441640b = EnumEntriesKt.enumEntries(r105);
    }

    public static BgType[] values() {
        return (BgType[]) f441639a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static BgType valueOf(String r100) {
        return (BgType) r27.a.a(BgType.class, r100);
    }

    public BgType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
