package jx6;

import com.bytedance.android.shopping.mall.feed.help.GYLFetchType;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.bytedance.locallife.dito.data.DitoNode;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Ljx6/k;", "", "", "statusCode", "I", "b", "()I", "", "lynxUrl", "Ljava/lang/String;", "getLynxUrl", "()Ljava/lang/String;", "rawData", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, DitoNode.LOAD_MORE, "getLoadMore", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class k {

    @SerializedName(GYLFetchType.LOAD_MORE)
    private final String loadMore;

    @SerializedName(SendClosePdpEventParam.KEY_LYNX_URL)
    private final String lynxUrl;

    @SerializedName(EventConstant.Key.RAW_DATA)
    private final String rawData;

    @SerializedName("status_code")
    private final int statusCode;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.statusCode == r101.statusCode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lynxUrl, r101.lynxUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.rawData, r101.rawData) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.loadMore, r101.loadMore) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.statusCode * 31;
        String r101 = this.lynxUrl;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.rawData;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.loadMore;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "HeadImageRateResponseData(statusCode=" + this.statusCode + ", lynxUrl=" + this.lynxUrl + ", rawData=" + this.rawData + ", loadMore=" + this.loadMore + ')';
    }

    public k() {
        this.statusCode = 0;
        this.lynxUrl = null;
        this.rawData = null;
        this.loadMore = null;
    }

    public final String a() {
        return this.rawData;
    }

    public final int b() {
        return this.statusCode;
    }
}
