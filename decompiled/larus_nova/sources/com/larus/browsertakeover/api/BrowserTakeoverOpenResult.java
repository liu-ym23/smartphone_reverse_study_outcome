package com.larus.browsertakeover.api;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/browsertakeover/api/BrowserTakeoverOpenResult;", "", "<init>", "(Ljava/lang/String;I)V", EventConstant.Event.EVENT_NFC_OPENED, "REUSED", "ACTIVITY_UNAVAILABLE", "EXPERIMENT_DISABLED", "TARGET_DISABLED", "INVALID_REQUEST", "SESSION_BUSY", "PAGE_OPEN_FAILED", "SERVICE_UNAVAILABLE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BrowserTakeoverOpenResult extends Enum<BrowserTakeoverOpenResult> {
    public static final BrowserTakeoverOpenResult ACTIVITY_UNAVAILABLE = null;
    public static final BrowserTakeoverOpenResult EXPERIMENT_DISABLED = null;
    public static final BrowserTakeoverOpenResult INVALID_REQUEST = null;
    public static final BrowserTakeoverOpenResult OPENED = null;
    public static final BrowserTakeoverOpenResult PAGE_OPEN_FAILED = null;
    public static final BrowserTakeoverOpenResult REUSED = null;
    public static final BrowserTakeoverOpenResult SERVICE_UNAVAILABLE = null;
    public static final BrowserTakeoverOpenResult SESSION_BUSY = null;
    public static final BrowserTakeoverOpenResult TARGET_DISABLED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BrowserTakeoverOpenResult[] f319378a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f319379b = null;

    public static EnumEntries<BrowserTakeoverOpenResult> getEntries() {
        return f319379b;
    }

    static {
        BrowserTakeoverOpenResult r100 = new BrowserTakeoverOpenResult(EventConstant.Event.EVENT_NFC_OPENED, 0);
        OPENED = r100;
        BrowserTakeoverOpenResult r101 = new BrowserTakeoverOpenResult("REUSED", 1);
        REUSED = r101;
        BrowserTakeoverOpenResult r102 = new BrowserTakeoverOpenResult("ACTIVITY_UNAVAILABLE", 2);
        ACTIVITY_UNAVAILABLE = r102;
        BrowserTakeoverOpenResult r103 = new BrowserTakeoverOpenResult("EXPERIMENT_DISABLED", 3);
        EXPERIMENT_DISABLED = r103;
        BrowserTakeoverOpenResult r104 = new BrowserTakeoverOpenResult("TARGET_DISABLED", 4);
        TARGET_DISABLED = r104;
        BrowserTakeoverOpenResult r105 = new BrowserTakeoverOpenResult("INVALID_REQUEST", 5);
        INVALID_REQUEST = r105;
        BrowserTakeoverOpenResult r110 = new BrowserTakeoverOpenResult("SESSION_BUSY", 6);
        SESSION_BUSY = r110;
        BrowserTakeoverOpenResult r111 = new BrowserTakeoverOpenResult("PAGE_OPEN_FAILED", 7);
        PAGE_OPEN_FAILED = r111;
        BrowserTakeoverOpenResult r112 = new BrowserTakeoverOpenResult("SERVICE_UNAVAILABLE", 8);
        SERVICE_UNAVAILABLE = r112;
        BrowserTakeoverOpenResult[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f319378a = r113;
        f319379b = EnumEntriesKt.enumEntries(r113);
    }

    public static BrowserTakeoverOpenResult[] values() {
        return (BrowserTakeoverOpenResult[]) f319378a.clone();
    }

    public static BrowserTakeoverOpenResult valueOf(String r100) {
        return (BrowserTakeoverOpenResult) a.a(BrowserTakeoverOpenResult.class, r100);
    }

    public BrowserTakeoverOpenResult(String r100, int r101) {
        super(r100, r101);
    }
}
