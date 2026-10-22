package com.relax;

/* JADX INFO: loaded from: classes34.dex */
public final enum RuntimeType extends Enum<RuntimeType> {
    public static final RuntimeType RuntimeTypeNative = null;
    public static final RuntimeType RuntimeTypeVM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RuntimeType[] f404615a = null;

    static {
        RuntimeType r100 = new RuntimeType("RuntimeTypeVM", 0);
        RuntimeTypeVM = r100;
        RuntimeType r101 = new RuntimeType("RuntimeTypeNative", 1);
        RuntimeTypeNative = r101;
        f404615a = new RuntimeType[]{r100, r101};
    }

    public static RuntimeType[] values() {
        return (RuntimeType[]) f404615a.clone();
    }

    public static RuntimeType valueOf(String r100) {
        return (RuntimeType) r27.a.a(RuntimeType.class, r100);
    }

    public RuntimeType(String r100, int r101) {
        super(r100, r101);
    }
}
