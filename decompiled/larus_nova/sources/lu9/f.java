package lu9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J5\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/larus/settings/provider/disk/AppOnlineCleanConfig;", "", "enableOnlineClean", "", "onlineCleanVersion", "", "internalCleanPath", "Lcom/larus/settings/provider/disk/PathConfig;", "externalCleanPath", "<init>", "(ZJLcom/larus/settings/provider/disk/PathConfig;Lcom/larus/settings/provider/disk/PathConfig;)V", "getEnableOnlineClean", "()Z", "getOnlineCleanVersion", "()J", "getInternalCleanPath", "()Lcom/larus/settings/provider/disk/PathConfig;", "getExternalCleanPath", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    @SerializedName("enable_online_clean")
    private final boolean enableOnlineClean;

    @SerializedName("external_clean_path")
    private final h externalCleanPath;

    @SerializedName("internal_clean_path")
    private final h internalCleanPath;

    @SerializedName("online_clean_version")
    private final long onlineCleanVersion;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.enableOnlineClean == r101.enableOnlineClean) goto L12;
        return false;
    L12:
        if (this.onlineCleanVersion == r101.onlineCleanVersion) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.internalCleanPath, r101.internalCleanPath) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.externalCleanPath, r101.externalCleanPath) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.enableOnlineClean == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.onlineCleanVersion;
        int r102 = ((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        h r103 = this.internalCleanPath;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        h r107 = this.externalCleanPath;
        if (r107 == null) goto L15;
        r104 = r107.hashCode();
    L15:
        return r106 + r104;
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "AppOnlineCleanConfig(enableOnlineClean=" + this.enableOnlineClean + ", onlineCleanVersion=" + this.onlineCleanVersion + ", internalCleanPath=" + this.internalCleanPath + ", externalCleanPath=" + this.externalCleanPath + ')';
    }

    public final boolean a() {
        return this.enableOnlineClean;
    }

    public final h b() {
        return this.externalCleanPath;
    }

    public final h c() {
        return this.internalCleanPath;
    }

    public final long d() {
        return this.onlineCleanVersion;
    }

    public f(int r100) {
        this.enableOnlineClean = false;
        this.onlineCleanVersion = 0;
        this.internalCleanPath = null;
        this.externalCleanPath = null;
    }
}
