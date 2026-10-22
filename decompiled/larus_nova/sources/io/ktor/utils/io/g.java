package io.ktor.utils.io;

import io.ktor.utils.io.core.ByteOrder;

/* JADX INFO: loaded from: classes41.dex */
public final /* synthetic */ class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f492056a = null;

    static {
        int[] r100 = new int[ByteOrder.values().length];
        r100[ByteOrder.BIG_ENDIAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
    L4:
        f492056a = r100;
    }
}
