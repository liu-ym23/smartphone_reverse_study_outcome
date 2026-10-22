package yf0;

import com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkInviteListContract$View;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class b extends e<BaseTalkInviteListContract$View> {
    public abstract void d(boolean r100);

    public abstract void e(ILinkPlayerInfoBridge r100);

    public abstract void f(ILinkPlayerInfoBridge r100);

    public b(BaseTalkInviteListContract$View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
    }
}
