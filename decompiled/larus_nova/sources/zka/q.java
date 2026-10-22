package zka;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f572730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f572731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f572732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f572733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f572734e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p f572735f;

    public final g a() {
        if (this.f572734e.c(this.f572730a) == true) goto L7;
        return null;
    L7:
        return this.f572732c;
    }

    public final Context getContext() {
        return this.f572730a;
    }

    public q(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f572730a = r100;
        this.f572731b = new m();
        this.f572732c = new g();
        this.f572733d = new a();
        this.f572734e = new n();
        this.f572735f = new p();
    }
}
