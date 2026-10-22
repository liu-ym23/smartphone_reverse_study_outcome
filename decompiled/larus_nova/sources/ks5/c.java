package ks5;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f505933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pxb.a f505934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rxb.c f505935c;

    public final Context getContext() {
        return this.f505933a;
    }

    public c(Context r100, pxb.a r101, rxb.c r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "webView");
        Intrinsics.checkNotNullParameter(r102, "logger");
        this.f505933a = r100;
        this.f505934b = r101;
        this.f505935c = r102;
    }
}
