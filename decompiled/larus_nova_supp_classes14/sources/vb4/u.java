package vb4;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.bdturing.livedetect.TuringLiveDetectActivity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u implements Runnable {
    public final /* synthetic */ TuringLiveDetectActivity a;

    @Override // java.lang.Runnable
    public final void run() {
        AppCompatActivity r0 = this.a;     // Catch: Throwable -> L4
        Toast.makeText(r0, r0.getString(2131923580), 1).show();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public u(TuringLiveDetectActivity r1) {
        this.a = r1;
    }
}
