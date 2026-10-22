package com.bytedance.ee.bear.lynx.impl.lynxview;

import com.bytedance.lark.lynxlib.widget.udtabs.LynxTabBarView$;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CCMLynxTabbarView$$PropsSetter extends LynxTabBarView$.PropsSetter {
    public CCMLynxTabbarView$$PropsSetter() {
    }

    public final void setProperty(LynxBaseUI r3, String r4, x0 r5) {
        CCMLynxTabbarView r0 = (CCMLynxTabbarView) r3;
        r4.getClass();
        if (r4.equals("left-offset") == true) goto L6;
        super.setProperty(r3, r4, r5);
        return;
    L6:
        r0.setLeftOffset(r5.f(r4, 0));
    }
}
