package x5a;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.component.svg.parser.SVG;
import com.lynx.component.svg.parser.SVGParseException;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.utils.UIThreadUtils;

/* JADX INFO: loaded from: classes32.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.lynx.component.svg.a f562560a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f562561a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f562561a.f562560a.f380986p = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(c r100) {
            this.f562561a = r100;
        }
    }

    public final void a() {
        SVG r100 = SVG.c(this.f562560a.f380982l);     // Catch: SVGParseException -> L7
        com.lynx.component.svg.a r101 = this.f562560a;     // Catch: SVGParseException -> L7
        if (r100 != null) goto L5;
        r101.f380986p = false;     // Catch: SVGParseException -> L7
    L10:
        return;
    L5:
        LynxThreadPool.e().execute(new b(r101, r101.f380990t, r101.f380991u, r100));     // Catch: SVGParseException -> L7
    L7:
        e = move-exception;
        LLog.e("lynx_SVGRenderer", "renderLegacySVGFromContent failed: " + e.getMessage());
        UIThreadUtils.runOnUiThread(new a(this));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(com.lynx.component.svg.a r100) {
        this.f562560a = r100;
    }
}
