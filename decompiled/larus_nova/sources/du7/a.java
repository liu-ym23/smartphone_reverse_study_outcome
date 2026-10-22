package du7;

import com.flow.performance.perflog.scenario.b;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements f09.a.b {
    public a() {
    }

    @Override // f09.a.b
    public final void onAllActivityDestroyed() {
        b.f274159a.getClass();
        b.f274164f = "background";
        bu7.a.b("App to background", "");
        Iterator<f09.a.b> r100 = b.f274160b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onAllActivityDestroyed();
        goto L4
    }

    @Override // f09.a.b
    public final void onAppBackground() {
        b.f274159a.getClass();
        b.f274164f = "background";
        bu7.a.b("App to background", "");
        Iterator<f09.a.b> r100 = b.f274160b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onAppBackground();
        goto L4
    }

    @Override // f09.a.b
    public final void onAppForeground() {
        b.f274159a.getClass();
        b.f274164f = "foreground";
        bu7.a.b("App to foreground", "");
        Iterator<f09.a.b> r100 = b.f274160b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onAppForeground();
        goto L4
    }
}
