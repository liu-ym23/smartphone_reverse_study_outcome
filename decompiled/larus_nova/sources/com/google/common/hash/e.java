package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;

/* JADX INFO: loaded from: classes23.dex */
@Immutable
@ElementTypesAreNonnullByDefault
public interface e {
    <T> HashCode hashObject(@ParametricNullness T r100, Funnel<? super T> r101);

    f newHasher();
}
