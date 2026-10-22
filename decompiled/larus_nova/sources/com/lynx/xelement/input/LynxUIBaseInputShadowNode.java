package com.lynx.xelement.input;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.shadow.LayoutNode;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode;
import com.lynx.tasm.utils.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lcom/lynx/xelement/input/LynxUIBaseInputShadowNode;", "Lcom/lynx/tasm/behavior/shadow/text/TextShadowNode;", "Lf6a/a;", "lineSpacing", "", "setLineSpacingStr", "<init>", "()V", "Input_release"}, k = 1, mv = {1, 6, 0})
public class LynxUIBaseInputShadowNode extends TextShadowNode {

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f384171p0;

    public LynxUIBaseInputShadowNode() {
    }

    @LynxProp(name = GXTemplateKey.GAIAX_LAYER_LINE_SPACING)
    public final void setLineSpacingStr(f6a.a r110) {
        Intrinsics.checkNotNullParameter(r110, "lineSpacing");
        if (r110.getType() != ReadableType.String) goto L6;
        float r111 = n.b(r110.asString(), 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, getContext().getScreenMetrics());
    L12:
        setLineSpacing(r111);
        return;
    L6:
        if (r110.getType() != ReadableType.Number) goto L8;
    L11:
        r111 = com.lynx.tasm.utils.i.a(r110.asDouble());
        goto L12
    L8:
        if (r110.getType() == ReadableType.Int) goto L11;
        r111 = 0.0f;
        goto L12
    }

    @Override // com.lynx.tasm.behavior.shadow.text.TextShadowNode
    public final long c(LayoutNode r100, float r101, MeasureMode r102, float r103, MeasureMode r104) {
        Intrinsics.checkNotNullParameter(r100, "node");
        Intrinsics.checkNotNullParameter(r102, "widthMode");
        Intrinsics.checkNotNullParameter(r104, "heightMode");
        if (r104 != MeasureMode.UNDEFINED) goto L6;
        r103 = this.f384171p0;
    L9:
        return y6a.i.a(r101, r103);
    L6:
        if (r104 != MeasureMode.AT_MOST) goto L9;
        r103 = Math.min(this.f384171p0, r103);
        goto L9
    }
}
