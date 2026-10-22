package com.bytedance.ee.bear.bitable.core.infoarch.arch;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bitable/core/infoarch/arch/ThemeType;", "", "<init>", "(Ljava/lang/String;I)V", "LIGHT", "DARK", "DEFAULT", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ThemeType extends Enum<ThemeType> {
    public static final ThemeType DARK = null;
    public static final ThemeType DEFAULT = null;
    public static final ThemeType LIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThemeType[] f210212a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f210213b = null;

    public static EnumEntries<ThemeType> getEntries() {
        return f210213b;
    }

    static {
        ThemeType r100 = new ThemeType("LIGHT", 0);
        LIGHT = r100;
        ThemeType r101 = new ThemeType("DARK", 1);
        DARK = r101;
        ThemeType r102 = new ThemeType("DEFAULT", 2);
        DEFAULT = r102;
        ThemeType[] r103 = {r100, r101, r102};
        f210212a = r103;
        f210213b = EnumEntriesKt.enumEntries(r103);
    }

    public static ThemeType[] values() {
        return (ThemeType[]) f210212a.clone();
    }

    public static ThemeType valueOf(String r100) {
        return (ThemeType) r27.a.a(ThemeType.class, r100);
    }

    public ThemeType(String r100, int r101) {
        super(r100, r101);
    }
}
