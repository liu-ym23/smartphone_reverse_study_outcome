package com.obric.memorydata.plugin_api;

import com.obric.aiagent.sharedstate.SharedState;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public class MemoryPluginActiveProviderRegistry {
    private static final String KEY_ACTIVE = "memorydata_active_state";
    private final AtomicInteger originActive;
    private final CopyOnWriteArraySet<MemoryPluginActiveProvider> providers;

    /* JADX INFO: loaded from: classes33.dex */
    public static /* synthetic */ class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final MemoryPluginActiveProviderRegistry f397049a = null;

        static {
            f397049a = new MemoryPluginActiveProviderRegistry(null);
        }
    }

    public boolean isActiveInProcess() {
        Iterator<MemoryPluginActiveProvider> r100 = this.providers.iterator();
        boolean r101 = false;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 | r100.next().isActive();
        goto L4
    L6:
        return r101;
    }

    private MemoryPluginActiveProviderRegistry() {
        this.providers = new CopyOnWriteArraySet();
        this.originActive = new AtomicInteger(-1);
    }

    public void onActiveChange() {
        boolean r100 = isActiveInProcess();
        boolean r101 = false;
        if (this.originActive.getAndSet(r100 ? 1 : 0) == r100) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L12;
        SharedState r103 = SharedState.INSTANCE;
        if (r100 != true) goto L10;
        r101 = true;
    L10:
        r103.putBoolean("memorydata_active_state", r101);
        return;
    L12:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public static MemoryPluginActiveProviderRegistry getInstance() {
        return b.f397049a;
    }

    public /* synthetic */ MemoryPluginActiveProviderRegistry(a r100) {
        this();
    }

    public void addProvider(MemoryPluginActiveProvider r100) {
        this.providers.add(r100);
        onActiveChange();
    }
}
