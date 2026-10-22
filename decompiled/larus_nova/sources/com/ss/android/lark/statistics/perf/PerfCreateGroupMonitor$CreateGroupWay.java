package com.ss.android.lark.statistics.perf;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes38.dex */
public final enum PerfCreateGroupMonitor$CreateGroupWay extends Enum<PerfCreateGroupMonitor$CreateGroupWay> {
    public static final PerfCreateGroupMonitor$CreateGroupWay EXTERNAL_GROUP = null;
    public static final PerfCreateGroupMonitor$CreateGroupWay NEW_GROUP = null;
    public static final PerfCreateGroupMonitor$CreateGroupWay SINGLE_CHAT = null;
    public static final PerfCreateGroupMonitor$CreateGroupWay UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PerfCreateGroupMonitor$CreateGroupWay[] f440753a = null;
    final String value;

    static {
        PerfCreateGroupMonitor$CreateGroupWay r100 = new PerfCreateGroupMonitor$CreateGroupWay("NEW_GROUP", 0, "new_group");
        NEW_GROUP = r100;
        PerfCreateGroupMonitor$CreateGroupWay r101 = new PerfCreateGroupMonitor$CreateGroupWay("SINGLE_CHAT", 1, "single_chat_to_group");
        SINGLE_CHAT = r101;
        PerfCreateGroupMonitor$CreateGroupWay r102 = new PerfCreateGroupMonitor$CreateGroupWay("EXTERNAL_GROUP", 2, "create_external_group");
        EXTERNAL_GROUP = r102;
        PerfCreateGroupMonitor$CreateGroupWay r103 = new PerfCreateGroupMonitor$CreateGroupWay("UNKNOWN", 3, "Unknown");
        UNKNOWN = r103;
        f440753a = new PerfCreateGroupMonitor$CreateGroupWay[]{r100, r101, r102, r103};
    }

    public static PerfCreateGroupMonitor$CreateGroupWay[] values() {
        return (PerfCreateGroupMonitor$CreateGroupWay[]) f440753a.clone();
    }

    public static PerfCreateGroupMonitor$CreateGroupWay fromValue(String r100) {
        PerfCreateGroupMonitor$CreateGroupWay[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        PerfCreateGroupMonitor$CreateGroupWay r104 = r101[r103];
        if (TextUtils.equals(r104.value, r100) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return UNKNOWN;
    }

    public static PerfCreateGroupMonitor$CreateGroupWay valueOf(String r100) {
        return (PerfCreateGroupMonitor$CreateGroupWay) r27.a.a(PerfCreateGroupMonitor$CreateGroupWay.class, r100);
    }

    public PerfCreateGroupMonitor$CreateGroupWay(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
