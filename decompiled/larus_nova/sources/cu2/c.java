package cu2;

import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.k3;
import jc1.k;

/* JADX INFO: loaded from: classes11.dex */
public final class c {
    public static void a(int r100, int r101) {
        if (k3.f142264a.getValue().mEnable == false) goto L6;
        ((IMiddlewareHostAction) k.f(IMiddlewareHostAction.class)).startVBoost(r100, r101);
        return;
    }
}
