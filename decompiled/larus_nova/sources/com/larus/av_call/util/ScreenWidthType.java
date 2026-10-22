package com.larus.av_call.util;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/av_call/util/ScreenWidthType;", "", "<init>", "(Ljava/lang/String;I)V", "Small", "Medium", "Large", "av-call_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ScreenWidthType extends Enum<ScreenWidthType> {
    public static final ScreenWidthType Large = null;
    public static final ScreenWidthType Medium = null;
    public static final ScreenWidthType Small = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScreenWidthType[] f290567a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f290568b = null;

    public static EnumEntries<ScreenWidthType> getEntries() {
        return f290568b;
    }

    static {
        ScreenWidthType r100 = new ScreenWidthType("Small", 0);
        Small = r100;
        ScreenWidthType r101 = new ScreenWidthType("Medium", 1);
        Medium = r101;
        ScreenWidthType r102 = new ScreenWidthType("Large", 2);
        Large = r102;
        ScreenWidthType[] r103 = {r100, r101, r102};
        f290567a = r103;
        f290568b = EnumEntriesKt.enumEntries(r103);
    }

    public static ScreenWidthType[] values() {
        return (ScreenWidthType[]) f290567a.clone();
    }

    public static ScreenWidthType valueOf(String r100) {
        return (ScreenWidthType) a.a(ScreenWidthType.class, r100);
    }

    public ScreenWidthType(String r100, int r101) {
        super(r100, r101);
    }
}
