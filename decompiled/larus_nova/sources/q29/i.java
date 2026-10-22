package q29;

import com.larus.home.impl.sdk.l1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.video.VideoPortraitConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes27.dex */
public final class i {
    static {
    }

    public static boolean a() {
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L9;
        r100.H();
        VideoPortraitConfig r101 = l1.f346198a.a();
        if (r101 == null) goto L9;
        if (r101.getEnableEditVideo() != true) goto L9;
        return true;
    L9:
        return false;
    }
}
