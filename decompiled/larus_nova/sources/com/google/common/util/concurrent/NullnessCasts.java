package com.google.common.util.concurrent;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class NullnessCasts {
    private NullnessCasts() {
    }

    @ParametricNullness
    public static <T> T uncheckedCastNullableTToT(@CheckForNull T r100) {
        return r100;
    }

    @ParametricNullness
    public static <T> T uncheckedNull() {
        return null;
    }
}
