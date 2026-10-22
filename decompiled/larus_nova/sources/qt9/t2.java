package qt9;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b+\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u0081\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010-\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0005HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013¨\u00062"}, d2 = {"Lcom/larus/settings/provider/LightLeakConfig;", "", "enable", "", "fetchPathTimeout", "", "fetchPathFork", "checkInterval", "leakThreshold", "activitySample", "fragmentSample", "sizeDeep", "maxDeep", "maxCount", "catchAll", "selfImpl", "<init>", "(ZIZIIIIIIIZZ)V", "getEnable", "()Z", "getFetchPathTimeout", "()I", "getFetchPathFork", "getCheckInterval", "getLeakThreshold", "getActivitySample", "getFragmentSample", "getSizeDeep", "getMaxDeep", "getMaxCount", "getCatchAll", "getSelfImpl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class t2 {

    @SerializedName("activity_sample")
    private final int activitySample;

    @SerializedName("catch_all")
    private final boolean catchAll;

    @SerializedName("check_interval")
    private final int checkInterval;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("fetch_path_fork")
    private final boolean fetchPathFork;

    @SerializedName("fetch_path_timeout")
    private final int fetchPathTimeout;

    @SerializedName("fragment_sample")
    private final int fragmentSample;

    @SerializedName("leak_threshold")
    private final int leakThreshold;

    @SerializedName(DownloadSettingKeys.RetryScheduleConfig.MAX_COUNT)
    private final int maxCount;

    @SerializedName("max_deep")
    private final int maxDeep;

    @SerializedName("self_impl")
    private final boolean selfImpl;

    @SerializedName("size_deep")
    private final int sizeDeep;

    public t2() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t2) == true) goto L8;
        return false;
    L8:
        t2 r101 = (t2) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.fetchPathTimeout == r101.fetchPathTimeout) goto L15;
        return false;
    L15:
        if (this.fetchPathFork == r101.fetchPathFork) goto L18;
        return false;
    L18:
        if (this.checkInterval == r101.checkInterval) goto L21;
        return false;
    L21:
        if (this.leakThreshold == r101.leakThreshold) goto L24;
        return false;
    L24:
        if (this.activitySample == r101.activitySample) goto L27;
        return false;
    L27:
        if (this.fragmentSample == r101.fragmentSample) goto L30;
        return false;
    L30:
        if (this.sizeDeep == r101.sizeDeep) goto L33;
        return false;
    L33:
        if (this.maxDeep == r101.maxDeep) goto L36;
        return false;
    L36:
        if (this.maxCount == r101.maxCount) goto L39;
        return false;
    L39:
        if (this.catchAll == r101.catchAll) goto L42;
        return false;
    L42:
        if (this.selfImpl == r101.selfImpl) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.fetchPathTimeout) * 31;
        if (this.fetchPathFork == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((((((((((((((r102 + r103) * 31) + this.checkInterval) * 31) + this.leakThreshold) * 31) + this.activitySample) * 31) + this.fragmentSample) * 31) + this.sizeDeep) * 31) + this.maxDeep) * 31) + this.maxCount) * 31;
        if (this.catchAll == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.selfImpl == true) goto L19;
        r100 = 1237;
    L19:
        return r106 + r100;
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
        return "LightLeakConfig(enable=" + this.enable + ", fetchPathTimeout=" + this.fetchPathTimeout + ", fetchPathFork=" + this.fetchPathFork + ", checkInterval=" + this.checkInterval + ", leakThreshold=" + this.leakThreshold + ", activitySample=" + this.activitySample + ", fragmentSample=" + this.fragmentSample + ", sizeDeep=" + this.sizeDeep + ", maxDeep=" + this.maxDeep + ", maxCount=" + this.maxCount + ", catchAll=" + this.catchAll + ", selfImpl=" + this.selfImpl + ')';
    }

    public t2(int r100) {
        this.enable = true;
        this.fetchPathTimeout = 30000;
        this.fetchPathFork = true;
        this.checkInterval = 60000;
        this.leakThreshold = 60000;
        this.activitySample = 1;
        this.fragmentSample = 1;
        this.sizeDeep = 10;
        this.maxDeep = 100;
        this.maxCount = 5;
        this.catchAll = true;
        this.selfImpl = false;
    }
}
