package com.ss.android.cert.manager.api;

import android.content.Context;
import com.ss.android.cert.manager.callback.CertCallback;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public interface IAliyunCert extends IPlugin {
    void doFaceLiveness(Context r100, Map<String, String> r101, CertCallback r102);

    String getMetaInfos(Context r100);

    JSONObject getSession();

    void init(Context r100);
}
