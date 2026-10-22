package zv9;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/larus/settings/provider/security/TTNetEncryptConfig;", "", "enable", "", "enableMob", "encryptList", "", "Lcom/larus/settings/provider/security/EncryptItem;", "<init>", "(ZZLjava/util/List;)V", "getEnable", "()Z", "getEnableMob", "getEncryptList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class u {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_mob")
    private final boolean enableMob;

    @SerializedName("encrypt_list")
    private final List<h> encryptList;

    public u() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.enableMob == r101.enableMob) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.encryptList, r101.encryptList) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableMob == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        List<h> r104 = this.encryptList;
        if (r104 != null) goto L13;
        int r105 = 0;
    L15:
        return r103 + r105;
    L13:
        r105 = r104.hashCode();
        goto L15
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "TTNetEncryptConfig(enable=" + this.enable + ", enableMob=" + this.enableMob + ", encryptList=" + this.encryptList + ')';
    }

    public final boolean a() {
        return this.enable;
    }

    public final boolean b() {
        return this.enableMob;
    }

    public final List<h> c() {
        return this.encryptList;
    }

    public u(Object r100) {
        this.enable = false;
        this.enableMob = false;
        this.encryptList = null;
    }
}
