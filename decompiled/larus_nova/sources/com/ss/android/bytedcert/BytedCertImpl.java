package com.ss.android.bytedcert;

import android.app.Activity;
import android.content.Context;
import com.ss.android.bytedcert.flow.cert.BytedCertFlowParams;
import com.ss.android.bytedcert.flow.face.FaceDetectFlowParams;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.cert.manager.ablity.IEventParamsInterceptor;
import com.ss.android.cert.manager.ablity.IRequestExtraInterceptor;
import com.ss.android.cert.manager.api.IBytedCert;
import com.ss.android.cert.manager.callback.CertResultCallback;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class BytedCertImpl implements IBytedCert {
    public BytedCertImpl() {
    }

    @Override // com.ss.android.cert.manager.api.IBytedCert
    public IEventParamsInterceptor getEventParamsInterceptor() {
        return null;
    }

    @Override // com.ss.android.cert.manager.api.IBytedCert
    public IRequestExtraInterceptor getExtraInterceptor() {
        return null;
    }

    @Override // com.ss.android.cert.manager.api.IBytedCert
    public void init(Context r100) {
    }

    @Override // com.ss.android.cert.manager.api.IPlugin
    public boolean installPlugin(Context r100) {
        return true;
    }

    private static String resolveLanguage(Map<String, String> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.isEmpty() == true) goto L16;
        String r101 = r100.get("byted_cert_language");
        if (r101 != null) goto L10;
        return null;
    L10:
        if (r101.trim().isEmpty() == false) goto L13;
        return null;
    L13:
        return r101;
    L16:
        return null;
    }

    @Override // com.ss.android.cert.manager.api.IBytedCert
    public void startCertFlow(Activity r100, Map<String, String> r101, CertResultCallback r102) {
        BytedCertManager.getInstance().startBytedCert(new BytedCertFlowParams.Builder(r100).setCertInfo(r101).setLanguage(resolveLanguage(r101)).setCertInfo("use_new_api", "true").setCertResultCallback(r102).build());
    }

    @Override // com.ss.android.cert.manager.api.IBytedCert
    public void startFaceLiveness(Activity r100, Map<String, String> r101, final CertResultCallback r102) {
        BytedCertManager.getInstance().doFaceLive(new FaceDetectFlowParams.Builder(r100).setCertInfo(r101).setLanguage(resolveLanguage(r101)).setCertInfo("use_new_api", "true").setFaceLiveCallback(new AnonymousClass1(this, r102)).build());
    }
}
