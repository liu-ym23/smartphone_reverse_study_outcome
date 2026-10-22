package dagger.hilt.android.dwarf.lifecycle;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes41.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface DwarfViewModel {
    Class<?> assistedFactory() default Object.class;

    Class<?> parent();
}
