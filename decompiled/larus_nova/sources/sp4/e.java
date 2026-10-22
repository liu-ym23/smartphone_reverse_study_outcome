package sp4;

import com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.h;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f542872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f542873b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f542874a;

        public a(h r100, boolean r101) {
            this.f542874a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f542874a.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public e(d r100, boolean r101) {
        this.f542872a = r100;
        this.f542873b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<h> r100 = this.f542872a.f542848n;     // Catch: Throwable -> L7
        boolean r101 = this.f542873b;     // Catch: Throwable -> L7
        Iterator r102 = ((ArrayList) r100).iterator();     // Catch: Throwable -> L7
    L4:
        if (r102.hasNext() == false) goto L16;
        j.c(new a((h) r102.next(), r101));     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
