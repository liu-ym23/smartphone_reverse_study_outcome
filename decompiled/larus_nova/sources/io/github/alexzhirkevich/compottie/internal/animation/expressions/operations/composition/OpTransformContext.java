package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.composition;

import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: loaded from: classes41.dex */
public abstract class OpTransformContext implements io.github.alexzhirkevich.compottie.internal.animation.expressions.f, io.github.alexzhirkevich.compottie.internal.animation.expressions.l<io.github.alexzhirkevich.compottie.internal.animation.z0> {
    public OpTransformContext() {
    }

    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.i c(final PropertyReference1Impl r100) {
        return io.github.alexzhirkevich.compottie.internal.animation.expressions.l.a.a(this, new a1(r100));
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.l
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f b(String r100, List<? extends io.github.alexzhirkevich.compottie.internal.animation.expressions.f> r101) {
        if (r101 == null) goto L5;
        return null;
    L5:
        if (r100 != null) goto L7;
        return null;
    L7:
        switch(r100.hashCode()) {
            case -1267206133: goto L42;
            case -1249320806: goto L38;
            case -1249320805: goto L34;
            case -1249320804: goto L30;
            case -40300674: goto L26;
            case 3532042: goto L22;
            case 109250890: goto L18;
            case 747804969: goto L14;
            case 2036837323: goto L10;
            default: goto L55;
        };
    L55:
        return null;
    L10:
        if (r100.equals("skewAxis") == true) goto L47;
        return null;
    L47:
        return c(OpTransformContext$interpret$8.INSTANCE);
    L14:
        if (r100.equals("position") == true) goto L48;
        return null;
    L48:
        return c(OpTransformContext$interpret$9.INSTANCE);
    L18:
        if (r100.equals("scale") == true) goto L49;
        return null;
    L49:
        return c(OpTransformContext$interpret$5.INSTANCE);
    L22:
        if (r100.equals("skew") == true) goto L50;
        return null;
    L50:
        return c(OpTransformContext$interpret$7.INSTANCE);
    L26:
        if (r100.equals("rotation") == true) goto L51;
        return null;
    L51:
        return c(OpTransformContext$interpret$1.INSTANCE);
    L30:
        if (r100.equals("rotationZ") == true) goto L52;
        return null;
    L52:
        return c(OpTransformContext$interpret$4.INSTANCE);
    L34:
        if (r100.equals("rotationY") == true) goto L53;
        return null;
    L53:
        return c(OpTransformContext$interpret$3.INSTANCE);
    L38:
        if (r100.equals("rotationX") == true) goto L54;
        return null;
    L54:
        return c(OpTransformContext$interpret$2.INSTANCE);
    L42:
        if (r100.equals(GXTemplateKey.STYLE_OPACITY) == true) goto L45;
        return null;
    L45:
        return c(OpTransformContext$interpret$6.INSTANCE);
    }
}
