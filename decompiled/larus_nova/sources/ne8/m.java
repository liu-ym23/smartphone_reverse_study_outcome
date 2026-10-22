package ne8;

import com.larus.im.bean.message.block.Block;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f518900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mf9.e f518901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Block f518902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f518903d;

    public m() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (this.f518900a == r101.f518900a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f518901b, r101.f518901b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f518902c, r101.f518902c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f518903d, r101.f518903d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f518900a * 31;
        mf9.e r101 = this.f518901b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Block r105 = this.f518902c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Map<String, String> r108 = this.f518903d;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DeepResearchData(viewType=" + this.f518900a + ", reportPodcastData=" + this.f518901b + ", block=" + this.f518902c + ", clientExt=" + this.f518903d + ')';
    }

    public m(int r100, mf9.e r101, Block r102, int r103) {
        LinkedHashMap r104 = null;
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r103 & 8) == 0) goto L11;
        r104 = new LinkedHashMap();
    L11:
        this.f518900a = r100;
        this.f518901b = r101;
        this.f518902c = r102;
        this.f518903d = r104;
    }
}
