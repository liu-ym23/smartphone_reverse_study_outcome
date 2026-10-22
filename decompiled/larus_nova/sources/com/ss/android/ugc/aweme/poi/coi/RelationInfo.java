package com.ss.android.ugc.aweme.poi.coi;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\tJ\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003JW\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/coi/RelationInfo;", "Ljava/io/Serializable;", "socialRelations", "", "", "rankDesc", "recommendRelations", "pubRelations", "relation", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getPubRelations", "()Ljava/util/List;", "getRankDesc", "()Ljava/lang/String;", "getRecommendRelations", "getRelation", "getSocialRelations", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class RelationInfo implements Serializable {

    @SerializedName("pub_opinions")
    private final List<String> pubRelations;

    @SerializedName("rank_desc")
    private final String rankDesc;

    @SerializedName("recomm_reasons")
    private final List<String> recommendRelations;

    @SerializedName("relation")
    private final String relation;

    @SerializedName("social_relations")
    private final List<String> socialRelations;

    public RelationInfo() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RelationInfo copy$default(RelationInfo r100, List r101, String r102, List r103, List r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.socialRelations;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.rankDesc;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.recommendRelations;
    L11:
        List r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.pubRelations;
    L14:
        List r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.relation;
    L17:
        List r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final List<String> component1() {
        return this.socialRelations;
    }

    public final String component2() {
        return this.rankDesc;
    }

    public final List<String> component3() {
        return this.recommendRelations;
    }

    public final List<String> component4() {
        return this.pubRelations;
    }

    public final String component5() {
        return this.relation;
    }

    public final RelationInfo copy(List<String> r100, String r101, List<String> r110, List<String> r111, String r112) {
        return new RelationInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RelationInfo) == true) goto L8;
        return false;
    L8:
        RelationInfo r101 = (RelationInfo) r100;
        if (Intrinsics.areEqual(this.socialRelations, r101.socialRelations) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rankDesc, r101.rankDesc) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.recommendRelations, r101.recommendRelations) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pubRelations, r101.pubRelations) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.relation, r101.relation) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        List<String> r100 = this.socialRelations;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.rankDesc;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.recommendRelations;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.pubRelations;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.relation;
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
        return "RelationInfo(socialRelations=" + this.socialRelations + ", rankDesc=" + this.rankDesc + ", recommendRelations=" + this.recommendRelations + ", pubRelations=" + this.pubRelations + ", relation=" + this.relation + ')';
    }

    public final List<String> getPubRelations() {
        return this.pubRelations;
    }

    public final String getRankDesc() {
        return this.rankDesc;
    }

    public final List<String> getRecommendRelations() {
        return this.recommendRelations;
    }

    public final String getRelation() {
        return this.relation;
    }

    public final List<String> getSocialRelations() {
        return this.socialRelations;
    }

    public RelationInfo(List<String> r100, String r101, List<String> r102, List<String> r103, String r104) {
        this.socialRelations = r100;
        this.rankDesc = r101;
        this.recommendRelations = r102;
        this.pubRelations = r103;
        this.relation = r104;
    }

    public /* synthetic */ RelationInfo(List r100, String r101, List r102, List r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        List r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        List r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        List r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
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
