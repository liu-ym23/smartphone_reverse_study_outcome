package lq8;

import com.larus.bmhome.interactionpanel.InteractionPanelSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InteractionPanelSource f510315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f510316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f510317c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f510315a == r101.f510315a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f510316b, r101.f510316b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f510317c, r101.f510317c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f510315a.hashCode() * 31) + this.f510316b.hashCode()) * 31) + this.f510317c.hashCode();
    }

    public final String toString() {
        return "InteractionPanelSourceId(source=" + this.f510315a + ", conversationId=" + this.f510316b + ", threadId=" + this.f510317c + ')';
    }

    public c(InteractionPanelSource r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        Intrinsics.checkNotNullParameter(r102, "threadId");
        this.f510315a = r100;
        this.f510316b = r101;
        this.f510317c = r102;
    }
}
