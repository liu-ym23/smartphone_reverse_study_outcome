package com.bytedance.labcv.licenselibrary;

import java.util.HashMap;

/* JADX INFO: loaded from: classes19.dex */
public interface BytedLicenseInterface {
    void clearParams();

    int getLicenseWithParams(HashMap<String, String> r100, boolean r101, LicenseCallback r102);

    String getParam(String r100);

    void registerHttpProvider(HttpRequestProvider r100);

    void setParam(String r100, String r101);

    int updateLicenseWithParams(HashMap<String, String> r100, boolean r101, LicenseCallback r102);
}
