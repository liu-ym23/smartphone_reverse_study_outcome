package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.composition;

import com.alibaba.gaiax.template.GXTemplateKey;
import io.github.alexzhirkevich.compottie.internal.shapes.Shape;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public abstract class OpShapeContext implements io.github.alexzhirkevich.compottie.internal.animation.expressions.l<Shape> {
    public OpShapeContext() {
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.l
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f b(final String r100, List<? extends io.github.alexzhirkevich.compottie.internal.animation.expressions.f> r101) {
        if (r101 != null) goto L4;
        if (r100 != null) goto L8;
    L59:
        return null;
    L8:
        switch(r100.hashCode()) {
            case -1267206133: goto L55;
            case -1249320806: goto L51;
            case -1249320805: goto L47;
            case -1249320804: goto L43;
            case -40300674: goto L39;
            case 3433509: goto L35;
            case 3530753: goto L31;
            case 3532042: goto L27;
            case 94842723: goto L23;
            case 109250890: goto L19;
            case 747804969: goto L15;
            case 2036837323: goto L11;
            default: goto L59;
        };
    L11:
        if (r100.equals("skewAxis") == false) goto L59;
        final OpShapeContext$interpret$7 r102 = OpShapeContext$interpret$7.INSTANCE;
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r103 = new y0(this, r102, r100);
    L66:
        return r103;
    L15:
        if (r100.equals("position") == false) goto L59;
        return new z0(this);
    L19:
        if (r100.equals("scale") == false) goto L59;
        final OpShapeContext$interpret$1 r104 = OpShapeContext$interpret$1.INSTANCE;
        r103 = new y0(this, r104, r100);
        goto L66
    L23:
        if (r100.equals("color") == false) goto L59;
        return new v0(this);
    L27:
        if (r100.equals("skew") == false) goto L59;
        final OpShapeContext$interpret$6 r105 = OpShapeContext$interpret$6.INSTANCE;
        r103 = new y0(this, r105, r100);
        goto L66
    L31:
        if (r100.equals("size") == false) goto L59;
        return new x0(this);
    L35:
        if (r100.equals("path") == false) goto L59;
        return new w0(this);
    L39:
        if (r100.equals("rotation") == false) goto L59;
        final OpShapeContext$interpret$2 r106 = OpShapeContext$interpret$2.INSTANCE;
        r103 = new y0(this, r106, r100);
        goto L66
    L43:
        if (r100.equals("rotationZ") == false) goto L59;
        final OpShapeContext$interpret$5 r107 = OpShapeContext$interpret$5.INSTANCE;
        r103 = new y0(this, r107, r100);
        goto L66
    L47:
        if (r100.equals("rotationY") == false) goto L59;
        final OpShapeContext$interpret$4 r108 = OpShapeContext$interpret$4.INSTANCE;
        r103 = new y0(this, r108, r100);
        goto L66
    L51:
        if (r100.equals("rotationX") == false) goto L59;
        final OpShapeContext$interpret$3 r109 = OpShapeContext$interpret$3.INSTANCE;
        r103 = new y0(this, r109, r100);
        goto L66
    L55:
        if (r100.equals(GXTemplateKey.STYLE_OPACITY) == false) goto L59;
        final OpShapeContext$interpret$8 r110 = OpShapeContext$interpret$8.INSTANCE;
        r103 = new y0(this, r110, r100);
        goto L66
    L4:
        if (Intrinsics.areEqual(r100, "content") == false) goto L59;
        io.github.alexzhirkevich.compottie.internal.animation.expressions.v.a(r101, 1, r100);
        return new o(this, io.github.alexzhirkevich.compottie.internal.animation.expressions.m.a(r101, 0));
    }
}
