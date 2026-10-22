package dagger.hilt.android;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.internal.Contexts;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes41.dex */
public final class EntryPointAccessors {
    private EntryPointAccessors() {
    }

    @Nonnull
    public static <T> T fromActivity(Activity r100, Class<T> r101) {
        return (T) EntryPoints.get(r100, r101);
    }

    @Nonnull
    public static <T> T fromApplication(Context r100, Class<T> r101) {
        return (T) EntryPoints.get(Contexts.getApplication(r100.getApplicationContext()), r101);
    }

    @Nonnull
    public static <T> T fromFragment(Fragment r100, Class<T> r101) {
        return (T) EntryPoints.get(r100, r101);
    }

    @Nonnull
    public static <T> T fromView(View r100, Class<T> r101) {
        return (T) EntryPoints.get(r100, r101);
    }
}
