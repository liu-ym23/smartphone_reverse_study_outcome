package ij7;

import android.app.Activity;
import android.webkit.WebView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes22.dex */
public final class d extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebView f490093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ij7.a f490094b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f490095a;

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.f490095a.f490093a.getProgress() >= 100) goto L9;
            this.f490095a.f490094b.f490087o = true;     // Catch: Throwable -> L6
            d r100 = this.f490095a;     // Catch: Throwable -> L6
            r100.f490094b.c(r100.f490093a, 90071, "loading_url_time_out");     // Catch: Throwable -> L6
            return;
        }

        public a(d r100) {
            this.f490095a = r100;
        }
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Activity r100 = this.f490094b.f490080h;     // Catch: Throwable -> L12
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isFinishing() == false) goto L8;
        return;
    L8:
        if (this.f490093a == null) goto L20;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("ErrorViewHelper", "startTimer task run");     // Catch: Throwable -> L12
        this.f490093a.post(new a(this));     // Catch: Throwable -> L12
        return;
    L20:
        return;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L21;
        throw th;
    }

    public d(ij7.a r100, WebView r101) {
        this.f490094b = r100;
        this.f490093a = r101;
    }
}
