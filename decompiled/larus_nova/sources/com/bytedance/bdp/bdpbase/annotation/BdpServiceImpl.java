package com.bytedance.bdp.bdpbase.annotation;

import com.bytedance.bdp.bdpbase.service.IBdpService;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes11.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface BdpServiceImpl {
    public static final int OVERRIDE = 10000;
    public static final int PLUG = -9;
    public static final int SDK = -10;

    String desc() default "not configured ServiceImpl info";

    String owner() default "BDP";

    int priority() default 0;

    Class<? extends IBdpService>[] services();

    String title() default "BDP";
}
