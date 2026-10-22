package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R(\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/e0;", "", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/x;", "content", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "Lcom/bytedance/locallife/live/goodsshelves/bean/t;", "icon", "Lcom/bytedance/locallife/live/goodsshelves/bean/t;", "b", "()Lcom/bytedance/locallife/live/goodsshelves/bean/t;", "", "lineNum", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "", "", "trackingParams", "Ljava/util/Map;", "getTrackingParams", "()Ljava/util/Map;", "extra", "getExtra", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class e0 {

    @SerializedName("content")
    private final List<x> content;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("icon")
    private final t icon;

    @SerializedName("line_num")
    private final Integer lineNum;

    @SerializedName("tracking_params")
    private final Map<String, String> trackingParams;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r101 = (e0) r100;
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lineNum, r101.lineNum) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.trackingParams, r101.trackingParams) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        List<x> r100 = this.content;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        t r104 = this.icon;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.lineNum;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.trackingParams;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, String> r113 = this.extra;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LiveLifeBFFCardTitleInfo(content=" + this.content + ", icon=" + this.icon + ", lineNum=" + this.lineNum + ", trackingParams=" + this.trackingParams + ", extra=" + this.extra + ')';
    }

    public final List<x> a() {
        return this.content;
    }

    public final t b() {
        return this.icon;
    }

    public final Integer c() {
        return this.lineNum;
    }
}
