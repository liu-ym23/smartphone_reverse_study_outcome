package xjb;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* JADX INFO: loaded from: classes36.dex */
public class b {

    @SerializedName("areaInfo")
    private a areaInfo;

    @SerializedName("guideKey")
    private String guideKey;

    @SerializedName("hasShowed")
    private boolean hasShowed;

    @SerializedName("priority")
    private long priority;

    public final void d() {
        this.hasShowed = true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.guideKey});
    }

    public b() {
        this("", -1, null, false);
    }

    public final String toString() {
        return "GuideInfo{guideKey='" + this.guideKey + "', priority=" + this.priority + ", areaInfo=" + this.areaInfo + ", hasShowed=" + this.hasShowed + '}';
    }

    public final String a() {
        return this.guideKey;
    }

    public final long b() {
        return this.priority;
    }

    public final boolean c() {
        return this.hasShowed;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (getClass() == r100.getClass()) goto L10;
        return false;
    L10:
        return Objects.equals(this.guideKey, ((b) r100).guideKey);
    }

    public b(String r100, long r101, a r102, boolean r103) {
        this.guideKey = r100;
        this.priority = r101;
        this.areaInfo = r102;
        this.hasShowed = r103;
    }
}
