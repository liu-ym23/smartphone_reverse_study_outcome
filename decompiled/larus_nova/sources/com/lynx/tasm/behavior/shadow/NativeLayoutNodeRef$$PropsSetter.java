package com.lynx.tasm.behavior.shadow;

import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class NativeLayoutNodeRef$$PropsSetter extends ShadowNode$$PropsSetter {
    public NativeLayoutNodeRef$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public final void a(ShadowNode r100, String r101, x0 r102) {
        NativeLayoutNodeRef r103 = (NativeLayoutNodeRef) r100;
        r101.getClass();
        if (r101.equals("vertical-align") == false) goto L5;
        r103.setVerticalAlign(r102.a(r101));
        return;
    L5:
        if (r101.equals("idSelector") == true) goto L8;
        super.a(r100, r101, r102);
        return;
    L8:
        r103.setIdSelector(r102.h(r101));
    }
}
