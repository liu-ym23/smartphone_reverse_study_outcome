package ep2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService;
import jc1.k;

/* JADX INFO: loaded from: classes11.dex */
public final class b extends d<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f473422a;

    public b() {
        this.f473422a = "rule_tag_app_enter_background";
    }

    @Override // ep2.d
    public final String d() {
        return this.f473422a;
    }

    @Override // ep2.d
    public final boolean e(Object r100) {
        ILiveMiniAppService r101 = (ILiveMiniAppService) k.f(ILiveMiniAppService.class);
        if (r101 == null) goto L5;
        boolean r102 = r101.getMiniAppActivityState();
    L6:
        if (r102 == false) goto L9;
        ALogger.i("AudioAndVideoPrivacy", "mini app,wont detect");
        return false;
    L9:
        return true;
    L5:
        r102 = false;
        goto L6
    }
}
