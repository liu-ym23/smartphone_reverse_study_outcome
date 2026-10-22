package com.ss.android.lark.integrator.im.dependency;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes36.dex */
public interface IEnvDependency {

    @Retention(RetentionPolicy.SOURCE)
    public @interface EnvType {
        public static final int PRE_RELEASE = 3;
        public static final int RELEASE = 1;
        public static final int STAGING = 2;
    }

    int envType();

    void rustSdkLogSubPath();
}
