package com.bytedance.ee.bear.contract.offline;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum OfflineDocsPriority extends Enum<OfflineDocsPriority> {
    public static final OfflineDocsPriority High_Priority = null;
    public static final OfflineDocsPriority Low_Priority = null;
    public static final OfflineDocsPriority Middle_Priority = null;
    public static final /* synthetic */ OfflineDocsPriority[] a = null;

    static {
        OfflineDocsPriority r0 = new OfflineDocsPriority("High_Priority", 0);
        High_Priority = r0;
        OfflineDocsPriority r1 = new OfflineDocsPriority("Middle_Priority", 1);
        Middle_Priority = r1;
        OfflineDocsPriority r3 = new OfflineDocsPriority("Low_Priority", 2);
        Low_Priority = r3;
        a = new OfflineDocsPriority[]{r0, r1, r3};
    }

    public static OfflineDocsPriority[] values() {
        return (OfflineDocsPriority[]) a.clone();
    }

    public static OfflineDocsPriority parsePriority(String r1) {
        if (r1 != null) goto L6;
        return Middle_Priority;
    L6:
        if (r1.equals("low") == true) goto L14;
        if (r1.equals("high") == true) goto L12;
        return Middle_Priority;
    L12:
        return High_Priority;
    L14:
        return Low_Priority;
    }

    public static OfflineDocsPriority valueOf(String r1) {
        return (OfflineDocsPriority) a.a(OfflineDocsPriority.class, r1);
    }

    public OfflineDocsPriority(String r1, int r2) {
        super(r1, r2);
    }
}
