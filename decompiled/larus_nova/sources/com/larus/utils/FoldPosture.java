package com.larus.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/utils/FoldPosture;", "", "<init>", "(Ljava/lang/String;I)V", "FOLDED", "HALF_OPENED", "FLAT", "UNKNOWN", "utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FoldPosture extends Enum<FoldPosture> {
    public static final FoldPosture FLAT = null;
    public static final FoldPosture FOLDED = null;
    public static final FoldPosture HALF_OPENED = null;
    public static final FoldPosture UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FoldPosture[] f375344a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f375345b = null;

    public static EnumEntries<FoldPosture> getEntries() {
        return f375345b;
    }

    static {
        FoldPosture r100 = new FoldPosture("FOLDED", 0);
        FOLDED = r100;
        FoldPosture r101 = new FoldPosture("HALF_OPENED", 1);
        HALF_OPENED = r101;
        FoldPosture r102 = new FoldPosture("FLAT", 2);
        FLAT = r102;
        FoldPosture r103 = new FoldPosture("UNKNOWN", 3);
        UNKNOWN = r103;
        FoldPosture[] r104 = {r100, r101, r102, r103};
        f375344a = r104;
        f375345b = EnumEntriesKt.enumEntries(r104);
    }

    public static FoldPosture[] values() {
        return (FoldPosture[]) f375344a.clone();
    }

    public static FoldPosture valueOf(String r100) {
        return (FoldPosture) r27.a.a(FoldPosture.class, r100);
    }

    public FoldPosture(String r100, int r101) {
        super(r100, r101);
    }
}
