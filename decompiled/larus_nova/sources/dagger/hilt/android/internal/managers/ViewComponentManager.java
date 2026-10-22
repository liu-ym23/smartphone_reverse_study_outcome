package dagger.hilt.android.internal.managers;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleEventObserver;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.internal.Contexts;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.internal.GeneratedComponentManager;
import dagger.hilt.internal.Preconditions;

/* JADX INFO: loaded from: classes41.dex */
public final class ViewComponentManager implements GeneratedComponentManager<Object> {

    /* JADX INFO: renamed from: component, reason: collision with root package name */
    private volatile Object f467788component;
    private final Object componentLock;
    private final boolean hasFragmentBindings;
    private final View view;

    public static final class FragmentContextWrapper extends ContextWrapper {
        private LayoutInflater baseInflater;
        private Fragment fragment;
        private final LifecycleEventObserver fragmentLifecycleObserver;
        private LayoutInflater inflater;

        public Fragment getFragment() {
            Preconditions.checkNotNull(this.fragment, "The fragment has already been destroyed.");
            return this.fragment;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String r100) {
            if ("layout_inflater".equals(r100) == true) goto L7;
            return getBaseContext().getSystemService(r100);
        L7:
            if (this.inflater != null) goto L13;
            if (this.baseInflater != null) goto L11;
            this.baseInflater = (LayoutInflater) getBaseContext().getSystemService("layout_inflater");
        L11:
            this.inflater = this.baseInflater.cloneInContext(this);
        L13:
            return this.inflater;
        }

        public FragmentContextWrapper(LayoutInflater r100, Fragment r101) {
            super((Context) Preconditions.checkNotNull(((LayoutInflater) Preconditions.checkNotNull(r100)).getContext()));
            LifecycleEventObserver r102 = new AnonymousClass1(this);
            this.fragmentLifecycleObserver = r102;
            this.baseInflater = r100;
            Fragment r103 = (Fragment) Preconditions.checkNotNull(r101);
            this.fragment = r103;
            r103.getLifecycle().addObserver(r102);
        }

        public static /* synthetic */ Fragment access$002(FragmentContextWrapper r100, Fragment r101) {
            r100.fragment = r101;
            return r101;
        }

        public static /* synthetic */ LayoutInflater access$102(FragmentContextWrapper r100, LayoutInflater r101) {
            r100.baseInflater = r101;
            return r101;
        }

        public static /* synthetic */ LayoutInflater access$202(FragmentContextWrapper r100, LayoutInflater r101) {
            r100.inflater = r101;
            return r101;
        }

        public FragmentContextWrapper(Context r100, Fragment r101) {
            super((Context) Preconditions.checkNotNull(r100));
            LifecycleEventObserver r102 = new AnonymousClass1(this);
            this.fragmentLifecycleObserver = r102;
            this.baseInflater = null;
            Fragment r103 = (Fragment) Preconditions.checkNotNull(r101);
            this.fragment = r103;
            r103.getLifecycle().addObserver(r102);
        }
    }

    public interface ViewComponentBuilderEntryPoint {
        ViewComponentBuilder viewComponentBuilder();
    }

    public interface ViewWithFragmentComponentBuilderEntryPoint {
        ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder();
    }

    private Object createComponent() {
        GeneratedComponentManager<?> r100 = getParentComponentManager(false);
        if (this.hasFragmentBindings == false) goto L7;
        return ((ViewWithFragmentComponentBuilderEntryPoint) EntryPoints.get(r100, ViewWithFragmentComponentBuilderEntryPoint.class)).viewWithFragmentComponentBuilder().view(this.view).build();
    L7:
        return ((ViewComponentBuilderEntryPoint) EntryPoints.get(r100, ViewComponentBuilderEntryPoint.class)).viewComponentBuilder().view(this.view).build();
    }

    public GeneratedComponentManager<?> maybeGetParentComponentManager() {
        return getParentComponentManager(true);
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public Object generatedComponent() {
        if (this.f467788component != null) goto L15;
        Object r100 = this.componentLock;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f467788component != null) goto L9;
        this.f467788component = createComponent();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L15:
        return this.f467788component;
    }

    private GeneratedComponentManager<?> getParentComponentManager(boolean r100) {
        if (this.hasFragmentBindings == false) goto L11;
        Context r101 = getParentContext(FragmentContextWrapper.class, r100);
        if ((r101 instanceof FragmentContextWrapper) == true) goto L7;
        if (r100 == false) goto L10;
        return null;
    L10:
        Context r102 = getParentContext(GeneratedComponentManager.class, r100);
        Preconditions.checkState(!(r102 instanceof GeneratedComponentManager), "%s, @WithFragmentBindings Hilt view must be attached to an @AndroidEntryPoint Fragment. Was attached to context %s", new Object[]{this.view.getClass(), r102.getClass().getName()});
    L18:
        throw new IllegalStateException(String.format("%s, Hilt view must be attached to an @AndroidEntryPoint Fragment or Activity.", new Object[]{this.view.getClass()}));
    L7:
        return (GeneratedComponentManager) ((FragmentContextWrapper) r101).getFragment();
    L11:
        Object r103 = getParentContext(GeneratedComponentManager.class, r100);
        if ((r103 instanceof GeneratedComponentManager) == true) goto L14;
        if (r100 == false) goto L18;
        return null;
    L14:
        return (GeneratedComponentManager) r103;
    }

    public ViewComponentManager(View r100, boolean r101) {
        this.componentLock = new Object();
        this.view = r100;
        this.hasFragmentBindings = r101;
    }

    private Context getParentContext(Class<?> r100, boolean r101) {
        Context r102 = unwrap(this.view.getContext(), r100);
        if (r102 != Contexts.getApplication(r102.getApplicationContext())) goto L6;
        Preconditions.checkState(r101, "%s, Hilt view cannot be created using the application context. Use a Hilt Fragment or Activity context.", new Object[]{this.view.getClass()});
        return null;
    L6:
        return r102;
    }

    private static Context unwrap(Context r100, Class<?> r101) {
    L3:
        if ((r100 instanceof ContextWrapper) == false) goto L7;
        if (r101.isInstance(r100) == true) goto L7;
        r100 = ((ContextWrapper) r100).getBaseContext();
    L7:
        return r100;
    }
}
