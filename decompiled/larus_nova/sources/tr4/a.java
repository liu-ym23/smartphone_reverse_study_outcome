package tr4;

import com.bytedance.ee.bear.bitable.context.BitableTokenType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f547296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BitableTokenType f547297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f547298c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f547296a, r101.f547296a) == true) goto L12;
        return false;
    L12:
        if (this.f547297b == r101.f547297b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f547298c, r101.f547298c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f547296a.hashCode() * 31) + this.f547297b.hashCode()) * 31;
        e r101 = this.f547298c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "BitableContext(token=" + this.f547296a + ", tokenType=" + this.f547297b + ", viewParam=" + this.f547298c + ')';
    }

    public a(String r100, BitableTokenType r101, e r102) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "tokenType");
        this.f547296a = r100;
        this.f547297b = r101;
        this.f547298c = r102;
    }
}
