package wlb;

import com.ss.android.lark.inline.ai.api.MentionType;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MentionType f560238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f560239b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f560238a == r101.f560238a) goto L12;
        return false;
    L12:
        if (this.f560239b == r101.f560239b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        MentionType r100 = this.f560238a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.f560239b == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public a() {
        this(MentionType.DEFAULT, false);
    }

    public final String toString() {
        return "(AIEditConfig: enableAt=" + this.f560238a + ", selectedShowKeyboard=" + this.f560239b + ')';
    }

    public a(MentionType r100, boolean r101) {
        this.f560238a = r100;
        this.f560239b = r101;
    }
}
