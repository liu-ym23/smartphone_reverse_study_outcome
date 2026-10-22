package com.bytedance.gamecenter.base.order;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes19.dex */
public final class OrderDownloadRealTriggerImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f245014a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f245015b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final OrderDownloadRealTriggerImpl f245016c = null;

    public OrderDownloadRealTriggerImpl() {
    }

    static {
        f245016c = new OrderDownloadRealTriggerImpl();
        f245014a = LazyKt.lazy(OrderDownloadRealTriggerImpl$triggerDownloadRecordCache$2.INSTANCE);
        f245015b = new ConcurrentHashMap();
    }
}
