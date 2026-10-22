package m93;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lm93/q;", "", "urlList", "Ljava/lang/Object;", "getUrlList", "()Ljava/lang/Object;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f512618a;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    private final Object urlList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == false) goto L10;
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f512618a, r101.f512618a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.urlList, r101.urlList) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f512618a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Object r104 = this.urlList;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "NewerIcon2(uri=" + this.f512618a + ", urlList=" + this.urlList + ")";
    }

    public q() {
        this.f512618a = null;
        this.urlList = null;
    }
}
