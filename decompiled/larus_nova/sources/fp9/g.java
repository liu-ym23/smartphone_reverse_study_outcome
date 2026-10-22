package fp9;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements f09.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f478319a;

    @Override // f09.a.b
    public final void onAllActivityDestroyed() {
    }

    @Override // f09.a.b
    public final void onAppForeground() {
    }

    @Override // f09.a.b
    public final void onAppBackground() {
        FLogger.f375446a.i(f.f478305n, "disk occupancy app background callback");
        this.f478319a.d("app_background");
    }

    public g(f r100) {
        this.f478319a = r100;
    }
}
