package io.ktor.utils.io.core;

import java.io.EOFException;

/* JADX INFO: loaded from: classes41.dex */
public final class d {
    public static final void a(int r100, int r101) {
        throw new EOFException("Unable to discard " + r100 + " bytes: only " + r101 + " available for writing");
    }

    public static final void b(int r100, int r101) {
        throw new EOFException("Unable to discard " + r100 + " bytes: only " + r101 + " available for reading");
    }
}
