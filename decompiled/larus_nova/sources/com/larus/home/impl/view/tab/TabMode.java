package com.larus.home.impl.view.tab;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/home/impl/view/tab/TabMode;", "", "<init>", "(Ljava/lang/String;I)V", "LIGHT", "NIGHT", "AUTO", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TabMode extends Enum<TabMode> {
    public static final TabMode AUTO = null;
    public static final TabMode LIGHT = null;
    public static final TabMode NIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TabMode[] f346382a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346383b = null;

    public static EnumEntries<TabMode> getEntries() {
        return f346383b;
    }

    static {
        TabMode r100 = new TabMode("LIGHT", 0);
        LIGHT = r100;
        TabMode r101 = new TabMode("NIGHT", 1);
        NIGHT = r101;
        TabMode r102 = new TabMode("AUTO", 2);
        AUTO = r102;
        TabMode[] r103 = {r100, r101, r102};
        f346382a = r103;
        f346383b = EnumEntriesKt.enumEntries(r103);
    }

    public static TabMode[] values() {
        return (TabMode[]) f346382a.clone();
    }

    public static TabMode valueOf(String r100) {
        return (TabMode) a.a(TabMode.class, r100);
    }

    public TabMode(String r100, int r101) {
        super(r100, r101);
    }
}
