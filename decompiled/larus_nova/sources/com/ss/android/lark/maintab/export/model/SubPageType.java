package com.ss.android.lark.maintab.export.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/maintab/export/model/SubPageType;", "", "<init>", "(Ljava/lang/String;I)V", "FULL_SCREEN", "SPLIT_SCREEN", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SubPageType extends Enum<SubPageType> {
    public static final SubPageType FULL_SCREEN = null;
    public static final SubPageType SPLIT_SCREEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SubPageType[] f431620a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f431621b = null;

    public static EnumEntries<SubPageType> getEntries() {
        return f431621b;
    }

    static {
        SubPageType r100 = new SubPageType("FULL_SCREEN", 0);
        FULL_SCREEN = r100;
        SubPageType r101 = new SubPageType("SPLIT_SCREEN", 1);
        SPLIT_SCREEN = r101;
        SubPageType[] r102 = {r100, r101};
        f431620a = r102;
        f431621b = EnumEntriesKt.enumEntries(r102);
    }

    public static SubPageType[] values() {
        return (SubPageType[]) f431620a.clone();
    }

    public static SubPageType valueOf(String r100) {
        return (SubPageType) a.a(SubPageType.class, r100);
    }

    public SubPageType(String r100, int r101) {
        super(r100, r101);
    }
}
