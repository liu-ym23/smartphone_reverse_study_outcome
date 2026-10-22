package com.lynx.tasm.behavior;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes32.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LynxElement {
    Class<? extends x6a.e> fragmentLayerRendererHost() default x6a.e.class;

    boolean isCreateAsync() default false;

    String name();

    boolean needProcessDirection() default false;

    boolean supportFragmentLayerRender() default false;
}
