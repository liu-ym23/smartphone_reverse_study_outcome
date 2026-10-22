package rr3;

import android.location.Location;
import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f539007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Location f539008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f539009c;

    public b(a r100, Location r101, int r102) {
        this.f539007a = r100;
        this.f539008b = r101;
        this.f539009c = r102;
    }

    public final void a() {
        if (this.f539007a.f538993n == true) goto L5;
        return;
    L5:
        a r100 = this.f539007a;
        r100.f538992m = System.currentTimeMillis();
        Function1<? super a.AbstractC7523a, Unit> r101 = this.f539007a.f538986g;
        if (r101 == null) goto L8;
        Unit r102 = r101.invoke(new a.AbstractC7523a.b(this.f539008b, this.f539009c));
    L8:
        a r103 = this.f539007a;
        Handler r104 = r103.f538980a;
        if (r104 == null) goto L12;
        r104.postDelayed(r103.f538998s, r103.f538981b);
        return;
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
