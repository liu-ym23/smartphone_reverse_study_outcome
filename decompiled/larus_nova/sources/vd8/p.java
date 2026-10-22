package vd8;

import com.larus.bmhome.chat.list.cell.spacer.SpacerAnimationState;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f554237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f554238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Message f554239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SpacerAnimationState f554240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.larus.bmhome.chat.list.cell.spacer.a f554241e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.bmhome.chat.list.cell.spacer.i f554242f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f554237a, r101.f554237a) == true) goto L12;
        return false;
    L12:
        if (this.f554238b == r101.f554238b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f554239c, r101.f554239c) == true) goto L18;
        return false;
    L18:
        if (this.f554240d == r101.f554240d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f554241e, r101.f554241e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f554242f, r101.f554242f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f554237a.hashCode() * 31) + this.f554238b) * 31) + this.f554239c.hashCode()) * 31) + this.f554240d.hashCode()) * 31;
        com.larus.bmhome.chat.list.cell.spacer.a r101 = this.f554241e;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f554242f.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "SpacerRequest(spacerId=" + this.f554237a + ", heightPx=" + this.f554238b + ", baseMessage=" + this.f554239c + ", animationState=" + this.f554240d + ", animationSpec=" + this.f554241e + ", delegate=" + this.f554242f + ')';
    }

    public p(String r100, int r101, Message r102, SpacerAnimationState r103, com.larus.bmhome.chat.list.cell.spacer.a r104, com.larus.bmhome.chat.list.cell.spacer.i r105) {
        Intrinsics.checkNotNullParameter(r100, "spacerId");
        Intrinsics.checkNotNullParameter(r102, "baseMessage");
        Intrinsics.checkNotNullParameter(r103, "animationState");
        Intrinsics.checkNotNullParameter(r105, "delegate");
        this.f554237a = r100;
        this.f554238b = r101;
        this.f554239c = r102;
        this.f554240d = r103;
        this.f554241e = r104;
        this.f554242f = r105;
    }
}
