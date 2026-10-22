package com.bytedance.jedi.model.guava.cache;

import com.bytedance.jedi.model.guava.annotations.NullableDecl;
import java.util.AbstractMap;

/* JADX INFO: loaded from: classes19.dex */
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;
    private final RemovalCause cause;

    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }

    public RemovalCause getCause() {
        return this.cause;
    }

    public RemovalNotification(@NullableDecl K r100, @NullableDecl V r101, RemovalCause r102) {
        super(r100, r101);
        r102.getClass();
        this.cause = r102;
    }

    public static <K, V> RemovalNotification<K, V> create(K r100, V r101, RemovalCause r102) {
        return new RemovalNotification(r100, r101, r102);
    }
}
