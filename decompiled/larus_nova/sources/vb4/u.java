package vb4;

import android.widget.Toast;
import com.bytedance.bdturing.livedetect.TuringLiveDetectActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes14.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuringLiveDetectActivity f554048a;

    @Override // java.lang.Runnable
    public final void run() {
        TuringLiveDetectActivity r100 = this.f554048a;     // Catch: Throwable -> L4
        Toast.makeText(r100, r100.getString(R.string.turing_live_camera_in_use), 1).show();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public u(TuringLiveDetectActivity r100) {
        this.f554048a = r100;
    }
}
