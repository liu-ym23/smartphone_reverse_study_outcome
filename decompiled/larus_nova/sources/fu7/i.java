package fu7;

import com.google.gson.annotations.SerializedName;
import com.obric.sva.sdk.utils.InteractConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J>\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0002\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006!"}, d2 = {"Lcom/flow/performance/perftag/EnergyControlPerfTags;", "", "isCharging", "", "screenState", "", "backgroundState", "locationPermissionState", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "setCharging", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getScreenState", "()Ljava/lang/String;", "setScreenState", "(Ljava/lang/String;)V", "getBackgroundState", "setBackgroundState", "getLocationPermissionState", "setLocationPermissionState", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/flow/performance/perftag/EnergyControlPerfTags;", "equals", "other", "hashCode", "", "toString", "performance_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class i {

    @SerializedName("background_state")
    private String backgroundState;

    @SerializedName("is_charging")
    private Boolean isCharging;

    @SerializedName("location_state")
    private String locationPermissionState;

    @SerializedName(InteractConst.WAKEUP_SCREEN_STATE)
    private String screenState;

    public i() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.isCharging, r101.isCharging) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.screenState, r101.screenState) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.backgroundState, r101.backgroundState) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.locationPermissionState, r101.locationPermissionState) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.isCharging;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.screenState;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.backgroundState;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.locationPermissionState;
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
        return "EnergyControlPerfTags(isCharging=" + this.isCharging + ", screenState=" + this.screenState + ", backgroundState=" + this.backgroundState + ", locationPermissionState=" + this.locationPermissionState + ')';
    }

    public final String a() {
        return this.backgroundState;
    }

    public final String b() {
        return this.locationPermissionState;
    }

    public final String c() {
        return this.screenState;
    }

    public i(int r100) {
        this.isCharging = null;
        this.screenState = null;
        this.backgroundState = null;
        this.locationPermissionState = null;
    }

    public final void d(String r100) {
        this.backgroundState = r100;
    }

    public final void e(String r100) {
        this.locationPermissionState = r100;
    }

    public final void f(String r100) {
        this.screenState = r100;
    }
}
