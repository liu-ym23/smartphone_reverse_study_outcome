package lc3;

import com.bytedance.android.shopping.commentv3.data.FetchFrom;
import com.bytedance.android.shopping.commentv3.data.interfaces.ICommentComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public final List<ICommentComponent> a;
    public final List<ICommentComponent> b;
    public final boolean c;
    public final FetchFrom d;

    public b() {
        List r0 = null;
        this(r0, r0, 15);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L14;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final int hashCode() {
        List<ICommentComponent> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<ICommentComponent> r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.c;
        ?? r8 = r7;
        if (r7 == false) goto L13;
        r8 = 1;
    L13:
        int r9 = (r6 + r8) * 31;
        FetchFrom r10 = this.d;
        if (r10 == null) goto L17;
        r1 = r10.hashCode();
    L17:
        return r9 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ComponentModel(listComponents=" + this.a + ", multiPicComponents=" + this.b + ", needScrollToFirst=" + this.c + ", fetchFrom=" + this.d + ")";
    }

    public /* synthetic */ b(List r2, List r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = new ArrayList();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = new ArrayList();
    L9:
        if ((r4 & 8) == 0) goto L11;
        FetchFrom r5 = FetchFrom.OTHER;
    L12:
        this(r2, r3, false, r5);
        return;
    L11:
        r5 = null;
        goto L12
    }

    public b(List<ICommentComponent> r2, List<ICommentComponent> r3, boolean r4, FetchFrom r5) {
        Intrinsics.checkNotNullParameter(r2, "listComponents");
        Intrinsics.checkNotNullParameter(r3, "multiPicComponents");
        Intrinsics.checkNotNullParameter(r5, "fetchFrom");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
