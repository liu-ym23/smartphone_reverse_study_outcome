package com.larus.disk.api;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/larus/disk/api/ManualCacheCleanError;", "", "code", "", "reason", "stage", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getReason", "getStage", UserProfileEvent.POSITION_NONE, "SERVICE_UNAVAILABLE", "FEATURE_DISABLED", "TASK_RUNNING", "ACCOUNT_CHANGED", "APP_FOREGROUND", "ROOT_CACHE_DELETE_FAILED", "CONFIGURED_PATH_DELETE_FAILED", "BUSINESS_HANDLER_FAILED", "MULTIPLE_COMPONENTS_FAILED", "REMAINING_CACHE", "SIZE_QUERY_FAILED", "EXECUTION_FAILED", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ManualCacheCleanError extends Enum<ManualCacheCleanError> {
    public static final ManualCacheCleanError ACCOUNT_CHANGED = null;
    public static final ManualCacheCleanError APP_FOREGROUND = null;
    public static final ManualCacheCleanError BUSINESS_HANDLER_FAILED = null;
    public static final ManualCacheCleanError CONFIGURED_PATH_DELETE_FAILED = null;
    public static final ManualCacheCleanError EXECUTION_FAILED = null;
    public static final ManualCacheCleanError FEATURE_DISABLED = null;
    public static final ManualCacheCleanError MULTIPLE_COMPONENTS_FAILED = null;
    public static final ManualCacheCleanError NONE = null;
    public static final ManualCacheCleanError REMAINING_CACHE = null;
    public static final ManualCacheCleanError ROOT_CACHE_DELETE_FAILED = null;
    public static final ManualCacheCleanError SERVICE_UNAVAILABLE = null;
    public static final ManualCacheCleanError SIZE_QUERY_FAILED = null;
    public static final ManualCacheCleanError TASK_RUNNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ManualCacheCleanError[] f330515a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f330516b = null;
    private final String code;
    private final String reason;
    private final String stage;

    public static EnumEntries<ManualCacheCleanError> getEntries() {
        return f330516b;
    }

    static {
        ManualCacheCleanError r100 = new ManualCacheCleanError(UserProfileEvent.POSITION_NONE, 0, "none", "none", "none");
        NONE = r100;
        ManualCacheCleanError r101 = new ManualCacheCleanError("SERVICE_UNAVAILABLE", 1, "service_unavailable", "disk clean service is unavailable", "precheck");
        SERVICE_UNAVAILABLE = r101;
        ManualCacheCleanError r102 = new ManualCacheCleanError("FEATURE_DISABLED", 2, "feature_disabled", "manual disk clean is disabled", "precheck");
        FEATURE_DISABLED = r102;
        ManualCacheCleanError r103 = new ManualCacheCleanError("TASK_RUNNING", 3, "task_running", "another disk clean task is running", "precheck");
        TASK_RUNNING = r103;
        ManualCacheCleanError r104 = new ManualCacheCleanError("ACCOUNT_CHANGED", 4, "account_changed", "account changed before disk clean finished", "precheck");
        ACCOUNT_CHANGED = r104;
        ManualCacheCleanError r105 = new ManualCacheCleanError("APP_FOREGROUND", 5, "app_foreground", "automatic disk clean stopped in foreground", "precheck");
        APP_FOREGROUND = r105;
        ManualCacheCleanError r106 = new ManualCacheCleanError("ROOT_CACHE_DELETE_FAILED", 6, "root_cache_delete_failed", "one or more root cache entries could not be deleted", "root_cache");
        ROOT_CACHE_DELETE_FAILED = r106;
        ManualCacheCleanError r110 = new ManualCacheCleanError("CONFIGURED_PATH_DELETE_FAILED", 7, "configured_path_delete_failed", "one or more configured cache paths could not be deleted", "configured_path");
        CONFIGURED_PATH_DELETE_FAILED = r110;
        ManualCacheCleanError r107 = new ManualCacheCleanError("BUSINESS_HANDLER_FAILED", 8, "business_handler_failed", "one or more business cache handlers did not finish cleanly", "business_handler");
        BUSINESS_HANDLER_FAILED = r107;
        ManualCacheCleanError r108 = new ManualCacheCleanError("MULTIPLE_COMPONENTS_FAILED", 9, "multiple_components_failed", "multiple cache cleaning components failed", "execution");
        MULTIPLE_COMPONENTS_FAILED = r108;
        ManualCacheCleanError r109 = new ManualCacheCleanError("REMAINING_CACHE", 10, "remaining_cleanable_cache", "cleanable cache remained after execution", "verification");
        REMAINING_CACHE = r109;
        ManualCacheCleanError r111 = new ManualCacheCleanError("SIZE_QUERY_FAILED", 11, "size_query_failed", "cleanable cache size query failed", "verification");
        SIZE_QUERY_FAILED = r111;
        ManualCacheCleanError r112 = new ManualCacheCleanError("EXECUTION_FAILED", 12, "execution_failed", "disk clean execution failed", "execution");
        EXECUTION_FAILED = r112;
        ManualCacheCleanError[] r113 = {r100, r101, r102, r103, r104, r105, r106, r110, r107, r108, r109, r111, r112};
        f330515a = r113;
        f330516b = EnumEntriesKt.enumEntries(r113);
    }

    public static ManualCacheCleanError[] values() {
        return (ManualCacheCleanError[]) f330515a.clone();
    }

    public final String getCode() {
        return this.code;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getStage() {
        return this.stage;
    }

    public static ManualCacheCleanError valueOf(String r100) {
        return (ManualCacheCleanError) r27.a.a(ManualCacheCleanError.class, r100);
    }

    public ManualCacheCleanError(String r100, int r101, String r102, String r103, String r104) {
        super(r100, r101);
        this.code = r102;
        this.reason = r103;
        this.stage = r104;
    }
}
