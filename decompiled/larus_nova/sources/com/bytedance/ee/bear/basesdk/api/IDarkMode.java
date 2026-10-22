package com.bytedance.ee.bear.basesdk.api;

import android.content.Context;
import android.content.res.Configuration;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
public interface IDarkMode {

    @Retention(RetentionPolicy.SOURCE)
    public @interface DarkModeType {
    }

    void a(Context r100, Configuration r101);
}
