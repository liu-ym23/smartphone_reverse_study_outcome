package yw6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"Lyw6/a0;", "", "", "sharePlayInfo", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "statusCode", "I", "b", "()I", "statusMessage", "c", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class a0 {

    @SerializedName("share_play_info")
    private final String sharePlayInfo;

    @SerializedName("status_code")
    private final int statusCode;

    @SerializedName("status_message")
    private final String statusMessage;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (Intrinsics.areEqual(this.sharePlayInfo, r101.sharePlayInfo) == true) goto L12;
        return false;
    L12:
        if (this.statusCode == r101.statusCode) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.statusMessage, r101.statusMessage) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.sharePlayInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.statusCode) * 31;
        String r104 = this.statusMessage;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SharePlayInfo(sharePlayInfo=" + this.sharePlayInfo + ", statusCode=" + this.statusCode + ", statusMessage=" + this.statusMessage + ')';
    }

    public a0() {
        this.sharePlayInfo = null;
        this.statusCode = -1;
        this.statusMessage = null;
    }

    public final String a() {
        return this.sharePlayInfo;
    }

    public final int b() {
        return this.statusCode;
    }

    public final String c() {
        return this.statusMessage;
    }
}
