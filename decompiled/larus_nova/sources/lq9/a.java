package lq9;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/platform/model/audio/AsrCompressConfig;", "", "enableAll", "", "enablePoorNetwork", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "", "<init>", "(ZZF)V", "getEnableAll", "()Z", "getEnablePoorNetwork", "getRatio", "()F", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("enable_all")
    private final boolean enableAll;

    @SerializedName("enable_poor_network")
    private final boolean enablePoorNetwork;

    @SerializedName(MapBundleKey.OfflineMapKey.OFFLINE_RATION)
    private final float ratio;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.enableAll == r101.enableAll) goto L12;
        return false;
    L12:
        if (this.enablePoorNetwork == r101.enablePoorNetwork) goto L15;
        return false;
    L15:
        if (Float.compare(this.ratio, r101.ratio) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enableAll == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enablePoorNetwork == true) goto L11;
        r100 = 1237;
    L11:
        return ((r102 + r100) * 31) + Float.floatToIntBits(this.ratio);
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "AsrCompressConfig(enableAll=" + this.enableAll + ", enablePoorNetwork=" + this.enablePoorNetwork + ", ratio=" + this.ratio + ')';
    }

    public final boolean a() {
        return this.enableAll;
    }

    public final boolean b() {
        return this.enablePoorNetwork;
    }

    public final float c() {
        return this.ratio;
    }

    public a(int r100) {
        this.enableAll = false;
        this.enablePoorNetwork = false;
        this.ratio = 1.0f;
    }
}
