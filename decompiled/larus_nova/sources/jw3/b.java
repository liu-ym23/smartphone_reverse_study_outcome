package jw3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f500705b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f500704a, r101.f500704a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f500705b, r101.f500705b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f500704a.hashCode() * 31) + this.f500705b.hashCode();
    }

    public final String toString() {
        return "AppletIndicationPayload(eventName=" + this.f500704a + ", payloadJson=" + this.f500705b + ')';
    }

    public b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "payloadJson");
        this.f500704a = r100;
        this.f500705b = r101;
    }
}
