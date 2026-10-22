package com.bytedance.ies.xelement.text.inlinetruncation;

import android.text.SpannableStringBuilder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxShadowNode;
import com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@LynxShadowNode(tagName = "x-inline-truncation")
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/xelement/text/inlinetruncation/LynxInlineTruncationShadowNode;", "Lcom/lynx/tasm/behavior/shadow/text/TextShadowNode;", "", "stick", "", "setStick", "<init>", "()V", "x-element-text_release"}, k = 1, mv = {1, 6, 0})
public final class LynxInlineTruncationShadowNode extends TextShadowNode {

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f250388p0;

    public LynxInlineTruncationShadowNode() {
    }

    @LynxProp(name = "stick")
    public final void setStick(boolean r100) {
        this.f250388p0 = r100;
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public final void G(SpannableStringBuilder r100, List<BaseTextShadowNode.a> r101) {
        SpannableStringBuilder r102 = new SpannableStringBuilder();
        ArrayList r103 = new ArrayList();
        super.G(r102, r103);
        int r104 = r103.size() - 1;
        if (r104 < 0) goto L9;
    L4:
        int r105 = r104 - 1;
        ((BaseTextShadowNode.a) ListProtector.get(r103, r104)).a(r102);
        if (r105 < 0) goto L9;
        r104 = r105;
    L9:
        if (r() == false) goto L11;
        r102.setSpan(A(), 0, r102.length(), 18);
    L11:
        this.N = r102;
    }
}
