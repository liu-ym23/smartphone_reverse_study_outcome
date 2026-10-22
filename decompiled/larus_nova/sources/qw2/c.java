package qw2;

import android.view.View;
import com.bytedance.android.live.broadcast.api.model.a2;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.lc;
import com.bytedance.android.livesdkapi.live.ILiveExternalCameraServiceForOther;
import jc1.k;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f534969a;

    public c(d r100) {
        this.f534969a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        d r101 = this.f534969a;
        r101.getClass();
        if (lc.f120667a.getValue().booleanValue() == true) goto L5;
    L7:
        ILiveExternalCameraServiceForOther r102 = (ILiveExternalCameraServiceForOther) k.f(ILiveExternalCameraServiceForOther.class);
        if (r102 != null) goto L10;
    L12:
        a2 r103 = r101.f534975e;
        if (r103 == null) goto L16;
        r101.a(r103.f59027b);
        r101.f534979i.a(r103.f59027b);
        ALogger.i("ZoomHelper", "ratio:" + r103.f59027b);
        return;
    L16:
        return;
    L10:
        if (r102.isConnected() != true) goto L12;
        return;
    L5:
        if (r101.f534972b == true) goto L7;
    }
}
