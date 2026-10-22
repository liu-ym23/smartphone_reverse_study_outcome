package dagger.hilt.android.internal.managers;

import dagger.hilt.internal.GeneratedComponentManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class ApplicationComponentManager implements GeneratedComponentManager<Object> {
    private volatile Object component;
    private final ComponentSupplier componentCreator;
    private final Object componentLock;

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public Object generatedComponent() {
        if (this.component != null) goto L15;
        Object r0 = this.componentLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.component != null) goto L9;
        this.component = this.componentCreator.get();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return this.component;
    }

    public ApplicationComponentManager(ComponentSupplier r2) {
        this.componentLock = new Object();
        this.componentCreator = r2;
    }
}
