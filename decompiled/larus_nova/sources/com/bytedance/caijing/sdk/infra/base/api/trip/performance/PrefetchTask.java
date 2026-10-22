package com.bytedance.caijing.sdk.infra.base.api.trip.performance;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/trip/performance/PrefetchTask;", "", "", "task", "Ljava/lang/String;", "getTask", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, UserProfileEvent.POSITION_NONE, "PREFETCH_FE_RES", "PREFETCH_HOME_PAGE_REQUEST", "PRERENDER_AMAP", "PREFETCH_ALL", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public final enum PrefetchTask extends Enum<PrefetchTask> {
    public static final a Companion = null;
    public static final PrefetchTask NONE = null;
    public static final PrefetchTask PREFETCH_ALL = null;
    public static final PrefetchTask PREFETCH_FE_RES = null;
    public static final PrefetchTask PREFETCH_HOME_PAGE_REQUEST = null;
    public static final PrefetchTask PRERENDER_AMAP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PrefetchTask[] f202252a = null;
    private final String task;

    public static PrefetchTask valueOf(String r100) {
        return (PrefetchTask) r27.a.a(PrefetchTask.class, r100);
    }

    public static PrefetchTask[] values() {
        return (PrefetchTask[]) f202252a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.caijing.sdk.infra.base.api.trip.performance.PrefetchTask$a] */
    static {
        PrefetchTask r100 = new PrefetchTask(UserProfileEvent.POSITION_NONE, 0, "none");
        NONE = r100;
        PrefetchTask r101 = new PrefetchTask("PREFETCH_FE_RES", 1, "prefetch_fe_res");
        PREFETCH_FE_RES = r101;
        PrefetchTask r102 = new PrefetchTask("PREFETCH_HOME_PAGE_REQUEST", 2, "prefetch_home_page_request");
        PREFETCH_HOME_PAGE_REQUEST = r102;
        PrefetchTask r103 = new PrefetchTask("PRERENDER_AMAP", 3, "prerender_amap");
        PRERENDER_AMAP = r103;
        PrefetchTask r104 = new PrefetchTask("PREFETCH_ALL", 4, "prefetch_all");
        PREFETCH_ALL = r104;
        f202252a = new PrefetchTask[]{r100, r101, r102, r103, r104};
        Companion = new a();
    }

    public final String getTask() {
        return this.task;
    }

    public PrefetchTask(String r100, int r101, String r102) {
        super(r100, r101);
        this.task = r102;
    }
}
