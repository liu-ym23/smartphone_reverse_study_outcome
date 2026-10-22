package com.ss.android.lark.diskmanage.clean.settings;

import com.ss.android.lark.diskmanage.NonProguard;

/* JADX INFO: loaded from: classes35.dex */
public class DeleteConfig implements NonProguard {
    private DeleteConfigItem deleteConfig;
    private ExpiredConfigItem expiredConfig;
    private RustConfigItem mainRustConfig;

    public String toString() {
        return "DeleteConfig{deleteConfig=" + this.deleteConfig + ", expiredConfig=" + this.expiredConfig + ", mainRustConfig=" + this.mainRustConfig + '}';
    }

    public DeleteConfig() {
        this.deleteConfig = new DeleteConfigItem();
        this.expiredConfig = new ExpiredConfigItem();
        this.mainRustConfig = new RustConfigItem();
    }

    public DeleteConfigItem getDeleteConfig() {
        return this.deleteConfig;
    }

    public ExpiredConfigItem getExpiredConfig() {
        return this.expiredConfig;
    }

    public RustConfigItem getMainRustConfig() {
        return this.mainRustConfig;
    }

    public void setDeleteConfig(DeleteConfigItem r100) {
        this.deleteConfig = r100;
    }

    public void setExpiredConfig(ExpiredConfigItem r100) {
        this.expiredConfig = r100;
    }

    public void setMainRustConfig(RustConfigItem r100) {
        this.mainRustConfig = r100;
    }
}
