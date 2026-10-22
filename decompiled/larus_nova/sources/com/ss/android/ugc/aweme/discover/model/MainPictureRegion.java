package com.ss.android.ugc.aweme.discover.model;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J8\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/MainPictureRegion;", "Ljava/io/Serializable;", "onlyServerIcon", "", "mainPictureLabels", "", "Lcom/ss/android/ugc/aweme/discover/model/TagLabel;", "labelAnimation", "Lcom/ss/android/ugc/aweme/discover/model/LabelAnimation;", "(Ljava/lang/Integer;Ljava/util/List;Lcom/ss/android/ugc/aweme/discover/model/LabelAnimation;)V", "getLabelAnimation", "()Lcom/ss/android/ugc/aweme/discover/model/LabelAnimation;", "getMainPictureLabels", "()Ljava/util/List;", "getOnlyServerIcon", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/util/List;Lcom/ss/android/ugc/aweme/discover/model/LabelAnimation;)Lcom/ss/android/ugc/aweme/discover/model/MainPictureRegion;", "equals", "", "other", "", "hashCode", "toString", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MainPictureRegion implements Serializable {

    @SerializedName(GXTemplateKey.GAIAX_ANIMATION)
    private final LabelAnimation labelAnimation;

    @SerializedName("icon_tag_element_list")
    private final List<TagLabel> mainPictureLabels;

    @SerializedName("only_server_icon")
    private final Integer onlyServerIcon;

    public MainPictureRegion() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MainPictureRegion copy$default(MainPictureRegion r100, Integer r101, List r102, LabelAnimation r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.onlyServerIcon;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.mainPictureLabels;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.labelAnimation;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Integer component1() {
        return this.onlyServerIcon;
    }

    public final List<TagLabel> component2() {
        return this.mainPictureLabels;
    }

    public final LabelAnimation component3() {
        return this.labelAnimation;
    }

    public final MainPictureRegion copy(Integer r100, List<TagLabel> r101, LabelAnimation r102) {
        return new MainPictureRegion(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MainPictureRegion) == false) goto L12;
        MainPictureRegion r101 = (MainPictureRegion) r100;
        if (Intrinsics.areEqual(this.onlyServerIcon, r101.onlyServerIcon) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.mainPictureLabels, r101.mainPictureLabels) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.labelAnimation, r101.labelAnimation) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.onlyServerIcon;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<TagLabel> r104 = this.mainPictureLabels;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        LabelAnimation r107 = this.labelAnimation;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "MainPictureRegion(onlyServerIcon=" + this.onlyServerIcon + ", mainPictureLabels=" + this.mainPictureLabels + ", labelAnimation=" + this.labelAnimation + ")";
    }

    public final LabelAnimation getLabelAnimation() {
        return this.labelAnimation;
    }

    public final List<TagLabel> getMainPictureLabels() {
        return this.mainPictureLabels;
    }

    public final Integer getOnlyServerIcon() {
        return this.onlyServerIcon;
    }

    public MainPictureRegion(Integer r100, List<TagLabel> r101, LabelAnimation r102) {
        this.onlyServerIcon = r100;
        this.mainPictureLabels = r101;
        this.labelAnimation = r102;
    }

    public /* synthetic */ MainPictureRegion(Integer r100, List r101, LabelAnimation r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
