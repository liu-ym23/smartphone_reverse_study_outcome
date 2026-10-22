package dagger.hilt;

import dagger.hilt.internal.GeneratedComponent;
import dagger.hilt.internal.GeneratedComponentManager;
import dagger.hilt.internal.Preconditions;
import dagger.hilt.internal.TestSingletonComponent;
import java.lang.annotation.Annotation;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes41.dex */
public final class EntryPoints {
    private static final String EARLY_ENTRY_POINT = "dagger.hilt.android.EarlyEntryPoint";

    private EntryPoints() {
    }

    @Nonnull
    public static <T> T get(Object r100, Class<T> r101) {
        if ((r100 instanceof GeneratedComponent) == false) goto L10;
        if ((r100 instanceof TestSingletonComponent) == false) goto L8;
        Preconditions.checkState(!hasAnnotationReflection(r101, EARLY_ENTRY_POINT), "Interface, %s, annotated with @EarlyEntryPoint should be called with EarlyEntryPoints.get() rather than EntryPoints.get()", new Object[]{r101.getCanonicalName()});
    L8:
        return r101.cast(r100);
    L10:
        if ((r100 instanceof GeneratedComponentManager) == false) goto L14;
        return (T) get(((GeneratedComponentManager) r100).generatedComponent(), r101);
    L14:
        throw new IllegalStateException(String.format("Given component holder %s does not implement %s or %s", new Object[]{r100.getClass(), GeneratedComponent.class, GeneratedComponentManager.class}));
    }

    private static boolean hasAnnotationReflection(Class<?> r100, String r101) {
        Annotation[] r102 = r100.getAnnotations();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L9;
        if (r102[r104].annotationType().getCanonicalName().contentEquals(r101) == true) goto L6;
        r104 = r104 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }
}
