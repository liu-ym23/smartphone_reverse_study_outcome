package he3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R*\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lhe3/m;", "", "Lhe3/r;", "liveInfo", "Lhe3/r;", "b", "()Lhe3/r;", "", "Lhe3/q;", "interaction", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "d", "(Ljava/util/List;)V", "Lhe3/s;", "multiTabInfo", "Lhe3/s;", "c", "()Lhe3/s;", "setMultiTabInfo", "(Lhe3/s;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m {

    @SerializedName("interaction_word_list")
    private List<q> interaction;

    @SerializedName("live_info")
    private final r liveInfo;

    @SerializedName("multi_tab_info")
    private s multiTabInfo;

    public m() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L12;
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.liveInfo, r101.liveInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.interaction, r101.interaction) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.multiTabInfo, r101.multiTabInfo) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        r r100 = this.liveInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<q> r104 = this.interaction;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        s r107 = this.multiTabInfo;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DeepFeedExtendInfo(liveInfo=" + this.liveInfo + ", interaction=" + this.interaction + ", multiTabInfo=" + this.multiTabInfo + ")";
    }

    public final List<q> a() {
        return this.interaction;
    }

    public final r b() {
        return this.liveInfo;
    }

    public final s c() {
        return this.multiTabInfo;
    }

    public final void d(List<q> r100) {
        this.interaction = r100;
    }

    public m(List r100, int r101) {
        if ((r101 & 2) == 0) goto L5;
        r100 = null;
    L5:
        this.liveInfo = null;
        this.interaction = r100;
        this.multiTabInfo = null;
    }
}
