package dq2;

import com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService;
import com.bytedance.android.livesdk.config.k20;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ai0.e f469637a;

    public final boolean a() {
        return ((ai0.c) this.f469637a).c();
    }

    public final boolean b() {
        if (k20.f120571a.getValue().a() == false) goto L9;
        ILiveMiniAppService r100 = (ILiveMiniAppService) jc1.k.f(ILiveMiniAppService.class);
        if (r100 == null) goto L9;
        if (r100.getMiniAppActivityState() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public i(ai0.e r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        this.f469637a = r100;
    }
}
