package dba;

import android.os.Handler;
import android.os.SystemClock;
import com.obric.assistant.activation.presentation.runtime.gesture.scheduler.ObricAiKeyGestureTimeout;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f467839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<ObricAiKeyGestureTimeout, Runnable> f467840b;

    @Override // dba.c
    public final void a() {
        Collection r100 = ((LinkedHashMap) this.f467840b).values();
        Handler r101 = this.f467839a;
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.removeCallbacks((Runnable) r102.next());
        goto L4
    L6:
        ((LinkedHashMap) this.f467840b).clear();
    }

    public b(Handler r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f467839a = r100;
        this.f467840b = new LinkedHashMap();
    }

    @Override // dba.c
    public final void b(ObricAiKeyGestureTimeout r100) {
        Intrinsics.checkNotNullParameter(r100, "timeout");
        Runnable r101 = this.f467840b.remove(r100);
        if (r101 == null) goto L6;
        this.f467839a.removeCallbacks(r101);
        return;
    }

    @Override // dba.c
    public final void c(final ObricAiKeyGestureTimeout r100, long r101, final cba.a r102) {
        Intrinsics.checkNotNullParameter(r100, "timeout");
        Intrinsics.checkNotNullParameter(r102, "callback");
        b(r100);
        Runnable r103 = new a(this, r100, r102);
        this.f467840b.put(r100, r103);
        this.f467839a.postAtTime(r103, Math.max(r101, SystemClock.uptimeMillis()));
    }
}
