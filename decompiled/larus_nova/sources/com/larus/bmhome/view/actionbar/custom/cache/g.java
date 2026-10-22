package com.larus.bmhome.view.actionbar.custom.cache;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/view/actionbar/custom/cache/ActionBarRedDotCacheEntity;", "", "itemId", "", RuleConditionBean.VERSION_CODE_KEY, "", "exposureTimes", "", "<init>", "(Ljava/lang/String;JI)V", "getItemId", "()Ljava/lang/String;", "getVersionCode", "()J", "getExposureTimes", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g {

    @SerializedName("exposure_times")
    private final int exposureTimes;

    @SerializedName("item_id")
    private final String itemId;

    @SerializedName("version_code")
    private final long versionCode;

    public g() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L12;
        return false;
    L12:
        if (this.versionCode == r101.versionCode) goto L15;
        return false;
    L15:
        if (this.exposureTimes == r101.exposureTimes) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.itemId;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        long r102 = this.versionCode;
        return (((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.exposureTimes;
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionBarRedDotCacheEntity(itemId=" + this.itemId + ", versionCode=" + this.versionCode + ", exposureTimes=" + this.exposureTimes + ')';
    }

    public final int b() {
        return this.exposureTimes;
    }

    public final long c() {
        return this.versionCode;
    }

    public /* synthetic */ g(String r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r101 & 2) == 0) goto L8;
        long r102 = -1;
    L9:
        this(r100, r102, 0);
        return;
    L8:
        r102 = 0;
        goto L9
    }

    public g(String r100, long r101, int r102) {
        this.itemId = r100;
        this.versionCode = r101;
        this.exposureTimes = r102;
    }

    public static g a(g r100, String r101, long r102, int r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.itemId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.versionCode;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.exposureTimes;
    L12:
        return new g(r101, r102, r103);
    }
}
