package on8;

import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import com.larus.bmhome.searchmixedmedia.RatioMode;
import com.larus.im.bean.message.block.UgcItem;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RatioMode f524373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<UgcItem> f524374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExpandCardViewMode f524375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f524376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f524377e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f524373a == r101.f524373a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f524374b, r101.f524374b) == true) goto L15;
        return false;
    L15:
        if (this.f524375c == r101.f524375c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f524376d, r101.f524376d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f524377e, r101.f524377e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f524373a.hashCode() * 31) + this.f524374b.hashCode()) * 31) + this.f524375c.hashCode()) * 31;
        String r101 = this.f524376d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f524377e;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "SearchMixedMediaVMData(ratioMode=" + this.f524373a + ", items=" + this.f524374b + ", msgExpandMode=" + this.f524375c + ", tips=" + this.f524376d + ", messageId=" + this.f524377e + ')';
    }

    public a(RatioMode r100, List<UgcItem> r101, ExpandCardViewMode r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "ratioMode");
        Intrinsics.checkNotNullParameter(r101, "items");
        Intrinsics.checkNotNullParameter(r102, "msgExpandMode");
        this.f524373a = r100;
        this.f524374b = r101;
        this.f524375c = r102;
        this.f524376d = r103;
        this.f524377e = r104;
    }
}
