package l84;

import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.utils.background.BackgroundProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c0 implements BackgroundProvider.Callback {
    public final /* synthetic */ d0 a;

    public c0(d0 r1) {
        this.a = r1;
    }

    public final void onAppBackgroundSwitch(final boolean r3) {
        Logger.i("onAppBackgroundSwitchTest isEnterBackground:" + r3);
        if (LocationUtil.isMainThread() == false) goto L5;
        this.a.a.post(new b0(this, r3));
        return;
    L5:
        d0.b(this.a, r3);
    }
}
