package o8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f522328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f522329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f522330c;

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f522328a, r101.f522328a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f522329b, r101.f522329b) == true) goto L15;
        return false;
    L15:
        if (this.f522330c == r101.f522330c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f522328a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f522329b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        if (this.f522330c == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "JsbInfo(nameSpace=" + this.f522328a + ", jsObjectName=" + this.f522329b + ", isShouldFlattenData=" + this.f522330c + ')';
    }

    public e(int r100) {
        this.f522328a = "webcast";
        this.f522329b = "ToutiaoJSBridge";
        this.f522330c = true;
    }
}
