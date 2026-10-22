package hq9;

import com.byted.cast.common.CommonOptionConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/larus/platform/model/LarkSocialBlockConfig;", "", "blockTypeList", "", "", "<init>", "(Ljava/util/List;)V", "getBlockTypeList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k2 {

    @SerializedName("block_type_list")
    private final List<Integer> blockTypeList;

    public k2() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k2) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.blockTypeList, ((k2) r100).blockTypeList) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        List<Integer> r100 = this.blockTypeList;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "LarkSocialBlockConfig(blockTypeList=" + this.blockTypeList + ')';
    }

    public final List<Integer> a() {
        return this.blockTypeList;
    }

    public k2(Object r100) {
        this.blockTypeList = CollectionsKt.listOf(new Integer[]{10000, 10008, 10009, 10050, 2074, 10006, 10017, 10010, 10011, 10012, 10013, 10014, 10024, Integer.valueOf(CommonOptionConstants.OPTION_SET_SINK_DATA_LISTENER_AUDIO), 10026, 10027, 10051, 10053, Integer.valueOf(CommonOptionConstants.OPTION_SEND_DRAMA_INFO), 10055, 10056, 10058, 10071, 10103, 10069, 10501});
    }
}
