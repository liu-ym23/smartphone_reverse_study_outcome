package com.lynx.tasm.utils;

/* JADX INFO: loaded from: classes32.dex */
public final enum Value$Unit extends Enum<Value$Unit> {
    public static final Value$Unit PERCENTAGE = null;
    public static final Value$Unit PX = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Value$Unit[] f384083a = null;

    static {
        Value$Unit r100 = new Value$Unit("PX", 0);
        PX = r100;
        Value$Unit r101 = new Value$Unit("PERCENTAGE", 1);
        PERCENTAGE = r101;
        f384083a = new Value$Unit[]{r100, r101};
    }

    public static Value$Unit[] values() {
        return (Value$Unit[]) f384083a.clone();
    }

    public static Value$Unit valueOf(String r100) {
        return (Value$Unit) r27.a.a(Value$Unit.class, r100);
    }

    public Value$Unit(String r100, int r101) {
        super(r100, r101);
    }
}
