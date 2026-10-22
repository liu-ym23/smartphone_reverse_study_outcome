package dagger.hilt.android.internal.managers;

import android.app.Activity;
import android.app.Application;
import androidx.activity.ComponentActivity;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.internal.GeneratedComponentManager;

/* JADX INFO: loaded from: classes41.dex */
public class ActivityComponentManager implements GeneratedComponentManager<Object> {
    protected final Activity activity;
    private final GeneratedComponentManager<ActivityRetainedComponent> activityRetainedComponentManager;

    /* JADX INFO: renamed from: component, reason: collision with root package name */
    private volatile Object f467782component;
    private final Object componentLock;

    public interface ActivityComponentBuilderEntryPoint {
        ActivityComponentBuilder activityComponentBuilder();
    }

    public Object createComponent() {
        if ((this.activity.getApplication() instanceof GeneratedComponentManager) == true) goto L11;
        if (Application.class.equals(this.activity.getApplication().getClass()) == false) goto L9;
        throw new IllegalStateException("Hilt Activity must be attached to an @HiltAndroidApp Application. Did you forget to specify your Application's class name in your manifest's <application />'s android:name attribute?");
    L9:
        throw new IllegalStateException("Hilt Activity must be attached to an @AndroidEntryPoint Application. Found: " + this.activity.getApplication().getClass());
    L11:
        return ((ActivityComponentBuilderEntryPoint) EntryPoints.get(this.activityRetainedComponentManager, ActivityComponentBuilderEntryPoint.class)).activityComponentBuilder().activity(this.activity).build();
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public Object generatedComponent() {
        if (this.f467782component != null) goto L15;
        Object r100 = this.componentLock;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f467782component != null) goto L9;
        this.f467782component = createComponent();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L15:
        return this.f467782component;
    }

    public ActivityComponentManager(Activity r100) {
        this.componentLock = new Object();
        this.activity = r100;
        this.activityRetainedComponentManager = new ActivityRetainedComponentManager((ComponentActivity) r100);
    }
}
