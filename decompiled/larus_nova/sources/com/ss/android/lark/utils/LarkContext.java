package com.ss.android.lark.utils;

import android.app.Application;

/* JADX INFO: loaded from: classes.dex */
public class LarkContext {
    public LarkContext() {
    }

    public static Application getApplication() {
        return com.larksuite.framework.utils.b.f285948a;
    }

    public static void setApplication(Application r100) {
        com.larksuite.framework.utils.b.f285948a = r100;
    }

    public static <T> T spiByDwarf(Class<T> r100) {
        return (T) e0c.k.a(getApplication(), r100);
    }
}
