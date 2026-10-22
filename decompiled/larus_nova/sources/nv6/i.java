package nv6;

import com.bytedance.locallife.host.model.UrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lnv6/i;", "", "Lcom/bytedance/locallife/host/model/UrlModel;", "icon", "Lcom/bytedance/locallife/host/model/UrlModel;", "c", "()Lcom/bytedance/locallife/host/model/UrlModel;", "", "coinTips", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "Lnv6/j0;", "gradientColors", "Lnv6/j0;", "b", "()Lnv6/j0;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("reward_task_text")
    private final String coinTips;

    @SerializedName("reward_task_bg")
    private final j0 gradientColors;

    @SerializedName("reward_task_icon")
    private final UrlModel icon;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.coinTips, r101.coinTips) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.gradientColors, r101.gradientColors) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        UrlModel r100 = this.icon;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.coinTips;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        j0 r107 = this.gradientColors;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CoinInfoData(icon=" + this.icon + ", coinTips=" + this.coinTips + ", gradientColors=" + this.gradientColors + ')';
    }

    public i() {
        this.icon = null;
        this.coinTips = null;
        this.gradientColors = null;
    }

    public final String a() {
        return this.coinTips;
    }

    public final j0 b() {
        return this.gradientColors;
    }

    public final UrlModel c() {
        return this.icon;
    }
}
