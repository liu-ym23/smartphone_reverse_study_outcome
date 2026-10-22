package q99;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f532138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f532139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b> f532140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f532141d;

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        boolean r100 = false;
        Object[] r101 = 0 == true ? 1 : 0;
        this(r100, null, r101, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f532138a == r101.f532138a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f532139b, r101.f532139b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f532140c, r101.f532140c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f532141d, r101.f532141d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f532138a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((r100 * 31) + this.f532139b.hashCode()) * 31) + this.f532140c.hashCode()) * 31;
        String r102 = this.f532141d;
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
        return "FlowDislikeFeedbackResult(isSubmit=" + this.f532138a + ", selectedCodeList=" + this.f532139b + ", selectedOptions=" + this.f532140c + ", inputText=" + this.f532141d + ')';
    }

    public /* synthetic */ a(boolean r100, List r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = CollectionsKt.emptyList();
    L9:
        if ((r103 & 4) == 0) goto L11;
        List r104 = CollectionsKt.emptyList();
    L13:
        if ((r103 & 8) == 0) goto L15;
        r102 = null;
    L15:
        this(r100, r101, r104, r102);
        return;
    L11:
        r104 = null;
        goto L13
    }

    public a(boolean r100, List<Integer> r101, List<b> r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "selectedCodeList");
        Intrinsics.checkNotNullParameter(r102, "selectedOptions");
        this.f532138a = r100;
        this.f532139b = r101;
        this.f532140c = r102;
        this.f532141d = r103;
    }
}
