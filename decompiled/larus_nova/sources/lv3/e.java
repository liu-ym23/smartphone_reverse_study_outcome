package lv3;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f510899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f510900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f510901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f510902d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f510899a, r101.f510899a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f510900b, r101.f510900b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f510901c, r101.f510901c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f510902d, r101.f510902d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f510899a.hashCode() * 31) + this.f510900b.hashCode()) * 31) + this.f510901c.hashCode()) * 31) + this.f510902d.hashCode();
    }

    public final String toString() {
        return "ECommerceProductCardPreloadRequest(messageId=" + this.f510899a + ", mixtureCardId=" + this.f510900b + ", conversationId=" + this.f510901c + ", schemaList=" + this.f510902d + ')';
    }

    public e(String r100, String r101, String r102, List<String> r103) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "mixtureCardId");
        Intrinsics.checkNotNullParameter(r102, "conversationId");
        Intrinsics.checkNotNullParameter(r103, "schemaList");
        this.f510899a = r100;
        this.f510900b = r101;
        this.f510901c = r102;
        this.f510902d = r103;
    }
}
