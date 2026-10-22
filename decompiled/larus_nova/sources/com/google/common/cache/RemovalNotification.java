package com.google.common.cache;

import java.util.AbstractMap;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;
    private final RemovalCause cause;

    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }

    public RemovalCause getCause() {
        return this.cause;
    }

    public RemovalNotification(@CheckForNull K r100, @CheckForNull V r101, RemovalCause r102) {
        super(r100, r101);
        r102.getClass();
        this.cause = r102;
    }

    public static <K, V> RemovalNotification<K, V> create(@CheckForNull K r100, @CheckForNull V r101, RemovalCause r102) {
        return new RemovalNotification(r100, r101, r102);
    }
}
