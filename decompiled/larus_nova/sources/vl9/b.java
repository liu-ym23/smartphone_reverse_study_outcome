package vl9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/larus/navigation/api/baidu/bean/instruction/BaiduNaviVerbalDetail;", "", "speakText", "", "distance2SpeakPoint", "", "distance2GuidePoint", "alreadySent", "", "<init>", "(Ljava/lang/String;IIZ)V", "getSpeakText", "()Ljava/lang/String;", "getDistance2SpeakPoint", "()I", "getDistance2GuidePoint", "getAlreadySent", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("already_sent")
    private final boolean alreadySent;

    @SerializedName("distance_to_gdpt")
    private final int distance2GuidePoint;

    @SerializedName("distance_to_speakpt")
    private final int distance2SpeakPoint;

    @SerializedName("speak_text")
    private final String speakText;

    public b() {
        this(null, 0, 0, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.speakText, r101.speakText) == true) goto L12;
        return false;
    L12:
        if (this.distance2SpeakPoint == r101.distance2SpeakPoint) goto L15;
        return false;
    L15:
        if (this.distance2GuidePoint == r101.distance2GuidePoint) goto L18;
        return false;
    L18:
        if (this.alreadySent == r101.alreadySent) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.speakText;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((((r101 * 31) + this.distance2SpeakPoint) * 31) + this.distance2GuidePoint) * 31;
        if (this.alreadySent == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BaiduNaviVerbalDetail(speakText=" + this.speakText + ", distance2SpeakPoint=" + this.distance2SpeakPoint + ", distance2GuidePoint=" + this.distance2GuidePoint + ", alreadySent=" + this.alreadySent + ')';
    }

    public final boolean a() {
        return this.alreadySent;
    }

    public final int b() {
        return this.distance2GuidePoint;
    }

    public final int c() {
        return this.distance2SpeakPoint;
    }

    public final String d() {
        return this.speakText;
    }

    public b(String r100, int r101, int r102, boolean r103) {
        this.speakText = r100;
        this.distance2SpeakPoint = r101;
        this.distance2GuidePoint = r102;
        this.alreadySent = r103;
    }
}
