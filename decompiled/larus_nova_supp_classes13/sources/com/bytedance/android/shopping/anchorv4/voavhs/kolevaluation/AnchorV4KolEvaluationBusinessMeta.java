package com.bytedance.android.shopping.anchorv4.voavhs.kolevaluation;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u0013\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0013\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u0016\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationBusinessMeta;", "Ljava/io/Serializable;", "kolAuthorIdList", "", "", "kolAwemeIdList", "kolVideoListSchema", "kolVideoPlaySchema", "kolElementTypeList", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getKolAuthorIdList", "()Ljava/util/List;", "getKolAwemeIdList", "getKolElementTypeList", "getKolVideoListSchema", "()Ljava/lang/String;", "getKolVideoPlaySchema", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4KolEvaluationBusinessMeta implements Serializable {

    @SerializedName("kol_author_id_list")
    private final List<String> kolAuthorIdList;

    @SerializedName("kol_aweme_id_list")
    private final List<String> kolAwemeIdList;

    @SerializedName("kol_element_type_list")
    private final List<String> kolElementTypeList;

    @SerializedName("kol_video_list_schema")
    private final String kolVideoListSchema;

    @SerializedName("kol_video_play_schema")
    private final String kolVideoPlaySchema;

    public AnchorV4KolEvaluationBusinessMeta() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4KolEvaluationBusinessMeta copy$default(AnchorV4KolEvaluationBusinessMeta r3, List r4, List r5, String r6, String r7, List r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.kolAuthorIdList;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.kolAwemeIdList;
    L8:
        List r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.kolVideoListSchema;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.kolVideoPlaySchema;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.kolElementTypeList;
    L17:
        List r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final List<String> component1() {
        return this.kolAuthorIdList;
    }

    public final List<String> component2() {
        return this.kolAwemeIdList;
    }

    public final String component3() {
        return this.kolVideoListSchema;
    }

    public final String component4() {
        return this.kolVideoPlaySchema;
    }

    public final List<String> component5() {
        return this.kolElementTypeList;
    }

    public final AnchorV4KolEvaluationBusinessMeta copy(List<String> r8, List<String> r9, String r10, String r11, List<String> r12) {
        return new AnchorV4KolEvaluationBusinessMeta(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AnchorV4KolEvaluationBusinessMeta) == false) goto L16;
        AnchorV4KolEvaluationBusinessMeta r4 = (AnchorV4KolEvaluationBusinessMeta) r3;
        if (Intrinsics.areEqual(this.kolAuthorIdList, r4.kolAuthorIdList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.kolAwemeIdList, r4.kolAwemeIdList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.kolVideoListSchema, r4.kolVideoListSchema) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.kolVideoPlaySchema, r4.kolVideoPlaySchema) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.kolElementTypeList, r4.kolElementTypeList) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        List<String> r0 = this.kolAuthorIdList;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.kolAwemeIdList;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.kolVideoListSchema;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.kolVideoPlaySchema;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        List<String> r13 = this.kolElementTypeList;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorV4KolEvaluationBusinessMeta(kolAuthorIdList=" + this.kolAuthorIdList + ", kolAwemeIdList=" + this.kolAwemeIdList + ", kolVideoListSchema=" + this.kolVideoListSchema + ", kolVideoPlaySchema=" + this.kolVideoPlaySchema + ", kolElementTypeList=" + this.kolElementTypeList + ")";
    }

    public final List<String> getKolAuthorIdList() {
        return this.kolAuthorIdList;
    }

    public final List<String> getKolAwemeIdList() {
        return this.kolAwemeIdList;
    }

    public final List<String> getKolElementTypeList() {
        return this.kolElementTypeList;
    }

    public final String getKolVideoListSchema() {
        return this.kolVideoListSchema;
    }

    public final String getKolVideoPlaySchema() {
        return this.kolVideoPlaySchema;
    }

    public AnchorV4KolEvaluationBusinessMeta(List<String> r1, List<String> r2, String r3, String r4, List<String> r5) {
        this.kolAuthorIdList = r1;
        this.kolAwemeIdList = r2;
        this.kolVideoListSchema = r3;
        this.kolVideoPlaySchema = r4;
        this.kolElementTypeList = r5;
    }

    public /* synthetic */ AnchorV4KolEvaluationBusinessMeta(List r5, List r6, String r7, String r8, List r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        List r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        List r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        List r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
