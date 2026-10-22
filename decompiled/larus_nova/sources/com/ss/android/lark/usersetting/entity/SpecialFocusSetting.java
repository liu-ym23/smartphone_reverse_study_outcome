package com.ss.android.lark.usersetting.entity;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J'\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/usersetting/entity/SpecialFocusSetting;", "Ljava/io/Serializable;", "isNoDisturbNotify", "", "isChatBoxNotify", "isMuteNotify", "<init>", "(ZZZ)V", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "usersetting_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpecialFocusSetting implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 9138537016181414535L;
    private final boolean isChatBoxNotify;
    private final boolean isMuteNotify;
    private final boolean isNoDisturbNotify;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ SpecialFocusSetting copy$default(SpecialFocusSetting r100, boolean r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.isNoDisturbNotify;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.isChatBoxNotify;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.isMuteNotify;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.isNoDisturbNotify;
    }

    public final boolean component2() {
        return this.isChatBoxNotify;
    }

    public final boolean component3() {
        return this.isMuteNotify;
    }

    public final SpecialFocusSetting copy(boolean r100, boolean r101, boolean r102) {
        return new SpecialFocusSetting(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SpecialFocusSetting) == true) goto L8;
        return false;
    L8:
        SpecialFocusSetting r101 = (SpecialFocusSetting) r100;
        if (this.isNoDisturbNotify == r101.isNoDisturbNotify) goto L12;
        return false;
    L12:
        if (this.isChatBoxNotify == r101.isChatBoxNotify) goto L15;
        return false;
    L15:
        if (this.isMuteNotify == r101.isMuteNotify) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.isNoDisturbNotify == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.isChatBoxNotify == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.isMuteNotify == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "SpecialFocusSetting(isNoDisturbNotify=" + this.isNoDisturbNotify + ", isChatBoxNotify=" + this.isChatBoxNotify + ", isMuteNotify=" + this.isMuteNotify + ')';
    }

    public final boolean isChatBoxNotify() {
        return this.isChatBoxNotify;
    }

    public final boolean isMuteNotify() {
        return this.isMuteNotify;
    }

    public final boolean isNoDisturbNotify() {
        return this.isNoDisturbNotify;
    }

    public SpecialFocusSetting(boolean r100, boolean r101, boolean r102) {
        this.isNoDisturbNotify = r100;
        this.isChatBoxNotify = r101;
        this.isMuteNotify = r102;
    }
}
