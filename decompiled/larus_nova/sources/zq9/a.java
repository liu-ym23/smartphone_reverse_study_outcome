package zq9;

import com.google.gson.annotations.SerializedName;
import com.ttnet.org.chromium.base.TimeUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u000eHÆ\u0003Jm\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010)\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020-HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006."}, d2 = {"Lcom/larus/platform/model/multitask_management/MultiTaskManagementConfig;", "", "maxOngoingTaskCount", "", "remoteTaskPollingInterval", "", "remoteTaskIdlePollingInterval", "remoteTaskPollingScatter", "remoteTaskRefreshInterval", "maxPinCount", "pinListPageCount", "recentVisitPageCount", "discoverListPageCount", "enableDialogBackHook", "", "<init>", "(IJJJJIIIIZ)V", "getMaxOngoingTaskCount", "()I", "getRemoteTaskPollingInterval", "()J", "getRemoteTaskIdlePollingInterval", "getRemoteTaskPollingScatter", "getRemoteTaskRefreshInterval", "getMaxPinCount", "getPinListPageCount", "getRecentVisitPageCount", "getDiscoverListPageCount", "getEnableDialogBackHook", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("discover_list_page_count")
    private final int discoverListPageCount;

    @SerializedName("enable_dialog_back_hook")
    private final boolean enableDialogBackHook;

    @SerializedName("max_ongoing_task_count")
    private final int maxOngoingTaskCount;

    @SerializedName("max_pin_count")
    private final int maxPinCount;

    @SerializedName("pin_list_page_count")
    private final int pinListPageCount;

    @SerializedName("recent_visit_page_count")
    private final int recentVisitPageCount;

    @SerializedName("remote_task_idle_polling_interval")
    private final long remoteTaskIdlePollingInterval;

    @SerializedName("remote_task_polling_interval")
    private final long remoteTaskPollingInterval;

    @SerializedName("remote_task_polling_scatter")
    private final long remoteTaskPollingScatter;

    @SerializedName("remote_task_refresh_interval")
    private final long remoteTaskRefreshInterval;

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
        if (this.maxOngoingTaskCount == r101.maxOngoingTaskCount) goto L12;
        return false;
    L12:
        if (this.remoteTaskPollingInterval == r101.remoteTaskPollingInterval) goto L15;
        return false;
    L15:
        if (this.remoteTaskIdlePollingInterval == r101.remoteTaskIdlePollingInterval) goto L18;
        return false;
    L18:
        if (this.remoteTaskPollingScatter == r101.remoteTaskPollingScatter) goto L21;
        return false;
    L21:
        if (this.remoteTaskRefreshInterval == r101.remoteTaskRefreshInterval) goto L24;
        return false;
    L24:
        if (this.maxPinCount == r101.maxPinCount) goto L27;
        return false;
    L27:
        if (this.pinListPageCount == r101.pinListPageCount) goto L30;
        return false;
    L30:
        if (this.recentVisitPageCount == r101.recentVisitPageCount) goto L33;
        return false;
    L33:
        if (this.discoverListPageCount == r101.discoverListPageCount) goto L36;
        return false;
    L36:
        if (this.enableDialogBackHook == r101.enableDialogBackHook) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = this.maxOngoingTaskCount * 31;
        long r101 = this.remoteTaskPollingInterval;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.remoteTaskIdlePollingInterval;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.remoteTaskPollingScatter;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.remoteTaskRefreshInterval;
        int r108 = (((((((((r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31) + this.maxPinCount) * 31) + this.pinListPageCount) * 31) + this.recentVisitPageCount) * 31) + this.discoverListPageCount) * 31;
        if (this.enableDialogBackHook == false) goto L5;
        int r109 = 1231;
    L7:
        return r108 + r109;
    L5:
        r109 = 1237;
        goto L7
    }

    public final String toString() {
        return "MultiTaskManagementConfig(maxOngoingTaskCount=" + this.maxOngoingTaskCount + ", remoteTaskPollingInterval=" + this.remoteTaskPollingInterval + ", remoteTaskIdlePollingInterval=" + this.remoteTaskIdlePollingInterval + ", remoteTaskPollingScatter=" + this.remoteTaskPollingScatter + ", remoteTaskRefreshInterval=" + this.remoteTaskRefreshInterval + ", maxPinCount=" + this.maxPinCount + ", pinListPageCount=" + this.pinListPageCount + ", recentVisitPageCount=" + this.recentVisitPageCount + ", discoverListPageCount=" + this.discoverListPageCount + ", enableDialogBackHook=" + this.enableDialogBackHook + ')';
    }

    public final int a() {
        return this.discoverListPageCount;
    }

    public final boolean b() {
        return this.enableDialogBackHook;
    }

    public final int c() {
        return this.maxOngoingTaskCount;
    }

    public final int d() {
        return this.maxPinCount;
    }

    public final int e() {
        return this.pinListPageCount;
    }

    public final int f() {
        return this.recentVisitPageCount;
    }

    public final long g() {
        return this.remoteTaskIdlePollingInterval;
    }

    public final long h() {
        return this.remoteTaskPollingInterval;
    }

    public final long i() {
        return this.remoteTaskPollingScatter;
    }

    public final long j() {
        return this.remoteTaskRefreshInterval;
    }

    public a(int r100) {
        this.maxOngoingTaskCount = 50;
        this.remoteTaskPollingInterval = 60;
        this.remoteTaskIdlePollingInterval = 300;
        this.remoteTaskPollingScatter = 10;
        this.remoteTaskRefreshInterval = TimeUtils.SECONDS_PER_HOUR;
        this.maxPinCount = 50;
        this.pinListPageCount = 50;
        this.recentVisitPageCount = 20;
        this.discoverListPageCount = 50;
        this.enableDialogBackHook = false;
    }
}
