package com.bytedance.lighten.loader;

import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes20.dex */
public final class p implements MemoryTrimmableRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<MemoryTrimmable> f254777a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f254778a = null;

        static {
            f254778a = new p();
        }
    }

    public p() {
        this.f254777a = new CopyOnWriteArraySet();
    }

    public final void a(MemoryTrimType r100) {
        Objects.toString(r100);
        this.f254777a.size();
        Iterator<MemoryTrimmable> r101 = this.f254777a.iterator();     // Catch: Exception -> L8
    L5:
        if (r101.hasNext() == false) goto L15;
        r101.next().trim(r100);     // Catch: Exception -> L8
        goto L5
    L15:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.facebook.common.memory.MemoryTrimmableRegistry
    public final void registerMemoryTrimmable(MemoryTrimmable r100) {
        if (r100 == null) goto L5;
        this.f254777a.add(r100);
        return;
    }

    @Override // com.facebook.common.memory.MemoryTrimmableRegistry
    public final void unregisterMemoryTrimmable(MemoryTrimmable r100) {
        if (r100 == null) goto L5;
        this.f254777a.remove(r100);
        return;
    }
}
