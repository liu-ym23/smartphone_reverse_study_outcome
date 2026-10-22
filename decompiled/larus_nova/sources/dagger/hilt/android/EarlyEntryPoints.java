package dagger.hilt.android;

import android.content.ComponentCallbacks2;
import android.content.Context;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.internal.Contexts;
import dagger.hilt.internal.GeneratedComponentManager;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.Preconditions;
import dagger.hilt.internal.TestSingletonComponentManager;
import java.lang.annotation.Annotation;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes41.dex */
public final class EarlyEntryPoints {
    private EarlyEntryPoints() {
    }

    @Nonnull
    public static <T> T get(Context r100, Class<T> r101) {
        ComponentCallbacks2 r102 = Contexts.getApplication(r100.getApplicationContext());
        Preconditions.checkState(r102 instanceof GeneratedComponentManagerHolder, "Expected application context to implement GeneratedComponentManagerHolder. Check that you're passing in an application context that uses Hilt.", new Object[0]);
        GeneratedComponentManager<?> r103 = ((GeneratedComponentManagerHolder) r102).componentManager();
        if ((r103 instanceof TestSingletonComponentManager) == false) goto L7;
        Preconditions.checkState(hasAnnotationReflection(r101, EarlyEntryPoint.class), "%s should be called with EntryPoints.get() rather than EarlyEntryPoints.get()", new Object[]{r101.getCanonicalName()});
        return r101.cast(((TestSingletonComponentManager) r103).earlySingletonComponent());
    L7:
        return (T) EntryPoints.get(r102, r101);
    }

    private static boolean hasAnnotationReflection(Class<?> r100, Class<? extends Annotation> r101) {
        Annotation[] r102 = r100.getAnnotations();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L9;
        if (r102[r104].annotationType().equals(r101) == true) goto L6;
        r104 = r104 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }
}
