package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class m0 extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f464900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f464901d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m0) == true) goto L8;
        return false;
    L8:
        m0 r101 = (m0) r100;
        if (Intrinsics.areEqual(this.f464899b, r101.f464899b) == true) goto L12;
        return false;
    L12:
        if (this.f464900c == r101.f464900c) goto L15;
        return false;
    L15:
        if (this.f464901d == r101.f464901d) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f464899b.hashCode() * 31;
        long r101 = this.f464900c;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        if (this.f464901d == false) goto L5;
        int r103 = 1231;
    L7:
        return r102 + r103;
    L5:
        r103 = 1237;
        goto L7
    }

    public final String toString() {
        return "MusicStyleSelectAction(widgetId=" + this.f464899b + ", optionId=" + this.f464900c + ", isDeselect=" + this.f464901d + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.f464899b;
    }

    public m0(String r100, long r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        super("MusicStyleSelectAction");
        this.f464899b = r100;
        this.f464900c = r101;
        this.f464901d = r102;
    }
}
