package com.bytedance.ug.sdk.luckyhost.api.api;

import gk7.d;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public interface ILuckyTokenUnionService {
    void addTokenInitListener(d r100);

    boolean checkNeedInterceptUrl(String r100);

    Map<String, String> getAccountAllData();

    String getActHash(String r100);

    void syncTokenToClipboard();
}
