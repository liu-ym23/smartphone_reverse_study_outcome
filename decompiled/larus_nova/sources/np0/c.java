package np0;

import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.utils.RecyclerViewScrollReportHelper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerViewScrollReportHelper f520001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f520002b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f520003a;

        public a(c r100) {
            this.f520003a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c r100 = this.f520003a;     // Catch: Throwable -> L4
            RecyclerViewScrollReportHelper.a(r100.f520001a, r100.f520002b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public c(RecyclerViewScrollReportHelper r100, List r101) {
        this.f520001a = r100;
        this.f520002b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RecyclerViewScrollReportHelper r100 = this.f520001a;     // Catch: Throwable -> L8
        if (r100.f84300b == false) goto L5;
        r100.f84305g.post(new a(this));     // Catch: Throwable -> L8
    L6:
        this.f520001a.f84300b = false;     // Catch: Throwable -> L8
        return;
    L5:
        RecyclerViewScrollReportHelper.a(r100, this.f520002b);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }
}
