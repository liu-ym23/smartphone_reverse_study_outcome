package ve5;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m {
    public final String a;
    public final String b;
    public final int c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c;
    }

    public final String toString() {
        return "MentionSnapshot(token=" + this.a + ", displayName=" + this.b + ", userType=" + this.c + ')';
    }

    public m(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r3, "displayName");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
