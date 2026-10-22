package dagger.android;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.ContentProvider;
import android.content.Context;
import android.util.Log;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.utils.statistics.PerfLog;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes41.dex */
public final class AndroidInjection {
    private static final String TAG = "dagger.android";

    private AndroidInjection() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static HasAndroidInjector findHasAndroidInjectorForFragment(Fragment r100) {
        Fragment r101 = r100;
    L3:
        r101 = r101.getParentFragment();
        if (r101 == 0) goto L9;
        if ((r101 instanceof HasAndroidInjector) == false) goto L3;
        return (HasAndroidInjector) r101;
    L9:
        Activity r102 = r100.getActivity();
        if ((r102 instanceof HasAndroidInjector) == false) goto L14;
        return (HasAndroidInjector) r102;
    L14:
        if ((r102.getApplication() instanceof HasAndroidInjector) == false) goto L18;
        return (HasAndroidInjector) r102.getApplication();
    L18:
        throw new IllegalArgumentException(String.format("No injector was found for %s", new Object[]{r100.getClass().getCanonicalName()}));
    }

    public static void inject(ContentProvider r100) {
        Preconditions.checkNotNull(r100, "contentProvider");
        ComponentCallbacks2 r101 = (Application) r100.getContext().getApplicationContext();
        if ((r101 instanceof HasAndroidInjector) == false) goto L7;
        inject(r100, (HasAndroidInjector) r101);
        return;
    L7:
        throw new RuntimeException(String.format("%s does not implement %s", new Object[]{r101.getClass().getCanonicalName(), HasAndroidInjector.class.getCanonicalName()}));
    }

    public static void inject(Activity r100) {
        Preconditions.checkNotNull(r100, "activity");
        ComponentCallbacks2 r101 = r100.getApplication();
        if ((r101 instanceof HasAndroidInjector) == false) goto L7;
        inject(r100, (HasAndroidInjector) r101);
        return;
    L7:
        throw new RuntimeException(String.format("%s does not implement %s", new Object[]{r101.getClass().getCanonicalName(), HasAndroidInjector.class.getCanonicalName()}));
    }

    public static void inject(Service r100) {
        Preconditions.checkNotNull(r100, "service");
        ComponentCallbacks2 r101 = r100.getApplication();
        if ((r101 instanceof HasAndroidInjector) == false) goto L7;
        inject(r100, (HasAndroidInjector) r101);
        return;
    L7:
        throw new RuntimeException(String.format("%s does not implement %s", new Object[]{r101.getClass().getCanonicalName(), HasAndroidInjector.class.getCanonicalName()}));
    }

    public static void inject(Fragment r100) {
        Preconditions.checkNotNull(r100, WidgetService.PARAM_FRAGMENT);
        HasAndroidInjector r101 = findHasAndroidInjectorForFragment(r100);
        if (Log.isLoggable(TAG, 3) == false) goto L5;
        String.format("An injector for %s was found in %s", new Object[]{r100.getClass().getCanonicalName(), r101.getClass().getCanonicalName()});
    L5:
        inject(r100, r101);
    }

    public static void inject(BroadcastReceiver r100, Context r101) {
        Preconditions.checkNotNull(r100, "broadcastReceiver");
        Preconditions.checkNotNull(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ComponentCallbacks2 r102 = (Application) r101.getApplicationContext();
        if ((r102 instanceof HasAndroidInjector) == false) goto L7;
        inject(r100, (HasAndroidInjector) r102);
        return;
    L7:
        throw new RuntimeException(String.format("%s does not implement %s", new Object[]{r102.getClass().getCanonicalName(), HasAndroidInjector.class.getCanonicalName()}));
    }

    private static void inject(Object r100, HasAndroidInjector r101) {
        AndroidInjector<Object> r102 = r101.androidInjector();
        Preconditions.checkNotNull(r102, "%s.androidInjector() returned null", r101.getClass());
        r102.inject(r100);
    }
}
