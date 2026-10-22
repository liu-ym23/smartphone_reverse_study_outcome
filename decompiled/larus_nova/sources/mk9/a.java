package mk9;

import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lk9.h;
import lk9.i;
import lk9.j;
import lk9.o;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements h {
    public a() {
    }

    @Override // lk9.h
    public final i a(o r100, lk9.f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "applicant");
        FLogger.f375446a.i("OnMediaStateChangeListener", "EmptyStackProcessor process");
        j r102 = r100.f509641a;
        CopyOnWriteArrayList<lk9.f> r103 = new CopyOnWriteArrayList(CollectionsKt.mutableListOf(new lk9.f[]{r101}));
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "applicants");
        r102.f509632a.push(r103);
        return new i.b(1.0f);
    }

    @Override // lk9.h
    public final boolean b(o r100, lk9.f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "applicant");
        return r100.f509641a.f509632a.isEmpty();
    }
}
