package g37;

import com.bytedance.news.common.settings.SettingsUpdateListener;
import com.bytedance.news.common.settings.api.SettingsData;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f479836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SettingsData f479837b;

    @Override // java.lang.Runnable
    public final void run() {
        ((SettingsUpdateListener) this.f479836a.getKey()).onSettingsUpdate(this.f479837b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(Map.Entry r100, SettingsData r101) {
        this.f479836a = r100;
        this.f479837b = r101;
    }
}
