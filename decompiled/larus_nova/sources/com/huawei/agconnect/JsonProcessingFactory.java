package com.huawei.agconnect;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class JsonProcessingFactory {
    private static final Map<String, JsonProcessor> PROCESSOR_MAP = null;

    public interface JsonProcessor {
        String processOption(AGConnectOptions r100);
    }

    static {
        PROCESSOR_MAP = new HashMap();
    }

    public JsonProcessingFactory() {
    }

    public static Map<String, JsonProcessor> getProcessors() {
        return PROCESSOR_MAP;
    }

    public static void registerProcessor(String r100, JsonProcessor r101) {
        PROCESSOR_MAP.put(r100, r101);
    }
}
