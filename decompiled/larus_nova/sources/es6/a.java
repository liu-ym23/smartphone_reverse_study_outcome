package es6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u0011"}, d2 = {"Les6/a;", "", "", "", "coverList", "Ljava/util/List;", "getCoverList", "()Ljava/util/List;", "", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "Ljava/lang/Long;", "getExpireTime", "()Ljava/lang/Long;", "", "isFirst", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName(ScoreTags.STAR_URL_LIST)
    private final List<String> coverList;

    @SerializedName("expire_time")
    private final Long expireTime;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST)
    private final Integer isFirst;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.coverList, r101.coverList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.expireTime, r101.expireTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isFirst, r101.isFirst) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.coverList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.expireTime;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.isFirst;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "GuessLikeCoverPreloadData(coverList=" + this.coverList + ", expireTime=" + this.expireTime + ", isFirst=" + this.isFirst + ')';
    }

    public a() {
        this.coverList = null;
        this.expireTime = null;
        this.isFirst = null;
    }
}
