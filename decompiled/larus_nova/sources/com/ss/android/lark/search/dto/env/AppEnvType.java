package com.ss.android.lark.search.dto.env;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/search/dto/env/AppEnvType;", "", "<init>", "(Ljava/lang/String;I)V", "PreRelease", "Boe", "Release", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppEnvType extends Enum<AppEnvType> {
    public static final AppEnvType Boe = null;
    public static final AppEnvType PreRelease = null;
    public static final AppEnvType Release = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppEnvType[] f440139a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440140b = null;

    public static EnumEntries<AppEnvType> getEntries() {
        return f440140b;
    }

    static {
        AppEnvType r100 = new AppEnvType("PreRelease", 0);
        PreRelease = r100;
        AppEnvType r101 = new AppEnvType("Boe", 1);
        Boe = r101;
        AppEnvType r102 = new AppEnvType("Release", 2);
        Release = r102;
        AppEnvType[] r103 = {r100, r101, r102};
        f440139a = r103;
        f440140b = EnumEntriesKt.enumEntries(r103);
    }

    public static AppEnvType[] values() {
        return (AppEnvType[]) f440139a.clone();
    }

    public static AppEnvType valueOf(String r100) {
        return (AppEnvType) a.a(AppEnvType.class, r100);
    }

    public AppEnvType(String r100, int r101) {
        super(r100, r101);
    }
}
