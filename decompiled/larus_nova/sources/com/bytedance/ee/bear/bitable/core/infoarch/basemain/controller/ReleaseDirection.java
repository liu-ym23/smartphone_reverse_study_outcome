package com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/core/infoarch/basemain/controller/ReleaseDirection;", "", "<init>", "(Ljava/lang/String;I)V", "COLLAPSE", "EXPAND", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum ReleaseDirection extends Enum<ReleaseDirection> {
    public static final ReleaseDirection COLLAPSE = null;
    public static final ReleaseDirection EXPAND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReleaseDirection[] f210391a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f210392b = null;

    public static EnumEntries<ReleaseDirection> getEntries() {
        return f210392b;
    }

    static {
        ReleaseDirection r100 = new ReleaseDirection("COLLAPSE", 0);
        COLLAPSE = r100;
        ReleaseDirection r101 = new ReleaseDirection("EXPAND", 1);
        EXPAND = r101;
        ReleaseDirection[] r102 = {r100, r101};
        f210391a = r102;
        f210392b = EnumEntriesKt.enumEntries(r102);
    }

    public static ReleaseDirection[] values() {
        return (ReleaseDirection[]) f210391a.clone();
    }

    public static ReleaseDirection valueOf(String r100) {
        return (ReleaseDirection) r27.a.a(ReleaseDirection.class, r100);
    }

    public ReleaseDirection(String r100, int r101) {
        super(r100, r101);
    }
}
