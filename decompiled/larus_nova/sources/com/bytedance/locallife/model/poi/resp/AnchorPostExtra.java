package com.bytedance.locallife.model.poi.resp;

import com.bytedance.android.ec.slice.SliceInitService;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0002\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/AnchorPostExtra;", "Ljava/io/Serializable;", "isRecommend", "", "anchorContent", "", "(Ljava/lang/Boolean;Ljava/lang/String;)V", "getAnchorContent", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/locallife/model/poi/resp/AnchorPostExtra;", "equals", "other", "", "hashCode", "", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class AnchorPostExtra implements Serializable {

    @SerializedName("anchor_content")
    private final String anchorContent;

    @SerializedName(sz1.a.KEY_IS_RECOMMEND)
    private final Boolean isRecommend;

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorPostExtra() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AnchorPostExtra copy$default(AnchorPostExtra r100, Boolean r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.isRecommend;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.anchorContent;
    L9:
        return r100.copy(r101, r102);
    }

    public final Boolean component1() {
        return this.isRecommend;
    }

    public final String component2() {
        return this.anchorContent;
    }

    public final AnchorPostExtra copy(Boolean r100, String r101) {
        return new AnchorPostExtra(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AnchorPostExtra) == true) goto L8;
        return false;
    L8:
        AnchorPostExtra r101 = (AnchorPostExtra) r100;
        if (Intrinsics.areEqual(this.isRecommend, r101.isRecommend) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.anchorContent, r101.anchorContent) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.isRecommend;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.anchorContent;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "AnchorPostExtra(isRecommend=" + this.isRecommend + ", anchorContent=" + this.anchorContent + ')';
    }

    public final String getAnchorContent() {
        return this.anchorContent;
    }

    public final Boolean isRecommend() {
        return this.isRecommend;
    }

    public AnchorPostExtra(Boolean r100, String r101) {
        this.isRecommend = r100;
        this.anchorContent = r101;
    }

    public /* synthetic */ AnchorPostExtra(Boolean r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = Boolean.FALSE;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = SliceInitService.DEFAULT_SWITCH;
    L8:
        this(r100, r101);
    }
}
