package com.xiaomi.push.service.module;

import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum PushChannelRegion extends Enum<PushChannelRegion> {
    private static final /* synthetic */ PushChannelRegion[] $VALUES = null;
    public static final PushChannelRegion China = null;
    public static final PushChannelRegion Europe = null;
    public static final PushChannelRegion Global = null;
    public static final PushChannelRegion India = null;
    public static final PushChannelRegion Russia = null;

    static {
        PushChannelRegion r100 = new PushChannelRegion("China", 0);
        China = r100;
        PushChannelRegion r101 = new PushChannelRegion("Global", 1);
        Global = r101;
        PushChannelRegion r102 = new PushChannelRegion("Europe", 2);
        Europe = r102;
        PushChannelRegion r103 = new PushChannelRegion("Russia", 3);
        Russia = r103;
        PushChannelRegion r104 = new PushChannelRegion("India", 4);
        India = r104;
        $VALUES = new PushChannelRegion[]{r100, r101, r102, r103, r104};
    }

    public static PushChannelRegion[] values() {
        return (PushChannelRegion[]) $VALUES.clone();
    }

    public static PushChannelRegion valueOf(String r100) {
        return (PushChannelRegion) a.a(PushChannelRegion.class, r100);
    }

    private PushChannelRegion(String r100, int r101) {
        super(r100, r101);
    }
}
