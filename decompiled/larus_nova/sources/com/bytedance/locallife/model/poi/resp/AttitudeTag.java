package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB)\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J+\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\f\u001a\u00020\u0004HÖ\u0001J\t\u0010\r\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003R\u001a\u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/AttitudeTag;", "Ljava/io/Serializable;", "", "component1", "", "component2", "Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "component3", "contentAttitudeType", "attitudeText", "imageUrl", "copy", "toString", "hashCode", "", "other", "", "equals", "I", "getContentAttitudeType", "()I", "Ljava/lang/String;", "getAttitudeText", "()Ljava/lang/String;", "Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "getImageUrl", "()Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "<init>", "(ILjava/lang/String;Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class AttitudeTag implements Serializable {
    public static final a Companion = null;
    public static final long serialVersionUID = 1;

    @SerializedName("attitude_text")
    private final String attitudeText;

    @SerializedName("content_attitude_type")
    private final int contentAttitudeType;

    @SerializedName("image_url")
    private final PoiImageUrlModel imageUrl;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public AttitudeTag() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ AttitudeTag copy$default(AttitudeTag r100, int r101, String r102, PoiImageUrlModel r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.contentAttitudeType;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.attitudeText;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.imageUrl;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.contentAttitudeType;
    }

    public final String component2() {
        return this.attitudeText;
    }

    public final PoiImageUrlModel component3() {
        return this.imageUrl;
    }

    public final AttitudeTag copy(int r100, String r101, PoiImageUrlModel r102) {
        return new AttitudeTag(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AttitudeTag) == true) goto L8;
        return false;
    L8:
        AttitudeTag r101 = (AttitudeTag) r100;
        if (this.contentAttitudeType == r101.contentAttitudeType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.attitudeText, r101.attitudeText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageUrl, r101.imageUrl) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.contentAttitudeType * 31;
        String r101 = this.attitudeText;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        PoiImageUrlModel r105 = this.imageUrl;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "AttitudeTag(contentAttitudeType=" + this.contentAttitudeType + ", attitudeText=" + this.attitudeText + ", imageUrl=" + this.imageUrl + ')';
    }

    public final String getAttitudeText() {
        return this.attitudeText;
    }

    public final int getContentAttitudeType() {
        return this.contentAttitudeType;
    }

    public final PoiImageUrlModel getImageUrl() {
        return this.imageUrl;
    }

    public AttitudeTag(int r100, String r101, PoiImageUrlModel r102) {
        this.contentAttitudeType = r100;
        this.attitudeText = r101;
        this.imageUrl = r102;
    }

    public /* synthetic */ AttitudeTag(int r100, String r101, PoiImageUrlModel r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
