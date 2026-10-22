package he3;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R*\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lhe3/m;", "", "Lhe3/r;", "liveInfo", "Lhe3/r;", "b", "()Lhe3/r;", "", "Lhe3/q;", "interaction", "Ljava/util/List;", "a", "()Ljava/util/List;", "d", "(Ljava/util/List;)V", "Lhe3/s;", "multiTabInfo", "Lhe3/s;", "c", "()Lhe3/s;", "setMultiTabInfo", "(Lhe3/s;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof m) == false) goto L12;
        m r4 = (m) r3;
        if (Intrinsics.areEqual(this.liveInfo, r4.liveInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.interaction, r4.interaction) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.multiTabInfo, r4.multiTabInfo) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        r r0 = this.liveInfo;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<q> r4 = this.interaction;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        s r7 = this.multiTabInfo;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
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

    public final void d(List<q> r1) {
        this.interaction = r1;
    }

    public m(List r2, int r3) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this.liveInfo = null;
        this.interaction = r2;
        this.multiTabInfo = null;
    }
}
