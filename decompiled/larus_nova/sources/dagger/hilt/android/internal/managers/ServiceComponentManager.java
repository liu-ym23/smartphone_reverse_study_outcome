package dagger.hilt.android.internal.managers;

import android.app.Application;
import android.app.Service;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.internal.GeneratedComponentManager;
import dagger.hilt.internal.Preconditions;

/* JADX INFO: loaded from: classes41.dex */
public final class ServiceComponentManager implements GeneratedComponentManager<Object> {

    /* JADX INFO: renamed from: component, reason: collision with root package name */
    private Object f467787component;
    private final Service service;

    public interface ServiceComponentBuilderEntryPoint {
        ServiceComponentBuilder serviceComponentBuilder();
    }

    private Object createComponent() {
        Application r100 = this.service.getApplication();
        Preconditions.checkState(r100 instanceof GeneratedComponentManager, "Hilt service must be attached to an @AndroidEntryPoint Application. Found: %s", new Object[]{r100.getClass()});
        return ((ServiceComponentBuilderEntryPoint) EntryPoints.get(r100, ServiceComponentBuilderEntryPoint.class)).serviceComponentBuilder().service(this.service).build();
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public Object generatedComponent() {
        if (this.f467787component != null) goto L6;
        this.f467787component = createComponent();
    L6:
        return this.f467787component;
    }

    public ServiceComponentManager(Service r100) {
        this.service = r100;
    }
}
