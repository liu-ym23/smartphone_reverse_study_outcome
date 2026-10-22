package com.bytedance.ee.lark.infra.network.ref.entity;

import com.larus.platform.model.upload.ResourceUploadError;
import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum ECOTaskState extends Enum<ECOTaskState> implements Serializable {
    public static final ECOTaskState TASK_CANCELED = null;
    public static final ECOTaskState TASK_EXECUTED = null;
    public static final ECOTaskState TASK_INIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECOTaskState[] f242808a = null;
    private String state;

    static {
        ECOTaskState r100 = new ECOTaskState("TASK_INIT", 0, "init");
        TASK_INIT = r100;
        ECOTaskState r101 = new ECOTaskState("TASK_EXECUTED", 1, "executed");
        TASK_EXECUTED = r101;
        ECOTaskState r102 = new ECOTaskState("TASK_CANCELED", 2, ResourceUploadError.CANCELED);
        TASK_CANCELED = r102;
        f242808a = new ECOTaskState[]{r100, r101, r102};
    }

    public static ECOTaskState[] values() {
        return (ECOTaskState[]) f242808a.clone();
    }

    public String getState() {
        return this.state;
    }

    public static ECOTaskState valueOf(String r100) {
        return (ECOTaskState) a.a(ECOTaskState.class, r100);
    }

    public ECOTaskState(String r100, int r101, String r102) {
        super(r100, r101);
        this.state = r102;
    }
}
