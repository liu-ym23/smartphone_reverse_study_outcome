package com.ss.android.lark.utils;

import android.app.Application;
import com.larksuite.framework.utils.b;
import e0c.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class LarkContext {
    public LarkContext() {
    }

    public static Application getApplication() {
        return b.a;
    }

    public static void setApplication(Application r0) {
        b.a = r0;
    }

    public static <T> T spiByDwarf(Class<T> r1) {
        return (T) k.a(getApplication(), r1);
    }
}
