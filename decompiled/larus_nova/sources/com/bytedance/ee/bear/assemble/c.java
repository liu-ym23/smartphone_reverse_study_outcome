package com.bytedance.ee.bear.assemble;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f206278a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f206279b = null;

    static {
        f206278a = new AtomicBoolean();
        f206279b = new AtomicBoolean();
    }

    @JvmStatic
    public static final void a(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (f206278a.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        tt5.a.h("KoinInit", "onSetupKoin Start");     // Catch: Throwable -> L7
        hwc.b.a(new KoinSetupTask$onSetupKoin$1(r100));     // Catch: Throwable -> L7
        tt5.a.h("KoinInit", "onSetupKoin End");     // Catch: Throwable -> L7
        return;
    }
}
