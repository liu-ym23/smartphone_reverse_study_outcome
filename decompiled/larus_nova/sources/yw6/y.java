package yw6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lyw6/y;", "", "", "needRequest", "Z", "getNeedRequest", "()Z", "Lyw6/z;", "requestParams", "Lyw6/z;", "getRequestParams", "()Lyw6/z;", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class y {

    @SerializedName("need_request")
    private final boolean needRequest;

    @SerializedName("request_params")
    private final z requestParams;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (this.needRequest == r101.needRequest) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.requestParams, r101.requestParams) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.needRequest == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        z r102 = this.requestParams;
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
        return "SharePanelRequestInfo(needRequest=" + this.needRequest + ", requestParams=" + this.requestParams + ')';
    }

    public y() {
        this.needRequest = false;
        this.requestParams = null;
    }
}
