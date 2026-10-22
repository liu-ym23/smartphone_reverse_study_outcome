package hq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/larus/platform/model/WeakNetBasicConfig;", "", "noticeCacheWaitInterval", "", "noticeListCacheEnable", "", "<init>", "(IZ)V", "getNoticeCacheWaitInterval", "()I", "getNoticeListCacheEnable", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e5 {

    @SerializedName("notice_cache_wait_interval")
    private final int noticeCacheWaitInterval;

    @SerializedName("notice_list_cache_enable")
    private final boolean noticeListCacheEnable;

    public e5() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e5) == true) goto L8;
        return false;
    L8:
        e5 r101 = (e5) r100;
        if (this.noticeCacheWaitInterval == r101.noticeCacheWaitInterval) goto L12;
        return false;
    L12:
        if (this.noticeListCacheEnable == r101.noticeListCacheEnable) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.noticeCacheWaitInterval * 31;
        if (this.noticeListCacheEnable == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "WeakNetBasicConfig(noticeCacheWaitInterval=" + this.noticeCacheWaitInterval + ", noticeListCacheEnable=" + this.noticeListCacheEnable + ')';
    }

    public final int a() {
        return this.noticeCacheWaitInterval;
    }

    public final boolean b() {
        return this.noticeListCacheEnable;
    }

    public e5(int r100) {
        this.noticeCacheWaitInterval = 800;
        this.noticeListCacheEnable = true;
    }
}
