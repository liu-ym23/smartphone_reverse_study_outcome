package com.bytedance.jedi.model.util;

import com.orhanobut.logger.Logger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/jedi/model/util/SyncLog;", "Lcom/bytedance/jedi/model/util/IJediModelLogger;", "<init>", "()V", "model_release"}, k = 1, mv = {1, 7, 1})
public final class SyncLog implements IJediModelLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SyncLog f251209a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f251210b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f251211c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f251212d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f251213e = null;

    private SyncLog() {
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.jedi.model.util.SyncLog$androidLogAdapter$1] */
    static {
        f251209a = new SyncLog();
        f251210b = "REPO_SYNC";
        f251211c = LazyKt.lazy(SyncLog$defaultFormatStrategy$2.INSTANCE);
        f251212d = LazyKt.lazy(SyncLog$utFormatStrategy$2.INSTANCE);
        ?? r100 = new SyncLog$androidLogAdapter$1();
        f251213e = LazyKt.lazy(SyncLog$executor$2.INSTANCE);
        Logger.a(r100);
    }
}
