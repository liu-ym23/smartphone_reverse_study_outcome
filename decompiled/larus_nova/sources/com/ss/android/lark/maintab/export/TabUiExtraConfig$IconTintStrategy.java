package com.ss.android.lark.maintab.export;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabUiExtraConfig$IconTintStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "NEVER", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TabUiExtraConfig$IconTintStrategy extends Enum<TabUiExtraConfig$IconTintStrategy> {
    public static final TabUiExtraConfig$IconTintStrategy NEVER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TabUiExtraConfig$IconTintStrategy[] f431607a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f431608b = null;

    public static EnumEntries<TabUiExtraConfig$IconTintStrategy> getEntries() {
        return f431608b;
    }

    static {
        TabUiExtraConfig$IconTintStrategy r100 = new TabUiExtraConfig$IconTintStrategy();
        NEVER = r100;
        TabUiExtraConfig$IconTintStrategy[] r101 = {r100};
        f431607a = r101;
        f431608b = EnumEntriesKt.enumEntries(r101);
    }

    public TabUiExtraConfig$IconTintStrategy() {
        super("NEVER", 0);
    }

    public static TabUiExtraConfig$IconTintStrategy[] values() {
        return (TabUiExtraConfig$IconTintStrategy[]) f431607a.clone();
    }

    public static TabUiExtraConfig$IconTintStrategy valueOf(String r100) {
        return (TabUiExtraConfig$IconTintStrategy) r27.a.a(TabUiExtraConfig$IconTintStrategy.class, r100);
    }
}
