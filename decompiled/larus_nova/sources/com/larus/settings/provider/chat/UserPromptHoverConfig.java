package com.larus.settings.provider.chat;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/larus/settings/provider/chat/UserPromptHoverConfig;", "", "enable", "", "botType", "", "hoverEveryPrompt", "<init>", "(ZIZ)V", "getEnable", "()Z", "getBotType", "()I", "getHoverEveryPrompt", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserPromptHoverConfig {

    @SerializedName("bot_type")
    private final int botType;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("hover_every_prompt")
    private final boolean hoverEveryPrompt;

    public UserPromptHoverConfig() {
        this(false, 0, false, 7, null);
    }

    public static /* synthetic */ UserPromptHoverConfig copy$default(UserPromptHoverConfig r100, boolean r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.enable;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.botType;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.hoverEveryPrompt;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final int component2() {
        return this.botType;
    }

    public final boolean component3() {
        return this.hoverEveryPrompt;
    }

    public final UserPromptHoverConfig copy(boolean r100, int r101, boolean r102) {
        return new UserPromptHoverConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UserPromptHoverConfig) == true) goto L8;
        return false;
    L8:
        UserPromptHoverConfig r101 = (UserPromptHoverConfig) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.botType == r101.botType) goto L15;
        return false;
    L15:
        if (this.hoverEveryPrompt == r101.hoverEveryPrompt) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.enable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.botType) * 31;
        if (this.hoverEveryPrompt == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "UserPromptHoverConfig(enable=" + this.enable + ", botType=" + this.botType + ", hoverEveryPrompt=" + this.hoverEveryPrompt + ')';
    }

    public final int getBotType() {
        return this.botType;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getHoverEveryPrompt() {
        return this.hoverEveryPrompt;
    }

    public UserPromptHoverConfig(boolean r100, int r101, boolean r102) {
        this.enable = r100;
        this.botType = r101;
        this.hoverEveryPrompt = r102;
    }

    public /* synthetic */ UserPromptHoverConfig(boolean r100, int r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }
}
