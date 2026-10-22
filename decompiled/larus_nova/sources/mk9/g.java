package mk9;

import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import lk9.h;
import lk9.i;
import lk9.k;
import lk9.o;

/* JADX INFO: loaded from: classes30.dex */
public final class g implements h {
    public g() {
    }

    @Override // lk9.h
    public final i a(o r100, lk9.f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "applicant");
        FLogger.f375446a.i("OnMediaStateChangeListener", "SystemMediaProcessor process");
        CopyOnWriteArrayList<lk9.f> r102 = r100.f509642b;
        if (r102 == null) goto L5;
        int r103 = k.f509633a;
        if (k.a(r100.f509641a, r102, r101, r100.f509643c) == false) goto L10;
        return new i.b(1.0f);
    L10:
        return new i.a("System media request rejected");
    L5:
        return new i.a("No top stack");
    }

    @Override // lk9.h
    public final boolean b(o r100, lk9.f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "applicant");
        CopyOnWriteArrayList<lk9.f> r102 = r100.f509642b;
        if (r102 != null) goto L5;
        return false;
    L5:
        if (r102.isEmpty() == true) goto L16;
        Iterator<T> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L16;
        if (((lk9.f) r103.next()).f509628a.f509610b != (-1)) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == false) goto L9;
        boolean r105 = true;
    L17:
        if (r105 != true) goto L26;
        return true;
    L26:
        return false;
    L13:
        r104 = false;
    L16:
        r105 = false;
        goto L17
    }
}
