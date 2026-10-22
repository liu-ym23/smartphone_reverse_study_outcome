package kq;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f505569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f505570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f505571c;

    /* JADX INFO: renamed from: kq.a$a, reason: collision with other inner class name */
    public static final class C6599a {
    }

    static {
    }

    public a() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f505569a, r101.f505569a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f505570b, r101.f505570b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f505571c, r101.f505571c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f505569a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f505570b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.f505571c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SliceUpdateAction(sliceId=" + this.f505569a + ", filter=" + this.f505570b + ", incomingData=" + this.f505571c + ")";
    }

    public a(String r100, String r101, Map<String, ? extends Object> r102) {
        this.f505569a = r100;
        this.f505570b = r101;
        this.f505571c = r102;
    }
}
