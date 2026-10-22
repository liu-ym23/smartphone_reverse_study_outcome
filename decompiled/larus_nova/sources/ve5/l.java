package ve5;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f554391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f554392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f554393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f554394d;

    public static final class a {
    }

    static {
    }

    public l() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f554391a, r101.f554391a) == true) goto L12;
        return false;
    L12:
        if (this.f554392b == r101.f554392b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f554393c, r101.f554393c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f554394d, r101.f554394d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f554391a.hashCode() * 31;
        long r101 = this.f554392b;
        return ((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f554393c.hashCode()) * 31) + this.f554394d.hashCode();
    }

    public final String toString() {
        return "BotMentionSceneContext(objToken=" + this.f554391a + ", objType=" + this.f554392b + ", scene=" + this.f554393c + ", extraParams=" + this.f554394d + ')';
    }

    public l(String r100, long r101) {
        Map<String, String> r102 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r100, "objToken");
        Intrinsics.checkNotNullParameter("comment", "scene");
        Intrinsics.checkNotNullParameter(r102, "extraParams");
        this.f554391a = r100;
        this.f554392b = r101;
        this.f554393c = "comment";
        this.f554394d = r102;
    }
}
