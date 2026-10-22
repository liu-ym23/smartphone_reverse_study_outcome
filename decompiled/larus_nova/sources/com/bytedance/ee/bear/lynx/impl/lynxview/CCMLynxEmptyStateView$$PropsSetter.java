package com.bytedance.ee.bear.lynx.impl.lynxview;

import com.bytedance.lark.lynxlib.widget.empty.LynxEmptyStateView$$PropsSetter;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes18.dex */
public class CCMLynxEmptyStateView$$PropsSetter extends LynxEmptyStateView$$PropsSetter {
    public CCMLynxEmptyStateView$$PropsSetter() {
    }

    @Override // com.bytedance.lark.lynxlib.widget.empty.LynxEmptyStateView$$PropsSetter, com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        CCMLynxEmptyStateView r103 = (CCMLynxEmptyStateView) r100;
        r101.getClass();
        if (r101.equals("img-res-enum") == true) goto L6;
        super.setProperty(r100, r101, r102);
        return;
    L6:
        r103.setImageResEnum(r102.f(r101, 0));
    }
}
