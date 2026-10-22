package wc9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<l> f559261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f559262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f559263c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f559261a, r101.f559261a) == true) goto L12;
        return false;
    L12:
        if (this.f559262b == r101.f559262b) goto L15;
        return false;
    L15:
        if (this.f559263c == r101.f559263c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f559261a.hashCode() * 31) + this.f559262b) * 31;
        if (this.f559263c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "SelectConversationListResponse(conversationList=" + this.f559261a + ", sortType=" + this.f559262b + ", hasMore=" + this.f559263c + ')';
    }

    public s(List<l> r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "conversationList");
        this.f559261a = r100;
        this.f559262b = r101;
        this.f559263c = r102;
    }
}
