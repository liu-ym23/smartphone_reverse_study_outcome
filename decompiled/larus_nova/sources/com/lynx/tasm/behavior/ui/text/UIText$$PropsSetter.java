package com.lynx.tasm.behavior.ui.text;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class UIText$$PropsSetter extends UIGroup$$PropsSetter {
    public UIText$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        UIText r103 = (UIText) r100;
        r101.getClass();
        byte r104 = -1;
        switch(r101.hashCode()) {
            case -1157887457: goto L30;
            case -1145258555: goto L26;
            case 263767276: goto L22;
            case 298809032: goto L18;
            case 315007413: goto L14;
            case 543207321: goto L10;
            case 1137695781: goto L6;
            default: goto L33;
        };
    L33:
        switch(r104) {
            case 0: goto L48;
            case 1: goto L46;
            case 2: goto L44;
            case 3: goto L42;
            case 4: goto L40;
            case 5: goto L38;
            case 6: goto L36;
            default: goto L34;
        };
    L34:
        super.setProperty(r100, r101, r102);
        return;
    L36:
        r103.setSelectionBackgroundColor(r102.f(r101, 0));
        return;
    L38:
        r103.setCustomContextMenu(r102.b(r101, false));
        return;
    L40:
        r103.setAccessibilityLabel(r102.d(r101));
        return;
    L42:
        r103.setCustomTextSelection(r102.b(r101, false));
        return;
    L44:
        r103.setEnableTextSelection(r102.b(r101, false));
        return;
    L46:
        r103.setSelectionHandleSize(r102.f(r101, 0));
        return;
    L48:
        r103.setSelectionHandleColor(r102.f(r101, 0));
        return;
    L6:
        if (r101.equals("selection-background-color") == false) goto L33;
        r104 = 6;
        goto L33
    L10:
        if (r101.equals("custom-context-menu") == false) goto L33;
        r104 = 5;
        goto L33
    L14:
        if (r101.equals("accessibility-label") == false) goto L33;
        r104 = 4;
        goto L33
    L18:
        if (r101.equals("custom-text-selection") == false) goto L33;
        r104 = 3;
        goto L33
    L22:
        if (r101.equals("text-selection") == false) goto L33;
        r104 = 2;
        goto L33
    L26:
        if (r101.equals("selection-handle-size") == false) goto L33;
        r104 = 1;
        goto L33
    L30:
        if (r101.equals("selection-handle-color") == false) goto L33;
        r104 = 0;
        goto L33
    }
}
