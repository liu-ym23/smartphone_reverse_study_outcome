package com.bytedance.locallife.photo.album.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R*\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/locallife/photo/album/model/m;", "", "Ltv6/b;", "Lcom/bytedance/locallife/photo/album/model/LynxInfo;", "bottomBar", "Ltv6/b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ltv6/b;", "setBottomBar", "(Ltv6/b;)V", "", "Lcom/bytedance/locallife/photo/album/model/n;", "rightMoreItems", "Ljava/util/List;", "b", "()Ljava/util/List;", "setRightMoreItems", "(Ljava/util/List;)V", "locallife-photo-api_release"}, k = 1, mv = {1, 4, 3})
public final class m {

    @SerializedName("bottom_bar")
    private tv6.b bottomBar;

    @SerializedName("right_more_items")
    private List<n> rightMoreItems;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.bottomBar, r101.bottomBar) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rightMoreItems, r101.rightMoreItems) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        tv6.b r100 = this.bottomBar;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<n> r104 = this.rightMoreItems;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BottomAndHeadInfo(bottomBar=" + this.bottomBar + ", rightMoreItems=" + this.rightMoreItems + ')';
    }

    public m() {
        this.bottomBar = null;
        this.rightMoreItems = null;
    }

    public final tv6.b a() {
        return this.bottomBar;
    }

    public final List<n> b() {
        return this.rightMoreItems;
    }
}
