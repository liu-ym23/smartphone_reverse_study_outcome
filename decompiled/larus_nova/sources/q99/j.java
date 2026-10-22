package q99;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\tHÆ\u0003JJ\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R&\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/larus/feedback/api/model/FlowFeedbackShownRequest;", "", "feedbackScene", "", "feedbackId", "", "showTime", "", "extraParams", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;JLjava/util/Map;)V", "getFeedbackScene", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFeedbackId", "()Ljava/lang/String;", "getShowTime", "()J", "getExtraParams", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;JLjava/util/Map;)Lcom/larus/feedback/api/model/FlowFeedbackShownRequest;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class j {

    @SerializedName("extra_params")
    private final Map<String, String> extraParams;

    @SerializedName("feedback_id")
    private final String feedbackId;

    @SerializedName("feedback_scene")
    private final Integer feedbackScene;

    @SerializedName("show_time")
    private final long showTime;

    public j() {
        this(null, null, 0, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.feedbackScene, r101.feedbackScene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.feedbackId, r101.feedbackId) == true) goto L15;
        return false;
    L15:
        if (this.showTime == r101.showTime) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extraParams, r101.extraParams) == true) goto L20;
        return false;
    L20:
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
        int r106 = (r103 + r105) * 31;
        long r107 = this.showTime;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        Map<String, String> r109 = this.extraParams;
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

    public final String toString() {
        return "FlowFeedbackShownRequest(feedbackScene=" + this.feedbackScene + ", feedbackId=" + this.feedbackId + ", showTime=" + this.showTime + ", extraParams=" + this.extraParams + ')';
    }

    public final String a() {
        return this.feedbackId;
    }

    public final Integer b() {
        return this.feedbackScene;
    }

    public j(Integer r100, String r101, long r102, Map<String, String> r103) {
        this.feedbackScene = r100;
        this.feedbackId = r101;
        this.showTime = r102;
        this.extraParams = r103;
    }
}
