package com.bytedance.ee.bear.onboarding.export.ui;

import r27.a;

/* JADX INFO: loaded from: classes18.dex */
public final enum FlowStyleHollowShape extends Enum<FlowStyleHollowShape> {
    public static final FlowStyleHollowShape Capsule = null;
    public static final FlowStyleHollowShape Circle = null;
    public static final FlowStyleHollowShape CustomRadius = null;
    public static final FlowStyleHollowShape None = null;
    public static final FlowStyleHollowShape RoundedRect = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowStyleHollowShape[] f236154a = null;

    static {
        FlowStyleHollowShape r100 = new FlowStyleHollowShape("Circle", 0);
        Circle = r100;
        FlowStyleHollowShape r101 = new FlowStyleHollowShape("Capsule", 1);
        Capsule = r101;
        FlowStyleHollowShape r102 = new FlowStyleHollowShape("RoundedRect", 2);
        RoundedRect = r102;
        FlowStyleHollowShape r103 = new FlowStyleHollowShape("CustomRadius", 3);
        CustomRadius = r103;
        FlowStyleHollowShape r104 = new FlowStyleHollowShape("None", 4);
        None = r104;
        f236154a = new FlowStyleHollowShape[]{r100, r101, r102, r103, r104};
    }

    public static FlowStyleHollowShape[] values() {
        return (FlowStyleHollowShape[]) f236154a.clone();
    }

    public static FlowStyleHollowShape valueOf(String r100) {
        return (FlowStyleHollowShape) a.a(FlowStyleHollowShape.class, r100);
    }

    public FlowStyleHollowShape(String r100, int r101) {
        super(r100, r101);
    }
}
