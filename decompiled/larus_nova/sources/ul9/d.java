package ul9;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003HÆ\u0003J1\u0010\u000e\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/larus/navigation/api/baidu/bean/BaiduNaviRouteGuidance;", "", "visualInstructions", "", "Lcom/larus/navigation/api/baidu/bean/instruction/BaiduNaviVisualInstruction;", "verbalInstructions", "Lcom/larus/navigation/api/baidu/bean/instruction/BaiduNaviVerbalInstruction;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getVisualInstructions", "()Ljava/util/List;", "getVerbalInstructions", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("verbal_instructions")
    private final List<vl9.c> verbalInstructions;

    @SerializedName("visual_instructions")
    private final List<vl9.d> visualInstructions;

    public d() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.visualInstructions, r101.visualInstructions) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.verbalInstructions, r101.verbalInstructions) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<vl9.d> r100 = this.visualInstructions;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<vl9.c> r104 = this.verbalInstructions;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BaiduNaviRouteGuidance(visualInstructions=" + this.visualInstructions + ", verbalInstructions=" + this.verbalInstructions + ')';
    }

    public final List<vl9.c> a() {
        return this.verbalInstructions;
    }

    public final List<vl9.d> b() {
        return this.visualInstructions;
    }

    public d(List<vl9.d> r100, List<vl9.c> r101) {
        this.visualInstructions = r100;
        this.verbalInstructions = r101;
    }
}
