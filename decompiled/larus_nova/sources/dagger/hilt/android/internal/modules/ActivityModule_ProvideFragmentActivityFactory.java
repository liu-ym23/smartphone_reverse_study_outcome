package dagger.hilt.android.internal.modules;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes41.dex */
public final class ActivityModule_ProvideFragmentActivityFactory implements Factory<FragmentActivity> {
    private final Provider<Activity> activityProvider;

    @Override // javax.inject.Provider
    public FragmentActivity get() {
        return provideFragmentActivity(this.activityProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ActivityModule_ProvideFragmentActivityFactory(Provider<Activity> r100) {
        this.activityProvider = r100;
    }

    public static ActivityModule_ProvideFragmentActivityFactory create(Provider<Activity> r100) {
        return new ActivityModule_ProvideFragmentActivityFactory(r100);
    }

    public static FragmentActivity provideFragmentActivity(Activity r100) {
        return (FragmentActivity) Preconditions.checkNotNullFromProvides(ActivityModule.provideFragmentActivity(r100));
    }
}
