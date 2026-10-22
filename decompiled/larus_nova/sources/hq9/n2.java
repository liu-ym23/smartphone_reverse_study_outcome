package hq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/platform/model/LarkSocialConfig;", "", "enable", "", "bootType", "", "<init>", "(ZI)V", "getEnable", "()Z", "getBootType", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class n2 {

    @SerializedName("boot_type")
    private final int bootType;

    @SerializedName("enable")
    private final boolean enable;

    public static final class a {
    }

    static {
    }

    public n2() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n2) == true) goto L8;
        return false;
    L8:
        n2 r101 = (n2) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.bootType == r101.bootType) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.enable == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.bootType;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "LarkSocialConfig(enable=" + this.enable + ", bootType=" + this.bootType + ')';
    }

    public final int a() {
        return this.bootType;
    }

    public final boolean b() {
        return this.enable;
    }

    public n2(int r100) {
        this.enable = false;
        this.bootType = 1;
    }
}
