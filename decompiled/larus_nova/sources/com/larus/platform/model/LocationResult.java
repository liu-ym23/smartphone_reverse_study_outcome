package com.larus.platform.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/larus/platform/model/LocationResult;", "", "message", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "SUCCESS", "NO_PERMISSION", "NOT_INITIALIZED", "SDK_INTERNAL_ERROR", "NOT_SUPPORT_CONTINUOUS", "NO_IMPL_MODULE", "REACH_LIMITATION", "INTERVAL_NOT_REACH", "NO_GPS", "TIME_OUT", "NO_DATA", "STOP_POLL_IN_BACKGROUND", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LocationResult extends Enum<LocationResult> {
    public static final LocationResult INTERVAL_NOT_REACH = null;
    public static final LocationResult NOT_INITIALIZED = null;
    public static final LocationResult NOT_SUPPORT_CONTINUOUS = null;
    public static final LocationResult NO_DATA = null;
    public static final LocationResult NO_GPS = null;
    public static final LocationResult NO_IMPL_MODULE = null;
    public static final LocationResult NO_PERMISSION = null;
    public static final LocationResult REACH_LIMITATION = null;
    public static final LocationResult SDK_INTERNAL_ERROR = null;
    public static final LocationResult STOP_POLL_IN_BACKGROUND = null;
    public static final LocationResult SUCCESS = null;
    public static final LocationResult TIME_OUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LocationResult[] f365467a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365468b = null;
    private final String message;

    public static EnumEntries<LocationResult> getEntries() {
        return f365468b;
    }

    static {
        LocationResult r100 = new LocationResult("SUCCESS", 0, "success");
        SUCCESS = r100;
        LocationResult r101 = new LocationResult("NO_PERMISSION", 1, "no_permission");
        NO_PERMISSION = r101;
        LocationResult r102 = new LocationResult("NOT_INITIALIZED", 2, "not_initialized");
        NOT_INITIALIZED = r102;
        LocationResult r103 = new LocationResult("SDK_INTERNAL_ERROR", 3, "sdk_internal_error");
        SDK_INTERNAL_ERROR = r103;
        LocationResult r104 = new LocationResult("NOT_SUPPORT_CONTINUOUS", 4, "not_support_continuous");
        NOT_SUPPORT_CONTINUOUS = r104;
        LocationResult r105 = new LocationResult("NO_IMPL_MODULE", 5, "no_impl_module");
        NO_IMPL_MODULE = r105;
        LocationResult r110 = new LocationResult("REACH_LIMITATION", 6, "reach_limitation");
        REACH_LIMITATION = r110;
        LocationResult r111 = new LocationResult("INTERVAL_NOT_REACH", 7, "interval_not_reach");
        INTERVAL_NOT_REACH = r111;
        LocationResult r112 = new LocationResult("NO_GPS", 8, "no_gps");
        NO_GPS = r112;
        LocationResult r113 = new LocationResult("TIME_OUT", 9, "time_out");
        TIME_OUT = r113;
        LocationResult r114 = new LocationResult("NO_DATA", 10, "no_data");
        NO_DATA = r114;
        LocationResult r106 = new LocationResult("STOP_POLL_IN_BACKGROUND", 11, "stop_poll_in_background");
        STOP_POLL_IN_BACKGROUND = r106;
        LocationResult[] r107 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106};
        f365467a = r107;
        f365468b = EnumEntriesKt.enumEntries(r107);
    }

    public static LocationResult[] values() {
        return (LocationResult[]) f365467a.clone();
    }

    public final String getMessage() {
        return this.message;
    }

    public static LocationResult valueOf(String r100) {
        return (LocationResult) a.a(LocationResult.class, r100);
    }

    public LocationResult(String r100, int r101, String r102) {
        super(r100, r101);
        this.message = r102;
    }
}
