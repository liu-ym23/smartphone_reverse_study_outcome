package j52;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater;
import l52.d;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends BaseTimingUpdater<d> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f497447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f497448d;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater
    public final void c() {
        e(new d(this.f497448d));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater
    public final long d() {
        return this.f497447c;
    }

    public b(int r100, int r101) {
        this.f497447c = ((long) r100) * 1000;
        this.f497448d = r101;
    }
}
