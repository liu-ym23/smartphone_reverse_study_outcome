package fq8;

import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/larus/bmhome/instruction/repo/AspectRatioInfo;", "", "aspectRatioId", "", "aspectRatioMessageText", "", "<init>", "(ILjava/lang/String;)V", "getAspectRatioId", "()I", "getAspectRatioMessageText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("id")
    private final int aspectRatioId;

    @SerializedName(TTDelegateActivity.MESSAGE_TEXT)
    private final String aspectRatioMessageText;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.aspectRatioId == r101.aspectRatioId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.aspectRatioMessageText, r101.aspectRatioMessageText) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.aspectRatioId * 31;
        String r101 = this.aspectRatioMessageText;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "AspectRatioInfo(aspectRatioId=" + this.aspectRatioId + ", aspectRatioMessageText=" + this.aspectRatioMessageText + ')';
    }

    public a() {
        this.aspectRatioId = 0;
        this.aspectRatioMessageText = "";
    }

    public final int a() {
        return this.aspectRatioId;
    }

    public final String b() {
        return this.aspectRatioMessageText;
    }
}
