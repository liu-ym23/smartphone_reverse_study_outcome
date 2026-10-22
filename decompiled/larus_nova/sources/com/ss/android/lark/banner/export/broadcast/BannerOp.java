package com.ss.android.lark.banner.export.broadcast;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes34.dex */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
public @interface BannerOp {
    public static final String CLOSE_BANNER = "close_banner";
}
