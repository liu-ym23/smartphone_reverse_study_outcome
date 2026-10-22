package com.larus.audio.call.plugins;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u0 f289431a;

    /* JADX INFO: renamed from: com.larus.audio.call.plugins.a$a, reason: collision with other inner class name */
    public static final class C3964a {
    }

    static {
    }

    public void a(pf9.a r100) {
    }

    public void b() {
    }

    public u0 getContext() {
        return this.f289431a;
    }

    public a(u0 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f289431a = r100;
    }

    public void c(String r100, Boolean r101) {
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L5;
        return;
    L5:
        getContext().e0().d(true, true, "query_begin");
    }
}
