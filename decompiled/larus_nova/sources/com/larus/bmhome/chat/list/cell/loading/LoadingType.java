package com.larus.bmhome.chat.list.cell.loading;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/loading/LoadingType;", "", "<init>", "(Ljava/lang/String;I)V", "IN", "OUT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LoadingType extends Enum<LoadingType> {
    public static final LoadingType IN = null;
    public static final LoadingType OUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadingType[] f305392a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f305393b = null;

    public static EnumEntries<LoadingType> getEntries() {
        return f305393b;
    }

    static {
        LoadingType r100 = new LoadingType("IN", 0);
        IN = r100;
        LoadingType r101 = new LoadingType("OUT", 1);
        OUT = r101;
        LoadingType[] r102 = {r100, r101};
        f305392a = r102;
        f305393b = EnumEntriesKt.enumEntries(r102);
    }

    public static LoadingType[] values() {
        return (LoadingType[]) f305392a.clone();
    }

    public static LoadingType valueOf(String r100) {
        return (LoadingType) a.a(LoadingType.class, r100);
    }

    public LoadingType(String r100, int r101) {
        super(r100, r101);
    }
}
