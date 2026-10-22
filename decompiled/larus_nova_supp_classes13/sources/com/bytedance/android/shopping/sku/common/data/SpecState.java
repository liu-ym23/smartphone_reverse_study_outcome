package com.bytedance.android.shopping.sku.common.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/sku/common/data/SpecState;", "Ljava/io/Serializable;", "curShowMode", "", "selectedSpecItemId", "(Ljava/lang/String;Ljava/lang/String;)V", "getCurShowMode", "()Ljava/lang/String;", "getSelectedSpecItemId", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SpecState implements Serializable {

    @SerializedName("cur_show_mode")
    private final String curShowMode;

    @SerializedName("selected_spec_item_id")
    private final String selectedSpecItemId;

    public SpecState() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public final String getCurShowMode() {
        return this.curShowMode;
    }

    public final String getSelectedSpecItemId() {
        return this.selectedSpecItemId;
    }

    public SpecState(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "curShowMode");
        Intrinsics.checkNotNullParameter(r3, "selectedSpecItemId");
        this.curShowMode = r2;
        this.selectedSpecItemId = r3;
    }

    public /* synthetic */ SpecState(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = "";
    L8:
        this(r2, r3);
    }
}
