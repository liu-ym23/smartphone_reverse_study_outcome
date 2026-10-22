package rta;

import android.app.Instrumentation;
import com.ss.android.dypay.utils.DyActivityResultMonitor;
import com.ss.android.dypay.utils.g;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<qta.d> f539204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<qta.b> f539205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f539206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DyActivityResultMonitor f539207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Instrumentation f539208e;

    public d(qta.d r100, qta.b r101) {
        this.f539204a = new WeakReference(r100);
        WeakReference<qta.b> r102 = new WeakReference(r101);
        this.f539205b = r102;
        qta.b r103 = r102.get();
        if (r103 == null) goto L5;
        vta.b r104 = r103.c();
    L6:
        this.f539206c = new g(r104);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
