package com.obric.assistant.cocreationreview.modules.proactive;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f387521d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Runnable, Unit> f387522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f387523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f387524c;

    public static final class a {
        /* JADX WARN: Type inference failed for: r2v0, types: [com.obric.assistant.cocreationreview.modules.proactive.t] */
        /* JADX WARN: Type inference failed for: r3v0, types: [com.obric.assistant.cocreationreview.modules.proactive.u] */
        public static v a() {
            Intrinsics.checkNotNullParameter("proactive-agent-load", "threadName");
            final ExecutorService r100 = PThreadExecutorsUtils.newSingleThreadExecutor(new s());
            return new v(new t(r100), new u(r100));
        }
    }

    static {
    }

    public v(t r100, u r101) {
        Intrinsics.checkNotNullParameter(r100, "dispatch");
        Intrinsics.checkNotNullParameter(r101, "release");
        this.f387522a = r100;
        this.f387523b = r101;
        this.f387524c = new AtomicBoolean(false);
    }
}
