package mk9;

import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import lk9.h;
import lk9.i;
import lk9.o;

/* JADX INFO: loaded from: classes30.dex */
public final class f implements h {
    public f() {
    }

    @Override // lk9.h
    public final i a(o r100, lk9.f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "applicant");
        FLogger.f375446a.i("OnMediaStateChangeListener", "SameMediaProcessor process");
        return new i.b(1.0f);
    }

    @Override // lk9.h
    public final boolean b(o r100, lk9.f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "applicant");
        CopyOnWriteArrayList<lk9.f> r102 = r100.f509642b;
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.contains(r101) != true) goto L7;
        return true;
    }
}
