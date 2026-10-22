package com.larus.network.ttnet;

import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class TTNetCommonQueryParamsInjector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f360219a = null;

    public TTNetCommonQueryParamsInjector() {
    }

    static {
        f360219a = new HashMap();
        Keva.getRepo("default", 0);
    }

    public static void clearCommonQueryParams() {
        FLogger.f375446a.i("TTNetCommonQueryParamsInjector", "clearCommonQueryParams skip, inject disabled");
    }

    public static void addCommonQueryParams(String r100, String r101) {
        FLogger.f375446a.i("TTNetCommonQueryParamsInjector", "addCommonQueryParams skip, inject disabled, key=" + r100);
    }
}
