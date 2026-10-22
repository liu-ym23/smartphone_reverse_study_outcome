package nd9;

import android.os.SystemClock;
import com.larus.im.internal.trace.legacy.RTCEstablishReportScene;
import com.larus.im.service.audio.y0;
import com.larus.im.service.audio.z0;
import kotlin.jvm.internal.Intrinsics;
import pf9.o;

/* JADX INFO: loaded from: classes29.dex */
public final class h extends z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f518823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f518824b;

    @Override // com.larus.im.service.audio.z0
    public final String g() {
        return this.f518823a;
    }

    public h(g r100) {
        this.f518824b = r100;
        this.f518823a = "SessionConnectionManager";
    }

    @Override // com.larus.im.service.audio.z0
    public final void n(z0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof o) == false) goto L13;
        this.f518824b.f518819f.set(true);
        if (y0.e(this.f518824b.f518815b.f350807b) == false) goto L7;
        gf9.a.f481074a.b(this.f518824b.b().getTraceId(), RTCEstablishReportScene.NORMAL, SystemClock.elapsedRealtime());
    L7:
        g r101 = this.f518824b;
        if ((r101.b().getCurrentState() instanceof ue9.b.a) == false) goto L10;
        jd9.c r102 = new jd9.c.a(false);
    L11:
        r101.c(r102);
        return;
    L10:
        r102 = jd9.c.b.f498755c;
        goto L11
    }
}
