package com.ss.android.ugc.aweme.poi.ugc.vh;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0001*BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0006HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000e¨\u0006+"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/ugc/vh/NpsLogParams;", "Ljava/io/Serializable;", "commentMode", "", "pageName", "commentCnt", "", "validCommentCnt", "poiEvaluateScore", "moduleAfterComment", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getCommentCnt", "()Ljava/lang/Integer;", "setCommentCnt", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCommentMode", "()Ljava/lang/String;", "setCommentMode", "(Ljava/lang/String;)V", "getModuleAfterComment", "setModuleAfterComment", "getPageName", "setPageName", "getPoiEvaluateScore", "setPoiEvaluateScore", "getValidCommentCnt", "setValidCommentCnt", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/ss/android/ugc/aweme/poi/ugc/vh/NpsLogParams;", "equals", "", "other", "", "hashCode", "toString", "Companion", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class NpsLogParams implements Serializable {
    public static final Companion Companion = null;
    public static final long serialVersionUID = 1;

    @SerializedName("comment_cnt")
    private Integer commentCnt;

    @SerializedName("comment_mode")
    private String commentMode;

    @SerializedName("module_after_comment")
    private String moduleAfterComment;

    @SerializedName("page_name")
    private String pageName;

    @SerializedName("poi_evaluate_score")
    private String poiEvaluateScore;

    @SerializedName("valid_comment_cnt")
    private Integer validCommentCnt;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/ugc/vh/NpsLogParams$Companion;", "", "()V", "serialVersionUID", "", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public NpsLogParams() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ NpsLogParams copy$default(NpsLogParams r100, String r101, String r102, Integer r103, Integer r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.commentMode;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.pageName;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.commentCnt;
    L11:
        Integer r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.validCommentCnt;
    L14:
        Integer r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.poiEvaluateScore;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.moduleAfterComment;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.commentMode;
    }

    public final String component2() {
        return this.pageName;
    }

    public final Integer component3() {
        return this.commentCnt;
    }

    public final Integer component4() {
        return this.validCommentCnt;
    }

    public final String component5() {
        return this.poiEvaluateScore;
    }

    public final String component6() {
        return this.moduleAfterComment;
    }

    public final NpsLogParams copy(String r100, String r110, Integer r111, Integer r112, String r113, String r114) {
        return new NpsLogParams(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NpsLogParams) == true) goto L8;
        return false;
    L8:
        NpsLogParams r101 = (NpsLogParams) r100;
        if (Intrinsics.areEqual(this.commentMode, r101.commentMode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pageName, r101.pageName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.commentCnt, r101.commentCnt) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.validCommentCnt, r101.validCommentCnt) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.poiEvaluateScore, r101.poiEvaluateScore) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.moduleAfterComment, r101.moduleAfterComment) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.commentMode;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.pageName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.commentCnt;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.validCommentCnt;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.poiEvaluateScore;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.moduleAfterComment;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
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
        return "NpsLogParams(commentMode=" + this.commentMode + ", pageName=" + this.pageName + ", commentCnt=" + this.commentCnt + ", validCommentCnt=" + this.validCommentCnt + ", poiEvaluateScore=" + this.poiEvaluateScore + ", moduleAfterComment=" + this.moduleAfterComment + ')';
    }

    public final Integer getCommentCnt() {
        return this.commentCnt;
    }

    public final String getCommentMode() {
        return this.commentMode;
    }

    public final String getModuleAfterComment() {
        return this.moduleAfterComment;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final String getPoiEvaluateScore() {
        return this.poiEvaluateScore;
    }

    public final Integer getValidCommentCnt() {
        return this.validCommentCnt;
    }

    public final void setCommentCnt(Integer r100) {
        this.commentCnt = r100;
    }

    public final void setCommentMode(String r100) {
        this.commentMode = r100;
    }

    public final void setModuleAfterComment(String r100) {
        this.moduleAfterComment = r100;
    }

    public final void setPageName(String r100) {
        this.pageName = r100;
    }

    public final void setPoiEvaluateScore(String r100) {
        this.poiEvaluateScore = r100;
    }

    public final void setValidCommentCnt(Integer r100) {
        this.validCommentCnt = r100;
    }

    public NpsLogParams(String r100, String r101, Integer r102, Integer r103, String r104, String r105) {
        this.commentMode = r100;
        this.pageName = r101;
        this.commentCnt = r102;
        this.validCommentCnt = r103;
        this.poiEvaluateScore = r104;
        this.moduleAfterComment = r105;
    }

    public /* synthetic */ NpsLogParams(String r100, String r101, Integer r102, Integer r103, String r104, String r110, int r111, DefaultConstructorMarker r112) {
        String r105 = "";
        if ((r111 & 1) == 0) goto L5;
        String r113 = "";
    L7:
        if ((r111 & 2) == 0) goto L9;
        String r106 = "";
    L11:
        if ((r111 & 4) == 0) goto L13;
        r102 = 0;
    L13:
        Integer r107 = r102;
        if ((r111 & 8) == 0) goto L16;
        r103 = 0;
    L16:
        Integer r108 = r103;
        if ((r111 & 16) != 0) goto L21;
        r105 = r104;
    L21:
        if ((r111 & 32) == 0) goto L23;
        r110 = null;
    L23:
        String r114 = r110;
        this(r113, r106, r107, r108, r105, r114);
        return;
    L9:
        r106 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}
