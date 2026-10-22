package com.bytedance.ug.sdk.luckydog.api.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ug/sdk/luckydog/api/model/TaskCacheClearCase;", "", "", "value", "I", "getValue", "()I", "CASE_VALID_EXPIRE", "CASE_CACHE_EXPIRE", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final enum TaskCacheClearCase extends Enum<TaskCacheClearCase> {
    public static final TaskCacheClearCase CASE_CACHE_EXPIRE = null;
    public static final TaskCacheClearCase CASE_VALID_EXPIRE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskCacheClearCase[] f271592a = null;
    private final int value;

    static {
        TaskCacheClearCase r100 = new TaskCacheClearCase("CASE_VALID_EXPIRE", 0, 1);
        CASE_VALID_EXPIRE = r100;
        TaskCacheClearCase r101 = new TaskCacheClearCase("CASE_CACHE_EXPIRE", 1, 2);
        CASE_CACHE_EXPIRE = r101;
        f271592a = new TaskCacheClearCase[]{r100, r101};
    }

    public static TaskCacheClearCase valueOf(String r100) {
        return (TaskCacheClearCase) a.a(TaskCacheClearCase.class, r100);
    }

    public static TaskCacheClearCase[] values() {
        return (TaskCacheClearCase[]) f271592a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public TaskCacheClearCase(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
