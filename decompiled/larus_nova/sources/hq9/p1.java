package hq9;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f486741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f486742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f486743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f486744d;

    public p1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p1) == true) goto L8;
        return false;
    L8:
        p1 r101 = (p1) r100;
        if (Intrinsics.areEqual(this.f486741a, r101.f486741a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486742b, r101.f486742b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f486743c, r101.f486743c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f486744d, r101.f486744d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f486741a.hashCode() * 31) + this.f486742b.hashCode()) * 31) + this.f486743c.hashCode()) * 31) + this.f486744d.hashCode();
    }

    public final String toString() {
        return "HealthBotConfigInfo(botIds=" + this.f486741a + ", settingAgreementTitle=" + this.f486742b + ", settingAgreementUrl=" + this.f486743c + ", settingAgreementTrackName=" + this.f486744d + ')';
    }

    public /* synthetic */ p1(int r100) {
        this(CollectionsKt.emptyList(), "", "", "");
    }

    public p1(List<String> r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "botIds");
        Intrinsics.checkNotNullParameter(r101, "settingAgreementTitle");
        Intrinsics.checkNotNullParameter(r102, "settingAgreementUrl");
        Intrinsics.checkNotNullParameter(r103, "settingAgreementTrackName");
        this.f486741a = r100;
        this.f486742b = r101;
        this.f486743c = r102;
        this.f486744d = r103;
    }
}
