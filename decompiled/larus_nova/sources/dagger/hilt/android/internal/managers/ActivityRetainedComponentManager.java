package dagger.hilt.android.internal.managers;

import android.content.Context;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.internal.ThreadUtil;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.internal.GeneratedComponentManager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes41.dex */
final class ActivityRetainedComponentManager implements GeneratedComponentManager<ActivityRetainedComponent> {

    /* JADX INFO: renamed from: component, reason: collision with root package name */
    private volatile ActivityRetainedComponent f467783component;
    private final Object componentLock;
    private final ViewModelProvider viewModelProvider;

    public interface ActivityRetainedComponentBuilderEntryPoint {
        ActivityRetainedComponentBuilder retainedComponentBuilder();
    }

    public static final class ActivityRetainedComponentViewModel extends ViewModel {

        /* JADX INFO: renamed from: component, reason: collision with root package name */
        private final ActivityRetainedComponent f467784component;

        @Override // androidx.lifecycle.ViewModel
        public void onCleared() {
            super.onCleared();
            ((Lifecycle) ((ActivityRetainedLifecycleEntryPoint) EntryPoints.get(this.f467784component, ActivityRetainedLifecycleEntryPoint.class)).getActivityRetainedLifecycle()).dispatchOnCleared();
        }

        public ActivityRetainedComponent getComponent() {
            return this.f467784component;
        }

        public ActivityRetainedComponentViewModel(ActivityRetainedComponent r100) {
            this.f467784component = r100;
        }
    }

    public interface ActivityRetainedLifecycleEntryPoint {
        ActivityRetainedLifecycle getActivityRetainedLifecycle();
    }

    public static final class Lifecycle implements ActivityRetainedLifecycle {
        private final Set<ActivityRetainedLifecycle.OnClearedListener> listeners;
        private boolean onClearedDispatched;

        private void throwIfOnClearedDispatched() {
            if (this.onClearedDispatched == true) goto L6;
            return;
        L6:
            throw new IllegalStateException("There was a race between the call to add/remove an OnClearedListener and onCleared(). This can happen when posting to the Main thread from a background thread, which is not supported.");
        }

        @Inject
        public Lifecycle() {
            this.listeners = new HashSet();
            this.onClearedDispatched = false;
        }

        public void dispatchOnCleared() {
            ThreadUtil.ensureMainThread();
            this.onClearedDispatched = true;
            Iterator<ActivityRetainedLifecycle.OnClearedListener> r100 = this.listeners.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            r100.next().onCleared();
            goto L4
        }

        @Override // dagger.hilt.android.ActivityRetainedLifecycle
        public void addOnClearedListener(ActivityRetainedLifecycle.OnClearedListener r100) {
            ThreadUtil.ensureMainThread();
            throwIfOnClearedDispatched();
            this.listeners.add(r100);
        }

        @Override // dagger.hilt.android.ActivityRetainedLifecycle
        public void removeOnClearedListener(ActivityRetainedLifecycle.OnClearedListener r100) {
            ThreadUtil.ensureMainThread();
            throwIfOnClearedDispatched();
            this.listeners.remove(r100);
        }
    }

    @Module
    public static abstract class LifecycleModule {
        public LifecycleModule() {
        }

        @Binds
        public abstract ActivityRetainedLifecycle bind(Lifecycle r100);
    }

    private ActivityRetainedComponent createComponent() {
        return ((ActivityRetainedComponentViewModel) this.viewModelProvider.get(ActivityRetainedComponentViewModel.class)).getComponent();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // dagger.hilt.internal.GeneratedComponentManager
    public ActivityRetainedComponent generatedComponent() {
        if (this.f467783component != null) goto L15;
        Object r100 = this.componentLock;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f467783component != null) goto L9;
        this.f467783component = createComponent();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L15:
        return this.f467783component;
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public /* bridge */ /* synthetic */ ActivityRetainedComponent generatedComponent() {
        return generatedComponent();
    }

    public ActivityRetainedComponentManager(ComponentActivity r100) {
        this.componentLock = new Object();
        this.viewModelProvider = getViewModelProvider(r100, r100);
    }

    private ViewModelProvider getViewModelProvider(ViewModelStoreOwner r100, final Context r101) {
        return new ViewModelProvider(r100, new AnonymousClass1(this, r101));
    }
}
