package km8;

import com.larus.im.bean.message.Message;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pair<Integer, Integer> f504086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f504087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Message f504088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ph8.e f504089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f504090e;

    public a() {
        this(null, 0, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f504086a, r101.f504086a) == true) goto L12;
        return false;
    L12:
        if (this.f504087b == r101.f504087b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f504088c, r101.f504088c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f504089d, r101.f504089d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f504090e, r101.f504090e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Pair<Integer, Integer> r100 = this.f504086a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f504087b) * 31;
        Message r104 = this.f504088c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ph8.e r107 = this.f504089d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f504090e;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MemoryVMData(topAndBottomMarginPair=" + this.f504086a + ", maxWidth=" + this.f504087b + ", message=" + this.f504088c + ", memoryItem=" + this.f504089d + ", cardPosition=" + this.f504090e + ')';
    }

    public a(Pair<Integer, Integer> r100, int r101, Message r102, ph8.e r103, Integer r104) {
        this.f504086a = r100;
        this.f504087b = r101;
        this.f504088c = r102;
        this.f504089d = r103;
        this.f504090e = r104;
    }
}
