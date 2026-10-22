package com.lynx.tasm.behavior.ui;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;

/* JADX INFO: loaded from: classes32.dex */
public class LynxBaseUI$$MethodInvoker implements com.lynx.tasm.behavior.utils.a<LynxBaseUI> {
    public LynxBaseUI$$MethodInvoker() {
    }

    @Override // com.lynx.tasm.behavior.utils.a
    public void invoke(LynxBaseUI r100, String r101, ReadableMap r102, Callback r103) {
        r101.getClass();
        byte r104 = -1;
        switch(r101.hashCode()) {
            case -527962973: goto L26;
            case -357431021: goto L22;
            case 692239790: goto L18;
            case 1419773105: goto L14;
            case 1848904985: goto L10;
            case 1908871954: goto L6;
            default: goto L29;
        };
    L29:
        switch(r104) {
            case 0: goto L36;
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L32;
            case 5: goto L31;
            default: goto L30;
        };
    L30:
        r103.invoke(new Object[]{3});
        return;
    L31:
        r100.scrollIntoView(r102, r103);
        return;
    L32:
        r100.requestAccessibilityFocus(r102, r103);
        return;
    L33:
        r100.requestUIInfo(r102, r103);
        return;
    L34:
        r100.fetchAccessibilityTargets(r102, r103);
        return;
    L35:
        r100.boundingClientRect(r102, r103);
        return;
    L36:
        r100.innerText(r102, r103);
        return;
    L6:
        if (r101.equals("scrollIntoView") == false) goto L29;
        r104 = 5;
        goto L29
    L10:
        if (r101.equals("requestAccessibilityFocus") == false) goto L29;
        r104 = 4;
        goto L29
    L14:
        if (r101.equals("requestUIInfo") == false) goto L29;
        r104 = 3;
        goto L29
    L18:
        if (r101.equals("fetchAccessibilityTargets") == false) goto L29;
        r104 = 2;
        goto L29
    L22:
        if (r101.equals("boundingClientRect") == false) goto L29;
        r104 = 1;
        goto L29
    L26:
        if (r101.equals("innerText") == false) goto L29;
        r104 = 0;
        goto L29
    }
}
