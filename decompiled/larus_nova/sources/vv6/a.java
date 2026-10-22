package vv6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lvv6/a;", "", "", "enable", "Z", "getEnable", "()Z", "", "duration", "I", "getDuration", "()I", "", "lifeMallChannelBid", "Ljava/lang/String;", "getLifeMallChannelBid", "()Ljava/lang/String;", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("duration")
    private final int duration;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("bid")
    private final String lifeMallChannelBid;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.duration == r101.duration) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lifeMallChannelBid, r101.lifeMallChannelBid) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.enable == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.duration) * 31;
        String r102 = this.lifeMallChannelBid;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "BottomBarStyleConfig(enable=" + this.enable + ", duration=" + this.duration + ", lifeMallChannelBid=" + this.lifeMallChannelBid + ')';
    }

    public a() {
        this.enable = false;
        this.duration = 10000;
        this.lifeMallChannelBid = null;
    }
}
