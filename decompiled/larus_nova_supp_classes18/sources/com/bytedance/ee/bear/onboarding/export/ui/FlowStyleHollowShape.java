package com.bytedance.ee.bear.onboarding.export.ui;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum FlowStyleHollowShape extends Enum<FlowStyleHollowShape> {
    public static final FlowStyleHollowShape Capsule = null;
    public static final FlowStyleHollowShape Circle = null;
    public static final FlowStyleHollowShape CustomRadius = null;
    public static final FlowStyleHollowShape None = null;
    public static final FlowStyleHollowShape RoundedRect = null;
    public static final /* synthetic */ FlowStyleHollowShape[] a = null;

    static {
        FlowStyleHollowShape r0 = new FlowStyleHollowShape("Circle", 0);
        Circle = r0;
        FlowStyleHollowShape r1 = new FlowStyleHollowShape("Capsule", 1);
        Capsule = r1;
        FlowStyleHollowShape r3 = new FlowStyleHollowShape("RoundedRect", 2);
        RoundedRect = r3;
        FlowStyleHollowShape r5 = new FlowStyleHollowShape("CustomRadius", 3);
        CustomRadius = r5;
        FlowStyleHollowShape r7 = new FlowStyleHollowShape("None", 4);
        None = r7;
        a = new FlowStyleHollowShape[]{r0, r1, r3, r5, r7};
    }

    public static FlowStyleHollowShape[] values() {
        return (FlowStyleHollowShape[]) a.clone();
    }

    public static FlowStyleHollowShape valueOf(String r1) {
        return (FlowStyleHollowShape) a.a(FlowStyleHollowShape.class, r1);
    }

    public FlowStyleHollowShape(String r1, int r2) {
        super(r1, r2);
    }
}
