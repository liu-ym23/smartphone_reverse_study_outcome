package dagger.hilt.android.internal.managers;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.internal.GeneratedComponentManager;
import dagger.hilt.internal.Preconditions;

/* JADX INFO: loaded from: classes41.dex */
public class FragmentComponentManager implements GeneratedComponentManager<Object> {

    /* JADX INFO: renamed from: component, reason: collision with root package name */
    private volatile Object f467786component;
    private final Object componentLock;
    private final Fragment fragment;

    public interface FragmentComponentBuilderEntryPoint {
        FragmentComponentBuilder fragmentComponentBuilder();
    }

    public void validate(Fragment r100) {
    }

    private Object createComponent() {
        Preconditions.checkNotNull(this.fragment.getHost(), "Hilt Fragments must be attached before creating the component.");
        Preconditions.checkState(this.fragment.getHost() instanceof GeneratedComponentManager, "Hilt Fragments must be attached to an @AndroidEntryPoint Activity. Found: %s", new Object[]{this.fragment.getHost().getClass()});
        validate(this.fragment);
        return ((FragmentComponentBuilderEntryPoint) EntryPoints.get(this.fragment.getHost(), FragmentComponentBuilderEntryPoint.class)).fragmentComponentBuilder().fragment(this.fragment).build();
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public Object generatedComponent() {
        if (this.f467786component != null) goto L15;
        Object r100 = this.componentLock;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f467786component != null) goto L9;
        this.f467786component = createComponent();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L15:
        return this.f467786component;
    }

    public FragmentComponentManager(Fragment r100) {
        this.componentLock = new Object();
        this.fragment = r100;
    }

    public static final Context findActivity(Context r100) {
    L3:
        if ((r100 instanceof ContextWrapper) == false) goto L7;
        if ((r100 instanceof Activity) == true) goto L7;
        r100 = ((ContextWrapper) r100).getBaseContext();
    L7:
        return r100;
    }

    public static final void initializeArguments(Fragment r100) {
        Preconditions.checkNotNull(r100);
        if (r100.getArguments() != null) goto L6;
        r100.setArguments(new Bundle());
        return;
    }

    public static ContextWrapper createContextWrapper(Context r100, Fragment r101) {
        return new ViewComponentManager.FragmentContextWrapper(r100, r101);
    }

    public static ContextWrapper createContextWrapper(LayoutInflater r100, Fragment r101) {
        return new ViewComponentManager.FragmentContextWrapper(r100, r101);
    }
}
