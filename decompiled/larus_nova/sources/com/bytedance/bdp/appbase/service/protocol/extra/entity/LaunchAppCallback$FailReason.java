package com.bytedance.bdp.appbase.service.protocol.extra.entity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"com/bytedance/bdp/appbase/service/protocol/extra/entity/LaunchAppCallback$FailReason", "", "Lcom/bytedance/bdp/appbase/service/protocol/extra/entity/LaunchAppCallback$FailReason;", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "NO_SUCH_APP", "LAUNCH_FAILED", "EXCEPTION_OCCURRED", "bdp-appbase-ext_release"}, k = 1, mv = {1, 4, 0})
public final enum LaunchAppCallback$FailReason extends Enum<LaunchAppCallback$FailReason> {
    public static final LaunchAppCallback$FailReason EXCEPTION_OCCURRED = null;
    public static final LaunchAppCallback$FailReason LAUNCH_FAILED = null;
    public static final LaunchAppCallback$FailReason NO_SUCH_APP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LaunchAppCallback$FailReason[] f200963a = null;
    private final String value;

    static {
        LaunchAppCallback$FailReason r100 = new LaunchAppCallback$FailReason("NO_SUCH_APP", 0, "noSuchApp");
        NO_SUCH_APP = r100;
        LaunchAppCallback$FailReason r101 = new LaunchAppCallback$FailReason("LAUNCH_FAILED", 1, "launchFailed");
        LAUNCH_FAILED = r101;
        LaunchAppCallback$FailReason r102 = new LaunchAppCallback$FailReason("EXCEPTION_OCCURRED", 2, "exceptionOccurred");
        EXCEPTION_OCCURRED = r102;
        f200963a = new LaunchAppCallback$FailReason[]{r100, r101, r102};
    }

    public static LaunchAppCallback$FailReason valueOf(String r100) {
        return (LaunchAppCallback$FailReason) a.a(LaunchAppCallback$FailReason.class, r100);
    }

    public static LaunchAppCallback$FailReason[] values() {
        return (LaunchAppCallback$FailReason[]) f200963a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public LaunchAppCallback$FailReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
