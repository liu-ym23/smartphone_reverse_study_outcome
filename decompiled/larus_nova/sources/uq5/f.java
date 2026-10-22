package uq5;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f551307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f551308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f551309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f551310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f551311e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f551312f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f551313g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ar5.a f551314h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f551315i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f551307a, r101.f551307a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f551308b, r101.f551308b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f551309c, r101.f551309c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f551310d, r101.f551310d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f551311e, r101.f551311e) == true) goto L24;
        return false;
    L24:
        if (this.f551312f == r101.f551312f) goto L27;
        return false;
    L27:
        if (this.f551313g == r101.f551313g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f551314h, r101.f551314h) == true) goto L33;
        return false;
    L33:
        if (this.f551315i == r101.f551315i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f551307a.hashCode() * 31;
        String r101 = this.f551308b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f551309c.hashCode()) * 31;
        String r105 = this.f551310d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f551311e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        int r111 = 1231;
        if (this.f551312f == false) goto L17;
        int r112 = 1231;
    L18:
        int r113 = (r110 + r112) * 31;
        if (this.f551313g == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (r113 + r114) * 31;
        ar5.a r116 = this.f551314h;
        if (r116 == null) goto L26;
        r102 = r116.hashCode();
    L26:
        int r117 = (r115 + r102) * 31;
        if (this.f551315i == true) goto L31;
        r111 = 1237;
    L31:
        return r117 + r111;
    L21:
        r114 = 1237;
        goto L22
    L17:
        r112 = 1237;
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "WikiTreePanelDialogShowParams(context=" + this.f551307a + ", title=" + this.f551308b + ", spaceId=" + this.f551309c + ", wikiToken=" + this.f551310d + ", uniqueUiId=" + this.f551311e + ", needOnBoarding=" + this.f551312f + ", isNeedExpandWindow=" + this.f551313g + ", pathResolveContext=" + this.f551314h + ", reusePathResolveTree=" + this.f551315i + ')';
    }

    public final FragmentActivity getContext() {
        return this.f551307a;
    }

    public f(FragmentActivity r100, String r101, String r102, String r103, String r104, boolean r105, ar5.a r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "spaceId");
        this.f551307a = r100;
        this.f551308b = r101;
        this.f551309c = r102;
        this.f551310d = r103;
        this.f551311e = r104;
        this.f551312f = false;
        this.f551313g = r105;
        this.f551314h = r106;
        this.f551315i = r107;
    }
}
