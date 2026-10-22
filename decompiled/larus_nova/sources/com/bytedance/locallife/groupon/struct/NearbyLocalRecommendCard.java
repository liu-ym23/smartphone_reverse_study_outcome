package com.bytedance.locallife.groupon.struct;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/NearbyLocalRecommendCard;", "Ljava/io/Serializable;", "title", "", "subTitle", "locationIndex", "", "candidateList", "", "Lcom/bytedance/locallife/groupon/struct/NearbyLocalCandidate;", "(Ljava/lang/String;Ljava/lang/String;JLjava/util/List;)V", "getCandidateList", "()Ljava/util/List;", "getLocationIndex", "()J", "getSubTitle", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class NearbyLocalRecommendCard implements Serializable {

    @SerializedName("candidate_list")
    private final List<NearbyLocalCandidate> candidateList;

    @SerializedName("location_index")
    private final long locationIndex;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    private final String subTitle;

    @SerializedName("title")
    private final String title;

    public NearbyLocalRecommendCard() {
        this(null, null, 0, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NearbyLocalRecommendCard copy$default(NearbyLocalRecommendCard r100, String r101, String r102, long r103, List r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.title;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.subTitle;
    L8:
        String r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.locationIndex;
    L11:
        long r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.candidateList;
    L14:
        String r107 = r101;
        return r100.copy(r107, r111, r106, r104);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.subTitle;
    }

    public final long component3() {
        return this.locationIndex;
    }

    public final List<NearbyLocalCandidate> component4() {
        return this.candidateList;
    }

    public final NearbyLocalRecommendCard copy(String r100, String r101, long r110, List<NearbyLocalCandidate> r111) {
        return new NearbyLocalRecommendCard(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NearbyLocalRecommendCard) == true) goto L8;
        return false;
    L8:
        NearbyLocalRecommendCard r101 = (NearbyLocalRecommendCard) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.subTitle, r101.subTitle) == true) goto L15;
        return false;
    L15:
        if (this.locationIndex == r101.locationIndex) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.candidateList, r101.candidateList) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.subTitle;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.locationIndex;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        List<NearbyLocalCandidate> r109 = this.candidateList;
        if (r109 == null) goto L15;
        r101 = r109.hashCode();
    L15:
        return r108 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "NearbyLocalRecommendCard(title=" + this.title + ", subTitle=" + this.subTitle + ", locationIndex=" + this.locationIndex + ", candidateList=" + this.candidateList + ')';
    }

    public final List<NearbyLocalCandidate> getCandidateList() {
        return this.candidateList;
    }

    public final long getLocationIndex() {
        return this.locationIndex;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public NearbyLocalRecommendCard(String r100, String r101, long r102, List<NearbyLocalCandidate> r103) {
        this.title = r100;
        this.subTitle = r101;
        this.locationIndex = r102;
        this.candidateList = r103;
    }

    public /* synthetic */ NearbyLocalRecommendCard(String r100, String r101, long r102, List r103, int r104, DefaultConstructorMarker r110) {
        String r105 = "";
        if ((r104 & 1) == 0) goto L5;
        String r111 = "";
    L7:
        if ((r104 & 2) != 0) goto L11;
        r105 = r101;
    L11:
        if ((r104 & 4) == 0) goto L13;
        r102 = 0;
    L13:
        long r106 = r102;
        if ((r104 & 8) == 0) goto L16;
        r103 = new ArrayList();
    L16:
        String r107 = r111;
        String r108 = r105;
        this(r107, r108, r106, r103);
        return;
    L5:
        r111 = r100;
        goto L7
    }
}
