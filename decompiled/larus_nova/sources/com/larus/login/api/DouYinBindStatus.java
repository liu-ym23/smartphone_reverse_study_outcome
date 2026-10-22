package com.larus.login.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/login/api/DouYinBindStatus;", "", "<init>", "(Ljava/lang/String;I)V", "ALREADY_BOUND", "SUCCESS", "FAILURE", "CANCEL", "GO_MARKET", "GO_ACCOUNT", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DouYinBindStatus extends Enum<DouYinBindStatus> {
    public static final DouYinBindStatus ALREADY_BOUND = null;
    public static final DouYinBindStatus CANCEL = null;
    public static final DouYinBindStatus FAILURE = null;
    public static final DouYinBindStatus GO_ACCOUNT = null;
    public static final DouYinBindStatus GO_MARKET = null;
    public static final DouYinBindStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DouYinBindStatus[] f356978a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f356979b = null;

    public static EnumEntries<DouYinBindStatus> getEntries() {
        return f356979b;
    }

    static {
        DouYinBindStatus r100 = new DouYinBindStatus("ALREADY_BOUND", 0);
        ALREADY_BOUND = r100;
        DouYinBindStatus r101 = new DouYinBindStatus("SUCCESS", 1);
        SUCCESS = r101;
        DouYinBindStatus r102 = new DouYinBindStatus("FAILURE", 2);
        FAILURE = r102;
        DouYinBindStatus r103 = new DouYinBindStatus("CANCEL", 3);
        CANCEL = r103;
        DouYinBindStatus r104 = new DouYinBindStatus("GO_MARKET", 4);
        GO_MARKET = r104;
        DouYinBindStatus r105 = new DouYinBindStatus("GO_ACCOUNT", 5);
        GO_ACCOUNT = r105;
        DouYinBindStatus[] r110 = {r100, r101, r102, r103, r104, r105};
        f356978a = r110;
        f356979b = EnumEntriesKt.enumEntries(r110);
    }

    public static DouYinBindStatus[] values() {
        return (DouYinBindStatus[]) f356978a.clone();
    }

    public static DouYinBindStatus valueOf(String r100) {
        return (DouYinBindStatus) r27.a.a(DouYinBindStatus.class, r100);
    }

    public DouYinBindStatus(String r100, int r101) {
        super(r100, r101);
    }
}
