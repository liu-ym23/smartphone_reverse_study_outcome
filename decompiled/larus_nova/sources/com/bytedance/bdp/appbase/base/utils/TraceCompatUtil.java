package com.bytedance.bdp.appbase.base.utils;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/bdp/appbase/base/utils/TraceCompatUtil;", "", "()V", "TAG", "", "beginSection", "", "tag", "endSection", "getTagName", "bdp-appbase-ext_release"}, k = 1, mv = {1, 1, 18})
public final class TraceCompatUtil {
    public static final TraceCompatUtil INSTANCE = null;
    private static final String TAG = "TraceCompatUtil";

    private TraceCompatUtil() {
    }

    public final void beginSection() {
    }

    public final void beginSection(String r100) {
    }

    public final void endSection() {
    }

    static {
        INSTANCE = new TraceCompatUtil();
    }

    private final String getTagName() {
        StackTraceElement r100 = (StackTraceElement) ArraysKt.getOrNull(ThreadMethodProxy.currentThread().getStackTrace(), 2);
        if (r100 != null) goto L5;
        return "TraceCompatUtil_trace";
    L5:
        return r100.getClassName() + "-" + r100.getMethodName();
    }
}
