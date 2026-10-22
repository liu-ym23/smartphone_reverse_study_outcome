package hm7;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u0018"}, d2 = {"Lhm7/e;", "", "", "tipEnable", "Z", "d", "()Z", "", "", "bgColor", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "", "tipsDuration", "D", "e", "()D", "textColor", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "content", "b", "luckydog-task_release"}, k = 1, mv = {1, 4, 0})
public final class e {

    @SerializedName("bg_color")
    private final List<String> bgColor;

    @SerializedName("content")
    private final String content;

    @SerializedName("text_color")
    private final String textColor;

    @SerializedName("tip_enable")
    private final boolean tipEnable;

    @SerializedName("tips_duration")
    private final double tipsDuration;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L21:
        return true;
    L5:
        if ((r100 instanceof e) == false) goto L20;
        e r101 = (e) r100;
        if (this.tipEnable != r101.tipEnable) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L20;
        if (Intrinsics.areEqual(this.bgColor, r101.bgColor) == false) goto L20;
        if (Double.compare(this.tipsDuration, r101.tipsDuration) != 0) goto L20;
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == false) goto L20;
        if (Intrinsics.areEqual(this.content, r101.content) == false) goto L20;
    L9:
        r102 = false;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
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
        long r106 = Double.doubleToLongBits(this.tipsDuration);
        int r107 = (((r102 + r105) * 31) + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        String r108 = this.textColor;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        String r111 = this.content;
        if (r111 == null) goto L17;
        r104 = r111.hashCode();
    L17:
        return r110 + r104;
    L12:
        r109 = 0;
        goto L13
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "TipsConf(tipEnable=" + this.tipEnable + ", bgColor=" + this.bgColor + ", tipsDuration=" + this.tipsDuration + ", textColor=" + this.textColor + ", content=" + this.content + ")";
    }

    public final List<String> a() {
        return this.bgColor;
    }

    public final String b() {
        return this.content;
    }

    public final String c() {
        return this.textColor;
    }

    public final boolean d() {
        return this.tipEnable;
    }

    public final double e() {
        return this.tipsDuration;
    }
}
