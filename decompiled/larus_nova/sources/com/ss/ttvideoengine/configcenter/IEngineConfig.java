package com.ss.ttvideoengine.configcenter;

import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public interface IEngineConfig {
    public static final IEngineConfig EMPTY = null;

    float getFloatOption(int r100);

    int getIntOption(int r100);

    Map<Integer, ConfigItem> getItemMap();

    long getLongOption(int r100);

    ConfigItem getOption(int r100);

    String getStringOption(int r100);

    boolean isKeySet(int r100);

    void remove(int r100);

    void reset();

    ConfigItem setFloatOption(int r100, float r101);

    ConfigItem setIntOption(int r100, int r101);

    ConfigItem setLongOption(int r100, long r101);

    ConfigItem setStringOption(int r100, String r101);

    static {
        EMPTY = new AnonymousClass1();
    }
}
