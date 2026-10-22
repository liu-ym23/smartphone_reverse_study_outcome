package tc5;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final int h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.c.hashCode()) * 31;
        String r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.f;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.g;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return ((r13 + r2) * 31) + this.h;
    L17:
        r12 = r11.hashCode();
        goto L18
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
        return "ReportCreateNewClickParam(module=" + this.a + ", subModule=" + this.b + ", click=" + this.c + ", target=" + this.d + ", templateId=" + this.e + ", parentToken=" + this.f + ", objToken=" + this.g + ", type=" + this.h + ')';
    }

    public final int getType() {
        return this.h;
    }

    public a(String r8, String r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "module");
        if (r10 != e.g.b) goto L6;
    L17:
        String r0 = "docs";
    L18:
        this(r8, r9, r0, "ccm_template_systemcenter_view", r11, r10);
        return;
    L6:
        if (r10 != e.h.b) goto L9;
        r0 = "sheets";
        goto L18
    L9:
        if (r10 != e.k.b) goto L12;
        r0 = "mindnotes";
        goto L18
    L12:
        if (r10 != e.i.b) goto L15;
        r0 = DocumentType.BITABLE_NAME;
        goto L18
    L15:
        if (r10 != e.o.b) goto L17;
        r0 = DocumentType.DOCX_NAME;
        goto L18
    }

    public a(String r2, String r3, String r4, String r5, String r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, "module");
        Intrinsics.checkNotNullParameter(r4, "click");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = "";
        this.f = r6;
        this.g = "";
        this.h = r7;
    }
}
