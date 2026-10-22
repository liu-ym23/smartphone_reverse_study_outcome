package il7;

import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f490322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f490323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f.a f490324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ f f490325d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f490326a;

        @Override // java.lang.Runnable
        public final void run() {
            f.a r100 = this.f490326a.f490324c;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.onSuccess(null);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(e r100) {
            this.f490326a = r100;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    L17:
        return;
    L3:
        if (this.f490322a == false) goto L7;
        k.a(this.f490323b);     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(null) == true) goto L7;
        this.f490325d.f490329a.post(new a(this));     // Catch: Throwable -> L9
    L14:
        return;
    L7:
        f r100 = this.f490325d;     // Catch: Throwable -> L9
        String r101 = this.f490323b;     // Catch: Throwable -> L9
        f.a r102 = this.f490324c;     // Catch: Throwable -> L9
        r100.getClass();     // Catch: Throwable -> L9
        rk7.m.d(new d(r100, r101, r102));     // Catch: Throwable -> L9
        goto L14
    }

    public e(f r100, String r101, com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.c r102) {
        this.f490325d = r100;
        this.f490322a = true;
        this.f490323b = r101;
        this.f490324c = r102;
    }
}
