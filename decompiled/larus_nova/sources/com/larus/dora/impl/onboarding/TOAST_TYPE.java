package com.larus.dora.impl.onboarding;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/onboarding/TOAST_TYPE;", "", "<init>", "(Ljava/lang/String;I)V", "TOAST_TYPE_ERROR", "TOAST_TYPE_SUCCESS", "TOAST_TYPE_WARNING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TOAST_TYPE extends Enum<TOAST_TYPE> {
    public static final TOAST_TYPE TOAST_TYPE_ERROR = null;
    public static final TOAST_TYPE TOAST_TYPE_SUCCESS = null;
    public static final TOAST_TYPE TOAST_TYPE_WARNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TOAST_TYPE[] f336602a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f336603b = null;

    public static EnumEntries<TOAST_TYPE> getEntries() {
        return f336603b;
    }

    static {
        TOAST_TYPE r100 = new TOAST_TYPE("TOAST_TYPE_ERROR", 0);
        TOAST_TYPE_ERROR = r100;
        TOAST_TYPE r101 = new TOAST_TYPE("TOAST_TYPE_SUCCESS", 1);
        TOAST_TYPE_SUCCESS = r101;
        TOAST_TYPE r102 = new TOAST_TYPE("TOAST_TYPE_WARNING", 2);
        TOAST_TYPE_WARNING = r102;
        TOAST_TYPE[] r103 = {r100, r101, r102};
        f336602a = r103;
        f336603b = EnumEntriesKt.enumEntries(r103);
    }

    public static TOAST_TYPE[] values() {
        return (TOAST_TYPE[]) f336602a.clone();
    }

    public static TOAST_TYPE valueOf(String r100) {
        return (TOAST_TYPE) r27.a.a(TOAST_TYPE.class, r100);
    }

    public TOAST_TYPE(String r100, int r101) {
        super(r100, r101);
    }
}
