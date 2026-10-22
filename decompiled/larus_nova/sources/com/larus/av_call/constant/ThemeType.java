package com.larus.av_call.constant;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/av_call/constant/ThemeType;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "MAIN_BOT", "UGC_BOT", "IMMERS_BOT", "av-call_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ThemeType extends Enum<ThemeType> {
    public static final ThemeType DEFAULT = null;
    public static final ThemeType IMMERS_BOT = null;
    public static final ThemeType MAIN_BOT = null;
    public static final ThemeType UGC_BOT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThemeType[] f290502a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f290503b = null;

    public static EnumEntries<ThemeType> getEntries() {
        return f290503b;
    }

    static {
        ThemeType r100 = new ThemeType("DEFAULT", 0);
        DEFAULT = r100;
        ThemeType r101 = new ThemeType("MAIN_BOT", 1);
        MAIN_BOT = r101;
        ThemeType r102 = new ThemeType("UGC_BOT", 2);
        UGC_BOT = r102;
        ThemeType r103 = new ThemeType("IMMERS_BOT", 3);
        IMMERS_BOT = r103;
        ThemeType[] r104 = {r100, r101, r102, r103};
        f290502a = r104;
        f290503b = EnumEntriesKt.enumEntries(r104);
    }

    public static ThemeType[] values() {
        return (ThemeType[]) f290502a.clone();
    }

    public static ThemeType valueOf(String r100) {
        return (ThemeType) a.a(ThemeType.class, r100);
    }

    public ThemeType(String r100, int r101) {
        super(r100, r101);
    }
}
