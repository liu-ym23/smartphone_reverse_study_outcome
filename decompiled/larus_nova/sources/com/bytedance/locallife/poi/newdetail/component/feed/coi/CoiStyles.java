package com.bytedance.locallife.poi.newdetail.component.feed.coi;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/component/feed/coi/CoiStyles;", "Ljava/io/Serializable;", "styles", "", "Lcom/bytedance/locallife/poi/newdetail/component/feed/coi/CoiDoubleUICell;", "(Ljava/util/List;)V", "getStyles", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CoiStyles implements Serializable {

    @SerializedName("coi_item_styles")
    private final List<CoiDoubleUICell> styles;

    /* JADX WARN: Multi-variable type inference failed */
    public CoiStyles() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CoiStyles copy$default(CoiStyles r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.styles;
    L6:
        return r100.copy(r101);
    }

    public final List<CoiDoubleUICell> component1() {
        return this.styles;
    }

    public final CoiStyles copy(List<CoiDoubleUICell> r100) {
        return new CoiStyles(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CoiStyles) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.styles, ((CoiStyles) r100).styles) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<CoiDoubleUICell> r100 = this.styles;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "CoiStyles(styles=" + this.styles + ')';
    }

    public final List<CoiDoubleUICell> getStyles() {
        return this.styles;
    }

    public CoiStyles(List<CoiDoubleUICell> r100) {
        this.styles = r100;
    }

    public /* synthetic */ CoiStyles(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
