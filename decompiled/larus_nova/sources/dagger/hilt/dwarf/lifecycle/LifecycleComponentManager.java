package dagger.hilt.dwarf.lifecycle;

import dagger.hilt.dwarf.internal.MultiGeneratedComponentManager;
import grc.a;
import grc.b;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes41.dex */
public abstract class LifecycleComponentManager<KEY, COMPONENT, PAYLOAD> implements MultiGeneratedComponentManager<KEY, COMPONENT, PAYLOAD> {
    private final Map<KEY, COMPONENT> components;
    private final Object componentsLock;

    @Nullable
    private final Executor lifecycleExecutor;

    public LifecycleComponentManager() {
        this(null);
    }

    public static /* synthetic */ void a(Set r100) {
        lambda$generatedComponent$0(r100);
    }

    public static /* synthetic */ void b(Set r100) {
        lambda$destroyComponent$1(r100);
    }

    public abstract COMPONENT createComponent(KEY r100, PAYLOAD r101);

    public LifecycleComponentManager(@Nullable Executor r100) {
        this.components = new ConcurrentHashMap();
        this.componentsLock = new Object();
        this.lifecycleExecutor = r100;
    }

    private static /* synthetic */ void lambda$destroyComponent$1(Set r100) {
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((ComponentLifecycleAware) r101.next()).onComponentDestroy();
        goto L4
    }

    private static /* synthetic */ void lambda$generatedComponent$0(Set r100) {
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((ComponentLifecycleAware) r101.next()).onComponentCreate();
        goto L4
    }

    @Override // dagger.hilt.dwarf.internal.MultiGeneratedComponentManager
    public COMPONENT destroyComponent(KEY r100) {
        Object r101 = this.componentsLock;
        monitor-enter(r101);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.components.containsKey(r100) == false) goto L14;
        COMPONENT r102 = this.components.remove(r100);     // Catch: Throwable -> L17
        if ((r102 instanceof ComponentLifecycleEntryPoint) == false) goto L12;
        final Set<ComponentLifecycleAware> r103 = ((ComponentLifecycleEntryPoint) r102).getLifecycleAwares();     // Catch: Throwable -> L17
        Runnable r104 = new a(r103);     // Catch: Throwable -> L17
        Executor r105 = this.lifecycleExecutor;     // Catch: Throwable -> L17
        if (r105 == null) goto L11;
        r105.execute(r104);     // Catch: Throwable -> L17
        goto L12
    L11:
        r104.run();     // Catch: Throwable -> L17
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L17
        return r102;
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L17
        return null;
    }

    @Override // dagger.hilt.dwarf.internal.MultiGeneratedComponentManager
    public COMPONENT findComponent(KEY r100) {
        return this.components.get(r100);
    }

    @Override // dagger.hilt.dwarf.internal.MultiGeneratedComponentManager
    public COMPONENT generatedComponent(KEY r100, PAYLOAD r101) {
        Object r102 = this.componentsLock;
        monitor-enter(r102);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.components.containsKey(r100) == true) goto L12;
        COMPONENT r103 = createComponent(r100, r101);     // Catch: Throwable -> L15
        this.components.put(r100, r103);     // Catch: Throwable -> L15
        if ((r103 instanceof ComponentLifecycleEntryPoint) == false) goto L12;
        final Set<ComponentLifecycleAware> r104 = ((ComponentLifecycleEntryPoint) r103).getLifecycleAwares();     // Catch: Throwable -> L15
        Runnable r105 = new b(r104);     // Catch: Throwable -> L15
        Executor r106 = this.lifecycleExecutor;     // Catch: Throwable -> L15
        if (r106 == null) goto L11;
        r106.execute(r105);     // Catch: Throwable -> L15
        goto L12
    L11:
        r105.run();     // Catch: Throwable -> L15
    L12:
        COMPONENT r107 = this.components.get(r100);     // Catch: Throwable -> L15
        monitor-exit(r102);     // Catch: Throwable -> L15
        return r107;
    }
}
