package x5a;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.component.svg.UISvg;
import com.lynx.component.svg.parser.SVG;
import com.lynx.tasm.utils.UIThreadUtils;

/* JADX INFO: loaded from: classes32.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SVG f562563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UISvg f562564b;

    @Override // java.lang.Runnable
    public final void run() {
        UISvg r100 = this.f562564b;     // Catch: Throwable -> L7
        SVG r101 = this.f562563a;     // Catch: Throwable -> L7
        int r102 = UISvg.f380956l;     // Catch: Throwable -> L7
        r100.f380962f = r101;     // Catch: Throwable -> L7
        if (r100.f380962f == null) goto L10;
        UIThreadUtils.runOnUiThread(new i(r100, new e(r101, r100.f380961e, r100.f380960d), r101));     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }

    public h(UISvg r100, SVG r101) {
        this.f562564b = r100;
        this.f562563a = r101;
    }
}
