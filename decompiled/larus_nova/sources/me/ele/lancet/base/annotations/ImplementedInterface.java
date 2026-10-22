package me.ele.lancet.base.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import me.ele.lancet.base.Scope;

/* JADX INFO: loaded from: classes42.dex */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ImplementedInterface {
    Scope scope() default Scope.SELF;

    String[] value();
}
