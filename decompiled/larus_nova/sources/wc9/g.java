package wc9;

import com.larus.im.bean.conversation.ConversationArchiveFilter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f559229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f559230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f559231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConversationArchiveFilter f559232d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f559229a == r101.f559229a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f559230b, r101.f559230b) == true) goto L15;
        return false;
    L15:
        if (this.f559231c == r101.f559231c) goto L18;
        return false;
    L18:
        if (this.f559232d == r101.f559232d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f559229a * 31;
        f r101 = this.f559230b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f559231c == false) goto L9;
        int r104 = 1231;
    L11:
        return ((r103 + r104) * 31) + this.f559232d.hashCode();
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ConversationListRequest(pageSize=" + this.f559229a + ", anchor=" + this.f559230b + ", withBrief=" + this.f559231c + ", archiveFilter=" + this.f559232d + ')';
    }

    public g(int r100, f r101, ConversationArchiveFilter r102) {
        Intrinsics.checkNotNullParameter(r102, "archiveFilter");
        this.f559229a = r100;
        this.f559230b = r101;
        this.f559231c = true;
        this.f559232d = r102;
    }
}
