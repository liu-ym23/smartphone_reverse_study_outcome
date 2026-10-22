package com.ss.android.lark.passport.signinsdk_api.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes37.dex */
public class NotifySettings implements Serializable {
    private boolean disableMobileNotify;
    private boolean stillNotifyAt;
    private boolean stillNotifySpecialFocus;

    public NotifySettings() {
    }

    public boolean isDisableMobileNotify() {
        return this.disableMobileNotify;
    }

    public boolean isStillNotifyAt() {
        return this.stillNotifyAt;
    }

    public boolean isStillNotifySpecialFocus() {
        return this.stillNotifySpecialFocus;
    }

    public void setDisableMobileNotify(boolean r100) {
        this.disableMobileNotify = r100;
    }

    public void setStillNotifyAt(boolean r100) {
        this.stillNotifyAt = r100;
    }

    public void setStillNotifySpecialFocus(boolean r100) {
        this.stillNotifySpecialFocus = r100;
    }
}
