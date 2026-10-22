package pfc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f.a f529045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f529046b;

    public final void a() {
        int r100 = this.f529046b.g();
        if (r100 != (-1)) goto L5;
        f.b r101 = this.f529046b.e();
    L6:
        r100 = r100 + 1;
        if (r100 >= ((ArrayList) this.f529046b.f529051c).size()) goto L9;
        r101.a((f.a) ListProtector.get(this.f529046b.f529051c, r100));
        goto L6
    L9:
        this.f529045a.f529057b = r101;
        return;
    L5:
        r101 = new f.b(((f.a) ListProtector.get(this.f529046b.f529051c, r100)).f529057b);
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

    public e(f r100, f.a r101) {
        this.f529046b = r100;
        this.f529045a = r101;
    }
}
