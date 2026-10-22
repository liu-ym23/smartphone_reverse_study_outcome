package com.bytedance.navigation.kmp.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/navigation/kmp/data/NavigationTraceLevel;", "", "<init>", "(Ljava/lang/String;I)V", "INFO", "WARNING", "ERROR", "bdnavigation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum NavigationTraceLevel extends Enum<NavigationTraceLevel> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ NavigationTraceLevel[] $VALUES = null;
    public static final NavigationTraceLevel ERROR = null;
    public static final NavigationTraceLevel INFO = null;
    public static final NavigationTraceLevel WARNING = null;

    public static EnumEntries<NavigationTraceLevel> getEntries() {
        return $ENTRIES;
    }

    static {
        NavigationTraceLevel r100 = new NavigationTraceLevel("INFO", 0);
        INFO = r100;
        NavigationTraceLevel r101 = new NavigationTraceLevel("WARNING", 1);
        WARNING = r101;
        NavigationTraceLevel r102 = new NavigationTraceLevel("ERROR", 2);
        ERROR = r102;
        NavigationTraceLevel[] r103 = {r100, r101, r102};
        $VALUES = r103;
        $ENTRIES = EnumEntriesKt.enumEntries(r103);
    }

    public static NavigationTraceLevel[] values() {
        return (NavigationTraceLevel[]) $VALUES.clone();
    }

    public static NavigationTraceLevel valueOf(String r100) {
        return (NavigationTraceLevel) a.a(NavigationTraceLevel.class, r100);
    }

    public NavigationTraceLevel(String r100, int r101) {
        super(r100, r101);
    }
}
