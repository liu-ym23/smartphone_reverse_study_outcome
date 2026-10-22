package com.lynx.tasm.behavior.shadow.text;

import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class RawTextShadowNode$$PropsSetter extends ShadowNode$$PropsSetter {
    public RawTextShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public final void a(ShadowNode r100, String r101, x0 r102) {
        RawTextShadowNode r103 = (RawTextShadowNode) r100;
        r101.getClass();
        if (r101.equals("pseudo") == false) goto L5;
        r103.setPsuedo(r102.b(r101, false));
        return;
    L5:
        if (r101.equals("text") == true) goto L8;
        super.a(r100, r101, r102);
        return;
    L8:
        r103.setText(r102.d(r101));
    }
}
