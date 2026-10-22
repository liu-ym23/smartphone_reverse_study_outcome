package nn1;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lnn1/g;", "", "", "Lnn1/e;", "tagList", "Ljava/util/List;", "getTagList", "()Ljava/util/List;", "", "", "Lnn1/b;", "batchTags", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("batch_tags")
    private final Map<Long, b> batchTags;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    private final List<e> tagList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L10;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.tagList, r101.tagList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.batchTags, r101.batchTags) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<e> r100 = this.tagList;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<Long, b> r104 = this.batchTags;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RoomTagsResponseV4(tagList=" + this.tagList + ", batchTags=" + this.batchTags + ")";
    }

    public g() {
        ArrayList r100 = new ArrayList();
        LinkedHashMap r101 = new LinkedHashMap();
        this.tagList = r100;
        this.batchTags = r101;
    }

    public final Map<Long, b> a() {
        return this.batchTags;
    }
}
