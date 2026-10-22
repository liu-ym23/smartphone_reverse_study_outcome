package tm8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f546819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f546820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f546821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<a> f546822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f546823e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f546824f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f546819a, r101.f546819a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f546820b, r101.f546820b) == true) goto L15;
        return false;
    L15:
        if (this.f546821c == r101.f546821c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f546822d, r101.f546822d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f546823e, r101.f546823e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f546824f, r101.f546824f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f546819a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f546820b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f546821c == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (((r106 + r107) * 31) + this.f546822d.hashCode()) * 31;
        String r109 = this.f546823e;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        Integer r112 = this.f546824f;
        if (r112 == null) goto L23;
        r101 = r112.hashCode();
    L23:
        return r111 + r101;
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "QuickReplyViewInput(messageId=" + this.f546819a + ", uniqueId=" + this.f546820b + ", useHorizontalLayout=" + this.f546821c + ", items=" + this.f546822d + ", guideText=" + this.f546823e + ", itemBackgroundRes=" + this.f546824f + ')';
    }

    public n(String r100, String r101, List r102, String r103, Integer r104) {
        Intrinsics.checkNotNullParameter(r102, "items");
        this.f546819a = r100;
        this.f546820b = r101;
        this.f546821c = false;
        this.f546822d = r102;
        this.f546823e = r103;
        this.f546824f = r104;
    }
}
