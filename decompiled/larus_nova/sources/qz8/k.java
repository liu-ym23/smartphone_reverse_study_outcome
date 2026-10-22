package qz8;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/larus/commercecredit/impl/entity/CreditTip;", "", "isFirstVisit", "", "actualTip", "Lcom/larus/commercecredit/impl/entity/CreditActualTip;", "<init>", "(ZLcom/larus/commercecredit/impl/entity/CreditActualTip;)V", "()Z", "getActualTip", "()Lcom/larus/commercecredit/impl/entity/CreditActualTip;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k {

    @SerializedName(AppConstants.BUNDLE_TIP)
    private final e actualTip;

    @SerializedName("is_first_visit")
    private final boolean isFirstVisit;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.isFirstVisit == r101.isFirstVisit) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actualTip, r101.actualTip) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.isFirstVisit == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        e r102 = this.actualTip;
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
        return "CreditTip(isFirstVisit=" + this.isFirstVisit + ", actualTip=" + this.actualTip + ')';
    }

    public k() {
        this.isFirstVisit = true;
        this.actualTip = null;
    }

    public final e a() {
        return this.actualTip;
    }

    public final boolean b() {
        return this.isFirstVisit;
    }
}
