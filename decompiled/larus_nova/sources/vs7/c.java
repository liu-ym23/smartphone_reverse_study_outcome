package vs7;

import android.app.Activity;
import com.dtf.face.verify.DTFaceFacade;
import com.dtf.face.verify.IFlowCheck;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f557063a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f557063a.f557071f.onVerifyEnd();     // Catch: Throwable -> L7
        hs7.a r100 = hs7.a.h();     // Catch: Throwable -> L7
        Activity r101 = this.f557063a.f557072g;     // Catch: Throwable -> L7
        Map<String, Object> r102 = DTFaceFacade.S_EXTRAS;     // Catch: Throwable -> L7
        IFlowCheck r103 = r100.f487007s;     // Catch: Throwable -> L7
        if (r103 == null) goto L5;
        r103.gotoNextFlow(r101, "PENDING", "PENDING", r102);     // Catch: Throwable -> L7
    L5:
        this.f557063a.f557072g.finish();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public c(f r100) {
        this.f557063a = r100;
    }
}
