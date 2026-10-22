package com.bytedance.lighten.core.executor;

import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ExecutorSupplierConfig$ExecutorTransformer$ExecutorType extends Enum<ExecutorSupplierConfig$ExecutorTransformer$ExecutorType> {
    public static final ExecutorSupplierConfig$ExecutorTransformer$ExecutorType BACKGROUND = null;
    public static final ExecutorSupplierConfig$ExecutorTransformer$ExecutorType DECODE = null;
    public static final ExecutorSupplierConfig$ExecutorTransformer$ExecutorType IO = null;
    public static final ExecutorSupplierConfig$ExecutorTransformer$ExecutorType LIGHT_WEIGHT_BACKGROUND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExecutorSupplierConfig$ExecutorTransformer$ExecutorType[] f254682a = null;

    static {
        ExecutorSupplierConfig$ExecutorTransformer$ExecutorType r100 = new ExecutorSupplierConfig$ExecutorTransformer$ExecutorType("IO", 0);
        IO = r100;
        ExecutorSupplierConfig$ExecutorTransformer$ExecutorType r101 = new ExecutorSupplierConfig$ExecutorTransformer$ExecutorType("DECODE", 1);
        DECODE = r101;
        ExecutorSupplierConfig$ExecutorTransformer$ExecutorType r102 = new ExecutorSupplierConfig$ExecutorTransformer$ExecutorType("BACKGROUND", 2);
        BACKGROUND = r102;
        ExecutorSupplierConfig$ExecutorTransformer$ExecutorType r103 = new ExecutorSupplierConfig$ExecutorTransformer$ExecutorType("LIGHT_WEIGHT_BACKGROUND", 3);
        LIGHT_WEIGHT_BACKGROUND = r103;
        f254682a = new ExecutorSupplierConfig$ExecutorTransformer$ExecutorType[]{r100, r101, r102, r103};
    }

    public static ExecutorSupplierConfig$ExecutorTransformer$ExecutorType[] values() {
        return (ExecutorSupplierConfig$ExecutorTransformer$ExecutorType[]) f254682a.clone();
    }

    public static ExecutorSupplierConfig$ExecutorTransformer$ExecutorType valueOf(String r100) {
        return (ExecutorSupplierConfig$ExecutorTransformer$ExecutorType) a.a(ExecutorSupplierConfig$ExecutorTransformer$ExecutorType.class, r100);
    }

    public ExecutorSupplierConfig$ExecutorTransformer$ExecutorType(String r100, int r101) {
        super(r100, r101);
    }
}
