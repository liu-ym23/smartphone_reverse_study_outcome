package com.bytedance.ee.bear.lynx.impl.lynxview.refresh;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIGroup$;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CCMLynxPullRefreshView$$PropsSetter extends UIGroup$.PropsSetter {
    public CCMLynxPullRefreshView$$PropsSetter() {
    }

    public final void setProperty(LynxBaseUI r4, String r5, x0 r6) {
        CCMLynxPullRefreshView r0 = (CCMLynxPullRefreshView) r4;
        r5.getClass();
        if (r5.equals("enable-loadmore") == false) goto L5;
        r0.setEnableLoadMore(r6.b(r5, true));
        return;
    L5:
        if (r5.equals("enable-refresh") == true) goto L8;
        super.setProperty(r4, r5, r6);
        return;
    L8:
        r0.setEnableRefresh(r6.b(r5, true));
    }
}
