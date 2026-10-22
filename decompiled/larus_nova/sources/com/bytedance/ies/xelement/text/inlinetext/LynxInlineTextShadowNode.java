package com.bytedance.ies.xelement.text.inlinetext;

import android.text.SpannableStringBuilder;
import com.bytedance.ies.xelement.text.emoji.g;
import com.bytedance.ies.xelement.text.text.LynxTextShadowNode;
import com.lynx.config.LynxLiteConfigs;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxShadowNode;
import com.lynx.tasm.behavior.shadow.text.InlineTextShadowNode;
import com.lynx.tasm.behavior.utils.f;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes19.dex */
@LynxShadowNode(tagName = "x-inline-text")
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/xelement/text/inlinetext/LynxInlineTextShadowNode;", "Lcom/lynx/tasm/behavior/shadow/text/InlineTextShadowNode;", "", "noTrim", "", "setNoTrim", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "x-element-text_release"}, k = 1, mv = {1, 6, 0})
public final class LynxInlineTextShadowNode extends InlineTextShadowNode {
    public boolean P;
    public String Q;

    public static final class a {
    }

    static {
    }

    public LynxInlineTextShadowNode() {
        this.Q = "none";
    }

    @LynxProp(defaultBoolean = true, name = "no-trim")
    public final void setNoTrim(boolean r100) {
        this.P = r100;
        q();
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public final void E(SpannableStringBuilder r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "sb");
        if (this.P == true) goto L9;
        Regex r103 = LynxTextShadowNode.V0;
        if (r101 == null) goto L7;
        r101 = f.a(LynxTextShadowNode.V0.replace(r101, ""), 0);
        goto L9
    L7:
        r101 = null;
    L9:
        if (LynxLiteConfigs.supportCustomEmojiInText() == true) goto L11;
        r100.append(r101);
        return;
    L11:
        if (Intrinsics.areEqual(this.Q, "bracket") == false) goto L13;
        Pattern r104 = g.f250386a;
        r100.append(g.a(getContext(), r101, (int) this.f382232v.f382258n));
        return;
    L13:
        r100.append(r101);
    }
}
