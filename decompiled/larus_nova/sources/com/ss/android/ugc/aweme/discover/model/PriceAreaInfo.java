package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.ec.search.common.UrlModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/PriceAreaInfo;", "Ljava/io/Serializable;", "backgroundImage", "Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "icon", "(Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;)V", "getBackgroundImage", "()Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "setBackgroundImage", "(Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;)V", "getIcon", "setIcon", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PriceAreaInfo implements Serializable {

    @SerializedName("background_image")
    private UrlModel backgroundImage;

    @SerializedName("icon")
    private UrlModel icon;

    /* JADX WARN: Multi-variable type inference failed */
    public PriceAreaInfo() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PriceAreaInfo copy$default(PriceAreaInfo r100, UrlModel r101, UrlModel r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.backgroundImage;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.icon;
    L9:
        return r100.copy(r101, r102);
    }

    public final UrlModel component1() {
        return this.backgroundImage;
    }

    public final UrlModel component2() {
        return this.icon;
    }

    public final PriceAreaInfo copy(UrlModel r100, UrlModel r101) {
        return new PriceAreaInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PriceAreaInfo) == false) goto L10;
        PriceAreaInfo r101 = (PriceAreaInfo) r100;
        if (Intrinsics.areEqual(this.backgroundImage, r101.backgroundImage) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        UrlModel r100 = this.backgroundImage;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        UrlModel r104 = this.icon;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PriceAreaInfo(backgroundImage=" + this.backgroundImage + ", icon=" + this.icon + ")";
    }

    public final UrlModel getBackgroundImage() {
        return this.backgroundImage;
    }

    public final UrlModel getIcon() {
        return this.icon;
    }

    public final void setBackgroundImage(UrlModel r100) {
        this.backgroundImage = r100;
    }

    public final void setIcon(UrlModel r100) {
        this.icon = r100;
    }

    public PriceAreaInfo(UrlModel r100, UrlModel r101) {
        this.backgroundImage = r100;
        this.icon = r101;
    }

    public /* synthetic */ PriceAreaInfo(UrlModel r100, UrlModel r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
