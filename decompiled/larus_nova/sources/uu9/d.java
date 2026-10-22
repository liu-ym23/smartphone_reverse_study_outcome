package uu9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/larus/settings/provider/home/SideBarConfig;", "", "sideBarEnable", "", "backPressedType", "", "<init>", "(Ljava/lang/String;I)V", "getSideBarEnable", "()Ljava/lang/String;", "getBackPressedType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("back_pressed_type")
    private final int backPressedType;

    @SerializedName("sidebar_enable")
    private final String sideBarEnable;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.sideBarEnable, r101.sideBarEnable) == true) goto L12;
        return false;
    L12:
        if (this.backPressedType == r101.backPressedType) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.sideBarEnable;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.backPressedType;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "SideBarConfig(sideBarEnable=" + this.sideBarEnable + ", backPressedType=" + this.backPressedType + ')';
    }

    public final int a() {
        return this.backPressedType;
    }

    public final String b() {
        return this.sideBarEnable;
    }

    public d(int r100) {
        this.sideBarEnable = "";
        this.backPressedType = 1;
    }
}
