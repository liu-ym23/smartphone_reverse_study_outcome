package com.bytedance.locallife.cube.impl;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/locallife/cube/impl/OperationType;", "", "OPERATION_PRE_CREATE", "OPERATION_PRE_LOAD", "OPERATION_GET_DELEGATE", "OPERATION_GET_PRELOADED_DELEGATE", "OPERATION_GET_PRE_CREATED_DELEGATE", "cube-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum OperationType extends Enum<OperationType> {
    public static final OperationType OPERATION_GET_DELEGATE = null;
    public static final OperationType OPERATION_GET_PRELOADED_DELEGATE = null;
    public static final OperationType OPERATION_GET_PRE_CREATED_DELEGATE = null;
    public static final OperationType OPERATION_PRE_CREATE = null;
    public static final OperationType OPERATION_PRE_LOAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OperationType[] f257229a = null;

    public static OperationType valueOf(String r100) {
        return (OperationType) r27.a.a(OperationType.class, r100);
    }

    public static OperationType[] values() {
        return (OperationType[]) f257229a.clone();
    }

    static {
        OperationType r100 = new OperationType("OPERATION_PRE_CREATE", 0);
        OPERATION_PRE_CREATE = r100;
        OperationType r101 = new OperationType("OPERATION_PRE_LOAD", 1);
        OPERATION_PRE_LOAD = r101;
        OperationType r102 = new OperationType("OPERATION_GET_DELEGATE", 2);
        OPERATION_GET_DELEGATE = r102;
        OperationType r103 = new OperationType("OPERATION_GET_PRELOADED_DELEGATE", 3);
        OPERATION_GET_PRELOADED_DELEGATE = r103;
        OperationType r104 = new OperationType("OPERATION_GET_PRE_CREATED_DELEGATE", 4);
        OPERATION_GET_PRE_CREATED_DELEGATE = r104;
        f257229a = new OperationType[]{r100, r101, r102, r103, r104};
    }

    public OperationType(String r100, int r101) {
        super(r100, r101);
    }
}
