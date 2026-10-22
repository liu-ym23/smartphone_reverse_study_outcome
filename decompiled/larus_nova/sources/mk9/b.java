package mk9;

import com.larus.media.MediaState;
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
public final class b implements h {
    public b() {
    }

    @Override // lk9.h
    public final i a(o r100, lk9.f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "applicant");
        FLogger r102 = FLogger.f375446a;
        r102.i("OnMediaStateChangeListener", "InterruptMediaProcessor process");
        CopyOnWriteArrayList<lk9.f> r103 = r100.f509642b;
        if (r103 == null) goto L5;
        Iterator<T> r104 = r103.iterator();
        if (r104.hasNext() == false) goto L17;
        if (((lk9.f) r104.next()).f509628a.f509615g == true) goto L11;
        r102.i("OnMediaStateChangeListener", "request play media applicant scene :" + r101.f509628a.f509609a + " failed");
        return new i.a("it.level == applicant.level media canInterruptInPeer request is rejected");
    L11:
        int r105 = k.f509633a;
        if (k.a(r100.f509641a, r103, r101, r100.f509643c) == false) goto L15;
        return new i.b(1.0f);
    L15:
        return new i.a("Interrupt request rejected");
    L17:
        return new i.b(1.0f);
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
        if (r102.isEmpty() == true) goto L18;
        Iterator<T> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L18;
        lk9.f r104 = (lk9.f) r103.next();
        if (r104.f509629b.f509626b != MediaState.INVALID) goto L13;
    L15:
        boolean r105 = false;
    L16:
        if (r105 == true) goto L9;
        boolean r106 = false;
    L19:
        if (r106 != true) goto L28;
        return true;
    L28:
        return false;
    L13:
        if (r101.f509628a.f509611c != r104.f509628a.f509611c) goto L15;
        r105 = true;
    L18:
        r106 = true;
        goto L19
    }
}
