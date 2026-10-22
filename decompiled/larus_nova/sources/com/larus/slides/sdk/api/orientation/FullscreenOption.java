package com.larus.slides.sdk.api.orientation;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/larus/slides/sdk/api/orientation/FullscreenOption;", "", "hideStatusBar", "", "hideNavigationBar", "immersive", "clickFrom", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getHideStatusBar", "()Ljava/lang/Boolean;", "setHideStatusBar", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getHideNavigationBar", "setHideNavigationBar", "getImmersive", "setImmersive", "getClickFrom", "()Ljava/lang/String;", "setClickFrom", "(Ljava/lang/String;)V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FullscreenOption {

    @SerializedName("clickFrom")
    private String clickFrom;

    @SerializedName("hideNavigationBar")
    private Boolean hideNavigationBar;

    @SerializedName("hideStatusBar")
    private Boolean hideStatusBar;

    @SerializedName("immersive")
    private Boolean immersive;

    public FullscreenOption() {
        this(null, null, null, null, 15, null);
    }

    public final String getClickFrom() {
        return this.clickFrom;
    }

    public final Boolean getHideNavigationBar() {
        return this.hideNavigationBar;
    }

    public final Boolean getHideStatusBar() {
        return this.hideStatusBar;
    }

    public final Boolean getImmersive() {
        return this.immersive;
    }

    public final void setClickFrom(String r100) {
        this.clickFrom = r100;
    }

    public final void setHideNavigationBar(Boolean r100) {
        this.hideNavigationBar = r100;
    }

    public final void setHideStatusBar(Boolean r100) {
        this.hideStatusBar = r100;
    }

    public final void setImmersive(Boolean r100) {
        this.immersive = r100;
    }

    public FullscreenOption(Boolean r100, Boolean r101, Boolean r102, String r103) {
        this.hideStatusBar = r100;
        this.hideNavigationBar = r101;
        this.immersive = r102;
        this.clickFrom = r103;
    }

    public /* synthetic */ FullscreenOption(Boolean r100, Boolean r101, Boolean r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = Boolean.TRUE;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = Boolean.TRUE;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = Boolean.TRUE;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
