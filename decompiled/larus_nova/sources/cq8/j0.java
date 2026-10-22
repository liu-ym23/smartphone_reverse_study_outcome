package cq8;

import com.larus.bmhome.actionbar.model.p1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j0 extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f464858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f464859e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p1 f464860f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f464861g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j0) == true) goto L8;
        return false;
    L8:
        j0 r101 = (j0) r100;
        if (Intrinsics.areEqual(this.f464857c, r101.f464857c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464858d, r101.f464858d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f464859e, r101.f464859e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f464860f, r101.f464860f) == true) goto L21;
        return false;
    L21:
        if (this.f464861g == r101.f464861g) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f464857c.hashCode() * 31) + this.f464858d.hashCode()) * 31) + this.f464859e.hashCode()) * 31;
        p1 r101 = this.f464860f;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f464861g;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MsgInstructionDescriptor(widgetId=" + this.f464857c + ", actionChannel=" + this.f464858d + ", version=" + this.f464859e + ", template=" + this.f464860f + ", msgInstructionType=" + this.f464861g + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.f464859e;
    }

    public j0(String r100, com.larus.bmhome.instruction.core.impl.base.b.C4081b r101, p1 r102, int r103) {
        String r104 = a0.a.a();
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "actionChannel");
        Intrinsics.checkNotNullParameter(r104, "version");
        super("MsgInstructionDescriptor");
        this.f464857c = r100;
        this.f464858d = r101;
        this.f464859e = r104;
        this.f464860f = r102;
        this.f464861g = r103;
    }
}
