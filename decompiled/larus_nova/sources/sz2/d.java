package sz2;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f543916a;

    public d(String r100) {
        this.f543916a = r100;
    }

    public final void a() {
        nz2.b.f("ContainerStandardApi", "invalidateID [monitorId:" + this.f543916a + ']');
        a r100 = e.f543918b;
        String r101 = this.f543916a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "monitorId");
        a.f543907b.remove(r101);
        a.f543908c.remove(r101);
        WeakHashMap<View, a.InterfaceC7672a> r102 = a.f543911f;
        f r103 = a.f543910e.get(r101);
        if (r103 == null) goto L5;
        View r104 = r103.a();
    L6:
        r102.remove(r104);
        a.f543909d.remove(r101);
        return;
    L5:
        r104 = null;
        goto L6
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
}
