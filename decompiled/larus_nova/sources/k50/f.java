package k50;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f501810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f501811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Pair<Integer, Integer> f501812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f501813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f501814e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f501815f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f501816g;

    public final Context getContext() {
        return this.f501816g;
    }

    public f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f501816g = r100;
        r100.getPackageName();
        this.f501810a = new d();
        this.f501812c = new Pair(770, 771);
        this.f501813d = System.currentTimeMillis();
        this.f501814e = true;
        this.f501815f = true;
    }
}
