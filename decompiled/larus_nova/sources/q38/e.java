package q38;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/larus/account/base/model/AgeGateReportResponse;", "", "pass", "", "reason", "", "<init>", "(ZI)V", "getPass", "()Z", "getReason", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    @SerializedName("pass")
    private final boolean pass;

    @SerializedName("forbidden_reason")
    private final int reason;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.pass == r101.pass) goto L12;
        return false;
    L12:
        if (this.reason == r101.reason) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.pass == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.reason;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "AgeGateReportResponse(pass=" + this.pass + ", reason=" + this.reason + ')';
    }

    public e() {
        this.pass = false;
        this.reason = 1;
    }

    public final boolean a() {
        return this.pass;
    }

    public final int b() {
        return this.reason;
    }
}
