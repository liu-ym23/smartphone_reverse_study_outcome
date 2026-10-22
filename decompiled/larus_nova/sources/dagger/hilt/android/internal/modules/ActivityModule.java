package dagger.hilt.android.internal.modules;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;

/* JADX INFO: loaded from: classes41.dex */
@Module
abstract class ActivityModule {
    private ActivityModule() {
    }

    @Binds
    public abstract Context provideContext(Activity r100);

    @Provides
    @Reusable
    public static FragmentActivity provideFragmentActivity(Activity r100) {
        return (FragmentActivity) r100;
    L4:
        e = move-exception;
        throw new IllegalStateException("Expected activity to be a FragmentActivity: " + r100, e);
    }
}
