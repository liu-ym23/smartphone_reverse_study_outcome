package com.bytedance.geckox.pcdn;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0083\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/geckox/pcdn/OdlDownloadSize;", "", "p2pSize", "", "cdnSize", "(JJ)V", "getCdnSize", "()J", "getP2pSize", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
final class OdlDownloadSize {

    @SerializedName(MonitorConstants.CDN_SIZE)
    private final long cdnSize;

    @SerializedName("p2p_size")
    private final long p2pSize;

    public static /* synthetic */ OdlDownloadSize copy$default(OdlDownloadSize r100, long r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.p2pSize;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.cdnSize;
    L9:
        return r100.copy(r101, r102);
    }

    public final long component1() {
        return this.p2pSize;
    }

    public final long component2() {
        return this.cdnSize;
    }

    public final OdlDownloadSize copy(long r100, long r101) {
        return new OdlDownloadSize(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof OdlDownloadSize) == false) goto L10;
        OdlDownloadSize r101 = (OdlDownloadSize) r100;
        if (this.p2pSize == r101.p2pSize) goto L8;
        return false;
    L8:
        if (this.cdnSize == r101.cdnSize) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        long r100 = this.p2pSize;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.cdnSize;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public String toString() {
        return "OdlDownloadSize(p2pSize=" + this.p2pSize + ", cdnSize=" + this.cdnSize + ")";
    }

    public final long getCdnSize() {
        return this.cdnSize;
    }

    public final long getP2pSize() {
        return this.p2pSize;
    }

    public OdlDownloadSize(long r100, long r101) {
        this.p2pSize = r100;
        this.cdnSize = r101;
    }
}
