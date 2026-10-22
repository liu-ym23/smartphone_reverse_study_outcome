package zq0;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import jc1.k;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f573294a = 0;

    public static boolean a() {
        IInteractService r100 = (IInteractService) k.f(IInteractService.class);
        if (r100 == null) goto L5;
        int r101 = r100.getCurrentScene();
    L7:
        if (r101 != 8) goto L9;
    L10:
        return true;
    L9:
        if (r101 == 12) goto L10;
        return false;
    L5:
        r101 = 0;
        goto L7
    }

    static {
    }
}
