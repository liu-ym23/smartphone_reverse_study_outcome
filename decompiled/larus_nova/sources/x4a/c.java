package x4a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.animax.ui.AnimaXView;
import com.lynx.animax.util.AnimaXLog;

/* JADX INFO: loaded from: classes32.dex */
public final class c extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnimaXView f562455a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f562456a;

        public final void a() {
            AnimaXLog.b("AnimaXView", "detect screen unlock, force redraw " + this + " run");
            if (this.f562456a.f562455a.getVisibility() != 0) goto L6;
            this.f562456a.f562455a.setVisibility(4);
            this.f562456a.f562455a.setVisibility(0);
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

        public a(c r100) {
            this.f562456a = r100;
        }
    }

    public c(AnimaXView r100) {
        this.f562455a = r100;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        AnimaXLog.b("AnimaXView", "detect screen unlock, force redraw " + this);
        y4a.d.a().post(new a(this));
    }
}
