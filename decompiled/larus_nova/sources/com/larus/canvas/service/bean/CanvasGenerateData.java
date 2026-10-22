package com.larus.canvas.service.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.message.ImageObj;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003JK\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/canvas/service/bean/CanvasGenerateData;", "Ljava/io/Serializable;", "genePrompt", "", "modelName", "refImages", "", "Lcom/larus/im/bean/message/ImageObj;", "imageOriRaw", "imageTargetRaw", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasGenerateData implements Serializable {

    @SerializedName("gene_prompt")
    public final String genePrompt;

    @SerializedName("image_ori_raw")
    public final ImageObj imageOriRaw;

    @SerializedName("image_target_raw")
    public final ImageObj imageTargetRaw;

    @SerializedName("model_name")
    public final String modelName;

    @SerializedName("ref_images")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public final List<ImageObj> refImages;

    public CanvasGenerateData() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CanvasGenerateData copy$default(CanvasGenerateData r100, String r101, String r102, List r103, ImageObj r104, ImageObj r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.genePrompt;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.modelName;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.refImages;
    L11:
        List r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.imageOriRaw;
    L14:
        ImageObj r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.imageTargetRaw;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.genePrompt;
    }

    public final String component2() {
        return this.modelName;
    }

    public final List<ImageObj> component3() {
        return this.refImages;
    }

    public final ImageObj component4() {
        return this.imageOriRaw;
    }

    public final ImageObj component5() {
        return this.imageTargetRaw;
    }

    public final CanvasGenerateData copy(String r100, String r101, List<ImageObj> r110, ImageObj r111, ImageObj r112) {
        return new CanvasGenerateData(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CanvasGenerateData) == true) goto L8;
        return false;
    L8:
        CanvasGenerateData r101 = (CanvasGenerateData) r100;
        if (Intrinsics.areEqual(this.genePrompt, r101.genePrompt) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.modelName, r101.modelName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.refImages, r101.refImages) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageOriRaw, r101.imageOriRaw) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.imageTargetRaw, r101.imageTargetRaw) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.genePrompt;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.modelName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<ImageObj> r107 = this.refImages;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        ImageObj r110 = this.imageOriRaw;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        ImageObj r113 = this.imageTargetRaw;
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

    public String toString() {
        return "CanvasGenerateData(genePrompt=" + this.genePrompt + ", modelName=" + this.modelName + ", refImages=" + this.refImages + ", imageOriRaw=" + this.imageOriRaw + ", imageTargetRaw=" + this.imageTargetRaw + ')';
    }

    public CanvasGenerateData(String r100, String r101, List<ImageObj> r102, ImageObj r103, ImageObj r104) {
        this.genePrompt = r100;
        this.modelName = r101;
        this.refImages = r102;
        this.imageOriRaw = r103;
        this.imageTargetRaw = r104;
    }

    public /* synthetic */ CanvasGenerateData(String r100, String r101, List r102, ImageObj r103, ImageObj r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        List r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        ImageObj r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        ImageObj r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
