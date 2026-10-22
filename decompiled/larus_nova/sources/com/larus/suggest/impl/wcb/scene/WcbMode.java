package com.larus.suggest.impl.wcb.scene;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/suggest/impl/wcb/scene/WcbMode;", "", "<init>", "(Ljava/lang/String;I)V", "QUICK_EXPERT", "OFFICE_TASK", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WcbMode extends Enum<WcbMode> {
    public static final WcbMode OFFICE_TASK = null;
    public static final WcbMode QUICK_EXPERT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WcbMode[] f370122a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f370123b = null;

    public static EnumEntries<WcbMode> getEntries() {
        return f370123b;
    }

    static {
        WcbMode r100 = new WcbMode("QUICK_EXPERT", 0);
        QUICK_EXPERT = r100;
        WcbMode r101 = new WcbMode("OFFICE_TASK", 1);
        OFFICE_TASK = r101;
        WcbMode[] r102 = {r100, r101};
        f370122a = r102;
        f370123b = EnumEntriesKt.enumEntries(r102);
    }

    public static WcbMode[] values() {
        return (WcbMode[]) f370122a.clone();
    }

    public static WcbMode valueOf(String r100) {
        return (WcbMode) a.a(WcbMode.class, r100);
    }

    public WcbMode(String r100, int r101) {
        super(r100, r101);
    }
}
