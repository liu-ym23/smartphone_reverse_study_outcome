package com.bytedance.ee.plugin.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public class PluginManager {
    private static final Map<Class<? extends IPluginApi>, IPluginApi> APIS = null;
    private static final List<String> WHITE_LIST_SIGN = null;
    private static int sPluginApiVersion;

    public PluginManager() {
    }

    static {
        APIS = new HashMap();
        ArrayList r100 = new ArrayList();
        WHITE_LIST_SIGN = r100;
        r100.add("C6973F5D324E58FDD7B2CDBACE515A7C");
    }

    public static int getPluginApiVersion() {
        return sPluginApiVersion;
    }

    public static List<String> getWhiteListSign() {
        return WHITE_LIST_SIGN;
    }

    public static <T extends IPluginApi> T getPluginApi(Class<T> r100) {
        return (T) APIS.get(r100);
    }

    public static void setPluginApiVersion(int r100) {
        sPluginApiVersion = r100;
    }

    public static void installPluginApi(Class<? extends IPluginApi> r100, IPluginApi r101) {
        APIS.put(r100, r101);
    }
}
