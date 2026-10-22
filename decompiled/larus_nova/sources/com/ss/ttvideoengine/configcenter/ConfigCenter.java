package com.ss.ttvideoengine.configcenter;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class ConfigCenter {
    public static final int CONFIG_SOURCE_PRIORITY_USER_SETTINGS = 1;
    public static final int CONFIG_SOURCE_PRIORITY_VOD_SETTINGS = 2;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.configcenter.ConfigCenter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class InstanceHolder {
        private static final ConfigCenter INSTANCE = null;

        private InstanceHolder() {
        }

        static {
            INSTANCE = new ConfigCenter(null);
        }

        public static /* synthetic */ ConfigCenter access$100() {
            return INSTANCE;
        }
    }

    private ConfigCenter() {
    }

    public void updateVodSettings(String r100, JSONObject r101) {
    }

    public static ConfigCenter getInstance() {
        return InstanceHolder.access$100();
    }

    public /* synthetic */ ConfigCenter(AnonymousClass1 r100) {
        this();
    }
}
