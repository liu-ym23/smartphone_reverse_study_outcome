package com.huawei.agconnect;

import android.content.Context;
import com.huawei.agconnect.config.impl.a;

/* JADX INFO: loaded from: classes23.dex */
public abstract class AGConnectApp {
    public AGConnectApp() {
    }

    public static AGConnectApp getInstance() {
        return a.a();
    }

    private static AGConnectApp getInstance(String r100) {
        return a.a(r100);
    }

    public static AGConnectApp initialize(Context r100) {
        return a.a(r100);
    }

    private static AGConnectApp initialize(Context r100, String r101) {
        return a.a(r100, r101);
    }

    public abstract void setApiKey(String r100);

    public abstract void setAppId(String r100);

    public abstract void setClientId(String r100);

    public abstract void setClientSecret(String r100);

    public abstract void setCpId(String r100);

    public abstract void setCustomAuthProvider(CustomAuthProvider r100);

    public abstract void setCustomCredentialsProvider(CustomCredentialsProvider r100);

    public abstract void setParam(String r100, String r101);

    public abstract void setProductId(String r100);
}
