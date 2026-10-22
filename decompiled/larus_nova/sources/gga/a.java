package gga;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f481222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Integer> f481223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f481224c;

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
        if (this.f481222a == r101.f481222a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f481223b, r101.f481223b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f481224c, r101.f481224c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f481222a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f481223b.hashCode()) * 31;
        Integer r102 = this.f481224c;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "ObricActionBarModelMenuPolicy(enabled=" + this.f481222a + ", blockedItemIds=" + this.f481223b + ", defaultItemId=" + this.f481224c + ')';
    }

    public /* synthetic */ a(int r100) {
        this(false, SetsKt.emptySet(), null);
    }

    public final boolean a(Integer r100) {
        if (this.f481222a == false) goto L9;
        if (r100 == null) goto L9;
        if (this.f481223b.contains(r100) == false) goto L9;
        return false;
    L9:
        return true;
    }

    public final int b(int r100) {
        if (this.f481222a == true) goto L5;
        return r100;
    L5:
        if (this.f481223b.contains(Integer.valueOf(r100)) == false) goto L19;
        Integer r101 = this.f481224c;
        if (r101 != null) goto L10;
        return r100;
    L10:
        if ((!this.f481223b.contains(Integer.valueOf(r101.intValue()))) == true) goto L13;
        r101 = null;
    L13:
        if (r101 != null) goto L15;
        return r100;
    L15:
        return r101.intValue();
    L19:
        return r100;
    }

    public a(boolean r100, Set<Integer> r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r101, "blockedItemIds");
        this.f481222a = r100;
        this.f481223b = r101;
        this.f481224c = r102;
    }
}
