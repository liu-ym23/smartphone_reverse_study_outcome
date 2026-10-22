package dagger.hilt.android.internal.managers;

import dagger.hilt.internal.GeneratedComponentManager;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationComponentManager implements GeneratedComponentManager<Object> {

    /* JADX INFO: renamed from: component, reason: collision with root package name */
    private volatile Object f467785component;
    private final ComponentSupplier componentCreator;
    private final Object componentLock;

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public Object generatedComponent() {
        if (this.f467785component != null) goto L15;
        Object r100 = this.componentLock;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f467785component != null) goto L9;
        this.f467785component = this.componentCreator.get();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L15:
        return this.f467785component;
    }

    public ApplicationComponentManager(ComponentSupplier r100) {
        this.componentLock = new Object();
        this.componentCreator = r100;
    }
}
