package com.uber.nullaway.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.annotation.Nullable;
import javax.annotation.meta.TypeQualifierDefault;

/* JADX INFO: loaded from: classes41.dex */
@Target({ElementType.TYPE})
@TypeQualifierDefault({ElementType.FIELD})
@Nullable
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface NullableFields {
}
