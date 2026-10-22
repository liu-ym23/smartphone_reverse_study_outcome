package com.larus.contextwindow.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/contextwindow/api/ContextWindowHiddenReason;", "", "<init>", "(Ljava/lang/String;I)V", "FEATURE_OFF", "SERVICE_UNAVAILABLE", "UNSUPPORTED_CONTAINER", "UNSUPPORTED_MODE", "MODE_UNAVAILABLE", "INVALID_CONVERSATION", "INVALID_ANCHOR", "NO_CANDIDATE", "USAGE_MISSING", "USAGE_INVALID", "USED_EMPTY", "USED_OVERFLOW", "TOTAL_MISSING", "TOTAL_INVALID", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContextWindowHiddenReason extends Enum<ContextWindowHiddenReason> {
    public static final ContextWindowHiddenReason FEATURE_OFF = null;
    public static final ContextWindowHiddenReason INVALID_ANCHOR = null;
    public static final ContextWindowHiddenReason INVALID_CONVERSATION = null;
    public static final ContextWindowHiddenReason MODE_UNAVAILABLE = null;
    public static final ContextWindowHiddenReason NO_CANDIDATE = null;
    public static final ContextWindowHiddenReason SERVICE_UNAVAILABLE = null;
    public static final ContextWindowHiddenReason TOTAL_INVALID = null;
    public static final ContextWindowHiddenReason TOTAL_MISSING = null;
    public static final ContextWindowHiddenReason UNSUPPORTED_CONTAINER = null;
    public static final ContextWindowHiddenReason UNSUPPORTED_MODE = null;
    public static final ContextWindowHiddenReason USAGE_INVALID = null;
    public static final ContextWindowHiddenReason USAGE_MISSING = null;
    public static final ContextWindowHiddenReason USED_EMPTY = null;
    public static final ContextWindowHiddenReason USED_OVERFLOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContextWindowHiddenReason[] f330240a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f330241b = null;

    public static EnumEntries<ContextWindowHiddenReason> getEntries() {
        return f330241b;
    }

    static {
        ContextWindowHiddenReason r100 = new ContextWindowHiddenReason("FEATURE_OFF", 0);
        FEATURE_OFF = r100;
        ContextWindowHiddenReason r101 = new ContextWindowHiddenReason("SERVICE_UNAVAILABLE", 1);
        SERVICE_UNAVAILABLE = r101;
        ContextWindowHiddenReason r102 = new ContextWindowHiddenReason("UNSUPPORTED_CONTAINER", 2);
        UNSUPPORTED_CONTAINER = r102;
        ContextWindowHiddenReason r103 = new ContextWindowHiddenReason("UNSUPPORTED_MODE", 3);
        UNSUPPORTED_MODE = r103;
        ContextWindowHiddenReason r104 = new ContextWindowHiddenReason("MODE_UNAVAILABLE", 4);
        MODE_UNAVAILABLE = r104;
        ContextWindowHiddenReason r105 = new ContextWindowHiddenReason("INVALID_CONVERSATION", 5);
        INVALID_CONVERSATION = r105;
        ContextWindowHiddenReason r110 = new ContextWindowHiddenReason("INVALID_ANCHOR", 6);
        INVALID_ANCHOR = r110;
        ContextWindowHiddenReason r111 = new ContextWindowHiddenReason("NO_CANDIDATE", 7);
        NO_CANDIDATE = r111;
        ContextWindowHiddenReason r112 = new ContextWindowHiddenReason("USAGE_MISSING", 8);
        USAGE_MISSING = r112;
        ContextWindowHiddenReason r113 = new ContextWindowHiddenReason("USAGE_INVALID", 9);
        USAGE_INVALID = r113;
        ContextWindowHiddenReason r114 = new ContextWindowHiddenReason("USED_EMPTY", 10);
        USED_EMPTY = r114;
        ContextWindowHiddenReason r115 = new ContextWindowHiddenReason("USED_OVERFLOW", 11);
        USED_OVERFLOW = r115;
        ContextWindowHiddenReason r106 = new ContextWindowHiddenReason("TOTAL_MISSING", 12);
        TOTAL_MISSING = r106;
        ContextWindowHiddenReason r107 = new ContextWindowHiddenReason("TOTAL_INVALID", 13);
        TOTAL_INVALID = r107;
        ContextWindowHiddenReason[] r108 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107};
        f330240a = r108;
        f330241b = EnumEntriesKt.enumEntries(r108);
    }

    public static ContextWindowHiddenReason[] values() {
        return (ContextWindowHiddenReason[]) f330240a.clone();
    }

    public static ContextWindowHiddenReason valueOf(String r100) {
        return (ContextWindowHiddenReason) r27.a.a(ContextWindowHiddenReason.class, r100);
    }

    public ContextWindowHiddenReason(String r100, int r101) {
        super(r100, r101);
    }
}
