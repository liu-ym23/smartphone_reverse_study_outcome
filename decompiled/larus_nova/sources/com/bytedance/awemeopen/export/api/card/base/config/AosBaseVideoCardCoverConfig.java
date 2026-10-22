package com.bytedance.awemeopen.export.api.card.base.config;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/awemeopen/export/api/card/base/config/AosBaseVideoCardCoverConfig;", "", "()V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "width", "getWidth", "setWidth", "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class AosBaseVideoCardCoverConfig {
    private int height;
    private int width;

    public AosBaseVideoCardCoverConfig() {
        this.width = -1;
        this.height = -1;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }
}
