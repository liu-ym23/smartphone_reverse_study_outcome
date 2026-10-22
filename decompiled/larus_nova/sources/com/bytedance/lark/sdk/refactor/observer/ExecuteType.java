package com.bytedance.lark.sdk.refactor.observer;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/lark/sdk/refactor/observer/ExecuteType;", "", "<init>", "(Ljava/lang/String;I)V", "BEFORE_EXECUTE", "EXECUTE_SUCCESS", "EXECUTE_FAILED", "rust-jvm_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ExecuteType extends Enum<ExecuteType> {
    public static final ExecuteType BEFORE_EXECUTE = null;
    public static final ExecuteType EXECUTE_FAILED = null;
    public static final ExecuteType EXECUTE_SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExecuteType[] f254273a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f254274b = null;

    public static EnumEntries<ExecuteType> getEntries() {
        return f254274b;
    }

    static {
        ExecuteType r100 = new ExecuteType("BEFORE_EXECUTE", 0);
        BEFORE_EXECUTE = r100;
        ExecuteType r101 = new ExecuteType("EXECUTE_SUCCESS", 1);
        EXECUTE_SUCCESS = r101;
        ExecuteType r102 = new ExecuteType("EXECUTE_FAILED", 2);
        EXECUTE_FAILED = r102;
        ExecuteType[] r103 = {r100, r101, r102};
        f254273a = r103;
        f254274b = EnumEntriesKt.enumEntries(r103);
    }

    public static ExecuteType[] values() {
        return (ExecuteType[]) f254273a.clone();
    }

    public static ExecuteType valueOf(String r100) {
        return (ExecuteType) a.a(ExecuteType.class, r100);
    }

    public ExecuteType(String r100, int r101) {
        super(r100, r101);
    }
}
