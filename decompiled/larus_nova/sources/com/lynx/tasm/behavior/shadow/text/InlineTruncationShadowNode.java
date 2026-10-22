package com.lynx.tasm.behavior.shadow.text;

import android.text.SpannableStringBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public class InlineTruncationShadowNode extends BaseTextShadowNode {
    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final boolean p() {
        return true;
    }

    public InlineTruncationShadowNode() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public final void G(SpannableStringBuilder r100, List<BaseTextShadowNode.a> r101) {
        super.G(r100, r101);
        if (r() == false) goto L6;
        r100.setSpan(A(), 0, r100.length(), 18);
        return;
    }
}
