package pr8;

import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import com.larus.bmhome.searchmixedmedia.RatioMode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RatioMode f530381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f530382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c> f530383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ExpandCardViewMode f530384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f530385e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f530381a == r101.f530381a) goto L12;
        return false;
    L12:
        if (this.f530382b == r101.f530382b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f530383c, r101.f530383c) == true) goto L18;
        return false;
    L18:
        if (this.f530384d == r101.f530384d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f530385e, r101.f530385e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f530381a.hashCode() * 31) + this.f530382b) * 31) + this.f530383c.hashCode()) * 31) + this.f530384d.hashCode()) * 31;
        String r101 = this.f530385e;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "SearchMixedMediaViewInput(ratioMode=" + this.f530381a + ", columnCount=" + this.f530382b + ", items=" + this.f530383c + ", msgExpandMode=" + this.f530384d + ", tips=" + this.f530385e + ')';
    }

    public e(RatioMode r100, int r101, List<c> r102, ExpandCardViewMode r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "ratioMode");
        Intrinsics.checkNotNullParameter(r102, "items");
        Intrinsics.checkNotNullParameter(r103, "msgExpandMode");
        this.f530381a = r100;
        this.f530382b = r101;
        this.f530383c = r102;
        this.f530384d = r103;
        this.f530385e = r104;
    }
}
