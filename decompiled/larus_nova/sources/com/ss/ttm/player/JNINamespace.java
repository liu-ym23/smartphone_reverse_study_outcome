package com.ss.ttm.player;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes40.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface JNINamespace {
    String value();
}
