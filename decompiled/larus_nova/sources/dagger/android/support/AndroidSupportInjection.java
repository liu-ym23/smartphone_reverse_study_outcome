package dagger.android.support;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import dagger.android.AndroidInjector;
import dagger.android.HasAndroidInjector;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes41.dex */
public final class AndroidSupportInjection {
    private static final String TAG = "dagger.android.support";

    private AndroidSupportInjection() {
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
        FragmentActivity r102 = r100.getActivity();
        if ((r102 instanceof HasAndroidInjector) == false) goto L14;
        return (HasAndroidInjector) r102;
    L14:
        if ((r102.getApplication() instanceof HasAndroidInjector) == false) goto L18;
        return (HasAndroidInjector) r102.getApplication();
    L18:
        throw new IllegalArgumentException(String.format("No injector was found for %s", new Object[]{r100.getClass().getCanonicalName()}));
    }

    public static void inject(Fragment r100) {
        Preconditions.checkNotNull(r100, WidgetService.PARAM_FRAGMENT);
        HasAndroidInjector r101 = findHasAndroidInjectorForFragment(r100);
        if (Log.isLoggable(TAG, 3) == false) goto L5;
        String.format("An injector for %s was found in %s", new Object[]{r100.getClass().getCanonicalName(), r101.getClass().getCanonicalName()});
    L5:
        inject(r100, r101);
    }

    private static void inject(Object r100, HasAndroidInjector r101) {
        AndroidInjector<Object> r102 = r101.androidInjector();
        Preconditions.checkNotNull(r102, "%s.androidInjector() returned null", r101.getClass());
        r102.inject(r100);
    }
}
