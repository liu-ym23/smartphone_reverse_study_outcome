package com.bytedance.ee.bear.lynx.impl.lynxview;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CCMLynxIconView$$PropsSetter extends LynxUI$.PropsSetter {
    public CCMLynxIconView$$PropsSetter() {
    }

    public final void setProperty(LynxBaseUI r3, String r4, x0 r5) {
        CCMLynxIconView r0 = (CCMLynxIconView) r3;
        r4.getClass();
        if (r4.equals("icon-token") == false) goto L5;
        r0.setIconToken(r5.h(r4));
        return;
    L5:
        if (r4.equals(ResourceData.KEY_URL) == true) goto L8;
        super.setProperty(r3, r4, r5);
        return;
    L8:
        r0.setUrl(r5.h(r4));
    }
}
