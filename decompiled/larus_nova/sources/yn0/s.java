package yn0;

import com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService;
import com.bytedance.android.livesdkapi.util.IScreenRotateMonitor;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes46.dex */
public final class s implements l81.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f568515a = null;

    public s() {
    }

    static {
        f568515a = new s();
    }

    @Override // l81.s
    public final void a(DataCenter r100) {
        IScreenRotateService r101 = (IScreenRotateService) jc1.k.f(IScreenRotateService.class);
        if (r101 == null) goto L8;
        IScreenRotateMonitor r102 = r101.rotateMonitor(r100);
        if (r102 == null) goto L9;
        r102.markClickToRotate(0);
        return;
    L9:
        return;
    }
}
