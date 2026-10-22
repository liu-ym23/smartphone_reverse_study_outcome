package r5c;

import android.app.Application;
import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements p5c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f536325a = null;

    static {
        f536325a = new a();
    }

    public a() {
    }

    @Override // p5c.a
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // p5c.a
    public final void init(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
    }

    @Override // p5c.a
    public final void report() {
        Intrinsics.checkNotNullParameter(null, "event");
    }
}
