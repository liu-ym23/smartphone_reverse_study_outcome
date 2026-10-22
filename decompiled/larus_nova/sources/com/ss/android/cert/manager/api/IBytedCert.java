package com.ss.android.cert.manager.api;

import android.app.Activity;
import android.content.Context;
import com.ss.android.cert.manager.ablity.IEventParamsInterceptor;
import com.ss.android.cert.manager.ablity.IRequestExtraInterceptor;
import com.ss.android.cert.manager.callback.CertResultCallback;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface IBytedCert extends IPlugin {
    IEventParamsInterceptor getEventParamsInterceptor();

    IRequestExtraInterceptor getExtraInterceptor();

    void init(Context r100);

    void startCertFlow(Activity r100, Map<String, String> r101, CertResultCallback r102);

    void startFaceLiveness(Activity r100, Map<String, String> r101, CertResultCallback r102);
}
