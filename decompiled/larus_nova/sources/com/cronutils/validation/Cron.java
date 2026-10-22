package com.cronutils.validation;

import as7.a;
import com.cronutils.model.CronType;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/* JADX INFO: loaded from: classes22.dex */
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Constraint(validatedBy = {a.class})
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Cron {
    Class<?>[] groups() default {};

    String message() default "UNUSED";

    Class<? extends Payload>[] payload() default {};

    CronType type();
}
