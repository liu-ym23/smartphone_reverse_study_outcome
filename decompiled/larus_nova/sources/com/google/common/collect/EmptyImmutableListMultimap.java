package com.google.common.collect;

import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
class EmptyImmutableListMultimap extends ImmutableListMultimap<Object, Object> {
    static final EmptyImmutableListMultimap INSTANCE = null;
    private static final long serialVersionUID = 0;

    static {
        INSTANCE = new EmptyImmutableListMultimap();
    }

    private EmptyImmutableListMultimap() {
        super(ImmutableMap.of(), 0);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public ImmutableMap<Object, Collection<Object>> asMap() {
        return super.asMap();
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Map asMap() {
        return asMap();
    }
}
