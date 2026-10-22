package com.google.common.base;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public interface g<F, T> {
    @ParametricNullness
    T apply(@ParametricNullness F r100);

    boolean equals(@CheckForNull Object r100);
}
