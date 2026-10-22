package dia;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a extends eia.e {

    /* JADX INFO: renamed from: dia.a$a, reason: collision with other inner class name */
    public static final class C5675a {
    }

    static {
    }

    @Override // eia.v
    public final void a() {
        FLogger.f375446a.i("LandscapeActionBarStrategy", "applyOrientationChange " + hashCode());
        c();
    }

    public a(Context r100, t1a.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "vContext");
        super(r100, r101);
    }
}
