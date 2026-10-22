package com.huawei.hms.framework.network.grs.h.g;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactoryNew;
import com.huawei.secure.android.common.ssl.SecureX509TrustManager;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes23.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HostnameVerifier f277269a = null;

    static {
        f277269a = new StrictHostnameVerifier();
    }

    public static HostnameVerifier a() {
        return f277269a;
    }

    public static SSLSocketFactory a(Context r100) {
        return new SecureSSLSocketFactoryNew(new SecureX509TrustManager(r100.getAssets().open(GrsApp.getInstance().getBrand(HTTP.URL_DEFAULT) + "grs_sp.bks"), ""), EncryptUtil.genSecureRandom());
    L6:
        e = move-exception;
        throw new AssertionError(e);
    }
}
