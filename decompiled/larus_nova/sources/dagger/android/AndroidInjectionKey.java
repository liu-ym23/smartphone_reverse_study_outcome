package dagger.android;

import dagger.MapKey;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes41.dex */
@MapKey
@Target({ElementType.METHOD})
@Documented
public @interface AndroidInjectionKey {
    String value();
}
