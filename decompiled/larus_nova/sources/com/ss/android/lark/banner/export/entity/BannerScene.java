package com.ss.android.lark.banner.export.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes34.dex */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface BannerScene {
    public static final String CCM = "BANNER_SCENE_CCM";
    public static final String CONTACT = "BANNER_SCENE_CONTACT";
    public static final String FEED = "BANNER_SCENE_FEED";
    public static final String SHARED = "BANNER_SCENE_SHARED";
    public static final String UNKNOWN = "BANNER_SCENE_UNKNOWN";
}
