package com.bytedance.live.bizlink.api.platformapi.host;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/live/bizlink/api/platformapi/host/InteractStateChangeType;", "", "BackToNormal", "PauseNormalPlay", "PauseNormalStreamPush", "ResumeNormalStreamPush", "multi-biz-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum InteractStateChangeType extends Enum<InteractStateChangeType> {
    public static final InteractStateChangeType BackToNormal = null;
    public static final InteractStateChangeType PauseNormalPlay = null;
    public static final InteractStateChangeType PauseNormalStreamPush = null;
    public static final InteractStateChangeType ResumeNormalStreamPush = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InteractStateChangeType[] f254865a = null;

    static {
        InteractStateChangeType r100 = new InteractStateChangeType("BackToNormal", 0);
        BackToNormal = r100;
        InteractStateChangeType r101 = new InteractStateChangeType("PauseNormalPlay", 1);
        PauseNormalPlay = r101;
        InteractStateChangeType r102 = new InteractStateChangeType("PauseNormalStreamPush", 2);
        PauseNormalStreamPush = r102;
        InteractStateChangeType r103 = new InteractStateChangeType("ResumeNormalStreamPush", 3);
        ResumeNormalStreamPush = r103;
        f254865a = new InteractStateChangeType[]{r100, r101, r102, r103};
    }

    public static InteractStateChangeType valueOf(String r100) {
        return (InteractStateChangeType) a.a(InteractStateChangeType.class, r100);
    }

    public static InteractStateChangeType[] values() {
        return (InteractStateChangeType[]) f254865a.clone();
    }

    public InteractStateChangeType(String r100, int r101) {
        super(r100, r101);
    }
}
