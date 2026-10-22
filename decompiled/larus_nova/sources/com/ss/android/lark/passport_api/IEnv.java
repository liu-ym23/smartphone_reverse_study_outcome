package com.ss.android.lark.passport_api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes37.dex */
public interface IEnv {

    @Retention(RetentionPolicy.SOURCE)
    public @interface ENV_TYPE {
        public static final int PRE_RELEASE = 3;
        public static final int RELEASE = 1;
        public static final int STAGING = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface UNIT_TYPE {
        public static final String EA = "eu_ea";
        public static final String JP = "larkjpaws";
        public static final String MY = "larkmy";
        public static final String NC = "eu_nc";
        public static final String SG = "larksgaws";
        public static final String TTP = "useast15a";
    }
}
