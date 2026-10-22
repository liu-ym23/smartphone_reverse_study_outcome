package fz4;

import android.webkit.WebView;
import com.bytedance.ee.bear.domain.BearUrl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public final boolean a;
    public final WebView b;
    public final BearUrl c;
    public final boolean d;
    public final String e;
    public final String f;
    public final String g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        WebView r3 = this.b;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        BearUrl r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.d == true) goto L18;
        r1 = 1237;
    L18:
        int r10 = (r9 + r1) * 31;
        String r11 = this.e;
        if (r11 != null) goto L21;
        int r12 = 0;
    L22:
        int r13 = (r10 + r12) * 31;
        String r14 = this.f;
        if (r14 != null) goto L25;
        int r16 = 0;
    L26:
        int r17 = (r13 + r16) * 31;
        String r18 = this.g;
        if (r18 == null) goto L31;
        r4 = r18.hashCode();
    L31:
        return r17 + r4;
    L25:
        r16 = r14.hashCode();
        goto L26
    L21:
        r12 = r11.hashCode();
        goto L22
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "DocShotParams(isMindNote=" + this.a + ", webView=" + this.b + ", bearUrl=" + this.c + ", isWiki=" + this.d + ", source=" + this.e + ", title=" + this.f + ", exportType=" + this.g + ')';
    }

    public c(boolean r1, WebView r2, BearUrl r3, boolean r4, String r5, String r6, String r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
