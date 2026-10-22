package com.larus.account.saas.runtime.depend;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/account/saas/runtime/depend/ToastType;", "", "INFO", "SUCCESS", "WARNING", "FAILURE", "LOADING", "account-saas-runtime_release"}, k = 1, mv = {1, 7, 1})
public final enum ToastType extends Enum<ToastType> {
    public static final ToastType FAILURE = null;
    public static final ToastType INFO = null;
    public static final ToastType LOADING = null;
    public static final ToastType SUCCESS = null;
    public static final ToastType WARNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ToastType[] f286459a = null;

    public static ToastType valueOf(String r100) {
        return (ToastType) a.a(ToastType.class, r100);
    }

    public static ToastType[] values() {
        return (ToastType[]) f286459a.clone();
    }

    static {
        ToastType r100 = new ToastType("INFO", 0);
        INFO = r100;
        ToastType r101 = new ToastType("SUCCESS", 1);
        SUCCESS = r101;
        ToastType r102 = new ToastType("WARNING", 2);
        WARNING = r102;
        ToastType r103 = new ToastType("FAILURE", 3);
        FAILURE = r103;
        ToastType r104 = new ToastType("LOADING", 4);
        LOADING = r104;
        f286459a = new ToastType[]{r100, r101, r102, r103, r104};
    }

    public ToastType(String r100, int r101) {
        super(r100, r101);
    }
}
