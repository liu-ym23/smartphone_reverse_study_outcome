package com.bytedance.ee.bear.list.constants;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/list/constants/RankType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "EDIT_TIME", "VISIT_TIME", "MY_EDIT_EVENT", "Companion", "contentmanager-list-export-min_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RankType extends Enum<RankType> {
    public static final a Companion = null;
    public static final RankType EDIT_TIME = null;
    public static final RankType MY_EDIT_EVENT = null;
    public static final RankType VISIT_TIME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RankType[] f227691a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f227692b = null;
    private final int value;

    public static EnumEntries<RankType> getEntries() {
        return f227692b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.list.constants.RankType$a] */
    static {
        RankType r100 = new RankType("EDIT_TIME", 0, 0);
        EDIT_TIME = r100;
        RankType r101 = new RankType("VISIT_TIME", 1, 6);
        VISIT_TIME = r101;
        RankType r102 = new RankType("MY_EDIT_EVENT", 2, 7);
        MY_EDIT_EVENT = r102;
        RankType[] r103 = {r100, r101, r102};
        f227691a = r103;
        f227692b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static RankType[] values() {
        return (RankType[]) f227691a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static RankType valueOf(String r100) {
        return (RankType) r27.a.a(RankType.class, r100);
    }

    public RankType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
