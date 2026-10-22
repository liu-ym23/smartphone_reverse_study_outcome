package io.github.alexzhirkevich.compottie.internal.animation.expressions;

import java.util.List;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public interface l<T> extends f {

    public static final class a {
        /* JADX WARN: Type inference failed for: r0v1, types: [io.github.alexzhirkevich.compottie.internal.animation.expressions.i] */
        public static i a(final l r100, final Function4 r101) {
            Intrinsics.checkNotNullParameter(r101, "block");
            return new i(r101, r100);
        }
    }

    f b(String r100, List<? extends f> r101);
}
