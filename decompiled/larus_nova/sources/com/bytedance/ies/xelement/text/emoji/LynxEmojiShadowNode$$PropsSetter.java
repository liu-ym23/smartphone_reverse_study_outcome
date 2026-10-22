package com.bytedance.ies.xelement.text.emoji;

import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes19.dex */
public class LynxEmojiShadowNode$$PropsSetter extends TextShadowNode$$PropsSetter {
    public LynxEmojiShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.TextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public final void a(ShadowNode r100, String r101, x0 r102) {
        LynxEmojiShadowNode r103 = (LynxEmojiShadowNode) r100;
        r101.getClass();
        if (r101.equals("emoji-name") == true) goto L6;
        super.a(r100, r101, r102);
        return;
    L6:
        r103.setEmojiName(r102.h(r101));
    }
}
