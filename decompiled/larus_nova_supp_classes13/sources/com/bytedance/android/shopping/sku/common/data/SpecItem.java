package com.bytedance.android.shopping.sku.common.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/sku/common/data/SpecItem;", "Ljava/io/Serializable;", "name", "", "specItemId", "bigPic", "smallPic", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBigPic", "()Ljava/lang/String;", "getName", "getSmallPic", "getSpecItemId", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SpecItem implements Serializable {

    @SerializedName("big_pic")
    private final String bigPic;

    @SerializedName("name")
    private final String name;

    @SerializedName("small_pic")
    private final String smallPic;

    @SerializedName("spec_item_id")
    private final String specItemId;

    public SpecItem() {
        this(null, null, null, null, 15, null);
    }

    public final String getBigPic() {
        return this.bigPic;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSmallPic() {
        return this.smallPic;
    }

    public final String getSpecItemId() {
        return this.specItemId;
    }

    public SpecItem(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "specItemId");
        Intrinsics.checkNotNullParameter(r4, "bigPic");
        Intrinsics.checkNotNullParameter(r5, "smallPic");
        this.name = r2;
        this.specItemId = r3;
        this.bigPic = r4;
        this.smallPic = r5;
    }

    public /* synthetic */ SpecItem(String r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = "";
    L14:
        this(r2, r3, r4, r5);
    }
}
