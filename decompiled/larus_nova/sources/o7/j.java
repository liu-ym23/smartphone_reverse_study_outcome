package o7;

import android.content.Context;
import android.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes43.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f522249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f522250b;

    public j(Context r100) {
        this.f522249a = r100;
        this.f522250b = R.string.annie_web_save_image_failed;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.makeText(this.f522249a, this.f522250b, 0).show();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
