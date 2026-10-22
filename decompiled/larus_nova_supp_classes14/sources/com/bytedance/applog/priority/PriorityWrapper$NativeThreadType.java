package com.bytedance.applog.priority;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final enum PriorityWrapper$NativeThreadType extends Enum<PriorityWrapper$NativeThreadType> {
    public static final PriorityWrapper$NativeThreadType Android = null;
    public static final PriorityWrapper$NativeThreadType Native = null;
    public static final /* synthetic */ PriorityWrapper$NativeThreadType[] a = null;
    private final int value;

    static {
        PriorityWrapper$NativeThreadType r0 = new PriorityWrapper$NativeThreadType("Native", 0, 0);
        Native = r0;
        PriorityWrapper$NativeThreadType r1 = new PriorityWrapper$NativeThreadType("Android", 1, 1);
        Android = r1;
        a = new PriorityWrapper$NativeThreadType[]{r0, r1};
    }

    public static PriorityWrapper$NativeThreadType[] values() {
        return (PriorityWrapper$NativeThreadType[]) a.clone();
    }

    public static /* synthetic */ int access$000(PriorityWrapper$NativeThreadType r0) {
        return r0.value;
    }

    public static PriorityWrapper$NativeThreadType valueOf(String r1) {
        return (PriorityWrapper$NativeThreadType) a.a(PriorityWrapper$NativeThreadType.class, r1);
    }

    public PriorityWrapper$NativeThreadType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
