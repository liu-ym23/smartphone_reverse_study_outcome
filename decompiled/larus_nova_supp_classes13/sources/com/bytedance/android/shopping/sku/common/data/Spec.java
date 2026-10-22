package com.bytedance.android.shopping.sku.common.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/sku/common/data/Spec;", "Ljava/io/Serializable;", "specIndex", "", "name", "specItemList", "", "Lcom/bytedance/android/shopping/sku/common/data/SpecItem;", "canShowBigPic", "", "canShowSmallPic", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCanShowBigPic", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCanShowSmallPic", "getName", "()Ljava/lang/String;", "getSpecIndex", "getSpecItemList", "()Ljava/util/List;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Spec implements Serializable {

    @SerializedName("can_show_big_pic")
    private final Boolean canShowBigPic;

    @SerializedName("can_show_small_pic")
    private final Boolean canShowSmallPic;

    @SerializedName("name")
    private final String name;

    @SerializedName("spec_index")
    private final String specIndex;

    @SerializedName("spec_item_list")
    private final List<SpecItem> specItemList;

    public Spec() {
        this(null, null, null, null, null, 31, null);
    }

    public final Boolean getCanShowBigPic() {
        return this.canShowBigPic;
    }

    public final Boolean getCanShowSmallPic() {
        return this.canShowSmallPic;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSpecIndex() {
        return this.specIndex;
    }

    public final List<SpecItem> getSpecItemList() {
        return this.specItemList;
    }

    public Spec(String r2, String r3, List<SpecItem> r4, Boolean r5, Boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "specIndex");
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "specItemList");
        this.specIndex = r2;
        this.name = r3;
        this.specItemList = r4;
        this.canShowBigPic = r5;
        this.canShowSmallPic = r6;
    }

    public /* synthetic */ Spec(String r4, String r5, List r6, Boolean r7, Boolean r8, int r9, DefaultConstructorMarker r10) {
        String r0 = "";
        if ((r9 & 1) == 0) goto L5;
        String r11 = "";
    L7:
        if ((r9 & 2) != 0) goto L11;
        r0 = r5;
    L11:
        if ((r9 & 4) == 0) goto L13;
        r6 = CollectionsKt.emptyList();
    L13:
        List r1 = r6;
        if ((r9 & 8) == 0) goto L16;
        Boolean r2 = null;
    L18:
        if ((r9 & 16) == 0) goto L20;
        Boolean r12 = null;
    L21:
        this(r11, r0, r1, r2, r12);
        return;
    L20:
        r12 = r8;
        goto L21
    L16:
        r2 = r7;
        goto L18
    L5:
        r11 = r4;
        goto L7
    }
}
