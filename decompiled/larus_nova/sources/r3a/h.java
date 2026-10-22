package r3a;

import android.content.Context;
import android.view.OrientationEventListener;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes32.dex */
public final class h extends OrientationEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f535925a;

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int r100) {
        if (r100 != (-1)) goto L5;
        return;
    L5:
        int r101 = this.f535925a.f535907k;
        this.f535925a.getClass();
        int r102 = f.E(r101);
        int r103 = Math.abs(f.E(r100) - f.E(r102));
        if (Math.min(r103, 360 - r103) < 50) goto L9;
        r102 = f.E(((r100 + 45) / 90) * 90);
    L9:
        if (r102 == r101) goto L12;
        this.f535925a.f535907k = r102;
        FLogger.f375446a.i("CameraContextImpl", "gravity sensor rotation changed, orientation=" + r100 + ", rotation=" + r102);
        return;
    }

    public h(f r100, Context r101) {
        this.f535925a = r100;
        super(r101, 2);
    }
}
