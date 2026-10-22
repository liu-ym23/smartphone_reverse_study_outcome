package com.bytedance.locallife.photo.album.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/photo/album/model/l;", "", "Lcom/bytedance/locallife/photo/album/model/m;", "bottomAndHeadInfo", "Lcom/bytedance/locallife/photo/album/model/m;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/locallife/photo/album/model/m;", "setBottomAndHeadInfo", "(Lcom/bytedance/locallife/photo/album/model/m;)V", "locallife-photo-api_release"}, k = 1, mv = {1, 4, 3})
public final class l {

    @SerializedName("bottom_and_head_co")
    private m bottomAndHeadInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.bottomAndHeadInfo, ((l) r100).bottomAndHeadInfo) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        m r100 = this.bottomAndHeadInfo;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "BottomAndHeadCO(bottomAndHeadInfo=" + this.bottomAndHeadInfo + ')';
    }

    public l() {
        this.bottomAndHeadInfo = null;
    }

    public final m a() {
        return this.bottomAndHeadInfo;
    }
}
