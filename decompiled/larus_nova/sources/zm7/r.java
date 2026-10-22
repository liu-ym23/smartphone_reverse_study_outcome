package zm7;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015¨\u0006\u001a"}, d2 = {"Lzm7/r;", "", "", "tipEnable", "Z", "getTipEnable", "()Z", "", "", "bgColor", "Ljava/util/List;", "getBgColor", "()Ljava/util/List;", "", "tipDuration", "I", "getTipDuration", "()I", "textColor", "Ljava/lang/String;", "getTextColor", "()Ljava/lang/String;", "content", "getContent", "tipSize", "getTipSize", "luckyhost-api_release"}, k = 1, mv = {1, 4, 0})
public final class r {

    @SerializedName("bg_color")
    private final List<String> bgColor;

    @SerializedName("content")
    private final String content;

    @SerializedName("text_color")
    private final String textColor;

    @SerializedName("tip_duration")
    private final int tipDuration;

    @SerializedName("tip_enable")
    private final boolean tipEnable;

    @SerializedName("tip_size")
    private final String tipSize;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L26:
        return true;
    L5:
        if ((r100 instanceof r) == false) goto L25;
        r r101 = (r) r100;
        if (this.tipEnable != r101.tipEnable) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L25;
        if (Intrinsics.areEqual(this.bgColor, r101.bgColor) == false) goto L25;
        if (this.tipDuration != r101.tipDuration) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == false) goto L25;
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == false) goto L25;
        if (Intrinsics.areEqual(this.content, r101.content) == false) goto L25;
        if (Intrinsics.areEqual(this.tipSize, r101.tipSize) == false) goto L25;
    L16:
        r103 = false;
        goto L17
    L9:
        r102 = false;
    L25:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public final int hashCode() {
        boolean r100 = this.tipEnable;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        List<String> r103 = this.bgColor;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (((r102 + r105) * 31) + this.tipDuration) * 31;
        String r107 = this.textColor;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.content;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = this.tipSize;
        if (r113 == null) goto L21;
        r104 = r113.hashCode();
    L21:
        return r112 + r104;
    L16:
        r111 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "TipConf(tipEnable=" + this.tipEnable + ", bgColor=" + this.bgColor + ", tipDuration=" + this.tipDuration + ", textColor=" + this.textColor + ", content=" + this.content + ", tipSize=" + this.tipSize + ")";
    }
}
