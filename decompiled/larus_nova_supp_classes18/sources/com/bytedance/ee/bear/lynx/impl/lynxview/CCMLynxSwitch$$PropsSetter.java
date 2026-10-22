package com.bytedance.ee.bear.lynx.impl.lynxview;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CCMLynxSwitch$$PropsSetter extends LynxUI$.PropsSetter {
    public CCMLynxSwitch$$PropsSetter() {
    }

    public final void setProperty(LynxBaseUI r4, String r5, x0 r6) {
        CCMLynxSwitch r0 = (CCMLynxSwitch) r4;
        r5.getClass();
        if (r5.equals("is-enabled") == false) goto L5;
        r0.setEnable(r6.b(r5, false));
        return;
    L5:
        if (r5.equals("is-on") == true) goto L8;
        super.setProperty(r4, r5, r6);
        return;
    L8:
        r0.setChecked(r6.b(r5, false));
    }
}
