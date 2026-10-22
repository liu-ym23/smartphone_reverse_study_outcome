package com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/core/infoarch/basemain/controller/OfficeBaseMainStatusBarMode;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "KEEP_TRANSPARENT", "DASHBOARD_FULLSCREEN", "FULLSCREEN_TRANSPARENT", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeBaseMainStatusBarMode extends Enum<OfficeBaseMainStatusBarMode> {
    public static final OfficeBaseMainStatusBarMode DASHBOARD_FULLSCREEN = null;
    public static final OfficeBaseMainStatusBarMode DEFAULT = null;
    public static final OfficeBaseMainStatusBarMode FULLSCREEN_TRANSPARENT = null;
    public static final OfficeBaseMainStatusBarMode KEEP_TRANSPARENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeBaseMainStatusBarMode[] f210389a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f210390b = null;

    public static EnumEntries<OfficeBaseMainStatusBarMode> getEntries() {
        return f210390b;
    }

    static {
        OfficeBaseMainStatusBarMode r100 = new OfficeBaseMainStatusBarMode("DEFAULT", 0);
        DEFAULT = r100;
        OfficeBaseMainStatusBarMode r101 = new OfficeBaseMainStatusBarMode("KEEP_TRANSPARENT", 1);
        KEEP_TRANSPARENT = r101;
        OfficeBaseMainStatusBarMode r102 = new OfficeBaseMainStatusBarMode("DASHBOARD_FULLSCREEN", 2);
        DASHBOARD_FULLSCREEN = r102;
        OfficeBaseMainStatusBarMode r103 = new OfficeBaseMainStatusBarMode("FULLSCREEN_TRANSPARENT", 3);
        FULLSCREEN_TRANSPARENT = r103;
        OfficeBaseMainStatusBarMode[] r104 = {r100, r101, r102, r103};
        f210389a = r104;
        f210390b = EnumEntriesKt.enumEntries(r104);
    }

    public static OfficeBaseMainStatusBarMode[] values() {
        return (OfficeBaseMainStatusBarMode[]) f210389a.clone();
    }

    public static OfficeBaseMainStatusBarMode valueOf(String r100) {
        return (OfficeBaseMainStatusBarMode) r27.a.a(OfficeBaseMainStatusBarMode.class, r100);
    }

    public OfficeBaseMainStatusBarMode(String r100, int r101) {
        super(r100, r101);
    }
}
