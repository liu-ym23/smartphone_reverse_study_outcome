package dagger.hilt.android.dwarf;

import dagger.hilt.components.SingletonComponent;

/* JADX INFO: loaded from: classes41.dex */
public @interface DwarfInjectPoint {
    Class<?>[] also() default {};

    Class<?> baseClass() default Void.class;

    Class<?> parent() default SingletonComponent.class;
}
