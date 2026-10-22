package mk6;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f514307a;

    public a(d r100) {
        this.f514307a = r100;
    }

    public final void a() {
        d r100 = this.f514307a;
        com.bytedance.live.richcontent.utils.c r101 = r100.f514315c;
        ik6.d r102 = r100.f514316d;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "rendItem");
        r101.f255805a.a();
        d r103 = this.f514307a;
        ak6.e r104 = r103.f514317e;
        if (r104 == null) goto L6;
        r104.b(r103.f514316d.c());
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
