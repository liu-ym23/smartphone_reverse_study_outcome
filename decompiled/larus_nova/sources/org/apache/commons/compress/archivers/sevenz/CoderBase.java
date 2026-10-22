package org.apache.commons.compress.archivers.sevenz;

/* JADX INFO: loaded from: classes42.dex */
abstract class CoderBase {
    private static final byte[] NONE = null;
    private final Class<?>[] acceptableOptions;

    static {
        NONE = new byte[0];
    }

    public CoderBase(Class<?>... r100) {
        this.acceptableOptions = r100;
    }
}
