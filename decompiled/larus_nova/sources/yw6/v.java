package yw6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lyw6/v;", "", "Lyw6/a0;", "masterSharePlayInfo", "Lyw6/a0;", "b", "()Lyw6/a0;", "guestSharePlayInfo", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "needRequest", "Z", "getNeedRequest", "()Z", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class v {

    @SerializedName("guest_share_play_info")
    private final a0 guestSharePlayInfo;

    @SerializedName("master_share_play_info")
    private final a0 masterSharePlayInfo;

    @SerializedName("need_request")
    private final boolean needRequest;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.masterSharePlayInfo, r101.masterSharePlayInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.guestSharePlayInfo, r101.guestSharePlayInfo) == true) goto L15;
        return false;
    L15:
        if (this.needRequest == r101.needRequest) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        a0 r100 = this.masterSharePlayInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        a0 r104 = this.guestSharePlayInfo;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        if (this.needRequest == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MarketingShareInfo(masterSharePlayInfo=" + this.masterSharePlayInfo + ", guestSharePlayInfo=" + this.guestSharePlayInfo + ", needRequest=" + this.needRequest + ')';
    }

    public v() {
        this.masterSharePlayInfo = null;
        this.guestSharePlayInfo = null;
        this.needRequest = false;
    }

    public final a0 a() {
        return this.guestSharePlayInfo;
    }

    public final a0 b() {
        return this.masterSharePlayInfo;
    }
}
