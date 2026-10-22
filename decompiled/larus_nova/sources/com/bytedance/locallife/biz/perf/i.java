package com.bytedance.locallife.biz.perf;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes21.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ScheduledExecutorService f256851a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f256852b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ExecutorService f256853c = null;

    public static final class a {
    }

    static {
        new String[]{"food", "general", "trip", "deliver", "default"};
        new String[]{"poi_detail_ng", "goods_detail_page"};
        f256851a = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("PoiLynxTemplatePredecodeTask"));
        f256852b = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("PoiLynxTemplatePredecodeTask"));
        f256853c = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("PoiLynxTemplatePredecodeTask"));
    }
}
