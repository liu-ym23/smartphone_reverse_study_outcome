package com.larus.multitask_management.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/multitask_management/api/CancelFrom;", "", "<init>", "(Ljava/lang/String;I)V", "UPDATE", "MANUAL", "EXCEED_LIMIT", "KEEP_TIMEOUT", "TIMEOUT", "REPLACE", "multitask_management_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CancelFrom extends Enum<CancelFrom> {
    public static final CancelFrom EXCEED_LIMIT = null;
    public static final CancelFrom KEEP_TIMEOUT = null;
    public static final CancelFrom MANUAL = null;
    public static final CancelFrom REPLACE = null;
    public static final CancelFrom TIMEOUT = null;
    public static final CancelFrom UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CancelFrom[] f359369a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f359370b = null;

    public static EnumEntries<CancelFrom> getEntries() {
        return f359370b;
    }

    static {
        CancelFrom r100 = new CancelFrom("UPDATE", 0);
        UPDATE = r100;
        CancelFrom r101 = new CancelFrom("MANUAL", 1);
        MANUAL = r101;
        CancelFrom r102 = new CancelFrom("EXCEED_LIMIT", 2);
        EXCEED_LIMIT = r102;
        CancelFrom r103 = new CancelFrom("KEEP_TIMEOUT", 3);
        KEEP_TIMEOUT = r103;
        CancelFrom r104 = new CancelFrom("TIMEOUT", 4);
        TIMEOUT = r104;
        CancelFrom r105 = new CancelFrom("REPLACE", 5);
        REPLACE = r105;
        CancelFrom[] r110 = {r100, r101, r102, r103, r104, r105};
        f359369a = r110;
        f359370b = EnumEntriesKt.enumEntries(r110);
    }

    public static CancelFrom[] values() {
        return (CancelFrom[]) f359369a.clone();
    }

    public static CancelFrom valueOf(String r100) {
        return (CancelFrom) a.a(CancelFrom.class, r100);
    }

    public CancelFrom(String r100, int r101) {
        super(r100, r101);
    }
}
