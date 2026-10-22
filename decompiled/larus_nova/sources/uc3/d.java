package uc3;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Luc3/d;", "", "Luc3/b;", "bizIdentity", "Luc3/b;", "getBizIdentity", "()Luc3/b;", "", "Luc3/e;", "feedList", "Ljava/util/List;", "getFeedList", "()Ljava/util/List;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("biz_identity")
    private final b bizIdentity;

    @SerializedName("feed")
    private final List<e> feedList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.bizIdentity, r101.bizIdentity) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.feedList, r101.feedList) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        b r100 = this.bizIdentity;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<e> r104 = this.feedList;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DeepFeedImpressionRequestData(bizIdentity=" + this.bizIdentity + ", feedList=" + this.feedList + ")";
    }

    public d() {
        this(new b(null, null), new ArrayList());
    }

    public d(b r100, List<e> r101) {
        this.bizIdentity = r100;
        this.feedList = r101;
    }
}
