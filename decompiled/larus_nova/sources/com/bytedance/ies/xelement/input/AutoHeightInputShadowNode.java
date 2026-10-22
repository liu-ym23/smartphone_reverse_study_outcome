package com.bytedance.ies.xelement.input;

import android.text.Editable;
import android.util.DisplayMetrics;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxShadowNode;
import com.lynx.tasm.behavior.shadow.LayoutNode;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@LynxShadowNode(tagName = "x-textarea")
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/xelement/input/AutoHeightInputShadowNode;", "Lcom/lynx/tasm/behavior/shadow/text/TextShadowNode;", "Lf6a/a;", "fontSize", "", "setFontTextSize", "<init>", "()V", "x-element-input_release"}, k = 1, mv = {1, 6, 0})
public class AutoHeightInputShadowNode extends TextShadowNode {
    public int H0;
    public float L0;
    public float P0;
    public float V0;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public LynxEditText f250008b1;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f250009p0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f250010a = null;

        static {
            int[] r100 = new int[ReadableType.values().length];
            r100[ReadableType.Number.ordinal()] = 1;
            r100[ReadableType.String.ordinal()] = 2;
            f250010a = r100;
        }
    }

    public final void X() {
        LynxEditText r100 = this.f250008b1;
        if (r100 == null) goto L14;
        Intrinsics.checkNotNull(r100);
        if (r100.getMaxHeight() < 0) goto L15;
        LynxEditText r101 = this.f250008b1;
        Intrinsics.checkNotNull(r101);
        if (r101.getMinHeight() < 0) goto L16;
        LynxEditText r102 = this.f250008b1;
        Intrinsics.checkNotNull(r102);
        if (r102.getHint() != null) goto L12;
        return;
    L12:
        LynxEditText r103 = this.f250008b1;
        Intrinsics.checkNotNull(r103);
        CharSequence r104 = r103.getHint();
        LynxEditText r105 = this.f250008b1;
        Intrinsics.checkNotNull(r105);
        this.f250009p0 = k.a(r104, r105, (int) this.V0).getHeight();
        LynxEditText r106 = this.f250008b1;
        Intrinsics.checkNotNull(r106);
        int r107 = r106.getMinHeight();
        LynxEditText r108 = this.f250008b1;
        Intrinsics.checkNotNull(r108);
        int r109 = r108.getMaxHeight();
        int r110 = Math.max(this.f250009p0, r107);
        this.f250009p0 = r110;
        this.f250009p0 = Math.min(r110, r109);
        return;
    L16:
        return;
    L15:
        return;
    }

    public final boolean Y() {
        LynxEditText r100 = this.f250008b1;
        if (r100 == null) goto L13;
        Intrinsics.checkNotNull(r100);
        if (r100.getMaxHeight() < 0) goto L13;
        LynxEditText r101 = this.f250008b1;
        Intrinsics.checkNotNull(r101);
        if (r101.getMinHeight() < 0) goto L13;
        int r102 = Math.min(Math.max(this.H0, this.f250009p0), (int) this.L0);
        LynxEditText r103 = this.f250008b1;
        Intrinsics.checkNotNull(r103);
        if (r103.getHeight() == r102) goto L13;
        q();
        return true;
    L13:
        return false;
    }

    public final void Z() {
        LynxEditText r100 = this.f250008b1;
        if (r100 == null) goto L14;
        Intrinsics.checkNotNull(r100);
        if (r100.getMaxHeight() < 0) goto L15;
        LynxEditText r101 = this.f250008b1;
        Intrinsics.checkNotNull(r101);
        if (r101.getMinHeight() < 0) goto L16;
        LynxEditText r102 = this.f250008b1;
        Intrinsics.checkNotNull(r102);
        if (r102.getEditableText() != null) goto L12;
        return;
    L12:
        LynxEditText r103 = this.f250008b1;
        Intrinsics.checkNotNull(r103);
        Editable r104 = r103.getEditableText();
        LynxEditText r105 = this.f250008b1;
        Intrinsics.checkNotNull(r105);
        this.H0 = k.a(r104, r105, (int) this.V0).getHeight();
        LynxEditText r106 = this.f250008b1;
        Intrinsics.checkNotNull(r106);
        int r107 = r106.getMinHeight();
        LynxEditText r108 = this.f250008b1;
        Intrinsics.checkNotNull(r108);
        int r109 = r108.getMaxHeight();
        int r110 = Math.max(this.H0, r107);
        this.H0 = r110;
        this.H0 = Math.min(r110, r109);
        return;
    L16:
        return;
    L15:
        return;
    }

    public AutoHeightInputShadowNode() {
        this.L0 = Float.MAX_VALUE;
        this.P0 = Float.MAX_VALUE;
        this.V0 = Float.MAX_VALUE;
    }

    @LynxProp(name = GXTemplateKey.STYLE_FONT_SIZE)
    public final void setFontTextSize(f6a.a r110) {
        DisplayMetrics r100 = null;
        if (r110 != null) goto L9;
        LynxContext r111 = this.f382220m;
        if (r111 == null) goto L7;
        r100 = r111.getScreenMetrics();
    L7:
        setFontSize(com.lynx.tasm.utils.n.c("14px", 0.0f, 0.0f, 0.0f, 0.0f, r100));
        return;
    L9:
        ReadableType r101 = r110.getType();
        if (r101 != null) goto L12;
        int r102 = -1;
    L14:
        if (r102 != 1) goto L16;
        setFontSize((float) r110.asDouble());
        return;
    L16:
        if (r102 != 2) goto L25;
        String r103 = r110.asString();
        LynxContext r112 = this.f382220m;
        if (r112 == null) goto L21;
        r100 = r112.getScreenMetrics();
    L21:
        setFontSize(com.lynx.tasm.utils.n.c(r103, 0.0f, 0.0f, 0.0f, 0.0f, r100));
        return;
    L25:
        return;
    L12:
        r102 = a.f250010a[r101.ordinal()];
        goto L14
    }

    @Override // com.lynx.tasm.behavior.shadow.text.TextShadowNode
    public final long c(LayoutNode r100, float r101, MeasureMode r102, float r103, MeasureMode r104) {
        Intrinsics.checkNotNullParameter(r100, "node");
        Intrinsics.checkNotNullParameter(r102, "widthMode");
        Intrinsics.checkNotNullParameter(r104, "heightMode");
        this.P0 = r103;
        this.V0 = r101;
        MeasureMode r105 = MeasureMode.EXACTLY;
        if (r104 != r105) goto L7;
        if (r102 != r105) goto L7;
        this.L0 = Float.MAX_VALUE;
        return y6a.i.a(r101, r103);
    L7:
        Z();
        X();
        float r106 = Math.max(this.H0, this.f250009p0);
        this.P0 = r106;
        if (r104 != MeasureMode.UNDEFINED) goto L11;
        this.L0 = Float.MAX_VALUE;
    L14:
        return y6a.i.a(r101, this.P0);
    L11:
        if (r104 != MeasureMode.AT_MOST) goto L14;
        this.L0 = r103;
        this.P0 = Math.min(r106, r103);
        goto L14
    }
}
