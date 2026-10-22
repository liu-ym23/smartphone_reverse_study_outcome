package nq9;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f520139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f520140b;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f520139a, r101.f520139a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f520140b, r101.f520140b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f520139a.hashCode() * 31) + this.f520140b.hashCode();
    }

    public final String toString() {
        return "AppsSdkUgcBotConfig(botId=" + this.f520139a + ", botIds=" + this.f520140b + ')';
    }

    public /* synthetic */ a(int r100) {
        this("", CollectionsKt.emptyList());
    }

    public a(String r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        Intrinsics.checkNotNullParameter(r101, "botIds");
        this.f520139a = r100;
        this.f520140b = r101;
    }
}
