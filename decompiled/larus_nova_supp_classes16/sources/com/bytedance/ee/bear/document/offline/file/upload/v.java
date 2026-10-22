package com.bytedance.ee.bear.document.offline.file.upload;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class v {
    public final boolean a;
    public final String b;
    public final Map<String, String> c;
    public final Map<String, String> d;
    public final Map<String, String> e;
    public Map<String, String> f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof v) == true) goto L8;
        return false;
    L8:
        v r6 = (v) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((r0 * 31) + this.b.hashCode()) * 31;
        Map<String, String> r2 = this.c;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        Map<String, String> r6 = this.d;
        if (r6 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (r5 + r7) * 31;
        Map<String, String> r9 = this.e;
        if (r9 == null) goto L19;
        r3 = r9.hashCode();
    L19:
        return r8 + r3;
    L13:
        r7 = r6.hashCode();
        goto L14
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "UploadFileParams(isFileUseUri=" + this.a + ", filePointer=" + this.b + ", params=" + this.c + ", extraParams=" + this.d + ", extraRust=" + this.e + ')';
    }

    public v(boolean r2, String r3, Map<String, String> r4, Map<String, String> r5, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r3, "filePointer");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
