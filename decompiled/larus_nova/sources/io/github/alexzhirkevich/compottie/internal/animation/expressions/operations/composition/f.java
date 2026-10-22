package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.composition;

import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public abstract class f implements io.github.alexzhirkevich.compottie.internal.animation.expressions.l<io.github.alexzhirkevich.compottie.internal.animation.expressions.g> {
    public f() {
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.l
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f b(String r100, List<? extends io.github.alexzhirkevich.compottie.internal.animation.expressions.f> r101) {
        if (r100 != null) goto L4;
    L30:
        return null;
    L4:
        switch(r100.hashCode()) {
            case -1221029593: goto L27;
            case -523940947: goto L23;
            case -279208415: goto L19;
            case 102749521: goto L15;
            case 113126854: goto L11;
            case 1016606824: goto L7;
            default: goto L30;
        };
    L7:
        if (r100.equals("numLayers") == false) goto L30;
        return io.github.alexzhirkevich.compottie.internal.animation.expressions.l.a.a(this, new a());
    L11:
        if (r100.equals("width") == false) goto L30;
        return io.github.alexzhirkevich.compottie.internal.animation.expressions.l.a.a(this, new b());
    L15:
        if (r100.equals(GXTemplateKey.GAIAX_LAYER) == false) goto L30;
        io.github.alexzhirkevich.compottie.internal.animation.expressions.v.a(r101, 1, r100);
        return new l(this, io.github.alexzhirkevich.compottie.internal.animation.expressions.m.a(r101, 0));
    L19:
        if (r100.equals("frameDuration") == false) goto L30;
        return io.github.alexzhirkevich.compottie.internal.animation.expressions.l.a.a(this, new e());
    L23:
        if (r100.equals("displayStartTime") == false) goto L30;
        return io.github.alexzhirkevich.compottie.internal.animation.expressions.l.a.a(this, new d());
    L27:
        if (r100.equals("height") == false) goto L30;
        return io.github.alexzhirkevich.compottie.internal.animation.expressions.l.a.a(this, new c());
    }
}
