package com.bytedance.locallife.live.userinfo.model;

import com.bytedance.locallife.live.goodsshelves.bean.p;
import com.bytedance.locallife.live.goodsshelves.bean.t;
import com.bytedance.locallife.live.goodsshelves.bean.x;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R(\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/locallife/live/userinfo/model/a;", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/t;", "avatar", "Lcom/bytedance/locallife/live/goodsshelves/bean/t;", "getAvatar", "()Lcom/bytedance/locallife/live/goodsshelves/bean/t;", "Lcom/bytedance/locallife/live/goodsshelves/bean/x;", "name", "Lcom/bytedance/locallife/live/goodsshelves/bean/x;", "getName", "()Lcom/bytedance/locallife/live/goodsshelves/bean/x;", "additionalInfo", "getAdditionalInfo", "officialCert", "getOfficialCert", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/p;", "labelList", "Ljava/util/List;", "getLabelList", "()Ljava/util/List;", "", "", "trackParams", "Ljava/util/Map;", "getTrackParams", "()Ljava/util/Map;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("additional_info")
    private final x additionalInfo;

    @SerializedName("avatar")
    private final t avatar;

    @SerializedName("label_list")
    private final List<p> labelList;

    @SerializedName("name")
    private final x name;

    @SerializedName("official_cert")
    private final t officialCert;

    @SerializedName("track_params")
    private final Map<String, String> trackParams;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.avatar, r101.avatar) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.additionalInfo, r101.additionalInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.officialCert, r101.officialCert) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.labelList, r101.labelList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        t r100 = this.avatar;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        x r104 = this.name;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        x r107 = this.additionalInfo;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        t r110 = this.officialCert;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<p> r113 = this.labelList;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, String> r116 = this.trackParams;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
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
        return "LifeLiveHeaderInfo(avatar=" + this.avatar + ", name=" + this.name + ", additionalInfo=" + this.additionalInfo + ", officialCert=" + this.officialCert + ", labelList=" + this.labelList + ", trackParams=" + this.trackParams + ')';
    }
}
