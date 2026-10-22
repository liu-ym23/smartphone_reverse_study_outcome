package f4b;

import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f475592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f475593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f475594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f475595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PartialReplyInfo.PartialContentRelativePosition f475596e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f475592a, r101.f475592a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f475593b, r101.f475593b) == true) goto L15;
        return false;
    L15:
        if (this.f475594c == r101.f475594c) goto L18;
        return false;
    L18:
        if (this.f475595d == r101.f475595d) goto L21;
        return false;
    L21:
        if (this.f475596e == r101.f475596e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        CharSequence r100 = this.f475592a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        CharSequence r104 = this.f475593b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        int r107 = 1231;
        if (this.f475594c == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f475595d == true) goto L18;
        r107 = 1237;
    L18:
        int r110 = (r109 + r107) * 31;
        PartialReplyInfo.PartialContentRelativePosition r111 = this.f475596e;
        if (r111 == null) goto L23;
        r101 = r111.hashCode();
    L23:
        return r110 + r101;
    L13:
        r108 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SelectData(select=" + this.f475592a + ", full=" + this.f475593b + ", isTranslate=" + this.f475594c + ", isPartialCopy=" + this.f475595d + ", partialPosition=" + this.f475596e + ')';
    }

    public f(CharSequence r100, CharSequence r101, boolean r102, boolean r103, PartialReplyInfo.PartialContentRelativePosition r104) {
        this.f475592a = r100;
        this.f475593b = r101;
        this.f475594c = r102;
        this.f475595d = r103;
        this.f475596e = r104;
    }
}
