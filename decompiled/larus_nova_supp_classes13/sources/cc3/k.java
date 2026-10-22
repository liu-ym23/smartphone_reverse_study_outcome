package cc3;

import com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final String e;
    public final String f;
    public final String g;
    public int h;
    public final CommentNodeVO i;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof k) == false) goto L24;
        k r4 = (k) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (this.h == r4.h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        int r0 = ((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31;
        String r1 = this.e;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.g;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (((r7 + r9) * 31) + this.h) * 31;
        CommentNodeVO r11 = this.i;
        if (r11 == null) goto L18;
        r2 = r11.hashCode();
    L18:
        return r10 + r2;
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "GalleryCommentInfo(mediaType=" + this.a + ", commentRank=" + this.b + ", videoNum=" + this.c + ", imageNum=" + this.d + ", commentSwitchType=" + this.e + ", commentId=" + this.f + ", userCommentLevel=" + this.g + ", contentRank=" + this.h + ", commentNodeVO=" + this.i + ")";
    }

    public k(int r2, int r3, int r4, int r5, String r6, String r7, String r8, int r9, CommentNodeVO r10) {
        Intrinsics.checkNotNullParameter(r6, "commentSwitchType");
        Intrinsics.checkNotNullParameter(r10, "commentNodeVO");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
