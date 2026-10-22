package com.bytedance.bdp.bdpbase.event;

import com.bytedance.bdp.bdpbase.manager.BdpManager;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes11.dex */
public final class BdpPreloadTimelineUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PreloadTimelineService f201094a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f201095b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f201096c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f201097d = null;

    static {
        f201094a = (PreloadTimelineService) BdpManager.getInst().getService(PreloadTimelineService.class);
        f201095b = LazyKt.lazy(BdpPreloadTimelineUtil$sampleRateInfo$2.INSTANCE);
        f201096c = LazyKt.lazy(BdpPreloadTimelineUtil$hitSample$2.INSTANCE);
        f201097d = LazyKt.lazy(BdpPreloadTimelineUtil$sampleRate$2.INSTANCE);
    }
}
