package mt3;

import android.app.Activity;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements uu3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f515627a;

    @Override // uu3.c
    public final void onActivityCreated(Activity r100) {
    }

    @Override // uu3.c
    public final void onActivityPause(Activity r100) {
    }

    @Override // uu3.c
    public final void onActivityResume(Activity r100) {
    }

    @Override // uu3.c
    public final void onActivityStarted(Activity r100) {
    }

    @Override // uu3.c
    public final void onBackground(Activity r100) {
    }

    public g(h r100) {
        this.f515627a = r100;
    }

    @Override // uu3.c
    public final void onFront(Activity r100) {
        h r101 = this.f515627a;
        if (r101.f515632d == true) goto L5;
        return;
    L5:
        if (r101.f515630b != null) goto L8;
        return;
    L8:
        if (xu3.a.a() == false) goto L10;
        List<String> r102 = a.f515607a;
        av3.b.a("APM-Slardar", "onAppForeground: retrying priority upload");
    L10:
        c r103 = c.e.f515622a;
        r103.getClass();
        cv3.b.a(AsyncTaskManagerType.IO).c(new d(r103));
    }
}
