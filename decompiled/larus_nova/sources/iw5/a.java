package iw5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f496217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f496218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f496219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f496220d;

    public a() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f496217a, r101.f496217a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f496218b, r101.f496218b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f496219c, r101.f496219c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f496220d, r101.f496220d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f496217a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f496218b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f496219c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.f496220d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowAsrAudioEventInfo(type=" + this.f496217a + ", aedRes=" + this.f496218b + ", aedDisplayRes=" + this.f496219c + ", needCallTool=" + this.f496220d + ')';
    }

    public final String getType() {
        return this.f496217a;
    }

    public a(String r100, String r101, String r102, Boolean r103) {
        this.f496217a = r100;
        this.f496218b = r101;
        this.f496219c = r102;
        this.f496220d = r103;
    }
}
