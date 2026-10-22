package com.huawei.agconnect;

import android.content.Context;
import com.huawei.agconnect.core.a.b;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AGConnectInstance {
    public AGConnectInstance() {
    }

    public static AGConnectInstance buildInstance(AGConnectOptions r100) {
        return b.a(r100);
    }

    public static AGConnectInstance getInstance() {
        return b.a();
    }

    public static AGConnectInstance getInstance(String r100) {
        return b.a(r100);
    }

    public static void initialize(Context r100) {
        b.a(r100);
    }

    public static void initialize(Context r100, AGConnectOptionsBuilder r101) {
        b.a(r100, r101);
    }

    public abstract Context getContext();

    public abstract String getIdentifier();

    public abstract AGConnectOptions getOptions();

    public abstract <T> T getService(Class<? super T> r100);
}
