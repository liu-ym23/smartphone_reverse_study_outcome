package jv6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Ljv6/d;", "", "Ljv6/f;", "liveIconStyleOne", "Ljv6/f;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljv6/f;", "liveIconStyleTwo", "getLiveIconStyleTwo", "localLifeIconStyleOne", "getLocalLifeIconStyleOne", "localLifeIconStyleTwo", "getLocalLifeIconStyleTwo", "locallife-live-api_release"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("live_icon_style_one")
    private final f liveIconStyleOne;

    @SerializedName("live_icon_style_two")
    private final f liveIconStyleTwo;

    @SerializedName("local_life_icon_style_one")
    private final f localLifeIconStyleOne;

    @SerializedName("local_life_icon_style_two")
    private final f localLifeIconStyleTwo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.liveIconStyleOne, r101.liveIconStyleOne) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.liveIconStyleTwo, r101.liveIconStyleTwo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.localLifeIconStyleOne, r101.localLifeIconStyleOne) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.localLifeIconStyleTwo, r101.localLifeIconStyleTwo) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        f r100 = this.liveIconStyleOne;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        f r104 = this.liveIconStyleTwo;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        f r107 = this.localLifeIconStyleOne;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        f r110 = this.localLifeIconStyleTwo;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "GrouponIconStyle(liveIconStyleOne=" + this.liveIconStyleOne + ", liveIconStyleTwo=" + this.liveIconStyleTwo + ", localLifeIconStyleOne=" + this.localLifeIconStyleOne + ", localLifeIconStyleTwo=" + this.localLifeIconStyleTwo + ')';
    }

    public d() {
        this.liveIconStyleOne = null;
        this.liveIconStyleTwo = null;
        this.localLifeIconStyleOne = null;
        this.localLifeIconStyleTwo = null;
    }

    public final f a() {
        return this.liveIconStyleOne;
    }
}
