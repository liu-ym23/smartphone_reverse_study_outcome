package do8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f469449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f469450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f469451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f469452d;

    public i() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f469449a == r101.f469449a) goto L12;
        return false;
    L12:
        if (this.f469450b == r101.f469450b) goto L15;
        return false;
    L15:
        if (this.f469451c == r101.f469451c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f469452d, r101.f469452d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f469449a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f469450b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f469451c == true) goto L14;
        r100 = 1237;
    L14:
        int r105 = (r104 + r100) * 31;
        List<String> r106 = this.f469452d;
        if (r106 != null) goto L17;
        int r107 = 0;
    L19:
        return r105 + r107;
    L17:
        r107 = r106.hashCode();
        goto L19
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "VLMContainerPreloadAndRecommendConfig(enableVideoRecommend=" + this.f469449a + ", enableVideoPreload=" + this.f469450b + ", enableVideoRecommendPreload=" + this.f469451c + ", splitQuery=" + this.f469452d + ')';
    }

    public /* synthetic */ i(int r100) {
        this(false, false, false, null);
    }

    public i(boolean r100, boolean r101, boolean r102, List<String> r103) {
        this.f469449a = r100;
        this.f469450b = r101;
        this.f469451c = r102;
        this.f469452d = r103;
    }
}
