package r06;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lr06/b;", "", "", "initSyncTimeWaiting", "J", "b", "()J", "", "jsbPermissionInitMode", "I", "d", "()I", "jsbPermissionInitAwaitTime", "c", "", "enableRouteAssociate", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("enable_route_associate")
    private final boolean enableRouteAssociate;

    @SerializedName("init_sync_time_waiting")
    private final long initSyncTimeWaiting;

    @SerializedName("jsb_permission_init_await_time")
    private final long jsbPermissionInitAwaitTime;

    @SerializedName("jsb_permission_init_mode")
    private final int jsbPermissionInitMode;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.initSyncTimeWaiting == r101.initSyncTimeWaiting) goto L12;
        return false;
    L12:
        if (this.jsbPermissionInitMode == r101.jsbPermissionInitMode) goto L15;
        return false;
    L15:
        if (this.jsbPermissionInitAwaitTime == r101.jsbPermissionInitAwaitTime) goto L18;
        return false;
    L18:
        if (this.enableRouteAssociate == r101.enableRouteAssociate) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r100 = this.initSyncTimeWaiting;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.jsbPermissionInitMode) * 31;
        long r102 = this.jsbPermissionInitAwaitTime;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        if (this.enableRouteAssociate == false) goto L5;
        int r104 = 1231;
    L7:
        return r103 + r104;
    L5:
        r104 = 1237;
        goto L7
    }

    public final String toString() {
        return "ArgusInitSetting(initSyncTimeWaiting=" + this.initSyncTimeWaiting + ", jsbPermissionInitMode=" + this.jsbPermissionInitMode + ", jsbPermissionInitAwaitTime=" + this.jsbPermissionInitAwaitTime + ", enableRouteAssociate=" + this.enableRouteAssociate + ')';
    }

    public final boolean a() {
        return this.enableRouteAssociate;
    }

    public final long b() {
        return this.initSyncTimeWaiting;
    }

    public final long c() {
        return this.jsbPermissionInitAwaitTime;
    }

    public final int d() {
        return this.jsbPermissionInitMode;
    }

    public b(int r100) {
        this.initSyncTimeWaiting = 1500;
        this.jsbPermissionInitMode = 0;
        this.jsbPermissionInitAwaitTime = 1500;
        this.enableRouteAssociate = false;
    }
}
