package com.bytedance.ee.bear.lynx.impl.lynxview;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CCMLynxRadioBox$$PropsSetter extends LynxUI$.PropsSetter {
    public CCMLynxRadioBox$$PropsSetter() {
    }

    public final void setProperty(LynxBaseUI r5, String r6, x0 r7) {
        CCMLynxRadioBox r0 = (CCMLynxRadioBox) r5;
        r6.getClass();
        byte r3 = -1;
        switch(r6.hashCode()) {
            case -1964681502: goto L26;
            case -1735887358: goto L22;
            case -1350454882: goto L18;
            case -342264874: goto L14;
            case 3575610: goto L10;
            case 1001453060: goto L6;
            default: goto L29;
        };
    L29:
        switch(r3) {
            case 0: goto L42;
            case 1: goto L40;
            case 2: goto L38;
            case 3: goto L36;
            case 4: goto L34;
            case 5: goto L32;
            default: goto L30;
        };
    L30:
        super.setProperty(r5, r6, r7);
        return;
    L32:
        r0.setChecked(r7.b(r6, false));
        return;
    L34:
        r0.setType(r7.h(r6));
        return;
    L36:
        r0.setLargeSize(r7.b(r6, false));
        return;
    L38:
        r0.setEnable(r7.b(r6, false));
        return;
    L40:
        r0.setUnCheckBackgroundColor(r7.h(r6));
        return;
    L42:
        r0.setClickable(r7.b(r6, false));
        return;
    L6:
        if (r6.equals("is-checked") == false) goto L29;
        r3 = 5;
        goto L29
    L10:
        if (r6.equals(ResourceData.KEY_TYPE) == false) goto L29;
        r3 = 4;
        goto L29
    L14:
        if (r6.equals("is-large-size") == false) goto L29;
        r3 = 3;
        goto L29
    L18:
        if (r6.equals("is-enabled") == false) goto L29;
        r3 = 2;
        goto L29
    L22:
        if (r6.equals("uncheck-background-color") == false) goto L29;
        r3 = 1;
        goto L29
    L26:
        if (r6.equals("clickable") == false) goto L29;
        r3 = 0;
        goto L29
    }
}
