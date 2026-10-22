package cy5;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.framwork.core.sdkmonitor.d;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f465788a;

    public a(Context r100) {
        if (this.f465788a != null) goto L13;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f465788a != null) goto L8;
        this.f465788a = r100.getSharedPreferences("monitor_downgrade" + d.a(r100), 0);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    }
}
