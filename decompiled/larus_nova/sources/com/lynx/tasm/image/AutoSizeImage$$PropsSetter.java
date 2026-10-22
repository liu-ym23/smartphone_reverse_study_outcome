package com.lynx.tasm.image;

import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class AutoSizeImage$$PropsSetter extends ShadowNode$$PropsSetter {
    public AutoSizeImage$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public final void a(ShadowNode r100, String r101, x0 r102) {
        AutoSizeImage r103 = (AutoSizeImage) r100;
        r101.getClass();
        if (r101.equals("src") == true) goto L6;
        super.a(r100, r101, r102);
        return;
    L6:
        r103.setSrc(r102.h(r101));
    }
}
