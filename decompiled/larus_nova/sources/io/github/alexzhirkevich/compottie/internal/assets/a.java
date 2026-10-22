package io.github.alexzhirkevich.compottie.internal.assets;

import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ouc.g;
import ouc.i;
import ouc.k;

/* JADX INFO: loaded from: classes41.dex */
public final class a extends g<d> {
    public a() {
        super(Reflection.getOrCreateKotlinClass(d.class));
    }

    @Override // ouc.g
    public final juc.c<d> a(i r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        if (k.n(r100).keySet().contains(GXTemplateKey.GAIAX_LAYERS) == false) goto L6;
        return PrecompositionAsset.Companion.serializer();
    L6:
        if (k.n(r100).keySet().contains("p") == false) goto L9;
        return c.Companion.serializer();
    L9:
        return d.b.Companion.serializer();
    }
}
