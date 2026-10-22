package q99;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0019\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000bHÆ\u0003Jh\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R&\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lcom/larus/feedback/api/model/FlowFeedbackSubmitRequest;", "", "feedbackScene", "", "feedbackId", "", "feedbackType", "selectDislikeKeys", "", "dislikeContent", "extraParams", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Ljava/util/Map;)V", "getFeedbackScene", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFeedbackId", "()Ljava/lang/String;", "getFeedbackType", "()I", "getSelectDislikeKeys", "()Ljava/util/List;", "getDislikeContent", "getExtraParams", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Ljava/util/Map;)Lcom/larus/feedback/api/model/FlowFeedbackSubmitRequest;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k {

    @SerializedName("dislike_content")
    private final String dislikeContent;

    @SerializedName("extra_params")
    private final Map<String, String> extraParams;

    @SerializedName("feedback_id")
    private final String feedbackId;

    @SerializedName("feedback_scene")
    private final Integer feedbackScene;

    @SerializedName("feedback_type")
    private final int feedbackType;

    @SerializedName("select_dislike_keys")
    private final List<Integer> selectDislikeKeys;

    public k() {
        this(null, null, 0, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.feedbackScene, r101.feedbackScene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.feedbackId, r101.feedbackId) == true) goto L15;
        return false;
    L15:
        if (this.feedbackType == r101.feedbackType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.selectDislikeKeys, r101.selectDislikeKeys) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.dislikeContent, r101.dislikeContent) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.extraParams, r101.extraParams) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.feedbackScene;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.feedbackId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.feedbackType) * 31;
        List<Integer> r107 = this.selectDislikeKeys;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.dislikeContent;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, String> r113 = this.extraParams;
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

    public final String toString() {
        return "FlowFeedbackSubmitRequest(feedbackScene=" + this.feedbackScene + ", feedbackId=" + this.feedbackId + ", feedbackType=" + this.feedbackType + ", selectDislikeKeys=" + this.selectDislikeKeys + ", dislikeContent=" + this.dislikeContent + ", extraParams=" + this.extraParams + ')';
    }

    public final String a() {
        return this.feedbackId;
    }

    public final Integer b() {
        return this.feedbackScene;
    }

    public final int c() {
        return this.feedbackType;
    }

    public /* synthetic */ k(Integer r110, String r111, int r112, Map r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        Integer r100 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r114 & 32) == 0) goto L17;
        Map r103 = null;
    L18:
        this(r100, r101, r102, null, null, r103);
        return;
    L17:
        r103 = r113;
        goto L18
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public k(Integer r100, String r101, int r102, List<Integer> r103, String r104, Map<String, String> r105) {
        this.feedbackScene = r100;
        this.feedbackId = r101;
        this.feedbackType = r102;
        this.selectDislikeKeys = r103;
        this.dislikeContent = r104;
        this.extraParams = r105;
    }
}
