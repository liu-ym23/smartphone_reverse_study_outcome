package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/d0;", "", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/x;", "content", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class d0 {

    @SerializedName("content")
    private final List<x> content;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.content, ((d0) r100).content) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        List<x> r100 = this.content;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "LiveLifeBFFCardSoldCount(content=" + this.content + ')';
    }

    public final List<x> a() {
        return this.content;
    }
}
