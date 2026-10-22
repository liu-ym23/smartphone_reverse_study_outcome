package com.larus.canvas.service.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/larus/canvas/service/bean/PresetRefImage;", "", "imageThumb", "Lcom/larus/canvas/service/bean/Icon;", "imageOri", "<init>", "(Lcom/larus/canvas/service/bean/Icon;Lcom/larus/canvas/service/bean/Icon;)V", "getImageThumb", "()Lcom/larus/canvas/service/bean/Icon;", "getImageOri", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PresetRefImage {

    @SerializedName("image_ori")
    private final Icon imageOri;

    @SerializedName("image_thumb")
    private final Icon imageThumb;

    /* JADX WARN: Multi-variable type inference failed */
    public PresetRefImage() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PresetRefImage copy$default(PresetRefImage r100, Icon r101, Icon r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.imageThumb;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.imageOri;
    L9:
        return r100.copy(r101, r102);
    }

    public final Icon component1() {
        return this.imageThumb;
    }

    public final Icon component2() {
        return this.imageOri;
    }

    public final PresetRefImage copy(Icon r100, Icon r101) {
        return new PresetRefImage(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PresetRefImage) == true) goto L8;
        return false;
    L8:
        PresetRefImage r101 = (PresetRefImage) r100;
        if (Intrinsics.areEqual(this.imageThumb, r101.imageThumb) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageOri, r101.imageOri) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Icon r100 = this.imageThumb;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Icon r104 = this.imageOri;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PresetRefImage(imageThumb=" + this.imageThumb + ", imageOri=" + this.imageOri + ')';
    }

    public final Icon getImageOri() {
        return this.imageOri;
    }

    public final Icon getImageThumb() {
        return this.imageThumb;
    }

    public PresetRefImage(Icon r100, Icon r101) {
        this.imageThumb = r100;
        this.imageOri = r101;
    }

    public /* synthetic */ PresetRefImage(Icon r100, Icon r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
