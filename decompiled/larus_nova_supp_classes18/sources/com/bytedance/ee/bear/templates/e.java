package com.bytedance.ee.bear.templates;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public final String a;
    public final String b;
    public final Integer c;
    public final String d;
    public final sbb.e e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        sbb.e r11 = this.e;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "TemplateClickReportParams(type=" + this.a + ", searchKey=" + this.b + ", subPosition=" + this.c + ", subTemplateSort=" + this.d + ", currentFilterDocumentType=" + this.e + ')';
    }

    public final String getType() {
        return this.a;
    }

    public e(String r3, Integer r4, String r5, sbb.e r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r3 = "";
    L6:
        if ((r7 & 4) == 0) goto L9;
        r4 = -1;
    L9:
        if ((r7 & 8) == 0) goto L12;
        r5 = "";
    L12:
        if ((r7 & 16) == 0) goto L14;
        r6 = null;
    L14:
        Intrinsics.checkNotNullParameter("preview_click", ResourceData.KEY_TYPE);
        this.a = "preview_click";
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
