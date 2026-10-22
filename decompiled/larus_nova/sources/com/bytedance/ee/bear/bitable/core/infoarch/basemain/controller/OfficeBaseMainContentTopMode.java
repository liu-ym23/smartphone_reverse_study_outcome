package com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bitable/core/infoarch/basemain/controller/OfficeBaseMainContentTopMode;", "", "<init>", "(Ljava/lang/String;I)V", "BELOW_CHROME", "BELOW_STATUS_BAR", "EDGE_TO_EDGE", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeBaseMainContentTopMode extends Enum<OfficeBaseMainContentTopMode> {
    public static final OfficeBaseMainContentTopMode BELOW_CHROME = null;
    public static final OfficeBaseMainContentTopMode BELOW_STATUS_BAR = null;
    public static final OfficeBaseMainContentTopMode EDGE_TO_EDGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeBaseMainContentTopMode[] f210310a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f210311b = null;

    public static EnumEntries<OfficeBaseMainContentTopMode> getEntries() {
        return f210311b;
    }

    static {
        OfficeBaseMainContentTopMode r100 = new OfficeBaseMainContentTopMode("BELOW_CHROME", 0);
        BELOW_CHROME = r100;
        OfficeBaseMainContentTopMode r101 = new OfficeBaseMainContentTopMode("BELOW_STATUS_BAR", 1);
        BELOW_STATUS_BAR = r101;
        OfficeBaseMainContentTopMode r102 = new OfficeBaseMainContentTopMode("EDGE_TO_EDGE", 2);
        EDGE_TO_EDGE = r102;
        OfficeBaseMainContentTopMode[] r103 = {r100, r101, r102};
        f210310a = r103;
        f210311b = EnumEntriesKt.enumEntries(r103);
    }

    public static OfficeBaseMainContentTopMode[] values() {
        return (OfficeBaseMainContentTopMode[]) f210310a.clone();
    }

    public static OfficeBaseMainContentTopMode valueOf(String r100) {
        return (OfficeBaseMainContentTopMode) r27.a.a(OfficeBaseMainContentTopMode.class, r100);
    }

    public OfficeBaseMainContentTopMode(String r100, int r101) {
        super(r100, r101);
    }
}
