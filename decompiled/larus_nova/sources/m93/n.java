package m93;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lm93/n;", "", "", "", "urlList", "Ljava/util/List;", "getUrlList", "()Ljava/util/List;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f512615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f512616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f512617c;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    private final List<String> urlList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L14;
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f512615a, r101.f512615a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.urlList, r101.urlList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f512616b, r101.f512616b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f512617c, r101.f512617c) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f512615a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.urlList;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f512616b;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f512617c;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "NewerCoverWhiteBg(uri=" + this.f512615a + ", urlList=" + this.urlList + ", width=" + this.f512616b + ", height=" + this.f512617c + ")";
    }

    public n() {
        this.f512615a = null;
        this.urlList = null;
        this.f512616b = null;
        this.f512617c = null;
    }
}
