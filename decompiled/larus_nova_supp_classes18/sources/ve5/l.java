package ve5;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l {
    public final String a;
    public final long b;
    public final String c;
    public final Map<String, String> d;

    public static final class a {
    }

    static {
    }

    public l() {
        throw null;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof l) == true) goto L8;
        return false;
    L8:
        l r9 = (l) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        return ((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "BotMentionSceneContext(objToken=" + this.a + ", objType=" + this.b + ", scene=" + this.c + ", extraParams=" + this.d + ')';
    }

    public l(String r4, long r5) {
        Map<String, String> r0 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r4, "objToken");
        Intrinsics.checkNotNullParameter("comment", "scene");
        Intrinsics.checkNotNullParameter(r0, "extraParams");
        this.a = r4;
        this.b = r5;
        this.c = "comment";
        this.d = r0;
    }
}
