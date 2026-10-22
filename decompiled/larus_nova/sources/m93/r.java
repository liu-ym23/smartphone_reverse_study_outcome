package m93;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lm93/r;", "", "", "urlList", "Ljava/util/List;", "getUrlList", "()Ljava/util/List;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f512619a;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    private final List<Object> urlList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == false) goto L10;
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f512619a, r101.f512619a) == true) goto L8;
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
        String r100 = this.f512619a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<Object> r104 = this.urlList;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "NewerIcon(uri=" + this.f512619a + ", urlList=" + this.urlList + ")";
    }

    public r() {
        this.f512619a = null;
        this.urlList = null;
    }
}
