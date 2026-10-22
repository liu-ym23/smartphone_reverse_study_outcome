package com.ss.ttm.utils;

/* JADX INFO: loaded from: classes40.dex */
public class UserConfig extends ReuseConfig {
    public UserConfig() {
        super(null, 0);
    }

    public UserConfig copy() {
        return new UserConfig(this);
    }

    private UserConfig(UserConfig r100) {
        super(r100, 1);
    }
}
