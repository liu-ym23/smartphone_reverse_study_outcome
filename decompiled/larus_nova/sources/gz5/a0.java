package gz5;

import androidx.camera.video.AudioStats;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015¨\u0006\u001a"}, d2 = {"Lgz5/a0;", "", "", "monitorRate", "D", "getMonitorRate", "()D", "applogRate", "getApplogRate", "npthRate", "getNpthRate", "", "usedControl", "Ljava/lang/String;", "getUsedControl", "()Ljava/lang/String;", "", "Lgz5/z;", "interestBinders", "Ljava/util/List;", "getInterestBinders", "()Ljava/util/List;", "skipActions", "getSkipActions", "skipProviders", "getSkipProviders", "api_release"}, k = 1, mv = {1, 4, 0})
public final class a0 {

    @SerializedName("applog_rate")
    private final double applogRate;

    @SerializedName("interest_binders")
    private final List<z> interestBinders;

    @SerializedName("monitor_rate")
    private final double monitorRate;

    @SerializedName("npth_rate")
    private final double npthRate;

    @SerializedName("skip_actions")
    private final List<String> skipActions;

    @SerializedName("skip_providers")
    private final List<String> skipProviders;

    @SerializedName("used_control")
    private final String usedControl;

    public a0() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a0) == false) goto L20;
        a0 r101 = (a0) r100;
        if (Double.compare(this.monitorRate, r101.monitorRate) == 0) goto L8;
        return false;
    L8:
        if (Double.compare(this.applogRate, r101.applogRate) == 0) goto L10;
        return false;
    L10:
        if (Double.compare(this.npthRate, r101.npthRate) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.usedControl, r101.usedControl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.interestBinders, r101.interestBinders) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.skipActions, r101.skipActions) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.skipProviders, r101.skipProviders) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.monitorRate);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.applogRate);
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = Double.doubleToLongBits(this.npthRate);
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        String r106 = this.usedControl;
        int r107 = 0;
        if (r106 == null) goto L5;
        int r108 = r106.hashCode();
    L6:
        int r109 = (r105 + r108) * 31;
        List<z> r110 = this.interestBinders;
        if (r110 == null) goto L9;
        int r111 = r110.hashCode();
    L10:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.skipActions;
        if (r113 == null) goto L13;
        int r114 = r113.hashCode();
    L14:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.skipProviders;
        if (r116 == null) goto L18;
        r107 = r116.hashCode();
    L18:
        return r115 + r107;
    L13:
        r114 = 0;
        goto L14
    L9:
        r111 = 0;
        goto L10
    L5:
        r108 = 0;
        goto L6
    }

    public final String toString() {
        return "ShareConfig(monitorRate=" + this.monitorRate + ", applogRate=" + this.applogRate + ", npthRate=" + this.npthRate + ", usedControl=" + this.usedControl + ", interestBinders=" + this.interestBinders + ", skipActions=" + this.skipActions + ", skipProviders=" + this.skipProviders + ")";
    }

    public a0(Object r100) {
        List<z> r101 = CollectionsKt.emptyList();
        List<String> r102 = CollectionsKt.emptyList();
        List<String> r103 = CollectionsKt.emptyList();
        this.monitorRate = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.applogRate = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.npthRate = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.usedControl = "legacy";
        this.interestBinders = r101;
        this.skipActions = r102;
        this.skipProviders = r103;
    }
}
