package hq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/larus/platform/model/FrequentMethodOptConfig;", "", "vContextOpt", "", "loginInfoOpt", "fastSendAccessibilityOpt", "onlyReadVideoNotGrantedOpt", "settingReadOpt", "<init>", "(ZZZZZ)V", "getVContextOpt", "()Z", "getLoginInfoOpt", "getFastSendAccessibilityOpt", "getOnlyReadVideoNotGrantedOpt", "getSettingReadOpt", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k1 {

    @SerializedName("fast_send_accessibility_opt")
    private final boolean fastSendAccessibilityOpt;

    @SerializedName("login_info_opt")
    private final boolean loginInfoOpt;

    @SerializedName("only_read_video_not_granted_opt")
    private final boolean onlyReadVideoNotGrantedOpt;

    @SerializedName("setting_read_opt")
    private final boolean settingReadOpt;

    @SerializedName("vcontext_opt")
    private final boolean vContextOpt;

    public k1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k1) == true) goto L8;
        return false;
    L8:
        k1 r101 = (k1) r100;
        if (this.vContextOpt == r101.vContextOpt) goto L12;
        return false;
    L12:
        if (this.loginInfoOpt == r101.loginInfoOpt) goto L15;
        return false;
    L15:
        if (this.fastSendAccessibilityOpt == r101.fastSendAccessibilityOpt) goto L18;
        return false;
    L18:
        if (this.onlyReadVideoNotGrantedOpt == r101.onlyReadVideoNotGrantedOpt) goto L21;
        return false;
    L21:
        if (this.settingReadOpt == r101.settingReadOpt) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.vContextOpt == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.loginInfoOpt == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.fastSendAccessibilityOpt == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.onlyReadVideoNotGrantedOpt == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.settingReadOpt == true) goto L23;
        r100 = 1237;
    L23:
        return r108 + r100;
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FrequentMethodOptConfig(vContextOpt=" + this.vContextOpt + ", loginInfoOpt=" + this.loginInfoOpt + ", fastSendAccessibilityOpt=" + this.fastSendAccessibilityOpt + ", onlyReadVideoNotGrantedOpt=" + this.onlyReadVideoNotGrantedOpt + ", settingReadOpt=" + this.settingReadOpt + ')';
    }

    public final boolean a() {
        return this.fastSendAccessibilityOpt;
    }

    public final boolean b() {
        return this.loginInfoOpt;
    }

    public final boolean c() {
        return this.onlyReadVideoNotGrantedOpt;
    }

    public final boolean d() {
        return this.settingReadOpt;
    }

    public final boolean e() {
        return this.vContextOpt;
    }

    public k1(int r100) {
        this.vContextOpt = false;
        this.loginInfoOpt = false;
        this.fastSendAccessibilityOpt = false;
        this.onlyReadVideoNotGrantedOpt = false;
        this.settingReadOpt = false;
    }
}
