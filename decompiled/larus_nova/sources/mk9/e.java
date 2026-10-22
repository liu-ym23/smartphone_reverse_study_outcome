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
public final class e implements h {
    public e() {
    }

    @Override // lk9.h
    public final i a(o r100, lk9.f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "applicant");
        FLogger.f375446a.i("OnMediaStateChangeListener", "PauseMediaProcessor process");
        CopyOnWriteArrayList<lk9.f> r102 = r100.f509642b;
        if (r102 == null) goto L5;
        int r103 = k.f509633a;
        if (k.a(r100.f509641a, r102, r101, r100.f509643c) == false) goto L10;
        return new i.b(1.0f);
    L10:
        return new i.a("Interrupt request rejected");
    L5:
        return new i.a("request topCanPause media failed when tryPauseCurrentAndPushNew");
    }

    @Override // lk9.h
    public final boolean b(o r100, lk9.f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "applicant");
        CopyOnWriteArrayList<lk9.f> r102 = r100.f509642b;
        if (r102 != null) goto L5;
        return false;
    L5:
        if (r102.isEmpty() == true) goto L23;
        Iterator<T> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L23;
        lk9.f r104 = (lk9.f) r103.next();
        lk9.a r105 = r104.f509628a;
        if (r105.f509614f == false) goto L20;
        lk9.a r106 = r101.f509628a;
        if (r106.f509614f == false) goto L20;
        if (r104.f509629b.f509626b != MediaState.INVALID) goto L17;
    L19:
        boolean r107 = false;
    L21:
        if (r107 == true) goto L9;
        boolean r108 = false;
    L24:
        if (r108 != true) goto L33;
        return true;
    L33:
        return false;
    L17:
        if (r106.f509611c.compareTo(r105.f509611c) <= 0) goto L19;
    L20:
        r107 = true;
    L23:
        r108 = true;
        goto L24
    }
}
