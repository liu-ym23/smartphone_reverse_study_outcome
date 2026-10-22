package com.larus.avlink.record.page;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/avlink/record/page/ListRecordingRequest;", "", "asc", "", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "", "<init>", "(ZI)V", "getAsc", "()Z", "getLimit", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: asc, reason: collision with root package name */
    @SerializedName("asc")
    private final boolean f294219asc;

    @SerializedName(VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT)
    private final int limit;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f294219asc == r101.f294219asc) goto L12;
        return false;
    L12:
        if (this.limit == r101.limit) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f294219asc == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.limit;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "ListRecordingRequest(asc=" + this.f294219asc + ", limit=" + this.limit + ')';
    }

    public d() {
        this(false, 1000);
    }

    public d(boolean r100, int r101) {
        this.f294219asc = r100;
        this.limit = r101;
    }
}
