package com.larus.bmhome.auth;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J8\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/auth/TouristModeABParam;", "Ljava/io/Serializable;", "type", "", "canFreeTyping", "", "loginWindowStyle", "launchLandingPage", "<init>", "(Ljava/lang/Integer;ZII)V", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCanFreeTyping", "()Z", "getLoginWindowStyle", "()I", "getLaunchLandingPage", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;ZII)Lcom/larus/bmhome/auth/TouristModeABParam;", "equals", "other", "", "hashCode", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TouristModeABParam implements Serializable {

    @SerializedName("free_typing")
    private final boolean canFreeTyping;

    @SerializedName("landing_type")
    private final int launchLandingPage;

    @SerializedName("login_window_style")
    private final int loginWindowStyle;

    @SerializedName("type")
    private final Integer type;

    public TouristModeABParam() {
        this(null, false, 0, 0, 15, null);
    }

    public static /* synthetic */ TouristModeABParam copy$default(TouristModeABParam r100, Integer r101, boolean r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.canFreeTyping;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.loginWindowStyle;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.launchLandingPage;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Integer component1() {
        return this.type;
    }

    public final boolean component2() {
        return this.canFreeTyping;
    }

    public final int component3() {
        return this.loginWindowStyle;
    }

    public final int component4() {
        return this.launchLandingPage;
    }

    public final TouristModeABParam copy(Integer r100, boolean r101, int r102, int r103) {
        return new TouristModeABParam(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TouristModeABParam) == true) goto L8;
        return false;
    L8:
        TouristModeABParam r101 = (TouristModeABParam) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (this.canFreeTyping == r101.canFreeTyping) goto L15;
        return false;
    L15:
        if (this.loginWindowStyle == r101.loginWindowStyle) goto L18;
        return false;
    L18:
        if (this.launchLandingPage == r101.launchLandingPage) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.type;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.canFreeTyping == false) goto L9;
        int r103 = 1231;
    L11:
        return ((((r102 + r103) * 31) + this.loginWindowStyle) * 31) + this.launchLandingPage;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "TouristModeABParam(type=" + this.type + ", canFreeTyping=" + this.canFreeTyping + ", loginWindowStyle=" + this.loginWindowStyle + ", launchLandingPage=" + this.launchLandingPage + ')';
    }

    public final boolean getCanFreeTyping() {
        return this.canFreeTyping;
    }

    public final int getLaunchLandingPage() {
        return this.launchLandingPage;
    }

    public final int getLoginWindowStyle() {
        return this.loginWindowStyle;
    }

    public final Integer getType() {
        return this.type;
    }

    public TouristModeABParam(Integer r100, boolean r101, int r102, int r103) {
        this.type = r100;
        this.canFreeTyping = r101;
        this.loginWindowStyle = r102;
        this.launchLandingPage = r103;
    }

    public /* synthetic */ TouristModeABParam(Integer r100, boolean r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 1;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 1;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 1;
    L14:
        this(r100, r101, r102, r103);
    }
}
