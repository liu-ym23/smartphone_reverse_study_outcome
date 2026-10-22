package com.ss.ttm.utils;

/* JADX INFO: loaded from: classes40.dex */
public class ConfigFactoryImpl implements ConfigFactory {
    public ConfigFactoryImpl() {
    }

    @Override // com.ss.ttm.utils.ConfigFactory
    public ConfigAPI createConfig(long r100, int r101) {
        return new ConfigImpl(r100, r101);
    }
}
