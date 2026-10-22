package com.larus.bmhome.chat.banner;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/larus/bmhome/chat/banner/ActiveSwitchBannerIconConfig;", "", "darkModeIcon", "Lcom/larus/bmhome/chat/banner/ActiveSwitchBannerImage;", "lightIcon", "<init>", "(Lcom/larus/bmhome/chat/banner/ActiveSwitchBannerImage;Lcom/larus/bmhome/chat/banner/ActiveSwitchBannerImage;)V", "getDarkModeIcon", "()Lcom/larus/bmhome/chat/banner/ActiveSwitchBannerImage;", "getLightIcon", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g {

    @SerializedName("dark_mode_icon")
    private final h darkModeIcon;

    @SerializedName("icon")
    private final h lightIcon;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.darkModeIcon, r101.darkModeIcon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lightIcon, r101.lightIcon) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        h r100 = this.darkModeIcon;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        h r104 = this.lightIcon;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActiveSwitchBannerIconConfig(darkModeIcon=" + this.darkModeIcon + ", lightIcon=" + this.lightIcon + ')';
    }

    public g() {
        this.darkModeIcon = null;
        this.lightIcon = null;
    }

    public final h a() {
        return this.darkModeIcon;
    }

    public final h b() {
        return this.lightIcon;
    }
}
