package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.model;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/model/HotAtmosphereState;", "Ljava/io/Serializable;", "()V", "hasShown", "", "getHasShown", "()Z", "setHasShown", "(Z)V", "isFold", "setFold", "lastNum", "", "getLastNum", "()I", "setLastNum", "(I)V", "lastType", "getLastType", "setLastType", "reset", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HotAtmosphereState implements Serializable {
    private boolean hasShown;
    private boolean isFold;
    private int lastNum;
    private int lastType;

    public HotAtmosphereState() {
    }

    public final void reset() {
        this.hasShown = false;
        this.lastNum = 0;
        this.isFold = false;
        this.lastType = 0;
    }

    public final boolean getHasShown() {
        return this.hasShown;
    }

    public final int getLastNum() {
        return this.lastNum;
    }

    public final int getLastType() {
        return this.lastType;
    }

    public final boolean isFold() {
        return this.isFold;
    }

    public final void setFold(boolean r1) {
        this.isFold = r1;
    }

    public final void setHasShown(boolean r1) {
        this.hasShown = r1;
    }

    public final void setLastNum(int r1) {
        this.lastNum = r1;
    }

    public final void setLastType(int r1) {
        this.lastType = r1;
    }
}
