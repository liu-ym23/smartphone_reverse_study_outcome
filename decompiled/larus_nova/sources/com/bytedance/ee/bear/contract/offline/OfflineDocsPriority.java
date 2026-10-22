package com.bytedance.ee.bear.contract.offline;

import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final enum OfflineDocsPriority extends Enum<OfflineDocsPriority> {
    public static final OfflineDocsPriority High_Priority = null;
    public static final OfflineDocsPriority Low_Priority = null;
    public static final OfflineDocsPriority Middle_Priority = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfflineDocsPriority[] f217121a = null;

    static {
        OfflineDocsPriority r100 = new OfflineDocsPriority("High_Priority", 0);
        High_Priority = r100;
        OfflineDocsPriority r101 = new OfflineDocsPriority("Middle_Priority", 1);
        Middle_Priority = r101;
        OfflineDocsPriority r102 = new OfflineDocsPriority("Low_Priority", 2);
        Low_Priority = r102;
        f217121a = new OfflineDocsPriority[]{r100, r101, r102};
    }

    public static OfflineDocsPriority[] values() {
        return (OfflineDocsPriority[]) f217121a.clone();
    }

    public static OfflineDocsPriority parsePriority(String r100) {
        if (r100 != null) goto L6;
        return Middle_Priority;
    L6:
        if (r100.equals("low") == true) goto L14;
        if (r100.equals("high") == true) goto L12;
        return Middle_Priority;
    L12:
        return High_Priority;
    L14:
        return Low_Priority;
    }

    public static OfflineDocsPriority valueOf(String r100) {
        return (OfflineDocsPriority) a.a(OfflineDocsPriority.class, r100);
    }

    public OfflineDocsPriority(String r100, int r101) {
        super(r100, r101);
    }
}
