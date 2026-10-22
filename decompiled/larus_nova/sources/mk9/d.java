package mk9;

import com.larus.media.MediaState;
import com.larus.media.o0;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lk9.h;
import lk9.i;
import lk9.o;
import lk9.p;

/* JADX INFO: loaded from: classes30.dex */
public final class d implements h {
    public d() {
    }

    @Override // lk9.h
    public final i a(o r100, final lk9.f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "applicant");
        FLogger.f375446a.i("OnMediaStateChangeListener", "MixableMediaProcessor process");
        CopyOnWriteArrayList<lk9.f> r102 = r100.f509642b;
        if (r102 == null) goto L5;
        CollectionsKt.removeAll(r102, new c(r101));
        r102.add(r101);
        Iterator r103 = p.a(r102).entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L14;
        Map.Entry r104 = (Map.Entry) r103.next();
        lk9.f r105 = (lk9.f) r104.getKey();
        float r106 = ((Number) r104.getValue()).floatValue();
        lk9.e r107 = r105.f509629b;
        if (r107.f509626b == MediaState.PAUSED) goto L11;
        r107.f509625a.g(r105, r106);
        goto L8
    L11:
        r107.f509625a.a(r105, r106);
        r105.a(MediaState.DEFAULT);
        goto L8
    L14:
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
        if (r102.isEmpty() == true) goto L22;
        Iterator<T> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L22;
        lk9.f r104 = (lk9.f) r103.next();
        if (r104.f509629b.f509626b == MediaState.INVALID) goto L19;
        lk9.a r105 = r104.f509628a;
        if (r105.f509614f == false) goto L19;
        lk9.a r106 = r101.f509628a;
        if (r106.f509614f == false) goto L19;
        Map<String, o0.a> r107 = o0.f359131a;
        if (o0.a(r105.f509609a, r106.f509609a) == false) goto L19;
        boolean r108 = true;
    L20:
        if (r108 == true) goto L9;
        boolean r109 = false;
    L23:
        if (r109 != true) goto L32;
        return true;
    L32:
        return false;
    L19:
        r108 = false;
    L22:
        r109 = true;
        goto L23
    }
}
