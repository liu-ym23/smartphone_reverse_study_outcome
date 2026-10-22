package j98;

import com.larus.nova.R;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f497802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f497803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f497804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f497805d;

    public c() {
        this(0, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f497802a == r101.f497802a) goto L12;
        return false;
    L12:
        if (this.f497803b == r101.f497803b) goto L15;
        return false;
    L15:
        if (this.f497804c == r101.f497804c) goto L18;
        return false;
    L18:
        if (this.f497805d == r101.f497805d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f497802a * 31) + this.f497803b) * 31) + this.f497804c) * 31) + this.f497805d;
    }

    public final String toString() {
        return "DiaryFeedbackEntryUiModel(titleRes=" + this.f497802a + ", likeTextRes=" + this.f497803b + ", dislikeTextRes=" + this.f497804c + ", selectedActionType=" + this.f497805d + ')';
    }

    public c(int r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        int r102 = R.string.larus_dora_personal_diary_do_you_like_cn;
    L7:
        if ((r101 & 2) == 0) goto L9;
        int r103 = R.string.larus_dora_personal_diary_like_cn;
    L11:
        if ((r101 & 4) == 0) goto L13;
        int r104 = R.string.larus_dora_personal_diary_dislike_cn;
    L15:
        if ((r101 & 8) == 0) goto L17;
        r100 = 0;
    L17:
        this.f497802a = r102;
        this.f497803b = r103;
        this.f497804c = r104;
        this.f497805d = r100;
        return;
    L13:
        r104 = 0;
        goto L15
    L9:
        r103 = 0;
        goto L11
    L5:
        r102 = 0;
        goto L7
    }
}
