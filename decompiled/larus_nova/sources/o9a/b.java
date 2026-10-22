package o9a;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f522494b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f522495a;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f522495a, ((b) r100).f522495a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f522495a.hashCode();
    }

    public final String toString() {
        return "MenuBean(menuItems=" + this.f522495a + ')';
    }

    public b() {
        this(CollectionsKt.emptyList());
    }

    public b(List<c> r100) {
        Intrinsics.checkNotNullParameter(r100, "menuItems");
        this.f522495a = r100;
    }
}
