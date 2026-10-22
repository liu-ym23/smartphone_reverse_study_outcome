package com.bytedance.awemeopen.bizmodels.feed.preload;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/preload/AosPreloadFeedListReason;", "", "", "reason", "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", "HOST_INVOKE_PRELOAD", "SDK_ON_USER_CHANGED", "SDK_ON_EXIT_RECOMMEND_PAGE", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final enum AosPreloadFeedListReason extends Enum<AosPreloadFeedListReason> {
    public static final AosPreloadFeedListReason HOST_INVOKE_PRELOAD = null;
    public static final AosPreloadFeedListReason SDK_ON_EXIT_RECOMMEND_PAGE = null;
    public static final AosPreloadFeedListReason SDK_ON_USER_CHANGED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AosPreloadFeedListReason[] f198196a = null;
    private final String reason;

    public static AosPreloadFeedListReason valueOf(String r100) {
        return (AosPreloadFeedListReason) a.a(AosPreloadFeedListReason.class, r100);
    }

    public static AosPreloadFeedListReason[] values() {
        return (AosPreloadFeedListReason[]) f198196a.clone();
    }

    static {
        AosPreloadFeedListReason r100 = new AosPreloadFeedListReason("HOST_INVOKE_PRELOAD", 0, "host_invoke_preload");
        HOST_INVOKE_PRELOAD = r100;
        AosPreloadFeedListReason r101 = new AosPreloadFeedListReason("SDK_ON_USER_CHANGED", 1, "sdk_on_user_changed");
        SDK_ON_USER_CHANGED = r101;
        AosPreloadFeedListReason r102 = new AosPreloadFeedListReason("SDK_ON_EXIT_RECOMMEND_PAGE", 2, "sdk_on_exit_recommend_page");
        SDK_ON_EXIT_RECOMMEND_PAGE = r102;
        f198196a = new AosPreloadFeedListReason[]{r100, r101, r102};
    }

    public final String getReason() {
        return this.reason;
    }

    public AosPreloadFeedListReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.reason = r102;
    }
}
